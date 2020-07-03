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
import com.baidu.tbadk.core.util.an;
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
    private com.baidu.tieba.frs.aggregation.a XR;
    public TextView ahA;
    private Animation btW;
    private Animation btX;
    private boolean dQI;
    private n fnj;
    public FrameLayout hFG;
    public FrameLayout hFH;
    public TextView hFI;
    public HeadImageView hFN;
    public c hFU;
    private View ibC;
    private View ibI;
    private com.baidu.tieba.frs.videomiddlepage.c ibK;
    private VideoNetworkStateTipView ibN;
    private Animation.AnimationListener ibU;
    private Animation.AnimationListener ibV;
    private View lhN;
    private View lhO;
    private View lhP;
    public TextView lhQ;
    private VideoMiddlePageAdCard lhR;
    private TextView lhS;
    private TextView lhT;
    private ViewGroup lhU;
    private d lhV;
    private e lhW;
    private f lhX;
    private int lhY;
    private boolean lhZ;
    private boolean lia;
    private a lib;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lhZ = false;
        this.lia = true;
        this.ibU = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ibI != null) {
                    VideoMiddlePageAdView.this.ibI.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lhN != null) {
                    VideoMiddlePageAdView.this.lhN.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ibI != null) {
                    VideoMiddlePageAdView.this.ibI.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lhN != null) {
                    VideoMiddlePageAdView.this.lhN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ibV = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ibI != null) {
                    VideoMiddlePageAdView.this.ibI.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.lhN != null) {
                    VideoMiddlePageAdView.this.lhN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ibI != null) {
                    VideoMiddlePageAdView.this.ibI.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.lhN != null) {
                    VideoMiddlePageAdView.this.lhN.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lhZ = false;
        this.lia = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.hFG = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.ibC = this.rootView.findViewById(R.id.card_container);
        this.hFH = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.hFU = new c(this.dPv, this.hFH, false);
        this.hFU.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.hFU != null && VideoMiddlePageAdView.this.hFU.getVideoView() != null) {
                    VideoMiddlePageAdView.this.lhY = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.hFU.getVideoView().getDuration());
                }
            }
        });
        this.hFU.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void oc(boolean z) {
                if (VideoMiddlePageAdView.this.lib != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.lib.wm(0);
                    } else {
                        VideoMiddlePageAdView.this.lib.wm(1);
                    }
                }
            }
        });
        this.hFU.jrJ.setOnTouchListener(null);
        this.hFI = (TextView) this.rootView.findViewById(R.id.title);
        this.hFN = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.hFN.setIsRound(true);
        this.hFN.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFN.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.lhQ = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ahA = (TextView) this.rootView.findViewById(R.id.user_name);
        this.fnj = new n(this.dPv.getPageActivity());
        this.lhS = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.lhT = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.lhU = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.lhV = new d(this.dPv.getPageActivity(), this.lhU);
        this.lhV.page = 1;
        this.ibN = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.ibN.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.ibN.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.hFU.tG(false);
                VideoMiddlePageAdView.this.ibN.dpG();
                if (VideoMiddlePageAdView.this.lhR != null && VideoMiddlePageAdView.this.lhR.video != null) {
                    VideoMiddlePageAdView.this.hFU.fd(VideoMiddlePageAdView.this.lhR.video.video_url, "");
                }
            }
        });
        this.ibI = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.lhO = this.rootView.findViewById(R.id.user_container_foreground);
        this.lhP = this.rootView.findViewById(R.id.title_foreground);
        this.lhN = this.rootView.findViewById(R.id.operate_area_foreground);
        this.ibI.setOnClickListener(this);
        this.lhO.setOnClickListener(this);
        this.lhP.setOnClickListener(this);
        this.lhN.setOnClickListener(this);
        this.hFH.setOnClickListener(this);
        this.hFG.setOnClickListener(this);
        this.hFU.Z(this);
        this.hFI.setOnClickListener(this);
        this.hFN.setOnClickListener(this);
        this.ahA.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.dPv.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFG.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hFG.setLayoutParams(layoutParams);
        this.btW = new AlphaAnimation(0.0f, 0.7f);
        this.btW.setDuration(500L);
        this.btW.setAnimationListener(this.ibV);
        this.btX = new AlphaAnimation(0.7f, 0.0f);
        this.btX.setDuration(500L);
        this.btX.setAnimationListener(this.ibU);
        this.rootView.setOnClickListener(this);
        this.lib = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cxy() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dQI = this.lhR.autoPlay;
            this.lhZ = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.lhY = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.hFU.qf()) {
                cR(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.hFU.getCurrentPosition());
                this.lia = true;
            }
            this.hFU.stopPlay();
            this.hFU.setIsNeedRecoveryVideoPlayer(true);
            this.hFU.tH(true);
            this.hFU.tD(false);
            this.hFU.tI(true);
            this.hFU.ao(false, true);
            this.hFU.CJ(i);
            this.hFU.a(new c.InterfaceC0720c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qd() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qe() {
                }
            });
            this.hFU.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void caJ() {
                    if (VideoMiddlePageAdView.this.lhR != null && VideoMiddlePageAdView.this.lhR.video != null && VideoMiddlePageAdView.this.lhR.video.video_height.intValue() > VideoMiddlePageAdView.this.lhR.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.hFU.ao(false, true);
                    } else {
                        VideoMiddlePageAdView.this.hFU.ao(false, true);
                    }
                    if (VideoMiddlePageAdView.this.lhX != null) {
                        VideoMiddlePageAdView.this.lhX.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Dr(VideoMiddlePageAdView.this.dQI ? 0 : 1);
                    VideoMiddlePageAdView.this.lhZ = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void caK() {
                }
            });
            this.hFU.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void nw(boolean z) {
                    VideoMiddlePageAdView.this.hFU.fd(VideoMiddlePageAdView.this.lhR.video.video_url, "");
                    if (VideoMiddlePageAdView.this.lhX != null) {
                        VideoMiddlePageAdView.this.lhX.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Dr(1);
                    VideoMiddlePageAdView.this.lhZ = false;
                }
            });
            this.hFU.tz(false);
            this.hFU.getVideoView().setBusiness(this.fnj);
            this.hFU.cxZ();
            this.hFU.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.hFU.cla();
                    if (VideoMiddlePageAdView.this.lhW != null) {
                        VideoMiddlePageAdView.this.lhW.cZX();
                    }
                    VideoMiddlePageAdView.this.Ds(VideoMiddlePageAdView.this.dQI ? 0 : 1);
                    VideoMiddlePageAdView.this.lia = true;
                }
            });
            this.hFU.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Dt(VideoMiddlePageAdView.this.dQI ? 0 : 1);
                    return true;
                }
            });
            this.hFU.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.hFU.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.hFU.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void caM() {
                    VideoMiddlePageAdView.this.cS(1, VideoMiddlePageAdView.this.hFU.getCurrentPosition());
                }
            });
            this.hFU.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cR(1, VideoMiddlePageAdView.this.hFU.getCurrentPosition());
                    VideoMiddlePageAdView.this.lia = true;
                }
            });
            this.hFU.cla();
            this.hFU.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.ibN.cQE()) {
                    this.hFU.tF(false);
                    this.ibN.dpF();
                    this.hFU.tG(true);
                    this.hFU.fc(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.hFU.tG(false);
                    this.hFU.tF(false);
                    this.ibN.hide();
                    this.hFU.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.lhW != null) {
                    this.lhW.tY(true);
                }
                if (i == 0) {
                    this.ibI.setVisibility(8);
                    this.lhN.setVisibility(8);
                } else {
                    this.ibI.startAnimation(this.btX);
                    this.lhN.startAnimation(this.btX);
                }
                if (i == 0) {
                    this.lib.wm(3);
                    return;
                } else {
                    this.lib.wm(0);
                    return;
                }
            }
            this.ibN.hide();
            this.hFU.tF(true);
            this.lib.wm(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.ibI.startAnimation(this.btX);
                this.lhN.startAnimation(this.btX);
                return;
            }
            this.ibI.setVisibility(0);
            this.lhN.setVisibility(0);
        }
    }

    private boolean cga() {
        try {
            int intValue = this.lhR.video.video_width.intValue();
            return intValue <= 0 || ((float) this.lhR.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.hFI.setTextColor(this.dPv.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lhQ.setTextColor(this.dPv.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lhS.setTextColor(this.dPv.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.lhT.setTextColor(this.dPv.getResources().getColor(R.color.cp_cont_i_alpha70));
        an.setBackgroundResource(this.lhT, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cgb() {
        if (!cga()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFG.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hFG.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hFG.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hFG.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lhR = videoMiddlePageAdCard;
        cgb();
        this.hFI.setText(videoMiddlePageAdCard.threadTitle);
        this.ahA.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.hFN.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.hFN.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.hFN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aZT() || VideoMiddlePageAdView.this.lhR == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.lhR.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.dPv.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.lhQ.setText(videoMiddlePageAdCard.tagName);
        this.lhS.setText(videoMiddlePageAdCard.operateData.lfN);
        this.lhT.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.lhT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = r.c(VideoMiddlePageAdView.this.dPv, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.lhR == null || VideoMiddlePageAdView.this.lhR.getAdFacadeData() == null || VideoMiddlePageAdView.this.lhR.getAdFacadeData().pL() == null) ? null : VideoMiddlePageAdView.this.lhR.getAdFacadeData().pL().dGL);
                if (VideoMiddlePageAdView.this.lhW != null) {
                    VideoMiddlePageAdView.this.lhW.tY(false);
                }
                if (VideoMiddlePageAdView.this.jrl != null) {
                    VideoMiddlePageAdView.this.jrl.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.lhR, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.lhW = this.lhV.a(videoMiddlePageAdCard.tailFrame, this.lhW);
        if (this.lhW != null) {
            b(this.lhR.getAdFacadeData());
            this.lhW.setPageContext(this.dPv);
            this.lhW.setTimeoutListener(this);
            this.lhW.a(videoMiddlePageAdCard.tailFrame);
            this.lhW.c(this.lhR);
            this.lhW.cZY();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.XR = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.XR;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.ibK = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.lhX = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bv(View view) {
        this.XR.uQ(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        caH();
        if (this.ibI != null) {
            this.ibI.clearAnimation();
        }
        if (this.lhN != null) {
            this.lhN.clearAnimation();
        }
    }

    public void caG() {
        this.hFU.stopPlay();
        if (this.hFI != null) {
            this.hFI.setVisibility(0);
        }
        if (this.lib != null) {
            this.lib.wm(2);
        }
        this.lhZ = false;
        this.lia = true;
    }

    public void caH() {
        if (this.hFU != null) {
            this.hFU.destroy();
        }
        this.lhZ = false;
        this.lia = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ibI && this.ibI.getVisibility() == 0) {
            if (this.ibK != null) {
                this.ibK.wq(this.mPosition);
            }
        } else if (view == this.lhN && this.lhN.getVisibility() == 0) {
            if (this.ibK != null) {
                this.ibK.wq(this.mPosition);
            }
        } else if (view == this.lhP || view == this.lhO) {
            if (this.ibI.getVisibility() == 0) {
                if (this.ibK != null) {
                    this.ibK.wq(this.mPosition);
                    return;
                }
                return;
            }
            this.lib.wm(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.leB = new WebVideoActivity.a();
            if (this.lhR.getAdFacadeData() != null) {
                WebVideoActivity.leB.leM = this.lhR.getAdFacadeData().pL();
                WebVideoActivity.leB.mPage = "DETAIL";
                if (this.lhR.getAdFacadeData().XD != null) {
                    WebVideoActivity.leB.mPageNum = this.lhR.getAdFacadeData().XD.pH();
                }
            }
            if (com.baidu.tieba.a.bmm().bmn() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.dPv.getPageActivity(), "", this.lhR.getScheme(), true, true, true, this.lhR.video.video_url, this.lhR.video.thumbnail_url, 1.7777778f, this.lhY, this.lhR.getAdFacadeData().pL().dGL)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.dPv.getPageActivity(), "", this.lhR.getScheme(), true, true, true, this.lhR.video.video_url, this.lhR.video.thumbnail_url, 1.7777778f, this.lhY)));
            }
            if (this.jrl != null) {
                this.jrl.d(0, null);
            }
            if (this.lhW != null) {
                this.lhW.tY(false);
            }
        } else {
            String str = null;
            if (this.lhR.getAdFacadeData() != null && this.lhR.getAdFacadeData().pL() != null) {
                str = this.lhR.getAdFacadeData().pL().dGL;
            }
            int c = r.c(this.dPv, this.lhR.getScheme(), str);
            if (this.jrl != null) {
                this.jrl.d(c, null);
            }
            if (this.lhW != null) {
                this.lhW.tY(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.pG(this.hFU.getCurrentPosition()) < this.lhY && this.hFU.getCurrentState() == 1) {
            cR(this.dQI ? 0 : 1, this.hFU.getCurrentPosition());
        }
        caG();
        this.lhW.tY(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void awZ() {
        if (isPlaying()) {
            this.hFU.awZ();
            cR(this.dQI ? 0 : 1, this.hFU.getCurrentPosition());
            this.lia = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hFU.qf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr(int i) {
        if (this.lhR != null && this.lhR.video != null && this.lhR.getAdFacadeData() != null && this.lia) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this.lhR.getAdFacadeData(), 31, this.lhR.getAdFacadeData().getPageNum(), i, this.lhY, 0, -1));
            this.lia = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(int i) {
        if (this.lhR != null && this.lhR.video != null && this.lhR.getAdFacadeData() != null && !this.lhZ) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this.lhR.getAdFacadeData(), 34, this.lhR.getAdFacadeData().getPageNum(), i, this.lhY, this.lhY, -1));
            this.lhZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dt(int i) {
        if (this.lhR != null && this.lhR.video != null && this.lhR.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this.lhR.getAdFacadeData(), 36, this.lhR.getAdFacadeData().getPageNum(), i, this.lhY, com.baidu.tieba.ad.a.a.pG(this.hFU.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(int i, int i2) {
        if (this.lhR != null && this.lhR.video != null && this.lhR.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this.lhR.getAdFacadeData(), 32, this.lhR.getAdFacadeData().getPageNum(), i, this.lhY, com.baidu.tieba.ad.a.a.pG(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(int i, int i2) {
        if (this.lhR != null && this.lhR.video != null && this.lhR.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this.lhR.getAdFacadeData(), 33, this.lhR.getAdFacadeData().getPageNum(), i, this.lhY, com.baidu.tieba.ad.a.a.pG(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(this.lhR.getAdFacadeData(), 303, this.lhR.getAdFacadeData().getPageNum(), this.dQI ? 0 : 1, this.lhR.video.video_duration.intValue(), 0, -1);
            if (this.lhW != null) {
                this.lhW.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW(boolean z) {
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
        private Runnable icb = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.icb);
                a.this.wm(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void wm(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = wn(i);
                    cgl();
                    return;
                case 1:
                    this.mCurrentState = wn(i);
                    this.mHandler.removeCallbacks(this.icb);
                    return;
                case 2:
                    this.mCurrentState = wo(i);
                    return;
                case 3:
                    this.mCurrentState = wp(i);
                    cgl();
                    return;
                default:
                    this.mCurrentState = wo(i);
                    return;
            }
        }

        private void cgl() {
            this.mHandler.removeCallbacks(this.icb);
            this.mHandler.postDelayed(this.icb, 3000L);
        }

        private int wn(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.lhP.setVisibility(8);
                VideoMiddlePageAdView.this.lhO.setVisibility(8);
                VideoMiddlePageAdView.this.tW(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int wo(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.lhP.setVisibility(0);
                VideoMiddlePageAdView.this.lhO.setVisibility(0);
                if (VideoMiddlePageAdView.this.hFU != null) {
                    VideoMiddlePageAdView.this.hFU.cUR();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.lhR.autoPlay) {
                    VideoMiddlePageAdView.this.tW(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int wp(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.lhP.setVisibility(0);
                VideoMiddlePageAdView.this.lhO.setVisibility(0);
                VideoMiddlePageAdView.this.tW(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
