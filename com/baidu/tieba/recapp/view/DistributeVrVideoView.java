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
    private View aix;
    private View dlx;
    private TbImageView gGp;
    private ImageView gGq;
    private View gJZ;
    private boolean gKa;
    private DistributeVrPlayController gKv;
    private GLTextureView gKw;
    private TbImageView gKx;
    private VideoInfo gcn;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aix = null;
        this.gKa = false;
        this.mContext = null;
        this.gKw = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gKa || DistributeVrVideoView.this.gJZ == null || DistributeVrVideoView.this.gJZ.getParent() != null) {
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
        this.aix = null;
        this.gKa = false;
        this.mContext = null;
        this.gKw = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gKa || DistributeVrVideoView.this.gJZ == null || DistributeVrVideoView.this.gJZ.getParent() != null) {
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
        this.aix = null;
        this.gKa = false;
        this.mContext = null;
        this.gKw = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gKa || DistributeVrVideoView.this.gJZ == null || DistributeVrVideoView.this.gJZ.getParent() != null) {
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
        this.aix = LayoutInflater.from(context).inflate(e.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gKw = this.aix.findViewById(e.g.ad_gl_view);
        this.gGp = (TbImageView) this.aix.findViewById(e.g.ad_thumbnail);
        this.gGq = (ImageView) this.aix.findViewById(e.g.ad_play_button);
        this.dlx = this.aix.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aix.findViewById(e.g.ad_error_tips);
        this.gKx = (TbImageView) this.aix.findViewById(e.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gKw != null && tbPageContext != null && dVar != null && dVar.cQa != null && dVar.cQa.aln != null) {
            this.gcn = dVar.cQa.aln.alF;
            if (this.gcn != null && !ao.isEmpty(this.gcn.video_url) && this.gKv == null) {
                this.mPageContext = tbPageContext;
                this.gKv = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aix.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, e.C0175e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aix.setLayoutParams(layoutParams);
                }
                this.gGp.startLoad(this.gcn.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.cQa.aln.alH)) {
                    this.gKx.startLoad(dVar.cQa.aln.alH, 10, false);
                } else {
                    this.gKx.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gKx.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cQa.aln.alI;
                    layoutParams2.height = l.h(this.mContext, e.C0175e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gKx.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gKw != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.gcn = gVar.videoInfo;
            if (this.gcn != null && !ao.isEmpty(this.gcn.video_url) && this.gKv == null) {
                this.mPageContext = tbPageContext;
                this.gKv = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aix.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aix.setLayoutParams(layoutParams);
                }
                this.gGp.startLoad(this.gcn.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.alH)) {
                    this.gKx.startLoad(gVar.alH, 10, false);
                } else {
                    this.gKx.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gKx.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.alI;
                    layoutParams2.height = l.h(this.mContext, e.C0175e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gKx.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gKw;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dlx.setVisibility(0);
        this.gGq.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gGq.setVisibility(8);
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gGp.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gGq.setVisibility(8);
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gGp.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gGp.setVisibility(0);
        this.gGq.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.dlx.setVisibility(8);
        this.gGq.setVisibility(0);
        this.gGp.setVisibility(0);
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
        if (this.gKv == null) {
            return false;
        }
        int playStatus = this.gKv.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gKv == null) {
            return false;
        }
        return this.gKv.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bmp() && this.gcn != null && this.gKv != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gKv.startPlay(this.gcn.video_url);
        }
    }

    private boolean bmp() {
        return q.bmp();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gKv != null) {
            this.gKv.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gcn == null ? "" : this.gcn.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gKv == null) {
            return 0L;
        }
        return this.gKv.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gKv != null) {
            this.gKv.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gKv == null) {
            return -2;
        }
        return this.gKv.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gJZ = view;
            this.gKa = true;
        }
    }
}
