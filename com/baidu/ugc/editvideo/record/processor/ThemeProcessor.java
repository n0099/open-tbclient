package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.mh0;
import com.baidu.tieba.uh0;
import com.baidu.tieba.yua;
/* loaded from: classes8.dex */
public class ThemeProcessor extends BaseEffectProcessor {
    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(mh0 mh0Var, int i, float[] fArr) {
        if (mh0Var == null) {
            return i;
        }
        int b = yua.b(mh0Var.l());
        int i2 = i;
        for (int i3 = 1; i3 < b; i3++) {
            MediaTrack mediaTrack = (MediaTrack) yua.c(mh0Var.l(), i3);
            if (!uh0.m(mediaTrack, "effect") && !uh0.m(mediaTrack, "template_effect") && !uh0.m(mediaTrack, "edit_sticker") && !uh0.m(mediaTrack, "multi_input") && !uh0.m(mediaTrack, "only_background") && !uh0.m(mediaTrack, "watermark") && !uh0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !uh0.m(mediaTrack, "user_background")) {
                i2 = mh0Var.j(mediaTrack, i2, null);
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
