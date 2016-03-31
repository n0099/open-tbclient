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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class r extends db<com.baidu.tieba.tbadkCore.data.s, an> {
    private CustomMessageListener ahA;
    private TextureVideoView.a ahe;
    private long bjp;
    private boolean bjq;
    private an ddX;
    private boolean ddY;
    private boolean ddZ;
    private com.baidu.tieba.pb.data.e ddq;
    private com.baidu.tieba.pb.a.c dds;
    private com.baidu.tieba.pb.model.a dea;
    private int deb;
    private View.OnTouchListener dec;
    private Runnable ded;
    private MediaPlayer.OnErrorListener dee;
    private CustomMessageListener def;
    private CustomMessageListener deg;
    private CustomMessageListener deh;
    private CustomMessageListener dei;
    private Handler mHandler;
    private View mView;

    public r(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.ddq = null;
        this.ddY = false;
        this.bjp = 0L;
        this.bjq = true;
        this.ddZ = false;
        this.deb = 0;
        this.dds = null;
        this.ahe = new s(this);
        this.mHandler = new ad(this, Looper.getMainLooper());
        this.dec = new ae(this);
        this.ded = new af(this);
        this.dee = new ag(this);
        this.ahA = new ah(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.def = new ai(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.deg = new aj(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.deh = new ak(this, CmdConfigCustom.PB_ON_SCROLL);
        this.dei = new t(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        if (pbActivity != null) {
            pbActivity.registerListener(this.ahA);
            pbActivity.registerListener(this.def);
            pbActivity.registerListener(this.deg);
            pbActivity.registerListener(this.deh);
            pbActivity.registerListener(this.dei);
        }
        this.dea = new com.baidu.tieba.pb.model.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public an b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(t.h.pb_list_item_video, (ViewGroup) null);
            this.ddX = new an(this.mView);
            View findViewById = this.mView.findViewById(t.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int B = com.baidu.adp.lib.util.k.B(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = B;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            avS();
        }
        return this.ddX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avS() {
        if (this.ddX != null && this.ddX.deu != null && this.ddX.deD != null) {
            this.ddX.deu.setVisibility(0);
            this.ddX.deD.setVisibility(8);
            this.ddZ = true;
            c(this.ddX);
            a(this.ddX);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, an anVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) anVar);
        if (sVar != null && anVar != null) {
            com.baidu.tbadk.widget.richText.n Iv = sVar.Iv();
            if (!this.ddY) {
                this.ddY = true;
                if (b(sVar)) {
                    anVar.deB.setVisibility(0);
                    anVar.deC.setVisibility(8);
                } else {
                    anVar.deB.setVisibility(8);
                    anVar.deC.setVisibility(0);
                }
                anVar.deu.setForegroundDrawable(t.f.icon_play_video);
                anVar.deu.setDefaultErrorResource(0);
                anVar.deu.setTag(Integer.valueOf(i));
                anVar.deu.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.qE().qK()) {
                    anVar.deu.setNoImageBottomTextColor(t.d.cp_cont_c);
                    anVar.deu.setNoImageBottomTextPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32));
                    anVar.deu.setNoImageBottomTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.fontsize28));
                    anVar.deu.setSupportNoImage(true);
                    anVar.deu.setNoImageBottomText(TbadkCoreApplication.m411getInst().getString(t.j.click_to_play));
                } else {
                    anVar.deu.setDefaultBgResource(t.f.pic_bg_video_frs);
                    if (!anVar.deA.isPlaying()) {
                        a(sVar, anVar);
                    }
                }
                anVar.deu.setOnClickListener(new a(Iv, anVar));
                if (this.ddq != null && this.ddq.avv() != null && this.ddq.avv().tA() == 1) {
                    anVar.dev.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = anVar.dew.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.dfw.getPageContext().getResources().getDimension(t.e.ds34);
                        anVar.dew.setLayoutParams(layoutParams);
                    }
                } else {
                    anVar.dev.setText(sVar.getTitle());
                    anVar.dev.setVisibility(0);
                    anVar.dev.setOnTouchListener(this.dds);
                }
                anVar.bAt.setOnClickListener(new u(this, anVar, sVar, Iv));
                anVar.deA.setOnPreparedListener(new v(this, anVar, Iv, sVar));
                anVar.deA.setOnCompletionListener(new w(this, anVar, sVar));
                anVar.deA.setOnErrorListener(this.dee);
                anVar.deA.setOnSurfaceDestroyedListener(this.ahe);
                this.mView.findViewById(t.g.pb_video_cover_view).setOnClickListener(new x(this, anVar, sVar));
                if (b(sVar)) {
                    anVar.deB.setPlayer(anVar.deA);
                } else {
                    anVar.deC.setPlayer(anVar.deA);
                }
            }
            com.baidu.tbadk.data.e aTv = sVar.aTv();
            if (aTv != null && !TextUtils.isEmpty(aTv.getName()) && !TextUtils.isEmpty(aTv.getName().trim())) {
                String name = aTv.getName();
                String lat = aTv.getLat();
                String lng = aTv.getLng();
                anVar.dex.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, anVar.dex, 0, 10, 0, 10);
                anVar.brk.setText(aTv.getName());
                at.b(anVar.brk, t.d.cp_cont_c, 1);
                at.c(anVar.dey, t.f.icon_frs_site);
                anVar.dex.setOnClickListener(new y(this, lat, lng, name));
            } else {
                anVar.dey.setVisibility(8);
                anVar.brk.setVisibility(8);
            }
            PraiseData praise = this.ddq.avv().getPraise();
            if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                anVar.bjL.setIsFromPb(true);
                anVar.bjL.setIsFromPbVideo(true);
                if (!anVar.dez.isShown()) {
                    anVar.dez.setVisibility(0);
                    anVar.bjL.dn(this.mSkinType);
                }
                anVar.bjL.a(praise, sVar.getId(), praise.getPostId(), true);
            } else {
                anVar.dez.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.af(anVar.bjL);
            com.baidu.tieba.graffiti.d.af(anVar.dez);
            a(anVar, Iv);
            anVar.deE.setOnClickListener(new z(this, praise));
            anVar.deE.setOnTouchListener(this.dec);
            if (praise != null && praise.getIsLike() == 1) {
                this.ddX.deE.setEnabled(false);
            } else {
                this.ddX.deE.setEnabled(true);
            }
            if (anVar.mSkinType != this.mSkinType) {
                at.l(view, t.d.cp_bg_line_d);
                at.b(anVar.dev, t.d.cp_cont_b, 1);
                at.b(anVar.dew, t.d.cp_cont_c, 1);
                at.b(anVar.deE, t.d.cp_cont_i, 1);
                anVar.bjL.dn(this.mSkinType);
                anVar.deE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, t.f.pb_like_after_play_selector), (Drawable) null, (Drawable) null);
                anVar.deB.onChangeSkinType(this.mSkinType);
                at.c(anVar.deF, t.f.icon_play_video);
                at.b(anVar.bAt, t.d.cp_cont_i, 1);
                anVar.deC.onChangeSkinType(this.mSkinType);
                anVar.bAt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, t.f.pb_replay_selector), (Drawable) null, (Drawable) null);
            }
            com.baidu.tieba.graffiti.d.af(anVar.deE);
            anVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avT() {
        if (this.dea != null && this.ddq != null && this.ddq.avv() != null && this.ddq.avv().tC() != null) {
            this.dea.z(this.ddq.avv().tC().video_md5, this.ddq.getThreadId(), this.ddq.getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.n nVar) {
        if (nVar != null) {
            this.deb++;
            nVar.fA(this.deb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, com.baidu.tbadk.widget.richText.n nVar) {
        if (anVar != null && anVar.dew != null && nVar != null) {
            if (nVar.IW() < this.deb) {
                nVar.fA(this.deb);
            } else {
                this.deb = nVar.IW();
            }
            anVar.dew.setText(String.format(this.dfw.getPageContext().getResources().getString(t.j.video_play_count), ay.z(this.deb)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (com.baidu.adp.lib.util.i.jh()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dfw.getPageContext().getPageActivity());
            aVar.cC(TbadkCoreApplication.m411getInst().getString(t.j.play_video_mobile_tip));
            aVar.a(t.j.confirm, new aa(this, anVar, sVar));
            aVar.b(t.j.cancel, new ab(this));
            aVar.b(this.dfw.getPageContext()).up();
            return;
        }
        b(anVar, sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        anVar.deA.start();
        anVar.deF.setVisibility(8);
        anVar.deD.setVisibility(8);
        b(sVar, anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.dfw.getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            com.baidu.adp.lib.h.h.hx().postDelayed(this.ded, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.dfw.getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            com.baidu.adp.lib.h.h.hx().postDelayed(this.ded, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.dfw.getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.richText.n der;
        private an des;

        public a(com.baidu.tbadk.widget.richText.n nVar, an anVar) {
            this.der = nVar;
            this.des = anVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.der != null && this.des != null && this.des.mLoadingLayout != null && this.des.deA != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                if (this.des.mLoadingLayout.getVisibility() == 0) {
                    this.des.deA.stopPlayback();
                    r.this.ddZ = true;
                    r.this.c(this.des);
                } else if (com.baidu.adp.lib.util.i.jh()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(r.this.dfw.getPageContext().getPageActivity());
                    aVar.cC(TbadkCoreApplication.m411getInst().getString(t.j.play_video_mobile_tip));
                    aVar.a(t.j.confirm, new al(this));
                    aVar.b(t.j.cancel, new am(this));
                    aVar.b(r.this.dfw.getPageContext()).up();
                } else {
                    avV();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void avV() {
            this.des.deA.setVideoPath(this.der.getVideoUrl());
            this.des.deA.start();
            r.this.ddZ = false;
            r.this.b(this.des);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddq = eVar;
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.s sVar) {
        com.baidu.tbadk.widget.richText.n Iv;
        return (sVar == null || (Iv = sVar.Iv()) == null || Iv.getDuration() <= 9) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.data.s sVar, an anVar) {
        com.baidu.tbadk.widget.richText.n Iv = sVar.Iv();
        if (Iv != null) {
            anVar.deu.c(Iv.rV(), 17, false);
            anVar.deu.setNoImageBottomText("");
            if (StringUtils.isNull(Iv.rV())) {
                lL(Iv.getVideoUrl());
            } else {
                anVar.deu.setEvent(new ac(this, Iv));
            }
            if (b(sVar)) {
                anVar.deB.aN(0, Iv.getDuration() * 1000);
            } else {
                anVar.deC.aAF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.dfw == null || this.dfw.awj() == null || this.dfw.awj().getPbData() == null || this.dfw.awj().getPbData().getPage() == null) {
            this.dfw.fY(true);
            return;
        }
        if (com.baidu.adp.lib.util.i.jg() && !this.dfw.awD() && com.baidu.tbadk.core.l.qE().qK()) {
            this.ddX.deA.setVideoPath(str);
            this.ddX.deA.start();
            b(this.ddX);
        }
        this.dfw.fY(true);
        if (this.ddq != null) {
            String str2 = com.baidu.adp.lib.util.i.jg() ? "1" : "0";
            aw awVar = new aw("c10643");
            awVar.ac("fid", this.ddq.getForumId());
            awVar.ac("tid", this.ddq.getThreadId());
            awVar.ac("obj_type", str2);
            TiebaStatic.log(awVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.data.s sVar, an anVar) {
        if (sVar != null && anVar != null) {
            if (b(sVar)) {
                anVar.deB.afJ();
            } else {
                anVar.deC.afJ();
            }
        }
    }

    private void a(an anVar) {
        if (anVar != null && anVar.deB != null && anVar.deC != null) {
            anVar.deB.aAD();
            anVar.deC.aAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(an anVar) {
        if (anVar != null) {
            anVar.mLoadingLayout.setVisibility(0);
            anVar.deu.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(an anVar) {
        if (anVar != null) {
            anVar.mLoadingLayout.setVisibility(8);
            anVar.deu.setForegroundDrawable(t.f.icon_play_video);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avU() {
        if (this.ddX != null && this.ddX.deA != null && this.ddX.deF != null && this.ddX.mLoadingLayout != null) {
            if (this.ddX.deA.isPlaying()) {
                this.ddX.deA.pause();
                this.ddX.deF.setVisibility(0);
            } else if (this.ddX.mLoadingLayout.getVisibility() == 0) {
                this.ddX.deA.stopPlayback();
                this.ddZ = true;
                c(this.ddX);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }
}
