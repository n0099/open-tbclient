package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.voice.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
/* loaded from: classes.dex */
public class VoiceButton extends ImageView {
    f gQk;
    private boolean gQl;

    public VoiceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gQl = false;
    }

    public void setRecorderView(f fVar) {
        this.gQk = fVar;
        a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.a(fVar);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a recorderManager = getRecorderManager();
        if (motionEvent.getAction() == 0) {
            if (recorderManager == null || !recorderManager.oG()) {
                return false;
            }
            this.gQl = recorderManager.a(this.gQk, -1);
            setPressed(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.gQl && recorderManager != null) {
                recorderManager.stopRecord();
            }
            setPressed(false);
        } else if (!isPressed()) {
            setPressed(true);
        }
        return true;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
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
