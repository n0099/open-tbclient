package com.baidu.tieba.recapp.lego.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.play.c;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.d.d;
import com.baidu.tieba.recapp.d.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, k, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a abZ;
    public TextView alr;
    private Animation cjx;
    private Animation cjy;
    private boolean eYE;
    private View jOg;
    private View jOm;
    private c jOo;
    private VideoNetworkStateTipView jOr;
    private Animation.AnimationListener jOy;
    private Animation.AnimationListener jOz;
    public FrameLayout joZ;
    public FrameLayout jpa;
    public TextView jpb;
    public HeadImageView jpg;
    public com.baidu.tieba.play.c jpo;
    private int mWidth;
    private View mXB;
    private View mXC;
    private View mXD;
    public TextView mXE;
    private VideoMiddlePageAdCard mXF;
    private TextView mXG;
    private TextView mXH;
    private ViewGroup mXI;
    private d mXJ;
    private e mXK;
    private f mXL;
    private int mXM;
    private boolean mXN;
    private boolean mXO;
    private a mXP;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mXN = false;
        this.mXO = true;
        this.jOy = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jOm != null) {
                    VideoMiddlePageAdView.this.jOm.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mXB != null) {
                    VideoMiddlePageAdView.this.mXB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jOm != null) {
                    VideoMiddlePageAdView.this.jOm.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mXB != null) {
                    VideoMiddlePageAdView.this.mXB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOz = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.jOm != null) {
                    VideoMiddlePageAdView.this.jOm.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.mXB != null) {
                    VideoMiddlePageAdView.this.mXB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.jOm != null) {
                    VideoMiddlePageAdView.this.jOm.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.mXB != null) {
                    VideoMiddlePageAdView.this.mXB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mXN = false;
        this.mXO = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.joZ = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.jOg = this.rootView.findViewById(R.id.card_container);
        this.jpa = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.jpo = new com.baidu.tieba.play.c(this.eWx, this.jpa, false);
        this.jpo.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.jpo.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.jpo != null && VideoMiddlePageAdView.this.jpo.getVideoView() != null) {
                    VideoMiddlePageAdView.this.mXM = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.jpo.getVideoView().getDuration());
                }
            }
        });
        this.jpo.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void rI(boolean z) {
                if (VideoMiddlePageAdView.this.mXP != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.mXP.AM(0);
                    } else {
                        VideoMiddlePageAdView.this.mXP.AM(1);
                    }
                }
            }
        });
        this.jpo.bWp.setOnTouchListener(null);
        this.jpb = (TextView) this.rootView.findViewById(R.id.title);
        this.jpg = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.jpg.setIsRound(true);
        this.jpg.setDefaultBgResource(R.color.CAM_X0205);
        this.jpg.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mXE = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.alr = (TextView) this.rootView.findViewById(R.id.user_name);
        this.mXG = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.mXH = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mXI = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mXJ = new d(this.eWx.getPageActivity(), this.mXI);
        this.mXJ.page = 1;
        this.jOr = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.jOr.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.jOr.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.jpo.xl(false);
                VideoMiddlePageAdView.this.jOr.dVu();
                if (VideoMiddlePageAdView.this.mXF != null && VideoMiddlePageAdView.this.mXF.video != null) {
                    VideoMiddlePageAdView.this.jpo.fX(VideoMiddlePageAdView.this.mXF.video.video_url, "");
                }
            }
        });
        this.jOm = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mXC = this.rootView.findViewById(R.id.user_container_foreground);
        this.mXD = this.rootView.findViewById(R.id.title_foreground);
        this.mXB = this.rootView.findViewById(R.id.operate_area_foreground);
        this.jOm.setOnClickListener(this);
        this.mXC.setOnClickListener(this);
        this.mXD.setOnClickListener(this);
        this.mXB.setOnClickListener(this);
        this.jpa.setOnClickListener(this);
        this.joZ.setOnClickListener(this);
        this.jpo.ae(this);
        this.jpb.setOnClickListener(this);
        this.jpg.setOnClickListener(this);
        this.alr.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.eWx.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.joZ.setLayoutParams(layoutParams);
        this.cjx = new AlphaAnimation(0.0f, 0.7f);
        this.cjx.setDuration(500L);
        this.cjx.setAnimationListener(this.jOz);
        this.cjy = new AlphaAnimation(0.7f, 0.0f);
        this.cjy.setDuration(500L);
        this.cjy.setAnimationListener(this.jOy);
        this.rootView.setOnClickListener(this);
        this.mXP = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.eYE = this.mXF.autoPlay;
            this.mXN = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.mXM = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.jpo.rl()) {
                dh(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.jpo.getCurrentPosition());
                this.mXO = true;
            }
            this.jpo.stopPlay();
            this.jpo.xm(true);
            this.jpo.xi(false);
            this.jpo.xn(true);
            this.jpo.ax(false, true);
            this.jpo.Hp(i);
            this.jpo.a(new c.InterfaceC0855c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rj() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rk() {
                }
            });
            this.jpo.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cFB() {
                    if (VideoMiddlePageAdView.this.mXF != null && VideoMiddlePageAdView.this.mXF.video != null && VideoMiddlePageAdView.this.mXF.video.video_height.intValue() > VideoMiddlePageAdView.this.mXF.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.jpo.ax(false, true);
                    } else {
                        VideoMiddlePageAdView.this.jpo.ax(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mXL != null) {
                        VideoMiddlePageAdView.this.mXL.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HX(VideoMiddlePageAdView.this.eYE ? 0 : 1);
                    VideoMiddlePageAdView.this.mXN = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFC() {
                }
            });
            this.jpo.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z) {
                    VideoMiddlePageAdView.this.jpo.fX(VideoMiddlePageAdView.this.mXF.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mXL != null) {
                        VideoMiddlePageAdView.this.mXL.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.HX(1);
                    VideoMiddlePageAdView.this.mXN = false;
                }
            });
            this.jpo.xd(false);
            this.jpo.dcE();
            this.jpo.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.jpo.cSR();
                    if (VideoMiddlePageAdView.this.mXK != null) {
                        VideoMiddlePageAdView.this.mXK.dEJ();
                    }
                    VideoMiddlePageAdView.this.HY(VideoMiddlePageAdView.this.eYE ? 0 : 1);
                    VideoMiddlePageAdView.this.mXO = true;
                }
            });
            this.jpo.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.HZ(VideoMiddlePageAdView.this.eYE ? 0 : 1);
                    return true;
                }
            });
            this.jpo.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.jpo.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.jpo.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cFE() {
                    VideoMiddlePageAdView.this.di(1, VideoMiddlePageAdView.this.jpo.getCurrentPosition());
                }
            });
            this.jpo.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.dh(1, VideoMiddlePageAdView.this.jpo.getCurrentPosition());
                    VideoMiddlePageAdView.this.mXO = true;
                }
            });
            this.jpo.cSR();
            this.jpo.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.jOr.dvK()) {
                    this.jpo.xk(false);
                    this.jOr.dVt();
                    this.jpo.xl(true);
                    this.jpo.fW(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.jpo.xl(false);
                    this.jpo.xk(false);
                    this.jOr.hide();
                    this.jpo.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mXK != null) {
                    this.mXK.xD(true);
                }
                if (i == 0) {
                    this.jOm.setVisibility(8);
                    this.mXB.setVisibility(8);
                } else {
                    this.jOm.startAnimation(this.cjy);
                    this.mXB.startAnimation(this.cjy);
                }
                if (i == 0) {
                    this.mXP.AM(3);
                    return;
                } else {
                    this.mXP.AM(0);
                    return;
                }
            }
            this.jOr.hide();
            this.jpo.xk(true);
            this.mXP.AM(3);
            if (j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.jOm.startAnimation(this.cjy);
                this.mXB.startAnimation(this.cjy);
                return;
            }
            this.jOm.setVisibility(0);
            this.mXB.setVisibility(0);
        }
    }

    private boolean cMl() {
        try {
            int intValue = this.mXF.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mXF.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.jpb.setTextColor(this.eWx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mXE.setTextColor(this.eWx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mXG.setTextColor(this.eWx.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mXH.setTextColor(this.eWx.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.mXH, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cMm() {
        if (!cMl()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.joZ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.joZ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mXF = videoMiddlePageAdCard;
        cMm();
        this.jpb.setText(videoMiddlePageAdCard.threadTitle);
        this.alr.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.jpg.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.jpg.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.jpg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bwf() || VideoMiddlePageAdView.this.mXF == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mXF.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.eWx.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mXE.setText(videoMiddlePageAdCard.tagName);
        this.mXG.setText(videoMiddlePageAdCard.operateData.mVv);
        this.mXH.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.mXH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (VideoMiddlePageAdView.this.mXF == null || VideoMiddlePageAdView.this.mXF.getAdFacadeData() == null || VideoMiddlePageAdView.this.mXF.getAdFacadeData().qS() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdvertAppInfo qS = VideoMiddlePageAdView.this.mXF.getAdFacadeData().qS();
                    str2 = VideoMiddlePageAdView.this.d(qS);
                    str = qS.extensionInfo;
                }
                int a2 = t.a(VideoMiddlePageAdView.this.eWx, videoMiddlePageAdCard.operateData.scheme, str2, str);
                if (VideoMiddlePageAdView.this.mXK != null) {
                    VideoMiddlePageAdView.this.mXK.xD(false);
                }
                if (VideoMiddlePageAdView.this.leD != null) {
                    VideoMiddlePageAdView.this.leD.d(a2, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mXF, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mXK = this.mXJ.a(videoMiddlePageAdCard.tailFrame, this.mXK);
        if (this.mXK != null) {
            b(this.mXF.getAdFacadeData());
            this.mXK.setPageContext(this.eWx);
            this.mXK.setTimeoutListener(this);
            this.mXK.a(videoMiddlePageAdCard.tailFrame);
            this.mXK.c(this.mXF);
            this.mXK.dEK();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.abZ = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.abZ;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.jOo = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mXL = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void cf(View view) {
        this.abZ.zf(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void onDestroy() {
        cFz();
        if (this.jOm != null) {
            this.jOm.clearAnimation();
        }
        if (this.mXB != null) {
            this.mXB.clearAnimation();
        }
    }

    public void stopVideo() {
        this.jpo.stopPlay();
        if (this.jpb != null) {
            this.jpb.setVisibility(0);
        }
        if (this.mXP != null) {
            this.mXP.AM(2);
        }
        this.mXN = false;
        this.mXO = true;
    }

    public void cFz() {
        if (this.jpo != null) {
            this.jpo.destroy();
        }
        this.mXN = false;
        this.mXO = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        if (view == this.jOm && this.jOm.getVisibility() == 0) {
            if (this.jOo != null) {
                this.jOo.AQ(this.mPosition);
            }
        } else if (view == this.mXB && this.mXB.getVisibility() == 0) {
            if (this.jOo != null) {
                this.jOo.AQ(this.mPosition);
            }
        } else if (view == this.mXD || view == this.mXC) {
            if (this.jOm.getVisibility() == 0) {
                if (this.jOo != null) {
                    this.jOo.AQ(this.mPosition);
                    return;
                }
                return;
            }
            this.mXP.AM(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dDW();
        } else {
            if (this.mXF.getAdFacadeData() == null || this.mXF.getAdFacadeData().qS() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = d(this.mXF.getAdFacadeData().qS());
                str = this.mXF.getAdFacadeData().qS().extensionInfo;
            }
            int a2 = t.a(this.eWx, this.mXF.getScheme(), str2, str);
            if (this.leD != null) {
                this.leD.d(a2, null);
            }
            if (this.mXK != null) {
                this.mXK.xD(false);
            }
        }
    }

    private void dDW() {
        if (this.eWx != null && this.eWx.getPageActivity() != null && this.mXF != null && this.mXF.getAdFacadeData() != null && !TextUtils.isEmpty(this.mXF.getScheme())) {
            String scheme = this.mXF.getScheme();
            AdvertAppInfo qS = this.mXF.getAdFacadeData().qS();
            int bc = t.RB(this.mXF.getScheme()) ? t.bc(this.eWx.getPageActivity(), scheme) : 0;
            if (this.leD != null) {
                this.leD.d(bc, null);
            }
            if (this.mXK != null) {
                this.mXK.xD(false);
            }
            if (bc != 1000) {
                String RC = t.RC(scheme);
                AdWebVideoActivity.a(qS, this.mXF.getAdFacadeData().abL != null ? this.mXF.getAdFacadeData().abL.qO() : 0, "DETAIL");
                Bundle bundle = new Bundle();
                bundle.putString("video_url", this.mXF.video.video_url);
                bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.mXF.video.thumbnail_url);
                bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
                bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.mXM);
                bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.mXF.tailFrame.toJsonString());
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, d(this.mXF.getAdFacadeData().qS()));
                AdWebVideoActivity.a(new AdWebVideoActivityConfig(this.eWx.getPageActivity(), "", RC, true, true, true, bundle));
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        if (com.baidu.tieba.ad.b.a.te(this.jpo.getCurrentPosition()) < this.mXM && this.jpo.rl()) {
            dh(this.eYE ? 0 : 1, this.jpo.getCurrentPosition());
        }
        stopVideo();
        this.mXK.xD(false);
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void pausePlay() {
        if (isPlaying()) {
            this.jpo.pausePlay();
            dh(this.eYE ? 0 : 1, this.jpo.getCurrentPosition());
            this.mXO = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jpo.rl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX(int i) {
        if (this.mXF != null && this.mXF.video != null && this.mXF.getAdFacadeData() != null && this.mXO) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(this.mXF.getAdFacadeData(), 31, this.mXF.getAdFacadeData().getPageNum(), i, this.mXM, 0, -1));
            this.mXO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY(int i) {
        if (this.mXF != null && this.mXF.video != null && this.mXF.getAdFacadeData() != null && !this.mXN) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(this.mXF.getAdFacadeData(), 34, this.mXF.getAdFacadeData().getPageNum(), i, this.mXM, this.mXM, -1));
            this.mXN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ(int i) {
        if (this.mXF != null && this.mXF.video != null && this.mXF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(this.mXF.getAdFacadeData(), 36, this.mXF.getAdFacadeData().getPageNum(), i, this.mXM, com.baidu.tieba.ad.b.a.te(this.jpo.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        if (this.mXF != null && this.mXF.video != null && this.mXF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(this.mXF.getAdFacadeData(), 32, this.mXF.getAdFacadeData().getPageNum(), i, this.mXM, com.baidu.tieba.ad.b.a.te(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(int i, int i2) {
        if (this.mXF != null && this.mXF.video != null && this.mXF.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(this.mXF.getAdFacadeData(), 33, this.mXF.getAdFacadeData().getPageNum(), i, this.mXM, com.baidu.tieba.ad.b.a.te(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(this.mXF.getAdFacadeData(), 303, this.mXF.getAdFacadeData().getPageNum(), this.eYE ? 0 : 1, this.mXF.video.video_duration.intValue(), 0, -1);
            if (this.mXK != null) {
                this.mXK.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(boolean z) {
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
    /* loaded from: classes7.dex */
    public class a {
        private int eBs = -1;
        private Runnable jOF = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.jOF);
                a.this.AM(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void AM(int i) {
            switch (i) {
                case 0:
                    this.eBs = AN(i);
                    cMw();
                    return;
                case 1:
                    this.eBs = AN(i);
                    this.mHandler.removeCallbacks(this.jOF);
                    return;
                case 2:
                    this.eBs = AO(i);
                    return;
                case 3:
                    this.eBs = AP(i);
                    cMw();
                    return;
                default:
                    this.eBs = AO(i);
                    return;
            }
        }

        private void cMw() {
            this.mHandler.removeCallbacks(this.jOF);
            this.mHandler.postDelayed(this.jOF, IMConnection.RETRY_DELAY_TIMES);
        }

        private int AN(int i) {
            if (i != this.eBs) {
                VideoMiddlePageAdView.this.mXD.setVisibility(8);
                VideoMiddlePageAdView.this.mXC.setVisibility(8);
                VideoMiddlePageAdView.this.xB(true);
                return i;
            }
            return this.eBs;
        }

        private int AO(int i) {
            int i2 = this.eBs;
            if (i != this.eBs) {
                VideoMiddlePageAdView.this.mXD.setVisibility(0);
                VideoMiddlePageAdView.this.mXC.setVisibility(0);
                if (VideoMiddlePageAdView.this.jpo != null) {
                    VideoMiddlePageAdView.this.jpo.dAc();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mXF.autoPlay) {
                    VideoMiddlePageAdView.this.xB(false);
                    return i;
                }
                return i;
            }
            return this.eBs;
        }

        private int AP(int i) {
            if (i != this.eBs) {
                VideoMiddlePageAdView.this.mXD.setVisibility(0);
                VideoMiddlePageAdView.this.mXC.setVisibility(0);
                VideoMiddlePageAdView.this.xB(true);
                return i;
            }
            return this.eBs;
        }
    }
}
