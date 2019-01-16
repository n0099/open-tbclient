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
    private RelativeLayout dHK;
    private View fsc;
    private CardGLTextureView gSA;
    private TbImageView gSB;
    private ImageView gSC;
    private VideoListMediaControllerView gSD;
    private ImageView gSE;
    private View gSF;
    private boolean gSG;
    private a gSy;
    DistributeVrVideoCard gSz;
    private VideoInfo gow;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dHK = null;
        this.gSA = null;
        this.isBackground = false;
        this.gSG = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gSA == null || DistributeVrVideoCardView.this.gSA.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gSy != null) {
                                    DistributeVrVideoCardView.this.gSy.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gSz.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.frp != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.frp.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gSy != null) {
                                            DistributeVrVideoCardView.this.gSy.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gSy != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gSy.continuePlay();
                                    }
                                }
                            } else if (b.fro == DistributeVrVideoCardView.this.gSz.getPage()) {
                                if (DistributeVrVideoCardView.this.gSy != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gSy.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gSy != null) {
                                DistributeVrVideoCardView.this.gSy.pausePlay();
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
        this.dHK = (RelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gSA = new CardGLTextureView(this.mContext.getPageActivity());
        this.dHK.addView((View) this.gSA, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gSB = (TbImageView) this.dHK.findViewById(e.g.ad_thumbnail);
        this.gSC = (ImageView) this.dHK.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.dHK.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dHK.findViewById(e.g.ad_error_tips);
        this.gSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gSE = (ImageView) this.dHK.findViewById(e.g.play_icon);
        this.gSF = this.dHK.findViewById(e.g.replay);
        this.fsc = this.dHK.findViewById(e.g.card_layout_media_controller);
        this.gSD = this.dHK.findViewById(e.g.card_media_controller);
        return this.dHK;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gSE.setOnClickListener(onClickListener);
        this.gSF.setOnClickListener(onClickListener);
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
        if (this.gSA != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gSz == null || this.gSz.getVideoInfo() == null || !TextUtils.equals(this.gSz.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gSA.isDestroyed()) {
                if (this.gSA.isDestroyed()) {
                    this.dHK.removeView(this.gSA);
                    this.gSA = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dHK.addView((View) this.gSA, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gSz = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().fqX;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().der);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fqY);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fqZ);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bso;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bsr);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gow = builder.build(false);
                if (this.gow != null && !ao.isEmpty(this.gow.video_url)) {
                    long bwp = (this.gSy == null || !this.gow.video_url.equalsIgnoreCase(this.gSy.getVideoPath())) ? 0L : this.gSy.bwp();
                    this.gSy = new a(this);
                    if (bwp > 0) {
                        this.gSy.rr((int) bwp);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dHK.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.dHK.setLayoutParams(layoutParams);
                    }
                    this.gSB.startLoad(this.gow.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().frb) {
                        if (com.baidu.tieba.recapp.lego.a.a.M(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsc.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0210e.ds32) + 0.5f);
                            this.fsc.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fsc.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0210e.ds30) + 0.5f);
                            this.fsc.setLayoutParams(layoutParams3);
                        }
                        this.fsc.setVisibility(0);
                    } else {
                        this.fsc.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gSA;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gSC.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gSE.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.gSC.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gSB.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gSE.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midplay));
        this.gSC.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gSB.setVisibility(8);
        this.gSD.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gSE.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(true);
        this.gSF.setVisibility(8);
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
        this.gSD.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gSD.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gSD.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gSD.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gSD.Z(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gSE.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
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
        this.gSB.setVisibility(0);
        this.gSC.setVisibility(0);
        this.gSD.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gSE.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gSC.setVisibility(0);
        this.gSB.setVisibility(0);
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
        if (this.gSy == null) {
            return false;
        }
        int playStatus = this.gSy.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gSy == null) {
            return false;
        }
        return this.gSy.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gSG) {
            this.gSG = false;
            if (!q.bEg()) {
                return;
            }
        }
        if (this.gSz != null && this.gow != null && this.gSy != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gSy.startPlay(DistributeVrVideoCardView.this.gow.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gSy != null) {
            this.gSy.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gSz == null || this.gow == null) ? "" : this.gow.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gSy == null) {
            return 0L;
        }
        return this.gSy.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gSy != null) {
                this.gSy.rr(0);
                this.gSy.destroy();
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
        if (this.gSA == null || this.gSA.isDestroyed()) {
            e(this.gSz);
        } else if (this.gSy != null) {
            this.gSy.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aZE() {
        this.isBackground = true;
        super.aZE();
        if (this.gSy != null) {
            this.gSy.pausePlay();
            this.gSy.bwq();
        }
    }
}
