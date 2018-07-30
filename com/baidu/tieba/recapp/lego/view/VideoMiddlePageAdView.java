package com.baidu.tieba.recapp.lego.view;

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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.b;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.g;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, g, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Pl;
    public TextView axL;
    private Animation bve;
    private n bvr;
    public HeadImageView ciQ;
    private View dHA;
    private View dHB;
    private b dHD;
    private Animation.AnimationListener dHF;
    private Animation.AnimationListener dHG;
    private View dHs;
    private View dHz;
    public FrameLayout dqJ;
    public FrameLayout dqK;
    public TextView dqL;
    public c dqX;
    private Animation drf;
    private boolean drg;
    private View grH;
    public TextView grI;
    private VideoMiddlePageAdCard grJ;
    private TextView grK;
    private TextView grL;
    private ViewGroup grM;
    private d grN;
    private e grO;
    private f grP;
    private int grQ;
    private boolean grR;
    private boolean grS;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.grR = false;
        this.grS = true;
        this.dHF = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dHz != null) {
                    VideoMiddlePageAdView.this.dHz.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.grH != null) {
                    VideoMiddlePageAdView.this.grH.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dHz != null) {
                    VideoMiddlePageAdView.this.dHz.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.grH != null) {
                    VideoMiddlePageAdView.this.grH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dHG = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dHz != null) {
                    VideoMiddlePageAdView.this.dHz.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.grH != null) {
                    VideoMiddlePageAdView.this.grH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dHz != null) {
                    VideoMiddlePageAdView.this.dHz.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.grH != null) {
                    VideoMiddlePageAdView.this.grH.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.grR = false;
        this.grS = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dqJ = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.dHs = this.rootView.findViewById(d.g.card_container);
        this.dqK = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.dqX = new c(this.mContext, this.dqK, false);
        this.dqX.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.grQ = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dqX.eQX.setOnTouchListener(null);
        this.dqL = (TextView) this.rootView.findViewById(d.g.title);
        this.ciQ = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.ciQ.setIsRound(true);
        this.ciQ.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.ciQ.setDefaultResource(d.f.icon_default_avatar100);
        this.ciQ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.grI = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.axL = (TextView) this.rootView.findViewById(d.g.user_name);
        this.bvr = new n(this.mContext.getPageActivity());
        this.grK = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.grL = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.grM = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.grN = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.grM);
        this.grN.page = 1;
        this.dHz = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.dHA = this.rootView.findViewById(d.g.user_container_foreground);
        this.dHB = this.rootView.findViewById(d.g.title_foreground);
        this.grH = this.rootView.findViewById(d.g.operate_area_foreground);
        this.dHz.setOnClickListener(this);
        this.dHA.setOnClickListener(this);
        this.dHB.setOnClickListener(this);
        this.grH.setOnClickListener(this);
        this.dqK.setOnClickListener(this);
        this.dqJ.setOnClickListener(this);
        this.dqX.S(this);
        this.dqL.setOnClickListener(this);
        this.ciQ.setOnClickListener(this);
        this.axL.setOnClickListener(this);
        this.mWidth = l.ah(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dqJ.setLayoutParams(layoutParams);
        this.drf = new AlphaAnimation(0.0f, 0.7f);
        this.drf.setDuration(500L);
        this.drf.setAnimationListener(this.dHG);
        this.bve = new AlphaAnimation(0.7f, 0.0f);
        this.bve.setDuration(500L);
        this.bve.setAnimationListener(this.dHF);
        this.dqX.bkc();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRx() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.drg = this.grJ.autoPlay;
            this.grR = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.grQ = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dqX.bjU()) {
                bz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dqX.getCurrentPosition());
                this.grS = true;
            }
            this.dqX.stopPlay();
            this.dqX.setIsNeedRecoveryVideoPlayer(true);
            this.dqX.ls(true);
            this.dqX.lq(false);
            this.dqX.lt(true);
            this.dqX.N(false, true);
            this.dqX.rF(i);
            this.dqX.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void awj() {
                }
            });
            this.dqX.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void awk() {
                    if (VideoMiddlePageAdView.this.grJ != null && VideoMiddlePageAdView.this.grJ.video != null && VideoMiddlePageAdView.this.grJ.video.video_height.intValue() > VideoMiddlePageAdView.this.grJ.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dqX.N(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dqX.N(false, true);
                    }
                    if (VideoMiddlePageAdView.this.grP != null) {
                        VideoMiddlePageAdView.this.grP.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.si(VideoMiddlePageAdView.this.drg ? 0 : 1);
                    VideoMiddlePageAdView.this.grR = false;
                }

                @Override // com.baidu.tieba.play.c.k
                public void awl() {
                }
            });
            this.dqX.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fT(boolean z) {
                    VideoMiddlePageAdView.this.dqX.bS(VideoMiddlePageAdView.this.grJ.video.video_url, "");
                    if (VideoMiddlePageAdView.this.grP != null) {
                        VideoMiddlePageAdView.this.grP.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.si(1);
                    VideoMiddlePageAdView.this.grR = false;
                }
            });
            this.dqX.lo(false);
            this.dqX.getVideoView().setBusiness(this.bvr);
            this.dqX.aSc();
            this.dqX.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (!VideoMiddlePageAdView.this.dqX.bjU()) {
                        VideoMiddlePageAdView.this.dHB.setVisibility(0);
                        VideoMiddlePageAdView.this.dHA.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.dHB.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dHB.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.dHA.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dHA.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lU(1);
                    } else {
                        if (VideoMiddlePageAdView.this.dHB.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dHB.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.dHA.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dHA.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lU(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awm() {
                    VideoMiddlePageAdView.this.lU(1);
                    if (!VideoMiddlePageAdView.this.dqX.bjU()) {
                        VideoMiddlePageAdView.this.dHB.setVisibility(0);
                        VideoMiddlePageAdView.this.dHA.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.dHB.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dHB.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.dHA.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dHA.setVisibility(0);
                    }
                }
            });
            this.dqX.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dqX.aFd();
                    if (VideoMiddlePageAdView.this.grO != null) {
                        VideoMiddlePageAdView.this.grO.bom();
                    }
                    VideoMiddlePageAdView.this.sj(VideoMiddlePageAdView.this.drg ? 0 : 1);
                    VideoMiddlePageAdView.this.grS = true;
                }
            });
            this.dqX.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.sk(VideoMiddlePageAdView.this.drg ? 0 : 1);
                    return true;
                }
            });
            this.dqX.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dqX.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dqX.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void awn() {
                    VideoMiddlePageAdView.this.bA(1, VideoMiddlePageAdView.this.dqX.getCurrentPosition());
                }
            });
            this.dqX.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.bz(1, VideoMiddlePageAdView.this.dqX.getCurrentPosition());
                    VideoMiddlePageAdView.this.grS = true;
                }
            });
            this.dqX.aFd();
            this.dqX.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dqX.a(videoMiddlePageAdCard.video.video_url, "", (c.d) null, new Object[0]);
                if (this.grO != null) {
                    this.grO.lH(true);
                }
                if (i == 0) {
                    this.dHz.setVisibility(8);
                    this.grH.setVisibility(8);
                } else {
                    this.dHz.startAnimation(this.bve);
                    this.grH.startAnimation(this.bve);
                }
                this.dHB.setVisibility(8);
                this.dHA.setVisibility(8);
            } else if (com.baidu.adp.lib.util.j.jG() && videoMiddlePageAdCard.waitConfirm) {
                this.dHz.startAnimation(this.bve);
                this.grH.startAnimation(this.bve);
                this.dHB.setVisibility(8);
                this.dHA.setVisibility(8);
            } else {
                this.dHB.setVisibility(0);
                this.dHA.setVisibility(0);
                this.dHz.setVisibility(0);
                this.grH.setVisibility(0);
            }
        }
    }

    private boolean aAS() {
        try {
            int intValue = this.grJ.video.video_width.intValue();
            return intValue <= 0 || ((float) this.grJ.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dqL.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.grI.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.grK.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.grL.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_i));
        am.i(this.grL, d.f.btn_rouned_corner_bg_shape);
    }

    private void aAT() {
        if (!aAS()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dqJ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dqJ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.grJ = videoMiddlePageAdCard;
        aAT();
        this.dqL.setText(videoMiddlePageAdCard.threadTitle);
        this.axL.setText(videoMiddlePageAdCard.userName);
        this.ciQ.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.ciQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.BT() || VideoMiddlePageAdView.this.grJ == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aQ(VideoMiddlePageAdView.this.grJ.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.grI.setText(videoMiddlePageAdCard.tagName);
        this.grK.setText(videoMiddlePageAdCard.operateData.gpw);
        this.grL.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.grL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.grO != null) {
                    VideoMiddlePageAdView.this.grO.lH(false);
                }
                if (VideoMiddlePageAdView.this.eQz != null) {
                    VideoMiddlePageAdView.this.eQz.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.grJ, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.grO = this.grN.a(videoMiddlePageAdCard.tailFrame, this.grO);
        if (this.grO != null) {
            b(this.grJ.getAdFacadeData());
            this.grO.setPageContext(this.mContext);
            this.grO.setTimeoutListener(this);
            this.grO.a(videoMiddlePageAdCard.tailFrame);
            this.grO.c(this.grJ);
            this.grO.bon();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Pl = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Pl;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dHD = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.grP = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void X(View view) {
        this.Pl.kL(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        awg();
        if (this.dHz != null) {
            this.dHz.clearAnimation();
        }
        if (this.grH != null) {
            this.grH.clearAnimation();
        }
    }

    public void awf() {
        this.dqX.stopPlay();
        if (this.dqL != null) {
            this.dqL.setVisibility(0);
        }
        this.grR = false;
        this.grS = true;
    }

    public void awg() {
        if (this.dqX != null) {
            this.dqX.destroy();
        }
        this.grR = false;
        this.grS = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra("low");
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHz && this.dHz.getVisibility() == 0) {
            if (this.dHD != null) {
                this.dHD.lV(this.mPosition);
            }
        } else if (view == this.grH && this.grH.getVisibility() == 0) {
            if (this.dHD != null) {
                this.dHD.lV(this.mPosition);
            }
        } else if (view == this.dHB || view == this.dHA) {
            if (this.dHz.getVisibility() == 0) {
                if (this.dHD != null) {
                    this.dHD.lV(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dHB.getVisibility() == 0) {
                this.dHB.setVisibility(8);
            }
            if (this.dHA.getVisibility() == 0) {
                this.dHA.setVisibility(8);
            }
            lU(0);
        } else if (view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.float_video_container || view.getId() == d.g.title) {
            WebVideoActivity.gop = new WebVideoActivity.a();
            if (this.grJ.getAdFacadeData() != null) {
                WebVideoActivity.gop.goz = this.grJ.getAdFacadeData().om();
                WebVideoActivity.gop.goA = "DETAIL";
                if (this.grJ.getAdFacadeData().OX != null) {
                    WebVideoActivity.gop.mPageNum = this.grJ.getAdFacadeData().OX.oi();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.grJ.getScheme(), true, true, true, this.grJ.video.video_url, this.grJ.video.thumbnail_url, 1.7777778f, this.grQ)));
            if (this.eQz != null) {
                this.eQz.b(0, null);
            }
            if (this.grO != null) {
                this.grO.lH(false);
            }
        } else {
            int e = s.e(this.mContext, this.grJ.getScheme());
            if (this.eQz != null) {
                this.eQz.b(e, null);
            }
            if (this.grO != null) {
                this.grO.lH(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.gB(this.dqX.getCurrentPosition()) < this.grQ && this.dqX.getCurrentState() == 1) {
            bz(this.drg ? 0 : 1, this.dqX.getCurrentPosition());
        }
        awf();
        this.grO.lH(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.dqX.pausePlay();
            bz(this.drg ? 0 : 1, this.dqX.getCurrentPosition());
            this.grS = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.dqX.bjU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        if (this.grJ != null && this.grJ.video != null && this.grJ.getAdFacadeData() != null && this.grS) {
            com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(this.grJ.getAdFacadeData(), 31, this.grJ.getAdFacadeData().getPageNum(), i, this.grQ, 0, -1));
            this.grS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        if (this.grJ != null && this.grJ.video != null && this.grJ.getAdFacadeData() != null && !this.grR) {
            com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(this.grJ.getAdFacadeData(), 34, this.grJ.getAdFacadeData().getPageNum(), i, this.grQ, this.grQ, -1));
            this.grR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        if (this.grJ != null && this.grJ.video != null && this.grJ.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(this.grJ.getAdFacadeData(), 36, this.grJ.getAdFacadeData().getPageNum(), i, this.grQ, com.baidu.tieba.ad.a.a.gB(this.dqX.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(int i, int i2) {
        if (this.grJ != null && this.grJ.video != null && this.grJ.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(this.grJ.getAdFacadeData(), 32, this.grJ.getAdFacadeData().getPageNum(), i, this.grQ, com.baidu.tieba.ad.a.a.gB(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i, int i2) {
        if (this.grJ != null && this.grJ.video != null && this.grJ.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(this.grJ.getAdFacadeData(), 33, this.grJ.getAdFacadeData().getPageNum(), i, this.grQ, com.baidu.tieba.ad.a.a.gB(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.grJ.getAdFacadeData(), 303, this.grJ.getAdFacadeData().getPageNum(), this.drg ? 0 : 1, this.grJ.video.video_duration.intValue(), 0, -1);
            if (this.grO != null) {
                this.grO.e(a);
            }
        }
    }
}
