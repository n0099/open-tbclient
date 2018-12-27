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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
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
    private com.baidu.tieba.frs.aggregation.a Sg;
    public TextView aKr;
    private boolean axF;
    private Animation bOg;
    private n bOs;
    public HeadImageView cDi;
    public TextView dPA;
    public c dPM;
    private Animation dPT;
    public FrameLayout dPy;
    public FrameLayout dPz;
    private View ehd;
    private View ehj;
    private b ehl;
    private Animation.AnimationListener ehp;
    private Animation.AnimationListener ehq;
    private View gRM;
    private View gRN;
    private View gRO;
    public TextView gRP;
    private VideoMiddlePageAdCard gRQ;
    private TextView gRR;
    private TextView gRS;
    private ViewGroup gRT;
    private d gRU;
    private e gRV;
    private f gRW;
    private int gRX;
    private boolean gRY;
    private boolean gRZ;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gRY = false;
        this.gRZ = true;
        this.ehp = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ehj != null) {
                    VideoMiddlePageAdView.this.ehj.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gRN != null) {
                    VideoMiddlePageAdView.this.gRN.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ehj != null) {
                    VideoMiddlePageAdView.this.ehj.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gRN != null) {
                    VideoMiddlePageAdView.this.gRN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehq = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ehj != null) {
                    VideoMiddlePageAdView.this.ehj.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gRN != null) {
                    VideoMiddlePageAdView.this.gRN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ehj != null) {
                    VideoMiddlePageAdView.this.ehj.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gRN != null) {
                    VideoMiddlePageAdView.this.gRN.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gRY = false;
        this.gRZ = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dPy = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.ehd = this.rootView.findViewById(e.g.card_container);
        this.dPz = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dPM = new c((TbPageContext<?>) this.mContext, (View) this.dPz, false);
        this.dPM.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gRX = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dPM.fqY.setOnTouchListener(null);
        this.dPA = (TextView) this.rootView.findViewById(e.g.title);
        this.cDi = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.cDi.setIsRound(true);
        this.cDi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cDi.setDefaultResource(e.f.icon_default_avatar100);
        this.cDi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gRP = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aKr = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bOs = new n(this.mContext.getPageActivity());
        this.gRR = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gRS = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gRT = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gRU = new d(this.mContext.getPageActivity(), this.gRT);
        this.gRU.page = 1;
        this.ehj = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gRM = this.rootView.findViewById(e.g.user_container_foreground);
        this.gRO = this.rootView.findViewById(e.g.title_foreground);
        this.gRN = this.rootView.findViewById(e.g.operate_area_foreground);
        this.ehj.setOnClickListener(this);
        this.gRM.setOnClickListener(this);
        this.gRO.setOnClickListener(this);
        this.gRN.setOnClickListener(this);
        this.dPz.setOnClickListener(this);
        this.dPy.setOnClickListener(this);
        this.dPM.T(this);
        this.dPA.setOnClickListener(this);
        this.cDi.setOnClickListener(this);
        this.aKr.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dPy.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dPy.setLayoutParams(layoutParams);
        this.dPT = new AlphaAnimation(0.0f, 0.7f);
        this.dPT.setDuration(500L);
        this.dPT.setAnimationListener(this.ehq);
        this.bOg = new AlphaAnimation(0.7f, 0.0f);
        this.bOg.setDuration(500L);
        this.bOg.setAnimationListener(this.ehp);
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYY() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.axF = this.gRQ.autoPlay;
            this.gRY = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gRX = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dPM.brH()) {
                bF(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dPM.getCurrentPosition());
                this.gRZ = true;
            }
            this.dPM.stopPlay();
            this.dPM.setIsNeedRecoveryVideoPlayer(true);
            this.dPM.mz(true);
            this.dPM.mv(false);
            this.dPM.mA(true);
            this.dPM.S(false, true);
            this.dPM.tz(i);
            this.dPM.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YS() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YT() {
                }
            });
            this.dPM.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.l
                public void aDJ() {
                    if (VideoMiddlePageAdView.this.gRQ != null && VideoMiddlePageAdView.this.gRQ.video != null && VideoMiddlePageAdView.this.gRQ.video.video_height.intValue() > VideoMiddlePageAdView.this.gRQ.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dPM.S(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dPM.S(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gRW != null) {
                        VideoMiddlePageAdView.this.gRW.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ud(VideoMiddlePageAdView.this.axF ? 0 : 1);
                    VideoMiddlePageAdView.this.gRY = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void aDK() {
                }
            });
            this.dPM.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.f
                public void gW(boolean z) {
                    VideoMiddlePageAdView.this.dPM.aZ(VideoMiddlePageAdView.this.gRQ.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gRW != null) {
                        VideoMiddlePageAdView.this.gRW.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ud(1);
                    VideoMiddlePageAdView.this.gRY = false;
                }
            });
            this.dPM.ms(false);
            this.dPM.getVideoView().setBusiness(this.bOs);
            this.dPM.aZC();
            this.dPM.b(new c.d() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.d
                public void gX(boolean z) {
                    if (!VideoMiddlePageAdView.this.dPM.brH()) {
                        VideoMiddlePageAdView.this.gRO.setVisibility(0);
                        VideoMiddlePageAdView.this.gRM.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.gRO.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gRO.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.gRM.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gRM.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.uc(1);
                    } else {
                        if (VideoMiddlePageAdView.this.gRO.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gRO.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.gRM.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gRM.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.uc(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aDL() {
                    VideoMiddlePageAdView.this.uc(1);
                    if (!VideoMiddlePageAdView.this.dPM.brH()) {
                        VideoMiddlePageAdView.this.gRO.setVisibility(0);
                        VideoMiddlePageAdView.this.gRM.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.gRO.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gRO.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.gRM.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gRM.setVisibility(0);
                    }
                }
            });
            this.dPM.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dPM.aMK();
                    if (VideoMiddlePageAdView.this.gRV != null) {
                        VideoMiddlePageAdView.this.gRV.bwj();
                    }
                    VideoMiddlePageAdView.this.ue(VideoMiddlePageAdView.this.axF ? 0 : 1);
                    VideoMiddlePageAdView.this.gRZ = true;
                }
            });
            this.dPM.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.uf(VideoMiddlePageAdView.this.axF ? 0 : 1);
                    return true;
                }
            });
            this.dPM.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dPM.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dPM.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void aDM() {
                    VideoMiddlePageAdView.this.bG(1, VideoMiddlePageAdView.this.dPM.getCurrentPosition());
                }
            });
            this.dPM.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bF(1, VideoMiddlePageAdView.this.dPM.getCurrentPosition());
                    VideoMiddlePageAdView.this.gRZ = true;
                }
            });
            this.dPM.aMK();
            this.dPM.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dPM.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gRV != null) {
                    this.gRV.mP(true);
                }
                if (i == 0) {
                    this.ehj.setVisibility(8);
                    this.gRN.setVisibility(8);
                } else {
                    this.ehj.startAnimation(this.bOg);
                    this.gRN.startAnimation(this.bOg);
                }
                this.gRO.setVisibility(8);
                this.gRM.setVisibility(8);
            } else if (j.kX() && videoMiddlePageAdCard.waitConfirm) {
                this.ehj.startAnimation(this.bOg);
                this.gRN.startAnimation(this.bOg);
                this.gRO.setVisibility(8);
                this.gRM.setVisibility(8);
            } else {
                this.gRO.setVisibility(0);
                this.gRM.setVisibility(0);
                this.ehj.setVisibility(0);
                this.gRN.setVisibility(0);
            }
        }
    }

    private boolean aIq() {
        try {
            int intValue = this.gRQ.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gRQ.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dPA.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gRP.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gRR.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gRS.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        al.i(this.gRS, e.f.btn_rouned_corner_bg_shape);
    }

    private void aIr() {
        if (!aIq()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dPy.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dPy.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dPy.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dPy.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gRQ = videoMiddlePageAdCard;
        aIr();
        this.dPA.setText(videoMiddlePageAdCard.threadTitle);
        this.aKr.setText(videoMiddlePageAdCard.userName);
        this.cDi.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.cDi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Gy() || VideoMiddlePageAdView.this.gRQ == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(VideoMiddlePageAdView.this.gRQ.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gRP.setText(videoMiddlePageAdCard.tagName);
        this.gRR.setText(videoMiddlePageAdCard.operateData.gPB);
        this.gRS.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gRV != null) {
                    VideoMiddlePageAdView.this.gRV.mP(false);
                }
                if (VideoMiddlePageAdView.this.fqA != null) {
                    VideoMiddlePageAdView.this.fqA.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gRQ, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gRV = this.gRU.a(videoMiddlePageAdCard.tailFrame, this.gRV);
        if (this.gRV != null) {
            b(this.gRQ.getAdFacadeData());
            this.gRV.setPageContext(this.mContext);
            this.gRV.setTimeoutListener(this);
            this.gRV.a(videoMiddlePageAdCard.tailFrame);
            this.gRV.c(this.gRQ);
            this.gRV.bwk();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Sg = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Sg;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.ehl = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gRW = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ak(View view) {
        this.Sg.mG(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aDH();
        if (this.ehj != null) {
            this.ehj.clearAnimation();
        }
        if (this.gRN != null) {
            this.gRN.clearAnimation();
        }
    }

    public void aDG() {
        this.dPM.stopPlay();
        if (this.dPA != null) {
            this.dPA.setVisibility(0);
        }
        this.gRY = false;
        this.gRZ = true;
    }

    public void aDH() {
        if (this.dPM != null) {
            this.dPM.destroy();
        }
        this.gRY = false;
        this.gRZ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ehj && this.ehj.getVisibility() == 0) {
            if (this.ehl != null) {
                this.ehl.nS(this.mPosition);
            }
        } else if (view == this.gRN && this.gRN.getVisibility() == 0) {
            if (this.ehl != null) {
                this.ehl.nS(this.mPosition);
            }
        } else if (view == this.gRO || view == this.gRM) {
            if (this.ehj.getVisibility() == 0) {
                if (this.ehl != null) {
                    this.ehl.nS(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gRO.getVisibility() == 0) {
                this.gRO.setVisibility(8);
            }
            if (this.gRM.getVisibility() == 0) {
                this.gRM.setVisibility(8);
            }
            uc(0);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gOu = new WebVideoActivity.a();
            if (this.gRQ.getAdFacadeData() != null) {
                WebVideoActivity.gOu.gOE = this.gRQ.getAdFacadeData().pu();
                WebVideoActivity.gOu.mPage = "DETAIL";
                if (this.gRQ.getAdFacadeData().RR != null) {
                    WebVideoActivity.gOu.mPageNum = this.gRQ.getAdFacadeData().RR.pq();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gRQ.getScheme(), true, true, true, this.gRQ.video.video_url, this.gRQ.video.thumbnail_url, 1.7777778f, this.gRX)));
            if (this.fqA != null) {
                this.fqA.b(0, null);
            }
            if (this.gRV != null) {
                this.gRV.mP(false);
            }
        } else {
            int e = s.e(this.mContext, this.gRQ.getScheme());
            if (this.fqA != null) {
                this.fqA.b(e, null);
            }
            if (this.gRV != null) {
                this.gRV.mP(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.hK(this.dPM.getCurrentPosition()) < this.gRX && this.dPM.getCurrentState() == 1) {
            bF(this.axF ? 0 : 1, this.dPM.getCurrentPosition());
        }
        aDG();
        this.gRV.mP(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dPM.pausePlay();
            bF(this.axF ? 0 : 1, this.dPM.getCurrentPosition());
            this.gRZ = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dPM.brH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        if (this.gRQ != null && this.gRQ.video != null && this.gRQ.getAdFacadeData() != null && this.gRZ) {
            com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(this.gRQ.getAdFacadeData(), 31, this.gRQ.getAdFacadeData().getPageNum(), i, this.gRX, 0, -1));
            this.gRZ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ue(int i) {
        if (this.gRQ != null && this.gRQ.video != null && this.gRQ.getAdFacadeData() != null && !this.gRY) {
            com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(this.gRQ.getAdFacadeData(), 34, this.gRQ.getAdFacadeData().getPageNum(), i, this.gRX, this.gRX, -1));
            this.gRY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.gRQ != null && this.gRQ.video != null && this.gRQ.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(this.gRQ.getAdFacadeData(), 36, this.gRQ.getAdFacadeData().getPageNum(), i, this.gRX, com.baidu.tieba.ad.a.a.hK(this.dPM.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        if (this.gRQ != null && this.gRQ.video != null && this.gRQ.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(this.gRQ.getAdFacadeData(), 32, this.gRQ.getAdFacadeData().getPageNum(), i, this.gRX, com.baidu.tieba.ad.a.a.hK(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(int i, int i2) {
        if (this.gRQ != null && this.gRQ.video != null && this.gRQ.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(this.gRQ.getAdFacadeData(), 33, this.gRQ.getAdFacadeData().getPageNum(), i, this.gRX, com.baidu.tieba.ad.a.a.hK(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.gRQ.getAdFacadeData(), 303, this.gRQ.getAdFacadeData().getPageNum(), this.axF ? 0 : 1, this.gRQ.video.video_duration.intValue(), 0, -1);
            if (this.gRV != null) {
                this.gRV.e(a);
            }
        }
    }
}
