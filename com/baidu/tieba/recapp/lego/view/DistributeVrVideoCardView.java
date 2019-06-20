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
    private ImageView Yo;
    private View bnR;
    private RelativeLayout fkW;
    private View gZr;
    private VideoInfo hWt;
    private CardGLTextureView iCA;
    private TbImageView iCB;
    private ImageView iCC;
    private VideoListMediaControllerView iCD;
    private View iCE;
    private boolean iCF;
    private a iCy;
    DistributeVrVideoCard iCz;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fkW = null;
        this.iCA = null;
        this.isBackground = false;
        this.iCF = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iCA == null || DistributeVrVideoCardView.this.iCA.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iCy != null) {
                                    DistributeVrVideoCardView.this.iCy.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iCz.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gYF != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gYF.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iCy != null) {
                                            DistributeVrVideoCardView.this.iCy.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iCy != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iCy.continuePlay();
                                    }
                                }
                            } else if (b.gYE == DistributeVrVideoCardView.this.iCz.getPage()) {
                                if (DistributeVrVideoCardView.this.iCy != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iCy.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iCy != null) {
                                DistributeVrVideoCardView.this.iCy.pausePlay();
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
    protected View bHO() {
        this.fkW = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iCA = new CardGLTextureView(this.mContext.getPageActivity());
        this.fkW.addView((View) this.iCA, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iCB = (TbImageView) this.fkW.findViewById(R.id.ad_thumbnail);
        this.iCC = (ImageView) this.fkW.findViewById(R.id.ad_play_button);
        this.bnR = this.fkW.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fkW.findViewById(R.id.ad_error_tips);
        this.iCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Yo = (ImageView) this.fkW.findViewById(R.id.play_icon);
        this.iCE = this.fkW.findViewById(R.id.replay);
        this.gZr = this.fkW.findViewById(R.id.card_layout_media_controller);
        this.iCD = this.fkW.findViewById(R.id.card_media_controller);
        return this.fkW;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Yo.setOnClickListener(onClickListener);
        this.iCE.setOnClickListener(onClickListener);
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
        if (this.iCA != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iCz == null || this.iCz.getVideoInfo() == null || !TextUtils.equals(this.iCz.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iCA.isDestroyed()) {
                if (this.iCA.isDestroyed()) {
                    this.fkW.removeView(this.iCA);
                    this.iCA = new CardGLTextureView(this.mContext.getPageActivity());
                    this.fkW.addView((View) this.iCA, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iCz = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gYo;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eDL);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gYp);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gYq);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cLr);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hWt = builder.build(false);
                if (this.hWt != null && !ap.isEmpty(this.hWt.video_url)) {
                    long cfi = (this.iCy == null || !this.hWt.video_url.equalsIgnoreCase(this.iCy.getVideoPath())) ? 0L : this.iCy.cfi();
                    this.iCy = new a(this);
                    if (cfi > 0) {
                        this.iCy.wd((int) cfi);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fkW.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.fkW.setLayoutParams(layoutParams);
                    }
                    this.iCB.startLoad(this.hWt.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gYs) {
                        if (com.baidu.tieba.recapp.lego.a.a.ao(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gZr.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.gZr.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gZr.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.gZr.setLayoutParams(layoutParams3);
                        }
                        this.gZr.setVisibility(0);
                    } else {
                        this.gZr.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iCA;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(0);
        this.iCC.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Yo.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iCC.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iCB.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Yo.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iCC.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCB.setVisibility(8);
        this.iCD.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Yo.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cV(true);
        this.iCE.setVisibility(8);
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
        this.iCD.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iCD.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iCD.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iCD.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iCD.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Yo.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cV(false);
        qa(false);
    }

    public void qa(boolean z) {
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
        this.iCB.setVisibility(0);
        this.iCC.setVisibility(0);
        this.iCD.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Yo.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(8);
        this.iCC.setVisibility(0);
        this.iCB.setVisibility(0);
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
        if (this.iCy == null) {
            return false;
        }
        int playStatus = this.iCy.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iCy == null) {
            return false;
        }
        return this.iCy.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iCF) {
            this.iCF = false;
            if (!q.clL()) {
                return;
            }
        }
        if (this.iCz != null && this.hWt != null && this.iCy != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iCy.startPlay(DistributeVrVideoCardView.this.hWt.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iCy != null) {
            this.iCy.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iCz == null || this.hWt == null) ? "" : this.hWt.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iCy == null) {
            return 0L;
        }
        return this.iCy.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iCy != null) {
                this.iCy.wd(0);
                this.iCy.destroy();
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
    public void bHU() {
        this.isBackground = false;
        super.bHU();
        if (this.iCA == null || this.iCA.isDestroyed()) {
            e(this.iCz);
        } else if (this.iCy != null) {
            this.iCy.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void PV() {
        this.isBackground = true;
        super.PV();
        if (this.iCy != null) {
            this.iCy.pausePlay();
            this.iCy.cfj();
        }
    }
}
