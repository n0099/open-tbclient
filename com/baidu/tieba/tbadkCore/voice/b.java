package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
public abstract class b extends ViewGroup {
    public abstract void a(VoiceData.VoiceModel voiceModel);

    public abstract VoiceData.VoiceModel getVoiceModel();

    public abstract void onStopingRecorder();

    public abstract void ov();

    public abstract void reset();

    public abstract void setCallback(c cVar);

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
