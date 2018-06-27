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
import com.baidu.tbadk.core.util.am;
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
    private com.baidu.tieba.frs.aggregation.a Po;
    public TextView ayf;
    private n buL;
    private Animation buy;
    public HeadImageView chg;
    private View dEF;
    private View dEM;
    private View dEN;
    private View dEO;
    private b dEQ;
    private Animation.AnimationListener dES;
    private Animation.AnimationListener dET;
    public FrameLayout dnQ;
    public FrameLayout dnR;
    public TextView dnS;
    public c doe;
    private Animation dom;
    private boolean don;
    private TextView gqA;
    private TextView gqB;
    private ViewGroup gqC;
    private d gqD;
    private e gqE;
    private f gqF;
    private int gqG;
    private View gqx;
    public TextView gqy;
    private VideoMiddlePageAdCard gqz;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dES = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dEM != null) {
                    VideoMiddlePageAdView.this.dEM.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gqx != null) {
                    VideoMiddlePageAdView.this.gqx.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dEM != null) {
                    VideoMiddlePageAdView.this.dEM.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gqx != null) {
                    VideoMiddlePageAdView.this.gqx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dET = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dEM != null) {
                    VideoMiddlePageAdView.this.dEM.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gqx != null) {
                    VideoMiddlePageAdView.this.gqx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dEM != null) {
                    VideoMiddlePageAdView.this.dEM.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gqx != null) {
                    VideoMiddlePageAdView.this.gqx.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.middle_page_video_ad_layout, (ViewGroup) null);
        this.dnQ = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.dEF = this.rootView.findViewById(d.g.card_container);
        this.dnR = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.doe = new c(this.mContext, this.dnR, false);
        this.doe.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gqG = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.doe.mMainView.setOnTouchListener(null);
        this.dnS = (TextView) this.rootView.findViewById(d.g.title);
        this.chg = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.chg.setIsRound(true);
        this.chg.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.chg.setDefaultResource(d.f.icon_default_avatar100);
        this.chg.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gqy = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.ayf = (TextView) this.rootView.findViewById(d.g.user_name);
        this.buL = new n(this.mContext.getPageActivity());
        this.gqA = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.gqB = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.gqC = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.gqD = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.gqC);
        this.gqD.page = 1;
        this.dEM = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.dEN = this.rootView.findViewById(d.g.user_container_foreground);
        this.dEO = this.rootView.findViewById(d.g.title_foreground);
        this.gqx = this.rootView.findViewById(d.g.operate_area_foreground);
        this.dEM.setOnClickListener(this);
        this.dEN.setOnClickListener(this);
        this.dEO.setOnClickListener(this);
        this.gqx.setOnClickListener(this);
        this.dnR.setOnClickListener(this);
        this.dnQ.setOnClickListener(this);
        this.doe.U(this);
        this.dnS.setOnClickListener(this);
        this.chg.setOnClickListener(this);
        this.ayf.setOnClickListener(this);
        this.mWidth = l.ah(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dnQ.setLayoutParams(layoutParams);
        this.dom = new AlphaAnimation(0.0f, 0.7f);
        this.dom.setDuration(500L);
        this.dom.setAnimationListener(this.dET);
        this.buy = new AlphaAnimation(0.7f, 0.0f);
        this.buy.setDuration(500L);
        this.buy.setAnimationListener(this.dES);
        this.doe.blK();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aQw() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.don = this.gqz.autoPlay;
            if (this.doe.blC()) {
                by(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.doe.getCurrentPosition());
            }
            this.doe.stopPlay();
            this.doe.lE(true);
            this.doe.lH(true);
            this.doe.lF(false);
            this.doe.lI(true);
            this.doe.N(false, true);
            this.doe.rI(i);
            this.doe.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void avD() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void avE() {
                }
            });
            this.doe.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void avF() {
                    if (VideoMiddlePageAdView.this.gqz != null && VideoMiddlePageAdView.this.gqz.video != null && VideoMiddlePageAdView.this.gqz.video.video_height.intValue() > VideoMiddlePageAdView.this.gqz.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.doe.N(false, true);
                    } else {
                        VideoMiddlePageAdView.this.doe.N(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gqF != null) {
                        VideoMiddlePageAdView.this.gqF.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.sk(VideoMiddlePageAdView.this.don ? 0 : 1);
                }

                @Override // com.baidu.tieba.play.c.k
                public void avG() {
                }
            });
            this.doe.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fR(boolean z) {
                    VideoMiddlePageAdView.this.doe.bX(VideoMiddlePageAdView.this.gqz.video.video_url, "");
                    VideoMiddlePageAdView.this.sk(1);
                }
            });
            this.doe.lC(false);
            this.doe.getVideoView().setBusiness(this.buL);
            this.doe.aRa();
            this.doe.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void fS(boolean z) {
                    if (!VideoMiddlePageAdView.this.doe.blC()) {
                        VideoMiddlePageAdView.this.dEO.setVisibility(0);
                        VideoMiddlePageAdView.this.dEN.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.dEO.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dEO.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.dEN.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dEN.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lJ(1);
                    } else {
                        if (VideoMiddlePageAdView.this.dEO.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dEO.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.dEN.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dEN.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lJ(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void avH() {
                    VideoMiddlePageAdView.this.lJ(1);
                    if (!VideoMiddlePageAdView.this.doe.blC()) {
                        VideoMiddlePageAdView.this.dEO.setVisibility(0);
                        VideoMiddlePageAdView.this.dEN.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.dEO.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dEO.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.dEN.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dEN.setVisibility(0);
                    }
                }
            });
            this.doe.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.doe.aEd();
                    if (VideoMiddlePageAdView.this.gqE != null) {
                        VideoMiddlePageAdView.this.gqE.bpH();
                    }
                    VideoMiddlePageAdView.this.sl(VideoMiddlePageAdView.this.don ? 0 : 1);
                }
            });
            this.doe.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.sm(VideoMiddlePageAdView.this.don ? 0 : 1);
                    return true;
                }
            });
            this.doe.pr(videoMiddlePageAdCard.video.thumbnail_url);
            this.doe.bW(videoMiddlePageAdCard.video.video_url, "");
            this.doe.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void avI() {
                    VideoMiddlePageAdView.this.bz(1, VideoMiddlePageAdView.this.doe.getCurrentPosition());
                }
            });
            this.doe.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.by(1, VideoMiddlePageAdView.this.doe.getCurrentPosition());
                }
            });
            this.doe.aEd();
            this.doe.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.doe.a(videoMiddlePageAdCard.video.video_url, "", (c.d) null, new Object[0]);
                if (this.gqE != null) {
                    this.gqE.lW(true);
                }
                if (i == 0) {
                    this.dEM.setVisibility(8);
                    this.gqx.setVisibility(8);
                } else {
                    this.dEM.startAnimation(this.buy);
                    this.gqx.startAnimation(this.buy);
                }
                this.dEO.setVisibility(8);
                this.dEN.setVisibility(8);
            } else if (j.jF() && videoMiddlePageAdCard.waitConfirm) {
                this.dEM.startAnimation(this.buy);
                this.gqx.startAnimation(this.buy);
                this.dEO.setVisibility(8);
                this.dEN.setVisibility(8);
            } else {
                this.dEO.setVisibility(0);
                this.dEN.setVisibility(0);
                this.dEM.setVisibility(0);
                this.gqx.setVisibility(0);
            }
        }
    }

    private boolean aAl() {
        try {
            int intValue = this.gqz.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gqz.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dnS.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_i));
        this.gqy.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_i));
        this.gqA.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_i));
        this.gqB.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_i));
        am.i(this.gqB, d.f.btn_rouned_corner_bg_shape);
    }

    private void aAm() {
        if (!aAl()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dnQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dnQ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gqz = videoMiddlePageAdCard;
        aAm();
        this.dnS.setText(videoMiddlePageAdCard.threadTitle);
        this.ayf.setText(videoMiddlePageAdCard.userName);
        this.chg.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.chg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Cb() || VideoMiddlePageAdView.this.gqz == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aP(VideoMiddlePageAdView.this.gqz.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gqy.setText(videoMiddlePageAdCard.tagName);
        this.gqA.setText(videoMiddlePageAdCard.operateData.gom);
        this.gqB.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gqE != null) {
                    VideoMiddlePageAdView.this.gqE.lW(false);
                }
                if (VideoMiddlePageAdView.this.eME != null) {
                    VideoMiddlePageAdView.this.eME.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gqz, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gqE = this.gqD.a(videoMiddlePageAdCard.tailFrame, this.gqE);
        if (this.gqE != null) {
            b(this.gqz.getAdFacadeData());
            this.gqE.setPageContext(this.mContext);
            this.gqE.setTimeoutListener(this);
            this.gqE.a(videoMiddlePageAdCard.tailFrame);
            this.gqE.c(this.gqz);
            this.gqE.bpI();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Po = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Po;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dEQ = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gqF = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void V(View view) {
        this.Po.kA(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        avB();
        if (this.dEM != null) {
            this.dEM.clearAnimation();
        }
        if (this.gqx != null) {
            this.gqx.clearAnimation();
        }
    }

    public void avA() {
        this.doe.stopPlay();
        if (this.dnS != null) {
            this.dnS.setVisibility(0);
        }
    }

    public void avB() {
        if (this.doe != null) {
            this.doe.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(int i) {
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
    public void onClick(View view) {
        if (view == this.dEM && this.dEM.getVisibility() == 0) {
            if (this.dEQ != null) {
                this.dEQ.lK(this.mPosition);
            }
        } else if (view == this.gqx && this.gqx.getVisibility() == 0) {
            if (this.dEQ != null) {
                this.dEQ.lK(this.mPosition);
            }
        } else if (view == this.dEO || view == this.dEN) {
            if (this.dEM.getVisibility() == 0) {
                if (this.dEQ != null) {
                    this.dEQ.lK(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dEO.getVisibility() == 0) {
                this.dEO.setVisibility(8);
            }
            if (this.dEN.getVisibility() == 0) {
                this.dEN.setVisibility(8);
            }
            lJ(0);
        } else if (view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.float_video_container || view.getId() == d.g.title) {
            WebVideoActivity.gnf = new WebVideoActivity.a();
            if (this.gqz.getAdFacadeData() != null) {
                WebVideoActivity.gnf.gnp = this.gqz.getAdFacadeData().ok();
                WebVideoActivity.gnf.gnq = "VIDEO_LIST";
                if (this.gqz.getAdFacadeData().Pa != null) {
                    WebVideoActivity.gnf.mPageNum = this.gqz.getAdFacadeData().Pa.og();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gqz.getScheme(), true, true, true, this.gqz.video.video_url, this.gqz.video.thumbnail_url, 1.7777778f, this.gqG)));
            if (this.eME != null) {
                this.eME.b(0, null);
            }
            if (this.gqE != null) {
                this.gqE.lW(false);
            }
        } else {
            int e = s.e(this.mContext, this.gqz.getScheme());
            if (this.eME != null) {
                this.eME.b(e, null);
            }
            if (this.gqE != null) {
                this.gqE.lW(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        avA();
        by(this.don ? 0 : 1, this.doe.getCurrentPosition());
        this.gqE.lW(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.doe.pausePlay();
            by(this.don ? 0 : 1, this.doe.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.doe.blC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        if (this.gqz != null && this.gqz.video != null && this.gqz.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this.gqz.getAdFacadeData(), 31, this.gqz.getAdFacadeData().getPageNum(), i, this.gqG, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(int i) {
        if (this.gqz != null && this.gqz.video != null && this.gqz.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this.gqz.getAdFacadeData(), 34, this.gqz.getAdFacadeData().getPageNum(), i, this.gqG, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(int i) {
        if (this.gqz != null && this.gqz.video != null && this.gqz.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this.gqz.getAdFacadeData(), 34, this.gqz.getAdFacadeData().getPageNum(), i, this.gqG, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, int i2) {
        if (this.gqz != null && this.gqz.video != null && this.gqz.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this.gqz.getAdFacadeData(), 32, this.gqz.getAdFacadeData().getPageNum(), i, this.gqG, i2, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(int i, int i2) {
        if (this.gqz != null && this.gqz.video != null && this.gqz.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this.gqz.getAdFacadeData(), 33, this.gqz.getAdFacadeData().getPageNum(), i, this.gqG, i2, -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(this.gqz.getAdFacadeData(), 303, this.gqz.getAdFacadeData().getPageNum(), this.don ? 0 : 1, this.gqz.video.video_duration.intValue(), 0, -1);
            if (this.gqE != null) {
                this.gqE.e(a);
            }
        }
    }
}
