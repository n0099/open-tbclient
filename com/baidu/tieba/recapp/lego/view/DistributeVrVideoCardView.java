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
    private View ddp;
    private RelativeLayout dou;
    private View eYw;
    private VideoInfo fUM;
    private a gyL;
    DistributeVrVideoCard gyM;
    private CardGLTextureView gyN;
    private TbImageView gyO;
    private ImageView gyP;
    private VideoListMediaControllerView gyQ;
    private ImageView gyR;
    private View gyS;
    private boolean gyT;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dou = null;
        this.gyN = null;
        this.isBackground = false;
        this.gyT = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gyN == null || DistributeVrVideoCardView.this.gyN.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gyL != null) {
                                    DistributeVrVideoCardView.this.gyL.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gyM.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.eXK != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.eXK.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gyL != null) {
                                            DistributeVrVideoCardView.this.gyL.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gyL != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gyL.continuePlay();
                                    }
                                }
                            } else if (b.eXJ == DistributeVrVideoCardView.this.gyM.getPage()) {
                                if (DistributeVrVideoCardView.this.gyL != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gyL.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gyL != null) {
                                DistributeVrVideoCardView.this.gyL.pausePlay();
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
    protected View aTI() {
        this.dou = (RelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gyN = new CardGLTextureView(this.mContext.getPageActivity());
        this.dou.addView((View) this.gyN, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gyO = (TbImageView) this.dou.findViewById(e.g.ad_thumbnail);
        this.gyP = (ImageView) this.dou.findViewById(e.g.ad_play_button);
        this.ddp = this.dou.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dou.findViewById(e.g.ad_error_tips);
        this.gyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gyR = (ImageView) this.dou.findViewById(e.g.play_icon);
        this.gyS = this.dou.findViewById(e.g.replay);
        this.eYw = this.dou.findViewById(e.g.card_layout_media_controller);
        this.gyQ = this.dou.findViewById(e.g.card_media_controller);
        return this.dou;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gyR.setOnClickListener(onClickListener);
        this.gyS.setOnClickListener(onClickListener);
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
        if (this.gyN != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gyM == null || this.gyM.getVideoInfo() == null || !TextUtils.equals(this.gyM.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gyN.isDestroyed()) {
                if (this.gyN.isDestroyed()) {
                    this.dou.removeView(this.gyN);
                    this.gyN = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dou.addView((View) this.gyN, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gyM = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().eXs;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cKF);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eXt);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eXu);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bjk;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bjn);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fUM = builder.build(false);
                if (this.fUM != null && !ao.isEmpty(this.fUM.video_url)) {
                    long bqr = (this.gyL == null || !this.fUM.video_url.equalsIgnoreCase(this.gyL.getVideoPath())) ? 0L : this.gyL.bqr();
                    this.gyL = new a(this);
                    if (bqr > 0) {
                        this.gyL.pR((int) bqr);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dou.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.dou.setLayoutParams(layoutParams);
                    }
                    this.gyO.startLoad(this.fUM.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().eXw) {
                        if (com.baidu.tieba.recapp.lego.a.a.H(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eYw.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0141e.ds32) + 0.5f);
                            this.eYw.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eYw.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0141e.ds30) + 0.5f);
                            this.eYw.setLayoutParams(layoutParams3);
                        }
                        this.eYw.setVisibility(0);
                    } else {
                        this.eYw.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gyN;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.ddp.setVisibility(0);
        this.gyP.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gyR.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.gyP.setVisibility(8);
        this.ddp.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gyO.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gyR.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midplay));
        this.gyP.setVisibility(8);
        this.ddp.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gyO.setVisibility(8);
        this.gyQ.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gyR.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        hs(true);
        this.gyS.setVisibility(8);
    }

    public void hs(boolean z) {
        if (z) {
            this.ddp.setVisibility(0);
        } else {
            this.ddp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gyQ.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gyQ.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gyQ.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gyQ.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gyQ.X(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gyR.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        hs(false);
        md(false);
    }

    public void md(boolean z) {
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
        this.ddp.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gyO.setVisibility(0);
        this.gyP.setVisibility(0);
        this.gyQ.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gyR.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.ddp.setVisibility(8);
        this.gyP.setVisibility(0);
        this.gyO.setVisibility(0);
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
        if (this.gyL == null) {
            return false;
        }
        int playStatus = this.gyL.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gyL == null) {
            return false;
        }
        return this.gyL.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gyT) {
            this.gyT = false;
            if (!q.bya()) {
                return;
            }
        }
        if (this.gyM != null && this.fUM != null && this.gyL != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gyL.startPlay(DistributeVrVideoCardView.this.fUM.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gyL != null) {
            this.gyL.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gyM == null || this.fUM == null) ? "" : this.fUM.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gyL == null) {
            return 0L;
        }
        return this.gyL.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gyL != null) {
                this.gyL.pR(0);
                this.gyL.destroy();
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
    public void aTQ() {
        this.isBackground = false;
        super.aTQ();
        if (this.gyN == null || this.gyN.isDestroyed()) {
            e(this.gyM);
        } else if (this.gyL != null) {
            this.gyL.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aTP() {
        this.isBackground = true;
        super.aTP();
        if (this.gyL != null) {
            this.gyL.pausePlay();
            this.gyL.bqs();
        }
    }
}
