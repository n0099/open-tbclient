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
    private RelativeLayout dEn;
    private View fop;
    private a gOD;
    DistributeVrVideoCard gOE;
    private CardGLTextureView gOF;
    private TbImageView gOG;
    private ImageView gOH;
    private VideoListMediaControllerView gOI;
    private ImageView gOJ;
    private View gOK;
    private boolean gOL;
    private VideoInfo gkC;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dEn = null;
        this.gOF = null;
        this.isBackground = false;
        this.gOL = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gOF == null || DistributeVrVideoCardView.this.gOF.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gOD != null) {
                                    DistributeVrVideoCardView.this.gOD.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gOE.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.fnD != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.fnD.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gOD != null) {
                                            DistributeVrVideoCardView.this.gOD.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gOD != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gOD.continuePlay();
                                    }
                                }
                            } else if (b.fnC == DistributeVrVideoCardView.this.gOE.getPage()) {
                                if (DistributeVrVideoCardView.this.gOD != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gOD.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gOD != null) {
                                DistributeVrVideoCardView.this.gOD.pausePlay();
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
    protected View aYl() {
        this.dEn = (RelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gOF = new CardGLTextureView(this.mContext.getPageActivity());
        this.dEn.addView((View) this.gOF, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gOG = (TbImageView) this.dEn.findViewById(e.g.ad_thumbnail);
        this.gOH = (ImageView) this.dEn.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.dEn.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dEn.findViewById(e.g.ad_error_tips);
        this.gOH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gOJ = (ImageView) this.dEn.findViewById(e.g.play_icon);
        this.gOK = this.dEn.findViewById(e.g.replay);
        this.fop = this.dEn.findViewById(e.g.card_layout_media_controller);
        this.gOI = this.dEn.findViewById(e.g.card_media_controller);
        return this.dEn;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gOJ.setOnClickListener(onClickListener);
        this.gOK.setOnClickListener(onClickListener);
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
        if (this.gOF != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gOE == null || this.gOE.getVideoInfo() == null || !TextUtils.equals(this.gOE.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gOF.isDestroyed()) {
                if (this.gOF.isDestroyed()) {
                    this.dEn.removeView(this.gOF);
                    this.gOF = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dEn.addView((View) this.gOF, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gOE = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().fnl;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().daN);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fnm);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fnn);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().brx;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().brA);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gkC = builder.build(false);
                if (this.gkC != null && !ao.isEmpty(this.gkC.video_url)) {
                    long buV = (this.gOD == null || !this.gkC.video_url.equalsIgnoreCase(this.gOD.getVideoPath())) ? 0L : this.gOD.buV();
                    this.gOD = new a(this);
                    if (buV > 0) {
                        this.gOD.rc((int) buV);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dEn.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.dEn.setLayoutParams(layoutParams);
                    }
                    this.gOG.startLoad(this.gkC.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().fnp) {
                        if (com.baidu.tieba.recapp.lego.a.a.P(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fop.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0210e.ds32) + 0.5f);
                            this.fop.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fop.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0210e.ds30) + 0.5f);
                            this.fop.setLayoutParams(layoutParams3);
                        }
                        this.fop.setVisibility(0);
                    } else {
                        this.fop.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gOF;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gOH.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gOJ.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.gOH.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gOG.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gOJ.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midplay));
        this.gOH.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gOG.setVisibility(8);
        this.gOI.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gOJ.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(true);
        this.gOK.setVisibility(8);
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
        this.gOI.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gOI.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gOI.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gOI.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gOI.Z(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gOJ.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(false);
        mJ(false);
    }

    public void mJ(boolean z) {
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
        this.gOG.setVisibility(0);
        this.gOH.setVisibility(0);
        this.gOI.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gOJ.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gOH.setVisibility(0);
        this.gOG.setVisibility(0);
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
        if (this.gOD == null) {
            return false;
        }
        int playStatus = this.gOD.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gOD == null) {
            return false;
        }
        return this.gOD.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gOL) {
            this.gOL = false;
            if (!q.bCG()) {
                return;
            }
        }
        if (this.gOE != null && this.gkC != null && this.gOD != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gOD.startPlay(DistributeVrVideoCardView.this.gkC.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gOD != null) {
            this.gOD.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gOE == null || this.gkC == null) ? "" : this.gkC.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gOD == null) {
            return 0L;
        }
        return this.gOD.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gOD != null) {
                this.gOD.rc(0);
                this.gOD.destroy();
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
    public void aYs() {
        this.isBackground = false;
        super.aYs();
        if (this.gOF == null || this.gOF.isDestroyed()) {
            e(this.gOE);
        } else if (this.gOD != null) {
            this.gOD.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aYr() {
        this.isBackground = true;
        super.aYr();
        if (this.gOD != null) {
            this.gOD.pausePlay();
            this.gOD.buW();
        }
    }
}
