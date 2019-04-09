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
    private View bhM;
    private View buc;
    private VideoInfo hEp;
    private TbImageView ijM;
    private ImageView ijN;
    private View inA;
    private boolean inB;
    private DistributeVrPlayController inV;
    private GLTextureView inW;
    private TbImageView inX;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.buc = null;
        this.inB = false;
        this.mContext = null;
        this.inW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inB || DistributeVrVideoView.this.inA == null || DistributeVrVideoView.this.inA.getParent() != null) {
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
        this.buc = null;
        this.inB = false;
        this.mContext = null;
        this.inW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inB || DistributeVrVideoView.this.inA == null || DistributeVrVideoView.this.inA.getParent() != null) {
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
        this.buc = null;
        this.inB = false;
        this.mContext = null;
        this.inW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inB || DistributeVrVideoView.this.inA == null || DistributeVrVideoView.this.inA.getParent() != null) {
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
        this.buc = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.inW = this.buc.findViewById(d.g.ad_gl_view);
        this.ijM = (TbImageView) this.buc.findViewById(d.g.ad_thumbnail);
        this.ijN = (ImageView) this.buc.findViewById(d.g.ad_play_button);
        this.bhM = this.buc.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.buc.findViewById(d.g.ad_error_tips);
        this.inX = (TbImageView) this.buc.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.inW != null && tbPageContext != null && dVar != null && dVar.ekM != null && dVar.ekM.bwR != null) {
            this.hEp = dVar.ekM.bwR.bxj;
            if (this.hEp != null && !ap.isEmpty(this.hEp.video_url) && this.inV == null) {
                this.mPageContext = tbPageContext;
                this.inV = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.buc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.buc.setLayoutParams(layoutParams);
                }
                this.ijM.startLoad(this.hEp.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.ekM.bwR.bxl)) {
                    this.inX.startLoad(dVar.ekM.bwR.bxl, 10, false);
                } else {
                    this.inX.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.inX.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.ekM.bwR.bxm;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.inX.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.inW != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.hEp = gVar.videoInfo;
            if (this.hEp != null && !ap.isEmpty(this.hEp.video_url) && this.inV == null) {
                this.mPageContext = tbPageContext;
                this.inV = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.buc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.buc.setLayoutParams(layoutParams);
                }
                this.ijM.startLoad(this.hEp.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.bxl)) {
                    this.inX.startLoad(gVar.bxl, 10, false);
                } else {
                    this.inX.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.inX.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bxm;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.inX.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.inW;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhM.setVisibility(0);
        this.ijN.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.ijN.setVisibility(8);
        this.bhM.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ijM.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.ijN.setVisibility(8);
        this.bhM.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijM.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bhM.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijM.setVisibility(0);
        this.ijN.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bhM.setVisibility(8);
        this.ijN.setVisibility(0);
        this.ijM.setVisibility(0);
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
        if (this.inV == null) {
            return false;
        }
        int playStatus = this.inV.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.inV == null) {
            return false;
        }
        return this.inV.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bPt() && this.hEp != null && this.inV != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.inV.startPlay(this.hEp.video_url);
        }
    }

    private boolean bPt() {
        return q.bPt();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.inV != null) {
            this.inV.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hEp == null ? "" : this.hEp.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.inV == null) {
            return 0L;
        }
        return this.inV.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.inV != null) {
            this.inV.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.inV == null) {
            return -2;
        }
        return this.inV.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.inA = view;
            this.inB = true;
        }
    }
}
