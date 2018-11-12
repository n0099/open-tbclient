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
    public TextView aGP;
    private boolean aue;
    private n bKA;
    private Animation bKo;
    public HeadImageView cyq;
    private Animation dGG;
    public FrameLayout dGl;
    public FrameLayout dGm;
    public TextView dGn;
    public c dGz;
    private View dXJ;
    private View dXP;
    private b dXR;
    private Animation.AnimationListener dXV;
    private Animation.AnimationListener dXW;
    private View gIe;
    private View gIf;
    private View gIg;
    public TextView gIh;
    private VideoMiddlePageAdCard gIi;
    private TextView gIj;
    private TextView gIk;
    private ViewGroup gIl;
    private d gIm;
    private e gIn;
    private f gIo;
    private int gIp;
    private boolean gIq;
    private boolean gIr;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gIq = false;
        this.gIr = true;
        this.dXV = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dXP != null) {
                    VideoMiddlePageAdView.this.dXP.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gIf != null) {
                    VideoMiddlePageAdView.this.gIf.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dXP != null) {
                    VideoMiddlePageAdView.this.dXP.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gIf != null) {
                    VideoMiddlePageAdView.this.gIf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dXW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dXP != null) {
                    VideoMiddlePageAdView.this.dXP.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gIf != null) {
                    VideoMiddlePageAdView.this.gIf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dXP != null) {
                    VideoMiddlePageAdView.this.dXP.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gIf != null) {
                    VideoMiddlePageAdView.this.gIf.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gIq = false;
        this.gIr = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dGl = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.dXJ = this.rootView.findViewById(e.g.card_container);
        this.dGm = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dGz = new c((TbPageContext<?>) this.mContext, (View) this.dGm, false);
        this.dGz.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gIp = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dGz.fho.setOnTouchListener(null);
        this.dGn = (TextView) this.rootView.findViewById(e.g.title);
        this.cyq = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.cyq.setIsRound(true);
        this.cyq.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cyq.setDefaultResource(e.f.icon_default_avatar100);
        this.cyq.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gIh = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aGP = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bKA = new n(this.mContext.getPageActivity());
        this.gIj = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gIk = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gIl = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gIm = new d(this.mContext.getPageActivity(), this.gIl);
        this.gIm.page = 1;
        this.dXP = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gIe = this.rootView.findViewById(e.g.user_container_foreground);
        this.gIg = this.rootView.findViewById(e.g.title_foreground);
        this.gIf = this.rootView.findViewById(e.g.operate_area_foreground);
        this.dXP.setOnClickListener(this);
        this.gIe.setOnClickListener(this);
        this.gIg.setOnClickListener(this);
        this.gIf.setOnClickListener(this);
        this.dGm.setOnClickListener(this);
        this.dGl.setOnClickListener(this);
        this.dGz.T(this);
        this.dGn.setOnClickListener(this);
        this.cyq.setOnClickListener(this);
        this.aGP.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dGl.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dGl.setLayoutParams(layoutParams);
        this.dGG = new AlphaAnimation(0.0f, 0.7f);
        this.dGG.setDuration(500L);
        this.dGG.setAnimationListener(this.dXW);
        this.bKo = new AlphaAnimation(0.7f, 0.0f);
        this.bKo.setDuration(500L);
        this.bKo.setAnimationListener(this.dXV);
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWt() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.aue = this.gIi.autoPlay;
            this.gIq = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gIp = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dGz.bpd()) {
                bG(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dGz.getCurrentPosition());
                this.gIr = true;
            }
            this.dGz.stopPlay();
            this.dGz.setIsNeedRecoveryVideoPlayer(true);
            this.dGz.mt(true);
            this.dGz.mp(false);
            this.dGz.mu(true);
            this.dGz.S(false, true);
            this.dGz.sS(i);
            this.dGz.a(new c.InterfaceC0286c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XN() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XO() {
                }
            });
            this.dGz.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.l
                public void aBk() {
                    if (VideoMiddlePageAdView.this.gIi != null && VideoMiddlePageAdView.this.gIi.video != null && VideoMiddlePageAdView.this.gIi.video.video_height.intValue() > VideoMiddlePageAdView.this.gIi.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dGz.S(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dGz.S(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gIo != null) {
                        VideoMiddlePageAdView.this.gIo.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.tw(VideoMiddlePageAdView.this.aue ? 0 : 1);
                    VideoMiddlePageAdView.this.gIq = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void aBl() {
                }
            });
            this.dGz.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.f
                public void gS(boolean z) {
                    VideoMiddlePageAdView.this.dGz.aW(VideoMiddlePageAdView.this.gIi.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gIo != null) {
                        VideoMiddlePageAdView.this.gIo.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.tw(1);
                    VideoMiddlePageAdView.this.gIq = false;
                }
            });
            this.dGz.mm(false);
            this.dGz.getVideoView().setBusiness(this.bKA);
            this.dGz.aWX();
            this.dGz.b(new c.d() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.d
                public void gT(boolean z) {
                    if (!VideoMiddlePageAdView.this.dGz.bpd()) {
                        VideoMiddlePageAdView.this.gIg.setVisibility(0);
                        VideoMiddlePageAdView.this.gIe.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.gIg.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gIg.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.gIe.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gIe.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.tv(1);
                    } else {
                        if (VideoMiddlePageAdView.this.gIg.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gIg.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.gIe.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gIe.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.tv(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBm() {
                    VideoMiddlePageAdView.this.tv(1);
                    if (!VideoMiddlePageAdView.this.dGz.bpd()) {
                        VideoMiddlePageAdView.this.gIg.setVisibility(0);
                        VideoMiddlePageAdView.this.gIe.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.gIg.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gIg.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.gIe.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gIe.setVisibility(0);
                    }
                }
            });
            this.dGz.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dGz.aKf();
                    if (VideoMiddlePageAdView.this.gIn != null) {
                        VideoMiddlePageAdView.this.gIn.btF();
                    }
                    VideoMiddlePageAdView.this.tx(VideoMiddlePageAdView.this.aue ? 0 : 1);
                    VideoMiddlePageAdView.this.gIr = true;
                }
            });
            this.dGz.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.ty(VideoMiddlePageAdView.this.aue ? 0 : 1);
                    return true;
                }
            });
            this.dGz.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dGz.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dGz.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void aBn() {
                    VideoMiddlePageAdView.this.bH(1, VideoMiddlePageAdView.this.dGz.getCurrentPosition());
                }
            });
            this.dGz.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bG(1, VideoMiddlePageAdView.this.dGz.getCurrentPosition());
                    VideoMiddlePageAdView.this.gIr = true;
                }
            });
            this.dGz.aKf();
            this.dGz.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dGz.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gIn != null) {
                    this.gIn.mJ(true);
                }
                if (i == 0) {
                    this.dXP.setVisibility(8);
                    this.gIf.setVisibility(8);
                } else {
                    this.dXP.startAnimation(this.bKo);
                    this.gIf.startAnimation(this.bKo);
                }
                this.gIg.setVisibility(8);
                this.gIe.setVisibility(8);
            } else if (j.kX() && videoMiddlePageAdCard.waitConfirm) {
                this.dXP.startAnimation(this.bKo);
                this.gIf.startAnimation(this.bKo);
                this.gIg.setVisibility(8);
                this.gIe.setVisibility(8);
            } else {
                this.gIg.setVisibility(0);
                this.gIe.setVisibility(0);
                this.dXP.setVisibility(0);
                this.gIf.setVisibility(0);
            }
        }
    }

    private boolean aFP() {
        try {
            int intValue = this.gIi.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gIi.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dGn.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gIh.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gIj.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gIk.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        al.i(this.gIk, e.f.btn_rouned_corner_bg_shape);
    }

    private void aFQ() {
        if (!aFP()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dGl.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dGl.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dGl.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dGl.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gIi = videoMiddlePageAdCard;
        aFQ();
        this.dGn.setText(videoMiddlePageAdCard.threadTitle);
        this.aGP.setText(videoMiddlePageAdCard.userName);
        this.cyq.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.cyq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Ft() || VideoMiddlePageAdView.this.gIi == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(VideoMiddlePageAdView.this.gIi.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gIh.setText(videoMiddlePageAdCard.tagName);
        this.gIj.setText(videoMiddlePageAdCard.operateData.gFT);
        this.gIk.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gIn != null) {
                    VideoMiddlePageAdView.this.gIn.mJ(false);
                }
                if (VideoMiddlePageAdView.this.fgQ != null) {
                    VideoMiddlePageAdView.this.fgQ.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gIi, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gIn = this.gIm.a(videoMiddlePageAdCard.tailFrame, this.gIn);
        if (this.gIn != null) {
            b(this.gIi.getAdFacadeData());
            this.gIn.setPageContext(this.mContext);
            this.gIn.setTimeoutListener(this);
            this.gIn.a(videoMiddlePageAdCard.tailFrame);
            this.gIn.c(this.gIi);
            this.gIn.btG();
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
        this.dXR = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gIo = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void ak(View view) {
        this.Sg.md(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        aBi();
        if (this.dXP != null) {
            this.dXP.clearAnimation();
        }
        if (this.gIf != null) {
            this.gIf.clearAnimation();
        }
    }

    public void aBh() {
        this.dGz.stopPlay();
        if (this.dGn != null) {
            this.dGn.setVisibility(0);
        }
        this.gIq = false;
        this.gIr = true;
    }

    public void aBi() {
        if (this.dGz != null) {
            this.dGz.destroy();
        }
        this.gIq = false;
        this.gIr = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(int i) {
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
        if (view == this.dXP && this.dXP.getVisibility() == 0) {
            if (this.dXR != null) {
                this.dXR.np(this.mPosition);
            }
        } else if (view == this.gIf && this.gIf.getVisibility() == 0) {
            if (this.dXR != null) {
                this.dXR.np(this.mPosition);
            }
        } else if (view == this.gIg || view == this.gIe) {
            if (this.dXP.getVisibility() == 0) {
                if (this.dXR != null) {
                    this.dXR.np(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gIg.getVisibility() == 0) {
                this.gIg.setVisibility(8);
            }
            if (this.gIe.getVisibility() == 0) {
                this.gIe.setVisibility(8);
            }
            tv(0);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gEN = new WebVideoActivity.a();
            if (this.gIi.getAdFacadeData() != null) {
                WebVideoActivity.gEN.gEX = this.gIi.getAdFacadeData().pv();
                WebVideoActivity.gEN.mPage = "DETAIL";
                if (this.gIi.getAdFacadeData().RR != null) {
                    WebVideoActivity.gEN.mPageNum = this.gIi.getAdFacadeData().RR.pr();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gIi.getScheme(), true, true, true, this.gIi.video.video_url, this.gIi.video.thumbnail_url, 1.7777778f, this.gIp)));
            if (this.fgQ != null) {
                this.fgQ.b(0, null);
            }
            if (this.gIn != null) {
                this.gIn.mJ(false);
            }
        } else {
            int e = s.e(this.mContext, this.gIi.getScheme());
            if (this.fgQ != null) {
                this.fgQ.b(e, null);
            }
            if (this.gIn != null) {
                this.gIn.mJ(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.hv(this.dGz.getCurrentPosition()) < this.gIp && this.dGz.getCurrentState() == 1) {
            bG(this.aue ? 0 : 1, this.dGz.getCurrentPosition());
        }
        aBh();
        this.gIn.mJ(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dGz.pausePlay();
            bG(this.aue ? 0 : 1, this.dGz.getCurrentPosition());
            this.gIr = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dGz.bpd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        if (this.gIi != null && this.gIi.video != null && this.gIi.getAdFacadeData() != null && this.gIr) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(this.gIi.getAdFacadeData(), 31, this.gIi.getAdFacadeData().getPageNum(), i, this.gIp, 0, -1));
            this.gIr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(int i) {
        if (this.gIi != null && this.gIi.video != null && this.gIi.getAdFacadeData() != null && !this.gIq) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(this.gIi.getAdFacadeData(), 34, this.gIi.getAdFacadeData().getPageNum(), i, this.gIp, this.gIp, -1));
            this.gIq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty(int i) {
        if (this.gIi != null && this.gIi.video != null && this.gIi.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(this.gIi.getAdFacadeData(), 36, this.gIi.getAdFacadeData().getPageNum(), i, this.gIp, com.baidu.tieba.ad.a.a.hv(this.dGz.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(int i, int i2) {
        if (this.gIi != null && this.gIi.video != null && this.gIi.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(this.gIi.getAdFacadeData(), 32, this.gIi.getAdFacadeData().getPageNum(), i, this.gIp, com.baidu.tieba.ad.a.a.hv(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(int i, int i2) {
        if (this.gIi != null && this.gIi.video != null && this.gIi.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(this.gIi.getAdFacadeData(), 33, this.gIi.getAdFacadeData().getPageNum(), i, this.gIp, com.baidu.tieba.ad.a.a.hv(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.gIi.getAdFacadeData(), 303, this.gIi.getAdFacadeData().getPageNum(), this.aue ? 0 : 1, this.gIi.video.video_duration.intValue(), 0, -1);
            if (this.gIn != null) {
                this.gIn.e(a);
            }
        }
    }
}
