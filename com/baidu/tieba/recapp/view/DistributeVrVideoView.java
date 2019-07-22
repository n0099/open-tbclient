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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.d;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View boE;
    private TbImageView iIT;
    private ImageView iIU;
    private View iMF;
    private boolean iMG;
    private DistributeVrPlayController iNe;
    private GLTextureView iNf;
    private TbImageView iNg;
    private VideoInfo icG;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;
    private View mRoot;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.mRoot = null;
        this.iMG = false;
        this.mContext = null;
        this.iNf = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iMG || DistributeVrVideoView.this.iMF == null || DistributeVrVideoView.this.iMF.getParent() != null) {
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
        this.mRoot = null;
        this.iMG = false;
        this.mContext = null;
        this.iNf = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iMG || DistributeVrVideoView.this.iMF == null || DistributeVrVideoView.this.iMF.getParent() != null) {
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
        this.mRoot = null;
        this.iMG = false;
        this.mContext = null;
        this.iNf = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iMG || DistributeVrVideoView.this.iMF == null || DistributeVrVideoView.this.iMF.getParent() != null) {
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
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.iNf = this.mRoot.findViewById(R.id.ad_gl_view);
        this.iIT = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.iIU = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.boE = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.iNg = (TbImageView) this.mRoot.findViewById(R.id.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.iNf != null && tbPageContext != null && dVar != null && dVar.eFx != null && dVar.eFx.bFd != null) {
            this.icG = dVar.eFx.bFd.bFv;
            if (this.icG != null && !aq.isEmpty(this.icG.video_url) && this.iNe == null) {
                this.mPageContext = tbPageContext;
                this.iNe = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds164);
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.iIT.startLoad(this.icG.thumbnail_url, 10, false);
                if (!aq.isEmpty(dVar.eFx.bFd.bFx)) {
                    this.iNg.startLoad(dVar.eFx.bFd.bFx, 10, false);
                } else {
                    this.iNg.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iNg.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.eFx.bFd.bFy;
                    layoutParams2.height = l.g(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iNg.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.iNf != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.icG = gVar.videoInfo;
            if (this.icG != null && !aq.isEmpty(this.icG.video_url) && this.iNe == null) {
                this.mPageContext = tbPageContext;
                this.iNe = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.iIT.startLoad(this.icG.thumbnail_url, 10, false);
                if (!aq.isEmpty(gVar.bFx)) {
                    this.iNg.startLoad(gVar.bFx, 10, false);
                } else {
                    this.iNg.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iNg.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bFy;
                    layoutParams2.height = l.g(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iNg.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iNf;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.boE.setVisibility(0);
        this.iIU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.iIU.setVisibility(8);
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iIT.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.iIU.setVisibility(8);
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iIT.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.boE.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iIT.setVisibility(0);
        this.iIU.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.boE.setVisibility(8);
        this.iIU.setVisibility(0);
        this.iIT.setVisibility(0);
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
        if (this.iNe == null) {
            return false;
        }
        int playStatus = this.iNe.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iNe == null) {
            return false;
        }
        return this.iNe.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (caf() && this.icG != null && this.iNe != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.iNe.startPlay(this.icG.video_url);
        }
    }

    private boolean caf() {
        return q.caf();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iNe != null) {
            this.iNe.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.icG == null ? "" : this.icG.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iNe == null) {
            return 0L;
        }
        return this.iNe.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.iNe != null) {
            this.iNe.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.iNe == null) {
            return -2;
        }
        return this.iNe.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.iMF = view;
            this.iMG = true;
        }
    }
}
