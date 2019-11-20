package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText cGr;

    public c(Context context) {
        super(context, (String) null, 28);
        this.cFg = false;
        this.cFf = 3;
        this.cEn = new VideoPlayInputContainer(context);
        this.cGr = ((VideoPlayInputContainer) this.cEn).getInputView();
        this.cFh = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.cGr;
    }
}
