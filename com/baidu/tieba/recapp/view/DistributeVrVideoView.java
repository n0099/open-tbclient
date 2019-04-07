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
import com.baidu.tbadk.core.util.ap;
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
    private View bhL;
    private View bub;
    private VideoInfo hEo;
    private TbImageView ijL;
    private ImageView ijM;
    private boolean inA;
    private DistributeVrPlayController inU;
    private GLTextureView inV;
    private TbImageView inW;
    private View inz;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.bub = null;
        this.inA = false;
        this.mContext = null;
        this.inV = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inA || DistributeVrVideoView.this.inz == null || DistributeVrVideoView.this.inz.getParent() != null) {
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
        this.bub = null;
        this.inA = false;
        this.mContext = null;
        this.inV = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inA || DistributeVrVideoView.this.inz == null || DistributeVrVideoView.this.inz.getParent() != null) {
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
        this.bub = null;
        this.inA = false;
        this.mContext = null;
        this.inV = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inA || DistributeVrVideoView.this.inz == null || DistributeVrVideoView.this.inz.getParent() != null) {
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
        this.bub = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.inV = this.bub.findViewById(d.g.ad_gl_view);
        this.ijL = (TbImageView) this.bub.findViewById(d.g.ad_thumbnail);
        this.ijM = (ImageView) this.bub.findViewById(d.g.ad_play_button);
        this.bhL = this.bub.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.bub.findViewById(d.g.ad_error_tips);
        this.inW = (TbImageView) this.bub.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.inV != null && tbPageContext != null && dVar != null && dVar.ekL != null && dVar.ekL.bwQ != null) {
            this.hEo = dVar.ekL.bwQ.bxi;
            if (this.hEo != null && !ap.isEmpty(this.hEo.video_url) && this.inU == null) {
                this.mPageContext = tbPageContext;
                this.inU = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.bub.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.bub.setLayoutParams(layoutParams);
                }
                this.ijL.startLoad(this.hEo.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.ekL.bwQ.bxk)) {
                    this.inW.startLoad(dVar.ekL.bwQ.bxk, 10, false);
                } else {
                    this.inW.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.inW.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.ekL.bwQ.bxl;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.inW.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.inV != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.hEo = gVar.videoInfo;
            if (this.hEo != null && !ap.isEmpty(this.hEo.video_url) && this.inU == null) {
                this.mPageContext = tbPageContext;
                this.inU = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.bub.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.bub.setLayoutParams(layoutParams);
                }
                this.ijL.startLoad(this.hEo.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.bxk)) {
                    this.inW.startLoad(gVar.bxk, 10, false);
                } else {
                    this.inW.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.inW.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bxl;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.inW.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.inV;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhL.setVisibility(0);
        this.ijM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.ijM.setVisibility(8);
        this.bhL.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ijL.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.ijM.setVisibility(8);
        this.bhL.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijL.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bhL.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijL.setVisibility(0);
        this.ijM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bhL.setVisibility(8);
        this.ijM.setVisibility(0);
        this.ijL.setVisibility(0);
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
        if (this.inU == null) {
            return false;
        }
        int playStatus = this.inU.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.inU == null) {
            return false;
        }
        return this.inU.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bPt() && this.hEo != null && this.inU != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.inU.startPlay(this.hEo.video_url);
        }
    }

    private boolean bPt() {
        return q.bPt();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.inU != null) {
            this.inU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hEo == null ? "" : this.hEo.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.inU == null) {
            return 0L;
        }
        return this.inU.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.inU != null) {
            this.inU.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.inU == null) {
            return -2;
        }
        return this.inU.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.inz = view;
            this.inA = true;
        }
    }
}
