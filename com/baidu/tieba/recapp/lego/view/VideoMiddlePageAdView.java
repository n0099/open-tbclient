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
import com.baidu.tieba.d;
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
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements View.OnClickListener, g, i, CountDownTextView.b {
    private com.baidu.tieba.frs.aggregation.a Tx;
    public TextView Zy;
    private Animation afd;
    private Animation afe;
    private boolean bGe;
    public HeadImageView dQJ;
    private n dbh;
    public FrameLayout fdQ;
    public FrameLayout fdR;
    public TextView fdS;
    public c fee;
    private View fwE;
    private View fwK;
    private com.baidu.tieba.frs.videomiddlepage.c fwM;
    private VideoNetworkStateTipView fwP;
    private Animation.AnimationListener fwV;
    private Animation.AnimationListener fwW;
    private View ijY;
    private View ijZ;
    private View ika;
    public TextView ikb;
    private VideoMiddlePageAdCard ikc;
    private TextView ikd;
    private TextView ike;
    private ViewGroup ikf;
    private d ikg;
    private e ikh;
    private f iki;
    private int ikj;
    private boolean ikk;
    private boolean ikl;
    private a ikm;
    private int mWidth;
    private int position;
    private View rootView;

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ikk = false;
        this.ikl = true;
        this.fwV = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fwK != null) {
                    VideoMiddlePageAdView.this.fwK.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.ijY != null) {
                    VideoMiddlePageAdView.this.ijY.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fwK != null) {
                    VideoMiddlePageAdView.this.fwK.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.ijY != null) {
                    VideoMiddlePageAdView.this.ijY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fwW = new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (VideoMiddlePageAdView.this.fwK != null) {
                    VideoMiddlePageAdView.this.fwK.setVisibility(8);
                }
                if (VideoMiddlePageAdView.this.ijY != null) {
                    VideoMiddlePageAdView.this.ijY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoMiddlePageAdView.this.fwK != null) {
                    VideoMiddlePageAdView.this.fwK.setVisibility(0);
                }
                if (VideoMiddlePageAdView.this.ijY != null) {
                    VideoMiddlePageAdView.this.ijY.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ikk = false;
        this.ikl = true;
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.middle_page_video_ad_layout, (ViewGroup) null);
        this.fdQ = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
        this.fwE = this.rootView.findViewById(d.g.card_container);
        this.fdR = (FrameLayout) this.rootView.findViewById(d.g.video_container);
        this.fee = new c((TbPageContext<?>) this.mContext, (View) this.fdR, false);
        this.fee.a(new g.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                VideoMiddlePageAdView.this.ikj = (int) TimeUnit.MILLISECONDS.toSeconds(gVar.getDuration());
            }
        });
        this.fee.a(new c.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.7
            @Override // com.baidu.tieba.play.c.a
            public void jV(boolean z) {
                if (VideoMiddlePageAdView.this.ikm != null) {
                    if (z) {
                        VideoMiddlePageAdView.this.ikm.rC(0);
                    } else {
                        VideoMiddlePageAdView.this.ikm.rC(1);
                    }
                }
            }
        });
        this.fee.gHJ.setOnTouchListener(null);
        this.fdS = (TextView) this.rootView.findViewById(d.g.title);
        this.dQJ = (HeadImageView) this.rootView.findViewById(d.g.user_icon);
        this.dQJ.setIsRound(true);
        this.dQJ.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.dQJ.setDefaultResource(d.f.icon_default_avatar100);
        this.dQJ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ikb = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.Zy = (TextView) this.rootView.findViewById(d.g.user_name);
        this.dbh = new n(this.mContext.getPageActivity());
        this.ikd = (TextView) this.rootView.findViewById(d.g.ad_operate_title);
        this.ike = (TextView) this.rootView.findViewById(d.g.ad_operate_button);
        this.ikf = (FrameLayout) this.rootView.findViewById(d.g.tail_frame_container);
        this.ikg = new com.baidu.tieba.recapp.e.d(this.mContext.getPageActivity(), this.ikf);
        this.ikg.page = 1;
        this.fwP = (VideoNetworkStateTipView) this.rootView.findViewById(d.g.network_state_tip);
        this.fwP.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoMiddlePageAdView.this.fwP.setHasAgreeToPlay(true);
                VideoMiddlePageAdView.this.fee.oW(false);
                VideoMiddlePageAdView.this.fwP.cmo();
                if (VideoMiddlePageAdView.this.ikc != null && VideoMiddlePageAdView.this.ikc.video != null) {
                    VideoMiddlePageAdView.this.fee.cf(VideoMiddlePageAdView.this.ikc.video.video_url, "");
                }
            }
        });
        this.fwK = this.rootView.findViewById(d.g.video_agg_container_foreground);
        this.ijZ = this.rootView.findViewById(d.g.user_container_foreground);
        this.ika = this.rootView.findViewById(d.g.title_foreground);
        this.ijY = this.rootView.findViewById(d.g.operate_area_foreground);
        this.fwK.setOnClickListener(this);
        this.ijZ.setOnClickListener(this);
        this.ika.setOnClickListener(this);
        this.ijY.setOnClickListener(this);
        this.fdR.setOnClickListener(this);
        this.fdQ.setOnClickListener(this);
        this.fee.T(this);
        this.fdS.setOnClickListener(this);
        this.dQJ.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.mWidth = l.aO(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fdQ.setLayoutParams(layoutParams);
        this.afd = new AlphaAnimation(0.0f, 0.7f);
        this.afd.setDuration(500L);
        this.afd.setAnimationListener(this.fwW);
        this.afe = new AlphaAnimation(0.7f, 0.0f);
        this.afe.setDuration(500L);
        this.afe.setAnimationListener(this.fwV);
        this.rootView.setOnClickListener(this);
        this.ikm = new a();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAa() {
        return this.rootView;
    }

    private void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (videoMiddlePageAdCard != null && videoMiddlePageAdCard.video != null) {
            this.position = i;
            this.bGe = this.ikc.autoPlay;
            this.ikk = false;
            if (videoMiddlePageAdCard.video.video_duration != null && videoMiddlePageAdCard.video.video_duration.intValue() > 0) {
                this.ikj = videoMiddlePageAdCard.video.video_duration.intValue();
            }
            if (this.fee.ql()) {
                cb(videoMiddlePageAdCard.autoPlay ? 0 : 1, this.fee.getCurrentPosition());
                this.ikl = true;
            }
            this.fee.stopPlay();
            this.fee.setIsNeedRecoveryVideoPlayer(true);
            this.fee.oX(true);
            this.fee.oT(false);
            this.fee.oY(true);
            this.fee.ac(false, true);
            this.fee.xi(i);
            this.fee.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.11
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                }
            });
            this.fee.a(new c.l() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.12
                @Override // com.baidu.tieba.play.c.l
                public void beN() {
                    if (VideoMiddlePageAdView.this.ikc != null && VideoMiddlePageAdView.this.ikc.video != null && VideoMiddlePageAdView.this.ikc.video.video_height.intValue() > VideoMiddlePageAdView.this.ikc.video.video_width.intValue()) {
                        VideoMiddlePageAdView.this.fee.ac(false, true);
                    } else {
                        VideoMiddlePageAdView.this.fee.ac(false, true);
                    }
                    if (VideoMiddlePageAdView.this.iki != null) {
                        VideoMiddlePageAdView.this.iki.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.xP(VideoMiddlePageAdView.this.bGe ? 0 : 1);
                    VideoMiddlePageAdView.this.ikk = false;
                }

                @Override // com.baidu.tieba.play.c.l
                public void beO() {
                }
            });
            this.fee.a(new c.f() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.13
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z) {
                    VideoMiddlePageAdView.this.fee.cf(VideoMiddlePageAdView.this.ikc.video.video_url, "");
                    if (VideoMiddlePageAdView.this.iki != null) {
                        VideoMiddlePageAdView.this.iki.a(VideoMiddlePageAdView.this);
                    }
                    VideoMiddlePageAdView.this.xP(1);
                    VideoMiddlePageAdView.this.ikk = false;
                }
            });
            this.fee.oP(false);
            this.fee.getVideoView().setBusiness(this.dbh);
            this.fee.bAD();
            this.fee.a(new g.a() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.14
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    VideoMiddlePageAdView.this.fee.bnN();
                    if (VideoMiddlePageAdView.this.ikh != null) {
                        VideoMiddlePageAdView.this.ikh.bXE();
                    }
                    VideoMiddlePageAdView.this.xQ(VideoMiddlePageAdView.this.bGe ? 0 : 1);
                    VideoMiddlePageAdView.this.ikl = true;
                }
            });
            this.fee.a(new g.b() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    VideoMiddlePageAdView.this.xR(VideoMiddlePageAdView.this.bGe ? 0 : 1);
                    return true;
                }
            });
            this.fee.setThumbnail(videoMiddlePageAdCard.video.thumbnail_url);
            this.fee.setVideoUrl(videoMiddlePageAdCard.video.video_url, "");
            this.fee.a(new c.i() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.3
                @Override // com.baidu.tieba.play.c.i
                public void beQ() {
                    VideoMiddlePageAdView.this.cc(1, VideoMiddlePageAdView.this.fee.getCurrentPosition());
                }
            });
            this.fee.a(new c.g() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.4
                @Override // com.baidu.tieba.play.c.g
                public void onPause() {
                    VideoMiddlePageAdView.this.cb(1, VideoMiddlePageAdView.this.fee.getCurrentPosition());
                    VideoMiddlePageAdView.this.ikl = true;
                }
            });
            this.fee.bnN();
            this.fee.show();
            if (videoMiddlePageAdCard.autoPlay) {
                if (this.fwP.bUk()) {
                    this.fee.oV(false);
                    this.fwP.cmn();
                    this.fee.oW(true);
                    this.fee.dD(videoMiddlePageAdCard.video.video_url, "");
                } else {
                    this.fee.oW(false);
                    this.fee.oV(false);
                    this.fwP.hide();
                    this.fee.a(videoMiddlePageAdCard.video.video_url, "", (c.e) null, new Object[0]);
                }
                if (this.ikh != null) {
                    this.ikh.pp(true);
                }
                if (i == 0) {
                    this.fwK.setVisibility(8);
                    this.ijY.setVisibility(8);
                } else {
                    this.fwK.startAnimation(this.afe);
                    this.ijY.startAnimation(this.afe);
                }
                if (i == 0) {
                    this.ikm.rC(3);
                    return;
                } else {
                    this.ikm.rC(0);
                    return;
                }
            }
            this.fwP.hide();
            this.fee.oV(true);
            this.ikm.rC(3);
            if (j.la() && videoMiddlePageAdCard.waitConfirm) {
                this.fwK.startAnimation(this.afe);
                this.ijY.startAnimation(this.afe);
                return;
            }
            this.fwK.setVisibility(0);
            this.ijY.setVisibility(0);
        }
    }

    private boolean bjB() {
        try {
            int intValue = this.ikc.video.video_width.intValue();
            return intValue <= 0 || ((float) this.ikc.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(VideoMiddlePageAdCard videoMiddlePageAdCard, int i) {
        this.fdS.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        this.ikb.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        this.ikd.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        this.ike.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_i_alpha70));
        al.k(this.ike, d.f.btn_rouned_corner_bg_shape);
    }

    private void bjC() {
        if (!bjB()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fdQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fdQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fdQ.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.ikc = videoMiddlePageAdCard;
        bjC();
        this.fdS.setText(videoMiddlePageAdCard.threadTitle);
        this.Zy.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.dQJ.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.dQJ.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.dQJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.agb() || VideoMiddlePageAdView.this.ikc == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(VideoMiddlePageAdView.this.ikc.adCollect());
                ((Vibrator) VideoMiddlePageAdView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.ikb.setText(videoMiddlePageAdCard.tagName);
        this.ikd.setText(videoMiddlePageAdCard.operateData.ihQ);
        this.ike.setText(videoMiddlePageAdCard.operateData.buttonText);
        this.ike.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = s.e(VideoMiddlePageAdView.this.mContext, videoMiddlePageAdCard.operateData.scheme);
                if (VideoMiddlePageAdView.this.ikh != null) {
                    VideoMiddlePageAdView.this.ikh.pp(false);
                }
                if (VideoMiddlePageAdView.this.gHl != null) {
                    VideoMiddlePageAdView.this.gHl.b(e, null);
                }
            }
        });
        a(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
        b(videoMiddlePageAdCard);
        a(this.ikc, TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.ikh = this.ikg.a(videoMiddlePageAdCard.tailFrame, this.ikh);
        if (this.ikh != null) {
            b(this.ikc.getAdFacadeData());
            this.ikh.setPageContext(this.mContext);
            this.ikh.setTimeoutListener(this);
            this.ikh.a(videoMiddlePageAdCard.tailFrame);
            this.ikh.c(this.ikc);
            this.ikh.bXF();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
        this.Tx = aVar;
    }

    public com.baidu.tieba.frs.aggregation.a getAutoPlayCallBack() {
        return this.Tx;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(com.baidu.tieba.frs.videomiddlepage.c cVar) {
        this.fwM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(f fVar) {
        this.iki = fVar;
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.b
    public void bh(View view) {
        this.Tx.qr(this.position);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void onDestroy() {
        beL();
        if (this.fwK != null) {
            this.fwK.clearAnimation();
        }
        if (this.ijY != null) {
            this.ijY.clearAnimation();
        }
    }

    public void beK() {
        this.fee.stopPlay();
        if (this.fdS != null) {
            this.fdS.setVisibility(0);
        }
        if (this.ikm != null) {
            this.ikm.rC(2);
        }
        this.ikk = false;
        this.ikl = true;
    }

    public void beL() {
        if (this.fee != null) {
            this.fee.destroy();
        }
        this.ikk = false;
        this.ikl = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwK && this.fwK.getVisibility() == 0) {
            if (this.fwM != null) {
                this.fwM.rG(this.mPosition);
            }
        } else if (view == this.ijY && this.ijY.getVisibility() == 0) {
            if (this.fwM != null) {
                this.fwM.rG(this.mPosition);
            }
        } else if (view == this.ika || view == this.ijZ) {
            if (this.fwK.getVisibility() == 0) {
                if (this.fwM != null) {
                    this.fwM.rG(this.mPosition);
                    return;
                }
                return;
            }
            this.ikm.rC(0);
        } else if (view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.float_video_container || view.getId() == d.g.title) {
            WebVideoActivity.igK = new WebVideoActivity.a();
            if (this.ikc.getAdFacadeData() != null) {
                WebVideoActivity.igK.igU = this.ikc.getAdFacadeData().pR();
                WebVideoActivity.igK.axL = "DETAIL";
                if (this.ikc.getAdFacadeData().Tj != null) {
                    WebVideoActivity.igK.mPageNum = this.ikc.getAdFacadeData().Tj.pN();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WebVideoActivityConfig(this.mContext.getPageActivity(), "", this.ikc.getScheme(), true, true, true, this.ikc.video.video_url, this.ikc.video.thumbnail_url, 1.7777778f, this.ikj)));
            if (this.gHl != null) {
                this.gHl.b(0, null);
            }
            if (this.ikh != null) {
                this.ikh.pp(false);
            }
        } else {
            int e = s.e(this.mContext, this.ikc.getScheme());
            if (this.gHl != null) {
                this.gHl.b(e, null);
            }
            if (this.ikh != null) {
                this.ikh.pp(false);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        if (com.baidu.tieba.ad.a.a.lz(this.fee.getCurrentPosition()) < this.ikj && this.fee.getCurrentState() == 1) {
            cb(this.bGe ? 0 : 1, this.fee.getCurrentPosition());
        }
        beK();
        this.ikh.pp(false);
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        if (isPlaying()) {
            this.fee.pausePlay();
            cb(this.bGe ? 0 : 1, this.fee.getCurrentPosition());
            this.ikl = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.fee.ql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP(int i) {
        if (this.ikc != null && this.ikc.video != null && this.ikc.getAdFacadeData() != null && this.ikl) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this.ikc.getAdFacadeData(), 31, this.ikc.getAdFacadeData().getPageNum(), i, this.ikj, 0, -1));
            this.ikl = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ(int i) {
        if (this.ikc != null && this.ikc.video != null && this.ikc.getAdFacadeData() != null && !this.ikk) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this.ikc.getAdFacadeData(), 34, this.ikc.getAdFacadeData().getPageNum(), i, this.ikj, this.ikj, -1));
            this.ikk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR(int i) {
        if (this.ikc != null && this.ikc.video != null && this.ikc.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this.ikc.getAdFacadeData(), 36, this.ikc.getAdFacadeData().getPageNum(), i, this.ikj, com.baidu.tieba.ad.a.a.lz(this.fee.getCurrentPosition()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        if (this.ikc != null && this.ikc.video != null && this.ikc.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this.ikc.getAdFacadeData(), 32, this.ikc.getAdFacadeData().getPageNum(), i, this.ikj, com.baidu.tieba.ad.a.a.lz(i2), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i, int i2) {
        if (this.ikc != null && this.ikc.video != null && this.ikc.getAdFacadeData() != null) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this.ikc.getAdFacadeData(), 33, this.ikc.getAdFacadeData().getPageNum(), i, this.ikj, com.baidu.tieba.ad.a.a.lz(i2), -1));
        }
    }

    private void b(com.baidu.afd.d dVar) {
        if (dVar != null) {
            b a2 = com.baidu.tieba.recapp.report.f.a(this.ikc.getAdFacadeData(), 303, this.ikc.getAdFacadeData().getPageNum(), this.bGe ? 0 : 1, this.ikc.video.video_duration.intValue(), 0, -1);
            if (this.ikh != null) {
                this.ikh.e(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pm(boolean z) {
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
        private Runnable fxc = new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.fxc);
                a.this.rC(2);
            }
        };
        private Handler mHandler = new Handler();

        public a() {
        }

        public void rC(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = rD(i);
                    bjM();
                    return;
                case 1:
                    this.mCurrentState = rD(i);
                    this.mHandler.removeCallbacks(this.fxc);
                    return;
                case 2:
                    this.mCurrentState = rE(i);
                    return;
                case 3:
                    this.mCurrentState = rF(i);
                    bjM();
                    return;
                default:
                    this.mCurrentState = rE(i);
                    return;
            }
        }

        private void bjM() {
            this.mHandler.removeCallbacks(this.fxc);
            this.mHandler.postDelayed(this.fxc, 3000L);
        }

        private int rD(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.ika.setVisibility(8);
                VideoMiddlePageAdView.this.ijZ.setVisibility(8);
                VideoMiddlePageAdView.this.pm(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int rE(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.ika.setVisibility(0);
                VideoMiddlePageAdView.this.ijZ.setVisibility(0);
                if (VideoMiddlePageAdView.this.fee != null) {
                    VideoMiddlePageAdView.this.fee.bSR();
                }
                if (i2 != 3 || VideoMiddlePageAdView.this.ikc.autoPlay) {
                    VideoMiddlePageAdView.this.pm(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int rF(int i) {
            if (i != this.mCurrentState) {
                VideoMiddlePageAdView.this.ika.setVisibility(0);
                VideoMiddlePageAdView.this.ijZ.setVisibility(0);
                VideoMiddlePageAdView.this.pm(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
