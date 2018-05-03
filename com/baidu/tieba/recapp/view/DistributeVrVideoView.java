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
    private View Tl;
    private TbImageView fZU;
    private ImageView fZV;
    private VideoInfo fwj;
    private View gdB;
    private boolean gdC;
    private DistributeVrPlayController gdW;
    private GLTextureView gdX;
    private TbImageView gdY;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.Tl = null;
        this.gdC = false;
        this.mContext = null;
        this.gdX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gdC || DistributeVrVideoView.this.gdB == null || DistributeVrVideoView.this.gdB.getParent() != null) {
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
        this.Tl = null;
        this.gdC = false;
        this.mContext = null;
        this.gdX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gdC || DistributeVrVideoView.this.gdB == null || DistributeVrVideoView.this.gdB.getParent() != null) {
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
        this.Tl = null;
        this.gdC = false;
        this.mContext = null;
        this.gdX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gdC || DistributeVrVideoView.this.gdB == null || DistributeVrVideoView.this.gdB.getParent() != null) {
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
        this.Tl = LayoutInflater.from(context).inflate(d.i.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gdX = this.Tl.findViewById(d.g.ad_gl_view);
        this.fZU = (TbImageView) this.Tl.findViewById(d.g.ad_thumbnail);
        this.fZV = (ImageView) this.Tl.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.Tl.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.Tl.findViewById(d.g.ad_error_tips);
        this.gdY = (TbImageView) this.Tl.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gdX != null && tbPageContext != null && dVar != null && dVar.crF != null && dVar.crF.Wb != null) {
            this.fwj = dVar.crF.Wb.Ws;
            if (this.fwj != null && !an.isEmpty(this.fwj.video_url) && this.gdW == null) {
                this.mPageContext = tbPageContext;
                this.gdW = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.Tl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.af(this.mContext) - l.e(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.Tl.setLayoutParams(layoutParams);
                }
                this.fZU.startLoad(this.fwj.thumbnail_url, 10, false);
                if (!an.isEmpty(dVar.crF.Wb.Wu)) {
                    this.gdY.startLoad(dVar.crF.Wb.Wu, 10, false);
                } else {
                    this.gdY.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gdY.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.crF.Wb.Wv;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gdY.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gdX != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fwj = gVar.videoInfo;
            if (this.fwj != null && !an.isEmpty(this.fwj.video_url) && this.gdW == null) {
                this.mPageContext = tbPageContext;
                this.gdW = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.Tl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.Tl.setLayoutParams(layoutParams);
                }
                this.fZU.startLoad(this.fwj.thumbnail_url, 10, false);
                if (!an.isEmpty(gVar.Wu)) {
                    this.gdY.startLoad(gVar.Wu, 10, false);
                } else {
                    this.gdY.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gdY.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.Wv;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gdY.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gdX;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.fZV.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.fZV.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.fZU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.fZV.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.fZU.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.fZU.setVisibility(0);
        this.fZV.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
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
        if (this.gdW == null) {
            return false;
        }
        int playStatus = this.gdW.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gdW == null) {
            return false;
        }
        return this.gdW.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bcI() && this.fwj != null && this.gdW != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.gdW.startPlay(this.fwj.video_url);
        }
    }

    private boolean bcI() {
        return q.bcI();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gdW != null) {
            this.gdW.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fwj == null ? "" : this.fwj.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gdW == null) {
            return 0L;
        }
        return this.gdW.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.gdW != null) {
            this.gdW.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gdW == null) {
            return -2;
        }
        return this.gdW.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view2) {
        if (view2 != null) {
            this.gdB = view2;
            this.gdC = true;
        }
    }
}
