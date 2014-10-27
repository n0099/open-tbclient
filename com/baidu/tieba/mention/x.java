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
    private com.baidu.tieba.b.a aAE;
    private int aAf;
    private BaseFragment bnH;
    private int bnd;
    private Activity mActivity;
    private BdUniqueId mId;
    private ViewGroup bna = null;
    private BdListView aof = null;
    private k bnb = null;
    private com.baidu.tieba.model.am bnc = null;
    private int aAp = 1;
    private ad bnI = null;
    private com.baidu.tbadk.core.view.o ahO = null;
    private String bnh = null;
    AlertDialog bni = null;
    private final Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a bnJ = new y(this, CmdConfigHttp.REPLYME_HTTP_CMD, 303007);

    public x(BaseFragment baseFragment, int i, ac acVar) {
        this.bnH = null;
        this.mActivity = null;
        this.bnd = -1;
        this.mId = null;
        this.aAE = null;
        this.bnH = baseFragment;
        this.mActivity = this.bnH.getActivity();
        this.bnd = i;
        this.mId = BdUniqueId.gen();
        this.bnJ.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.bnJ);
        this.aAE = new com.baidu.tieba.b.a("replymeStat");
    }

    public void SS() {
        ST();
        if (this.bnc != null) {
            this.bnc.cancelLoadData();
        }
        if (this.aAE != null) {
            this.aAE.xY();
            this.aAE = null;
        }
    }

    public void ST() {
        MessageManager.getInstance().unRegisterListener(this.mId);
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

    public void b(com.baidu.tieba.model.am amVar) {
        a(amVar, true, true);
    }

    public int SU() {
        return this.aAp;
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
        if (this.bnH instanceof ae) {
            this.bnb.a((ae) this.bnH);
        }
        this.bnb.gv(TbadkApplication.m251getInst().getFontSize());
        this.aof.setAdapter((ListAdapter) this.bnb);
        this.aof.setOnItemClickListener(new z(this));
        this.aof.setOnSrollToBottomListener(new aa(this));
    }

    public void show() {
        boolean z;
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
        SM();
        if (!z) {
            if (this.bnc != null) {
                a(this.bnc, true, false);
                return;
            }
            SV();
        }
        if (this.aAf != 4) {
            this.aAp = 1;
        }
        new com.baidu.tieba.model.am(this.mActivity).U(this.aAf, this.aAp);
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
    public void a(com.baidu.tieba.model.am amVar, boolean z, boolean z2) {
        dA(false);
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
                        this.mHandler.postDelayed(new ab(this, firstVisiblePosition), 10L);
                    }
                    if (TK2.size() == 0) {
                        if (com.baidu.adp.lib.util.m.isNetOk() && !z2) {
                            this.ahO.setVisibility(0);
                        }
                    } else {
                        this.ahO.setVisibility(8);
                    }
                }
            }
            this.bnb.notifyDataSetChanged();
            r rVar = (r) this.bnH.getParentFragment();
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
        if (this.bnI != null) {
            this.bnI.cancel();
            this.bnI = null;
        }
        if (this.bnc != null) {
            this.bnc.cancelLoadData();
        }
        this.bnb.cb(false);
        this.bnb.dB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(boolean z) {
        if (z) {
            switch (this.aAf) {
                case 1:
                case 2:
                case 3:
                    if (this.aof != null) {
                        this.aof.hO();
                        return;
                    }
                    return;
                case 4:
                    this.bnb.dB(true);
                    return;
                default:
                    return;
            }
        }
        switch (this.aAf) {
            case 1:
            case 2:
            case 3:
                if (this.aof != null) {
                    this.aof.hN();
                    return;
                }
                return;
            case 4:
                this.bnb.dB(false);
                return;
            default:
                return;
        }
    }

    private void SV() {
        if (this.bnH != null) {
            this.bnH.sendMessage(new CustomMessage(2001229));
        }
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
