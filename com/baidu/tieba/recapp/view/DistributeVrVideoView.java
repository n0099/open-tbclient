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
    private View abt;
    private VideoInfo fML;
    private TbImageView gqj;
    private ImageView gqk;
    private View gtT;
    private boolean gtU;
    private DistributeVrPlayController gup;
    private GLTextureView guq;
    private TbImageView gur;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;
    private TbPageContext<?> mPageContext;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.abt = null;
        this.gtU = false;
        this.mContext = null;
        this.guq = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gtU || DistributeVrVideoView.this.gtT == null || DistributeVrVideoView.this.gtT.getParent() != null) {
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
        this.abt = null;
        this.gtU = false;
        this.mContext = null;
        this.guq = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gtU || DistributeVrVideoView.this.gtT == null || DistributeVrVideoView.this.gtT.getParent() != null) {
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
        this.abt = null;
        this.gtU = false;
        this.mContext = null;
        this.guq = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (!DistributeVrVideoView.this.gtU || DistributeVrVideoView.this.gtT == null || DistributeVrVideoView.this.gtT.getParent() != null) {
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
        this.abt = LayoutInflater.from(context).inflate(d.i.distribute_vr_video_view, (ViewGroup) this, true);
        this.mContext = context;
        this.guq = this.abt.findViewById(d.g.ad_gl_view);
        this.gqj = (TbImageView) this.abt.findViewById(d.g.ad_thumbnail);
        this.gqk = (ImageView) this.abt.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.abt.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.abt.findViewById(d.g.ad_error_tips);
        this.gur = (TbImageView) this.abt.findViewById(d.g.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, com.baidu.tieba.card.data.d dVar) {
        if (this.guq != null && tbPageContext != null && dVar != null && dVar.czn != null && dVar.czn.aem != null) {
            this.fML = dVar.czn.aem.aeE;
            if (this.fML != null && !ap.isEmpty(this.fML.video_url) && this.gup == null) {
                this.mPageContext = tbPageContext;
                this.gup = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.abt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.ah(this.mContext) - l.e(this.mContext, d.e.ds164);
                    layoutParams.height = layoutParams.width;
                    this.abt.setLayoutParams(layoutParams);
                }
                this.gqj.startLoad(this.fML.thumbnail_url, 10, false);
                if (!ap.isEmpty(dVar.czn.aem.aeG)) {
                    this.gur.startLoad(dVar.czn.aem.aeG, 10, false);
                } else {
                    this.gur.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gur.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.czn.aem.aeH;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gur.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.guq != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.fML = gVar.videoInfo;
            if (this.fML != null && !ap.isEmpty(this.fML.video_url) && this.gup == null) {
                this.mPageContext = tbPageContext;
                this.gup = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.abt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.abt.setLayoutParams(layoutParams);
                }
                this.gqj.startLoad(this.fML.thumbnail_url, 10, false);
                if (!ap.isEmpty(gVar.aeG)) {
                    this.gur.startLoad(gVar.aeG, 10, false);
                } else {
                    this.gur.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.gur.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.aeH;
                    layoutParams2.height = l.e(this.mContext, d.e.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.gur.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.guq;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gqk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gqk.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gqj.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gqk.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gqj.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gqj.setVisibility(0);
        this.gqk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.gqk.setVisibility(0);
        this.gqj.setVisibility(0);
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
        if (this.gup == null) {
            return false;
        }
        int playStatus = this.gup.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gup == null) {
            return false;
        }
        return this.gup.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bio() && this.fML != null && this.gup != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.gup.startPlay(this.fML.video_url);
        }
    }

    private boolean bio() {
        return q.bio();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gup != null) {
            this.gup.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.fML == null ? "" : this.fML.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gup == null) {
            return 0L;
        }
        return this.gup.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gup != null) {
            this.gup.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.gup == null) {
            return -2;
        }
        return this.gup.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.gtT = view;
            this.gtU = true;
        }
    }
}
