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
/* loaded from: classes26.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Za;
    public TextView aju;
    private Animation bYl;
    private Animation bYm;
    private boolean eJq;
    public FrameLayout iOj;
    public FrameLayout iOk;
    public TextView iOl;
    public HeadImageView iOq;
    public c iOy;
    private View jkD;
    private com.baidu.tieba.frs.videomiddlepage.c jkF;
    private VideoNetworkStateTipView jkI;
    private Animation.AnimationListener jkP;
    private Animation.AnimationListener jkQ;
    private View jkx;
    private int mWidth;
    public TextView mwA;
    private VideoMiddlePageAdCard mwB;
    private TextView mwC;
    private TextView mwD;
    private ViewGroup mwE;
    private d mwF;
    private e mwG;
    private f mwH;
    private int mwI;
    private boolean mwJ;
    private boolean mwK;
    private a mwL;
    private View mwx;
    private View mwy;
    private View mwz;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mwJ = false;
        this.mwK = true;
        this.jkP = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jkD != null) {
                    VideoMiddlePageAdView.this.jkD.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mwx != null) {
                    VideoMiddlePageAdView.this.mwx.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jkD != null) {
                    VideoMiddlePageAdView.this.jkD.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mwx != null) {
                    VideoMiddlePageAdView.this.mwx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jkQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jkD != null) {
                    VideoMiddlePageAdView.this.jkD.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mwx != null) {
                    VideoMiddlePageAdView.this.mwx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jkD != null) {
                    VideoMiddlePageAdView.this.jkD.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mwx != null) {
                    VideoMiddlePageAdView.this.mwx.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mwJ = false;
        this.mwK = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.iOj = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jkx = this.rootView.findViewById(R.id.card_container);
        this.iOk = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.iOy = new c(this.eIc, this.iOk, false);
        this.iOy.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.iOy.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.iOy != null && VideoMiddlePageAdView.this.iOy.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mwI = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.iOy.getVideoView().getDuration());
                }
            }
        });
        this.iOy.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void qz(boolean z) {
                if (VideoMiddlePageAdView.this.mwL != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mwL.AI(0);
                    } else {
                        VideoMiddlePageAdView.this.mwL.AI(1);
                    }
                }
            }
        });
        this.iOy.kFY.setOnTouchListener(null);
        this.iOl = (TextView) this.rootView.findViewById(R.id.title);
        this.iOq = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.iOq.setIsRound(true);
        this.iOq.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iOq.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iOq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.mwA = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.aju = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mwC = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mwD = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mwE = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mwF = new d(this.eIc.getPageActivity(), this.mwE);
        this.mwF.page = 1;
        this.jkI = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jkI.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jkI.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.iOy.wp(false);
                VideoMiddlePageAdView.this.jkI.dRN();
                if (VideoMiddlePageAdView.this.mwB != null && VideoMiddlePageAdView.this.mwB.video != null) {
                    VideoMiddlePageAdView.this.iOy.fW(VideoMiddlePageAdView.this.mwB.video.video_url, "");
                }
            }
        });
        this.jkD = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mwy = this.rootView.findViewById(R.id.user_container_foreground);
        this.mwz = this.rootView.findViewById(R.id.title_foreground);
        this.mwx = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jkD.setOnClickListener(this);
        this.mwy.setOnClickListener(this);
        this.mwz.setOnClickListener(this);
        this.mwx.setOnClickListener(this);
        this.iOk.setOnClickListener(this);
        this.iOj.setOnClickListener(this);
        this.iOy.ac(this);
        this.iOl.setOnClickListener(this);
        this.iOq.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eIc.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOj.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iOj.setLayoutParams(layoutParams);
        this.bYl = new AlphaAnimation(0.0f, 0.7f);
        this.bYl.setDuration(500L);
        this.bYl.setAnimationListener(this.jkQ);
        this.bYm = new AlphaAnimation(0.7f, 0.0f);
        this.bYm.setDuration(500L);
        this.bYm.setAnimationListener(this.jkP);
        this.rootView.setOnClickListener(this);
        this.mwL = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZo() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eJq = this.mwB.autoPlay;
            this.mwJ = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mwI = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.iOy.rK()) {
                di(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.iOy.getCurrentPosition());
                this.mwK = true;
            }
            this.iOy.stopPlay();
            this.iOy.wq(true);
            this.iOy.wm(false);
            this.iOy.wr(true);
            this.iOy.ay(false, true);
            this.iOy.Hr(i);
            this.iOy.a(new c.InterfaceC0827c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rI() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rJ() {
                }
            });
            this.iOy.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cBf() {
                    if (VideoMiddlePageAdView.this.mwB != null && VideoMiddlePageAdView.this.mwB.video != null && VideoMiddlePageAdView.this.mwB.video.video_height.intValue() > VideoMiddlePageAdView.this.mwB.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.iOy.ay(false, true);
                    } else {
                        VideoMiddlePageAdView.this.iOy.ay(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mwH != null) {
                        VideoMiddlePageAdView.this.mwH.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HV(VideoMiddlePageAdView.this.eJq ? 0 : 1);
                    VideoMiddlePageAdView.this.mwJ = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cBg() {
                }
            });
            this.iOy.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void pT(boolean z) {
                    VideoMiddlePageAdView.this.iOy.fW(VideoMiddlePageAdView.this.mwB.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mwH != null) {
                        VideoMiddlePageAdView.this.mwH.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HV(1);
                    VideoMiddlePageAdView.this.mwJ = false;
                }
            });
            this.iOy.wi(false);
            this.iOy.cZO();
            this.iOy.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.iOy.cMt();
                    if (VideoMiddlePageAdView.this.mwG != null) {
                        VideoMiddlePageAdView.this.mwG.dBw();
                    }
                    VideoMiddlePageAdView.this.HW(VideoMiddlePageAdView.this.eJq ? 0 : 1);
                    VideoMiddlePageAdView.this.mwK = true;
                }
            });
            this.iOy.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.HX(VideoMiddlePageAdView.this.eJq ? 0 : 1);
                    return true;
                }
            });
            this.iOy.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.iOy.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.iOy.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cBi() {
                    VideoMiddlePageAdView.this.dj(1, VideoMiddlePageAdView.this.iOy.getCurrentPosition());
                }
            });
            this.iOy.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.di(1, VideoMiddlePageAdView.this.iOy.getCurrentPosition());
                    VideoMiddlePageAdView.this.mwK = true;
                }
            });
            this.iOy.cMt();
            this.iOy.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jkI.dsq()) {
                    this.iOy.wo(false);
                    this.jkI.dRM();
                    this.iOy.wp(true);
                    this.iOy.fV(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.iOy.wp(false);
                    this.iOy.wo(false);
                    this.jkI.hide();
                    this.iOy.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mwG != null) {
                    this.mwG.wG(true);
                }
                if (i == 0) {
                    this.jkD.setVisibility(8);
                    this.mwx.setVisibility(8);
                } else {
                    this.jkD.startAnimation(this.bYm);
                    this.mwx.startAnimation(this.bYm);
                }
                if (i == 0) {
                    this.mwL.AI(3);
                    return;
                } else {
                    this.mwL.AI(0);
                    return;
                }
            }
            this.jkI.hide();
            this.iOy.wo(true);
            this.mwL.AI(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jkD.startAnimation(this.bYm);
                this.mwx.startAnimation(this.bYm);
                return;
            }
            this.jkD.setVisibility(0);
            this.mwx.setVisibility(0);
        }
    }

    private boolean cGD() {
        try {
            int intValue = this.mwB.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mwB.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.iOl.setTextColor(this.eIc.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mwA.setTextColor(this.eIc.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mwC.setTextColor(this.eIc.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mwD.setTextColor(this.eIc.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mwD, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cGE() {
        if (!cGD()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOj.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iOj.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iOj.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iOj.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mwB = videoMiddlePageAdCard;
        cGE();
        this.iOl.setText(videoMiddlePageAdCard.threadTitle);
        this.aju.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.iOq.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.iOq.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.iOq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.but() || VideoMiddlePageAdView.this.mwB == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mwB.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eIc.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mwA.setText(videoMiddlePageAdCard.tagName);
        this.mwC.setText(videoMiddlePageAdCard.operateData.muw);
        this.mwD.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mwD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.eIc, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.mwB == null || VideoMiddlePageAdView.this.mwB.getAdFacadeData() == null || VideoMiddlePageAdView.this.mwB.getAdFacadeData().rq() == null) ? null : VideoMiddlePageAdView.this.mwB.getAdFacadeData().rq().eyO);
                if (VideoMiddlePageAdView.this.mwG != null) {
                    VideoMiddlePageAdView.this.mwG.wG(false);
                }
                if (VideoMiddlePageAdView.this.kFA != null) {
                    VideoMiddlePageAdView.this.kFA.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mwB, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mwG = this.mwF.a(videoMiddlePageAdCard.tailFrame, this.mwG);
        if (this.mwG != null) {
            b(this.mwB.getAdFacadeData());
            this.mwG.setPageContext(this.eIc);
            this.mwG.setTimeoutListener(this);
            this.mwG.a(videoMiddlePageAdCard.tailFrame);
            this.mwG.c(this.mwB);
            this.mwG.dBx();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Za = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Za;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jkF = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mwH = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bQ(View view) {
        this.Za.zl(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        cBd();
        if (this.jkD != null) {
            this.jkD.clearAnimation();
        }
        if (this.mwx != null) {
            this.mwx.clearAnimation();
        }
    }

    public void cBc() {
        this.iOy.stopPlay();
        if (this.iOl != null) {
            this.iOl.setVisibility(0);
        }
        if (this.mwL != null) {
            this.mwL.AI(2);
        }
        this.mwJ = false;
        this.mwK = true;
    }

    public void cBd() {
        if (this.iOy != null) {
            this.iOy.destroy();
        }
        this.mwJ = false;
        this.mwK = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jkD && this.jkD.getVisibility() == 0) {
            if (this.jkF != null) {
                this.jkF.AM(this.mPosition);
            }
        } else if (view == this.mwx && this.mwx.getVisibility() == 0) {
            if (this.jkF != null) {
                this.jkF.AM(this.mPosition);
            }
        } else if (view == this.mwz || view == this.mwy) {
            if (this.jkD.getVisibility() == 0) {
                if (this.jkF != null) {
                    this.jkF.AM(this.mPosition);
                    return;
                }
                return;
            }
            this.mwL.AI(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dAL();
        } else {
            int c = s.c(this.eIc, this.mwB.getScheme(), (this.mwB.getAdFacadeData() == null || this.mwB.getAdFacadeData().rq() == null) ? null : this.mwB.getAdFacadeData().rq().eyO);
            if (this.kFA != null) {
                this.kFA.d(c, null);
            }
            if (this.mwG != null) {
                this.mwG.wG(false);
            }
        }
    }

    private void dAL() {
        if (this.eIc != null && this.eIc.getPageActivity() != null && this.mwB != null && this.mwB.getAdFacadeData() != null && !TextUtils.isEmpty(this.mwB.getScheme())) {
            String scheme = this.mwB.getScheme();
            AdvertAppInfo rq = this.mwB.getAdFacadeData().rq();
            boolean aZ = s.Rp(this.mwB.getScheme()) ? s.aZ(this.eIc.getPageActivity(), scheme) : false;
            if (this.kFA != null) {
                this.kFA.d(aZ ? 1 : 2, null);
            }
            if (this.mwG != null) {
                this.mwG.wG(false);
            }
            if (!aZ) {
                String Rq = s.Rq(scheme);
                NewWebVideoActivity.a(rq, this.mwB.getAdFacadeData().YM != null ? this.mwB.getAdFacadeData().YM.rm() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.eIc.getPageActivity(), "", Rq, true, true, true, this.mwB.video.video_url, this.mwB.video.thumbnail_url, 1.7777778f, this.mwI, this.mwB.getAdFacadeData().rq().eyO);
                newWebVideoActivityConfig.setTailFrame(this.mwB.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.tq(this.iOy.getCurrentPosition()) < this.mwI && this.iOy.rK()) {
            di(this.eJq ? 0 : 1, this.iOy.getCurrentPosition());
        }
        cBc();
        this.mwG.wG(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aPL() {
        if (isPlaying()) {
            this.iOy.aPL();
            di(this.eJq ? 0 : 1, this.iOy.getCurrentPosition());
            this.mwK = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iOy.rK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HV(int i) {
        if (this.mwB != null && this.mwB.video != null && this.mwB.getAdFacadeData() != null && this.mwK) {
            com.baidu.tieba.recapp.report.d.dBp().a(g.a(this.mwB.getAdFacadeData(), 31, this.mwB.getAdFacadeData().getPageNum(), i, this.mwI, 0, -1));
            this.mwK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HW(int i) {
        if (this.mwB != null && this.mwB.video != null && this.mwB.getAdFacadeData() != null && !this.mwJ) {
            com.baidu.tieba.recapp.report.d.dBp().a(g.a(this.mwB.getAdFacadeData(), 34, this.mwB.getAdFacadeData().getPageNum(), i, this.mwI, this.mwI, -1));
            this.mwJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX(int i) {
        if (this.mwB != null && this.mwB.video != null && this.mwB.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dBp().a(g.a(this.mwB.getAdFacadeData(), 36, this.mwB.getAdFacadeData().getPageNum(), i, this.mwI, com.baidu.tieba.ad.a.a.tq(this.iOy.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(int i, int i2) {
        if (this.mwB != null && this.mwB.video != null && this.mwB.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dBp().a(g.a(this.mwB.getAdFacadeData(), 32, this.mwB.getAdFacadeData().getPageNum(), i, this.mwI, com.baidu.tieba.ad.a.a.tq(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i, int i2) {
        if (this.mwB != null && this.mwB.video != null && this.mwB.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dBp().a(g.a(this.mwB.getAdFacadeData(), 33, this.mwB.getAdFacadeData().getPageNum(), i, this.mwI, com.baidu.tieba.ad.a.a.tq(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.mwB.getAdFacadeData(), 303, this.mwB.getAdFacadeData().getPageNum(), this.eJq ? 0 : 1, this.mwB.video.video_duration.intValue(), 0, -1);
            if (this.mwG != null) {
                this.mwG.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wE(boolean z) {
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
    /* loaded from: classes26.dex */
    public class a {
        private int ciY = -1;
        private Runnable jkW = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jkW);
                a.this.AI(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void AI(int i) {
            switch (i) {
                case 0:
                    this.ciY = AJ(i);
                    cGO();
                    return;
                case 1:
                    this.ciY = AJ(i);
                    this.mHandler.removeCallbacks(this.jkW);
                    return;
                case 2:
                    this.ciY = AK(i);
                    return;
                case 3:
                    this.ciY = AL(i);
                    cGO();
                    return;
                default:
                    this.ciY = AK(i);
                    return;
            }
        }

        private void cGO() {
            this.mHandler.removeCallbacks(this.jkW);
            this.mHandler.postDelayed(this.jkW, IMConnection.RETRY_DELAY_TIMES);
        }

        private int AJ(int i) {
            if (i != this.ciY) {
                VideoMiddlePageAdView.this.mwz.setVisibility(8);
                VideoMiddlePageAdView.this.mwy.setVisibility(8);
                VideoMiddlePageAdView.this.wE(true);
                return i;
            }
            return this.ciY;
        }

        private int AK(int i) {
            int i2 = this.ciY;
            if (i != this.ciY) {
                VideoMiddlePageAdView.this.mwz.setVisibility(0);
                VideoMiddlePageAdView.this.mwy.setVisibility(0);
                if (VideoMiddlePageAdView.this.iOy != null) {
                    VideoMiddlePageAdView.this.iOy.dwM();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mwB.autoPlay) {
                    VideoMiddlePageAdView.this.wE(false);
                    return i;
                }
                return i;
            }
            return this.ciY;
        }

        private int AL(int i) {
            if (i != this.ciY) {
                VideoMiddlePageAdView.this.mwz.setVisibility(0);
                VideoMiddlePageAdView.this.mwy.setVisibility(0);
                VideoMiddlePageAdView.this.wE(true);
                return i;
            }
            return this.ciY;
        }
    }
}
