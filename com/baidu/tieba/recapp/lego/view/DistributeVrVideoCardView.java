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
import com.baidu.adp.lib.f.e;
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
/* loaded from: classes10.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private ImageView NR;
    private View csn;
    private View hTH;
    private VideoInfo iSv;
    private boolean isBackground;
    private a jEJ;
    DistributeVrVideoCard jEK;
    private CardGLTextureView jEL;
    private TbImageView jEM;
    private ImageView jEN;
    private VideoListMediaControllerView jEO;
    private View jEP;
    private boolean jEQ;
    private TextView mErrorTip;
    private Handler mHandler;
    private RelativeLayout mRoot;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRoot = null;
        this.jEL = null;
        this.isBackground = false;
        this.jEQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cQU != null && DistributeVrVideoCardView.this.cQU.getPageActivity() != null && !DistributeVrVideoCardView.this.cQU.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.jEL == null || DistributeVrVideoCardView.this.jEL.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.jEJ != null) {
                                    DistributeVrVideoCardView.this.jEJ.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.jEK.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hSV != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hSV.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cQU.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.jEJ != null) {
                                            DistributeVrVideoCardView.this.jEJ.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.jEJ != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.jEJ.continuePlay();
                                    }
                                }
                            } else if (b.hSU == DistributeVrVideoCardView.this.jEK.getPage()) {
                                if (DistributeVrVideoCardView.this.jEJ != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.jEJ.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.jEJ != null) {
                                DistributeVrVideoCardView.this.jEJ.pausePlay();
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
    protected View bZt() {
        this.mRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.jEL = new CardGLTextureView(this.cQU.getPageActivity());
        this.mRoot.addView((View) this.jEL, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jEM = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jEN = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.csn = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jEN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.NR = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.jEP = this.mRoot.findViewById(R.id.replay);
        this.hTH = this.mRoot.findViewById(R.id.card_layout_media_controller);
        this.jEO = this.mRoot.findViewById(R.id.card_media_controller);
        return this.mRoot;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.NR.setOnClickListener(onClickListener);
        this.jEP.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(DistributeVrVideoCard distributeVrVideoCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(DistributeVrVideoCard distributeVrVideoCard) {
        if (this.jEL != null && this.cQU != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.jEK == null || this.jEK.getVideoInfo() == null || !TextUtils.equals(this.jEK.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.jEL.isDestroyed()) {
                if (this.jEL.isDestroyed()) {
                    this.mRoot.removeView(this.jEL);
                    this.jEL = new CardGLTextureView(this.cQU.getPageActivity());
                    this.mRoot.addView((View) this.jEL, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.jEK = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hSF;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoLength);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbWidth);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().thumbHeight);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().aXb);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iSv = builder.build(false);
                if (this.iSv != null && !aq.isEmpty(this.iSv.video_url)) {
                    long cAl = (this.jEJ == null || !this.iSv.video_url.equalsIgnoreCase(this.jEJ.getVideoPath())) ? 0L : this.jEJ.cAl();
                    this.jEJ = new a(this);
                    if (cAl > 0) {
                        this.jEJ.xs((int) cAl);
                    }
                    ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.mRoot.setLayoutParams(layoutParams);
                    }
                    this.jEM.startLoad(this.iSv.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hSH) {
                        if (com.baidu.tieba.recapp.lego.a.a.ao(this.cQU.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hTH.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cQU.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hTH.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hTH.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cQU.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hTH.setLayoutParams(layoutParams3);
                        }
                        this.hTH.setVisibility(0);
                    } else {
                        this.hTH.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jEL;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.csn.setVisibility(0);
        this.jEN.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.NR.setImageDrawable(this.cQU.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.jEN.setVisibility(8);
        this.csn.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jEM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.NR.setImageDrawable(this.cQU.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.jEN.setVisibility(8);
        this.csn.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jEM.setVisibility(8);
        this.jEO.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.NR.setImageDrawable(this.cQU.getResources().getDrawable(R.drawable.icon_video_midpause));
        eA(true);
        this.jEP.setVisibility(8);
    }

    public void eA(boolean z) {
        if (z) {
            this.csn.setVisibility(0);
        } else {
            this.csn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.jEO.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.jEO.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.jEO.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.jEO.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.jEO.aV(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.NR.setImageDrawable(this.cQU.getResources().getDrawable(R.drawable.icon_video_midpause));
        eA(false);
        rK(false);
    }

    public void rK(boolean z) {
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
        this.csn.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jEM.setVisibility(0);
        this.jEN.setVisibility(0);
        this.jEO.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.NR.setImageDrawable(this.cQU.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.csn.setVisibility(8);
        this.jEN.setVisibility(0);
        this.jEM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cQU;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.jEJ == null) {
            return false;
        }
        int playStatus = this.jEJ.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jEJ == null) {
            return false;
        }
        return this.jEJ.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.jEQ) {
            this.jEQ = false;
            if (!s.cHH()) {
                return;
            }
        }
        if (this.jEK != null && this.iSv != null && this.jEJ != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.jEJ.startPlay(DistributeVrVideoCardView.this.iSv.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jEJ != null) {
            this.jEJ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.jEK == null || this.iSv == null) ? "" : this.iSv.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jEJ == null) {
            return 0L;
        }
        return this.jEJ.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.jEJ != null) {
                this.jEJ.xs(0);
                this.jEJ.destroy();
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
    public void bMW() {
        this.isBackground = false;
        super.bMW();
        if (this.jEL == null || this.jEL.isDestroyed()) {
            d(this.jEK);
        } else if (this.jEJ != null) {
            this.jEJ.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aig() {
        this.isBackground = true;
        super.aig();
        if (this.jEJ != null) {
            this.jEJ.pausePlay();
            this.jEJ.cAm();
        }
    }
}
