package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.m1b;
import com.baidu.tieba.qh0;
import com.baidu.tieba.yh0;
/* loaded from: classes8.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(qh0 qh0Var, int i, float[] fArr) {
        if (qh0Var == null) {
            return i;
        }
        int b = m1b.b(qh0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) m1b.c(qh0Var.l(), i3);
            if (!yh0.m(mediaTrack, "effect") && !yh0.m(mediaTrack, "template_effect") && !yh0.m(mediaTrack, "edit_sticker") && !yh0.m(mediaTrack, "multi_input") && !yh0.m(mediaTrack, "only_background") && !yh0.m(mediaTrack, "watermark") && !yh0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !yh0.m(mediaTrack, "user_background")) {
                i2 = qh0Var.j(mediaTrack, i2, null);
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
