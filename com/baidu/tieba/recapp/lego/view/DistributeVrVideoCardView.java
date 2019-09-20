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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.d.b;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.view.IVrPlayView;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView YJ;
    private View bpc;
    private RelativeLayout fsh;
    private View hiq;
    private a iMq;
    DistributeVrVideoCard iMr;
    private CardGLTextureView iMs;
    private TbImageView iMt;
    private ImageView iMu;
    private VideoListMediaControllerView iMv;
    private View iMw;
    private boolean iMx;
    private VideoInfo ifF;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fsh = null;
        this.iMs = null;
        this.isBackground = false;
        this.iMx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iMs == null || DistributeVrVideoCardView.this.iMs.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iMq != null) {
                                    DistributeVrVideoCardView.this.iMq.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iMr.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hhD != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hhD.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.u(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iMq != null) {
                                            DistributeVrVideoCardView.this.iMq.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iMq != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iMq.continuePlay();
                                    }
                                }
                            } else if (b.hhC == DistributeVrVideoCardView.this.iMr.getPage()) {
                                if (DistributeVrVideoCardView.this.iMq != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iMq.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iMq != null) {
                                DistributeVrVideoCardView.this.iMq.pausePlay();
                            }
                            DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                            DistributeVrVideoCardView.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        DistributeVrVideoCardView.this.release();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bLw() {
        this.fsh = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iMs = new CardGLTextureView(this.mContext.getPageActivity());
        this.fsh.addView((View) this.iMs, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iMt = (TbImageView) this.fsh.findViewById(R.id.ad_thumbnail);
        this.iMu = (ImageView) this.fsh.findViewById(R.id.ad_play_button);
        this.bpc = this.fsh.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fsh.findViewById(R.id.ad_error_tips);
        this.iMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.YJ = (ImageView) this.fsh.findViewById(R.id.play_icon);
        this.iMw = this.fsh.findViewById(R.id.replay);
        this.hiq = this.fsh.findViewById(R.id.card_layout_media_controller);
        this.iMv = this.fsh.findViewById(R.id.card_media_controller);
        return this.fsh;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.YJ.setOnClickListener(onClickListener);
        this.iMw.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(DistributeVrVideoCard distributeVrVideoCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(DistributeVrVideoCard distributeVrVideoCard) {
        if (this.iMs != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iMr == null || this.iMr.getVideoInfo() == null || !TextUtils.equals(this.iMr.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iMs.isDestroyed()) {
                if (this.iMs.isDestroyed()) {
                    this.fsh.removeView(this.iMs);
                    this.iMs = new CardGLTextureView(this.mContext.getPageActivity());
                    this.fsh.addView((View) this.iMs, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iMr = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hhl;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eKx);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().hhm);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().hhn);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cNI);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.ifF = builder.build(false);
                if (this.ifF != null && !aq.isEmpty(this.ifF.video_url)) {
                    long cjf = (this.iMq == null || !this.ifF.video_url.equalsIgnoreCase(this.iMq.getVideoPath())) ? 0L : this.iMq.cjf();
                    this.iMq = new a(this);
                    if (cjf > 0) {
                        this.iMq.wL((int) cjf);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fsh.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.fsh.setLayoutParams(layoutParams);
                    }
                    this.iMt.startLoad(this.ifF.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hhp) {
                        if (com.baidu.tieba.recapp.lego.a.a.ar(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hiq.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hiq.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hiq.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hiq.setLayoutParams(layoutParams3);
                        }
                        this.hiq.setVisibility(0);
                    } else {
                        this.hiq.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iMs;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bpc.setVisibility(0);
        this.iMu.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iMu.setVisibility(8);
        this.bpc.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iMt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iMu.setVisibility(8);
        this.bpc.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iMt.setVisibility(8);
        this.iMv.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cY(true);
        this.iMw.setVisibility(8);
    }

    public void cY(boolean z) {
        if (z) {
            this.bpc.setVisibility(0);
        } else {
            this.bpc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iMv.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iMv.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iMv.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iMv.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iMv.aC(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cY(false);
        qt(false);
    }

    public void qt(boolean z) {
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
        this.bpc.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iMt.setVisibility(0);
        this.iMu.setVisibility(0);
        this.iMv.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bpc.setVisibility(8);
        this.iMu.setVisibility(0);
        this.iMt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.mContext;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.iMq == null) {
            return false;
        }
        int playStatus = this.iMq.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iMq == null) {
            return false;
        }
        return this.iMq.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iMx) {
            this.iMx = false;
            if (!s.cpN()) {
                return;
            }
        }
        if (this.iMr != null && this.ifF != null && this.iMq != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iMq.startPlay(DistributeVrVideoCardView.this.ifF.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iMq != null) {
            this.iMq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iMr == null || this.ifF == null) ? "" : this.ifF.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iMq == null) {
            return 0L;
        }
        return this.iMq.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iMq != null) {
                this.iMq.wL(0);
                this.iMq.destroy();
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

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bLC() {
        this.isBackground = false;
        super.bLC();
        if (this.iMs == null || this.iMs.isDestroyed()) {
            e(this.iMr);
        } else if (this.iMq != null) {
            this.iMq.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void QR() {
        this.isBackground = true;
        super.QR();
        if (this.iMq != null) {
            this.iMq.pausePlay();
            this.iMq.cjg();
        }
    }
}
