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
    private com.baidu.tieba.frs.aggregation.a WY;
    public TextView afZ;
    private Animation bhy;
    private Animation bhz;
    private boolean dvO;
    private n ePh;
    public FrameLayout hdR;
    public FrameLayout hdS;
    public TextView hdT;
    public HeadImageView hdY;
    public c hef;
    private View hyQ;
    private View hyW;
    private com.baidu.tieba.frs.videomiddlepage.c hyY;
    private VideoNetworkStateTipView hzb;
    private Animation.AnimationListener hzi;
    private Animation.AnimationListener hzj;
    private View kuS;
    private View kuT;
    private View kuU;
    public TextView kuV;
    private VideoMiddlePageAdCard kuW;
    private TextView kuX;
    private TextView kuY;
    private ViewGroup kuZ;
    private d kva;
    private e kvb;
    private f kvc;
    private int kvd;
    private boolean kve;
    private boolean kvf;
    private a kvg;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kve = false;
        this.kvf = true;
        this.hzi = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hyW != null) {
                    VideoMiddlePageAdView.this.hyW.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kuS != null) {
                    VideoMiddlePageAdView.this.kuS.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hyW != null) {
                    VideoMiddlePageAdView.this.hyW.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kuS != null) {
                    VideoMiddlePageAdView.this.kuS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hzj = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.hyW != null) {
                    VideoMiddlePageAdView.this.hyW.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.kuS != null) {
                    VideoMiddlePageAdView.this.kuS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.hyW != null) {
                    VideoMiddlePageAdView.this.hyW.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.kuS != null) {
                    VideoMiddlePageAdView.this.kuS.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kve = false;
        this.kvf = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hdR = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.hyQ = this.rootView.findViewById(R.id.card_container);
        this.hdS = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hef = new c(this.duK, this.hdS, false);
        this.hef.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.hef != null && VideoMiddlePageAdView.this.hef.getVideoView() != null) {
                    VideoMiddlePageAdView.this.kvd = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hef.getVideoView().getDuration());
                }
            }
        });
        this.hef.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void nv(boolean z) {
                if (VideoMiddlePageAdView.this.kvg != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.kvg.uZ(0);
                    } else {
                        VideoMiddlePageAdView.this.kvg.uZ(1);
                    }
                }
            }
        });
        this.hef.iKM.setOnTouchListener(null);
        this.hdT = (TextView) this.rootView.findViewById(R.id.title);
        this.hdY = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hdY.setIsRound(true);
        this.hdY.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hdY.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hdY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.kuV = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.afZ = (TextView) this.rootView.findViewById(R.id.user_name);
        this.ePh = new n(this.duK.getPageActivity());
        this.kuX = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.kuY = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.kuZ = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.kva = new d(this.duK.getPageActivity(), this.kuZ);
        this.kva.page = 1;
        this.hzb = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.hzb.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.hzb.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hef.sU(false);
                VideoMiddlePageAdView.this.hzb.ddR();
                if (VideoMiddlePageAdView.this.kuW != null && VideoMiddlePageAdView.this.kuW.video != null) {
                    VideoMiddlePageAdView.this.hef.ev(VideoMiddlePageAdView.this.kuW.video.video_url, "");
                }
            }
        });
        this.hyW = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.kuT = this.rootView.findViewById(R.id.user_container_foreground);
        this.kuU = this.rootView.findViewById(R.id.title_foreground);
        this.kuS = this.rootView.findViewById(R.id.operate_area_foreground);
        this.hyW.setOnClickListener(this);
        this.kuT.setOnClickListener(this);
        this.kuU.setOnClickListener(this);
        this.kuS.setOnClickListener(this);
        this.hdS.setOnClickListener(this);
        this.hdR.setOnClickListener(this);
        this.hef.Z(this);
        this.hdT.setOnClickListener(this);
        this.hdY.setOnClickListener(this);
        this.afZ.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.duK.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hdR.setLayoutParams(layoutParams);
        this.bhy = new AlphaAnimation(0.0f, 0.7f);
        this.bhy.setDuration(500L);
        this.bhy.setAnimationListener(this.hzj);
        this.bhz = new AlphaAnimation(0.7f, 0.0f);
        this.bhz.setDuration(500L);
        this.bhz.setAnimationListener(this.hzi);
        this.rootView.setOnClickListener(this);
        this.kvg = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cmY() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dvO = this.kuW.autoPlay;
            this.kve = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.kvd = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hef.pI()) {
                cG(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hef.getCurrentPosition());
                this.kvf = true;
            }
            this.hef.stopPlay();
            this.hef.setIsNeedRecoveryVideoPlayer(true);
            this.hef.sV(true);
            this.hef.sR(false);
            this.hef.sW(true);
            this.hef.ak(false, true);
            this.hef.AV(i);
            this.hef.a(new c.InterfaceC0650c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pG() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pH() {
                }
            });
            this.hef.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bRa() {
                    if (VideoMiddlePageAdView.this.kuW != null && VideoMiddlePageAdView.this.kuW.video != null && VideoMiddlePageAdView.this.kuW.video.video_height.intValue() > VideoMiddlePageAdView.this.kuW.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hef.ak(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hef.ak(false, true);
                    }
                    if (VideoMiddlePageAdView.this.kvc != null) {
                        VideoMiddlePageAdView.this.kvc.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.BD(VideoMiddlePageAdView.this.dvO ? 0 : 1);
                    VideoMiddlePageAdView.this.kve = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bRb() {
                }
            });
            this.hef.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void mQ(boolean z) {
                    VideoMiddlePageAdView.this.hef.ev(VideoMiddlePageAdView.this.kuW.video.video_url, "");
                    if (VideoMiddlePageAdView.this.kvc != null) {
                        VideoMiddlePageAdView.this.kvc.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.BD(1);
                    VideoMiddlePageAdView.this.kve = false;
                }
            });
            this.hef.sN(false);
            this.hef.getVideoView().setBusiness(this.ePh);
            this.hef.cnz();
            this.hef.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.hef.caG();
                    if (VideoMiddlePageAdView.this.kvb != null) {
                        VideoMiddlePageAdView.this.kvb.cOq();
                    }
                    VideoMiddlePageAdView.this.BE(VideoMiddlePageAdView.this.dvO ? 0 : 1);
                    VideoMiddlePageAdView.this.kvf = true;
                }
            });
            this.hef.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.BF(VideoMiddlePageAdView.this.dvO ? 0 : 1);
                    return true;
                }
            });
            this.hef.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hef.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hef.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bRd() {
                    VideoMiddlePageAdView.this.cH(1, VideoMiddlePageAdView.this.hef.getCurrentPosition());
                }
            });
            this.hef.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cG(1, VideoMiddlePageAdView.this.hef.getCurrentPosition());
                    VideoMiddlePageAdView.this.kvf = true;
                }
            });
            this.hef.caG();
            this.hef.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.hzb.cEZ()) {
                    this.hef.sT(false);
                    this.hzb.ddQ();
                    this.hef.sU(true);
                    this.hef.eu(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hef.sU(false);
                    this.hef.sT(false);
                    this.hzb.hide();
                    this.hef.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.kvb != null) {
                    this.kvb.tl(true);
                }
                if (i == 0) {
                    this.hyW.setVisibility(8);
                    this.kuS.setVisibility(8);
                } else {
                    this.hyW.startAnimation(this.bhz);
                    this.kuS.startAnimation(this.bhz);
                }
                if (i == 0) {
                    this.kvg.uZ(3);
                    return;
                } else {
                    this.kvg.uZ(0);
                    return;
                }
            }
            this.hzb.hide();
            this.hef.sT(true);
            this.kvg.uZ(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.hyW.startAnimation(this.bhz);
                this.kuS.startAnimation(this.bhz);
                return;
            }
            this.hyW.setVisibility(0);
            this.kuS.setVisibility(0);
        }
    }

    private boolean bWb() {
        try {
            int intValue = this.kuW.video.video_width.intValue();
            return intValue <= 0 || ((float) this.kuW.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hdT.setTextColor(this.duK.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kuV.setTextColor(this.duK.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kuX.setTextColor(this.duK.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.kuY.setTextColor(this.duK.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.kuY, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bWc() {
        if (!bWb()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hdR.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hdR.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kuW = videoMiddlePageAdCard;
        bWc();
        this.hdT.setText(videoMiddlePageAdCard.threadTitle);
        this.afZ.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hdY.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hdY.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hdY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aRG() || VideoMiddlePageAdView.this.kuW == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.kuW.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.duK.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.kuV.setText(videoMiddlePageAdCard.tagName);
        this.kuX.setText(videoMiddlePageAdCard.operateData.ksQ);
        this.kuY.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.kuY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = r.b(VideoMiddlePageAdView.this.duK, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.kuW == null || VideoMiddlePageAdView.this.kuW.getAdFacadeData() == null || VideoMiddlePageAdView.this.kuW.getAdFacadeData().po() == null) ? null : VideoMiddlePageAdView.this.kuW.getAdFacadeData().po().dms);
                if (VideoMiddlePageAdView.this.kvb != null) {
                    VideoMiddlePageAdView.this.kvb.tl(false);
                }
                if (VideoMiddlePageAdView.this.iKo != null) {
                    VideoMiddlePageAdView.this.iKo.d(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.kuW, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.kvb = this.kva.a(videoMiddlePageAdCard.tailFrame, this.kvb);
        if (this.kvb != null) {
            b(this.kuW.getAdFacadeData());
            this.kvb.setPageContext(this.duK);
            this.kvb.setTimeoutListener(this);
            this.kvb.a(videoMiddlePageAdCard.tailFrame);
            this.kvb.c(this.kuW);
            this.kvb.cOr();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.WY = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.WY;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.hyY = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.kvc = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void br(View view) {
        this.WY.tE(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bQY();
        if (this.hyW != null) {
            this.hyW.clearAnimation();
        }
        if (this.kuS != null) {
            this.kuS.clearAnimation();
        }
    }

    public void bQX() {
        this.hef.stopPlay();
        if (this.hdT != null) {
            this.hdT.setVisibility(0);
        }
        if (this.kvg != null) {
            this.kvg.uZ(2);
        }
        this.kve = false;
        this.kvf = true;
    }

    public void bQY() {
        if (this.hef != null) {
            this.hef.destroy();
        }
        this.kve = false;
        this.kvf = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hyW && this.hyW.getVisibility() == 0) {
            if (this.hyY != null) {
                this.hyY.vd(this.mPosition);
            }
        } else if (view == this.kuS && this.kuS.getVisibility() == 0) {
            if (this.hyY != null) {
                this.hyY.vd(this.mPosition);
            }
        } else if (view == this.kuU || view == this.kuT) {
            if (this.hyW.getVisibility() == 0) {
                if (this.hyY != null) {
                    this.hyY.vd(this.mPosition);
                    return;
                }
                return;
            }
            this.kvg.uZ(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.krF = new WebVideoActivity.a();
            if (this.kuW.getAdFacadeData() != null) {
                WebVideoActivity.krF.krP = this.kuW.getAdFacadeData().po();
                WebVideoActivity.krF.mPage = "DETAIL";
                if (this.kuW.getAdFacadeData().WK != null) {
                    WebVideoActivity.krF.mPageNum = this.kuW.getAdFacadeData().WK.pk();
                }
            }
            if (com.baidu.tieba.a.bdA().bdB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.duK.getPageActivity(), "", this.kuW.getScheme(), true, true, true, this.kuW.video.video_url, this.kuW.video.thumbnail_url, 1.7777778f, this.kvd, this.kuW.getAdFacadeData().po().dms)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.duK.getPageActivity(), "", this.kuW.getScheme(), true, true, true, this.kuW.video.video_url, this.kuW.video.thumbnail_url, 1.7777778f, this.kvd)));
            }
            if (this.iKo != null) {
                this.iKo.d(0, null);
            }
            if (this.kvb != null) {
                this.kvb.tl(false);
            }
        } else {
            String str = null;
            if (this.kuW.getAdFacadeData() != null && this.kuW.getAdFacadeData().po() != null) {
                str = this.kuW.getAdFacadeData().po().dms;
            }
            int b = r.b(this.duK, this.kuW.getScheme(), str);
            if (this.iKo != null) {
                this.iKo.d(b, null);
            }
            if (this.kvb != null) {
                this.kvb.tl(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.oy(this.hef.getCurrentPosition()) < this.kvd && this.hef.getCurrentState() == 1) {
            cG(this.dvO ? 0 : 1, this.hef.getCurrentPosition());
        }
        bQX();
        this.kvb.tl(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void asl() {
        if (isPlaying()) {
            this.hef.asl();
            cG(this.dvO ? 0 : 1, this.hef.getCurrentPosition());
            this.kvf = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hef.pI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD(int i) {
        if (this.kuW != null && this.kuW.video != null && this.kuW.getAdFacadeData() != null && this.kvf) {
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(this.kuW.getAdFacadeData(), 31, this.kuW.getAdFacadeData().getPageNum(), i, this.kvd, 0, -1));
            this.kvf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE(int i) {
        if (this.kuW != null && this.kuW.video != null && this.kuW.getAdFacadeData() != null && !this.kve) {
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(this.kuW.getAdFacadeData(), 34, this.kuW.getAdFacadeData().getPageNum(), i, this.kvd, this.kvd, -1));
            this.kve = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF(int i) {
        if (this.kuW != null && this.kuW.video != null && this.kuW.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(this.kuW.getAdFacadeData(), 36, this.kuW.getAdFacadeData().getPageNum(), i, this.kvd, com.baidu.tieba.ad.a.a.oy(this.hef.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i, int i2) {
        if (this.kuW != null && this.kuW.video != null && this.kuW.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(this.kuW.getAdFacadeData(), 32, this.kuW.getAdFacadeData().getPageNum(), i, this.kvd, com.baidu.tieba.ad.a.a.oy(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(int i, int i2) {
        if (this.kuW != null && this.kuW.video != null && this.kuW.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(this.kuW.getAdFacadeData(), 33, this.kuW.getAdFacadeData().getPageNum(), i, this.kvd, com.baidu.tieba.ad.a.a.oy(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(this.kuW.getAdFacadeData(), 303, this.kuW.getAdFacadeData().getPageNum(), this.dvO ? 0 : 1, this.kuW.video.video_duration.intValue(), 0, -1);
            if (this.kvb != null) {
                this.kvb.e(a2);
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
        private Runnable hzp = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.hzp);
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
                    bWm();
                    return;
                case 1:
                    this.mCurrentState = va(i);
                    this.mHandler.removeCallbacks(this.hzp);
                    return;
                case 2:
                    this.mCurrentState = vb(i);
                    return;
                case 3:
                    this.mCurrentState = vc(i);
                    bWm();
                    return;
                default:
                    this.mCurrentState = vb(i);
                    return;
            }
        }

        private void bWm() {
            this.mHandler.removeCallbacks(this.hzp);
            this.mHandler.postDelayed(this.hzp, 3000L);
        }

        private int va(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kuU.setVisibility(8);
                VideoMiddlePageAdView.this.kuT.setVisibility(8);
                VideoMiddlePageAdView.this.tj(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vb(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kuU.setVisibility(0);
                VideoMiddlePageAdView.this.kuT.setVisibility(0);
                if (VideoMiddlePageAdView.this.hef != null) {
                    VideoMiddlePageAdView.this.hef.cJl();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.kuW.autoPlay) {
                    VideoMiddlePageAdView.this.tj(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vc(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.kuU.setVisibility(0);
                VideoMiddlePageAdView.this.kuT.setVisibility(0);
                VideoMiddlePageAdView.this.tj(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
