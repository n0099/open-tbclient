package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.hc0;
import com.baidu.tieba.pc0;
import com.baidu.tieba.ywb;
/* loaded from: classes9.dex */
public class MiniVideoEffectProcessor extends BaseEffectProcessor {
    public boolean mIsDraw = true;

    public void needDrawEffect(boolean z) {
        this.mIsDraw = z;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(hc0 hc0Var, int i, float[] fArr) {
        int i2;
        if (hc0Var == null || !this.mIsDraw) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= ywb.b(hc0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) ywb.c(hc0Var.l(), i3);
            if (mediaTrack != null && pc0.m(mediaTrack, "effect")) {
                i2 = hc0Var.j(mediaTrack, i, null);
                break;
            }
            i3++;
        }
        return i2 == 0 ? i : i2;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
