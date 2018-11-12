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
    private RelativeLayout dxO;
    private View fhx;
    private a gHN;
    DistributeVrVideoCard gHO;
    private CardGLTextureView gHP;
    private TbImageView gHQ;
    private ImageView gHR;
    private VideoListMediaControllerView gHS;
    private ImageView gHT;
    private View gHU;
    private boolean gHV;
    private VideoInfo gdK;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dxO = null;
        this.gHP = null;
        this.isBackground = false;
        this.gHV = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gHP == null || DistributeVrVideoCardView.this.gHP.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gHN != null) {
                                    DistributeVrVideoCardView.this.gHN.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gHO.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.fgL != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.fgL.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gHN != null) {
                                            DistributeVrVideoCardView.this.gHN.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gHN != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gHN.continuePlay();
                                    }
                                }
                            } else if (b.fgK == DistributeVrVideoCardView.this.gHO.getPage()) {
                                if (DistributeVrVideoCardView.this.gHN != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gHN.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gHN != null) {
                                DistributeVrVideoCardView.this.gHN.pausePlay();
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
    protected View aWt() {
        this.dxO = (RelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gHP = new CardGLTextureView(this.mContext.getPageActivity());
        this.dxO.addView((View) this.gHP, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gHQ = (TbImageView) this.dxO.findViewById(e.g.ad_thumbnail);
        this.gHR = (ImageView) this.dxO.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.dxO.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dxO.findViewById(e.g.ad_error_tips);
        this.gHR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gHT = (ImageView) this.dxO.findViewById(e.g.play_icon);
        this.gHU = this.dxO.findViewById(e.g.replay);
        this.fhx = this.dxO.findViewById(e.g.card_layout_media_controller);
        this.gHS = this.dxO.findViewById(e.g.card_media_controller);
        return this.dxO;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gHT.setOnClickListener(onClickListener);
        this.gHU.setOnClickListener(onClickListener);
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
        if (this.gHP != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gHO == null || this.gHO.getVideoInfo() == null || !TextUtils.equals(this.gHO.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gHP.isDestroyed()) {
                if (this.gHP.isDestroyed()) {
                    this.dxO.removeView(this.gHP);
                    this.gHP = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dxO.addView((View) this.gHP, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gHO = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().fgt;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cUe);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fgu);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fgv);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().boa;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bod);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gdK = builder.build(false);
                if (this.gdK != null && !ao.isEmpty(this.gdK.video_url)) {
                    long btc = (this.gHN == null || !this.gdK.video_url.equalsIgnoreCase(this.gHN.getVideoPath())) ? 0L : this.gHN.btc();
                    this.gHN = new a(this);
                    if (btc > 0) {
                        this.gHN.qI((int) btc);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dxO.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.dxO.setLayoutParams(layoutParams);
                    }
                    this.gHQ.startLoad(this.gdK.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().fgx) {
                        if (com.baidu.tieba.recapp.lego.a.a.M(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fhx.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0200e.ds32) + 0.5f);
                            this.fhx.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fhx.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0200e.ds30) + 0.5f);
                            this.fhx.setLayoutParams(layoutParams3);
                        }
                        this.fhx.setVisibility(0);
                    } else {
                        this.fhx.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gHP;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gHR.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gHT.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.gHR.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gHQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gHT.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midplay));
        this.gHR.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gHQ.setVisibility(8);
        this.gHS.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gHT.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(true);
        this.gHU.setVisibility(8);
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
        this.gHS.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gHS.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gHS.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gHS.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gHS.Y(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gHT.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        showLoadingView(false);
        mG(false);
    }

    public void mG(boolean z) {
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
        this.gHQ.setVisibility(0);
        this.gHR.setVisibility(0);
        this.gHS.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gHT.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gHR.setVisibility(0);
        this.gHQ.setVisibility(0);
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
        if (this.gHN == null) {
            return false;
        }
        int playStatus = this.gHN.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gHN == null) {
            return false;
        }
        return this.gHN.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gHV) {
            this.gHV = false;
            if (!q.bAL()) {
                return;
            }
        }
        if (this.gHO != null && this.gdK != null && this.gHN != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gHN.startPlay(DistributeVrVideoCardView.this.gdK.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gHN != null) {
            this.gHN.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gHO == null || this.gdK == null) ? "" : this.gdK.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gHN == null) {
            return 0L;
        }
        return this.gHN.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gHN != null) {
                this.gHN.qI(0);
                this.gHN.destroy();
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
    public void aWA() {
        this.isBackground = false;
        super.aWA();
        if (this.gHP == null || this.gHP.isDestroyed()) {
            e(this.gHO);
        } else if (this.gHN != null) {
            this.gHN.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aWz() {
        this.isBackground = true;
        super.aWz();
        if (this.gHN != null) {
            this.gHN.pausePlay();
            this.gHN.btd();
        }
    }
}
