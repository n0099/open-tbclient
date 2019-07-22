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
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, h, j, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a RA;
    public TextView XL;
    private Animation afH;
    private Animation afI;
    private boolean bOG;
    private n dnw;
    public HeadImageView efG;
    private View fSB;
    private c fSD;
    private VideoNetworkStateTipView fSG;
    private Animation.AnimationListener fSN;
    private Animation.AnimationListener fSO;
    private View fSv;
    public FrameLayout fzb;
    public FrameLayout fzc;
    public TextView fzd;
    public com.baidu.tieba.play.c fzp;
    private View iJg;
    private View iJh;
    private View iJi;
    public TextView iJj;
    private VideoMiddlePageAdCard iJk;
    private TextView iJl;
    private TextView iJm;
    private ViewGroup iJn;
    private d iJo;
    private e iJp;
    private f iJq;
    private int iJr;
    private boolean iJs;
    private boolean iJt;
    private a iJu;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iJs = false;
        this.iJt = true;
        this.fSN = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fSB != null) {
                    VideoMiddlePageAdView.this.fSB.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iJg != null) {
                    VideoMiddlePageAdView.this.iJg.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fSB != null) {
                    VideoMiddlePageAdView.this.fSB.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iJg != null) {
                    VideoMiddlePageAdView.this.iJg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fSO = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fSB != null) {
                    VideoMiddlePageAdView.this.fSB.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.iJg != null) {
                    VideoMiddlePageAdView.this.iJg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fSB != null) {
                    VideoMiddlePageAdView.this.fSB.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.iJg != null) {
                    VideoMiddlePageAdView.this.iJg.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iJs = false;
        this.iJt = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.fzb = (FrameLayout) this.rootView.findViewById(R.id.video_agg_container);
        this.fSv = this.rootView.findViewById(R.id.card_container);
        this.fzc = (FrameLayout) this.rootView.findViewById(R.id.video_container);
        this.fzp = new com.baidu.tieba.play.c((TbPageContext<?>) this.mContext, (View) this.fzc, false);
        this.fzp.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                VideoMiddlePageAdView.this.iJr = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fzp.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void kV(boolean z) {
                if (VideoMiddlePageAdView.this.iJu != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.iJu.tc(0);
                    } else {
                        VideoMiddlePageAdView.this.iJu.tc(1);
                    }
                }
            }
        });
        this.fzp.hfu.setOnTouchListener(null);
        this.fzd = (TextView) this.rootView.findViewById(R.id.title);
        this.efG = (HeadImageView) this.rootView.findViewById(R.id.user_icon);
        this.efG.setIsRound(true);
        this.efG.setDefaultBgResource(R.color.cp_bg_line_e);
        this.efG.setDefaultResource(R.drawable.icon_default_avatar100);
        this.efG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iJj = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.XL = (TextView) this.rootView.findViewById(R.id.user_name);
        this.dnw = new n(this.mContext.getPageActivity());
        this.iJl = (TextView) this.rootView.findViewById(R.id.ad_operate_title);
        this.iJm = (TextView) this.rootView.findViewById(R.id.ad_operate_button);
        this.iJn = (FrameLayout) this.rootView.findViewById(R.id.tail_frame_container);
        this.iJo = new d(this.mContext.getPageActivity(), this.iJn);
        this.iJo.page = 1;
        this.fSG = (VideoNetworkStateTipView) this.rootView.findViewById(R.id.network_state_tip);
        this.fSG.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fSG.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fzp.qa(false);
                VideoMiddlePageAdView.this.fSG.cxh();
                if (VideoMiddlePageAdView.this.iJk != null && VideoMiddlePageAdView.this.iJk.video != null) {
                    VideoMiddlePageAdView.this.fzp.cs(VideoMiddlePageAdView.this.iJk.video.video_url, "");
                }
            }
        });
        this.fSB = this.rootView.findViewById(R.id.video_agg_container_foreground);
        this.iJh = this.rootView.findViewById(R.id.user_container_foreground);
        this.iJi = this.rootView.findViewById(R.id.title_foreground);
        this.iJg = this.rootView.findViewById(R.id.operate_area_foreground);
        this.fSB.setOnClickListener(this);
        this.iJh.setOnClickListener(this);
        this.iJi.setOnClickListener(this);
        this.iJg.setOnClickListener(this);
        this.fzc.setOnClickListener(this);
        this.fzb.setOnClickListener(this);
        this.fzp.Y(this);
        this.fzd.setOnClickListener(this);
        this.efG.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.mWidth = l.af(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fzb.setLayoutParams(layoutParams);
        this.afH = new AlphaAnimation(0.0f, 0.7f);
        this.afH.setDuration(500L);
        this.afH.setAnimationListener(this.fSO);
        this.afI = new AlphaAnimation(0.7f, 0.0f);
        this.afI.setDuration(500L);
        this.afI.setAnimationListener(this.fSN);
        this.rootView.setOnClickListener(this);
        this.iJu = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKv() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bOG = this.iJk.autoPlay;
            this.iJs = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.iJr = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fzp.pB()) {
                co(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fzp.getCurrentPosition());
                this.iJt = true;
            }
            this.fzp.stopPlay();
            this.fzp.setIsNeedRecoveryVideoPlayer(true);
            this.fzp.qb(true);
            this.fzp.pX(false);
            this.fzp.qc(true);
            this.fzp.ag(false, true);
            this.fzp.yU(i);
            this.fzp.a(new c.InterfaceC0386c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pz() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pA() {
                }
            });
            this.fzp.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void boj() {
                    if (VideoMiddlePageAdView.this.iJk != null && VideoMiddlePageAdView.this.iJk.video != null && VideoMiddlePageAdView.this.iJk.video.video_height.intValue() > VideoMiddlePageAdView.this.iJk.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fzp.ag(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fzp.ag(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iJq != null) {
                        VideoMiddlePageAdView.this.iJq.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.zB(VideoMiddlePageAdView.this.bOG ? 0 : 1);
                    VideoMiddlePageAdView.this.iJs = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void bok() {
                }
            });
            this.fzp.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void kr(boolean z) {
                    VideoMiddlePageAdView.this.fzp.cs(VideoMiddlePageAdView.this.iJk.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iJq != null) {
                        VideoMiddlePageAdView.this.iJq.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.zB(1);
                    VideoMiddlePageAdView.this.iJs = false;
                }
            });
            this.fzp.pT(false);
            this.fzp.getVideoView().setBusiness(this.dnw);
            this.fzp.bKY();
            this.fzp.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(g gVar) {
                    VideoMiddlePageAdView.this.fzp.bxZ();
                    if (VideoMiddlePageAdView.this.iJp != null) {
                        VideoMiddlePageAdView.this.iJp.ciC();
                    }
                    VideoMiddlePageAdView.this.zC(VideoMiddlePageAdView.this.bOG ? 0 : 1);
                    VideoMiddlePageAdView.this.iJt = true;
                }
            });
            this.fzp.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.zD(VideoMiddlePageAdView.this.bOG ? 0 : 1);
                    return true;
                }
            });
            this.fzp.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fzp.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fzp.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void bom() {
                    VideoMiddlePageAdView.this.cp(1, VideoMiddlePageAdView.this.fzp.getCurrentPosition());
                }
            });
            this.fzp.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.co(1, VideoMiddlePageAdView.this.fzp.getCurrentPosition());
                    VideoMiddlePageAdView.this.iJt = true;
                }
            });
            this.fzp.bxZ();
            this.fzp.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fSG.cff()) {
                    this.fzp.pZ(false);
                    this.fSG.cxg();
                    this.fzp.qa(true);
                    this.fzp.dQ(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fzp.qa(false);
                    this.fzp.pZ(false);
                    this.fSG.hide();
                    this.fzp.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.iJp != null) {
                    this.iJp.qt(true);
                }
                if (i == 0) {
                    this.fSB.setVisibility(8);
                    this.iJg.setVisibility(8);
                } else {
                    this.fSB.startAnimation(this.afI);
                    this.iJg.startAnimation(this.afI);
                }
                if (i == 0) {
                    this.iJu.tc(3);
                    return;
                } else {
                    this.iJu.tc(0);
                    return;
                }
            }
            this.fSG.hide();
            this.fzp.pZ(true);
            this.iJu.tc(3);
            if (com.baidu.adp.lib.util.j.ke() && videoMiddlePageAdCard.waitConfirm) {
                this.fSB.startAnimation(this.afI);
                this.iJg.startAnimation(this.afI);
                return;
            }
            this.fSB.setVisibility(0);
            this.iJg.setVisibility(0);
        }
    }

    private boolean bsZ() {
        try {
            int intValue = this.iJk.video.video_width.intValue();
            return intValue <= 0 || ((float) this.iJk.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fzd.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iJj.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iJl.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.iJm.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
        am.k(this.iJm, R.drawable.btn_rouned_corner_bg_shape);
    }

    private void bta() {
        if (!bsZ()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fzb.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fzb.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iJk = videoMiddlePageAdCard;
        bta();
        this.fzd.setText(videoMiddlePageAdCard.threadTitle);
        this.XL.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.efG.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.efG.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.efG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.amf() || VideoMiddlePageAdView.this.iJk == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aS(VideoMiddlePageAdView.this.iJk.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iJj.setText(videoMiddlePageAdCard.tagName);
        this.iJl.setText(videoMiddlePageAdCard.operateData.iGY);
        this.iJm.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.iJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.iJp != null) {
                    VideoMiddlePageAdView.this.iJp.qt(false);
                }
                if (VideoMiddlePageAdView.this.heW != null) {
                    VideoMiddlePageAdView.this.heW.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.iJk, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.iJp = this.iJo.a(videoMiddlePageAdCard.tailFrame, this.iJp);
        if (this.iJp != null) {
            b(this.iJk.getAdFacadeData());
            this.iJp.setPageContext(this.mContext);
            this.iJp.setTimeoutListener(this);
            this.iJp.a(videoMiddlePageAdCard.tailFrame);
            this.iJp.c(this.iJk);
            this.iJp.ciD();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.RA = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.RA;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fSD = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(f fVar) {
        this.iJq = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bp(View view) {
        this.RA.rQ(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        boh();
        if (this.fSB != null) {
            this.fSB.clearAnimation();
        }
        if (this.iJg != null) {
            this.iJg.clearAnimation();
        }
    }

    public void bog() {
        this.fzp.stopPlay();
        if (this.fzd != null) {
            this.fzd.setVisibility(0);
        }
        if (this.iJu != null) {
            this.iJu.tc(2);
        }
        this.iJs = false;
        this.iJt = true;
    }

    public void boh() {
        if (this.fzp != null) {
            this.fzp.destroy();
        }
        this.iJs = false;
        this.iJt = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fSB && this.fSB.getVisibility() == 0) {
            if (this.fSD != null) {
                this.fSD.tg(this.mPosition);
            }
        } else if (view == this.iJg && this.iJg.getVisibility() == 0) {
            if (this.fSD != null) {
                this.fSD.tg(this.mPosition);
            }
        } else if (view == this.iJi || view == this.iJh) {
            if (this.fSB.getVisibility() == 0) {
                if (this.fSD != null) {
                    this.fSD.tg(this.mPosition);
                    return;
                }
                return;
            }
            this.iJu.tc(0);
        } else if (view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.float_video_container || view.getId() == R.id.title) {
            WebVideoActivity.iFS = new WebVideoActivity.a();
            if (this.iJk.getAdFacadeData() != null) {
                WebVideoActivity.iFS.iGc = this.iJk.getAdFacadeData().ph();
                WebVideoActivity.iFS.azs = "DETAIL";
                if (this.iJk.getAdFacadeData().Rm != null) {
                    WebVideoActivity.iFS.mPageNum = this.iJk.getAdFacadeData().Rm.pd();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.iJk.getScheme(), true, true, true, this.iJk.video.video_url, this.iJk.video.thumbnail_url, 1.7777778f, this.iJr)));
            if (this.heW != null) {
                this.heW.b(0, null);
            }
            if (this.iJp != null) {
                this.iJp.qt(false);
            }
        } else {
            int e = s.e(this.mContext, this.iJk.getScheme());
            if (this.heW != null) {
                this.heW.b(e, null);
            }
            if (this.iJp != null) {
                this.iJp.qt(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.mv(this.fzp.getCurrentPosition()) < this.iJr && this.fzp.getCurrentState() == 1) {
            co(this.bOG ? 0 : 1, this.fzp.getCurrentPosition());
        }
        bog();
        this.iJp.qt(false);
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        if (isPlaying()) {
            this.fzp.pausePlay();
            co(this.bOG ? 0 : 1, this.fzp.getCurrentPosition());
            this.iJt = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fzp.pB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zB(int i) {
        if (this.iJk != null && this.iJk.video != null && this.iJk.getAdFacadeData() != null && this.iJt) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(this.iJk.getAdFacadeData(), 31, this.iJk.getAdFacadeData().getPageNum(), i, this.iJr, 0, -1));
            this.iJt = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zC(int i) {
        if (this.iJk != null && this.iJk.video != null && this.iJk.getAdFacadeData() != null && !this.iJs) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(this.iJk.getAdFacadeData(), 34, this.iJk.getAdFacadeData().getPageNum(), i, this.iJr, this.iJr, -1));
            this.iJs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zD(int i) {
        if (this.iJk != null && this.iJk.video != null && this.iJk.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(this.iJk.getAdFacadeData(), 36, this.iJk.getAdFacadeData().getPageNum(), i, this.iJr, com.baidu.tieba.ad.a.a.mv(this.fzp.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(int i, int i2) {
        if (this.iJk != null && this.iJk.video != null && this.iJk.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(this.iJk.getAdFacadeData(), 32, this.iJk.getAdFacadeData().getPageNum(), i, this.iJr, com.baidu.tieba.ad.a.a.mv(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(int i, int i2) {
        if (this.iJk != null && this.iJk.video != null && this.iJk.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(this.iJk.getAdFacadeData(), 33, this.iJk.getAdFacadeData().getPageNum(), i, this.iJr, com.baidu.tieba.ad.a.a.mv(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.iJk.getAdFacadeData(), 303, this.iJk.getAdFacadeData().getPageNum(), this.bOG ? 0 : 1, this.iJk.video.video_duration.intValue(), 0, -1);
            if (this.iJp != null) {
                this.iJp.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(boolean z) {
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
        private Runnable fSU = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fSU);
                a.this.tc(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void tc(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = td(i);
                    btk();
                    return;
                case 1:
                    this.mCurrentState = td(i);
                    this.mHandler.removeCallbacks(this.fSU);
                    return;
                case 2:
                    this.mCurrentState = te(i);
                    return;
                case 3:
                    this.mCurrentState = tf(i);
                    btk();
                    return;
                default:
                    this.mCurrentState = te(i);
                    return;
            }
        }

        private void btk() {
            this.mHandler.removeCallbacks(this.fSU);
            this.mHandler.postDelayed(this.fSU, 3000L);
        }

        private int td(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iJi.setVisibility(8);
                VideoMiddlePageAdView.this.iJh.setVisibility(8);
                VideoMiddlePageAdView.this.qq(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int te(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iJi.setVisibility(0);
                VideoMiddlePageAdView.this.iJh.setVisibility(0);
                if (VideoMiddlePageAdView.this.fzp != null) {
                    VideoMiddlePageAdView.this.fzp.cdK();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.iJk.autoPlay) {
                    VideoMiddlePageAdView.this.qq(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int tf(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.iJi.setVisibility(0);
                VideoMiddlePageAdView.this.iJh.setVisibility(0);
                VideoMiddlePageAdView.this.qq(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
