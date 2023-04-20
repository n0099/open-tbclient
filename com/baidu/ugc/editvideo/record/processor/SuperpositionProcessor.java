package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.lf0;
import com.baidu.tieba.qha;
/* loaded from: classes7.dex */
public class SuperpositionProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(lf0 lf0Var, int i, float[] fArr) {
        int e;
        return (lf0Var == null || (e = lf0Var.e((MediaTrack) qha.c(lf0Var.l(), 0), i, null)) == 0) ? i : e;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
