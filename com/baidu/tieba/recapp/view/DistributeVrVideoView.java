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
    private TbImageView gGo;
    private ImageView gGp;
    private View gJY;
    private boolean gJZ;
    private DistributeVrPlayController gKu;
    private GLTextureView gKv;
    private TbImageView gKw;
    private VideoInfo gcm;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aix = null;
        this.gJZ = false;
        this.mContext = null;
        this.gKv = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gJZ || DistributeVrVideoView.this.gJY == null || DistributeVrVideoView.this.gJY.getParent() != null) {
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
        this.gJZ = false;
        this.mContext = null;
        this.gKv = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gJZ || DistributeVrVideoView.this.gJY == null || DistributeVrVideoView.this.gJY.getParent() != null) {
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
        this.gJZ = false;
        this.mContext = null;
        this.gKv = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gJZ || DistributeVrVideoView.this.gJY == null || DistributeVrVideoView.this.gJY.getParent() != null) {
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
        this.gKv = this.aix.findViewById(e.g.ad_gl_view);
        this.gGo = (TbImageView) this.aix.findViewById(e.g.ad_thumbnail);
        this.gGp = (ImageView) this.aix.findViewById(e.g.ad_play_button);
        this.dlx = this.aix.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aix.findViewById(e.g.ad_error_tips);
        this.gKw = (TbImageView) this.aix.findViewById(e.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gKv != null && tbPageContext != null && dVar != null && dVar.cQa != null && dVar.cQa.aln != null) {
            this.gcm = dVar.cQa.aln.alF;
            if (this.gcm != null && !ao.isEmpty(this.gcm.video_url) && this.gKu == null) {
                this.mPageContext = tbPageContext;
                this.gKu = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aix.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, e.C0175e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aix.setLayoutParams(layoutParams);
                }
                this.gGo.startLoad(this.gcm.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.cQa.aln.alH)) {
                    this.gKw.startLoad(dVar.cQa.aln.alH, 10, false);
                } else {
                    this.gKw.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gKw.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cQa.aln.alI;
                    layoutParams2.height = l.h(this.mContext, e.C0175e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gKw.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gKv != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.gcm = gVar.videoInfo;
            if (this.gcm != null && !ao.isEmpty(this.gcm.video_url) && this.gKu == null) {
                this.mPageContext = tbPageContext;
                this.gKu = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aix.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aix.setLayoutParams(layoutParams);
                }
                this.gGo.startLoad(this.gcm.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.alH)) {
                    this.gKw.startLoad(gVar.alH, 10, false);
                } else {
                    this.gKw.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gKw.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.alI;
                    layoutParams2.height = l.h(this.mContext, e.C0175e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gKw.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gKv;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dlx.setVisibility(0);
        this.gGp.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gGp.setVisibility(8);
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gGo.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gGp.setVisibility(8);
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gGo.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gGo.setVisibility(0);
        this.gGp.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.dlx.setVisibility(8);
        this.gGp.setVisibility(0);
        this.gGo.setVisibility(0);
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
        if (this.gKu == null) {
            return false;
        }
        int playStatus = this.gKu.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gKu == null) {
            return false;
        }
        return this.gKu.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bmp() && this.gcm != null && this.gKu != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gKu.startPlay(this.gcm.video_url);
        }
    }

    private boolean bmp() {
        return q.bmp();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gKu != null) {
            this.gKu.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gcm == null ? "" : this.gcm.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gKu == null) {
            return 0L;
        }
        return this.gKu.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gKu != null) {
            this.gKu.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gKu == null) {
            return -2;
        }
        return this.gKu.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gJY = view;
            this.gJZ = true;
        }
    }
}
