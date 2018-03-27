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
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View aHT;
    private View dtI;
    private TbImageView gFk;
    private ImageView gFl;
    private View gIE;
    private boolean gIF;
    private DistributeVrPlayController gJc;
    private GLTextureView gJd;
    private TbImageView gJe;
    private VideoInfo gcd;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aHT = null;
        this.gIF = false;
        this.mContext = null;
        this.gJd = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIF || DistributeVrVideoView.this.gIE == null || DistributeVrVideoView.this.gIE.getParent() != null) {
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
        this.aHT = null;
        this.gIF = false;
        this.mContext = null;
        this.gJd = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIF || DistributeVrVideoView.this.gIE == null || DistributeVrVideoView.this.gIE.getParent() != null) {
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
        this.aHT = null;
        this.gIF = false;
        this.mContext = null;
        this.gJd = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIF || DistributeVrVideoView.this.gIE == null || DistributeVrVideoView.this.gIE.getParent() != null) {
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
        this.aHT = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gJd = this.aHT.findViewById(d.g.ad_gl_view);
        this.gFk = (TbImageView) this.aHT.findViewById(d.g.ad_thumbnail);
        this.gFl = (ImageView) this.aHT.findViewById(d.g.ad_play_button);
        this.dtI = this.aHT.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aHT.findViewById(d.g.ad_error_tips);
        this.gJe = (TbImageView) this.aHT.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gJd != null && tbPageContext != null && dVar != null && dVar.cZK != null && dVar.cZK.aKH != null) {
            this.gcd = dVar.cZK.aKH.aKY;
            if (this.gcd != null && !am.isEmpty(this.gcd.video_url) && this.gJc == null) {
                this.mPageContext = tbPageContext;
                this.gJc = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aHT.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ao(this.mContext) - l.t(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aHT.setLayoutParams(layoutParams);
                }
                this.gFk.startLoad(this.gcd.thumbnail_url, 10, false);
                if (!am.isEmpty(dVar.cZK.aKH.aLa)) {
                    this.gJe.startLoad(dVar.cZK.aKH.aLa, 10, false);
                } else {
                    this.gJe.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gJe.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cZK.aKH.aLb;
                    layoutParams2.height = l.t(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gJe.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gJd != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.f fVar = adCard.vrVideoInfo;
            this.gcd = fVar.videoInfo;
            if (this.gcd != null && !am.isEmpty(this.gcd.video_url) && this.gJc == null) {
                this.mPageContext = tbPageContext;
                this.gJc = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aHT.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aHT.setLayoutParams(layoutParams);
                }
                this.gFk.startLoad(this.gcd.thumbnail_url, 10, false);
                if (!am.isEmpty(fVar.aLa)) {
                    this.gJe.startLoad(fVar.aLa, 10, false);
                } else {
                    this.gJe.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gJe.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = fVar.aLb;
                    layoutParams2.height = l.t(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gJe.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gJd;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dtI.setVisibility(0);
        this.gFl.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gFl.setVisibility(8);
        this.dtI.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gFk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gFl.setVisibility(8);
        this.dtI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFk.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.dtI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFk.setVisibility(0);
        this.gFl.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.dtI.setVisibility(8);
        this.gFl.setVisibility(0);
        this.gFk.setVisibility(0);
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
        if (this.gJc == null) {
            return false;
        }
        int playStatus = this.gJc.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gJc == null) {
            return false;
        }
        return this.gJc.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bhI() && this.gcd != null && this.gJc != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.gJc.startPlay(this.gcd.video_url);
        }
    }

    private boolean bhI() {
        return r.bhI();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gJc != null) {
            this.gJc.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gcd == null ? "" : this.gcd.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gJc == null) {
            return 0L;
        }
        return this.gJc.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.gJc != null) {
            this.gJc.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gJc == null) {
            return -2;
        }
        return this.gJc.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gIE = view;
            this.gIF = true;
        }
    }
}
