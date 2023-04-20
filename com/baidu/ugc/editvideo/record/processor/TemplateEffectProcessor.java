package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.lf0;
import com.baidu.tieba.qha;
import com.baidu.tieba.tf0;
/* loaded from: classes7.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(lf0 lf0Var, int i, float[] fArr) {
        int i2;
        if (lf0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= qha.b(lf0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) qha.c(lf0Var.l(), i3);
            if (mediaTrack != null && tf0.m(mediaTrack, "template_effect")) {
                i2 = lf0Var.j(mediaTrack, i, null);
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
