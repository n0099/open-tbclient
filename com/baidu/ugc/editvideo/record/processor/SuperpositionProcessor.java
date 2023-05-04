package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.mla;
import com.baidu.tieba.nf0;
/* loaded from: classes7.dex */
public class SuperpositionProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(nf0 nf0Var, int i, float[] fArr) {
        int e;
        return (nf0Var == null || (e = nf0Var.e((MediaTrack) mla.c(nf0Var.l(), 0), i, null)) == 0) ? i : e;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
