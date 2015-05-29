package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.adp.lib.voice.j;
import com.baidu.tbadk.core.voice.VoiceManager;
/* loaded from: classes.dex */
public class VoiceButton extends ImageView {
    j cuj;
    private boolean cuk;

    public VoiceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuk = false;
    }

    public void setRecorderView(j jVar) {
        this.cuj = jVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a recorderManager = getRecorderManager();
        if (motionEvent.getAction() == 0) {
            if (recorderManager == null || !recorderManager.ok()) {
                return false;
            }
            this.cuk = recorderManager.a(this.cuj, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.cuk && recorderManager != null) {
                recorderManager.ol();
            }
            setPressed(false);
        } else if (!isPressed()) {
            setPressed(true);
        }
        return true;
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof com.baidu.tbadk.core.voice.j) {
            return ((com.baidu.tbadk.core.voice.j) context).getVoiceManager();
        }
        return null;
    }

    public a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }
}
