package com.baidu.tieba.recapp.lego.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.base.MsgField;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.d.b;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.view.IVrPlayView;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.vr.player.framework.GLTextureView;
import com.baidu.tieba.vr.player.framework.player.VideoListMediaControllerView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVrVideoCardView extends BaseLegoCardView<DistributeVrVideoCard> implements i, IVrPlayView {
    private RelativeLayout dfN;
    private View eNk;
    private VideoInfo fML;
    private a gqg;
    DistributeVrVideoCard gqh;
    private CardGLTextureView gqi;
    private TbImageView gqj;
    private ImageView gqk;
    private VideoListMediaControllerView gql;
    private ImageView gqm;
    private View gqn;
    private boolean gqo;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;
    private View mLoadingView;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dfN = null;
        this.gqi = null;
        this.isBackground = false;
        this.gqo = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gqi == null || DistributeVrVideoCardView.this.gqi.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gqg != null) {
                                    DistributeVrVideoCardView.this.gqg.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gqh.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.eMz != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.eMz.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.o(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gqg != null) {
                                            DistributeVrVideoCardView.this.gqg.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gqg != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gqg.continuePlay();
                                    }
                                }
                            } else if (b.eMy == DistributeVrVideoCardView.this.gqh.getPage()) {
                                if (DistributeVrVideoCardView.this.gqg != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gqg.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gqg != null) {
                                DistributeVrVideoCardView.this.gqg.pausePlay();
                            }
                            DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                            DistributeVrVideoCardView.this.mHandler.sendEmptyMessageDelayed(MsgField.IMSG_DEVICE_NOT_SUPPORT, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        DistributeVrVideoCardView.this.release();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aQw() {
        this.dfN = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.card_distribute_vr_video_view, (ViewGroup) null);
        this.gqi = new CardGLTextureView(this.mContext.getPageActivity());
        this.dfN.addView((View) this.gqi, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gqj = (TbImageView) this.dfN.findViewById(d.g.ad_thumbnail);
        this.gqk = (ImageView) this.dfN.findViewById(d.g.ad_play_button);
        this.mLoadingView = this.dfN.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dfN.findViewById(d.g.ad_error_tips);
        this.gqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gqm = (ImageView) this.dfN.findViewById(d.g.play_icon);
        this.gqn = this.dfN.findViewById(d.g.replay);
        this.eNk = this.dfN.findViewById(d.g.card_layout_media_controller);
        this.gql = this.dfN.findViewById(d.g.card_media_controller);
        return this.dfN;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gqm.setOnClickListener(onClickListener);
        this.gqn.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(DistributeVrVideoCard distributeVrVideoCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(DistributeVrVideoCard distributeVrVideoCard) {
        if (this.gqi != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gqh == null || this.gqh.getVideoInfo() == null || !TextUtils.equals(this.gqh.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gqi.isDestroyed()) {
                if (this.gqi.isDestroyed()) {
                    this.dfN.removeView(this.gqi);
                    this.gqi = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dfN.addView((View) this.gqi, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gqh = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().eMh;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cCm);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eMi);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eMj);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bfC;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bfF);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fML = builder.build(false);
                if (this.fML != null && !ap.isEmpty(this.fML.video_url)) {
                    long bpf = (this.gqg == null || !this.fML.video_url.equalsIgnoreCase(this.gqg.getVideoPath())) ? 0L : this.gqg.bpf();
                    this.gqg = new a(this);
                    if (bpf > 0) {
                        this.gqg.oY((int) bpf);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dfN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ah(getContext());
                        layoutParams.height = l.aj(getContext());
                        this.dfN.setLayoutParams(layoutParams);
                    }
                    this.gqj.startLoad(this.fML.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().eMl) {
                        if (com.baidu.tieba.recapp.lego.a.a.E(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNk.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.eNk.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eNk.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.eNk.setLayoutParams(layoutParams3);
                        }
                        this.eNk.setVisibility(0);
                    } else {
                        this.eNk.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gqi;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        this.gqk.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gqm.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.gqk.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gqj.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gqm.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.gqk.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gqj.setVisibility(8);
        this.gql.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gqm.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gR(true);
        this.gqn.setVisibility(8);
    }

    public void gR(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
        } else {
            this.mLoadingView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gql.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gql.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gql.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gql.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gql.R(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gqm.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        gR(false);
        lT(false);
    }

    public void lT(boolean z) {
        if (z) {
            this.mErrorTip.setVisibility(0);
        } else {
            this.mErrorTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        }
        this.mLoadingView.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gqj.setVisibility(0);
        this.gqk.setVisibility(0);
        this.gql.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gqm.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
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
        return this.mContext;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        if (this.gqg == null) {
            return false;
        }
        int playStatus = this.gqg.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gqg == null) {
            return false;
        }
        return this.gqg.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gqo) {
            this.gqo = false;
            if (!q.bwP()) {
                return;
            }
        }
        if (this.gqh != null && this.fML != null && this.gqg != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gqg.startPlay(DistributeVrVideoCardView.this.fML.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gqg != null) {
            this.gqg.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gqh == null || this.fML == null) ? "" : this.fML.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gqg == null) {
            return 0L;
        }
        return this.gqg.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gqg != null) {
                this.gqg.oY(0);
                this.gqg.destroy();
            }
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return -1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aQE() {
        this.isBackground = false;
        super.aQE();
        if (this.gqi == null || this.gqi.isDestroyed()) {
            e(this.gqh);
        } else if (this.gqg != null) {
            this.gqg.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aQD() {
        this.isBackground = true;
        super.aQD();
        if (this.gqg != null) {
            this.gqg.pausePlay();
            this.gqg.bpg();
        }
    }
}
