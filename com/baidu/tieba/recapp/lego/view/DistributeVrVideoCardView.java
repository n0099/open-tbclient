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
import com.baidu.ar.base.MsgField;
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
    private View cXy;
    private RelativeLayout diD;
    private View eRg;
    private VideoInfo fMZ;
    private a grq;
    DistributeVrVideoCard grr;
    private CardGLTextureView grs;
    private TbImageView grt;
    private ImageView gru;
    private VideoListMediaControllerView grv;
    private ImageView grw;
    private View grx;
    private boolean gry;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.diD = null;
        this.grs = null;
        this.isBackground = false;
        this.gry = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.grs == null || DistributeVrVideoCardView.this.grs.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.grq != null) {
                                    DistributeVrVideoCardView.this.grq.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.grr.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.eQu != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.eQu.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.o(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.grq != null) {
                                            DistributeVrVideoCardView.this.grq.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.grq != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.grq.continuePlay();
                                    }
                                }
                            } else if (b.eQt == DistributeVrVideoCardView.this.grr.getPage()) {
                                if (DistributeVrVideoCardView.this.grq != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.grq.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.grq != null) {
                                DistributeVrVideoCardView.this.grq.pausePlay();
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
    protected View aRx() {
        this.diD = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.grs = new CardGLTextureView(this.mContext.getPageActivity());
        this.diD.addView((View) this.grs, 0, new ViewGroup.LayoutParams(-1, -1));
        this.grt = (TbImageView) this.diD.findViewById(d.g.ad_thumbnail);
        this.gru = (ImageView) this.diD.findViewById(d.g.ad_play_button);
        this.cXy = this.diD.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.diD.findViewById(d.g.ad_error_tips);
        this.gru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.grw = (ImageView) this.diD.findViewById(d.g.play_icon);
        this.grx = this.diD.findViewById(d.g.replay);
        this.eRg = this.diD.findViewById(d.g.card_layout_media_controller);
        this.grv = this.diD.findViewById(d.g.card_media_controller);
        return this.diD;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.grw.setOnClickListener(onClickListener);
        this.grx.setOnClickListener(onClickListener);
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
        if (this.grs != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.grr == null || this.grr.getVideoInfo() == null || !TextUtils.equals(this.grr.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.grs.isDestroyed()) {
                if (this.grs.isDestroyed()) {
                    this.diD.removeView(this.grs);
                    this.grs = new CardGLTextureView(this.mContext.getPageActivity());
                    this.diD.addView((View) this.grs, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.grr = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().eQc;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cER);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eQd);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eQe);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bfO;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bfR);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fMZ = builder.build(false);
                if (this.fMZ != null && !ap.isEmpty(this.fMZ.video_url)) {
                    long bnJ = (this.grq == null || !this.fMZ.video_url.equalsIgnoreCase(this.grq.getVideoPath())) ? 0L : this.grq.bnJ();
                    this.grq = new a(this);
                    if (bnJ > 0) {
                        this.grq.pn((int) bnJ);
                    }
                    ViewGroup.LayoutParams layoutParams = this.diD.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ah(getContext());
                        layoutParams.height = l.aj(getContext());
                        this.diD.setLayoutParams(layoutParams);
                    }
                    this.grt.startLoad(this.fMZ.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().eQg) {
                        if (com.baidu.tieba.recapp.lego.a.a.F(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRg.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.eRg.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eRg.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.eRg.setLayoutParams(layoutParams3);
                        }
                        this.eRg.setVisibility(0);
                    } else {
                        this.eRg.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.grs;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cXy.setVisibility(0);
        this.gru.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.grw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.gru.setVisibility(8);
        this.cXy.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.grt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.grw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.gru.setVisibility(8);
        this.cXy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grt.setVisibility(8);
        this.grv.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.grw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gU(true);
        this.grx.setVisibility(8);
    }

    public void gU(boolean z) {
        if (z) {
            this.cXy.setVisibility(0);
        } else {
            this.cXy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.grv.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.grv.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.grv.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.grv.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.grv.T(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.grw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gU(false);
        lE(false);
    }

    public void lE(boolean z) {
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
        this.cXy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grt.setVisibility(0);
        this.gru.setVisibility(0);
        this.grv.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.grw.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.cXy.setVisibility(8);
        this.gru.setVisibility(0);
        this.grt.setVisibility(0);
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
        if (this.grq == null) {
            return false;
        }
        int playStatus = this.grq.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.grq == null) {
            return false;
        }
        return this.grq.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gry) {
            this.gry = false;
            if (!q.bvt()) {
                return;
            }
        }
        if (this.grr != null && this.fMZ != null && this.grq != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.grq.startPlay(DistributeVrVideoCardView.this.fMZ.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.grq != null) {
            this.grq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.grr == null || this.fMZ == null) ? "" : this.fMZ.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.grq == null) {
            return 0L;
        }
        return this.grq.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.grq != null) {
                this.grq.pn(0);
                this.grq.destroy();
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
    public void aRF() {
        this.isBackground = false;
        super.aRF();
        if (this.grs == null || this.grs.isDestroyed()) {
            e(this.grr);
        } else if (this.grq != null) {
            this.grq.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aRE() {
        this.isBackground = true;
        super.aRE();
        if (this.grq != null) {
            this.grq.pausePlay();
            this.grq.bnK();
        }
    }
}
