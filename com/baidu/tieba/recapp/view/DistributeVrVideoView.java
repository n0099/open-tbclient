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
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes13.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View cwB;
    private VideoInfo iXu;
    private TbImageView jJr;
    private ImageView jJs;
    private DistributeVrPlayController jNG;
    private GLTextureView jNH;
    private TbImageView jNI;
    private View jNc;
    private boolean jNd;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;
    private View mRoot;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.mRoot = null;
        this.jNd = false;
        this.mContext = null;
        this.jNH = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.jNd || DistributeVrVideoView.this.jNc == null || DistributeVrVideoView.this.jNc.getParent() != null) {
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
        this.jNd = false;
        this.mContext = null;
        this.jNH = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.jNd || DistributeVrVideoView.this.jNc == null || DistributeVrVideoView.this.jNc.getParent() != null) {
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
        this.jNd = false;
        this.mContext = null;
        this.jNH = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.jNd || DistributeVrVideoView.this.jNc == null || DistributeVrVideoView.this.jNc.getParent() != null) {
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
        this.jNH = this.mRoot.findViewById(R.id.ad_gl_view);
        this.jJr = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jJs = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.cwB = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jNI = (TbImageView) this.mRoot.findViewById(R.id.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.jNH != null && tbPageContext != null && dVar != null && dVar.fMy != null && dVar.fMy.cNf != null) {
            this.iXu = dVar.fMy.cNf.cNx;
            if (this.iXu != null && !aq.isEmpty(this.iXu.video_url) && this.jNG == null) {
                this.mPageContext = tbPageContext;
                this.jNG = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds164);
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.jJr.startLoad(this.iXu.thumbnail_url, 10, false);
                if (!aq.isEmpty(dVar.fMy.cNf.cNz)) {
                    this.jNI.startLoad(dVar.fMy.cNf.cNz, 10, false);
                } else {
                    this.jNI.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.jNI.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.fMy.cNf.cNA;
                    layoutParams2.height = l.getDimens(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.jNI.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.jNH != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.iXu = gVar.videoInfo;
            if (this.iXu != null && !aq.isEmpty(this.iXu.video_url) && this.jNG == null) {
                this.mPageContext = tbPageContext;
                this.jNG = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.jJr.startLoad(this.iXu.thumbnail_url, 10, false);
                if (!aq.isEmpty(gVar.cNz)) {
                    this.jNI.startLoad(gVar.cNz, 10, false);
                } else {
                    this.jNI.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.jNI.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.cNA;
                    layoutParams2.height = l.getDimens(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.jNI.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jNH;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cwB.setVisibility(0);
        this.jJs.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.jJs.setVisibility(8);
        this.cwB.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jJr.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.jJs.setVisibility(8);
        this.cwB.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJr.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.cwB.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jJr.setVisibility(0);
        this.jJs.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.cwB.setVisibility(8);
        this.jJs.setVisibility(0);
        this.jJr.setVisibility(0);
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
        if (this.jNG == null) {
            return false;
        }
        int playStatus = this.jNG.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jNG == null) {
            return false;
        }
        return this.jNG.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (cDD() && this.iXu != null && this.jNG != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.jNG.startPlay(this.iXu.video_url);
        }
    }

    private boolean cDD() {
        return s.cDD();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jNG != null) {
            this.jNG.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.iXu == null ? "" : this.iXu.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jNG == null) {
            return 0L;
        }
        return this.jNG.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.jNG != null) {
            this.jNG.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.jNG == null) {
            return -2;
        }
        return this.jNG.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.jNc = view;
            this.jNd = true;
        }
    }
}
