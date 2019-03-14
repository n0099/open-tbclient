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
    private ImageView aav;
    private View bhI;
    private RelativeLayout eUY;
    private View gIf;
    private VideoInfo hEC;
    private a ijW;
    DistributeVrVideoCard ijX;
    private CardGLTextureView ijY;
    private TbImageView ijZ;
    private ImageView ika;
    private VideoListMediaControllerView ikb;
    private View ikc;
    private boolean ikd;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUY = null;
        this.ijY = null;
        this.isBackground = false;
        this.ikd = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.ijY == null || DistributeVrVideoCardView.this.ijY.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.ijW != null) {
                                    DistributeVrVideoCardView.this.ijW.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.ijX.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gHt != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gHt.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.ijW != null) {
                                            DistributeVrVideoCardView.this.ijW.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.ijW != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.ijW.continuePlay();
                                    }
                                }
                            } else if (b.gHs == DistributeVrVideoCardView.this.ijX.getPage()) {
                                if (DistributeVrVideoCardView.this.ijW != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.ijW.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.ijW != null) {
                                DistributeVrVideoCardView.this.ijW.pausePlay();
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
    protected View bAd() {
        this.eUY = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.ijY = new CardGLTextureView(this.mContext.getPageActivity());
        this.eUY.addView((View) this.ijY, 0, new ViewGroup.LayoutParams(-1, -1));
        this.ijZ = (TbImageView) this.eUY.findViewById(d.g.ad_thumbnail);
        this.ika = (ImageView) this.eUY.findViewById(d.g.ad_play_button);
        this.bhI = this.eUY.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.eUY.findViewById(d.g.ad_error_tips);
        this.ika.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.aav = (ImageView) this.eUY.findViewById(d.g.play_icon);
        this.ikc = this.eUY.findViewById(d.g.replay);
        this.gIf = this.eUY.findViewById(d.g.card_layout_media_controller);
        this.ikb = this.eUY.findViewById(d.g.card_media_controller);
        return this.eUY;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.aav.setOnClickListener(onClickListener);
        this.ikc.setOnClickListener(onClickListener);
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
        if (this.ijY != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.ijX == null || this.ijX.getVideoInfo() == null || !TextUtils.equals(this.ijX.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.ijY.isDestroyed()) {
                if (this.ijY.isDestroyed()) {
                    this.eUY.removeView(this.ijY);
                    this.ijY = new CardGLTextureView(this.mContext.getPageActivity());
                    this.eUY.addView((View) this.ijY, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.ijX = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gHc;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eop);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gHd);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gHe);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cDf);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hEC = builder.build(false);
                if (this.hEC != null && !ap.isEmpty(this.hEC.video_url)) {
                    long bXf = (this.ijW == null || !this.hEC.video_url.equalsIgnoreCase(this.ijW.getVideoPath())) ? 0L : this.ijW.bXf();
                    this.ijW = new a(this);
                    if (bXf > 0) {
                        this.ijW.va((int) bXf);
                    }
                    ViewGroup.LayoutParams layoutParams = this.eUY.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.eUY.setLayoutParams(layoutParams);
                    }
                    this.ijZ.startLoad(this.hEC.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gHg) {
                        if (com.baidu.tieba.recapp.lego.a.a.al(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gIf.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.gIf.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gIf.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.gIf.setLayoutParams(layoutParams3);
                        }
                        this.gIf.setVisibility(0);
                    } else {
                        this.gIf.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.ijY;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhI.setVisibility(0);
        this.ika.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.aav.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.ika.setVisibility(8);
        this.bhI.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ijZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.aav.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.ika.setVisibility(8);
        this.bhI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijZ.setVisibility(8);
        this.ikb.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.aav.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        cE(true);
        this.ikc.setVisibility(8);
    }

    public void cE(boolean z) {
        if (z) {
            this.bhI.setVisibility(0);
        } else {
            this.bhI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ikb.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.ikb.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.ikb.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.ikb.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.ikb.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.aav.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        cE(false);
        pl(false);
    }

    public void pl(boolean z) {
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
        this.bhI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijZ.setVisibility(0);
        this.ika.setVisibility(0);
        this.ikb.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.aav.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bhI.setVisibility(8);
        this.ika.setVisibility(0);
        this.ijZ.setVisibility(0);
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
        if (this.ijW == null) {
            return false;
        }
        int playStatus = this.ijW.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.ijW == null) {
            return false;
        }
        return this.ijW.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.ikd) {
            this.ikd = false;
            if (!q.cdH()) {
                return;
            }
        }
        if (this.ijX != null && this.hEC != null && this.ijW != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.ijW.startPlay(DistributeVrVideoCardView.this.hEC.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.ijW != null) {
            this.ijW.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.ijX == null || this.hEC == null) ? "" : this.hEC.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.ijW == null) {
            return 0L;
        }
        return this.ijW.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.ijW != null) {
                this.ijW.va(0);
                this.ijW.destroy();
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
    public void bAj() {
        this.isBackground = false;
        super.bAj();
        if (this.ijY == null || this.ijY.isDestroyed()) {
            e(this.ijX);
        } else if (this.ijW != null) {
            this.ijW.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void Pq() {
        this.isBackground = true;
        super.Pq();
        if (this.ijW != null) {
            this.ijW.pausePlay();
            this.ijW.bXg();
        }
    }
}
