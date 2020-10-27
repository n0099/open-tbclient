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
    private Animation bSB;
    private Animation bSC;
    private boolean eDB;
    public c iIB;
    public FrameLayout iIm;
    public FrameLayout iIn;
    public TextView iIo;
    public HeadImageView iIt;
    private View jeF;
    private com.baidu.tieba.frs.videomiddlepage.c jeH;
    private VideoNetworkStateTipView jeK;
    private Animation.AnimationListener jeR;
    private Animation.AnimationListener jeS;
    private View jez;
    private int mWidth;
    private View mqA;
    private View mqB;
    private View mqC;
    public TextView mqD;
    private VideoMiddlePageAdCard mqE;
    private TextView mqF;
    private TextView mqG;
    private ViewGroup mqH;
    private d mqI;
    private e mqJ;
    private f mqK;
    private int mqL;
    private boolean mqM;
    private boolean mqN;
    private a mqO;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mqM = false;
        this.mqN = true;
        this.jeR = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jeF != null) {
                    VideoMiddlePageAdView.this.jeF.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mqA != null) {
                    VideoMiddlePageAdView.this.mqA.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jeF != null) {
                    VideoMiddlePageAdView.this.jeF.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mqA != null) {
                    VideoMiddlePageAdView.this.mqA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jeS = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jeF != null) {
                    VideoMiddlePageAdView.this.jeF.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mqA != null) {
                    VideoMiddlePageAdView.this.mqA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jeF != null) {
                    VideoMiddlePageAdView.this.jeF.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mqA != null) {
                    VideoMiddlePageAdView.this.mqA.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mqM = false;
        this.mqN = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.iIm = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jez = this.rootView.findViewById(R.id.card_container);
        this.iIn = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.iIB = new c(this.eCn, this.iIn, false);
        this.iIB.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.iIB.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.iIB != null && VideoMiddlePageAdView.this.iIB.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mqL = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.iIB.getVideoView().getDuration());
                }
            }
        });
        this.iIB.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void qq(boolean z) {
                if (VideoMiddlePageAdView.this.mqO != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mqO.Av(0);
                    } else {
                        VideoMiddlePageAdView.this.mqO.Av(1);
                    }
                }
            }
        });
        this.iIB.kAe.setOnTouchListener(null);
        this.iIo = (TextView) this.rootView.findViewById(R.id.title);
        this.iIt = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.iIt.setIsRound(true);
        this.iIt.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iIt.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iIt.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.mqD = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.aju = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mqF = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mqG = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mqH = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mqI = new d(this.eCn.getPageActivity(), this.mqH);
        this.mqI.page = 1;
        this.jeK = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jeK.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jeK.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.iIB.wg(false);
                VideoMiddlePageAdView.this.jeK.dPl();
                if (VideoMiddlePageAdView.this.mqE != null && VideoMiddlePageAdView.this.mqE.video != null) {
                    VideoMiddlePageAdView.this.iIB.fW(VideoMiddlePageAdView.this.mqE.video.video_url, "");
                }
            }
        });
        this.jeF = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mqB = this.rootView.findViewById(R.id.user_container_foreground);
        this.mqC = this.rootView.findViewById(R.id.title_foreground);
        this.mqA = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jeF.setOnClickListener(this);
        this.mqB.setOnClickListener(this);
        this.mqC.setOnClickListener(this);
        this.mqA.setOnClickListener(this);
        this.iIn.setOnClickListener(this);
        this.iIm.setOnClickListener(this);
        this.iIB.ab(this);
        this.iIo.setOnClickListener(this);
        this.iIt.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eCn.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iIm.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iIm.setLayoutParams(layoutParams);
        this.bSB = new AlphaAnimation(0.0f, 0.7f);
        this.bSB.setDuration(500L);
        this.bSB.setAnimationListener(this.jeS);
        this.bSC = new AlphaAnimation(0.7f, 0.0f);
        this.bSC.setDuration(500L);
        this.bSC.setAnimationListener(this.jeR);
        this.rootView.setOnClickListener(this);
        this.mqO = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cWN() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eDB = this.mqE.autoPlay;
            this.mqM = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mqL = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.iIB.rK()) {
                dg(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.iIB.getCurrentPosition());
                this.mqN = true;
            }
            this.iIB.stopPlay();
            this.iIB.wh(true);
            this.iIB.wd(false);
            this.iIB.wi(true);
            this.iIB.ay(false, true);
            this.iIB.He(i);
            this.iIB.a(new c.InterfaceC0812c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rI() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rJ() {
                }
            });
            this.iIB.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cyE() {
                    if (VideoMiddlePageAdView.this.mqE != null && VideoMiddlePageAdView.this.mqE.video != null && VideoMiddlePageAdView.this.mqE.video.video_height.intValue() > VideoMiddlePageAdView.this.mqE.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.iIB.ay(false, true);
                    } else {
                        VideoMiddlePageAdView.this.iIB.ay(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mqK != null) {
                        VideoMiddlePageAdView.this.mqK.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HI(VideoMiddlePageAdView.this.eDB ? 0 : 1);
                    VideoMiddlePageAdView.this.mqM = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cyF() {
                }
            });
            this.iIB.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void pK(boolean z) {
                    VideoMiddlePageAdView.this.iIB.fW(VideoMiddlePageAdView.this.mqE.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mqK != null) {
                        VideoMiddlePageAdView.this.mqK.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HI(1);
                    VideoMiddlePageAdView.this.mqM = false;
                }
            });
            this.iIB.vZ(false);
            this.iIB.cXn();
            this.iIB.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.iIB.cJS();
                    if (VideoMiddlePageAdView.this.mqJ != null) {
                        VideoMiddlePageAdView.this.mqJ.dyU();
                    }
                    VideoMiddlePageAdView.this.HJ(VideoMiddlePageAdView.this.eDB ? 0 : 1);
                    VideoMiddlePageAdView.this.mqN = true;
                }
            });
            this.iIB.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.HK(VideoMiddlePageAdView.this.eDB ? 0 : 1);
                    return true;
                }
            });
            this.iIB.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.iIB.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.iIB.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cyH() {
                    VideoMiddlePageAdView.this.dh(1, VideoMiddlePageAdView.this.iIB.getCurrentPosition());
                }
            });
            this.iIB.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dg(1, VideoMiddlePageAdView.this.iIB.getCurrentPosition());
                    VideoMiddlePageAdView.this.mqN = true;
                }
            });
            this.iIB.cJS();
            this.iIB.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jeK.dpO()) {
                    this.iIB.wf(false);
                    this.jeK.dPk();
                    this.iIB.wg(true);
                    this.iIB.fV(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.iIB.wg(false);
                    this.iIB.wf(false);
                    this.jeK.hide();
                    this.iIB.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mqJ != null) {
                    this.mqJ.wx(true);
                }
                if (i == 0) {
                    this.jeF.setVisibility(8);
                    this.mqA.setVisibility(8);
                } else {
                    this.jeF.startAnimation(this.bSC);
                    this.mqA.startAnimation(this.bSC);
                }
                if (i == 0) {
                    this.mqO.Av(3);
                    return;
                } else {
                    this.mqO.Av(0);
                    return;
                }
            }
            this.jeK.hide();
            this.iIB.wf(true);
            this.mqO.Av(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jeF.startAnimation(this.bSC);
                this.mqA.startAnimation(this.bSC);
                return;
            }
            this.jeF.setVisibility(0);
            this.mqA.setVisibility(0);
        }
    }

    private boolean cEc() {
        try {
            int intValue = this.mqE.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mqE.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.iIo.setTextColor(this.eCn.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mqD.setTextColor(this.eCn.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mqF.setTextColor(this.eCn.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mqG.setTextColor(this.eCn.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mqG, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cEd() {
        if (!cEc()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iIm.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iIm.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iIm.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iIm.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mqE = videoMiddlePageAdCard;
        cEd();
        this.iIo.setText(videoMiddlePageAdCard.threadTitle);
        this.aju.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.iIt.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.iIt.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.iIt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.brT() || VideoMiddlePageAdView.this.mqE == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mqE.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eCn.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mqD.setText(videoMiddlePageAdCard.tagName);
        this.mqF.setText(videoMiddlePageAdCard.operateData.moz);
        this.mqG.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.eCn, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.mqE == null || VideoMiddlePageAdView.this.mqE.getAdFacadeData() == null || VideoMiddlePageAdView.this.mqE.getAdFacadeData().rq() == null) ? null : VideoMiddlePageAdView.this.mqE.getAdFacadeData().rq().esU);
                if (VideoMiddlePageAdView.this.mqJ != null) {
                    VideoMiddlePageAdView.this.mqJ.wx(false);
                }
                if (VideoMiddlePageAdView.this.kzG != null) {
                    VideoMiddlePageAdView.this.kzG.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mqE, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mqJ = this.mqI.a(videoMiddlePageAdCard.tailFrame, this.mqJ);
        if (this.mqJ != null) {
            b(this.mqE.getAdFacadeData());
            this.mqJ.setPageContext(this.eCn);
            this.mqJ.setTimeoutListener(this);
            this.mqJ.a(videoMiddlePageAdCard.tailFrame);
            this.mqJ.c(this.mqE);
            this.mqJ.dyV();
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
        this.jeH = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mqK = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bM(View view) {
        this.Za.yY(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        cyC();
        if (this.jeF != null) {
            this.jeF.clearAnimation();
        }
        if (this.mqA != null) {
            this.mqA.clearAnimation();
        }
    }

    public void cyB() {
        this.iIB.stopPlay();
        if (this.iIo != null) {
            this.iIo.setVisibility(0);
        }
        if (this.mqO != null) {
            this.mqO.Av(2);
        }
        this.mqM = false;
        this.mqN = true;
    }

    public void cyC() {
        if (this.iIB != null) {
            this.iIB.destroy();
        }
        this.mqM = false;
        this.mqN = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jeF && this.jeF.getVisibility() == 0) {
            if (this.jeH != null) {
                this.jeH.Az(this.mPosition);
            }
        } else if (view == this.mqA && this.mqA.getVisibility() == 0) {
            if (this.jeH != null) {
                this.jeH.Az(this.mPosition);
            }
        } else if (view == this.mqC || view == this.mqB) {
            if (this.jeF.getVisibility() == 0) {
                if (this.jeH != null) {
                    this.jeH.Az(this.mPosition);
                    return;
                }
                return;
            }
            this.mqO.Av(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dyj();
        } else {
            int c = s.c(this.eCn, this.mqE.getScheme(), (this.mqE.getAdFacadeData() == null || this.mqE.getAdFacadeData().rq() == null) ? null : this.mqE.getAdFacadeData().rq().esU);
            if (this.kzG != null) {
                this.kzG.d(c, null);
            }
            if (this.mqJ != null) {
                this.mqJ.wx(false);
            }
        }
    }

    private void dyj() {
        if (this.eCn != null && this.eCn.getPageActivity() != null && this.mqE != null && this.mqE.getAdFacadeData() != null && !TextUtils.isEmpty(this.mqE.getScheme())) {
            String scheme = this.mqE.getScheme();
            AdvertAppInfo rq = this.mqE.getAdFacadeData().rq();
            boolean aZ = s.QY(this.mqE.getScheme()) ? s.aZ(this.eCn.getPageActivity(), scheme) : false;
            if (this.kzG != null) {
                this.kzG.d(aZ ? 1 : 2, null);
            }
            if (this.mqJ != null) {
                this.mqJ.wx(false);
            }
            if (!aZ) {
                String QZ = s.QZ(scheme);
                NewWebVideoActivity.a(rq, this.mqE.getAdFacadeData().YM != null ? this.mqE.getAdFacadeData().YM.rm() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.eCn.getPageActivity(), "", QZ, true, true, true, this.mqE.video.video_url, this.mqE.video.thumbnail_url, 1.7777778f, this.mqL, this.mqE.getAdFacadeData().rq().esU);
                newWebVideoActivityConfig.setTailFrame(this.mqE.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.tg(this.iIB.getCurrentPosition()) < this.mqL && this.iIB.rK()) {
            dg(this.eDB ? 0 : 1, this.iIB.getCurrentPosition());
        }
        cyB();
        this.mqJ.wx(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aNl() {
        if (isPlaying()) {
            this.iIB.aNl();
            dg(this.eDB ? 0 : 1, this.iIB.getCurrentPosition());
            this.mqN = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iIB.rK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HI(int i) {
        if (this.mqE != null && this.mqE.video != null && this.mqE.getAdFacadeData() != null && this.mqN) {
            com.baidu.tieba.recapp.report.d.dyN().a(g.a(this.mqE.getAdFacadeData(), 31, this.mqE.getAdFacadeData().getPageNum(), i, this.mqL, 0, -1));
            this.mqN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ(int i) {
        if (this.mqE != null && this.mqE.video != null && this.mqE.getAdFacadeData() != null && !this.mqM) {
            com.baidu.tieba.recapp.report.d.dyN().a(g.a(this.mqE.getAdFacadeData(), 34, this.mqE.getAdFacadeData().getPageNum(), i, this.mqL, this.mqL, -1));
            this.mqM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK(int i) {
        if (this.mqE != null && this.mqE.video != null && this.mqE.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dyN().a(g.a(this.mqE.getAdFacadeData(), 36, this.mqE.getAdFacadeData().getPageNum(), i, this.mqL, com.baidu.tieba.ad.a.a.tg(this.iIB.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(int i, int i2) {
        if (this.mqE != null && this.mqE.video != null && this.mqE.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dyN().a(g.a(this.mqE.getAdFacadeData(), 32, this.mqE.getAdFacadeData().getPageNum(), i, this.mqL, com.baidu.tieba.ad.a.a.tg(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        if (this.mqE != null && this.mqE.video != null && this.mqE.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dyN().a(g.a(this.mqE.getAdFacadeData(), 33, this.mqE.getAdFacadeData().getPageNum(), i, this.mqL, com.baidu.tieba.ad.a.a.tg(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.mqE.getAdFacadeData(), 303, this.mqE.getAdFacadeData().getPageNum(), this.eDB ? 0 : 1, this.mqE.video.video_duration.intValue(), 0, -1);
            if (this.mqJ != null) {
                this.mqJ.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(boolean z) {
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
        private int cdn = -1;
        private Runnable jeY = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jeY);
                a.this.Av(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void Av(int i) {
            switch (i) {
                case 0:
                    this.cdn = Aw(i);
                    cEn();
                    return;
                case 1:
                    this.cdn = Aw(i);
                    this.mHandler.removeCallbacks(this.jeY);
                    return;
                case 2:
                    this.cdn = Ax(i);
                    return;
                case 3:
                    this.cdn = Ay(i);
                    cEn();
                    return;
                default:
                    this.cdn = Ax(i);
                    return;
            }
        }

        private void cEn() {
            this.mHandler.removeCallbacks(this.jeY);
            this.mHandler.postDelayed(this.jeY, IMConnection.RETRY_DELAY_TIMES);
        }

        private int Aw(int i) {
            if (i != this.cdn) {
                VideoMiddlePageAdView.this.mqC.setVisibility(8);
                VideoMiddlePageAdView.this.mqB.setVisibility(8);
                VideoMiddlePageAdView.this.wv(true);
                return i;
            }
            return this.cdn;
        }

        private int Ax(int i) {
            int i2 = this.cdn;
            if (i != this.cdn) {
                VideoMiddlePageAdView.this.mqC.setVisibility(0);
                VideoMiddlePageAdView.this.mqB.setVisibility(0);
                if (VideoMiddlePageAdView.this.iIB != null) {
                    VideoMiddlePageAdView.this.iIB.duk();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mqE.autoPlay) {
                    VideoMiddlePageAdView.this.wv(false);
                    return i;
                }
                return i;
            }
            return this.cdn;
        }

        private int Ay(int i) {
            if (i != this.cdn) {
                VideoMiddlePageAdView.this.mqC.setVisibility(0);
                VideoMiddlePageAdView.this.mqB.setVisibility(0);
                VideoMiddlePageAdView.this.wv(true);
                return i;
            }
            return this.cdn;
        }
    }
}
