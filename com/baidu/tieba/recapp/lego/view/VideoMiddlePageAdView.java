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
    private com.baidu.tieba.frs.aggregation.a Ri;
    public TextView Xq;
    private Animation afk;
    private Animation afl;
    private boolean bNG;
    private n dlO;
    public HeadImageView ebk;
    private View fNE;
    private c fNG;
    private VideoNetworkStateTipView fNJ;
    private Animation.AnimationListener fNQ;
    private Animation.AnimationListener fNR;
    private View fNy;
    public FrameLayout fuf;
    public FrameLayout fug;
    public TextView fuh;
    public com.baidu.tieba.play.c fut;
    private View iCO;
    private View iCP;
    private View iCQ;
    public TextView iCR;
    private VideoMiddlePageAdCard iCS;
    private TextView iCT;
    private TextView iCU;
    private ViewGroup iCV;
    private d iCW;
    private e iCX;
    private f iCY;
    private int iCZ;
    private boolean iDa;
    private boolean iDb;
    private a iDc;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iDa = false;
        this.iDb = true;
        this.fNQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fNE != null) {
                    VideoMiddlePageAdView.this.fNE.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iCO != null) {
                    VideoMiddlePageAdView.this.iCO.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fNE != null) {
                    VideoMiddlePageAdView.this.fNE.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iCO != null) {
                    VideoMiddlePageAdView.this.iCO.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNR = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fNE != null) {
                    VideoMiddlePageAdView.this.fNE.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iCO != null) {
                    VideoMiddlePageAdView.this.iCO.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fNE != null) {
                    VideoMiddlePageAdView.this.fNE.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iCO != null) {
                    VideoMiddlePageAdView.this.iCO.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iDa = false;
        this.iDb = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fuf = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fNy = this.rootView.findViewById(R.id.card_container);
        this.fug = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fut = new com.baidu.tieba.play.c((TbPageContext<?>) this.mContext, (View) this.fug, false);
        this.fut.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                VideoMiddlePageAdView.this.iCZ = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fut.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kL(boolean z) {
                if (VideoMiddlePageAdView.this.iDc != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iDc.sK(0);
                    } else {
                        VideoMiddlePageAdView.this.iDc.sK(1);
                    }
                }
            }
        });
        this.fut.gZi.setOnTouchListener(null);
        this.fuh = (TextView) this.rootView.findViewById(R.id.title);
        this.ebk = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.ebk.setIsRound(true);
        this.ebk.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ebk.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ebk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iCR = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Xq = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dlO = new n(this.mContext.getPageActivity());
        this.iCT = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iCU = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iCV = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iCW = new d(this.mContext.getPageActivity(), this.iCV);
        this.iCW.page = 1;
        this.fNJ = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fNJ.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fNJ.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fut.pM(false);
                VideoMiddlePageAdView.this.fNJ.cus();
                if (VideoMiddlePageAdView.this.iCS != null && VideoMiddlePageAdView.this.iCS.video != null) {
                    VideoMiddlePageAdView.this.fut.cr(VideoMiddlePageAdView.this.iCS.video.video_url, "");
                }
            }
        });
        this.fNE = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iCP = this.rootView.findViewById(R.id.user_container_foreground);
        this.iCQ = this.rootView.findViewById(R.id.title_foreground);
        this.iCO = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fNE.setOnClickListener(this);
        this.iCP.setOnClickListener(this);
        this.iCQ.setOnClickListener(this);
        this.iCO.setOnClickListener(this);
        this.fug.setOnClickListener(this);
        this.fuf.setOnClickListener(this);
        this.fut.W(this);
        this.fuh.setOnClickListener(this);
        this.ebk.setOnClickListener(this);
        this.Xq.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fuf.setLayoutParams(layoutParams);
        this.afk = new AlphaAnimation(0.0f, 0.7f);
        this.afk.setDuration(500L);
        this.afk.setAnimationListener(this.fNR);
        this.afl = new AlphaAnimation(0.7f, 0.0f);
        this.afl.setDuration(500L);
        this.afl.setAnimationListener(this.fNQ);
        this.rootView.setOnClickListener(this);
        this.iDc = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHO() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bNG = this.iCS.autoPlay;
            this.iDa = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iCZ = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fut.pg()) {
                ci(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fut.getCurrentPosition());
                this.iDb = true;
            }
            this.fut.stopPlay();
            this.fut.setIsNeedRecoveryVideoPlayer(true);
            this.fut.pN(true);
            this.fut.pJ(false);
            this.fut.pO(true);
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
                    if (VideoMiddlePageAdView.this.iCS != null && VideoMiddlePageAdView.this.iCS.video != null && VideoMiddlePageAdView.this.iCS.video.video_height.intValue() > VideoMiddlePageAdView.this.iCS.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fut.ad(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fut.ad(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iCY != null) {
                        VideoMiddlePageAdView.this.iCY.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yW(VideoMiddlePageAdView.this.bNG ? 0 : 1);
                    VideoMiddlePageAdView.this.iDa = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmj() {
                }
            });
            this.fut.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    VideoMiddlePageAdView.this.fut.cr(VideoMiddlePageAdView.this.iCS.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iCY != null) {
                        VideoMiddlePageAdView.this.iCY.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yW(1);
                    VideoMiddlePageAdView.this.iDa = false;
                }
            });
            this.fut.pF(false);
            this.fut.getVideoView().setBusiness(this.dlO);
            this.fut.bIr();
            this.fut.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fut.bvu();
                    if (VideoMiddlePageAdView.this.iCX != null) {
                        VideoMiddlePageAdView.this.iCX.cfL();
                    }
                    VideoMiddlePageAdView.this.yX(VideoMiddlePageAdView.this.bNG ? 0 : 1);
                    VideoMiddlePageAdView.this.iDb = true;
                }
            });
            this.fut.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.yY(VideoMiddlePageAdView.this.bNG ? 0 : 1);
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
                    VideoMiddlePageAdView.this.iDb = true;
                }
            });
            this.fut.bvu();
            this.fut.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fNJ.ccp()) {
                    this.fut.pL(false);
                    this.fNJ.cur();
                    this.fut.pM(true);
                    this.fut.dP(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fut.pM(false);
                    this.fut.pL(false);
                    this.fNJ.hide();
                    this.fut.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iCX != null) {
                    this.iCX.qe(true);
                }
                if (i == 0) {
                    this.fNE.setVisibility(8);
                    this.iCO.setVisibility(8);
                } else {
                    this.fNE.startAnimation(this.afl);
                    this.iCO.startAnimation(this.afl);
                }
                if (i == 0) {
                    this.iDc.sK(3);
                    return;
                } else {
                    this.iDc.sK(0);
                    return;
                }
            }
            this.fNJ.hide();
            this.fut.pL(true);
            this.iDc.sK(3);
            if (com.baidu.adp.lib.util.j.jU() && videoMiddlePageAdCard.waitConfirm) {
                this.fNE.startAnimation(this.afl);
                this.iCO.startAnimation(this.afl);
                return;
            }
            this.fNE.setVisibility(0);
            this.iCO.setVisibility(0);
        }
    }

    private boolean bqY() {
        try {
            int intValue = this.iCS.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iCS.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fuh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCT.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iCU.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        al.k(this.iCU, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bqZ() {
        if (!bqY()) {
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
        this.iCS = videoMiddlePageAdCard;
        bqZ();
        this.fuh.setText(videoMiddlePageAdCard.threadTitle);
        this.Xq.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.ebk.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.ebk.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.ebk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.ala() || VideoMiddlePageAdView.this.iCS == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aR(VideoMiddlePageAdView.this.iCS.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iCR.setText(videoMiddlePageAdCard.tagName);
        this.iCT.setText(videoMiddlePageAdCard.operateData.iAG);
        this.iCU.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.iCX != null) {
                    VideoMiddlePageAdView.this.iCX.qe(false);
                }
                if (VideoMiddlePageAdView.this.gYK != null) {
                    VideoMiddlePageAdView.this.gYK.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iCS, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iCX = this.iCW.a(videoMiddlePageAdCard.tailFrame, this.iCX);
        if (this.iCX != null) {
            b(this.iCS.getAdFacadeData());
            this.iCX.setPageContext(this.mContext);
            this.iCX.setTimeoutListener(this);
            this.iCX.a(videoMiddlePageAdCard.tailFrame);
            this.iCX.c(this.iCS);
            this.iCX.cfM();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Ri = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Ri;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fNG = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iCY = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bn(View view) {
        this.Ri.ry(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bmg();
        if (this.fNE != null) {
            this.fNE.clearAnimation();
        }
        if (this.iCO != null) {
            this.iCO.clearAnimation();
        }
    }

    public void bmf() {
        this.fut.stopPlay();
        if (this.fuh != null) {
            this.fuh.setVisibility(0);
        }
        if (this.iDc != null) {
            this.iDc.sK(2);
        }
        this.iDa = false;
        this.iDb = true;
    }

    public void bmg() {
        if (this.fut != null) {
            this.fut.destroy();
        }
        this.iDa = false;
        this.iDb = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fNE && this.fNE.getVisibility() == 0) {
            if (this.fNG != null) {
                this.fNG.sO(this.mPosition);
            }
        } else if (view == this.iCO && this.iCO.getVisibility() == 0) {
            if (this.fNG != null) {
                this.fNG.sO(this.mPosition);
            }
        } else if (view == this.iCQ || view == this.iCP) {
            if (this.fNE.getVisibility() == 0) {
                if (this.fNG != null) {
                    this.fNG.sO(this.mPosition);
                    return;
                }
                return;
            }
            this.iDc.sK(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.izA = new WebVideoActivity.a();
            if (this.iCS.getAdFacadeData() != null) {
                WebVideoActivity.izA.izK = this.iCS.getAdFacadeData().oM();
                WebVideoActivity.izA.ayL = "DETAIL";
                if (this.iCS.getAdFacadeData().QU != null) {
                    WebVideoActivity.izA.mPageNum = this.iCS.getAdFacadeData().QU.oI();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iCS.getScheme(), true, true, true, this.iCS.video.video_url, this.iCS.video.thumbnail_url, 1.7777778f, this.iCZ)));
            if (this.gYK != null) {
                this.gYK.b(0, null);
            }
            if (this.iCX != null) {
                this.iCX.qe(false);
            }
        } else {
            int e = s.e(this.mContext, this.iCS.getScheme());
            if (this.gYK != null) {
                this.gYK.b(e, null);
            }
            if (this.iCX != null) {
                this.iCX.qe(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.mo(this.fut.getCurrentPosition()) < this.iCZ && this.fut.getCurrentState() == 1) {
            ci(this.bNG ? 0 : 1, this.fut.getCurrentPosition());
        }
        bmf();
        this.iCX.qe(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fut.pausePlay();
            ci(this.bNG ? 0 : 1, this.fut.getCurrentPosition());
            this.iDb = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fut.pg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yW(int i) {
        if (this.iCS != null && this.iCS.video != null && this.iCS.getAdFacadeData() != null && this.iDb) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(this.iCS.getAdFacadeData(), 31, this.iCS.getAdFacadeData().getPageNum(), i, this.iCZ, 0, -1));
            this.iDb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX(int i) {
        if (this.iCS != null && this.iCS.video != null && this.iCS.getAdFacadeData() != null && !this.iDa) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(this.iCS.getAdFacadeData(), 34, this.iCS.getAdFacadeData().getPageNum(), i, this.iCZ, this.iCZ, -1));
            this.iDa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY(int i) {
        if (this.iCS != null && this.iCS.video != null && this.iCS.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(this.iCS.getAdFacadeData(), 36, this.iCS.getAdFacadeData().getPageNum(), i, this.iCZ, com.baidu.tieba.ad.a.a.mo(this.fut.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(int i, int i2) {
        if (this.iCS != null && this.iCS.video != null && this.iCS.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(this.iCS.getAdFacadeData(), 32, this.iCS.getAdFacadeData().getPageNum(), i, this.iCZ, com.baidu.tieba.ad.a.a.mo(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(int i, int i2) {
        if (this.iCS != null && this.iCS.video != null && this.iCS.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(this.iCS.getAdFacadeData(), 33, this.iCS.getAdFacadeData().getPageNum(), i, this.iCZ, com.baidu.tieba.ad.a.a.mo(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iCS.getAdFacadeData(), 303, this.iCS.getAdFacadeData().getPageNum(), this.bNG ? 0 : 1, this.iCS.video.video_duration.intValue(), 0, -1);
            if (this.iCX != null) {
                this.iCX.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qb(boolean z) {
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
        private Runnable fNX = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fNX);
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
                    brj();
                    return;
                case 1:
                    this.mCurrentState = sL(i);
                    this.mHandler.removeCallbacks(this.fNX);
                    return;
                case 2:
                    this.mCurrentState = sM(i);
                    return;
                case 3:
                    this.mCurrentState = sN(i);
                    brj();
                    return;
                default:
                    this.mCurrentState = sM(i);
                    return;
            }
        }

        private void brj() {
            this.mHandler.removeCallbacks(this.fNX);
            this.mHandler.postDelayed(this.fNX, 3000L);
        }

        private int sL(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCQ.setVisibility(8);
                VideoMiddlePageAdView.this.iCP.setVisibility(8);
                VideoMiddlePageAdView.this.qb(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sM(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCQ.setVisibility(0);
                VideoMiddlePageAdView.this.iCP.setVisibility(0);
                if (VideoMiddlePageAdView.this.fut != null) {
                    VideoMiddlePageAdView.this.fut.caV();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iCS.autoPlay) {
                    VideoMiddlePageAdView.this.qb(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sN(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iCQ.setVisibility(0);
                VideoMiddlePageAdView.this.iCP.setVisibility(0);
                VideoMiddlePageAdView.this.qb(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
