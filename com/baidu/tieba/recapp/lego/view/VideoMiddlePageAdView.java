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
import com.baidu.tieba.recapp.s;
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
    private Animation.AnimationListener jMB;
    private Animation.AnimationListener jMC;
    private View jMj;
    private View jMp;
    private c jMr;
    private VideoNetworkStateTipView jMu;
    public FrameLayout jnc;
    public FrameLayout jnd;
    public TextView jne;
    public HeadImageView jnj;
    public com.baidu.tieba.play.c jnr;
    private View mUQ;
    private View mUR;
    private View mUS;
    public TextView mUT;
    private VideoMiddlePageAdCard mUU;
    private TextView mUV;
    private TextView mUW;
    private ViewGroup mUX;
    private d mUY;
    private e mUZ;
    private f mVa;
    private int mVb;
    private boolean mVc;
    private boolean mVd;
    private a mVe;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mVc = false;
        this.mVd = true;
        this.jMB = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jMp != null) {
                    VideoMiddlePageAdView.this.jMp.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mUQ != null) {
                    VideoMiddlePageAdView.this.mUQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jMp != null) {
                    VideoMiddlePageAdView.this.jMp.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mUQ != null) {
                    VideoMiddlePageAdView.this.mUQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jMC = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jMp != null) {
                    VideoMiddlePageAdView.this.jMp.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mUQ != null) {
                    VideoMiddlePageAdView.this.mUQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jMp != null) {
                    VideoMiddlePageAdView.this.jMp.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mUQ != null) {
                    VideoMiddlePageAdView.this.mUQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mVc = false;
        this.mVd = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.jnc = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jMj = this.rootView.findViewById(R.id.card_container);
        this.jnd = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jnr = new com.baidu.tieba.play.c(this.eUY, this.jnd, false);
        this.jnr.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jnr.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jnr != null && VideoMiddlePageAdView.this.jnr.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mVb = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jnr.getVideoView().getDuration());
                }
            }
        });
        this.jnr.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void rI(boolean z) {
                if (VideoMiddlePageAdView.this.mVe != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mVe.AL(0);
                    } else {
                        VideoMiddlePageAdView.this.mVe.AL(1);
                    }
                }
            }
        });
        this.jnr.bUP.setOnTouchListener(null);
        this.jne = (TextView) this.rootView.findViewById(R.id.title);
        this.jnj = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.jnj.setIsRound(true);
        this.jnj.setDefaultBgResource(R.color.CAM_X0205);
        this.jnj.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mUT = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ajY = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mUV = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mUW = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mUX = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mUY = new d(this.eUY.getPageActivity(), this.mUX);
        this.mUY.page = 1;
        this.jMu = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jMu.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jMu.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jnr.xl(false);
                VideoMiddlePageAdView.this.jMu.dVe();
                if (VideoMiddlePageAdView.this.mUU != null && VideoMiddlePageAdView.this.mUU.video != null) {
                    VideoMiddlePageAdView.this.jnr.fX(VideoMiddlePageAdView.this.mUU.video.video_url, "");
                }
            }
        });
        this.jMp = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mUR = this.rootView.findViewById(R.id.user_container_foreground);
        this.mUS = this.rootView.findViewById(R.id.title_foreground);
        this.mUQ = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jMp.setOnClickListener(this);
        this.mUR.setOnClickListener(this);
        this.mUS.setOnClickListener(this);
        this.mUQ.setOnClickListener(this);
        this.jnd.setOnClickListener(this);
        this.jnc.setOnClickListener(this);
        this.jnr.ad(this);
        this.jne.setOnClickListener(this);
        this.jnj.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eUY.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jnc.setLayoutParams(layoutParams);
        this.chW = new AlphaAnimation(0.0f, 0.7f);
        this.chW.setDuration(500L);
        this.chW.setAnimationListener(this.jMC);
        this.chX = new AlphaAnimation(0.7f, 0.0f);
        this.chX.setDuration(500L);
        this.chX.setAnimationListener(this.jMB);
        this.rootView.setOnClickListener(this);
        this.mVe = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eXf = this.mUU.autoPlay;
            this.mVc = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mVb = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jnr.rl()) {
                dg(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jnr.getCurrentPosition());
                this.mVd = true;
            }
            this.jnr.stopPlay();
            this.jnr.xm(true);
            this.jnr.xi(false);
            this.jnr.xn(true);
            this.jnr.ax(false, true);
            this.jnr.Hm(i);
            this.jnr.a(new c.InterfaceC0848c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rj() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rk() {
                }
            });
            this.jnr.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cFo() {
                    if (VideoMiddlePageAdView.this.mUU != null && VideoMiddlePageAdView.this.mUU.video != null && VideoMiddlePageAdView.this.mUU.video.video_height.intValue() > VideoMiddlePageAdView.this.mUU.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jnr.ax(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jnr.ax(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mVa != null) {
                        VideoMiddlePageAdView.this.mVa.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HT(VideoMiddlePageAdView.this.eXf ? 0 : 1);
                    VideoMiddlePageAdView.this.mVc = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFp() {
                }
            });
            this.jnr.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z) {
                    VideoMiddlePageAdView.this.jnr.fX(VideoMiddlePageAdView.this.mUU.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mVa != null) {
                        VideoMiddlePageAdView.this.mVa.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HT(1);
                    VideoMiddlePageAdView.this.mVc = false;
                }
            });
            this.jnr.xd(false);
            this.jnr.dco();
            this.jnr.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jnr.cSD();
                    if (VideoMiddlePageAdView.this.mUZ != null) {
                        VideoMiddlePageAdView.this.mUZ.dEt();
                    }
                    VideoMiddlePageAdView.this.HU(VideoMiddlePageAdView.this.eXf ? 0 : 1);
                    VideoMiddlePageAdView.this.mVd = true;
                }
            });
            this.jnr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.HV(VideoMiddlePageAdView.this.eXf ? 0 : 1);
                    return true;
                }
            });
            this.jnr.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jnr.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jnr.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cFr() {
                    VideoMiddlePageAdView.this.dh(1, VideoMiddlePageAdView.this.jnr.getCurrentPosition());
                }
            });
            this.jnr.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dg(1, VideoMiddlePageAdView.this.jnr.getCurrentPosition());
                    VideoMiddlePageAdView.this.mVd = true;
                }
            });
            this.jnr.cSD();
            this.jnr.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jMu.dvu()) {
                    this.jnr.xk(false);
                    this.jMu.dVd();
                    this.jnr.xl(true);
                    this.jnr.fW(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jnr.xl(false);
                    this.jnr.xk(false);
                    this.jMu.hide();
                    this.jnr.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mUZ != null) {
                    this.mUZ.xD(true);
                }
                if (i == 0) {
                    this.jMp.setVisibility(8);
                    this.mUQ.setVisibility(8);
                } else {
                    this.jMp.startAnimation(this.chX);
                    this.mUQ.startAnimation(this.chX);
                }
                if (i == 0) {
                    this.mVe.AL(3);
                    return;
                } else {
                    this.mVe.AL(0);
                    return;
                }
            }
            this.jMu.hide();
            this.jnr.xk(true);
            this.mVe.AL(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jMp.startAnimation(this.chX);
                this.mUQ.startAnimation(this.chX);
                return;
            }
            this.jMp.setVisibility(0);
            this.mUQ.setVisibility(0);
        }
    }

    private boolean cLY() {
        try {
            int intValue = this.mUU.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mUU.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.jne.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mUT.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mUV.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mUW.setTextColor(this.eUY.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mUW, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cLZ() {
        if (!cLY()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnc.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jnc.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jnc.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jnc.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mUU = videoMiddlePageAdCard;
        cLZ();
        this.jne.setText(videoMiddlePageAdCard.threadTitle);
        this.ajY.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.jnj.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.jnj.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.jnj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bwc() || VideoMiddlePageAdView.this.mUU == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mUU.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eUY.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mUT.setText(videoMiddlePageAdCard.tagName);
        this.mUV.setText(videoMiddlePageAdCard.operateData.mSN);
        this.mUW.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (VideoMiddlePageAdView.this.mUU == null || VideoMiddlePageAdView.this.mUU.getAdFacadeData() == null || VideoMiddlePageAdView.this.mUU.getAdFacadeData().qS() == null) {
                    str = null;
                } else {
                    str = VideoMiddlePageAdView.this.d(VideoMiddlePageAdView.this.mUU.getAdFacadeData().qS());
                }
                int c = s.c(VideoMiddlePageAdView.this.eUY, videoMiddlePageAdCard.operateData.scheme, str);
                if (VideoMiddlePageAdView.this.mUZ != null) {
                    VideoMiddlePageAdView.this.mUZ.xD(false);
                }
                if (VideoMiddlePageAdView.this.lcl != null) {
                    VideoMiddlePageAdView.this.lcl.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mUU, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mUZ = this.mUY.a(videoMiddlePageAdCard.tailFrame, this.mUZ);
        if (this.mUZ != null) {
            b(this.mUU.getAdFacadeData());
            this.mUZ.setPageContext(this.eUY);
            this.mUZ.setTimeoutListener(this);
            this.mUZ.a(videoMiddlePageAdCard.tailFrame);
            this.mUZ.c(this.mUU);
            this.mUZ.dEu();
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
        this.jMr = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mVa = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void cf(View view) {
        this.aaF.ze(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cFm();
        if (this.jMp != null) {
            this.jMp.clearAnimation();
        }
        if (this.mUQ != null) {
            this.mUQ.clearAnimation();
        }
    }

    public void stopVideo() {
        this.jnr.stopPlay();
        if (this.jne != null) {
            this.jne.setVisibility(0);
        }
        if (this.mVe != null) {
            this.mVe.AL(2);
        }
        this.mVc = false;
        this.mVd = true;
    }

    public void cFm() {
        if (this.jnr != null) {
            this.jnr.destroy();
        }
        this.mVc = false;
        this.mVd = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jMp && this.jMp.getVisibility() == 0) {
            if (this.jMr != null) {
                this.jMr.AP(this.mPosition);
            }
        } else if (view == this.mUQ && this.mUQ.getVisibility() == 0) {
            if (this.jMr != null) {
                this.jMr.AP(this.mPosition);
            }
        } else if (view == this.mUS || view == this.mUR) {
            if (this.jMp.getVisibility() == 0) {
                if (this.jMr != null) {
                    this.jMr.AP(this.mPosition);
                    return;
                }
                return;
            }
            this.mVe.AL(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dDG();
        } else {
            int c = s.c(this.eUY, this.mUU.getScheme(), (this.mUU.getAdFacadeData() == null || this.mUU.getAdFacadeData().qS() == null) ? null : d(this.mUU.getAdFacadeData().qS()));
            if (this.lcl != null) {
                this.lcl.d(c, null);
            }
            if (this.mUZ != null) {
                this.mUZ.xD(false);
            }
        }
    }

    private void dDG() {
        if (this.eUY != null && this.eUY.getPageActivity() != null && this.mUU != null && this.mUU.getAdFacadeData() != null && !TextUtils.isEmpty(this.mUU.getScheme())) {
            String scheme = this.mUU.getScheme();
            AdvertAppInfo qS = this.mUU.getAdFacadeData().qS();
            int be = s.Rm(this.mUU.getScheme()) ? s.be(this.eUY.getPageActivity(), scheme) : 0;
            if (this.lcl != null) {
                this.lcl.d(be, null);
            }
            if (this.mUZ != null) {
                this.mUZ.xD(false);
            }
            if (be != 1000) {
                String Rn = s.Rn(scheme);
                AdWebVideoActivity.a(qS, this.mUU.getAdFacadeData().aar != null ? this.mUU.getAdFacadeData().aar.qO() : 0, "DETAIL");
                Bundle bundle = new Bundle();
                bundle.putString("video_url", this.mUU.video.video_url);
                bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.mUU.video.thumbnail_url);
                bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
                bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.mVb);
                bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.mUU.tailFrame.toJsonString());
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, d(this.mUU.getAdFacadeData().qS()));
                AdWebVideoActivity.a(new AdWebVideoActivityConfig(this.eUY.getPageActivity(), "", Rn, true, true, true, bundle));
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.tc(this.jnr.getCurrentPosition()) < this.mVb && this.jnr.rl()) {
            dg(this.eXf ? 0 : 1, this.jnr.getCurrentPosition());
        }
        stopVideo();
        this.mUZ.xD(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void pausePlay() {
        if (isPlaying()) {
            this.jnr.pausePlay();
            dg(this.eXf ? 0 : 1, this.jnr.getCurrentPosition());
            this.mVd = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jnr.rl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HT(int i) {
        if (this.mUU != null && this.mUU.video != null && this.mUU.getAdFacadeData() != null && this.mVd) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(this.mUU.getAdFacadeData(), 31, this.mUU.getAdFacadeData().getPageNum(), i, this.mVb, 0, -1));
            this.mVd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU(int i) {
        if (this.mUU != null && this.mUU.video != null && this.mUU.getAdFacadeData() != null && !this.mVc) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(this.mUU.getAdFacadeData(), 34, this.mUU.getAdFacadeData().getPageNum(), i, this.mVb, this.mVb, -1));
            this.mVc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HV(int i) {
        if (this.mUU != null && this.mUU.video != null && this.mUU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(this.mUU.getAdFacadeData(), 36, this.mUU.getAdFacadeData().getPageNum(), i, this.mVb, com.baidu.tieba.ad.a.a.tc(this.jnr.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(int i, int i2) {
        if (this.mUU != null && this.mUU.video != null && this.mUU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(this.mUU.getAdFacadeData(), 32, this.mUU.getAdFacadeData().getPageNum(), i, this.mVb, com.baidu.tieba.ad.a.a.tc(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        if (this.mUU != null && this.mUU.video != null && this.mUU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(this.mUU.getAdFacadeData(), 33, this.mUU.getAdFacadeData().getPageNum(), i, this.mVb, com.baidu.tieba.ad.a.a.tc(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(this.mUU.getAdFacadeData(), 303, this.mUU.getAdFacadeData().getPageNum(), this.eXf ? 0 : 1, this.mUU.video.video_duration.intValue(), 0, -1);
            if (this.mUZ != null) {
                this.mUZ.e(a2);
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
        private Runnable jMI = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jMI);
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
                    cMj();
                    return;
                case 1:
                    this.ezR = AM(i);
                    this.mHandler.removeCallbacks(this.jMI);
                    return;
                case 2:
                    this.ezR = AN(i);
                    return;
                case 3:
                    this.ezR = AO(i);
                    cMj();
                    return;
                default:
                    this.ezR = AN(i);
                    return;
            }
        }

        private void cMj() {
            this.mHandler.removeCallbacks(this.jMI);
            this.mHandler.postDelayed(this.jMI, IMConnection.RETRY_DELAY_TIMES);
        }

        private int AM(int i) {
            if (i != this.ezR) {
                VideoMiddlePageAdView.this.mUS.setVisibility(8);
                VideoMiddlePageAdView.this.mUR.setVisibility(8);
                VideoMiddlePageAdView.this.xB(true);
                return i;
            }
            return this.ezR;
        }

        private int AN(int i) {
            int i2 = this.ezR;
            if (i != this.ezR) {
                VideoMiddlePageAdView.this.mUS.setVisibility(0);
                VideoMiddlePageAdView.this.mUR.setVisibility(0);
                if (VideoMiddlePageAdView.this.jnr != null) {
                    VideoMiddlePageAdView.this.jnr.dzM();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mUU.autoPlay) {
                    VideoMiddlePageAdView.this.xB(false);
                    return i;
                }
                return i;
            }
            return this.ezR;
        }

        private int AO(int i) {
            if (i != this.ezR) {
                VideoMiddlePageAdView.this.mUS.setVisibility(0);
                VideoMiddlePageAdView.this.mUR.setVisibility(0);
                VideoMiddlePageAdView.this.xB(true);
                return i;
            }
            return this.ezR;
        }
    }
}
