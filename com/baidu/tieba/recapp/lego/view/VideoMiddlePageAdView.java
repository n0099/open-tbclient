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
    public HeadImageView bWd;
    private Animation bkE;
    private n bkR;
    public FrameLayout daI;
    public FrameLayout daJ;
    public TextView daK;
    public c daV;
    private Animation dbd;
    private boolean dbe;
    private View dqW;
    private View drd;
    private View dre;
    private View drf;
    private b drh;
    private Animation.AnimationListener drj;
    private Animation.AnimationListener drk;
    private View gai;
    public TextView gaj;
    private VideoMiddlePageAdCard gak;
    private TextView gal;
    private TextView gam;
    private ViewGroup gan;
    private d gao;
    private e gap;
    private f gaq;
    private int gar;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.drj = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.drd != null) {
                    VideoMiddlePageAdView.this.drd.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gai != null) {
                    VideoMiddlePageAdView.this.gai.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.drd != null) {
                    VideoMiddlePageAdView.this.drd.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gai != null) {
                    VideoMiddlePageAdView.this.gai.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.drk = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.drd != null) {
                    VideoMiddlePageAdView.this.drd.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gai != null) {
                    VideoMiddlePageAdView.this.gai.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.drd != null) {
                    VideoMiddlePageAdView.this.drd.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gai != null) {
                    VideoMiddlePageAdView.this.gai.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.middle_page_video_ad_layout, (ViewGroup) null);
        this.daI = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.dqW = this.rootView.findViewById(d.g.card_container);
        this.daJ = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.daV = new c(this.adf, this.daJ, false);
        this.daV.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gar = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.daV.mMainView.setOnTouchListener(null);
        this.daK = (TextView) this.rootView.findViewById(d.g.title);
        this.bWd = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.bWd.setIsRound(true);
        this.bWd.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.bWd.setDefaultResource(d.f.icon_default_avatar100);
        this.bWd.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gaj = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.apg = (TextView) this.rootView.findViewById(d.g.user_name);
        this.bkR = new n(this.adf.getPageActivity());
        this.gal = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.gam = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.gan = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.gao = new com.baidu.tieba.recapp.e.d(this.adf.getPageActivity(), this.gan);
        this.gao.page = 1;
        this.drd = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.dre = this.rootView.findViewById(d.g.user_container_foreground);
        this.drf = this.rootView.findViewById(d.g.title_foreground);
        this.gai = this.rootView.findViewById(d.g.operate_area_foreground);
        this.drd.setOnClickListener(this);
        this.dre.setOnClickListener(this);
        this.drf.setOnClickListener(this);
        this.gai.setOnClickListener(this);
        this.daJ.setOnClickListener(this);
        this.daI.setOnClickListener(this);
        this.daV.Q(this);
        this.daK.setOnClickListener(this);
        this.bWd.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.mWidth = l.af(this.adf.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.daI.setLayoutParams(layoutParams);
        this.dbd = new AlphaAnimation(0.0f, 0.7f);
        this.dbd.setDuration(500L);
        this.dbd.setAnimationListener(this.drk);
        this.bkE = new AlphaAnimation(0.7f, 0.0f);
        this.bkE.setDuration(500L);
        this.bkE.setAnimationListener(this.drj);
        this.daV.bgi();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dbe = this.gak.autoPlay;
            if (this.daV.bga()) {
                bx(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.daV.getCurrentPosition());
            }
            this.daV.stopPlay();
            this.daV.ln(true);
            this.daV.lq(true);
            this.daV.lo(false);
            this.daV.lr(true);
            this.daV.K(false, true);
            this.daV.ro(i);
            this.daV.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                }
            });
            this.daV.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    if (VideoMiddlePageAdView.this.gak != null && VideoMiddlePageAdView.this.gak.video != null && VideoMiddlePageAdView.this.gak.video.video_height.intValue() > VideoMiddlePageAdView.this.gak.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.daV.K(false, true);
                    } else {
                        VideoMiddlePageAdView.this.daV.K(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gaq != null) {
                        VideoMiddlePageAdView.this.gaq.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.rP(VideoMiddlePageAdView.this.dbe ? 0 : 1);
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqY() {
                }
            });
            this.daV.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fF(boolean z) {
                    VideoMiddlePageAdView.this.daV.bL(VideoMiddlePageAdView.this.gak.video.video_url, "");
                    VideoMiddlePageAdView.this.rP(1);
                }
            });
            this.daV.ll(false);
            this.daV.getVideoView().setBusiness(this.bkR);
            this.daV.aLy();
            this.daV.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (!VideoMiddlePageAdView.this.daV.bga()) {
                        VideoMiddlePageAdView.this.drf.setVisibility(0);
                        VideoMiddlePageAdView.this.dre.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.drf.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.drf.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.dre.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dre.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lw(1);
                    } else {
                        if (VideoMiddlePageAdView.this.drf.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.drf.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.dre.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dre.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lw(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    VideoMiddlePageAdView.this.lw(1);
                    if (!VideoMiddlePageAdView.this.daV.bga()) {
                        VideoMiddlePageAdView.this.drf.setVisibility(0);
                        VideoMiddlePageAdView.this.dre.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.drf.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.drf.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.dre.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dre.setVisibility(0);
                    }
                }
            });
            this.daV.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.daV.ayA();
                    if (VideoMiddlePageAdView.this.gap != null) {
                        VideoMiddlePageAdView.this.gap.bkj();
                    }
                    VideoMiddlePageAdView.this.rQ(VideoMiddlePageAdView.this.dbe ? 0 : 1);
                }
            });
            this.daV.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.rR(VideoMiddlePageAdView.this.dbe ? 0 : 1);
                    return true;
                }
            });
            this.daV.oz(videoMiddlePageAdCard.video.thumbnail_url);
            this.daV.bK(videoMiddlePageAdCard.video.video_url, "");
            this.daV.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void ara() {
                    VideoMiddlePageAdView.this.by(1, VideoMiddlePageAdView.this.daV.getCurrentPosition());
                }
            });
            this.daV.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.bx(1, VideoMiddlePageAdView.this.daV.getCurrentPosition());
                }
            });
            this.daV.ayA();
            this.daV.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.daV.a(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
                if (this.gap != null) {
                    this.gap.lF(true);
                }
                if (i == 0) {
                    this.drd.setVisibility(8);
                    this.gai.setVisibility(8);
                } else {
                    this.drd.startAnimation(this.bkE);
                    this.gai.startAnimation(this.bkE);
                }
                this.drf.setVisibility(8);
                this.dre.setVisibility(8);
            } else if (j.gR() && videoMiddlePageAdCard.waitConfirm) {
                this.drd.startAnimation(this.bkE);
                this.gai.startAnimation(this.bkE);
                this.drf.setVisibility(8);
                this.dre.setVisibility(8);
            } else {
                this.drf.setVisibility(0);
                this.dre.setVisibility(0);
                this.drd.setVisibility(0);
                this.gai.setVisibility(0);
            }
        }
    }

    private boolean avw() {
        try {
            int intValue = this.gak.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gak.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.daK.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        this.gaj.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        this.gal.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        this.gam.setTextColor(this.adf.getResources().getColor(d.C0126d.cp_cont_i));
        ak.i(this.gam, d.f.btn_rouned_corner_bg_shape);
    }

    private void avx() {
        if (!avw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.daI.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.daI.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gak = videoMiddlePageAdCard;
        avx();
        this.daK.setText(videoMiddlePageAdCard.threadTitle);
        this.apg.setText(videoMiddlePageAdCard.userName);
        this.bWd.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.bWd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.yl() || VideoMiddlePageAdView.this.gak == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aB(VideoMiddlePageAdView.this.gak.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.adf.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gaj.setText(videoMiddlePageAdCard.tagName);
        this.gal.setText(videoMiddlePageAdCard.operateData.fXX);
        this.gam.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gam.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int e = s.e(VideoMiddlePageAdView.this.adf, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gap != null) {
                    VideoMiddlePageAdView.this.gap.lF(false);
                }
                if (VideoMiddlePageAdView.this.ewj != null) {
                    VideoMiddlePageAdView.this.ewj.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gak, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gap = this.gao.a(videoMiddlePageAdCard.tailFrame, this.gap);
        if (this.gap != null) {
            b(this.gak.getAdFacadeData());
            this.gap.setPageContext(this.adf);
            this.gap.setTimeoutListener(this);
            this.gap.a(videoMiddlePageAdCard.tailFrame);
            this.gap.bkk();
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
        this.drh = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gaq = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void U(View view2) {
        this.Jf.kp(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aqT();
        if (this.drd != null) {
            this.drd.clearAnimation();
        }
        if (this.gai != null) {
            this.gai.clearAnimation();
        }
    }

    public void aqS() {
        this.daV.stopPlay();
        if (this.daK != null) {
            this.daK.setVisibility(0);
        }
    }

    public void aqT() {
        if (this.daV != null) {
            this.daV.destroy();
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
        if (view2 == this.drd && this.drd.getVisibility() == 0) {
            if (this.drh != null) {
                this.drh.lx(this.mPosition);
            }
        } else if (view2 == this.gai && this.gai.getVisibility() == 0) {
            if (this.drh != null) {
                this.drh.lx(this.mPosition);
            }
        } else if (view2 == this.drf || view2 == this.dre) {
            if (this.drd.getVisibility() == 0) {
                if (this.drh != null) {
                    this.drh.lx(this.mPosition);
                    return;
                }
                return;
            }
            if (this.drf.getVisibility() == 0) {
                this.drf.setVisibility(8);
            }
            if (this.dre.getVisibility() == 0) {
                this.dre.setVisibility(8);
            }
            lw(0);
        } else if (view2.getId() == d.g.video_container || view2.getId() == d.g.video_agg_container || view2.getId() == d.g.float_video_container || view2.getId() == d.g.title) {
            WebVideoActivity.fWQ = new WebVideoActivity.a();
            if (this.gak.getAdFacadeData() != null) {
                WebVideoActivity.fWQ.fXa = this.gak.getAdFacadeData().lv();
                WebVideoActivity.fWQ.fXb = "VIDEO_LIST";
                if (this.gak.getAdFacadeData().IQ != null) {
                    WebVideoActivity.fWQ.mPageNum = this.gak.getAdFacadeData().IQ.lr();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.adf.getPageActivity(), "", this.gak.getScheme(), true, true, true, this.gak.video.video_url, this.gak.video.thumbnail_url, 1.7777778f, this.gar)));
            if (this.ewj != null) {
                this.ewj.b(0, null);
            }
            if (this.gap != null) {
                this.gap.lF(false);
            }
        } else {
            int e = s.e(this.adf, this.gak.getScheme());
            if (this.ewj != null) {
                this.ewj.b(e, null);
            }
            if (this.gap != null) {
                this.gap.lF(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aqS();
        bx(this.dbe ? 0 : 1, this.daV.getCurrentPosition());
        this.gap.lF(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.daV.pausePlay();
            bx(this.dbe ? 0 : 1, this.daV.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.daV.bga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        if (this.gak != null && this.gak.video != null && this.gak.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gak.getAdFacadeData(), 31, this.gak.getAdFacadeData().getPageNum(), i, this.gar, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        if (this.gak != null && this.gak.video != null && this.gak.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gak.getAdFacadeData(), 34, this.gak.getAdFacadeData().getPageNum(), i, this.gar, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(int i) {
        if (this.gak != null && this.gak.video != null && this.gak.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gak.getAdFacadeData(), 34, this.gak.getAdFacadeData().getPageNum(), i, this.gar, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, int i2) {
        if (this.gak != null && this.gak.video != null && this.gak.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gak.getAdFacadeData(), 32, this.gak.getAdFacadeData().getPageNum(), i, this.gar, i2, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, int i2) {
        if (this.gak != null && this.gak.video != null && this.gak.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gak.getAdFacadeData(), 33, this.gak.getAdFacadeData().getPageNum(), i, this.gar, i2, -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(this.gak.getAdFacadeData(), 303, this.gak.getAdFacadeData().getPageNum(), this.dbe ? 0 : 1, this.gak.video.video_duration.intValue(), 0, -1);
            if (this.gap != null) {
                this.gap.e(a);
            }
        }
    }
}
