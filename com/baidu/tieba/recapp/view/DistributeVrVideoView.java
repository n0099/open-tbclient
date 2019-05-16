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
    private View bBg;
    private View bnR;
    private VideoInfo hWp;
    private TbImageView iCy;
    private ImageView iCz;
    private DistributeVrPlayController iGJ;
    private GLTextureView iGK;
    private TbImageView iGL;
    private View iGk;
    private boolean iGl;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.bBg = null;
        this.iGl = false;
        this.mContext = null;
        this.iGK = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iGl || DistributeVrVideoView.this.iGk == null || DistributeVrVideoView.this.iGk.getParent() != null) {
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
        this.bBg = null;
        this.iGl = false;
        this.mContext = null;
        this.iGK = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iGl || DistributeVrVideoView.this.iGk == null || DistributeVrVideoView.this.iGk.getParent() != null) {
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
        this.bBg = null;
        this.iGl = false;
        this.mContext = null;
        this.iGK = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iGl || DistributeVrVideoView.this.iGk == null || DistributeVrVideoView.this.iGk.getParent() != null) {
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
        this.bBg = LayoutInflater.from(context).inflate(R.layout.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.iGK = this.bBg.findViewById(R.id.ad_gl_view);
        this.iCy = (TbImageView) this.bBg.findViewById(R.id.ad_thumbnail);
        this.iCz = (ImageView) this.bBg.findViewById(R.id.ad_play_button);
        this.bnR = this.bBg.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.bBg.findViewById(R.id.ad_error_tips);
        this.iGL = (TbImageView) this.bBg.findViewById(R.id.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.iGK != null && tbPageContext != null && dVar != null && dVar.eAA != null && dVar.eAA.bEc != null) {
            this.hWp = dVar.eAA.bEc.bEu;
            if (this.hWp != null && !ap.isEmpty(this.hWp.video_url) && this.iGJ == null) {
                this.mPageContext = tbPageContext;
                this.iGJ = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.bBg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds164);
                    layoutParams.height = layoutParams.width;
                    this.bBg.setLayoutParams(layoutParams);
                }
                this.iCy.startLoad(this.hWp.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.eAA.bEc.bEw)) {
                    this.iGL.startLoad(dVar.eAA.bEc.bEw, 10, false);
                } else {
                    this.iGL.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iGL.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.eAA.bEc.bEx;
                    layoutParams2.height = l.g(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iGL.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.iGK != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.hWp = gVar.videoInfo;
            if (this.hWp != null && !ap.isEmpty(this.hWp.video_url) && this.iGJ == null) {
                this.mPageContext = tbPageContext;
                this.iGJ = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.bBg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.bBg.setLayoutParams(layoutParams);
                }
                this.iCy.startLoad(this.hWp.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.bEw)) {
                    this.iGL.startLoad(gVar.bEw, 10, false);
                } else {
                    this.iGL.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iGL.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bEx;
                    layoutParams2.height = l.g(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iGL.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iGK;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(0);
        this.iCz.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.iCz.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iCy.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.iCz.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCy.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCy.setVisibility(0);
        this.iCz.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(8);
        this.iCz.setVisibility(0);
        this.iCy.setVisibility(0);
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
        if (this.iGJ == null) {
            return false;
        }
        int playStatus = this.iGJ.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iGJ == null) {
            return false;
        }
        return this.iGJ.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bXm() && this.hWp != null && this.iGJ != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.iGJ.startPlay(this.hWp.video_url);
        }
    }

    private boolean bXm() {
        return q.bXm();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iGJ != null) {
            this.iGJ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hWp == null ? "" : this.hWp.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iGJ == null) {
            return 0L;
        }
        return this.iGJ.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.iGJ != null) {
            this.iGJ.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.iGJ == null) {
            return -2;
        }
        return this.iGJ.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.iGk = view;
            this.iGl = true;
        }
    }
}
