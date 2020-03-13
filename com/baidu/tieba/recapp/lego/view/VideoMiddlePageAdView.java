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
    public TextView Nl;
    private Animation aLy;
    private Animation aLz;
    private boolean cWm;
    private n elm;
    private View gNE;
    private View gNK;
    private c gNM;
    private VideoNetworkStateTipView gNP;
    private Animation.AnimationListener gNW;
    private Animation.AnimationListener gNX;
    public FrameLayout gtW;
    public FrameLayout gtX;
    public TextView gtY;
    public HeadImageView gud;
    public com.baidu.tieba.play.c guk;
    private View jJP;
    private View jJQ;
    private View jJR;
    public TextView jJS;
    private VideoMiddlePageAdCard jJT;
    private TextView jJU;
    private TextView jJV;
    private ViewGroup jJW;
    private d jJX;
    private e jJY;
    private f jJZ;
    private int jKa;
    private boolean jKb;
    private boolean jKc;
    private a jKd;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jKb = false;
        this.jKc = true;
        this.gNW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gNK != null) {
                    VideoMiddlePageAdView.this.gNK.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jJP != null) {
                    VideoMiddlePageAdView.this.jJP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gNK != null) {
                    VideoMiddlePageAdView.this.gNK.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jJP != null) {
                    VideoMiddlePageAdView.this.jJP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNX = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gNK != null) {
                    VideoMiddlePageAdView.this.gNK.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jJP != null) {
                    VideoMiddlePageAdView.this.jJP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gNK != null) {
                    VideoMiddlePageAdView.this.gNK.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jJP != null) {
                    VideoMiddlePageAdView.this.jJP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jKb = false;
        this.jKc = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.gtW = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.gNE = this.rootView.findViewById(R.id.card_container);
        this.gtX = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.guk = new com.baidu.tieba.play.c(this.cVi, this.gtX, false);
        this.guk.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.guk != null && VideoMiddlePageAdView.this.guk.getVideoView() != null) {
                    VideoMiddlePageAdView.this.jKa = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.guk.getVideoView().getDuration());
                }
            }
        });
        this.guk.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void ml(boolean z) {
                if (VideoMiddlePageAdView.this.jKd != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.jKd.uu(0);
                    } else {
                        VideoMiddlePageAdView.this.jKd.uu(1);
                    }
                }
            }
        });
        this.guk.hZo.setOnTouchListener(null);
        this.gtY = (TextView) this.rootView.findViewById(R.id.title);
        this.gud = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.gud.setIsRound(true);
        this.gud.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gud.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gud.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jJS = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Nl = (TextView) this.rootView.findViewById(R.id.user_name);
        this.elm = new n(this.cVi.getPageActivity());
        this.jJU = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.jJV = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.jJW = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.jJX = new d(this.cVi.getPageActivity(), this.jJW);
        this.jJX.page = 1;
        this.gNP = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.gNP.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.gNP.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.guk.rK(false);
                VideoMiddlePageAdView.this.gNP.cSw();
                if (VideoMiddlePageAdView.this.jJT != null && VideoMiddlePageAdView.this.jJT.video != null) {
                    VideoMiddlePageAdView.this.guk.ei(VideoMiddlePageAdView.this.jJT.video.video_url, "");
                }
            }
        });
        this.gNK = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.jJQ = this.rootView.findViewById(R.id.user_container_foreground);
        this.jJR = this.rootView.findViewById(R.id.title_foreground);
        this.jJP = this.rootView.findViewById(R.id.operate_area_foreground);
        this.gNK.setOnClickListener(this);
        this.jJQ.setOnClickListener(this);
        this.jJR.setOnClickListener(this);
        this.jJP.setOnClickListener(this);
        this.gtX.setOnClickListener(this);
        this.gtW.setOnClickListener(this);
        this.guk.Y(this);
        this.gtY.setOnClickListener(this);
        this.gud.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cVi.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtW.setLayoutParams(layoutParams);
        this.aLy = new AlphaAnimation(0.0f, 0.7f);
        this.aLy.setDuration(500L);
        this.aLy.setAnimationListener(this.gNX);
        this.aLz = new AlphaAnimation(0.7f, 0.0f);
        this.aLz.setDuration(500L);
        this.aLz.setAnimationListener(this.gNW);
        this.rootView.setOnClickListener(this);
        this.jKd = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccg() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cWm = this.jJT.autoPlay;
            this.jKb = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.jKa = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.guk.le()) {
                cz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.guk.getCurrentPosition());
                this.jKc = true;
            }
            this.guk.stopPlay();
            this.guk.setIsNeedRecoveryVideoPlayer(true);
            this.guk.rL(true);
            this.guk.rH(false);
            this.guk.rM(true);
            this.guk.aj(false, true);
            this.guk.An(i);
            this.guk.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                }
            });
            this.guk.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bGo() {
                    if (VideoMiddlePageAdView.this.jJT != null && VideoMiddlePageAdView.this.jJT.video != null && VideoMiddlePageAdView.this.jJT.video.video_height.intValue() > VideoMiddlePageAdView.this.jJT.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.guk.aj(false, true);
                    } else {
                        VideoMiddlePageAdView.this.guk.aj(false, true);
                    }
                    if (VideoMiddlePageAdView.this.jJZ != null) {
                        VideoMiddlePageAdView.this.jJZ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AV(VideoMiddlePageAdView.this.cWm ? 0 : 1);
                    VideoMiddlePageAdView.this.jKb = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGp() {
                }
            });
            this.guk.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z) {
                    VideoMiddlePageAdView.this.guk.ei(VideoMiddlePageAdView.this.jJT.video.video_url, "");
                    if (VideoMiddlePageAdView.this.jJZ != null) {
                        VideoMiddlePageAdView.this.jJZ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AV(1);
                    VideoMiddlePageAdView.this.jKb = false;
                }
            });
            this.guk.rD(false);
            this.guk.getVideoView().setBusiness(this.elm);
            this.guk.ccH();
            this.guk.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.guk.bPP();
                    if (VideoMiddlePageAdView.this.jJY != null) {
                        VideoMiddlePageAdView.this.jJY.cDx();
                    }
                    VideoMiddlePageAdView.this.AW(VideoMiddlePageAdView.this.cWm ? 0 : 1);
                    VideoMiddlePageAdView.this.jKc = true;
                }
            });
            this.guk.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.AX(VideoMiddlePageAdView.this.cWm ? 0 : 1);
                    return true;
                }
            });
            this.guk.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.guk.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.guk.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bGr() {
                    VideoMiddlePageAdView.this.cA(1, VideoMiddlePageAdView.this.guk.getCurrentPosition());
                }
            });
            this.guk.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cz(1, VideoMiddlePageAdView.this.guk.getCurrentPosition());
                    VideoMiddlePageAdView.this.jKc = true;
                }
            });
            this.guk.bPP();
            this.guk.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.gNP.cuc()) {
                    this.guk.rJ(false);
                    this.gNP.cSv();
                    this.guk.rK(true);
                    this.guk.eh(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.guk.rK(false);
                    this.guk.rJ(false);
                    this.gNP.hide();
                    this.guk.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.jJY != null) {
                    this.jJY.se(true);
                }
                if (i == 0) {
                    this.gNK.setVisibility(8);
                    this.jJP.setVisibility(8);
                } else {
                    this.gNK.startAnimation(this.aLz);
                    this.jJP.startAnimation(this.aLz);
                }
                if (i == 0) {
                    this.jKd.uu(3);
                    return;
                } else {
                    this.jKd.uu(0);
                    return;
                }
            }
            this.gNP.hide();
            this.guk.rJ(true);
            this.jKd.uu(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.gNK.startAnimation(this.aLz);
                this.jJP.startAnimation(this.aLz);
                return;
            }
            this.gNK.setVisibility(0);
            this.jJP.setVisibility(0);
        }
    }

    private boolean bLi() {
        try {
            int intValue = this.jJT.video.video_width.intValue();
            return intValue <= 0 || ((float) this.jJT.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.gtY.setTextColor(this.cVi.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJS.setTextColor(this.cVi.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJU.setTextColor(this.cVi.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJV.setTextColor(this.cVi.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.jJV, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bLj() {
        if (!bLi()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtW.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.gtW.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtW.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.gtW.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jJT = videoMiddlePageAdCard;
        bLj();
        this.gtY.setText(videoMiddlePageAdCard.threadTitle);
        this.Nl.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.gud.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.gud.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.gud.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJi() || VideoMiddlePageAdView.this.jJT == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.jJT.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cVi.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.jJS.setText(videoMiddlePageAdCard.tagName);
        this.jJU.setText(videoMiddlePageAdCard.operateData.jHB);
        this.jJV.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.jJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = s.b(VideoMiddlePageAdView.this.cVi, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.jJT == null || VideoMiddlePageAdView.this.jJT.getAdFacadeData() == null || VideoMiddlePageAdView.this.jJT.getAdFacadeData().kK() == null) ? null : VideoMiddlePageAdView.this.jJT.getAdFacadeData().kK().cMX);
                if (VideoMiddlePageAdView.this.jJY != null) {
                    VideoMiddlePageAdView.this.jJY.se(false);
                }
                if (VideoMiddlePageAdView.this.hYQ != null) {
                    VideoMiddlePageAdView.this.hYQ.b(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.jJT, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jJY = this.jJX.a(videoMiddlePageAdCard.tailFrame, this.jJY);
        if (this.jJY != null) {
            b(this.jJT.getAdFacadeData());
            this.jJY.setPageContext(this.cVi);
            this.jJY.setTimeoutListener(this);
            this.jJY.a(videoMiddlePageAdCard.tailFrame);
            this.jJY.c(this.jJT);
            this.jJY.cDy();
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
        this.gNM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.jJZ = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bq(View view) {
        this.DA.te(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bGm();
        if (this.gNK != null) {
            this.gNK.clearAnimation();
        }
        if (this.jJP != null) {
            this.jJP.clearAnimation();
        }
    }

    public void bGl() {
        this.guk.stopPlay();
        if (this.gtY != null) {
            this.gtY.setVisibility(0);
        }
        if (this.jKd != null) {
            this.jKd.uu(2);
        }
        this.jKb = false;
        this.jKc = true;
    }

    public void bGm() {
        if (this.guk != null) {
            this.guk.destroy();
        }
        this.jKb = false;
        this.jKc = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNK && this.gNK.getVisibility() == 0) {
            if (this.gNM != null) {
                this.gNM.uy(this.mPosition);
            }
        } else if (view == this.jJP && this.jJP.getVisibility() == 0) {
            if (this.gNM != null) {
                this.gNM.uy(this.mPosition);
            }
        } else if (view == this.jJR || view == this.jJQ) {
            if (this.gNK.getVisibility() == 0) {
                if (this.gNM != null) {
                    this.gNM.uy(this.mPosition);
                    return;
                }
                return;
            }
            this.jKd.uu(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.jGr = new WebVideoActivity.a();
            if (this.jJT.getAdFacadeData() != null) {
                WebVideoActivity.jGr.jGB = this.jJT.getAdFacadeData().kK();
                WebVideoActivity.jGr.mPage = "DETAIL";
                if (this.jJT.getAdFacadeData().Dm != null) {
                    WebVideoActivity.jGr.mPageNum = this.jJT.getAdFacadeData().Dm.kG();
                }
            }
            if (com.baidu.tieba.a.aVo().aVp() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cVi.getPageActivity(), "", this.jJT.getScheme(), true, true, true, this.jJT.video.video_url, this.jJT.video.thumbnail_url, 1.7777778f, this.jKa, this.jJT.getAdFacadeData().kK().cMX)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cVi.getPageActivity(), "", this.jJT.getScheme(), true, true, true, this.jJT.video.video_url, this.jJT.video.thumbnail_url, 1.7777778f, this.jKa)));
            }
            if (this.hYQ != null) {
                this.hYQ.b(0, null);
            }
            if (this.jJY != null) {
                this.jJY.se(false);
            }
        } else {
            String str = null;
            if (this.jJT.getAdFacadeData() != null && this.jJT.getAdFacadeData().kK() != null) {
                str = this.jJT.getAdFacadeData().kK().cMX;
            }
            int b = s.b(this.cVi, this.jJT.getScheme(), str);
            if (this.hYQ != null) {
                this.hYQ.b(b, null);
            }
            if (this.jJY != null) {
                this.jJY.se(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.oj(this.guk.getCurrentPosition()) < this.jKa && this.guk.getCurrentState() == 1) {
            cz(this.cWm ? 0 : 1, this.guk.getCurrentPosition());
        }
        bGl();
        this.jJY.se(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.guk.pausePlay();
            cz(this.cWm ? 0 : 1, this.guk.getCurrentPosition());
            this.jKc = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.guk.le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV(int i) {
        if (this.jJT != null && this.jJT.video != null && this.jJT.getAdFacadeData() != null && this.jKc) {
            com.baidu.tieba.recapp.report.c.cDq().a(com.baidu.tieba.recapp.report.f.a(this.jJT.getAdFacadeData(), 31, this.jJT.getAdFacadeData().getPageNum(), i, this.jKa, 0, -1));
            this.jKc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW(int i) {
        if (this.jJT != null && this.jJT.video != null && this.jJT.getAdFacadeData() != null && !this.jKb) {
            com.baidu.tieba.recapp.report.c.cDq().a(com.baidu.tieba.recapp.report.f.a(this.jJT.getAdFacadeData(), 34, this.jJT.getAdFacadeData().getPageNum(), i, this.jKa, this.jKa, -1));
            this.jKb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX(int i) {
        if (this.jJT != null && this.jJT.video != null && this.jJT.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDq().a(com.baidu.tieba.recapp.report.f.a(this.jJT.getAdFacadeData(), 36, this.jJT.getAdFacadeData().getPageNum(), i, this.jKa, com.baidu.tieba.ad.a.a.oj(this.guk.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i, int i2) {
        if (this.jJT != null && this.jJT.video != null && this.jJT.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDq().a(com.baidu.tieba.recapp.report.f.a(this.jJT.getAdFacadeData(), 32, this.jJT.getAdFacadeData().getPageNum(), i, this.jKa, com.baidu.tieba.ad.a.a.oj(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(int i, int i2) {
        if (this.jJT != null && this.jJT.video != null && this.jJT.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDq().a(com.baidu.tieba.recapp.report.f.a(this.jJT.getAdFacadeData(), 33, this.jJT.getAdFacadeData().getPageNum(), i, this.jKa, com.baidu.tieba.ad.a.a.oj(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.jJT.getAdFacadeData(), 303, this.jJT.getAdFacadeData().getPageNum(), this.cWm ? 0 : 1, this.jJT.video.video_duration.intValue(), 0, -1);
            if (this.jJY != null) {
                this.jJY.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(boolean z) {
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
        private Runnable gOd = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gOd);
                a.this.uu(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void uu(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uv(i);
                    bLt();
                    return;
                case 1:
                    this.mCurrentState = uv(i);
                    this.mHandler.removeCallbacks(this.gOd);
                    return;
                case 2:
                    this.mCurrentState = uw(i);
                    return;
                case 3:
                    this.mCurrentState = ux(i);
                    bLt();
                    return;
                default:
                    this.mCurrentState = uw(i);
                    return;
            }
        }

        private void bLt() {
            this.mHandler.removeCallbacks(this.gOd);
            this.mHandler.postDelayed(this.gOd, 3000L);
        }

        private int uv(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJR.setVisibility(8);
                VideoMiddlePageAdView.this.jJQ.setVisibility(8);
                VideoMiddlePageAdView.this.sa(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uw(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJR.setVisibility(0);
                VideoMiddlePageAdView.this.jJQ.setVisibility(0);
                if (VideoMiddlePageAdView.this.guk != null) {
                    VideoMiddlePageAdView.this.guk.cyp();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.jJT.autoPlay) {
                    VideoMiddlePageAdView.this.sa(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ux(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJR.setVisibility(0);
                VideoMiddlePageAdView.this.jJQ.setVisibility(0);
                VideoMiddlePageAdView.this.sa(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
