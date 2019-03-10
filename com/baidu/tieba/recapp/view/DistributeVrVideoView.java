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
    private View bhH;
    private View btW;
    private VideoInfo hEI;
    private TbImageView ikg;
    private ImageView ikh;
    private View inW;
    private boolean inX;
    private DistributeVrPlayController ior;
    private GLTextureView ios;
    private TbImageView iot;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.btW = null;
        this.inX = false;
        this.mContext = null;
        this.ios = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inX || DistributeVrVideoView.this.inW == null || DistributeVrVideoView.this.inW.getParent() != null) {
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
        this.btW = null;
        this.inX = false;
        this.mContext = null;
        this.ios = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inX || DistributeVrVideoView.this.inW == null || DistributeVrVideoView.this.inW.getParent() != null) {
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
        this.btW = null;
        this.inX = false;
        this.mContext = null;
        this.ios = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inX || DistributeVrVideoView.this.inW == null || DistributeVrVideoView.this.inW.getParent() != null) {
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
        this.btW = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.ios = this.btW.findViewById(d.g.ad_gl_view);
        this.ikg = (TbImageView) this.btW.findViewById(d.g.ad_thumbnail);
        this.ikh = (ImageView) this.btW.findViewById(d.g.ad_play_button);
        this.bhH = this.btW.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.btW.findViewById(d.g.ad_error_tips);
        this.iot = (TbImageView) this.btW.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.ios != null && tbPageContext != null && dVar != null && dVar.eld != null && dVar.eld.bwL != null) {
            this.hEI = dVar.eld.bwL.bxd;
            if (this.hEI != null && !ap.isEmpty(this.hEI.video_url) && this.ior == null) {
                this.mPageContext = tbPageContext;
                this.ior = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.btW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.btW.setLayoutParams(layoutParams);
                }
                this.ikg.startLoad(this.hEI.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.eld.bwL.bxf)) {
                    this.iot.startLoad(dVar.eld.bwL.bxf, 10, false);
                } else {
                    this.iot.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iot.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.eld.bwL.bxg;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iot.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.ios != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.hEI = gVar.videoInfo;
            if (this.hEI != null && !ap.isEmpty(this.hEI.video_url) && this.ior == null) {
                this.mPageContext = tbPageContext;
                this.ior = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.btW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.btW.setLayoutParams(layoutParams);
                }
                this.ikg.startLoad(this.hEI.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.bxf)) {
                    this.iot.startLoad(gVar.bxf, 10, false);
                } else {
                    this.iot.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iot.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bxg;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iot.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.ios;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhH.setVisibility(0);
        this.ikh.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.ikh.setVisibility(8);
        this.bhH.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ikg.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.ikh.setVisibility(8);
        this.bhH.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ikg.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bhH.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ikg.setVisibility(0);
        this.ikh.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bhH.setVisibility(8);
        this.ikh.setVisibility(0);
        this.ikg.setVisibility(0);
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
        if (this.ior == null) {
            return false;
        }
        int playStatus = this.ior.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.ior == null) {
            return false;
        }
        return this.ior.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bPu() && this.hEI != null && this.ior != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.ior.startPlay(this.hEI.video_url);
        }
    }

    private boolean bPu() {
        return q.bPu();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.ior != null) {
            this.ior.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hEI == null ? "" : this.hEI.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.ior == null) {
            return 0L;
        }
        return this.ior.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.ior != null) {
            this.ior.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.ior == null) {
            return -2;
        }
        return this.ior.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.inW = view;
            this.inX = true;
        }
    }
}
