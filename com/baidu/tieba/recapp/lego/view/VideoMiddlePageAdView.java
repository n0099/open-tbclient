package com.baidu.tieba.recapp.lego.view;

import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes25.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a YJ;
    public TextView ajb;
    private Animation bDE;
    private Animation bDF;
    private boolean eiU;
    private Animation.AnimationListener iDF;
    private Animation.AnimationListener iDG;
    private View iDn;
    private View iDt;
    private c iDv;
    private VideoNetworkStateTipView iDy;
    public FrameLayout igT;
    public FrameLayout igU;
    public TextView igV;
    public HeadImageView iha;
    public com.baidu.tieba.play.c ihi;
    private View lOK;
    private View lOL;
    private View lOM;
    public TextView lON;
    private VideoMiddlePageAdCard lOO;
    private TextView lOP;
    private TextView lOQ;
    private ViewGroup lOR;
    private d lOS;
    private e lOT;
    private f lOU;
    private int lOV;
    private boolean lOW;
    private boolean lOX;
    private a lOY;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lOW = false;
        this.lOX = true;
        this.iDF = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.iDt != null) {
                    VideoMiddlePageAdView.this.iDt.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lOK != null) {
                    VideoMiddlePageAdView.this.lOK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.iDt != null) {
                    VideoMiddlePageAdView.this.iDt.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lOK != null) {
                    VideoMiddlePageAdView.this.lOK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iDG = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.iDt != null) {
                    VideoMiddlePageAdView.this.iDt.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lOK != null) {
                    VideoMiddlePageAdView.this.lOK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.iDt != null) {
                    VideoMiddlePageAdView.this.iDt.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lOK != null) {
                    VideoMiddlePageAdView.this.lOK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lOW = false;
        this.lOX = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.igT = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.iDn = this.rootView.findViewById(R.id.card_container);
        this.igU = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.ihi = new com.baidu.tieba.play.c(this.ehG, this.igU, false);
        this.ihi.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.ihi.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.ihi != null && VideoMiddlePageAdView.this.ihi.getVideoView() != null) {
                    VideoMiddlePageAdView.this.lOV = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.ihi.getVideoView().getDuration());
                }
            }
        });
        this.ihi.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void pt(boolean z) {
                if (VideoMiddlePageAdView.this.lOY != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.lOY.zw(0);
                    } else {
                        VideoMiddlePageAdView.this.lOY.zw(1);
                    }
                }
            }
        });
        this.ihi.jYr.setOnTouchListener(null);
        this.igV = (TextView) this.rootView.findViewById(R.id.title);
        this.iha = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.iha.setIsRound(true);
        this.iha.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iha.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iha.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.lON = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ajb = (TextView) this.rootView.findViewById(R.id.user_name);
        this.lOP = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.lOQ = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.lOR = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.lOS = new d(this.ehG.getPageActivity(), this.lOR);
        this.lOS.page = 1;
        this.iDy = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.iDy.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.iDy.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.ihi.vi(false);
                VideoMiddlePageAdView.this.iDy.dIr();
                if (VideoMiddlePageAdView.this.lOO != null && VideoMiddlePageAdView.this.lOO.video != null) {
                    VideoMiddlePageAdView.this.ihi.fK(VideoMiddlePageAdView.this.lOO.video.video_url, "");
                }
            }
        });
        this.iDt = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.lOL = this.rootView.findViewById(R.id.user_container_foreground);
        this.lOM = this.rootView.findViewById(R.id.title_foreground);
        this.lOK = this.rootView.findViewById(R.id.operate_area_foreground);
        this.iDt.setOnClickListener(this);
        this.lOL.setOnClickListener(this);
        this.lOM.setOnClickListener(this);
        this.lOK.setOnClickListener(this);
        this.igU.setOnClickListener(this);
        this.igT.setOnClickListener(this);
        this.ihi.ab(this);
        this.igV.setOnClickListener(this);
        this.iha.setOnClickListener(this);
        this.ajb.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.ehG.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igT.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.igT.setLayoutParams(layoutParams);
        this.bDE = new AlphaAnimation(0.0f, 0.7f);
        this.bDE.setDuration(500L);
        this.bDE.setAnimationListener(this.iDG);
        this.bDF = new AlphaAnimation(0.7f, 0.0f);
        this.bDF.setDuration(500L);
        this.bDF.setAnimationListener(this.iDF);
        this.rootView.setOnClickListener(this);
        this.lOY = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cPW() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eiU = this.lOO.autoPlay;
            this.lOW = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.lOV = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.ihi.rK()) {
                de(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.ihi.getCurrentPosition());
                this.lOX = true;
            }
            this.ihi.stopPlay();
            this.ihi.vj(true);
            this.ihi.vf(false);
            this.ihi.vk(true);
            this.ihi.aw(false, true);
            this.ihi.Gf(i);
            this.ihi.a(new c.InterfaceC0779c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rI() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rJ() {
                }
            });
            this.ihi.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void csa() {
                    if (VideoMiddlePageAdView.this.lOO != null && VideoMiddlePageAdView.this.lOO.video != null && VideoMiddlePageAdView.this.lOO.video.video_height.intValue() > VideoMiddlePageAdView.this.lOO.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.ihi.aw(false, true);
                    } else {
                        VideoMiddlePageAdView.this.ihi.aw(false, true);
                    }
                    if (VideoMiddlePageAdView.this.lOU != null) {
                        VideoMiddlePageAdView.this.lOU.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.GJ(VideoMiddlePageAdView.this.eiU ? 0 : 1);
                    VideoMiddlePageAdView.this.lOW = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void csb() {
                }
            });
            this.ihi.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void oN(boolean z) {
                    VideoMiddlePageAdView.this.ihi.fK(VideoMiddlePageAdView.this.lOO.video.video_url, "");
                    if (VideoMiddlePageAdView.this.lOU != null) {
                        VideoMiddlePageAdView.this.lOU.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.GJ(1);
                    VideoMiddlePageAdView.this.lOW = false;
                }
            });
            this.ihi.vb(false);
            this.ihi.cQw();
            this.ihi.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.ihi.cDc();
                    if (VideoMiddlePageAdView.this.lOT != null) {
                        VideoMiddlePageAdView.this.lOT.dsc();
                    }
                    VideoMiddlePageAdView.this.GK(VideoMiddlePageAdView.this.eiU ? 0 : 1);
                    VideoMiddlePageAdView.this.lOX = true;
                }
            });
            this.ihi.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.GL(VideoMiddlePageAdView.this.eiU ? 0 : 1);
                    return true;
                }
            });
            this.ihi.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.ihi.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.ihi.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void csd() {
                    VideoMiddlePageAdView.this.df(1, VideoMiddlePageAdView.this.ihi.getCurrentPosition());
                }
            });
            this.ihi.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.de(1, VideoMiddlePageAdView.this.ihi.getCurrentPosition());
                    VideoMiddlePageAdView.this.lOX = true;
                }
            });
            this.ihi.cDc();
            this.ihi.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.iDy.diX()) {
                    this.ihi.vh(false);
                    this.iDy.dIq();
                    this.ihi.vi(true);
                    this.ihi.fJ(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.ihi.vi(false);
                    this.ihi.vh(false);
                    this.iDy.hide();
                    this.ihi.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.lOT != null) {
                    this.lOT.vz(true);
                }
                if (i == 0) {
                    this.iDt.setVisibility(8);
                    this.lOK.setVisibility(8);
                } else {
                    this.iDt.startAnimation(this.bDF);
                    this.lOK.startAnimation(this.bDF);
                }
                if (i == 0) {
                    this.lOY.zw(3);
                    return;
                } else {
                    this.lOY.zw(0);
                    return;
                }
            }
            this.iDy.hide();
            this.ihi.vh(true);
            this.lOY.zw(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.iDt.startAnimation(this.bDF);
                this.lOK.startAnimation(this.bDF);
                return;
            }
            this.iDt.setVisibility(0);
            this.lOK.setVisibility(0);
        }
    }

    private boolean cxy() {
        try {
            int intValue = this.lOO.video.video_width.intValue();
            return intValue <= 0 || ((float) this.lOO.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.igV.setTextColor(this.ehG.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lON.setTextColor(this.ehG.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lOP.setTextColor(this.ehG.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lOQ.setTextColor(this.ehG.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.lOQ, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cxz() {
        if (!cxy()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igT.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.igT.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.igT.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.igT.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lOO = videoMiddlePageAdCard;
        cxz();
        this.igV.setText(videoMiddlePageAdCard.threadTitle);
        this.ajb.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.iha.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.iha.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.iha.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bnq() || VideoMiddlePageAdView.this.lOO == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.lOO.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.ehG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.lON.setText(videoMiddlePageAdCard.tagName);
        this.lOP.setText(videoMiddlePageAdCard.operateData.lMJ);
        this.lOQ.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.lOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.ehG, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.lOO == null || VideoMiddlePageAdView.this.lOO.getAdFacadeData() == null || VideoMiddlePageAdView.this.lOO.getAdFacadeData().rq() == null) ? null : VideoMiddlePageAdView.this.lOO.getAdFacadeData().rq().dYt);
                if (VideoMiddlePageAdView.this.lOT != null) {
                    VideoMiddlePageAdView.this.lOT.vz(false);
                }
                if (VideoMiddlePageAdView.this.jXT != null) {
                    VideoMiddlePageAdView.this.jXT.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.lOO, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lOT = this.lOS.a(videoMiddlePageAdCard.tailFrame, this.lOT);
        if (this.lOT != null) {
            b(this.lOO.getAdFacadeData());
            this.lOT.setPageContext(this.ehG);
            this.lOT.setTimeoutListener(this);
            this.lOT.a(videoMiddlePageAdCard.tailFrame);
            this.lOT.c(this.lOO);
            this.lOT.dsd();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.YJ = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.YJ;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.iDv = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.lOU = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bH(View view) {
        this.YJ.xZ(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        crY();
        if (this.iDt != null) {
            this.iDt.clearAnimation();
        }
        if (this.lOK != null) {
            this.lOK.clearAnimation();
        }
    }

    public void crX() {
        this.ihi.stopPlay();
        if (this.igV != null) {
            this.igV.setVisibility(0);
        }
        if (this.lOY != null) {
            this.lOY.zw(2);
        }
        this.lOW = false;
        this.lOX = true;
    }

    public void crY() {
        if (this.ihi != null) {
            this.ihi.destroy();
        }
        this.lOW = false;
        this.lOX = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDt && this.iDt.getVisibility() == 0) {
            if (this.iDv != null) {
                this.iDv.zA(this.mPosition);
            }
        } else if (view == this.lOK && this.lOK.getVisibility() == 0) {
            if (this.iDv != null) {
                this.iDv.zA(this.mPosition);
            }
        } else if (view == this.lOM || view == this.lOL) {
            if (this.iDt.getVisibility() == 0) {
                if (this.iDv != null) {
                    this.iDv.zA(this.mPosition);
                    return;
                }
                return;
            }
            this.lOY.zw(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            drr();
        } else {
            int c = s.c(this.ehG, this.lOO.getScheme(), (this.lOO.getAdFacadeData() == null || this.lOO.getAdFacadeData().rq() == null) ? null : this.lOO.getAdFacadeData().rq().dYt);
            if (this.jXT != null) {
                this.jXT.d(c, null);
            }
            if (this.lOT != null) {
                this.lOT.vz(false);
            }
        }
    }

    private void drr() {
        if (this.ehG != null && this.ehG.getPageActivity() != null && this.lOO != null && this.lOO.getAdFacadeData() != null && !TextUtils.isEmpty(this.lOO.getScheme())) {
            String scheme = this.lOO.getScheme();
            AdvertAppInfo rq = this.lOO.getAdFacadeData().rq();
            boolean aV = s.PL(this.lOO.getScheme()) ? s.aV(this.ehG.getPageActivity(), scheme) : false;
            if (this.jXT != null) {
                this.jXT.d(aV ? 1 : 2, null);
            }
            if (this.lOT != null) {
                this.lOT.vz(false);
            }
            if (!aV) {
                String PM = s.PM(scheme);
                NewWebVideoActivity.a(rq, this.lOO.getAdFacadeData().Yv != null ? this.lOO.getAdFacadeData().Yv.rm() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.ehG.getPageActivity(), "", PM, true, true, true, this.lOO.video.video_url, this.lOO.video.thumbnail_url, 1.7777778f, this.lOV, this.lOO.getAdFacadeData().rq().dYt);
                newWebVideoActivityConfig.setTailFrame(this.lOO.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.sx(this.ihi.getCurrentPosition()) < this.lOV && this.ihi.rK()) {
            de(this.eiU ? 0 : 1, this.ihi.getCurrentPosition());
        }
        crX();
        this.lOT.vz(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aII() {
        if (isPlaying()) {
            this.ihi.aII();
            de(this.eiU ? 0 : 1, this.ihi.getCurrentPosition());
            this.lOX = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.ihi.rK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ(int i) {
        if (this.lOO != null && this.lOO.video != null && this.lOO.getAdFacadeData() != null && this.lOX) {
            com.baidu.tieba.recapp.report.d.drV().a(g.a(this.lOO.getAdFacadeData(), 31, this.lOO.getAdFacadeData().getPageNum(), i, this.lOV, 0, -1));
            this.lOX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK(int i) {
        if (this.lOO != null && this.lOO.video != null && this.lOO.getAdFacadeData() != null && !this.lOW) {
            com.baidu.tieba.recapp.report.d.drV().a(g.a(this.lOO.getAdFacadeData(), 34, this.lOO.getAdFacadeData().getPageNum(), i, this.lOV, this.lOV, -1));
            this.lOW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GL(int i) {
        if (this.lOO != null && this.lOO.video != null && this.lOO.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.drV().a(g.a(this.lOO.getAdFacadeData(), 36, this.lOO.getAdFacadeData().getPageNum(), i, this.lOV, com.baidu.tieba.ad.a.a.sx(this.ihi.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(int i, int i2) {
        if (this.lOO != null && this.lOO.video != null && this.lOO.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.drV().a(g.a(this.lOO.getAdFacadeData(), 32, this.lOO.getAdFacadeData().getPageNum(), i, this.lOV, com.baidu.tieba.ad.a.a.sx(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(int i, int i2) {
        if (this.lOO != null && this.lOO.video != null && this.lOO.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.drV().a(g.a(this.lOO.getAdFacadeData(), 33, this.lOO.getAdFacadeData().getPageNum(), i, this.lOV, com.baidu.tieba.ad.a.a.sx(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.lOO.getAdFacadeData(), 303, this.lOO.getAdFacadeData().getPageNum(), this.eiU ? 0 : 1, this.lOO.video.video_duration.intValue(), 0, -1);
            if (this.lOT != null) {
                this.lOT.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(boolean z) {
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
    /* loaded from: classes25.dex */
    public class a {
        private int bOf = -1;
        private Runnable iDM = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.iDM);
                a.this.zw(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void zw(int i) {
            switch (i) {
                case 0:
                    this.bOf = zx(i);
                    cxJ();
                    return;
                case 1:
                    this.bOf = zx(i);
                    this.mHandler.removeCallbacks(this.iDM);
                    return;
                case 2:
                    this.bOf = zy(i);
                    return;
                case 3:
                    this.bOf = zz(i);
                    cxJ();
                    return;
                default:
                    this.bOf = zy(i);
                    return;
            }
        }

        private void cxJ() {
            this.mHandler.removeCallbacks(this.iDM);
            this.mHandler.postDelayed(this.iDM, IMConnection.RETRY_DELAY_TIMES);
        }

        private int zx(int i) {
            if (i != this.bOf) {
                VideoMiddlePageAdView.this.lOM.setVisibility(8);
                VideoMiddlePageAdView.this.lOL.setVisibility(8);
                VideoMiddlePageAdView.this.vx(true);
                return i;
            }
            return this.bOf;
        }

        private int zy(int i) {
            int i2 = this.bOf;
            if (i != this.bOf) {
                VideoMiddlePageAdView.this.lOM.setVisibility(0);
                VideoMiddlePageAdView.this.lOL.setVisibility(0);
                if (VideoMiddlePageAdView.this.ihi != null) {
                    VideoMiddlePageAdView.this.ihi.dnr();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.lOO.autoPlay) {
                    VideoMiddlePageAdView.this.vx(false);
                    return i;
                }
                return i;
            }
            return this.bOf;
        }

        private int zz(int i) {
            if (i != this.bOf) {
                VideoMiddlePageAdView.this.lOM.setVisibility(0);
                VideoMiddlePageAdView.this.lOL.setVisibility(0);
                VideoMiddlePageAdView.this.vx(true);
                return i;
            }
            return this.bOf;
        }
    }
}
