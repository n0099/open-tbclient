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
    private com.baidu.tieba.frs.aggregation.a Se;
    public TextView aFZ;
    private boolean atr;
    private Animation bJD;
    private n bJP;
    public HeadImageView cxi;
    public FrameLayout dEW;
    public FrameLayout dEX;
    public TextView dEY;
    public c dFk;
    private Animation dFr;
    private View dWC;
    private b dWE;
    private Animation.AnimationListener dWI;
    private Animation.AnimationListener dWJ;
    private View dWw;
    private View gGD;
    private View gGE;
    private View gGF;
    public TextView gGG;
    private VideoMiddlePageAdCard gGH;
    private TextView gGI;
    private TextView gGJ;
    private ViewGroup gGK;
    private d gGL;
    private e gGM;
    private f gGN;
    private int gGO;
    private boolean gGP;
    private boolean gGQ;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gGP = false;
        this.gGQ = true;
        this.dWI = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dWC != null) {
                    VideoMiddlePageAdView.this.dWC.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gGE != null) {
                    VideoMiddlePageAdView.this.gGE.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dWC != null) {
                    VideoMiddlePageAdView.this.dWC.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gGE != null) {
                    VideoMiddlePageAdView.this.gGE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dWC != null) {
                    VideoMiddlePageAdView.this.dWC.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gGE != null) {
                    VideoMiddlePageAdView.this.gGE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dWC != null) {
                    VideoMiddlePageAdView.this.dWC.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gGE != null) {
                    VideoMiddlePageAdView.this.gGE.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gGP = false;
        this.gGQ = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dEW = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.dWw = this.rootView.findViewById(e.g.card_container);
        this.dEX = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dFk = new c((TbPageContext<?>) this.mContext, (View) this.dEX, false);
        this.dFk.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gGO = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dFk.ffV.setOnTouchListener(null);
        this.dEY = (TextView) this.rootView.findViewById(e.g.title);
        this.cxi = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.cxi.setIsRound(true);
        this.cxi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cxi.setDefaultResource(e.f.icon_default_avatar100);
        this.cxi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gGG = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aFZ = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bJP = new n(this.mContext.getPageActivity());
        this.gGI = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gGJ = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gGK = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gGL = new d(this.mContext.getPageActivity(), this.gGK);
        this.gGL.page = 1;
        this.dWC = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gGD = this.rootView.findViewById(e.g.user_container_foreground);
        this.gGF = this.rootView.findViewById(e.g.title_foreground);
        this.gGE = this.rootView.findViewById(e.g.operate_area_foreground);
        this.dWC.setOnClickListener(this);
        this.gGD.setOnClickListener(this);
        this.gGF.setOnClickListener(this);
        this.gGE.setOnClickListener(this);
        this.dEX.setOnClickListener(this);
        this.dEW.setOnClickListener(this);
        this.dFk.R(this);
        this.dEY.setOnClickListener(this);
        this.cxi.setOnClickListener(this);
        this.aFZ.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dEW.setLayoutParams(layoutParams);
        this.dFr = new AlphaAnimation(0.0f, 0.7f);
        this.dFr.setDuration(500L);
        this.dFr.setAnimationListener(this.dWJ);
        this.bJD = new AlphaAnimation(0.7f, 0.0f);
        this.bJD.setDuration(500L);
        this.bJD.setAnimationListener(this.dWI);
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWW() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.atr = this.gGH.autoPlay;
            this.gGP = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gGO = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dFk.bpH()) {
                bE(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dFk.getCurrentPosition());
                this.gGQ = true;
            }
            this.dFk.stopPlay();
            this.dFk.setIsNeedRecoveryVideoPlayer(true);
            this.dFk.mi(true);
            this.dFk.me(false);
            this.dFk.mj(true);
            this.dFk.Q(false, true);
            this.dFk.sz(i);
            this.dFk.a(new c.InterfaceC0258c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XD() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XE() {
                }
            });
            this.dFk.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.l
                public void aBN() {
                    if (VideoMiddlePageAdView.this.gGH != null && VideoMiddlePageAdView.this.gGH.video != null && VideoMiddlePageAdView.this.gGH.video.video_height.intValue() > VideoMiddlePageAdView.this.gGH.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dFk.Q(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dFk.Q(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gGN != null) {
                        VideoMiddlePageAdView.this.gGN.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.td(VideoMiddlePageAdView.this.atr ? 0 : 1);
                    VideoMiddlePageAdView.this.gGP = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void aBO() {
                }
            });
            this.dFk.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.f
                public void gI(boolean z) {
                    VideoMiddlePageAdView.this.dFk.aW(VideoMiddlePageAdView.this.gGH.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gGN != null) {
                        VideoMiddlePageAdView.this.gGN.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.td(1);
                    VideoMiddlePageAdView.this.gGP = false;
                }
            });
            this.dFk.mb(false);
            this.dFk.getVideoView().setBusiness(this.bJP);
            this.dFk.aXA();
            this.dFk.b(new c.d() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.d
                public void gJ(boolean z) {
                    if (!VideoMiddlePageAdView.this.dFk.bpH()) {
                        VideoMiddlePageAdView.this.gGF.setVisibility(0);
                        VideoMiddlePageAdView.this.gGD.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.gGF.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gGF.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.gGD.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gGD.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.tc(1);
                    } else {
                        if (VideoMiddlePageAdView.this.gGF.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gGF.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.gGD.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gGD.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.tc(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBP() {
                    VideoMiddlePageAdView.this.tc(1);
                    if (!VideoMiddlePageAdView.this.dFk.bpH()) {
                        VideoMiddlePageAdView.this.gGF.setVisibility(0);
                        VideoMiddlePageAdView.this.gGD.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.gGF.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gGF.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.gGD.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gGD.setVisibility(0);
                    }
                }
            });
            this.dFk.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dFk.aKH();
                    if (VideoMiddlePageAdView.this.gGM != null) {
                        VideoMiddlePageAdView.this.gGM.buj();
                    }
                    VideoMiddlePageAdView.this.te(VideoMiddlePageAdView.this.atr ? 0 : 1);
                    VideoMiddlePageAdView.this.gGQ = true;
                }
            });
            this.dFk.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.tf(VideoMiddlePageAdView.this.atr ? 0 : 1);
                    return true;
                }
            });
            this.dFk.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dFk.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dFk.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void aBQ() {
                    VideoMiddlePageAdView.this.bF(1, VideoMiddlePageAdView.this.dFk.getCurrentPosition());
                }
            });
            this.dFk.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bE(1, VideoMiddlePageAdView.this.dFk.getCurrentPosition());
                    VideoMiddlePageAdView.this.gGQ = true;
                }
            });
            this.dFk.aKH();
            this.dFk.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dFk.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gGM != null) {
                    this.gGM.my(true);
                }
                if (i == 0) {
                    this.dWC.setVisibility(8);
                    this.gGE.setVisibility(8);
                } else {
                    this.dWC.startAnimation(this.bJD);
                    this.gGE.startAnimation(this.bJD);
                }
                this.gGF.setVisibility(8);
                this.gGD.setVisibility(8);
            } else if (j.kZ() && videoMiddlePageAdCard.waitConfirm) {
                this.dWC.startAnimation(this.bJD);
                this.gGE.startAnimation(this.bJD);
                this.gGF.setVisibility(8);
                this.gGD.setVisibility(8);
            } else {
                this.gGF.setVisibility(0);
                this.gGD.setVisibility(0);
                this.dWC.setVisibility(0);
                this.gGE.setVisibility(0);
            }
        }
    }

    private boolean aGr() {
        try {
            int intValue = this.gGH.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gGH.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dEY.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gGG.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gGI.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gGJ.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        al.i(this.gGJ, e.f.btn_rouned_corner_bg_shape);
    }

    private void aGs() {
        if (!aGr()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEW.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dEW.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dEW.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dEW.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gGH = videoMiddlePageAdCard;
        aGs();
        this.dEY.setText(videoMiddlePageAdCard.threadTitle);
        this.aFZ.setText(videoMiddlePageAdCard.userName);
        this.cxi.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.cxi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Fi() || VideoMiddlePageAdView.this.gGH == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(VideoMiddlePageAdView.this.gGH.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gGG.setText(videoMiddlePageAdCard.tagName);
        this.gGI.setText(videoMiddlePageAdCard.operateData.gEs);
        this.gGJ.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gGM != null) {
                    VideoMiddlePageAdView.this.gGM.my(false);
                }
                if (VideoMiddlePageAdView.this.ffx != null) {
                    VideoMiddlePageAdView.this.ffx.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gGH, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gGM = this.gGL.a(videoMiddlePageAdCard.tailFrame, this.gGM);
        if (this.gGM != null) {
            b(this.gGH.getAdFacadeData());
            this.gGM.setPageContext(this.mContext);
            this.gGM.setTimeoutListener(this);
            this.gGM.a(videoMiddlePageAdCard.tailFrame);
            this.gGM.c(this.gGH);
            this.gGM.buk();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Se = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Se;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dWE = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gGN = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void al(View view) {
        this.Se.lL(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aBL();
        if (this.dWC != null) {
            this.dWC.clearAnimation();
        }
        if (this.gGE != null) {
            this.gGE.clearAnimation();
        }
    }

    public void aBK() {
        this.dFk.stopPlay();
        if (this.dEY != null) {
            this.dEY.setVisibility(0);
        }
        this.gGP = false;
        this.gGQ = true;
    }

    public void aBL() {
        if (this.dFk != null) {
            this.dFk.destroy();
        }
        this.gGP = false;
        this.gGQ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
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
        if (view == this.dWC && this.dWC.getVisibility() == 0) {
            if (this.dWE != null) {
                this.dWE.mX(this.mPosition);
            }
        } else if (view == this.gGE && this.gGE.getVisibility() == 0) {
            if (this.dWE != null) {
                this.dWE.mX(this.mPosition);
            }
        } else if (view == this.gGF || view == this.gGD) {
            if (this.dWC.getVisibility() == 0) {
                if (this.dWE != null) {
                    this.dWE.mX(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gGF.getVisibility() == 0) {
                this.gGF.setVisibility(8);
            }
            if (this.gGD.getVisibility() == 0) {
                this.gGD.setVisibility(8);
            }
            tc(0);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gDm = new WebVideoActivity.a();
            if (this.gGH.getAdFacadeData() != null) {
                WebVideoActivity.gDm.gDw = this.gGH.getAdFacadeData().px();
                WebVideoActivity.gDm.mPage = "DETAIL";
                if (this.gGH.getAdFacadeData().RP != null) {
                    WebVideoActivity.gDm.mPageNum = this.gGH.getAdFacadeData().RP.pt();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gGH.getScheme(), true, true, true, this.gGH.video.video_url, this.gGH.video.thumbnail_url, 1.7777778f, this.gGO)));
            if (this.ffx != null) {
                this.ffx.b(0, null);
            }
            if (this.gGM != null) {
                this.gGM.my(false);
            }
        } else {
            int e = s.e(this.mContext, this.gGH.getScheme());
            if (this.ffx != null) {
                this.ffx.b(e, null);
            }
            if (this.gGM != null) {
                this.gGM.my(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.hi(this.dFk.getCurrentPosition()) < this.gGO && this.dFk.getCurrentState() == 1) {
            bE(this.atr ? 0 : 1, this.dFk.getCurrentPosition());
        }
        aBK();
        this.gGM.my(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dFk.pausePlay();
            bE(this.atr ? 0 : 1, this.dFk.getCurrentPosition());
            this.gGQ = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dFk.bpH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.gGH != null && this.gGH.video != null && this.gGH.getAdFacadeData() != null && this.gGQ) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(this.gGH.getAdFacadeData(), 31, this.gGH.getAdFacadeData().getPageNum(), i, this.gGO, 0, -1));
            this.gGQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te(int i) {
        if (this.gGH != null && this.gGH.video != null && this.gGH.getAdFacadeData() != null && !this.gGP) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(this.gGH.getAdFacadeData(), 34, this.gGH.getAdFacadeData().getPageNum(), i, this.gGO, this.gGO, -1));
            this.gGP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(int i) {
        if (this.gGH != null && this.gGH.video != null && this.gGH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(this.gGH.getAdFacadeData(), 36, this.gGH.getAdFacadeData().getPageNum(), i, this.gGO, com.baidu.tieba.ad.a.a.hi(this.dFk.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(int i, int i2) {
        if (this.gGH != null && this.gGH.video != null && this.gGH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(this.gGH.getAdFacadeData(), 32, this.gGH.getAdFacadeData().getPageNum(), i, this.gGO, com.baidu.tieba.ad.a.a.hi(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        if (this.gGH != null && this.gGH.video != null && this.gGH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(this.gGH.getAdFacadeData(), 33, this.gGH.getAdFacadeData().getPageNum(), i, this.gGO, com.baidu.tieba.ad.a.a.hi(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.gGH.getAdFacadeData(), 303, this.gGH.getAdFacadeData().getPageNum(), this.atr ? 0 : 1, this.gGH.video.video_duration.intValue(), 0, -1);
            if (this.gGM != null) {
                this.gGM.e(a);
            }
        }
    }
}
