package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.dg0;
import com.baidu.tieba.lg0;
import com.baidu.tieba.lna;
/* loaded from: classes8.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(dg0 dg0Var, int i, float[] fArr) {
        if (dg0Var == null) {
            return i;
        }
        int b = lna.b(dg0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) lna.c(dg0Var.l(), i3);
            if (!lg0.m(mediaTrack, "effect") && !lg0.m(mediaTrack, "template_effect") && !lg0.m(mediaTrack, "edit_sticker") && !lg0.m(mediaTrack, "multi_input") && !lg0.m(mediaTrack, "only_background") && !lg0.m(mediaTrack, "watermark") && !lg0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !lg0.m(mediaTrack, "user_background")) {
                i2 = dg0Var.j(mediaTrack, i2, null);
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
