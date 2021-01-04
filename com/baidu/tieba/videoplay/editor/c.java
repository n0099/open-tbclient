package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes8.dex */
public class c extends m {
    private EditText fGr;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fEC = false;
        this.fEB = 3;
        this.fDH = new VideoPlayInputContainer(context);
        this.fGr = ((VideoPlayInputContainer) this.fDH).getInputView();
        this.fED = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fGr;
    }
}
