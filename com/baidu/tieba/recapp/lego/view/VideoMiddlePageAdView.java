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
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a AY;
    public TextView HE;
    private Animation azf;
    private Animation azg;
    private boolean cgq;
    private n dwz;
    public FrameLayout fAT;
    public FrameLayout fAU;
    public TextView fAV;
    public HeadImageView fBa;
    public c fBh;
    private View fUC;
    private com.baidu.tieba.frs.videomiddlepage.c fUE;
    private VideoNetworkStateTipView fUH;
    private Animation.AnimationListener fUO;
    private Animation.AnimationListener fUP;
    private View fUw;
    private View iLA;
    private View iLB;
    public TextView iLC;
    private VideoMiddlePageAdCard iLD;
    private TextView iLE;
    private TextView iLF;
    private ViewGroup iLG;
    private d iLH;
    private e iLI;
    private f iLJ;
    private int iLK;
    private boolean iLL;
    private boolean iLM;
    private a iLN;
    private View iLz;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iLL = false;
        this.iLM = true;
        this.fUO = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fUC != null) {
                    VideoMiddlePageAdView.this.fUC.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iLz != null) {
                    VideoMiddlePageAdView.this.iLz.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fUC != null) {
                    VideoMiddlePageAdView.this.fUC.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iLz != null) {
                    VideoMiddlePageAdView.this.iLz.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fUP = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fUC != null) {
                    VideoMiddlePageAdView.this.fUC.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iLz != null) {
                    VideoMiddlePageAdView.this.iLz.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fUC != null) {
                    VideoMiddlePageAdView.this.fUC.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iLz != null) {
                    VideoMiddlePageAdView.this.iLz.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iLL = false;
        this.iLM = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fAT = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fUw = this.rootView.findViewById(R.id.card_container);
        this.fAU = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fBh = new c((TbPageContext<?>) this.cfl, (View) this.fAU, false);
        this.fBh.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.fBh != null && VideoMiddlePageAdView.this.fBh.getVideoView() != null) {
                    VideoMiddlePageAdView.this.iLK = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.fBh.getVideoView().getDuration());
                }
            }
        });
        this.fBh.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kL(boolean z) {
                if (VideoMiddlePageAdView.this.iLN != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iLN.sc(0);
                    } else {
                        VideoMiddlePageAdView.this.iLN.sc(1);
                    }
                }
            }
        });
        this.fBh.hgl.setOnTouchListener(null);
        this.fAV = (TextView) this.rootView.findViewById(R.id.title);
        this.fBa = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.fBa.setIsRound(true);
        this.fBa.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fBa.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fBa.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iLC = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.HE = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dwz = new n(this.cfl.getPageActivity());
        this.iLE = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iLF = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iLG = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iLH = new d(this.cfl.getPageActivity(), this.iLG);
        this.iLH.page = 1;
        this.fUH = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fUH.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fUH.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fBh.pM(false);
                VideoMiddlePageAdView.this.fUH.cwh();
                if (VideoMiddlePageAdView.this.iLD != null && VideoMiddlePageAdView.this.iLD.video != null) {
                    VideoMiddlePageAdView.this.fBh.cm(VideoMiddlePageAdView.this.iLD.video.video_url, "");
                }
            }
        });
        this.fUC = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iLA = this.rootView.findViewById(R.id.user_container_foreground);
        this.iLB = this.rootView.findViewById(R.id.title_foreground);
        this.iLz = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fUC.setOnClickListener(this);
        this.iLA.setOnClickListener(this);
        this.iLB.setOnClickListener(this);
        this.iLz.setOnClickListener(this);
        this.fAU.setOnClickListener(this);
        this.fAT.setOnClickListener(this);
        this.fBh.Z(this);
        this.fAV.setOnClickListener(this);
        this.fBa.setOnClickListener(this);
        this.HE.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cfl.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fAT.setLayoutParams(layoutParams);
        this.azf = new AlphaAnimation(0.0f, 0.7f);
        this.azf.setDuration(500L);
        this.azf.setAnimationListener(this.fUP);
        this.azg = new AlphaAnimation(0.7f, 0.0f);
        this.azg.setDuration(500L);
        this.azg.setAnimationListener(this.fUO);
        this.rootView.setOnClickListener(this);
        this.iLN = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIg() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cgq = this.iLD.autoPlay;
            this.iLL = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iLK = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fBh.kx()) {
                ch(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fBh.getCurrentPosition());
                this.iLM = true;
            }
            this.fBh.stopPlay();
            this.fBh.setIsNeedRecoveryVideoPlayer(true);
            this.fBh.pN(true);
            this.fBh.pJ(false);
            this.fBh.pO(true);
            this.fBh.ag(false, true);
            this.fBh.xE(i);
            this.fBh.a(new c.InterfaceC0497c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kv() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kw() {
                }
            });
            this.fBh.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bmm() {
                    if (VideoMiddlePageAdView.this.iLD != null && VideoMiddlePageAdView.this.iLD.video != null && VideoMiddlePageAdView.this.iLD.video.video_height.intValue() > VideoMiddlePageAdView.this.iLD.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fBh.ag(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fBh.ag(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iLJ != null) {
                        VideoMiddlePageAdView.this.iLJ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ym(VideoMiddlePageAdView.this.cgq ? 0 : 1);
                    VideoMiddlePageAdView.this.iLL = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmn() {
                }
            });
            this.fBh.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    VideoMiddlePageAdView.this.fBh.cm(VideoMiddlePageAdView.this.iLD.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iLJ != null) {
                        VideoMiddlePageAdView.this.iLJ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ym(1);
                    VideoMiddlePageAdView.this.iLL = false;
                }
            });
            this.fBh.pF(false);
            this.fBh.getVideoView().setBusiness(this.dwz);
            this.fBh.bII();
            this.fBh.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fBh.bvM();
                    if (VideoMiddlePageAdView.this.iLI != null) {
                        VideoMiddlePageAdView.this.iLI.cgP();
                    }
                    VideoMiddlePageAdView.this.yn(VideoMiddlePageAdView.this.cgq ? 0 : 1);
                    VideoMiddlePageAdView.this.iLM = true;
                }
            });
            this.fBh.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.yo(VideoMiddlePageAdView.this.cgq ? 0 : 1);
                    return true;
                }
            });
            this.fBh.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fBh.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fBh.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bmp() {
                    VideoMiddlePageAdView.this.ci(1, VideoMiddlePageAdView.this.fBh.getCurrentPosition());
                }
            });
            this.fBh.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.ch(1, VideoMiddlePageAdView.this.fBh.getCurrentPosition());
                    VideoMiddlePageAdView.this.iLM = true;
                }
            });
            this.fBh.bvM();
            this.fBh.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fUH.cdl()) {
                    this.fBh.pL(false);
                    this.fUH.cwg();
                    this.fBh.pM(true);
                    this.fBh.dE(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fBh.pM(false);
                    this.fBh.pL(false);
                    this.fUH.hide();
                    this.fBh.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iLI != null) {
                    this.iLI.qg(true);
                }
                if (i == 0) {
                    this.fUC.setVisibility(8);
                    this.iLz.setVisibility(8);
                } else {
                    this.fUC.startAnimation(this.azg);
                    this.iLz.startAnimation(this.azg);
                }
                if (i == 0) {
                    this.iLN.sc(3);
                    return;
                } else {
                    this.iLN.sc(0);
                    return;
                }
            }
            this.fUH.hide();
            this.fBh.pL(true);
            this.iLN.sc(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.fUC.startAnimation(this.azg);
                this.iLz.startAnimation(this.azg);
                return;
            }
            this.fUC.setVisibility(0);
            this.iLz.setVisibility(0);
        }
    }

    private boolean brd() {
        try {
            int intValue = this.iLD.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iLD.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fAV.setTextColor(this.cfl.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iLC.setTextColor(this.cfl.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iLE.setTextColor(this.cfl.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iLF.setTextColor(this.cfl.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.iLF, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bre() {
        if (!brd()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fAT.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fAT.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iLD = videoMiddlePageAdCard;
        bre();
        this.fAV.setText(videoMiddlePageAdCard.threadTitle);
        this.HE.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.fBa.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.fBa.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.fBa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aoY() || VideoMiddlePageAdView.this.iLD == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.iLD.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cfl.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iLC.setText(videoMiddlePageAdCard.tagName);
        this.iLE.setText(videoMiddlePageAdCard.operateData.iJp);
        this.iLF.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int a2 = s.a(VideoMiddlePageAdView.this.cfl, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.iLD == null || VideoMiddlePageAdView.this.iLD.getAdFacadeData() == null || VideoMiddlePageAdView.this.iLD.getAdFacadeData().kd() == null) ? null : VideoMiddlePageAdView.this.iLD.getAdFacadeData().kd().bXk);
                if (VideoMiddlePageAdView.this.iLI != null) {
                    VideoMiddlePageAdView.this.iLI.qg(false);
                }
                if (VideoMiddlePageAdView.this.hfN != null) {
                    VideoMiddlePageAdView.this.hfN.b(a2, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iLD, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iLI = this.iLH.a(videoMiddlePageAdCard.tailFrame, this.iLI);
        if (this.iLI != null) {
            b(this.iLD.getAdFacadeData());
            this.iLI.setPageContext(this.cfl);
            this.iLI.setTimeoutListener(this);
            this.iLI.a(videoMiddlePageAdCard.tailFrame);
            this.iLI.c(this.iLD);
            this.iLI.cgQ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.AY = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.AY;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fUE = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iLJ = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bp(View view) {
        this.AY.qO(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bmk();
        if (this.fUC != null) {
            this.fUC.clearAnimation();
        }
        if (this.iLz != null) {
            this.iLz.clearAnimation();
        }
    }

    public void bmj() {
        this.fBh.stopPlay();
        if (this.fAV != null) {
            this.fAV.setVisibility(0);
        }
        if (this.iLN != null) {
            this.iLN.sc(2);
        }
        this.iLL = false;
        this.iLM = true;
    }

    public void bmk() {
        if (this.fBh != null) {
            this.fBh.destroy();
        }
        this.iLL = false;
        this.iLM = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fUC && this.fUC.getVisibility() == 0) {
            if (this.fUE != null) {
                this.fUE.sg(this.mPosition);
            }
        } else if (view == this.iLz && this.iLz.getVisibility() == 0) {
            if (this.fUE != null) {
                this.fUE.sg(this.mPosition);
            }
        } else if (view == this.iLB || view == this.iLA) {
            if (this.fUC.getVisibility() == 0) {
                if (this.fUE != null) {
                    this.fUE.sg(this.mPosition);
                    return;
                }
                return;
            }
            this.iLN.sc(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.iIe = new WebVideoActivity.a();
            if (this.iLD.getAdFacadeData() != null) {
                WebVideoActivity.iIe.iIo = this.iLD.getAdFacadeData().kd();
                WebVideoActivity.iIe.aTe = "DETAIL";
                if (this.iLD.getAdFacadeData().AI != null) {
                    WebVideoActivity.iIe.mPageNum = this.iLD.getAdFacadeData().AI.jZ();
                }
            }
            if (com.baidu.tieba.a.aAO().aAP() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cfl.getPageActivity(), "", this.iLD.getScheme(), true, true, true, this.iLD.video.video_url, this.iLD.video.thumbnail_url, 1.7777778f, this.iLK, this.iLD.getAdFacadeData().kd().bXk)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cfl.getPageActivity(), "", this.iLD.getScheme(), true, true, true, this.iLD.video.video_url, this.iLD.video.thumbnail_url, 1.7777778f, this.iLK)));
            }
            if (this.hfN != null) {
                this.hfN.b(0, null);
            }
            if (this.iLI != null) {
                this.iLI.qg(false);
            }
        } else {
            String str = null;
            if (this.iLD.getAdFacadeData() != null && this.iLD.getAdFacadeData().kd() != null) {
                str = this.iLD.getAdFacadeData().kd().bXk;
            }
            int a2 = s.a(this.cfl, this.iLD.getScheme(), str);
            if (this.hfN != null) {
                this.hfN.b(a2, null);
            }
            if (this.iLI != null) {
                this.iLI.qg(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.lF(this.fBh.getCurrentPosition()) < this.iLK && this.fBh.getCurrentState() == 1) {
            ch(this.cgq ? 0 : 1, this.fBh.getCurrentPosition());
        }
        bmj();
        this.iLI.qg(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fBh.pausePlay();
            ch(this.cgq ? 0 : 1, this.fBh.getCurrentPosition());
            this.iLM = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fBh.kx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(int i) {
        if (this.iLD != null && this.iLD.video != null && this.iLD.getAdFacadeData() != null && this.iLM) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(this.iLD.getAdFacadeData(), 31, this.iLD.getAdFacadeData().getPageNum(), i, this.iLK, 0, -1));
            this.iLM = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(int i) {
        if (this.iLD != null && this.iLD.video != null && this.iLD.getAdFacadeData() != null && !this.iLL) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(this.iLD.getAdFacadeData(), 34, this.iLD.getAdFacadeData().getPageNum(), i, this.iLK, this.iLK, -1));
            this.iLL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(int i) {
        if (this.iLD != null && this.iLD.video != null && this.iLD.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(this.iLD.getAdFacadeData(), 36, this.iLD.getAdFacadeData().getPageNum(), i, this.iLK, com.baidu.tieba.ad.a.a.lF(this.fBh.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(int i, int i2) {
        if (this.iLD != null && this.iLD.video != null && this.iLD.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(this.iLD.getAdFacadeData(), 32, this.iLD.getAdFacadeData().getPageNum(), i, this.iLK, com.baidu.tieba.ad.a.a.lF(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(int i, int i2) {
        if (this.iLD != null && this.iLD.video != null && this.iLD.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(this.iLD.getAdFacadeData(), 33, this.iLD.getAdFacadeData().getPageNum(), i, this.iLK, com.baidu.tieba.ad.a.a.lF(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iLD.getAdFacadeData(), 303, this.iLD.getAdFacadeData().getPageNum(), this.cgq ? 0 : 1, this.iLD.video.video_duration.intValue(), 0, -1);
            if (this.iLI != null) {
                this.iLI.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
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
    /* loaded from: classes3.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable fUV = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fUV);
                a.this.sc(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void sc(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sd(i);
                    bro();
                    return;
                case 1:
                    this.mCurrentState = sd(i);
                    this.mHandler.removeCallbacks(this.fUV);
                    return;
                case 2:
                    this.mCurrentState = se(i);
                    return;
                case 3:
                    this.mCurrentState = sf(i);
                    bro();
                    return;
                default:
                    this.mCurrentState = se(i);
                    return;
            }
        }

        private void bro() {
            this.mHandler.removeCallbacks(this.fUV);
            this.mHandler.postDelayed(this.fUV, 3000L);
        }

        private int sd(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iLB.setVisibility(8);
                VideoMiddlePageAdView.this.iLA.setVisibility(8);
                VideoMiddlePageAdView.this.qc(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int se(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iLB.setVisibility(0);
                VideoMiddlePageAdView.this.iLA.setVisibility(0);
                if (VideoMiddlePageAdView.this.fBh != null) {
                    VideoMiddlePageAdView.this.fBh.cbU();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iLD.autoPlay) {
                    VideoMiddlePageAdView.this.qc(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sf(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iLB.setVisibility(0);
                VideoMiddlePageAdView.this.iLA.setVisibility(0);
                VideoMiddlePageAdView.this.qc(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
