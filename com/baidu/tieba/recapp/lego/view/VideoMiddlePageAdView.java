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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.b;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.g;
import com.baidu.tieba.lego.card.view.i;
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
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, g, i, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Pm;
    public TextView axo;
    private Animation bsX;
    private n btk;
    public HeadImageView ceW;
    private View dBA;
    private b dBC;
    private Animation.AnimationListener dBE;
    private Animation.AnimationListener dBF;
    private View dBr;
    private View dBy;
    private View dBz;
    private Animation dlA;
    private boolean dlB;
    public FrameLayout dlf;
    public FrameLayout dlg;
    public TextView dlh;
    public c dls;
    private View gmG;
    public TextView gmH;
    private VideoMiddlePageAdCard gmI;
    private TextView gmJ;
    private TextView gmK;
    private ViewGroup gmL;
    private d gmM;
    private e gmN;
    private f gmO;
    private int gmP;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dBE = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dBy != null) {
                    VideoMiddlePageAdView.this.dBy.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gmG != null) {
                    VideoMiddlePageAdView.this.gmG.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dBy != null) {
                    VideoMiddlePageAdView.this.dBy.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gmG != null) {
                    VideoMiddlePageAdView.this.gmG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dBF = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dBy != null) {
                    VideoMiddlePageAdView.this.dBy.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gmG != null) {
                    VideoMiddlePageAdView.this.gmG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dBy != null) {
                    VideoMiddlePageAdView.this.dBy.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gmG != null) {
                    VideoMiddlePageAdView.this.gmG.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.middle_page_video_ad_layout, (ViewGroup) null);
        this.dlf = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.dBr = this.rootView.findViewById(d.g.card_container);
        this.dlg = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.dls = new c(this.mContext, this.dlg, false);
        this.dls.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gmP = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dls.mMainView.setOnTouchListener(null);
        this.dlh = (TextView) this.rootView.findViewById(d.g.title);
        this.ceW = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.ceW.setIsRound(true);
        this.ceW.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.ceW.setDefaultResource(d.f.icon_default_avatar100);
        this.ceW.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gmH = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.axo = (TextView) this.rootView.findViewById(d.g.user_name);
        this.btk = new n(this.mContext.getPageActivity());
        this.gmJ = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.gmK = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.gmL = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.gmM = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.gmL);
        this.gmM.page = 1;
        this.dBy = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.dBz = this.rootView.findViewById(d.g.user_container_foreground);
        this.dBA = this.rootView.findViewById(d.g.title_foreground);
        this.gmG = this.rootView.findViewById(d.g.operate_area_foreground);
        this.dBy.setOnClickListener(this);
        this.dBz.setOnClickListener(this);
        this.dBA.setOnClickListener(this);
        this.gmG.setOnClickListener(this);
        this.dlg.setOnClickListener(this);
        this.dlf.setOnClickListener(this);
        this.dls.Q(this);
        this.dlh.setOnClickListener(this);
        this.ceW.setOnClickListener(this);
        this.axo.setOnClickListener(this);
        this.mWidth = l.ah(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dlf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dlf.setLayoutParams(layoutParams);
        this.dlA = new AlphaAnimation(0.0f, 0.7f);
        this.dlA.setDuration(500L);
        this.dlA.setAnimationListener(this.dBF);
        this.bsX = new AlphaAnimation(0.7f, 0.0f);
        this.bsX.setDuration(500L);
        this.bsX.setAnimationListener(this.dBE);
        this.dls.blg();
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aPQ() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.dlB = this.gmI.autoPlay;
            if (this.dls.bkY()) {
                bz(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dls.getCurrentPosition());
            }
            this.dls.stopPlay();
            this.dls.lu(true);
            this.dls.lx(true);
            this.dls.lv(false);
            this.dls.ly(true);
            this.dls.K(false, true);
            this.dls.rz(i);
            this.dls.a(new c.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.b
                public void auZ() {
                }

                @Override // com.baidu.tieba.play.c.b
                public void ava() {
                }
            });
            this.dls.a(new c.k() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.k
                public void avb() {
                    if (VideoMiddlePageAdView.this.gmI != null && VideoMiddlePageAdView.this.gmI.video != null && VideoMiddlePageAdView.this.gmI.video.video_height.intValue() > VideoMiddlePageAdView.this.gmI.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dls.K(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dls.K(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gmO != null) {
                        VideoMiddlePageAdView.this.gmO.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.sa(VideoMiddlePageAdView.this.dlB ? 0 : 1);
                }

                @Override // com.baidu.tieba.play.c.k
                public void avc() {
                }
            });
            this.dls.a(new c.e() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.e
                public void fL(boolean z) {
                    VideoMiddlePageAdView.this.dls.bT(VideoMiddlePageAdView.this.gmI.video.video_url, "");
                    VideoMiddlePageAdView.this.sa(1);
                }
            });
            this.dls.ls(false);
            this.dls.getVideoView().setBusiness(this.btk);
            this.dls.aQu();
            this.dls.b(new c.InterfaceC0217c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void fM(boolean z) {
                    if (!VideoMiddlePageAdView.this.dls.bkY()) {
                        VideoMiddlePageAdView.this.dBA.setVisibility(0);
                        VideoMiddlePageAdView.this.dBz.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.dBA.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dBA.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.dBz.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.dBz.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.lC(1);
                    } else {
                        if (VideoMiddlePageAdView.this.dBA.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dBA.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.dBz.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.dBz.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.lC(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void avd() {
                    VideoMiddlePageAdView.this.lC(1);
                    if (!VideoMiddlePageAdView.this.dls.bkY()) {
                        VideoMiddlePageAdView.this.dBA.setVisibility(0);
                        VideoMiddlePageAdView.this.dBz.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.dBA.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dBA.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.dBz.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.dBz.setVisibility(0);
                    }
                }
            });
            this.dls.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dls.aDt();
                    if (VideoMiddlePageAdView.this.gmN != null) {
                        VideoMiddlePageAdView.this.gmN.bpg();
                    }
                    VideoMiddlePageAdView.this.sb(VideoMiddlePageAdView.this.dlB ? 0 : 1);
                }
            });
            this.dls.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.sc(VideoMiddlePageAdView.this.dlB ? 0 : 1);
                    return true;
                }
            });
            this.dls.pq(videoMiddlePageAdCard.video.thumbnail_url);
            this.dls.bS(videoMiddlePageAdCard.video.video_url, "");
            this.dls.a(new c.h() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.h
                public void ave() {
                    VideoMiddlePageAdView.this.bA(1, VideoMiddlePageAdView.this.dls.getCurrentPosition());
                }
            });
            this.dls.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.f
                public void onPause() {
                    VideoMiddlePageAdView.this.bz(1, VideoMiddlePageAdView.this.dls.getCurrentPosition());
                }
            });
            this.dls.aDt();
            this.dls.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dls.a(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
                if (this.gmN != null) {
                    this.gmN.lM(true);
                }
                if (i == 0) {
                    this.dBy.setVisibility(8);
                    this.gmG.setVisibility(8);
                } else {
                    this.dBy.startAnimation(this.bsX);
                    this.gmG.startAnimation(this.bsX);
                }
                this.dBA.setVisibility(8);
                this.dBz.setVisibility(8);
            } else if (j.jF() && videoMiddlePageAdCard.waitConfirm) {
                this.dBy.startAnimation(this.bsX);
                this.gmG.startAnimation(this.bsX);
                this.dBA.setVisibility(8);
                this.dBz.setVisibility(8);
            } else {
                this.dBA.setVisibility(0);
                this.dBz.setVisibility(0);
                this.dBy.setVisibility(0);
                this.gmG.setVisibility(0);
            }
        }
    }

    private boolean azE() {
        try {
            int intValue = this.gmI.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gmI.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dlh.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.gmH.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.gmJ.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.gmK.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i));
        al.i(this.gmK, d.f.btn_rouned_corner_bg_shape);
    }

    private void azF() {
        if (!azE()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dlf.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dlf.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dlf.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dlf.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gmI = videoMiddlePageAdCard;
        azF();
        this.dlh.setText(videoMiddlePageAdCard.threadTitle);
        this.axo.setText(videoMiddlePageAdCard.userName);
        this.ceW.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.ceW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.BK() || VideoMiddlePageAdView.this.gmI == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aN(VideoMiddlePageAdView.this.gmI.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gmH.setText(videoMiddlePageAdCard.tagName);
        this.gmJ.setText(videoMiddlePageAdCard.operateData.gkv);
        this.gmK.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gmK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gmN != null) {
                    VideoMiddlePageAdView.this.gmN.lM(false);
                }
                if (VideoMiddlePageAdView.this.eIN != null) {
                    VideoMiddlePageAdView.this.eIN.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gmI, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gmN = this.gmM.a(videoMiddlePageAdCard.tailFrame, this.gmN);
        if (this.gmN != null) {
            b(this.gmI.getAdFacadeData());
            this.gmN.setPageContext(this.mContext);
            this.gmN.setTimeoutListener(this);
            this.gmN.a(videoMiddlePageAdCard.tailFrame);
            this.gmN.c(this.gmI);
            this.gmN.bph();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Pm = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Pm;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dBC = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gmO = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void U(View view) {
        this.Pm.kt(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        auX();
        if (this.dBy != null) {
            this.dBy.clearAnimation();
        }
        if (this.gmG != null) {
            this.gmG.clearAnimation();
        }
    }

    public void auW() {
        this.dls.stopPlay();
        if (this.dlh != null) {
            this.dlh.setVisibility(0);
        }
    }

    public void auX() {
        if (this.dls != null) {
            this.dls.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(int i) {
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
        if (view == this.dBy && this.dBy.getVisibility() == 0) {
            if (this.dBC != null) {
                this.dBC.lD(this.mPosition);
            }
        } else if (view == this.gmG && this.gmG.getVisibility() == 0) {
            if (this.dBC != null) {
                this.dBC.lD(this.mPosition);
            }
        } else if (view == this.dBA || view == this.dBz) {
            if (this.dBy.getVisibility() == 0) {
                if (this.dBC != null) {
                    this.dBC.lD(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dBA.getVisibility() == 0) {
                this.dBA.setVisibility(8);
            }
            if (this.dBz.getVisibility() == 0) {
                this.dBz.setVisibility(8);
            }
            lC(0);
        } else if (view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.float_video_container || view.getId() == d.g.title) {
            WebVideoActivity.gjo = new WebVideoActivity.a();
            if (this.gmI.getAdFacadeData() != null) {
                WebVideoActivity.gjo.gjy = this.gmI.getAdFacadeData().ok();
                WebVideoActivity.gjo.gjz = "VIDEO_LIST";
                if (this.gmI.getAdFacadeData().OY != null) {
                    WebVideoActivity.gjo.mPageNum = this.gmI.getAdFacadeData().OY.og();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gmI.getScheme(), true, true, true, this.gmI.video.video_url, this.gmI.video.thumbnail_url, 1.7777778f, this.gmP)));
            if (this.eIN != null) {
                this.eIN.b(0, null);
            }
            if (this.gmN != null) {
                this.gmN.lM(false);
            }
        } else {
            int e = s.e(this.mContext, this.gmI.getScheme());
            if (this.eIN != null) {
                this.eIN.b(e, null);
            }
            if (this.gmN != null) {
                this.gmN.lM(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        auW();
        bz(this.dlB ? 0 : 1, this.dls.getCurrentPosition());
        this.gmN.lM(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dls.pausePlay();
            bz(this.dlB ? 0 : 1, this.dls.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dls.bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        if (this.gmI != null && this.gmI.video != null && this.gmI.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this.gmI.getAdFacadeData(), 31, this.gmI.getAdFacadeData().getPageNum(), i, this.gmP, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        if (this.gmI != null && this.gmI.video != null && this.gmI.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this.gmI.getAdFacadeData(), 34, this.gmI.getAdFacadeData().getPageNum(), i, this.gmP, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i) {
        if (this.gmI != null && this.gmI.video != null && this.gmI.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this.gmI.getAdFacadeData(), 34, this.gmI.getAdFacadeData().getPageNum(), i, this.gmP, 0, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(int i, int i2) {
        if (this.gmI != null && this.gmI.video != null && this.gmI.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this.gmI.getAdFacadeData(), 32, this.gmI.getAdFacadeData().getPageNum(), i, this.gmP, i2, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i, int i2) {
        if (this.gmI != null && this.gmI.video != null && this.gmI.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this.gmI.getAdFacadeData(), 33, this.gmI.getAdFacadeData().getPageNum(), i, this.gmP, i2, -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(this.gmI.getAdFacadeData(), 303, this.gmI.getAdFacadeData().getPageNum(), this.dlB ? 0 : 1, this.gmI.video.video_duration.intValue(), 0, -1);
            if (this.gmN != null) {
                this.gmN.e(a);
            }
        }
    }
}
