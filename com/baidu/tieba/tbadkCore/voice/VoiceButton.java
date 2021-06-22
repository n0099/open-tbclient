package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import d.a.c.a.j;
import d.a.c.e.q.f;
import d.a.o0.e3.p0.a;
/* loaded from: classes5.dex */
public class VoiceButton extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public f f21035e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21036f;

    public VoiceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21036f = false;
    }

    public a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(getContext()) instanceof d.a.c.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a recorderManager = getRecorderManager();
        if (motionEvent.getAction() == 0) {
            if (recorderManager == null || !recorderManager.f()) {
                return false;
            }
            this.f21036f = recorderManager.b(this.f21035e, -1);
            setPressed(true);
        } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            if (!isPressed()) {
                setPressed(true);
            }
        } else {
            if (this.f21036f && recorderManager != null) {
                recorderManager.stopRecord();
            }
            setPressed(false);
        }
        return true;
    }

    public void setRecorderView(f fVar) {
        this.f21035e = fVar;
        a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.e(fVar);
        }
    }
}
