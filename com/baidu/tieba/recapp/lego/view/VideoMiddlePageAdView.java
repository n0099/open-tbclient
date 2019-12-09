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
    private com.baidu.tieba.frs.aggregation.a Aw;
    public TextView He;
    private Animation ayN;
    private Animation ayO;
    private boolean cfz;
    private n dvI;
    public FrameLayout fAc;
    public FrameLayout fAd;
    public TextView fAe;
    public HeadImageView fAj;
    public c fAq;
    private View fTF;
    private View fTL;
    private com.baidu.tieba.frs.videomiddlepage.c fTN;
    private VideoNetworkStateTipView fTQ;
    private Animation.AnimationListener fTX;
    private Animation.AnimationListener fTY;
    private View iKI;
    private View iKJ;
    private View iKK;
    public TextView iKL;
    private VideoMiddlePageAdCard iKM;
    private TextView iKN;
    private TextView iKO;
    private ViewGroup iKP;
    private d iKQ;
    private e iKR;
    private f iKS;
    private int iKT;
    private boolean iKU;
    private boolean iKV;
    private a iKW;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iKU = false;
        this.iKV = true;
        this.fTX = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fTL != null) {
                    VideoMiddlePageAdView.this.fTL.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iKI != null) {
                    VideoMiddlePageAdView.this.iKI.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fTL != null) {
                    VideoMiddlePageAdView.this.fTL.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iKI != null) {
                    VideoMiddlePageAdView.this.iKI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fTY = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fTL != null) {
                    VideoMiddlePageAdView.this.fTL.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iKI != null) {
                    VideoMiddlePageAdView.this.iKI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fTL != null) {
                    VideoMiddlePageAdView.this.fTL.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iKI != null) {
                    VideoMiddlePageAdView.this.iKI.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iKU = false;
        this.iKV = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fAc = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fTF = this.rootView.findViewById(R.id.card_container);
        this.fAd = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fAq = new c((TbPageContext<?>) this.ceu, (View) this.fAd, false);
        this.fAq.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.fAq != null && VideoMiddlePageAdView.this.fAq.getVideoView() != null) {
                    VideoMiddlePageAdView.this.iKT = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.fAq.getVideoView().getDuration());
                }
            }
        });
        this.fAq.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kL(boolean z) {
                if (VideoMiddlePageAdView.this.iKW != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iKW.sb(0);
                    } else {
                        VideoMiddlePageAdView.this.iKW.sb(1);
                    }
                }
            }
        });
        this.fAq.hfu.setOnTouchListener(null);
        this.fAe = (TextView) this.rootView.findViewById(R.id.title);
        this.fAj = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.fAj.setIsRound(true);
        this.fAj.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fAj.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fAj.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iKL = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.He = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dvI = new n(this.ceu.getPageActivity());
        this.iKN = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iKO = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iKP = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iKQ = new d(this.ceu.getPageActivity(), this.iKP);
        this.iKQ.page = 1;
        this.fTQ = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fTQ.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fTQ.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fAq.pM(false);
                VideoMiddlePageAdView.this.fTQ.cwf();
                if (VideoMiddlePageAdView.this.iKM != null && VideoMiddlePageAdView.this.iKM.video != null) {
                    VideoMiddlePageAdView.this.fAq.cm(VideoMiddlePageAdView.this.iKM.video.video_url, "");
                }
            }
        });
        this.fTL = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iKJ = this.rootView.findViewById(R.id.user_container_foreground);
        this.iKK = this.rootView.findViewById(R.id.title_foreground);
        this.iKI = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fTL.setOnClickListener(this);
        this.iKJ.setOnClickListener(this);
        this.iKK.setOnClickListener(this);
        this.iKI.setOnClickListener(this);
        this.fAd.setOnClickListener(this);
        this.fAc.setOnClickListener(this);
        this.fAq.Z(this);
        this.fAe.setOnClickListener(this);
        this.fAj.setOnClickListener(this);
        this.He.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.ceu.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fAc.setLayoutParams(layoutParams);
        this.ayN = new AlphaAnimation(0.0f, 0.7f);
        this.ayN.setDuration(500L);
        this.ayN.setAnimationListener(this.fTY);
        this.ayO = new AlphaAnimation(0.7f, 0.0f);
        this.ayO.setDuration(500L);
        this.ayO.setAnimationListener(this.fTX);
        this.rootView.setOnClickListener(this);
        this.iKW = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIe() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cfz = this.iKM.autoPlay;
            this.iKU = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iKT = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fAq.kx()) {
                cf(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fAq.getCurrentPosition());
                this.iKV = true;
            }
            this.fAq.stopPlay();
            this.fAq.setIsNeedRecoveryVideoPlayer(true);
            this.fAq.pN(true);
            this.fAq.pJ(false);
            this.fAq.pO(true);
            this.fAq.ag(false, true);
            this.fAq.xD(i);
            this.fAq.a(new c.InterfaceC0492c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0492c
                public void kv() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0492c
                public void kw() {
                }
            });
            this.fAq.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bmk() {
                    if (VideoMiddlePageAdView.this.iKM != null && VideoMiddlePageAdView.this.iKM.video != null && VideoMiddlePageAdView.this.iKM.video.video_height.intValue() > VideoMiddlePageAdView.this.iKM.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fAq.ag(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fAq.ag(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iKS != null) {
                        VideoMiddlePageAdView.this.iKS.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yl(VideoMiddlePageAdView.this.cfz ? 0 : 1);
                    VideoMiddlePageAdView.this.iKU = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bml() {
                }
            });
            this.fAq.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    VideoMiddlePageAdView.this.fAq.cm(VideoMiddlePageAdView.this.iKM.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iKS != null) {
                        VideoMiddlePageAdView.this.iKS.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.yl(1);
                    VideoMiddlePageAdView.this.iKU = false;
                }
            });
            this.fAq.pF(false);
            this.fAq.getVideoView().setBusiness(this.dvI);
            this.fAq.bIG();
            this.fAq.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fAq.bvK();
                    if (VideoMiddlePageAdView.this.iKR != null) {
                        VideoMiddlePageAdView.this.iKR.cgN();
                    }
                    VideoMiddlePageAdView.this.ym(VideoMiddlePageAdView.this.cfz ? 0 : 1);
                    VideoMiddlePageAdView.this.iKV = true;
                }
            });
            this.fAq.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.yn(VideoMiddlePageAdView.this.cfz ? 0 : 1);
                    return true;
                }
            });
            this.fAq.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fAq.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fAq.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bmn() {
                    VideoMiddlePageAdView.this.cg(1, VideoMiddlePageAdView.this.fAq.getCurrentPosition());
                }
            });
            this.fAq.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cf(1, VideoMiddlePageAdView.this.fAq.getCurrentPosition());
                    VideoMiddlePageAdView.this.iKV = true;
                }
            });
            this.fAq.bvK();
            this.fAq.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fTQ.cdj()) {
                    this.fAq.pL(false);
                    this.fTQ.cwe();
                    this.fAq.pM(true);
                    this.fAq.dE(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fAq.pM(false);
                    this.fAq.pL(false);
                    this.fTQ.hide();
                    this.fAq.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iKR != null) {
                    this.iKR.qg(true);
                }
                if (i == 0) {
                    this.fTL.setVisibility(8);
                    this.iKI.setVisibility(8);
                } else {
                    this.fTL.startAnimation(this.ayO);
                    this.iKI.startAnimation(this.ayO);
                }
                if (i == 0) {
                    this.iKW.sb(3);
                    return;
                } else {
                    this.iKW.sb(0);
                    return;
                }
            }
            this.fTQ.hide();
            this.fAq.pL(true);
            this.iKW.sb(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.fTL.startAnimation(this.ayO);
                this.iKI.startAnimation(this.ayO);
                return;
            }
            this.fTL.setVisibility(0);
            this.iKI.setVisibility(0);
        }
    }

    private boolean brb() {
        try {
            int intValue = this.iKM.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iKM.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fAe.setTextColor(this.ceu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iKL.setTextColor(this.ceu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iKN.setTextColor(this.ceu.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iKO.setTextColor(this.ceu.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.iKO, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void brc() {
        if (!brb()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAc.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fAc.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAc.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fAc.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iKM = videoMiddlePageAdCard;
        brc();
        this.fAe.setText(videoMiddlePageAdCard.threadTitle);
        this.He.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.fAj.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.fAj.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.fAj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aoW() || VideoMiddlePageAdView.this.iKM == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.iKM.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.ceu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iKL.setText(videoMiddlePageAdCard.tagName);
        this.iKN.setText(videoMiddlePageAdCard.operateData.iIy);
        this.iKO.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int a2 = s.a(VideoMiddlePageAdView.this.ceu, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.iKM == null || VideoMiddlePageAdView.this.iKM.getAdFacadeData() == null || VideoMiddlePageAdView.this.iKM.getAdFacadeData().kd() == null) ? null : VideoMiddlePageAdView.this.iKM.getAdFacadeData().kd().bWt);
                if (VideoMiddlePageAdView.this.iKR != null) {
                    VideoMiddlePageAdView.this.iKR.qg(false);
                }
                if (VideoMiddlePageAdView.this.heW != null) {
                    VideoMiddlePageAdView.this.heW.b(a2, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iKM, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iKR = this.iKQ.a(videoMiddlePageAdCard.tailFrame, this.iKR);
        if (this.iKR != null) {
            b(this.iKM.getAdFacadeData());
            this.iKR.setPageContext(this.ceu);
            this.iKR.setTimeoutListener(this);
            this.iKR.a(videoMiddlePageAdCard.tailFrame);
            this.iKR.c(this.iKM);
            this.iKR.cgO();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Aw = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Aw;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fTN = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iKS = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bp(View view) {
        this.Aw.qN(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bmi();
        if (this.fTL != null) {
            this.fTL.clearAnimation();
        }
        if (this.iKI != null) {
            this.iKI.clearAnimation();
        }
    }

    public void bmh() {
        this.fAq.stopPlay();
        if (this.fAe != null) {
            this.fAe.setVisibility(0);
        }
        if (this.iKW != null) {
            this.iKW.sb(2);
        }
        this.iKU = false;
        this.iKV = true;
    }

    public void bmi() {
        if (this.fAq != null) {
            this.fAq.destroy();
        }
        this.iKU = false;
        this.iKV = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fTL && this.fTL.getVisibility() == 0) {
            if (this.fTN != null) {
                this.fTN.sf(this.mPosition);
            }
        } else if (view == this.iKI && this.iKI.getVisibility() == 0) {
            if (this.fTN != null) {
                this.fTN.sf(this.mPosition);
            }
        } else if (view == this.iKK || view == this.iKJ) {
            if (this.fTL.getVisibility() == 0) {
                if (this.fTN != null) {
                    this.fTN.sf(this.mPosition);
                    return;
                }
                return;
            }
            this.iKW.sb(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.iHn = new WebVideoActivity.a();
            if (this.iKM.getAdFacadeData() != null) {
                WebVideoActivity.iHn.iHx = this.iKM.getAdFacadeData().kd();
                WebVideoActivity.iHn.aSM = "DETAIL";
                if (this.iKM.getAdFacadeData().Ai != null) {
                    WebVideoActivity.iHn.mPageNum = this.iKM.getAdFacadeData().Ai.jZ();
                }
            }
            if (com.baidu.tieba.a.aAM().aAN() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.ceu.getPageActivity(), "", this.iKM.getScheme(), true, true, true, this.iKM.video.video_url, this.iKM.video.thumbnail_url, 1.7777778f, this.iKT, this.iKM.getAdFacadeData().kd().bWt)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.ceu.getPageActivity(), "", this.iKM.getScheme(), true, true, true, this.iKM.video.video_url, this.iKM.video.thumbnail_url, 1.7777778f, this.iKT)));
            }
            if (this.heW != null) {
                this.heW.b(0, null);
            }
            if (this.iKR != null) {
                this.iKR.qg(false);
            }
        } else {
            String str = null;
            if (this.iKM.getAdFacadeData() != null && this.iKM.getAdFacadeData().kd() != null) {
                str = this.iKM.getAdFacadeData().kd().bWt;
            }
            int a2 = s.a(this.ceu, this.iKM.getScheme(), str);
            if (this.heW != null) {
                this.heW.b(a2, null);
            }
            if (this.iKR != null) {
                this.iKR.qg(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.lE(this.fAq.getCurrentPosition()) < this.iKT && this.fAq.getCurrentState() == 1) {
            cf(this.cfz ? 0 : 1, this.fAq.getCurrentPosition());
        }
        bmh();
        this.iKR.qg(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fAq.pausePlay();
            cf(this.cfz ? 0 : 1, this.fAq.getCurrentPosition());
            this.iKV = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fAq.kx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        if (this.iKM != null && this.iKM.video != null && this.iKM.getAdFacadeData() != null && this.iKV) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(this.iKM.getAdFacadeData(), 31, this.iKM.getAdFacadeData().getPageNum(), i, this.iKT, 0, -1));
            this.iKV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(int i) {
        if (this.iKM != null && this.iKM.video != null && this.iKM.getAdFacadeData() != null && !this.iKU) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(this.iKM.getAdFacadeData(), 34, this.iKM.getAdFacadeData().getPageNum(), i, this.iKT, this.iKT, -1));
            this.iKU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(int i) {
        if (this.iKM != null && this.iKM.video != null && this.iKM.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(this.iKM.getAdFacadeData(), 36, this.iKM.getAdFacadeData().getPageNum(), i, this.iKT, com.baidu.tieba.ad.a.a.lE(this.fAq.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(int i, int i2) {
        if (this.iKM != null && this.iKM.video != null && this.iKM.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(this.iKM.getAdFacadeData(), 32, this.iKM.getAdFacadeData().getPageNum(), i, this.iKT, com.baidu.tieba.ad.a.a.lE(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(int i, int i2) {
        if (this.iKM != null && this.iKM.video != null && this.iKM.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(this.iKM.getAdFacadeData(), 33, this.iKM.getAdFacadeData().getPageNum(), i, this.iKT, com.baidu.tieba.ad.a.a.lE(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iKM.getAdFacadeData(), 303, this.iKM.getAdFacadeData().getPageNum(), this.cfz ? 0 : 1, this.iKM.video.video_duration.intValue(), 0, -1);
            if (this.iKR != null) {
                this.iKR.e(a2);
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
        private Runnable fUe = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fUe);
                a.this.sb(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void sb(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sc(i);
                    brm();
                    return;
                case 1:
                    this.mCurrentState = sc(i);
                    this.mHandler.removeCallbacks(this.fUe);
                    return;
                case 2:
                    this.mCurrentState = sd(i);
                    return;
                case 3:
                    this.mCurrentState = se(i);
                    brm();
                    return;
                default:
                    this.mCurrentState = sd(i);
                    return;
            }
        }

        private void brm() {
            this.mHandler.removeCallbacks(this.fUe);
            this.mHandler.postDelayed(this.fUe, 3000L);
        }

        private int sc(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iKK.setVisibility(8);
                VideoMiddlePageAdView.this.iKJ.setVisibility(8);
                VideoMiddlePageAdView.this.qc(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sd(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iKK.setVisibility(0);
                VideoMiddlePageAdView.this.iKJ.setVisibility(0);
                if (VideoMiddlePageAdView.this.fAq != null) {
                    VideoMiddlePageAdView.this.fAq.cbS();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iKM.autoPlay) {
                    VideoMiddlePageAdView.this.qc(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int se(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iKK.setVisibility(0);
                VideoMiddlePageAdView.this.iKJ.setVisibility(0);
                VideoMiddlePageAdView.this.qc(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
