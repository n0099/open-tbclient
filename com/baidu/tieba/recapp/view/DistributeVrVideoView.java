package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View Th;
    private VideoInfo fxp;
    private TbImageView gba;
    private ImageView gbb;
    private View geI;
    private boolean geJ;
    private DistributeVrPlayController gfd;
    private GLTextureView gfe;
    private TbImageView gff;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.Th = null;
        this.geJ = false;
        this.mContext = null;
        this.gfe = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.geJ || DistributeVrVideoView.this.geI == null || DistributeVrVideoView.this.geI.getParent() != null) {
                            DistributeVrVideoView.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        } else {
                            DistributeVrVideoView.this.stopPlay();
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public DistributeVrVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Th = null;
        this.geJ = false;
        this.mContext = null;
        this.gfe = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.geJ || DistributeVrVideoView.this.geI == null || DistributeVrVideoView.this.geI.getParent() != null) {
                            DistributeVrVideoView.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        } else {
                            DistributeVrVideoView.this.stopPlay();
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public DistributeVrVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Th = null;
        this.geJ = false;
        this.mContext = null;
        this.gfe = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.geJ || DistributeVrVideoView.this.geI == null || DistributeVrVideoView.this.geI.getParent() != null) {
                            DistributeVrVideoView.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        } else {
                            DistributeVrVideoView.this.stopPlay();
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Th = LayoutInflater.from(context).inflate(d.i.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gfe = this.Th.findViewById(d.g.ad_gl_view);
        this.gba = (TbImageView) this.Th.findViewById(d.g.ad_thumbnail);
        this.gbb = (ImageView) this.Th.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.Th.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.Th.findViewById(d.g.ad_error_tips);
        this.gff = (TbImageView) this.Th.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gfe != null && tbPageContext != null && dVar != null && dVar.csO != null && dVar.csO.VX != null) {
            this.fxp = dVar.csO.VX.Wo;
            if (this.fxp != null && !an.isEmpty(this.fxp.video_url) && this.gfd == null) {
                this.mPageContext = tbPageContext;
                this.gfd = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.Th.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.af(this.mContext) - l.e(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.Th.setLayoutParams(layoutParams);
                }
                this.gba.startLoad(this.fxp.thumbnail_url, 10, false);
                if (!an.isEmpty(dVar.csO.VX.Wq)) {
                    this.gff.startLoad(dVar.csO.VX.Wq, 10, false);
                } else {
                    this.gff.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gff.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.csO.VX.Wr;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gff.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gfe != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fxp = gVar.videoInfo;
            if (this.fxp != null && !an.isEmpty(this.fxp.video_url) && this.gfd == null) {
                this.mPageContext = tbPageContext;
                this.gfd = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.Th.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.Th.setLayoutParams(layoutParams);
                }
                this.gba.startLoad(this.fxp.thumbnail_url, 10, false);
                if (!an.isEmpty(gVar.Wq)) {
                    this.gff.startLoad(gVar.Wq, 10, false);
                } else {
                    this.gff.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gff.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.Wr;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gff.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gfe;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gbb.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gbb.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gba.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gbb.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gba.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gba.setVisibility(0);
        this.gbb.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gbb.setVisibility(0);
        this.gba.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void showPanoramaPrompt() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public TbPageContext<?> getPageContext() {
        return this.mPageContext;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.gfd == null) {
            return false;
        }
        int playStatus = this.gfd.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gfd == null) {
            return false;
        }
        return this.gfd.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bcI() && this.fxp != null && this.gfd != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.gfd.startPlay(this.fxp.video_url);
        }
    }

    private boolean bcI() {
        return q.bcI();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gfd != null) {
            this.gfd.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fxp == null ? "" : this.fxp.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gfd == null) {
            return 0L;
        }
        return this.gfd.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.gfd != null) {
            this.gfd.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gfd == null) {
            return -2;
        }
        return this.gfd.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view2) {
        if (view2 != null) {
            this.geI = view2;
            this.geJ = true;
        }
    }
}
