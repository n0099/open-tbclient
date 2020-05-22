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
    private n fbO;
    private View hND;
    private View hNJ;
    private c hNL;
    private VideoNetworkStateTipView hNO;
    private Animation.AnimationListener hNV;
    private Animation.AnimationListener hNW;
    public FrameLayout hsF;
    public FrameLayout hsG;
    public TextView hsH;
    public HeadImageView hsM;
    public com.baidu.tieba.play.c hsT;
    private View kML;
    private View kMM;
    private View kMN;
    public TextView kMO;
    private VideoMiddlePageAdCard kMP;
    private TextView kMQ;
    private TextView kMR;
    private ViewGroup kMS;
    private d kMT;
    private e kMU;
    private f kMV;
    private int kMW;
    private boolean kMX;
    private boolean kMY;
    private a kMZ;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kMX = false;
        this.kMY = true;
        this.hNV = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hNJ != null) {
                    VideoMiddlePageAdView.this.hNJ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kML != null) {
                    VideoMiddlePageAdView.this.kML.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hNJ != null) {
                    VideoMiddlePageAdView.this.hNJ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kML != null) {
                    VideoMiddlePageAdView.this.kML.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hNW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hNJ != null) {
                    VideoMiddlePageAdView.this.hNJ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kML != null) {
                    VideoMiddlePageAdView.this.kML.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hNJ != null) {
                    VideoMiddlePageAdView.this.hNJ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kML != null) {
                    VideoMiddlePageAdView.this.kML.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kMX = false;
        this.kMY = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hsF = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.hND = this.rootView.findViewById(R.id.card_container);
        this.hsG = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hsT = new com.baidu.tieba.play.c(this.dIF, this.hsG, false);
        this.hsT.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.hsT != null && VideoMiddlePageAdView.this.hsT.getVideoView() != null) {
                    VideoMiddlePageAdView.this.kMW = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hsT.getVideoView().getDuration());
                }
            }
        });
        this.hsT.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void nQ(boolean z) {
                if (VideoMiddlePageAdView.this.kMZ != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.kMZ.vF(0);
                    } else {
                        VideoMiddlePageAdView.this.kMZ.vF(1);
                    }
                }
            }
        });
        this.hsT.iZM.setOnTouchListener(null);
        this.hsH = (TextView) this.rootView.findViewById(R.id.title);
        this.hsM = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hsM.setIsRound(true);
        this.hsM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hsM.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hsM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.kMO = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.agw = (TextView) this.rootView.findViewById(R.id.user_name);
        this.fbO = new n(this.dIF.getPageActivity());
        this.kMQ = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.kMR = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.kMS = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.kMT = new d(this.dIF.getPageActivity(), this.kMS);
        this.kMT.page = 1;
        this.hNO = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.hNO.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.hNO.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hsT.ts(false);
                VideoMiddlePageAdView.this.hNO.dlf();
                if (VideoMiddlePageAdView.this.kMP != null && VideoMiddlePageAdView.this.kMP.video != null) {
                    VideoMiddlePageAdView.this.hsT.eW(VideoMiddlePageAdView.this.kMP.video.video_url, "");
                }
            }
        });
        this.hNJ = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.kMM = this.rootView.findViewById(R.id.user_container_foreground);
        this.kMN = this.rootView.findViewById(R.id.title_foreground);
        this.kML = this.rootView.findViewById(R.id.operate_area_foreground);
        this.hNJ.setOnClickListener(this);
        this.kMM.setOnClickListener(this);
        this.kMN.setOnClickListener(this);
        this.kML.setOnClickListener(this);
        this.hsG.setOnClickListener(this);
        this.hsF.setOnClickListener(this);
        this.hsT.Z(this);
        this.hsH.setOnClickListener(this);
        this.hsM.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.dIF.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsF.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hsF.setLayoutParams(layoutParams);
        this.boW = new AlphaAnimation(0.0f, 0.7f);
        this.boW.setDuration(500L);
        this.boW.setAnimationListener(this.hNW);
        this.boX = new AlphaAnimation(0.7f, 0.0f);
        this.boX.setDuration(500L);
        this.boX.setAnimationListener(this.hNV);
        this.rootView.setOnClickListener(this);
        this.kMZ = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctA() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dJS = this.kMP.autoPlay;
            this.kMX = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.kMW = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hsT.pO()) {
                cL(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hsT.getCurrentPosition());
                this.kMY = true;
            }
            this.hsT.stopPlay();
            this.hsT.setIsNeedRecoveryVideoPlayer(true);
            this.hsT.tt(true);
            this.hsT.tp(false);
            this.hsT.tu(true);
            this.hsT.an(false, true);
            this.hsT.BF(i);
            this.hsT.a(new c.InterfaceC0703c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pM() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pN() {
                }
            });
            this.hsT.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bXw() {
                    if (VideoMiddlePageAdView.this.kMP != null && VideoMiddlePageAdView.this.kMP.video != null && VideoMiddlePageAdView.this.kMP.video.video_height.intValue() > VideoMiddlePageAdView.this.kMP.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hsT.an(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hsT.an(false, true);
                    }
                    if (VideoMiddlePageAdView.this.kMV != null) {
                        VideoMiddlePageAdView.this.kMV.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Cn(VideoMiddlePageAdView.this.dJS ? 0 : 1);
                    VideoMiddlePageAdView.this.kMX = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bXx() {
                }
            });
            this.hsT.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void nl(boolean z) {
                    VideoMiddlePageAdView.this.hsT.eW(VideoMiddlePageAdView.this.kMP.video.video_url, "");
                    if (VideoMiddlePageAdView.this.kMV != null) {
                        VideoMiddlePageAdView.this.kMV.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Cn(1);
                    VideoMiddlePageAdView.this.kMX = false;
                }
            });
            this.hsT.tl(false);
            this.hsT.getVideoView().setBusiness(this.fbO);
            this.hsT.cub();
            this.hsT.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.hsT.chf();
                    if (VideoMiddlePageAdView.this.kMU != null) {
                        VideoMiddlePageAdView.this.kMU.cVr();
                    }
                    VideoMiddlePageAdView.this.Co(VideoMiddlePageAdView.this.dJS ? 0 : 1);
                    VideoMiddlePageAdView.this.kMY = true;
                }
            });
            this.hsT.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Cp(VideoMiddlePageAdView.this.dJS ? 0 : 1);
                    return true;
                }
            });
            this.hsT.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hsT.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hsT.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bXz() {
                    VideoMiddlePageAdView.this.cM(1, VideoMiddlePageAdView.this.hsT.getCurrentPosition());
                }
            });
            this.hsT.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cL(1, VideoMiddlePageAdView.this.hsT.getCurrentPosition());
                    VideoMiddlePageAdView.this.kMY = true;
                }
            });
            this.hsT.chf();
            this.hsT.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.hNO.cLX()) {
                    this.hsT.tr(false);
                    this.hNO.dle();
                    this.hsT.ts(true);
                    this.hsT.eV(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hsT.ts(false);
                    this.hsT.tr(false);
                    this.hNO.hide();
                    this.hsT.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.kMU != null) {
                    this.kMU.tJ(true);
                }
                if (i == 0) {
                    this.hNJ.setVisibility(8);
                    this.kML.setVisibility(8);
                } else {
                    this.hNJ.startAnimation(this.boX);
                    this.kML.startAnimation(this.boX);
                }
                if (i == 0) {
                    this.kMZ.vF(3);
                    return;
                } else {
                    this.kMZ.vF(0);
                    return;
                }
            }
            this.hNO.hide();
            this.hsT.tr(true);
            this.kMZ.vF(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.hNJ.startAnimation(this.boX);
                this.kML.startAnimation(this.boX);
                return;
            }
            this.hNJ.setVisibility(0);
            this.kML.setVisibility(0);
        }
    }

    private boolean ccz() {
        try {
            int intValue = this.kMP.video.video_width.intValue();
            return intValue <= 0 || ((float) this.kMP.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hsH.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kMO.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kMQ.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kMR.setTextColor(this.dIF.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.kMR, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void ccA() {
        if (!ccz()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsF.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hsF.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsF.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hsF.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kMP = videoMiddlePageAdCard;
        ccA();
        this.hsH.setText(videoMiddlePageAdCard.threadTitle);
        this.agw.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hsM.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hsM.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hsM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aXN() || VideoMiddlePageAdView.this.kMP == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.kMP.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.dIF.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.kMO.setText(videoMiddlePageAdCard.tagName);
        this.kMQ.setText(videoMiddlePageAdCard.operateData.kKK);
        this.kMR.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.kMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = r.b(VideoMiddlePageAdView.this.dIF, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.kMP == null || VideoMiddlePageAdView.this.kMP.getAdFacadeData() == null || VideoMiddlePageAdView.this.kMP.getAdFacadeData().pu() == null) ? null : VideoMiddlePageAdView.this.kMP.getAdFacadeData().pu().dAu);
                if (VideoMiddlePageAdView.this.kMU != null) {
                    VideoMiddlePageAdView.this.kMU.tJ(false);
                }
                if (VideoMiddlePageAdView.this.iZo != null) {
                    VideoMiddlePageAdView.this.iZo.d(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.kMP, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kMU = this.kMT.a(videoMiddlePageAdCard.tailFrame, this.kMU);
        if (this.kMU != null) {
            b(this.kMP.getAdFacadeData());
            this.kMU.setPageContext(this.dIF);
            this.kMU.setTimeoutListener(this);
            this.kMU.a(videoMiddlePageAdCard.tailFrame);
            this.kMU.c(this.kMP);
            this.kMU.cVs();
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
        this.hNL = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.kMV = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bs(View view) {
        this.Xn.uj(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bXu();
        if (this.hNJ != null) {
            this.hNJ.clearAnimation();
        }
        if (this.kML != null) {
            this.kML.clearAnimation();
        }
    }

    public void bXt() {
        this.hsT.stopPlay();
        if (this.hsH != null) {
            this.hsH.setVisibility(0);
        }
        if (this.kMZ != null) {
            this.kMZ.vF(2);
        }
        this.kMX = false;
        this.kMY = true;
    }

    public void bXu() {
        if (this.hsT != null) {
            this.hsT.destroy();
        }
        this.kMX = false;
        this.kMY = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hNJ && this.hNJ.getVisibility() == 0) {
            if (this.hNL != null) {
                this.hNL.vJ(this.mPosition);
            }
        } else if (view == this.kML && this.kML.getVisibility() == 0) {
            if (this.hNL != null) {
                this.hNL.vJ(this.mPosition);
            }
        } else if (view == this.kMN || view == this.kMM) {
            if (this.hNJ.getVisibility() == 0) {
                if (this.hNL != null) {
                    this.hNL.vJ(this.mPosition);
                    return;
                }
                return;
            }
            this.kMZ.vF(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.kJz = new WebVideoActivity.a();
            if (this.kMP.getAdFacadeData() != null) {
                WebVideoActivity.kJz.kJJ = this.kMP.getAdFacadeData().pu();
                WebVideoActivity.kJz.mPage = "DETAIL";
                if (this.kMP.getAdFacadeData().WY != null) {
                    WebVideoActivity.kJz.mPageNum = this.kMP.getAdFacadeData().WY.pq();
                }
            }
            if (com.baidu.tieba.a.bjL().bjM() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.dIF.getPageActivity(), "", this.kMP.getScheme(), true, true, true, this.kMP.video.video_url, this.kMP.video.thumbnail_url, 1.7777778f, this.kMW, this.kMP.getAdFacadeData().pu().dAu)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.dIF.getPageActivity(), "", this.kMP.getScheme(), true, true, true, this.kMP.video.video_url, this.kMP.video.thumbnail_url, 1.7777778f, this.kMW)));
            }
            if (this.iZo != null) {
                this.iZo.d(0, null);
            }
            if (this.kMU != null) {
                this.kMU.tJ(false);
            }
        } else {
            String str = null;
            if (this.kMP.getAdFacadeData() != null && this.kMP.getAdFacadeData().pu() != null) {
                str = this.kMP.getAdFacadeData().pu().dAu;
            }
            int b = r.b(this.dIF, this.kMP.getScheme(), str);
            if (this.iZo != null) {
                this.iZo.d(b, null);
            }
            if (this.kMU != null) {
                this.kMU.tJ(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.pf(this.hsT.getCurrentPosition()) < this.kMW && this.hsT.getCurrentState() == 1) {
            cL(this.dJS ? 0 : 1, this.hsT.getCurrentPosition());
        }
        bXt();
        this.kMU.tJ(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void avT() {
        if (isPlaying()) {
            this.hsT.avT();
            cL(this.dJS ? 0 : 1, this.hsT.getCurrentPosition());
            this.kMY = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hsT.pO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cn(int i) {
        if (this.kMP != null && this.kMP.video != null && this.kMP.getAdFacadeData() != null && this.kMY) {
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(this.kMP.getAdFacadeData(), 31, this.kMP.getAdFacadeData().getPageNum(), i, this.kMW, 0, -1));
            this.kMY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co(int i) {
        if (this.kMP != null && this.kMP.video != null && this.kMP.getAdFacadeData() != null && !this.kMX) {
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(this.kMP.getAdFacadeData(), 34, this.kMP.getAdFacadeData().getPageNum(), i, this.kMW, this.kMW, -1));
            this.kMX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp(int i) {
        if (this.kMP != null && this.kMP.video != null && this.kMP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(this.kMP.getAdFacadeData(), 36, this.kMP.getAdFacadeData().getPageNum(), i, this.kMW, com.baidu.tieba.ad.a.a.pf(this.hsT.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(int i, int i2) {
        if (this.kMP != null && this.kMP.video != null && this.kMP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(this.kMP.getAdFacadeData(), 32, this.kMP.getAdFacadeData().getPageNum(), i, this.kMW, com.baidu.tieba.ad.a.a.pf(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(int i, int i2) {
        if (this.kMP != null && this.kMP.video != null && this.kMP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(this.kMP.getAdFacadeData(), 33, this.kMP.getAdFacadeData().getPageNum(), i, this.kMW, com.baidu.tieba.ad.a.a.pf(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(this.kMP.getAdFacadeData(), 303, this.kMP.getAdFacadeData().getPageNum(), this.dJS ? 0 : 1, this.kMP.video.video_duration.intValue(), 0, -1);
            if (this.kMU != null) {
                this.kMU.e(a2);
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
        private Runnable hOc = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.hOc);
                a.this.vF(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void vF(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = vG(i);
                    ccK();
                    return;
                case 1:
                    this.mCurrentState = vG(i);
                    this.mHandler.removeCallbacks(this.hOc);
                    return;
                case 2:
                    this.mCurrentState = vH(i);
                    return;
                case 3:
                    this.mCurrentState = vI(i);
                    ccK();
                    return;
                default:
                    this.mCurrentState = vH(i);
                    return;
            }
        }

        private void ccK() {
            this.mHandler.removeCallbacks(this.hOc);
            this.mHandler.postDelayed(this.hOc, 3000L);
        }

        private int vG(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kMN.setVisibility(8);
                VideoMiddlePageAdView.this.kMM.setVisibility(8);
                VideoMiddlePageAdView.this.tH(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vH(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kMN.setVisibility(0);
                VideoMiddlePageAdView.this.kMM.setVisibility(0);
                if (VideoMiddlePageAdView.this.hsT != null) {
                    VideoMiddlePageAdView.this.hsT.cQk();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.kMP.autoPlay) {
                    VideoMiddlePageAdView.this.tH(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vI(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kMN.setVisibility(0);
                VideoMiddlePageAdView.this.kMM.setVisibility(0);
                VideoMiddlePageAdView.this.tH(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
