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
    private ImageView If;
    private View bGX;
    private RelativeLayout fqC;
    private View hfD;
    private a iKs;
    DistributeVrVideoCard iKt;
    private CardGLTextureView iKu;
    private TbImageView iKv;
    private ImageView iKw;
    private VideoListMediaControllerView iKx;
    private View iKy;
    private boolean iKz;
    private VideoInfo idy;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fqC = null;
        this.iKu = null;
        this.isBackground = false;
        this.iKz = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.ceu != null && DistributeVrVideoCardView.this.ceu.getPageActivity() != null && !DistributeVrVideoCardView.this.ceu.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iKu == null || DistributeVrVideoCardView.this.iKu.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iKs != null) {
                                    DistributeVrVideoCardView.this.iKs.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iKt.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.heR != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.heR.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.ceu.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iKs != null) {
                                            DistributeVrVideoCardView.this.iKs.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iKs != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iKs.continuePlay();
                                    }
                                }
                            } else if (b.heQ == DistributeVrVideoCardView.this.iKt.getPage()) {
                                if (DistributeVrVideoCardView.this.iKs != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iKs.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iKs != null) {
                                DistributeVrVideoCardView.this.iKs.pausePlay();
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
    protected View bIe() {
        this.fqC = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iKu = new CardGLTextureView(this.ceu.getPageActivity());
        this.fqC.addView((View) this.iKu, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iKv = (TbImageView) this.fqC.findViewById(R.id.ad_thumbnail);
        this.iKw = (ImageView) this.fqC.findViewById(R.id.ad_play_button);
        this.bGX = this.fqC.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fqC.findViewById(R.id.ad_error_tips);
        this.iKw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.If = (ImageView) this.fqC.findViewById(R.id.play_icon);
        this.iKy = this.fqC.findViewById(R.id.replay);
        this.hfD = this.fqC.findViewById(R.id.card_layout_media_controller);
        this.iKx = this.fqC.findViewById(R.id.card_media_controller);
        return this.fqC;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.If.setOnClickListener(onClickListener);
        this.iKy.setOnClickListener(onClickListener);
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
        if (this.iKu != null && this.ceu != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iKt == null || this.iKt.getVideoInfo() == null || !TextUtils.equals(this.iKt.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iKu.isDestroyed()) {
                if (this.iKu.isDestroyed()) {
                    this.fqC.removeView(this.iKu);
                    this.iKu = new CardGLTextureView(this.ceu.getPageActivity());
                    this.fqC.addView((View) this.iKu, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iKt = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hez;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eSl);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().heA);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().heB);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cWj);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.idy = builder.build(false);
                if (this.idy != null && !aq.isEmpty(this.idy.video_url)) {
                    long cgh = (this.iKs == null || !this.idy.video_url.equalsIgnoreCase(this.iKs.getVideoPath())) ? 0L : this.iKs.cgh();
                    this.iKs = new a(this);
                    if (cgh > 0) {
                        this.iKs.vq((int) cgh);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fqC.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.fqC.setLayoutParams(layoutParams);
                    }
                    this.iKv.startLoad(this.idy.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().heD) {
                        if (com.baidu.tieba.recapp.lego.a.a.aj(this.ceu.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfD.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.ceu.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hfD.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hfD.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.ceu.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hfD.setLayoutParams(layoutParams3);
                        }
                        this.hfD.setVisibility(0);
                    } else {
                        this.hfD.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iKu;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bGX.setVisibility(0);
        this.iKw.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.If.setImageDrawable(this.ceu.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iKw.setVisibility(8);
        this.bGX.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iKv.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.If.setImageDrawable(this.ceu.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iKw.setVisibility(8);
        this.bGX.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iKv.setVisibility(8);
        this.iKx.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.If.setImageDrawable(this.ceu.getResources().getDrawable(R.drawable.icon_video_midpause));
        dp(true);
        this.iKy.setVisibility(8);
    }

    public void dp(boolean z) {
        if (z) {
            this.bGX.setVisibility(0);
        } else {
            this.bGX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iKx.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iKx.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iKx.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iKx.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iKx.aB(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.If.setImageDrawable(this.ceu.getResources().getDrawable(R.drawable.icon_video_midpause));
        dp(false);
        qb(false);
    }

    public void qb(boolean z) {
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
        this.bGX.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iKv.setVisibility(0);
        this.iKw.setVisibility(0);
        this.iKx.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.If.setImageDrawable(this.ceu.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bGX.setVisibility(8);
        this.iKw.setVisibility(0);
        this.iKv.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.ceu;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.iKs == null) {
            return false;
        }
        int playStatus = this.iKs.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iKs == null) {
            return false;
        }
        return this.iKs.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iKz) {
            this.iKz = false;
            if (!s.cnC()) {
                return;
            }
        }
        if (this.iKt != null && this.idy != null && this.iKs != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iKs.startPlay(DistributeVrVideoCardView.this.idy.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iKs != null) {
            this.iKs.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iKt == null || this.idy == null) ? "" : this.idy.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iKs == null) {
            return 0L;
        }
        return this.iKs.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iKs != null) {
                this.iKs.vq(0);
                this.iKs.destroy();
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
    public void bIk() {
        this.isBackground = false;
        super.bIk();
        if (this.iKu == null || this.iKu.isDestroyed()) {
            e(this.iKt);
        } else if (this.iKs != null) {
            this.iKs.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void VF() {
        this.isBackground = true;
        super.VF();
        if (this.iKs != null) {
            this.iKs.pausePlay();
            this.iKs.cgi();
        }
    }
}
