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
    private View cwA;
    private View hZj;
    private VideoInfo iXs;
    private boolean isBackground;
    private a jJm;
    DistributeVrVideoCard jJn;
    private CardGLTextureView jJo;
    private TbImageView jJp;
    private ImageView jJq;
    private VideoListMediaControllerView jJr;
    private View jJs;
    private boolean jJt;
    private TextView mErrorTip;
    private Handler mHandler;
    private RelativeLayout mRoot;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRoot = null;
        this.jJo = null;
        this.isBackground = false;
        this.jJt = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cVg != null && DistributeVrVideoCardView.this.cVg.getPageActivity() != null && !DistributeVrVideoCardView.this.cVg.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.jJo == null || DistributeVrVideoCardView.this.jJo.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.jJm != null) {
                                    DistributeVrVideoCardView.this.jJm.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.jJn.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hYx != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hYx.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cVg.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.jJm != null) {
                                            DistributeVrVideoCardView.this.jJm.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.jJm != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.jJm.continuePlay();
                                    }
                                }
                            } else if (b.hYw == DistributeVrVideoCardView.this.jJn.getPage()) {
                                if (DistributeVrVideoCardView.this.jJm != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.jJm.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.jJm != null) {
                                DistributeVrVideoCardView.this.jJm.pausePlay();
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
    protected View ccd() {
        this.mRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.jJo = new CardGLTextureView(this.cVg.getPageActivity());
        this.mRoot.addView((View) this.jJo, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jJp = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jJq = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.cwA = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Ox = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.jJs = this.mRoot.findViewById(R.id.replay);
        this.hZj = this.mRoot.findViewById(R.id.card_layout_media_controller);
        this.jJr = this.mRoot.findViewById(R.id.card_media_controller);
        return this.mRoot;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Ox.setOnClickListener(onClickListener);
        this.jJs.setOnClickListener(onClickListener);
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
        if (this.jJo != null && this.cVg != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.jJn == null || this.jJn.getVideoInfo() == null || !TextUtils.equals(this.jJn.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.jJo.isDestroyed()) {
                if (this.jJo.isDestroyed()) {
                    this.mRoot.removeView(this.jJo);
                    this.jJo = new CardGLTextureView(this.cVg.getPageActivity());
                    this.mRoot.addView((View) this.jJo, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.jJn = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hYh;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoLength);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbWidth);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbHeight);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().playCount);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iXs = builder.build(false);
                if (this.iXs != null && !aq.isEmpty(this.iXs.video_url)) {
                    long cCQ = (this.jJm == null || !this.iXs.video_url.equalsIgnoreCase(this.jJm.getVideoPath())) ? 0L : this.jJm.cCQ();
                    this.jJm = new a(this);
                    if (cCQ > 0) {
                        this.jJm.xD((int) cCQ);
                    }
                    ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.mRoot.setLayoutParams(layoutParams);
                    }
                    this.jJp.startLoad(this.iXs.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hYj) {
                        if (com.baidu.tieba.recapp.lego.a.a.aq(this.cVg.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZj.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cVg.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hZj.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hZj.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cVg.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hZj.setLayoutParams(layoutParams3);
                        }
                        this.hZj.setVisibility(0);
                    } else {
                        this.hZj.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jJo;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cwA.setVisibility(0);
        this.jJq.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Ox.setImageDrawable(this.cVg.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.jJq.setVisibility(8);
        this.cwA.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jJp.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Ox.setImageDrawable(this.cVg.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.jJq.setVisibility(8);
        this.cwA.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJp.setVisibility(8);
        this.jJr.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Ox.setImageDrawable(this.cVg.getResources().getDrawable(R.drawable.icon_video_midpause));
        eM(true);
        this.jJs.setVisibility(8);
    }

    public void eM(boolean z) {
        if (z) {
            this.cwA.setVisibility(0);
        } else {
            this.cwA.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.jJr.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.jJr.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.jJr.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.jJr.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.jJr.aZ(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Ox.setImageDrawable(this.cVg.getResources().getDrawable(R.drawable.icon_video_midpause));
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
        this.cwA.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJp.setVisibility(0);
        this.jJq.setVisibility(0);
        this.jJr.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Ox.setImageDrawable(this.cVg.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.cwA.setVisibility(8);
        this.jJq.setVisibility(0);
        this.jJp.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cVg;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.jJm == null) {
            return false;
        }
        int playStatus = this.jJm.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jJm == null) {
            return false;
        }
        return this.jJm.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.jJt) {
            this.jJt = false;
            if (!s.cKr()) {
                return;
            }
        }
        if (this.jJn != null && this.iXs != null && this.jJm != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.jJm.startPlay(DistributeVrVideoCardView.this.iXs.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jJm != null) {
            this.jJm.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.jJn == null || this.iXs == null) ? "" : this.iXs.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jJm == null) {
            return 0L;
        }
        return this.jJm.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.jJm != null) {
                this.jJm.xD(0);
                this.jJm.destroy();
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
    public void bPG() {
        this.isBackground = false;
        super.bPG();
        if (this.jJo == null || this.jJo.isDestroyed()) {
            d(this.jJn);
        } else if (this.jJm != null) {
            this.jJm.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void akN() {
        this.isBackground = true;
        super.akN();
        if (this.jJm != null) {
            this.jJm.pausePlay();
            this.jJm.cCR();
        }
    }
}
