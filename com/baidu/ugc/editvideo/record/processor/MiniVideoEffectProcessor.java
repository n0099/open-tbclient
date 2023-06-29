package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.m1b;
import com.baidu.tieba.qh0;
import com.baidu.tieba.yh0;
/* loaded from: classes8.dex */
public class MiniVideoEffectProcessor extends BaseEffectProcessor {
    public boolean mIsDraw = true;

    public void needDrawEffect(boolean z) {
        this.mIsDraw = z;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(qh0 qh0Var, int i, float[] fArr) {
        int i2;
        if (qh0Var == null || !this.mIsDraw) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= m1b.b(qh0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) m1b.c(qh0Var.l(), i3);
            if (mediaTrack != null && yh0.m(mediaTrack, "effect")) {
                i2 = qh0Var.j(mediaTrack, i, null);
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
