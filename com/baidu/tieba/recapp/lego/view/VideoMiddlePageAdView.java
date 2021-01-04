package com.baidu.tieba.recapp.lego.view;

import android.os.Bundle;
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
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.play.c;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.d.d;
import com.baidu.tieba.recapp.d.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, k, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a aaL;
    public TextView ala;
    private Animation ciB;
    private Animation ciC;
    private boolean eZA;
    private Animation.AnimationListener jLD;
    private Animation.AnimationListener jLE;
    private View jLl;
    private View jLr;
    private c jLt;
    private VideoNetworkStateTipView jLw;
    public FrameLayout jmb;
    public FrameLayout jmc;
    public TextView jmd;
    public HeadImageView jmi;
    public com.baidu.tieba.play.c jmr;
    private View mQi;
    private View mQj;
    private View mQk;
    public TextView mQl;
    private VideoMiddlePageAdCard mQm;
    private TextView mQn;
    private TextView mQo;
    private ViewGroup mQp;
    private d mQq;
    private e mQr;
    private f mQs;
    private int mQt;
    private boolean mQu;
    private boolean mQv;
    private a mQw;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mQu = false;
        this.mQv = true;
        this.jLD = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mQi != null) {
                    VideoMiddlePageAdView.this.mQi.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mQi != null) {
                    VideoMiddlePageAdView.this.mQi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jLE = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mQi != null) {
                    VideoMiddlePageAdView.this.mQi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mQi != null) {
                    VideoMiddlePageAdView.this.mQi.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mQu = false;
        this.mQv = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.jmb = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jLl = this.rootView.findViewById(R.id.card_container);
        this.jmc = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jmr = new com.baidu.tieba.play.c(this.eXu, this.jmc, false);
        this.jmr.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jmr.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jmr != null && VideoMiddlePageAdView.this.jmr.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mQt = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jmr.getVideoView().getDuration());
                }
            }
        });
        this.jmr.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void rC(boolean z) {
                if (VideoMiddlePageAdView.this.mQw != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mQw.Ch(0);
                    } else {
                        VideoMiddlePageAdView.this.mQw.Ch(1);
                    }
                }
            }
        });
        this.jmr.bVM.setOnTouchListener(null);
        this.jmd = (TextView) this.rootView.findViewById(R.id.title);
        this.jmi = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.jmi.setIsRound(true);
        this.jmi.setDefaultBgResource(R.color.CAM_X0205);
        this.jmi.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mQl = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ala = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mQn = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mQo = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mQp = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mQq = new d(this.eXu.getPageActivity(), this.mQp);
        this.mQq.page = 1;
        this.jLw = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jLw.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jLw.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jmr.wX(false);
                VideoMiddlePageAdView.this.jLw.dWK();
                if (VideoMiddlePageAdView.this.mQm != null && VideoMiddlePageAdView.this.mQm.video != null) {
                    VideoMiddlePageAdView.this.jmr.fY(VideoMiddlePageAdView.this.mQm.video.video_url, "");
                }
            }
        });
        this.jLr = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mQj = this.rootView.findViewById(R.id.user_container_foreground);
        this.mQk = this.rootView.findViewById(R.id.title_foreground);
        this.mQi = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jLr.setOnClickListener(this);
        this.mQj.setOnClickListener(this);
        this.mQk.setOnClickListener(this);
        this.mQi.setOnClickListener(this);
        this.jmc.setOnClickListener(this);
        this.jmb.setOnClickListener(this);
        this.jmr.ad(this);
        this.jmd.setOnClickListener(this);
        this.jmi.setOnClickListener(this);
        this.ala.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eXu.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jmb.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jmb.setLayoutParams(layoutParams);
        this.ciB = new AlphaAnimation(0.0f, 0.7f);
        this.ciB.setDuration(500L);
        this.ciB.setAnimationListener(this.jLE);
        this.ciC = new AlphaAnimation(0.7f, 0.0f);
        this.ciC.setDuration(500L);
        this.ciC.setAnimationListener(this.jLD);
        this.rootView.setOnClickListener(this);
        this.mQw = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddH() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eZA = this.mQm.autoPlay;
            this.mQu = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mQt = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jmr.rn()) {
                dj(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jmr.getCurrentPosition());
                this.mQv = true;
            }
            this.jmr.stopPlay();
            this.jmr.wY(true);
            this.jmr.wU(false);
            this.jmr.wZ(true);
            this.jmr.ax(false, true);
            this.jmr.IA(i);
            this.jmr.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rl() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rm() {
                }
            });
            this.jmr.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cHT() {
                    if (VideoMiddlePageAdView.this.mQm != null && VideoMiddlePageAdView.this.mQm.video != null && VideoMiddlePageAdView.this.mQm.video.video_height.intValue() > VideoMiddlePageAdView.this.mQm.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jmr.ax(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jmr.ax(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mQs != null) {
                        VideoMiddlePageAdView.this.mQs.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Jh(VideoMiddlePageAdView.this.eZA ? 0 : 1);
                    VideoMiddlePageAdView.this.mQu = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cHU() {
                }
            });
            this.jmr.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qR(boolean z) {
                    VideoMiddlePageAdView.this.jmr.fY(VideoMiddlePageAdView.this.mQm.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mQs != null) {
                        VideoMiddlePageAdView.this.mQs.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Jh(1);
                    VideoMiddlePageAdView.this.mQu = false;
                }
            });
            this.jmr.wQ(false);
            this.jmr.deh();
            this.jmr.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jmr.cUv();
                    if (VideoMiddlePageAdView.this.mQr != null) {
                        VideoMiddlePageAdView.this.mQr.dGc();
                    }
                    VideoMiddlePageAdView.this.Ji(VideoMiddlePageAdView.this.eZA ? 0 : 1);
                    VideoMiddlePageAdView.this.mQv = true;
                }
            });
            this.jmr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Jj(VideoMiddlePageAdView.this.eZA ? 0 : 1);
                    return true;
                }
            });
            this.jmr.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jmr.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jmr.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cHW() {
                    VideoMiddlePageAdView.this.dk(1, VideoMiddlePageAdView.this.jmr.getCurrentPosition());
                }
            });
            this.jmr.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dj(1, VideoMiddlePageAdView.this.jmr.getCurrentPosition());
                    VideoMiddlePageAdView.this.mQv = true;
                }
            });
            this.jmr.cUv();
            this.jmr.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jLw.dwY()) {
                    this.jmr.wW(false);
                    this.jLw.dWJ();
                    this.jmr.wX(true);
                    this.jmr.fX(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jmr.wX(false);
                    this.jmr.wW(false);
                    this.jLw.hide();
                    this.jmr.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mQr != null) {
                    this.mQr.xo(true);
                }
                if (i == 0) {
                    this.jLr.setVisibility(8);
                    this.mQi.setVisibility(8);
                } else {
                    this.jLr.startAnimation(this.ciC);
                    this.mQi.startAnimation(this.ciC);
                }
                if (i == 0) {
                    this.mQw.Ch(3);
                    return;
                } else {
                    this.mQw.Ch(0);
                    return;
                }
            }
            this.jLw.hide();
            this.jmr.wW(true);
            this.mQw.Ch(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jLr.startAnimation(this.ciC);
                this.mQi.startAnimation(this.ciC);
                return;
            }
            this.jLr.setVisibility(0);
            this.mQi.setVisibility(0);
        }
    }

    private boolean cOB() {
        try {
            int intValue = this.mQm.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mQm.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.jmd.setTextColor(this.eXu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mQl.setTextColor(this.eXu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mQn.setTextColor(this.eXu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mQo.setTextColor(this.eXu.getResources().getColor(R.color.cp_cont_i_alpha70));
        ao.setBackgroundResource(this.mQo, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cOC() {
        if (!cOB()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jmb.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jmb.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jmb.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jmb.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mQm = videoMiddlePageAdCard;
        cOC();
        this.jmd.setText(videoMiddlePageAdCard.threadTitle);
        this.ala.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.jmi.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.jmi.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.jmi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bzC() || VideoMiddlePageAdView.this.mQm == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mQm.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eXu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mQl.setText(videoMiddlePageAdCard.tagName);
        this.mQn.setText(videoMiddlePageAdCard.operateData.mOk);
        this.mQo.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mQo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (VideoMiddlePageAdView.this.mQm == null || VideoMiddlePageAdView.this.mQm.getAdFacadeData() == null || VideoMiddlePageAdView.this.mQm.getAdFacadeData().qU() == null) {
                    str = null;
                } else {
                    str = VideoMiddlePageAdView.this.d(VideoMiddlePageAdView.this.mQm.getAdFacadeData().qU());
                }
                int c = s.c(VideoMiddlePageAdView.this.eXu, videoMiddlePageAdCard.operateData.scheme, str);
                if (VideoMiddlePageAdView.this.mQr != null) {
                    VideoMiddlePageAdView.this.mQr.xo(false);
                }
                if (VideoMiddlePageAdView.this.kYN != null) {
                    VideoMiddlePageAdView.this.kYN.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mQm, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mQr = this.mQq.a(videoMiddlePageAdCard.tailFrame, this.mQr);
        if (this.mQr != null) {
            b(this.mQm.getAdFacadeData());
            this.mQr.setPageContext(this.eXu);
            this.mQr.setTimeoutListener(this);
            this.mQr.a(videoMiddlePageAdCard.tailFrame);
            this.mQr.c(this.mQm);
            this.mQr.dGd();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.aaL = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.aaL;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jLt = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mQs = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void cj(View view) {
        this.aaL.AA(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cHR();
        if (this.jLr != null) {
            this.jLr.clearAnimation();
        }
        if (this.mQi != null) {
            this.mQi.clearAnimation();
        }
    }

    public void stopVideo() {
        this.jmr.stopPlay();
        if (this.jmd != null) {
            this.jmd.setVisibility(0);
        }
        if (this.mQw != null) {
            this.mQw.Ch(2);
        }
        this.mQu = false;
        this.mQv = true;
    }

    public void cHR() {
        if (this.jmr != null) {
            this.jmr.destroy();
        }
        this.mQu = false;
        this.mQv = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jLr && this.jLr.getVisibility() == 0) {
            if (this.jLt != null) {
                this.jLt.Cl(this.mPosition);
            }
        } else if (view == this.mQi && this.mQi.getVisibility() == 0) {
            if (this.jLt != null) {
                this.jLt.Cl(this.mPosition);
            }
        } else if (view == this.mQk || view == this.mQj) {
            if (this.jLr.getVisibility() == 0) {
                if (this.jLt != null) {
                    this.jLt.Cl(this.mPosition);
                    return;
                }
                return;
            }
            this.mQw.Ch(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dFp();
        } else {
            int c = s.c(this.eXu, this.mQm.getScheme(), (this.mQm.getAdFacadeData() == null || this.mQm.getAdFacadeData().qU() == null) ? null : d(this.mQm.getAdFacadeData().qU()));
            if (this.kYN != null) {
                this.kYN.d(c, null);
            }
            if (this.mQr != null) {
                this.mQr.xo(false);
            }
        }
    }

    private void dFp() {
        if (this.eXu != null && this.eXu.getPageActivity() != null && this.mQm != null && this.mQm.getAdFacadeData() != null && !TextUtils.isEmpty(this.mQm.getScheme())) {
            String scheme = this.mQm.getScheme();
            AdvertAppInfo qU = this.mQm.getAdFacadeData().qU();
            boolean bf = s.Rz(this.mQm.getScheme()) ? s.bf(this.eXu.getPageActivity(), scheme) : false;
            if (this.kYN != null) {
                this.kYN.d(bf ? 1 : 2, null);
            }
            if (this.mQr != null) {
                this.mQr.xo(false);
            }
            if (!bf) {
                String RA = s.RA(scheme);
                AdWebVideoActivity.a(qU, this.mQm.getAdFacadeData().aax != null ? this.mQm.getAdFacadeData().aax.qQ() : 0, "DETAIL");
                Bundle bundle = new Bundle();
                bundle.putString("video_url", this.mQm.video.video_url);
                bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.mQm.video.thumbnail_url);
                bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
                bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.mQt);
                bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.mQm.tailFrame.toJsonString());
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, d(this.mQm.getAdFacadeData().qU()));
                AdWebVideoActivity.a(new AdWebVideoActivityConfig(this.eXu.getPageActivity(), "", RA, true, true, true, bundle));
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.uD(this.jmr.getCurrentPosition()) < this.mQt && this.jmr.rn()) {
            dj(this.eZA ? 0 : 1, this.jmr.getCurrentPosition());
        }
        stopVideo();
        this.mQr.xo(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aUC() {
        if (isPlaying()) {
            this.jmr.aUC();
            dj(this.eZA ? 0 : 1, this.jmr.getCurrentPosition());
            this.mQv = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jmr.rn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(int i) {
        if (this.mQm != null && this.mQm.video != null && this.mQm.getAdFacadeData() != null && this.mQv) {
            com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(this.mQm.getAdFacadeData(), 31, this.mQm.getAdFacadeData().getPageNum(), i, this.mQt, 0, -1));
            this.mQv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji(int i) {
        if (this.mQm != null && this.mQm.video != null && this.mQm.getAdFacadeData() != null && !this.mQu) {
            com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(this.mQm.getAdFacadeData(), 34, this.mQm.getAdFacadeData().getPageNum(), i, this.mQt, this.mQt, -1));
            this.mQu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj(int i) {
        if (this.mQm != null && this.mQm.video != null && this.mQm.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(this.mQm.getAdFacadeData(), 36, this.mQm.getAdFacadeData().getPageNum(), i, this.mQt, com.baidu.tieba.ad.a.a.uD(this.jmr.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i, int i2) {
        if (this.mQm != null && this.mQm.video != null && this.mQm.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(this.mQm.getAdFacadeData(), 32, this.mQm.getAdFacadeData().getPageNum(), i, this.mQt, com.baidu.tieba.ad.a.a.uD(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i, int i2) {
        if (this.mQm != null && this.mQm.video != null && this.mQm.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(this.mQm.getAdFacadeData(), 33, this.mQm.getAdFacadeData().getPageNum(), i, this.mQt, com.baidu.tieba.ad.a.a.uD(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(this.mQm.getAdFacadeData(), 303, this.mQm.getAdFacadeData().getPageNum(), this.eZA ? 0 : 1, this.mQm.video.video_duration.intValue(), 0, -1);
            if (this.mQr != null) {
                this.mQr.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(boolean z) {
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
    /* loaded from: classes8.dex */
    public class a {
        private int cvb = -1;
        private Runnable jLK = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jLK);
                a.this.Ch(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void Ch(int i) {
            switch (i) {
                case 0:
                    this.cvb = Ci(i);
                    cOM();
                    return;
                case 1:
                    this.cvb = Ci(i);
                    this.mHandler.removeCallbacks(this.jLK);
                    return;
                case 2:
                    this.cvb = Cj(i);
                    return;
                case 3:
                    this.cvb = Ck(i);
                    cOM();
                    return;
                default:
                    this.cvb = Cj(i);
                    return;
            }
        }

        private void cOM() {
            this.mHandler.removeCallbacks(this.jLK);
            this.mHandler.postDelayed(this.jLK, IMConnection.RETRY_DELAY_TIMES);
        }

        private int Ci(int i) {
            if (i != this.cvb) {
                VideoMiddlePageAdView.this.mQk.setVisibility(8);
                VideoMiddlePageAdView.this.mQj.setVisibility(8);
                VideoMiddlePageAdView.this.xm(true);
                return i;
            }
            return this.cvb;
        }

        private int Cj(int i) {
            int i2 = this.cvb;
            if (i != this.cvb) {
                VideoMiddlePageAdView.this.mQk.setVisibility(0);
                VideoMiddlePageAdView.this.mQj.setVisibility(0);
                if (VideoMiddlePageAdView.this.jmr != null) {
                    VideoMiddlePageAdView.this.jmr.dBu();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mQm.autoPlay) {
                    VideoMiddlePageAdView.this.xm(false);
                    return i;
                }
                return i;
            }
            return this.cvb;
        }

        private int Ck(int i) {
            if (i != this.cvb) {
                VideoMiddlePageAdView.this.mQk.setVisibility(0);
                VideoMiddlePageAdView.this.mQj.setVisibility(0);
                VideoMiddlePageAdView.this.xm(true);
                return i;
            }
            return this.cvb;
        }
    }
}
