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
    private com.baidu.tieba.frs.aggregation.a RA;
    public TextView XL;
    private Animation afH;
    private Animation afI;
    private boolean bOM;
    private n dnD;
    public HeadImageView efN;
    public c fAd;
    private Animation.AnimationListener fTD;
    private Animation.AnimationListener fTE;
    private View fTl;
    private View fTr;
    private com.baidu.tieba.frs.videomiddlepage.c fTt;
    private VideoNetworkStateTipView fTw;
    public FrameLayout fzP;
    public FrameLayout fzQ;
    public TextView fzR;
    private View iKk;
    private View iKl;
    private View iKm;
    public TextView iKn;
    private VideoMiddlePageAdCard iKo;
    private TextView iKp;
    private TextView iKq;
    private ViewGroup iKr;
    private d iKs;
    private e iKt;
    private f iKu;
    private int iKv;
    private boolean iKw;
    private boolean iKx;
    private a iKy;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iKw = false;
        this.iKx = true;
        this.fTD = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fTr != null) {
                    VideoMiddlePageAdView.this.fTr.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iKk != null) {
                    VideoMiddlePageAdView.this.iKk.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fTr != null) {
                    VideoMiddlePageAdView.this.fTr.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iKk != null) {
                    VideoMiddlePageAdView.this.iKk.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fTE = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fTr != null) {
                    VideoMiddlePageAdView.this.fTr.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iKk != null) {
                    VideoMiddlePageAdView.this.iKk.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fTr != null) {
                    VideoMiddlePageAdView.this.fTr.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iKk != null) {
                    VideoMiddlePageAdView.this.iKk.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iKw = false;
        this.iKx = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fzP = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fTl = this.rootView.findViewById(R.id.card_container);
        this.fzQ = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fAd = new c((TbPageContext<?>) this.mContext, (View) this.fzQ, false);
        this.fAd.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                VideoMiddlePageAdView.this.iKv = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fAd.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kV(boolean z) {
                if (VideoMiddlePageAdView.this.iKy != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iKy.te(0);
                    } else {
                        VideoMiddlePageAdView.this.iKy.te(1);
                    }
                }
            }
        });
        this.fAd.hgm.setOnTouchListener(null);
        this.fzR = (TextView) this.rootView.findViewById(R.id.title);
        this.efN = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.efN.setIsRound(true);
        this.efN.setDefaultBgResource(R.color.cp_bg_line_e);
        this.efN.setDefaultResource(R.drawable.icon_default_avatar100);
        this.efN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iKn = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.XL = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dnD = new n(this.mContext.getPageActivity());
        this.iKp = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iKq = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iKr = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iKs = new d(this.mContext.getPageActivity(), this.iKr);
        this.iKs.page = 1;
        this.fTw = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fTw.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fTw.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fAd.qb(false);
                VideoMiddlePageAdView.this.fTw.cxD();
                if (VideoMiddlePageAdView.this.iKo != null && VideoMiddlePageAdView.this.iKo.video != null) {
                    VideoMiddlePageAdView.this.fAd.cs(VideoMiddlePageAdView.this.iKo.video.video_url, "");
                }
            }
        });
        this.fTr = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iKl = this.rootView.findViewById(R.id.user_container_foreground);
        this.iKm = this.rootView.findViewById(R.id.title_foreground);
        this.iKk = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fTr.setOnClickListener(this);
        this.iKl.setOnClickListener(this);
        this.iKm.setOnClickListener(this);
        this.iKk.setOnClickListener(this);
        this.fzQ.setOnClickListener(this);
        this.fzP.setOnClickListener(this);
        this.fAd.Y(this);
        this.fzR.setOnClickListener(this);
        this.efN.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fzP.setLayoutParams(layoutParams);
        this.afH = new AlphaAnimation(0.0f, 0.7f);
        this.afH.setDuration(500L);
        this.afH.setAnimationListener(this.fTE);
        this.afI = new AlphaAnimation(0.7f, 0.0f);
        this.afI.setDuration(500L);
        this.afI.setAnimationListener(this.fTD);
        this.rootView.setOnClickListener(this);
        this.iKy = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKJ() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bOM = this.iKo.autoPlay;
            this.iKw = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iKv = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fAd.pB()) {
                co(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fAd.getCurrentPosition());
                this.iKx = true;
            }
            this.fAd.stopPlay();
            this.fAd.setIsNeedRecoveryVideoPlayer(true);
            this.fAd.qc(true);
            this.fAd.pY(false);
            this.fAd.qd(true);
            this.fAd.ag(false, true);
            this.fAd.yW(i);
            this.fAd.a(new c.InterfaceC0392c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pz() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pA() {
                }
            });
            this.fAd.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bow() {
                    if (VideoMiddlePageAdView.this.iKo != null && VideoMiddlePageAdView.this.iKo.video != null && VideoMiddlePageAdView.this.iKo.video.video_height.intValue() > VideoMiddlePageAdView.this.iKo.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fAd.ag(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fAd.ag(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iKu != null) {
                        VideoMiddlePageAdView.this.iKu.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.zD(VideoMiddlePageAdView.this.bOM ? 0 : 1);
                    VideoMiddlePageAdView.this.iKw = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void box() {
                }
            });
            this.fAd.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kr(boolean z) {
                    VideoMiddlePageAdView.this.fAd.cs(VideoMiddlePageAdView.this.iKo.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iKu != null) {
                        VideoMiddlePageAdView.this.iKu.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.zD(1);
                    VideoMiddlePageAdView.this.iKw = false;
                }
            });
            this.fAd.pU(false);
            this.fAd.getVideoView().setBusiness(this.dnD);
            this.fAd.bLm();
            this.fAd.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fAd.byn();
                    if (VideoMiddlePageAdView.this.iKt != null) {
                        VideoMiddlePageAdView.this.iKt.ciU();
                    }
                    VideoMiddlePageAdView.this.zE(VideoMiddlePageAdView.this.bOM ? 0 : 1);
                    VideoMiddlePageAdView.this.iKx = true;
                }
            });
            this.fAd.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.zF(VideoMiddlePageAdView.this.bOM ? 0 : 1);
                    return true;
                }
            });
            this.fAd.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fAd.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fAd.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void boz() {
                    VideoMiddlePageAdView.this.cp(1, VideoMiddlePageAdView.this.fAd.getCurrentPosition());
                }
            });
            this.fAd.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.co(1, VideoMiddlePageAdView.this.fAd.getCurrentPosition());
                    VideoMiddlePageAdView.this.iKx = true;
                }
            });
            this.fAd.byn();
            this.fAd.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fTw.cfx()) {
                    this.fAd.qa(false);
                    this.fTw.cxC();
                    this.fAd.qb(true);
                    this.fAd.dQ(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fAd.qb(false);
                    this.fAd.qa(false);
                    this.fTw.hide();
                    this.fAd.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iKt != null) {
                    this.iKt.qu(true);
                }
                if (i == 0) {
                    this.fTr.setVisibility(8);
                    this.iKk.setVisibility(8);
                } else {
                    this.fTr.startAnimation(this.afI);
                    this.iKk.startAnimation(this.afI);
                }
                if (i == 0) {
                    this.iKy.te(3);
                    return;
                } else {
                    this.iKy.te(0);
                    return;
                }
            }
            this.fTw.hide();
            this.fAd.qa(true);
            this.iKy.te(3);
            if (com.baidu.adp.lib.util.j.ke() && videoMiddlePageAdCard.waitConfirm) {
                this.fTr.startAnimation(this.afI);
                this.iKk.startAnimation(this.afI);
                return;
            }
            this.fTr.setVisibility(0);
            this.iKk.setVisibility(0);
        }
    }

    private boolean btm() {
        try {
            int intValue = this.iKo.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iKo.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fzR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iKn.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iKp.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iKq.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.k(this.iKq, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void btn() {
        if (!btm()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fzP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fzP.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iKo = videoMiddlePageAdCard;
        btn();
        this.fzR.setText(videoMiddlePageAdCard.threadTitle);
        this.XL.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.efN.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.efN.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.efN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.amh() || VideoMiddlePageAdView.this.iKo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aS(VideoMiddlePageAdView.this.iKo.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iKn.setText(videoMiddlePageAdCard.tagName);
        this.iKp.setText(videoMiddlePageAdCard.operateData.iIc);
        this.iKq.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iKq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.iKt != null) {
                    VideoMiddlePageAdView.this.iKt.qu(false);
                }
                if (VideoMiddlePageAdView.this.hfO != null) {
                    VideoMiddlePageAdView.this.hfO.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iKo, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iKt = this.iKs.a(videoMiddlePageAdCard.tailFrame, this.iKt);
        if (this.iKt != null) {
            b(this.iKo.getAdFacadeData());
            this.iKt.setPageContext(this.mContext);
            this.iKt.setTimeoutListener(this);
            this.iKt.a(videoMiddlePageAdCard.tailFrame);
            this.iKt.c(this.iKo);
            this.iKt.ciV();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.RA = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.RA;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fTt = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iKu = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bp(View view) {
        this.RA.rS(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bou();
        if (this.fTr != null) {
            this.fTr.clearAnimation();
        }
        if (this.iKk != null) {
            this.iKk.clearAnimation();
        }
    }

    public void bot() {
        this.fAd.stopPlay();
        if (this.fzR != null) {
            this.fzR.setVisibility(0);
        }
        if (this.iKy != null) {
            this.iKy.te(2);
        }
        this.iKw = false;
        this.iKx = true;
    }

    public void bou() {
        if (this.fAd != null) {
            this.fAd.destroy();
        }
        this.iKw = false;
        this.iKx = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fTr && this.fTr.getVisibility() == 0) {
            if (this.fTt != null) {
                this.fTt.ti(this.mPosition);
            }
        } else if (view == this.iKk && this.iKk.getVisibility() == 0) {
            if (this.fTt != null) {
                this.fTt.ti(this.mPosition);
            }
        } else if (view == this.iKm || view == this.iKl) {
            if (this.fTr.getVisibility() == 0) {
                if (this.fTt != null) {
                    this.fTt.ti(this.mPosition);
                    return;
                }
                return;
            }
            this.iKy.te(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.iGW = new WebVideoActivity.a();
            if (this.iKo.getAdFacadeData() != null) {
                WebVideoActivity.iGW.iHg = this.iKo.getAdFacadeData().ph();
                WebVideoActivity.iGW.azs = "DETAIL";
                if (this.iKo.getAdFacadeData().Rm != null) {
                    WebVideoActivity.iGW.mPageNum = this.iKo.getAdFacadeData().Rm.pd();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iKo.getScheme(), true, true, true, this.iKo.video.video_url, this.iKo.video.thumbnail_url, 1.7777778f, this.iKv)));
            if (this.hfO != null) {
                this.hfO.b(0, null);
            }
            if (this.iKt != null) {
                this.iKt.qu(false);
            }
        } else {
            int e = s.e(this.mContext, this.iKo.getScheme());
            if (this.hfO != null) {
                this.hfO.b(e, null);
            }
            if (this.iKt != null) {
                this.iKt.qu(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.mw(this.fAd.getCurrentPosition()) < this.iKv && this.fAd.getCurrentState() == 1) {
            co(this.bOM ? 0 : 1, this.fAd.getCurrentPosition());
        }
        bot();
        this.iKt.qu(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fAd.pausePlay();
            co(this.bOM ? 0 : 1, this.fAd.getCurrentPosition());
            this.iKx = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fAd.pB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zD(int i) {
        if (this.iKo != null && this.iKo.video != null && this.iKo.getAdFacadeData() != null && this.iKx) {
            com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.a(this.iKo.getAdFacadeData(), 31, this.iKo.getAdFacadeData().getPageNum(), i, this.iKv, 0, -1));
            this.iKx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zE(int i) {
        if (this.iKo != null && this.iKo.video != null && this.iKo.getAdFacadeData() != null && !this.iKw) {
            com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.a(this.iKo.getAdFacadeData(), 34, this.iKo.getAdFacadeData().getPageNum(), i, this.iKv, this.iKv, -1));
            this.iKw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        if (this.iKo != null && this.iKo.video != null && this.iKo.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.a(this.iKo.getAdFacadeData(), 36, this.iKo.getAdFacadeData().getPageNum(), i, this.iKv, com.baidu.tieba.ad.a.a.mw(this.fAd.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(int i, int i2) {
        if (this.iKo != null && this.iKo.video != null && this.iKo.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.a(this.iKo.getAdFacadeData(), 32, this.iKo.getAdFacadeData().getPageNum(), i, this.iKv, com.baidu.tieba.ad.a.a.mw(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(int i, int i2) {
        if (this.iKo != null && this.iKo.video != null && this.iKo.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.a(this.iKo.getAdFacadeData(), 33, this.iKo.getAdFacadeData().getPageNum(), i, this.iKv, com.baidu.tieba.ad.a.a.mw(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iKo.getAdFacadeData(), 303, this.iKo.getAdFacadeData().getPageNum(), this.bOM ? 0 : 1, this.iKo.video.video_duration.intValue(), 0, -1);
            if (this.iKt != null) {
                this.iKt.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(boolean z) {
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
        private Runnable fTK = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fTK);
                a.this.te(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void te(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = tf(i);
                    btx();
                    return;
                case 1:
                    this.mCurrentState = tf(i);
                    this.mHandler.removeCallbacks(this.fTK);
                    return;
                case 2:
                    this.mCurrentState = tg(i);
                    return;
                case 3:
                    this.mCurrentState = th(i);
                    btx();
                    return;
                default:
                    this.mCurrentState = tg(i);
                    return;
            }
        }

        private void btx() {
            this.mHandler.removeCallbacks(this.fTK);
            this.mHandler.postDelayed(this.fTK, 3000L);
        }

        private int tf(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iKm.setVisibility(8);
                VideoMiddlePageAdView.this.iKl.setVisibility(8);
                VideoMiddlePageAdView.this.qr(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int tg(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iKm.setVisibility(0);
                VideoMiddlePageAdView.this.iKl.setVisibility(0);
                if (VideoMiddlePageAdView.this.fAd != null) {
                    VideoMiddlePageAdView.this.fAd.cec();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iKo.autoPlay) {
                    VideoMiddlePageAdView.this.qr(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int th(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iKm.setVisibility(0);
                VideoMiddlePageAdView.this.iKl.setVisibility(0);
                VideoMiddlePageAdView.this.qr(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
