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
    private View amM;
    private TbImageView gRy;
    private ImageView gRz;
    private DistributeVrPlayController gVF;
    private GLTextureView gVG;
    private TbImageView gVH;
    private View gVk;
    private boolean gVl;
    private VideoInfo gnt;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.amM = null;
        this.gVl = false;
        this.mContext = null;
        this.gVG = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gVl || DistributeVrVideoView.this.gVk == null || DistributeVrVideoView.this.gVk.getParent() != null) {
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
        this.amM = null;
        this.gVl = false;
        this.mContext = null;
        this.gVG = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gVl || DistributeVrVideoView.this.gVk == null || DistributeVrVideoView.this.gVk.getParent() != null) {
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
        this.amM = null;
        this.gVl = false;
        this.mContext = null;
        this.gVG = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gVl || DistributeVrVideoView.this.gVk == null || DistributeVrVideoView.this.gVk.getParent() != null) {
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
        this.amM = LayoutInflater.from(context).inflate(e.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gVG = this.amM.findViewById(e.g.ad_gl_view);
        this.gRy = (TbImageView) this.amM.findViewById(e.g.ad_thumbnail);
        this.gRz = (ImageView) this.amM.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.amM.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.amM.findViewById(e.g.ad_error_tips);
        this.gVH = (TbImageView) this.amM.findViewById(e.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gVG != null && tbPageContext != null && dVar != null && dVar.daF != null && dVar.daF.apB != null) {
            this.gnt = dVar.daF.apB.apT;
            if (this.gnt != null && !ao.isEmpty(this.gnt.video_url) && this.gVF == null) {
                this.mPageContext = tbPageContext;
                this.gVF = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.amM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.amM.setLayoutParams(layoutParams);
                }
                this.gRy.startLoad(this.gnt.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.daF.apB.apV)) {
                    this.gVH.startLoad(dVar.daF.apB.apV, 10, false);
                } else {
                    this.gVH.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gVH.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.daF.apB.apW;
                    layoutParams2.height = l.h(this.mContext, e.C0210e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gVH.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gVG != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.gnt = gVar.videoInfo;
            if (this.gnt != null && !ao.isEmpty(this.gnt.video_url) && this.gVF == null) {
                this.mPageContext = tbPageContext;
                this.gVF = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.amM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.amM.setLayoutParams(layoutParams);
                }
                this.gRy.startLoad(this.gnt.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.apV)) {
                    this.gVH.startLoad(gVar.apV, 10, false);
                } else {
                    this.gVH.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gVH.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.apW;
                    layoutParams2.height = l.h(this.mContext, e.C0210e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gVH.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gVG;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gRz.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gRz.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gRy.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gRz.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gRy.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gRy.setVisibility(0);
        this.gRz.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gRz.setVisibility(0);
        this.gRy.setVisibility(0);
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
        if (this.gVF == null) {
            return false;
        }
        int playStatus = this.gVF.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gVF == null) {
            return false;
        }
        return this.gVF.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bop() && this.gnt != null && this.gVF != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gVF.startPlay(this.gnt.video_url);
        }
    }

    private boolean bop() {
        return q.bop();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gVF != null) {
            this.gVF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gnt == null ? "" : this.gnt.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gVF == null) {
            return 0L;
        }
        return this.gVF.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gVF != null) {
            this.gVF.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gVF == null) {
            return -2;
        }
        return this.gVF.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gVk = view;
            this.gVl = true;
        }
    }
}
