package com.baidu.tieba.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.n;
import com.baidu.tbadk.core.voice.o;
/* loaded from: classes.dex */
public class VoiceBnt extends ImageView {
    n bSp;
    private boolean bSq;

    public VoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSq = false;
    }

    public void setRecorderView(n nVar) {
        this.bSp = nVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VoiceManager voiceManager = getVoiceManager();
        if (motionEvent.getAction() == 0) {
            if (voiceManager == null || !voiceManager.isAllowRecord()) {
                return false;
            }
            this.bSq = voiceManager.startRecord(this.bSp, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.bSq && voiceManager != null) {
                voiceManager.stopRecord();
            }
            setPressed(false);
        }
        return true;
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).getVoiceManager();
        }
        return null;
    }
}
