package com.baidu.tieba.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class VoiceBnt extends ImageView {
    ae a;
    private boolean b;

    public VoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public void setRecorderView(ae aeVar) {
        this.a = aeVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VoiceManager voiceManager = getVoiceManager();
        if (motionEvent.getAction() == 0) {
            if (voiceManager == null || !voiceManager.i()) {
                return false;
            }
            this.b = voiceManager.a(this.a, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.b && voiceManager != null) {
                voiceManager.f();
            }
            setPressed(false);
        }
        return true;
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof af) {
            return ((af) context).h();
        }
        return null;
    }
}
