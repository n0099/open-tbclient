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
    private ImageView IG;
    private View bHO;
    private RelativeLayout fru;
    private View hgu;
    private a iLj;
    DistributeVrVideoCard iLk;
    private CardGLTextureView iLl;
    private TbImageView iLm;
    private ImageView iLn;
    private VideoListMediaControllerView iLo;
    private View iLp;
    private boolean iLq;
    private VideoInfo iep;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fru = null;
        this.iLl = null;
        this.isBackground = false;
        this.iLq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.cfl != null && DistributeVrVideoCardView.this.cfl.getPageActivity() != null && !DistributeVrVideoCardView.this.cfl.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.iLl == null || DistributeVrVideoCardView.this.iLl.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.iLj != null) {
                                    DistributeVrVideoCardView.this.iLj.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.iLk.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.hfI != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.hfI.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.getStatusBarHeight(DistributeVrVideoCardView.this.cfl.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.iLj != null) {
                                            DistributeVrVideoCardView.this.iLj.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.iLj != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.iLj.continuePlay();
                                    }
                                }
                            } else if (b.hfH == DistributeVrVideoCardView.this.iLk.getPage()) {
                                if (DistributeVrVideoCardView.this.iLj != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.iLj.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.iLj != null) {
                                DistributeVrVideoCardView.this.iLj.pausePlay();
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
    protected View bIg() {
        this.fru = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_distribute_vr_video_view, (ViewGroup) null);
        this.iLl = new CardGLTextureView(this.cfl.getPageActivity());
        this.fru.addView((View) this.iLl, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iLm = (TbImageView) this.fru.findViewById(R.id.ad_thumbnail);
        this.iLn = (ImageView) this.fru.findViewById(R.id.ad_play_button);
        this.bHO = this.fru.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.fru.findViewById(R.id.ad_error_tips);
        this.iLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.IG = (ImageView) this.fru.findViewById(R.id.play_icon);
        this.iLp = this.fru.findViewById(R.id.replay);
        this.hgu = this.fru.findViewById(R.id.card_layout_media_controller);
        this.iLo = this.fru.findViewById(R.id.card_media_controller);
        return this.fru;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.IG.setOnClickListener(onClickListener);
        this.iLp.setOnClickListener(onClickListener);
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
        if (this.iLl != null && this.cfl != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.iLk == null || this.iLk.getVideoInfo() == null || !TextUtils.equals(this.iLk.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.iLl.isDestroyed()) {
                if (this.iLl.isDestroyed()) {
                    this.fru.removeView(this.iLl);
                    this.iLl = new CardGLTextureView(this.cfl.getPageActivity());
                    this.fru.addView((View) this.iLl, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.iLk = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().hfq;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eTc);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().hfr);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().hfs);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cXa);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.iep = builder.build(false);
                if (this.iep != null && !aq.isEmpty(this.iep.video_url)) {
                    long cgj = (this.iLj == null || !this.iep.video_url.equalsIgnoreCase(this.iLj.getVideoPath())) ? 0L : this.iLj.cgj();
                    this.iLj = new a(this);
                    if (cgj > 0) {
                        this.iLj.vr((int) cgj);
                    }
                    ViewGroup.LayoutParams layoutParams = this.fru.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.getEquipmentWidth(getContext());
                        layoutParams.height = l.getEquipmentHeight(getContext());
                        this.fru.setLayoutParams(layoutParams);
                    }
                    this.iLm.startLoad(this.iep.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().hfu) {
                        if (com.baidu.tieba.recapp.lego.a.a.aj(this.cfl.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hgu.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.cfl.getResources().getDimension(R.dimen.ds32) + 0.5f);
                            this.hgu.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hgu.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.cfl.getResources().getDimension(R.dimen.ds30) + 0.5f);
                            this.hgu.setLayoutParams(layoutParams3);
                        }
                        this.hgu.setVisibility(0);
                    } else {
                        this.hgu.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iLl;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bHO.setVisibility(0);
        this.iLn.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.IG.setImageDrawable(this.cfl.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.iLn.setVisibility(8);
        this.bHO.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iLm.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.IG.setImageDrawable(this.cfl.getResources().getDrawable(R.drawable.icon_video_midplay));
        this.iLn.setVisibility(8);
        this.bHO.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iLm.setVisibility(8);
        this.iLo.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.IG.setImageDrawable(this.cfl.getResources().getDrawable(R.drawable.icon_video_midpause));
        dp(true);
        this.iLp.setVisibility(8);
    }

    public void dp(boolean z) {
        if (z) {
            this.bHO.setVisibility(0);
        } else {
            this.bHO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iLo.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iLo.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iLo.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iLo.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iLo.aD(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.IG.setImageDrawable(this.cfl.getResources().getDrawable(R.drawable.icon_video_midpause));
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
        this.bHO.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iLm.setVisibility(0);
        this.iLn.setVisibility(0);
        this.iLo.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.IG.setImageDrawable(this.cfl.getResources().getDrawable(R.drawable.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bHO.setVisibility(8);
        this.iLn.setVisibility(0);
        this.iLm.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.cfl;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.iLj == null) {
            return false;
        }
        int playStatus = this.iLj.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iLj == null) {
            return false;
        }
        return this.iLj.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.iLq) {
            this.iLq = false;
            if (!s.cnE()) {
                return;
            }
        }
        if (this.iLk != null && this.iep != null && this.iLj != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.iLj.startPlay(DistributeVrVideoCardView.this.iep.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iLj != null) {
            this.iLj.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.iLk == null || this.iep == null) ? "" : this.iep.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iLj == null) {
            return 0L;
        }
        return this.iLj.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.iLj != null) {
                this.iLj.vr(0);
                this.iLj.destroy();
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
    public void bIm() {
        this.isBackground = false;
        super.bIm();
        if (this.iLl == null || this.iLl.isDestroyed()) {
            e(this.iLk);
        } else if (this.iLj != null) {
            this.iLj.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void VH() {
        this.isBackground = true;
        super.VH();
        if (this.iLj != null) {
            this.iLj.pausePlay();
            this.iLj.cgk();
        }
    }
}
