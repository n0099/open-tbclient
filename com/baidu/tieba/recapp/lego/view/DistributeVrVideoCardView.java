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
import com.baidu.adp.lib.f.e;
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
/* loaded from: classes13.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView Ox;
    private View cwC;
    private View hZx;
    private VideoInfo iXG;
    private boolean isBackground;
    private a jJA;
    DistributeVrVideoCard jJB;
    private CardGLTextureView jJC;
    private TbImageView jJD;
    private ImageView jJE;
    private VideoListMediaControllerView jJF;
    private View jJG;
    private boolean jJH;
    private TextView mErrorTip;
    private Handler mHandler;
    private RelativeLayout mRoot;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRoot = null;
        this.jJC = null;
        this.isBackground = false;
        this.jJH = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cVi != null && DistributeVrVideoCardView.this.cVi.getPageActivity() != null && !DistributeVrVideoCardView.this.cVi.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.jJC == null || DistributeVrVideoCardView.this.jJC.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.jJA != null) {
                                    DistributeVrVideoCardView.this.jJA.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.jJB.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hYL != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hYL.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cVi.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.jJA != null) {
                                            DistributeVrVideoCardView.this.jJA.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.jJA != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.jJA.continuePlay();
                                    }
                                }
                            } else if (b.hYK == DistributeVrVideoCardView.this.jJB.getPage()) {
                                if (DistributeVrVideoCardView.this.jJA != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.jJA.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.jJA != null) {
                                DistributeVrVideoCardView.this.jJA.pausePlay();
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
    protected View ccg() {
        this.mRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.jJC = new CardGLTextureView(this.cVi.getPageActivity());
        this.mRoot.addView((View) this.jJC, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jJD = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jJE = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.cwC = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Ox = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.jJG = this.mRoot.findViewById(R.id.replay);
        this.hZx = this.mRoot.findViewById(R.id.card_layout_media_controller);
        this.jJF = this.mRoot.findViewById(R.id.card_media_controller);
        return this.mRoot;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Ox.setOnClickListener(onClickListener);
        this.jJG.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(DistributeVrVideoCard distributeVrVideoCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(DistributeVrVideoCard distributeVrVideoCard) {
        if (this.jJC != null && this.cVi != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.jJB == null || this.jJB.getVideoInfo() == null || !TextUtils.equals(this.jJB.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.jJC.isDestroyed()) {
                if (this.jJC.isDestroyed()) {
                    this.mRoot.removeView(this.jJC);
                    this.jJC = new CardGLTextureView(this.cVi.getPageActivity());
                    this.mRoot.addView((View) this.jJC, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.jJB = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hYv;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoLength);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbWidth);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbHeight);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().playCount);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iXG = builder.build(false);
                if (this.iXG != null && !aq.isEmpty(this.iXG.video_url)) {
                    long cCT = (this.jJA == null || !this.iXG.video_url.equalsIgnoreCase(this.jJA.getVideoPath())) ? 0L : this.jJA.cCT();
                    this.jJA = new a(this);
                    if (cCT > 0) {
                        this.jJA.xD((int) cCT);
                    }
                    ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.mRoot.setLayoutParams(layoutParams);
                    }
                    this.jJD.startLoad(this.iXG.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hYx) {
                        if (com.baidu.tieba.recapp.lego.a.a.as(this.cVi.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZx.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cVi.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hZx.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hZx.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cVi.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hZx.setLayoutParams(layoutParams3);
                        }
                        this.hZx.setVisibility(0);
                    } else {
                        this.hZx.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jJC;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cwC.setVisibility(0);
        this.jJE.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Ox.setImageDrawable(this.cVi.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.jJE.setVisibility(8);
        this.cwC.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jJD.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Ox.setImageDrawable(this.cVi.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.jJE.setVisibility(8);
        this.cwC.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJD.setVisibility(8);
        this.jJF.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Ox.setImageDrawable(this.cVi.getResources().getDrawable(R.drawable.icon_video_midpause));
        eM(true);
        this.jJG.setVisibility(8);
    }

    public void eM(boolean z) {
        if (z) {
            this.cwC.setVisibility(0);
        } else {
            this.cwC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.jJF.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.jJF.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.jJF.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.jJF.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.jJF.aZ(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Ox.setImageDrawable(this.cVi.getResources().getDrawable(R.drawable.icon_video_midpause));
        eM(false);
        rZ(false);
    }

    public void rZ(boolean z) {
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
        this.cwC.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJD.setVisibility(0);
        this.jJE.setVisibility(0);
        this.jJF.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Ox.setImageDrawable(this.cVi.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.cwC.setVisibility(8);
        this.jJE.setVisibility(0);
        this.jJD.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cVi;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.jJA == null) {
            return false;
        }
        int playStatus = this.jJA.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jJA == null) {
            return false;
        }
        return this.jJA.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.jJH) {
            this.jJH = false;
            if (!s.cKu()) {
                return;
            }
        }
        if (this.jJB != null && this.iXG != null && this.jJA != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.jJA.startPlay(DistributeVrVideoCardView.this.iXG.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jJA != null) {
            this.jJA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.jJB == null || this.iXG == null) ? "" : this.iXG.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jJA == null) {
            return 0L;
        }
        return this.jJA.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.jJA != null) {
                this.jJA.xD(0);
                this.jJA.destroy();
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
    public void bPJ() {
        this.isBackground = false;
        super.bPJ();
        if (this.jJC == null || this.jJC.isDestroyed()) {
            d(this.jJB);
        } else if (this.jJA != null) {
            this.jJA.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void akP() {
        this.isBackground = true;
        super.akP();
        if (this.jJA != null) {
            this.jJA.pausePlay();
            this.jJA.cCU();
        }
    }
}
