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
    public FrameLayout iZN;
    public FrameLayout iZO;
    public TextView iZP;
    public HeadImageView iZU;
    public c jac;
    private View jyK;
    private View jyQ;
    private com.baidu.tieba.frs.videomiddlepage.c jyS;
    private VideoNetworkStateTipView jyV;
    private Animation.AnimationListener jzc;
    private Animation.AnimationListener jzd;
    private View mKX;
    private View mKY;
    private View mKZ;
    public TextView mLa;
    private VideoMiddlePageAdCard mLb;
    private TextView mLc;
    private TextView mLd;
    private ViewGroup mLe;
    private d mLf;
    private e mLg;
    private f mLh;
    private int mLi;
    private boolean mLj;
    private boolean mLk;
    private a mLl;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mLj = false;
        this.mLk = true;
        this.jzc = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jyQ != null) {
                    VideoMiddlePageAdView.this.jyQ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mKX != null) {
                    VideoMiddlePageAdView.this.mKX.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jyQ != null) {
                    VideoMiddlePageAdView.this.jyQ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mKX != null) {
                    VideoMiddlePageAdView.this.mKX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jzd = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jyQ != null) {
                    VideoMiddlePageAdView.this.jyQ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mKX != null) {
                    VideoMiddlePageAdView.this.mKX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jyQ != null) {
                    VideoMiddlePageAdView.this.jyQ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mKX != null) {
                    VideoMiddlePageAdView.this.mKX.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mLj = false;
        this.mLk = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.iZN = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jyK = this.rootView.findViewById(R.id.card_container);
        this.iZO = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jac = new c(this.eNx, this.iZO, false);
        this.jac.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jac.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jac != null && VideoMiddlePageAdView.this.jac.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mLi = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jac.getVideoView().getDuration());
                }
            }
        });
        this.jac.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void rd(boolean z) {
                if (VideoMiddlePageAdView.this.mLl != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mLl.BV(0);
                    } else {
                        VideoMiddlePageAdView.this.mLl.BV(1);
                    }
                }
            }
        });
        this.jac.kTF.setOnTouchListener(null);
        this.iZP = (TextView) this.rootView.findViewById(R.id.title);
        this.iZU = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.iZU.setIsRound(true);
        this.iZU.setDefaultBgResource(R.color.CAM_X0205);
        this.iZU.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iZU.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.mLa = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.aky = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mLc = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mLd = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mLe = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mLf = new d(this.eNx.getPageActivity(), this.mLe);
        this.mLf.page = 1;
        this.jyV = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jyV.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jyV.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jac.wW(false);
                VideoMiddlePageAdView.this.jyV.dXg();
                if (VideoMiddlePageAdView.this.mLb != null && VideoMiddlePageAdView.this.mLb.video != null) {
                    VideoMiddlePageAdView.this.jac.gb(VideoMiddlePageAdView.this.mLb.video.video_url, "");
                }
            }
        });
        this.jyQ = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mKY = this.rootView.findViewById(R.id.user_container_foreground);
        this.mKZ = this.rootView.findViewById(R.id.title_foreground);
        this.mKX = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jyQ.setOnClickListener(this);
        this.mKY.setOnClickListener(this);
        this.mKZ.setOnClickListener(this);
        this.mKX.setOnClickListener(this);
        this.iZO.setOnClickListener(this);
        this.iZN.setOnClickListener(this);
        this.jac.ab(this);
        this.iZP.setOnClickListener(this);
        this.iZU.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eNx.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZN.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iZN.setLayoutParams(layoutParams);
        this.cbQ = new AlphaAnimation(0.0f, 0.7f);
        this.cbQ.setDuration(500L);
        this.cbQ.setAnimationListener(this.jzd);
        this.cbR = new AlphaAnimation(0.7f, 0.0f);
        this.cbR.setDuration(500L);
        this.cbR.setAnimationListener(this.jzc);
        this.rootView.setOnClickListener(this);
        this.mLl = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddV() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.ePB = this.mLb.autoPlay;
            this.mLj = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mLi = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jac.rM()) {
                dn(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jac.getCurrentPosition());
                this.mLk = true;
            }
            this.jac.stopPlay();
            this.jac.wX(true);
            this.jac.wT(false);
            this.jac.wY(true);
            this.jac.av(false, true);
            this.jac.IG(i);
            this.jac.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                }
            });
            this.jac.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cEY() {
                    if (VideoMiddlePageAdView.this.mLb != null && VideoMiddlePageAdView.this.mLb.video != null && VideoMiddlePageAdView.this.mLb.video.video_height.intValue() > VideoMiddlePageAdView.this.mLb.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jac.av(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jac.av(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mLh != null) {
                        VideoMiddlePageAdView.this.mLh.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Jn(VideoMiddlePageAdView.this.ePB ? 0 : 1);
                    VideoMiddlePageAdView.this.mLj = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cEZ() {
                }
            });
            this.jac.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qt(boolean z) {
                    VideoMiddlePageAdView.this.jac.gb(VideoMiddlePageAdView.this.mLb.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mLh != null) {
                        VideoMiddlePageAdView.this.mLh.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Jn(1);
                    VideoMiddlePageAdView.this.mLj = false;
                }
            });
            this.jac.wP(false);
            this.jac.dev();
            this.jac.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jac.cRo();
                    if (VideoMiddlePageAdView.this.mLg != null) {
                        VideoMiddlePageAdView.this.mLg.dGm();
                    }
                    VideoMiddlePageAdView.this.Jo(VideoMiddlePageAdView.this.ePB ? 0 : 1);
                    VideoMiddlePageAdView.this.mLk = true;
                }
            });
            this.jac.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Jp(VideoMiddlePageAdView.this.ePB ? 0 : 1);
                    return true;
                }
            });
            this.jac.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jac.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jac.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cFb() {
                    VideoMiddlePageAdView.this.m40do(1, VideoMiddlePageAdView.this.jac.getCurrentPosition());
                }
            });
            this.jac.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dn(1, VideoMiddlePageAdView.this.jac.getCurrentPosition());
                    VideoMiddlePageAdView.this.mLk = true;
                }
            });
            this.jac.cRo();
            this.jac.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jyV.dxi()) {
                    this.jac.wV(false);
                    this.jyV.dXf();
                    this.jac.wW(true);
                    this.jac.ga(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jac.wW(false);
                    this.jac.wV(false);
                    this.jyV.hide();
                    this.jac.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mLg != null) {
                    this.mLg.xn(true);
                }
                if (i == 0) {
                    this.jyQ.setVisibility(8);
                    this.mKX.setVisibility(8);
                } else {
                    this.jyQ.startAnimation(this.cbR);
                    this.mKX.startAnimation(this.cbR);
                }
                if (i == 0) {
                    this.mLl.BV(3);
                    return;
                } else {
                    this.mLl.BV(0);
                    return;
                }
            }
            this.jyV.hide();
            this.jac.wV(true);
            this.mLl.BV(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jyQ.startAnimation(this.cbR);
                this.mKX.startAnimation(this.cbR);
                return;
            }
            this.jyQ.setVisibility(0);
            this.mKX.setVisibility(0);
        }
    }

    private boolean cLx() {
        try {
            int intValue = this.mLb.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mLb.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.iZP.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLa.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLc.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mLd.setTextColor(this.eNx.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mLd, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cLy() {
        if (!cLx()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZN.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iZN.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iZN.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iZN.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mLb = videoMiddlePageAdCard;
        cLy();
        this.iZP.setText(videoMiddlePageAdCard.threadTitle);
        this.aky.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.iZU.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.iZU.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.iZU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bxj() || VideoMiddlePageAdView.this.mLb == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mLb.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eNx.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mLa.setText(videoMiddlePageAdCard.tagName);
        this.mLc.setText(videoMiddlePageAdCard.operateData.mJa);
        this.mLd.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (VideoMiddlePageAdView.this.mLb == null || VideoMiddlePageAdView.this.mLb.getAdFacadeData() == null || VideoMiddlePageAdView.this.mLb.getAdFacadeData().rs() == null) {
                    str = null;
                } else {
                    str = VideoMiddlePageAdView.this.d(VideoMiddlePageAdView.this.mLb.getAdFacadeData().rs());
                }
                int c = s.c(VideoMiddlePageAdView.this.eNx, videoMiddlePageAdCard.operateData.scheme, str);
                if (VideoMiddlePageAdView.this.mLg != null) {
                    VideoMiddlePageAdView.this.mLg.xn(false);
                }
                if (VideoMiddlePageAdView.this.kTh != null) {
                    VideoMiddlePageAdView.this.kTh.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mLb, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mLg = this.mLf.a(videoMiddlePageAdCard.tailFrame, this.mLg);
        if (this.mLg != null) {
            b(this.mLb.getAdFacadeData());
            this.mLg.setPageContext(this.eNx);
            this.mLg.setTimeoutListener(this);
            this.mLg.a(videoMiddlePageAdCard.tailFrame);
            this.mLg.c(this.mLb);
            this.mLg.dGn();
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
        this.jyS = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mLh = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ca(View view) {
        this.aac.Ao(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cEW();
        if (this.jyQ != null) {
            this.jyQ.clearAnimation();
        }
        if (this.mKX != null) {
            this.mKX.clearAnimation();
        }
    }

    public void cEV() {
        this.jac.stopPlay();
        if (this.iZP != null) {
            this.iZP.setVisibility(0);
        }
        if (this.mLl != null) {
            this.mLl.BV(2);
        }
        this.mLj = false;
        this.mLk = true;
    }

    public void cEW() {
        if (this.jac != null) {
            this.jac.destroy();
        }
        this.mLj = false;
        this.mLk = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jyQ && this.jyQ.getVisibility() == 0) {
            if (this.jyS != null) {
                this.jyS.BZ(this.mPosition);
            }
        } else if (view == this.mKX && this.mKX.getVisibility() == 0) {
            if (this.jyS != null) {
                this.jyS.BZ(this.mPosition);
            }
        } else if (view == this.mKZ || view == this.mKY) {
            if (this.jyQ.getVisibility() == 0) {
                if (this.jyS != null) {
                    this.jyS.BZ(this.mPosition);
                    return;
                }
                return;
            }
            this.mLl.BV(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dFz();
        } else {
            int c = s.c(this.eNx, this.mLb.getScheme(), (this.mLb.getAdFacadeData() == null || this.mLb.getAdFacadeData().rs() == null) ? null : d(this.mLb.getAdFacadeData().rs()));
            if (this.kTh != null) {
                this.kTh.d(c, null);
            }
            if (this.mLg != null) {
                this.mLg.xn(false);
            }
        }
    }

    private void dFz() {
        if (this.eNx != null && this.eNx.getPageActivity() != null && this.mLb != null && this.mLb.getAdFacadeData() != null && !TextUtils.isEmpty(this.mLb.getScheme())) {
            String scheme = this.mLb.getScheme();
            AdvertAppInfo rs = this.mLb.getAdFacadeData().rs();
            boolean ba = s.RT(this.mLb.getScheme()) ? s.ba(this.eNx.getPageActivity(), scheme) : false;
            if (this.kTh != null) {
                this.kTh.d(ba ? 1 : 2, null);
            }
            if (this.mLg != null) {
                this.mLg.xn(false);
            }
            if (!ba) {
                String RU = s.RU(scheme);
                NewWebVideoActivity.a(rs, this.mLb.getAdFacadeData().ZO != null ? this.mLb.getAdFacadeData().ZO.ro() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.eNx.getPageActivity(), "", RU, true, true, true, this.mLb.video.video_url, this.mLb.video.thumbnail_url, 1.7777778f, this.mLi, d(this.mLb.getAdFacadeData().rs()));
                newWebVideoActivityConfig.setTailFrame(this.mLb.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.us(this.jac.getCurrentPosition()) < this.mLi && this.jac.rM()) {
            dn(this.ePB ? 0 : 1, this.jac.getCurrentPosition());
        }
        cEV();
        this.mLg.xn(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aSi() {
        if (isPlaying()) {
            this.jac.aSi();
            dn(this.ePB ? 0 : 1, this.jac.getCurrentPosition());
            this.mLk = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jac.rM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jn(int i) {
        if (this.mLb != null && this.mLb.video != null && this.mLb.getAdFacadeData() != null && this.mLk) {
            com.baidu.tieba.recapp.report.d.dGf().a(g.a(this.mLb.getAdFacadeData(), 31, this.mLb.getAdFacadeData().getPageNum(), i, this.mLi, 0, -1));
            this.mLk = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo(int i) {
        if (this.mLb != null && this.mLb.video != null && this.mLb.getAdFacadeData() != null && !this.mLj) {
            com.baidu.tieba.recapp.report.d.dGf().a(g.a(this.mLb.getAdFacadeData(), 34, this.mLb.getAdFacadeData().getPageNum(), i, this.mLi, this.mLi, -1));
            this.mLj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp(int i) {
        if (this.mLb != null && this.mLb.video != null && this.mLb.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dGf().a(g.a(this.mLb.getAdFacadeData(), 36, this.mLb.getAdFacadeData().getPageNum(), i, this.mLi, com.baidu.tieba.ad.a.a.us(this.jac.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(int i, int i2) {
        if (this.mLb != null && this.mLb.video != null && this.mLb.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dGf().a(g.a(this.mLb.getAdFacadeData(), 32, this.mLb.getAdFacadeData().getPageNum(), i, this.mLi, com.baidu.tieba.ad.a.a.us(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m40do(int i, int i2) {
        if (this.mLb != null && this.mLb.video != null && this.mLb.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dGf().a(g.a(this.mLb.getAdFacadeData(), 33, this.mLb.getAdFacadeData().getPageNum(), i, this.mLi, com.baidu.tieba.ad.a.a.us(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.mLb.getAdFacadeData(), 303, this.mLb.getAdFacadeData().getPageNum(), this.ePB ? 0 : 1, this.mLb.video.video_duration.intValue(), 0, -1);
            if (this.mLg != null) {
                this.mLg.e(a2);
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
        private Runnable jzj = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jzj);
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
                    cLI();
                    return;
                case 1:
                    this.cnU = BW(i);
                    this.mHandler.removeCallbacks(this.jzj);
                    return;
                case 2:
                    this.cnU = BX(i);
                    return;
                case 3:
                    this.cnU = BY(i);
                    cLI();
                    return;
                default:
                    this.cnU = BX(i);
                    return;
            }
        }

        private void cLI() {
            this.mHandler.removeCallbacks(this.jzj);
            this.mHandler.postDelayed(this.jzj, IMConnection.RETRY_DELAY_TIMES);
        }

        private int BW(int i) {
            if (i != this.cnU) {
                VideoMiddlePageAdView.this.mKZ.setVisibility(8);
                VideoMiddlePageAdView.this.mKY.setVisibility(8);
                VideoMiddlePageAdView.this.xl(true);
                return i;
            }
            return this.cnU;
        }

        private int BX(int i) {
            int i2 = this.cnU;
            if (i != this.cnU) {
                VideoMiddlePageAdView.this.mKZ.setVisibility(0);
                VideoMiddlePageAdView.this.mKY.setVisibility(0);
                if (VideoMiddlePageAdView.this.jac != null) {
                    VideoMiddlePageAdView.this.jac.dBE();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mLb.autoPlay) {
                    VideoMiddlePageAdView.this.xl(false);
                    return i;
                }
                return i;
            }
            return this.cnU;
        }

        private int BY(int i) {
            if (i != this.cnU) {
                VideoMiddlePageAdView.this.mKZ.setVisibility(0);
                VideoMiddlePageAdView.this.mKY.setVisibility(0);
                VideoMiddlePageAdView.this.xl(true);
                return i;
            }
            return this.cnU;
        }
    }
}
