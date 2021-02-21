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
import com.baidu.tbadk.core.util.ap;
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
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, k, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a aaF;
    public TextView ajY;
    private Animation chW;
    private Animation chX;
    private boolean eXf;
    private View jMD;
    private c jMF;
    private VideoNetworkStateTipView jMI;
    private Animation.AnimationListener jMP;
    private Animation.AnimationListener jMQ;
    private View jMx;
    public com.baidu.tieba.play.c jnF;
    public FrameLayout jnq;
    public FrameLayout jnr;
    public TextView jns;
    public HeadImageView jnx;
    private f mVA;
    private int mVB;
    private boolean mVC;
    private boolean mVD;
    private a mVE;
    private View mVq;
    private View mVr;
    private View mVs;
    public TextView mVt;
    private VideoMiddlePageAdCard mVu;
    private TextView mVv;
    private TextView mVw;
    private ViewGroup mVx;
    private d mVy;
    private e mVz;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mVC = false;
        this.mVD = true;
        this.jMP = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jMD != null) {
                    VideoMiddlePageAdView.this.jMD.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mVq != null) {
                    VideoMiddlePageAdView.this.mVq.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jMD != null) {
                    VideoMiddlePageAdView.this.jMD.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mVq != null) {
                    VideoMiddlePageAdView.this.mVq.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jMQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jMD != null) {
                    VideoMiddlePageAdView.this.jMD.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mVq != null) {
                    VideoMiddlePageAdView.this.mVq.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jMD != null) {
                    VideoMiddlePageAdView.this.jMD.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mVq != null) {
                    VideoMiddlePageAdView.this.mVq.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mVC = false;
        this.mVD = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.jnq = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jMx = this.rootView.findViewById(R.id.card_container);
        this.jnr = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jnF = new com.baidu.tieba.play.c(this.eUY, this.jnr, false);
        this.jnF.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jnF.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jnF != null && VideoMiddlePageAdView.this.jnF.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mVB = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jnF.getVideoView().getDuration());
                }
            }
        });
        this.jnF.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void rI(boolean z) {
                if (VideoMiddlePageAdView.this.mVE != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mVE.AL(0);
                    } else {
                        VideoMiddlePageAdView.this.mVE.AL(1);
                    }
                }
            }
        });
        this.jnF.bUP.setOnTouchListener(null);
        this.jns = (TextView) this.rootView.findViewById(R.id.title);
        this.jnx = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.jnx.setIsRound(true);
        this.jnx.setDefaultBgResource(R.color.CAM_X0205);
        this.jnx.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mVt = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ajY = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mVv = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mVw = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mVx = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mVy = new d(this.eUY.getPageActivity(), this.mVx);
        this.mVy.page = 1;
        this.jMI = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jMI.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jMI.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jnF.xl(false);
                VideoMiddlePageAdView.this.jMI.dVm();
                if (VideoMiddlePageAdView.this.mVu != null && VideoMiddlePageAdView.this.mVu.video != null) {
                    VideoMiddlePageAdView.this.jnF.fX(VideoMiddlePageAdView.this.mVu.video.video_url, "");
                }
            }
        });
        this.jMD = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mVr = this.rootView.findViewById(R.id.user_container_foreground);
        this.mVs = this.rootView.findViewById(R.id.title_foreground);
        this.mVq = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jMD.setOnClickListener(this);
        this.mVr.setOnClickListener(this);
        this.mVs.setOnClickListener(this);
        this.mVq.setOnClickListener(this);
        this.jnr.setOnClickListener(this);
        this.jnq.setOnClickListener(this);
        this.jnF.ad(this);
        this.jns.setOnClickListener(this);
        this.jnx.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eUY.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnq.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jnq.setLayoutParams(layoutParams);
        this.chW = new AlphaAnimation(0.0f, 0.7f);
        this.chW.setDuration(500L);
        this.chW.setAnimationListener(this.jMQ);
        this.chX = new AlphaAnimation(0.7f, 0.0f);
        this.chX.setDuration(500L);
        this.chX.setAnimationListener(this.jMP);
        this.rootView.setOnClickListener(this);
        this.mVE = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eXf = this.mVu.autoPlay;
            this.mVC = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mVB = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jnF.rl()) {
                dh(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jnF.getCurrentPosition());
                this.mVD = true;
            }
            this.jnF.stopPlay();
            this.jnF.xm(true);
            this.jnF.xi(false);
            this.jnF.xn(true);
            this.jnF.ax(false, true);
            this.jnF.Hm(i);
            this.jnF.a(new c.InterfaceC0849c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rj() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rk() {
                }
            });
            this.jnF.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cFv() {
                    if (VideoMiddlePageAdView.this.mVu != null && VideoMiddlePageAdView.this.mVu.video != null && VideoMiddlePageAdView.this.mVu.video.video_height.intValue() > VideoMiddlePageAdView.this.mVu.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jnF.ax(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jnF.ax(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mVA != null) {
                        VideoMiddlePageAdView.this.mVA.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HT(VideoMiddlePageAdView.this.eXf ? 0 : 1);
                    VideoMiddlePageAdView.this.mVC = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFw() {
                }
            });
            this.jnF.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z) {
                    VideoMiddlePageAdView.this.jnF.fX(VideoMiddlePageAdView.this.mVu.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mVA != null) {
                        VideoMiddlePageAdView.this.mVA.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HT(1);
                    VideoMiddlePageAdView.this.mVC = false;
                }
            });
            this.jnF.xd(false);
            this.jnF.dcv();
            this.jnF.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jnF.cSK();
                    if (VideoMiddlePageAdView.this.mVz != null) {
                        VideoMiddlePageAdView.this.mVz.dEB();
                    }
                    VideoMiddlePageAdView.this.HU(VideoMiddlePageAdView.this.eXf ? 0 : 1);
                    VideoMiddlePageAdView.this.mVD = true;
                }
            });
            this.jnF.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.HV(VideoMiddlePageAdView.this.eXf ? 0 : 1);
                    return true;
                }
            });
            this.jnF.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jnF.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jnF.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cFy() {
                    VideoMiddlePageAdView.this.di(1, VideoMiddlePageAdView.this.jnF.getCurrentPosition());
                }
            });
            this.jnF.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dh(1, VideoMiddlePageAdView.this.jnF.getCurrentPosition());
                    VideoMiddlePageAdView.this.mVD = true;
                }
            });
            this.jnF.cSK();
            this.jnF.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jMI.dvB()) {
                    this.jnF.xk(false);
                    this.jMI.dVl();
                    this.jnF.xl(true);
                    this.jnF.fW(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jnF.xl(false);
                    this.jnF.xk(false);
                    this.jMI.hide();
                    this.jnF.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mVz != null) {
                    this.mVz.xD(true);
                }
                if (i == 0) {
                    this.jMD.setVisibility(8);
                    this.mVq.setVisibility(8);
                } else {
                    this.jMD.startAnimation(this.chX);
                    this.mVq.startAnimation(this.chX);
                }
                if (i == 0) {
                    this.mVE.AL(3);
                    return;
                } else {
                    this.mVE.AL(0);
                    return;
                }
            }
            this.jMI.hide();
            this.jnF.xk(true);
            this.mVE.AL(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jMD.startAnimation(this.chX);
                this.mVq.startAnimation(this.chX);
                return;
            }
            this.jMD.setVisibility(0);
            this.mVq.setVisibility(0);
        }
    }

    private boolean cMf() {
        try {
            int intValue = this.mVu.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mVu.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.jns.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mVt.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mVv.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mVw.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mVw, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cMg() {
        if (!cMf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnq.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jnq.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jnq.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jnq.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mVu = videoMiddlePageAdCard;
        cMg();
        this.jns.setText(videoMiddlePageAdCard.threadTitle);
        this.ajY.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.jnx.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.jnx.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.jnx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bwc() || VideoMiddlePageAdView.this.mVu == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mVu.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eUY.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mVt.setText(videoMiddlePageAdCard.tagName);
        this.mVv.setText(videoMiddlePageAdCard.operateData.mTq);
        this.mVw.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (VideoMiddlePageAdView.this.mVu == null || VideoMiddlePageAdView.this.mVu.getAdFacadeData() == null || VideoMiddlePageAdView.this.mVu.getAdFacadeData().qS() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdvertAppInfo qS = VideoMiddlePageAdView.this.mVu.getAdFacadeData().qS();
                    str2 = VideoMiddlePageAdView.this.d(qS);
                    str = qS.extensionInfo;
                }
                int a2 = t.a(VideoMiddlePageAdView.this.eUY, videoMiddlePageAdCard.operateData.scheme, str2, str);
                if (VideoMiddlePageAdView.this.mVz != null) {
                    VideoMiddlePageAdView.this.mVz.xD(false);
                }
                if (VideoMiddlePageAdView.this.lcA != null) {
                    VideoMiddlePageAdView.this.lcA.d(a2, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mVu, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mVz = this.mVy.a(videoMiddlePageAdCard.tailFrame, this.mVz);
        if (this.mVz != null) {
            b(this.mVu.getAdFacadeData());
            this.mVz.setPageContext(this.eUY);
            this.mVz.setTimeoutListener(this);
            this.mVz.a(videoMiddlePageAdCard.tailFrame);
            this.mVz.c(this.mVu);
            this.mVz.dEC();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.aaF = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.aaF;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jMF = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mVA = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void cf(View view) {
        this.aaF.ze(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cFt();
        if (this.jMD != null) {
            this.jMD.clearAnimation();
        }
        if (this.mVq != null) {
            this.mVq.clearAnimation();
        }
    }

    public void stopVideo() {
        this.jnF.stopPlay();
        if (this.jns != null) {
            this.jns.setVisibility(0);
        }
        if (this.mVE != null) {
            this.mVE.AL(2);
        }
        this.mVC = false;
        this.mVD = true;
    }

    public void cFt() {
        if (this.jnF != null) {
            this.jnF.destroy();
        }
        this.mVC = false;
        this.mVD = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        if (view == this.jMD && this.jMD.getVisibility() == 0) {
            if (this.jMF != null) {
                this.jMF.AP(this.mPosition);
            }
        } else if (view == this.mVq && this.mVq.getVisibility() == 0) {
            if (this.jMF != null) {
                this.jMF.AP(this.mPosition);
            }
        } else if (view == this.mVs || view == this.mVr) {
            if (this.jMD.getVisibility() == 0) {
                if (this.jMF != null) {
                    this.jMF.AP(this.mPosition);
                    return;
                }
                return;
            }
            this.mVE.AL(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dDO();
        } else {
            if (this.mVu.getAdFacadeData() == null || this.mVu.getAdFacadeData().qS() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = d(this.mVu.getAdFacadeData().qS());
                str = this.mVu.getAdFacadeData().qS().extensionInfo;
            }
            int a2 = t.a(this.eUY, this.mVu.getScheme(), str2, str);
            if (this.lcA != null) {
                this.lcA.d(a2, null);
            }
            if (this.mVz != null) {
                this.mVz.xD(false);
            }
        }
    }

    private void dDO() {
        if (this.eUY != null && this.eUY.getPageActivity() != null && this.mVu != null && this.mVu.getAdFacadeData() != null && !TextUtils.isEmpty(this.mVu.getScheme())) {
            String scheme = this.mVu.getScheme();
            AdvertAppInfo qS = this.mVu.getAdFacadeData().qS();
            int bc = t.Rv(this.mVu.getScheme()) ? t.bc(this.eUY.getPageActivity(), scheme) : 0;
            if (this.lcA != null) {
                this.lcA.d(bc, null);
            }
            if (this.mVz != null) {
                this.mVz.xD(false);
            }
            if (bc != 1000) {
                String Rw = t.Rw(scheme);
                AdWebVideoActivity.a(qS, this.mVu.getAdFacadeData().aar != null ? this.mVu.getAdFacadeData().aar.qO() : 0, "DETAIL");
                Bundle bundle = new Bundle();
                bundle.putString("video_url", this.mVu.video.video_url);
                bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.mVu.video.thumbnail_url);
                bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
                bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.mVB);
                bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.mVu.tailFrame.toJsonString());
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, d(this.mVu.getAdFacadeData().qS()));
                AdWebVideoActivity.a(new AdWebVideoActivityConfig(this.eUY.getPageActivity(), "", Rw, true, true, true, bundle));
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.b.a.tc(this.jnF.getCurrentPosition()) < this.mVB && this.jnF.rl()) {
            dh(this.eXf ? 0 : 1, this.jnF.getCurrentPosition());
        }
        stopVideo();
        this.mVz.xD(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void pausePlay() {
        if (isPlaying()) {
            this.jnF.pausePlay();
            dh(this.eXf ? 0 : 1, this.jnF.getCurrentPosition());
            this.mVD = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jnF.rl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HT(int i) {
        if (this.mVu != null && this.mVu.video != null && this.mVu.getAdFacadeData() != null && this.mVD) {
            com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.a(this.mVu.getAdFacadeData(), 31, this.mVu.getAdFacadeData().getPageNum(), i, this.mVB, 0, -1));
            this.mVD = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU(int i) {
        if (this.mVu != null && this.mVu.video != null && this.mVu.getAdFacadeData() != null && !this.mVC) {
            com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.a(this.mVu.getAdFacadeData(), 34, this.mVu.getAdFacadeData().getPageNum(), i, this.mVB, this.mVB, -1));
            this.mVC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HV(int i) {
        if (this.mVu != null && this.mVu.video != null && this.mVu.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.a(this.mVu.getAdFacadeData(), 36, this.mVu.getAdFacadeData().getPageNum(), i, this.mVB, com.baidu.tieba.ad.b.a.tc(this.jnF.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        if (this.mVu != null && this.mVu.video != null && this.mVu.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.a(this.mVu.getAdFacadeData(), 32, this.mVu.getAdFacadeData().getPageNum(), i, this.mVB, com.baidu.tieba.ad.b.a.tc(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(int i, int i2) {
        if (this.mVu != null && this.mVu.video != null && this.mVu.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.a(this.mVu.getAdFacadeData(), 33, this.mVu.getAdFacadeData().getPageNum(), i, this.mVB, com.baidu.tieba.ad.b.a.tc(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(this.mVu.getAdFacadeData(), 303, this.mVu.getAdFacadeData().getPageNum(), this.eXf ? 0 : 1, this.mVu.video.video_duration.intValue(), 0, -1);
            if (this.mVz != null) {
                this.mVz.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(boolean z) {
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
        private int ezR = -1;
        private Runnable jMW = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jMW);
                a.this.AL(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void AL(int i) {
            switch (i) {
                case 0:
                    this.ezR = AM(i);
                    cMq();
                    return;
                case 1:
                    this.ezR = AM(i);
                    this.mHandler.removeCallbacks(this.jMW);
                    return;
                case 2:
                    this.ezR = AN(i);
                    return;
                case 3:
                    this.ezR = AO(i);
                    cMq();
                    return;
                default:
                    this.ezR = AN(i);
                    return;
            }
        }

        private void cMq() {
            this.mHandler.removeCallbacks(this.jMW);
            this.mHandler.postDelayed(this.jMW, IMConnection.RETRY_DELAY_TIMES);
        }

        private int AM(int i) {
            if (i != this.ezR) {
                VideoMiddlePageAdView.this.mVs.setVisibility(8);
                VideoMiddlePageAdView.this.mVr.setVisibility(8);
                VideoMiddlePageAdView.this.xB(true);
                return i;
            }
            return this.ezR;
        }

        private int AN(int i) {
            int i2 = this.ezR;
            if (i != this.ezR) {
                VideoMiddlePageAdView.this.mVs.setVisibility(0);
                VideoMiddlePageAdView.this.mVr.setVisibility(0);
                if (VideoMiddlePageAdView.this.jnF != null) {
                    VideoMiddlePageAdView.this.jnF.dzT();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mVu.autoPlay) {
                    VideoMiddlePageAdView.this.xB(false);
                    return i;
                }
                return i;
            }
            return this.ezR;
        }

        private int AO(int i) {
            if (i != this.ezR) {
                VideoMiddlePageAdView.this.mVs.setVisibility(0);
                VideoMiddlePageAdView.this.mVr.setVisibility(0);
                VideoMiddlePageAdView.this.xB(true);
                return i;
            }
            return this.ezR;
        }
    }
}
