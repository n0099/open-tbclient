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
    private View bhI;
    private View btY;
    private VideoInfo hEC;
    private TbImageView ijZ;
    private ImageView ika;
    private View inP;
    private boolean inQ;
    private DistributeVrPlayController iok;
    private GLTextureView iol;
    private TbImageView iom;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.btY = null;
        this.inQ = false;
        this.mContext = null;
        this.iol = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inQ || DistributeVrVideoView.this.inP == null || DistributeVrVideoView.this.inP.getParent() != null) {
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
        this.btY = null;
        this.inQ = false;
        this.mContext = null;
        this.iol = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inQ || DistributeVrVideoView.this.inP == null || DistributeVrVideoView.this.inP.getParent() != null) {
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
        this.btY = null;
        this.inQ = false;
        this.mContext = null;
        this.iol = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.inQ || DistributeVrVideoView.this.inP == null || DistributeVrVideoView.this.inP.getParent() != null) {
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
        this.btY = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.iol = this.btY.findViewById(d.g.ad_gl_view);
        this.ijZ = (TbImageView) this.btY.findViewById(d.g.ad_thumbnail);
        this.ika = (ImageView) this.btY.findViewById(d.g.ad_play_button);
        this.bhI = this.btY.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.btY.findViewById(d.g.ad_error_tips);
        this.iom = (TbImageView) this.btY.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.iol != null && tbPageContext != null && dVar != null && dVar.ekZ != null && dVar.ekZ.bwN != null) {
            this.hEC = dVar.ekZ.bwN.bxf;
            if (this.hEC != null && !ap.isEmpty(this.hEC.video_url) && this.iok == null) {
                this.mPageContext = tbPageContext;
                this.iok = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.btY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.aO(this.mContext) - l.h(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.btY.setLayoutParams(layoutParams);
                }
                this.ijZ.startLoad(this.hEC.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.ekZ.bwN.bxh)) {
                    this.iom.startLoad(dVar.ekZ.bwN.bxh, 10, false);
                } else {
                    this.iom.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iom.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.ekZ.bwN.bxi;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iom.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.iol != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.hEC = gVar.videoInfo;
            if (this.hEC != null && !ap.isEmpty(this.hEC.video_url) && this.iok == null) {
                this.mPageContext = tbPageContext;
                this.iok = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.btY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.btY.setLayoutParams(layoutParams);
                }
                this.ijZ.startLoad(this.hEC.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.bxh)) {
                    this.iom.startLoad(gVar.bxh, 10, false);
                } else {
                    this.iom.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iom.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bxi;
                    layoutParams2.height = l.h(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iom.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iol;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhI.setVisibility(0);
        this.ika.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.ika.setVisibility(8);
        this.bhI.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ijZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.ika.setVisibility(8);
        this.bhI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bhI.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ijZ.setVisibility(0);
        this.ika.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bhI.setVisibility(8);
        this.ika.setVisibility(0);
        this.ijZ.setVisibility(0);
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
        if (this.iok == null) {
            return false;
        }
        int playStatus = this.iok.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iok == null) {
            return false;
        }
        return this.iok.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bPw() && this.hEC != null && this.iok != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.iok.startPlay(this.hEC.video_url);
        }
    }

    private boolean bPw() {
        return q.bPw();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iok != null) {
            this.iok.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hEC == null ? "" : this.hEC.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iok == null) {
            return 0L;
        }
        return this.iok.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.iok != null) {
            this.iok.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.iok == null) {
            return -2;
        }
        return this.iok.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.inP = view;
            this.inQ = true;
        }
    }
}
