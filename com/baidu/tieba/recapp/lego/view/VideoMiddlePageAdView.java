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
    private Animation aLx;
    private Animation aLy;
    private boolean cWl;
    private n ekZ;
    private c gNA;
    private VideoNetworkStateTipView gND;
    private Animation.AnimationListener gNK;
    private Animation.AnimationListener gNL;
    private View gNs;
    private View gNy;
    public FrameLayout gtK;
    public FrameLayout gtL;
    public TextView gtM;
    public HeadImageView gtR;
    public com.baidu.tieba.play.c gtY;
    private View jJD;
    private View jJE;
    private View jJF;
    public TextView jJG;
    private VideoMiddlePageAdCard jJH;
    private TextView jJI;
    private TextView jJJ;
    private ViewGroup jJK;
    private d jJL;
    private e jJM;
    private f jJN;
    private int jJO;
    private boolean jJP;
    private boolean jJQ;
    private a jJR;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jJP = false;
        this.jJQ = true;
        this.gNK = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gNy != null) {
                    VideoMiddlePageAdView.this.gNy.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jJD != null) {
                    VideoMiddlePageAdView.this.jJD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gNy != null) {
                    VideoMiddlePageAdView.this.gNy.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jJD != null) {
                    VideoMiddlePageAdView.this.jJD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNL = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gNy != null) {
                    VideoMiddlePageAdView.this.gNy.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jJD != null) {
                    VideoMiddlePageAdView.this.jJD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gNy != null) {
                    VideoMiddlePageAdView.this.gNy.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jJD != null) {
                    VideoMiddlePageAdView.this.jJD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jJP = false;
        this.jJQ = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.gtK = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.gNs = this.rootView.findViewById(R.id.card_container);
        this.gtL = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.gtY = new com.baidu.tieba.play.c(this.cVh, this.gtL, false);
        this.gtY.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.gtY != null && VideoMiddlePageAdView.this.gtY.getVideoView() != null) {
                    VideoMiddlePageAdView.this.jJO = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.gtY.getVideoView().getDuration());
                }
            }
        });
        this.gtY.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void ml(boolean z) {
                if (VideoMiddlePageAdView.this.jJR != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.jJR.uu(0);
                    } else {
                        VideoMiddlePageAdView.this.jJR.uu(1);
                    }
                }
            }
        });
        this.gtY.hZc.setOnTouchListener(null);
        this.gtM = (TextView) this.rootView.findViewById(R.id.title);
        this.gtR = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.gtR.setIsRound(true);
        this.gtR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gtR.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gtR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jJG = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.Nl = (TextView) this.rootView.findViewById(R.id.user_name);
        this.ekZ = new n(this.cVh.getPageActivity());
        this.jJI = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.jJJ = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.jJK = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.jJL = new d(this.cVh.getPageActivity(), this.jJK);
        this.jJL.page = 1;
        this.gND = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.gND.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.gND.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.gtY.rK(false);
                VideoMiddlePageAdView.this.gND.cSv();
                if (VideoMiddlePageAdView.this.jJH != null && VideoMiddlePageAdView.this.jJH.video != null) {
                    VideoMiddlePageAdView.this.gtY.ei(VideoMiddlePageAdView.this.jJH.video.video_url, "");
                }
            }
        });
        this.gNy = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.jJE = this.rootView.findViewById(R.id.user_container_foreground);
        this.jJF = this.rootView.findViewById(R.id.title_foreground);
        this.jJD = this.rootView.findViewById(R.id.operate_area_foreground);
        this.gNy.setOnClickListener(this);
        this.jJE.setOnClickListener(this);
        this.jJF.setOnClickListener(this);
        this.jJD.setOnClickListener(this);
        this.gtL.setOnClickListener(this);
        this.gtK.setOnClickListener(this);
        this.gtY.Y(this);
        this.gtM.setOnClickListener(this);
        this.gtR.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cVh.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtK.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtK.setLayoutParams(layoutParams);
        this.aLx = new AlphaAnimation(0.0f, 0.7f);
        this.aLx.setDuration(500L);
        this.aLx.setAnimationListener(this.gNL);
        this.aLy = new AlphaAnimation(0.7f, 0.0f);
        this.aLy.setDuration(500L);
        this.aLy.setAnimationListener(this.gNK);
        this.rootView.setOnClickListener(this);
        this.jJR = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccf() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cWl = this.jJH.autoPlay;
            this.jJP = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.jJO = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.gtY.le()) {
                cz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.gtY.getCurrentPosition());
                this.jJQ = true;
            }
            this.gtY.stopPlay();
            this.gtY.setIsNeedRecoveryVideoPlayer(true);
            this.gtY.rL(true);
            this.gtY.rH(false);
            this.gtY.rM(true);
            this.gtY.aj(false, true);
            this.gtY.An(i);
            this.gtY.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                }
            });
            this.gtY.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bGn() {
                    if (VideoMiddlePageAdView.this.jJH != null && VideoMiddlePageAdView.this.jJH.video != null && VideoMiddlePageAdView.this.jJH.video.video_height.intValue() > VideoMiddlePageAdView.this.jJH.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.gtY.aj(false, true);
                    } else {
                        VideoMiddlePageAdView.this.gtY.aj(false, true);
                    }
                    if (VideoMiddlePageAdView.this.jJN != null) {
                        VideoMiddlePageAdView.this.jJN.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AV(VideoMiddlePageAdView.this.cWl ? 0 : 1);
                    VideoMiddlePageAdView.this.jJP = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGo() {
                }
            });
            this.gtY.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z) {
                    VideoMiddlePageAdView.this.gtY.ei(VideoMiddlePageAdView.this.jJH.video.video_url, "");
                    if (VideoMiddlePageAdView.this.jJN != null) {
                        VideoMiddlePageAdView.this.jJN.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AV(1);
                    VideoMiddlePageAdView.this.jJP = false;
                }
            });
            this.gtY.rD(false);
            this.gtY.getVideoView().setBusiness(this.ekZ);
            this.gtY.ccG();
            this.gtY.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.gtY.bPO();
                    if (VideoMiddlePageAdView.this.jJM != null) {
                        VideoMiddlePageAdView.this.jJM.cDw();
                    }
                    VideoMiddlePageAdView.this.AW(VideoMiddlePageAdView.this.cWl ? 0 : 1);
                    VideoMiddlePageAdView.this.jJQ = true;
                }
            });
            this.gtY.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.AX(VideoMiddlePageAdView.this.cWl ? 0 : 1);
                    return true;
                }
            });
            this.gtY.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.gtY.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.gtY.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bGq() {
                    VideoMiddlePageAdView.this.cA(1, VideoMiddlePageAdView.this.gtY.getCurrentPosition());
                }
            });
            this.gtY.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cz(1, VideoMiddlePageAdView.this.gtY.getCurrentPosition());
                    VideoMiddlePageAdView.this.jJQ = true;
                }
            });
            this.gtY.bPO();
            this.gtY.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.gND.cub()) {
                    this.gtY.rJ(false);
                    this.gND.cSu();
                    this.gtY.rK(true);
                    this.gtY.eh(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.gtY.rK(false);
                    this.gtY.rJ(false);
                    this.gND.hide();
                    this.gtY.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.jJM != null) {
                    this.jJM.se(true);
                }
                if (i == 0) {
                    this.gNy.setVisibility(8);
                    this.jJD.setVisibility(8);
                } else {
                    this.gNy.startAnimation(this.aLy);
                    this.jJD.startAnimation(this.aLy);
                }
                if (i == 0) {
                    this.jJR.uu(3);
                    return;
                } else {
                    this.jJR.uu(0);
                    return;
                }
            }
            this.gND.hide();
            this.gtY.rJ(true);
            this.jJR.uu(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.gNy.startAnimation(this.aLy);
                this.jJD.startAnimation(this.aLy);
                return;
            }
            this.gNy.setVisibility(0);
            this.jJD.setVisibility(0);
        }
    }

    private boolean bLh() {
        try {
            int intValue = this.jJH.video.video_width.intValue();
            return intValue <= 0 || ((float) this.jJH.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.gtM.setTextColor(this.cVh.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJG.setTextColor(this.cVh.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJI.setTextColor(this.cVh.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jJJ.setTextColor(this.cVh.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.jJJ, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bLi() {
        if (!bLh()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtK.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.gtK.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtK.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.gtK.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jJH = videoMiddlePageAdCard;
        bLi();
        this.gtM.setText(videoMiddlePageAdCard.threadTitle);
        this.Nl.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.gtR.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.gtR.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.gtR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJh() || VideoMiddlePageAdView.this.jJH == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.jJH.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cVh.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.jJG.setText(videoMiddlePageAdCard.tagName);
        this.jJI.setText(videoMiddlePageAdCard.operateData.jHp);
        this.jJJ.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.jJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = s.b(VideoMiddlePageAdView.this.cVh, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.jJH == null || VideoMiddlePageAdView.this.jJH.getAdFacadeData() == null || VideoMiddlePageAdView.this.jJH.getAdFacadeData().kK() == null) ? null : VideoMiddlePageAdView.this.jJH.getAdFacadeData().kK().cMW);
                if (VideoMiddlePageAdView.this.jJM != null) {
                    VideoMiddlePageAdView.this.jJM.se(false);
                }
                if (VideoMiddlePageAdView.this.hYE != null) {
                    VideoMiddlePageAdView.this.hYE.b(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.jJH, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jJM = this.jJL.a(videoMiddlePageAdCard.tailFrame, this.jJM);
        if (this.jJM != null) {
            b(this.jJH.getAdFacadeData());
            this.jJM.setPageContext(this.cVh);
            this.jJM.setTimeoutListener(this);
            this.jJM.a(videoMiddlePageAdCard.tailFrame);
            this.jJM.c(this.jJH);
            this.jJM.cDx();
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
        this.gNA = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.jJN = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bq(View view) {
        this.DA.te(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bGl();
        if (this.gNy != null) {
            this.gNy.clearAnimation();
        }
        if (this.jJD != null) {
            this.jJD.clearAnimation();
        }
    }

    public void bGk() {
        this.gtY.stopPlay();
        if (this.gtM != null) {
            this.gtM.setVisibility(0);
        }
        if (this.jJR != null) {
            this.jJR.uu(2);
        }
        this.jJP = false;
        this.jJQ = true;
    }

    public void bGl() {
        if (this.gtY != null) {
            this.gtY.destroy();
        }
        this.jJP = false;
        this.jJQ = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNy && this.gNy.getVisibility() == 0) {
            if (this.gNA != null) {
                this.gNA.uy(this.mPosition);
            }
        } else if (view == this.jJD && this.jJD.getVisibility() == 0) {
            if (this.gNA != null) {
                this.gNA.uy(this.mPosition);
            }
        } else if (view == this.jJF || view == this.jJE) {
            if (this.gNy.getVisibility() == 0) {
                if (this.gNA != null) {
                    this.gNA.uy(this.mPosition);
                    return;
                }
                return;
            }
            this.jJR.uu(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.jGf = new WebVideoActivity.a();
            if (this.jJH.getAdFacadeData() != null) {
                WebVideoActivity.jGf.jGp = this.jJH.getAdFacadeData().kK();
                WebVideoActivity.jGf.mPage = "DETAIL";
                if (this.jJH.getAdFacadeData().Dm != null) {
                    WebVideoActivity.jGf.mPageNum = this.jJH.getAdFacadeData().Dm.kG();
                }
            }
            if (com.baidu.tieba.a.aVn().aVo() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cVh.getPageActivity(), "", this.jJH.getScheme(), true, true, true, this.jJH.video.video_url, this.jJH.video.thumbnail_url, 1.7777778f, this.jJO, this.jJH.getAdFacadeData().kK().cMW)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cVh.getPageActivity(), "", this.jJH.getScheme(), true, true, true, this.jJH.video.video_url, this.jJH.video.thumbnail_url, 1.7777778f, this.jJO)));
            }
            if (this.hYE != null) {
                this.hYE.b(0, null);
            }
            if (this.jJM != null) {
                this.jJM.se(false);
            }
        } else {
            String str = null;
            if (this.jJH.getAdFacadeData() != null && this.jJH.getAdFacadeData().kK() != null) {
                str = this.jJH.getAdFacadeData().kK().cMW;
            }
            int b = s.b(this.cVh, this.jJH.getScheme(), str);
            if (this.hYE != null) {
                this.hYE.b(b, null);
            }
            if (this.jJM != null) {
                this.jJM.se(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.oj(this.gtY.getCurrentPosition()) < this.jJO && this.gtY.getCurrentState() == 1) {
            cz(this.cWl ? 0 : 1, this.gtY.getCurrentPosition());
        }
        bGk();
        this.jJM.se(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.gtY.pausePlay();
            cz(this.cWl ? 0 : 1, this.gtY.getCurrentPosition());
            this.jJQ = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.gtY.le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV(int i) {
        if (this.jJH != null && this.jJH.video != null && this.jJH.getAdFacadeData() != null && this.jJQ) {
            com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(this.jJH.getAdFacadeData(), 31, this.jJH.getAdFacadeData().getPageNum(), i, this.jJO, 0, -1));
            this.jJQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW(int i) {
        if (this.jJH != null && this.jJH.video != null && this.jJH.getAdFacadeData() != null && !this.jJP) {
            com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(this.jJH.getAdFacadeData(), 34, this.jJH.getAdFacadeData().getPageNum(), i, this.jJO, this.jJO, -1));
            this.jJP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX(int i) {
        if (this.jJH != null && this.jJH.video != null && this.jJH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(this.jJH.getAdFacadeData(), 36, this.jJH.getAdFacadeData().getPageNum(), i, this.jJO, com.baidu.tieba.ad.a.a.oj(this.gtY.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i, int i2) {
        if (this.jJH != null && this.jJH.video != null && this.jJH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(this.jJH.getAdFacadeData(), 32, this.jJH.getAdFacadeData().getPageNum(), i, this.jJO, com.baidu.tieba.ad.a.a.oj(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(int i, int i2) {
        if (this.jJH != null && this.jJH.video != null && this.jJH.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(this.jJH.getAdFacadeData(), 33, this.jJH.getAdFacadeData().getPageNum(), i, this.jJO, com.baidu.tieba.ad.a.a.oj(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.jJH.getAdFacadeData(), 303, this.jJH.getAdFacadeData().getPageNum(), this.cWl ? 0 : 1, this.jJH.video.video_duration.intValue(), 0, -1);
            if (this.jJM != null) {
                this.jJM.e(a2);
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
        private Runnable gNR = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gNR);
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
                    bLs();
                    return;
                case 1:
                    this.mCurrentState = uv(i);
                    this.mHandler.removeCallbacks(this.gNR);
                    return;
                case 2:
                    this.mCurrentState = uw(i);
                    return;
                case 3:
                    this.mCurrentState = ux(i);
                    bLs();
                    return;
                default:
                    this.mCurrentState = uw(i);
                    return;
            }
        }

        private void bLs() {
            this.mHandler.removeCallbacks(this.gNR);
            this.mHandler.postDelayed(this.gNR, 3000L);
        }

        private int uv(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJF.setVisibility(8);
                VideoMiddlePageAdView.this.jJE.setVisibility(8);
                VideoMiddlePageAdView.this.sa(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uw(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJF.setVisibility(0);
                VideoMiddlePageAdView.this.jJE.setVisibility(0);
                if (VideoMiddlePageAdView.this.gtY != null) {
                    VideoMiddlePageAdView.this.gtY.cyo();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.jJH.autoPlay) {
                    VideoMiddlePageAdView.this.sa(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ux(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jJF.setVisibility(0);
                VideoMiddlePageAdView.this.jJE.setVisibility(0);
                VideoMiddlePageAdView.this.sa(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
