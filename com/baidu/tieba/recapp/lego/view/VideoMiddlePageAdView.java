package com.baidu.tieba.recapp.lego.view;

import android.os.Handler;
import android.os.Vibrator;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Dc;
    public TextView ME;
    private Animation aGA;
    private Animation aGz;
    private boolean cRY;
    private n egK;
    private View gIe;
    private View gIk;
    private c gIm;
    private VideoNetworkStateTipView gIp;
    private Animation.AnimationListener gIw;
    private Animation.AnimationListener gIx;
    public TextView goA;
    public HeadImageView goF;
    public com.baidu.tieba.play.c goM;
    public FrameLayout goy;
    public FrameLayout goz;
    private View jEY;
    private View jEZ;
    private View jFa;
    public TextView jFb;
    private VideoMiddlePageAdCard jFc;
    private TextView jFd;
    private TextView jFe;
    private ViewGroup jFf;
    private d jFg;
    private e jFh;
    private f jFi;
    private int jFj;
    private boolean jFk;
    private boolean jFl;
    private a jFm;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jFk = false;
        this.jFl = true;
        this.gIw = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gIk != null) {
                    VideoMiddlePageAdView.this.gIk.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jEY != null) {
                    VideoMiddlePageAdView.this.jEY.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gIk != null) {
                    VideoMiddlePageAdView.this.gIk.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jEY != null) {
                    VideoMiddlePageAdView.this.jEY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gIx = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gIk != null) {
                    VideoMiddlePageAdView.this.gIk.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jEY != null) {
                    VideoMiddlePageAdView.this.jEY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gIk != null) {
                    VideoMiddlePageAdView.this.gIk.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jEY != null) {
                    VideoMiddlePageAdView.this.jEY.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jFk = false;
        this.jFl = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.goy = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.gIe = this.rootView.findViewById(R.id.card_container);
        this.goz = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.goM = new com.baidu.tieba.play.c(this.cQU, this.goz, false);
        this.goM.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.goM != null && VideoMiddlePageAdView.this.goM.getVideoView() != null) {
                    VideoMiddlePageAdView.this.jFj = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.goM.getVideoView().getDuration());
                }
            }
        });
        this.goM.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void lY(boolean z) {
                if (VideoMiddlePageAdView.this.jFm != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.jFm.uj(0);
                    } else {
                        VideoMiddlePageAdView.this.jFm.uj(1);
                    }
                }
            }
        });
        this.goM.hTy.setOnTouchListener(null);
        this.goA = (TextView) this.rootView.findViewById(R.id.title);
        this.goF = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.goF.setIsRound(true);
        this.goF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.goF.setDefaultResource(R.drawable.icon_default_avatar100);
        this.goF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jFb = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ME = (TextView) this.rootView.findViewById(R.id.user_name);
        this.egK = new n(this.cQU.getPageActivity());
        this.jFd = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.jFe = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.jFf = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.jFg = new d(this.cQU.getPageActivity(), this.jFf);
        this.jFg.page = 1;
        this.gIp = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.gIp.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.gIp.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.goM.ru(false);
                VideoMiddlePageAdView.this.gIp.cPV();
                if (VideoMiddlePageAdView.this.jFc != null && VideoMiddlePageAdView.this.jFc.video != null) {
                    VideoMiddlePageAdView.this.goM.dX(VideoMiddlePageAdView.this.jFc.video.video_url, "");
                }
            }
        });
        this.gIk = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.jEZ = this.rootView.findViewById(R.id.user_container_foreground);
        this.jFa = this.rootView.findViewById(R.id.title_foreground);
        this.jEY = this.rootView.findViewById(R.id.operate_area_foreground);
        this.gIk.setOnClickListener(this);
        this.jEZ.setOnClickListener(this);
        this.jFa.setOnClickListener(this);
        this.jEY.setOnClickListener(this);
        this.goz.setOnClickListener(this);
        this.goy.setOnClickListener(this);
        this.goM.Z(this);
        this.goA.setOnClickListener(this);
        this.goF.setOnClickListener(this);
        this.ME.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cQU.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goy.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.goy.setLayoutParams(layoutParams);
        this.aGz = new AlphaAnimation(0.0f, 0.7f);
        this.aGz.setDuration(500L);
        this.aGz.setAnimationListener(this.gIx);
        this.aGA = new AlphaAnimation(0.7f, 0.0f);
        this.aGA.setDuration(500L);
        this.aGA.setAnimationListener(this.gIw);
        this.rootView.setOnClickListener(this);
        this.jFm = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bZt() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cRY = this.jFc.autoPlay;
            this.jFk = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.jFj = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.goM.kO()) {
                cz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.goM.getCurrentPosition());
                this.jFl = true;
            }
            this.goM.stopPlay();
            this.goM.setIsNeedRecoveryVideoPlayer(true);
            this.goM.rv(true);
            this.goM.rr(false);
            this.goM.rw(true);
            this.goM.ah(false, true);
            this.goM.zZ(i);
            this.goM.a(new c.InterfaceC0576c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kM() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kN() {
                }
            });
            this.goM.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bDH() {
                    if (VideoMiddlePageAdView.this.jFc != null && VideoMiddlePageAdView.this.jFc.video != null && VideoMiddlePageAdView.this.jFc.video.video_height.intValue() > VideoMiddlePageAdView.this.jFc.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.goM.ah(false, true);
                    } else {
                        VideoMiddlePageAdView.this.goM.ah(false, true);
                    }
                    if (VideoMiddlePageAdView.this.jFi != null) {
                        VideoMiddlePageAdView.this.jFi.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AH(VideoMiddlePageAdView.this.cRY ? 0 : 1);
                    VideoMiddlePageAdView.this.jFk = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bDI() {
                }
            });
            this.goM.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void lt(boolean z) {
                    VideoMiddlePageAdView.this.goM.dX(VideoMiddlePageAdView.this.jFc.video.video_url, "");
                    if (VideoMiddlePageAdView.this.jFi != null) {
                        VideoMiddlePageAdView.this.jFi.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AH(1);
                    VideoMiddlePageAdView.this.jFk = false;
                }
            });
            this.goM.rn(false);
            this.goM.getVideoView().setBusiness(this.egK);
            this.goM.bZU();
            this.goM.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.goM.bNb();
                    if (VideoMiddlePageAdView.this.jFh != null) {
                        VideoMiddlePageAdView.this.jFh.cAQ();
                    }
                    VideoMiddlePageAdView.this.AI(VideoMiddlePageAdView.this.cRY ? 0 : 1);
                    VideoMiddlePageAdView.this.jFl = true;
                }
            });
            this.goM.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.AJ(VideoMiddlePageAdView.this.cRY ? 0 : 1);
                    return true;
                }
            });
            this.goM.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.goM.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.goM.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bDK() {
                    VideoMiddlePageAdView.this.cA(1, VideoMiddlePageAdView.this.goM.getCurrentPosition());
                }
            });
            this.goM.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cz(1, VideoMiddlePageAdView.this.goM.getCurrentPosition());
                    VideoMiddlePageAdView.this.jFl = true;
                }
            });
            this.goM.bNb();
            this.goM.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.gIp.crv()) {
                    this.goM.rt(false);
                    this.gIp.cPU();
                    this.goM.ru(true);
                    this.goM.dW(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.goM.ru(false);
                    this.goM.rt(false);
                    this.gIp.hide();
                    this.goM.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.jFh != null) {
                    this.jFh.rP(true);
                }
                if (i == 0) {
                    this.gIk.setVisibility(8);
                    this.jEY.setVisibility(8);
                } else {
                    this.gIk.startAnimation(this.aGA);
                    this.jEY.startAnimation(this.aGA);
                }
                if (i == 0) {
                    this.jFm.uj(3);
                    return;
                } else {
                    this.jFm.uj(0);
                    return;
                }
            }
            this.gIp.hide();
            this.goM.rt(true);
            this.jFm.uj(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.gIk.startAnimation(this.aGA);
                this.jEY.startAnimation(this.aGA);
                return;
            }
            this.gIk.setVisibility(0);
            this.jEY.setVisibility(0);
        }
    }

    private boolean bIC() {
        try {
            int intValue = this.jFc.video.video_width.intValue();
            return intValue <= 0 || ((float) this.jFc.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.goA.setTextColor(this.cQU.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jFb.setTextColor(this.cQU.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jFd.setTextColor(this.cQU.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jFe.setTextColor(this.cQU.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.jFe, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bID() {
        if (!bIC()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goy.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.goy.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.goy.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.goy.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jFc = videoMiddlePageAdCard;
        bID();
        this.goA.setText(videoMiddlePageAdCard.threadTitle);
        this.ME.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.goF.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.goF.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.goF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aGy() || VideoMiddlePageAdView.this.jFc == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.jFc.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cQU.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.jFb.setText(videoMiddlePageAdCard.tagName);
        this.jFd.setText(videoMiddlePageAdCard.operateData.jCP);
        this.jFe.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.jFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int a2 = s.a(VideoMiddlePageAdView.this.cQU, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.jFc == null || VideoMiddlePageAdView.this.jFc.getAdFacadeData() == null || VideoMiddlePageAdView.this.jFc.getAdFacadeData().ku() == null) ? null : VideoMiddlePageAdView.this.jFc.getAdFacadeData().ku().cIG);
                if (VideoMiddlePageAdView.this.jFh != null) {
                    VideoMiddlePageAdView.this.jFh.rP(false);
                }
                if (VideoMiddlePageAdView.this.hTa != null) {
                    VideoMiddlePageAdView.this.hTa.b(a2, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.jFc, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jFh = this.jFg.a(videoMiddlePageAdCard.tailFrame, this.jFh);
        if (this.jFh != null) {
            b(this.jFc.getAdFacadeData());
            this.jFh.setPageContext(this.cQU);
            this.jFh.setTimeoutListener(this);
            this.jFh.a(videoMiddlePageAdCard.tailFrame);
            this.jFh.c(this.jFc);
            this.jFh.cAR();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Dc = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Dc;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.gIm = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.jFi = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bm(View view) {
        this.Dc.sT(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bDF();
        if (this.gIk != null) {
            this.gIk.clearAnimation();
        }
        if (this.jEY != null) {
            this.jEY.clearAnimation();
        }
    }

    public void bDE() {
        this.goM.stopPlay();
        if (this.goA != null) {
            this.goA.setVisibility(0);
        }
        if (this.jFm != null) {
            this.jFm.uj(2);
        }
        this.jFk = false;
        this.jFl = true;
    }

    public void bDF() {
        if (this.goM != null) {
            this.goM.destroy();
        }
        this.jFk = false;
        this.jFl = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIk && this.gIk.getVisibility() == 0) {
            if (this.gIm != null) {
                this.gIm.un(this.mPosition);
            }
        } else if (view == this.jEY && this.jEY.getVisibility() == 0) {
            if (this.gIm != null) {
                this.gIm.un(this.mPosition);
            }
        } else if (view == this.jFa || view == this.jEZ) {
            if (this.gIk.getVisibility() == 0) {
                if (this.gIm != null) {
                    this.gIm.un(this.mPosition);
                    return;
                }
                return;
            }
            this.jFm.uj(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.jBF = new WebVideoActivity.a();
            if (this.jFc.getAdFacadeData() != null) {
                WebVideoActivity.jBF.jBP = this.jFc.getAdFacadeData().ku();
                WebVideoActivity.jBF.mPage = "DETAIL";
                if (this.jFc.getAdFacadeData().CM != null) {
                    WebVideoActivity.jBF.mPageNum = this.jFc.getAdFacadeData().CM.kq();
                }
            }
            if (com.baidu.tieba.a.aSA().aSB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cQU.getPageActivity(), "", this.jFc.getScheme(), true, true, true, this.jFc.video.video_url, this.jFc.video.thumbnail_url, 1.7777778f, this.jFj, this.jFc.getAdFacadeData().ku().cIG)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cQU.getPageActivity(), "", this.jFc.getScheme(), true, true, true, this.jFc.video.video_url, this.jFc.video.thumbnail_url, 1.7777778f, this.jFj)));
            }
            if (this.hTa != null) {
                this.hTa.b(0, null);
            }
            if (this.jFh != null) {
                this.jFh.rP(false);
            }
        } else {
            String str = null;
            if (this.jFc.getAdFacadeData() != null && this.jFc.getAdFacadeData().ku() != null) {
                str = this.jFc.getAdFacadeData().ku().cIG;
            }
            int a2 = s.a(this.cQU, this.jFc.getScheme(), str);
            if (this.hTa != null) {
                this.hTa.b(a2, null);
            }
            if (this.jFh != null) {
                this.jFh.rP(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.nS(this.goM.getCurrentPosition()) < this.jFj && this.goM.getCurrentState() == 1) {
            cz(this.cRY ? 0 : 1, this.goM.getCurrentPosition());
        }
        bDE();
        this.jFh.rP(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.goM.pausePlay();
            cz(this.cRY ? 0 : 1, this.goM.getCurrentPosition());
            this.jFl = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.goM.kO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(int i) {
        if (this.jFc != null && this.jFc.video != null && this.jFc.getAdFacadeData() != null && this.jFl) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(this.jFc.getAdFacadeData(), 31, this.jFc.getAdFacadeData().getPageNum(), i, this.jFj, 0, -1));
            this.jFl = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(int i) {
        if (this.jFc != null && this.jFc.video != null && this.jFc.getAdFacadeData() != null && !this.jFk) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(this.jFc.getAdFacadeData(), 34, this.jFc.getAdFacadeData().getPageNum(), i, this.jFj, this.jFj, -1));
            this.jFk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(int i) {
        if (this.jFc != null && this.jFc.video != null && this.jFc.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(this.jFc.getAdFacadeData(), 36, this.jFc.getAdFacadeData().getPageNum(), i, this.jFj, com.baidu.tieba.ad.a.a.nS(this.goM.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i, int i2) {
        if (this.jFc != null && this.jFc.video != null && this.jFc.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(this.jFc.getAdFacadeData(), 32, this.jFc.getAdFacadeData().getPageNum(), i, this.jFj, com.baidu.tieba.ad.a.a.nS(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(int i, int i2) {
        if (this.jFc != null && this.jFc.video != null && this.jFc.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(this.jFc.getAdFacadeData(), 33, this.jFc.getAdFacadeData().getPageNum(), i, this.jFj, com.baidu.tieba.ad.a.a.nS(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.jFc.getAdFacadeData(), 303, this.jFc.getAdFacadeData().getPageNum(), this.cRY ? 0 : 1, this.jFc.video.video_duration.intValue(), 0, -1);
            if (this.jFh != null) {
                this.jFh.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(boolean z) {
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
    /* loaded from: classes10.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable gID = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gID);
                a.this.uj(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void uj(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uk(i);
                    bIN();
                    return;
                case 1:
                    this.mCurrentState = uk(i);
                    this.mHandler.removeCallbacks(this.gID);
                    return;
                case 2:
                    this.mCurrentState = ul(i);
                    return;
                case 3:
                    this.mCurrentState = um(i);
                    bIN();
                    return;
                default:
                    this.mCurrentState = ul(i);
                    return;
            }
        }

        private void bIN() {
            this.mHandler.removeCallbacks(this.gID);
            this.mHandler.postDelayed(this.gID, 3000L);
        }

        private int uk(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jFa.setVisibility(8);
                VideoMiddlePageAdView.this.jEZ.setVisibility(8);
                VideoMiddlePageAdView.this.rL(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int ul(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jFa.setVisibility(0);
                VideoMiddlePageAdView.this.jEZ.setVisibility(0);
                if (VideoMiddlePageAdView.this.goM != null) {
                    VideoMiddlePageAdView.this.goM.cvK();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.jFc.autoPlay) {
                    VideoMiddlePageAdView.this.rL(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int um(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jFa.setVisibility(0);
                VideoMiddlePageAdView.this.jEZ.setVisibility(0);
                VideoMiddlePageAdView.this.rL(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
