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
/* loaded from: classes13.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a DA;
    public TextView Nm;
    private Animation aLM;
    private Animation aLN;
    private boolean cWz;
    private n elC;
    private View gOL;
    private View gOR;
    private c gOT;
    private VideoNetworkStateTipView gOW;
    private Animation.AnimationListener gPd;
    private Animation.AnimationListener gPe;
    public FrameLayout guA;
    public FrameLayout guB;
    public TextView guC;
    public HeadImageView guH;
    public com.baidu.tieba.play.c guO;
    private e jLA;
    private f jLB;
    private int jLC;
    private boolean jLD;
    private boolean jLE;
    private a jLF;
    private View jLr;
    private View jLs;
    private View jLt;
    public TextView jLu;
    private VideoMiddlePageAdCard jLv;
    private TextView jLw;
    private TextView jLx;
    private ViewGroup jLy;
    private d jLz;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jLD = false;
        this.jLE = true;
        this.gPd = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gOR != null) {
                    VideoMiddlePageAdView.this.gOR.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gOR != null) {
                    VideoMiddlePageAdView.this.gOR.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gPe = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gOR != null) {
                    VideoMiddlePageAdView.this.gOR.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gOR != null) {
                    VideoMiddlePageAdView.this.gOR.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jLr != null) {
                    VideoMiddlePageAdView.this.jLr.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jLD = false;
        this.jLE = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.guA = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.gOL = this.rootView.findViewById(R.id.card_container);
        this.guB = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.guO = new com.baidu.tieba.play.c(this.cVv, this.guB, false);
        this.guO.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.guO != null && VideoMiddlePageAdView.this.guO.getVideoView() != null) {
                    VideoMiddlePageAdView.this.jLC = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.guO.getVideoView().getDuration());
                }
            }
        });
        this.guO.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void mr(boolean z) {
                if (VideoMiddlePageAdView.this.jLF != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.jLF.uB(0);
                    } else {
                        VideoMiddlePageAdView.this.jLF.uB(1);
                    }
                }
            }
        });
        this.guO.iaO.setOnTouchListener(null);
        this.guC = (TextView) this.rootView.findViewById(R.id.title);
        this.guH = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.guH.setIsRound(true);
        this.guH.setDefaultBgResource(R.color.cp_bg_line_e);
        this.guH.setDefaultResource(R.drawable.icon_default_avatar100);
        this.guH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jLu = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Nm = (TextView) this.rootView.findViewById(R.id.user_name);
        this.elC = new n(this.cVv.getPageActivity());
        this.jLw = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.jLx = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.jLy = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.jLz = new d(this.cVv.getPageActivity(), this.jLy);
        this.jLz.page = 1;
        this.gOW = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.gOW.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.gOW.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.guO.rQ(false);
                VideoMiddlePageAdView.this.gOW.cSQ();
                if (VideoMiddlePageAdView.this.jLv != null && VideoMiddlePageAdView.this.jLv.video != null) {
                    VideoMiddlePageAdView.this.guO.eg(VideoMiddlePageAdView.this.jLv.video.video_url, "");
                }
            }
        });
        this.gOR = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.jLs = this.rootView.findViewById(R.id.user_container_foreground);
        this.jLt = this.rootView.findViewById(R.id.title_foreground);
        this.jLr = this.rootView.findViewById(R.id.operate_area_foreground);
        this.gOR.setOnClickListener(this);
        this.jLs.setOnClickListener(this);
        this.jLt.setOnClickListener(this);
        this.jLr.setOnClickListener(this);
        this.guB.setOnClickListener(this);
        this.guA.setOnClickListener(this);
        this.guO.Y(this);
        this.guC.setOnClickListener(this);
        this.guH.setOnClickListener(this);
        this.Nm.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cVv.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.guA.setLayoutParams(layoutParams);
        this.aLM = new AlphaAnimation(0.0f, 0.7f);
        this.aLM.setDuration(500L);
        this.aLM.setAnimationListener(this.gPe);
        this.aLN = new AlphaAnimation(0.7f, 0.0f);
        this.aLN.setDuration(500L);
        this.aLN.setAnimationListener(this.gPd);
        this.rootView.setOnClickListener(this);
        this.jLF = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccz() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cWz = this.jLv.autoPlay;
            this.jLD = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.jLC = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.guO.le()) {
                cA(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.guO.getCurrentPosition());
                this.jLE = true;
            }
            this.guO.stopPlay();
            this.guO.setIsNeedRecoveryVideoPlayer(true);
            this.guO.rR(true);
            this.guO.rN(false);
            this.guO.rS(true);
            this.guO.aj(false, true);
            this.guO.Av(i);
            this.guO.a(new c.InterfaceC0590c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void lc() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void ld() {
                }
            });
            this.guO.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bGA() {
                    if (VideoMiddlePageAdView.this.jLv != null && VideoMiddlePageAdView.this.jLv.video != null && VideoMiddlePageAdView.this.jLv.video.video_height.intValue() > VideoMiddlePageAdView.this.jLv.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.guO.aj(false, true);
                    } else {
                        VideoMiddlePageAdView.this.guO.aj(false, true);
                    }
                    if (VideoMiddlePageAdView.this.jLB != null) {
                        VideoMiddlePageAdView.this.jLB.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Bd(VideoMiddlePageAdView.this.cWz ? 0 : 1);
                    VideoMiddlePageAdView.this.jLD = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGB() {
                }
            });
            this.guO.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void lM(boolean z) {
                    VideoMiddlePageAdView.this.guO.eg(VideoMiddlePageAdView.this.jLv.video.video_url, "");
                    if (VideoMiddlePageAdView.this.jLB != null) {
                        VideoMiddlePageAdView.this.jLB.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Bd(1);
                    VideoMiddlePageAdView.this.jLD = false;
                }
            });
            this.guO.rJ(false);
            this.guO.getVideoView().setBusiness(this.elC);
            this.guO.cda();
            this.guO.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.guO.bQh();
                    if (VideoMiddlePageAdView.this.jLA != null) {
                        VideoMiddlePageAdView.this.jLA.cDR();
                    }
                    VideoMiddlePageAdView.this.Be(VideoMiddlePageAdView.this.cWz ? 0 : 1);
                    VideoMiddlePageAdView.this.jLE = true;
                }
            });
            this.guO.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Bf(VideoMiddlePageAdView.this.cWz ? 0 : 1);
                    return true;
                }
            });
            this.guO.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.guO.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.guO.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bGD() {
                    VideoMiddlePageAdView.this.cB(1, VideoMiddlePageAdView.this.guO.getCurrentPosition());
                }
            });
            this.guO.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cA(1, VideoMiddlePageAdView.this.guO.getCurrentPosition());
                    VideoMiddlePageAdView.this.jLE = true;
                }
            });
            this.guO.bQh();
            this.guO.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.gOW.cuv()) {
                    this.guO.rP(false);
                    this.gOW.cSP();
                    this.guO.rQ(true);
                    this.guO.ef(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.guO.rQ(false);
                    this.guO.rP(false);
                    this.gOW.hide();
                    this.guO.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.jLA != null) {
                    this.jLA.sk(true);
                }
                if (i == 0) {
                    this.gOR.setVisibility(8);
                    this.jLr.setVisibility(8);
                } else {
                    this.gOR.startAnimation(this.aLN);
                    this.jLr.startAnimation(this.aLN);
                }
                if (i == 0) {
                    this.jLF.uB(3);
                    return;
                } else {
                    this.jLF.uB(0);
                    return;
                }
            }
            this.gOW.hide();
            this.guO.rP(true);
            this.jLF.uB(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.gOR.startAnimation(this.aLN);
                this.jLr.startAnimation(this.aLN);
                return;
            }
            this.gOR.setVisibility(0);
            this.jLr.setVisibility(0);
        }
    }

    private boolean bLw() {
        try {
            int intValue = this.jLv.video.video_width.intValue();
            return intValue <= 0 || ((float) this.jLv.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.guC.setTextColor(this.cVv.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jLu.setTextColor(this.cVv.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jLw.setTextColor(this.cVv.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jLx.setTextColor(this.cVv.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.jLx, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bLx() {
        if (!bLw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.guA.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.guA.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jLv = videoMiddlePageAdCard;
        bLx();
        this.guC.setText(videoMiddlePageAdCard.threadTitle);
        this.Nm.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.guH.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.guH.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.guH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJm() || VideoMiddlePageAdView.this.jLv == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.jLv.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cVv.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.jLu.setText(videoMiddlePageAdCard.tagName);
        this.jLw.setText(videoMiddlePageAdCard.operateData.jJa);
        this.jLx.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.jLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = s.b(VideoMiddlePageAdView.this.cVv, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.jLv == null || VideoMiddlePageAdView.this.jLv.getAdFacadeData() == null || VideoMiddlePageAdView.this.jLv.getAdFacadeData().kK() == null) ? null : VideoMiddlePageAdView.this.jLv.getAdFacadeData().kK().cNk);
                if (VideoMiddlePageAdView.this.jLA != null) {
                    VideoMiddlePageAdView.this.jLA.sk(false);
                }
                if (VideoMiddlePageAdView.this.iaq != null) {
                    VideoMiddlePageAdView.this.iaq.b(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.jLv, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jLA = this.jLz.a(videoMiddlePageAdCard.tailFrame, this.jLA);
        if (this.jLA != null) {
            b(this.jLv.getAdFacadeData());
            this.jLA.setPageContext(this.cVv);
            this.jLA.setTimeoutListener(this);
            this.jLA.a(videoMiddlePageAdCard.tailFrame);
            this.jLA.c(this.jLv);
            this.jLA.cDS();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.DA = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.DA;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.gOT = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.jLB = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bq(View view) {
        this.DA.tg(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bGy();
        if (this.gOR != null) {
            this.gOR.clearAnimation();
        }
        if (this.jLr != null) {
            this.jLr.clearAnimation();
        }
    }

    public void bGx() {
        this.guO.stopPlay();
        if (this.guC != null) {
            this.guC.setVisibility(0);
        }
        if (this.jLF != null) {
            this.jLF.uB(2);
        }
        this.jLD = false;
        this.jLE = true;
    }

    public void bGy() {
        if (this.guO != null) {
            this.guO.destroy();
        }
        this.jLD = false;
        this.jLE = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gOR && this.gOR.getVisibility() == 0) {
            if (this.gOT != null) {
                this.gOT.uF(this.mPosition);
            }
        } else if (view == this.jLr && this.jLr.getVisibility() == 0) {
            if (this.gOT != null) {
                this.gOT.uF(this.mPosition);
            }
        } else if (view == this.jLt || view == this.jLs) {
            if (this.gOR.getVisibility() == 0) {
                if (this.gOT != null) {
                    this.gOT.uF(this.mPosition);
                    return;
                }
                return;
            }
            this.jLF.uB(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.jHQ = new WebVideoActivity.a();
            if (this.jLv.getAdFacadeData() != null) {
                WebVideoActivity.jHQ.jIa = this.jLv.getAdFacadeData().kK();
                WebVideoActivity.jHQ.mPage = "DETAIL";
                if (this.jLv.getAdFacadeData().Dm != null) {
                    WebVideoActivity.jHQ.mPageNum = this.jLv.getAdFacadeData().Dm.kG();
                }
            }
            if (com.baidu.tieba.a.aVs().aVt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cVv.getPageActivity(), "", this.jLv.getScheme(), true, true, true, this.jLv.video.video_url, this.jLv.video.thumbnail_url, 1.7777778f, this.jLC, this.jLv.getAdFacadeData().kK().cNk)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cVv.getPageActivity(), "", this.jLv.getScheme(), true, true, true, this.jLv.video.video_url, this.jLv.video.thumbnail_url, 1.7777778f, this.jLC)));
            }
            if (this.iaq != null) {
                this.iaq.b(0, null);
            }
            if (this.jLA != null) {
                this.jLA.sk(false);
            }
        } else {
            String str = null;
            if (this.jLv.getAdFacadeData() != null && this.jLv.getAdFacadeData().kK() != null) {
                str = this.jLv.getAdFacadeData().kK().cNk;
            }
            int b = s.b(this.cVv, this.jLv.getScheme(), str);
            if (this.iaq != null) {
                this.iaq.b(b, null);
            }
            if (this.jLA != null) {
                this.jLA.sk(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.ol(this.guO.getCurrentPosition()) < this.jLC && this.guO.getCurrentState() == 1) {
            cA(this.cWz ? 0 : 1, this.guO.getCurrentPosition());
        }
        bGx();
        this.jLA.sk(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.guO.pausePlay();
            cA(this.cWz ? 0 : 1, this.guO.getCurrentPosition());
            this.jLE = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.guO.le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd(int i) {
        if (this.jLv != null && this.jLv.video != null && this.jLv.getAdFacadeData() != null && this.jLE) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(this.jLv.getAdFacadeData(), 31, this.jLv.getAdFacadeData().getPageNum(), i, this.jLC, 0, -1));
            this.jLE = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be(int i) {
        if (this.jLv != null && this.jLv.video != null && this.jLv.getAdFacadeData() != null && !this.jLD) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(this.jLv.getAdFacadeData(), 34, this.jLv.getAdFacadeData().getPageNum(), i, this.jLC, this.jLC, -1));
            this.jLD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        if (this.jLv != null && this.jLv.video != null && this.jLv.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(this.jLv.getAdFacadeData(), 36, this.jLv.getAdFacadeData().getPageNum(), i, this.jLC, com.baidu.tieba.ad.a.a.ol(this.guO.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(int i, int i2) {
        if (this.jLv != null && this.jLv.video != null && this.jLv.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(this.jLv.getAdFacadeData(), 32, this.jLv.getAdFacadeData().getPageNum(), i, this.jLC, com.baidu.tieba.ad.a.a.ol(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        if (this.jLv != null && this.jLv.video != null && this.jLv.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(this.jLv.getAdFacadeData(), 33, this.jLv.getAdFacadeData().getPageNum(), i, this.jLC, com.baidu.tieba.ad.a.a.ol(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.jLv.getAdFacadeData(), 303, this.jLv.getAdFacadeData().getPageNum(), this.cWz ? 0 : 1, this.jLv.video.video_duration.intValue(), 0, -1);
            if (this.jLA != null) {
                this.jLA.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sg(boolean z) {
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
    /* loaded from: classes13.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable gPk = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gPk);
                a.this.uB(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void uB(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uC(i);
                    bLH();
                    return;
                case 1:
                    this.mCurrentState = uC(i);
                    this.mHandler.removeCallbacks(this.gPk);
                    return;
                case 2:
                    this.mCurrentState = uD(i);
                    return;
                case 3:
                    this.mCurrentState = uE(i);
                    bLH();
                    return;
                default:
                    this.mCurrentState = uD(i);
                    return;
            }
        }

        private void bLH() {
            this.mHandler.removeCallbacks(this.gPk);
            this.mHandler.postDelayed(this.gPk, 3000L);
        }

        private int uC(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jLt.setVisibility(8);
                VideoMiddlePageAdView.this.jLs.setVisibility(8);
                VideoMiddlePageAdView.this.sg(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uD(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jLt.setVisibility(0);
                VideoMiddlePageAdView.this.jLs.setVisibility(0);
                if (VideoMiddlePageAdView.this.guO != null) {
                    VideoMiddlePageAdView.this.guO.cyI();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.jLv.autoPlay) {
                    VideoMiddlePageAdView.this.sg(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int uE(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jLt.setVisibility(0);
                VideoMiddlePageAdView.this.jLs.setVisibility(0);
                VideoMiddlePageAdView.this.sg(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
