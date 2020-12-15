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
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes26.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, k, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a aac;
    public TextView aky;
    private Animation cbQ;
    private Animation cbR;
    private boolean ePB;
    public FrameLayout iZP;
    public FrameLayout iZQ;
    public TextView iZR;
    public HeadImageView iZW;
    public c jae;
    private View jyM;
    private View jyS;
    private com.baidu.tieba.frs.videomiddlepage.c jyU;
    private VideoNetworkStateTipView jyX;
    private Animation.AnimationListener jze;
    private Animation.AnimationListener jzf;
    private View mKZ;
    private View mLa;
    private View mLb;
    public TextView mLc;
    private VideoMiddlePageAdCard mLd;
    private TextView mLe;
    private TextView mLf;
    private ViewGroup mLg;
    private d mLh;
    private e mLi;
    private f mLj;
    private int mLk;
    private boolean mLl;
    private boolean mLm;
    private a mLn;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mLl = false;
        this.mLm = true;
        this.jze = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jyS != null) {
                    VideoMiddlePageAdView.this.jyS.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mKZ != null) {
                    VideoMiddlePageAdView.this.mKZ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jyS != null) {
                    VideoMiddlePageAdView.this.jyS.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mKZ != null) {
                    VideoMiddlePageAdView.this.mKZ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jzf = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jyS != null) {
                    VideoMiddlePageAdView.this.jyS.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mKZ != null) {
                    VideoMiddlePageAdView.this.mKZ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jyS != null) {
                    VideoMiddlePageAdView.this.jyS.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mKZ != null) {
                    VideoMiddlePageAdView.this.mKZ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mLl = false;
        this.mLm = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.iZP = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jyM = this.rootView.findViewById(R.id.card_container);
        this.iZQ = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jae = new c(this.eNx, this.iZQ, false);
        this.jae.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jae.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jae != null && VideoMiddlePageAdView.this.jae.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mLk = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jae.getVideoView().getDuration());
                }
            }
        });
        this.jae.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void rd(boolean z) {
                if (VideoMiddlePageAdView.this.mLn != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mLn.BV(0);
                    } else {
                        VideoMiddlePageAdView.this.mLn.BV(1);
                    }
                }
            }
        });
        this.jae.kTH.setOnTouchListener(null);
        this.iZR = (TextView) this.rootView.findViewById(R.id.title);
        this.iZW = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.iZW.setIsRound(true);
        this.iZW.setDefaultBgResource(R.color.CAM_X0205);
        this.iZW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iZW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.mLc = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.aky = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mLe = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mLf = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mLg = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mLh = new d(this.eNx.getPageActivity(), this.mLg);
        this.mLh.page = 1;
        this.jyX = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jyX.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jyX.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jae.wW(false);
                VideoMiddlePageAdView.this.jyX.dXh();
                if (VideoMiddlePageAdView.this.mLd != null && VideoMiddlePageAdView.this.mLd.video != null) {
                    VideoMiddlePageAdView.this.jae.gb(VideoMiddlePageAdView.this.mLd.video.video_url, "");
                }
            }
        });
        this.jyS = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mLa = this.rootView.findViewById(R.id.user_container_foreground);
        this.mLb = this.rootView.findViewById(R.id.title_foreground);
        this.mKZ = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jyS.setOnClickListener(this);
        this.mLa.setOnClickListener(this);
        this.mLb.setOnClickListener(this);
        this.mKZ.setOnClickListener(this);
        this.iZQ.setOnClickListener(this);
        this.iZP.setOnClickListener(this);
        this.jae.ab(this);
        this.iZR.setOnClickListener(this);
        this.iZW.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eNx.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iZP.setLayoutParams(layoutParams);
        this.cbQ = new AlphaAnimation(0.0f, 0.7f);
        this.cbQ.setDuration(500L);
        this.cbQ.setAnimationListener(this.jzf);
        this.cbR = new AlphaAnimation(0.7f, 0.0f);
        this.cbR.setDuration(500L);
        this.cbR.setAnimationListener(this.jze);
        this.rootView.setOnClickListener(this);
        this.mLn = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddW() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.ePB = this.mLd.autoPlay;
            this.mLl = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mLk = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jae.rM()) {
                dn(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jae.getCurrentPosition());
                this.mLm = true;
            }
            this.jae.stopPlay();
            this.jae.wX(true);
            this.jae.wT(false);
            this.jae.wY(true);
            this.jae.av(false, true);
            this.jae.IG(i);
            this.jae.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                }
            });
            this.jae.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cEZ() {
                    if (VideoMiddlePageAdView.this.mLd != null && VideoMiddlePageAdView.this.mLd.video != null && VideoMiddlePageAdView.this.mLd.video.video_height.intValue() > VideoMiddlePageAdView.this.mLd.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jae.av(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jae.av(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mLj != null) {
                        VideoMiddlePageAdView.this.mLj.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Jn(VideoMiddlePageAdView.this.ePB ? 0 : 1);
                    VideoMiddlePageAdView.this.mLl = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFa() {
                }
            });
            this.jae.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qt(boolean z) {
                    VideoMiddlePageAdView.this.jae.gb(VideoMiddlePageAdView.this.mLd.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mLj != null) {
                        VideoMiddlePageAdView.this.mLj.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Jn(1);
                    VideoMiddlePageAdView.this.mLl = false;
                }
            });
            this.jae.wP(false);
            this.jae.dew();
            this.jae.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jae.cRp();
                    if (VideoMiddlePageAdView.this.mLi != null) {
                        VideoMiddlePageAdView.this.mLi.dGn();
                    }
                    VideoMiddlePageAdView.this.Jo(VideoMiddlePageAdView.this.ePB ? 0 : 1);
                    VideoMiddlePageAdView.this.mLm = true;
                }
            });
            this.jae.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Jp(VideoMiddlePageAdView.this.ePB ? 0 : 1);
                    return true;
                }
            });
            this.jae.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jae.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jae.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cFc() {
                    VideoMiddlePageAdView.this.m40do(1, VideoMiddlePageAdView.this.jae.getCurrentPosition());
                }
            });
            this.jae.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dn(1, VideoMiddlePageAdView.this.jae.getCurrentPosition());
                    VideoMiddlePageAdView.this.mLm = true;
                }
            });
            this.jae.cRp();
            this.jae.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jyX.dxj()) {
                    this.jae.wV(false);
                    this.jyX.dXg();
                    this.jae.wW(true);
                    this.jae.ga(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jae.wW(false);
                    this.jae.wV(false);
                    this.jyX.hide();
                    this.jae.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mLi != null) {
                    this.mLi.xn(true);
                }
                if (i == 0) {
                    this.jyS.setVisibility(8);
                    this.mKZ.setVisibility(8);
                } else {
                    this.jyS.startAnimation(this.cbR);
                    this.mKZ.startAnimation(this.cbR);
                }
                if (i == 0) {
                    this.mLn.BV(3);
                    return;
                } else {
                    this.mLn.BV(0);
                    return;
                }
            }
            this.jyX.hide();
            this.jae.wV(true);
            this.mLn.BV(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jyS.startAnimation(this.cbR);
                this.mKZ.startAnimation(this.cbR);
                return;
            }
            this.jyS.setVisibility(0);
            this.mKZ.setVisibility(0);
        }
    }

    private boolean cLy() {
        try {
            int intValue = this.mLd.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mLd.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.iZR.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLc.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLe.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLf.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mLf, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cLz() {
        if (!cLy()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iZP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iZP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iZP.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mLd = videoMiddlePageAdCard;
        cLz();
        this.iZR.setText(videoMiddlePageAdCard.threadTitle);
        this.aky.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.iZW.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.iZW.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.iZW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bxj() || VideoMiddlePageAdView.this.mLd == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mLd.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eNx.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mLc.setText(videoMiddlePageAdCard.tagName);
        this.mLe.setText(videoMiddlePageAdCard.operateData.mJc);
        this.mLf.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (VideoMiddlePageAdView.this.mLd == null || VideoMiddlePageAdView.this.mLd.getAdFacadeData() == null || VideoMiddlePageAdView.this.mLd.getAdFacadeData().rs() == null) {
                    str = null;
                } else {
                    str = VideoMiddlePageAdView.this.d(VideoMiddlePageAdView.this.mLd.getAdFacadeData().rs());
                }
                int c = s.c(VideoMiddlePageAdView.this.eNx, videoMiddlePageAdCard.operateData.scheme, str);
                if (VideoMiddlePageAdView.this.mLi != null) {
                    VideoMiddlePageAdView.this.mLi.xn(false);
                }
                if (VideoMiddlePageAdView.this.kTj != null) {
                    VideoMiddlePageAdView.this.kTj.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mLd, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mLi = this.mLh.a(videoMiddlePageAdCard.tailFrame, this.mLi);
        if (this.mLi != null) {
            b(this.mLd.getAdFacadeData());
            this.mLi.setPageContext(this.eNx);
            this.mLi.setTimeoutListener(this);
            this.mLi.a(videoMiddlePageAdCard.tailFrame);
            this.mLi.c(this.mLd);
            this.mLi.dGo();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.aac = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.aac;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jyU = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mLj = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ca(View view) {
        this.aac.Ao(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cEX();
        if (this.jyS != null) {
            this.jyS.clearAnimation();
        }
        if (this.mKZ != null) {
            this.mKZ.clearAnimation();
        }
    }

    public void cEW() {
        this.jae.stopPlay();
        if (this.iZR != null) {
            this.iZR.setVisibility(0);
        }
        if (this.mLn != null) {
            this.mLn.BV(2);
        }
        this.mLl = false;
        this.mLm = true;
    }

    public void cEX() {
        if (this.jae != null) {
            this.jae.destroy();
        }
        this.mLl = false;
        this.mLm = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jyS && this.jyS.getVisibility() == 0) {
            if (this.jyU != null) {
                this.jyU.BZ(this.mPosition);
            }
        } else if (view == this.mKZ && this.mKZ.getVisibility() == 0) {
            if (this.jyU != null) {
                this.jyU.BZ(this.mPosition);
            }
        } else if (view == this.mLb || view == this.mLa) {
            if (this.jyS.getVisibility() == 0) {
                if (this.jyU != null) {
                    this.jyU.BZ(this.mPosition);
                    return;
                }
                return;
            }
            this.mLn.BV(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dFA();
        } else {
            int c = s.c(this.eNx, this.mLd.getScheme(), (this.mLd.getAdFacadeData() == null || this.mLd.getAdFacadeData().rs() == null) ? null : d(this.mLd.getAdFacadeData().rs()));
            if (this.kTj != null) {
                this.kTj.d(c, null);
            }
            if (this.mLi != null) {
                this.mLi.xn(false);
            }
        }
    }

    private void dFA() {
        if (this.eNx != null && this.eNx.getPageActivity() != null && this.mLd != null && this.mLd.getAdFacadeData() != null && !TextUtils.isEmpty(this.mLd.getScheme())) {
            String scheme = this.mLd.getScheme();
            AdvertAppInfo rs = this.mLd.getAdFacadeData().rs();
            boolean ba = s.RT(this.mLd.getScheme()) ? s.ba(this.eNx.getPageActivity(), scheme) : false;
            if (this.kTj != null) {
                this.kTj.d(ba ? 1 : 2, null);
            }
            if (this.mLi != null) {
                this.mLi.xn(false);
            }
            if (!ba) {
                String RU = s.RU(scheme);
                NewWebVideoActivity.a(rs, this.mLd.getAdFacadeData().ZO != null ? this.mLd.getAdFacadeData().ZO.ro() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.eNx.getPageActivity(), "", RU, true, true, true, this.mLd.video.video_url, this.mLd.video.thumbnail_url, 1.7777778f, this.mLk, d(this.mLd.getAdFacadeData().rs()));
                newWebVideoActivityConfig.setTailFrame(this.mLd.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.us(this.jae.getCurrentPosition()) < this.mLk && this.jae.rM()) {
            dn(this.ePB ? 0 : 1, this.jae.getCurrentPosition());
        }
        cEW();
        this.mLi.xn(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aSi() {
        if (isPlaying()) {
            this.jae.aSi();
            dn(this.ePB ? 0 : 1, this.jae.getCurrentPosition());
            this.mLm = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jae.rM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jn(int i) {
        if (this.mLd != null && this.mLd.video != null && this.mLd.getAdFacadeData() != null && this.mLm) {
            com.baidu.tieba.recapp.report.d.dGg().a(g.a(this.mLd.getAdFacadeData(), 31, this.mLd.getAdFacadeData().getPageNum(), i, this.mLk, 0, -1));
            this.mLm = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo(int i) {
        if (this.mLd != null && this.mLd.video != null && this.mLd.getAdFacadeData() != null && !this.mLl) {
            com.baidu.tieba.recapp.report.d.dGg().a(g.a(this.mLd.getAdFacadeData(), 34, this.mLd.getAdFacadeData().getPageNum(), i, this.mLk, this.mLk, -1));
            this.mLl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp(int i) {
        if (this.mLd != null && this.mLd.video != null && this.mLd.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dGg().a(g.a(this.mLd.getAdFacadeData(), 36, this.mLd.getAdFacadeData().getPageNum(), i, this.mLk, com.baidu.tieba.ad.a.a.us(this.jae.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(int i, int i2) {
        if (this.mLd != null && this.mLd.video != null && this.mLd.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dGg().a(g.a(this.mLd.getAdFacadeData(), 32, this.mLd.getAdFacadeData().getPageNum(), i, this.mLk, com.baidu.tieba.ad.a.a.us(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m40do(int i, int i2) {
        if (this.mLd != null && this.mLd.video != null && this.mLd.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dGg().a(g.a(this.mLd.getAdFacadeData(), 33, this.mLd.getAdFacadeData().getPageNum(), i, this.mLk, com.baidu.tieba.ad.a.a.us(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.mLd.getAdFacadeData(), 303, this.mLd.getAdFacadeData().getPageNum(), this.ePB ? 0 : 1, this.mLd.video.video_duration.intValue(), 0, -1);
            if (this.mLi != null) {
                this.mLi.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(boolean z) {
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
        private int cnU = -1;
        private Runnable jzl = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jzl);
                a.this.BV(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void BV(int i) {
            switch (i) {
                case 0:
                    this.cnU = BW(i);
                    cLJ();
                    return;
                case 1:
                    this.cnU = BW(i);
                    this.mHandler.removeCallbacks(this.jzl);
                    return;
                case 2:
                    this.cnU = BX(i);
                    return;
                case 3:
                    this.cnU = BY(i);
                    cLJ();
                    return;
                default:
                    this.cnU = BX(i);
                    return;
            }
        }

        private void cLJ() {
            this.mHandler.removeCallbacks(this.jzl);
            this.mHandler.postDelayed(this.jzl, IMConnection.RETRY_DELAY_TIMES);
        }

        private int BW(int i) {
            if (i != this.cnU) {
                VideoMiddlePageAdView.this.mLb.setVisibility(8);
                VideoMiddlePageAdView.this.mLa.setVisibility(8);
                VideoMiddlePageAdView.this.xl(true);
                return i;
            }
            return this.cnU;
        }

        private int BX(int i) {
            int i2 = this.cnU;
            if (i != this.cnU) {
                VideoMiddlePageAdView.this.mLb.setVisibility(0);
                VideoMiddlePageAdView.this.mLa.setVisibility(0);
                if (VideoMiddlePageAdView.this.jae != null) {
                    VideoMiddlePageAdView.this.jae.dBF();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mLd.autoPlay) {
                    VideoMiddlePageAdView.this.xl(false);
                    return i;
                }
                return i;
            }
            return this.cnU;
        }

        private int BY(int i) {
            if (i != this.cnU) {
                VideoMiddlePageAdView.this.mLb.setVisibility(0);
                VideoMiddlePageAdView.this.mLa.setVisibility(0);
                VideoMiddlePageAdView.this.xl(true);
                return i;
            }
            return this.cnU;
        }
    }
}
