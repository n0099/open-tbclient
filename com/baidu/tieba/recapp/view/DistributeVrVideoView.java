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
    private View adA;
    private View ddp;
    private VideoInfo fUM;
    private View gCA;
    private boolean gCB;
    private DistributeVrPlayController gCW;
    private GLTextureView gCX;
    private TbImageView gCY;
    private TbImageView gyO;
    private ImageView gyP;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.adA = null;
        this.gCB = false;
        this.mContext = null;
        this.gCX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gCB || DistributeVrVideoView.this.gCA == null || DistributeVrVideoView.this.gCA.getParent() != null) {
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
        this.adA = null;
        this.gCB = false;
        this.mContext = null;
        this.gCX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gCB || DistributeVrVideoView.this.gCA == null || DistributeVrVideoView.this.gCA.getParent() != null) {
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
        this.adA = null;
        this.gCB = false;
        this.mContext = null;
        this.gCX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gCB || DistributeVrVideoView.this.gCA == null || DistributeVrVideoView.this.gCA.getParent() != null) {
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
        this.adA = LayoutInflater.from(context).inflate(e.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gCX = this.adA.findViewById(e.g.ad_gl_view);
        this.gyO = (TbImageView) this.adA.findViewById(e.g.ad_thumbnail);
        this.gyP = (ImageView) this.adA.findViewById(e.g.ad_play_button);
        this.ddp = this.adA.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.adA.findViewById(e.g.ad_error_tips);
        this.gCY = (TbImageView) this.adA.findViewById(e.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gCX != null && tbPageContext != null && dVar != null && dVar.cHH != null && dVar.cHH.agr != null) {
            this.fUM = dVar.cHH.agr.agJ;
            if (this.fUM != null && !ao.isEmpty(this.fUM.video_url) && this.gCW == null) {
                this.mPageContext = tbPageContext;
                this.gCW = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.adA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, e.C0141e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.adA.setLayoutParams(layoutParams);
                }
                this.gyO.startLoad(this.fUM.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.cHH.agr.agL)) {
                    this.gCY.startLoad(dVar.cHH.agr.agL, 10, false);
                } else {
                    this.gCY.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gCY.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cHH.agr.agM;
                    layoutParams2.height = l.h(this.mContext, e.C0141e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gCY.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gCX != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fUM = gVar.videoInfo;
            if (this.fUM != null && !ao.isEmpty(this.fUM.video_url) && this.gCW == null) {
                this.mPageContext = tbPageContext;
                this.gCW = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.adA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.adA.setLayoutParams(layoutParams);
                }
                this.gyO.startLoad(this.fUM.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.agL)) {
                    this.gCY.startLoad(gVar.agL, 10, false);
                } else {
                    this.gCY.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gCY.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.agM;
                    layoutParams2.height = l.h(this.mContext, e.C0141e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gCY.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gCX;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.ddp.setVisibility(0);
        this.gyP.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gyP.setVisibility(8);
        this.ddp.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gyO.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gyP.setVisibility(8);
        this.ddp.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gyO.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.ddp.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gyO.setVisibility(0);
        this.gyP.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.ddp.setVisibility(8);
        this.gyP.setVisibility(0);
        this.gyO.setVisibility(0);
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
        if (this.gCW == null) {
            return false;
        }
        int playStatus = this.gCW.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gCW == null) {
            return false;
        }
        return this.gCW.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bjd() && this.fUM != null && this.gCW != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gCW.startPlay(this.fUM.video_url);
        }
    }

    private boolean bjd() {
        return q.bjd();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gCW != null) {
            this.gCW.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fUM == null ? "" : this.fUM.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gCW == null) {
            return 0L;
        }
        return this.gCW.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gCW != null) {
            this.gCW.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gCW == null) {
            return -2;
        }
        return this.gCW.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gCA = view;
            this.gCB = true;
        }
    }
}
