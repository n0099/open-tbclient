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
import com.baidu.tieba.f;
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
    private View cXu;
    private RelativeLayout diB;
    private View eRb;
    private VideoInfo fMS;
    private View grA;
    private boolean grB;
    private a grt;
    DistributeVrVideoCard gru;
    private CardGLTextureView grv;
    private TbImageView grw;
    private ImageView grx;
    private VideoListMediaControllerView gry;
    private ImageView grz;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.diB = null;
        this.grv = null;
        this.isBackground = false;
        this.grB = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.grv == null || DistributeVrVideoCardView.this.grv.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.grt != null) {
                                    DistributeVrVideoCardView.this.grt.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gru.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.eQp != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.eQp.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.n(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.grt != null) {
                                            DistributeVrVideoCardView.this.grt.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.grt != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.grt.continuePlay();
                                    }
                                }
                            } else if (b.eQo == DistributeVrVideoCardView.this.gru.getPage()) {
                                if (DistributeVrVideoCardView.this.grt != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.grt.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.grt != null) {
                                DistributeVrVideoCardView.this.grt.pausePlay();
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
    protected View aRu() {
        this.diB = (RelativeLayout) LayoutInflater.from(getContext()).inflate(f.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.grv = new CardGLTextureView(this.mContext.getPageActivity());
        this.diB.addView((View) this.grv, 0, new ViewGroup.LayoutParams(-1, -1));
        this.grw = (TbImageView) this.diB.findViewById(f.g.ad_thumbnail);
        this.grx = (ImageView) this.diB.findViewById(f.g.ad_play_button);
        this.cXu = this.diB.findViewById(f.g.ad_loading_view);
        this.mErrorTip = (TextView) this.diB.findViewById(f.g.ad_error_tips);
        this.grx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.grz = (ImageView) this.diB.findViewById(f.g.play_icon);
        this.grA = this.diB.findViewById(f.g.replay);
        this.eRb = this.diB.findViewById(f.g.card_layout_media_controller);
        this.gry = this.diB.findViewById(f.g.card_media_controller);
        return this.diB;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.grz.setOnClickListener(onClickListener);
        this.grA.setOnClickListener(onClickListener);
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
        if (this.grv != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gru == null || this.gru.getVideoInfo() == null || !TextUtils.equals(this.gru.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.grv.isDestroyed()) {
                if (this.grv.isDestroyed()) {
                    this.diB.removeView(this.grv);
                    this.grv = new CardGLTextureView(this.mContext.getPageActivity());
                    this.diB.addView((View) this.grv, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gru = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().ePX;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cEO);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().ePY);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().ePZ);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bfP;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bfS);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.fMS = builder.build(false);
                if (this.fMS != null && !ap.isEmpty(this.fMS.video_url)) {
                    long bnK = (this.grt == null || !this.fMS.video_url.equalsIgnoreCase(this.grt.getVideoPath())) ? 0L : this.grt.bnK();
                    this.grt = new a(this);
                    if (bnK > 0) {
                        this.grt.pn((int) bnK);
                    }
                    ViewGroup.LayoutParams layoutParams = this.diB.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.ah(getContext());
                        layoutParams.height = l.aj(getContext());
                        this.diB.setLayoutParams(layoutParams);
                    }
                    this.grw.startLoad(this.fMS.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().eQb) {
                        if (com.baidu.tieba.recapp.lego.a.a.F(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRb.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(f.e.ds32) + 0.5f);
                            this.eRb.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eRb.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(f.e.ds30) + 0.5f);
                            this.eRb.setLayoutParams(layoutParams3);
                        }
                        this.eRb.setVisibility(0);
                    } else {
                        this.eRb.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.grv;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.cXu.setVisibility(0);
        this.grx.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.grz.setImageDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_video_midpause));
        this.grx.setVisibility(8);
        this.cXu.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.grw.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.grz.setImageDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_video_midplay));
        this.grx.setVisibility(8);
        this.cXu.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grw.setVisibility(8);
        this.gry.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.grz.setImageDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_video_midpause));
        gU(true);
        this.grA.setVisibility(8);
    }

    public void gU(boolean z) {
        if (z) {
            this.cXu.setVisibility(0);
        } else {
            this.cXu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gry.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gry.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gry.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gry.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gry.T(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.grz.setImageDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_video_midpause));
        gU(false);
        lE(false);
    }

    public void lE(boolean z) {
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
        this.cXu.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.grw.setVisibility(0);
        this.grx.setVisibility(0);
        this.gry.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.grz.setImageDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.cXu.setVisibility(8);
        this.grx.setVisibility(0);
        this.grw.setVisibility(0);
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
        if (this.grt == null) {
            return false;
        }
        int playStatus = this.grt.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.grt == null) {
            return false;
        }
        return this.grt.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.grB) {
            this.grB = false;
            if (!q.bvu()) {
                return;
            }
        }
        if (this.gru != null && this.fMS != null && this.grt != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.grt.startPlay(DistributeVrVideoCardView.this.fMS.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.grt != null) {
            this.grt.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gru == null || this.fMS == null) ? "" : this.fMS.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.grt == null) {
            return 0L;
        }
        return this.grt.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.grt != null) {
                this.grt.pn(0);
                this.grt.destroy();
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
    public void aRC() {
        this.isBackground = false;
        super.aRC();
        if (this.grv == null || this.grv.isDestroyed()) {
            e(this.gru);
        } else if (this.grt != null) {
            this.grt.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aRB() {
        this.isBackground = true;
        super.aRB();
        if (this.grt != null) {
            this.grt.pausePlay();
            this.grt.bnL();
        }
    }
}
