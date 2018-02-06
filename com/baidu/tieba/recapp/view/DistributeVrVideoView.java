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
    private View aId;
    private View dtR;
    private TbImageView gFj;
    private ImageView gFk;
    private View gID;
    private boolean gIE;
    private DistributeVrPlayController gJb;
    private GLTextureView gJc;
    private TbImageView gJd;
    private VideoInfo gbY;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.aId = null;
        this.gIE = false;
        this.mContext = null;
        this.gJc = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIE || DistributeVrVideoView.this.gID == null || DistributeVrVideoView.this.gID.getParent() != null) {
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
        this.aId = null;
        this.gIE = false;
        this.mContext = null;
        this.gJc = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIE || DistributeVrVideoView.this.gID == null || DistributeVrVideoView.this.gID.getParent() != null) {
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
        this.aId = null;
        this.gIE = false;
        this.mContext = null;
        this.gJc = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.gIE || DistributeVrVideoView.this.gID == null || DistributeVrVideoView.this.gID.getParent() != null) {
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
        this.aId = LayoutInflater.from(context).inflate(d.h.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.gJc = this.aId.findViewById(d.g.ad_gl_view);
        this.gFj = (TbImageView) this.aId.findViewById(d.g.ad_thumbnail);
        this.gFk = (ImageView) this.aId.findViewById(d.g.ad_play_button);
        this.dtR = this.aId.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.aId.findViewById(d.g.ad_error_tips);
        this.gJd = (TbImageView) this.aId.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.gJc != null && tbPageContext != null && dVar != null && dVar.cZT != null && dVar.cZT.aKR != null) {
            this.gbY = dVar.cZT.aKR.aLi;
            if (this.gbY != null && !am.isEmpty(this.gbY.video_url) && this.gJb == null) {
                this.mPageContext = tbPageContext;
                this.gJb = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aId.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ao(this.mContext) - l.t(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.aId.setLayoutParams(layoutParams);
                }
                this.gFj.startLoad(this.gbY.thumbnail_url, 10, false);
                if (!am.isEmpty(dVar.cZT.aKR.aLk)) {
                    this.gJd.startLoad(dVar.cZT.aKR.aLk, 10, false);
                } else {
                    this.gJd.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gJd.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.cZT.aKR.aLl;
                    layoutParams2.height = l.t(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gJd.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.gJc != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.f fVar = adCard.vrVideoInfo;
            this.gbY = fVar.videoInfo;
            if (this.gbY != null && !am.isEmpty(this.gbY.video_url) && this.gJb == null) {
                this.mPageContext = tbPageContext;
                this.gJb = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.aId.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.aId.setLayoutParams(layoutParams);
                }
                this.gFj.startLoad(this.gbY.thumbnail_url, 10, false);
                if (!am.isEmpty(fVar.aLk)) {
                    this.gJd.startLoad(fVar.aLk, 10, false);
                } else {
                    this.gJd.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gJd.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = fVar.aLl;
                    layoutParams2.height = l.t(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gJd.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gJc;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dtR.setVisibility(0);
        this.gFk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gFk.setVisibility(8);
        this.dtR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gFj.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gFk.setVisibility(8);
        this.dtR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFj.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.dtR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gFj.setVisibility(0);
        this.gFk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.dtR.setVisibility(8);
        this.gFk.setVisibility(0);
        this.gFj.setVisibility(0);
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
        if (this.gJb == null) {
            return false;
        }
        int playStatus = this.gJb.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gJb == null) {
            return false;
        }
        return this.gJb.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bhI() && this.gbY != null && this.gJb != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.gJb.startPlay(this.gbY.video_url);
        }
    }

    private boolean bhI() {
        return q.bhI();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.gJb != null) {
            this.gJb.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.gbY == null ? "" : this.gbY.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gJb == null) {
            return 0L;
        }
        return this.gJb.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.gJb != null) {
            this.gJb.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gJb == null) {
            return -2;
        }
        return this.gJb.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gID = view;
            this.gIE = true;
        }
    }
}
