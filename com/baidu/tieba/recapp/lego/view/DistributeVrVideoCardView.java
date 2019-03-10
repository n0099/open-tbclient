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
    private ImageView aau;
    private View bhH;
    private RelativeLayout eVc;
    private View gIg;
    private VideoInfo hEI;
    private a ikd;
    DistributeVrVideoCard ike;
    private CardGLTextureView ikf;
    private TbImageView ikg;
    private ImageView ikh;
    private VideoListMediaControllerView iki;
    private View ikj;
    private boolean ikk;
    private boolean isBackground;
    private TextView mErrorTip;
    private Handler mHandler;

    public DistributeVrVideoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eVc = null;
        this.ikf = null;
        this.isBackground = false;
        this.ikk = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ViewGroup viewGroup;
                switch (message.what) {
                    case 30001:
                        if (DistributeVrVideoCardView.this.mContext != null && DistributeVrVideoCardView.this.mContext.getPageActivity() != null && !DistributeVrVideoCardView.this.mContext.getPageActivity().isFinishing()) {
                            if (DistributeVrVideoCardView.this.ikf == null || DistributeVrVideoCardView.this.ikf.isDestroyed()) {
                                DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                                if (DistributeVrVideoCardView.this.ikd != null) {
                                    DistributeVrVideoCardView.this.ikd.destroy();
                                    return;
                                }
                                return;
                            }
                            if (DistributeVrVideoCardView.this.ike.getPage() <= 0) {
                                if (DistributeVrVideoCardView.this.gHu != null && (viewGroup = (ViewGroup) DistributeVrVideoCardView.this.gHu.getParent()) != null) {
                                    int[] iArr = new int[2];
                                    viewGroup.getLocationOnScreen(iArr);
                                    if (Math.abs(iArr[1]) > l.r(DistributeVrVideoCardView.this.mContext.getPageActivity())) {
                                        if (DistributeVrVideoCardView.this.ikd != null) {
                                            DistributeVrVideoCardView.this.ikd.pausePlay();
                                        }
                                    } else if (DistributeVrVideoCardView.this.ikd != null && !DistributeVrVideoCardView.this.isBackground) {
                                        DistributeVrVideoCardView.this.ikd.continuePlay();
                                    }
                                }
                            } else if (b.gHt == DistributeVrVideoCardView.this.ike.getPage()) {
                                if (DistributeVrVideoCardView.this.ikd != null && !DistributeVrVideoCardView.this.isBackground) {
                                    DistributeVrVideoCardView.this.ikd.continuePlay();
                                }
                            } else if (DistributeVrVideoCardView.this.ikd != null) {
                                DistributeVrVideoCardView.this.ikd.pausePlay();
                            }
                            DistributeVrVideoCardView.this.mHandler.removeMessages(30001);
                            DistributeVrVideoCardView.this.mHandler.sendEmptyMessageDelayed(30001, TimeUnit.SECONDS.toMillis(1L));
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
    protected View bAe() {
        this.eVc = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_distribute_vr_video_view, (ViewGroup) null);
        this.ikf = new CardGLTextureView(this.mContext.getPageActivity());
        this.eVc.addView((View) this.ikf, 0, new ViewGroup.LayoutParams(-1, -1));
        this.ikg = (TbImageView) this.eVc.findViewById(d.g.ad_thumbnail);
        this.ikh = (ImageView) this.eVc.findViewById(d.g.ad_play_button);
        this.bhH = this.eVc.findViewById(d.g.ad_loading_view);
        this.mErrorTip = (TextView) this.eVc.findViewById(d.g.ad_error_tips);
        this.ikh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DistributeVrVideoCardView.this.startPlay();
            }
        });
        this.aau = (ImageView) this.eVc.findViewById(d.g.play_icon);
        this.ikj = this.eVc.findViewById(d.g.replay);
        this.gIg = this.eVc.findViewById(d.g.card_layout_media_controller);
        this.iki = this.eVc.findViewById(d.g.card_media_controller);
        return this.eVc;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mErrorTip.setOnClickListener(onClickListener);
        this.aau.setOnClickListener(onClickListener);
        this.ikj.setOnClickListener(onClickListener);
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
        if (this.ikf != null && this.mContext != null && distributeVrVideoCard != null && distributeVrVideoCard.getVideoInfo() != null) {
            if (this.ike == null || this.ike.getVideoInfo() == null || !TextUtils.equals(this.ike.getVideoInfo().videoUrl, distributeVrVideoCard.getVideoInfo().videoUrl) || this.ikf.isDestroyed()) {
                if (this.ikf.isDestroyed()) {
                    this.eVc.removeView(this.ikf);
                    this.ikf = new CardGLTextureView(this.mContext.getPageActivity());
                    this.eVc.addView((View) this.ikf, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                this.ike = distributeVrVideoCard;
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoWidth);
                builder.video_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoHeight);
                builder.video_url = distributeVrVideoCard.getVideoInfo().videoUrl;
                builder.video_md5 = distributeVrVideoCard.getVideoInfo().gHd;
                builder.video_length = Integer.valueOf(distributeVrVideoCard.getVideoInfo().eot);
                builder.thumbnail_width = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gHe);
                builder.thumbnail_height = Integer.valueOf(distributeVrVideoCard.getVideoInfo().gHf);
                builder.thumbnail_url = distributeVrVideoCard.getVideoInfo().thumbUrl;
                builder.play_count = Integer.valueOf(distributeVrVideoCard.getVideoInfo().cDi);
                builder.video_duration = Integer.valueOf(distributeVrVideoCard.getVideoInfo().videoDuration);
                this.hEI = builder.build(false);
                if (this.hEI != null && !ap.isEmpty(this.hEI.video_url)) {
                    long bXd = (this.ikd == null || !this.hEI.video_url.equalsIgnoreCase(this.ikd.getVideoPath())) ? 0L : this.ikd.bXd();
                    this.ikd = new a(this);
                    if (bXd > 0) {
                        this.ikd.va((int) bXd);
                    }
                    ViewGroup.LayoutParams layoutParams = this.eVc.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = l.aO(getContext());
                        layoutParams.height = l.aQ(getContext());
                        this.eVc.setLayoutParams(layoutParams);
                    }
                    this.ikg.startLoad(this.hEI.thumbnail_url, 10, false);
                    if (distributeVrVideoCard.getVideoInfo().gHh) {
                        if (com.baidu.tieba.recapp.lego.a.a.al(this.mContext.getPageActivity())) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gIg.getLayoutParams();
                            layoutParams2.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds32) + 0.5f);
                            this.gIg.setLayoutParams(layoutParams2);
                        } else {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gIg.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
                            this.gIg.setLayoutParams(layoutParams3);
                        }
                        this.gIg.setVisibility(0);
                    } else {
                        this.gIg.setVisibility(8);
                    }
                    startPlay();
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public GLTextureView getGLView() {
        return this.ikf;
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void loading() {
        this.mErrorTip.setVisibility(8);
        this.bhH.setVisibility(0);
        this.ikh.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void error() {
        this.aau.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.ikh.setVisibility(8);
        this.bhH.setVisibility(8);
        this.mErrorTip.setVisibility(0);
        this.ikg.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void play() {
        this.aau.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midplay));
        this.ikh.setVisibility(8);
        this.bhH.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ikg.setVisibility(8);
        this.iki.showProgress();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void buffer() {
        this.aau.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        cE(true);
        this.ikj.setVisibility(8);
    }

    public void cE(boolean z) {
        if (z) {
            this.bhH.setVisibility(0);
        } else {
            this.bhH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.iki.setPlayer(mediaPlayerControl);
    }

    public void setOnProgressUpdateListener(VideoControllerView.b bVar) {
        this.iki.setOnProgressUpdatedListener(bVar);
    }

    public void setOnDragListener(VideoControllerView.a aVar) {
        this.iki.setOnDragingListener(aVar);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.iki.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void setSeekBarTime(int i, int i2) {
        this.iki.ax(i, i2);
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void pause() {
        this.aau.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        cE(false);
        pl(false);
    }

    public void pl(boolean z) {
        if (z) {
            this.mErrorTip.setVisibility(0);
        } else {
            this.mErrorTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
        }
        this.bhH.setVisibility(8);
        this.mErrorTip.setVisibility(8);
        this.ikg.setVisibility(0);
        this.ikh.setVisibility(0);
        this.iki.destroy();
    }

    @Override // com.baidu.tieba.recapp.view.IVrPlayView
    public void complete() {
        this.aau.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_video_midpause));
        this.mErrorTip.setVisibility(8);
        this.bhH.setVisibility(8);
        this.ikh.setVisibility(0);
        this.ikg.setVisibility(0);
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
        if (this.ikd == null) {
            return false;
        }
        int playStatus = this.ikd.getPlayStatus();
        return playStatus == 0 || playStatus == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        if (this.ikd == null) {
            return false;
        }
        return this.ikd.getPlayStatus() == 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        if (this.ikk) {
            this.ikk = false;
            if (!q.cdF()) {
                return;
            }
        }
        if (this.ike != null && this.hEI != null && this.ikd != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler.sendEmptyMessage(30001);
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    DistributeVrVideoCardView.this.ikd.startPlay(DistributeVrVideoCardView.this.hEI.video_url);
                }
            }, TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        this.mHandler.removeMessages(30001);
        if (this.ikd != null) {
            this.ikd.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return (this.ike == null || this.hEI == null) ? "" : this.hEI.video_url;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        if (this.ikd == null) {
            return 0L;
        }
        return this.ikd.getCurrentPos();
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(30001);
            this.mHandler = null;
            if (this.ikd != null) {
                this.ikd.va(0);
                this.ikd.destroy();
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
    public void bAk() {
        this.isBackground = false;
        super.bAk();
        if (this.ikf == null || this.ikf.isDestroyed()) {
            e(this.ike);
        } else if (this.ikd != null) {
            this.ikd.continuePlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void Pq() {
        this.isBackground = true;
        super.Pq();
        if (this.ikd != null) {
            this.ikd.pausePlay();
            this.ikd.bXe();
        }
    }
}
