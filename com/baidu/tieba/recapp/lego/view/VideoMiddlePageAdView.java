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
/* loaded from: classes7.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, k, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a aaJ;
    public TextView akj;
    private Animation cdO;
    private Animation cdP;
    private boolean eUP;
    private View jGF;
    private View jGL;
    private c jGN;
    private VideoNetworkStateTipView jGQ;
    private Animation.AnimationListener jGX;
    private Animation.AnimationListener jGY;
    public HeadImageView jhB;
    public com.baidu.tieba.play.c jhJ;
    public FrameLayout jhu;
    public FrameLayout jhv;
    public TextView jhw;
    private View mLB;
    private View mLC;
    private View mLD;
    public TextView mLE;
    private VideoMiddlePageAdCard mLF;
    private TextView mLG;
    private TextView mLH;
    private ViewGroup mLI;
    private d mLJ;
    private e mLK;
    private f mLL;
    private int mLM;
    private boolean mLN;
    private boolean mLO;
    private a mLP;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mLN = false;
        this.mLO = true;
        this.jGX = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jGL != null) {
                    VideoMiddlePageAdView.this.jGL.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mLB != null) {
                    VideoMiddlePageAdView.this.mLB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jGL != null) {
                    VideoMiddlePageAdView.this.jGL.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mLB != null) {
                    VideoMiddlePageAdView.this.mLB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jGY = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jGL != null) {
                    VideoMiddlePageAdView.this.jGL.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mLB != null) {
                    VideoMiddlePageAdView.this.mLB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jGL != null) {
                    VideoMiddlePageAdView.this.jGL.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mLB != null) {
                    VideoMiddlePageAdView.this.mLB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mLN = false;
        this.mLO = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.jhu = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jGF = this.rootView.findViewById(R.id.card_container);
        this.jhv = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jhJ = new com.baidu.tieba.play.c(this.eSJ, this.jhv, false);
        this.jhJ.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jhJ.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jhJ != null && VideoMiddlePageAdView.this.jhJ.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mLM = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jhJ.getVideoView().getDuration());
                }
            }
        });
        this.jhJ.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void ry(boolean z) {
                if (VideoMiddlePageAdView.this.mLP != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mLP.AB(0);
                    } else {
                        VideoMiddlePageAdView.this.mLP.AB(1);
                    }
                }
            }
        });
        this.jhJ.bRa.setOnTouchListener(null);
        this.jhw = (TextView) this.rootView.findViewById(R.id.title);
        this.jhB = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.jhB.setIsRound(true);
        this.jhB.setDefaultBgResource(R.color.CAM_X0205);
        this.jhB.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mLE = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.akj = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mLG = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mLH = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mLI = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mLJ = new d(this.eSJ.getPageActivity(), this.mLI);
        this.mLJ.page = 1;
        this.jGQ = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jGQ.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jGQ.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jhJ.wT(false);
                VideoMiddlePageAdView.this.jGQ.dST();
                if (VideoMiddlePageAdView.this.mLF != null && VideoMiddlePageAdView.this.mLF.video != null) {
                    VideoMiddlePageAdView.this.jhJ.fX(VideoMiddlePageAdView.this.mLF.video.video_url, "");
                }
            }
        });
        this.jGL = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mLC = this.rootView.findViewById(R.id.user_container_foreground);
        this.mLD = this.rootView.findViewById(R.id.title_foreground);
        this.mLB = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jGL.setOnClickListener(this);
        this.mLC.setOnClickListener(this);
        this.mLD.setOnClickListener(this);
        this.mLB.setOnClickListener(this);
        this.jhv.setOnClickListener(this);
        this.jhu.setOnClickListener(this);
        this.jhJ.ad(this);
        this.jhw.setOnClickListener(this);
        this.jhB.setOnClickListener(this);
        this.akj.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eSJ.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jhu.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jhu.setLayoutParams(layoutParams);
        this.cdO = new AlphaAnimation(0.0f, 0.7f);
        this.cdO.setDuration(500L);
        this.cdO.setAnimationListener(this.jGY);
        this.cdP = new AlphaAnimation(0.7f, 0.0f);
        this.cdP.setDuration(500L);
        this.cdP.setAnimationListener(this.jGX);
        this.rootView.setOnClickListener(this);
        this.mLP = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eUP = this.mLF.autoPlay;
            this.mLN = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mLM = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jhJ.rn()) {
                dj(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jhJ.getCurrentPosition());
                this.mLO = true;
            }
            this.jhJ.stopPlay();
            this.jhJ.wU(true);
            this.jhJ.wQ(false);
            this.jhJ.wV(true);
            this.jhJ.ax(false, true);
            this.jhJ.GT(i);
            this.jhJ.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rl() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rm() {
                }
            });
            this.jhJ.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cEc() {
                    if (VideoMiddlePageAdView.this.mLF != null && VideoMiddlePageAdView.this.mLF.video != null && VideoMiddlePageAdView.this.mLF.video.video_height.intValue() > VideoMiddlePageAdView.this.mLF.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jhJ.ax(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jhJ.ax(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mLL != null) {
                        VideoMiddlePageAdView.this.mLL.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HA(VideoMiddlePageAdView.this.eUP ? 0 : 1);
                    VideoMiddlePageAdView.this.mLN = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cEd() {
                }
            });
            this.jhJ.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qN(boolean z) {
                    VideoMiddlePageAdView.this.jhJ.fX(VideoMiddlePageAdView.this.mLF.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mLL != null) {
                        VideoMiddlePageAdView.this.mLL.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HA(1);
                    VideoMiddlePageAdView.this.mLN = false;
                }
            });
            this.jhJ.wM(false);
            this.jhJ.daq();
            this.jhJ.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jhJ.cQE();
                    if (VideoMiddlePageAdView.this.mLK != null) {
                        VideoMiddlePageAdView.this.mLK.dCl();
                    }
                    VideoMiddlePageAdView.this.HB(VideoMiddlePageAdView.this.eUP ? 0 : 1);
                    VideoMiddlePageAdView.this.mLO = true;
                }
            });
            this.jhJ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.HC(VideoMiddlePageAdView.this.eUP ? 0 : 1);
                    return true;
                }
            });
            this.jhJ.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jhJ.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jhJ.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cEf() {
                    VideoMiddlePageAdView.this.dk(1, VideoMiddlePageAdView.this.jhJ.getCurrentPosition());
                }
            });
            this.jhJ.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dj(1, VideoMiddlePageAdView.this.jhJ.getCurrentPosition());
                    VideoMiddlePageAdView.this.mLO = true;
                }
            });
            this.jhJ.cQE();
            this.jhJ.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jGQ.dth()) {
                    this.jhJ.wS(false);
                    this.jGQ.dSS();
                    this.jhJ.wT(true);
                    this.jhJ.fW(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jhJ.wT(false);
                    this.jhJ.wS(false);
                    this.jGQ.hide();
                    this.jhJ.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mLK != null) {
                    this.mLK.xk(true);
                }
                if (i == 0) {
                    this.jGL.setVisibility(8);
                    this.mLB.setVisibility(8);
                } else {
                    this.jGL.startAnimation(this.cdP);
                    this.mLB.startAnimation(this.cdP);
                }
                if (i == 0) {
                    this.mLP.AB(3);
                    return;
                } else {
                    this.mLP.AB(0);
                    return;
                }
            }
            this.jGQ.hide();
            this.jhJ.wS(true);
            this.mLP.AB(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jGL.startAnimation(this.cdP);
                this.mLB.startAnimation(this.cdP);
                return;
            }
            this.jGL.setVisibility(0);
            this.mLB.setVisibility(0);
        }
    }

    private boolean cKK() {
        try {
            int intValue = this.mLF.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mLF.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.jhw.setTextColor(this.eSJ.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLE.setTextColor(this.eSJ.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLG.setTextColor(this.eSJ.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLH.setTextColor(this.eSJ.getResources().getColor(R.color.cp_cont_i_alpha70));
        ao.setBackgroundResource(this.mLH, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cKL() {
        if (!cKK()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jhu.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jhu.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jhu.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jhu.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mLF = videoMiddlePageAdCard;
        cKL();
        this.jhw.setText(videoMiddlePageAdCard.threadTitle);
        this.akj.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.jhB.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.jhB.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.jhB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bvJ() || VideoMiddlePageAdView.this.mLF == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mLF.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eSJ.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mLE.setText(videoMiddlePageAdCard.tagName);
        this.mLG.setText(videoMiddlePageAdCard.operateData.mJF);
        this.mLH.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (VideoMiddlePageAdView.this.mLF == null || VideoMiddlePageAdView.this.mLF.getAdFacadeData() == null || VideoMiddlePageAdView.this.mLF.getAdFacadeData().qU() == null) {
                    str = null;
                } else {
                    str = VideoMiddlePageAdView.this.d(VideoMiddlePageAdView.this.mLF.getAdFacadeData().qU());
                }
                int c = s.c(VideoMiddlePageAdView.this.eSJ, videoMiddlePageAdCard.operateData.scheme, str);
                if (VideoMiddlePageAdView.this.mLK != null) {
                    VideoMiddlePageAdView.this.mLK.xk(false);
                }
                if (VideoMiddlePageAdView.this.kUi != null) {
                    VideoMiddlePageAdView.this.kUi.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mLF, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mLK = this.mLJ.a(videoMiddlePageAdCard.tailFrame, this.mLK);
        if (this.mLK != null) {
            b(this.mLF.getAdFacadeData());
            this.mLK.setPageContext(this.eSJ);
            this.mLK.setTimeoutListener(this);
            this.mLK.a(videoMiddlePageAdCard.tailFrame);
            this.mLK.c(this.mLF);
            this.mLK.dCm();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.aaJ = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.aaJ;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jGN = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mLL = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void cj(View view) {
        this.aaJ.yU(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cEa();
        if (this.jGL != null) {
            this.jGL.clearAnimation();
        }
        if (this.mLB != null) {
            this.mLB.clearAnimation();
        }
    }

    public void stopVideo() {
        this.jhJ.stopPlay();
        if (this.jhw != null) {
            this.jhw.setVisibility(0);
        }
        if (this.mLP != null) {
            this.mLP.AB(2);
        }
        this.mLN = false;
        this.mLO = true;
    }

    public void cEa() {
        if (this.jhJ != null) {
            this.jhJ.destroy();
        }
        this.mLN = false;
        this.mLO = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jGL && this.jGL.getVisibility() == 0) {
            if (this.jGN != null) {
                this.jGN.AF(this.mPosition);
            }
        } else if (view == this.mLB && this.mLB.getVisibility() == 0) {
            if (this.jGN != null) {
                this.jGN.AF(this.mPosition);
            }
        } else if (view == this.mLD || view == this.mLC) {
            if (this.jGL.getVisibility() == 0) {
                if (this.jGN != null) {
                    this.jGN.AF(this.mPosition);
                    return;
                }
                return;
            }
            this.mLP.AB(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dBy();
        } else {
            int c = s.c(this.eSJ, this.mLF.getScheme(), (this.mLF.getAdFacadeData() == null || this.mLF.getAdFacadeData().qU() == null) ? null : d(this.mLF.getAdFacadeData().qU()));
            if (this.kUi != null) {
                this.kUi.d(c, null);
            }
            if (this.mLK != null) {
                this.mLK.xk(false);
            }
        }
    }

    private void dBy() {
        if (this.eSJ != null && this.eSJ.getPageActivity() != null && this.mLF != null && this.mLF.getAdFacadeData() != null && !TextUtils.isEmpty(this.mLF.getScheme())) {
            String scheme = this.mLF.getScheme();
            AdvertAppInfo qU = this.mLF.getAdFacadeData().qU();
            boolean bf = s.Qq(this.mLF.getScheme()) ? s.bf(this.eSJ.getPageActivity(), scheme) : false;
            if (this.kUi != null) {
                this.kUi.d(bf ? 1 : 2, null);
            }
            if (this.mLK != null) {
                this.mLK.xk(false);
            }
            if (!bf) {
                String Qr = s.Qr(scheme);
                AdWebVideoActivity.a(qU, this.mLF.getAdFacadeData().aav != null ? this.mLF.getAdFacadeData().aav.qQ() : 0, "DETAIL");
                Bundle bundle = new Bundle();
                bundle.putString("video_url", this.mLF.video.video_url);
                bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.mLF.video.thumbnail_url);
                bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
                bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.mLM);
                bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.mLF.tailFrame.toJsonString());
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, d(this.mLF.getAdFacadeData().qU()));
                AdWebVideoActivity.a(new AdWebVideoActivityConfig(this.eSJ.getPageActivity(), "", Qr, true, true, true, bundle));
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.sX(this.jhJ.getCurrentPosition()) < this.mLM && this.jhJ.rn()) {
            dj(this.eUP ? 0 : 1, this.jhJ.getCurrentPosition());
        }
        stopVideo();
        this.mLK.xk(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aQJ() {
        if (isPlaying()) {
            this.jhJ.aQJ();
            dj(this.eUP ? 0 : 1, this.jhJ.getCurrentPosition());
            this.mLO = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jhJ.rn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HA(int i) {
        if (this.mLF != null && this.mLF.video != null && this.mLF.getAdFacadeData() != null && this.mLO) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(this.mLF.getAdFacadeData(), 31, this.mLF.getAdFacadeData().getPageNum(), i, this.mLM, 0, -1));
            this.mLO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB(int i) {
        if (this.mLF != null && this.mLF.video != null && this.mLF.getAdFacadeData() != null && !this.mLN) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(this.mLF.getAdFacadeData(), 34, this.mLF.getAdFacadeData().getPageNum(), i, this.mLM, this.mLM, -1));
            this.mLN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(int i) {
        if (this.mLF != null && this.mLF.video != null && this.mLF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(this.mLF.getAdFacadeData(), 36, this.mLF.getAdFacadeData().getPageNum(), i, this.mLM, com.baidu.tieba.ad.a.a.sX(this.jhJ.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i, int i2) {
        if (this.mLF != null && this.mLF.video != null && this.mLF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(this.mLF.getAdFacadeData(), 32, this.mLF.getAdFacadeData().getPageNum(), i, this.mLM, com.baidu.tieba.ad.a.a.sX(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i, int i2) {
        if (this.mLF != null && this.mLF.video != null && this.mLF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(this.mLF.getAdFacadeData(), 33, this.mLF.getAdFacadeData().getPageNum(), i, this.mLM, com.baidu.tieba.ad.a.a.sX(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(this.mLF.getAdFacadeData(), 303, this.mLF.getAdFacadeData().getPageNum(), this.eUP ? 0 : 1, this.mLF.video.video_duration.intValue(), 0, -1);
            if (this.mLK != null) {
                this.mLK.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi(boolean z) {
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
    /* loaded from: classes7.dex */
    public class a {
        private int cqj = -1;
        private Runnable jHe = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jHe);
                a.this.AB(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void AB(int i) {
            switch (i) {
                case 0:
                    this.cqj = AC(i);
                    cKV();
                    return;
                case 1:
                    this.cqj = AC(i);
                    this.mHandler.removeCallbacks(this.jHe);
                    return;
                case 2:
                    this.cqj = AD(i);
                    return;
                case 3:
                    this.cqj = AE(i);
                    cKV();
                    return;
                default:
                    this.cqj = AD(i);
                    return;
            }
        }

        private void cKV() {
            this.mHandler.removeCallbacks(this.jHe);
            this.mHandler.postDelayed(this.jHe, IMConnection.RETRY_DELAY_TIMES);
        }

        private int AC(int i) {
            if (i != this.cqj) {
                VideoMiddlePageAdView.this.mLD.setVisibility(8);
                VideoMiddlePageAdView.this.mLC.setVisibility(8);
                VideoMiddlePageAdView.this.xi(true);
                return i;
            }
            return this.cqj;
        }

        private int AD(int i) {
            int i2 = this.cqj;
            if (i != this.cqj) {
                VideoMiddlePageAdView.this.mLD.setVisibility(0);
                VideoMiddlePageAdView.this.mLC.setVisibility(0);
                if (VideoMiddlePageAdView.this.jhJ != null) {
                    VideoMiddlePageAdView.this.jhJ.dxD();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mLF.autoPlay) {
                    VideoMiddlePageAdView.this.xi(false);
                    return i;
                }
                return i;
            }
            return this.cqj;
        }

        private int AE(int i) {
            if (i != this.cqj) {
                VideoMiddlePageAdView.this.mLD.setVisibility(0);
                VideoMiddlePageAdView.this.mLC.setVisibility(0);
                VideoMiddlePageAdView.this.xi(true);
                return i;
            }
            return this.cqj;
        }
    }
}
