package com.baidu.tieba.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.aa;
import com.baidu.tbadk.core.voice.z;
/* loaded from: classes.dex */
public class VoiceBnt extends ImageView {
    z a;
    private boolean b;

    public VoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public void setRecorderView(z zVar) {
        this.a = zVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VoiceManager voiceManager = getVoiceManager();
        if (motionEvent.getAction() == 0) {
            if (voiceManager == null || !voiceManager.isAllowRecord()) {
                return false;
            }
            this.b = voiceManager.startRecord(this.a, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.b && voiceManager != null) {
                voiceManager.stopRecord();
            }
            setPressed(false);
        }
        return true;
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof aa) {
            return ((aa) context).d();
        }
        return null;
    }
}
