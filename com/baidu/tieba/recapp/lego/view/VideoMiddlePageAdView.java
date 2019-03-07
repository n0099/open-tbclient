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
    private com.baidu.tieba.frs.aggregation.a Tw;
    public TextView Zx;
    private Animation aeX;
    private Animation aeY;
    private boolean bGa;
    public HeadImageView dRw;
    private n dbi;
    public FrameLayout fee;
    public FrameLayout fef;
    public TextView feg;
    public c fes;
    private View fwS;
    private View fwY;
    private com.baidu.tieba.frs.videomiddlepage.c fxa;
    private VideoNetworkStateTipView fxd;
    private Animation.AnimationListener fxj;
    private Animation.AnimationListener fxk;
    private d ikA;
    private e ikB;
    private f ikC;
    private int ikD;
    private boolean ikE;
    private boolean ikF;
    private a ikG;
    private View iks;
    private View ikt;
    private View iku;
    public TextView ikv;
    private VideoMiddlePageAdCard ikw;
    private TextView ikx;
    private TextView iky;
    private ViewGroup ikz;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ikE = false;
        this.ikF = true;
        this.fxj = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fwY != null) {
                    VideoMiddlePageAdView.this.fwY.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iks != null) {
                    VideoMiddlePageAdView.this.iks.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fwY != null) {
                    VideoMiddlePageAdView.this.fwY.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iks != null) {
                    VideoMiddlePageAdView.this.iks.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fxk = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fwY != null) {
                    VideoMiddlePageAdView.this.fwY.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iks != null) {
                    VideoMiddlePageAdView.this.iks.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fwY != null) {
                    VideoMiddlePageAdView.this.fwY.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iks != null) {
                    VideoMiddlePageAdView.this.iks.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ikE = false;
        this.ikF = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.fee = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.fwS = this.rootView.findViewById(d.g.card_container);
        this.fef = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.fes = new c((TbPageContext<?>) this.mContext, (View) this.fef, false);
        this.fes.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.ikD = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fes.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void jV(boolean z) {
                if (VideoMiddlePageAdView.this.ikG != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.ikG.rG(0);
                    } else {
                        VideoMiddlePageAdView.this.ikG.rG(1);
                    }
                }
            }
        });
        this.fes.gHW.setOnTouchListener(null);
        this.feg = (TextView) this.rootView.findViewById(d.g.title);
        this.dRw = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.dRw.setIsRound(true);
        this.dRw.setDefaultBgResource(d.C0236d.cp_bg_line_e);
        this.dRw.setDefaultResource(d.f.icon_default_avatar100);
        this.dRw.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ikv = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.Zx = (TextView) this.rootView.findViewById(d.g.user_name);
        this.dbi = new n(this.mContext.getPageActivity());
        this.ikx = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.iky = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.ikz = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.ikA = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.ikz);
        this.ikA.page = 1;
        this.fxd = (VideoNetworkStateTipView) this.rootView.findViewById(d.g.network_state_tip);
        this.fxd.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fxd.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fes.oW(false);
                VideoMiddlePageAdView.this.fxd.cmd();
                if (VideoMiddlePageAdView.this.ikw != null && VideoMiddlePageAdView.this.ikw.video != null) {
                    VideoMiddlePageAdView.this.fes.cf(VideoMiddlePageAdView.this.ikw.video.video_url, "");
                }
            }
        });
        this.fwY = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.ikt = this.rootView.findViewById(d.g.user_container_foreground);
        this.iku = this.rootView.findViewById(d.g.title_foreground);
        this.iks = this.rootView.findViewById(d.g.operate_area_foreground);
        this.fwY.setOnClickListener(this);
        this.ikt.setOnClickListener(this);
        this.iku.setOnClickListener(this);
        this.iks.setOnClickListener(this);
        this.fef.setOnClickListener(this);
        this.fee.setOnClickListener(this);
        this.fes.T(this);
        this.feg.setOnClickListener(this);
        this.dRw.setOnClickListener(this);
        this.Zx.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fee.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fee.setLayoutParams(layoutParams);
        this.aeX = new AlphaAnimation(0.0f, 0.7f);
        this.aeX.setDuration(500L);
        this.aeX.setAnimationListener(this.fxk);
        this.aeY = new AlphaAnimation(0.7f, 0.0f);
        this.aeY.setDuration(500L);
        this.aeY.setAnimationListener(this.fxj);
        this.rootView.setOnClickListener(this);
        this.ikG = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bGa = this.ikw.autoPlay;
            this.ikE = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.ikD = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fes.ql()) {
                cb(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fes.getCurrentPosition());
                this.ikF = true;
            }
            this.fes.stopPlay();
            this.fes.setIsNeedRecoveryVideoPlayer(true);
            this.fes.oX(true);
            this.fes.oT(false);
            this.fes.oY(true);
            this.fes.ae(false, true);
            this.fes.xm(i);
            this.fes.a(new c.InterfaceC0294c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0294c
                public void qj() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0294c
                public void qk() {
                }
            });
            this.fes.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void beP() {
                    if (VideoMiddlePageAdView.this.ikw != null && VideoMiddlePageAdView.this.ikw.video != null && VideoMiddlePageAdView.this.ikw.video.video_height.intValue() > VideoMiddlePageAdView.this.ikw.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fes.ae(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fes.ae(false, true);
                    }
                    if (VideoMiddlePageAdView.this.ikC != null) {
                        VideoMiddlePageAdView.this.ikC.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.xT(VideoMiddlePageAdView.this.bGa ? 0 : 1);
                    VideoMiddlePageAdView.this.ikE = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void beQ() {
                }
            });
            this.fes.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z) {
                    VideoMiddlePageAdView.this.fes.cf(VideoMiddlePageAdView.this.ikw.video.video_url, "");
                    if (VideoMiddlePageAdView.this.ikC != null) {
                        VideoMiddlePageAdView.this.ikC.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.xT(1);
                    VideoMiddlePageAdView.this.ikE = false;
                }
            });
            this.fes.oP(false);
            this.fes.getVideoView().setBusiness(this.dbi);
            this.fes.bAG();
            this.fes.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.fes.bnQ();
                    if (VideoMiddlePageAdView.this.ikB != null) {
                        VideoMiddlePageAdView.this.ikB.bXF();
                    }
                    VideoMiddlePageAdView.this.xU(VideoMiddlePageAdView.this.bGa ? 0 : 1);
                    VideoMiddlePageAdView.this.ikF = true;
                }
            });
            this.fes.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.xV(VideoMiddlePageAdView.this.bGa ? 0 : 1);
                    return true;
                }
            });
            this.fes.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fes.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fes.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void beS() {
                    VideoMiddlePageAdView.this.cc(1, VideoMiddlePageAdView.this.fes.getCurrentPosition());
                }
            });
            this.fes.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cb(1, VideoMiddlePageAdView.this.fes.getCurrentPosition());
                    VideoMiddlePageAdView.this.ikF = true;
                }
            });
            this.fes.bnQ();
            this.fes.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fxd.bUl()) {
                    this.fes.oV(false);
                    this.fxd.cmc();
                    this.fes.oW(true);
                    this.fes.dC(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fes.oW(false);
                    this.fes.oV(false);
                    this.fxd.hide();
                    this.fes.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.ikB != null) {
                    this.ikB.pp(true);
                }
                if (i == 0) {
                    this.fwY.setVisibility(8);
                    this.iks.setVisibility(8);
                } else {
                    this.fwY.startAnimation(this.aeY);
                    this.iks.startAnimation(this.aeY);
                }
                if (i == 0) {
                    this.ikG.rG(3);
                    return;
                } else {
                    this.ikG.rG(0);
                    return;
                }
            }
            this.fxd.hide();
            this.fes.oV(true);
            this.ikG.rG(3);
            if (j.la() && videoMiddlePageAdCard.waitConfirm) {
                this.fwY.startAnimation(this.aeY);
                this.iks.startAnimation(this.aeY);
                return;
            }
            this.fwY.setVisibility(0);
            this.iks.setVisibility(0);
        }
    }

    private boolean bjD() {
        try {
            int intValue = this.ikw.video.video_width.intValue();
            return intValue <= 0 || ((float) this.ikw.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.feg.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_i_alpha70));
        this.ikv.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_i_alpha70));
        this.ikx.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_i_alpha70));
        this.iky.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_i_alpha70));
        al.k(this.iky, d.f.btn_rouned_corner_bg_shape);
    }

    private void bjE() {
        if (!bjD()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fee.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fee.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fee.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fee.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.ikw = videoMiddlePageAdCard;
        bjE();
        this.feg.setText(videoMiddlePageAdCard.threadTitle);
        this.Zx.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.dRw.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.dRw.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.dRw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.age() || VideoMiddlePageAdView.this.ikw == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(VideoMiddlePageAdView.this.ikw.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.ikv.setText(videoMiddlePageAdCard.tagName);
        this.ikx.setText(videoMiddlePageAdCard.operateData.iij);
        this.iky.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int f = s.f(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.ikB != null) {
                    VideoMiddlePageAdView.this.ikB.pp(false);
                }
                if (VideoMiddlePageAdView.this.gHy != null) {
                    VideoMiddlePageAdView.this.gHy.b(f, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.ikw, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.ikB = this.ikA.a(videoMiddlePageAdCard.tailFrame, this.ikB);
        if (this.ikB != null) {
            b(this.ikw.getAdFacadeData());
            this.ikB.setPageContext(this.mContext);
            this.ikB.setTimeoutListener(this);
            this.ikB.a(videoMiddlePageAdCard.tailFrame);
            this.ikB.c(this.ikw);
            this.ikB.bXG();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Tw = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Tw;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fxa = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.ikC = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bh(View view) {
        this.Tw.qv(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        beN();
        if (this.fwY != null) {
            this.fwY.clearAnimation();
        }
        if (this.iks != null) {
            this.iks.clearAnimation();
        }
    }

    public void beM() {
        this.fes.stopPlay();
        if (this.feg != null) {
            this.feg.setVisibility(0);
        }
        if (this.ikG != null) {
            this.ikG.rG(2);
        }
        this.ikE = false;
        this.ikF = true;
    }

    public void beN() {
        if (this.fes != null) {
            this.fes.destroy();
        }
        this.ikE = false;
        this.ikF = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwY && this.fwY.getVisibility() == 0) {
            if (this.fxa != null) {
                this.fxa.rK(this.mPosition);
            }
        } else if (view == this.iks && this.iks.getVisibility() == 0) {
            if (this.fxa != null) {
                this.fxa.rK(this.mPosition);
            }
        } else if (view == this.iku || view == this.ikt) {
            if (this.fwY.getVisibility() == 0) {
                if (this.fxa != null) {
                    this.fxa.rK(this.mPosition);
                    return;
                }
                return;
            }
            this.ikG.rG(0);
        } else if (view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.float_video_container || view.getId() == d.g.title) {
            WebVideoActivity.ihd = new WebVideoActivity.a();
            if (this.ikw.getAdFacadeData() != null) {
                WebVideoActivity.ihd.ihn = this.ikw.getAdFacadeData().pR();
                WebVideoActivity.ihd.axH = "DETAIL";
                if (this.ikw.getAdFacadeData().Ti != null) {
                    WebVideoActivity.ihd.mPageNum = this.ikw.getAdFacadeData().Ti.pN();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.ikw.getScheme(), true, true, true, this.ikw.video.video_url, this.ikw.video.thumbnail_url, 1.7777778f, this.ikD)));
            if (this.gHy != null) {
                this.gHy.b(0, null);
            }
            if (this.ikB != null) {
                this.ikB.pp(false);
            }
        } else {
            int f = s.f(this.mContext, this.ikw.getScheme());
            if (this.gHy != null) {
                this.gHy.b(f, null);
            }
            if (this.ikB != null) {
                this.ikB.pp(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.lA(this.fes.getCurrentPosition()) < this.ikD && this.fes.getCurrentState() == 1) {
            cb(this.bGa ? 0 : 1, this.fes.getCurrentPosition());
        }
        beM();
        this.ikB.pp(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.fes.pausePlay();
            cb(this.bGa ? 0 : 1, this.fes.getCurrentPosition());
            this.ikF = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.fes.ql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xT(int i) {
        if (this.ikw != null && this.ikw.video != null && this.ikw.getAdFacadeData() != null && this.ikF) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(this.ikw.getAdFacadeData(), 31, this.ikw.getAdFacadeData().getPageNum(), i, this.ikD, 0, -1));
            this.ikF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(int i) {
        if (this.ikw != null && this.ikw.video != null && this.ikw.getAdFacadeData() != null && !this.ikE) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(this.ikw.getAdFacadeData(), 34, this.ikw.getAdFacadeData().getPageNum(), i, this.ikD, this.ikD, -1));
            this.ikE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xV(int i) {
        if (this.ikw != null && this.ikw.video != null && this.ikw.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(this.ikw.getAdFacadeData(), 36, this.ikw.getAdFacadeData().getPageNum(), i, this.ikD, com.baidu.tieba.ad.a.a.lA(this.fes.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        if (this.ikw != null && this.ikw.video != null && this.ikw.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(this.ikw.getAdFacadeData(), 32, this.ikw.getAdFacadeData().getPageNum(), i, this.ikD, com.baidu.tieba.ad.a.a.lA(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i, int i2) {
        if (this.ikw != null && this.ikw.video != null && this.ikw.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(this.ikw.getAdFacadeData(), 33, this.ikw.getAdFacadeData().getPageNum(), i, this.ikD, com.baidu.tieba.ad.a.a.lA(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.ikw.getAdFacadeData(), 303, this.ikw.getAdFacadeData().getPageNum(), this.bGa ? 0 : 1, this.ikw.video.video_duration.intValue(), 0, -1);
            if (this.ikB != null) {
                this.ikB.e(a2);
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
            customMessage.setExtra("low");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable fxp = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fxp);
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
                    this.mHandler.removeCallbacks(this.fxp);
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
            this.mHandler.removeCallbacks(this.fxp);
            this.mHandler.postDelayed(this.fxp, 3000L);
        }

        private int rH(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iku.setVisibility(8);
                VideoMiddlePageAdView.this.ikt.setVisibility(8);
                VideoMiddlePageAdView.this.pm(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int rI(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iku.setVisibility(0);
                VideoMiddlePageAdView.this.ikt.setVisibility(0);
                if (VideoMiddlePageAdView.this.fes != null) {
                    VideoMiddlePageAdView.this.fes.bSS();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.ikw.autoPlay) {
                    VideoMiddlePageAdView.this.pm(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int rJ(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iku.setVisibility(0);
                VideoMiddlePageAdView.this.ikt.setVisibility(0);
                VideoMiddlePageAdView.this.pm(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
