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
import com.baidu.tbadk.core.util.an;
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
    private RelativeLayout cTG;
    private View ewS;
    private a fZU;
    DistributeVrVideoCard fZV;
    private CardGLTextureView fZW;
    private TbImageView fZX;
    private ImageView fZY;
    private VideoListMediaControllerView fZZ;
    private VideoInfo fwm;
    private ImageView gaa;
    private View gab;
    private boolean gac;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cTG = null;
        this.fZW = null;
        this.isBackground = false;
        this.gac = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.adf != null && DistributeVrVideoCardView.this.adf.getPageActivity() != null && !DistributeVrVideoCardView.this.adf.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.fZW == null || DistributeVrVideoCardView.this.fZW.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.fZU != null) {
                                    DistributeVrVideoCardView.this.fZU.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.fZV.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.ewh != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.ewh.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.p(DistributeVrVideoCardView.this.adf.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.fZU != null) {
                                            DistributeVrVideoCardView.this.fZU.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.fZU != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.fZU.continuePlay();
                                    }
                                }
                            } else if (b.ewg == DistributeVrVideoCardView.this.fZV.getPage()) {
                                if (DistributeVrVideoCardView.this.fZU != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.fZU.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.fZU != null) {
                                DistributeVrVideoCardView.this.fZU.pausePlay();
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
    protected View aKU() {
        this.cTG = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.card_distribute_vr_video_view, (ViewGroup) null);
        this.fZW = new CardGLTextureView(this.adf.getPageActivity());
        this.cTG.addView((View) this.fZW, 0, new ViewGroup.LayoutParams(-1, -1));
        this.fZX = (TbImageView) this.cTG.findViewById(d.g.ad_thumbnail);
        this.fZY = (ImageView) this.cTG.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.cTG.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.cTG.findViewById(d.g.ad_error_tips);
        this.fZY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gaa = (ImageView) this.cTG.findViewById(d.g.play_icon);
        this.gab = this.cTG.findViewById(d.g.replay);
        this.ewS = this.cTG.findViewById(d.g.card_layout_media_controller);
        this.fZZ = this.cTG.findViewById(d.g.card_media_controller);
        return this.cTG;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gaa.setOnClickListener(onClickListener);
        this.gab.setOnClickListener(onClickListener);
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
        if (this.fZW != null && this.adf != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.fZV == null || this.fZV.getVideoInfo() == null || !TextUtils.equals(this.fZV.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.fZW.isDestroyed()) {
                if (this.fZW.isDestroyed()) {
                    this.cTG.removeView(this.fZW);
                    this.fZW = new CardGLTextureView(this.adf.getPageActivity());
                    this.cTG.addView((View) this.fZW, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.fZV = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().evP;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cuK);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().evQ);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().evR);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().aWh;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().aWk);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fwm = builder.build(false);
                if (this.fwm != null && !an.isEmpty(this.fwm.video_url)) {
                    long bjG = (this.fZU == null || !this.fwm.video_url.equalsIgnoreCase(this.fZU.getVideoPath())) ? 0L : this.fZU.bjG();
                    this.fZU = new a(this);
                    if (bjG > 0) {
                        this.fZU.oH((int) bjG);
                    }
                    ViewGroup.LayoutParams layoutParams = this.cTG.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.cTG.setLayoutParams(layoutParams);
                    }
                    this.fZX.startLoad(this.fwm.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().evT) {
                        if (com.baidu.tieba.recapp.lego.a.a.D(this.adf.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ewS.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.adf.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.ewS.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ewS.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.adf.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.ewS.setLayoutParams(layoutParams3);
                        }
                        this.ewS.setVisibility(0);
                    } else {
                        this.ewS.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.fZW;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.fZY.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gaa.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        this.fZY.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.fZX.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gaa.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midplay));
        this.fZY.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.fZX.setVisibility(8);
        this.fZZ.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gaa.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        gA(true);
        this.gab.setVisibility(8);
    }

    public void gA(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
        } else {
            this.mLoadingView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fZZ.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.fZZ.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.fZZ.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fZZ.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.fZZ.Q(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gaa.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        gA(false);
        lC(false);
    }

    public void lC(boolean z) {
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
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.fZX.setVisibility(0);
        this.fZY.setVisibility(0);
        this.fZZ.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gaa.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.fZY.setVisibility(0);
        this.fZX.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.adf;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.fZU == null) {
            return false;
        }
        int playStatus = this.fZU.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.fZU == null) {
            return false;
        }
        return this.fZU.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gac) {
            this.gac = false;
            if (!q.bro()) {
                return;
            }
        }
        if (this.fZV != null && this.fwm != null && this.fZU != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.fZU.startPlay(DistributeVrVideoCardView.this.fwm.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.fZU != null) {
            this.fZU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.fZV == null || this.fwm == null) ? "" : this.fwm.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.fZU == null) {
            return 0L;
        }
        return this.fZU.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.fZU != null) {
                this.fZU.oH(0);
                this.fZU.destroy();
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
    public void aLc() {
        this.isBackground = false;
        super.aLc();
        if (this.fZW == null || this.fZW.isDestroyed()) {
            e(this.fZV);
        } else if (this.fZU != null) {
            this.fZU.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLb() {
        this.isBackground = true;
        super.aLb();
        if (this.fZU != null) {
            this.fZU.pausePlay();
            this.fZU.bjH();
        }
    }
}
