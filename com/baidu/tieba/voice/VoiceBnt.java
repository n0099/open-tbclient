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
    n bSE;
    private boolean bSF;

    public VoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSF = false;
    }

    public void setRecorderView(n nVar) {
        this.bSE = nVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VoiceManager voiceManager = getVoiceManager();
        if (motionEvent.getAction() == 0) {
            if (voiceManager == null || !voiceManager.isAllowRecord()) {
                return false;
            }
            this.bSF = voiceManager.startRecord(this.bSE, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.bSF && voiceManager != null) {
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
