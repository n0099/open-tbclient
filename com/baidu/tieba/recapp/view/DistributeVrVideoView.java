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
    private VideoInfo hWs;
    private TbImageView iCA;
    private ImageView iCB;
    private DistributeVrPlayController iGL;
    private GLTextureView iGM;
    private TbImageView iGN;
    private View iGm;
    private boolean iGn;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.bBg = null;
        this.iGn = false;
        this.mContext = null;
        this.iGM = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iGn || DistributeVrVideoView.this.iGm == null || DistributeVrVideoView.this.iGm.getParent() != null) {
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
        this.iGn = false;
        this.mContext = null;
        this.iGM = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iGn || DistributeVrVideoView.this.iGm == null || DistributeVrVideoView.this.iGm.getParent() != null) {
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
        this.iGn = false;
        this.mContext = null;
        this.iGM = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iGn || DistributeVrVideoView.this.iGm == null || DistributeVrVideoView.this.iGm.getParent() != null) {
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
        this.iGM = this.bBg.findViewById(R.id.ad_gl_view);
        this.iCA = (TbImageView) this.bBg.findViewById(R.id.ad_thumbnail);
        this.iCB = (ImageView) this.bBg.findViewById(R.id.ad_play_button);
        this.bnR = this.bBg.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.bBg.findViewById(R.id.ad_error_tips);
        this.iGN = (TbImageView) this.bBg.findViewById(R.id.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.iGM != null && tbPageContext != null && dVar != null && dVar.eAB != null && dVar.eAB.bEc != null) {
            this.hWs = dVar.eAB.bEc.bEu;
            if (this.hWs != null && !ap.isEmpty(this.hWs.video_url) && this.iGL == null) {
                this.mPageContext = tbPageContext;
                this.iGL = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.bBg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds164);
                    layoutParams.height = layoutParams.width;
                    this.bBg.setLayoutParams(layoutParams);
                }
                this.iCA.startLoad(this.hWs.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.eAB.bEc.bEw)) {
                    this.iGN.startLoad(dVar.eAB.bEc.bEw, 10, false);
                } else {
                    this.iGN.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iGN.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.eAB.bEc.bEx;
                    layoutParams2.height = l.g(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iGN.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.iGM != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.hWs = gVar.videoInfo;
            if (this.hWs != null && !ap.isEmpty(this.hWs.video_url) && this.iGL == null) {
                this.mPageContext = tbPageContext;
                this.iGL = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.bBg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.bBg.setLayoutParams(layoutParams);
                }
                this.iCA.startLoad(this.hWs.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.bEw)) {
                    this.iGN.startLoad(gVar.bEw, 10, false);
                } else {
                    this.iGN.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iGN.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bEx;
                    layoutParams2.height = l.g(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iGN.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iGM;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(0);
        this.iCB.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.iCB.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iCA.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.iCB.setVisibility(8);
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCA.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bnR.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iCA.setVisibility(0);
        this.iCB.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bnR.setVisibility(8);
        this.iCB.setVisibility(0);
        this.iCA.setVisibility(0);
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
        if (this.iGL == null) {
            return false;
        }
        int playStatus = this.iGL.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iGL == null) {
            return false;
        }
        return this.iGL.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bXp() && this.hWs != null && this.iGL != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.iGL.startPlay(this.hWs.video_url);
        }
    }

    private boolean bXp() {
        return q.bXp();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iGL != null) {
            this.iGL.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hWs == null ? "" : this.hWs.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iGL == null) {
            return 0L;
        }
        return this.iGL.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.iGL != null) {
            this.iGL.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.iGL == null) {
            return -2;
        }
        return this.iGL.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.iGm = view;
            this.iGn = true;
        }
    }
}
