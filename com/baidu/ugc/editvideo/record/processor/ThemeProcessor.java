package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.bh0;
import com.baidu.tieba.i1a;
import com.baidu.tieba.tg0;
/* loaded from: classes7.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(tg0 tg0Var, int i, float[] fArr) {
        if (tg0Var == null) {
            return i;
        }
        int b = i1a.b(tg0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) i1a.c(tg0Var.l(), i3);
            if (!bh0.m(mediaTrack, "effect") && !bh0.m(mediaTrack, "template_effect") && !bh0.m(mediaTrack, "edit_sticker") && !bh0.m(mediaTrack, "multi_input") && !bh0.m(mediaTrack, "only_background") && !bh0.m(mediaTrack, "watermark") && !bh0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !bh0.m(mediaTrack, "user_background")) {
                i2 = tg0Var.j(mediaTrack, i2, null);
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
