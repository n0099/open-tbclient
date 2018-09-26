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
    private com.baidu.tieba.frs.aggregation.a RO;
    public TextView aBt;
    private boolean aoz;
    private Animation bAV;
    private n bBi;
    public HeadImageView coE;
    private View dOA;
    private View dOG;
    private b dOI;
    private Animation.AnimationListener dOM;
    private Animation.AnimationListener dON;
    public FrameLayout dwV;
    public FrameLayout dwW;
    public TextView dwX;
    public c dxj;
    private Animation dxq;
    private View gzc;
    private View gzd;
    private View gze;
    public TextView gzf;
    private VideoMiddlePageAdCard gzg;
    private TextView gzh;
    private TextView gzi;
    private ViewGroup gzj;
    private d gzk;
    private e gzl;
    private f gzm;
    private int gzn;
    private boolean gzo;
    private boolean gzp;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gzo = false;
        this.gzp = true;
        this.dOM = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dOG != null) {
                    VideoMiddlePageAdView.this.dOG.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gzd != null) {
                    VideoMiddlePageAdView.this.gzd.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dOG != null) {
                    VideoMiddlePageAdView.this.dOG.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gzd != null) {
                    VideoMiddlePageAdView.this.gzd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dON = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.dOG != null) {
                    VideoMiddlePageAdView.this.dOG.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.gzd != null) {
                    VideoMiddlePageAdView.this.gzd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.dOG != null) {
                    VideoMiddlePageAdView.this.dOG.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.gzd != null) {
                    VideoMiddlePageAdView.this.gzd.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gzo = false;
        this.gzp = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.dwV = (FrameLayout) this.rootView.findViewById(e.g.video_agg_container);
        this.dOA = this.rootView.findViewById(e.g.card_container);
        this.dwW = (FrameLayout) this.rootView.findViewById(e.g.video_container);
        this.dxj = new c(this.mContext, this.dwW, false);
        this.dxj.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.gzn = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.dxj.eYn.setOnTouchListener(null);
        this.dwX = (TextView) this.rootView.findViewById(e.g.title);
        this.coE = (HeadImageView) this.rootView.findViewById(e.g.user_icon);
        this.coE.setIsRound(true);
        this.coE.setDefaultBgResource(e.d.cp_bg_line_e);
        this.coE.setDefaultResource(e.f.icon_default_avatar100);
        this.coE.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gzf = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.aBt = (TextView) this.rootView.findViewById(e.g.user_name);
        this.bBi = new n(this.mContext.getPageActivity());
        this.gzh = (TextView) this.rootView.findViewById(e.g.ad_operate_title);
        this.gzi = (TextView) this.rootView.findViewById(e.g.ad_operate_button);
        this.gzj = (FrameLayout) this.rootView.findViewById(e.g.tail_frame_container);
        this.gzk = new d(this.mContext.getPageActivity(), this.gzj);
        this.gzk.page = 1;
        this.dOG = this.rootView.findViewById(e.g.video_agg_container_foreground);
        this.gzc = this.rootView.findViewById(e.g.user_container_foreground);
        this.gze = this.rootView.findViewById(e.g.title_foreground);
        this.gzd = this.rootView.findViewById(e.g.operate_area_foreground);
        this.dOG.setOnClickListener(this);
        this.gzc.setOnClickListener(this);
        this.gze.setOnClickListener(this);
        this.gzd.setOnClickListener(this);
        this.dwW.setOnClickListener(this);
        this.dwV.setOnClickListener(this);
        this.dxj.R(this);
        this.dwX.setOnClickListener(this);
        this.coE.setOnClickListener(this);
        this.aBt.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dwV.setLayoutParams(layoutParams);
        this.dxq = new AlphaAnimation(0.0f, 0.7f);
        this.dxq.setDuration(500L);
        this.dxq.setAnimationListener(this.dON);
        this.bAV = new AlphaAnimation(0.7f, 0.0f);
        this.bAV.setDuration(500L);
        this.bAV.setAnimationListener(this.dOM);
        this.rootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aTI() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.aoz = this.gzg.autoPlay;
            this.gzo = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.gzn = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.dxj.bmu()) {
                bB(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.dxj.getCurrentPosition());
                this.gzp = true;
            }
            this.dxj.stopPlay();
            this.dxj.setIsNeedRecoveryVideoPlayer(true);
            this.dxj.lR(true);
            this.dxj.lN(false);
            this.dxj.lS(true);
            this.dxj.P(false, true);
            this.dxj.sc(i);
            this.dxj.a(new c.InterfaceC0224c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ayr() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ays() {
                }
            });
            this.dxj.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
                @Override // com.baidu.tieba.play.c.l
                public void ayt() {
                    if (VideoMiddlePageAdView.this.gzg != null && VideoMiddlePageAdView.this.gzg.video != null && VideoMiddlePageAdView.this.gzg.video.video_height.intValue() > VideoMiddlePageAdView.this.gzg.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.dxj.P(false, true);
                    } else {
                        VideoMiddlePageAdView.this.dxj.P(false, true);
                    }
                    if (VideoMiddlePageAdView.this.gzm != null) {
                        VideoMiddlePageAdView.this.gzm.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.sG(VideoMiddlePageAdView.this.aoz ? 0 : 1);
                    VideoMiddlePageAdView.this.gzo = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void ayu() {
                }
            });
            this.dxj.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
                @Override // com.baidu.tieba.play.c.f
                public void gq(boolean z) {
                    VideoMiddlePageAdView.this.dxj.cb(VideoMiddlePageAdView.this.gzg.video.video_url, "");
                    if (VideoMiddlePageAdView.this.gzm != null) {
                        VideoMiddlePageAdView.this.gzm.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.sG(1);
                    VideoMiddlePageAdView.this.gzo = false;
                }
            });
            this.dxj.lK(false);
            this.dxj.getVideoView().setBusiness(this.bBi);
            this.dxj.aUn();
            this.dxj.b(new c.d() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.d
                public void gr(boolean z) {
                    if (!VideoMiddlePageAdView.this.dxj.bmu()) {
                        VideoMiddlePageAdView.this.gze.setVisibility(0);
                        VideoMiddlePageAdView.this.gzc.setVisibility(0);
                    } else if (z) {
                        if (VideoMiddlePageAdView.this.gze.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gze.setVisibility(0);
                        }
                        if (VideoMiddlePageAdView.this.gzc.getVisibility() == 8) {
                            VideoMiddlePageAdView.this.gzc.setVisibility(0);
                        }
                        VideoMiddlePageAdView.this.sF(1);
                    } else {
                        if (VideoMiddlePageAdView.this.gze.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gze.setVisibility(8);
                        }
                        if (VideoMiddlePageAdView.this.gzc.getVisibility() == 0) {
                            VideoMiddlePageAdView.this.gzc.setVisibility(8);
                        }
                        VideoMiddlePageAdView.this.sF(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void ayv() {
                    VideoMiddlePageAdView.this.sF(1);
                    if (!VideoMiddlePageAdView.this.dxj.bmu()) {
                        VideoMiddlePageAdView.this.gze.setVisibility(0);
                        VideoMiddlePageAdView.this.gzc.setVisibility(0);
                        return;
                    }
                    if (VideoMiddlePageAdView.this.gze.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gze.setVisibility(0);
                    }
                    if (VideoMiddlePageAdView.this.gzc.getVisibility() == 8) {
                        VideoMiddlePageAdView.this.gzc.setVisibility(0);
                    }
                }
            });
            this.dxj.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.dxj.aHp();
                    if (VideoMiddlePageAdView.this.gzl != null) {
                        VideoMiddlePageAdView.this.gzl.bqU();
                    }
                    VideoMiddlePageAdView.this.sH(VideoMiddlePageAdView.this.aoz ? 0 : 1);
                    VideoMiddlePageAdView.this.gzp = true;
                }
            });
            this.dxj.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.sI(VideoMiddlePageAdView.this.aoz ? 0 : 1);
                    return true;
                }
            });
            this.dxj.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.dxj.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.dxj.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.c.i
                public void ayw() {
                    VideoMiddlePageAdView.this.bC(1, VideoMiddlePageAdView.this.dxj.getCurrentPosition());
                }
            });
            this.dxj.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.bB(1, VideoMiddlePageAdView.this.dxj.getCurrentPosition());
                    VideoMiddlePageAdView.this.gzp = true;
                }
            });
            this.dxj.aHp();
            this.dxj.show();
            if (videoMiddlePageAdCard.autoPlay) {
                this.dxj.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                if (this.gzl != null) {
                    this.gzl.mg(true);
                }
                if (i == 0) {
                    this.dOG.setVisibility(8);
                    this.gzd.setVisibility(8);
                } else {
                    this.dOG.startAnimation(this.bAV);
                    this.gzd.startAnimation(this.bAV);
                }
                this.gze.setVisibility(8);
                this.gzc.setVisibility(8);
            } else if (j.kM() && videoMiddlePageAdCard.waitConfirm) {
                this.dOG.startAnimation(this.bAV);
                this.gzd.startAnimation(this.bAV);
                this.gze.setVisibility(8);
                this.gzc.setVisibility(8);
            } else {
                this.gze.setVisibility(0);
                this.gzc.setVisibility(0);
                this.dOG.setVisibility(0);
                this.gzd.setVisibility(0);
            }
        }
    }

    private boolean aCZ() {
        try {
            int intValue = this.gzg.video.video_width.intValue();
            return intValue <= 0 || ((float) this.gzg.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.dwX.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gzf.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gzh.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        this.gzi.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        al.i(this.gzi, e.f.btn_rouned_corner_bg_shape);
    }

    private void aDa() {
        if (!aCZ()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dwV.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dwV.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gzg = videoMiddlePageAdCard;
        aDa();
        this.dwX.setText(videoMiddlePageAdCard.threadTitle);
        this.aBt.setText(videoMiddlePageAdCard.userName);
        this.coE.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        this.coE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.De() || VideoMiddlePageAdView.this.gzg == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(VideoMiddlePageAdView.this.gzg.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gzf.setText(videoMiddlePageAdCard.tagName);
        this.gzh.setText(videoMiddlePageAdCard.operateData.gwR);
        this.gzi.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.gzi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.gzl != null) {
                    VideoMiddlePageAdView.this.gzl.mg(false);
                }
                if (VideoMiddlePageAdView.this.eXP != null) {
                    VideoMiddlePageAdView.this.eXP.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.gzg, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.gzl = this.gzk.a(videoMiddlePageAdCard.tailFrame, this.gzl);
        if (this.gzl != null) {
            b(this.gzg.getAdFacadeData());
            this.gzl.setPageContext(this.mContext);
            this.gzl.setTimeoutListener(this);
            this.gzl.a(videoMiddlePageAdCard.tailFrame);
            this.gzl.c(this.gzg);
            this.gzl.bqV();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.RO = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.RO;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dOI = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.gzm = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void al(View view) {
        this.RO.ln(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        ayp();
        if (this.dOG != null) {
            this.dOG.clearAnimation();
        }
        if (this.gzd != null) {
            this.gzd.clearAnimation();
        }
    }

    public void ayo() {
        this.dxj.stopPlay();
        if (this.dwX != null) {
            this.dwX.setVisibility(0);
        }
        this.gzo = false;
        this.gzp = true;
    }

    public void ayp() {
        if (this.dxj != null) {
            this.dxj.destroy();
        }
        this.gzo = false;
        this.gzp = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sF(int i) {
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
        if (view == this.dOG && this.dOG.getVisibility() == 0) {
            if (this.dOI != null) {
                this.dOI.mz(this.mPosition);
            }
        } else if (view == this.gzd && this.gzd.getVisibility() == 0) {
            if (this.dOI != null) {
                this.dOI.mz(this.mPosition);
            }
        } else if (view == this.gze || view == this.gzc) {
            if (this.dOG.getVisibility() == 0) {
                if (this.dOI != null) {
                    this.dOI.mz(this.mPosition);
                    return;
                }
                return;
            }
            if (this.gze.getVisibility() == 0) {
                this.gze.setVisibility(8);
            }
            if (this.gzc.getVisibility() == 0) {
                this.gzc.setVisibility(8);
            }
            sF(0);
        } else if (view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.float_video_container || view.getId() == e.g.title) {
            WebVideoActivity.gvK = new WebVideoActivity.a();
            if (this.gzg.getAdFacadeData() != null) {
                WebVideoActivity.gvK.gvU = this.gzg.getAdFacadeData().pp();
                WebVideoActivity.gvK.gvV = "DETAIL";
                if (this.gzg.getAdFacadeData().Ry != null) {
                    WebVideoActivity.gvK.mPageNum = this.gzg.getAdFacadeData().Ry.pl();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.gzg.getScheme(), true, true, true, this.gzg.video.video_url, this.gzg.video.thumbnail_url, 1.7777778f, this.gzn)));
            if (this.eXP != null) {
                this.eXP.b(0, null);
            }
            if (this.gzl != null) {
                this.gzl.mg(false);
            }
        } else {
            int e = s.e(this.mContext, this.gzg.getScheme());
            if (this.eXP != null) {
                this.eXP.b(e, null);
            }
            if (this.gzl != null) {
                this.gzl.mg(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.ha(this.dxj.getCurrentPosition()) < this.gzn && this.dxj.getCurrentState() == 1) {
            bB(this.aoz ? 0 : 1, this.dxj.getCurrentPosition());
        }
        ayo();
        this.gzl.mg(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.dxj.pausePlay();
            bB(this.aoz ? 0 : 1, this.dxj.getCurrentPosition());
            this.gzp = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dxj.bmu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(int i) {
        if (this.gzg != null && this.gzg.video != null && this.gzg.getAdFacadeData() != null && this.gzp) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(this.gzg.getAdFacadeData(), 31, this.gzg.getAdFacadeData().getPageNum(), i, this.gzn, 0, -1));
            this.gzp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(int i) {
        if (this.gzg != null && this.gzg.video != null && this.gzg.getAdFacadeData() != null && !this.gzo) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(this.gzg.getAdFacadeData(), 34, this.gzg.getAdFacadeData().getPageNum(), i, this.gzn, this.gzn, -1));
            this.gzo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sI(int i) {
        if (this.gzg != null && this.gzg.video != null && this.gzg.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(this.gzg.getAdFacadeData(), 36, this.gzg.getAdFacadeData().getPageNum(), i, this.gzn, com.baidu.tieba.ad.a.a.ha(this.dxj.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(int i, int i2) {
        if (this.gzg != null && this.gzg.video != null && this.gzg.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(this.gzg.getAdFacadeData(), 32, this.gzg.getAdFacadeData().getPageNum(), i, this.gzn, com.baidu.tieba.ad.a.a.ha(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(int i, int i2) {
        if (this.gzg != null && this.gzg.video != null && this.gzg.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(this.gzg.getAdFacadeData(), 33, this.gzg.getAdFacadeData().getPageNum(), i, this.gzn, com.baidu.tieba.ad.a.a.ha(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.gzg.getAdFacadeData(), 303, this.gzg.getAdFacadeData().getPageNum(), this.aoz ? 0 : 1, this.gzg.video.video_duration.intValue(), 0, -1);
            if (this.gzl != null) {
                this.gzl.e(a);
            }
        }
    }
}
