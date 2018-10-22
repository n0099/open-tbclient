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
import com.baidu.adp.lib.util.l;
import com.baidu.ar.base.MsgField;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
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
    private View dlx;
    private RelativeLayout dww;
    private View fge;
    private a gGm;
    DistributeVrVideoCard gGn;
    private CardGLTextureView gGo;
    private TbImageView gGp;
    private ImageView gGq;
    private VideoListMediaControllerView gGr;
    private ImageView gGs;
    private View gGt;
    private boolean gGu;
    private VideoInfo gcn;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dww = null;
        this.gGo = null;
        this.isBackground = false;
        this.gGu = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case MsgField.IMSG_DEVICE_NOT_SUPPORT /* 30001 */:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.gGo == null || DistributeVrVideoCardView.this.gGo.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
                                if (DistributeVrVideoCardView.this.gGm != null) {
                                    DistributeVrVideoCardView.this.gGm.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.gGn.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.ffs != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.ffs.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.gGm != null) {
                                            DistributeVrVideoCardView.this.gGm.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.gGm != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.gGm.continuePlay();
                                    }
                                }
                            } else if (b.ffr == DistributeVrVideoCardView.this.gGn.getPage()) {
                                if (DistributeVrVideoCardView.this.gGm != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.gGm.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.gGm != null) {
                                DistributeVrVideoCardView.this.gGm.pausePlay();
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
    protected View aWW() {
        this.dww = (RelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.gGo = new CardGLTextureView(this.mContext.getPageActivity());
        this.dww.addView((View) this.gGo, 0, new ViewGroup.LayoutParams(-1, -1));
        this.gGp = (TbImageView) this.dww.findViewById(e.g.ad_thumbnail);
        this.gGq = (ImageView) this.dww.findViewById(e.g.ad_play_button);
        this.dlx = this.dww.findViewById(e.g.ad_loading_view);
        this.mErrorTip = (TextView) this.dww.findViewById(e.g.ad_error_tips);
        this.gGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.gGs = (ImageView) this.dww.findViewById(e.g.play_icon);
        this.gGt = this.dww.findViewById(e.g.replay);
        this.fge = this.dww.findViewById(e.g.card_layout_media_controller);
        this.gGr = this.dww.findViewById(e.g.card_media_controller);
        return this.dww;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.gGs.setOnClickListener(onClickListener);
        this.gGt.setOnClickListener(onClickListener);
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
        if (this.gGo != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.gGn == null || this.gGn.getVideoInfo() == null || !TextUtils.equals(this.gGn.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.gGo.isDestroyed()) {
                if (this.gGo.isDestroyed()) {
                    this.dww.removeView(this.gGo);
                    this.gGo = new CardGLTextureView(this.mContext.getPageActivity());
                    this.dww.addView((View) this.gGo, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.gGn = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().ffa;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cSY);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().ffb);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().ffc);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().bno;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().bnr);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.gcn = builder.build(false);
                if (this.gcn != null && !ao.isEmpty(this.gcn.video_url)) {
                    long btG = (this.gGm == null || !this.gcn.video_url.equalsIgnoreCase(this.gGm.getVideoPath())) ? 0L : this.gGm.btG();
                    this.gGm = new a(this);
                    if (btG > 0) {
                        this.gGm.qp((int) btG);
                    }
                    ViewGroup.LayoutParams layoutParams = this.dww.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.dww.setLayoutParams(layoutParams);
                    }
                    this.gGp.startLoad(this.gcn.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().ffe) {
                        if (com.baidu.tieba.recapp.lego.a.a.J(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fge.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0175e.ds32) + 0.5f);
                            this.fge.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fge.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(e.C0175e.ds30) + 0.5f);
                            this.fge.setLayoutParams(layoutParams3);
                        }
                        this.fge.setVisibility(0);
                    } else {
                        this.fge.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.gGo;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.dlx.setVisibility(0);
        this.gGq.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.gGs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.gGq.setVisibility(8);
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.gGp.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.gGs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midplay));
        this.gGq.setVisibility(8);
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gGp.setVisibility(8);
        this.gGr.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.gGs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        hK(true);
        this.gGt.setVisibility(8);
    }

    public void hK(boolean z) {
        if (z) {
            this.dlx.setVisibility(0);
        } else {
            this.dlx.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gGr.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.gGr.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.gGr.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gGr.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.gGr.X(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.gGs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        hK(false);
        mv(false);
    }

    public void mv(boolean z) {
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
        this.dlx.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.gGp.setVisibility(0);
        this.gGq.setVisibility(0);
        this.gGr.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.gGs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.dlx.setVisibility(8);
        this.gGq.setVisibility(0);
        this.gGp.setVisibility(0);
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
        if (this.gGm == null) {
            return false;
        }
        int playStatus = this.gGm.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.gGm == null) {
            return false;
        }
        return this.gGm.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.gGu) {
            this.gGu = false;
            if (!q.bBp()) {
                return;
            }
        }
        if (this.gGn != null && this.gcn != null && this.gGm != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler.sendEmptyMessage(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.gGm.startPlay(DistributeVrVideoCardView.this.gcn.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
        if (this.gGm != null) {
            this.gGm.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.gGn == null || this.gcn == null) ? "" : this.gcn.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.gGm == null) {
            return 0L;
        }
        return this.gGm.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MsgField.IMSG_DEVICE_NOT_SUPPORT);
            this.mHandler = null;
            if (this.gGm != null) {
                this.gGm.qp(0);
                this.gGm.destroy();
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
    public void aXd() {
        this.isBackground = false;
        super.aXd();
        if (this.gGo == null || this.gGo.isDestroyed()) {
            e(this.gGn);
        } else if (this.gGm != null) {
            this.gGm.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aXc() {
        this.isBackground = true;
        super.aXc();
        if (this.gGm != null) {
            this.gGm.pausePlay();
            this.gGm.btH();
        }
    }
}
