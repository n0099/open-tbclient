package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes24.dex */
public class c extends m {
    private EditText fwL;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fuW = false;
        this.fuV = 3;
        this.fub = new VideoPlayInputContainer(context);
        this.fwL = ((VideoPlayInputContainer) this.fub).getInputView();
        this.fuX = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fwL;
    }
}
