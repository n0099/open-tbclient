package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.csb;
import com.baidu.tieba.gc0;
/* loaded from: classes9.dex */
public class SuperpositionProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(gc0 gc0Var, int i, float[] fArr) {
        int e;
        return (gc0Var == null || (e = gc0Var.e((MediaTrack) csb.c(gc0Var.l(), 0), i, null)) == 0) ? i : e;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
