package com.baidu.tieba.recapp.lego.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.v;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.view.IVrPlayView;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.lego.card.e.b<DistributeVrVideoCard> implements com.baidu.tieba.recapp.i, IVrPlayView {
    private RelativeLayout dAR;
    private View dtF;
    private View fbX;
    private j gER;
    DistributeVrVideoCard gES;
    private h gET;
    private TbImageView gEU;
    private ImageView gEV;
    private VideoListMediaControllerView gEW;
    private ImageView gEX;
    private View gEY;
    private boolean gEZ;
    private VideoInfo gbN;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public k(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dAR = null;
        this.gET = null;
        this.isBackground = false;
        this.gEZ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (k.this.aRG != null && k.this.aRG.getPageActivity() != null && !k.this.aRG.getPageActivity().isFinishing()) {
                            if (k.this.gET == null || k.this.gET.isDestroyed()) {
                                k.this.mHandler.removeMessages(30001);
                                if (k.this.gER != null) {
                                    k.this.gER.destroy();
                                    return;
                                }
                                return;
                            }
                            if (k.this.gES.getPage() <= 0) {
                                if (k.this.fbl != null && (viewGroup = (ViewGroup) k.this.fbl.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.p(k.this.aRG.getPageActivity())) {
                                        if (k.this.gER != null) {
                                            k.this.gER.pausePlay();
                                        }
                                    } else if (k.this.gER != null && !k.this.isBackground) {
                                        k.this.gER.continuePlay();
                                    }
                                }
                            } else if (com.baidu.tieba.lego.card.d.b.fbk == k.this.gES.getPage()) {
                                if (k.this.gER != null && !k.this.isBackground) {
                                    k.this.gER.continuePlay();
                                }
                            } else if (k.this.gER != null) {
                                k.this.gER.pausePlay();
                            }
                            k.this.mHandler.removeMessages(30001);
                            k.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        k.this.release();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPS() {
        this.dAR = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gET = new h(this.aRG.getPageActivity());
        this.dAR.addView((View) this.gET, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gEU = (TbImageView) this.dAR.findViewById(d.g.ad_thumbnail);
        this.gEV = (ImageView) this.dAR.findViewById(d.g.ad_play_button);
        this.dtF = this.dAR.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dAR.findViewById(d.g.ad_error_tips);
        this.gEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.startPlay();
            }
        });
        this.gEX = (ImageView) this.dAR.findViewById(d.g.play_icon);
        this.gEY = this.dAR.findViewById(d.g.replay);
        this.fbX = this.dAR.findViewById(d.g.card_layout_media_controller);
        this.gEW = this.dAR.findViewById(d.g.card_media_controller);
        return this.dAR;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gEX.setOnClickListener(onClickListener);
        this.gEY.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(DistributeVrVideoCard distributeVrVideoCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: a */
    public void e(DistributeVrVideoCard distributeVrVideoCard) {
        if (this.gET != null && this.aRG != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gES == null || this.gES.getVideoInfo() == null || !TextUtils.equals(this.gES.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gET.isDestroyed()) {
                if (this.gET.isDestroyed()) {
                    this.dAR.removeView(this.gET);
                    this.gET = new h(this.aRG.getPageActivity());
                    this.dAR.addView((View) this.gET, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gES = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().faT;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().dcO);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().faU);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().faV);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bLq;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bLt);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gbN = builder.build(false);
                if (this.gbN != null && !am.isEmpty(this.gbN.video_url)) {
                    long boz = (this.gER == null || !this.gbN.video_url.equalsIgnoreCase(this.gER.getVideoPath())) ? 0L : this.gER.boz();
                    this.gER = new j(this);
                    if (boz > 0) {
                        this.gER.rl((int) boz);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dAR.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ao(getContext());
                        layoutParams.height = l.aq(getContext());
                        this.dAR.setLayoutParams(layoutParams);
                    }
                    this.gEU.startLoad(this.gbN.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().faX) {
                        if (com.baidu.tieba.recapp.lego.a.a.B(this.aRG.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fbX.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.aRG.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.fbX.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fbX.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.aRG.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.fbX.setLayoutParams(layoutParams3);
                        }
                        this.fbX.setVisibility(0);
                    } else {
                        this.fbX.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gET;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dtF.setVisibility(0);
        this.gEV.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gEX.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_video_midpause));
        this.gEV.setVisibility(8);
        this.dtF.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gEU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gEX.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_video_midplay));
        this.gEV.setVisibility(8);
        this.dtF.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gEU.setVisibility(8);
        this.gEW.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gEX.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_video_midpause));
        gU(true);
        this.gEY.setVisibility(8);
    }

    public void gU(boolean z) {
        if (z) {
            this.dtF.setVisibility(0);
        } else {
            this.dtF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gEW.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(v.b bVar) {
        this.gEW.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(v.a aVar) {
        this.gEW.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gEW.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gEW.aU(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gEX.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_video_midpause));
        gU(false);
        lX(false);
    }

    public void lX(boolean z) {
        if (z) {
            this.mErrorTip.setVisibility(0);
        } else {
            this.mErrorTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
        }
        this.dtF.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gEU.setVisibility(0);
        this.gEV.setVisibility(0);
        this.gEW.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gEX.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.dtF.setVisibility(8);
        this.gEV.setVisibility(0);
        this.gEU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.aRG;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.gER == null) {
            return false;
        }
        int playStatus = this.gER.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gER == null) {
            return false;
        }
        return this.gER.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gEZ) {
            this.gEZ = false;
            if (!q.bwj()) {
                return;
            }
        }
        if (this.gES != null && this.gbN != null && this.gER != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.k.3
                @Override // java.lang.Runnable
                public void run() {
                    k.this.gER.startPlay(k.this.gbN.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gER != null) {
            this.gER.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gES == null || this.gbN == null) ? "" : this.gbN.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gER == null) {
            return 0L;
        }
        return this.gER.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.gER != null) {
                this.gER.rl(0);
                this.gER.destroy();
            }
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return -1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQb() {
        this.isBackground = false;
        super.aQb();
        if (this.gET == null || this.gET.isDestroyed()) {
            e(this.gES);
        } else if (this.gER != null) {
            this.gER.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQa() {
        this.isBackground = true;
        super.aQa();
        if (this.gER != null) {
            this.gER.pausePlay();
            this.gER.boA();
        }
    }
}
