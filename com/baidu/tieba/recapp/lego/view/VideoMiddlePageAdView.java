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
    public FrameLayout hLE;
    public FrameLayout hLF;
    public TextView hLG;
    public HeadImageView hLL;
    public c hLS;
    private View ihG;
    private View ihM;
    private com.baidu.tieba.frs.videomiddlepage.c ihO;
    private VideoNetworkStateTipView ihR;
    private Animation.AnimationListener ihY;
    private Animation.AnimationListener ihZ;
    private View lpi;
    private View lpj;
    private View lpk;
    public TextView lpl;
    private VideoMiddlePageAdCard lpm;
    private TextView lpn;
    private TextView lpo;
    private ViewGroup lpp;
    private d lpq;
    private e lpr;
    private f lps;
    private int lpt;
    private boolean lpu;
    private boolean lpv;
    private a lpw;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lpu = false;
        this.lpv = true;
        this.ihY = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ihM != null) {
                    VideoMiddlePageAdView.this.ihM.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lpi != null) {
                    VideoMiddlePageAdView.this.lpi.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ihM != null) {
                    VideoMiddlePageAdView.this.ihM.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lpi != null) {
                    VideoMiddlePageAdView.this.lpi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ihZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ihM != null) {
                    VideoMiddlePageAdView.this.ihM.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lpi != null) {
                    VideoMiddlePageAdView.this.lpi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ihM != null) {
                    VideoMiddlePageAdView.this.ihM.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lpi != null) {
                    VideoMiddlePageAdView.this.lpi.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lpu = false;
        this.lpv = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hLE = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.ihG = this.rootView.findViewById(R.id.card_container);
        this.hLF = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hLS = new c(this.dVN, this.hLF, false);
        this.hLS.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.hLS != null && VideoMiddlePageAdView.this.hLS.getVideoView() != null) {
                    VideoMiddlePageAdView.this.lpt = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hLS.getVideoView().getDuration());
                }
            }
        });
        this.hLS.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void oH(boolean z) {
                if (VideoMiddlePageAdView.this.lpw != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.lpw.wE(0);
                    } else {
                        VideoMiddlePageAdView.this.lpw.wE(1);
                    }
                }
            }
        });
        this.hLS.jAo.setOnTouchListener(null);
        this.hLG = (TextView) this.rootView.findViewById(R.id.title);
        this.hLL = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hLL.setIsRound(true);
        this.hLL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hLL.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hLL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.lpl = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ahr = (TextView) this.rootView.findViewById(R.id.user_name);
        this.lpn = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.lpo = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.lpp = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.lpq = new d(this.dVN.getPageActivity(), this.lpp);
        this.lpq.page = 1;
        this.ihR = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.ihR.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.ihR.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hLS.um(false);
                VideoMiddlePageAdView.this.ihR.dsT();
                if (VideoMiddlePageAdView.this.lpm != null && VideoMiddlePageAdView.this.lpm.video != null) {
                    VideoMiddlePageAdView.this.hLS.ff(VideoMiddlePageAdView.this.lpm.video.video_url, "");
                }
            }
        });
        this.ihM = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.lpj = this.rootView.findViewById(R.id.user_container_foreground);
        this.lpk = this.rootView.findViewById(R.id.title_foreground);
        this.lpi = this.rootView.findViewById(R.id.operate_area_foreground);
        this.ihM.setOnClickListener(this);
        this.lpj.setOnClickListener(this);
        this.lpk.setOnClickListener(this);
        this.lpi.setOnClickListener(this);
        this.hLF.setOnClickListener(this);
        this.hLE.setOnClickListener(this);
        this.hLS.aa(this);
        this.hLG.setOnClickListener(this);
        this.hLL.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.dVN.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLE.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hLE.setLayoutParams(layoutParams);
        this.but = new AlphaAnimation(0.0f, 0.7f);
        this.but.setDuration(500L);
        this.but.setAnimationListener(this.ihZ);
        this.buu = new AlphaAnimation(0.7f, 0.0f);
        this.buu.setDuration(500L);
        this.buu.setAnimationListener(this.ihY);
        this.rootView.setOnClickListener(this);
        this.lpw = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dXa = this.lpm.autoPlay;
            this.lpu = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.lpt = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hLS.qg()) {
                cT(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hLS.getCurrentPosition());
                this.lpv = true;
            }
            this.hLS.stopPlay();
            this.hLS.un(true);
            this.hLS.uj(false);
            this.hLS.uo(true);
            this.hLS.ap(false, true);
            this.hLS.Dj(i);
            this.hLS.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                }
            });
            this.hLS.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cei() {
                    if (VideoMiddlePageAdView.this.lpm != null && VideoMiddlePageAdView.this.lpm.video != null && VideoMiddlePageAdView.this.lpm.video.video_height.intValue() > VideoMiddlePageAdView.this.lpm.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hLS.ap(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hLS.ap(false, true);
                    }
                    if (VideoMiddlePageAdView.this.lps != null) {
                        VideoMiddlePageAdView.this.lps.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.DN(VideoMiddlePageAdView.this.dXa ? 0 : 1);
                    VideoMiddlePageAdView.this.lpu = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cej() {
                }
            });
            this.hLS.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void ob(boolean z) {
                    VideoMiddlePageAdView.this.hLS.ff(VideoMiddlePageAdView.this.lpm.video.video_url, "");
                    if (VideoMiddlePageAdView.this.lps != null) {
                        VideoMiddlePageAdView.this.lps.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.DN(1);
                    VideoMiddlePageAdView.this.lpu = false;
                }
            });
            this.hLS.uf(false);
            this.hLS.cBY();
            this.hLS.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.hLS.coB();
                    if (VideoMiddlePageAdView.this.lpr != null) {
                        VideoMiddlePageAdView.this.lpr.ddf();
                    }
                    VideoMiddlePageAdView.this.DO(VideoMiddlePageAdView.this.dXa ? 0 : 1);
                    VideoMiddlePageAdView.this.lpv = true;
                }
            });
            this.hLS.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.DP(VideoMiddlePageAdView.this.dXa ? 0 : 1);
                    return true;
                }
            });
            this.hLS.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hLS.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hLS.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cel() {
                    VideoMiddlePageAdView.this.cU(1, VideoMiddlePageAdView.this.hLS.getCurrentPosition());
                }
            });
            this.hLS.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cT(1, VideoMiddlePageAdView.this.hLS.getCurrentPosition());
                    VideoMiddlePageAdView.this.lpv = true;
                }
            });
            this.hLS.coB();
            this.hLS.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.ihR.cUv()) {
                    this.hLS.ul(false);
                    this.ihR.dsS();
                    this.hLS.um(true);
                    this.hLS.fe(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hLS.um(false);
                    this.hLS.ul(false);
                    this.ihR.hide();
                    this.hLS.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.lpr != null) {
                    this.lpr.uC(true);
                }
                if (i == 0) {
                    this.ihM.setVisibility(8);
                    this.lpi.setVisibility(8);
                } else {
                    this.ihM.startAnimation(this.buu);
                    this.lpi.startAnimation(this.buu);
                }
                if (i == 0) {
                    this.lpw.wE(3);
                    return;
                } else {
                    this.lpw.wE(0);
                    return;
                }
            }
            this.ihR.hide();
            this.hLS.ul(true);
            this.lpw.wE(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.ihM.startAnimation(this.buu);
                this.lpi.startAnimation(this.buu);
                return;
            }
            this.ihM.setVisibility(0);
            this.lpi.setVisibility(0);
        }
    }

    private boolean cjA() {
        try {
            int intValue = this.lpm.video.video_width.intValue();
            return intValue <= 0 || ((float) this.lpm.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hLG.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lpl.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lpn.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lpo.setTextColor(this.dVN.getResources().getColor(R.color.cp_cont_i_alpha70));
        ao.setBackgroundResource(this.lpo, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cjB() {
        if (!cjA()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLE.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hLE.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hLE.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hLE.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lpm = videoMiddlePageAdCard;
        cjB();
        this.hLG.setText(videoMiddlePageAdCard.threadTitle);
        this.ahr.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hLL.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hLL.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hLL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bdQ() || VideoMiddlePageAdView.this.lpm == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.lpm.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.dVN.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.lpl.setText(videoMiddlePageAdCard.tagName);
        this.lpn.setText(videoMiddlePageAdCard.operateData.lnd);
        this.lpo.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.lpo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.dVN, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.lpm == null || VideoMiddlePageAdView.this.lpm.getAdFacadeData() == null || VideoMiddlePageAdView.this.lpm.getAdFacadeData().pM() == null) ? null : VideoMiddlePageAdView.this.lpm.getAdFacadeData().pM().dMW);
                if (VideoMiddlePageAdView.this.lpr != null) {
                    VideoMiddlePageAdView.this.lpr.uC(false);
                }
                if (VideoMiddlePageAdView.this.jzQ != null) {
                    VideoMiddlePageAdView.this.jzQ.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.lpm, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lpr = this.lpq.a(videoMiddlePageAdCard.tailFrame, this.lpr);
        if (this.lpr != null) {
            b(this.lpm.getAdFacadeData());
            this.lpr.setPageContext(this.dVN);
            this.lpr.setTimeoutListener(this);
            this.lpr.a(videoMiddlePageAdCard.tailFrame);
            this.lpr.c(this.lpm);
            this.lpr.ddg();
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
        this.ihO = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.lps = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bB(View view) {
        this.XJ.vi(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        ceg();
        if (this.ihM != null) {
            this.ihM.clearAnimation();
        }
        if (this.lpi != null) {
            this.lpi.clearAnimation();
        }
    }

    public void cef() {
        this.hLS.stopPlay();
        if (this.hLG != null) {
            this.hLG.setVisibility(0);
        }
        if (this.lpw != null) {
            this.lpw.wE(2);
        }
        this.lpu = false;
        this.lpv = true;
    }

    public void ceg() {
        if (this.hLS != null) {
            this.hLS.destroy();
        }
        this.lpu = false;
        this.lpv = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ihM && this.ihM.getVisibility() == 0) {
            if (this.ihO != null) {
                this.ihO.wI(this.mPosition);
            }
        } else if (view == this.lpi && this.lpi.getVisibility() == 0) {
            if (this.ihO != null) {
                this.ihO.wI(this.mPosition);
            }
        } else if (view == this.lpk || view == this.lpj) {
            if (this.ihM.getVisibility() == 0) {
                if (this.ihO != null) {
                    this.ihO.wI(this.mPosition);
                    return;
                }
                return;
            }
            this.lpw.wE(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.llQ = new WebVideoActivity.a();
            if (this.lpm.getAdFacadeData() != null) {
                WebVideoActivity.llQ.lmc = this.lpm.getAdFacadeData().pM();
                WebVideoActivity.llQ.mPage = "DETAIL";
                if (this.lpm.getAdFacadeData().Xv != null) {
                    WebVideoActivity.llQ.mPageNum = this.lpm.getAdFacadeData().Xv.pI();
                }
            }
            if (com.baidu.tieba.a.bqh().bqi() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.dVN.getPageActivity(), "", this.lpm.getScheme(), true, true, true, this.lpm.video.video_url, this.lpm.video.thumbnail_url, 1.7777778f, this.lpt, this.lpm.getAdFacadeData().pM().dMW)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.dVN.getPageActivity(), "", this.lpm.getScheme(), true, true, true, this.lpm.video.video_url, this.lpm.video.thumbnail_url, 1.7777778f, this.lpt)));
            }
            if (this.jzQ != null) {
                this.jzQ.d(0, null);
            }
            if (this.lpr != null) {
                this.lpr.uC(false);
            }
        } else {
            String str = null;
            if (this.lpm.getAdFacadeData() != null && this.lpm.getAdFacadeData().pM() != null) {
                str = this.lpm.getAdFacadeData().pM().dMW;
            }
            int c = s.c(this.dVN, this.lpm.getScheme(), str);
            if (this.jzQ != null) {
                this.jzQ.d(c, null);
            }
            if (this.lpr != null) {
                this.lpr.uC(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.pT(this.hLS.getCurrentPosition()) < this.lpt && this.hLS.qg()) {
            cT(this.dXa ? 0 : 1, this.hLS.getCurrentPosition());
        }
        cef();
        this.lpr.uC(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void azN() {
        if (isPlaying()) {
            this.hLS.azN();
            cT(this.dXa ? 0 : 1, this.hLS.getCurrentPosition());
            this.lpv = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hLS.qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN(int i) {
        if (this.lpm != null && this.lpm.video != null && this.lpm.getAdFacadeData() != null && this.lpv) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpm.getAdFacadeData(), 31, this.lpm.getAdFacadeData().getPageNum(), i, this.lpt, 0, -1));
            this.lpv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(int i) {
        if (this.lpm != null && this.lpm.video != null && this.lpm.getAdFacadeData() != null && !this.lpu) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpm.getAdFacadeData(), 34, this.lpm.getAdFacadeData().getPageNum(), i, this.lpt, this.lpt, -1));
            this.lpu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP(int i) {
        if (this.lpm != null && this.lpm.video != null && this.lpm.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpm.getAdFacadeData(), 36, this.lpm.getAdFacadeData().getPageNum(), i, this.lpt, com.baidu.tieba.ad.a.a.pT(this.hLS.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        if (this.lpm != null && this.lpm.video != null && this.lpm.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpm.getAdFacadeData(), 32, this.lpm.getAdFacadeData().getPageNum(), i, this.lpt, com.baidu.tieba.ad.a.a.pT(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(int i, int i2) {
        if (this.lpm != null && this.lpm.video != null && this.lpm.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lpm.getAdFacadeData(), 33, this.lpm.getAdFacadeData().getPageNum(), i, this.lpt, com.baidu.tieba.ad.a.a.pT(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.lpm.getAdFacadeData(), 303, this.lpm.getAdFacadeData().getPageNum(), this.dXa ? 0 : 1, this.lpm.video.video_duration.intValue(), 0, -1);
            if (this.lpr != null) {
                this.lpr.e(a2);
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
        private Runnable iif = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.iif);
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
                    this.mHandler.removeCallbacks(this.iif);
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
            this.mHandler.removeCallbacks(this.iif);
            this.mHandler.postDelayed(this.iif, 3000L);
        }

        private int wF(int i) {
            if (i != this.bGB) {
                VideoMiddlePageAdView.this.lpk.setVisibility(8);
                VideoMiddlePageAdView.this.lpj.setVisibility(8);
                VideoMiddlePageAdView.this.uA(true);
                return i;
            }
            return this.bGB;
        }

        private int wG(int i) {
            int i2 = this.bGB;
            if (i != this.bGB) {
                VideoMiddlePageAdView.this.lpk.setVisibility(0);
                VideoMiddlePageAdView.this.lpj.setVisibility(0);
                if (VideoMiddlePageAdView.this.hLS != null) {
                    VideoMiddlePageAdView.this.hLS.cYG();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.lpm.autoPlay) {
                    VideoMiddlePageAdView.this.uA(false);
                    return i;
                }
                return i;
            }
            return this.bGB;
        }

        private int wH(int i) {
            if (i != this.bGB) {
                VideoMiddlePageAdView.this.lpk.setVisibility(0);
                VideoMiddlePageAdView.this.lpj.setVisibility(0);
                VideoMiddlePageAdView.this.uA(true);
                return i;
            }
            return this.bGB;
        }
    }
}
