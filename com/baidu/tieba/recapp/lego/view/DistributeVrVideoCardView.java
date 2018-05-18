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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
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
    private RelativeLayout cUK;
    private View exY;
    private VideoInfo fxp;
    private a gaX;
    DistributeVrVideoCard gaY;
    private CardGLTextureView gaZ;
    private TbImageView gba;
    private ImageView gbb;
    private VideoListMediaControllerView gbc;
    private ImageView gbd;
    private View gbe;
    private boolean gbf;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cUK = null;
        this.gaZ = null;
        this.isBackground = false;
        this.gbf = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gaZ == null || DistributeVrVideoCardView.this.gaZ.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.gaX != null) {
                                    DistributeVrVideoCardView.this.gaX.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gaY.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.exm != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.exm.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.p(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gaX != null) {
                                            DistributeVrVideoCardView.this.gaX.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gaX != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gaX.continuePlay();
                                    }
                                }
                            } else if (b.exl == DistributeVrVideoCardView.this.gaY.getPage()) {
                                if (DistributeVrVideoCardView.this.gaX != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gaX.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gaX != null) {
                                DistributeVrVideoCardView.this.gaX.pausePlay();
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
    protected View aKT() {
        this.cUK = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.card_distribute_vr_video_view, (ViewGroup) null);
        this.gaZ = new CardGLTextureView(this.mContext.getPageActivity());
        this.cUK.addView((View) this.gaZ, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gba = (TbImageView) this.cUK.findViewById(d.g.ad_thumbnail);
        this.gbb = (ImageView) this.cUK.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.cUK.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.cUK.findViewById(d.g.ad_error_tips);
        this.gbb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gbd = (ImageView) this.cUK.findViewById(d.g.play_icon);
        this.gbe = this.cUK.findViewById(d.g.replay);
        this.exY = this.cUK.findViewById(d.g.card_layout_media_controller);
        this.gbc = this.cUK.findViewById(d.g.card_media_controller);
        return this.cUK;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gbd.setOnClickListener(onClickListener);
        this.gbe.setOnClickListener(onClickListener);
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
        if (this.gaZ != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gaY == null || this.gaY.getVideoInfo() == null || !TextUtils.equals(this.gaY.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gaZ.isDestroyed()) {
                if (this.gaZ.isDestroyed()) {
                    this.cUK.removeView(this.gaZ);
                    this.gaZ = new CardGLTextureView(this.mContext.getPageActivity());
                    this.cUK.addView((View) this.gaZ, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gaY = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().ewU;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cvQ);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().ewV);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().ewW);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().aWi;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().aWl);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fxp = builder.build(false);
                if (this.fxp != null && !an.isEmpty(this.fxp.video_url)) {
                    long bjF = (this.gaX == null || !this.fxp.video_url.equalsIgnoreCase(this.gaX.getVideoPath())) ? 0L : this.gaX.bjF();
                    this.gaX = new a(this);
                    if (bjF > 0) {
                        this.gaX.oF((int) bjF);
                    }
                    ViewGroup.LayoutParams layoutParams = this.cUK.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.cUK.setLayoutParams(layoutParams);
                    }
                    this.gba.startLoad(this.fxp.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().ewY) {
                        if (com.baidu.tieba.recapp.lego.a.a.D(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.exY.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.exY.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.exY.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.exY.setLayoutParams(layoutParams3);
                        }
                        this.exY.setVisibility(0);
                    } else {
                        this.exY.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gaZ;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gbb.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gbd.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.gbb.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gba.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gbd.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.gbb.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gba.setVisibility(8);
        this.gbc.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gbd.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gB(true);
        this.gbe.setVisibility(8);
    }

    public void gB(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
        } else {
            this.mLoadingView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gbc.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gbc.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gbc.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gbc.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gbc.Q(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gbd.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gB(false);
        lD(false);
    }

    public void lD(boolean z) {
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
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gba.setVisibility(0);
        this.gbb.setVisibility(0);
        this.gbc.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gbd.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gbb.setVisibility(0);
        this.gba.setVisibility(0);
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
        if (this.gaX == null) {
            return false;
        }
        int playStatus = this.gaX.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gaX == null) {
            return false;
        }
        return this.gaX.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gbf) {
            this.gbf = false;
            if (!q.brm()) {
                return;
            }
        }
        if (this.gaY != null && this.fxp != null && this.gaX != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gaX.startPlay(DistributeVrVideoCardView.this.fxp.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gaX != null) {
            this.gaX.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gaY == null || this.fxp == null) ? "" : this.fxp.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gaX == null) {
            return 0L;
        }
        return this.gaX.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.gaX != null) {
                this.gaX.oF(0);
                this.gaX.destroy();
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
    public void aLb() {
        this.isBackground = false;
        super.aLb();
        if (this.gaZ == null || this.gaZ.isDestroyed()) {
            e(this.gaY);
        } else if (this.gaX != null) {
            this.gaX.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLa() {
        this.isBackground = true;
        super.aLa();
        if (this.gaX != null) {
            this.gaX.pausePlay();
            this.gaX.bjG();
        }
    }
}
