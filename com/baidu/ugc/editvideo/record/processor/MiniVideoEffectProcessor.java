package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.afb;
import com.baidu.tieba.pb0;
import com.baidu.tieba.xb0;
/* loaded from: classes9.dex */
public class MiniVideoEffectProcessor extends BaseEffectProcessor {
    public boolean mIsDraw = true;

    public void needDrawEffect(boolean z) {
        this.mIsDraw = z;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(pb0 pb0Var, int i, float[] fArr) {
        int i2;
        if (pb0Var == null || !this.mIsDraw) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= afb.b(pb0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) afb.c(pb0Var.l(), i3);
            if (mediaTrack != null && xb0.m(mediaTrack, "effect")) {
                i2 = pb0Var.j(mediaTrack, i, null);
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
