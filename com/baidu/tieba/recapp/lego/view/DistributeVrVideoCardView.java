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
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView YJ;
    private View boE;
    private RelativeLayout fpU;
    private View hfD;
    private a iIQ;
    DistributeVrVideoCard iIR;
    private CardGLTextureView iIS;
    private TbImageView iIT;
    private ImageView iIU;
    private VideoListMediaControllerView iIV;
    private View iIW;
    private boolean iIX;
    private VideoInfo icG;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fpU = null;
        this.iIS = null;
        this.isBackground = false;
        this.iIX = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iIS == null || DistributeVrVideoCardView.this.iIS.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iIQ != null) {
                                    DistributeVrVideoCardView.this.iIQ.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iIR.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.heR != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.heR.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.u(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iIQ != null) {
                                            DistributeVrVideoCardView.this.iIQ.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iIQ != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iIQ.continuePlay();
                                    }
                                }
                            } else if (b.heQ == DistributeVrVideoCardView.this.iIR.getPage()) {
                                if (DistributeVrVideoCardView.this.iIQ != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iIQ.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iIQ != null) {
                                DistributeVrVideoCardView.this.iIQ.pausePlay();
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
    protected View bKv() {
        this.fpU = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iIS = new CardGLTextureView(this.mContext.getPageActivity());
        this.fpU.addView((View) this.iIS, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iIT = (TbImageView) this.fpU.findViewById(R.id.ad_thumbnail);
        this.iIU = (ImageView) this.fpU.findViewById(R.id.ad_play_button);
        this.boE = this.fpU.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fpU.findViewById(R.id.ad_error_tips);
        this.iIU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.YJ = (ImageView) this.fpU.findViewById(R.id.play_icon);
        this.iIW = this.fpU.findViewById(R.id.replay);
        this.hfD = this.fpU.findViewById(R.id.card_layout_media_controller);
        this.iIV = this.fpU.findViewById(R.id.card_media_controller);
        return this.fpU;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.YJ.setOnClickListener(onClickListener);
        this.iIW.setOnClickListener(onClickListener);
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
        if (this.iIS != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iIR == null || this.iIR.getVideoInfo() == null || !TextUtils.equals(this.iIR.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iIS.isDestroyed()) {
                if (this.iIS.isDestroyed()) {
                    this.fpU.removeView(this.iIS);
                    this.iIS = new CardGLTextureView(this.mContext.getPageActivity());
                    this.fpU.addView((View) this.iIS, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iIR = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hez;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eIH);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().heA);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().heB);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cML);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.icG = builder.build(false);
                if (this.icG != null && !aq.isEmpty(this.icG.video_url)) {
                    long chZ = (this.iIQ == null || !this.icG.video_url.equalsIgnoreCase(this.iIQ.getVideoPath())) ? 0L : this.iIQ.chZ();
                    this.iIQ = new a(this);
                    if (chZ > 0) {
                        this.iIQ.wG((int) chZ);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fpU.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.fpU.setLayoutParams(layoutParams);
                    }
                    this.iIT.startLoad(this.icG.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().heD) {
                        if (com.baidu.tieba.recapp.lego.a.a.ar(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfD.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hfD.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hfD.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds30) + 0.5f);
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
        return this.iIS;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.boE.setVisibility(0);
        this.iIU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iIU.setVisibility(8);
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iIT.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iIU.setVisibility(8);
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iIT.setVisibility(8);
        this.iIV.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cY(true);
        this.iIW.setVisibility(8);
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
        this.iIV.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iIV.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iIV.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iIV.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iIV.aC(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cY(false);
        qp(false);
    }

    public void qp(boolean z) {
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
        this.iIT.setVisibility(0);
        this.iIU.setVisibility(0);
        this.iIV.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.YJ.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.boE.setVisibility(8);
        this.iIU.setVisibility(0);
        this.iIT.setVisibility(0);
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
        if (this.iIQ == null) {
            return false;
        }
        int playStatus = this.iIQ.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iIQ == null) {
            return false;
        }
        return this.iIQ.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iIX) {
            this.iIX = false;
            if (!q.coD()) {
                return;
            }
        }
        if (this.iIR != null && this.icG != null && this.iIQ != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iIQ.startPlay(DistributeVrVideoCardView.this.icG.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iIQ != null) {
            this.iIQ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iIR == null || this.icG == null) ? "" : this.icG.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iIQ == null) {
            return 0L;
        }
        return this.iIQ.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iIQ != null) {
                this.iIQ.wG(0);
                this.iIQ.destroy();
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
    public void bKB() {
        this.isBackground = false;
        super.bKB();
        if (this.iIS == null || this.iIS.isDestroyed()) {
            e(this.iIR);
        } else if (this.iIQ != null) {
            this.iIQ.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void QN() {
        this.isBackground = true;
        super.QN();
        if (this.iIQ != null) {
            this.iIQ.pausePlay();
            this.iIQ.cia();
        }
    }
}
