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
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes13.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a DA;
    public TextView Nl;
    private Animation aLw;
    private Animation aLx;
    private boolean cWk;
    private n ekY;
    private VideoNetworkStateTipView gNB;
    private Animation.AnimationListener gNI;
    private Animation.AnimationListener gNJ;
    private View gNq;
    private View gNw;
    private c gNy;
    public FrameLayout gtI;
    public FrameLayout gtJ;
    public TextView gtK;
    public HeadImageView gtP;
    public com.baidu.tieba.play.c gtW;
    private View jJB;
    private View jJC;
    private View jJD;
    public TextView jJE;
    private VideoMiddlePageAdCard jJF;
    private TextView jJG;
    private TextView jJH;
    private ViewGroup jJI;
    private d jJJ;
    private e jJK;
    private f jJL;
    private int jJM;
    private boolean jJN;
    private boolean jJO;
    private a jJP;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jJN = false;
        this.jJO = true;
        this.gNI = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gNw != null) {
                    VideoMiddlePageAdView.this.gNw.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jJB != null) {
                    VideoMiddlePageAdView.this.jJB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gNw != null) {
                    VideoMiddlePageAdView.this.gNw.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jJB != null) {
                    VideoMiddlePageAdView.this.jJB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gNw != null) {
                    VideoMiddlePageAdView.this.gNw.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jJB != null) {
                    VideoMiddlePageAdView.this.jJB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gNw != null) {
                    VideoMiddlePageAdView.this.gNw.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jJB != null) {
                    VideoMiddlePageAdView.this.jJB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jJN = false;
        this.jJO = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.gtI = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.gNq = this.rootView.findViewById(R.id.card_container);
        this.gtJ = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.gtW = new com.baidu.tieba.play.c(this.cVg, this.gtJ, false);
        this.gtW.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.gtW != null && VideoMiddlePageAdView.this.gtW.getVideoView() != null) {
                    VideoMiddlePageAdView.this.jJM = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.gtW.getVideoView().getDuration());
                }
            }
        });
        this.gtW.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void ml(boolean z) {
                if (VideoMiddlePageAdView.this.jJP != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.jJP.uu(0);
                    } else {
                        VideoMiddlePageAdView.this.jJP.uu(1);
                    }
                }
            }
        });
        this.gtW.hZa.setOnTouchListener(null);
        this.gtK = (TextView) this.rootView.findViewById(R.id.title);
        this.gtP = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.gtP.setIsRound(true);
        this.gtP.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gtP.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gtP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jJE = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Nl = (TextView) this.rootView.findViewById(R.id.user_name);
        this.ekY = new n(this.cVg.getPageActivity());
        this.jJG = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.jJH = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.jJI = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.jJJ = new d(this.cVg.getPageActivity(), this.jJI);
        this.jJJ.page = 1;
        this.gNB = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.gNB.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.gNB.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.gtW.rK(false);
                VideoMiddlePageAdView.this.gNB.cSt();
                if (VideoMiddlePageAdView.this.jJF != null && VideoMiddlePageAdView.this.jJF.video != null) {
                    VideoMiddlePageAdView.this.gtW.ei(VideoMiddlePageAdView.this.jJF.video.video_url, "");
                }
            }
        });
        this.gNw = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.jJC = this.rootView.findViewById(R.id.user_container_foreground);
        this.jJD = this.rootView.findViewById(R.id.title_foreground);
        this.jJB = this.rootView.findViewById(R.id.operate_area_foreground);
        this.gNw.setOnClickListener(this);
        this.jJC.setOnClickListener(this);
        this.jJD.setOnClickListener(this);
        this.jJB.setOnClickListener(this);
        this.gtJ.setOnClickListener(this);
        this.gtI.setOnClickListener(this);
        this.gtW.Y(this);
        this.gtK.setOnClickListener(this);
        this.gtP.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cVg.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtI.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtI.setLayoutParams(layoutParams);
        this.aLw = new AlphaAnimation(0.0f, 0.7f);
        this.aLw.setDuration(500L);
        this.aLw.setAnimationListener(this.gNJ);
        this.aLx = new AlphaAnimation(0.7f, 0.0f);
        this.aLx.setDuration(500L);
        this.aLx.setAnimationListener(this.gNI);
        this.rootView.setOnClickListener(this);
        this.jJP = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccd() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cWk = this.jJF.autoPlay;
            this.jJN = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.jJM = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.gtW.le()) {
                cz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.gtW.getCurrentPosition());
                this.jJO = true;
            }
            this.gtW.stopPlay();
            this.gtW.setIsNeedRecoveryVideoPlayer(true);
            this.gtW.rL(true);
            this.gtW.rH(false);
            this.gtW.rM(true);
            this.gtW.aj(false, true);
            this.gtW.An(i);
            this.gtW.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                }
            });
            this.gtW.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bGl() {
                    if (VideoMiddlePageAdView.this.jJF != null && VideoMiddlePageAdView.this.jJF.video != null && VideoMiddlePageAdView.this.jJF.video.video_height.intValue() > VideoMiddlePageAdView.this.jJF.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.gtW.aj(false, true);
                    } else {
                        VideoMiddlePageAdView.this.gtW.aj(false, true);
                    }
                    if (VideoMiddlePageAdView.this.jJL != null) {
                        VideoMiddlePageAdView.this.jJL.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AV(VideoMiddlePageAdView.this.cWk ? 0 : 1);
                    VideoMiddlePageAdView.this.jJN = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGm() {
                }
            });
            this.gtW.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z) {
                    VideoMiddlePageAdView.this.gtW.ei(VideoMiddlePageAdView.this.jJF.video.video_url, "");
                    if (VideoMiddlePageAdView.this.jJL != null) {
                        VideoMiddlePageAdView.this.jJL.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AV(1);
                    VideoMiddlePageAdView.this.jJN = false;
                }
            });
            this.gtW.rD(false);
            this.gtW.getVideoView().setBusiness(this.ekY);
            this.gtW.ccE();
            this.gtW.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.gtW.bPM();
                    if (VideoMiddlePageAdView.this.jJK != null) {
                        VideoMiddlePageAdView.this.jJK.cDu();
                    }
                    VideoMiddlePageAdView.this.AW(VideoMiddlePageAdView.this.cWk ? 0 : 1);
                    VideoMiddlePageAdView.this.jJO = true;
                }
            });
            this.gtW.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.AX(VideoMiddlePageAdView.this.cWk ? 0 : 1);
                    return true;
                }
            });
            this.gtW.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.gtW.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.gtW.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bGo() {
                    VideoMiddlePageAdView.this.cA(1, VideoMiddlePageAdView.this.gtW.getCurrentPosition());
                }
            });
            this.gtW.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cz(1, VideoMiddlePageAdView.this.gtW.getCurrentPosition());
                    VideoMiddlePageAdView.this.jJO = true;
                }
            });
            this.gtW.bPM();
            this.gtW.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.gNB.ctZ()) {
                    this.gtW.rJ(false);
                    this.gNB.cSs();
                    this.gtW.rK(true);
                    this.gtW.eh(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.gtW.rK(false);
                    this.gtW.rJ(false);
                    this.gNB.hide();
                    this.gtW.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.jJK != null) {
                    this.jJK.se(true);
                }
                if (i == 0) {
                    this.gNw.setVisibility(8);
                    this.jJB.setVisibility(8);
                } else {
                    this.gNw.startAnimation(this.aLx);
                    this.jJB.startAnimation(this.aLx);
                }
                if (i == 0) {
                    this.jJP.uu(3);
                    return;
                } else {
                    this.jJP.uu(0);
                    return;
                }
            }
            this.gNB.hide();
            this.gtW.rJ(true);
            this.jJP.uu(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.gNw.startAnimation(this.aLx);
                this.jJB.startAnimation(this.aLx);
                return;
            }
            this.gNw.setVisibility(0);
            this.jJB.setVisibility(0);
        }
    }

    private boolean bLf() {
        try {
            int intValue = this.jJF.video.video_width.intValue();
            return intValue <= 0 || ((float) this.jJF.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.gtK.setTextColor(this.cVg.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJE.setTextColor(this.cVg.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJG.setTextColor(this.cVg.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJH.setTextColor(this.cVg.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.jJH, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bLg() {
        if (!bLf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtI.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.gtI.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtI.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.gtI.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jJF = videoMiddlePageAdCard;
        bLg();
        this.gtK.setText(videoMiddlePageAdCard.threadTitle);
        this.Nl.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.gtP.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.gtP.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.gtP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJf() || VideoMiddlePageAdView.this.jJF == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.jJF.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cVg.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.jJE.setText(videoMiddlePageAdCard.tagName);
        this.jJG.setText(videoMiddlePageAdCard.operateData.jHn);
        this.jJH.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.jJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = s.b(VideoMiddlePageAdView.this.cVg, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.jJF == null || VideoMiddlePageAdView.this.jJF.getAdFacadeData() == null || VideoMiddlePageAdView.this.jJF.getAdFacadeData().kK() == null) ? null : VideoMiddlePageAdView.this.jJF.getAdFacadeData().kK().cMV);
                if (VideoMiddlePageAdView.this.jJK != null) {
                    VideoMiddlePageAdView.this.jJK.se(false);
                }
                if (VideoMiddlePageAdView.this.hYC != null) {
                    VideoMiddlePageAdView.this.hYC.b(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.jJF, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jJK = this.jJJ.a(videoMiddlePageAdCard.tailFrame, this.jJK);
        if (this.jJK != null) {
            b(this.jJF.getAdFacadeData());
            this.jJK.setPageContext(this.cVg);
            this.jJK.setTimeoutListener(this);
            this.jJK.a(videoMiddlePageAdCard.tailFrame);
            this.jJK.c(this.jJF);
            this.jJK.cDv();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.DA = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.DA;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.gNy = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.jJL = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bq(View view) {
        this.DA.te(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bGj();
        if (this.gNw != null) {
            this.gNw.clearAnimation();
        }
        if (this.jJB != null) {
            this.jJB.clearAnimation();
        }
    }

    public void bGi() {
        this.gtW.stopPlay();
        if (this.gtK != null) {
            this.gtK.setVisibility(0);
        }
        if (this.jJP != null) {
            this.jJP.uu(2);
        }
        this.jJN = false;
        this.jJO = true;
    }

    public void bGj() {
        if (this.gtW != null) {
            this.gtW.destroy();
        }
        this.jJN = false;
        this.jJO = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNw && this.gNw.getVisibility() == 0) {
            if (this.gNy != null) {
                this.gNy.uy(this.mPosition);
            }
        } else if (view == this.jJB && this.jJB.getVisibility() == 0) {
            if (this.gNy != null) {
                this.gNy.uy(this.mPosition);
            }
        } else if (view == this.jJD || view == this.jJC) {
            if (this.gNw.getVisibility() == 0) {
                if (this.gNy != null) {
                    this.gNy.uy(this.mPosition);
                    return;
                }
                return;
            }
            this.jJP.uu(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.jGd = new WebVideoActivity.a();
            if (this.jJF.getAdFacadeData() != null) {
                WebVideoActivity.jGd.jGn = this.jJF.getAdFacadeData().kK();
                WebVideoActivity.jGd.mPage = "DETAIL";
                if (this.jJF.getAdFacadeData().Dm != null) {
                    WebVideoActivity.jGd.mPageNum = this.jJF.getAdFacadeData().Dm.kG();
                }
            }
            if (com.baidu.tieba.a.aVl().aVm() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cVg.getPageActivity(), "", this.jJF.getScheme(), true, true, true, this.jJF.video.video_url, this.jJF.video.thumbnail_url, 1.7777778f, this.jJM, this.jJF.getAdFacadeData().kK().cMV)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cVg.getPageActivity(), "", this.jJF.getScheme(), true, true, true, this.jJF.video.video_url, this.jJF.video.thumbnail_url, 1.7777778f, this.jJM)));
            }
            if (this.hYC != null) {
                this.hYC.b(0, null);
            }
            if (this.jJK != null) {
                this.jJK.se(false);
            }
        } else {
            String str = null;
            if (this.jJF.getAdFacadeData() != null && this.jJF.getAdFacadeData().kK() != null) {
                str = this.jJF.getAdFacadeData().kK().cMV;
            }
            int b = s.b(this.cVg, this.jJF.getScheme(), str);
            if (this.hYC != null) {
                this.hYC.b(b, null);
            }
            if (this.jJK != null) {
                this.jJK.se(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.oj(this.gtW.getCurrentPosition()) < this.jJM && this.gtW.getCurrentState() == 1) {
            cz(this.cWk ? 0 : 1, this.gtW.getCurrentPosition());
        }
        bGi();
        this.jJK.se(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.gtW.pausePlay();
            cz(this.cWk ? 0 : 1, this.gtW.getCurrentPosition());
            this.jJO = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.gtW.le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV(int i) {
        if (this.jJF != null && this.jJF.video != null && this.jJF.getAdFacadeData() != null && this.jJO) {
            com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(this.jJF.getAdFacadeData(), 31, this.jJF.getAdFacadeData().getPageNum(), i, this.jJM, 0, -1));
            this.jJO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW(int i) {
        if (this.jJF != null && this.jJF.video != null && this.jJF.getAdFacadeData() != null && !this.jJN) {
            com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(this.jJF.getAdFacadeData(), 34, this.jJF.getAdFacadeData().getPageNum(), i, this.jJM, this.jJM, -1));
            this.jJN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX(int i) {
        if (this.jJF != null && this.jJF.video != null && this.jJF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(this.jJF.getAdFacadeData(), 36, this.jJF.getAdFacadeData().getPageNum(), i, this.jJM, com.baidu.tieba.ad.a.a.oj(this.gtW.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i, int i2) {
        if (this.jJF != null && this.jJF.video != null && this.jJF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(this.jJF.getAdFacadeData(), 32, this.jJF.getAdFacadeData().getPageNum(), i, this.jJM, com.baidu.tieba.ad.a.a.oj(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(int i, int i2) {
        if (this.jJF != null && this.jJF.video != null && this.jJF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(this.jJF.getAdFacadeData(), 33, this.jJF.getAdFacadeData().getPageNum(), i, this.jJM, com.baidu.tieba.ad.a.a.oj(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.jJF.getAdFacadeData(), 303, this.jJF.getAdFacadeData().getPageNum(), this.cWk ? 0 : 1, this.jJF.video.video_duration.intValue(), 0, -1);
            if (this.jJK != null) {
                this.jJK.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(boolean z) {
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
        private Runnable gNP = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gNP);
                a.this.uu(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void uu(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uv(i);
                    bLq();
                    return;
                case 1:
                    this.mCurrentState = uv(i);
                    this.mHandler.removeCallbacks(this.gNP);
                    return;
                case 2:
                    this.mCurrentState = uw(i);
                    return;
                case 3:
                    this.mCurrentState = ux(i);
                    bLq();
                    return;
                default:
                    this.mCurrentState = uw(i);
                    return;
            }
        }

        private void bLq() {
            this.mHandler.removeCallbacks(this.gNP);
            this.mHandler.postDelayed(this.gNP, 3000L);
        }

        private int uv(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJD.setVisibility(8);
                VideoMiddlePageAdView.this.jJC.setVisibility(8);
                VideoMiddlePageAdView.this.sa(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uw(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJD.setVisibility(0);
                VideoMiddlePageAdView.this.jJC.setVisibility(0);
                if (VideoMiddlePageAdView.this.gtW != null) {
                    VideoMiddlePageAdView.this.gtW.cym();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.jJF.autoPlay) {
                    VideoMiddlePageAdView.this.sa(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ux(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJD.setVisibility(0);
                VideoMiddlePageAdView.this.jJC.setVisibility(0);
                VideoMiddlePageAdView.this.sa(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
