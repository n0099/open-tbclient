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
import com.baidu.adp.lib.util.l;
import com.baidu.ar.base.MsgField;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
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
    private RelativeLayout dHL;
    private View fsd;
    DistributeVrVideoCard gSA;
    private CardGLTextureView gSB;
    private TbImageView gSC;
    private ImageView gSD;
    private VideoListMediaControllerView gSE;
    private ImageView gSF;
    private View gSG;
    private boolean gSH;
    private a gSz;
    private VideoInfo gox;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dHL = null;
        this.gSB = null;
        this.isBackground = false;
        this.gSH = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gSB == null || DistributeVrVideoCardView.this.gSB.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gSz != null) {
                                    DistributeVrVideoCardView.this.gSz.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gSA.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.frq != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.frq.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gSz != null) {
                                            DistributeVrVideoCardView.this.gSz.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gSz != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gSz.continuePlay();
                                    }
                                }
                            } else if (b.frp == DistributeVrVideoCardView.this.gSA.getPage()) {
                                if (DistributeVrVideoCardView.this.gSz != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gSz.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gSz != null) {
                                DistributeVrVideoCardView.this.gSz.pausePlay();
                            }
                            DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                            DistributeVrVideoCardView.this.mHandler.sendEmptyMessageDelayed(MsgField.IMSG_DEVICE_NOT_SUPPORT, TimeUnit.SECONDS.toMillis(1L));
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
    protected View aZy() {
        this.dHL = (RelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gSB = new CardGLTextureView(this.mContext.getPageActivity());
        this.dHL.addView((View) this.gSB, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gSC = (TbImageView) this.dHL.findViewById(e.g.ad_thumbnail);
        this.gSD = (ImageView) this.dHL.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.dHL.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dHL.findViewById(e.g.ad_error_tips);
        this.gSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gSF = (ImageView) this.dHL.findViewById(e.g.play_icon);
        this.gSG = this.dHL.findViewById(e.g.replay);
        this.fsd = this.dHL.findViewById(e.g.card_layout_media_controller);
        this.gSE = this.dHL.findViewById(e.g.card_media_controller);
        return this.dHL;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gSF.setOnClickListener(onClickListener);
        this.gSG.setOnClickListener(onClickListener);
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
        if (this.gSB != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gSA == null || this.gSA.getVideoInfo() == null || !TextUtils.equals(this.gSA.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gSB.isDestroyed()) {
                if (this.gSB.isDestroyed()) {
                    this.dHL.removeView(this.gSB);
                    this.gSB = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dHL.addView((View) this.gSB, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gSA = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().fqY;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().det);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fqZ);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fra);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bsp;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bss);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gox = builder.build(false);
                if (this.gox != null && !ao.isEmpty(this.gox.video_url)) {
                    long bwp = (this.gSz == null || !this.gox.video_url.equalsIgnoreCase(this.gSz.getVideoPath())) ? 0L : this.gSz.bwp();
                    this.gSz = new a(this);
                    if (bwp > 0) {
                        this.gSz.rr((int) bwp);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dHL.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.dHL.setLayoutParams(layoutParams);
                    }
                    this.gSC.startLoad(this.gox.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().frc) {
                        if (com.baidu.tieba.recapp.lego.a.a.M(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsd.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0210e.ds32) + 0.5f);
                            this.fsd.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fsd.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0210e.ds30) + 0.5f);
                            this.fsd.setLayoutParams(layoutParams3);
                        }
                        this.fsd.setVisibility(0);
                    } else {
                        this.fsd.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gSB;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gSD.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gSF.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.gSD.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gSC.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gSF.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midplay));
        this.gSD.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gSC.setVisibility(8);
        this.gSE.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gSF.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(true);
        this.gSG.setVisibility(8);
    }

    public void showLoadingView(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
        } else {
            this.mLoadingView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gSE.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gSE.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gSE.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gSE.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gSE.Z(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gSF.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(false);
        mM(false);
    }

    public void mM(boolean z) {
        if (z) {
            this.mErrorTip.setVisibility(0);
        } else {
            this.mErrorTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        }
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gSC.setVisibility(0);
        this.gSD.setVisibility(0);
        this.gSE.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gSF.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gSD.setVisibility(0);
        this.gSC.setVisibility(0);
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
        if (this.gSz == null) {
            return false;
        }
        int playStatus = this.gSz.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gSz == null) {
            return false;
        }
        return this.gSz.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gSH) {
            this.gSH = false;
            if (!q.bEg()) {
                return;
            }
        }
        if (this.gSA != null && this.gox != null && this.gSz != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gSz.startPlay(DistributeVrVideoCardView.this.gox.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gSz != null) {
            this.gSz.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gSA == null || this.gox == null) ? "" : this.gox.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gSz == null) {
            return 0L;
        }
        return this.gSz.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gSz != null) {
                this.gSz.rr(0);
                this.gSz.destroy();
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
    public void aZF() {
        this.isBackground = false;
        super.aZF();
        if (this.gSB == null || this.gSB.isDestroyed()) {
            e(this.gSA);
        } else if (this.gSz != null) {
            this.gSz.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aZE() {
        this.isBackground = true;
        super.aZE();
        if (this.gSz != null) {
            this.gSz.pausePlay();
            this.gSz.bwq();
        }
    }
}
