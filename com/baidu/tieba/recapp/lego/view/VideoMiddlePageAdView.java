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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.play.c;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes25.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, k, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Zg;
    public TextView ajz;
    private Animation bWB;
    private Animation bWC;
    private boolean eIq;
    public FrameLayout iOW;
    public FrameLayout iOX;
    public TextView iOY;
    public HeadImageView iPd;
    public c iPl;
    private Animation.AnimationListener jlA;
    private View jlh;
    private View jln;
    private com.baidu.tieba.frs.videomiddlepage.c jlp;
    private VideoNetworkStateTipView jls;
    private Animation.AnimationListener jlz;
    private int mWidth;
    private View mwL;
    private View mwM;
    private View mwN;
    public TextView mwO;
    private VideoMiddlePageAdCard mwP;
    private TextView mwQ;
    private TextView mwR;
    private ViewGroup mwS;
    private d mwT;
    private e mwU;
    private f mwV;
    private int mwW;
    private boolean mwX;
    private boolean mwY;
    private a mwZ;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mwX = false;
        this.mwY = true;
        this.jlz = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jln != null) {
                    VideoMiddlePageAdView.this.jln.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mwL != null) {
                    VideoMiddlePageAdView.this.mwL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jln != null) {
                    VideoMiddlePageAdView.this.jln.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mwL != null) {
                    VideoMiddlePageAdView.this.mwL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jlA = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jln != null) {
                    VideoMiddlePageAdView.this.jln.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mwL != null) {
                    VideoMiddlePageAdView.this.mwL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jln != null) {
                    VideoMiddlePageAdView.this.jln.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mwL != null) {
                    VideoMiddlePageAdView.this.mwL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mwX = false;
        this.mwY = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.iOW = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jlh = this.rootView.findViewById(R.id.card_container);
        this.iOX = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.iPl = new c(this.eGu, this.iOX, false);
        this.iPl.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.iPl.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.iPl != null && VideoMiddlePageAdView.this.iPl.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mwW = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.iPl.getVideoView().getDuration());
                }
            }
        });
        this.iPl.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void qC(boolean z) {
                if (VideoMiddlePageAdView.this.mwZ != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mwZ.Bg(0);
                    } else {
                        VideoMiddlePageAdView.this.mwZ.Bg(1);
                    }
                }
            }
        });
        this.iPl.kGn.setOnTouchListener(null);
        this.iOY = (TextView) this.rootView.findViewById(R.id.title);
        this.iPd = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.iPd.setIsRound(true);
        this.iPd.setDefaultBgResource(R.color.CAM_X0205);
        this.iPd.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iPd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.mwO = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ajz = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mwQ = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mwR = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mwS = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mwT = new d(this.eGu.getPageActivity(), this.mwS);
        this.mwT.page = 1;
        this.jls = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jls.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jls.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.iPl.ws(false);
                VideoMiddlePageAdView.this.jls.dRM();
                if (VideoMiddlePageAdView.this.mwP != null && VideoMiddlePageAdView.this.mwP.video != null) {
                    VideoMiddlePageAdView.this.iPl.fW(VideoMiddlePageAdView.this.mwP.video.video_url, "");
                }
            }
        });
        this.jln = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mwM = this.rootView.findViewById(R.id.user_container_foreground);
        this.mwN = this.rootView.findViewById(R.id.title_foreground);
        this.mwL = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jln.setOnClickListener(this);
        this.mwM.setOnClickListener(this);
        this.mwN.setOnClickListener(this);
        this.mwL.setOnClickListener(this);
        this.iOX.setOnClickListener(this);
        this.iOW.setOnClickListener(this);
        this.iPl.ab(this);
        this.iOY.setOnClickListener(this);
        this.iPd.setOnClickListener(this);
        this.ajz.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eGu.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iOW.setLayoutParams(layoutParams);
        this.bWB = new AlphaAnimation(0.0f, 0.7f);
        this.bWB.setDuration(500L);
        this.bWB.setAnimationListener(this.jlA);
        this.bWC = new AlphaAnimation(0.7f, 0.0f);
        this.bWC.setDuration(500L);
        this.bWC.setAnimationListener(this.jlz);
        this.rootView.setOnClickListener(this);
        this.mwZ = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cYK() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eIq = this.mwP.autoPlay;
            this.mwX = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mwW = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.iPl.rK()) {
                di(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.iPl.getCurrentPosition());
                this.mwY = true;
            }
            this.iPl.stopPlay();
            this.iPl.wt(true);
            this.iPl.wp(false);
            this.iPl.wu(true);
            this.iPl.av(false, true);
            this.iPl.HP(i);
            this.iPl.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rI() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rJ() {
                }
            });
            this.iPl.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cAI() {
                    if (VideoMiddlePageAdView.this.mwP != null && VideoMiddlePageAdView.this.mwP.video != null && VideoMiddlePageAdView.this.mwP.video.video_height.intValue() > VideoMiddlePageAdView.this.mwP.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.iPl.av(false, true);
                    } else {
                        VideoMiddlePageAdView.this.iPl.av(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mwV != null) {
                        VideoMiddlePageAdView.this.mwV.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Iw(VideoMiddlePageAdView.this.eIq ? 0 : 1);
                    VideoMiddlePageAdView.this.mwX = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cAJ() {
                }
            });
            this.iPl.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void pW(boolean z) {
                    VideoMiddlePageAdView.this.iPl.fW(VideoMiddlePageAdView.this.mwP.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mwV != null) {
                        VideoMiddlePageAdView.this.mwV.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Iw(1);
                    VideoMiddlePageAdView.this.mwX = false;
                }
            });
            this.iPl.wl(false);
            this.iPl.cZk();
            this.iPl.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.iPl.cMa();
                    if (VideoMiddlePageAdView.this.mwU != null) {
                        VideoMiddlePageAdView.this.mwU.dBa();
                    }
                    VideoMiddlePageAdView.this.Ix(VideoMiddlePageAdView.this.eIq ? 0 : 1);
                    VideoMiddlePageAdView.this.mwY = true;
                }
            });
            this.iPl.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Iy(VideoMiddlePageAdView.this.eIq ? 0 : 1);
                    return true;
                }
            });
            this.iPl.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.iPl.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.iPl.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cAL() {
                    VideoMiddlePageAdView.this.dj(1, VideoMiddlePageAdView.this.iPl.getCurrentPosition());
                }
            });
            this.iPl.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.di(1, VideoMiddlePageAdView.this.iPl.getCurrentPosition());
                    VideoMiddlePageAdView.this.mwY = true;
                }
            });
            this.iPl.cMa();
            this.iPl.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jls.drQ()) {
                    this.iPl.wr(false);
                    this.jls.dRL();
                    this.iPl.ws(true);
                    this.iPl.fV(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.iPl.ws(false);
                    this.iPl.wr(false);
                    this.jls.hide();
                    this.iPl.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mwU != null) {
                    this.mwU.wJ(true);
                }
                if (i == 0) {
                    this.jln.setVisibility(8);
                    this.mwL.setVisibility(8);
                } else {
                    this.jln.startAnimation(this.bWC);
                    this.mwL.startAnimation(this.bWC);
                }
                if (i == 0) {
                    this.mwZ.Bg(3);
                    return;
                } else {
                    this.mwZ.Bg(0);
                    return;
                }
            }
            this.jls.hide();
            this.iPl.wr(true);
            this.mwZ.Bg(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jln.startAnimation(this.bWC);
                this.mwL.startAnimation(this.bWC);
                return;
            }
            this.jln.setVisibility(0);
            this.mwL.setVisibility(0);
        }
    }

    private boolean cGi() {
        try {
            int intValue = this.mwP.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mwP.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.iOY.setTextColor(this.eGu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mwO.setTextColor(this.eGu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mwQ.setTextColor(this.eGu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mwR.setTextColor(this.eGu.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mwR, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cGj() {
        if (!cGi()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOW.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iOW.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iOW.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iOW.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mwP = videoMiddlePageAdCard;
        cGj();
        this.iOY.setText(videoMiddlePageAdCard.threadTitle);
        this.ajz.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.iPd.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.iPd.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.iPd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.btJ() || VideoMiddlePageAdView.this.mwP == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mwP.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eGu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mwO.setText(videoMiddlePageAdCard.tagName);
        this.mwQ.setText(videoMiddlePageAdCard.operateData.muO);
        this.mwR.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mwR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = r.c(VideoMiddlePageAdView.this.eGu, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.mwP == null || VideoMiddlePageAdView.this.mwP.getAdFacadeData() == null || VideoMiddlePageAdView.this.mwP.getAdFacadeData().rq() == null) ? null : VideoMiddlePageAdView.this.mwP.getAdFacadeData().rq().exc);
                if (VideoMiddlePageAdView.this.mwU != null) {
                    VideoMiddlePageAdView.this.mwU.wJ(false);
                }
                if (VideoMiddlePageAdView.this.kFP != null) {
                    VideoMiddlePageAdView.this.kFP.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mwP, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mwU = this.mwT.a(videoMiddlePageAdCard.tailFrame, this.mwU);
        if (this.mwU != null) {
            b(this.mwP.getAdFacadeData());
            this.mwU.setPageContext(this.eGu);
            this.mwU.setTimeoutListener(this);
            this.mwU.a(videoMiddlePageAdCard.tailFrame);
            this.mwU.c(this.mwP);
            this.mwU.dBb();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Zg = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Zg;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jlp = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mwV = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bT(View view) {
        this.Zg.zJ(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cAG();
        if (this.jln != null) {
            this.jln.clearAnimation();
        }
        if (this.mwL != null) {
            this.mwL.clearAnimation();
        }
    }

    public void cAF() {
        this.iPl.stopPlay();
        if (this.iOY != null) {
            this.iOY.setVisibility(0);
        }
        if (this.mwZ != null) {
            this.mwZ.Bg(2);
        }
        this.mwX = false;
        this.mwY = true;
    }

    public void cAG() {
        if (this.iPl != null) {
            this.iPl.destroy();
        }
        this.mwX = false;
        this.mwY = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jln && this.jln.getVisibility() == 0) {
            if (this.jlp != null) {
                this.jlp.Bk(this.mPosition);
            }
        } else if (view == this.mwL && this.mwL.getVisibility() == 0) {
            if (this.jlp != null) {
                this.jlp.Bk(this.mPosition);
            }
        } else if (view == this.mwN || view == this.mwM) {
            if (this.jln.getVisibility() == 0) {
                if (this.jlp != null) {
                    this.jlp.Bk(this.mPosition);
                    return;
                }
                return;
            }
            this.mwZ.Bg(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dAi();
        } else {
            int c = r.c(this.eGu, this.mwP.getScheme(), (this.mwP.getAdFacadeData() == null || this.mwP.getAdFacadeData().rq() == null) ? null : this.mwP.getAdFacadeData().rq().exc);
            if (this.kFP != null) {
                this.kFP.d(c, null);
            }
            if (this.mwU != null) {
                this.mwU.wJ(false);
            }
        }
    }

    private void dAi() {
        if (this.eGu != null && this.eGu.getPageActivity() != null && this.mwP != null && this.mwP.getAdFacadeData() != null && !TextUtils.isEmpty(this.mwP.getScheme())) {
            String scheme = this.mwP.getScheme();
            AdvertAppInfo rq = this.mwP.getAdFacadeData().rq();
            boolean aW = r.QK(this.mwP.getScheme()) ? r.aW(this.eGu.getPageActivity(), scheme) : false;
            if (this.kFP != null) {
                this.kFP.d(aW ? 1 : 2, null);
            }
            if (this.mwU != null) {
                this.mwU.wJ(false);
            }
            if (!aW) {
                String QL = r.QL(scheme);
                NewWebVideoActivity.a(rq, this.mwP.getAdFacadeData().YR != null ? this.mwP.getAdFacadeData().YR.rm() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.eGu.getPageActivity(), "", QL, true, true, true, this.mwP.video.video_url, this.mwP.video.thumbnail_url, 1.7777778f, this.mwW, this.mwP.getAdFacadeData().rq().exc);
                newWebVideoActivityConfig.setTailFrame(this.mwP.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.tO(this.iPl.getCurrentPosition()) < this.mwW && this.iPl.rK()) {
            di(this.eIq ? 0 : 1, this.iPl.getCurrentPosition());
        }
        cAF();
        this.mwU.wJ(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aPd() {
        if (isPlaying()) {
            this.iPl.aPd();
            di(this.eIq ? 0 : 1, this.iPl.getCurrentPosition());
            this.mwY = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.iPl.rK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw(int i) {
        if (this.mwP != null && this.mwP.video != null && this.mwP.getAdFacadeData() != null && this.mwY) {
            com.baidu.tieba.recapp.report.d.dAT().a(g.a(this.mwP.getAdFacadeData(), 31, this.mwP.getAdFacadeData().getPageNum(), i, this.mwW, 0, -1));
            this.mwY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix(int i) {
        if (this.mwP != null && this.mwP.video != null && this.mwP.getAdFacadeData() != null && !this.mwX) {
            com.baidu.tieba.recapp.report.d.dAT().a(g.a(this.mwP.getAdFacadeData(), 34, this.mwP.getAdFacadeData().getPageNum(), i, this.mwW, this.mwW, -1));
            this.mwX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy(int i) {
        if (this.mwP != null && this.mwP.video != null && this.mwP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dAT().a(g.a(this.mwP.getAdFacadeData(), 36, this.mwP.getAdFacadeData().getPageNum(), i, this.mwW, com.baidu.tieba.ad.a.a.tO(this.iPl.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(int i, int i2) {
        if (this.mwP != null && this.mwP.video != null && this.mwP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dAT().a(g.a(this.mwP.getAdFacadeData(), 32, this.mwP.getAdFacadeData().getPageNum(), i, this.mwW, com.baidu.tieba.ad.a.a.tO(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i, int i2) {
        if (this.mwP != null && this.mwP.video != null && this.mwP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dAT().a(g.a(this.mwP.getAdFacadeData(), 33, this.mwP.getAdFacadeData().getPageNum(), i, this.mwW, com.baidu.tieba.ad.a.a.tO(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.mwP.getAdFacadeData(), 303, this.mwP.getAdFacadeData().getPageNum(), this.eIq ? 0 : 1, this.mwP.video.video_duration.intValue(), 0, -1);
            if (this.mwU != null) {
                this.mwU.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH(boolean z) {
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
        private int chm = -1;
        private Runnable jlG = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jlG);
                a.this.Bg(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void Bg(int i) {
            switch (i) {
                case 0:
                    this.chm = Bh(i);
                    cGt();
                    return;
                case 1:
                    this.chm = Bh(i);
                    this.mHandler.removeCallbacks(this.jlG);
                    return;
                case 2:
                    this.chm = Bi(i);
                    return;
                case 3:
                    this.chm = Bj(i);
                    cGt();
                    return;
                default:
                    this.chm = Bi(i);
                    return;
            }
        }

        private void cGt() {
            this.mHandler.removeCallbacks(this.jlG);
            this.mHandler.postDelayed(this.jlG, IMConnection.RETRY_DELAY_TIMES);
        }

        private int Bh(int i) {
            if (i != this.chm) {
                VideoMiddlePageAdView.this.mwN.setVisibility(8);
                VideoMiddlePageAdView.this.mwM.setVisibility(8);
                VideoMiddlePageAdView.this.wH(true);
                return i;
            }
            return this.chm;
        }

        private int Bi(int i) {
            int i2 = this.chm;
            if (i != this.chm) {
                VideoMiddlePageAdView.this.mwN.setVisibility(0);
                VideoMiddlePageAdView.this.mwM.setVisibility(0);
                if (VideoMiddlePageAdView.this.iPl != null) {
                    VideoMiddlePageAdView.this.iPl.dwm();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mwP.autoPlay) {
                    VideoMiddlePageAdView.this.wH(false);
                    return i;
                }
                return i;
            }
            return this.chm;
        }

        private int Bj(int i) {
            if (i != this.chm) {
                VideoMiddlePageAdView.this.mwN.setVisibility(0);
                VideoMiddlePageAdView.this.mwM.setVisibility(0);
                VideoMiddlePageAdView.this.wH(true);
                return i;
            }
            return this.chm;
        }
    }
}
