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
    private RelativeLayout cTD;
    private View ewP;
    private a fZR;
    DistributeVrVideoCard fZS;
    private CardGLTextureView fZT;
    private TbImageView fZU;
    private ImageView fZV;
    private VideoListMediaControllerView fZW;
    private ImageView fZX;
    private View fZY;
    private boolean fZZ;
    private VideoInfo fwj;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cTD = null;
        this.fZT = null;
        this.isBackground = false;
        this.fZZ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.adf != null && DistributeVrVideoCardView.this.adf.getPageActivity() != null && !DistributeVrVideoCardView.this.adf.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.fZT == null || DistributeVrVideoCardView.this.fZT.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.fZR != null) {
                                    DistributeVrVideoCardView.this.fZR.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.fZS.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.ewe != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.ewe.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.p(DistributeVrVideoCardView.this.adf.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.fZR != null) {
                                            DistributeVrVideoCardView.this.fZR.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.fZR != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.fZR.continuePlay();
                                    }
                                }
                            } else if (b.ewd == DistributeVrVideoCardView.this.fZS.getPage()) {
                                if (DistributeVrVideoCardView.this.fZR != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.fZR.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.fZR != null) {
                                DistributeVrVideoCardView.this.fZR.pausePlay();
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
        this.cTD = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.card_distribute_vr_video_view, (ViewGroup) null);
        this.fZT = new CardGLTextureView(this.adf.getPageActivity());
        this.cTD.addView((View) this.fZT, 0, new ViewGroup.LayoutParams(-1, -1));
        this.fZU = (TbImageView) this.cTD.findViewById(d.g.ad_thumbnail);
        this.fZV = (ImageView) this.cTD.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.cTD.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.cTD.findViewById(d.g.ad_error_tips);
        this.fZV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.fZX = (ImageView) this.cTD.findViewById(d.g.play_icon);
        this.fZY = this.cTD.findViewById(d.g.replay);
        this.ewP = this.cTD.findViewById(d.g.card_layout_media_controller);
        this.fZW = this.cTD.findViewById(d.g.card_media_controller);
        return this.cTD;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.fZX.setOnClickListener(onClickListener);
        this.fZY.setOnClickListener(onClickListener);
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
        if (this.fZT != null && this.adf != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.fZS == null || this.fZS.getVideoInfo() == null || !TextUtils.equals(this.fZS.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.fZT.isDestroyed()) {
                if (this.fZT.isDestroyed()) {
                    this.cTD.removeView(this.fZT);
                    this.fZT = new CardGLTextureView(this.adf.getPageActivity());
                    this.cTD.addView((View) this.fZT, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.fZS = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().evM;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cuH);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().evN);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().evO);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().aWh;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().aWk);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fwj = builder.build(false);
                if (this.fwj != null && !an.isEmpty(this.fwj.video_url)) {
                    long bjG = (this.fZR == null || !this.fwj.video_url.equalsIgnoreCase(this.fZR.getVideoPath())) ? 0L : this.fZR.bjG();
                    this.fZR = new a(this);
                    if (bjG > 0) {
                        this.fZR.oG((int) bjG);
                    }
                    ViewGroup.LayoutParams layoutParams = this.cTD.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.af(getContext());
                        layoutParams.height = l.ah(getContext());
                        this.cTD.setLayoutParams(layoutParams);
                    }
                    this.fZU.startLoad(this.fwj.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().evQ) {
                        if (com.baidu.tieba.recapp.lego.a.a.D(this.adf.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ewP.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.adf.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.ewP.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ewP.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.adf.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.ewP.setLayoutParams(layoutParams3);
                        }
                        this.ewP.setVisibility(0);
                    } else {
                        this.ewP.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.fZT;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.fZV.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.fZX.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        this.fZV.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.fZU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.fZX.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midplay));
        this.fZV.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.fZU.setVisibility(8);
        this.fZW.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.fZX.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        gA(true);
        this.fZY.setVisibility(8);
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
        this.fZW.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.fZW.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.fZW.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fZW.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.fZW.Q(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.fZX.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
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
        this.fZU.setVisibility(0);
        this.fZV.setVisibility(0);
        this.fZW.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.fZX.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.fZV.setVisibility(0);
        this.fZU.setVisibility(0);
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
        if (this.fZR == null) {
            return false;
        }
        int playStatus = this.fZR.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.fZR == null) {
            return false;
        }
        return this.fZR.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.fZZ) {
            this.fZZ = false;
            if (!q.bro()) {
                return;
            }
        }
        if (this.fZS != null && this.fwj != null && this.fZR != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.fZR.startPlay(DistributeVrVideoCardView.this.fwj.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.fZR != null) {
            this.fZR.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.fZS == null || this.fwj == null) ? "" : this.fwj.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.fZR == null) {
            return 0L;
        }
        return this.fZR.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.fZR != null) {
                this.fZR.oG(0);
                this.fZR.destroy();
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
        if (this.fZT == null || this.fZT.isDestroyed()) {
            e(this.fZS);
        } else if (this.fZR != null) {
            this.fZR.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLb() {
        this.isBackground = true;
        super.aLb();
        if (this.fZR != null) {
            this.fZR.pausePlay();
            this.fZR.bjH();
        }
    }
}
