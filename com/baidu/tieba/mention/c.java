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
    private int aAf;
    private com.baidu.tbadk.core.view.o ahO;
    private int bnd;
    private h bne;
    private Activity mActivity;
    private Fragment mFragment;
    private ViewGroup bna = null;
    private BdListView aof = null;
    private k bnb = null;
    private com.baidu.tieba.model.am bnc = null;
    private int aAp = 1;
    private i bnf = null;
    private j bng = null;
    private String bnh = null;
    AlertDialog bni = null;
    private final Handler mHandler = new Handler();

    public c(Fragment fragment, int i, h hVar) {
        this.mFragment = null;
        this.mActivity = null;
        this.bnd = -1;
        this.bne = null;
        this.mFragment = fragment;
        this.mActivity = this.mFragment.getActivity();
        this.bnd = i;
        this.bne = hVar;
    }

    public void setUpdateType(int i) {
        this.aAf = i;
    }

    public void t(BdListView bdListView) {
        this.aof = bdListView;
    }

    public void d(ViewGroup viewGroup) {
        this.bna = viewGroup;
    }

    public void gO(String str) {
        this.bnh = str;
    }

    public void a(com.baidu.tbadk.core.view.o oVar) {
        this.ahO = oVar;
    }

    public void refresh() {
        this.aAp = 1;
        this.aAf = 3;
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.bnd == 2) {
                    com.baidu.tbadk.core.i.l(this.mActivity, "new_at_me_visit_post");
                } else if (this.bnd == 1) {
                    com.baidu.tbadk.core.i.l(this.mActivity, "new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        com.baidu.tbadk.core.i.l(this.mActivity, "zan_mlist");
                    }
                }
                b(feedData);
                return;
            }
            if (this.bnd == 2) {
                com.baidu.tbadk.core.i.l(this.mActivity, "new_at_me_visit_pb");
            } else if (this.bnd == 1) {
                com.baidu.tbadk.core.i.l(this.mActivity, "new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    com.baidu.tbadk.core.i.l(this.mActivity, "zan_mlist");
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mActivity).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
    }

    public void init() {
        this.aAp = 1;
        this.bnb = new k(this.mActivity, null);
        this.bnb.setType(this.bnd);
        this.bnb.gv(TbadkApplication.m251getInst().getFontSize());
        this.aof.setAdapter((ListAdapter) this.bnb);
        this.aof.setOnItemClickListener(new d(this));
        this.aof.setOnScrollListener(new e(this));
        this.aof.setOnSrollToBottomListener(new f(this));
    }

    public void show() {
        boolean z;
        ArrayList<FeedData> TK;
        switch (this.aAf) {
            case 2:
                z = true;
                break;
            case 3:
                if (this.bnb.Gl()) {
                    return;
                }
                z = true;
                break;
            case 4:
                if (this.bnb.SO()) {
                    return;
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z && this.bnc != null) {
            a(this.bnc, true);
            return;
        }
        if (this.aAf != 4) {
            this.aAp = 1;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(TbConfig.SERVER_ADDRESS);
        stringBuffer.append(this.bnh);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.aAp)));
        if (this.aAf == 4 && this.bnc != null && (TK = this.bnc.TK()) != null && TK.size() > 0) {
            FeedData feedData = TK.get(TK.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id())));
        }
        SM();
        if (this.bnf != null) {
            this.bnf.cancel();
            this.bnf = null;
        }
        this.bnf = new i(this, stringBuffer.toString(), arrayList, this.bnb);
        this.bnf.setPriority(3);
        this.bnf.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        if (this.bnc != null && this.bnc.zM().kh() == 1) {
            this.aAp++;
            this.aAf = 4;
            show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.am amVar, boolean z) {
        if (amVar != null && amVar.TK() != null) {
            if (this.aAf == 4 && this.bnc != null) {
                ArrayList<FeedData> TK = this.bnc.TK();
                TK.addAll(amVar.TK());
                amVar.A(TK);
                this.bnc = null;
                this.bnc = amVar;
            } else {
                this.bnc = amVar;
            }
            if (this.bnc != null) {
                if (this.bnc.zM().kh() == 1) {
                    this.bnb.bO(true);
                } else {
                    this.bnb.bO(false);
                }
                ArrayList<FeedData> TK2 = this.bnc.TK();
                if (TK2 != null) {
                    int firstVisiblePosition = this.aof.getFirstVisiblePosition();
                    this.bnb.a(TK2, z);
                    if (this.aAf == 2 || this.aAf == 3) {
                        this.aof.setSelectionFromTop(0, 0);
                    } else if (this.aAf == 4 && Build.VERSION.SDK_INT < 11) {
                        this.mHandler.postDelayed(new g(this, firstVisiblePosition), 10L);
                    }
                    if (TK2.size() == 0) {
                        if (com.baidu.adp.lib.util.m.isNetOk()) {
                            this.ahO.setVisibility(0);
                        }
                    } else {
                        this.ahO.setVisibility(8);
                    }
                }
            }
            this.bnb.notifyDataSetChanged();
            r rVar = (r) this.mFragment.getParentFragment();
            if (rVar != null) {
                if (this.aAf == 3 || this.aAf == 2) {
                    if (z) {
                        rVar.s(this.bnd, false);
                        return;
                    } else {
                        rVar.s(this.bnd, true);
                        return;
                    }
                }
                rVar.s(this.bnd, false);
            }
        }
    }

    public void SL() {
        if (this.bnb != null && this.bnb.SP() != TbadkApplication.m251getInst().getFontSize()) {
            this.bnb.gv(TbadkApplication.m251getInst().getFontSize());
            this.bnb.notifyDataSetChanged();
        }
    }

    private void SM() {
        if (this.bnf != null) {
            this.bnf.cancel();
            this.bnf = null;
        }
        if (this.bng != null) {
            this.bng.cancel();
            this.bng = null;
        }
        this.bnb.cb(false);
        this.bnb.dB(false);
    }

    private void b(FeedData feedData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mActivity).createSubPbCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
    }

    public void SN() {
        if (this.bnb != null) {
            this.bnb.notifyDataSetChanged();
        }
    }
}
