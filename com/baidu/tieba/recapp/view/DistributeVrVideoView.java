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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View abp;
    private VideoInfo fIJ;
    private TbImageView gms;
    private ImageView gmt;
    private View gqb;
    private boolean gqc;
    private DistributeVrPlayController gqx;
    private GLTextureView gqy;
    private TbImageView gqz;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.abp = null;
        this.gqc = false;
        this.mContext = null;
        this.gqy = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gqc || DistributeVrVideoView.this.gqb == null || DistributeVrVideoView.this.gqb.getParent() != null) {
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
        this.abp = null;
        this.gqc = false;
        this.mContext = null;
        this.gqy = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gqc || DistributeVrVideoView.this.gqb == null || DistributeVrVideoView.this.gqb.getParent() != null) {
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
        this.abp = null;
        this.gqc = false;
        this.mContext = null;
        this.gqy = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gqc || DistributeVrVideoView.this.gqb == null || DistributeVrVideoView.this.gqb.getParent() != null) {
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
        this.abp = LayoutInflater.from(context).inflate(d.i.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gqy = this.abp.findViewById(d.g.ad_gl_view);
        this.gms = (TbImageView) this.abp.findViewById(d.g.ad_thumbnail);
        this.gmt = (ImageView) this.abp.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.abp.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.abp.findViewById(d.g.ad_error_tips);
        this.gqz = (TbImageView) this.abp.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gqy != null && tbPageContext != null && dVar != null && dVar.cBt != null && dVar.cBt.adX != null) {
            this.fIJ = dVar.cBt.adX.aep;
            if (this.fIJ != null && !ao.isEmpty(this.fIJ.video_url) && this.gqx == null) {
                this.mPageContext = tbPageContext;
                this.gqx = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.abp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ah(this.mContext) - l.e(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.abp.setLayoutParams(layoutParams);
                }
                this.gms.startLoad(this.fIJ.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.cBt.adX.aer)) {
                    this.gqz.startLoad(dVar.cBt.adX.aer, 10, false);
                } else {
                    this.gqz.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gqz.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cBt.adX.aes;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gqz.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gqy != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fIJ = gVar.videoInfo;
            if (this.fIJ != null && !ao.isEmpty(this.fIJ.video_url) && this.gqx == null) {
                this.mPageContext = tbPageContext;
                this.gqx = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.abp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.abp.setLayoutParams(layoutParams);
                }
                this.gms.startLoad(this.fIJ.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.aer)) {
                    this.gqz.startLoad(gVar.aer, 10, false);
                } else {
                    this.gqz.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gqz.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.aes;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gqz.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gqy;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gmt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gmt.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gms.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gmt.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gms.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gms.setVisibility(0);
        this.gmt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gmt.setVisibility(0);
        this.gms.setVisibility(0);
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
        if (this.gqx == null) {
            return false;
        }
        int playStatus = this.gqx.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gqx == null) {
            return false;
        }
        return this.gqx.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bhI() && this.fIJ != null && this.gqx != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gqx.startPlay(this.fIJ.video_url);
        }
    }

    private boolean bhI() {
        return q.bhI();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gqx != null) {
            this.gqx.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fIJ == null ? "" : this.fIJ.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gqx == null) {
            return 0L;
        }
        return this.gqx.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gqx != null) {
            this.gqx.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gqx == null) {
            return -2;
        }
        return this.gqx.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gqb = view;
            this.gqc = true;
        }
    }
}
