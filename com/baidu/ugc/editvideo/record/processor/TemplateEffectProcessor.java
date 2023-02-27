package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.bh0;
import com.baidu.tieba.i1a;
import com.baidu.tieba.tg0;
/* loaded from: classes7.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(tg0 tg0Var, int i, float[] fArr) {
        int i2;
        if (tg0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= i1a.b(tg0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) i1a.c(tg0Var.l(), i3);
            if (mediaTrack != null && bh0.m(mediaTrack, "template_effect")) {
                i2 = tg0Var.j(mediaTrack, i, null);
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
