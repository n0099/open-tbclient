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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes13.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView Oy;
    private View cwN;
    private VideoInfo iZh;
    private View iaX;
    private boolean isBackground;
    private a jLc;
    DistributeVrVideoCard jLd;
    private CardGLTextureView jLe;
    private TbImageView jLf;
    private ImageView jLg;
    private VideoListMediaControllerView jLh;
    private View jLi;
    private boolean jLj;
    private TextView mErrorTip;
    private Handler mHandler;
    private RelativeLayout mRoot;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRoot = null;
        this.jLe = null;
        this.isBackground = false;
        this.jLj = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cVv != null && DistributeVrVideoCardView.this.cVv.getPageActivity() != null && !DistributeVrVideoCardView.this.cVv.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.jLe == null || DistributeVrVideoCardView.this.jLe.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.jLc != null) {
                                    DistributeVrVideoCardView.this.jLc.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.jLd.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.ial != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.ial.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cVv.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.jLc != null) {
                                            DistributeVrVideoCardView.this.jLc.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.jLc != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.jLc.continuePlay();
                                    }
                                }
                            } else if (b.iak == DistributeVrVideoCardView.this.jLd.getPage()) {
                                if (DistributeVrVideoCardView.this.jLc != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.jLc.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.jLc != null) {
                                DistributeVrVideoCardView.this.jLc.pausePlay();
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
    protected View ccz() {
        this.mRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.jLe = new CardGLTextureView(this.cVv.getPageActivity());
        this.mRoot.addView((View) this.jLe, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jLf = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jLg = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.cwN = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Oy = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.jLi = this.mRoot.findViewById(R.id.replay);
        this.iaX = this.mRoot.findViewById(R.id.card_layout_media_controller);
        this.jLh = this.mRoot.findViewById(R.id.card_media_controller);
        return this.mRoot;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Oy.setOnClickListener(onClickListener);
        this.jLi.setOnClickListener(onClickListener);
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
        if (this.jLe != null && this.cVv != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.jLd == null || this.jLd.getVideoInfo() == null || !TextUtils.equals(this.jLd.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.jLe.isDestroyed()) {
                if (this.jLe.isDestroyed()) {
                    this.mRoot.removeView(this.jLe);
                    this.jLe = new CardGLTextureView(this.cVv.getPageActivity());
                    this.mRoot.addView((View) this.jLe, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.jLd = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hZV;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoLength);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbWidth);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbHeight);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().playCount);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iZh = builder.build(false);
                if (this.iZh != null && !aq.isEmpty(this.iZh.video_url)) {
                    long cDn = (this.jLc == null || !this.iZh.video_url.equalsIgnoreCase(this.jLc.getVideoPath())) ? 0L : this.jLc.cDn();
                    this.jLc = new a(this);
                    if (cDn > 0) {
                        this.jLc.xL((int) cDn);
                    }
                    ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.mRoot.setLayoutParams(layoutParams);
                    }
                    this.jLf.startLoad(this.iZh.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hZX) {
                        if (com.baidu.tieba.recapp.lego.a.a.as(this.cVv.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iaX.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cVv.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.iaX.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iaX.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cVv.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.iaX.setLayoutParams(layoutParams3);
                        }
                        this.iaX.setVisibility(0);
                    } else {
                        this.iaX.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jLe;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cwN.setVisibility(0);
        this.jLg.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Oy.setImageDrawable(this.cVv.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.jLg.setVisibility(8);
        this.cwN.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jLf.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Oy.setImageDrawable(this.cVv.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.jLg.setVisibility(8);
        this.cwN.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jLf.setVisibility(8);
        this.jLh.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Oy.setImageDrawable(this.cVv.getResources().getDrawable(R.drawable.icon_video_midpause));
        eN(true);
        this.jLi.setVisibility(8);
    }

    public void eN(boolean z) {
        if (z) {
            this.cwN.setVisibility(0);
        } else {
            this.cwN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.jLh.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.jLh.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.jLh.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.jLh.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.jLh.ba(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Oy.setImageDrawable(this.cVv.getResources().getDrawable(R.drawable.icon_video_midpause));
        eN(false);
        sf(false);
    }

    public void sf(boolean z) {
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
        this.cwN.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jLf.setVisibility(0);
        this.jLg.setVisibility(0);
        this.jLh.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Oy.setImageDrawable(this.cVv.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.cwN.setVisibility(8);
        this.jLg.setVisibility(0);
        this.jLf.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cVv;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.jLc == null) {
            return false;
        }
        int playStatus = this.jLc.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jLc == null) {
            return false;
        }
        return this.jLc.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.jLj) {
            this.jLj = false;
            if (!t.cKO()) {
                return;
            }
        }
        if (this.jLd != null && this.iZh != null && this.jLc != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.jLc.startPlay(DistributeVrVideoCardView.this.iZh.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jLc != null) {
            this.jLc.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.jLd == null || this.iZh == null) ? "" : this.iZh.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jLc == null) {
            return 0L;
        }
        return this.jLc.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.jLc != null) {
                this.jLc.xL(0);
                this.jLc.destroy();
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
    public void bQb() {
        this.isBackground = false;
        super.bQb();
        if (this.jLe == null || this.jLe.isDestroyed()) {
            d(this.jLd);
        } else if (this.jLc != null) {
            this.jLc.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void akS() {
        this.isBackground = true;
        super.akS();
        if (this.jLc != null) {
            this.jLc.pausePlay();
            this.jLc.cDo();
        }
    }
}
