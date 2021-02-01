package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.alphavideo.c;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes11.dex */
public class AlaAudioVideoLayout extends RelativeLayout {
    private com.baidu.live.alphavideo.c bei;
    private MediaMetadataRetriever bem;
    private boolean mStopped;
    private String mVideoPath;
    private d oII;

    public AlaAudioVideoLayout(Context context) {
        super(context);
    }

    public void setData(String str) {
        this.mVideoPath = str;
        int[] gF = gF(str);
        R(gF[0], gF[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gF(String str) {
        int i;
        int i2;
        int i3;
        if (this.bem == null) {
            this.bem = new MediaMetadataRetriever();
        }
        try {
            this.bem.setDataSource(str);
            i = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                i2 = 0;
                if (i > 0) {
                }
                if (i2 <= 0) {
                }
                return new int[]{i3, i2};
            }
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        if (i > 0) {
            i3 = FormCard.WIDTH_DEFAULT_SIZE;
        } else {
            i3 = i / 2;
        }
        if (i2 <= 0) {
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        return new int[]{i3, i2};
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setVideoCallback(d dVar) {
        this.oII = dVar;
    }

    public void startAnim() {
        this.mStopped = false;
        if (this.bei != null && !this.bei.isDestroyed() && !TextUtils.isEmpty(this.mVideoPath)) {
            this.bei.play(this.mVideoPath);
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.bei != null) {
            this.bei.stop();
            this.bei.reset();
        }
        if (this.bem != null) {
            this.bem.release();
        }
    }

    private void R(int i, int i2) {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        GY();
        if (indexOfChild(this.bei.getView()) < 0) {
            addView(this.bei.getView());
        }
        S(i, i2);
    }

    private void GY() {
        this.bei.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.AlaAudioVideoLayout.1
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaAudioVideoLayout.this.oII != null) {
                    AlaAudioVideoLayout.this.oII.EM(AlaAudioVideoLayout.this.mVideoPath);
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaAudioVideoLayout.this.mStopped && AlaAudioVideoLayout.this.oII != null) {
                    AlaAudioVideoLayout.this.oII.Ww(AlaAudioVideoLayout.this.mVideoPath);
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                if (AlaAudioVideoLayout.this.oII != null) {
                    AlaAudioVideoLayout.this.oII.onFail(AlaAudioVideoLayout.this.mVideoPath);
                }
            }
        });
    }

    private void S(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bei.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bei.getView().setLayoutParams(layoutParams);
    }
}
