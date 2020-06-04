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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes13.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Xn;
    public TextView agw;
    private Animation boW;
    private Animation boX;
    private boolean dJS;
    private n fbZ;
    private VideoNetworkStateTipView hOB;
    private Animation.AnimationListener hOI;
    private Animation.AnimationListener hOJ;
    private View hOq;
    private View hOw;
    private c hOy;
    public FrameLayout hsQ;
    public FrameLayout hsR;
    public TextView hsS;
    public HeadImageView hsX;
    public com.baidu.tieba.play.c hte;
    private View kNU;
    private View kNV;
    private View kNW;
    public TextView kNX;
    private VideoMiddlePageAdCard kNY;
    private TextView kNZ;
    private TextView kOa;
    private ViewGroup kOb;
    private d kOc;
    private e kOd;
    private f kOe;
    private int kOf;
    private boolean kOg;
    private boolean kOh;
    private a kOi;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kOg = false;
        this.kOh = true;
        this.hOI = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hOw != null) {
                    VideoMiddlePageAdView.this.hOw.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kNU != null) {
                    VideoMiddlePageAdView.this.kNU.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hOw != null) {
                    VideoMiddlePageAdView.this.hOw.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kNU != null) {
                    VideoMiddlePageAdView.this.kNU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hOJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hOw != null) {
                    VideoMiddlePageAdView.this.hOw.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kNU != null) {
                    VideoMiddlePageAdView.this.kNU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hOw != null) {
                    VideoMiddlePageAdView.this.hOw.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kNU != null) {
                    VideoMiddlePageAdView.this.kNU.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kOg = false;
        this.kOh = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hsQ = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.hOq = this.rootView.findViewById(R.id.card_container);
        this.hsR = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hte = new com.baidu.tieba.play.c(this.dIF, this.hsR, false);
        this.hte.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.hte != null && VideoMiddlePageAdView.this.hte.getVideoView() != null) {
                    VideoMiddlePageAdView.this.kOf = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hte.getVideoView().getDuration());
                }
            }
        });
        this.hte.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void nQ(boolean z) {
                if (VideoMiddlePageAdView.this.kOi != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.kOi.vH(0);
                    } else {
                        VideoMiddlePageAdView.this.kOi.vH(1);
                    }
                }
            }
        });
        this.hte.jaz.setOnTouchListener(null);
        this.hsS = (TextView) this.rootView.findViewById(R.id.title);
        this.hsX = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hsX.setIsRound(true);
        this.hsX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hsX.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hsX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.kNX = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.agw = (TextView) this.rootView.findViewById(R.id.user_name);
        this.fbZ = new n(this.dIF.getPageActivity());
        this.kNZ = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.kOa = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.kOb = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.kOc = new d(this.dIF.getPageActivity(), this.kOb);
        this.kOc.page = 1;
        this.hOB = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.hOB.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.hOB.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hte.ts(false);
                VideoMiddlePageAdView.this.hOB.dlu();
                if (VideoMiddlePageAdView.this.kNY != null && VideoMiddlePageAdView.this.kNY.video != null) {
                    VideoMiddlePageAdView.this.hte.eW(VideoMiddlePageAdView.this.kNY.video.video_url, "");
                }
            }
        });
        this.hOw = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.kNV = this.rootView.findViewById(R.id.user_container_foreground);
        this.kNW = this.rootView.findViewById(R.id.title_foreground);
        this.kNU = this.rootView.findViewById(R.id.operate_area_foreground);
        this.hOw.setOnClickListener(this);
        this.kNV.setOnClickListener(this);
        this.kNW.setOnClickListener(this);
        this.kNU.setOnClickListener(this);
        this.hsR.setOnClickListener(this);
        this.hsQ.setOnClickListener(this);
        this.hte.Z(this);
        this.hsS.setOnClickListener(this);
        this.hsX.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.dIF.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hsQ.setLayoutParams(layoutParams);
        this.boW = new AlphaAnimation(0.0f, 0.7f);
        this.boW.setDuration(500L);
        this.boW.setAnimationListener(this.hOJ);
        this.boX = new AlphaAnimation(0.7f, 0.0f);
        this.boX.setDuration(500L);
        this.boX.setAnimationListener(this.hOI);
        this.rootView.setOnClickListener(this);
        this.kOi = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctJ() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dJS = this.kNY.autoPlay;
            this.kOg = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.kOf = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hte.pO()) {
                cL(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hte.getCurrentPosition());
                this.kOh = true;
            }
            this.hte.stopPlay();
            this.hte.setIsNeedRecoveryVideoPlayer(true);
            this.hte.tt(true);
            this.hte.tp(false);
            this.hte.tu(true);
            this.hte.an(false, true);
            this.hte.BH(i);
            this.hte.a(new c.InterfaceC0704c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pM() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pN() {
                }
            });
            this.hte.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bXy() {
                    if (VideoMiddlePageAdView.this.kNY != null && VideoMiddlePageAdView.this.kNY.video != null && VideoMiddlePageAdView.this.kNY.video.video_height.intValue() > VideoMiddlePageAdView.this.kNY.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hte.an(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hte.an(false, true);
                    }
                    if (VideoMiddlePageAdView.this.kOe != null) {
                        VideoMiddlePageAdView.this.kOe.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Cp(VideoMiddlePageAdView.this.dJS ? 0 : 1);
                    VideoMiddlePageAdView.this.kOg = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bXz() {
                }
            });
            this.hte.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void nl(boolean z) {
                    VideoMiddlePageAdView.this.hte.eW(VideoMiddlePageAdView.this.kNY.video.video_url, "");
                    if (VideoMiddlePageAdView.this.kOe != null) {
                        VideoMiddlePageAdView.this.kOe.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Cp(1);
                    VideoMiddlePageAdView.this.kOg = false;
                }
            });
            this.hte.tl(false);
            this.hte.getVideoView().setBusiness(this.fbZ);
            this.hte.cuk();
            this.hte.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.hte.cho();
                    if (VideoMiddlePageAdView.this.kOd != null) {
                        VideoMiddlePageAdView.this.kOd.cVH();
                    }
                    VideoMiddlePageAdView.this.Cq(VideoMiddlePageAdView.this.dJS ? 0 : 1);
                    VideoMiddlePageAdView.this.kOh = true;
                }
            });
            this.hte.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Cr(VideoMiddlePageAdView.this.dJS ? 0 : 1);
                    return true;
                }
            });
            this.hte.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hte.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hte.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bXB() {
                    VideoMiddlePageAdView.this.cM(1, VideoMiddlePageAdView.this.hte.getCurrentPosition());
                }
            });
            this.hte.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cL(1, VideoMiddlePageAdView.this.hte.getCurrentPosition());
                    VideoMiddlePageAdView.this.kOh = true;
                }
            });
            this.hte.cho();
            this.hte.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.hOB.cMn()) {
                    this.hte.tr(false);
                    this.hOB.dlt();
                    this.hte.ts(true);
                    this.hte.eV(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hte.ts(false);
                    this.hte.tr(false);
                    this.hOB.hide();
                    this.hte.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.kOd != null) {
                    this.kOd.tJ(true);
                }
                if (i == 0) {
                    this.hOw.setVisibility(8);
                    this.kNU.setVisibility(8);
                } else {
                    this.hOw.startAnimation(this.boX);
                    this.kNU.startAnimation(this.boX);
                }
                if (i == 0) {
                    this.kOi.vH(3);
                    return;
                } else {
                    this.kOi.vH(0);
                    return;
                }
            }
            this.hOB.hide();
            this.hte.tr(true);
            this.kOi.vH(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.hOw.startAnimation(this.boX);
                this.kNU.startAnimation(this.boX);
                return;
            }
            this.hOw.setVisibility(0);
            this.kNU.setVisibility(0);
        }
    }

    private boolean ccH() {
        try {
            int intValue = this.kNY.video.video_width.intValue();
            return intValue <= 0 || ((float) this.kNY.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hsS.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kNX.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kNZ.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kOa.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.kOa, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void ccI() {
        if (!ccH()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hsQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hsQ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kNY = videoMiddlePageAdCard;
        ccI();
        this.hsS.setText(videoMiddlePageAdCard.threadTitle);
        this.agw.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hsX.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hsX.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hsX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aXO() || VideoMiddlePageAdView.this.kNY == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.kNY.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.dIF.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.kNX.setText(videoMiddlePageAdCard.tagName);
        this.kNZ.setText(videoMiddlePageAdCard.operateData.kLT);
        this.kOa.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.kOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = r.b(VideoMiddlePageAdView.this.dIF, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.kNY == null || VideoMiddlePageAdView.this.kNY.getAdFacadeData() == null || VideoMiddlePageAdView.this.kNY.getAdFacadeData().pu() == null) ? null : VideoMiddlePageAdView.this.kNY.getAdFacadeData().pu().dAu);
                if (VideoMiddlePageAdView.this.kOd != null) {
                    VideoMiddlePageAdView.this.kOd.tJ(false);
                }
                if (VideoMiddlePageAdView.this.jab != null) {
                    VideoMiddlePageAdView.this.jab.d(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.kNY, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kOd = this.kOc.a(videoMiddlePageAdCard.tailFrame, this.kOd);
        if (this.kOd != null) {
            b(this.kNY.getAdFacadeData());
            this.kOd.setPageContext(this.dIF);
            this.kOd.setTimeoutListener(this);
            this.kOd.a(videoMiddlePageAdCard.tailFrame);
            this.kOd.c(this.kNY);
            this.kOd.cVI();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Xn = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Xn;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.hOy = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.kOe = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bs(View view) {
        this.Xn.ul(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bXw();
        if (this.hOw != null) {
            this.hOw.clearAnimation();
        }
        if (this.kNU != null) {
            this.kNU.clearAnimation();
        }
    }

    public void bXv() {
        this.hte.stopPlay();
        if (this.hsS != null) {
            this.hsS.setVisibility(0);
        }
        if (this.kOi != null) {
            this.kOi.vH(2);
        }
        this.kOg = false;
        this.kOh = true;
    }

    public void bXw() {
        if (this.hte != null) {
            this.hte.destroy();
        }
        this.kOg = false;
        this.kOh = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hOw && this.hOw.getVisibility() == 0) {
            if (this.hOy != null) {
                this.hOy.vL(this.mPosition);
            }
        } else if (view == this.kNU && this.kNU.getVisibility() == 0) {
            if (this.hOy != null) {
                this.hOy.vL(this.mPosition);
            }
        } else if (view == this.kNW || view == this.kNV) {
            if (this.hOw.getVisibility() == 0) {
                if (this.hOy != null) {
                    this.hOy.vL(this.mPosition);
                    return;
                }
                return;
            }
            this.kOi.vH(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.kKH = new WebVideoActivity.a();
            if (this.kNY.getAdFacadeData() != null) {
                WebVideoActivity.kKH.kKS = this.kNY.getAdFacadeData().pu();
                WebVideoActivity.kKH.mPage = "DETAIL";
                if (this.kNY.getAdFacadeData().WY != null) {
                    WebVideoActivity.kKH.mPageNum = this.kNY.getAdFacadeData().WY.pq();
                }
            }
            if (com.baidu.tieba.a.bjN().bjO() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.dIF.getPageActivity(), "", this.kNY.getScheme(), true, true, true, this.kNY.video.video_url, this.kNY.video.thumbnail_url, 1.7777778f, this.kOf, this.kNY.getAdFacadeData().pu().dAu)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.dIF.getPageActivity(), "", this.kNY.getScheme(), true, true, true, this.kNY.video.video_url, this.kNY.video.thumbnail_url, 1.7777778f, this.kOf)));
            }
            if (this.jab != null) {
                this.jab.d(0, null);
            }
            if (this.kOd != null) {
                this.kOd.tJ(false);
            }
        } else {
            String str = null;
            if (this.kNY.getAdFacadeData() != null && this.kNY.getAdFacadeData().pu() != null) {
                str = this.kNY.getAdFacadeData().pu().dAu;
            }
            int b = r.b(this.dIF, this.kNY.getScheme(), str);
            if (this.jab != null) {
                this.jab.d(b, null);
            }
            if (this.kOd != null) {
                this.kOd.tJ(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.ph(this.hte.getCurrentPosition()) < this.kOf && this.hte.getCurrentState() == 1) {
            cL(this.dJS ? 0 : 1, this.hte.getCurrentPosition());
        }
        bXv();
        this.kOd.tJ(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void avT() {
        if (isPlaying()) {
            this.hte.avT();
            cL(this.dJS ? 0 : 1, this.hte.getCurrentPosition());
            this.kOh = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hte.pO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp(int i) {
        if (this.kNY != null && this.kNY.video != null && this.kNY.getAdFacadeData() != null && this.kOh) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this.kNY.getAdFacadeData(), 31, this.kNY.getAdFacadeData().getPageNum(), i, this.kOf, 0, -1));
            this.kOh = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cq(int i) {
        if (this.kNY != null && this.kNY.video != null && this.kNY.getAdFacadeData() != null && !this.kOg) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this.kNY.getAdFacadeData(), 34, this.kNY.getAdFacadeData().getPageNum(), i, this.kOf, this.kOf, -1));
            this.kOg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr(int i) {
        if (this.kNY != null && this.kNY.video != null && this.kNY.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this.kNY.getAdFacadeData(), 36, this.kNY.getAdFacadeData().getPageNum(), i, this.kOf, com.baidu.tieba.ad.a.a.ph(this.hte.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(int i, int i2) {
        if (this.kNY != null && this.kNY.video != null && this.kNY.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this.kNY.getAdFacadeData(), 32, this.kNY.getAdFacadeData().getPageNum(), i, this.kOf, com.baidu.tieba.ad.a.a.ph(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(int i, int i2) {
        if (this.kNY != null && this.kNY.video != null && this.kNY.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this.kNY.getAdFacadeData(), 33, this.kNY.getAdFacadeData().getPageNum(), i, this.kOf, com.baidu.tieba.ad.a.a.ph(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(this.kNY.getAdFacadeData(), 303, this.kNY.getAdFacadeData().getPageNum(), this.dJS ? 0 : 1, this.kNY.video.video_duration.intValue(), 0, -1);
            if (this.kOd != null) {
                this.kOd.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable hOP = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.hOP);
                a.this.vH(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void vH(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = vI(i);
                    ccS();
                    return;
                case 1:
                    this.mCurrentState = vI(i);
                    this.mHandler.removeCallbacks(this.hOP);
                    return;
                case 2:
                    this.mCurrentState = vJ(i);
                    return;
                case 3:
                    this.mCurrentState = vK(i);
                    ccS();
                    return;
                default:
                    this.mCurrentState = vJ(i);
                    return;
            }
        }

        private void ccS() {
            this.mHandler.removeCallbacks(this.hOP);
            this.mHandler.postDelayed(this.hOP, 3000L);
        }

        private int vI(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kNW.setVisibility(8);
                VideoMiddlePageAdView.this.kNV.setVisibility(8);
                VideoMiddlePageAdView.this.tH(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vJ(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kNW.setVisibility(0);
                VideoMiddlePageAdView.this.kNV.setVisibility(0);
                if (VideoMiddlePageAdView.this.hte != null) {
                    VideoMiddlePageAdView.this.hte.cQA();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.kNY.autoPlay) {
                    VideoMiddlePageAdView.this.tH(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vK(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kNW.setVisibility(0);
                VideoMiddlePageAdView.this.kNV.setVisibility(0);
                VideoMiddlePageAdView.this.tH(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
