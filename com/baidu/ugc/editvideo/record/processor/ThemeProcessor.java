package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.ah0;
import com.baidu.tieba.dgb;
import com.baidu.tieba.sg0;
/* loaded from: classes9.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(sg0 sg0Var, int i, float[] fArr) {
        if (sg0Var == null) {
            return i;
        }
        int b = dgb.b(sg0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) dgb.c(sg0Var.l(), i3);
            if (!ah0.m(mediaTrack, "effect") && !ah0.m(mediaTrack, "template_effect") && !ah0.m(mediaTrack, "edit_sticker") && !ah0.m(mediaTrack, "multi_input") && !ah0.m(mediaTrack, "only_background") && !ah0.m(mediaTrack, "watermark") && !ah0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !ah0.m(mediaTrack, "user_background")) {
                i2 = sg0Var.j(mediaTrack, i2, null);
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
