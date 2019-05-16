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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
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
    private com.baidu.tieba.frs.aggregation.a Rj;
    public TextView Xr;
    private Animation afk;
    private Animation afl;
    private boolean bNF;
    private n dlN;
    public HeadImageView ebj;
    private View fNB;
    private c fND;
    private VideoNetworkStateTipView fNG;
    private Animation.AnimationListener fNN;
    private Animation.AnimationListener fNO;
    private View fNv;
    public FrameLayout fue;
    public FrameLayout fuf;
    public TextView fug;
    public com.baidu.tieba.play.c fus;
    private View iCL;
    private View iCM;
    private View iCN;
    public TextView iCO;
    private VideoMiddlePageAdCard iCP;
    private TextView iCQ;
    private TextView iCR;
    private ViewGroup iCS;
    private d iCT;
    private e iCU;
    private f iCV;
    private int iCW;
    private boolean iCX;
    private boolean iCY;
    private a iCZ;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iCX = false;
        this.iCY = true;
        this.fNN = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fNB != null) {
                    VideoMiddlePageAdView.this.fNB.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iCL != null) {
                    VideoMiddlePageAdView.this.iCL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fNB != null) {
                    VideoMiddlePageAdView.this.fNB.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iCL != null) {
                    VideoMiddlePageAdView.this.iCL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNO = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fNB != null) {
                    VideoMiddlePageAdView.this.fNB.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iCL != null) {
                    VideoMiddlePageAdView.this.iCL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fNB != null) {
                    VideoMiddlePageAdView.this.fNB.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iCL != null) {
                    VideoMiddlePageAdView.this.iCL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iCX = false;
        this.iCY = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fue = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fNv = this.rootView.findViewById(R.id.card_container);
        this.fuf = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fus = new com.baidu.tieba.play.c((TbPageContext<?>) this.mContext, (View) this.fuf, false);
        this.fus.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                VideoMiddlePageAdView.this.iCW = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fus.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kK(boolean z) {
                if (VideoMiddlePageAdView.this.iCZ != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iCZ.sK(0);
                    } else {
                        VideoMiddlePageAdView.this.iCZ.sK(1);
                    }
                }
            }
        });
        this.fus.gZe.setOnTouchListener(null);
        this.fug = (TextView) this.rootView.findViewById(R.id.title);
        this.ebj = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.ebj.setIsRound(true);
        this.ebj.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ebj.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ebj.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iCO = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Xr = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dlN = new n(this.mContext.getPageActivity());
        this.iCQ = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iCR = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iCS = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iCT = new d(this.mContext.getPageActivity(), this.iCS);
        this.iCT.page = 1;
        this.fNG = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fNG.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fNG.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fus.pL(false);
                VideoMiddlePageAdView.this.fNG.cur();
                if (VideoMiddlePageAdView.this.iCP != null && VideoMiddlePageAdView.this.iCP.video != null) {
                    VideoMiddlePageAdView.this.fus.cr(VideoMiddlePageAdView.this.iCP.video.video_url, "");
                }
            }
        });
        this.fNB = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iCM = this.rootView.findViewById(R.id.user_container_foreground);
        this.iCN = this.rootView.findViewById(R.id.title_foreground);
        this.iCL = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fNB.setOnClickListener(this);
        this.iCM.setOnClickListener(this);
        this.iCN.setOnClickListener(this);
        this.iCL.setOnClickListener(this);
        this.fuf.setOnClickListener(this);
        this.fue.setOnClickListener(this);
        this.fus.W(this);
        this.fug.setOnClickListener(this);
        this.ebj.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fue.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fue.setLayoutParams(layoutParams);
        this.afk = new AlphaAnimation(0.0f, 0.7f);
        this.afk.setDuration(500L);
        this.afk.setAnimationListener(this.fNO);
        this.afl = new AlphaAnimation(0.7f, 0.0f);
        this.afl.setDuration(500L);
        this.afl.setAnimationListener(this.fNN);
        this.rootView.setOnClickListener(this);
        this.iCZ = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHK() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bNF = this.iCP.autoPlay;
            this.iCX = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iCW = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fus.pg()) {
                ci(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fus.getCurrentPosition());
                this.iCY = true;
            }
            this.fus.stopPlay();
            this.fus.setIsNeedRecoveryVideoPlayer(true);
            this.fus.pM(true);
            this.fus.pI(false);
            this.fus.pN(true);
            this.fus.ad(false, true);
            this.fus.yp(i);
            this.fus.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                }
            });
            this.fus.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bmf() {
                    if (VideoMiddlePageAdView.this.iCP != null && VideoMiddlePageAdView.this.iCP.video != null && VideoMiddlePageAdView.this.iCP.video.video_height.intValue() > VideoMiddlePageAdView.this.iCP.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fus.ad(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fus.ad(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iCV != null) {
                        VideoMiddlePageAdView.this.iCV.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yW(VideoMiddlePageAdView.this.bNF ? 0 : 1);
                    VideoMiddlePageAdView.this.iCX = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmg() {
                }
            });
            this.fus.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    VideoMiddlePageAdView.this.fus.cr(VideoMiddlePageAdView.this.iCP.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iCV != null) {
                        VideoMiddlePageAdView.this.iCV.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yW(1);
                    VideoMiddlePageAdView.this.iCX = false;
                }
            });
            this.fus.pE(false);
            this.fus.getVideoView().setBusiness(this.dlN);
            this.fus.bIn();
            this.fus.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fus.bvq();
                    if (VideoMiddlePageAdView.this.iCU != null) {
                        VideoMiddlePageAdView.this.iCU.cfI();
                    }
                    VideoMiddlePageAdView.this.yX(VideoMiddlePageAdView.this.bNF ? 0 : 1);
                    VideoMiddlePageAdView.this.iCY = true;
                }
            });
            this.fus.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.yY(VideoMiddlePageAdView.this.bNF ? 0 : 1);
                    return true;
                }
            });
            this.fus.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fus.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fus.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bmi() {
                    VideoMiddlePageAdView.this.cj(1, VideoMiddlePageAdView.this.fus.getCurrentPosition());
                }
            });
            this.fus.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.ci(1, VideoMiddlePageAdView.this.fus.getCurrentPosition());
                    VideoMiddlePageAdView.this.iCY = true;
                }
            });
            this.fus.bvq();
            this.fus.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fNG.ccl()) {
                    this.fus.pK(false);
                    this.fNG.cuq();
                    this.fus.pL(true);
                    this.fus.dP(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fus.pL(false);
                    this.fus.pK(false);
                    this.fNG.hide();
                    this.fus.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iCU != null) {
                    this.iCU.qd(true);
                }
                if (i == 0) {
                    this.fNB.setVisibility(8);
                    this.iCL.setVisibility(8);
                } else {
                    this.fNB.startAnimation(this.afl);
                    this.iCL.startAnimation(this.afl);
                }
                if (i == 0) {
                    this.iCZ.sK(3);
                    return;
                } else {
                    this.iCZ.sK(0);
                    return;
                }
            }
            this.fNG.hide();
            this.fus.pK(true);
            this.iCZ.sK(3);
            if (com.baidu.adp.lib.util.j.jU() && videoMiddlePageAdCard.waitConfirm) {
                this.fNB.startAnimation(this.afl);
                this.iCL.startAnimation(this.afl);
                return;
            }
            this.fNB.setVisibility(0);
            this.iCL.setVisibility(0);
        }
    }

    private boolean bqT() {
        try {
            int intValue = this.iCP.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iCP.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fug.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCO.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCQ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        al.k(this.iCR, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bqU() {
        if (!bqT()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fue.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fue.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fue.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fue.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iCP = videoMiddlePageAdCard;
        bqU();
        this.fug.setText(videoMiddlePageAdCard.threadTitle);
        this.Xr.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.ebj.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.ebj.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.ebj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.ala() || VideoMiddlePageAdView.this.iCP == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aR(VideoMiddlePageAdView.this.iCP.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iCO.setText(videoMiddlePageAdCard.tagName);
        this.iCQ.setText(videoMiddlePageAdCard.operateData.iAD);
        this.iCR.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.iCU != null) {
                    VideoMiddlePageAdView.this.iCU.qd(false);
                }
                if (VideoMiddlePageAdView.this.gYG != null) {
                    VideoMiddlePageAdView.this.gYG.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iCP, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iCU = this.iCT.a(videoMiddlePageAdCard.tailFrame, this.iCU);
        if (this.iCU != null) {
            b(this.iCP.getAdFacadeData());
            this.iCU.setPageContext(this.mContext);
            this.iCU.setTimeoutListener(this);
            this.iCU.a(videoMiddlePageAdCard.tailFrame);
            this.iCU.c(this.iCP);
            this.iCU.cfJ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Rj = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Rj;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fND = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iCV = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bn(View view) {
        this.Rj.ry(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bmd();
        if (this.fNB != null) {
            this.fNB.clearAnimation();
        }
        if (this.iCL != null) {
            this.iCL.clearAnimation();
        }
    }

    public void bmc() {
        this.fus.stopPlay();
        if (this.fug != null) {
            this.fug.setVisibility(0);
        }
        if (this.iCZ != null) {
            this.iCZ.sK(2);
        }
        this.iCX = false;
        this.iCY = true;
    }

    public void bmd() {
        if (this.fus != null) {
            this.fus.destroy();
        }
        this.iCX = false;
        this.iCY = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fNB && this.fNB.getVisibility() == 0) {
            if (this.fND != null) {
                this.fND.sO(this.mPosition);
            }
        } else if (view == this.iCL && this.iCL.getVisibility() == 0) {
            if (this.fND != null) {
                this.fND.sO(this.mPosition);
            }
        } else if (view == this.iCN || view == this.iCM) {
            if (this.fNB.getVisibility() == 0) {
                if (this.fND != null) {
                    this.fND.sO(this.mPosition);
                    return;
                }
                return;
            }
            this.iCZ.sK(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.izx = new WebVideoActivity.a();
            if (this.iCP.getAdFacadeData() != null) {
                WebVideoActivity.izx.izH = this.iCP.getAdFacadeData().oM();
                WebVideoActivity.izx.ayL = "DETAIL";
                if (this.iCP.getAdFacadeData().QV != null) {
                    WebVideoActivity.izx.mPageNum = this.iCP.getAdFacadeData().QV.oI();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iCP.getScheme(), true, true, true, this.iCP.video.video_url, this.iCP.video.thumbnail_url, 1.7777778f, this.iCW)));
            if (this.gYG != null) {
                this.gYG.b(0, null);
            }
            if (this.iCU != null) {
                this.iCU.qd(false);
            }
        } else {
            int e = s.e(this.mContext, this.iCP.getScheme());
            if (this.gYG != null) {
                this.gYG.b(e, null);
            }
            if (this.iCU != null) {
                this.iCU.qd(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.mo(this.fus.getCurrentPosition()) < this.iCW && this.fus.getCurrentState() == 1) {
            ci(this.bNF ? 0 : 1, this.fus.getCurrentPosition());
        }
        bmc();
        this.iCU.qd(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fus.pausePlay();
            ci(this.bNF ? 0 : 1, this.fus.getCurrentPosition());
            this.iCY = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fus.pg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yW(int i) {
        if (this.iCP != null && this.iCP.video != null && this.iCP.getAdFacadeData() != null && this.iCY) {
            com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(this.iCP.getAdFacadeData(), 31, this.iCP.getAdFacadeData().getPageNum(), i, this.iCW, 0, -1));
            this.iCY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX(int i) {
        if (this.iCP != null && this.iCP.video != null && this.iCP.getAdFacadeData() != null && !this.iCX) {
            com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(this.iCP.getAdFacadeData(), 34, this.iCP.getAdFacadeData().getPageNum(), i, this.iCW, this.iCW, -1));
            this.iCX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY(int i) {
        if (this.iCP != null && this.iCP.video != null && this.iCP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(this.iCP.getAdFacadeData(), 36, this.iCP.getAdFacadeData().getPageNum(), i, this.iCW, com.baidu.tieba.ad.a.a.mo(this.fus.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(int i, int i2) {
        if (this.iCP != null && this.iCP.video != null && this.iCP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(this.iCP.getAdFacadeData(), 32, this.iCP.getAdFacadeData().getPageNum(), i, this.iCW, com.baidu.tieba.ad.a.a.mo(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(int i, int i2) {
        if (this.iCP != null && this.iCP.video != null && this.iCP.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(this.iCP.getAdFacadeData(), 33, this.iCP.getAdFacadeData().getPageNum(), i, this.iCW, com.baidu.tieba.ad.a.a.mo(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iCP.getAdFacadeData(), 303, this.iCP.getAdFacadeData().getPageNum(), this.bNF ? 0 : 1, this.iCP.video.video_duration.intValue(), 0, -1);
            if (this.iCU != null) {
                this.iCU.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
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
        private Runnable fNU = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fNU);
                a.this.sK(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void sK(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sL(i);
                    bre();
                    return;
                case 1:
                    this.mCurrentState = sL(i);
                    this.mHandler.removeCallbacks(this.fNU);
                    return;
                case 2:
                    this.mCurrentState = sM(i);
                    return;
                case 3:
                    this.mCurrentState = sN(i);
                    bre();
                    return;
                default:
                    this.mCurrentState = sM(i);
                    return;
            }
        }

        private void bre() {
            this.mHandler.removeCallbacks(this.fNU);
            this.mHandler.postDelayed(this.fNU, 3000L);
        }

        private int sL(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCN.setVisibility(8);
                VideoMiddlePageAdView.this.iCM.setVisibility(8);
                VideoMiddlePageAdView.this.qa(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sM(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCN.setVisibility(0);
                VideoMiddlePageAdView.this.iCM.setVisibility(0);
                if (VideoMiddlePageAdView.this.fus != null) {
                    VideoMiddlePageAdView.this.fus.caR();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iCP.autoPlay) {
                    VideoMiddlePageAdView.this.qa(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sN(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCN.setVisibility(0);
                VideoMiddlePageAdView.this.iCM.setVisibility(0);
                VideoMiddlePageAdView.this.qa(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
