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
    private com.baidu.tieba.frs.aggregation.a Jb;
    public TextView apg;
    public HeadImageView bWT;
    private Animation bkT;
    private n blg;
    public FrameLayout dbP;
    public FrameLayout dbQ;
    public TextView dbR;
    public c dcc;
    private Animation dck;
    private boolean dcl;
    private View dse;
    private View dsl;
    private View dsm;
    private View dsn;
    private b dsp;
    private Animation.AnimationListener dsr;
    private Animation.AnimationListener dss;
    private View gbo;
    public TextView gbp;
    private VideoMiddlePageAdCard gbq;
    private TextView gbr;
    private TextView gbs;
    private ViewGroup gbt;
    private d gbu;
    private e gbv;
    private f gbw;
    private int gbx;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dsr = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dsl != null) {
                    VideoMiddlePageAdView.this.dsl.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gbo != null) {
                    VideoMiddlePageAdView.this.gbo.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dsl != null) {
                    VideoMiddlePageAdView.this.dsl.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gbo != null) {
                    VideoMiddlePageAdView.this.gbo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dss = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dsl != null) {
                    VideoMiddlePageAdView.this.dsl.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gbo != null) {
                    VideoMiddlePageAdView.this.gbo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dsl != null) {
                    VideoMiddlePageAdView.this.dsl.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gbo != null) {
                    VideoMiddlePageAdView.this.gbo.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.middle_page_video_ad_layout, (ViewGroup) null);
        this.dbP = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.dse = this.rootView.findViewById(d.g.card_container);
        this.dbQ = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.dcc = new c(this.mContext, this.dbQ, false);
        this.dcc.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gbx = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dcc.mMainView.setOnTouchListener(null);
        this.dbR = (TextView) this.rootView.findViewById(d.g.title);
        this.bWT = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.bWT.setIsRound(true);
        this.bWT.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.bWT.setDefaultResource(d.f.icon_default_avatar100);
        this.bWT.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gbp = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.apg = (TextView) this.rootView.findViewById(d.g.user_name);
        this.blg = new n(this.mContext.getPageActivity());
        this.gbr = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.gbs = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.gbt = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.gbu = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.gbt);
        this.gbu.page = 1;
        this.dsl = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.dsm = this.rootView.findViewById(d.g.user_container_foreground);
        this.dsn = this.rootView.findViewById(d.g.title_foreground);
        this.gbo = this.rootView.findViewById(d.g.operate_area_foreground);
        this.dsl.setOnClickListener(this);
        this.dsm.setOnClickListener(this);
        this.dsn.setOnClickListener(this);
        this.gbo.setOnClickListener(this);
        this.dbQ.setOnClickListener(this);
        this.dbP.setOnClickListener(this);
        this.dcc.Q(this);
        this.dbR.setOnClickListener(this);
        this.bWT.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dbP.setLayoutParams(layoutParams);
        this.dck = new AlphaAnimation(0.0f, 0.7f);
        this.dck.setDuration(500L);
        this.dck.setAnimationListener(this.dss);
        this.bkT = new AlphaAnimation(0.7f, 0.0f);
        this.bkT.setDuration(500L);
        this.bkT.setAnimationListener(this.dsr);
        this.dcc.bgi();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKT() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dcl = this.gbq.autoPlay;
            if (this.dcc.bga()) {
                bx(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dcc.getCurrentPosition());
            }
            this.dcc.stopPlay();
            this.dcc.lo(true);
            this.dcc.lr(true);
            this.dcc.lp(false);
            this.dcc.ls(true);
            this.dcc.K(false, true);
            this.dcc.rn(i);
            this.dcc.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void aqU() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                }
            });
            this.dcc.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void aqW() {
                    if (VideoMiddlePageAdView.this.gbq != null && VideoMiddlePageAdView.this.gbq.video != null && VideoMiddlePageAdView.this.gbq.video.video_height.intValue() > VideoMiddlePageAdView.this.gbq.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dcc.K(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dcc.K(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gbw != null) {
                        VideoMiddlePageAdView.this.gbw.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.rO(VideoMiddlePageAdView.this.dcl ? 0 : 1);
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                }
            });
            this.dcc.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fG(boolean z) {
                    VideoMiddlePageAdView.this.dcc.bL(VideoMiddlePageAdView.this.gbq.video.video_url, "");
                    VideoMiddlePageAdView.this.rO(1);
                }
            });
            this.dcc.lm(false);
            this.dcc.getVideoView().setBusiness(this.blg);
            this.dcc.aLx();
            this.dcc.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fH(boolean z) {
                    if (!VideoMiddlePageAdView.this.dcc.bga()) {
                        VideoMiddlePageAdView.this.dsn.setVisibility(0);
                        VideoMiddlePageAdView.this.dsm.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.dsn.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dsn.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.dsm.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dsm.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lv(1);
                    } else {
                        if (VideoMiddlePageAdView.this.dsn.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dsn.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.dsm.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dsm.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lv(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqY() {
                    VideoMiddlePageAdView.this.lv(1);
                    if (!VideoMiddlePageAdView.this.dcc.bga()) {
                        VideoMiddlePageAdView.this.dsn.setVisibility(0);
                        VideoMiddlePageAdView.this.dsm.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.dsn.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dsn.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.dsm.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dsm.setVisibility(0);
                    }
                }
            });
            this.dcc.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dcc.ayy();
                    if (VideoMiddlePageAdView.this.gbv != null) {
                        VideoMiddlePageAdView.this.gbv.bki();
                    }
                    VideoMiddlePageAdView.this.rP(VideoMiddlePageAdView.this.dcl ? 0 : 1);
                }
            });
            this.dcc.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.rQ(VideoMiddlePageAdView.this.dcl ? 0 : 1);
                    return true;
                }
            });
            this.dcc.oC(videoMiddlePageAdCard.video.thumbnail_url);
            this.dcc.bK(videoMiddlePageAdCard.video.video_url, "");
            this.dcc.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void aqZ() {
                    VideoMiddlePageAdView.this.by(1, VideoMiddlePageAdView.this.dcc.getCurrentPosition());
                }
            });
            this.dcc.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.bx(1, VideoMiddlePageAdView.this.dcc.getCurrentPosition());
                }
            });
            this.dcc.ayy();
            this.dcc.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dcc.a(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
                if (this.gbv != null) {
                    this.gbv.lG(true);
                }
                if (i == 0) {
                    this.dsl.setVisibility(8);
                    this.gbo.setVisibility(8);
                } else {
                    this.dsl.startAnimation(this.bkT);
                    this.gbo.startAnimation(this.bkT);
                }
                this.dsn.setVisibility(8);
                this.dsm.setVisibility(8);
            } else if (j.gR() && videoMiddlePageAdCard.waitConfirm) {
                this.dsl.startAnimation(this.bkT);
                this.gbo.startAnimation(this.bkT);
                this.dsn.setVisibility(8);
                this.dsm.setVisibility(8);
            } else {
                this.dsn.setVisibility(0);
                this.dsm.setVisibility(0);
                this.dsl.setVisibility(0);
                this.gbo.setVisibility(0);
            }
        }
    }

    private boolean avv() {
        try {
            int intValue = this.gbq.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gbq.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dbR.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_i));
        this.gbp.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_i));
        this.gbr.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_i));
        this.gbs.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_i));
        ak.i(this.gbs, d.f.btn_rouned_corner_bg_shape);
    }

    private void avw() {
        if (!avv()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dbP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dbP.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gbq = videoMiddlePageAdCard;
        avw();
        this.dbR.setText(videoMiddlePageAdCard.threadTitle);
        this.apg.setText(videoMiddlePageAdCard.userName);
        this.bWT.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.bWT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.yk() || VideoMiddlePageAdView.this.gbq == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aB(VideoMiddlePageAdView.this.gbq.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gbp.setText(videoMiddlePageAdCard.tagName);
        this.gbr.setText(videoMiddlePageAdCard.operateData.fZd);
        this.gbs.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gbv != null) {
                    VideoMiddlePageAdView.this.gbv.lG(false);
                }
                if (VideoMiddlePageAdView.this.exr != null) {
                    VideoMiddlePageAdView.this.exr.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gbq, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gbv = this.gbu.a(videoMiddlePageAdCard.tailFrame, this.gbv);
        if (this.gbv != null) {
            b(this.gbq.getAdFacadeData());
            this.gbv.setPageContext(this.mContext);
            this.gbv.setTimeoutListener(this);
            this.gbv.a(videoMiddlePageAdCard.tailFrame);
            this.gbv.bkj();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Jb = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Jb;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dsp = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gbw = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void U(View view2) {
        this.Jb.ko(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aqS();
        if (this.dsl != null) {
            this.dsl.clearAnimation();
        }
        if (this.gbo != null) {
            this.gbo.clearAnimation();
        }
    }

    public void aqR() {
        this.dcc.stopPlay();
        if (this.dbR != null) {
            this.dbR.setVisibility(0);
        }
    }

    public void aqS() {
        if (this.dcc != null) {
            this.dcc.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(int i) {
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
        if (view2 == this.dsl && this.dsl.getVisibility() == 0) {
            if (this.dsp != null) {
                this.dsp.lw(this.mPosition);
            }
        } else if (view2 == this.gbo && this.gbo.getVisibility() == 0) {
            if (this.dsp != null) {
                this.dsp.lw(this.mPosition);
            }
        } else if (view2 == this.dsn || view2 == this.dsm) {
            if (this.dsl.getVisibility() == 0) {
                if (this.dsp != null) {
                    this.dsp.lw(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dsn.getVisibility() == 0) {
                this.dsn.setVisibility(8);
            }
            if (this.dsm.getVisibility() == 0) {
                this.dsm.setVisibility(8);
            }
            lv(0);
        } else if (view2.getId() == d.g.video_container || view2.getId() == d.g.video_agg_container || view2.getId() == d.g.float_video_container || view2.getId() == d.g.title) {
            WebVideoActivity.fXW = new WebVideoActivity.a();
            if (this.gbq.getAdFacadeData() != null) {
                WebVideoActivity.fXW.fYg = this.gbq.getAdFacadeData().lu();
                WebVideoActivity.fXW.fYh = "VIDEO_LIST";
                if (this.gbq.getAdFacadeData().IL != null) {
                    WebVideoActivity.fXW.mPageNum = this.gbq.getAdFacadeData().IL.lq();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gbq.getScheme(), true, true, true, this.gbq.video.video_url, this.gbq.video.thumbnail_url, 1.7777778f, this.gbx)));
            if (this.exr != null) {
                this.exr.b(0, null);
            }
            if (this.gbv != null) {
                this.gbv.lG(false);
            }
        } else {
            int e = s.e(this.mContext, this.gbq.getScheme());
            if (this.exr != null) {
                this.exr.b(e, null);
            }
            if (this.gbv != null) {
                this.gbv.lG(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aqR();
        bx(this.dcl ? 0 : 1, this.dcc.getCurrentPosition());
        this.gbv.lG(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dcc.pausePlay();
            bx(this.dcl ? 0 : 1, this.dcc.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dcc.bga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(int i) {
        if (this.gbq != null && this.gbq.video != null && this.gbq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(this.gbq.getAdFacadeData(), 31, this.gbq.getAdFacadeData().getPageNum(), i, this.gbx, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        if (this.gbq != null && this.gbq.video != null && this.gbq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(this.gbq.getAdFacadeData(), 34, this.gbq.getAdFacadeData().getPageNum(), i, this.gbx, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        if (this.gbq != null && this.gbq.video != null && this.gbq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(this.gbq.getAdFacadeData(), 34, this.gbq.getAdFacadeData().getPageNum(), i, this.gbx, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, int i2) {
        if (this.gbq != null && this.gbq.video != null && this.gbq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(this.gbq.getAdFacadeData(), 32, this.gbq.getAdFacadeData().getPageNum(), i, this.gbx, i2, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, int i2) {
        if (this.gbq != null && this.gbq.video != null && this.gbq.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(this.gbq.getAdFacadeData(), 33, this.gbq.getAdFacadeData().getPageNum(), i, this.gbx, i2, -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(this.gbq.getAdFacadeData(), 303, this.gbq.getAdFacadeData().getPageNum(), this.dcl ? 0 : 1, this.gbq.video.video_duration.intValue(), 0, -1);
            if (this.gbv != null) {
                this.gbv.e(a);
            }
        }
    }
}
