package com.baidu.ugc.editvideo.record.processor;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.dva;
import com.baidu.tieba.mh0;
/* loaded from: classes8.dex */
public class SuperpositionProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(mh0 mh0Var, int i, float[] fArr) {
        int e;
        return (mh0Var == null || (e = mh0Var.e((MediaTrack) dva.c(mh0Var.l(), 0), i, null)) == 0) ? i : e;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
