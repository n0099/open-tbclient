package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.o9b;
import com.baidu.tieba.pg0;
import com.baidu.tieba.xg0;
/* loaded from: classes9.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(pg0 pg0Var, int i, float[] fArr) {
        if (pg0Var == null) {
            return i;
        }
        int b = o9b.b(pg0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) o9b.c(pg0Var.l(), i3);
            if (!xg0.m(mediaTrack, "effect") && !xg0.m(mediaTrack, "template_effect") && !xg0.m(mediaTrack, "edit_sticker") && !xg0.m(mediaTrack, "multi_input") && !xg0.m(mediaTrack, "only_background") && !xg0.m(mediaTrack, "watermark") && !xg0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !xg0.m(mediaTrack, "user_background")) {
                i2 = pg0Var.j(mediaTrack, i2, null);
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
