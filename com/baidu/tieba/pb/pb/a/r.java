package com.baidu.tieba.pb.pb.a;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class r extends cm<com.baidu.tieba.tbadkCore.data.s, an> {
    private com.baidu.tieba.play.a aPY;
    private TextureVideoView.b acR;
    private CustomMessageListener adt;
    private long bfp;
    private boolean bfq;
    private com.baidu.tieba.pb.data.e dfK;
    private com.baidu.tieba.pb.a.d dfM;
    private CustomMessageListener dgA;
    private CustomMessageListener dgB;
    private an dgr;
    private boolean dgs;
    private boolean dgt;
    private int dgu;
    private View.OnTouchListener dgv;
    private Runnable dgw;
    private MediaPlayer.OnErrorListener dgx;
    private CustomMessageListener dgy;
    private CustomMessageListener dgz;
    private Handler mHandler;
    private View mView;

    public r(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.dfK = null;
        this.dgs = false;
        this.bfp = 0L;
        this.bfq = true;
        this.dgt = false;
        this.dgu = 0;
        this.dfM = null;
        this.acR = new s(this);
        this.mHandler = new ad(this, Looper.getMainLooper());
        this.dgv = new ae(this);
        this.dgw = new af(this);
        this.dgx = new ag(this);
        this.adt = new ah(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.dgy = new ai(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.dgz = new aj(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.dgA = new ak(this, CmdConfigCustom.PB_ON_SCROLL);
        this.dgB = new t(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        if (pbActivity != null) {
            pbActivity.registerListener(this.adt);
            pbActivity.registerListener(this.dgy);
            pbActivity.registerListener(this.dgz);
            pbActivity.registerListener(this.dgA);
            pbActivity.registerListener(this.dgB);
        }
        this.aPY = new com.baidu.tieba.play.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aD */
    public an b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(t.h.pb_list_item_video, (ViewGroup) null);
            this.dgr = new an(this.mView);
            View findViewById = this.mView.findViewById(t.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int B = com.baidu.adp.lib.util.k.B(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = B;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            awe();
        }
        return this.dgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awe() {
        if (this.dgr != null && this.dgr.dgN != null && this.dgr.dgW != null) {
            this.dgr.dgN.setVisibility(0);
            this.dgr.dgW.setVisibility(8);
            this.dgt = true;
            c(this.dgr);
            a(this.dgr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, an anVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) anVar);
        if (sVar != null && anVar != null) {
            com.baidu.tbadk.widget.richText.o GN = sVar.GN();
            if (!this.dgs) {
                this.dgs = true;
                if (b(sVar)) {
                    anVar.dgU.setVisibility(0);
                    anVar.dgV.setVisibility(8);
                } else {
                    anVar.dgU.setVisibility(8);
                    anVar.dgV.setVisibility(0);
                }
                anVar.dgN.setForegroundDrawable(t.f.icon_play_video);
                anVar.dgN.setDefaultErrorResource(0);
                anVar.dgN.setTag(Integer.valueOf(i));
                anVar.dgN.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.ob().oh()) {
                    anVar.dgN.setNoImageBottomTextColor(t.d.cp_cont_c);
                    anVar.dgN.setNoImageBottomTextPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds32));
                    anVar.dgN.setNoImageBottomTextSize(TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.fontsize28));
                    anVar.dgN.setSupportNoImage(true);
                    anVar.dgN.setNoImageBottomText(TbadkCoreApplication.m11getInst().getString(t.j.click_to_play));
                } else {
                    anVar.dgN.setDefaultBgResource(t.f.pic_bg_video_frs);
                    if (!anVar.dgT.isPlaying()) {
                        a(sVar, anVar);
                    }
                }
                anVar.dgN.setOnClickListener(new a(GN, anVar));
                if (this.dfK != null && this.dfK.avE() != null && this.dfK.avE().qZ() == 1) {
                    anVar.dgO.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = anVar.dgP.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.dhY.getPageContext().getResources().getDimension(t.e.ds34);
                        anVar.dgP.setLayoutParams(layoutParams);
                    }
                } else {
                    anVar.dgO.setTextSize(TbConfig.getContentSize());
                    anVar.dgO.setText(sVar.getTitle());
                    anVar.dgO.setVisibility(0);
                    anVar.dgO.setOnTouchListener(this.dfM);
                }
                anVar.bAx.setOnClickListener(new u(this, anVar, sVar, GN));
                anVar.dgT.setOnPreparedListener(new v(this, anVar, GN, sVar));
                anVar.dgT.setOnCompletionListener(new w(this, anVar, sVar));
                anVar.dgT.setOnErrorListener(this.dgx);
                anVar.dgT.setOnSurfaceDestroyedListener(this.acR);
                this.mView.findViewById(t.g.pb_video_cover_view).setOnClickListener(new x(this, anVar, sVar));
                if (b(sVar)) {
                    anVar.dgU.setPlayer(anVar.dgT);
                } else {
                    anVar.dgV.setPlayer(anVar.dgT);
                }
                awg();
            }
            com.baidu.tbadk.data.f aUb = sVar.aUb();
            if (aUb != null && !TextUtils.isEmpty(aUb.getName()) && !TextUtils.isEmpty(aUb.getName().trim())) {
                String name = aUb.getName();
                String lat = aUb.getLat();
                String lng = aUb.getLng();
                anVar.dgQ.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, anVar.dgQ, 0, 10, 0, 10);
                anVar.bmy.setText(aUb.getName());
                at.c(anVar.bmy, t.d.cp_link_tip_c, 1);
                anVar.dgR.setImageDrawable(at.getDrawable(t.f.icon_pb_pin));
                anVar.dgQ.setOnClickListener(new y(this, lat, lng, name));
            } else {
                anVar.dgR.setVisibility(8);
                anVar.bmy.setVisibility(8);
            }
            PraiseData praise = this.dfK.avE().getPraise();
            if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                anVar.bfL.setIsFromPb(true);
                anVar.bfL.setIsFromPbVideo(true);
                if (!anVar.dgS.isShown()) {
                    anVar.dgS.setVisibility(0);
                    anVar.bfL.cV(this.mSkinType);
                }
                anVar.bfL.a(praise, sVar.getId(), praise.getPostId(), true);
            } else {
                anVar.dgS.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.aj(anVar.bfL);
            com.baidu.tieba.graffiti.d.aj(anVar.dgS);
            a(anVar, GN);
            anVar.dgX.setOnClickListener(new z(this, praise));
            anVar.dgX.setOnTouchListener(this.dgv);
            if (praise != null && praise.getIsLike() == 1) {
                this.dgr.dgX.setEnabled(false);
            } else {
                this.dgr.dgX.setEnabled(true);
            }
            if (anVar.mSkinType != this.mSkinType) {
                at.l(view, t.d.cp_bg_line_d);
                at.c(anVar.dgO, t.d.cp_cont_b, 1);
                at.c(anVar.dgP, t.d.cp_cont_c, 1);
                at.c(anVar.dgX, t.d.cp_cont_i, 1);
                anVar.bfL.cV(this.mSkinType);
                anVar.dgX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, t.f.pb_like_after_play_selector), (Drawable) null, (Drawable) null);
                anVar.dgU.onChangeSkinType(this.mSkinType);
                at.c(anVar.dgY, t.f.icon_play_video);
                at.c(anVar.bAx, t.d.cp_cont_i, 1);
                anVar.dgV.onChangeSkinType(this.mSkinType);
                anVar.bAx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, t.f.pb_replay_selector), (Drawable) null, (Drawable) null);
            }
            com.baidu.tieba.graffiti.d.aj(anVar.dgX);
            anVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awf() {
        if (this.aPY != null && this.dfK != null && this.dfK.avE() != null && this.dfK.avE().rb() != null) {
            this.aPY.A(this.dfK.avE().rb().video_md5, this.dfK.getThreadId(), this.dfK.getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.dgu++;
            oVar.ff(this.dgu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, com.baidu.tbadk.widget.richText.o oVar) {
        if (anVar != null && anVar.dgP != null && oVar != null) {
            if (oVar.Ho() < this.dgu) {
                oVar.ff(this.dgu);
            } else {
                this.dgu = oVar.Ho();
            }
            anVar.dgP.setText(String.format(this.dhY.getPageContext().getResources().getString(t.j.video_play_count), ay.A(this.dgu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (com.baidu.adp.lib.util.i.fs()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dhY.getPageContext().getPageActivity());
            aVar.cA(TbadkCoreApplication.m11getInst().getString(t.j.play_video_mobile_tip));
            aVar.a(t.j.confirm, new aa(this, anVar, sVar));
            aVar.b(t.j.cancel, new ab(this));
            aVar.b(this.dhY.getPageContext()).rV();
            return;
        }
        b(anVar, sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        anVar.dgT.start();
        anVar.dgY.setVisibility(8);
        anVar.dgW.setVisibility(8);
        b(sVar, anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.dhY.getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            com.baidu.adp.lib.h.h.dL().postDelayed(this.dgw, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.dhY.getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            com.baidu.adp.lib.h.h.dL().postDelayed(this.dgw, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.dhY.getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.richText.o dgK;
        private an dgL;

        public a(com.baidu.tbadk.widget.richText.o oVar, an anVar) {
            this.dgK = oVar;
            this.dgL = anVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dgK != null && this.dgL != null && this.dgL.mLoadingLayout != null && this.dgL.dgT != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                if (this.dgL.mLoadingLayout.getVisibility() == 0) {
                    this.dgL.dgT.stopPlayback();
                    r.this.dgt = true;
                    r.this.c(this.dgL);
                } else if (com.baidu.adp.lib.util.i.fs()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(r.this.dhY.getPageContext().getPageActivity());
                    aVar.cA(TbadkCoreApplication.m11getInst().getString(t.j.play_video_mobile_tip));
                    aVar.a(t.j.confirm, new al(this));
                    aVar.b(t.j.cancel, new am(this));
                    aVar.b(r.this.dhY.getPageContext()).rV();
                } else {
                    awj();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void awj() {
            if (this.dgK != null && this.dgL != null && this.dgL.dgT != null) {
                if (com.baidu.tbadk.core.view.at.vE().vH() > 0) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(this.dgK.getVideoUrl()), "video/mp4");
                    if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                        r.this.dhY.startActivity(intent);
                        return;
                    }
                    return;
                }
                this.dgL.dgT.setVideoPath(this.dgK.getVideoUrl());
                this.dgL.dgT.start();
                r.this.dgt = false;
                r.this.b(this.dgL);
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.s sVar) {
        com.baidu.tbadk.widget.richText.o GN;
        return (sVar == null || (GN = sVar.GN()) == null || GN.getDuration() <= 9) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.data.s sVar, an anVar) {
        com.baidu.tbadk.widget.richText.o GN = sVar.GN();
        if (GN != null) {
            anVar.dgN.c(GN.po(), 17, false);
            anVar.dgN.setNoImageBottomText("");
            if (StringUtils.isNull(GN.po())) {
                lP(GN.getVideoUrl());
            } else {
                anVar.dgN.setEvent(new ac(this, GN));
            }
            if (b(sVar)) {
                anVar.dgU.aO(0, GN.getDuration() * 1000);
            } else {
                anVar.dgV.aAT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(String str) {
        if (this.dhY == null || this.dhY.awx() == null || this.dhY.awx().getPbData() == null || this.dhY.awx().getPbData().getPage() == null) {
            this.dhY.gy(true);
        } else if (com.baidu.tbadk.core.view.at.vE().vH() <= 0) {
            if (com.baidu.adp.lib.util.i.fr() && !this.dhY.awO() && com.baidu.tbadk.core.l.ob().oh()) {
                this.dgr.dgT.setVideoPath(str);
                this.dgr.dgT.start();
                b(this.dgr);
            }
            this.dhY.gy(true);
        }
    }

    private void awg() {
        if (this.dfK != null) {
            String str = com.baidu.adp.lib.util.i.fr() ? "1" : "0";
            aw awVar = new aw("c10643");
            awVar.ac("fid", this.dfK.getForumId());
            awVar.ac("tid", this.dfK.getThreadId());
            awVar.ac("obj_type", str);
            TiebaStatic.log(awVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.data.s sVar, an anVar) {
        if (sVar != null && anVar != null) {
            if (b(sVar)) {
                anVar.dgU.afQ();
            } else {
                anVar.dgV.afQ();
            }
        }
    }

    private void a(an anVar) {
        if (anVar != null && anVar.dgU != null && anVar.dgV != null) {
            anVar.dgU.aAR();
            anVar.dgV.aAR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(an anVar) {
        if (anVar != null) {
            anVar.mLoadingLayout.setVisibility(0);
            anVar.dgN.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(an anVar) {
        if (anVar != null) {
            anVar.mLoadingLayout.setVisibility(8);
            anVar.dgN.setForegroundDrawable(t.f.icon_play_video);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awh() {
        if (this.dgr != null && this.dgr.dgT != null && this.dgr.dgY != null && this.dgr.mLoadingLayout != null) {
            if (this.dgr.dgT.isPlaying()) {
                this.dgr.dgT.pause();
                this.dgr.dgY.setVisibility(0);
            } else if (this.dgr.mLoadingLayout.getVisibility() == 0) {
                this.dgr.dgT.stopPlayback();
                this.dgt = true;
                c(this.dgr);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void awi() {
        if (this.dgr != null) {
            this.dgr.dgO.setTextSize(TbConfig.getContentSize());
        }
    }
}
