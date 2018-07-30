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
    private View aaV;
    private View cXy;
    private VideoInfo fMZ;
    private TbImageView grt;
    private ImageView gru;
    private DistributeVrPlayController gvC;
    private GLTextureView gvD;
    private TbImageView gvE;
    private View gvg;
    private boolean gvh;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aaV = null;
        this.gvh = false;
        this.mContext = null;
        this.gvD = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gvh || DistributeVrVideoView.this.gvg == null || DistributeVrVideoView.this.gvg.getParent() != null) {
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
        this.aaV = null;
        this.gvh = false;
        this.mContext = null;
        this.gvD = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gvh || DistributeVrVideoView.this.gvg == null || DistributeVrVideoView.this.gvg.getParent() != null) {
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
        this.aaV = null;
        this.gvh = false;
        this.mContext = null;
        this.gvD = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gvh || DistributeVrVideoView.this.gvg == null || DistributeVrVideoView.this.gvg.getParent() != null) {
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
        this.aaV = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gvD = this.aaV.findViewById(d.g.ad_gl_view);
        this.grt = (TbImageView) this.aaV.findViewById(d.g.ad_thumbnail);
        this.gru = (ImageView) this.aaV.findViewById(d.g.ad_play_button);
        this.cXy = this.aaV.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aaV.findViewById(d.g.ad_error_tips);
        this.gvE = (TbImageView) this.aaV.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gvD != null && tbPageContext != null && dVar != null && dVar.cBT != null && dVar.cBT.adQ != null) {
            this.fMZ = dVar.cBT.adQ.aei;
            if (this.fMZ != null && !ap.isEmpty(this.fMZ.video_url) && this.gvC == null) {
                this.mPageContext = tbPageContext;
                this.gvC = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aaV.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ah(this.mContext) - l.f(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aaV.setLayoutParams(layoutParams);
                }
                this.grt.startLoad(this.fMZ.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.cBT.adQ.aek)) {
                    this.gvE.startLoad(dVar.cBT.adQ.aek, 10, false);
                } else {
                    this.gvE.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gvE.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cBT.adQ.ael;
                    layoutParams2.height = l.f(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gvE.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gvD != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fMZ = gVar.videoInfo;
            if (this.fMZ != null && !ap.isEmpty(this.fMZ.video_url) && this.gvC == null) {
                this.mPageContext = tbPageContext;
                this.gvC = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aaV.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aaV.setLayoutParams(layoutParams);
                }
                this.grt.startLoad(this.fMZ.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.aek)) {
                    this.gvE.startLoad(gVar.aek, 10, false);
                } else {
                    this.gvE.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gvE.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.ael;
                    layoutParams2.height = l.f(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gvE.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gvD;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cXy.setVisibility(0);
        this.gru.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gru.setVisibility(8);
        this.cXy.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.grt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gru.setVisibility(8);
        this.cXy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grt.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.cXy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grt.setVisibility(0);
        this.gru.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.cXy.setVisibility(8);
        this.gru.setVisibility(0);
        this.grt.setVisibility(0);
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
        if (this.gvC == null) {
            return false;
        }
        int playStatus = this.gvC.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gvC == null) {
            return false;
        }
        return this.gvC.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bgH() && this.fMZ != null && this.gvC != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gvC.startPlay(this.fMZ.video_url);
        }
    }

    private boolean bgH() {
        return q.bgH();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gvC != null) {
            this.gvC.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fMZ == null ? "" : this.fMZ.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gvC == null) {
            return 0L;
        }
        return this.gvC.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gvC != null) {
            this.gvC.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gvC == null) {
            return -2;
        }
        return this.gvC.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gvg = view;
            this.gvh = true;
        }
    }
}
