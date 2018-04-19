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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
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
    private com.baidu.tieba.frs.aggregation.a Jf;
    public TextView apg;
    public HeadImageView bWg;
    private Animation bkE;
    private n bkR;
    public FrameLayout daL;
    public FrameLayout daM;
    public TextView daN;
    public c daY;
    private Animation dbg;
    private boolean dbh;
    private View dqZ;
    private View drg;
    private View drh;
    private View dri;
    private b drk;
    private Animation.AnimationListener drm;
    private Animation.AnimationListener drn;
    private View gal;
    public TextView gam;
    private VideoMiddlePageAdCard gan;
    private TextView gao;
    private TextView gap;
    private ViewGroup gaq;
    private d gar;
    private e gas;
    private f gat;
    private int gau;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.drm = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.drg != null) {
                    VideoMiddlePageAdView.this.drg.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gal != null) {
                    VideoMiddlePageAdView.this.gal.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.drg != null) {
                    VideoMiddlePageAdView.this.drg.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gal != null) {
                    VideoMiddlePageAdView.this.gal.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.drn = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.drg != null) {
                    VideoMiddlePageAdView.this.drg.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gal != null) {
                    VideoMiddlePageAdView.this.gal.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.drg != null) {
                    VideoMiddlePageAdView.this.drg.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gal != null) {
                    VideoMiddlePageAdView.this.gal.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.middle_page_video_ad_layout, (ViewGroup) null);
        this.daL = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.dqZ = this.rootView.findViewById(d.g.card_container);
        this.daM = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.daY = new c(this.adf, this.daM, false);
        this.daY.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gau = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.daY.mMainView.setOnTouchListener(null);
        this.daN = (TextView) this.rootView.findViewById(d.g.title);
        this.bWg = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.bWg.setIsRound(true);
        this.bWg.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.bWg.setDefaultResource(d.f.icon_default_avatar100);
        this.bWg.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gam = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.apg = (TextView) this.rootView.findViewById(d.g.user_name);
        this.bkR = new n(this.adf.getPageActivity());
        this.gao = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.gap = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.gaq = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.gar = new com.baidu.tieba.recapp.e.d(this.adf.getPageActivity(), this.gaq);
        this.gar.page = 1;
        this.drg = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.drh = this.rootView.findViewById(d.g.user_container_foreground);
        this.dri = this.rootView.findViewById(d.g.title_foreground);
        this.gal = this.rootView.findViewById(d.g.operate_area_foreground);
        this.drg.setOnClickListener(this);
        this.drh.setOnClickListener(this);
        this.dri.setOnClickListener(this);
        this.gal.setOnClickListener(this);
        this.daM.setOnClickListener(this);
        this.daL.setOnClickListener(this);
        this.daY.Q(this);
        this.daN.setOnClickListener(this);
        this.bWg.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.mWidth = l.af(this.adf.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.daL.setLayoutParams(layoutParams);
        this.dbg = new AlphaAnimation(0.0f, 0.7f);
        this.dbg.setDuration(500L);
        this.dbg.setAnimationListener(this.drn);
        this.bkE = new AlphaAnimation(0.7f, 0.0f);
        this.bkE.setDuration(500L);
        this.bkE.setAnimationListener(this.drm);
        this.daY.bgi();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dbh = this.gan.autoPlay;
            if (this.daY.bga()) {
                by(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.daY.getCurrentPosition());
            }
            this.daY.stopPlay();
            this.daY.ln(true);
            this.daY.lq(true);
            this.daY.lo(false);
            this.daY.lr(true);
            this.daY.K(false, true);
            this.daY.ro(i);
            this.daY.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                }
            });
            this.daY.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    if (VideoMiddlePageAdView.this.gan != null && VideoMiddlePageAdView.this.gan.video != null && VideoMiddlePageAdView.this.gan.video.video_height.intValue() > VideoMiddlePageAdView.this.gan.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.daY.K(false, true);
                    } else {
                        VideoMiddlePageAdView.this.daY.K(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gat != null) {
                        VideoMiddlePageAdView.this.gat.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.rP(VideoMiddlePageAdView.this.dbh ? 0 : 1);
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqY() {
                }
            });
            this.daY.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fF(boolean z) {
                    VideoMiddlePageAdView.this.daY.bL(VideoMiddlePageAdView.this.gan.video.video_url, "");
                    VideoMiddlePageAdView.this.rP(1);
                }
            });
            this.daY.ll(false);
            this.daY.getVideoView().setBusiness(this.bkR);
            this.daY.aLy();
            this.daY.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (!VideoMiddlePageAdView.this.daY.bga()) {
                        VideoMiddlePageAdView.this.dri.setVisibility(0);
                        VideoMiddlePageAdView.this.drh.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.dri.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dri.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.drh.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.drh.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lw(1);
                    } else {
                        if (VideoMiddlePageAdView.this.dri.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dri.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.drh.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.drh.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lw(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    VideoMiddlePageAdView.this.lw(1);
                    if (!VideoMiddlePageAdView.this.daY.bga()) {
                        VideoMiddlePageAdView.this.dri.setVisibility(0);
                        VideoMiddlePageAdView.this.drh.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.dri.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dri.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.drh.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.drh.setVisibility(0);
                    }
                }
            });
            this.daY.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.daY.ayA();
                    if (VideoMiddlePageAdView.this.gas != null) {
                        VideoMiddlePageAdView.this.gas.bkj();
                    }
                    VideoMiddlePageAdView.this.rQ(VideoMiddlePageAdView.this.dbh ? 0 : 1);
                }
            });
            this.daY.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.rR(VideoMiddlePageAdView.this.dbh ? 0 : 1);
                    return true;
                }
            });
            this.daY.oz(videoMiddlePageAdCard.video.thumbnail_url);
            this.daY.bK(videoMiddlePageAdCard.video.video_url, "");
            this.daY.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void ara() {
                    VideoMiddlePageAdView.this.bz(1, VideoMiddlePageAdView.this.daY.getCurrentPosition());
                }
            });
            this.daY.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.by(1, VideoMiddlePageAdView.this.daY.getCurrentPosition());
                }
            });
            this.daY.ayA();
            this.daY.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.daY.a(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
                if (this.gas != null) {
                    this.gas.lF(true);
                }
                if (i == 0) {
                    this.drg.setVisibility(8);
                    this.gal.setVisibility(8);
                } else {
                    this.drg.startAnimation(this.bkE);
                    this.gal.startAnimation(this.bkE);
                }
                this.dri.setVisibility(8);
                this.drh.setVisibility(8);
            } else if (j.gR() && videoMiddlePageAdCard.waitConfirm) {
                this.drg.startAnimation(this.bkE);
                this.gal.startAnimation(this.bkE);
                this.dri.setVisibility(8);
                this.drh.setVisibility(8);
            } else {
                this.dri.setVisibility(0);
                this.drh.setVisibility(0);
                this.drg.setVisibility(0);
                this.gal.setVisibility(0);
            }
        }
    }

    private boolean avw() {
        try {
            int intValue = this.gan.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gan.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.daN.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        this.gam.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        this.gao.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        this.gap.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        ak.i(this.gap, d.f.btn_rouned_corner_bg_shape);
    }

    private void avx() {
        if (!avw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.daL.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.daL.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gan = videoMiddlePageAdCard;
        avx();
        this.daN.setText(videoMiddlePageAdCard.threadTitle);
        this.apg.setText(videoMiddlePageAdCard.userName);
        this.bWg.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.bWg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.yl() || VideoMiddlePageAdView.this.gan == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aB(VideoMiddlePageAdView.this.gan.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.adf.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gam.setText(videoMiddlePageAdCard.tagName);
        this.gao.setText(videoMiddlePageAdCard.operateData.fYa);
        this.gap.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int e = s.e(VideoMiddlePageAdView.this.adf, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gas != null) {
                    VideoMiddlePageAdView.this.gas.lF(false);
                }
                if (VideoMiddlePageAdView.this.ewm != null) {
                    VideoMiddlePageAdView.this.ewm.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gan, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gas = this.gar.a(videoMiddlePageAdCard.tailFrame, this.gas);
        if (this.gas != null) {
            b(this.gan.getAdFacadeData());
            this.gas.setPageContext(this.adf);
            this.gas.setTimeoutListener(this);
            this.gas.a(videoMiddlePageAdCard.tailFrame);
            this.gas.bkk();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Jf = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Jf;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.drk = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gat = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void U(View view2) {
        this.Jf.kp(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aqT();
        if (this.drg != null) {
            this.drg.clearAnimation();
        }
        if (this.gal != null) {
            this.gal.clearAnimation();
        }
    }

    public void aqS() {
        this.daY.stopPlay();
        if (this.daN != null) {
            this.daN.setVisibility(0);
        }
    }

    public void aqT() {
        if (this.daY != null) {
            this.daY.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra("low");
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.drg && this.drg.getVisibility() == 0) {
            if (this.drk != null) {
                this.drk.lx(this.mPosition);
            }
        } else if (view2 == this.gal && this.gal.getVisibility() == 0) {
            if (this.drk != null) {
                this.drk.lx(this.mPosition);
            }
        } else if (view2 == this.dri || view2 == this.drh) {
            if (this.drg.getVisibility() == 0) {
                if (this.drk != null) {
                    this.drk.lx(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dri.getVisibility() == 0) {
                this.dri.setVisibility(8);
            }
            if (this.drh.getVisibility() == 0) {
                this.drh.setVisibility(8);
            }
            lw(0);
        } else if (view2.getId() == d.g.video_container || view2.getId() == d.g.video_agg_container || view2.getId() == d.g.float_video_container || view2.getId() == d.g.title) {
            WebVideoActivity.fWT = new WebVideoActivity.a();
            if (this.gan.getAdFacadeData() != null) {
                WebVideoActivity.fWT.fXd = this.gan.getAdFacadeData().lv();
                WebVideoActivity.fWT.fXe = "VIDEO_LIST";
                if (this.gan.getAdFacadeData().IQ != null) {
                    WebVideoActivity.fWT.mPageNum = this.gan.getAdFacadeData().IQ.lr();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.adf.getPageActivity(), "", this.gan.getScheme(), true, true, true, this.gan.video.video_url, this.gan.video.thumbnail_url, 1.7777778f, this.gau)));
            if (this.ewm != null) {
                this.ewm.b(0, null);
            }
            if (this.gas != null) {
                this.gas.lF(false);
            }
        } else {
            int e = s.e(this.adf, this.gan.getScheme());
            if (this.ewm != null) {
                this.ewm.b(e, null);
            }
            if (this.gas != null) {
                this.gas.lF(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aqS();
        by(this.dbh ? 0 : 1, this.daY.getCurrentPosition());
        this.gas.lF(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.daY.pausePlay();
            by(this.dbh ? 0 : 1, this.daY.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.daY.bga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        if (this.gan != null && this.gan.video != null && this.gan.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gan.getAdFacadeData(), 31, this.gan.getAdFacadeData().getPageNum(), i, this.gau, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        if (this.gan != null && this.gan.video != null && this.gan.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gan.getAdFacadeData(), 34, this.gan.getAdFacadeData().getPageNum(), i, this.gau, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(int i) {
        if (this.gan != null && this.gan.video != null && this.gan.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gan.getAdFacadeData(), 34, this.gan.getAdFacadeData().getPageNum(), i, this.gau, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, int i2) {
        if (this.gan != null && this.gan.video != null && this.gan.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gan.getAdFacadeData(), 32, this.gan.getAdFacadeData().getPageNum(), i, this.gau, i2, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(int i, int i2) {
        if (this.gan != null && this.gan.video != null && this.gan.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gan.getAdFacadeData(), 33, this.gan.getAdFacadeData().getPageNum(), i, this.gau, i2, -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(this.gan.getAdFacadeData(), 303, this.gan.getAdFacadeData().getPageNum(), this.dbh ? 0 : 1, this.gan.video.video_duration.intValue(), 0, -1);
            if (this.gas != null) {
                this.gas.e(a);
            }
        }
    }
}
