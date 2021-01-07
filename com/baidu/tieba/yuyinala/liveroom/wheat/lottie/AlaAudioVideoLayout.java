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
    private com.baidu.live.alphavideo.c bfS;
    private MediaMetadataRetriever bfW;
    private boolean mStopped;
    private String mVideoPath;
    private d oDF;

    public AlaAudioVideoLayout(Context context) {
        super(context);
    }

    public void setData(String str) {
        this.mVideoPath = str;
        int[] ht = ht(str);
        S(ht[0], ht[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] ht(String str) {
        int i;
        int i2;
        int i3;
        if (this.bfW == null) {
            this.bfW = new MediaMetadataRetriever();
        }
        try {
            this.bfW.setDataSource(str);
            i = Integer.valueOf(this.bfW.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bfW.extractMetadata(19)).intValue();
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
        this.oDF = dVar;
    }

    public void startAnim() {
        this.mStopped = false;
        if (this.bfS != null && !this.bfS.isDestroyed() && !TextUtils.isEmpty(this.mVideoPath)) {
            this.bfS.play(this.mVideoPath);
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.bfS != null) {
            this.bfS.stop();
            this.bfS.reset();
        }
        if (this.bfW != null) {
            this.bfW.release();
        }
    }

    private void S(int i, int i2) {
        if (this.bfS == null || this.bfS.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfS = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        JD();
        if (indexOfChild(this.bfS.getView()) < 0) {
            addView(this.bfS.getView());
        }
        T(i, i2);
    }

    private void JD() {
        this.bfS.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.AlaAudioVideoLayout.1
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaAudioVideoLayout.this.oDF != null) {
                    AlaAudioVideoLayout.this.oDF.Fz(AlaAudioVideoLayout.this.mVideoPath);
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaAudioVideoLayout.this.mStopped && AlaAudioVideoLayout.this.oDF != null) {
                    AlaAudioVideoLayout.this.oDF.WE(AlaAudioVideoLayout.this.mVideoPath);
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                if (AlaAudioVideoLayout.this.oDF != null) {
                    AlaAudioVideoLayout.this.oDF.onFail(AlaAudioVideoLayout.this.mVideoPath);
                }
            }
        });
    }

    private void T(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bfS.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bfS.getView().setLayoutParams(layoutParams);
    }
}
