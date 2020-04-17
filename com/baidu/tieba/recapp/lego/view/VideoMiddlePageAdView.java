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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes13.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a WV;
    public TextView afW;
    private Animation bht;
    private Animation bhu;
    private boolean dvK;
    private n ePc;
    public FrameLayout hdL;
    public FrameLayout hdM;
    public TextView hdN;
    public HeadImageView hdS;
    public c hdZ;
    private View hyK;
    private View hyQ;
    private com.baidu.tieba.frs.videomiddlepage.c hyS;
    private VideoNetworkStateTipView hyV;
    private Animation.AnimationListener hzc;
    private Animation.AnimationListener hzd;
    private View kuO;
    private View kuP;
    private View kuQ;
    public TextView kuR;
    private VideoMiddlePageAdCard kuS;
    private TextView kuT;
    private TextView kuU;
    private ViewGroup kuV;
    private d kuW;
    private e kuX;
    private f kuY;
    private int kuZ;
    private boolean kva;
    private boolean kvb;
    private a kvc;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kva = false;
        this.kvb = true;
        this.hzc = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hyQ != null) {
                    VideoMiddlePageAdView.this.hyQ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kuO != null) {
                    VideoMiddlePageAdView.this.kuO.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hyQ != null) {
                    VideoMiddlePageAdView.this.hyQ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kuO != null) {
                    VideoMiddlePageAdView.this.kuO.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hzd = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hyQ != null) {
                    VideoMiddlePageAdView.this.hyQ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kuO != null) {
                    VideoMiddlePageAdView.this.kuO.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hyQ != null) {
                    VideoMiddlePageAdView.this.hyQ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kuO != null) {
                    VideoMiddlePageAdView.this.kuO.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kva = false;
        this.kvb = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hdL = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.hyK = this.rootView.findViewById(R.id.card_container);
        this.hdM = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hdZ = new c(this.duG, this.hdM, false);
        this.hdZ.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.hdZ != null && VideoMiddlePageAdView.this.hdZ.getVideoView() != null) {
                    VideoMiddlePageAdView.this.kuZ = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hdZ.getVideoView().getDuration());
                }
            }
        });
        this.hdZ.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void nv(boolean z) {
                if (VideoMiddlePageAdView.this.kvc != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.kvc.uZ(0);
                    } else {
                        VideoMiddlePageAdView.this.kvc.uZ(1);
                    }
                }
            }
        });
        this.hdZ.iKI.setOnTouchListener(null);
        this.hdN = (TextView) this.rootView.findViewById(R.id.title);
        this.hdS = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hdS.setIsRound(true);
        this.hdS.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hdS.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hdS.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.kuR = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.afW = (TextView) this.rootView.findViewById(R.id.user_name);
        this.ePc = new n(this.duG.getPageActivity());
        this.kuT = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.kuU = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.kuV = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.kuW = new d(this.duG.getPageActivity(), this.kuV);
        this.kuW.page = 1;
        this.hyV = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.hyV.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.hyV.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hdZ.sU(false);
                VideoMiddlePageAdView.this.hyV.ddT();
                if (VideoMiddlePageAdView.this.kuS != null && VideoMiddlePageAdView.this.kuS.video != null) {
                    VideoMiddlePageAdView.this.hdZ.ev(VideoMiddlePageAdView.this.kuS.video.video_url, "");
                }
            }
        });
        this.hyQ = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.kuP = this.rootView.findViewById(R.id.user_container_foreground);
        this.kuQ = this.rootView.findViewById(R.id.title_foreground);
        this.kuO = this.rootView.findViewById(R.id.operate_area_foreground);
        this.hyQ.setOnClickListener(this);
        this.kuP.setOnClickListener(this);
        this.kuQ.setOnClickListener(this);
        this.kuO.setOnClickListener(this);
        this.hdM.setOnClickListener(this);
        this.hdL.setOnClickListener(this);
        this.hdZ.Z(this);
        this.hdN.setOnClickListener(this);
        this.hdS.setOnClickListener(this);
        this.afW.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.duG.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hdL.setLayoutParams(layoutParams);
        this.bht = new AlphaAnimation(0.0f, 0.7f);
        this.bht.setDuration(500L);
        this.bht.setAnimationListener(this.hzd);
        this.bhu = new AlphaAnimation(0.7f, 0.0f);
        this.bhu.setDuration(500L);
        this.bhu.setAnimationListener(this.hzc);
        this.rootView.setOnClickListener(this);
        this.kvc = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cna() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dvK = this.kuS.autoPlay;
            this.kva = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.kuZ = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hdZ.pI()) {
                cG(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hdZ.getCurrentPosition());
                this.kvb = true;
            }
            this.hdZ.stopPlay();
            this.hdZ.setIsNeedRecoveryVideoPlayer(true);
            this.hdZ.sV(true);
            this.hdZ.sR(false);
            this.hdZ.sW(true);
            this.hdZ.ak(false, true);
            this.hdZ.AV(i);
            this.hdZ.a(new c.InterfaceC0629c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pG() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pH() {
                }
            });
            this.hdZ.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bRb() {
                    if (VideoMiddlePageAdView.this.kuS != null && VideoMiddlePageAdView.this.kuS.video != null && VideoMiddlePageAdView.this.kuS.video.video_height.intValue() > VideoMiddlePageAdView.this.kuS.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hdZ.ak(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hdZ.ak(false, true);
                    }
                    if (VideoMiddlePageAdView.this.kuY != null) {
                        VideoMiddlePageAdView.this.kuY.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.BD(VideoMiddlePageAdView.this.dvK ? 0 : 1);
                    VideoMiddlePageAdView.this.kva = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bRc() {
                }
            });
            this.hdZ.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void mQ(boolean z) {
                    VideoMiddlePageAdView.this.hdZ.ev(VideoMiddlePageAdView.this.kuS.video.video_url, "");
                    if (VideoMiddlePageAdView.this.kuY != null) {
                        VideoMiddlePageAdView.this.kuY.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.BD(1);
                    VideoMiddlePageAdView.this.kva = false;
                }
            });
            this.hdZ.sN(false);
            this.hdZ.getVideoView().setBusiness(this.ePc);
            this.hdZ.cnB();
            this.hdZ.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.hdZ.caH();
                    if (VideoMiddlePageAdView.this.kuX != null) {
                        VideoMiddlePageAdView.this.kuX.cOs();
                    }
                    VideoMiddlePageAdView.this.BE(VideoMiddlePageAdView.this.dvK ? 0 : 1);
                    VideoMiddlePageAdView.this.kvb = true;
                }
            });
            this.hdZ.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.BF(VideoMiddlePageAdView.this.dvK ? 0 : 1);
                    return true;
                }
            });
            this.hdZ.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hdZ.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hdZ.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bRe() {
                    VideoMiddlePageAdView.this.cH(1, VideoMiddlePageAdView.this.hdZ.getCurrentPosition());
                }
            });
            this.hdZ.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cG(1, VideoMiddlePageAdView.this.hdZ.getCurrentPosition());
                    VideoMiddlePageAdView.this.kvb = true;
                }
            });
            this.hdZ.caH();
            this.hdZ.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.hyV.cFb()) {
                    this.hdZ.sT(false);
                    this.hyV.ddS();
                    this.hdZ.sU(true);
                    this.hdZ.eu(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hdZ.sU(false);
                    this.hdZ.sT(false);
                    this.hyV.hide();
                    this.hdZ.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.kuX != null) {
                    this.kuX.tl(true);
                }
                if (i == 0) {
                    this.hyQ.setVisibility(8);
                    this.kuO.setVisibility(8);
                } else {
                    this.hyQ.startAnimation(this.bhu);
                    this.kuO.startAnimation(this.bhu);
                }
                if (i == 0) {
                    this.kvc.uZ(3);
                    return;
                } else {
                    this.kvc.uZ(0);
                    return;
                }
            }
            this.hyV.hide();
            this.hdZ.sT(true);
            this.kvc.uZ(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.hyQ.startAnimation(this.bhu);
                this.kuO.startAnimation(this.bhu);
                return;
            }
            this.hyQ.setVisibility(0);
            this.kuO.setVisibility(0);
        }
    }

    private boolean bWc() {
        try {
            int intValue = this.kuS.video.video_width.intValue();
            return intValue <= 0 || ((float) this.kuS.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hdN.setTextColor(this.duG.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kuR.setTextColor(this.duG.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kuT.setTextColor(this.duG.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kuU.setTextColor(this.duG.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.kuU, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bWd() {
        if (!bWc()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hdL.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hdL.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kuS = videoMiddlePageAdCard;
        bWd();
        this.hdN.setText(videoMiddlePageAdCard.threadTitle);
        this.afW.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hdS.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hdS.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hdS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aRJ() || VideoMiddlePageAdView.this.kuS == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.kuS.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.duG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.kuR.setText(videoMiddlePageAdCard.tagName);
        this.kuT.setText(videoMiddlePageAdCard.operateData.ksM);
        this.kuU.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.kuU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = r.b(VideoMiddlePageAdView.this.duG, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.kuS == null || VideoMiddlePageAdView.this.kuS.getAdFacadeData() == null || VideoMiddlePageAdView.this.kuS.getAdFacadeData().po() == null) ? null : VideoMiddlePageAdView.this.kuS.getAdFacadeData().po().dmo);
                if (VideoMiddlePageAdView.this.kuX != null) {
                    VideoMiddlePageAdView.this.kuX.tl(false);
                }
                if (VideoMiddlePageAdView.this.iKk != null) {
                    VideoMiddlePageAdView.this.iKk.d(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.kuS, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kuX = this.kuW.a(videoMiddlePageAdCard.tailFrame, this.kuX);
        if (this.kuX != null) {
            b(this.kuS.getAdFacadeData());
            this.kuX.setPageContext(this.duG);
            this.kuX.setTimeoutListener(this);
            this.kuX.a(videoMiddlePageAdCard.tailFrame);
            this.kuX.c(this.kuS);
            this.kuX.cOt();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.WV = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.WV;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.hyS = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.kuY = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void br(View view) {
        this.WV.tE(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bQZ();
        if (this.hyQ != null) {
            this.hyQ.clearAnimation();
        }
        if (this.kuO != null) {
            this.kuO.clearAnimation();
        }
    }

    public void bQY() {
        this.hdZ.stopPlay();
        if (this.hdN != null) {
            this.hdN.setVisibility(0);
        }
        if (this.kvc != null) {
            this.kvc.uZ(2);
        }
        this.kva = false;
        this.kvb = true;
    }

    public void bQZ() {
        if (this.hdZ != null) {
            this.hdZ.destroy();
        }
        this.kva = false;
        this.kvb = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hyQ && this.hyQ.getVisibility() == 0) {
            if (this.hyS != null) {
                this.hyS.vd(this.mPosition);
            }
        } else if (view == this.kuO && this.kuO.getVisibility() == 0) {
            if (this.hyS != null) {
                this.hyS.vd(this.mPosition);
            }
        } else if (view == this.kuQ || view == this.kuP) {
            if (this.hyQ.getVisibility() == 0) {
                if (this.hyS != null) {
                    this.hyS.vd(this.mPosition);
                    return;
                }
                return;
            }
            this.kvc.uZ(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.krB = new WebVideoActivity.a();
            if (this.kuS.getAdFacadeData() != null) {
                WebVideoActivity.krB.krL = this.kuS.getAdFacadeData().po();
                WebVideoActivity.krB.mPage = "DETAIL";
                if (this.kuS.getAdFacadeData().WH != null) {
                    WebVideoActivity.krB.mPageNum = this.kuS.getAdFacadeData().WH.pk();
                }
            }
            if (com.baidu.tieba.a.bdC().bdD() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.duG.getPageActivity(), "", this.kuS.getScheme(), true, true, true, this.kuS.video.video_url, this.kuS.video.thumbnail_url, 1.7777778f, this.kuZ, this.kuS.getAdFacadeData().po().dmo)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.duG.getPageActivity(), "", this.kuS.getScheme(), true, true, true, this.kuS.video.video_url, this.kuS.video.thumbnail_url, 1.7777778f, this.kuZ)));
            }
            if (this.iKk != null) {
                this.iKk.d(0, null);
            }
            if (this.kuX != null) {
                this.kuX.tl(false);
            }
        } else {
            String str = null;
            if (this.kuS.getAdFacadeData() != null && this.kuS.getAdFacadeData().po() != null) {
                str = this.kuS.getAdFacadeData().po().dmo;
            }
            int b = r.b(this.duG, this.kuS.getScheme(), str);
            if (this.iKk != null) {
                this.iKk.d(b, null);
            }
            if (this.kuX != null) {
                this.kuX.tl(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.oy(this.hdZ.getCurrentPosition()) < this.kuZ && this.hdZ.getCurrentState() == 1) {
            cG(this.dvK ? 0 : 1, this.hdZ.getCurrentPosition());
        }
        bQY();
        this.kuX.tl(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void asn() {
        if (isPlaying()) {
            this.hdZ.asn();
            cG(this.dvK ? 0 : 1, this.hdZ.getCurrentPosition());
            this.kvb = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hdZ.pI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD(int i) {
        if (this.kuS != null && this.kuS.video != null && this.kuS.getAdFacadeData() != null && this.kvb) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this.kuS.getAdFacadeData(), 31, this.kuS.getAdFacadeData().getPageNum(), i, this.kuZ, 0, -1));
            this.kvb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE(int i) {
        if (this.kuS != null && this.kuS.video != null && this.kuS.getAdFacadeData() != null && !this.kva) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this.kuS.getAdFacadeData(), 34, this.kuS.getAdFacadeData().getPageNum(), i, this.kuZ, this.kuZ, -1));
            this.kva = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF(int i) {
        if (this.kuS != null && this.kuS.video != null && this.kuS.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this.kuS.getAdFacadeData(), 36, this.kuS.getAdFacadeData().getPageNum(), i, this.kuZ, com.baidu.tieba.ad.a.a.oy(this.hdZ.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i, int i2) {
        if (this.kuS != null && this.kuS.video != null && this.kuS.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this.kuS.getAdFacadeData(), 32, this.kuS.getAdFacadeData().getPageNum(), i, this.kuZ, com.baidu.tieba.ad.a.a.oy(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(int i, int i2) {
        if (this.kuS != null && this.kuS.video != null && this.kuS.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this.kuS.getAdFacadeData(), 33, this.kuS.getAdFacadeData().getPageNum(), i, this.kuZ, com.baidu.tieba.ad.a.a.oy(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(this.kuS.getAdFacadeData(), 303, this.kuS.getAdFacadeData().getPageNum(), this.dvK ? 0 : 1, this.kuS.video.video_duration.intValue(), 0, -1);
            if (this.kuX != null) {
                this.kuX.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(boolean z) {
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
        private Runnable hzj = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.hzj);
                a.this.uZ(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void uZ(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = va(i);
                    bWn();
                    return;
                case 1:
                    this.mCurrentState = va(i);
                    this.mHandler.removeCallbacks(this.hzj);
                    return;
                case 2:
                    this.mCurrentState = vb(i);
                    return;
                case 3:
                    this.mCurrentState = vc(i);
                    bWn();
                    return;
                default:
                    this.mCurrentState = vb(i);
                    return;
            }
        }

        private void bWn() {
            this.mHandler.removeCallbacks(this.hzj);
            this.mHandler.postDelayed(this.hzj, 3000L);
        }

        private int va(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kuQ.setVisibility(8);
                VideoMiddlePageAdView.this.kuP.setVisibility(8);
                VideoMiddlePageAdView.this.tj(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vb(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kuQ.setVisibility(0);
                VideoMiddlePageAdView.this.kuP.setVisibility(0);
                if (VideoMiddlePageAdView.this.hdZ != null) {
                    VideoMiddlePageAdView.this.hdZ.cJn();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.kuS.autoPlay) {
                    VideoMiddlePageAdView.this.tj(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vc(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kuQ.setVisibility(0);
                VideoMiddlePageAdView.this.kuP.setVisibility(0);
                VideoMiddlePageAdView.this.tj(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
