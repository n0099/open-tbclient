package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.nh0;
import com.baidu.tieba.vh0;
import com.baidu.tieba.wwa;
/* loaded from: classes8.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(nh0 nh0Var, int i, float[] fArr) {
        int i2;
        if (nh0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= wwa.b(nh0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) wwa.c(nh0Var.l(), i3);
            if (mediaTrack != null && vh0.m(mediaTrack, "template_effect")) {
                i2 = nh0Var.j(mediaTrack, i, null);
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
