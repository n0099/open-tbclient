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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends ct<com.baidu.tieba.tbadkCore.data.q, t> {
    private final CustomMessageListener FT;
    private t.b aMp;
    private QuickVideoView.b aOX;
    private Runnable aOY;
    private String aPS;
    private int bcY;
    private CustomMessageListener cTA;
    private CustomMessageListener cTB;
    private boolean cTt;
    private CustomMessageListener cTy;
    private CustomMessageListener cTz;
    private int ceY;
    private com.baidu.tieba.pb.data.h esP;
    private t esQ;
    private long esR;
    private boolean esS;
    private com.baidu.tieba.pb.a.d esT;
    private int esU;
    private boolean esV;
    private boolean esW;
    private CustomMessageListener esX;
    private Handler mHandler;
    private View mView;

    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.esP = null;
        this.cTt = false;
        this.esR = 0L;
        this.esS = true;
        this.ceY = 0;
        this.esT = null;
        this.bcY = 0;
        this.aPS = null;
        this.esU = 0;
        this.esV = true;
        this.esW = false;
        this.aOX = new f(this);
        this.mHandler = new l(this, Looper.getMainLooper());
        this.cTy = new m(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.esX = new n(this, CmdConfigCustom.PB_RESTART_VIDEO);
        this.cTz = new o(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cTA = new p(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cTB = new q(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        this.FT = new r(this, 2000994);
        this.aMp = new s(this);
        this.aOY = new g(this);
        if (pbActivity != null) {
            pbActivity.registerListener(this.cTy);
            pbActivity.registerListener(this.esX);
            pbActivity.registerListener(this.cTz);
            pbActivity.registerListener(this.cTA);
            pbActivity.registerListener(this.cTB);
            this.cTB.setSelfListener(true);
            pbActivity.registerListener(this.FT);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public t a(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(r.h.pb_list_item_video, (ViewGroup) null);
            this.esQ = new t(this.mView);
            View findViewById = this.mView.findViewById(r.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int K = com.baidu.adp.lib.util.k.K(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = K;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            aqu();
        }
        return this.esQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        if (this.esQ != null && this.esQ.cWB != null) {
            e(false, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.ct, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, t tVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) tVar);
        if (qVar != null && tVar != null) {
            qVar.sN();
            tVar.aNT.a(c(qVar));
            com.baidu.tbadk.widget.richText.o Il = qVar.Il();
            if (tVar.aNT.bcT() != null) {
                tVar.aNT.bcT().e(Il);
            }
            if (!this.cTt) {
                this.cTt = true;
                tVar.cWB.setDefaultErrorResource(0);
                tVar.cWB.setTag(Integer.valueOf(i));
                tVar.cWB.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.oJ().oP()) {
                    tVar.cWB.setNoImageBottomTextColor(r.d.cp_cont_c);
                    tVar.cWB.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32));
                    tVar.cWB.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize28));
                    tVar.cWB.setSupportNoImage(true);
                    tVar.cWB.setNoImageBottomText(TbadkCoreApplication.m9getInst().getString(r.j.click_to_play));
                } else {
                    tVar.cWB.setDefaultBgResource(r.f.pic_bg_video_frs);
                    if (!tVar.aOE.isPlaying()) {
                        a(qVar, tVar);
                    }
                }
                tVar.aOE.setOnPreparedListener(new h(this, tVar, Il, qVar));
                tVar.aOE.setOnCompletionListener(new i(this));
                tVar.aOE.setOnSurfaceDestroyedListener(this.aOX);
                tVar.aOE.setOnErrorListener(this.aMp);
                tVar.mRootView.setOnClickListener(new j(this, tVar));
                aOR();
            }
            if (tVar.mSkinType != this.mSkinType) {
                at.l(view, r.d.cp_bg_line_d);
                at.c(tVar.cWF, r.f.icon_play_video);
                at.l(tVar.mRootView, r.d.cp_bg_line_k);
                at.l(tVar.etd, r.d.cp_bg_line_k);
            }
            tVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    private ax c(com.baidu.tieba.tbadkCore.data.q qVar) {
        ax axVar = null;
        if (qVar != null) {
            axVar = new ax();
            axVar.mLocate = "6";
            if (this.esP != null) {
                axVar.aRO = this.esP.getThreadId();
                axVar.aRN = this.esP.getForumId();
            }
        }
        return axVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        if (this.esP != null && this.esP.aOl() != null && this.esP.aOl().sf() != null) {
            z.a(this.esP.aOl().sf().video_md5, this.esP.getThreadId(), this.esP.getForumId(), "pb", this.esP.LP(), "", "1");
        }
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.esP = hVar;
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, t tVar) {
        com.baidu.tbadk.widget.richText.o Il = qVar.Il();
        if (Il != null) {
            tVar.cWB.c(Il.qg(), 17, false);
            tVar.cWB.setNoImageBottomText("");
            this.aPS = Il.getVideoUrl();
            if (StringUtils.isNull(Il.qg())) {
                pn(Il.getVideoUrl());
            } else {
                tVar.cWB.setEvent(new k(this, Il));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(String str) {
        if (this.eug != null && this.eug.aPd() != null && this.eug.aPd().getPbData() != null && this.eug.aPd().getPbData().getPage() != null && this.esQ != null && this.esQ.aOE != null) {
            if (this.bcY != 1 || !this.esQ.aOE.isPlaying()) {
                if (aOU()) {
                    if (this.bcY != 2) {
                        this.esQ.aOE.setVideoPath(str);
                        e(false, 3);
                    } else {
                        e(false, 1);
                    }
                    this.esQ.aOE.start();
                } else {
                    e(true, 0);
                }
                this.eug.iu(true);
            }
        }
    }

    private void aOR() {
        if (this.esP != null) {
            String str = com.baidu.adp.lib.util.i.gn() ? "1" : "0";
            av avVar = new av("c10643");
            avVar.ab("fid", this.esP.getForumId());
            avVar.ab("tid", this.esP.getThreadId());
            avVar.ab("obj_type", str);
            TiebaStatic.log(avVar);
        }
    }

    public void aqw() {
        if (this.esQ != null && this.esQ.aOE != null && this.esQ.cWF != null) {
            if (this.esQ.aOE.isPlaying()) {
                this.esQ.aOE.pause();
                e(false, 2);
            } else if (this.bcY == 3) {
                this.esQ.aOE.stopPlayback();
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOS() {
        if (this.esQ != null && this.esQ.aOE != null && this.esQ.cWF != null) {
            if (aOU() && !this.esQ.aOE.isPlaying()) {
                if (this.bcY == 2) {
                    this.esQ.aOE.start();
                    e(false, 1);
                    return;
                }
                boolean po = po(this.aPS);
                if (this.aPS != null && po && this.bcY != 2 && !this.esW) {
                    this.esQ.aOE.setVideoPath(this.aPS);
                    this.esW = true;
                    e(false, 3);
                    this.esQ.aOE.start();
                    return;
                }
                JU();
                this.esQ.aOE.setVideoPath(this.aPS);
                e(false, 3);
                this.esQ.aOE.start();
            } else if (!aOU()) {
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOT() {
        if (this.esQ != null && this.esQ.aOE != null && this.esQ.cWF != null) {
            if (aOU() && !this.esQ.aOE.isPlaying()) {
                boolean po = po(this.aPS);
                if (this.aPS != null && po && this.bcY != 2 && !this.esW) {
                    this.esQ.aOE.setVideoPath(this.aPS);
                    this.esW = true;
                    e(false, 3);
                    this.esQ.aOE.start();
                    return;
                }
                JU();
                e(false, 1);
                this.esQ.aOE.start();
            } else if (!aOU()) {
                e(false, 0);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.esT = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.esQ != null && this.esQ.cWB != null && this.esQ.cWF != null && this.esQ.ete != null && this.esQ.ceN != null && this.esQ.etf != null && this.esQ.aOO != null && this.esQ.bcV != null && this.esQ.etd != null) {
            if (z || this.bcY != i) {
                this.bcY = i;
                this.esQ.cWF.setVisibility(8);
                this.esQ.ete.setVisibility(8);
                this.esQ.ete.btg();
                this.esQ.bcV.setVisibility(8);
                this.esQ.ceN.setVisibility(8);
                this.esQ.ceN.setIndeterminate(false);
                this.esQ.etf.setVisibility(8);
                this.esQ.aOO.setVisibility(8);
                this.esQ.cWB.setVisibility(8);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aOY);
                if (i == 0) {
                    this.esQ.cWB.setVisibility(0);
                    this.esQ.cWF.setVisibility(0);
                } else if (i == 1) {
                    this.esQ.ete.setVisibility(0);
                    this.esQ.ete.btg();
                    this.esQ.ete.start();
                } else if (i == 3) {
                    this.esQ.bcV.setVisibility(0);
                    this.esQ.ceN.setVisibility(0);
                    this.esQ.cWB.setVisibility(0);
                    this.esQ.bcV.setVisibility(0);
                    this.esQ.ceN.setVisibility(0);
                    this.esQ.ceN.setIndeterminate(true);
                } else if (i == 2) {
                    this.esQ.cWF.setVisibility(0);
                } else if (i == 4) {
                    this.esQ.cWB.setVisibility(0);
                    this.esQ.etf.setVisibility(0);
                    this.esQ.aOO.setVisibility(0);
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aOY, 2000L);
                }
            }
        }
    }

    private boolean po(String str) {
        if (com.baidu.tbadk.core.util.ax.isEmpty(str)) {
            return false;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
        return (runTask == null || com.baidu.tbadk.core.util.ax.isEmpty((String) runTask.getData())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOU() {
        return com.baidu.tbadk.util.w.fn(3) && com.baidu.tbadk.core.l.oJ().oP();
    }
}
