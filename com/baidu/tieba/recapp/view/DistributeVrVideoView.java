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
/* loaded from: classes11.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View csy;
    private VideoInfo iWd;
    private TbImageView jIt;
    private ImageView jIu;
    private DistributeVrPlayController jME;
    private GLTextureView jMF;
    private TbImageView jMG;
    private View jMe;
    private boolean jMf;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;
    private View mRoot;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.mRoot = null;
        this.jMf = false;
        this.mContext = null;
        this.jMF = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.jMf || DistributeVrVideoView.this.jMe == null || DistributeVrVideoView.this.jMe.getParent() != null) {
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
        this.jMf = false;
        this.mContext = null;
        this.jMF = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.jMf || DistributeVrVideoView.this.jMe == null || DistributeVrVideoView.this.jMe.getParent() != null) {
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
        this.jMf = false;
        this.mContext = null;
        this.jMF = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.jMf || DistributeVrVideoView.this.jMe == null || DistributeVrVideoView.this.jMe.getParent() != null) {
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
        this.jMF = this.mRoot.findViewById(R.id.ad_gl_view);
        this.jIt = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.jIu = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.csy = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.jMG = (TbImageView) this.mRoot.findViewById(R.id.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.jMF != null && tbPageContext != null && dVar != null && dVar.fJZ != null && dVar.fJZ.cJb != null) {
            this.iWd = dVar.fJZ.cJb.cJt;
            if (this.iWd != null && !aq.isEmpty(this.iWd.video_url) && this.jME == null) {
                this.mPageContext = tbPageContext;
                this.jME = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds164);
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.jIt.startLoad(this.iWd.thumbnail_url, 10, false);
                if (!aq.isEmpty(dVar.fJZ.cJb.cJv)) {
                    this.jMG.startLoad(dVar.fJZ.cJb.cJv, 10, false);
                } else {
                    this.jMG.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.jMG.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.fJZ.cJb.cJw;
                    layoutParams2.height = l.getDimens(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.jMG.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.jMF != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.iWd = gVar.videoInfo;
            if (this.iWd != null && !aq.isEmpty(this.iWd.video_url) && this.jME == null) {
                this.mPageContext = tbPageContext;
                this.jME = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.jIt.startLoad(this.iWd.thumbnail_url, 10, false);
                if (!aq.isEmpty(gVar.cJv)) {
                    this.jMG.startLoad(gVar.cJv, 10, false);
                } else {
                    this.jMG.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.jMG.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.cJw;
                    layoutParams2.height = l.getDimens(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.jMG.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.jMF;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.csy.setVisibility(0);
        this.jIu.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.jIu.setVisibility(8);
        this.csy.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.jIt.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.jIu.setVisibility(8);
        this.csy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jIt.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.csy.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.jIt.setVisibility(0);
        this.jIu.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.csy.setVisibility(8);
        this.jIu.setVisibility(0);
        this.jIt.setVisibility(0);
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
        if (this.jME == null) {
            return false;
        }
        int playStatus = this.jME.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.jME == null) {
            return false;
        }
        return this.jME.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (csN() && this.iWd != null && this.jME != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.jME.startPlay(this.iWd.video_url);
        }
    }

    private boolean csN() {
        return s.csN();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.jME != null) {
            this.jME.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.iWd == null ? "" : this.iWd.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.jME == null) {
            return 0L;
        }
        return this.jME.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.jME != null) {
            this.jME.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.jME == null) {
            return -2;
        }
        return this.jME.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.jMe = view;
            this.jMf = true;
        }
    }
}
