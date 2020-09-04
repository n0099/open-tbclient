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
    private com.baidu.tieba.frs.aggregation.a Yr;
    public TextView aiH;
    private Animation bAh;
    private Animation bAi;
    private boolean egF;
    public FrameLayout hZP;
    public FrameLayout hZQ;
    public TextView hZR;
    public HeadImageView hZW;
    public c iad;
    private View ivR;
    private View ivX;
    private com.baidu.tieba.frs.videomiddlepage.c ivZ;
    private VideoNetworkStateTipView iwc;
    private Animation.AnimationListener iwj;
    private Animation.AnimationListener iwk;
    private View lFQ;
    private View lFR;
    private View lFS;
    public TextView lFT;
    private VideoMiddlePageAdCard lFU;
    private TextView lFV;
    private TextView lFW;
    private ViewGroup lFX;
    private d lFY;
    private e lFZ;
    private f lGa;
    private int lGb;
    private boolean lGc;
    private boolean lGd;
    private a lGe;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lGc = false;
        this.lGd = true;
        this.iwj = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ivX != null) {
                    VideoMiddlePageAdView.this.ivX.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lFQ != null) {
                    VideoMiddlePageAdView.this.lFQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ivX != null) {
                    VideoMiddlePageAdView.this.ivX.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lFQ != null) {
                    VideoMiddlePageAdView.this.lFQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iwk = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ivX != null) {
                    VideoMiddlePageAdView.this.ivX.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lFQ != null) {
                    VideoMiddlePageAdView.this.lFQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ivX != null) {
                    VideoMiddlePageAdView.this.ivX.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lFQ != null) {
                    VideoMiddlePageAdView.this.lFQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lGc = false;
        this.lGd = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hZP = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.ivR = this.rootView.findViewById(R.id.card_container);
        this.hZQ = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.iad = new c(this.efr, this.hZQ, false);
        this.iad.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.iad.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.iad != null && VideoMiddlePageAdView.this.iad.getVideoView() != null) {
                    VideoMiddlePageAdView.this.lGb = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.iad.getVideoView().getDuration());
                }
            }
        });
        this.iad.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void pn(boolean z) {
                if (VideoMiddlePageAdView.this.lGe != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.lGe.yY(0);
                    } else {
                        VideoMiddlePageAdView.this.lGe.yY(1);
                    }
                }
            }
        });
        this.iad.jPO.setOnTouchListener(null);
        this.hZR = (TextView) this.rootView.findViewById(R.id.title);
        this.hZW = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hZW.setIsRound(true);
        this.hZW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hZW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hZW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.lFT = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.aiH = (TextView) this.rootView.findViewById(R.id.user_name);
        this.lFV = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.lFW = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.lFX = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.lFY = new d(this.efr.getPageActivity(), this.lFX);
        this.lFY.page = 1;
        this.iwc = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.iwc.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.iwc.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.iad.va(false);
                VideoMiddlePageAdView.this.iwc.dEx();
                if (VideoMiddlePageAdView.this.lFU != null && VideoMiddlePageAdView.this.lFU.video != null) {
                    VideoMiddlePageAdView.this.iad.fx(VideoMiddlePageAdView.this.lFU.video.video_url, "");
                }
            }
        });
        this.ivX = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.lFR = this.rootView.findViewById(R.id.user_container_foreground);
        this.lFS = this.rootView.findViewById(R.id.title_foreground);
        this.lFQ = this.rootView.findViewById(R.id.operate_area_foreground);
        this.ivX.setOnClickListener(this);
        this.lFR.setOnClickListener(this);
        this.lFS.setOnClickListener(this);
        this.lFQ.setOnClickListener(this);
        this.hZQ.setOnClickListener(this);
        this.hZP.setOnClickListener(this);
        this.iad.ab(this);
        this.hZR.setOnClickListener(this);
        this.hZW.setOnClickListener(this);
        this.aiH.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.efr.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hZP.setLayoutParams(layoutParams);
        this.bAh = new AlphaAnimation(0.0f, 0.7f);
        this.bAh.setDuration(500L);
        this.bAh.setAnimationListener(this.iwk);
        this.bAi = new AlphaAnimation(0.7f, 0.0f);
        this.bAi.setDuration(500L);
        this.bAi.setAnimationListener(this.iwj);
        this.rootView.setOnClickListener(this);
        this.lGe = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMq() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.egF = this.lFU.autoPlay;
            this.lGc = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.lGb = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.iad.rF()) {
                db(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.iad.getCurrentPosition());
                this.lGd = true;
            }
            this.iad.stopPlay();
            this.iad.vb(true);
            this.iad.uX(false);
            this.iad.vc(true);
            this.iad.au(false, true);
            this.iad.FE(i);
            this.iad.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                }
            });
            this.iad.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void coN() {
                    if (VideoMiddlePageAdView.this.lFU != null && VideoMiddlePageAdView.this.lFU.video != null && VideoMiddlePageAdView.this.lFU.video.video_height.intValue() > VideoMiddlePageAdView.this.lFU.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.iad.au(false, true);
                    } else {
                        VideoMiddlePageAdView.this.iad.au(false, true);
                    }
                    if (VideoMiddlePageAdView.this.lGa != null) {
                        VideoMiddlePageAdView.this.lGa.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Gi(VideoMiddlePageAdView.this.egF ? 0 : 1);
                    VideoMiddlePageAdView.this.lGc = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void coO() {
                }
            });
            this.iad.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void oH(boolean z) {
                    VideoMiddlePageAdView.this.iad.fx(VideoMiddlePageAdView.this.lFU.video.video_url, "");
                    if (VideoMiddlePageAdView.this.lGa != null) {
                        VideoMiddlePageAdView.this.lGa.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Gi(1);
                    VideoMiddlePageAdView.this.lGc = false;
                }
            });
            this.iad.uT(false);
            this.iad.cMR();
            this.iad.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.iad.czv();
                    if (VideoMiddlePageAdView.this.lFZ != null) {
                        VideoMiddlePageAdView.this.lFZ.dos();
                    }
                    VideoMiddlePageAdView.this.Gj(VideoMiddlePageAdView.this.egF ? 0 : 1);
                    VideoMiddlePageAdView.this.lGd = true;
                }
            });
            this.iad.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Gk(VideoMiddlePageAdView.this.egF ? 0 : 1);
                    return true;
                }
            });
            this.iad.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.iad.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.iad.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void coQ() {
                    VideoMiddlePageAdView.this.dc(1, VideoMiddlePageAdView.this.iad.getCurrentPosition());
                }
            });
            this.iad.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.db(1, VideoMiddlePageAdView.this.iad.getCurrentPosition());
                    VideoMiddlePageAdView.this.lGd = true;
                }
            });
            this.iad.czv();
            this.iad.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.iwc.dft()) {
                    this.iad.uZ(false);
                    this.iwc.dEw();
                    this.iad.va(true);
                    this.iad.fw(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.iad.va(false);
                    this.iad.uZ(false);
                    this.iwc.hide();
                    this.iad.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.lFZ != null) {
                    this.lFZ.vr(true);
                }
                if (i == 0) {
                    this.ivX.setVisibility(8);
                    this.lFQ.setVisibility(8);
                } else {
                    this.ivX.startAnimation(this.bAi);
                    this.lFQ.startAnimation(this.bAi);
                }
                if (i == 0) {
                    this.lGe.yY(3);
                    return;
                } else {
                    this.lGe.yY(0);
                    return;
                }
            }
            this.iwc.hide();
            this.iad.uZ(true);
            this.lGe.yY(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.ivX.startAnimation(this.bAi);
                this.lFQ.startAnimation(this.bAi);
                return;
            }
            this.ivX.setVisibility(0);
            this.lFQ.setVisibility(0);
        }
    }

    private boolean cuf() {
        try {
            int intValue = this.lFU.video.video_width.intValue();
            return intValue <= 0 || ((float) this.lFU.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hZR.setTextColor(this.efr.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lFT.setTextColor(this.efr.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lFV.setTextColor(this.efr.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lFW.setTextColor(this.efr.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.lFW, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cug() {
        if (!cuf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hZP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hZP.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lFU = videoMiddlePageAdCard;
        cug();
        this.hZR.setText(videoMiddlePageAdCard.threadTitle);
        this.aiH.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hZW.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hZW.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hZW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bmw() || VideoMiddlePageAdView.this.lFU == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.lFU.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.efr.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.lFT.setText(videoMiddlePageAdCard.tagName);
        this.lFV.setText(videoMiddlePageAdCard.operateData.lDP);
        this.lFW.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.lFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.efr, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.lFU == null || VideoMiddlePageAdView.this.lFU.getAdFacadeData() == null || VideoMiddlePageAdView.this.lFU.getAdFacadeData().rl() == null) ? null : VideoMiddlePageAdView.this.lFU.getAdFacadeData().rl().dWj);
                if (VideoMiddlePageAdView.this.lFZ != null) {
                    VideoMiddlePageAdView.this.lFZ.vr(false);
                }
                if (VideoMiddlePageAdView.this.jPq != null) {
                    VideoMiddlePageAdView.this.jPq.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.lFU, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lFZ = this.lFY.a(videoMiddlePageAdCard.tailFrame, this.lFZ);
        if (this.lFZ != null) {
            b(this.lFU.getAdFacadeData());
            this.lFZ.setPageContext(this.efr);
            this.lFZ.setTimeoutListener(this);
            this.lFZ.a(videoMiddlePageAdCard.tailFrame);
            this.lFZ.c(this.lFU);
            this.lFZ.dot();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Yr = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Yr;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.ivZ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.lGa = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bD(View view) {
        this.Yr.xA(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        coL();
        if (this.ivX != null) {
            this.ivX.clearAnimation();
        }
        if (this.lFQ != null) {
            this.lFQ.clearAnimation();
        }
    }

    public void coK() {
        this.iad.stopPlay();
        if (this.hZR != null) {
            this.hZR.setVisibility(0);
        }
        if (this.lGe != null) {
            this.lGe.yY(2);
        }
        this.lGc = false;
        this.lGd = true;
    }

    public void coL() {
        if (this.iad != null) {
            this.iad.destroy();
        }
        this.lGc = false;
        this.lGd = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivX && this.ivX.getVisibility() == 0) {
            if (this.ivZ != null) {
                this.ivZ.zc(this.mPosition);
            }
        } else if (view == this.lFQ && this.lFQ.getVisibility() == 0) {
            if (this.ivZ != null) {
                this.ivZ.zc(this.mPosition);
            }
        } else if (view == this.lFS || view == this.lFR) {
            if (this.ivX.getVisibility() == 0) {
                if (this.ivZ != null) {
                    this.ivZ.zc(this.mPosition);
                    return;
                }
                return;
            }
            this.lGe.yY(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dnI();
        } else {
            int c = s.c(this.efr, this.lFU.getScheme(), (this.lFU.getAdFacadeData() == null || this.lFU.getAdFacadeData().rl() == null) ? null : this.lFU.getAdFacadeData().rl().dWj);
            if (this.jPq != null) {
                this.jPq.d(c, null);
            }
            if (this.lFZ != null) {
                this.lFZ.vr(false);
            }
        }
    }

    private void dnI() {
        if (this.efr != null && this.efr.getPageActivity() != null && this.lFU != null && this.lFU.getAdFacadeData() != null && !TextUtils.isEmpty(this.lFU.getScheme())) {
            String scheme = this.lFU.getScheme();
            AdvertAppInfo rl = this.lFU.getAdFacadeData().rl();
            boolean aS = s.Pl(this.lFU.getScheme()) ? s.aS(this.efr.getPageActivity(), scheme) : false;
            if (this.jPq != null) {
                this.jPq.d(aS ? 1 : 2, null);
            }
            if (this.lFZ != null) {
                this.lFZ.vr(false);
            }
            if (!aS) {
                String Pm = s.Pm(scheme);
                NewWebVideoActivity.a(rl, this.lFU.getAdFacadeData().Yc != null ? this.lFU.getAdFacadeData().Yc.rh() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.efr.getPageActivity(), "", Pm, true, true, true, this.lFU.video.video_url, this.lFU.video.thumbnail_url, 1.7777778f, this.lGb, this.lFU.getAdFacadeData().rl().dWj);
                newWebVideoActivityConfig.setTailFrame(this.lFU.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.sf(this.iad.getCurrentPosition()) < this.lGb && this.iad.rF()) {
            db(this.egF ? 0 : 1, this.iad.getCurrentPosition());
        }
        coK();
        this.lFZ.vr(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aHX() {
        if (isPlaying()) {
            this.iad.aHX();
            db(this.egF ? 0 : 1, this.iad.getCurrentPosition());
            this.lGd = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iad.rF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi(int i) {
        if (this.lFU != null && this.lFU.video != null && this.lFU.getAdFacadeData() != null && this.lGd) {
            com.baidu.tieba.recapp.report.d.dol().a(g.a(this.lFU.getAdFacadeData(), 31, this.lFU.getAdFacadeData().getPageNum(), i, this.lGb, 0, -1));
            this.lGd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj(int i) {
        if (this.lFU != null && this.lFU.video != null && this.lFU.getAdFacadeData() != null && !this.lGc) {
            com.baidu.tieba.recapp.report.d.dol().a(g.a(this.lFU.getAdFacadeData(), 34, this.lFU.getAdFacadeData().getPageNum(), i, this.lGb, this.lGb, -1));
            this.lGc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk(int i) {
        if (this.lFU != null && this.lFU.video != null && this.lFU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dol().a(g.a(this.lFU.getAdFacadeData(), 36, this.lFU.getAdFacadeData().getPageNum(), i, this.lGb, com.baidu.tieba.ad.a.a.sf(this.iad.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i, int i2) {
        if (this.lFU != null && this.lFU.video != null && this.lFU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dol().a(g.a(this.lFU.getAdFacadeData(), 32, this.lFU.getAdFacadeData().getPageNum(), i, this.lGb, com.baidu.tieba.ad.a.a.sf(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(int i, int i2) {
        if (this.lFU != null && this.lFU.video != null && this.lFU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dol().a(g.a(this.lFU.getAdFacadeData(), 33, this.lFU.getAdFacadeData().getPageNum(), i, this.lGb, com.baidu.tieba.ad.a.a.sf(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.lFU.getAdFacadeData(), 303, this.lFU.getAdFacadeData().getPageNum(), this.egF ? 0 : 1, this.lFU.video.video_duration.intValue(), 0, -1);
            if (this.lFZ != null) {
                this.lFZ.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp(boolean z) {
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
        private int bMf = -1;
        private Runnable iwq = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.iwq);
                a.this.yY(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void yY(int i) {
            switch (i) {
                case 0:
                    this.bMf = yZ(i);
                    cuq();
                    return;
                case 1:
                    this.bMf = yZ(i);
                    this.mHandler.removeCallbacks(this.iwq);
                    return;
                case 2:
                    this.bMf = za(i);
                    return;
                case 3:
                    this.bMf = zb(i);
                    cuq();
                    return;
                default:
                    this.bMf = za(i);
                    return;
            }
        }

        private void cuq() {
            this.mHandler.removeCallbacks(this.iwq);
            this.mHandler.postDelayed(this.iwq, IMConnection.RETRY_DELAY_TIMES);
        }

        private int yZ(int i) {
            if (i != this.bMf) {
                VideoMiddlePageAdView.this.lFS.setVisibility(8);
                VideoMiddlePageAdView.this.lFR.setVisibility(8);
                VideoMiddlePageAdView.this.vp(true);
                return i;
            }
            return this.bMf;
        }

        private int za(int i) {
            int i2 = this.bMf;
            if (i != this.bMf) {
                VideoMiddlePageAdView.this.lFS.setVisibility(0);
                VideoMiddlePageAdView.this.lFR.setVisibility(0);
                if (VideoMiddlePageAdView.this.iad != null) {
                    VideoMiddlePageAdView.this.iad.djM();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.lFU.autoPlay) {
                    VideoMiddlePageAdView.this.vp(false);
                    return i;
                }
                return i;
            }
            return this.bMf;
        }

        private int zb(int i) {
            if (i != this.bMf) {
                VideoMiddlePageAdView.this.lFS.setVisibility(0);
                VideoMiddlePageAdView.this.lFR.setVisibility(0);
                VideoMiddlePageAdView.this.vp(true);
                return i;
            }
            return this.bMf;
        }
    }
}
