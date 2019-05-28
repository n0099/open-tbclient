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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.d.b;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.view.IVrPlayView;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView Yp;
    private View bnR;
    private RelativeLayout fkW;
    private View gZq;
    private VideoInfo hWs;
    private TbImageView iCA;
    private ImageView iCB;
    private VideoListMediaControllerView iCC;
    private View iCD;
    private boolean iCE;
    private a iCx;
    DistributeVrVideoCard iCy;
    private CardGLTextureView iCz;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fkW = null;
        this.iCz = null;
        this.isBackground = false;
        this.iCE = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iCz == null || DistributeVrVideoCardView.this.iCz.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iCx != null) {
                                    DistributeVrVideoCardView.this.iCx.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iCy.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gYE != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gYE.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iCx != null) {
                                            DistributeVrVideoCardView.this.iCx.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iCx != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iCx.continuePlay();
                                    }
                                }
                            } else if (b.gYD == DistributeVrVideoCardView.this.iCy.getPage()) {
                                if (DistributeVrVideoCardView.this.iCx != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iCx.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iCx != null) {
                                DistributeVrVideoCardView.this.iCx.pausePlay();
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
    protected View bHN() {
        this.fkW = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iCz = new CardGLTextureView(this.mContext.getPageActivity());
        this.fkW.addView((View) this.iCz, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iCA = (TbImageView) this.fkW.findViewById(R.id.ad_thumbnail);
        this.iCB = (ImageView) this.fkW.findViewById(R.id.ad_play_button);
        this.bnR = this.fkW.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fkW.findViewById(R.id.ad_error_tips);
        this.iCB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Yp = (ImageView) this.fkW.findViewById(R.id.play_icon);
        this.iCD = this.fkW.findViewById(R.id.replay);
        this.gZq = this.fkW.findViewById(R.id.card_layout_media_controller);
        this.iCC = this.fkW.findViewById(R.id.card_media_controller);
        return this.fkW;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Yp.setOnClickListener(onClickListener);
        this.iCD.setOnClickListener(onClickListener);
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
        if (this.iCz != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iCy == null || this.iCy.getVideoInfo() == null || !TextUtils.equals(this.iCy.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iCz.isDestroyed()) {
                if (this.iCz.isDestroyed()) {
                    this.fkW.removeView(this.iCz);
                    this.iCz = new CardGLTextureView(this.mContext.getPageActivity());
                    this.fkW.addView((View) this.iCz, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iCy = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gYn;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eDL);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gYo);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gYp);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cLq);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hWs = builder.build(false);
                if (this.hWs != null && !ap.isEmpty(this.hWs.video_url)) {
                    long cfh = (this.iCx == null || !this.hWs.video_url.equalsIgnoreCase(this.iCx.getVideoPath())) ? 0L : this.iCx.cfh();
                    this.iCx = new a(this);
                    if (cfh > 0) {
                        this.iCx.wd((int) cfh);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fkW.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.fkW.setLayoutParams(layoutParams);
                    }
                    this.iCA.startLoad(this.hWs.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gYr) {
                        if (com.baidu.tieba.recapp.lego.a.a.ao(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gZq.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.gZq.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gZq.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.gZq.setLayoutParams(layoutParams3);
                        }
                        this.gZq.setVisibility(0);
                    } else {
                        this.gZq.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iCz;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(0);
        this.iCB.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iCB.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iCA.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iCB.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCA.setVisibility(8);
        this.iCC.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cV(true);
        this.iCD.setVisibility(8);
    }

    public void cV(boolean z) {
        if (z) {
            this.bnR.setVisibility(0);
        } else {
            this.bnR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iCC.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iCC.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iCC.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iCC.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iCC.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cV(false);
        pZ(false);
    }

    public void pZ(boolean z) {
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
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCA.setVisibility(0);
        this.iCB.setVisibility(0);
        this.iCC.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(8);
        this.iCB.setVisibility(0);
        this.iCA.setVisibility(0);
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
        if (this.iCx == null) {
            return false;
        }
        int playStatus = this.iCx.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iCx == null) {
            return false;
        }
        return this.iCx.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iCE) {
            this.iCE = false;
            if (!q.clK()) {
                return;
            }
        }
        if (this.iCy != null && this.hWs != null && this.iCx != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iCx.startPlay(DistributeVrVideoCardView.this.hWs.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iCx != null) {
            this.iCx.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iCy == null || this.hWs == null) ? "" : this.hWs.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iCx == null) {
            return 0L;
        }
        return this.iCx.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iCx != null) {
                this.iCx.wd(0);
                this.iCx.destroy();
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
    public void bHT() {
        this.isBackground = false;
        super.bHT();
        if (this.iCz == null || this.iCz.isDestroyed()) {
            e(this.iCy);
        } else if (this.iCx != null) {
            this.iCx.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void PV() {
        this.isBackground = true;
        super.PV();
        if (this.iCx != null) {
            this.iCx.pausePlay();
            this.iCx.cfi();
        }
    }
}
