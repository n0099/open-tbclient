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
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.lego.card.e.b<DistributeVrVideoCard> implements com.baidu.tieba.recapp.i, IVrPlayView {
    private RelativeLayout dAU;
    private View dtI;
    private View fcl;
    private j gFh;
    DistributeVrVideoCard gFi;
    private h gFj;
    private TbImageView gFk;
    private ImageView gFl;
    private VideoListMediaControllerView gFm;
    private ImageView gFn;
    private View gFo;
    private boolean gFp;
    private VideoInfo gcd;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public k(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dAU = null;
        this.gFj = null;
        this.isBackground = false;
        this.gFp = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (k.this.aRI != null && k.this.aRI.getPageActivity() != null && !k.this.aRI.getPageActivity().isFinishing()) {
                            if (k.this.gFj == null || k.this.gFj.isDestroyed()) {
                                k.this.mHandler.removeMessages(30001);
                                if (k.this.gFh != null) {
                                    k.this.gFh.destroy();
                                    return;
                                }
                                return;
                            }
                            if (k.this.gFi.getPage() <= 0) {
                                if (k.this.fbz != null && (viewGroup = (ViewGroup) k.this.fbz.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.p(k.this.aRI.getPageActivity())) {
                                        if (k.this.gFh != null) {
                                            k.this.gFh.pausePlay();
                                        }
                                    } else if (k.this.gFh != null && !k.this.isBackground) {
                                        k.this.gFh.continuePlay();
                                    }
                                }
                            } else if (com.baidu.tieba.lego.card.d.b.fby == k.this.gFi.getPage()) {
                                if (k.this.gFh != null && !k.this.isBackground) {
                                    k.this.gFh.continuePlay();
                                }
                            } else if (k.this.gFh != null) {
                                k.this.gFh.pausePlay();
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
        this.dAU = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gFj = new h(this.aRI.getPageActivity());
        this.dAU.addView((View) this.gFj, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gFk = (TbImageView) this.dAU.findViewById(d.g.ad_thumbnail);
        this.gFl = (ImageView) this.dAU.findViewById(d.g.ad_play_button);
        this.dtI = this.dAU.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dAU.findViewById(d.g.ad_error_tips);
        this.gFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.startPlay();
            }
        });
        this.gFn = (ImageView) this.dAU.findViewById(d.g.play_icon);
        this.gFo = this.dAU.findViewById(d.g.replay);
        this.fcl = this.dAU.findViewById(d.g.card_layout_media_controller);
        this.gFm = this.dAU.findViewById(d.g.card_media_controller);
        return this.dAU;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gFn.setOnClickListener(onClickListener);
        this.gFo.setOnClickListener(onClickListener);
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
        if (this.gFj != null && this.aRI != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gFi == null || this.gFi.getVideoInfo() == null || !TextUtils.equals(this.gFi.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gFj.isDestroyed()) {
                if (this.gFj.isDestroyed()) {
                    this.dAU.removeView(this.gFj);
                    this.gFj = new h(this.aRI.getPageActivity());
                    this.dAU.addView((View) this.gFj, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gFi = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().fbh;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().dcR);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fbi);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().fbj);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bLt;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bLw);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gcd = builder.build(false);
                if (this.gcd != null && !am.isEmpty(this.gcd.video_url)) {
                    long boA = (this.gFh == null || !this.gcd.video_url.equalsIgnoreCase(this.gFh.getVideoPath())) ? 0L : this.gFh.boA();
                    this.gFh = new j(this);
                    if (boA > 0) {
                        this.gFh.rl((int) boA);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dAU.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ao(getContext());
                        layoutParams.height = l.aq(getContext());
                        this.dAU.setLayoutParams(layoutParams);
                    }
                    this.gFk.startLoad(this.gcd.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().fbl) {
                        if (com.baidu.tieba.recapp.lego.a.a.B(this.aRI.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fcl.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.aRI.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.fcl.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fcl.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.aRI.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.fcl.setLayoutParams(layoutParams3);
                        }
                        this.fcl.setVisibility(0);
                    } else {
                        this.fcl.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gFj;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dtI.setVisibility(0);
        this.gFl.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gFn.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_video_midpause));
        this.gFl.setVisibility(8);
        this.dtI.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gFk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gFn.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_video_midplay));
        this.gFl.setVisibility(8);
        this.dtI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFk.setVisibility(8);
        this.gFm.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gFn.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_video_midpause));
        gZ(true);
        this.gFo.setVisibility(8);
    }

    public void gZ(boolean z) {
        if (z) {
            this.dtI.setVisibility(0);
        } else {
            this.dtI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gFm.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(v.b bVar) {
        this.gFm.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(v.a aVar) {
        this.gFm.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gFm.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gFm.aU(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gFn.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_video_midpause));
        gZ(false);
        mc(false);
    }

    public void mc(boolean z) {
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
        this.dtI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFk.setVisibility(0);
        this.gFl.setVisibility(0);
        this.gFm.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gFn.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.dtI.setVisibility(8);
        this.gFl.setVisibility(0);
        this.gFk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.aRI;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.gFh == null) {
            return false;
        }
        int playStatus = this.gFh.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gFh == null) {
            return false;
        }
        return this.gFh.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gFp) {
            this.gFp = false;
            if (!r.bwo()) {
                return;
            }
        }
        if (this.gFi != null && this.gcd != null && this.gFh != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.k.3
                @Override // java.lang.Runnable
                public void run() {
                    k.this.gFh.startPlay(k.this.gcd.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gFh != null) {
            this.gFh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gFi == null || this.gcd == null) ? "" : this.gcd.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gFh == null) {
            return 0L;
        }
        return this.gFh.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.gFh != null) {
                this.gFh.rl(0);
                this.gFh.destroy();
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
        if (this.gFj == null || this.gFj.isDestroyed()) {
            e(this.gFi);
        } else if (this.gFh != null) {
            this.gFh.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQb() {
        this.isBackground = true;
        super.aQb();
        if (this.gFh != null) {
            this.gFh.pausePlay();
            this.gFh.boB();
        }
    }
}
