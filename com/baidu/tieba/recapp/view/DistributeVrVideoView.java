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
import com.baidu.ar.base.MsgField;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.d;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View ajk;
    private TbImageView gHQ;
    private ImageView gHR;
    private boolean gLA;
    private DistributeVrPlayController gLU;
    private GLTextureView gLV;
    private TbImageView gLW;
    private View gLz;
    private VideoInfo gdK;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.ajk = null;
        this.gLA = false;
        this.mContext = null;
        this.gLV = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gLA || DistributeVrVideoView.this.gLz == null || DistributeVrVideoView.this.gLz.getParent() != null) {
                            DistributeVrVideoView.this.mHandler.sendEmptyMessageDelayed(MsgField.IMSG_DEVICE_NOT_SUPPORT, TimeUnit.SECONDS.toMillis(1L));
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
        this.ajk = null;
        this.gLA = false;
        this.mContext = null;
        this.gLV = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gLA || DistributeVrVideoView.this.gLz == null || DistributeVrVideoView.this.gLz.getParent() != null) {
                            DistributeVrVideoView.this.mHandler.sendEmptyMessageDelayed(MsgField.IMSG_DEVICE_NOT_SUPPORT, TimeUnit.SECONDS.toMillis(1L));
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
        this.ajk = null;
        this.gLA = false;
        this.mContext = null;
        this.gLV = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gLA || DistributeVrVideoView.this.gLz == null || DistributeVrVideoView.this.gLz.getParent() != null) {
                            DistributeVrVideoView.this.mHandler.sendEmptyMessageDelayed(MsgField.IMSG_DEVICE_NOT_SUPPORT, TimeUnit.SECONDS.toMillis(1L));
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
        this.ajk = LayoutInflater.from(context).inflate(e.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gLV = this.ajk.findViewById(e.g.ad_gl_view);
        this.gHQ = (TbImageView) this.ajk.findViewById(e.g.ad_thumbnail);
        this.gHR = (ImageView) this.ajk.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.ajk.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.ajk.findViewById(e.g.ad_error_tips);
        this.gLW = (TbImageView) this.ajk.findViewById(e.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gLV != null && tbPageContext != null && dVar != null && dVar.cRg != null && dVar.cRg.ama != null) {
            this.gdK = dVar.cRg.ama.ams;
            if (this.gdK != null && !ao.isEmpty(this.gdK.video_url) && this.gLU == null) {
                this.mPageContext = tbPageContext;
                this.gLU = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.ajk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, e.C0200e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.ajk.setLayoutParams(layoutParams);
                }
                this.gHQ.startLoad(this.gdK.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.cRg.ama.amu)) {
                    this.gLW.startLoad(dVar.cRg.ama.amu, 10, false);
                } else {
                    this.gLW.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gLW.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cRg.ama.amv;
                    layoutParams2.height = l.h(this.mContext, e.C0200e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gLW.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gLV != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.gdK = gVar.videoInfo;
            if (this.gdK != null && !ao.isEmpty(this.gdK.video_url) && this.gLU == null) {
                this.mPageContext = tbPageContext;
                this.gLU = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.ajk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.ajk.setLayoutParams(layoutParams);
                }
                this.gHQ.startLoad(this.gdK.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.amu)) {
                    this.gLW.startLoad(gVar.amu, 10, false);
                } else {
                    this.gLW.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gLW.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.amv;
                    layoutParams2.height = l.h(this.mContext, e.C0200e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gLW.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gLV;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gHR.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gHR.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gHQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gHR.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gHQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gHQ.setVisibility(0);
        this.gHR.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gHR.setVisibility(0);
        this.gHQ.setVisibility(0);
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
        if (this.gLU == null) {
            return false;
        }
        int playStatus = this.gLU.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gLU == null) {
            return false;
        }
        return this.gLU.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (blL() && this.gdK != null && this.gLU != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gLU.startPlay(this.gdK.video_url);
        }
    }

    private boolean blL() {
        return q.blL();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gLU != null) {
            this.gLU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gdK == null ? "" : this.gdK.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gLU == null) {
            return 0L;
        }
        return this.gLU.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gLU != null) {
            this.gLU.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gLU == null) {
            return -2;
        }
        return this.gLU.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gLz = view;
            this.gLA = true;
        }
    }
}
