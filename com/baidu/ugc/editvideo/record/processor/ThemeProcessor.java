package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.bsb;
import com.baidu.tieba.gc0;
import com.baidu.tieba.oc0;
/* loaded from: classes9.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(gc0 gc0Var, int i, float[] fArr) {
        if (gc0Var == null) {
            return i;
        }
        int b = bsb.b(gc0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) bsb.c(gc0Var.l(), i3);
            if (!oc0.m(mediaTrack, "effect") && !oc0.m(mediaTrack, "template_effect") && !oc0.m(mediaTrack, "edit_sticker") && !oc0.m(mediaTrack, "multi_input") && !oc0.m(mediaTrack, "only_background") && !oc0.m(mediaTrack, "watermark") && !oc0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !oc0.m(mediaTrack, "user_background")) {
                i2 = gc0Var.j(mediaTrack, i2, null);
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
