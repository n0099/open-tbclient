package com.baidu.tieba.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class VoiceBnt extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    ad f2016a;
    private boolean b;

    public VoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public void setRecorderView(ad adVar) {
        this.f2016a = adVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        r voiceManager = getVoiceManager();
        if (motionEvent.getAction() == 0) {
            if (voiceManager == null || !voiceManager.g()) {
                return false;
            }
            this.b = voiceManager.a(this.f2016a, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.b && voiceManager != null) {
                voiceManager.d();
            }
            setPressed(false);
        }
        return true;
    }

    public r getVoiceManager() {
        Context context = getContext();
        if (context instanceof ae) {
            return ((ae) context).c_();
        }
        return null;
    }
}
