package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private int aAo;
    private com.baidu.tbadk.core.view.o ahX;
    private int bnr;
    private h bns;
    private Activity mActivity;
    private Fragment mFragment;
    private ViewGroup bno = null;
    private BdListView aoo = null;
    private k bnp = null;
    private com.baidu.tieba.model.am bnq = null;
    private int aAz = 1;
    private i bnt = null;
    private j bnu = null;
    private String bnv = null;
    AlertDialog bnw = null;
    private final Handler mHandler = new Handler();

    public c(Fragment fragment, int i, h hVar) {
        this.mFragment = null;
        this.mActivity = null;
        this.bnr = -1;
        this.bns = null;
        this.mFragment = fragment;
        this.mActivity = this.mFragment.getActivity();
        this.bnr = i;
        this.bns = hVar;
    }

    public void setUpdateType(int i) {
        this.aAo = i;
    }

    public void t(BdListView bdListView) {
        this.aoo = bdListView;
    }

    public void d(ViewGroup viewGroup) {
        this.bno = viewGroup;
    }

    public void gO(String str) {
        this.bnv = str;
    }

    public void a(com.baidu.tbadk.core.view.o oVar) {
        this.ahX = oVar;
    }

    public void refresh() {
        this.aAz = 1;
        this.aAo = 3;
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.bnr == 2) {
                    com.baidu.tbadk.core.j.l(this.mActivity, "new_at_me_visit_post");
                } else if (this.bnr == 1) {
                    com.baidu.tbadk.core.j.l(this.mActivity, "new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        com.baidu.tbadk.core.j.l(this.mActivity, "zan_mlist");
                    }
                }
                b(feedData);
                return;
            }
            if (this.bnr == 2) {
                com.baidu.tbadk.core.j.l(this.mActivity, "new_at_me_visit_pb");
            } else if (this.bnr == 1) {
                com.baidu.tbadk.core.j.l(this.mActivity, "new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    com.baidu.tbadk.core.j.l(this.mActivity, "zan_mlist");
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mActivity).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
    }

    public void init() {
        this.aAz = 1;
        this.bnp = new k(this.mActivity, null);
        this.bnp.setType(this.bnr);
        this.bnp.gv(TbadkApplication.m251getInst().getFontSize());
        this.aoo.setAdapter((ListAdapter) this.bnp);
        this.aoo.setOnItemClickListener(new d(this));
        this.aoo.setOnScrollListener(new e(this));
        this.aoo.setOnSrollToBottomListener(new f(this));
    }

    public void show() {
        boolean z;
        ArrayList<FeedData> TN;
        switch (this.aAo) {
            case 2:
                z = true;
                break;
            case 3:
                if (this.bnp.Gn()) {
                    return;
                }
                z = true;
                break;
            case 4:
                if (this.bnp.SR()) {
                    return;
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z && this.bnq != null) {
            a(this.bnq, true);
            return;
        }
        if (this.aAo != 4) {
            this.aAz = 1;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(TbConfig.SERVER_ADDRESS);
        stringBuffer.append(this.bnv);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.aAz)));
        if (this.aAo == 4 && this.bnq != null && (TN = this.bnq.TN()) != null && TN.size() > 0) {
            FeedData feedData = TN.get(TN.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id())));
        }
        SP();
        if (this.bnt != null) {
            this.bnt.cancel();
            this.bnt = null;
        }
        this.bnt = new i(this, stringBuffer.toString(), arrayList, this.bnp);
        this.bnt.setPriority(3);
        this.bnt.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SN() {
        if (this.bnq != null && this.bnq.zO().kh() == 1) {
            this.aAz++;
            this.aAo = 4;
            show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.am amVar, boolean z) {
        if (amVar != null && amVar.TN() != null) {
            if (this.aAo == 4 && this.bnq != null) {
                ArrayList<FeedData> TN = this.bnq.TN();
                TN.addAll(amVar.TN());
                amVar.B(TN);
                this.bnq = null;
                this.bnq = amVar;
            } else {
                this.bnq = amVar;
            }
            if (this.bnq != null) {
                if (this.bnq.zO().kh() == 1) {
                    this.bnp.bO(true);
                } else {
                    this.bnp.bO(false);
                }
                ArrayList<FeedData> TN2 = this.bnq.TN();
                if (TN2 != null) {
                    int firstVisiblePosition = this.aoo.getFirstVisiblePosition();
                    this.bnp.a(TN2, z);
                    if (this.aAo == 2 || this.aAo == 3) {
                        this.aoo.setSelectionFromTop(0, 0);
                    } else if (this.aAo == 4 && Build.VERSION.SDK_INT < 11) {
                        this.mHandler.postDelayed(new g(this, firstVisiblePosition), 10L);
                    }
                    if (TN2.size() == 0) {
                        if (com.baidu.adp.lib.util.m.isNetOk()) {
                            this.ahX.setVisibility(0);
                        }
                    } else {
                        this.ahX.setVisibility(8);
                    }
                }
            }
            this.bnp.notifyDataSetChanged();
            r rVar = (r) this.mFragment.getParentFragment();
            if (rVar != null) {
                if (this.aAo == 3 || this.aAo == 2) {
                    if (z) {
                        rVar.s(this.bnr, false);
                        return;
                    } else {
                        rVar.s(this.bnr, true);
                        return;
                    }
                }
                rVar.s(this.bnr, false);
            }
        }
    }

    public void SO() {
        if (this.bnp != null && this.bnp.SS() != TbadkApplication.m251getInst().getFontSize()) {
            this.bnp.gv(TbadkApplication.m251getInst().getFontSize());
            this.bnp.notifyDataSetChanged();
        }
    }

    private void SP() {
        if (this.bnt != null) {
            this.bnt.cancel();
            this.bnt = null;
        }
        if (this.bnu != null) {
            this.bnu.cancel();
            this.bnu = null;
        }
        this.bnp.cb(false);
        this.bnp.dB(false);
    }

    private void b(FeedData feedData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mActivity).createSubPbCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
    }

    public void SQ() {
        if (this.bnp != null) {
            this.bnp.notifyDataSetChanged();
        }
    }
}
