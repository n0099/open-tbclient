package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tieba.b.a aAO;
    private int aAo;
    private BaseFragment bnV;
    private int bnr;
    private Activity mActivity;
    private BdUniqueId mId;
    private ViewGroup bno = null;
    private BdListView aoo = null;
    private k bnp = null;
    private com.baidu.tieba.model.am bnq = null;
    private int aAz = 1;
    private ad bnW = null;
    private com.baidu.tbadk.core.view.o ahX = null;
    private String bnv = null;
    AlertDialog bnw = null;
    private final Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a bnX = new y(this, CmdConfigHttp.REPLYME_HTTP_CMD, 303007);

    public x(BaseFragment baseFragment, int i, ac acVar) {
        this.bnV = null;
        this.mActivity = null;
        this.bnr = -1;
        this.mId = null;
        this.aAO = null;
        this.bnV = baseFragment;
        this.mActivity = this.bnV.getActivity();
        this.bnr = i;
        this.mId = BdUniqueId.gen();
        this.bnX.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.bnX);
        this.aAO = new com.baidu.tieba.b.a("replymeStat");
    }

    public void SV() {
        SW();
        if (this.bnq != null) {
            this.bnq.cancelLoadData();
        }
        if (this.aAO != null) {
            this.aAO.ya();
            this.aAO = null;
        }
    }

    public void SW() {
        MessageManager.getInstance().unRegisterListener(this.mId);
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

    public void b(com.baidu.tieba.model.am amVar) {
        a(amVar, true, true);
    }

    public int SX() {
        return this.aAz;
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
        if (this.bnV instanceof ae) {
            this.bnp.a((ae) this.bnV);
        }
        this.bnp.gv(TbadkApplication.m251getInst().getFontSize());
        this.aoo.setAdapter((ListAdapter) this.bnp);
        this.aoo.setOnItemClickListener(new z(this));
        this.aoo.setOnSrollToBottomListener(new aa(this));
    }

    public void show() {
        boolean z;
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
        SP();
        if (!z) {
            if (this.bnq != null) {
                a(this.bnq, true, false);
                return;
            }
            if (this.aoo != null) {
                this.aoo.hO();
            }
            SY();
        }
        if (this.aAo != 4) {
            this.aAz = 1;
        }
        new com.baidu.tieba.model.am(this.mActivity).U(this.aAo, this.aAz);
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
    public void a(com.baidu.tieba.model.am amVar, boolean z, boolean z2) {
        dA(false);
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
                        this.mHandler.postDelayed(new ab(this, firstVisiblePosition), 10L);
                    }
                    if (TN2.size() == 0) {
                        if (com.baidu.adp.lib.util.m.isNetOk() && !z2) {
                            this.ahX.setVisibility(0);
                        }
                    } else {
                        this.ahX.setVisibility(8);
                    }
                }
            }
            this.bnp.notifyDataSetChanged();
            r rVar = (r) this.bnV.getParentFragment();
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
        if (this.bnW != null) {
            this.bnW.cancel();
            this.bnW = null;
        }
        if (this.bnq != null) {
            this.bnq.cancelLoadData();
        }
        this.bnp.cb(false);
        this.bnp.dB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(boolean z) {
        if (z) {
            switch (this.aAo) {
                case 1:
                case 2:
                case 3:
                default:
                    return;
                case 4:
                    this.bnp.dB(true);
                    return;
            }
        }
        switch (this.aAo) {
            case 1:
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.bnp.dB(false);
                return;
        }
    }

    private void SY() {
        if (this.bnV != null) {
            this.bnV.sendMessage(new CustomMessage(2001229));
        }
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
