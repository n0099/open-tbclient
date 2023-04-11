package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.iha;
import com.baidu.tieba.kf0;
import com.baidu.tieba.sf0;
/* loaded from: classes7.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(kf0 kf0Var, int i, float[] fArr) {
        if (kf0Var == null) {
            return i;
        }
        int b = iha.b(kf0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) iha.c(kf0Var.l(), i3);
            if (!sf0.m(mediaTrack, "effect") && !sf0.m(mediaTrack, "template_effect") && !sf0.m(mediaTrack, "edit_sticker") && !sf0.m(mediaTrack, "multi_input") && !sf0.m(mediaTrack, "only_background") && !sf0.m(mediaTrack, "watermark") && !sf0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !sf0.m(mediaTrack, "user_background")) {
                i2 = kf0Var.j(mediaTrack, i2, null);
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
