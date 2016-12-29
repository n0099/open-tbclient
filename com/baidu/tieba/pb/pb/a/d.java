package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends cs<com.baidu.tieba.tbadkCore.data.q, s> {
    private final CustomMessageListener FT;
    private t.b aLG;
    private QuickVideoView.b aOo;
    private Runnable aOp;
    private String aPj;
    private int bKH;
    private int bcq;
    private boolean cyC;
    private CustomMessageListener cyH;
    private CustomMessageListener cyI;
    private CustomMessageListener cyJ;
    private CustomMessageListener cyK;
    private com.baidu.tieba.pb.data.f dXl;
    private s dXm;
    private long dXn;
    private boolean dXo;
    private com.baidu.tieba.pb.a.d dXp;
    private int dXq;
    private boolean dXr;
    private boolean dXs;
    private CustomMessageListener dXt;
    private Handler mHandler;
    private View mView;

    public d(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.dXl = null;
        this.cyC = false;
        this.dXn = 0L;
        this.dXo = true;
        this.bKH = 0;
        this.dXp = null;
        this.bcq = 0;
        this.aPj = null;
        this.dXq = 0;
        this.dXr = true;
        this.dXs = false;
        this.aOo = new e(this);
        this.mHandler = new k(this, Looper.getMainLooper());
        this.cyH = new l(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.dXt = new m(this, CmdConfigCustom.PB_RESTART_VIDEO);
        this.cyI = new n(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cyJ = new o(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cyK = new p(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        this.FT = new q(this, 2000994);
        this.aLG = new r(this);
        this.aOp = new f(this);
        if (pbActivity != null) {
            pbActivity.registerListener(this.cyH);
            pbActivity.registerListener(this.dXt);
            pbActivity.registerListener(this.cyI);
            pbActivity.registerListener(this.cyJ);
            pbActivity.registerListener(this.cyK);
            this.cyK.setSelfListener(true);
            pbActivity.registerListener(this.FT);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public s a(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(r.h.pb_list_item_video, (ViewGroup) null);
            this.dXm = new s(this.mView);
            View findViewById = this.mView.findViewById(r.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int I = com.baidu.adp.lib.util.k.I(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = I;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            akW();
        }
        return this.dXm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akW() {
        if (this.dXm != null && this.dXm.cBJ != null) {
            e(false, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, s sVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) sVar);
        if (qVar != null && sVar != null) {
            qVar.sB();
            sVar.aNk.a(c(qVar));
            com.baidu.tbadk.widget.richText.n HH = qVar.HH();
            if (sVar.aNk.aWA() != null) {
                sVar.aNk.aWA().e(HH);
            }
            if (!this.cyC) {
                this.cyC = true;
                sVar.cBJ.setDefaultErrorResource(0);
                sVar.cBJ.setTag(Integer.valueOf(i));
                sVar.cBJ.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.oJ().oP()) {
                    sVar.cBJ.setNoImageBottomTextColor(r.d.cp_cont_c);
                    sVar.cBJ.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32));
                    sVar.cBJ.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize28));
                    sVar.cBJ.setSupportNoImage(true);
                    sVar.cBJ.setNoImageBottomText(TbadkCoreApplication.m9getInst().getString(r.j.click_to_play));
                } else {
                    sVar.cBJ.setDefaultBgResource(r.f.pic_bg_video_frs);
                    if (!sVar.aNV.isPlaying()) {
                        a(qVar, sVar);
                    }
                }
                sVar.aNV.setOnPreparedListener(new g(this, sVar, HH, qVar));
                sVar.aNV.setOnCompletionListener(new h(this));
                sVar.aNV.setOnSurfaceDestroyedListener(this.aOo);
                sVar.aNV.setOnErrorListener(this.aLG);
                sVar.mRootView.setOnClickListener(new i(this, sVar));
                aIQ();
            }
            if (sVar.mSkinType != this.mSkinType) {
                ar.l(view, r.d.cp_bg_line_d);
                ar.c(sVar.cBN, r.f.icon_play_video);
                ar.l(sVar.mRootView, r.d.cp_bg_line_k);
                ar.l(sVar.dXy, r.d.cp_bg_line_k);
            }
            sVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    private ax c(com.baidu.tieba.tbadkCore.data.q qVar) {
        ax axVar = null;
        if (qVar != null) {
            axVar = new ax();
            axVar.mLocate = "6";
            if (this.dXl != null) {
                axVar.aRf = this.dXl.getThreadId();
                axVar.aRe = this.dXl.getForumId();
            }
        }
        return axVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jn() {
        if (this.dXl != null && this.dXl.aIl() != null && this.dXl.aIl().rW() != null) {
            z.a(this.dXl.aIl().rW().video_md5, this.dXl.getThreadId(), this.dXl.getForumId(), "pb", this.dXl.Li(), "", "1");
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.dXl = fVar;
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, s sVar) {
        com.baidu.tbadk.widget.richText.n HH = qVar.HH();
        if (HH != null) {
            sVar.cBJ.c(HH.qh(), 17, false);
            sVar.cBJ.setNoImageBottomText("");
            this.aPj = HH.getVideoUrl();
            if (StringUtils.isNull(HH.qh())) {
                nO(HH.getVideoUrl());
            } else {
                sVar.cBJ.setEvent(new j(this, HH));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nO(String str) {
        if (this.dYB != null && this.dYB.aJc() != null && this.dYB.aJc().getPbData() != null && this.dYB.aJc().getPbData().getPage() != null && this.dXm != null && this.dXm.aNV != null) {
            if (this.bcq != 1 || !this.dXm.aNV.isPlaying()) {
                if (aIT()) {
                    if (this.bcq != 2) {
                        this.dXm.aNV.setVideoPath(str);
                        e(false, 3);
                    } else {
                        e(false, 1);
                    }
                    this.dXm.aNV.start();
                } else {
                    e(true, 0);
                }
                this.dYB.ih(true);
            }
        }
    }

    private void aIQ() {
        if (this.dXl != null) {
            String str = com.baidu.adp.lib.util.i.gn() ? "1" : "0";
            at atVar = new at("c10643");
            atVar.ab("fid", this.dXl.getForumId());
            atVar.ab("tid", this.dXl.getThreadId());
            atVar.ab("obj_type", str);
            TiebaStatic.log(atVar);
        }
    }

    public void akY() {
        if (this.dXm != null && this.dXm.aNV != null && this.dXm.cBN != null) {
            if (this.dXm.aNV.isPlaying()) {
                this.dXm.aNV.pause();
                e(false, 2);
            } else if (this.bcq == 3) {
                this.dXm.aNV.stopPlayback();
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIR() {
        if (this.dXm != null && this.dXm.aNV != null && this.dXm.cBN != null) {
            if (aIT() && !this.dXm.aNV.isPlaying()) {
                if (this.bcq == 2) {
                    this.dXm.aNV.start();
                    e(false, 1);
                    return;
                }
                boolean nP = nP(this.aPj);
                if (this.aPj != null && nP && this.bcq != 2 && !this.dXs) {
                    this.dXm.aNV.setVideoPath(this.aPj);
                    this.dXs = true;
                    e(false, 3);
                    this.dXm.aNV.start();
                    return;
                }
                Jn();
                this.dXm.aNV.setVideoPath(this.aPj);
                e(false, 3);
                this.dXm.aNV.start();
            } else if (!aIT()) {
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIS() {
        if (this.dXm != null && this.dXm.aNV != null && this.dXm.cBN != null) {
            if (aIT() && !this.dXm.aNV.isPlaying()) {
                boolean nP = nP(this.aPj);
                if (this.aPj != null && nP && this.bcq != 2 && !this.dXs) {
                    this.dXm.aNV.setVideoPath(this.aPj);
                    this.dXs = true;
                    e(false, 3);
                    this.dXm.aNV.start();
                    return;
                }
                Jn();
                e(false, 1);
                this.dXm.aNV.start();
            } else if (!aIT()) {
                e(false, 0);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dXp = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.dXm != null && this.dXm.cBJ != null && this.dXm.cBN != null && this.dXm.dXz != null && this.dXm.bKw != null && this.dXm.dXA != null && this.dXm.aOf != null && this.dXm.bcn != null && this.dXm.dXy != null) {
            if (z || this.bcq != i) {
                this.bcq = i;
                this.dXm.cBN.setVisibility(8);
                this.dXm.dXz.setVisibility(8);
                this.dXm.dXz.bkg();
                this.dXm.bcn.setVisibility(8);
                this.dXm.bKw.setVisibility(8);
                this.dXm.bKw.setIndeterminate(false);
                this.dXm.dXA.setVisibility(8);
                this.dXm.aOf.setVisibility(8);
                this.dXm.cBJ.setVisibility(8);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aOp);
                if (i == 0) {
                    this.dXm.cBJ.setVisibility(0);
                    this.dXm.cBN.setVisibility(0);
                } else if (i == 1) {
                    this.dXm.dXz.setVisibility(0);
                    this.dXm.dXz.bkg();
                    this.dXm.dXz.start();
                } else if (i == 3) {
                    this.dXm.bcn.setVisibility(0);
                    this.dXm.bKw.setVisibility(0);
                    this.dXm.cBJ.setVisibility(0);
                    this.dXm.bcn.setVisibility(0);
                    this.dXm.bKw.setVisibility(0);
                    this.dXm.bKw.setIndeterminate(true);
                } else if (i == 2) {
                    this.dXm.cBN.setVisibility(0);
                } else if (i == 4) {
                    this.dXm.cBJ.setVisibility(0);
                    this.dXm.dXA.setVisibility(0);
                    this.dXm.aOf.setVisibility(0);
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aOp, 2000L);
                }
            }
        }
    }

    private boolean nP(String str) {
        if (av.isEmpty(str)) {
            return false;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
        return (runTask == null || av.isEmpty((String) runTask.getData())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIT() {
        return w.fn(3) && com.baidu.tbadk.core.l.oJ().oP();
    }
}
