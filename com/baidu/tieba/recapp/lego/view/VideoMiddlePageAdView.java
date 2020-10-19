package com.baidu.tieba.recapp.lego.view;

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
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes26.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a YZ;
    public TextView ajt;
    private Animation bKg;
    private Animation bKh;
    private boolean evc;
    private View iSd;
    private View iSj;
    private c iSl;
    private VideoNetworkStateTipView iSo;
    private Animation.AnimationListener iSv;
    private Animation.AnimationListener iSw;
    public FrameLayout ivQ;
    public FrameLayout ivR;
    public TextView ivS;
    public HeadImageView ivX;
    public com.baidu.tieba.play.c iwf;
    private int mWidth;
    private View meb;
    private View mec;
    private View med;
    public TextView mee;
    private VideoMiddlePageAdCard mef;
    private TextView meg;
    private TextView meh;
    private ViewGroup mei;
    private d mej;
    private e mek;
    private f mel;
    private int men;
    private boolean meo;
    private boolean mep;
    private a meq;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.meo = false;
        this.mep = true;
        this.iSv = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.iSj != null) {
                    VideoMiddlePageAdView.this.iSj.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.meb != null) {
                    VideoMiddlePageAdView.this.meb.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.iSj != null) {
                    VideoMiddlePageAdView.this.iSj.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.meb != null) {
                    VideoMiddlePageAdView.this.meb.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iSw = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.iSj != null) {
                    VideoMiddlePageAdView.this.iSj.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.meb != null) {
                    VideoMiddlePageAdView.this.meb.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.iSj != null) {
                    VideoMiddlePageAdView.this.iSj.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.meb != null) {
                    VideoMiddlePageAdView.this.meb.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.meo = false;
        this.mep = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.ivQ = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.iSd = this.rootView.findViewById(R.id.card_container);
        this.ivR = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.iwf = new com.baidu.tieba.play.c(this.etO, this.ivR, false);
        this.iwf.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.iwf.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoMiddlePageAdView.this.iwf != null && VideoMiddlePageAdView.this.iwf.getVideoView() != null) {
                    VideoMiddlePageAdView.this.men = (int) TimeUnit.MILLISECONDS.toSeconds(VideoMiddlePageAdView.this.iwf.getVideoView().getDuration());
                }
            }
        });
        this.iwf.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void pY(boolean z) {
                if (VideoMiddlePageAdView.this.meq != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.meq.Ac(0);
                    } else {
                        VideoMiddlePageAdView.this.meq.Ac(1);
                    }
                }
            }
        });
        this.iwf.knH.setOnTouchListener(null);
        this.ivS = (TextView) this.rootView.findViewById(R.id.title);
        this.ivX = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.ivX.setIsRound(true);
        this.ivX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ivX.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ivX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.mee = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.ajt = (TextView) this.rootView.findViewById(R.id.user_name);
        this.meg = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.meh = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.mei = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.mej = new d(this.etO.getPageActivity(), this.mei);
        this.mej.page = 1;
        this.iSo = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.iSo.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.iSo.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.iwf.vP(false);
                VideoMiddlePageAdView.this.iSo.dMd();
                if (VideoMiddlePageAdView.this.mef != null && VideoMiddlePageAdView.this.mef.video != null) {
                    VideoMiddlePageAdView.this.iwf.fR(VideoMiddlePageAdView.this.mef.video.video_url, "");
                }
            }
        });
        this.iSj = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.mec = this.rootView.findViewById(R.id.user_container_foreground);
        this.med = this.rootView.findViewById(R.id.title_foreground);
        this.meb = this.rootView.findViewById(R.id.operate_area_foreground);
        this.iSj.setOnClickListener(this);
        this.mec.setOnClickListener(this);
        this.med.setOnClickListener(this);
        this.meb.setOnClickListener(this);
        this.ivR.setOnClickListener(this);
        this.ivQ.setOnClickListener(this);
        this.iwf.ab(this);
        this.ivS.setOnClickListener(this);
        this.ivX.setOnClickListener(this);
        this.ajt.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(this.etO.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.ivQ.setLayoutParams(layoutParams);
        this.bKg = new AlphaAnimation(0.0f, 0.7f);
        this.bKg.setDuration(500L);
        this.bKg.setAnimationListener(this.iSw);
        this.bKh = new AlphaAnimation(0.7f, 0.0f);
        this.bKh.setDuration(500L);
        this.bKh.setAnimationListener(this.iSv);
        this.rootView.setOnClickListener(this);
        this.meq = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cTG() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.evc = this.mef.autoPlay;
            this.meo = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.men = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.iwf.rK()) {
                de(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.iwf.getCurrentPosition());
                this.mep = true;
            }
            this.iwf.stopPlay();
            this.iwf.vQ(true);
            this.iwf.vM(false);
            this.iwf.vR(true);
            this.iwf.av(false, true);
            this.iwf.GL(i);
            this.iwf.a(new c.InterfaceC0797c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rI() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rJ() {
                }
            });
            this.iwf.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void cvx() {
                    if (VideoMiddlePageAdView.this.mef != null && VideoMiddlePageAdView.this.mef.video != null && VideoMiddlePageAdView.this.mef.video.video_height.intValue() > VideoMiddlePageAdView.this.mef.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.iwf.av(false, true);
                    } else {
                        VideoMiddlePageAdView.this.iwf.av(false, true);
                    }
                    if (VideoMiddlePageAdView.this.mel != null) {
                        VideoMiddlePageAdView.this.mel.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Hp(VideoMiddlePageAdView.this.evc ? 0 : 1);
                    VideoMiddlePageAdView.this.meo = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void cvy() {
                }
            });
            this.iwf.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void ps(boolean z) {
                    VideoMiddlePageAdView.this.iwf.fR(VideoMiddlePageAdView.this.mef.video.video_url, "");
                    if (VideoMiddlePageAdView.this.mel != null) {
                        VideoMiddlePageAdView.this.mel.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.Hp(1);
                    VideoMiddlePageAdView.this.meo = false;
                }
            });
            this.iwf.vI(false);
            this.iwf.cUg();
            this.iwf.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    VideoMiddlePageAdView.this.iwf.cGL();
                    if (VideoMiddlePageAdView.this.mek != null) {
                        VideoMiddlePageAdView.this.mek.dvN();
                    }
                    VideoMiddlePageAdView.this.Hq(VideoMiddlePageAdView.this.evc ? 0 : 1);
                    VideoMiddlePageAdView.this.mep = true;
                }
            });
            this.iwf.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.Hr(VideoMiddlePageAdView.this.evc ? 0 : 1);
                    return true;
                }
            });
            this.iwf.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.iwf.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.iwf.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void cvA() {
                    VideoMiddlePageAdView.this.df(1, VideoMiddlePageAdView.this.iwf.getCurrentPosition());
                }
            });
            this.iwf.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.de(1, VideoMiddlePageAdView.this.iwf.getCurrentPosition());
                    VideoMiddlePageAdView.this.mep = true;
                }
            });
            this.iwf.cGL();
            this.iwf.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.iSo.dmG()) {
                    this.iwf.vO(false);
                    this.iSo.dMc();
                    this.iwf.vP(true);
                    this.iwf.fQ(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.iwf.vP(false);
                    this.iwf.vO(false);
                    this.iSo.hide();
                    this.iwf.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.mek != null) {
                    this.mek.wg(true);
                }
                if (i == 0) {
                    this.iSj.setVisibility(8);
                    this.meb.setVisibility(8);
                } else {
                    this.iSj.startAnimation(this.bKh);
                    this.meb.startAnimation(this.bKh);
                }
                if (i == 0) {
                    this.meq.Ac(3);
                    return;
                } else {
                    this.meq.Ac(0);
                    return;
                }
            }
            this.iSo.hide();
            this.iwf.vO(true);
            this.meq.Ac(3);
            if (com.baidu.adp.lib.util.j.isMobileNet() && videoMiddlePageAdCard.waitConfirm) {
                this.iSj.startAnimation(this.bKh);
                this.meb.startAnimation(this.bKh);
                return;
            }
            this.iSj.setVisibility(0);
            this.meb.setVisibility(0);
        }
    }

    private boolean cAV() {
        try {
            int intValue = this.mef.video.video_width.intValue();
            return intValue <= 0 || ((float) this.mef.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.ivS.setTextColor(this.etO.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.mee.setTextColor(this.etO.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.meg.setTextColor(this.etO.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.meh.setTextColor(this.etO.getResources().getColor(R.color.cp_cont_i_alpha70));
        ap.setBackgroundResource(this.meh, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void cAW() {
        if (!cAV()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.ivQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ivQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.ivQ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mef = videoMiddlePageAdCard;
        cAW();
        this.ivS.setText(videoMiddlePageAdCard.threadTitle);
        this.ajt.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.ivX.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.ivX.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.ivX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bqa() || VideoMiddlePageAdView.this.mef == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(VideoMiddlePageAdView.this.mef.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.etO.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.mee.setText(videoMiddlePageAdCard.tagName);
        this.meg.setText(videoMiddlePageAdCard.operateData.mca);
        this.meh.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.meh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int c = s.c(VideoMiddlePageAdView.this.etO, videoMiddlePageAdCard.operateData.scheme, (VideoMiddlePageAdView.this.mef == null || VideoMiddlePageAdView.this.mef.getAdFacadeData() == null || VideoMiddlePageAdView.this.mef.getAdFacadeData().rq() == null) ? null : VideoMiddlePageAdView.this.mef.getAdFacadeData().rq().ekv);
                if (VideoMiddlePageAdView.this.mek != null) {
                    VideoMiddlePageAdView.this.mek.wg(false);
                }
                if (VideoMiddlePageAdView.this.knj != null) {
                    VideoMiddlePageAdView.this.knj.d(c, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.mef, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.mek = this.mej.a(videoMiddlePageAdCard.tailFrame, this.mek);
        if (this.mek != null) {
            b(this.mef.getAdFacadeData());
            this.mek.setPageContext(this.etO);
            this.mek.setTimeoutListener(this);
            this.mek.a(videoMiddlePageAdCard.tailFrame);
            this.mek.c(this.mef);
            this.mek.dvO();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.YZ = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.YZ;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.iSl = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.mel = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bL(View view) {
        this.YZ.yF(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        cvv();
        if (this.iSj != null) {
            this.iSj.clearAnimation();
        }
        if (this.meb != null) {
            this.meb.clearAnimation();
        }
    }

    public void cvu() {
        this.iwf.stopPlay();
        if (this.ivS != null) {
            this.ivS.setVisibility(0);
        }
        if (this.meq != null) {
            this.meq.Ac(2);
        }
        this.meo = false;
        this.mep = true;
    }

    public void cvv() {
        if (this.iwf != null) {
            this.iwf.destroy();
        }
        this.meo = false;
        this.mep = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iSj && this.iSj.getVisibility() == 0) {
            if (this.iSl != null) {
                this.iSl.Ag(this.mPosition);
            }
        } else if (view == this.meb && this.meb.getVisibility() == 0) {
            if (this.iSl != null) {
                this.iSl.Ag(this.mPosition);
            }
        } else if (view == this.med || view == this.mec) {
            if (this.iSj.getVisibility() == 0) {
                if (this.iSl != null) {
                    this.iSl.Ag(this.mPosition);
                    return;
                }
                return;
            }
            this.meq.Ac(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container) {
            dvc();
        } else {
            int c = s.c(this.etO, this.mef.getScheme(), (this.mef.getAdFacadeData() == null || this.mef.getAdFacadeData().rq() == null) ? null : this.mef.getAdFacadeData().rq().ekv);
            if (this.knj != null) {
                this.knj.d(c, null);
            }
            if (this.mek != null) {
                this.mek.wg(false);
            }
        }
    }

    private void dvc() {
        if (this.etO != null && this.etO.getPageActivity() != null && this.mef != null && this.mef.getAdFacadeData() != null && !TextUtils.isEmpty(this.mef.getScheme())) {
            String scheme = this.mef.getScheme();
            AdvertAppInfo rq = this.mef.getAdFacadeData().rq();
            boolean aX = s.QA(this.mef.getScheme()) ? s.aX(this.etO.getPageActivity(), scheme) : false;
            if (this.knj != null) {
                this.knj.d(aX ? 1 : 2, null);
            }
            if (this.mek != null) {
                this.mek.wg(false);
            }
            if (!aX) {
                String QB = s.QB(scheme);
                NewWebVideoActivity.a(rq, this.mef.getAdFacadeData().YL != null ? this.mef.getAdFacadeData().YL.rm() : 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.etO.getPageActivity(), "", QB, true, true, true, this.mef.video.video_url, this.mef.video.thumbnail_url, 1.7777778f, this.men, this.mef.getAdFacadeData().rq().ekv);
                newWebVideoActivityConfig.setTailFrame(this.mef.tailFrame.toJsonString());
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.sV(this.iwf.getCurrentPosition()) < this.men && this.iwf.rK()) {
            de(this.evc ? 0 : 1, this.iwf.getCurrentPosition());
        }
        cvu();
        this.mek.wg(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aLr() {
        if (isPlaying()) {
            this.iwf.aLr();
            de(this.evc ? 0 : 1, this.iwf.getCurrentPosition());
            this.mep = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iwf.rK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp(int i) {
        if (this.mef != null && this.mef.video != null && this.mef.getAdFacadeData() != null && this.mep) {
            com.baidu.tieba.recapp.report.d.dvG().a(g.a(this.mef.getAdFacadeData(), 31, this.mef.getAdFacadeData().getPageNum(), i, this.men, 0, -1));
            this.mep = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq(int i) {
        if (this.mef != null && this.mef.video != null && this.mef.getAdFacadeData() != null && !this.meo) {
            com.baidu.tieba.recapp.report.d.dvG().a(g.a(this.mef.getAdFacadeData(), 34, this.mef.getAdFacadeData().getPageNum(), i, this.men, this.men, -1));
            this.meo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr(int i) {
        if (this.mef != null && this.mef.video != null && this.mef.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dvG().a(g.a(this.mef.getAdFacadeData(), 36, this.mef.getAdFacadeData().getPageNum(), i, this.men, com.baidu.tieba.ad.a.a.sV(this.iwf.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(int i, int i2) {
        if (this.mef != null && this.mef.video != null && this.mef.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dvG().a(g.a(this.mef.getAdFacadeData(), 32, this.mef.getAdFacadeData().getPageNum(), i, this.men, com.baidu.tieba.ad.a.a.sV(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(int i, int i2) {
        if (this.mef != null && this.mef.video != null && this.mef.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.d.dvG().a(g.a(this.mef.getAdFacadeData(), 33, this.mef.getAdFacadeData().getPageNum(), i, this.men, com.baidu.tieba.ad.a.a.sV(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.c a2 = g.a(this.mef.getAdFacadeData(), 303, this.mef.getAdFacadeData().getPageNum(), this.evc ? 0 : 1, this.mef.video.video_duration.intValue(), 0, -1);
            if (this.mek != null) {
                this.mek.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(boolean z) {
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
    /* loaded from: classes26.dex */
    public class a {
        private int bUO = -1;
        private Runnable iSC = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.iSC);
                a.this.Ac(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void Ac(int i) {
            switch (i) {
                case 0:
                    this.bUO = Ad(i);
                    cBg();
                    return;
                case 1:
                    this.bUO = Ad(i);
                    this.mHandler.removeCallbacks(this.iSC);
                    return;
                case 2:
                    this.bUO = Ae(i);
                    return;
                case 3:
                    this.bUO = Af(i);
                    cBg();
                    return;
                default:
                    this.bUO = Ae(i);
                    return;
            }
        }

        private void cBg() {
            this.mHandler.removeCallbacks(this.iSC);
            this.mHandler.postDelayed(this.iSC, IMConnection.RETRY_DELAY_TIMES);
        }

        private int Ad(int i) {
            if (i != this.bUO) {
                VideoMiddlePageAdView.this.med.setVisibility(8);
                VideoMiddlePageAdView.this.mec.setVisibility(8);
                VideoMiddlePageAdView.this.we(true);
                return i;
            }
            return this.bUO;
        }

        private int Ae(int i) {
            int i2 = this.bUO;
            if (i != this.bUO) {
                VideoMiddlePageAdView.this.med.setVisibility(0);
                VideoMiddlePageAdView.this.mec.setVisibility(0);
                if (VideoMiddlePageAdView.this.iwf != null) {
                    VideoMiddlePageAdView.this.iwf.drd();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.mef.autoPlay) {
                    VideoMiddlePageAdView.this.we(false);
                    return i;
                }
                return i;
            }
            return this.bUO;
        }

        private int Af(int i) {
            if (i != this.bUO) {
                VideoMiddlePageAdView.this.med.setVisibility(0);
                VideoMiddlePageAdView.this.mec.setVisibility(0);
                VideoMiddlePageAdView.this.we(true);
                return i;
            }
            return this.bUO;
        }
    }
}
