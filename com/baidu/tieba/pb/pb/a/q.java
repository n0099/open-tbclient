package com.baidu.tieba.pb.pb.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cl;
import com.baidu.tieba.pb.view.TextureVideoView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends cl<com.baidu.tieba.tbadkCore.data.r, am> {
    private CustomMessageListener ahv;
    private long beD;
    private boolean beE;
    private com.baidu.tieba.pb.a.c cJZ;
    private am cKF;
    private boolean cKG;
    private boolean cKH;
    private com.baidu.tieba.pb.model.a cKI;
    private int cKJ;
    private TextureVideoView.a cKK;
    private View.OnTouchListener cKL;
    private Runnable cKM;
    private MediaPlayer.OnErrorListener cKN;
    private CustomMessageListener cKO;
    private CustomMessageListener cKP;
    private CustomMessageListener cKQ;
    private CustomMessageListener cKR;
    private com.baidu.tieba.pb.b.c cKb;
    private Handler mHandler;
    private View mView;

    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.cJZ = null;
        this.cKG = false;
        this.beD = 0L;
        this.beE = true;
        this.cKH = false;
        this.cKJ = 0;
        this.cKb = null;
        this.cKK = new r(this);
        this.mHandler = new ac(this, Looper.getMainLooper());
        this.cKL = new ad(this);
        this.cKM = new ae(this);
        this.cKN = new af(this);
        this.ahv = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.cKO = new ah(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.cKP = new ai(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cKQ = new aj(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cKR = new s(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        if (pbActivity != null) {
            pbActivity.registerListener(this.ahv);
            pbActivity.registerListener(this.cKO);
            pbActivity.registerListener(this.cKP);
            pbActivity.registerListener(this.cKQ);
            pbActivity.registerListener(this.cKR);
        }
        this.cKI = new com.baidu.tieba.pb.model.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public am b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(t.h.pb_list_item_video, (ViewGroup) null);
            this.cKF = new am(this.mView);
            View findViewById = this.mView.findViewById(t.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int K = com.baidu.adp.lib.util.k.K(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = K;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            apb();
        }
        return this.cKF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apb() {
        if (this.cKF != null && this.cKF.cLd != null && this.cKF.cLn != null) {
            this.cKF.cLd.setVisibility(0);
            this.cKF.cLn.setVisibility(8);
            this.cKH = true;
            c(this.cKF);
            a(this.cKF);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, am amVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) amVar);
        if (rVar != null && amVar != null) {
            com.baidu.tbadk.widget.richText.m Hb = rVar.Hb();
            if (!this.cKG) {
                this.cKG = true;
                if (b(rVar)) {
                    amVar.cLl.setVisibility(0);
                    amVar.cLm.setVisibility(8);
                } else {
                    amVar.cLl.setVisibility(8);
                    amVar.cLm.setVisibility(0);
                }
                amVar.cLd.setForegroundDrawable(t.f.icon_play_video);
                amVar.cLd.setTag(Integer.valueOf(i));
                amVar.cLd.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.rn().rt()) {
                    amVar.cLd.setNoImageBottomTextColor(t.d.cp_cont_c);
                    amVar.cLd.setNoImageBottomTextPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32));
                    amVar.cLd.setNoImageBottomTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.fontsize28));
                    amVar.cLd.setSupportNoImage(true);
                    amVar.cLd.setNoImageBottomText(TbadkCoreApplication.m411getInst().getString(t.j.click_to_play));
                } else {
                    amVar.cLd.setDefaultBgResource(t.f.pic_bg_video_frs);
                    if (!amVar.cLk.isPlaying()) {
                        a(rVar, amVar);
                    }
                }
                amVar.cLd.setOnClickListener(new a(Hb, amVar));
                if (this.cJZ != null && this.cJZ.aoF() != null && this.cJZ.aoF().tx() == 1) {
                    amVar.cLe.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = amVar.cLf.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.cNL.getPageContext().getResources().getDimension(t.e.ds34);
                        amVar.cLf.setLayoutParams(layoutParams);
                    }
                } else {
                    amVar.cLe.setText(rVar.getTitle());
                    amVar.cLe.setVisibility(0);
                    amVar.cLe.setOnTouchListener(this.cKb);
                }
                amVar.bvl.setOnClickListener(new t(this, amVar, rVar, Hb));
                amVar.cLk.setOnPreparedListener(new u(this, amVar, Hb, rVar));
                amVar.cLk.setOnCompletionListener(new v(this, amVar, rVar));
                amVar.cLk.setOnErrorListener(this.cKN);
                amVar.cLk.setOnSurfaceDestroyedListener(this.cKK);
                this.mView.findViewById(t.g.pb_video_cover_view).setOnClickListener(new w(this, amVar, rVar));
                if (b(rVar)) {
                    amVar.cLl.setPlayer(amVar.cLk);
                } else {
                    amVar.cLm.setPlayer(amVar.cLk);
                }
            }
            com.baidu.tbadk.data.d aMy = rVar.aMy();
            if (aMy != null && !TextUtils.isEmpty(aMy.getName()) && !TextUtils.isEmpty(aMy.getName().trim())) {
                String name = aMy.getName();
                String lat = aMy.getLat();
                String lng = aMy.getLng();
                amVar.cLh.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, amVar.cLh, 0, 10, 0, 10);
                amVar.blT.setText(aMy.getName());
                com.baidu.tbadk.core.util.ar.b(amVar.blT, t.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.c(amVar.cLi, t.f.icon_frs_site);
                amVar.cLh.setOnClickListener(new x(this, lat, lng, name));
            } else {
                amVar.cLi.setVisibility(8);
                amVar.blT.setVisibility(8);
            }
            PraiseData praise = this.cJZ.aoF().getPraise();
            if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                amVar.beZ.setIsFromPb(true);
                amVar.beZ.setIsFromPbVideo(true);
                if (!amVar.cLj.isShown()) {
                    amVar.cLj.setVisibility(0);
                    amVar.beZ.dk(this.mSkinType);
                }
                amVar.beZ.a(praise, rVar.getId(), praise.getPostId(), true);
            } else {
                amVar.cLj.setVisibility(8);
            }
            a(amVar, Hb);
            amVar.cLo.setOnClickListener(new y(this, praise));
            amVar.cLo.setOnTouchListener(this.cKL);
            if (praise != null && praise.getIsLike() == 1) {
                this.cKF.cLo.setEnabled(false);
            } else {
                this.cKF.cLo.setEnabled(true);
            }
            if (amVar.mSkinType != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.l(view, t.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.ar.b(amVar.cLe, t.d.cp_cont_b, 1);
                com.baidu.tbadk.core.util.ar.b(amVar.cLf, t.d.cp_cont_c, 1);
                amVar.beZ.dk(this.mSkinType);
                amVar.cLl.onChangeSkinType(this.mSkinType);
                com.baidu.tbadk.core.util.ar.c(amVar.cLp, t.f.icon_play_video);
                com.baidu.tbadk.core.util.ar.b(amVar.cLo, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.b(amVar.bvl, t.d.cp_cont_i, 1);
                amVar.cLm.onChangeSkinType(this.mSkinType);
                amVar.cLo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.c((Resources) null, t.f.pb_like_after_play_selector), (Drawable) null, (Drawable) null);
                amVar.bvl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.c((Resources) null, t.f.pb_replay_selector), (Drawable) null, (Drawable) null);
            }
            amVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apc() {
        if (this.cKI != null && this.cJZ != null && this.cJZ.aoF() != null && this.cJZ.aoF().tz() != null) {
            this.cKI.x(this.cJZ.aoF().tz().video_md5, this.cJZ.getThreadId(), this.cJZ.getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.m mVar) {
        if (mVar != null) {
            this.cKJ++;
            mVar.fn(this.cKJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(am amVar, com.baidu.tbadk.widget.richText.m mVar) {
        if (amVar != null && amVar.cLf != null && mVar != null) {
            if (mVar.HA() < this.cKJ) {
                mVar.fn(this.cKJ);
            } else {
                this.cKJ = mVar.HA();
            }
            amVar.cLf.setText(String.format(this.cNL.getPageContext().getResources().getString(t.j.video_play_count), aw.x(this.cKJ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(am amVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (com.baidu.adp.lib.util.i.jb()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cNL.getPageContext().getPageActivity());
            aVar.cE(TbadkCoreApplication.m411getInst().getString(t.j.play_video_mobile_tip));
            aVar.a(t.j.confirm, new z(this, amVar, rVar));
            aVar.b(t.j.cancel, new aa(this));
            aVar.b(this.cNL.getPageContext()).uj();
            return;
        }
        b(amVar, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(am amVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        amVar.cLk.start();
        amVar.cLp.setVisibility(8);
        amVar.cLn.setVisibility(8);
        b(rVar, amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.cNL.getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            com.baidu.adp.lib.h.h.hr().postDelayed(this.cKM, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.cNL.getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            com.baidu.adp.lib.h.h.hr().postDelayed(this.cKM, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.cNL.getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.richText.m cLa;
        private am cLb;

        public a(com.baidu.tbadk.widget.richText.m mVar, am amVar) {
            this.cLa = mVar;
            this.cLb = amVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cLa != null && this.cLb != null && this.cLb.mLoadingLayout != null && this.cLb.cLk != null) {
                if (this.cLb.mLoadingLayout.isShown()) {
                    this.cLb.cLk.stopPlayback();
                    q.this.cKH = true;
                    q.this.c(this.cLb);
                } else if (com.baidu.adp.lib.util.i.jb()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(q.this.cNL.getPageContext().getPageActivity());
                    aVar.cE(TbadkCoreApplication.m411getInst().getString(t.j.play_video_mobile_tip));
                    aVar.a(t.j.confirm, new ak(this));
                    aVar.b(t.j.cancel, new al(this));
                    aVar.b(q.this.cNL.getPageContext()).uj();
                } else {
                    apf();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void apf() {
            this.cLb.cLk.setVideoPath(this.cLa.getVideoUrl());
            this.cLb.cLk.start();
            q.this.cKH = false;
            q.this.b(this.cLb);
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cJZ = cVar;
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.r rVar) {
        com.baidu.tbadk.widget.richText.m Hb;
        return (rVar == null || (Hb = rVar.Hb()) == null || Hb.getDuration() <= 9) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.data.r rVar, am amVar) {
        com.baidu.tbadk.widget.richText.m Hb = rVar.Hb();
        if (Hb != null) {
            amVar.cLd.d(Hb.Hx(), 17, false);
            amVar.cLd.setNoImageBottomText("");
            if (StringUtils.isNull(Hb.Hx())) {
                ky(Hb.getVideoUrl());
            } else {
                amVar.cLd.setEvent(new ab(this, Hb));
            }
            if (b(rVar)) {
                amVar.cLl.aN(0, Hb.getDuration() * 1000);
            } else {
                amVar.cLm.asV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(String str) {
        if (this.cNL == null || this.cNL.apk() == null || this.cNL.apk().getPbData() == null || this.cNL.apk().getPbData().getPage() == null) {
            this.cNL.fn(true);
            return;
        }
        if (com.baidu.adp.lib.util.i.ja() && !this.cNL.apC() && com.baidu.tbadk.core.l.rn().rt()) {
            this.cKF.cLk.setVideoPath(str);
            this.cKF.cLk.start();
            b(this.cKF);
        }
        this.cNL.fn(true);
        if (this.cJZ != null) {
            String str2 = com.baidu.adp.lib.util.i.ja() ? "1" : "0";
            au auVar = new au("c10643");
            auVar.aa(ImageViewerConfig.FORUM_ID, this.cJZ.getForumId());
            auVar.aa("obj_type", str2);
            TiebaStatic.log(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.data.r rVar, am amVar) {
        if (rVar != null && amVar != null) {
            if (b(rVar)) {
                amVar.cLl.aco();
            } else {
                amVar.cLm.aco();
            }
        }
    }

    private void a(am amVar) {
        if (amVar != null && amVar.cLl != null && amVar.cLm != null) {
            amVar.cLl.asT();
            amVar.cLm.asT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(am amVar) {
        if (amVar != null) {
            amVar.mLoadingLayout.setVisibility(0);
            amVar.cLd.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(am amVar) {
        if (amVar != null) {
            amVar.mLoadingLayout.setVisibility(8);
            amVar.cLd.setForegroundDrawable(t.f.icon_play_video);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apd() {
        if (this.cKF != null && this.cKF.cLk != null && this.cKF.cLp != null && this.cKF.mLoadingLayout != null) {
            if (this.cKF.cLk.isPlaying()) {
                this.cKF.cLk.pause();
                this.cKF.cLp.setVisibility(0);
            } else if (this.cKF.mLoadingLayout.getVisibility() == 0) {
                this.cKF.cLk.stopPlayback();
                this.cKH = true;
                c(this.cKF);
            }
        }
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }
}
