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
/* loaded from: classes11.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView NW;
    private View csy;
    private View hXl;
    private VideoInfo iWd;
    private boolean isBackground;
    private a jIq;
    DistributeVrVideoCard jIr;
    private CardGLTextureView jIs;
    private TbImageView jIt;
    private ImageView jIu;
    private VideoListMediaControllerView jIv;
    private View jIw;
    private boolean jIx;
    private TextView mErrorTip;
    private Handler mHandler;
    private RelativeLayout mRoot;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRoot = null;
        this.jIs = null;
        this.isBackground = false;
        this.jIx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cRe != null && DistributeVrVideoCardView.this.cRe.getPageActivity() != null && !DistributeVrVideoCardView.this.cRe.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.jIs == null || DistributeVrVideoCardView.this.jIs.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.jIq != null) {
                                    DistributeVrVideoCardView.this.jIq.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.jIr.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hWz != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hWz.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cRe.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.jIq != null) {
                                            DistributeVrVideoCardView.this.jIq.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.jIq != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.jIq.continuePlay();
                                    }
                                }
                            } else if (b.hWy == DistributeVrVideoCardView.this.jIr.getPage()) {
                                if (DistributeVrVideoCardView.this.jIq != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.jIq.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.jIq != null) {
                                DistributeVrVideoCardView.this.jIq.pausePlay();
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
    protected View caC() {
        this.mRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.jIs = new CardGLTextureView(this.cRe.getPageActivity());
        this.mRoot.addView((View) this.jIs, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jIt = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jIu = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.csy = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.NW = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.jIw = this.mRoot.findViewById(R.id.replay);
        this.hXl = this.mRoot.findViewById(R.id.card_layout_media_controller);
        this.jIv = this.mRoot.findViewById(R.id.card_media_controller);
        return this.mRoot;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.NW.setOnClickListener(onClickListener);
        this.jIw.setOnClickListener(onClickListener);
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
        if (this.jIs != null && this.cRe != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.jIr == null || this.jIr.getVideoInfo() == null || !TextUtils.equals(this.jIr.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.jIs.isDestroyed()) {
                if (this.jIs.isDestroyed()) {
                    this.mRoot.removeView(this.jIs);
                    this.jIs = new CardGLTextureView(this.cRe.getPageActivity());
                    this.mRoot.addView((View) this.jIs, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.jIr = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hWj;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoLength);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbWidth);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbHeight);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().aXT);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iWd = builder.build(false);
                if (this.iWd != null && !aq.isEmpty(this.iWd.video_url)) {
                    long cBu = (this.jIq == null || !this.iWd.video_url.equalsIgnoreCase(this.jIq.getVideoPath())) ? 0L : this.jIq.cBu();
                    this.jIq = new a(this);
                    if (cBu > 0) {
                        this.jIq.xx((int) cBu);
                    }
                    ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.mRoot.setLayoutParams(layoutParams);
                    }
                    this.jIt.startLoad(this.iWd.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hWl) {
                        if (com.baidu.tieba.recapp.lego.a.a.ap(this.cRe.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hXl.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cRe.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hXl.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hXl.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cRe.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hXl.setLayoutParams(layoutParams3);
                        }
                        this.hXl.setVisibility(0);
                    } else {
                        this.hXl.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jIs;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.csy.setVisibility(0);
        this.jIu.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.NW.setImageDrawable(this.cRe.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.jIu.setVisibility(8);
        this.csy.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jIt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.NW.setImageDrawable(this.cRe.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.jIu.setVisibility(8);
        this.csy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jIt.setVisibility(8);
        this.jIv.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.NW.setImageDrawable(this.cRe.getResources().getDrawable(R.drawable.icon_video_midpause));
        eF(true);
        this.jIw.setVisibility(8);
    }

    public void eF(boolean z) {
        if (z) {
            this.csy.setVisibility(0);
        } else {
            this.csy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.jIv.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.jIv.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.jIv.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.jIv.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.jIv.aZ(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.NW.setImageDrawable(this.cRe.getResources().getDrawable(R.drawable.icon_video_midpause));
        eF(false);
        rW(false);
    }

    public void rW(boolean z) {
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
        this.csy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jIt.setVisibility(0);
        this.jIu.setVisibility(0);
        this.jIv.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.NW.setImageDrawable(this.cRe.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.csy.setVisibility(8);
        this.jIu.setVisibility(0);
        this.jIt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cRe;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.jIq == null) {
            return false;
        }
        int playStatus = this.jIq.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jIq == null) {
            return false;
        }
        return this.jIq.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.jIx) {
            this.jIx = false;
            if (!s.cIN()) {
                return;
            }
        }
        if (this.jIr != null && this.iWd != null && this.jIq != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.jIq.startPlay(DistributeVrVideoCardView.this.iWd.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jIq != null) {
            this.jIq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.jIr == null || this.iWd == null) ? "" : this.iWd.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jIq == null) {
            return 0L;
        }
        return this.jIq.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.jIq != null) {
                this.jIq.xx(0);
                this.jIq.destroy();
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
    public void bOe() {
        this.isBackground = false;
        super.bOe();
        if (this.jIs == null || this.jIs.isDestroyed()) {
            d(this.jIr);
        } else if (this.jIq != null) {
            this.jIq.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aiz() {
        this.isBackground = true;
        super.aiz();
        if (this.jIq != null) {
            this.jIq.pausePlay();
            this.jIq.cBv();
        }
    }
}
