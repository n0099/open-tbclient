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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes20.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a XJ;
    public TextView ahr;
    private Animation but;
    private Animation buu;
    private boolean dXa;
    public FrameLayout hLC;
    public FrameLayout hLD;
    public TextView hLE;
    public HeadImageView hLJ;
    public c hLQ;
    private View ihE;
    private View ihK;
    private com.baidu.tieba.frs.videomiddlepage.c ihM;
    private VideoNetworkStateTipView ihP;
    private Animation.AnimationListener ihW;
    private Animation.AnimationListener ihX;
    private View lpg;
    private View lph;
    private View lpi;
    public TextView lpj;
    private VideoMiddlePageAdCard lpk;
    private TextView lpl;
    private TextView lpm;
    private ViewGroup lpn;
    private d lpo;
    private e lpp;
    private f lpq;
    private int lpr;
    private boolean lps;
    private boolean lpt;
    private a lpu;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lps = false;
        this.lpt = true;
        this.ihW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ihK != null) {
                    VideoMiddlePageAdView.this.ihK.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lpg != null) {
                    VideoMiddlePageAdView.this.lpg.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ihK != null) {
                    VideoMiddlePageAdView.this.ihK.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lpg != null) {
                    VideoMiddlePageAdView.this.lpg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ihX = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ihK != null) {
                    VideoMiddlePageAdView.this.ihK.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lpg != null) {
                    VideoMiddlePageAdView.this.lpg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ihK != null) {
                    VideoMiddlePageAdView.this.ihK.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lpg != null) {
                    VideoMiddlePageAdView.this.lpg.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lps = false;
        this.lpt = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hLC = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.ihE = this.rootView.findViewById(R.id.card_container);
        this.hLD = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hLQ = new c(this.dVN, this.hLD, false);
        this.hLQ.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.hLQ != null && VideoMiddlePageAdView.this.hLQ.getVideoView() != null) {
                    VideoMiddlePageAdView.this.lpr = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hLQ.getVideoView().getDuration());
                }
            }
        });
        this.hLQ.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void oH(boolean z) {
                if (VideoMiddlePageAdView.this.lpu != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.lpu.wE(0);
                    } else {
                        VideoMiddlePageAdView.this.lpu.wE(1);
                    }
                }
            }
        });
        this.hLQ.jAm.setOnTouchListener(null);
        this.hLE = (TextView) this.rootView.findViewById(R.id.title);
        this.hLJ = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hLJ.setIsRound(true);
        this.hLJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hLJ.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hLJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.lpj = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ahr = (TextView) this.rootView.findViewById(R.id.user_name);
        this.lpl = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.lpm = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.lpn = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.lpo = new d(this.dVN.getPageActivity(), this.lpn);
        this.lpo.page = 1;
        this.ihP = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.ihP.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.ihP.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hLQ.um(false);
                VideoMiddlePageAdView.this.ihP.dsS();
                if (VideoMiddlePageAdView.this.lpk != null && VideoMiddlePageAdView.this.lpk.video != null) {
                    VideoMiddlePageAdView.this.hLQ.ff(VideoMiddlePageAdView.this.lpk.video.video_url, "");
                }
            }
        });
        this.ihK = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.lph = this.rootView.findViewById(R.id.user_container_foreground);
        this.lpi = this.rootView.findViewById(R.id.title_foreground);
        this.lpg = this.rootView.findViewById(R.id.operate_area_foreground);
        this.ihK.setOnClickListener(this);
        this.lph.setOnClickListener(this);
        this.lpi.setOnClickListener(this);
        this.lpg.setOnClickListener(this);
        this.hLD.setOnClickListener(this);
        this.hLC.setOnClickListener(this);
        this.hLQ.aa(this);
        this.hLE.setOnClickListener(this);
        this.hLJ.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.dVN.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hLC.setLayoutParams(layoutParams);
        this.but = new AlphaAnimation(0.0f, 0.7f);
        this.but.setDuration(500L);
        this.but.setAnimationListener(this.ihX);
        this.buu = new AlphaAnimation(0.7f, 0.0f);
        this.buu.setDuration(500L);
        this.buu.setAnimationListener(this.ihW);
        this.rootView.setOnClickListener(this);
        this.lpu = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dXa = this.lpk.autoPlay;
            this.lps = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.lpr = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hLQ.qg()) {
                cT(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hLQ.getCurrentPosition());
                this.lpt = true;
            }
            this.hLQ.stopPlay();
            this.hLQ.un(true);
            this.hLQ.uj(false);
            this.hLQ.uo(true);
            this.hLQ.ap(false, true);
            this.hLQ.Dj(i);
            this.hLQ.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                }
            });
            this.hLQ.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cei() {
                    if (VideoMiddlePageAdView.this.lpk != null && VideoMiddlePageAdView.this.lpk.video != null && VideoMiddlePageAdView.this.lpk.video.video_height.intValue() > VideoMiddlePageAdView.this.lpk.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hLQ.ap(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hLQ.ap(false, true);
                    }
                    if (VideoMiddlePageAdView.this.lpq != null) {
                        VideoMiddlePageAdView.this.lpq.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.DN(VideoMiddlePageAdView.this.dXa ? 0 : 1);
                    VideoMiddlePageAdView.this.lps = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cej() {
                }
            });
            this.hLQ.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void ob(boolean z) {
                    VideoMiddlePageAdView.this.hLQ.ff(VideoMiddlePageAdView.this.lpk.video.video_url, "");
                    if (VideoMiddlePageAdView.this.lpq != null) {
                        VideoMiddlePageAdView.this.lpq.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.DN(1);
                    VideoMiddlePageAdView.this.lps = false;
                }
            });
            this.hLQ.uf(false);
            this.hLQ.cBY();
            this.hLQ.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.hLQ.coB();
                    if (VideoMiddlePageAdView.this.lpp != null) {
                        VideoMiddlePageAdView.this.lpp.ddf();
                    }
                    VideoMiddlePageAdView.this.DO(VideoMiddlePageAdView.this.dXa ? 0 : 1);
                    VideoMiddlePageAdView.this.lpt = true;
                }
            });
            this.hLQ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.DP(VideoMiddlePageAdView.this.dXa ? 0 : 1);
                    return true;
                }
            });
            this.hLQ.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hLQ.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hLQ.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cel() {
                    VideoMiddlePageAdView.this.cU(1, VideoMiddlePageAdView.this.hLQ.getCurrentPosition());
                }
            });
            this.hLQ.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cT(1, VideoMiddlePageAdView.this.hLQ.getCurrentPosition());
                    VideoMiddlePageAdView.this.lpt = true;
                }
            });
            this.hLQ.coB();
            this.hLQ.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.ihP.cUv()) {
                    this.hLQ.ul(false);
                    this.ihP.dsR();
                    this.hLQ.um(true);
                    this.hLQ.fe(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hLQ.um(false);
                    this.hLQ.ul(false);
                    this.ihP.hide();
                    this.hLQ.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.lpp != null) {
                    this.lpp.uC(true);
                }
                if (i == 0) {
                    this.ihK.setVisibility(8);
                    this.lpg.setVisibility(8);
                } else {
                    this.ihK.startAnimation(this.buu);
                    this.lpg.startAnimation(this.buu);
                }
                if (i == 0) {
                    this.lpu.wE(3);
                    return;
                } else {
                    this.lpu.wE(0);
                    return;
                }
            }
            this.ihP.hide();
            this.hLQ.ul(true);
            this.lpu.wE(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.ihK.startAnimation(this.buu);
                this.lpg.startAnimation(this.buu);
                return;
            }
            this.ihK.setVisibility(0);
            this.lpg.setVisibility(0);
        }
    }

    private boolean cjA() {
        try {
            int intValue = this.lpk.video.video_width.intValue();
            return intValue <= 0 || ((float) this.lpk.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hLE.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lpj.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lpl.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lpm.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        ao.setBackgroundResource(this.lpm, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cjB() {
        if (!cjA()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hLC.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hLC.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lpk = videoMiddlePageAdCard;
        cjB();
        this.hLE.setText(videoMiddlePageAdCard.threadTitle);
        this.ahr.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hLJ.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hLJ.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hLJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bdQ() || VideoMiddlePageAdView.this.lpk == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.lpk.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.dVN.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.lpj.setText(videoMiddlePageAdCard.tagName);
        this.lpl.setText(videoMiddlePageAdCard.operateData.lnb);
        this.lpm.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.lpm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.dVN, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.lpk == null || VideoMiddlePageAdView.this.lpk.getAdFacadeData() == null || VideoMiddlePageAdView.this.lpk.getAdFacadeData().pM() == null) ? null : VideoMiddlePageAdView.this.lpk.getAdFacadeData().pM().dMW);
                if (VideoMiddlePageAdView.this.lpp != null) {
                    VideoMiddlePageAdView.this.lpp.uC(false);
                }
                if (VideoMiddlePageAdView.this.jzO != null) {
                    VideoMiddlePageAdView.this.jzO.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.lpk, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lpp = this.lpo.a(videoMiddlePageAdCard.tailFrame, this.lpp);
        if (this.lpp != null) {
            b(this.lpk.getAdFacadeData());
            this.lpp.setPageContext(this.dVN);
            this.lpp.setTimeoutListener(this);
            this.lpp.a(videoMiddlePageAdCard.tailFrame);
            this.lpp.c(this.lpk);
            this.lpp.ddg();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.XJ = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.XJ;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.ihM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.lpq = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bB(View view) {
        this.XJ.vi(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        ceg();
        if (this.ihK != null) {
            this.ihK.clearAnimation();
        }
        if (this.lpg != null) {
            this.lpg.clearAnimation();
        }
    }

    public void cef() {
        this.hLQ.stopPlay();
        if (this.hLE != null) {
            this.hLE.setVisibility(0);
        }
        if (this.lpu != null) {
            this.lpu.wE(2);
        }
        this.lps = false;
        this.lpt = true;
    }

    public void ceg() {
        if (this.hLQ != null) {
            this.hLQ.destroy();
        }
        this.lps = false;
        this.lpt = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ihK && this.ihK.getVisibility() == 0) {
            if (this.ihM != null) {
                this.ihM.wI(this.mPosition);
            }
        } else if (view == this.lpg && this.lpg.getVisibility() == 0) {
            if (this.ihM != null) {
                this.ihM.wI(this.mPosition);
            }
        } else if (view == this.lpi || view == this.lph) {
            if (this.ihK.getVisibility() == 0) {
                if (this.ihM != null) {
                    this.ihM.wI(this.mPosition);
                    return;
                }
                return;
            }
            this.lpu.wE(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.llO = new WebVideoActivity.a();
            if (this.lpk.getAdFacadeData() != null) {
                WebVideoActivity.llO.lma = this.lpk.getAdFacadeData().pM();
                WebVideoActivity.llO.mPage = "DETAIL";
                if (this.lpk.getAdFacadeData().Xv != null) {
                    WebVideoActivity.llO.mPageNum = this.lpk.getAdFacadeData().Xv.pI();
                }
            }
            if (com.baidu.tieba.a.bqh().bqi() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.dVN.getPageActivity(), "", this.lpk.getScheme(), true, true, true, this.lpk.video.video_url, this.lpk.video.thumbnail_url, 1.7777778f, this.lpr, this.lpk.getAdFacadeData().pM().dMW)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.dVN.getPageActivity(), "", this.lpk.getScheme(), true, true, true, this.lpk.video.video_url, this.lpk.video.thumbnail_url, 1.7777778f, this.lpr)));
            }
            if (this.jzO != null) {
                this.jzO.d(0, null);
            }
            if (this.lpp != null) {
                this.lpp.uC(false);
            }
        } else {
            String str = null;
            if (this.lpk.getAdFacadeData() != null && this.lpk.getAdFacadeData().pM() != null) {
                str = this.lpk.getAdFacadeData().pM().dMW;
            }
            int c = s.c(this.dVN, this.lpk.getScheme(), str);
            if (this.jzO != null) {
                this.jzO.d(c, null);
            }
            if (this.lpp != null) {
                this.lpp.uC(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.pT(this.hLQ.getCurrentPosition()) < this.lpr && this.hLQ.qg()) {
            cT(this.dXa ? 0 : 1, this.hLQ.getCurrentPosition());
        }
        cef();
        this.lpp.uC(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void azN() {
        if (isPlaying()) {
            this.hLQ.azN();
            cT(this.dXa ? 0 : 1, this.hLQ.getCurrentPosition());
            this.lpt = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hLQ.qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN(int i) {
        if (this.lpk != null && this.lpk.video != null && this.lpk.getAdFacadeData() != null && this.lpt) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpk.getAdFacadeData(), 31, this.lpk.getAdFacadeData().getPageNum(), i, this.lpr, 0, -1));
            this.lpt = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(int i) {
        if (this.lpk != null && this.lpk.video != null && this.lpk.getAdFacadeData() != null && !this.lps) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpk.getAdFacadeData(), 34, this.lpk.getAdFacadeData().getPageNum(), i, this.lpr, this.lpr, -1));
            this.lps = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP(int i) {
        if (this.lpk != null && this.lpk.video != null && this.lpk.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpk.getAdFacadeData(), 36, this.lpk.getAdFacadeData().getPageNum(), i, this.lpr, com.baidu.tieba.ad.a.a.pT(this.hLQ.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        if (this.lpk != null && this.lpk.video != null && this.lpk.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpk.getAdFacadeData(), 32, this.lpk.getAdFacadeData().getPageNum(), i, this.lpr, com.baidu.tieba.ad.a.a.pT(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(int i, int i2) {
        if (this.lpk != null && this.lpk.video != null && this.lpk.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpk.getAdFacadeData(), 33, this.lpk.getAdFacadeData().getPageNum(), i, this.lpr, com.baidu.tieba.ad.a.a.pT(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.lpk.getAdFacadeData(), 303, this.lpk.getAdFacadeData().getPageNum(), this.dXa ? 0 : 1, this.lpk.video.video_duration.intValue(), 0, -1);
            if (this.lpp != null) {
                this.lpp.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(boolean z) {
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
    /* loaded from: classes20.dex */
    public class a {
        private int bGB = -1;
        private Runnable iid = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.iid);
                a.this.wE(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void wE(int i) {
            switch (i) {
                case 0:
                    this.bGB = wF(i);
                    cjL();
                    return;
                case 1:
                    this.bGB = wF(i);
                    this.mHandler.removeCallbacks(this.iid);
                    return;
                case 2:
                    this.bGB = wG(i);
                    return;
                case 3:
                    this.bGB = wH(i);
                    cjL();
                    return;
                default:
                    this.bGB = wG(i);
                    return;
            }
        }

        private void cjL() {
            this.mHandler.removeCallbacks(this.iid);
            this.mHandler.postDelayed(this.iid, 3000L);
        }

        private int wF(int i) {
            if (i != this.bGB) {
                VideoMiddlePageAdView.this.lpi.setVisibility(8);
                VideoMiddlePageAdView.this.lph.setVisibility(8);
                VideoMiddlePageAdView.this.uA(true);
                return i;
            }
            return this.bGB;
        }

        private int wG(int i) {
            int i2 = this.bGB;
            if (i != this.bGB) {
                VideoMiddlePageAdView.this.lpi.setVisibility(0);
                VideoMiddlePageAdView.this.lph.setVisibility(0);
                if (VideoMiddlePageAdView.this.hLQ != null) {
                    VideoMiddlePageAdView.this.hLQ.cYG();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.lpk.autoPlay) {
                    VideoMiddlePageAdView.this.uA(false);
                    return i;
                }
                return i;
            }
            return this.bGB;
        }

        private int wH(int i) {
            if (i != this.bGB) {
                VideoMiddlePageAdView.this.lpi.setVisibility(0);
                VideoMiddlePageAdView.this.lph.setVisibility(0);
                VideoMiddlePageAdView.this.uA(true);
                return i;
            }
            return this.bGB;
        }
    }
}
