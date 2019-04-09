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
    private ImageView aax;
    private View bhM;
    private RelativeLayout eUL;
    private View gHT;
    private VideoInfo hEp;
    private a ijJ;
    DistributeVrVideoCard ijK;
    private CardGLTextureView ijL;
    private TbImageView ijM;
    private ImageView ijN;
    private VideoListMediaControllerView ijO;
    private View ijP;
    private boolean ijQ;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUL = null;
        this.ijL = null;
        this.isBackground = false;
        this.ijQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.ijL == null || DistributeVrVideoCardView.this.ijL.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.ijJ != null) {
                                    DistributeVrVideoCardView.this.ijJ.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.ijK.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gHh != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gHh.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.ijJ != null) {
                                            DistributeVrVideoCardView.this.ijJ.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.ijJ != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.ijJ.continuePlay();
                                    }
                                }
                            } else if (b.gHg == DistributeVrVideoCardView.this.ijK.getPage()) {
                                if (DistributeVrVideoCardView.this.ijJ != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.ijJ.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.ijJ != null) {
                                DistributeVrVideoCardView.this.ijJ.pausePlay();
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
        this.eUL = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.ijL = new CardGLTextureView(this.mContext.getPageActivity());
        this.eUL.addView((View) this.ijL, 0, new ViewGroup.LayoutParams(-1, -1));
        this.ijM = (TbImageView) this.eUL.findViewById(d.g.ad_thumbnail);
        this.ijN = (ImageView) this.eUL.findViewById(d.g.ad_play_button);
        this.bhM = this.eUL.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.eUL.findViewById(d.g.ad_error_tips);
        this.ijN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.aax = (ImageView) this.eUL.findViewById(d.g.play_icon);
        this.ijP = this.eUL.findViewById(d.g.replay);
        this.gHT = this.eUL.findViewById(d.g.card_layout_media_controller);
        this.ijO = this.eUL.findViewById(d.g.card_media_controller);
        return this.eUL;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.aax.setOnClickListener(onClickListener);
        this.ijP.setOnClickListener(onClickListener);
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
        if (this.ijL != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.ijK == null || this.ijK.getVideoInfo() == null || !TextUtils.equals(this.ijK.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.ijL.isDestroyed()) {
                if (this.ijL.isDestroyed()) {
                    this.eUL.removeView(this.ijL);
                    this.ijL = new CardGLTextureView(this.mContext.getPageActivity());
                    this.eUL.addView((View) this.ijL, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.ijK = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gGQ;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eob);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gGR);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gGS);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cDi);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hEp = builder.build(false);
                if (this.hEp != null && !ap.isEmpty(this.hEp.video_url)) {
                    long bXb = (this.ijJ == null || !this.hEp.video_url.equalsIgnoreCase(this.ijJ.getVideoPath())) ? 0L : this.ijJ.bXb();
                    this.ijJ = new a(this);
                    if (bXb > 0) {
                        this.ijJ.uW((int) bXb);
                    }
                    ViewGroup.LayoutParams layoutParams = this.eUL.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.eUL.setLayoutParams(layoutParams);
                    }
                    this.ijM.startLoad(this.hEp.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gGU) {
                        if (com.baidu.tieba.recapp.lego.a.a.al(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHT.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.gHT.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gHT.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.gHT.setLayoutParams(layoutParams3);
                        }
                        this.gHT.setVisibility(0);
                    } else {
                        this.gHT.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.ijL;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhM.setVisibility(0);
        this.ijN.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.aax.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.ijN.setVisibility(8);
        this.bhM.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ijM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.aax.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.ijN.setVisibility(8);
        this.bhM.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijM.setVisibility(8);
        this.ijO.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.aax.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        cE(true);
        this.ijP.setVisibility(8);
    }

    public void cE(boolean z) {
        if (z) {
            this.bhM.setVisibility(0);
        } else {
            this.bhM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ijO.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.ijO.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.ijO.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.ijO.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.ijO.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.aax.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
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
        this.bhM.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijM.setVisibility(0);
        this.ijN.setVisibility(0);
        this.ijO.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.aax.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bhM.setVisibility(8);
        this.ijN.setVisibility(0);
        this.ijM.setVisibility(0);
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
        if (this.ijJ == null) {
            return false;
        }
        int playStatus = this.ijJ.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.ijJ == null) {
            return false;
        }
        return this.ijJ.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.ijQ) {
            this.ijQ = false;
            if (!q.cdD()) {
                return;
            }
        }
        if (this.ijK != null && this.hEp != null && this.ijJ != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.ijJ.startPlay(DistributeVrVideoCardView.this.hEp.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.ijJ != null) {
            this.ijJ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.ijK == null || this.hEp == null) ? "" : this.hEp.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.ijJ == null) {
            return 0L;
        }
        return this.ijJ.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.ijJ != null) {
                this.ijJ.uW(0);
                this.ijJ.destroy();
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
        if (this.ijL == null || this.ijL.isDestroyed()) {
            e(this.ijK);
        } else if (this.ijJ != null) {
            this.ijJ.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void Po() {
        this.isBackground = true;
        super.Po();
        if (this.ijJ != null) {
            this.ijJ.pausePlay();
            this.ijJ.bXc();
        }
    }
}
