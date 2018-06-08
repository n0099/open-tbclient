package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes2.dex */
public class c extends k {
    private EditText aNk;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aMa = false;
        this.aLZ = 3;
        this.aLj = new VideoPlayInputContainer(context);
        this.aNk = ((VideoPlayInputContainer) this.aLj).getInputView();
        this.aMb = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aNk;
    }
}
