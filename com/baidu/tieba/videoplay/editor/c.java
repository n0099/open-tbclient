package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes23.dex */
public class c extends m {
    private EditText fpg;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fns = false;
        this.fnr = 3;
        this.fmx = new VideoPlayInputContainer(context);
        this.fpg = ((VideoPlayInputContainer) this.fmx).getInputView();
        this.fnt = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fpg;
    }
}
