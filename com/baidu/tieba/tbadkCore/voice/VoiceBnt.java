package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.n;
import com.baidu.tbadk.core.voice.o;
/* loaded from: classes.dex */
public class VoiceBnt extends ImageView {
    n bZC;
    private boolean bZD;

    public VoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZD = false;
    }

    public void setRecorderView(n nVar) {
        this.bZC = nVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VoiceManager voiceManager = getVoiceManager();
        if (motionEvent.getAction() == 0) {
            if (voiceManager == null || !voiceManager.isAllowRecord()) {
                return false;
            }
            this.bZD = voiceManager.startRecord(this.bZC, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.bZD && voiceManager != null) {
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
