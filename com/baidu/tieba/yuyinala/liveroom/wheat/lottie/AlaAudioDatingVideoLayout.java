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
/* loaded from: classes4.dex */
public class AlaAudioDatingVideoLayout extends RelativeLayout {
    private com.baidu.live.alphavideo.c baF;
    private MediaMetadataRetriever baJ;
    private boolean mStopped;
    private String mVideoPath;
    private d ohJ;

    public AlaAudioDatingVideoLayout(Context context) {
        super(context);
    }

    public void setData(String str) {
        this.mVideoPath = str;
        int[] hn = hn(str);
        A(hn[0], hn[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] hn(String str) {
        int i;
        int i2;
        int i3;
        if (this.baJ == null) {
            this.baJ = new MediaMetadataRetriever();
        }
        try {
            this.baJ.setDataSource(str);
            i = Integer.valueOf(this.baJ.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.baJ.extractMetadata(19)).intValue();
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
        this.ohJ = dVar;
    }

    public void startAnim() {
        this.mStopped = false;
        if (this.baF != null && !this.baF.isDestroyed() && !TextUtils.isEmpty(this.mVideoPath)) {
            this.baF.play(this.mVideoPath);
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.baF != null) {
            this.baF.stop();
            this.baF.reset();
        }
        if (this.baJ != null) {
            this.baJ.release();
        }
    }

    private void A(int i, int i2) {
        if (this.baF == null || this.baF.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.baF = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Ik();
        if (indexOfChild(this.baF.getView()) < 0) {
            addView(this.baF.getView());
        }
        B(i, i2);
    }

    private void Ik() {
        this.baF.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.AlaAudioDatingVideoLayout.1
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaAudioDatingVideoLayout.this.ohJ != null) {
                    AlaAudioDatingVideoLayout.this.ohJ.EO(AlaAudioDatingVideoLayout.this.mVideoPath);
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaAudioDatingVideoLayout.this.mStopped && AlaAudioDatingVideoLayout.this.ohJ != null) {
                    AlaAudioDatingVideoLayout.this.ohJ.VE(AlaAudioDatingVideoLayout.this.mVideoPath);
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                if (AlaAudioDatingVideoLayout.this.ohJ != null) {
                    AlaAudioDatingVideoLayout.this.ohJ.onFail(AlaAudioDatingVideoLayout.this.mVideoPath);
                }
            }
        });
    }

    private void B(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.baF.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.baF.getView().setLayoutParams(layoutParams);
    }
}
