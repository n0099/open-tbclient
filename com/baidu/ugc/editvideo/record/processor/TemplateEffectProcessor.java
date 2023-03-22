package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.jf0;
import com.baidu.tieba.r7a;
import com.baidu.tieba.rf0;
/* loaded from: classes7.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(jf0 jf0Var, int i, float[] fArr) {
        int i2;
        if (jf0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= r7a.b(jf0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) r7a.c(jf0Var.l(), i3);
            if (mediaTrack != null && rf0.m(mediaTrack, "template_effect")) {
                i2 = jf0Var.j(mediaTrack, i, null);
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
