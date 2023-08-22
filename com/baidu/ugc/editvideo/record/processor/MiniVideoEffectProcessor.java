package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.ah0;
import com.baidu.tieba.dgb;
import com.baidu.tieba.sg0;
/* loaded from: classes9.dex */
public class MiniVideoEffectProcessor extends BaseEffectProcessor {
    public boolean mIsDraw = true;

    public void needDrawEffect(boolean z) {
        this.mIsDraw = z;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(sg0 sg0Var, int i, float[] fArr) {
        int i2;
        if (sg0Var == null || !this.mIsDraw) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= dgb.b(sg0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) dgb.c(sg0Var.l(), i3);
            if (mediaTrack != null && ah0.m(mediaTrack, "effect")) {
                i2 = sg0Var.j(mediaTrack, i, null);
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
