package com.baidu.tieba.recapp.lego.view;

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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.videomiddlepage.b;
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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, g, i, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Sg;
    public TextView aKp;
    private boolean axE;
    private Animation bOd;
    private n bOp;
    public HeadImageView cCi;
    public FrameLayout dMK;
    public FrameLayout dML;
    public TextView dMM;
    public c dMY;
    private Animation dNf;
    private View eem;
    private View ees;
    private b eeu;
    private Animation.AnimationListener eey;
    private Animation.AnimationListener eez;
    private View gOU;
    private View gOV;
    private View gOW;
    public TextView gOX;
    private VideoMiddlePageAdCard gOY;
    private TextView gOZ;
    private TextView gPa;
    private ViewGroup gPb;
    private d gPc;
    private e gPd;
    private f gPe;
    private int gPf;
    private boolean gPg;
    private boolean gPh;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gPg = false;
        this.gPh = true;
        this.eey = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ees != null) {
                    VideoMiddlePageAdView.this.ees.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gOV != null) {
                    VideoMiddlePageAdView.this.gOV.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ees != null) {
                    VideoMiddlePageAdView.this.ees.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gOV != null) {
                    VideoMiddlePageAdView.this.gOV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eez = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ees != null) {
                    VideoMiddlePageAdView.this.ees.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gOV != null) {
                    VideoMiddlePageAdView.this.gOV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ees != null) {
                    VideoMiddlePageAdView.this.ees.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gOV != null) {
                    VideoMiddlePageAdView.this.gOV.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gPg = false;
        this.gPh = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dMK = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.eem = this.rootView.findViewById(e.g.card_container);
        this.dML = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dMY = new c((TbPageContext<?>) this.mContext, (View) this.dML, false);
        this.dMY.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gPf = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dMY.fog.setOnTouchListener(null);
        this.dMM = (TextView) this.rootView.findViewById(e.g.title);
        this.cCi = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.cCi.setIsRound(true);
        this.cCi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cCi.setDefaultResource(e.f.icon_default_avatar100);
        this.cCi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gOX = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aKp = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bOp = new n(this.mContext.getPageActivity());
        this.gOZ = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gPa = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gPb = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gPc = new d(this.mContext.getPageActivity(), this.gPb);
        this.gPc.page = 1;
        this.ees = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gOU = this.rootView.findViewById(e.g.user_container_foreground);
        this.gOW = this.rootView.findViewById(e.g.title_foreground);
        this.gOV = this.rootView.findViewById(e.g.operate_area_foreground);
        this.ees.setOnClickListener(this);
        this.gOU.setOnClickListener(this);
        this.gOW.setOnClickListener(this);
        this.gOV.setOnClickListener(this);
        this.dML.setOnClickListener(this);
        this.dMK.setOnClickListener(this);
        this.dMY.T(this);
        this.dMM.setOnClickListener(this);
        this.cCi.setOnClickListener(this);
        this.aKp.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dMK.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dMK.setLayoutParams(layoutParams);
        this.dNf = new AlphaAnimation(0.0f, 0.7f);
        this.dNf.setDuration(500L);
        this.dNf.setAnimationListener(this.eez);
        this.bOd = new AlphaAnimation(0.7f, 0.0f);
        this.bOd.setDuration(500L);
        this.bOd.setAnimationListener(this.eey);
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYk() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.axE = this.gOY.autoPlay;
            this.gPg = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gPf = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dMY.bqV()) {
                bE(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dMY.getCurrentPosition());
                this.gPh = true;
            }
            this.dMY.stopPlay();
            this.dMY.setIsNeedRecoveryVideoPlayer(true);
            this.dMY.mw(true);
            this.dMY.ms(false);
            this.dMY.mx(true);
            this.dMY.S(false, true);
            this.dMY.tm(i);
            this.dMY.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YQ() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YR() {
                }
            });
            this.dMY.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.l
                public void aCU() {
                    if (VideoMiddlePageAdView.this.gOY != null && VideoMiddlePageAdView.this.gOY.video != null && VideoMiddlePageAdView.this.gOY.video.video_height.intValue() > VideoMiddlePageAdView.this.gOY.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dMY.S(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dMY.S(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gPe != null) {
                        VideoMiddlePageAdView.this.gPe.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.tQ(VideoMiddlePageAdView.this.axE ? 0 : 1);
                    VideoMiddlePageAdView.this.gPg = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void aCV() {
                }
            });
            this.dMY.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.f
                public void gT(boolean z) {
                    VideoMiddlePageAdView.this.dMY.aZ(VideoMiddlePageAdView.this.gOY.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gPe != null) {
                        VideoMiddlePageAdView.this.gPe.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.tQ(1);
                    VideoMiddlePageAdView.this.gPg = false;
                }
            });
            this.dMY.mp(false);
            this.dMY.getVideoView().setBusiness(this.bOp);
            this.dMY.aYO();
            this.dMY.b(new c.d() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.d
                public void gU(boolean z) {
                    if (!VideoMiddlePageAdView.this.dMY.bqV()) {
                        VideoMiddlePageAdView.this.gOW.setVisibility(0);
                        VideoMiddlePageAdView.this.gOU.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.gOW.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gOW.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.gOU.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gOU.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.tP(1);
                    } else {
                        if (VideoMiddlePageAdView.this.gOW.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gOW.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.gOU.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gOU.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.tP(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aCW() {
                    VideoMiddlePageAdView.this.tP(1);
                    if (!VideoMiddlePageAdView.this.dMY.bqV()) {
                        VideoMiddlePageAdView.this.gOW.setVisibility(0);
                        VideoMiddlePageAdView.this.gOU.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.gOW.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gOW.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.gOU.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gOU.setVisibility(0);
                    }
                }
            });
            this.dMY.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dMY.aLW();
                    if (VideoMiddlePageAdView.this.gPd != null) {
                        VideoMiddlePageAdView.this.gPd.bvx();
                    }
                    VideoMiddlePageAdView.this.tR(VideoMiddlePageAdView.this.axE ? 0 : 1);
                    VideoMiddlePageAdView.this.gPh = true;
                }
            });
            this.dMY.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.tS(VideoMiddlePageAdView.this.axE ? 0 : 1);
                    return true;
                }
            });
            this.dMY.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dMY.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dMY.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void aCX() {
                    VideoMiddlePageAdView.this.bF(1, VideoMiddlePageAdView.this.dMY.getCurrentPosition());
                }
            });
            this.dMY.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bE(1, VideoMiddlePageAdView.this.dMY.getCurrentPosition());
                    VideoMiddlePageAdView.this.gPh = true;
                }
            });
            this.dMY.aLW();
            this.dMY.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dMY.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gPd != null) {
                    this.gPd.mM(true);
                }
                if (i == 0) {
                    this.ees.setVisibility(8);
                    this.gOV.setVisibility(8);
                } else {
                    this.ees.startAnimation(this.bOd);
                    this.gOV.startAnimation(this.bOd);
                }
                this.gOW.setVisibility(8);
                this.gOU.setVisibility(8);
            } else if (j.kX() && videoMiddlePageAdCard.waitConfirm) {
                this.ees.startAnimation(this.bOd);
                this.gOV.startAnimation(this.bOd);
                this.gOW.setVisibility(8);
                this.gOU.setVisibility(8);
            } else {
                this.gOW.setVisibility(0);
                this.gOU.setVisibility(0);
                this.ees.setVisibility(0);
                this.gOV.setVisibility(0);
            }
        }
    }

    private boolean aHB() {
        try {
            int intValue = this.gOY.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gOY.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dMM.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gOX.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gOZ.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gPa.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        al.i(this.gPa, e.f.btn_rouned_corner_bg_shape);
    }

    private void aHC() {
        if (!aHB()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dMK.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dMK.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dMK.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dMK.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gOY = videoMiddlePageAdCard;
        aHC();
        this.dMM.setText(videoMiddlePageAdCard.threadTitle);
        this.aKp.setText(videoMiddlePageAdCard.userName);
        this.cCi.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.cCi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Gx() || VideoMiddlePageAdView.this.gOY == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(VideoMiddlePageAdView.this.gOY.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gOX.setText(videoMiddlePageAdCard.tagName);
        this.gOZ.setText(videoMiddlePageAdCard.operateData.gMJ);
        this.gPa.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gPa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gPd != null) {
                    VideoMiddlePageAdView.this.gPd.mM(false);
                }
                if (VideoMiddlePageAdView.this.fnI != null) {
                    VideoMiddlePageAdView.this.fnI.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gOY, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gPd = this.gPc.a(videoMiddlePageAdCard.tailFrame, this.gPd);
        if (this.gPd != null) {
            b(this.gOY.getAdFacadeData());
            this.gPd.setPageContext(this.mContext);
            this.gPd.setTimeoutListener(this);
            this.gPd.a(videoMiddlePageAdCard.tailFrame);
            this.gPd.c(this.gOY);
            this.gPd.bvy();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Sg = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Sg;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.eeu = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gPe = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ak(View view) {
        this.Sg.mt(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aCS();
        if (this.ees != null) {
            this.ees.clearAnimation();
        }
        if (this.gOV != null) {
            this.gOV.clearAnimation();
        }
    }

    public void aCR() {
        this.dMY.stopPlay();
        if (this.dMM != null) {
            this.dMM.setVisibility(0);
        }
        this.gPg = false;
        this.gPh = true;
    }

    public void aCS() {
        if (this.dMY != null) {
            this.dMY.destroy();
        }
        this.gPg = false;
        this.gPh = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ees && this.ees.getVisibility() == 0) {
            if (this.eeu != null) {
                this.eeu.nF(this.mPosition);
            }
        } else if (view == this.gOV && this.gOV.getVisibility() == 0) {
            if (this.eeu != null) {
                this.eeu.nF(this.mPosition);
            }
        } else if (view == this.gOW || view == this.gOU) {
            if (this.ees.getVisibility() == 0) {
                if (this.eeu != null) {
                    this.eeu.nF(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gOW.getVisibility() == 0) {
                this.gOW.setVisibility(8);
            }
            if (this.gOU.getVisibility() == 0) {
                this.gOU.setVisibility(8);
            }
            tP(0);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gLD = new WebVideoActivity.a();
            if (this.gOY.getAdFacadeData() != null) {
                WebVideoActivity.gLD.gLN = this.gOY.getAdFacadeData().pu();
                WebVideoActivity.gLD.mPage = "DETAIL";
                if (this.gOY.getAdFacadeData().RR != null) {
                    WebVideoActivity.gLD.mPageNum = this.gOY.getAdFacadeData().RR.pq();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gOY.getScheme(), true, true, true, this.gOY.video.video_url, this.gOY.video.thumbnail_url, 1.7777778f, this.gPf)));
            if (this.fnI != null) {
                this.fnI.b(0, null);
            }
            if (this.gPd != null) {
                this.gPd.mM(false);
            }
        } else {
            int e = s.e(this.mContext, this.gOY.getScheme());
            if (this.fnI != null) {
                this.fnI.b(e, null);
            }
            if (this.gPd != null) {
                this.gPd.mM(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.hJ(this.dMY.getCurrentPosition()) < this.gPf && this.dMY.getCurrentState() == 1) {
            bE(this.axE ? 0 : 1, this.dMY.getCurrentPosition());
        }
        aCR();
        this.gPd.mM(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dMY.pausePlay();
            bE(this.axE ? 0 : 1, this.dMY.getCurrentPosition());
            this.gPh = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dMY.bqV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(int i) {
        if (this.gOY != null && this.gOY.video != null && this.gOY.getAdFacadeData() != null && this.gPh) {
            com.baidu.tieba.recapp.report.c.bvt().a(com.baidu.tieba.recapp.report.f.a(this.gOY.getAdFacadeData(), 31, this.gOY.getAdFacadeData().getPageNum(), i, this.gPf, 0, -1));
            this.gPh = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tR(int i) {
        if (this.gOY != null && this.gOY.video != null && this.gOY.getAdFacadeData() != null && !this.gPg) {
            com.baidu.tieba.recapp.report.c.bvt().a(com.baidu.tieba.recapp.report.f.a(this.gOY.getAdFacadeData(), 34, this.gOY.getAdFacadeData().getPageNum(), i, this.gPf, this.gPf, -1));
            this.gPg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(int i) {
        if (this.gOY != null && this.gOY.video != null && this.gOY.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bvt().a(com.baidu.tieba.recapp.report.f.a(this.gOY.getAdFacadeData(), 36, this.gOY.getAdFacadeData().getPageNum(), i, this.gPf, com.baidu.tieba.ad.a.a.hJ(this.dMY.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(int i, int i2) {
        if (this.gOY != null && this.gOY.video != null && this.gOY.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bvt().a(com.baidu.tieba.recapp.report.f.a(this.gOY.getAdFacadeData(), 32, this.gOY.getAdFacadeData().getPageNum(), i, this.gPf, com.baidu.tieba.ad.a.a.hJ(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        if (this.gOY != null && this.gOY.video != null && this.gOY.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bvt().a(com.baidu.tieba.recapp.report.f.a(this.gOY.getAdFacadeData(), 33, this.gOY.getAdFacadeData().getPageNum(), i, this.gPf, com.baidu.tieba.ad.a.a.hJ(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.gOY.getAdFacadeData(), 303, this.gOY.getAdFacadeData().getPageNum(), this.axE ? 0 : 1, this.gOY.video.video_duration.intValue(), 0, -1);
            if (this.gPd != null) {
                this.gPd.e(a);
            }
        }
    }
}
