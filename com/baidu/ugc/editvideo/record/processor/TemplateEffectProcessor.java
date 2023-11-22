package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.csb;
import com.baidu.tieba.gc0;
import com.baidu.tieba.oc0;
/* loaded from: classes9.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(gc0 gc0Var, int i, float[] fArr) {
        int i2;
        if (gc0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= csb.b(gc0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) csb.c(gc0Var.l(), i3);
            if (mediaTrack != null && oc0.m(mediaTrack, "template_effect")) {
                i2 = gc0Var.j(mediaTrack, i, null);
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
