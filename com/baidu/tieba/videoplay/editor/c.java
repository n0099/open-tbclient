package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes2.dex */
public class c extends k {
    private EditText aEN;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aDD = false;
        this.aDC = 3;
        this.aCM = new VideoPlayInputContainer(context);
        this.aEN = ((VideoPlayInputContainer) this.aCM).getInputView();
        this.aDE = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aEN;
    }
}
