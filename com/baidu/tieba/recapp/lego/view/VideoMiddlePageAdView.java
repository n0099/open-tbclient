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
    public TextView aKU;
    private boolean ayi;
    private Animation bOT;
    private n bPe;
    public HeadImageView cDU;
    private Animation dQD;
    public FrameLayout dQi;
    public FrameLayout dQj;
    public TextView dQk;
    public c dQw;
    private View ehK;
    private View ehQ;
    private b ehS;
    private Animation.AnimationListener ehW;
    private Animation.AnimationListener ehX;
    private View gSQ;
    private View gSR;
    private View gSS;
    public TextView gST;
    private VideoMiddlePageAdCard gSU;
    private TextView gSV;
    private TextView gSW;
    private ViewGroup gSX;
    private d gSY;
    private e gSZ;
    private f gTa;
    private int gTb;
    private boolean gTc;
    private boolean gTd;
    private a gTe;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gTc = false;
        this.gTd = true;
        this.ehW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ehQ != null) {
                    VideoMiddlePageAdView.this.ehQ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gSQ != null) {
                    VideoMiddlePageAdView.this.gSQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ehQ != null) {
                    VideoMiddlePageAdView.this.ehQ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gSQ != null) {
                    VideoMiddlePageAdView.this.gSQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehX = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.ehQ != null) {
                    VideoMiddlePageAdView.this.ehQ.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gSQ != null) {
                    VideoMiddlePageAdView.this.gSQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.ehQ != null) {
                    VideoMiddlePageAdView.this.ehQ.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gSQ != null) {
                    VideoMiddlePageAdView.this.gSQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gTc = false;
        this.gTd = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dQi = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.ehK = this.rootView.findViewById(e.g.card_container);
        this.dQj = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dQw = new c((TbPageContext<?>) this.mContext, (View) this.dQj, false);
        this.dQw.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gTb = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dQw.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // com.baidu.tieba.play.c.a
            public void hz(boolean z) {
                if (VideoMiddlePageAdView.this.gTe != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.gTe.nP(0);
                    } else {
                        VideoMiddlePageAdView.this.gTe.nP(1);
                    }
                }
            }
        });
        this.dQw.frU.setOnTouchListener(null);
        this.dQk = (TextView) this.rootView.findViewById(e.g.title);
        this.cDU = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.cDU.setIsRound(true);
        this.cDU.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cDU.setDefaultResource(e.f.icon_default_avatar100);
        this.cDU.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gST = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aKU = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bPe = new n(this.mContext.getPageActivity());
        this.gSV = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gSW = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gSX = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gSY = new d(this.mContext.getPageActivity(), this.gSX);
        this.gSY.page = 1;
        this.ehQ = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gSR = this.rootView.findViewById(e.g.user_container_foreground);
        this.gSS = this.rootView.findViewById(e.g.title_foreground);
        this.gSQ = this.rootView.findViewById(e.g.operate_area_foreground);
        this.ehQ.setOnClickListener(this);
        this.gSR.setOnClickListener(this);
        this.gSS.setOnClickListener(this);
        this.gSQ.setOnClickListener(this);
        this.dQj.setOnClickListener(this);
        this.dQi.setOnClickListener(this);
        this.dQw.T(this);
        this.dQk.setOnClickListener(this);
        this.cDU.setOnClickListener(this);
        this.aKU.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQi.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dQi.setLayoutParams(layoutParams);
        this.dQD = new AlphaAnimation(0.0f, 0.7f);
        this.dQD.setDuration(500L);
        this.dQD.setAnimationListener(this.ehX);
        this.bOT = new AlphaAnimation(0.7f, 0.0f);
        this.bOT.setDuration(500L);
        this.bOT.setAnimationListener(this.ehW);
        this.rootView.setOnClickListener(this);
        this.gTe = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aZy() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.ayi = this.gSU.autoPlay;
            this.gTc = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gTb = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dQw.bsq()) {
                bF(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dQw.getCurrentPosition());
                this.gTd = true;
            }
            this.dQw.stopPlay();
            this.dQw.setIsNeedRecoveryVideoPlayer(true);
            this.dQw.mz(true);
            this.dQw.mv(false);
            this.dQw.mA(true);
            this.dQw.S(false, true);
            this.dQw.tD(i);
            this.dQw.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                }
            });
            this.dQw.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.l
                public void aEg() {
                    if (VideoMiddlePageAdView.this.gSU != null && VideoMiddlePageAdView.this.gSU.video != null && VideoMiddlePageAdView.this.gSU.video.video_height.intValue() > VideoMiddlePageAdView.this.gSU.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dQw.S(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dQw.S(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gTa != null) {
                        VideoMiddlePageAdView.this.gTa.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ug(VideoMiddlePageAdView.this.ayi ? 0 : 1);
                    VideoMiddlePageAdView.this.gTc = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void aEh() {
                }
            });
            this.dQw.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.f
                public void gZ(boolean z) {
                    VideoMiddlePageAdView.this.dQw.ba(VideoMiddlePageAdView.this.gSU.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gTa != null) {
                        VideoMiddlePageAdView.this.gTa.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.ug(1);
                    VideoMiddlePageAdView.this.gTc = false;
                }
            });
            this.dQw.ms(false);
            this.dQw.getVideoView().setBusiness(this.bPe);
            this.dQw.bac();
            this.dQw.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dQw.aNk();
                    if (VideoMiddlePageAdView.this.gSZ != null) {
                        VideoMiddlePageAdView.this.gSZ.bwS();
                    }
                    VideoMiddlePageAdView.this.uh(VideoMiddlePageAdView.this.ayi ? 0 : 1);
                    VideoMiddlePageAdView.this.gTd = true;
                }
            });
            this.dQw.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.ui(VideoMiddlePageAdView.this.ayi ? 0 : 1);
                    return true;
                }
            });
            this.dQw.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dQw.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dQw.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void aEj() {
                    VideoMiddlePageAdView.this.bG(1, VideoMiddlePageAdView.this.dQw.getCurrentPosition());
                }
            });
            this.dQw.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bF(1, VideoMiddlePageAdView.this.dQw.getCurrentPosition());
                    VideoMiddlePageAdView.this.gTd = true;
                }
            });
            this.dQw.aNk();
            this.dQw.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dQw.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gSZ != null) {
                    this.gSZ.mQ(true);
                }
                if (i == 0) {
                    this.ehQ.setVisibility(8);
                    this.gSQ.setVisibility(8);
                } else {
                    this.ehQ.startAnimation(this.bOT);
                    this.gSQ.startAnimation(this.bOT);
                }
                if (i == 0) {
                    this.gTe.nP(3);
                    return;
                } else {
                    this.gTe.nP(0);
                    return;
                }
            }
            this.gTe.nP(3);
            if (j.kX() && videoMiddlePageAdCard.waitConfirm) {
                this.ehQ.startAnimation(this.bOT);
                this.gSQ.startAnimation(this.bOT);
                return;
            }
            this.ehQ.setVisibility(0);
            this.gSQ.setVisibility(0);
        }
    }

    private boolean aIN() {
        try {
            int intValue = this.gSU.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gSU.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dQk.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.gST.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.gSV.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.gSW.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        al.i(this.gSW, e.f.btn_rouned_corner_bg_shape);
    }

    private void aIO() {
        if (!aIN()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQi.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dQi.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dQi.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dQi.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gSU = videoMiddlePageAdCard;
        aIO();
        this.dQk.setText(videoMiddlePageAdCard.threadTitle);
        this.aKU.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.cDU.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.cDU.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.cDU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.GL() || VideoMiddlePageAdView.this.gSU == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(VideoMiddlePageAdView.this.gSU.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gST.setText(videoMiddlePageAdCard.tagName);
        this.gSV.setText(videoMiddlePageAdCard.operateData.gQF);
        this.gSW.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gSZ != null) {
                    VideoMiddlePageAdView.this.gSZ.mQ(false);
                }
                if (VideoMiddlePageAdView.this.frw != null) {
                    VideoMiddlePageAdView.this.frw.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gSU, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gSZ = this.gSY.a(videoMiddlePageAdCard.tailFrame, this.gSZ);
        if (this.gSZ != null) {
            b(this.gSU.getAdFacadeData());
            this.gSZ.setPageContext(this.mContext);
            this.gSZ.setTimeoutListener(this);
            this.gSZ.a(videoMiddlePageAdCard.tailFrame);
            this.gSZ.c(this.gSU);
            this.gSZ.bwT();
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
        this.ehS = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gTa = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ak(View view) {
        this.Sp.mH(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aEe();
        if (this.ehQ != null) {
            this.ehQ.clearAnimation();
        }
        if (this.gSQ != null) {
            this.gSQ.clearAnimation();
        }
    }

    public void aEd() {
        this.dQw.stopPlay();
        if (this.dQk != null) {
            this.dQk.setVisibility(0);
        }
        if (this.gTe != null) {
            this.gTe.nP(2);
        }
        this.gTc = false;
        this.gTd = true;
    }

    public void aEe() {
        if (this.dQw != null) {
            this.dQw.destroy();
        }
        this.gTc = false;
        this.gTd = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ehQ && this.ehQ.getVisibility() == 0) {
            if (this.ehS != null) {
                this.ehS.nT(this.mPosition);
            }
        } else if (view == this.gSQ && this.gSQ.getVisibility() == 0) {
            if (this.ehS != null) {
                this.ehS.nT(this.mPosition);
            }
        } else if (view == this.gSS || view == this.gSR) {
            if (this.ehQ.getVisibility() == 0) {
                if (this.ehS != null) {
                    this.ehS.nT(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gSS.getVisibility() == 0) {
                this.gSS.setVisibility(8);
            }
            if (this.gSR.getVisibility() == 0) {
                this.gSR.setVisibility(8);
            }
            mN(true);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gPz = new WebVideoActivity.a();
            if (this.gSU.getAdFacadeData() != null) {
                WebVideoActivity.gPz.gPJ = this.gSU.getAdFacadeData().py();
                WebVideoActivity.gPz.mPage = "DETAIL";
                if (this.gSU.getAdFacadeData().Sb != null) {
                    WebVideoActivity.gPz.mPageNum = this.gSU.getAdFacadeData().Sb.pu();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gSU.getScheme(), true, true, true, this.gSU.video.video_url, this.gSU.video.thumbnail_url, 1.7777778f, this.gTb)));
            if (this.frw != null) {
                this.frw.b(0, null);
            }
            if (this.gSZ != null) {
                this.gSZ.mQ(false);
            }
        } else {
            int e = s.e(this.mContext, this.gSU.getScheme());
            if (this.frw != null) {
                this.frw.b(e, null);
            }
            if (this.gSZ != null) {
                this.gSZ.mQ(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.hK(this.dQw.getCurrentPosition()) < this.gTb && this.dQw.getCurrentState() == 1) {
            bF(this.ayi ? 0 : 1, this.dQw.getCurrentPosition());
        }
        aEd();
        this.gSZ.mQ(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dQw.pausePlay();
            bF(this.ayi ? 0 : 1, this.dQw.getCurrentPosition());
            this.gTd = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dQw.bsq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ug(int i) {
        if (this.gSU != null && this.gSU.video != null && this.gSU.getAdFacadeData() != null && this.gTd) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gSU.getAdFacadeData(), 31, this.gSU.getAdFacadeData().getPageNum(), i, this.gTb, 0, -1));
            this.gTd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i) {
        if (this.gSU != null && this.gSU.video != null && this.gSU.getAdFacadeData() != null && !this.gTc) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gSU.getAdFacadeData(), 34, this.gSU.getAdFacadeData().getPageNum(), i, this.gTb, this.gTb, -1));
            this.gTc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(int i) {
        if (this.gSU != null && this.gSU.video != null && this.gSU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gSU.getAdFacadeData(), 36, this.gSU.getAdFacadeData().getPageNum(), i, this.gTb, com.baidu.tieba.ad.a.a.hK(this.dQw.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        if (this.gSU != null && this.gSU.video != null && this.gSU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gSU.getAdFacadeData(), 32, this.gSU.getAdFacadeData().getPageNum(), i, this.gTb, com.baidu.tieba.ad.a.a.hK(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(int i, int i2) {
        if (this.gSU != null && this.gSU.video != null && this.gSU.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this.gSU.getAdFacadeData(), 33, this.gSU.getAdFacadeData().getPageNum(), i, this.gTb, com.baidu.tieba.ad.a.a.hK(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a2 = com.baidu.tieba.recapp.report.f.a(this.gSU.getAdFacadeData(), 303, this.gSU.getAdFacadeData().getPageNum(), this.ayi ? 0 : 1, this.gSU.video.video_duration.intValue(), 0, -1);
            if (this.gSZ != null) {
                this.gSZ.e(a2);
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
        private Runnable eib = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.eib);
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
                    this.mHandler.removeCallbacks(this.eib);
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
            this.mHandler.removeCallbacks(this.eib);
            this.mHandler.postDelayed(this.eib, 3000L);
        }

        private int nQ(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.gSS.setVisibility(8);
                VideoMiddlePageAdView.this.gSR.setVisibility(8);
                VideoMiddlePageAdView.this.mN(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nR(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.gSS.setVisibility(0);
                VideoMiddlePageAdView.this.gSR.setVisibility(0);
                if (i2 != 3 || VideoMiddlePageAdView.this.gSU.autoPlay) {
                    VideoMiddlePageAdView.this.mN(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int nS(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.gSS.setVisibility(0);
                VideoMiddlePageAdView.this.gSR.setVisibility(0);
                VideoMiddlePageAdView.this.mN(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
