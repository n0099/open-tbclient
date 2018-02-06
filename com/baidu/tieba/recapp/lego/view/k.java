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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.v;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.view.IVrPlayView;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.lego.card.e.b<DistributeVrVideoCard> implements com.baidu.tieba.recapp.i, IVrPlayView {
    private RelativeLayout dBd;
    private View dtR;
    private View fcj;
    private j gFg;
    DistributeVrVideoCard gFh;
    private h gFi;
    private TbImageView gFj;
    private ImageView gFk;
    private VideoListMediaControllerView gFl;
    private ImageView gFm;
    private View gFn;
    private boolean gFo;
    private VideoInfo gbY;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public k(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dBd = null;
        this.gFi = null;
        this.isBackground = false;
        this.gFo = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (k.this.aRR != null && k.this.aRR.getPageActivity() != null && !k.this.aRR.getPageActivity().isFinishing()) {
                            if (k.this.gFi == null || k.this.gFi.isDestroyed()) {
                                k.this.mHandler.removeMessages(30001);
                                if (k.this.gFg != null) {
                                    k.this.gFg.destroy();
                                    return;
                                }
                                return;
                            }
                            if (k.this.gFh.getPage() <= 0) {
                                if (k.this.fbx != null && (viewGroup = (ViewGroup) k.this.fbx.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.p(k.this.aRR.getPageActivity())) {
                                        if (k.this.gFg != null) {
                                            k.this.gFg.pausePlay();
                                        }
                                    } else if (k.this.gFg != null && !k.this.isBackground) {
                                        k.this.gFg.continuePlay();
                                    }
                                }
                            } else if (com.baidu.tieba.lego.card.d.b.fbw == k.this.gFh.getPage()) {
                                if (k.this.gFg != null && !k.this.isBackground) {
                                    k.this.gFg.continuePlay();
                                }
                            } else if (k.this.gFg != null) {
                                k.this.gFg.pausePlay();
                            }
                            k.this.mHandler.removeMessages(30001);
                            k.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        k.this.release();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPT() {
        this.dBd = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gFi = new h(this.aRR.getPageActivity());
        this.dBd.addView((View) this.gFi, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gFj = (TbImageView) this.dBd.findViewById(d.g.ad_thumbnail);
        this.gFk = (ImageView) this.dBd.findViewById(d.g.ad_play_button);
        this.dtR = this.dBd.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dBd.findViewById(d.g.ad_error_tips);
        this.gFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.startPlay();
            }
        });
        this.gFm = (ImageView) this.dBd.findViewById(d.g.play_icon);
        this.gFn = this.dBd.findViewById(d.g.replay);
        this.fcj = this.dBd.findViewById(d.g.card_layout_media_controller);
        this.gFl = this.dBd.findViewById(d.g.card_media_controller);
        return this.dBd;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gFm.setOnClickListener(onClickListener);
        this.gFn.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(DistributeVrVideoCard distributeVrVideoCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: a */
    public void e(DistributeVrVideoCard distributeVrVideoCard) {
        if (this.gFi != null && this.aRR != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gFh == null || this.gFh.getVideoInfo() == null || !TextUtils.equals(this.gFh.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gFi.isDestroyed()) {
                if (this.gFi.isDestroyed()) {
                    this.dBd.removeView(this.gFi);
                    this.gFi = new h(this.aRR.getPageActivity());
                    this.dBd.addView((View) this.gFi, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gFh = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().fbf;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().dda);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fbg);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fbh);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bLD;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bLG);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gbY = builder.build(false);
                if (this.gbY != null && !am.isEmpty(this.gbY.video_url)) {
                    long boA = (this.gFg == null || !this.gbY.video_url.equalsIgnoreCase(this.gFg.getVideoPath())) ? 0L : this.gFg.boA();
                    this.gFg = new j(this);
                    if (boA > 0) {
                        this.gFg.rk((int) boA);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dBd.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ao(getContext());
                        layoutParams.height = l.aq(getContext());
                        this.dBd.setLayoutParams(layoutParams);
                    }
                    this.gFj.startLoad(this.gbY.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().fbj) {
                        if (com.baidu.tieba.recapp.lego.a.a.B(this.aRR.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fcj.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.aRR.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.fcj.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fcj.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.aRR.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.fcj.setLayoutParams(layoutParams3);
                        }
                        this.fcj.setVisibility(0);
                    } else {
                        this.fcj.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gFi;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dtR.setVisibility(0);
        this.gFk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gFm.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_video_midpause));
        this.gFk.setVisibility(8);
        this.dtR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gFj.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gFm.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_video_midplay));
        this.gFk.setVisibility(8);
        this.dtR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFj.setVisibility(8);
        this.gFl.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gFm.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_video_midpause));
        gU(true);
        this.gFn.setVisibility(8);
    }

    public void gU(boolean z) {
        if (z) {
            this.dtR.setVisibility(0);
        } else {
            this.dtR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gFl.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(v.b bVar) {
        this.gFl.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(v.a aVar) {
        this.gFl.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gFl.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gFl.aU(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gFm.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_video_midpause));
        gU(false);
        lX(false);
    }

    public void lX(boolean z) {
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
        this.dtR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFj.setVisibility(0);
        this.gFk.setVisibility(0);
        this.gFl.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gFm.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.dtR.setVisibility(8);
        this.gFk.setVisibility(0);
        this.gFj.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.aRR;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.gFg == null) {
            return false;
        }
        int playStatus = this.gFg.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gFg == null) {
            return false;
        }
        return this.gFg.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gFo) {
            this.gFo = false;
            if (!q.bwk()) {
                return;
            }
        }
        if (this.gFh != null && this.gbY != null && this.gFg != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.k.3
                @Override // java.lang.Runnable
                public void run() {
                    k.this.gFg.startPlay(k.this.gbY.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gFg != null) {
            this.gFg.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gFh == null || this.gbY == null) ? "" : this.gbY.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gFg == null) {
            return 0L;
        }
        return this.gFg.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.gFg != null) {
                this.gFg.rk(0);
                this.gFg.destroy();
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

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQc() {
        this.isBackground = false;
        super.aQc();
        if (this.gFi == null || this.gFi.isDestroyed()) {
            e(this.gFh);
        } else if (this.gFg != null) {
            this.gFg.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQb() {
        this.isBackground = true;
        super.aQb();
        if (this.gFg != null) {
            this.gFg.pausePlay();
            this.gFg.boB();
        }
    }
}
