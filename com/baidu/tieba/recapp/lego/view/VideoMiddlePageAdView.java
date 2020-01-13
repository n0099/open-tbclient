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
/* loaded from: classes11.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Dh;
    public TextView MK;
    private Animation aHr;
    private Animation aHs;
    private boolean cSi;
    private n egU;
    private VideoNetworkStateTipView gLC;
    private Animation.AnimationListener gLJ;
    private Animation.AnimationListener gLK;
    private View gLr;
    private View gLx;
    private c gLz;
    public FrameLayout grH;
    public FrameLayout grI;
    public TextView grJ;
    public HeadImageView grO;
    public com.baidu.tieba.play.c grV;
    private View jIA;
    private View jIB;
    private View jIC;
    public TextView jID;
    private VideoMiddlePageAdCard jIE;
    private TextView jIF;
    private TextView jIG;
    private ViewGroup jIH;
    private d jII;
    private e jIJ;
    private f jIK;
    private int jIL;
    private boolean jIM;
    private boolean jIN;
    private a jIO;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jIM = false;
        this.jIN = true;
        this.gLJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gLx != null) {
                    VideoMiddlePageAdView.this.gLx.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jIA != null) {
                    VideoMiddlePageAdView.this.jIA.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gLx != null) {
                    VideoMiddlePageAdView.this.gLx.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jIA != null) {
                    VideoMiddlePageAdView.this.jIA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gLK = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.gLx != null) {
                    VideoMiddlePageAdView.this.gLx.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.jIA != null) {
                    VideoMiddlePageAdView.this.jIA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.gLx != null) {
                    VideoMiddlePageAdView.this.gLx.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.jIA != null) {
                    VideoMiddlePageAdView.this.jIA.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jIM = false;
        this.jIN = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.grH = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.gLr = this.rootView.findViewById(R.id.card_container);
        this.grI = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.grV = new com.baidu.tieba.play.c(this.cRe, this.grI, false);
        this.grV.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (VideoMiddlePageAdView.this.grV != null && VideoMiddlePageAdView.this.grV.getVideoView() != null) {
                    VideoMiddlePageAdView.this.jIL = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.grV.getVideoView().getDuration());
                }
            }
        });
        this.grV.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void mj(boolean z) {
                if (VideoMiddlePageAdView.this.jIO != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.jIO.uo(0);
                    } else {
                        VideoMiddlePageAdView.this.jIO.uo(1);
                    }
                }
            }
        });
        this.grV.hXc.setOnTouchListener(null);
        this.grJ = (TextView) this.rootView.findViewById(R.id.title);
        this.grO = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.grO.setIsRound(true);
        this.grO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.grO.setDefaultResource(R.drawable.icon_default_avatar100);
        this.grO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jID = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.MK = (TextView) this.rootView.findViewById(R.id.user_name);
        this.egU = new n(this.cRe.getPageActivity());
        this.jIF = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.jIG = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.jIH = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.jII = new d(this.cRe.getPageActivity(), this.jIH);
        this.jII.page = 1;
        this.gLC = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.gLC.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.gLC.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.grV.rH(false);
                VideoMiddlePageAdView.this.gLC.cQY();
                if (VideoMiddlePageAdView.this.jIE != null && VideoMiddlePageAdView.this.jIE.video != null) {
                    VideoMiddlePageAdView.this.grV.dZ(VideoMiddlePageAdView.this.jIE.video.video_url, "");
                }
            }
        });
        this.gLx = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.jIB = this.rootView.findViewById(R.id.user_container_foreground);
        this.jIC = this.rootView.findViewById(R.id.title_foreground);
        this.jIA = this.rootView.findViewById(R.id.operate_area_foreground);
        this.gLx.setOnClickListener(this);
        this.jIB.setOnClickListener(this);
        this.jIC.setOnClickListener(this);
        this.jIA.setOnClickListener(this);
        this.grI.setOnClickListener(this);
        this.grH.setOnClickListener(this);
        this.grV.Y(this);
        this.grJ.setOnClickListener(this);
        this.grO.setOnClickListener(this);
        this.MK.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.cRe.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grH.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.grH.setLayoutParams(layoutParams);
        this.aHr = new AlphaAnimation(0.0f, 0.7f);
        this.aHr.setDuration(500L);
        this.aHr.setAnimationListener(this.gLK);
        this.aHs = new AlphaAnimation(0.7f, 0.0f);
        this.aHs.setDuration(500L);
        this.aHs.setAnimationListener(this.gLJ);
        this.rootView.setOnClickListener(this);
        this.jIO = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View caC() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.cSi = this.jIE.autoPlay;
            this.jIM = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.jIL = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.grV.kP()) {
                cy(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.grV.getCurrentPosition());
                this.jIN = true;
            }
            this.grV.stopPlay();
            this.grV.setIsNeedRecoveryVideoPlayer(true);
            this.grV.rI(true);
            this.grV.rE(false);
            this.grV.rJ(true);
            this.grV.ah(false, true);
            this.grV.Ae(i);
            this.grV.a(new c.InterfaceC0581c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kN() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kO() {
                }
            });
            this.grV.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void bEJ() {
                    if (VideoMiddlePageAdView.this.jIE != null && VideoMiddlePageAdView.this.jIE.video != null && VideoMiddlePageAdView.this.jIE.video.video_height.intValue() > VideoMiddlePageAdView.this.jIE.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.grV.ah(false, true);
                    } else {
                        VideoMiddlePageAdView.this.grV.ah(false, true);
                    }
                    if (VideoMiddlePageAdView.this.jIK != null) {
                        VideoMiddlePageAdView.this.jIK.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AM(VideoMiddlePageAdView.this.cSi ? 0 : 1);
                    VideoMiddlePageAdView.this.jIM = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bEK() {
                }
            });
            this.grV.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void lE(boolean z) {
                    VideoMiddlePageAdView.this.grV.dZ(VideoMiddlePageAdView.this.jIE.video.video_url, "");
                    if (VideoMiddlePageAdView.this.jIK != null) {
                        VideoMiddlePageAdView.this.jIK.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.AM(1);
                    VideoMiddlePageAdView.this.jIM = false;
                }
            });
            this.grV.rA(false);
            this.grV.getVideoView().setBusiness(this.egU);
            this.grV.cbd();
            this.grV.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.grV.bOk();
                    if (VideoMiddlePageAdView.this.jIJ != null) {
                        VideoMiddlePageAdView.this.jIJ.cBW();
                    }
                    VideoMiddlePageAdView.this.AN(VideoMiddlePageAdView.this.cSi ? 0 : 1);
                    VideoMiddlePageAdView.this.jIN = true;
                }
            });
            this.grV.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.AO(VideoMiddlePageAdView.this.cSi ? 0 : 1);
                    return true;
                }
            });
            this.grV.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.grV.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.grV.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bEM() {
                    VideoMiddlePageAdView.this.cz(1, VideoMiddlePageAdView.this.grV.getCurrentPosition());
                }
            });
            this.grV.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cy(1, VideoMiddlePageAdView.this.grV.getCurrentPosition());
                    VideoMiddlePageAdView.this.jIN = true;
                }
            });
            this.grV.bOk();
            this.grV.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.gLC.csC()) {
                    this.grV.rG(false);
                    this.gLC.cQX();
                    this.grV.rH(true);
                    this.grV.dY(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.grV.rH(false);
                    this.grV.rG(false);
                    this.gLC.hide();
                    this.grV.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.jIJ != null) {
                    this.jIJ.sb(true);
                }
                if (i == 0) {
                    this.gLx.setVisibility(8);
                    this.jIA.setVisibility(8);
                } else {
                    this.gLx.startAnimation(this.aHs);
                    this.jIA.startAnimation(this.aHs);
                }
                if (i == 0) {
                    this.jIO.uo(3);
                    return;
                } else {
                    this.jIO.uo(0);
                    return;
                }
            }
            this.gLC.hide();
            this.grV.rG(true);
            this.jIO.uo(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.gLx.startAnimation(this.aHs);
                this.jIA.startAnimation(this.aHs);
                return;
            }
            this.gLx.setVisibility(0);
            this.jIA.setVisibility(0);
        }
    }

    private boolean bJE() {
        try {
            int intValue = this.jIE.video.video_width.intValue();
            return intValue <= 0 || ((float) this.jIE.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.grJ.setTextColor(this.cRe.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jID.setTextColor(this.cRe.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jIF.setTextColor(this.cRe.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.jIG.setTextColor(this.cRe.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.setBackgroundResource(this.jIG, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bJF() {
        if (!bJE()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grH.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.grH.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.grH.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.grH.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jIE = videoMiddlePageAdCard;
        bJF();
        this.grJ.setText(videoMiddlePageAdCard.threadTitle);
        this.MK.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.grO.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.grO.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.grO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aGR() || VideoMiddlePageAdView.this.jIE == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.jIE.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.cRe.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.jID.setText(videoMiddlePageAdCard.tagName);
        this.jIF.setText(videoMiddlePageAdCard.operateData.jGr);
        this.jIG.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.jIG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int b = s.b(VideoMiddlePageAdView.this.cRe, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.jIE == null || VideoMiddlePageAdView.this.jIE.getAdFacadeData() == null || VideoMiddlePageAdView.this.jIE.getAdFacadeData().kv() == null) ? null : VideoMiddlePageAdView.this.jIE.getAdFacadeData().kv().cIS);
                if (VideoMiddlePageAdView.this.jIJ != null) {
                    VideoMiddlePageAdView.this.jIJ.sb(false);
                }
                if (VideoMiddlePageAdView.this.hWE != null) {
                    VideoMiddlePageAdView.this.hWE.b(b, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.jIE, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.jIJ = this.jII.a(videoMiddlePageAdCard.tailFrame, this.jIJ);
        if (this.jIJ != null) {
            b(this.jIE.getAdFacadeData());
            this.jIJ.setPageContext(this.cRe);
            this.jIJ.setTimeoutListener(this);
            this.jIJ.a(videoMiddlePageAdCard.tailFrame);
            this.jIJ.c(this.jIE);
            this.jIJ.cBX();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Dh = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Dh;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.gLz = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.jIK = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bq(View view) {
        this.Dh.sY(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bEH();
        if (this.gLx != null) {
            this.gLx.clearAnimation();
        }
        if (this.jIA != null) {
            this.jIA.clearAnimation();
        }
    }

    public void bEG() {
        this.grV.stopPlay();
        if (this.grJ != null) {
            this.grJ.setVisibility(0);
        }
        if (this.jIO != null) {
            this.jIO.uo(2);
        }
        this.jIM = false;
        this.jIN = true;
    }

    public void bEH() {
        if (this.grV != null) {
            this.grV.destroy();
        }
        this.jIM = false;
        this.jIN = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gLx && this.gLx.getVisibility() == 0) {
            if (this.gLz != null) {
                this.gLz.us(this.mPosition);
            }
        } else if (view == this.jIA && this.jIA.getVisibility() == 0) {
            if (this.gLz != null) {
                this.gLz.us(this.mPosition);
            }
        } else if (view == this.jIC || view == this.jIB) {
            if (this.gLx.getVisibility() == 0) {
                if (this.gLz != null) {
                    this.gLz.us(this.mPosition);
                    return;
                }
                return;
            }
            this.jIO.uo(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.jFh = new WebVideoActivity.a();
            if (this.jIE.getAdFacadeData() != null) {
                WebVideoActivity.jFh.jFr = this.jIE.getAdFacadeData().kv();
                WebVideoActivity.jFh.mPage = "DETAIL";
                if (this.jIE.getAdFacadeData().CT != null) {
                    WebVideoActivity.jFh.mPageNum = this.jIE.getAdFacadeData().CT.kr();
                }
            }
            if (com.baidu.tieba.a.aSU().aSV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewWebVideoActivityConfig(this.cRe.getPageActivity(), "", this.jIE.getScheme(), true, true, true, this.jIE.video.video_url, this.jIE.video.thumbnail_url, 1.7777778f, this.jIL, this.jIE.getAdFacadeData().kv().cIS)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WebVideoActivityConfig(this.cRe.getPageActivity(), "", this.jIE.getScheme(), true, true, true, this.jIE.video.video_url, this.jIE.video.thumbnail_url, 1.7777778f, this.jIL)));
            }
            if (this.hWE != null) {
                this.hWE.b(0, null);
            }
            if (this.jIJ != null) {
                this.jIJ.sb(false);
            }
        } else {
            String str = null;
            if (this.jIE.getAdFacadeData() != null && this.jIE.getAdFacadeData().kv() != null) {
                str = this.jIE.getAdFacadeData().kv().cIS;
            }
            int b = s.b(this.cRe, this.jIE.getScheme(), str);
            if (this.hWE != null) {
                this.hWE.b(b, null);
            }
            if (this.jIJ != null) {
                this.jIJ.sb(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.nS(this.grV.getCurrentPosition()) < this.jIL && this.grV.getCurrentState() == 1) {
            cy(this.cSi ? 0 : 1, this.grV.getCurrentPosition());
        }
        bEG();
        this.jIJ.sb(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.grV.pausePlay();
            cy(this.cSi ? 0 : 1, this.grV.getCurrentPosition());
            this.jIN = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.grV.kP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(int i) {
        if (this.jIE != null && this.jIE.video != null && this.jIE.getAdFacadeData() != null && this.jIN) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(this.jIE.getAdFacadeData(), 31, this.jIE.getAdFacadeData().getPageNum(), i, this.jIL, 0, -1));
            this.jIN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(int i) {
        if (this.jIE != null && this.jIE.video != null && this.jIE.getAdFacadeData() != null && !this.jIM) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(this.jIE.getAdFacadeData(), 34, this.jIE.getAdFacadeData().getPageNum(), i, this.jIL, this.jIL, -1));
            this.jIM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO(int i) {
        if (this.jIE != null && this.jIE.video != null && this.jIE.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(this.jIE.getAdFacadeData(), 36, this.jIE.getAdFacadeData().getPageNum(), i, this.jIL, com.baidu.tieba.ad.a.a.nS(this.grV.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(int i, int i2) {
        if (this.jIE != null && this.jIE.video != null && this.jIE.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(this.jIE.getAdFacadeData(), 32, this.jIE.getAdFacadeData().getPageNum(), i, this.jIL, com.baidu.tieba.ad.a.a.nS(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i, int i2) {
        if (this.jIE != null && this.jIE.video != null && this.jIE.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(this.jIE.getAdFacadeData(), 33, this.jIE.getAdFacadeData().getPageNum(), i, this.jIL, com.baidu.tieba.ad.a.a.nS(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.jIE.getAdFacadeData(), 303, this.jIE.getAdFacadeData().getPageNum(), this.cSi ? 0 : 1, this.jIE.video.video_duration.intValue(), 0, -1);
            if (this.jIJ != null) {
                this.jIJ.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rX(boolean z) {
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
    /* loaded from: classes11.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable gLQ = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gLQ);
                a.this.uo(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void uo(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = up(i);
                    bJP();
                    return;
                case 1:
                    this.mCurrentState = up(i);
                    this.mHandler.removeCallbacks(this.gLQ);
                    return;
                case 2:
                    this.mCurrentState = uq(i);
                    return;
                case 3:
                    this.mCurrentState = ur(i);
                    bJP();
                    return;
                default:
                    this.mCurrentState = uq(i);
                    return;
            }
        }

        private void bJP() {
            this.mHandler.removeCallbacks(this.gLQ);
            this.mHandler.postDelayed(this.gLQ, 3000L);
        }

        private int up(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jIC.setVisibility(8);
                VideoMiddlePageAdView.this.jIB.setVisibility(8);
                VideoMiddlePageAdView.this.rX(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uq(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jIC.setVisibility(0);
                VideoMiddlePageAdView.this.jIB.setVisibility(0);
                if (VideoMiddlePageAdView.this.grV != null) {
                    VideoMiddlePageAdView.this.grV.cwR();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.jIE.autoPlay) {
                    VideoMiddlePageAdView.this.rX(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ur(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.jIC.setVisibility(0);
                VideoMiddlePageAdView.this.jIB.setVisibility(0);
                VideoMiddlePageAdView.this.rX(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
