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
    private ImageView Yp;
    private View bnR;
    private RelativeLayout fkV;
    private View gZn;
    private VideoInfo hWp;
    private VideoListMediaControllerView iCA;
    private View iCB;
    private boolean iCC;
    private a iCv;
    DistributeVrVideoCard iCw;
    private CardGLTextureView iCx;
    private TbImageView iCy;
    private ImageView iCz;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fkV = null;
        this.iCx = null;
        this.isBackground = false;
        this.iCC = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iCx == null || DistributeVrVideoCardView.this.iCx.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iCv != null) {
                                    DistributeVrVideoCardView.this.iCv.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iCw.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gYB != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gYB.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iCv != null) {
                                            DistributeVrVideoCardView.this.iCv.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iCv != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iCv.continuePlay();
                                    }
                                }
                            } else if (b.gYA == DistributeVrVideoCardView.this.iCw.getPage()) {
                                if (DistributeVrVideoCardView.this.iCv != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iCv.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iCv != null) {
                                DistributeVrVideoCardView.this.iCv.pausePlay();
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
    protected View bHK() {
        this.fkV = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iCx = new CardGLTextureView(this.mContext.getPageActivity());
        this.fkV.addView((View) this.iCx, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iCy = (TbImageView) this.fkV.findViewById(R.id.ad_thumbnail);
        this.iCz = (ImageView) this.fkV.findViewById(R.id.ad_play_button);
        this.bnR = this.fkV.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fkV.findViewById(R.id.ad_error_tips);
        this.iCz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.Yp = (ImageView) this.fkV.findViewById(R.id.play_icon);
        this.iCB = this.fkV.findViewById(R.id.replay);
        this.gZn = this.fkV.findViewById(R.id.card_layout_media_controller);
        this.iCA = this.fkV.findViewById(R.id.card_media_controller);
        return this.fkV;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.Yp.setOnClickListener(onClickListener);
        this.iCB.setOnClickListener(onClickListener);
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
        if (this.iCx != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iCw == null || this.iCw.getVideoInfo() == null || !TextUtils.equals(this.iCw.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iCx.isDestroyed()) {
                if (this.iCx.isDestroyed()) {
                    this.fkV.removeView(this.iCx);
                    this.iCx = new CardGLTextureView(this.mContext.getPageActivity());
                    this.fkV.addView((View) this.iCx, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iCw = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gYk;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eDK);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gYl);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gYm);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cLq);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hWp = builder.build(false);
                if (this.hWp != null && !ap.isEmpty(this.hWp.video_url)) {
                    long cff = (this.iCv == null || !this.hWp.video_url.equalsIgnoreCase(this.iCv.getVideoPath())) ? 0L : this.iCv.cff();
                    this.iCv = new a(this);
                    if (cff > 0) {
                        this.iCv.wd((int) cff);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fkV.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.fkV.setLayoutParams(layoutParams);
                    }
                    this.iCy.startLoad(this.hWp.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gYo) {
                        if (com.baidu.tieba.recapp.lego.a.a.ao(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gZn.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.gZn.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gZn.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.gZn.setLayoutParams(layoutParams3);
                        }
                        this.gZn.setVisibility(0);
                    } else {
                        this.gZn.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iCx;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(0);
        this.iCz.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iCz.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iCy.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iCz.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCy.setVisibility(8);
        this.iCA.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cV(true);
        this.iCB.setVisibility(8);
    }

    public void cV(boolean z) {
        if (z) {
            this.bnR.setVisibility(0);
        } else {
            this.bnR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iCA.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iCA.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iCA.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iCA.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iCA.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        cV(false);
        pZ(false);
    }

    public void pZ(boolean z) {
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
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCy.setVisibility(0);
        this.iCz.setVisibility(0);
        this.iCA.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.Yp.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(8);
        this.iCz.setVisibility(0);
        this.iCy.setVisibility(0);
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
        if (this.iCv == null) {
            return false;
        }
        int playStatus = this.iCv.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iCv == null) {
            return false;
        }
        return this.iCv.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iCC) {
            this.iCC = false;
            if (!q.clI()) {
                return;
            }
        }
        if (this.iCw != null && this.hWp != null && this.iCv != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iCv.startPlay(DistributeVrVideoCardView.this.hWp.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iCv != null) {
            this.iCv.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iCw == null || this.hWp == null) ? "" : this.hWp.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iCv == null) {
            return 0L;
        }
        return this.iCv.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iCv != null) {
                this.iCv.wd(0);
                this.iCv.destroy();
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
    public void bHQ() {
        this.isBackground = false;
        super.bHQ();
        if (this.iCx == null || this.iCx.isDestroyed()) {
            e(this.iCw);
        } else if (this.iCv != null) {
            this.iCv.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void PV() {
        this.isBackground = true;
        super.PV();
        if (this.iCv != null) {
            this.iCv.pausePlay();
            this.iCv.cfg();
        }
    }
}
