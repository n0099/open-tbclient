package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.mla;
import com.baidu.tieba.nf0;
import com.baidu.tieba.vf0;
/* loaded from: classes7.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(nf0 nf0Var, int i, float[] fArr) {
        if (nf0Var == null) {
            return i;
        }
        int b = mla.b(nf0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) mla.c(nf0Var.l(), i3);
            if (!vf0.m(mediaTrack, "effect") && !vf0.m(mediaTrack, "template_effect") && !vf0.m(mediaTrack, "edit_sticker") && !vf0.m(mediaTrack, "multi_input") && !vf0.m(mediaTrack, "only_background") && !vf0.m(mediaTrack, "watermark") && !vf0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !vf0.m(mediaTrack, "user_background")) {
                i2 = nf0Var.j(mediaTrack, i2, null);
            }
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
