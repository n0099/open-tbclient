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
import com.baidu.tbadk.core.util.am;
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
    private View aHS;
    private View dtF;
    private TbImageView gEU;
    private ImageView gEV;
    private DistributeVrPlayController gIM;
    private GLTextureView gIN;
    private TbImageView gIO;
    private View gIo;
    private boolean gIp;
    private VideoInfo gbN;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aHS = null;
        this.gIp = false;
        this.mContext = null;
        this.gIN = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIp || DistributeVrVideoView.this.gIo == null || DistributeVrVideoView.this.gIo.getParent() != null) {
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
        this.aHS = null;
        this.gIp = false;
        this.mContext = null;
        this.gIN = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIp || DistributeVrVideoView.this.gIo == null || DistributeVrVideoView.this.gIo.getParent() != null) {
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
        this.aHS = null;
        this.gIp = false;
        this.mContext = null;
        this.gIN = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIp || DistributeVrVideoView.this.gIo == null || DistributeVrVideoView.this.gIo.getParent() != null) {
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
        this.aHS = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gIN = this.aHS.findViewById(d.g.ad_gl_view);
        this.gEU = (TbImageView) this.aHS.findViewById(d.g.ad_thumbnail);
        this.gEV = (ImageView) this.aHS.findViewById(d.g.ad_play_button);
        this.dtF = this.aHS.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aHS.findViewById(d.g.ad_error_tips);
        this.gIO = (TbImageView) this.aHS.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gIN != null && tbPageContext != null && dVar != null && dVar.cZH != null && dVar.cZH.aKG != null) {
            this.gbN = dVar.cZH.aKG.aKX;
            if (this.gbN != null && !am.isEmpty(this.gbN.video_url) && this.gIM == null) {
                this.mPageContext = tbPageContext;
                this.gIM = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aHS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ao(this.mContext) - l.t(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aHS.setLayoutParams(layoutParams);
                }
                this.gEU.startLoad(this.gbN.thumbnail_url, 10, false);
                if (!am.isEmpty(dVar.cZH.aKG.aKZ)) {
                    this.gIO.startLoad(dVar.cZH.aKG.aKZ, 10, false);
                } else {
                    this.gIO.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gIO.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cZH.aKG.aLa;
                    layoutParams2.height = l.t(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gIO.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gIN != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.f fVar = adCard.vrVideoInfo;
            this.gbN = fVar.videoInfo;
            if (this.gbN != null && !am.isEmpty(this.gbN.video_url) && this.gIM == null) {
                this.mPageContext = tbPageContext;
                this.gIM = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aHS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aHS.setLayoutParams(layoutParams);
                }
                this.gEU.startLoad(this.gbN.thumbnail_url, 10, false);
                if (!am.isEmpty(fVar.aKZ)) {
                    this.gIO.startLoad(fVar.aKZ, 10, false);
                } else {
                    this.gIO.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gIO.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = fVar.aLa;
                    layoutParams2.height = l.t(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gIO.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gIN;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dtF.setVisibility(0);
        this.gEV.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gEV.setVisibility(8);
        this.dtF.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gEU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gEV.setVisibility(8);
        this.dtF.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gEU.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.dtF.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gEU.setVisibility(0);
        this.gEV.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.dtF.setVisibility(8);
        this.gEV.setVisibility(0);
        this.gEU.setVisibility(0);
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
        if (this.gIM == null) {
            return false;
        }
        int playStatus = this.gIM.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gIM == null) {
            return false;
        }
        return this.gIM.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bhH() && this.gbN != null && this.gIM != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.gIM.startPlay(this.gbN.video_url);
        }
    }

    private boolean bhH() {
        return q.bhH();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gIM != null) {
            this.gIM.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gbN == null ? "" : this.gbN.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gIM == null) {
            return 0L;
        }
        return this.gIM.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.gIM != null) {
            this.gIM.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gIM == null) {
            return -2;
        }
        return this.gIM.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gIo = view;
            this.gIp = true;
        }
    }
}
