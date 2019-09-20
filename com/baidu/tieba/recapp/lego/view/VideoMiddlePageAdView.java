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
    private com.baidu.tieba.frs.aggregation.a Rz;
    public TextView XK;
    private Animation afH;
    private Animation afI;
    private boolean bPn;
    private n dpp;
    public HeadImageView ehx;
    public FrameLayout fBC;
    public FrameLayout fBD;
    public TextView fBE;
    public c fBQ;
    private View fVc;
    private View fVi;
    private com.baidu.tieba.frs.videomiddlepage.c fVk;
    private VideoNetworkStateTipView fVn;
    private Animation.AnimationListener fVu;
    private Animation.AnimationListener fVv;
    private View iMG;
    private View iMH;
    private View iMI;
    public TextView iMJ;
    private VideoMiddlePageAdCard iMK;
    private TextView iML;
    private TextView iMM;
    private ViewGroup iMN;
    private d iMO;
    private e iMP;
    private f iMQ;
    private int iMR;
    private boolean iMS;
    private boolean iMT;
    private a iMU;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iMS = false;
        this.iMT = true;
        this.fVu = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fVi != null) {
                    VideoMiddlePageAdView.this.fVi.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iMG != null) {
                    VideoMiddlePageAdView.this.iMG.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fVi != null) {
                    VideoMiddlePageAdView.this.fVi.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iMG != null) {
                    VideoMiddlePageAdView.this.iMG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fVv = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fVi != null) {
                    VideoMiddlePageAdView.this.fVi.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iMG != null) {
                    VideoMiddlePageAdView.this.iMG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fVi != null) {
                    VideoMiddlePageAdView.this.fVi.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iMG != null) {
                    VideoMiddlePageAdView.this.iMG.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iMS = false;
        this.iMT = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fBC = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fVc = this.rootView.findViewById(R.id.card_container);
        this.fBD = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fBQ = new c((TbPageContext<?>) this.mContext, (View) this.fBD, false);
        this.fBQ.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.fBQ != null && VideoMiddlePageAdView.this.fBQ.getVideoView() != null) {
                    VideoMiddlePageAdView.this.iMR = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.fBQ.getVideoView().getDuration());
                }
            }
        });
        this.fBQ.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kY(boolean z) {
                if (VideoMiddlePageAdView.this.iMU != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iMU.ti(0);
                    } else {
                        VideoMiddlePageAdView.this.iMU.ti(1);
                    }
                }
            }
        });
        this.fBQ.hih.setOnTouchListener(null);
        this.fBE = (TextView) this.rootView.findViewById(R.id.title);
        this.ehx = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.ehx.setIsRound(true);
        this.ehx.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ehx.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ehx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iMJ = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.XK = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dpp = new n(this.mContext.getPageActivity());
        this.iML = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iMM = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iMN = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iMO = new d(this.mContext.getPageActivity(), this.iMN);
        this.iMO.page = 1;
        this.fVn = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fVn.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fVn.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fBQ.qe(false);
                VideoMiddlePageAdView.this.fVn.cyr();
                if (VideoMiddlePageAdView.this.iMK != null && VideoMiddlePageAdView.this.iMK.video != null) {
                    VideoMiddlePageAdView.this.fBQ.ct(VideoMiddlePageAdView.this.iMK.video.video_url, "");
                }
            }
        });
        this.fVi = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iMH = this.rootView.findViewById(R.id.user_container_foreground);
        this.iMI = this.rootView.findViewById(R.id.title_foreground);
        this.iMG = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fVi.setOnClickListener(this);
        this.iMH.setOnClickListener(this);
        this.iMI.setOnClickListener(this);
        this.iMG.setOnClickListener(this);
        this.fBD.setOnClickListener(this);
        this.fBC.setOnClickListener(this);
        this.fBQ.Y(this);
        this.fBE.setOnClickListener(this);
        this.ehx.setOnClickListener(this);
        this.XK.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBC.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fBC.setLayoutParams(layoutParams);
        this.afH = new AlphaAnimation(0.0f, 0.7f);
        this.afH.setDuration(500L);
        this.afH.setAnimationListener(this.fVv);
        this.afI = new AlphaAnimation(0.7f, 0.0f);
        this.afI.setDuration(500L);
        this.afI.setAnimationListener(this.fVu);
        this.rootView.setOnClickListener(this);
        this.iMU = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bLw() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bPn = this.iMK.autoPlay;
            this.iMS = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iMR = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fBQ.pC()) {
                co(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fBQ.getCurrentPosition());
                this.iMT = true;
            }
            this.fBQ.stopPlay();
            this.fBQ.setIsNeedRecoveryVideoPlayer(true);
            this.fBQ.qf(true);
            this.fBQ.qb(false);
            this.fBQ.qg(true);
            this.fBQ.ae(false, true);
            this.fBQ.yZ(i);
            this.fBQ.a(new c.InterfaceC0403c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pA() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pB() {
                }
            });
            this.fBQ.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bph() {
                    if (VideoMiddlePageAdView.this.iMK != null && VideoMiddlePageAdView.this.iMK.video != null && VideoMiddlePageAdView.this.iMK.video.video_height.intValue() > VideoMiddlePageAdView.this.iMK.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fBQ.ae(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fBQ.ae(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iMQ != null) {
                        VideoMiddlePageAdView.this.iMQ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.zG(VideoMiddlePageAdView.this.bPn ? 0 : 1);
                    VideoMiddlePageAdView.this.iMS = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bpi() {
                }
            });
            this.fBQ.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void ku(boolean z) {
                    VideoMiddlePageAdView.this.fBQ.ct(VideoMiddlePageAdView.this.iMK.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iMQ != null) {
                        VideoMiddlePageAdView.this.iMQ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.zG(1);
                    VideoMiddlePageAdView.this.iMS = false;
                }
            });
            this.fBQ.pX(false);
            this.fBQ.getVideoView().setBusiness(this.dpp);
            this.fBQ.bLZ();
            this.fBQ.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fBQ.bzb();
                    if (VideoMiddlePageAdView.this.iMP != null) {
                        VideoMiddlePageAdView.this.iMP.cjI();
                    }
                    VideoMiddlePageAdView.this.zH(VideoMiddlePageAdView.this.bPn ? 0 : 1);
                    VideoMiddlePageAdView.this.iMT = true;
                }
            });
            this.fBQ.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.zI(VideoMiddlePageAdView.this.bPn ? 0 : 1);
                    return true;
                }
            });
            this.fBQ.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fBQ.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fBQ.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bpk() {
                    VideoMiddlePageAdView.this.cp(1, VideoMiddlePageAdView.this.fBQ.getCurrentPosition());
                }
            });
            this.fBQ.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.co(1, VideoMiddlePageAdView.this.fBQ.getCurrentPosition());
                    VideoMiddlePageAdView.this.iMT = true;
                }
            });
            this.fBQ.bzb();
            this.fBQ.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fVn.cgl()) {
                    this.fBQ.qd(false);
                    this.fVn.cyq();
                    this.fBQ.qe(true);
                    this.fBQ.dS(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fBQ.qe(false);
                    this.fBQ.qd(false);
                    this.fVn.hide();
                    this.fBQ.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iMP != null) {
                    this.iMP.qx(true);
                }
                if (i == 0) {
                    this.fVi.setVisibility(8);
                    this.iMG.setVisibility(8);
                } else {
                    this.fVi.startAnimation(this.afI);
                    this.iMG.startAnimation(this.afI);
                }
                if (i == 0) {
                    this.iMU.ti(3);
                    return;
                } else {
                    this.iMU.ti(0);
                    return;
                }
            }
            this.fVn.hide();
            this.fBQ.qd(true);
            this.iMU.ti(3);
            if (com.baidu.adp.lib.util.j.ke() && videoMiddlePageAdCard.waitConfirm) {
                this.fVi.startAnimation(this.afI);
                this.iMG.startAnimation(this.afI);
                return;
            }
            this.fVi.setVisibility(0);
            this.iMG.setVisibility(0);
        }
    }

    private boolean bua() {
        try {
            int intValue = this.iMK.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iMK.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fBE.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iMJ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iML.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iMM.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.k(this.iMM, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bub() {
        if (!bua()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBC.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fBC.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fBC.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fBC.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iMK = videoMiddlePageAdCard;
        bub();
        this.fBE.setText(videoMiddlePageAdCard.threadTitle);
        this.XK.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.ehx.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.ehx.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.ehx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.amt() || VideoMiddlePageAdView.this.iMK == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aS(VideoMiddlePageAdView.this.iMK.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iMJ.setText(videoMiddlePageAdCard.tagName);
        this.iML.setText(videoMiddlePageAdCard.operateData.iKy);
        this.iMM.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int a2 = s.a(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.iMK == null || VideoMiddlePageAdView.this.iMK.getAdFacadeData() == null || VideoMiddlePageAdView.this.iMK.getAdFacadeData().pi() == null) ? null : VideoMiddlePageAdView.this.iMK.getAdFacadeData().pi().bFs);
                if (VideoMiddlePageAdView.this.iMP != null) {
                    VideoMiddlePageAdView.this.iMP.qx(false);
                }
                if (VideoMiddlePageAdView.this.hhI != null) {
                    VideoMiddlePageAdView.this.hhI.b(a2, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iMK, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iMP = this.iMO.a(videoMiddlePageAdCard.tailFrame, this.iMP);
        if (this.iMP != null) {
            b(this.iMK.getAdFacadeData());
            this.iMP.setPageContext(this.mContext);
            this.iMP.setTimeoutListener(this);
            this.iMP.a(videoMiddlePageAdCard.tailFrame);
            this.iMP.c(this.iMK);
            this.iMP.cjJ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Rz = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Rz;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fVk = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iMQ = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bp(View view) {
        this.Rz.rV(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bpf();
        if (this.fVi != null) {
            this.fVi.clearAnimation();
        }
        if (this.iMG != null) {
            this.iMG.clearAnimation();
        }
    }

    public void bpe() {
        this.fBQ.stopPlay();
        if (this.fBE != null) {
            this.fBE.setVisibility(0);
        }
        if (this.iMU != null) {
            this.iMU.ti(2);
        }
        this.iMS = false;
        this.iMT = true;
    }

    public void bpf() {
        if (this.fBQ != null) {
            this.fBQ.destroy();
        }
        this.iMS = false;
        this.iMT = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fVi && this.fVi.getVisibility() == 0) {
            if (this.fVk != null) {
                this.fVk.tm(this.mPosition);
            }
        } else if (view == this.iMG && this.iMG.getVisibility() == 0) {
            if (this.fVk != null) {
                this.fVk.tm(this.mPosition);
            }
        } else if (view == this.iMI || view == this.iMH) {
            if (this.fVi.getVisibility() == 0) {
                if (this.fVk != null) {
                    this.fVk.tm(this.mPosition);
                    return;
                }
                return;
            }
            this.iMU.ti(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.iJn = new WebVideoActivity.a();
            if (this.iMK.getAdFacadeData() != null) {
                WebVideoActivity.iJn.iJx = this.iMK.getAdFacadeData().pi();
                WebVideoActivity.iJn.azQ = "DETAIL";
                if (this.iMK.getAdFacadeData().Rl != null) {
                    WebVideoActivity.iJn.mPageNum = this.iMK.getAdFacadeData().Rl.pe();
                }
            }
            if (com.baidu.tieba.a.aAF().aAG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewWebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iMK.getScheme(), true, true, true, this.iMK.video.video_url, this.iMK.video.thumbnail_url, 1.7777778f, this.iMR, this.iMK.getAdFacadeData().pi().bFs)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iMK.getScheme(), true, true, true, this.iMK.video.video_url, this.iMK.video.thumbnail_url, 1.7777778f, this.iMR)));
            }
            if (this.hhI != null) {
                this.hhI.b(0, null);
            }
            if (this.iMP != null) {
                this.iMP.qx(false);
            }
        } else {
            String str = null;
            if (this.iMK.getAdFacadeData() != null && this.iMK.getAdFacadeData().pi() != null) {
                str = this.iMK.getAdFacadeData().pi().bFs;
            }
            int a2 = s.a(this.mContext, this.iMK.getScheme(), str);
            if (this.hhI != null) {
                this.hhI.b(a2, null);
            }
            if (this.iMP != null) {
                this.iMP.qx(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.mA(this.fBQ.getCurrentPosition()) < this.iMR && this.fBQ.getCurrentState() == 1) {
            co(this.bPn ? 0 : 1, this.fBQ.getCurrentPosition());
        }
        bpe();
        this.iMP.qx(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fBQ.pausePlay();
            co(this.bPn ? 0 : 1, this.fBQ.getCurrentPosition());
            this.iMT = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fBQ.pC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(int i) {
        if (this.iMK != null && this.iMK.video != null && this.iMK.getAdFacadeData() != null && this.iMT) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(this.iMK.getAdFacadeData(), 31, this.iMK.getAdFacadeData().getPageNum(), i, this.iMR, 0, -1));
            this.iMT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zH(int i) {
        if (this.iMK != null && this.iMK.video != null && this.iMK.getAdFacadeData() != null && !this.iMS) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(this.iMK.getAdFacadeData(), 34, this.iMK.getAdFacadeData().getPageNum(), i, this.iMR, this.iMR, -1));
            this.iMS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zI(int i) {
        if (this.iMK != null && this.iMK.video != null && this.iMK.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(this.iMK.getAdFacadeData(), 36, this.iMK.getAdFacadeData().getPageNum(), i, this.iMR, com.baidu.tieba.ad.a.a.mA(this.fBQ.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(int i, int i2) {
        if (this.iMK != null && this.iMK.video != null && this.iMK.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(this.iMK.getAdFacadeData(), 32, this.iMK.getAdFacadeData().getPageNum(), i, this.iMR, com.baidu.tieba.ad.a.a.mA(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(int i, int i2) {
        if (this.iMK != null && this.iMK.video != null && this.iMK.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(this.iMK.getAdFacadeData(), 33, this.iMK.getAdFacadeData().getPageNum(), i, this.iMR, com.baidu.tieba.ad.a.a.mA(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iMK.getAdFacadeData(), 303, this.iMK.getAdFacadeData().getPageNum(), this.bPn ? 0 : 1, this.iMK.video.video_duration.intValue(), 0, -1);
            if (this.iMP != null) {
                this.iMP.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu(boolean z) {
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
        private Runnable fVB = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fVB);
                a.this.ti(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void ti(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = tj(i);
                    bul();
                    return;
                case 1:
                    this.mCurrentState = tj(i);
                    this.mHandler.removeCallbacks(this.fVB);
                    return;
                case 2:
                    this.mCurrentState = tk(i);
                    return;
                case 3:
                    this.mCurrentState = tl(i);
                    bul();
                    return;
                default:
                    this.mCurrentState = tk(i);
                    return;
            }
        }

        private void bul() {
            this.mHandler.removeCallbacks(this.fVB);
            this.mHandler.postDelayed(this.fVB, 3000L);
        }

        private int tj(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iMI.setVisibility(8);
                VideoMiddlePageAdView.this.iMH.setVisibility(8);
                VideoMiddlePageAdView.this.qu(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int tk(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iMI.setVisibility(0);
                VideoMiddlePageAdView.this.iMH.setVisibility(0);
                if (VideoMiddlePageAdView.this.fBQ != null) {
                    VideoMiddlePageAdView.this.fBQ.ceS();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iMK.autoPlay) {
                    VideoMiddlePageAdView.this.qu(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int tl(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iMI.setVisibility(0);
                VideoMiddlePageAdView.this.iMH.setVisibility(0);
                VideoMiddlePageAdView.this.qu(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
