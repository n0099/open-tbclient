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
import com.baidu.tbadk.core.util.ao;
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
    private RelativeLayout ddV;
    private View eJt;
    private VideoInfo fIJ;
    private a gmp;
    DistributeVrVideoCard gmq;
    private CardGLTextureView gmr;
    private TbImageView gms;
    private ImageView gmt;
    private VideoListMediaControllerView gmu;
    private ImageView gmv;
    private View gmw;
    private boolean gmx;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ddV = null;
        this.gmr = null;
        this.isBackground = false;
        this.gmx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gmr == null || DistributeVrVideoCardView.this.gmr.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gmp != null) {
                                    DistributeVrVideoCardView.this.gmp.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gmq.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.eII != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.eII.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.o(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gmp != null) {
                                            DistributeVrVideoCardView.this.gmp.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gmp != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gmp.continuePlay();
                                    }
                                }
                            } else if (b.eIH == DistributeVrVideoCardView.this.gmq.getPage()) {
                                if (DistributeVrVideoCardView.this.gmp != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gmp.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gmp != null) {
                                DistributeVrVideoCardView.this.gmp.pausePlay();
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
    protected View aPQ() {
        this.ddV = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.card_distribute_vr_video_view, (ViewGroup) null);
        this.gmr = new CardGLTextureView(this.mContext.getPageActivity());
        this.ddV.addView((View) this.gmr, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gms = (TbImageView) this.ddV.findViewById(d.g.ad_thumbnail);
        this.gmt = (ImageView) this.ddV.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.ddV.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.ddV.findViewById(d.g.ad_error_tips);
        this.gmt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gmv = (ImageView) this.ddV.findViewById(d.g.play_icon);
        this.gmw = this.ddV.findViewById(d.g.replay);
        this.eJt = this.ddV.findViewById(d.g.card_layout_media_controller);
        this.gmu = this.ddV.findViewById(d.g.card_media_controller);
        return this.ddV;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gmv.setOnClickListener(onClickListener);
        this.gmw.setOnClickListener(onClickListener);
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
        if (this.gmr != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gmq == null || this.gmq.getVideoInfo() == null || !TextUtils.equals(this.gmq.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gmr.isDestroyed()) {
                if (this.gmr.isDestroyed()) {
                    this.ddV.removeView(this.gmr);
                    this.gmr = new CardGLTextureView(this.mContext.getPageActivity());
                    this.ddV.addView((View) this.gmr, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gmq = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().eIq;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cEt);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eIr);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eIs);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().ben;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().beq);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fIJ = builder.build(false);
                if (this.fIJ != null && !ao.isEmpty(this.fIJ.video_url)) {
                    long boE = (this.gmp == null || !this.fIJ.video_url.equalsIgnoreCase(this.gmp.getVideoPath())) ? 0L : this.gmp.boE();
                    this.gmp = new a(this);
                    if (boE > 0) {
                        this.gmp.oR((int) boE);
                    }
                    ViewGroup.LayoutParams layoutParams = this.ddV.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ah(getContext());
                        layoutParams.height = l.aj(getContext());
                        this.ddV.setLayoutParams(layoutParams);
                    }
                    this.gms.startLoad(this.fIJ.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().eIu) {
                        if (com.baidu.tieba.recapp.lego.a.a.E(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eJt.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.eJt.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eJt.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.eJt.setLayoutParams(layoutParams3);
                        }
                        this.eJt.setVisibility(0);
                    } else {
                        this.eJt.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gmr;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gmt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gmv.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.gmt.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gms.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gmv.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.gmt.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gms.setVisibility(8);
        this.gmu.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gmv.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gH(true);
        this.gmw.setVisibility(8);
    }

    public void gH(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
        } else {
            this.mLoadingView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gmu.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gmu.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gmu.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gmu.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gmu.R(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gmv.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gH(false);
        lJ(false);
    }

    public void lJ(boolean z) {
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
        this.gms.setVisibility(0);
        this.gmt.setVisibility(0);
        this.gmu.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gmv.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gmt.setVisibility(0);
        this.gms.setVisibility(0);
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
        if (this.gmp == null) {
            return false;
        }
        int playStatus = this.gmp.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gmp == null) {
            return false;
        }
        return this.gmp.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gmx) {
            this.gmx = false;
            if (!q.bwo()) {
                return;
            }
        }
        if (this.gmq != null && this.fIJ != null && this.gmp != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gmp.startPlay(DistributeVrVideoCardView.this.fIJ.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gmp != null) {
            this.gmp.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gmq == null || this.fIJ == null) ? "" : this.fIJ.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gmp == null) {
            return 0L;
        }
        return this.gmp.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gmp != null) {
                this.gmp.oR(0);
                this.gmp.destroy();
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
    public void aPY() {
        this.isBackground = false;
        super.aPY();
        if (this.gmr == null || this.gmr.isDestroyed()) {
            e(this.gmq);
        } else if (this.gmp != null) {
            this.gmp.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aPX() {
        this.isBackground = true;
        super.aPX();
        if (this.gmp != null) {
            this.gmp.pausePlay();
            this.gmp.boF();
        }
    }
}
