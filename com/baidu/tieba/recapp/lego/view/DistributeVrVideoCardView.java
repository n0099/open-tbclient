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
/* loaded from: classes3.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView YJ;
    private View boE;
    private RelativeLayout fqt;
    private View hgv;
    private a iJU;
    DistributeVrVideoCard iJV;
    private CardGLTextureView iJW;
    private TbImageView iJX;
    private ImageView iJY;
    private VideoListMediaControllerView iJZ;
    private View iKa;
    private boolean iKb;
    private VideoInfo idG;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fqt = null;
        this.iJW = null;
        this.isBackground = false;
        this.iKb = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iJW == null || DistributeVrVideoCardView.this.iJW.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iJU != null) {
                                    DistributeVrVideoCardView.this.iJU.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iJV.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hfJ != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hfJ.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.u(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iJU != null) {
                                            DistributeVrVideoCardView.this.iJU.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iJU != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iJU.continuePlay();
                                    }
                                }
                            } else if (b.hfI == DistributeVrVideoCardView.this.iJV.getPage()) {
                                if (DistributeVrVideoCardView.this.iJU != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iJU.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iJU != null) {
                                DistributeVrVideoCardView.this.iJU.pausePlay();
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
    protected View bKJ() {
        this.fqt = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iJW = new CardGLTextureView(this.mContext.getPageActivity());
        this.fqt.addView((View) this.iJW, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iJX = (TbImageView) this.fqt.findViewById(R.id.ad_thumbnail);
        this.iJY = (ImageView) this.fqt.findViewById(R.id.ad_play_button);
        this.boE = this.fqt.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fqt.findViewById(R.id.ad_error_tips);
        this.iJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.YJ = (ImageView) this.fqt.findViewById(R.id.play_icon);
        this.iKa = this.fqt.findViewById(R.id.replay);
        this.hgv = this.fqt.findViewById(R.id.card_layout_media_controller);
        this.iJZ = this.fqt.findViewById(R.id.card_media_controller);
        return this.fqt;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.YJ.setOnClickListener(onClickListener);
        this.iKa.setOnClickListener(onClickListener);
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
        if (this.iJW != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iJV == null || this.iJV.getVideoInfo() == null || !TextUtils.equals(this.iJV.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iJW.isDestroyed()) {
                if (this.iJW.isDestroyed()) {
                    this.fqt.removeView(this.iJW);
                    this.iJW = new CardGLTextureView(this.mContext.getPageActivity());
                    this.fqt.addView((View) this.iJW, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iJV = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hfr;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eIO);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().hfs);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().hft);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cMS);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.idG = builder.build(false);
                if (this.idG != null && !aq.isEmpty(this.idG.video_url)) {
                    long cir = (this.iJU == null || !this.idG.video_url.equalsIgnoreCase(this.iJU.getVideoPath())) ? 0L : this.iJU.cir();
                    this.iJU = new a(this);
                    if (cir > 0) {
                        this.iJU.wI((int) cir);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fqt.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.fqt.setLayoutParams(layoutParams);
                    }
                    this.iJX.startLoad(this.idG.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hfv) {
                        if (com.baidu.tieba.recapp.lego.a.a.ar(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hgv.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hgv.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hgv.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hgv.setLayoutParams(layoutParams3);
                        }
                        this.hgv.setVisibility(0);
                    } else {
                        this.hgv.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iJW;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.boE.setVisibility(0);
        this.iJY.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iJY.setVisibility(8);
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iJX.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iJY.setVisibility(8);
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iJX.setVisibility(8);
        this.iJZ.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cY(true);
        this.iKa.setVisibility(8);
    }

    public void cY(boolean z) {
        if (z) {
            this.boE.setVisibility(0);
        } else {
            this.boE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iJZ.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iJZ.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iJZ.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iJZ.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iJZ.aC(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cY(false);
        qq(false);
    }

    public void qq(boolean z) {
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
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iJX.setVisibility(0);
        this.iJY.setVisibility(0);
        this.iJZ.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.boE.setVisibility(8);
        this.iJY.setVisibility(0);
        this.iJX.setVisibility(0);
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
        if (this.iJU == null) {
            return false;
        }
        int playStatus = this.iJU.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iJU == null) {
            return false;
        }
        return this.iJU.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iKb) {
            this.iKb = false;
            if (!s.coZ()) {
                return;
            }
        }
        if (this.iJV != null && this.idG != null && this.iJU != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iJU.startPlay(DistributeVrVideoCardView.this.idG.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iJU != null) {
            this.iJU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iJV == null || this.idG == null) ? "" : this.idG.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iJU == null) {
            return 0L;
        }
        return this.iJU.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iJU != null) {
                this.iJU.wI(0);
                this.iJU.destroy();
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
    public void bKP() {
        this.isBackground = false;
        super.bKP();
        if (this.iJW == null || this.iJW.isDestroyed()) {
            e(this.iJV);
        } else if (this.iJU != null) {
            this.iJU.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void QN() {
        this.isBackground = true;
        super.QN();
        if (this.iJU != null) {
            this.iJU.pausePlay();
            this.iJU.cis();
        }
    }
}
