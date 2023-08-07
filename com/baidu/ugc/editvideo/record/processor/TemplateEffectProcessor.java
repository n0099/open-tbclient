package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.n9b;
import com.baidu.tieba.pg0;
import com.baidu.tieba.xg0;
/* loaded from: classes9.dex */
public class TemplateEffectProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(pg0 pg0Var, int i, float[] fArr) {
        int i2;
        if (pg0Var == null) {
            return i;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= n9b.b(pg0Var.l())) {
                i2 = i;
                break;
            }
            MediaTrack mediaTrack = (MediaTrack) n9b.c(pg0Var.l(), i3);
            if (mediaTrack != null && xg0.m(mediaTrack, "template_effect")) {
                i2 = pg0Var.j(mediaTrack, i, null);
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
