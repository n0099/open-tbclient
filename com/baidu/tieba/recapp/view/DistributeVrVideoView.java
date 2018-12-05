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
    private TbImageView gOG;
    private ImageView gOH;
    private DistributeVrPlayController gSK;
    private GLTextureView gSL;
    private TbImageView gSM;
    private View gSp;
    private boolean gSq;
    private VideoInfo gkC;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.amM = null;
        this.gSq = false;
        this.mContext = null;
        this.gSL = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gSq || DistributeVrVideoView.this.gSp == null || DistributeVrVideoView.this.gSp.getParent() != null) {
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
        this.gSq = false;
        this.mContext = null;
        this.gSL = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gSq || DistributeVrVideoView.this.gSp == null || DistributeVrVideoView.this.gSp.getParent() != null) {
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
        this.gSq = false;
        this.mContext = null;
        this.gSL = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gSq || DistributeVrVideoView.this.gSp == null || DistributeVrVideoView.this.gSp.getParent() != null) {
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
        this.gSL = this.amM.findViewById(e.g.ad_gl_view);
        this.gOG = (TbImageView) this.amM.findViewById(e.g.ad_thumbnail);
        this.gOH = (ImageView) this.amM.findViewById(e.g.ad_play_button);
        this.mLoadingView = this.amM.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.amM.findViewById(e.g.ad_error_tips);
        this.gSM = (TbImageView) this.amM.findViewById(e.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.gSL != null && tbPageContext != null && dVar != null && dVar.cXN != null && dVar.cXN.apB != null) {
            this.gkC = dVar.cXN.apB.apT;
            if (this.gkC != null && !ao.isEmpty(this.gkC.video_url) && this.gSK == null) {
                this.mPageContext = tbPageContext;
                this.gSK = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.amM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.amM.setLayoutParams(layoutParams);
                }
                this.gOG.startLoad(this.gkC.thumbnail_url, 10, false);
                if (!ao.isEmpty(dVar.cXN.apB.apV)) {
                    this.gSM.startLoad(dVar.cXN.apB.apV, 10, false);
                } else {
                    this.gSM.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gSM.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cXN.apB.apW;
                    layoutParams2.height = l.h(this.mContext, e.C0210e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gSM.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gSL != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.gkC = gVar.videoInfo;
            if (this.gkC != null && !ao.isEmpty(this.gkC.video_url) && this.gSK == null) {
                this.mPageContext = tbPageContext;
                this.gSK = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.amM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.amM.setLayoutParams(layoutParams);
                }
                this.gOG.startLoad(this.gkC.thumbnail_url, 10, false);
                if (!ao.isEmpty(gVar.apV)) {
                    this.gSM.startLoad(gVar.apV, 10, false);
                } else {
                    this.gSM.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gSM.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.apW;
                    layoutParams2.height = l.h(this.mContext, e.C0210e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gSM.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gSL;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gOH.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gOH.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gOG.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gOH.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gOG.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gOG.setVisibility(0);
        this.gOH.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gOH.setVisibility(0);
        this.gOG.setVisibility(0);
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
        if (this.gSK == null) {
            return false;
        }
        int playStatus = this.gSK.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gSK == null) {
            return false;
        }
        return this.gSK.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bnE() && this.gkC != null && this.gSK != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gSK.startPlay(this.gkC.video_url);
        }
    }

    private boolean bnE() {
        return q.bnE();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gSK != null) {
            this.gSK.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gkC == null ? "" : this.gkC.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gSK == null) {
            return 0L;
        }
        return this.gSK.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gSK != null) {
            this.gSK.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gSK == null) {
            return -2;
        }
        return this.gSK.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gSp = view;
            this.gSq = true;
        }
    }
}
