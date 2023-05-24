package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.dg0;
import com.baidu.tieba.lg0;
import com.baidu.tieba.lna;
/* loaded from: classes8.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(dg0 dg0Var, int i, float[] fArr) {
        int i2;
        if (dg0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= lna.b(dg0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) lna.c(dg0Var.l(), i3);
            if (mediaTrack != null && lg0.m(mediaTrack, "template_effect")) {
                i2 = dg0Var.j(mediaTrack, i, null);
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
