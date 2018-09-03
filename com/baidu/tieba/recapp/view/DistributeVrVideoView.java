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
import com.baidu.tieba.card.data.d;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View aaW;
    private View cXu;
    private VideoInfo fMS;
    private TbImageView grw;
    private ImageView grx;
    private DistributeVrPlayController gvF;
    private GLTextureView gvG;
    private TbImageView gvH;
    private View gvj;
    private boolean gvk;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aaW = null;
        this.gvk = false;
        this.mContext = null;
        this.gvG = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gvk || DistributeVrVideoView.this.gvj == null || DistributeVrVideoView.this.gvj.getParent() != null) {
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
        this.aaW = null;
        this.gvk = false;
        this.mContext = null;
        this.gvG = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gvk || DistributeVrVideoView.this.gvj == null || DistributeVrVideoView.this.gvj.getParent() != null) {
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
        this.aaW = null;
        this.gvk = false;
        this.mContext = null;
        this.gvG = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gvk || DistributeVrVideoView.this.gvj == null || DistributeVrVideoView.this.gvj.getParent() != null) {
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
        this.aaW = LayoutInflater.from(context).inflate(f.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gvG = this.aaW.findViewById(f.g.ad_gl_view);
        this.grw = (TbImageView) this.aaW.findViewById(f.g.ad_thumbnail);
        this.grx = (ImageView) this.aaW.findViewById(f.g.ad_play_button);
        this.cXu = this.aaW.findViewById(f.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aaW.findViewById(f.g.ad_error_tips);
        this.gvH = (TbImageView) this.aaW.findViewById(f.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gvG != null && tbPageContext != null && dVar != null && dVar.cBQ != null && dVar.cBQ.adQ != null) {
            this.fMS = dVar.cBQ.adQ.aei;
            if (this.fMS != null && !ap.isEmpty(this.fMS.video_url) && this.gvF == null) {
                this.mPageContext = tbPageContext;
                this.gvF = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aaW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ah(this.mContext) - l.f(this.mContext, f.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aaW.setLayoutParams(layoutParams);
                }
                this.grw.startLoad(this.fMS.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.cBQ.adQ.aek)) {
                    this.gvH.startLoad(dVar.cBQ.adQ.aek, 10, false);
                } else {
                    this.gvH.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gvH.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cBQ.adQ.ael;
                    layoutParams2.height = l.f(this.mContext, f.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gvH.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gvG != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fMS = gVar.videoInfo;
            if (this.fMS != null && !ap.isEmpty(this.fMS.video_url) && this.gvF == null) {
                this.mPageContext = tbPageContext;
                this.gvF = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aaW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aaW.setLayoutParams(layoutParams);
                }
                this.grw.startLoad(this.fMS.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.aek)) {
                    this.gvH.startLoad(gVar.aek, 10, false);
                } else {
                    this.gvH.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gvH.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.ael;
                    layoutParams2.height = l.f(this.mContext, f.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gvH.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gvG;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cXu.setVisibility(0);
        this.grx.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.grx.setVisibility(8);
        this.cXu.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.grw.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.grx.setVisibility(8);
        this.cXu.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grw.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.cXu.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grw.setVisibility(0);
        this.grx.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.cXu.setVisibility(8);
        this.grx.setVisibility(0);
        this.grw.setVisibility(0);
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
        if (this.gvF == null) {
            return false;
        }
        int playStatus = this.gvF.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gvF == null) {
            return false;
        }
        return this.gvF.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bgC() && this.fMS != null && this.gvF != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gvF.startPlay(this.fMS.video_url);
        }
    }

    private boolean bgC() {
        return q.bgC();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gvF != null) {
            this.gvF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fMS == null ? "" : this.fMS.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gvF == null) {
            return 0L;
        }
        return this.gvF.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gvF != null) {
            this.gvF.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gvF == null) {
            return -2;
        }
        return this.gvF.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gvj = view;
            this.gvk = true;
        }
    }
}
