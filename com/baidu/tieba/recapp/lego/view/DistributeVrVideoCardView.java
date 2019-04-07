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
    private ImageView aaw;
    private View bhL;
    private RelativeLayout eUK;
    private View gHS;
    private VideoInfo hEo;
    private a ijI;
    DistributeVrVideoCard ijJ;
    private CardGLTextureView ijK;
    private TbImageView ijL;
    private ImageView ijM;
    private VideoListMediaControllerView ijN;
    private View ijO;
    private boolean ijP;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUK = null;
        this.ijK = null;
        this.isBackground = false;
        this.ijP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.ijK == null || DistributeVrVideoCardView.this.ijK.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.ijI != null) {
                                    DistributeVrVideoCardView.this.ijI.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.ijJ.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gHg != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gHg.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.ijI != null) {
                                            DistributeVrVideoCardView.this.ijI.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.ijI != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.ijI.continuePlay();
                                    }
                                }
                            } else if (b.gHf == DistributeVrVideoCardView.this.ijJ.getPage()) {
                                if (DistributeVrVideoCardView.this.ijI != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.ijI.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.ijI != null) {
                                DistributeVrVideoCardView.this.ijI.pausePlay();
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
    protected View bAa() {
        this.eUK = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.ijK = new CardGLTextureView(this.mContext.getPageActivity());
        this.eUK.addView((View) this.ijK, 0, new ViewGroup.LayoutParams(-1, -1));
        this.ijL = (TbImageView) this.eUK.findViewById(d.g.ad_thumbnail);
        this.ijM = (ImageView) this.eUK.findViewById(d.g.ad_play_button);
        this.bhL = this.eUK.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.eUK.findViewById(d.g.ad_error_tips);
        this.ijM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.aaw = (ImageView) this.eUK.findViewById(d.g.play_icon);
        this.ijO = this.eUK.findViewById(d.g.replay);
        this.gHS = this.eUK.findViewById(d.g.card_layout_media_controller);
        this.ijN = this.eUK.findViewById(d.g.card_media_controller);
        return this.eUK;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.aaw.setOnClickListener(onClickListener);
        this.ijO.setOnClickListener(onClickListener);
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
        if (this.ijK != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.ijJ == null || this.ijJ.getVideoInfo() == null || !TextUtils.equals(this.ijJ.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.ijK.isDestroyed()) {
                if (this.ijK.isDestroyed()) {
                    this.eUK.removeView(this.ijK);
                    this.ijK = new CardGLTextureView(this.mContext.getPageActivity());
                    this.eUK.addView((View) this.ijK, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.ijJ = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gGP;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eoa);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gGQ);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gGR);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cDh);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hEo = builder.build(false);
                if (this.hEo != null && !ap.isEmpty(this.hEo.video_url)) {
                    long bXb = (this.ijI == null || !this.hEo.video_url.equalsIgnoreCase(this.ijI.getVideoPath())) ? 0L : this.ijI.bXb();
                    this.ijI = new a(this);
                    if (bXb > 0) {
                        this.ijI.uW((int) bXb);
                    }
                    ViewGroup.LayoutParams layoutParams = this.eUK.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.eUK.setLayoutParams(layoutParams);
                    }
                    this.ijL.startLoad(this.hEo.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gGT) {
                        if (com.baidu.tieba.recapp.lego.a.a.al(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHS.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.gHS.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gHS.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.gHS.setLayoutParams(layoutParams3);
                        }
                        this.gHS.setVisibility(0);
                    } else {
                        this.gHS.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.ijK;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhL.setVisibility(0);
        this.ijM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.aaw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.ijM.setVisibility(8);
        this.bhL.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ijL.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.aaw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.ijM.setVisibility(8);
        this.bhL.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijL.setVisibility(8);
        this.ijN.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.aaw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        cE(true);
        this.ijO.setVisibility(8);
    }

    public void cE(boolean z) {
        if (z) {
            this.bhL.setVisibility(0);
        } else {
            this.bhL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ijN.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.ijN.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.ijN.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.ijN.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.ijN.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.aaw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
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
        this.bhL.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijL.setVisibility(0);
        this.ijM.setVisibility(0);
        this.ijN.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.aaw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bhL.setVisibility(8);
        this.ijM.setVisibility(0);
        this.ijL.setVisibility(0);
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
        if (this.ijI == null) {
            return false;
        }
        int playStatus = this.ijI.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.ijI == null) {
            return false;
        }
        return this.ijI.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.ijP) {
            this.ijP = false;
            if (!q.cdD()) {
                return;
            }
        }
        if (this.ijJ != null && this.hEo != null && this.ijI != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.ijI.startPlay(DistributeVrVideoCardView.this.hEo.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.ijI != null) {
            this.ijI.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.ijJ == null || this.hEo == null) ? "" : this.hEo.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.ijI == null) {
            return 0L;
        }
        return this.ijI.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.ijI != null) {
                this.ijI.uW(0);
                this.ijI.destroy();
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
    public void bAg() {
        this.isBackground = false;
        super.bAg();
        if (this.ijK == null || this.ijK.isDestroyed()) {
            e(this.ijJ);
        } else if (this.ijI != null) {
            this.ijI.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void Po() {
        this.isBackground = true;
        super.Po();
        if (this.ijI != null) {
            this.ijI.pausePlay();
            this.ijI.bXc();
        }
    }
}
