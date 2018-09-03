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
import com.baidu.tieba.f;
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
    private boolean alU;
    public TextView axI;
    private Animation bvg;
    private n bvt;
    public HeadImageView ciN;
    private Animation.AnimationListener dHB;
    private Animation.AnimationListener dHC;
    private View dHo;
    private View dHv;
    private View dHw;
    private View dHx;
    private b dHz;
    public FrameLayout dqH;
    public FrameLayout dqI;
    public TextView dqJ;
    public c dqV;
    private Animation drd;
    private View grK;
    public TextView grL;
    private VideoMiddlePageAdCard grM;
    private TextView grN;
    private TextView grO;
    private ViewGroup grP;
    private d grQ;
    private e grR;
    private f grS;
    private int grT;
    private boolean grU;
    private boolean grV;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.grU = false;
        this.grV = true;
        this.dHB = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dHv != null) {
                    VideoMiddlePageAdView.this.dHv.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.grK != null) {
                    VideoMiddlePageAdView.this.grK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dHv != null) {
                    VideoMiddlePageAdView.this.dHv.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.grK != null) {
                    VideoMiddlePageAdView.this.grK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dHC = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dHv != null) {
                    VideoMiddlePageAdView.this.dHv.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.grK != null) {
                    VideoMiddlePageAdView.this.grK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dHv != null) {
                    VideoMiddlePageAdView.this.dHv.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.grK != null) {
                    VideoMiddlePageAdView.this.grK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.grU = false;
        this.grV = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(f.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dqH = (FrameLayout) this.rootView.findViewById(f.g.video_agg_container);
        this.dHo = this.rootView.findViewById(f.g.card_container);
        this.dqI = (FrameLayout) this.rootView.findViewById(f.g.video_container);
        this.dqV = new c(this.mContext, this.dqI, false);
        this.dqV.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.grT = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dqV.eQS.setOnTouchListener(null);
        this.dqJ = (TextView) this.rootView.findViewById(f.g.title);
        this.ciN = (HeadImageView) this.rootView.findViewById(f.g.user_icon);
        this.ciN.setIsRound(true);
        this.ciN.setDefaultBgResource(f.d.cp_bg_line_e);
        this.ciN.setDefaultResource(f.C0146f.icon_default_avatar100);
        this.ciN.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.grL = (TextView) this.rootView.findViewById(f.g.ad_tag);
        this.axI = (TextView) this.rootView.findViewById(f.g.user_name);
        this.bvt = new n(this.mContext.getPageActivity());
        this.grN = (TextView) this.rootView.findViewById(f.g.ad_operate_title);
        this.grO = (TextView) this.rootView.findViewById(f.g.ad_operate_button);
        this.grP = (FrameLayout) this.rootView.findViewById(f.g.tail_frame_container);
        this.grQ = new d(this.mContext.getPageActivity(), this.grP);
        this.grQ.page = 1;
        this.dHv = this.rootView.findViewById(f.g.video_agg_container_foreground);
        this.dHw = this.rootView.findViewById(f.g.user_container_foreground);
        this.dHx = this.rootView.findViewById(f.g.title_foreground);
        this.grK = this.rootView.findViewById(f.g.operate_area_foreground);
        this.dHv.setOnClickListener(this);
        this.dHw.setOnClickListener(this);
        this.dHx.setOnClickListener(this);
        this.grK.setOnClickListener(this);
        this.dqI.setOnClickListener(this);
        this.dqH.setOnClickListener(this);
        this.dqV.S(this);
        this.dqJ.setOnClickListener(this);
        this.ciN.setOnClickListener(this);
        this.axI.setOnClickListener(this);
        this.mWidth = l.ah(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dqH.setLayoutParams(layoutParams);
        this.drd = new AlphaAnimation(0.0f, 0.7f);
        this.drd.setDuration(500L);
        this.drd.setAnimationListener(this.dHC);
        this.bvg = new AlphaAnimation(0.7f, 0.0f);
        this.bvg.setDuration(500L);
        this.bvg.setAnimationListener(this.dHB);
        this.dqV.bjZ();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRu() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.alU = this.grM.autoPlay;
            this.grU = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.grT = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dqV.bjR()) {
                bz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dqV.getCurrentPosition());
                this.grV = true;
            }
            this.dqV.stopPlay();
            this.dqV.setIsNeedRecoveryVideoPlayer(true);
            this.dqV.ls(true);
            this.dqV.lq(false);
            this.dqV.lt(true);
            this.dqV.N(false, true);
            this.dqV.rF(i);
            this.dqV.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void awh() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                }
            });
            this.dqV.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void awj() {
                    if (VideoMiddlePageAdView.this.grM != null && VideoMiddlePageAdView.this.grM.video != null && VideoMiddlePageAdView.this.grM.video.video_height.intValue() > VideoMiddlePageAdView.this.grM.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dqV.N(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dqV.N(false, true);
                    }
                    if (VideoMiddlePageAdView.this.grS != null) {
                        VideoMiddlePageAdView.this.grS.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.si(VideoMiddlePageAdView.this.alU ? 0 : 1);
                    VideoMiddlePageAdView.this.grU = false;
                }

                @Override // com.baidu.tieba.play.c.k
                public void awk() {
                }
            });
            this.dqV.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fT(boolean z) {
                    VideoMiddlePageAdView.this.dqV.bS(VideoMiddlePageAdView.this.grM.video.video_url, "");
                    if (VideoMiddlePageAdView.this.grS != null) {
                        VideoMiddlePageAdView.this.grS.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.si(1);
                    VideoMiddlePageAdView.this.grU = false;
                }
            });
            this.dqV.lo(false);
            this.dqV.getVideoView().setBusiness(this.bvt);
            this.dqV.aRZ();
            this.dqV.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (!VideoMiddlePageAdView.this.dqV.bjR()) {
                        VideoMiddlePageAdView.this.dHx.setVisibility(0);
                        VideoMiddlePageAdView.this.dHw.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.dHx.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dHx.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.dHw.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dHw.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lU(1);
                    } else {
                        if (VideoMiddlePageAdView.this.dHx.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dHx.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.dHw.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dHw.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lU(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awl() {
                    VideoMiddlePageAdView.this.lU(1);
                    if (!VideoMiddlePageAdView.this.dqV.bjR()) {
                        VideoMiddlePageAdView.this.dHx.setVisibility(0);
                        VideoMiddlePageAdView.this.dHw.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.dHx.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dHx.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.dHw.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dHw.setVisibility(0);
                    }
                }
            });
            this.dqV.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dqV.aFa();
                    if (VideoMiddlePageAdView.this.grR != null) {
                        VideoMiddlePageAdView.this.grR.bon();
                    }
                    VideoMiddlePageAdView.this.sj(VideoMiddlePageAdView.this.alU ? 0 : 1);
                    VideoMiddlePageAdView.this.grV = true;
                }
            });
            this.dqV.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.sk(VideoMiddlePageAdView.this.alU ? 0 : 1);
                    return true;
                }
            });
            this.dqV.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dqV.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dqV.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void awm() {
                    VideoMiddlePageAdView.this.bA(1, VideoMiddlePageAdView.this.dqV.getCurrentPosition());
                }
            });
            this.dqV.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.bz(1, VideoMiddlePageAdView.this.dqV.getCurrentPosition());
                    VideoMiddlePageAdView.this.grV = true;
                }
            });
            this.dqV.aFa();
            this.dqV.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dqV.a(videoMiddlePageAdCard.video.video_url, "", (c.d) null, new Object[0]);
                if (this.grR != null) {
                    this.grR.lH(true);
                }
                if (i == 0) {
                    this.dHv.setVisibility(8);
                    this.grK.setVisibility(8);
                } else {
                    this.dHv.startAnimation(this.bvg);
                    this.grK.startAnimation(this.bvg);
                }
                this.dHx.setVisibility(8);
                this.dHw.setVisibility(8);
            } else if (com.baidu.adp.lib.util.j.jG() && videoMiddlePageAdCard.waitConfirm) {
                this.dHv.startAnimation(this.bvg);
                this.grK.startAnimation(this.bvg);
                this.dHx.setVisibility(8);
                this.dHw.setVisibility(8);
            } else {
                this.dHx.setVisibility(0);
                this.dHw.setVisibility(0);
                this.dHv.setVisibility(0);
                this.grK.setVisibility(0);
            }
        }
    }

    private boolean aAP() {
        try {
            int intValue = this.grM.video.video_width.intValue();
            return intValue <= 0 || ((float) this.grM.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dqJ.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_i));
        this.grL.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_i));
        this.grN.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_i));
        this.grO.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_i));
        am.i(this.grO, f.C0146f.btn_rouned_corner_bg_shape);
    }

    private void aAQ() {
        if (!aAP()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dqH.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dqH.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.grM = videoMiddlePageAdCard;
        aAQ();
        this.dqJ.setText(videoMiddlePageAdCard.threadTitle);
        this.axI.setText(videoMiddlePageAdCard.userName);
        this.ciN.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.ciN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.BQ() || VideoMiddlePageAdView.this.grM == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aQ(VideoMiddlePageAdView.this.grM.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.grL.setText(videoMiddlePageAdCard.tagName);
        this.grN.setText(videoMiddlePageAdCard.operateData.gpz);
        this.grO.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.grO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.grR != null) {
                    VideoMiddlePageAdView.this.grR.lH(false);
                }
                if (VideoMiddlePageAdView.this.eQu != null) {
                    VideoMiddlePageAdView.this.eQu.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.grM, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.grR = this.grQ.a(videoMiddlePageAdCard.tailFrame, this.grR);
        if (this.grR != null) {
            b(this.grM.getAdFacadeData());
            this.grR.setPageContext(this.mContext);
            this.grR.setTimeoutListener(this);
            this.grR.a(videoMiddlePageAdCard.tailFrame);
            this.grR.c(this.grM);
            this.grR.boo();
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
        this.dHz = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.grS = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void X(View view) {
        this.Pl.kK(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        awf();
        if (this.dHv != null) {
            this.dHv.clearAnimation();
        }
        if (this.grK != null) {
            this.grK.clearAnimation();
        }
    }

    public void awe() {
        this.dqV.stopPlay();
        if (this.dqJ != null) {
            this.dqJ.setVisibility(0);
        }
        this.grU = false;
        this.grV = true;
    }

    public void awf() {
        if (this.dqV != null) {
            this.dqV.destroy();
        }
        this.grU = false;
        this.grV = true;
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
        if (view == this.dHv && this.dHv.getVisibility() == 0) {
            if (this.dHz != null) {
                this.dHz.lV(this.mPosition);
            }
        } else if (view == this.grK && this.grK.getVisibility() == 0) {
            if (this.dHz != null) {
                this.dHz.lV(this.mPosition);
            }
        } else if (view == this.dHx || view == this.dHw) {
            if (this.dHv.getVisibility() == 0) {
                if (this.dHz != null) {
                    this.dHz.lV(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dHx.getVisibility() == 0) {
                this.dHx.setVisibility(8);
            }
            if (this.dHw.getVisibility() == 0) {
                this.dHw.setVisibility(8);
            }
            lU(0);
        } else if (view.getId() == f.g.video_container || view.getId() == f.g.video_agg_container || view.getId() == f.g.float_video_container || view.getId() == f.g.title) {
            WebVideoActivity.gos = new WebVideoActivity.a();
            if (this.grM.getAdFacadeData() != null) {
                WebVideoActivity.gos.goC = this.grM.getAdFacadeData().oj();
                WebVideoActivity.gos.goD = "DETAIL";
                if (this.grM.getAdFacadeData().OX != null) {
                    WebVideoActivity.gos.mPageNum = this.grM.getAdFacadeData().OX.of();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.grM.getScheme(), true, true, true, this.grM.video.video_url, this.grM.video.thumbnail_url, 1.7777778f, this.grT)));
            if (this.eQu != null) {
                this.eQu.b(0, null);
            }
            if (this.grR != null) {
                this.grR.lH(false);
            }
        } else {
            int e = s.e(this.mContext, this.grM.getScheme());
            if (this.eQu != null) {
                this.eQu.b(e, null);
            }
            if (this.grR != null) {
                this.grR.lH(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.gA(this.dqV.getCurrentPosition()) < this.grT && this.dqV.getCurrentState() == 1) {
            bz(this.alU ? 0 : 1, this.dqV.getCurrentPosition());
        }
        awe();
        this.grR.lH(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.dqV.pausePlay();
            bz(this.alU ? 0 : 1, this.dqV.getCurrentPosition());
            this.grV = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.dqV.bjR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        if (this.grM != null && this.grM.video != null && this.grM.getAdFacadeData() != null && this.grV) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this.grM.getAdFacadeData(), 31, this.grM.getAdFacadeData().getPageNum(), i, this.grT, 0, -1));
            this.grV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        if (this.grM != null && this.grM.video != null && this.grM.getAdFacadeData() != null && !this.grU) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this.grM.getAdFacadeData(), 34, this.grM.getAdFacadeData().getPageNum(), i, this.grT, this.grT, -1));
            this.grU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        if (this.grM != null && this.grM.video != null && this.grM.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this.grM.getAdFacadeData(), 36, this.grM.getAdFacadeData().getPageNum(), i, this.grT, com.baidu.tieba.ad.a.a.gA(this.dqV.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(int i, int i2) {
        if (this.grM != null && this.grM.video != null && this.grM.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this.grM.getAdFacadeData(), 32, this.grM.getAdFacadeData().getPageNum(), i, this.grT, com.baidu.tieba.ad.a.a.gA(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i, int i2) {
        if (this.grM != null && this.grM.video != null && this.grM.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this.grM.getAdFacadeData(), 33, this.grM.getAdFacadeData().getPageNum(), i, this.grT, com.baidu.tieba.ad.a.a.gA(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.grM.getAdFacadeData(), 303, this.grM.getAdFacadeData().getPageNum(), this.alU ? 0 : 1, this.grM.video.video_duration.intValue(), 0, -1);
            if (this.grR != null) {
                this.grR.e(a);
            }
        }
    }
}
