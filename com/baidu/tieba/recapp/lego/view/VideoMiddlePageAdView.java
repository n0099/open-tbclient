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
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, g, i, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Sp;
    public TextView aKT;
    private boolean ayh;
    private Animation bOS;
    private n bPd;
    public HeadImageView cDT;
    private Animation dQC;
    public FrameLayout dQh;
    public FrameLayout dQi;
    public TextView dQj;
    public c dQv;
    private View ehJ;
    private View ehP;
    private b ehR;
    private Animation.AnimationListener ehV;
    private Animation.AnimationListener ehW;
    private View gSP;
    private View gSQ;
    private View gSR;
    public TextView gSS;
    private VideoMiddlePageAdCard gST;
    private TextView gSU;
    private TextView gSV;
    private ViewGroup gSW;
    private d gSX;
    private e gSY;
    private f gSZ;
    private int gTa;
    private boolean gTb;
    private boolean gTc;
    private a gTd;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gTb = false;
        this.gTc = true;
        this.ehV = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ehP != null) {
                    VideoMiddlePageAdView.this.ehP.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gSP != null) {
                    VideoMiddlePageAdView.this.gSP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ehP != null) {
                    VideoMiddlePageAdView.this.ehP.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gSP != null) {
                    VideoMiddlePageAdView.this.gSP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ehP != null) {
                    VideoMiddlePageAdView.this.ehP.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gSP != null) {
                    VideoMiddlePageAdView.this.gSP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ehP != null) {
                    VideoMiddlePageAdView.this.ehP.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gSP != null) {
                    VideoMiddlePageAdView.this.gSP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gTb = false;
        this.gTc = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dQh = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.ehJ = this.rootView.findViewById(e.g.card_container);
        this.dQi = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dQv = new c((TbPageContext<?>) this.mContext, (View) this.dQi, false);
        this.dQv.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gTa = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dQv.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // com.baidu.tieba.play.c.a
            public void hz(boolean z) {
                if (VideoMiddlePageAdView.this.gTd != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.gTd.nP(0);
                    } else {
                        VideoMiddlePageAdView.this.gTd.nP(1);
                    }
                }
            }
        });
        this.dQv.frT.setOnTouchListener(null);
        this.dQj = (TextView) this.rootView.findViewById(e.g.title);
        this.cDT = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.cDT.setIsRound(true);
        this.cDT.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cDT.setDefaultResource(e.f.icon_default_avatar100);
        this.cDT.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gSS = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aKT = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bPd = new n(this.mContext.getPageActivity());
        this.gSU = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gSV = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gSW = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gSX = new d(this.mContext.getPageActivity(), this.gSW);
        this.gSX.page = 1;
        this.ehP = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gSQ = this.rootView.findViewById(e.g.user_container_foreground);
        this.gSR = this.rootView.findViewById(e.g.title_foreground);
        this.gSP = this.rootView.findViewById(e.g.operate_area_foreground);
        this.ehP.setOnClickListener(this);
        this.gSQ.setOnClickListener(this);
        this.gSR.setOnClickListener(this);
        this.gSP.setOnClickListener(this);
        this.dQi.setOnClickListener(this);
        this.dQh.setOnClickListener(this);
        this.dQv.T(this);
        this.dQj.setOnClickListener(this);
        this.cDT.setOnClickListener(this);
        this.aKT.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQh.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dQh.setLayoutParams(layoutParams);
        this.dQC = new AlphaAnimation(0.0f, 0.7f);
        this.dQC.setDuration(500L);
        this.dQC.setAnimationListener(this.ehW);
        this.bOS = new AlphaAnimation(0.7f, 0.0f);
        this.bOS.setDuration(500L);
        this.bOS.setAnimationListener(this.ehV);
        this.rootView.setOnClickListener(this);
        this.gTd = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aZy() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.ayh = this.gST.autoPlay;
            this.gTb = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gTa = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dQv.bsq()) {
                bF(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dQv.getCurrentPosition());
                this.gTc = true;
            }
            this.dQv.stopPlay();
            this.dQv.setIsNeedRecoveryVideoPlayer(true);
            this.dQv.mz(true);
            this.dQv.mv(false);
            this.dQv.mA(true);
            this.dQv.S(false, true);
            this.dQv.tD(i);
            this.dQv.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                }
            });
            this.dQv.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.l
                public void aEg() {
                    if (VideoMiddlePageAdView.this.gST != null && VideoMiddlePageAdView.this.gST.video != null && VideoMiddlePageAdView.this.gST.video.video_height.intValue() > VideoMiddlePageAdView.this.gST.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dQv.S(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dQv.S(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gSZ != null) {
                        VideoMiddlePageAdView.this.gSZ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ug(VideoMiddlePageAdView.this.ayh ? 0 : 1);
                    VideoMiddlePageAdView.this.gTb = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void aEh() {
                }
            });
            this.dQv.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.f
                public void gZ(boolean z) {
                    VideoMiddlePageAdView.this.dQv.ba(VideoMiddlePageAdView.this.gST.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gSZ != null) {
                        VideoMiddlePageAdView.this.gSZ.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ug(1);
                    VideoMiddlePageAdView.this.gTb = false;
                }
            });
            this.dQv.ms(false);
            this.dQv.getVideoView().setBusiness(this.bPd);
            this.dQv.bac();
            this.dQv.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dQv.aNk();
                    if (VideoMiddlePageAdView.this.gSY != null) {
                        VideoMiddlePageAdView.this.gSY.bwS();
                    }
                    VideoMiddlePageAdView.this.uh(VideoMiddlePageAdView.this.ayh ? 0 : 1);
                    VideoMiddlePageAdView.this.gTc = true;
                }
            });
            this.dQv.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.ui(VideoMiddlePageAdView.this.ayh ? 0 : 1);
                    return true;
                }
            });
            this.dQv.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dQv.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dQv.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void aEj() {
                    VideoMiddlePageAdView.this.bG(1, VideoMiddlePageAdView.this.dQv.getCurrentPosition());
                }
            });
            this.dQv.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bF(1, VideoMiddlePageAdView.this.dQv.getCurrentPosition());
                    VideoMiddlePageAdView.this.gTc = true;
                }
            });
            this.dQv.aNk();
            this.dQv.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dQv.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gSY != null) {
                    this.gSY.mQ(true);
                }
                if (i == 0) {
                    this.ehP.setVisibility(8);
                    this.gSP.setVisibility(8);
                } else {
                    this.ehP.startAnimation(this.bOS);
                    this.gSP.startAnimation(this.bOS);
                }
                if (i == 0) {
                    this.gTd.nP(3);
                    return;
                } else {
                    this.gTd.nP(0);
                    return;
                }
            }
            this.gTd.nP(3);
            if (j.kX() && videoMiddlePageAdCard.waitConfirm) {
                this.ehP.startAnimation(this.bOS);
                this.gSP.startAnimation(this.bOS);
                return;
            }
            this.ehP.setVisibility(0);
            this.gSP.setVisibility(0);
        }
    }

    private boolean aIN() {
        try {
            int intValue = this.gST.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gST.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dQj.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.gSS.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.gSU.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.gSV.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        al.i(this.gSV, e.f.btn_rouned_corner_bg_shape);
    }

    private void aIO() {
        if (!aIN()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQh.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dQh.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dQh.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dQh.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gST = videoMiddlePageAdCard;
        aIO();
        this.dQj.setText(videoMiddlePageAdCard.threadTitle);
        this.aKT.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.cDT.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.cDT.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.cDT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.GL() || VideoMiddlePageAdView.this.gST == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(VideoMiddlePageAdView.this.gST.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gSS.setText(videoMiddlePageAdCard.tagName);
        this.gSU.setText(videoMiddlePageAdCard.operateData.gQE);
        this.gSV.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gSY != null) {
                    VideoMiddlePageAdView.this.gSY.mQ(false);
                }
                if (VideoMiddlePageAdView.this.frv != null) {
                    VideoMiddlePageAdView.this.frv.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gST, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gSY = this.gSX.a(videoMiddlePageAdCard.tailFrame, this.gSY);
        if (this.gSY != null) {
            b(this.gST.getAdFacadeData());
            this.gSY.setPageContext(this.mContext);
            this.gSY.setTimeoutListener(this);
            this.gSY.a(videoMiddlePageAdCard.tailFrame);
            this.gSY.c(this.gST);
            this.gSY.bwT();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Sp = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Sp;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.ehR = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gSZ = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ak(View view) {
        this.Sp.mH(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aEe();
        if (this.ehP != null) {
            this.ehP.clearAnimation();
        }
        if (this.gSP != null) {
            this.gSP.clearAnimation();
        }
    }

    public void aEd() {
        this.dQv.stopPlay();
        if (this.dQj != null) {
            this.dQj.setVisibility(0);
        }
        if (this.gTd != null) {
            this.gTd.nP(2);
        }
        this.gTb = false;
        this.gTc = true;
    }

    public void aEe() {
        if (this.dQv != null) {
            this.dQv.destroy();
        }
        this.gTb = false;
        this.gTc = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ehP && this.ehP.getVisibility() == 0) {
            if (this.ehR != null) {
                this.ehR.nT(this.mPosition);
            }
        } else if (view == this.gSP && this.gSP.getVisibility() == 0) {
            if (this.ehR != null) {
                this.ehR.nT(this.mPosition);
            }
        } else if (view == this.gSR || view == this.gSQ) {
            if (this.ehP.getVisibility() == 0) {
                if (this.ehR != null) {
                    this.ehR.nT(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gSR.getVisibility() == 0) {
                this.gSR.setVisibility(8);
            }
            if (this.gSQ.getVisibility() == 0) {
                this.gSQ.setVisibility(8);
            }
            mN(true);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gPy = new WebVideoActivity.a();
            if (this.gST.getAdFacadeData() != null) {
                WebVideoActivity.gPy.gPI = this.gST.getAdFacadeData().py();
                WebVideoActivity.gPy.mPage = "DETAIL";
                if (this.gST.getAdFacadeData().Sb != null) {
                    WebVideoActivity.gPy.mPageNum = this.gST.getAdFacadeData().Sb.pu();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gST.getScheme(), true, true, true, this.gST.video.video_url, this.gST.video.thumbnail_url, 1.7777778f, this.gTa)));
            if (this.frv != null) {
                this.frv.b(0, null);
            }
            if (this.gSY != null) {
                this.gSY.mQ(false);
            }
        } else {
            int e = s.e(this.mContext, this.gST.getScheme());
            if (this.frv != null) {
                this.frv.b(e, null);
            }
            if (this.gSY != null) {
                this.gSY.mQ(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.hK(this.dQv.getCurrentPosition()) < this.gTa && this.dQv.getCurrentState() == 1) {
            bF(this.ayh ? 0 : 1, this.dQv.getCurrentPosition());
        }
        aEd();
        this.gSY.mQ(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dQv.pausePlay();
            bF(this.ayh ? 0 : 1, this.dQv.getCurrentPosition());
            this.gTc = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dQv.bsq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ug(int i) {
        if (this.gST != null && this.gST.video != null && this.gST.getAdFacadeData() != null && this.gTc) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gST.getAdFacadeData(), 31, this.gST.getAdFacadeData().getPageNum(), i, this.gTa, 0, -1));
            this.gTc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i) {
        if (this.gST != null && this.gST.video != null && this.gST.getAdFacadeData() != null && !this.gTb) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gST.getAdFacadeData(), 34, this.gST.getAdFacadeData().getPageNum(), i, this.gTa, this.gTa, -1));
            this.gTb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(int i) {
        if (this.gST != null && this.gST.video != null && this.gST.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gST.getAdFacadeData(), 36, this.gST.getAdFacadeData().getPageNum(), i, this.gTa, com.baidu.tieba.ad.a.a.hK(this.dQv.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        if (this.gST != null && this.gST.video != null && this.gST.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gST.getAdFacadeData(), 32, this.gST.getAdFacadeData().getPageNum(), i, this.gTa, com.baidu.tieba.ad.a.a.hK(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(int i, int i2) {
        if (this.gST != null && this.gST.video != null && this.gST.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gST.getAdFacadeData(), 33, this.gST.getAdFacadeData().getPageNum(), i, this.gTa, com.baidu.tieba.ad.a.a.hK(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a2 = com.baidu.tieba.recapp.report.f.a(this.gST.getAdFacadeData(), 303, this.gST.getAdFacadeData().getPageNum(), this.ayh ? 0 : 1, this.gST.video.video_duration.intValue(), 0, -1);
            if (this.gSY != null) {
                this.gSY.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private int mCurrentState = -1;
        private Runnable eia = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.eia);
                a.this.nP(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void nP(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = nQ(i);
                    aIT();
                    return;
                case 1:
                    this.mCurrentState = nQ(i);
                    this.mHandler.removeCallbacks(this.eia);
                    return;
                case 2:
                    this.mCurrentState = nR(i);
                    return;
                case 3:
                    this.mCurrentState = nS(i);
                    aIT();
                    return;
                default:
                    this.mCurrentState = nR(i);
                    return;
            }
        }

        private void aIT() {
            this.mHandler.removeCallbacks(this.eia);
            this.mHandler.postDelayed(this.eia, 3000L);
        }

        private int nQ(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.gSR.setVisibility(8);
                VideoMiddlePageAdView.this.gSQ.setVisibility(8);
                VideoMiddlePageAdView.this.mN(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nR(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.gSR.setVisibility(0);
                VideoMiddlePageAdView.this.gSQ.setVisibility(0);
                if (i2 != 3 || VideoMiddlePageAdView.this.gST.autoPlay) {
                    VideoMiddlePageAdView.this.mN(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int nS(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.gSR.setVisibility(0);
                VideoMiddlePageAdView.this.gSQ.setVisibility(0);
                VideoMiddlePageAdView.this.mN(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
