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
/* loaded from: classes20.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Yp;
    public TextView aiF;
    private Animation bAe;
    private Animation bAf;
    private boolean egB;
    public FrameLayout hZJ;
    public FrameLayout hZK;
    public TextView hZL;
    public HeadImageView hZQ;
    public c hZX;
    private View ivL;
    private View ivR;
    private com.baidu.tieba.frs.videomiddlepage.c ivT;
    private VideoNetworkStateTipView ivW;
    private Animation.AnimationListener iwd;
    private Animation.AnimationListener iwe;
    private View lFD;
    private View lFE;
    private View lFF;
    public TextView lFG;
    private VideoMiddlePageAdCard lFH;
    private TextView lFI;
    private TextView lFJ;
    private ViewGroup lFK;
    private d lFL;
    private e lFM;
    private f lFN;
    private int lFO;
    private boolean lFP;
    private boolean lFQ;
    private a lFR;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lFP = false;
        this.lFQ = true;
        this.iwd = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ivR != null) {
                    VideoMiddlePageAdView.this.ivR.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lFD != null) {
                    VideoMiddlePageAdView.this.lFD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ivR != null) {
                    VideoMiddlePageAdView.this.ivR.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lFD != null) {
                    VideoMiddlePageAdView.this.lFD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iwe = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ivR != null) {
                    VideoMiddlePageAdView.this.ivR.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lFD != null) {
                    VideoMiddlePageAdView.this.lFD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ivR != null) {
                    VideoMiddlePageAdView.this.ivR.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lFD != null) {
                    VideoMiddlePageAdView.this.lFD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lFP = false;
        this.lFQ = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hZJ = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.ivL = this.rootView.findViewById(R.id.card_container);
        this.hZK = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hZX = new c(this.efn, this.hZK, false);
        this.hZX.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.hZX.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.hZX != null && VideoMiddlePageAdView.this.hZX.getVideoView() != null) {
                    VideoMiddlePageAdView.this.lFO = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hZX.getVideoView().getDuration());
                }
            }
        });
        this.hZX.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void pl(boolean z) {
                if (VideoMiddlePageAdView.this.lFR != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.lFR.yY(0);
                    } else {
                        VideoMiddlePageAdView.this.lFR.yY(1);
                    }
                }
            }
        });
        this.hZX.jPI.setOnTouchListener(null);
        this.hZL = (TextView) this.rootView.findViewById(R.id.title);
        this.hZQ = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hZQ.setIsRound(true);
        this.hZQ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hZQ.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hZQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.lFG = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.aiF = (TextView) this.rootView.findViewById(R.id.user_name);
        this.lFI = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.lFJ = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.lFK = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.lFL = new d(this.efn.getPageActivity(), this.lFK);
        this.lFL.page = 1;
        this.ivW = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.ivW.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.ivW.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hZX.uY(false);
                VideoMiddlePageAdView.this.ivW.dEo();
                if (VideoMiddlePageAdView.this.lFH != null && VideoMiddlePageAdView.this.lFH.video != null) {
                    VideoMiddlePageAdView.this.hZX.fw(VideoMiddlePageAdView.this.lFH.video.video_url, "");
                }
            }
        });
        this.ivR = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.lFE = this.rootView.findViewById(R.id.user_container_foreground);
        this.lFF = this.rootView.findViewById(R.id.title_foreground);
        this.lFD = this.rootView.findViewById(R.id.operate_area_foreground);
        this.ivR.setOnClickListener(this);
        this.lFE.setOnClickListener(this);
        this.lFF.setOnClickListener(this);
        this.lFD.setOnClickListener(this);
        this.hZK.setOnClickListener(this);
        this.hZJ.setOnClickListener(this);
        this.hZX.ab(this);
        this.hZL.setOnClickListener(this);
        this.hZQ.setOnClickListener(this);
        this.aiF.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.efn.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZJ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hZJ.setLayoutParams(layoutParams);
        this.bAe = new AlphaAnimation(0.0f, 0.7f);
        this.bAe.setDuration(500L);
        this.bAe.setAnimationListener(this.iwe);
        this.bAf = new AlphaAnimation(0.7f, 0.0f);
        this.bAf.setDuration(500L);
        this.bAf.setAnimationListener(this.iwd);
        this.rootView.setOnClickListener(this);
        this.lFR = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMp() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.egB = this.lFH.autoPlay;
            this.lFP = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.lFO = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hZX.rF()) {
                db(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hZX.getCurrentPosition());
                this.lFQ = true;
            }
            this.hZX.stopPlay();
            this.hZX.uZ(true);
            this.hZX.uV(false);
            this.hZX.va(true);
            this.hZX.au(false, true);
            this.hZX.FE(i);
            this.hZX.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                }
            });
            this.hZX.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void coM() {
                    if (VideoMiddlePageAdView.this.lFH != null && VideoMiddlePageAdView.this.lFH.video != null && VideoMiddlePageAdView.this.lFH.video.video_height.intValue() > VideoMiddlePageAdView.this.lFH.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hZX.au(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hZX.au(false, true);
                    }
                    if (VideoMiddlePageAdView.this.lFN != null) {
                        VideoMiddlePageAdView.this.lFN.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Gi(VideoMiddlePageAdView.this.egB ? 0 : 1);
                    VideoMiddlePageAdView.this.lFP = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void coN() {
                }
            });
            this.hZX.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void oF(boolean z) {
                    VideoMiddlePageAdView.this.hZX.fw(VideoMiddlePageAdView.this.lFH.video.video_url, "");
                    if (VideoMiddlePageAdView.this.lFN != null) {
                        VideoMiddlePageAdView.this.lFN.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Gi(1);
                    VideoMiddlePageAdView.this.lFP = false;
                }
            });
            this.hZX.uR(false);
            this.hZX.cMQ();
            this.hZX.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.hZX.czu();
                    if (VideoMiddlePageAdView.this.lFM != null) {
                        VideoMiddlePageAdView.this.lFM.dop();
                    }
                    VideoMiddlePageAdView.this.Gj(VideoMiddlePageAdView.this.egB ? 0 : 1);
                    VideoMiddlePageAdView.this.lFQ = true;
                }
            });
            this.hZX.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Gk(VideoMiddlePageAdView.this.egB ? 0 : 1);
                    return true;
                }
            });
            this.hZX.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hZX.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hZX.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void coP() {
                    VideoMiddlePageAdView.this.dc(1, VideoMiddlePageAdView.this.hZX.getCurrentPosition());
                }
            });
            this.hZX.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.db(1, VideoMiddlePageAdView.this.hZX.getCurrentPosition());
                    VideoMiddlePageAdView.this.lFQ = true;
                }
            });
            this.hZX.czu();
            this.hZX.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.ivW.dfs()) {
                    this.hZX.uX(false);
                    this.ivW.dEn();
                    this.hZX.uY(true);
                    this.hZX.fv(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hZX.uY(false);
                    this.hZX.uX(false);
                    this.ivW.hide();
                    this.hZX.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.lFM != null) {
                    this.lFM.vp(true);
                }
                if (i == 0) {
                    this.ivR.setVisibility(8);
                    this.lFD.setVisibility(8);
                } else {
                    this.ivR.startAnimation(this.bAf);
                    this.lFD.startAnimation(this.bAf);
                }
                if (i == 0) {
                    this.lFR.yY(3);
                    return;
                } else {
                    this.lFR.yY(0);
                    return;
                }
            }
            this.ivW.hide();
            this.hZX.uX(true);
            this.lFR.yY(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.ivR.startAnimation(this.bAf);
                this.lFD.startAnimation(this.bAf);
                return;
            }
            this.ivR.setVisibility(0);
            this.lFD.setVisibility(0);
        }
    }

    private boolean cue() {
        try {
            int intValue = this.lFH.video.video_width.intValue();
            return intValue <= 0 || ((float) this.lFH.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hZL.setTextColor(this.efn.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lFG.setTextColor(this.efn.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lFI.setTextColor(this.efn.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lFJ.setTextColor(this.efn.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.lFJ, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cuf() {
        if (!cue()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZJ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hZJ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZJ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hZJ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lFH = videoMiddlePageAdCard;
        cuf();
        this.hZL.setText(videoMiddlePageAdCard.threadTitle);
        this.aiF.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hZQ.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hZQ.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hZQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bmw() || VideoMiddlePageAdView.this.lFH == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.lFH.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.efn.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.lFG.setText(videoMiddlePageAdCard.tagName);
        this.lFI.setText(videoMiddlePageAdCard.operateData.lDE);
        this.lFJ.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.lFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.efn, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.lFH == null || VideoMiddlePageAdView.this.lFH.getAdFacadeData() == null || VideoMiddlePageAdView.this.lFH.getAdFacadeData().rl() == null) ? null : VideoMiddlePageAdView.this.lFH.getAdFacadeData().rl().dWf);
                if (VideoMiddlePageAdView.this.lFM != null) {
                    VideoMiddlePageAdView.this.lFM.vp(false);
                }
                if (VideoMiddlePageAdView.this.jPk != null) {
                    VideoMiddlePageAdView.this.jPk.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.lFH, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lFM = this.lFL.a(videoMiddlePageAdCard.tailFrame, this.lFM);
        if (this.lFM != null) {
            b(this.lFH.getAdFacadeData());
            this.lFM.setPageContext(this.efn);
            this.lFM.setTimeoutListener(this);
            this.lFM.a(videoMiddlePageAdCard.tailFrame);
            this.lFM.c(this.lFH);
            this.lFM.doq();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Yp = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Yp;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.ivT = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.lFN = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bD(View view) {
        this.Yp.xA(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        coK();
        if (this.ivR != null) {
            this.ivR.clearAnimation();
        }
        if (this.lFD != null) {
            this.lFD.clearAnimation();
        }
    }

    public void coJ() {
        this.hZX.stopPlay();
        if (this.hZL != null) {
            this.hZL.setVisibility(0);
        }
        if (this.lFR != null) {
            this.lFR.yY(2);
        }
        this.lFP = false;
        this.lFQ = true;
    }

    public void coK() {
        if (this.hZX != null) {
            this.hZX.destroy();
        }
        this.lFP = false;
        this.lFQ = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivR && this.ivR.getVisibility() == 0) {
            if (this.ivT != null) {
                this.ivT.zc(this.mPosition);
            }
        } else if (view == this.lFD && this.lFD.getVisibility() == 0) {
            if (this.ivT != null) {
                this.ivT.zc(this.mPosition);
            }
        } else if (view == this.lFF || view == this.lFE) {
            if (this.ivR.getVisibility() == 0) {
                if (this.ivT != null) {
                    this.ivT.zc(this.mPosition);
                    return;
                }
                return;
            }
            this.lFR.yY(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dnF();
        } else {
            int c = s.c(this.efn, this.lFH.getScheme(), (this.lFH.getAdFacadeData() == null || this.lFH.getAdFacadeData().rl() == null) ? null : this.lFH.getAdFacadeData().rl().dWf);
            if (this.jPk != null) {
                this.jPk.d(c, null);
            }
            if (this.lFM != null) {
                this.lFM.vp(false);
            }
        }
    }

    private void dnF() {
        if (this.efn != null && this.efn.getPageActivity() != null && this.lFH != null && this.lFH.getAdFacadeData() != null && !TextUtils.isEmpty(this.lFH.getScheme())) {
            String scheme = this.lFH.getScheme();
            AdvertAppInfo rl = this.lFH.getAdFacadeData().rl();
            boolean aS = s.Pk(this.lFH.getScheme()) ? s.aS(this.efn.getPageActivity(), scheme) : false;
            if (this.jPk != null) {
                this.jPk.d(aS ? 1 : 2, null);
            }
            if (this.lFM != null) {
                this.lFM.vp(false);
            }
            if (!aS) {
                String Pl = s.Pl(scheme);
                NewWebVideoActivity.a(rl, this.lFH.getAdFacadeData().Ya != null ? this.lFH.getAdFacadeData().Ya.rh() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.efn.getPageActivity(), "", Pl, true, true, true, this.lFH.video.video_url, this.lFH.video.thumbnail_url, 1.7777778f, this.lFO, this.lFH.getAdFacadeData().rl().dWf);
                newWebVideoActivityConfig.setTailFrame(this.lFH.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.sf(this.hZX.getCurrentPosition()) < this.lFO && this.hZX.rF()) {
            db(this.egB ? 0 : 1, this.hZX.getCurrentPosition());
        }
        coJ();
        this.lFM.vp(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aHX() {
        if (isPlaying()) {
            this.hZX.aHX();
            db(this.egB ? 0 : 1, this.hZX.getCurrentPosition());
            this.lFQ = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hZX.rF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi(int i) {
        if (this.lFH != null && this.lFH.video != null && this.lFH.getAdFacadeData() != null && this.lFQ) {
            com.baidu.tieba.recapp.report.d.doi().a(g.a(this.lFH.getAdFacadeData(), 31, this.lFH.getAdFacadeData().getPageNum(), i, this.lFO, 0, -1));
            this.lFQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj(int i) {
        if (this.lFH != null && this.lFH.video != null && this.lFH.getAdFacadeData() != null && !this.lFP) {
            com.baidu.tieba.recapp.report.d.doi().a(g.a(this.lFH.getAdFacadeData(), 34, this.lFH.getAdFacadeData().getPageNum(), i, this.lFO, this.lFO, -1));
            this.lFP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk(int i) {
        if (this.lFH != null && this.lFH.video != null && this.lFH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.doi().a(g.a(this.lFH.getAdFacadeData(), 36, this.lFH.getAdFacadeData().getPageNum(), i, this.lFO, com.baidu.tieba.ad.a.a.sf(this.hZX.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i, int i2) {
        if (this.lFH != null && this.lFH.video != null && this.lFH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.doi().a(g.a(this.lFH.getAdFacadeData(), 32, this.lFH.getAdFacadeData().getPageNum(), i, this.lFO, com.baidu.tieba.ad.a.a.sf(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(int i, int i2) {
        if (this.lFH != null && this.lFH.video != null && this.lFH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.doi().a(g.a(this.lFH.getAdFacadeData(), 33, this.lFH.getAdFacadeData().getPageNum(), i, this.lFO, com.baidu.tieba.ad.a.a.sf(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.lFH.getAdFacadeData(), 303, this.lFH.getAdFacadeData().getPageNum(), this.egB ? 0 : 1, this.lFH.video.video_duration.intValue(), 0, -1);
            if (this.lFM != null) {
                this.lFM.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(boolean z) {
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
    /* loaded from: classes20.dex */
    public class a {
        private int bMb = -1;
        private Runnable iwk = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.iwk);
                a.this.yY(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void yY(int i) {
            switch (i) {
                case 0:
                    this.bMb = yZ(i);
                    cup();
                    return;
                case 1:
                    this.bMb = yZ(i);
                    this.mHandler.removeCallbacks(this.iwk);
                    return;
                case 2:
                    this.bMb = za(i);
                    return;
                case 3:
                    this.bMb = zb(i);
                    cup();
                    return;
                default:
                    this.bMb = za(i);
                    return;
            }
        }

        private void cup() {
            this.mHandler.removeCallbacks(this.iwk);
            this.mHandler.postDelayed(this.iwk, IMConnection.RETRY_DELAY_TIMES);
        }

        private int yZ(int i) {
            if (i != this.bMb) {
                VideoMiddlePageAdView.this.lFF.setVisibility(8);
                VideoMiddlePageAdView.this.lFE.setVisibility(8);
                VideoMiddlePageAdView.this.vn(true);
                return i;
            }
            return this.bMb;
        }

        private int za(int i) {
            int i2 = this.bMb;
            if (i != this.bMb) {
                VideoMiddlePageAdView.this.lFF.setVisibility(0);
                VideoMiddlePageAdView.this.lFE.setVisibility(0);
                if (VideoMiddlePageAdView.this.hZX != null) {
                    VideoMiddlePageAdView.this.hZX.djJ();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.lFH.autoPlay) {
                    VideoMiddlePageAdView.this.vn(false);
                    return i;
                }
                return i;
            }
            return this.bMb;
        }

        private int zb(int i) {
            if (i != this.bMb) {
                VideoMiddlePageAdView.this.lFF.setVisibility(0);
                VideoMiddlePageAdView.this.lFE.setVisibility(0);
                VideoMiddlePageAdView.this.vn(true);
                return i;
            }
            return this.bMb;
        }
    }
}
