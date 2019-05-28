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
    private n dlO;
    public HeadImageView ebk;
    private View fNC;
    private c fNE;
    private VideoNetworkStateTipView fNH;
    private Animation.AnimationListener fNO;
    private Animation.AnimationListener fNP;
    private View fNw;
    public FrameLayout fuf;
    public FrameLayout fug;
    public TextView fuh;
    public com.baidu.tieba.play.c fut;
    private View iCN;
    private View iCO;
    private View iCP;
    public TextView iCQ;
    private VideoMiddlePageAdCard iCR;
    private TextView iCS;
    private TextView iCT;
    private ViewGroup iCU;
    private d iCV;
    private e iCW;
    private f iCX;
    private int iCY;
    private boolean iCZ;
    private boolean iDa;
    private a iDb;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iCZ = false;
        this.iDa = true;
        this.fNO = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fNC != null) {
                    VideoMiddlePageAdView.this.fNC.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iCN != null) {
                    VideoMiddlePageAdView.this.iCN.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fNC != null) {
                    VideoMiddlePageAdView.this.fNC.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iCN != null) {
                    VideoMiddlePageAdView.this.iCN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNP = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fNC != null) {
                    VideoMiddlePageAdView.this.fNC.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iCN != null) {
                    VideoMiddlePageAdView.this.iCN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fNC != null) {
                    VideoMiddlePageAdView.this.fNC.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iCN != null) {
                    VideoMiddlePageAdView.this.iCN.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iCZ = false;
        this.iDa = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fuf = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fNw = this.rootView.findViewById(R.id.card_container);
        this.fug = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fut = new com.baidu.tieba.play.c((TbPageContext<?>) this.mContext, (View) this.fug, false);
        this.fut.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                VideoMiddlePageAdView.this.iCY = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fut.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kK(boolean z) {
                if (VideoMiddlePageAdView.this.iDb != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iDb.sK(0);
                    } else {
                        VideoMiddlePageAdView.this.iDb.sK(1);
                    }
                }
            }
        });
        this.fut.gZh.setOnTouchListener(null);
        this.fuh = (TextView) this.rootView.findViewById(R.id.title);
        this.ebk = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.ebk.setIsRound(true);
        this.ebk.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ebk.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ebk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iCQ = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Xr = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dlO = new n(this.mContext.getPageActivity());
        this.iCS = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iCT = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iCU = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iCV = new d(this.mContext.getPageActivity(), this.iCU);
        this.iCV.page = 1;
        this.fNH = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fNH.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fNH.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fut.pL(false);
                VideoMiddlePageAdView.this.fNH.cut();
                if (VideoMiddlePageAdView.this.iCR != null && VideoMiddlePageAdView.this.iCR.video != null) {
                    VideoMiddlePageAdView.this.fut.cr(VideoMiddlePageAdView.this.iCR.video.video_url, "");
                }
            }
        });
        this.fNC = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iCO = this.rootView.findViewById(R.id.user_container_foreground);
        this.iCP = this.rootView.findViewById(R.id.title_foreground);
        this.iCN = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fNC.setOnClickListener(this);
        this.iCO.setOnClickListener(this);
        this.iCP.setOnClickListener(this);
        this.iCN.setOnClickListener(this);
        this.fug.setOnClickListener(this);
        this.fuf.setOnClickListener(this);
        this.fut.W(this);
        this.fuh.setOnClickListener(this);
        this.ebk.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fuf.setLayoutParams(layoutParams);
        this.afk = new AlphaAnimation(0.0f, 0.7f);
        this.afk.setDuration(500L);
        this.afk.setAnimationListener(this.fNP);
        this.afl = new AlphaAnimation(0.7f, 0.0f);
        this.afl.setDuration(500L);
        this.afl.setAnimationListener(this.fNO);
        this.rootView.setOnClickListener(this);
        this.iDb = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHN() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bNF = this.iCR.autoPlay;
            this.iCZ = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iCY = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fut.pg()) {
                ci(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fut.getCurrentPosition());
                this.iDa = true;
            }
            this.fut.stopPlay();
            this.fut.setIsNeedRecoveryVideoPlayer(true);
            this.fut.pM(true);
            this.fut.pI(false);
            this.fut.pN(true);
            this.fut.ad(false, true);
            this.fut.yp(i);
            this.fut.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                }
            });
            this.fut.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bmi() {
                    if (VideoMiddlePageAdView.this.iCR != null && VideoMiddlePageAdView.this.iCR.video != null && VideoMiddlePageAdView.this.iCR.video.video_height.intValue() > VideoMiddlePageAdView.this.iCR.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fut.ad(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fut.ad(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iCX != null) {
                        VideoMiddlePageAdView.this.iCX.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yW(VideoMiddlePageAdView.this.bNF ? 0 : 1);
                    VideoMiddlePageAdView.this.iCZ = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmj() {
                }
            });
            this.fut.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    VideoMiddlePageAdView.this.fut.cr(VideoMiddlePageAdView.this.iCR.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iCX != null) {
                        VideoMiddlePageAdView.this.iCX.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yW(1);
                    VideoMiddlePageAdView.this.iCZ = false;
                }
            });
            this.fut.pE(false);
            this.fut.getVideoView().setBusiness(this.dlO);
            this.fut.bIq();
            this.fut.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fut.bvt();
                    if (VideoMiddlePageAdView.this.iCW != null) {
                        VideoMiddlePageAdView.this.iCW.cfK();
                    }
                    VideoMiddlePageAdView.this.yX(VideoMiddlePageAdView.this.bNF ? 0 : 1);
                    VideoMiddlePageAdView.this.iDa = true;
                }
            });
            this.fut.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.yY(VideoMiddlePageAdView.this.bNF ? 0 : 1);
                    return true;
                }
            });
            this.fut.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fut.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fut.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bml() {
                    VideoMiddlePageAdView.this.cj(1, VideoMiddlePageAdView.this.fut.getCurrentPosition());
                }
            });
            this.fut.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.ci(1, VideoMiddlePageAdView.this.fut.getCurrentPosition());
                    VideoMiddlePageAdView.this.iDa = true;
                }
            });
            this.fut.bvt();
            this.fut.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fNH.cco()) {
                    this.fut.pK(false);
                    this.fNH.cus();
                    this.fut.pL(true);
                    this.fut.dP(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fut.pL(false);
                    this.fut.pK(false);
                    this.fNH.hide();
                    this.fut.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iCW != null) {
                    this.iCW.qd(true);
                }
                if (i == 0) {
                    this.fNC.setVisibility(8);
                    this.iCN.setVisibility(8);
                } else {
                    this.fNC.startAnimation(this.afl);
                    this.iCN.startAnimation(this.afl);
                }
                if (i == 0) {
                    this.iDb.sK(3);
                    return;
                } else {
                    this.iDb.sK(0);
                    return;
                }
            }
            this.fNH.hide();
            this.fut.pK(true);
            this.iDb.sK(3);
            if (com.baidu.adp.lib.util.j.jU() && videoMiddlePageAdCard.waitConfirm) {
                this.fNC.startAnimation(this.afl);
                this.iCN.startAnimation(this.afl);
                return;
            }
            this.fNC.setVisibility(0);
            this.iCN.setVisibility(0);
        }
    }

    private boolean bqW() {
        try {
            int intValue = this.iCR.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iCR.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fuh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCQ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCS.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCT.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        al.k(this.iCT, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bqX() {
        if (!bqW()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fuf.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fuf.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iCR = videoMiddlePageAdCard;
        bqX();
        this.fuh.setText(videoMiddlePageAdCard.threadTitle);
        this.Xr.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.ebk.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.ebk.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.ebk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.ala() || VideoMiddlePageAdView.this.iCR == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aR(VideoMiddlePageAdView.this.iCR.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iCQ.setText(videoMiddlePageAdCard.tagName);
        this.iCS.setText(videoMiddlePageAdCard.operateData.iAF);
        this.iCT.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.iCW != null) {
                    VideoMiddlePageAdView.this.iCW.qd(false);
                }
                if (VideoMiddlePageAdView.this.gYJ != null) {
                    VideoMiddlePageAdView.this.gYJ.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iCR, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iCW = this.iCV.a(videoMiddlePageAdCard.tailFrame, this.iCW);
        if (this.iCW != null) {
            b(this.iCR.getAdFacadeData());
            this.iCW.setPageContext(this.mContext);
            this.iCW.setTimeoutListener(this);
            this.iCW.a(videoMiddlePageAdCard.tailFrame);
            this.iCW.c(this.iCR);
            this.iCW.cfL();
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
        this.fNE = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iCX = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bn(View view) {
        this.Rj.ry(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bmg();
        if (this.fNC != null) {
            this.fNC.clearAnimation();
        }
        if (this.iCN != null) {
            this.iCN.clearAnimation();
        }
    }

    public void bmf() {
        this.fut.stopPlay();
        if (this.fuh != null) {
            this.fuh.setVisibility(0);
        }
        if (this.iDb != null) {
            this.iDb.sK(2);
        }
        this.iCZ = false;
        this.iDa = true;
    }

    public void bmg() {
        if (this.fut != null) {
            this.fut.destroy();
        }
        this.iCZ = false;
        this.iDa = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fNC && this.fNC.getVisibility() == 0) {
            if (this.fNE != null) {
                this.fNE.sO(this.mPosition);
            }
        } else if (view == this.iCN && this.iCN.getVisibility() == 0) {
            if (this.fNE != null) {
                this.fNE.sO(this.mPosition);
            }
        } else if (view == this.iCP || view == this.iCO) {
            if (this.fNC.getVisibility() == 0) {
                if (this.fNE != null) {
                    this.fNE.sO(this.mPosition);
                    return;
                }
                return;
            }
            this.iDb.sK(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.izz = new WebVideoActivity.a();
            if (this.iCR.getAdFacadeData() != null) {
                WebVideoActivity.izz.izJ = this.iCR.getAdFacadeData().oM();
                WebVideoActivity.izz.ayL = "DETAIL";
                if (this.iCR.getAdFacadeData().QV != null) {
                    WebVideoActivity.izz.mPageNum = this.iCR.getAdFacadeData().QV.oI();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iCR.getScheme(), true, true, true, this.iCR.video.video_url, this.iCR.video.thumbnail_url, 1.7777778f, this.iCY)));
            if (this.gYJ != null) {
                this.gYJ.b(0, null);
            }
            if (this.iCW != null) {
                this.iCW.qd(false);
            }
        } else {
            int e = s.e(this.mContext, this.iCR.getScheme());
            if (this.gYJ != null) {
                this.gYJ.b(e, null);
            }
            if (this.iCW != null) {
                this.iCW.qd(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.mo(this.fut.getCurrentPosition()) < this.iCY && this.fut.getCurrentState() == 1) {
            ci(this.bNF ? 0 : 1, this.fut.getCurrentPosition());
        }
        bmf();
        this.iCW.qd(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fut.pausePlay();
            ci(this.bNF ? 0 : 1, this.fut.getCurrentPosition());
            this.iDa = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fut.pg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yW(int i) {
        if (this.iCR != null && this.iCR.video != null && this.iCR.getAdFacadeData() != null && this.iDa) {
            com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.a(this.iCR.getAdFacadeData(), 31, this.iCR.getAdFacadeData().getPageNum(), i, this.iCY, 0, -1));
            this.iDa = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX(int i) {
        if (this.iCR != null && this.iCR.video != null && this.iCR.getAdFacadeData() != null && !this.iCZ) {
            com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.a(this.iCR.getAdFacadeData(), 34, this.iCR.getAdFacadeData().getPageNum(), i, this.iCY, this.iCY, -1));
            this.iCZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY(int i) {
        if (this.iCR != null && this.iCR.video != null && this.iCR.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.a(this.iCR.getAdFacadeData(), 36, this.iCR.getAdFacadeData().getPageNum(), i, this.iCY, com.baidu.tieba.ad.a.a.mo(this.fut.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(int i, int i2) {
        if (this.iCR != null && this.iCR.video != null && this.iCR.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.a(this.iCR.getAdFacadeData(), 32, this.iCR.getAdFacadeData().getPageNum(), i, this.iCY, com.baidu.tieba.ad.a.a.mo(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(int i, int i2) {
        if (this.iCR != null && this.iCR.video != null && this.iCR.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.a(this.iCR.getAdFacadeData(), 33, this.iCR.getAdFacadeData().getPageNum(), i, this.iCY, com.baidu.tieba.ad.a.a.mo(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iCR.getAdFacadeData(), 303, this.iCR.getAdFacadeData().getPageNum(), this.bNF ? 0 : 1, this.iCR.video.video_duration.intValue(), 0, -1);
            if (this.iCW != null) {
                this.iCW.e(a2);
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
        private Runnable fNV = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fNV);
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
                    brh();
                    return;
                case 1:
                    this.mCurrentState = sL(i);
                    this.mHandler.removeCallbacks(this.fNV);
                    return;
                case 2:
                    this.mCurrentState = sM(i);
                    return;
                case 3:
                    this.mCurrentState = sN(i);
                    brh();
                    return;
                default:
                    this.mCurrentState = sM(i);
                    return;
            }
        }

        private void brh() {
            this.mHandler.removeCallbacks(this.fNV);
            this.mHandler.postDelayed(this.fNV, 3000L);
        }

        private int sL(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCP.setVisibility(8);
                VideoMiddlePageAdView.this.iCO.setVisibility(8);
                VideoMiddlePageAdView.this.qa(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sM(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCP.setVisibility(0);
                VideoMiddlePageAdView.this.iCO.setVisibility(0);
                if (VideoMiddlePageAdView.this.fut != null) {
                    VideoMiddlePageAdView.this.fut.caU();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iCR.autoPlay) {
                    VideoMiddlePageAdView.this.qa(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sN(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCP.setVisibility(0);
                VideoMiddlePageAdView.this.iCO.setVisibility(0);
                VideoMiddlePageAdView.this.qa(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
