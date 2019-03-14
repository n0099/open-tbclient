package com.baidu.tieba.recapp.lego.view;

import android.os.Handler;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.g;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, g, i, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Tx;
    public TextView Zy;
    private Animation aeY;
    private Animation aeZ;
    private boolean bGc;
    public HeadImageView dRs;
    private n dbe;
    public FrameLayout fed;
    public FrameLayout fee;
    public TextView fef;
    public c fer;
    private View fwR;
    private View fwX;
    private com.baidu.tieba.frs.videomiddlepage.c fwZ;
    private VideoNetworkStateTipView fxc;
    private Animation.AnimationListener fxi;
    private Animation.AnimationListener fxj;
    private a ikA;
    private View ikm;
    private View ikn;
    private View iko;
    public TextView ikp;
    private VideoMiddlePageAdCard ikq;
    private TextView ikr;
    private TextView iks;
    private ViewGroup ikt;
    private d iku;
    private e ikv;
    private f ikw;
    private int ikx;
    private boolean iky;
    private boolean ikz;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iky = false;
        this.ikz = true;
        this.fxi = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fwX != null) {
                    VideoMiddlePageAdView.this.fwX.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.ikm != null) {
                    VideoMiddlePageAdView.this.ikm.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fwX != null) {
                    VideoMiddlePageAdView.this.fwX.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.ikm != null) {
                    VideoMiddlePageAdView.this.ikm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fxj = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fwX != null) {
                    VideoMiddlePageAdView.this.fwX.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.ikm != null) {
                    VideoMiddlePageAdView.this.ikm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fwX != null) {
                    VideoMiddlePageAdView.this.fwX.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.ikm != null) {
                    VideoMiddlePageAdView.this.ikm.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iky = false;
        this.ikz = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.fed = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.fwR = this.rootView.findViewById(d.g.card_container);
        this.fee = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.fer = new c((TbPageContext<?>) this.mContext, (View) this.fee, false);
        this.fer.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.ikx = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fer.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void jV(boolean z) {
                if (VideoMiddlePageAdView.this.ikA != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.ikA.rG(0);
                    } else {
                        VideoMiddlePageAdView.this.ikA.rG(1);
                    }
                }
            }
        });
        this.fer.gHW.setOnTouchListener(null);
        this.fef = (TextView) this.rootView.findViewById(d.g.title);
        this.dRs = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.dRs.setIsRound(true);
        this.dRs.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.dRs.setDefaultResource(d.f.icon_default_avatar100);
        this.dRs.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ikp = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.Zy = (TextView) this.rootView.findViewById(d.g.user_name);
        this.dbe = new n(this.mContext.getPageActivity());
        this.ikr = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.iks = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.ikt = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.iku = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.ikt);
        this.iku.page = 1;
        this.fxc = (VideoNetworkStateTipView) this.rootView.findViewById(d.g.network_state_tip);
        this.fxc.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fxc.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fer.oW(false);
                VideoMiddlePageAdView.this.fxc.cmq();
                if (VideoMiddlePageAdView.this.ikq != null && VideoMiddlePageAdView.this.ikq.video != null) {
                    VideoMiddlePageAdView.this.fer.cf(VideoMiddlePageAdView.this.ikq.video.video_url, "");
                }
            }
        });
        this.fwX = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.ikn = this.rootView.findViewById(d.g.user_container_foreground);
        this.iko = this.rootView.findViewById(d.g.title_foreground);
        this.ikm = this.rootView.findViewById(d.g.operate_area_foreground);
        this.fwX.setOnClickListener(this);
        this.ikn.setOnClickListener(this);
        this.iko.setOnClickListener(this);
        this.ikm.setOnClickListener(this);
        this.fee.setOnClickListener(this);
        this.fed.setOnClickListener(this);
        this.fer.T(this);
        this.fef.setOnClickListener(this);
        this.dRs.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fed.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fed.setLayoutParams(layoutParams);
        this.aeY = new AlphaAnimation(0.0f, 0.7f);
        this.aeY.setDuration(500L);
        this.aeY.setAnimationListener(this.fxj);
        this.aeZ = new AlphaAnimation(0.7f, 0.0f);
        this.aeZ.setDuration(500L);
        this.aeZ.setAnimationListener(this.fxi);
        this.rootView.setOnClickListener(this);
        this.ikA = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bGc = this.ikq.autoPlay;
            this.iky = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.ikx = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fer.ql()) {
                cb(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fer.getCurrentPosition());
                this.ikz = true;
            }
            this.fer.stopPlay();
            this.fer.setIsNeedRecoveryVideoPlayer(true);
            this.fer.oX(true);
            this.fer.oT(false);
            this.fer.oY(true);
            this.fer.ae(false, true);
            this.fer.xm(i);
            this.fer.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                }
            });
            this.fer.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void beP() {
                    if (VideoMiddlePageAdView.this.ikq != null && VideoMiddlePageAdView.this.ikq.video != null && VideoMiddlePageAdView.this.ikq.video.video_height.intValue() > VideoMiddlePageAdView.this.ikq.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fer.ae(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fer.ae(false, true);
                    }
                    if (VideoMiddlePageAdView.this.ikw != null) {
                        VideoMiddlePageAdView.this.ikw.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.xT(VideoMiddlePageAdView.this.bGc ? 0 : 1);
                    VideoMiddlePageAdView.this.iky = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void beQ() {
                }
            });
            this.fer.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z) {
                    VideoMiddlePageAdView.this.fer.cf(VideoMiddlePageAdView.this.ikq.video.video_url, "");
                    if (VideoMiddlePageAdView.this.ikw != null) {
                        VideoMiddlePageAdView.this.ikw.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.xT(1);
                    VideoMiddlePageAdView.this.iky = false;
                }
            });
            this.fer.oP(false);
            this.fer.getVideoView().setBusiness(this.dbe);
            this.fer.bAG();
            this.fer.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.fer.bnQ();
                    if (VideoMiddlePageAdView.this.ikv != null) {
                        VideoMiddlePageAdView.this.ikv.bXI();
                    }
                    VideoMiddlePageAdView.this.xU(VideoMiddlePageAdView.this.bGc ? 0 : 1);
                    VideoMiddlePageAdView.this.ikz = true;
                }
            });
            this.fer.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.xV(VideoMiddlePageAdView.this.bGc ? 0 : 1);
                    return true;
                }
            });
            this.fer.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fer.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fer.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void beS() {
                    VideoMiddlePageAdView.this.cc(1, VideoMiddlePageAdView.this.fer.getCurrentPosition());
                }
            });
            this.fer.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cb(1, VideoMiddlePageAdView.this.fer.getCurrentPosition());
                    VideoMiddlePageAdView.this.ikz = true;
                }
            });
            this.fer.bnQ();
            this.fer.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fxc.bUo()) {
                    this.fer.oV(false);
                    this.fxc.cmp();
                    this.fer.oW(true);
                    this.fer.dC(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fer.oW(false);
                    this.fer.oV(false);
                    this.fxc.hide();
                    this.fer.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.ikv != null) {
                    this.ikv.pp(true);
                }
                if (i == 0) {
                    this.fwX.setVisibility(8);
                    this.ikm.setVisibility(8);
                } else {
                    this.fwX.startAnimation(this.aeZ);
                    this.ikm.startAnimation(this.aeZ);
                }
                if (i == 0) {
                    this.ikA.rG(3);
                    return;
                } else {
                    this.ikA.rG(0);
                    return;
                }
            }
            this.fxc.hide();
            this.fer.oV(true);
            this.ikA.rG(3);
            if (j.la() && videoMiddlePageAdCard.waitConfirm) {
                this.fwX.startAnimation(this.aeZ);
                this.ikm.startAnimation(this.aeZ);
                return;
            }
            this.fwX.setVisibility(0);
            this.ikm.setVisibility(0);
        }
    }

    private boolean bjD() {
        try {
            int intValue = this.ikq.video.video_width.intValue();
            return intValue <= 0 || ((float) this.ikq.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fef.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        this.ikp.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        this.ikr.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        this.iks.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        al.k(this.iks, d.f.btn_rouned_corner_bg_shape);
    }

    private void bjE() {
        if (!bjD()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fed.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fed.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fed.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fed.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.ikq = videoMiddlePageAdCard;
        bjE();
        this.fef.setText(videoMiddlePageAdCard.threadTitle);
        this.Zy.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.dRs.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.dRs.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.dRs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.age() || VideoMiddlePageAdView.this.ikq == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(VideoMiddlePageAdView.this.ikq.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.ikp.setText(videoMiddlePageAdCard.tagName);
        this.ikr.setText(videoMiddlePageAdCard.operateData.iie);
        this.iks.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iks.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.ikv != null) {
                    VideoMiddlePageAdView.this.ikv.pp(false);
                }
                if (VideoMiddlePageAdView.this.gHy != null) {
                    VideoMiddlePageAdView.this.gHy.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.ikq, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.ikv = this.iku.a(videoMiddlePageAdCard.tailFrame, this.ikv);
        if (this.ikv != null) {
            b(this.ikq.getAdFacadeData());
            this.ikv.setPageContext(this.mContext);
            this.ikv.setTimeoutListener(this);
            this.ikv.a(videoMiddlePageAdCard.tailFrame);
            this.ikv.c(this.ikq);
            this.ikv.bXJ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Tx = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Tx;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fwZ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.ikw = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bh(View view) {
        this.Tx.qv(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        beN();
        if (this.fwX != null) {
            this.fwX.clearAnimation();
        }
        if (this.ikm != null) {
            this.ikm.clearAnimation();
        }
    }

    public void beM() {
        this.fer.stopPlay();
        if (this.fef != null) {
            this.fef.setVisibility(0);
        }
        if (this.ikA != null) {
            this.ikA.rG(2);
        }
        this.iky = false;
        this.ikz = true;
    }

    public void beN() {
        if (this.fer != null) {
            this.fer.destroy();
        }
        this.iky = false;
        this.ikz = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwX && this.fwX.getVisibility() == 0) {
            if (this.fwZ != null) {
                this.fwZ.rK(this.mPosition);
            }
        } else if (view == this.ikm && this.ikm.getVisibility() == 0) {
            if (this.fwZ != null) {
                this.fwZ.rK(this.mPosition);
            }
        } else if (view == this.iko || view == this.ikn) {
            if (this.fwX.getVisibility() == 0) {
                if (this.fwZ != null) {
                    this.fwZ.rK(this.mPosition);
                    return;
                }
                return;
            }
            this.ikA.rG(0);
        } else if (view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.float_video_container || view.getId() == d.g.title) {
            WebVideoActivity.igY = new WebVideoActivity.a();
            if (this.ikq.getAdFacadeData() != null) {
                WebVideoActivity.igY.ihi = this.ikq.getAdFacadeData().pR();
                WebVideoActivity.igY.axI = "DETAIL";
                if (this.ikq.getAdFacadeData().Tj != null) {
                    WebVideoActivity.igY.mPageNum = this.ikq.getAdFacadeData().Tj.pN();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.ikq.getScheme(), true, true, true, this.ikq.video.video_url, this.ikq.video.thumbnail_url, 1.7777778f, this.ikx)));
            if (this.gHy != null) {
                this.gHy.b(0, null);
            }
            if (this.ikv != null) {
                this.ikv.pp(false);
            }
        } else {
            int e = s.e(this.mContext, this.ikq.getScheme());
            if (this.gHy != null) {
                this.gHy.b(e, null);
            }
            if (this.ikv != null) {
                this.ikv.pp(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.lA(this.fer.getCurrentPosition()) < this.ikx && this.fer.getCurrentState() == 1) {
            cb(this.bGc ? 0 : 1, this.fer.getCurrentPosition());
        }
        beM();
        this.ikv.pp(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.fer.pausePlay();
            cb(this.bGc ? 0 : 1, this.fer.getCurrentPosition());
            this.ikz = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.fer.ql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xT(int i) {
        if (this.ikq != null && this.ikq.video != null && this.ikq.getAdFacadeData() != null && this.ikz) {
            com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(this.ikq.getAdFacadeData(), 31, this.ikq.getAdFacadeData().getPageNum(), i, this.ikx, 0, -1));
            this.ikz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(int i) {
        if (this.ikq != null && this.ikq.video != null && this.ikq.getAdFacadeData() != null && !this.iky) {
            com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(this.ikq.getAdFacadeData(), 34, this.ikq.getAdFacadeData().getPageNum(), i, this.ikx, this.ikx, -1));
            this.iky = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xV(int i) {
        if (this.ikq != null && this.ikq.video != null && this.ikq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(this.ikq.getAdFacadeData(), 36, this.ikq.getAdFacadeData().getPageNum(), i, this.ikx, com.baidu.tieba.ad.a.a.lA(this.fer.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        if (this.ikq != null && this.ikq.video != null && this.ikq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(this.ikq.getAdFacadeData(), 32, this.ikq.getAdFacadeData().getPageNum(), i, this.ikx, com.baidu.tieba.ad.a.a.lA(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i, int i2) {
        if (this.ikq != null && this.ikq.video != null && this.ikq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(this.ikq.getAdFacadeData(), 33, this.ikq.getAdFacadeData().getPageNum(), i, this.ikx, com.baidu.tieba.ad.a.a.lA(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.ikq.getAdFacadeData(), 303, this.ikq.getAdFacadeData().getPageNum(), this.bGc ? 0 : 1, this.ikq.video.video_duration.intValue(), 0, -1);
            if (this.ikv != null) {
                this.ikv.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pm(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable fxo = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fxo);
                a.this.rG(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void rG(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = rH(i);
                    bjO();
                    return;
                case 1:
                    this.mCurrentState = rH(i);
                    this.mHandler.removeCallbacks(this.fxo);
                    return;
                case 2:
                    this.mCurrentState = rI(i);
                    return;
                case 3:
                    this.mCurrentState = rJ(i);
                    bjO();
                    return;
                default:
                    this.mCurrentState = rI(i);
                    return;
            }
        }

        private void bjO() {
            this.mHandler.removeCallbacks(this.fxo);
            this.mHandler.postDelayed(this.fxo, 3000L);
        }

        private int rH(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iko.setVisibility(8);
                VideoMiddlePageAdView.this.ikn.setVisibility(8);
                VideoMiddlePageAdView.this.pm(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int rI(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iko.setVisibility(0);
                VideoMiddlePageAdView.this.ikn.setVisibility(0);
                if (VideoMiddlePageAdView.this.fer != null) {
                    VideoMiddlePageAdView.this.fer.bSV();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.ikq.autoPlay) {
                    VideoMiddlePageAdView.this.pm(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int rJ(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iko.setVisibility(0);
                VideoMiddlePageAdView.this.ikn.setVisibility(0);
                VideoMiddlePageAdView.this.pm(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
