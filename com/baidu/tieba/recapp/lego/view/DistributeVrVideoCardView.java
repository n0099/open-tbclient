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
    private View cwB;
    private View hZl;
    private VideoInfo iXu;
    private boolean isBackground;
    private a jJo;
    DistributeVrVideoCard jJp;
    private CardGLTextureView jJq;
    private TbImageView jJr;
    private ImageView jJs;
    private VideoListMediaControllerView jJt;
    private View jJu;
    private boolean jJv;
    private TextView mErrorTip;
    private Handler mHandler;
    private RelativeLayout mRoot;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRoot = null;
        this.jJq = null;
        this.isBackground = false;
        this.jJv = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cVh != null && DistributeVrVideoCardView.this.cVh.getPageActivity() != null && !DistributeVrVideoCardView.this.cVh.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.jJq == null || DistributeVrVideoCardView.this.jJq.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.jJo != null) {
                                    DistributeVrVideoCardView.this.jJo.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.jJp.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hYz != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hYz.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cVh.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.jJo != null) {
                                            DistributeVrVideoCardView.this.jJo.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.jJo != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.jJo.continuePlay();
                                    }
                                }
                            } else if (b.hYy == DistributeVrVideoCardView.this.jJp.getPage()) {
                                if (DistributeVrVideoCardView.this.jJo != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.jJo.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.jJo != null) {
                                DistributeVrVideoCardView.this.jJo.pausePlay();
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
    protected View ccf() {
        this.mRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.jJq = new CardGLTextureView(this.cVh.getPageActivity());
        this.mRoot.addView((View) this.jJq, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jJr = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jJs = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.cwB = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jJs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Ox = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.jJu = this.mRoot.findViewById(R.id.replay);
        this.hZl = this.mRoot.findViewById(R.id.card_layout_media_controller);
        this.jJt = this.mRoot.findViewById(R.id.card_media_controller);
        return this.mRoot;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Ox.setOnClickListener(onClickListener);
        this.jJu.setOnClickListener(onClickListener);
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
        if (this.jJq != null && this.cVh != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.jJp == null || this.jJp.getVideoInfo() == null || !TextUtils.equals(this.jJp.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.jJq.isDestroyed()) {
                if (this.jJq.isDestroyed()) {
                    this.mRoot.removeView(this.jJq);
                    this.jJq = new CardGLTextureView(this.cVh.getPageActivity());
                    this.mRoot.addView((View) this.jJq, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.jJp = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hYj;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoLength);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbWidth);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbHeight);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().playCount);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iXu = builder.build(false);
                if (this.iXu != null && !aq.isEmpty(this.iXu.video_url)) {
                    long cCS = (this.jJo == null || !this.iXu.video_url.equalsIgnoreCase(this.jJo.getVideoPath())) ? 0L : this.jJo.cCS();
                    this.jJo = new a(this);
                    if (cCS > 0) {
                        this.jJo.xD((int) cCS);
                    }
                    ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.mRoot.setLayoutParams(layoutParams);
                    }
                    this.jJr.startLoad(this.iXu.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hYl) {
                        if (com.baidu.tieba.recapp.lego.a.a.aq(this.cVh.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZl.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cVh.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hZl.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hZl.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cVh.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hZl.setLayoutParams(layoutParams3);
                        }
                        this.hZl.setVisibility(0);
                    } else {
                        this.hZl.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jJq;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cwB.setVisibility(0);
        this.jJs.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Ox.setImageDrawable(this.cVh.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.jJs.setVisibility(8);
        this.cwB.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jJr.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Ox.setImageDrawable(this.cVh.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.jJs.setVisibility(8);
        this.cwB.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJr.setVisibility(8);
        this.jJt.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Ox.setImageDrawable(this.cVh.getResources().getDrawable(R.drawable.icon_video_midpause));
        eM(true);
        this.jJu.setVisibility(8);
    }

    public void eM(boolean z) {
        if (z) {
            this.cwB.setVisibility(0);
        } else {
            this.cwB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.jJt.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.jJt.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.jJt.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.jJt.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.jJt.aZ(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Ox.setImageDrawable(this.cVh.getResources().getDrawable(R.drawable.icon_video_midpause));
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
        this.cwB.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJr.setVisibility(0);
        this.jJs.setVisibility(0);
        this.jJt.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Ox.setImageDrawable(this.cVh.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.cwB.setVisibility(8);
        this.jJs.setVisibility(0);
        this.jJr.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cVh;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.jJo == null) {
            return false;
        }
        int playStatus = this.jJo.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jJo == null) {
            return false;
        }
        return this.jJo.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.jJv) {
            this.jJv = false;
            if (!s.cKt()) {
                return;
            }
        }
        if (this.jJp != null && this.iXu != null && this.jJo != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.jJo.startPlay(DistributeVrVideoCardView.this.iXu.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jJo != null) {
            this.jJo.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.jJp == null || this.iXu == null) ? "" : this.iXu.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jJo == null) {
            return 0L;
        }
        return this.jJo.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.jJo != null) {
                this.jJo.xD(0);
                this.jJo.destroy();
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
    public void bPI() {
        this.isBackground = false;
        super.bPI();
        if (this.jJq == null || this.jJq.isDestroyed()) {
            d(this.jJp);
        } else if (this.jJo != null) {
            this.jJo.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void akP() {
        this.isBackground = true;
        super.akP();
        if (this.jJo != null) {
            this.jJo.pausePlay();
            this.jJo.cCT();
        }
    }
}
