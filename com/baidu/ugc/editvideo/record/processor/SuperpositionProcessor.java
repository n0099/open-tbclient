package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.nib;
import com.baidu.tieba.tg0;
/* loaded from: classes9.dex */
public class SuperpositionProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(tg0 tg0Var, int i, float[] fArr) {
        int e;
        return (tg0Var == null || (e = tg0Var.e((MediaTrack) nib.c(tg0Var.l(), 0), i, null)) == 0) ? i : e;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
