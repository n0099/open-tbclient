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
/* loaded from: classes3.dex */
public class DistributeVrVideoView extends RelativeLayout implements i, IVrPlayView {
    private View bHO;
    private TbImageView iLm;
    private ImageView iLn;
    private DistributeVrPlayController iPA;
    private GLTextureView iPB;
    private TbImageView iPC;
    private View iPb;
    private boolean iPc;
    private VideoInfo iep;
    private Context mContext;
    private TextView mErrorTip;
    private Handler mHandler;
    private TbPageContext<?> mPageContext;
    private View mRoot;

    public DistributeVrVideoView(Context context) {
        super(context);
        this.mRoot = null;
        this.iPc = false;
        this.mContext = null;
        this.iPB = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iPc || DistributeVrVideoView.this.iPb == null || DistributeVrVideoView.this.iPb.getParent() != null) {
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
        this.iPc = false;
        this.mContext = null;
        this.iPB = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iPc || DistributeVrVideoView.this.iPb == null || DistributeVrVideoView.this.iPb.getParent() != null) {
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
        this.iPc = false;
        this.mContext = null;
        this.iPB = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVrVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 30001:
                        if (!DistributeVrVideoView.this.iPc || DistributeVrVideoView.this.iPb == null || DistributeVrVideoView.this.iPb.getParent() != null) {
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
        this.iPB = this.mRoot.findViewById(R.id.ad_gl_view);
        this.iLm = (TbImageView) this.mRoot.findViewById(R.id.ad_thumbnail);
        this.iLn = (ImageView) this.mRoot.findViewById(R.id.ad_play_button);
        this.bHO = this.mRoot.findViewById(R.id.ad_loading_view);
        this.mErrorTip = (TextView) this.mRoot.findViewById(R.id.ad_error_tips);
        this.iPC = (TbImageView) this.mRoot.findViewById(R.id.ad_brand);
    }

    public void setData(TbPageContext<?> tbPageContext, d dVar) {
        if (this.iPB != null && tbPageContext != null && dVar != null && dVar.ePS != null && dVar.ePS.bXu != null) {
            this.iep = dVar.ePS.bXu.bXM;
            if (this.iep != null && !aq.isEmpty(this.iep.video_url) && this.iPA == null) {
                this.mPageContext = tbPageContext;
                this.iPA = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds164);
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.iLm.startLoad(this.iep.thumbnail_url, 10, false);
                if (!aq.isEmpty(dVar.ePS.bXu.bXO)) {
                    this.iPC.startLoad(dVar.ePS.bXu.bXO, 10, false);
                } else {
                    this.iPC.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iPC.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = dVar.ePS.bXu.bXP;
                    layoutParams2.height = l.getDimens(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iPC.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, AdCard adCard, int i) {
        if (this.iPB != null && tbPageContext != null && adCard != null && adCard.vrVideoInfo != null) {
            AdCard.g gVar = adCard.vrVideoInfo;
            this.iep = gVar.videoInfo;
            if (this.iep != null && !aq.isEmpty(this.iep.video_url) && this.iPA == null) {
                this.mPageContext = tbPageContext;
                this.iPA = new DistributeVrPlayController(this);
                ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = layoutParams.width;
                    this.mRoot.setLayoutParams(layoutParams);
                }
                this.iLm.startLoad(this.iep.thumbnail_url, 10, false);
                if (!aq.isEmpty(gVar.bXO)) {
                    this.iPC.startLoad(gVar.bXO, 10, false);
                } else {
                    this.iPC.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.iPC.getLayoutParams();
                if (layoutParams2 != null) {
                    float f = gVar.bXP;
                    layoutParams2.height = l.getDimens(this.mContext, R.dimen.ds60);
                    layoutParams2.width = f > 0.0f ? (int) (f * layoutParams2.height) : layoutParams2.height;
                    this.iPC.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.iPB;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bHO.setVisibility(0);
        this.iLn.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.iLn.setVisibility(8);
        this.bHO.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.iLm.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.iLn.setVisibility(8);
        this.bHO.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iLm.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        this.bHO.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.iLm.setVisibility(0);
        this.iLn.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.mErrorTip.setVisibility(8);
        this.bHO.setVisibility(8);
        this.iLn.setVisibility(0);
        this.iLm.setVisibility(0);
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
        if (this.iPA == null) {
            return false;
        }
        int playStatus = this.iPA.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.iPA == null) {
            return false;
        }
        return this.iPA.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (bYn() && this.iep != null && this.iPA != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            this.iPA.startPlay(this.iep.video_url);
        }
    }

    private boolean bYn() {
        return s.bYn();
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.iPA != null) {
            this.iPA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.iep == null ? "" : this.iep.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.iPA == null) {
            return 0L;
        }
        return this.iPA.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        this.mHandler.removeMessages(30001);
        if (this.iPA != null) {
            this.iPA.destroy();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        if (this.iPA == null) {
            return -2;
        }
        return this.iPA.getPlayStatus();
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        startPlay();
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.iPb = view;
            this.iPc = true;
        }
    }
}
