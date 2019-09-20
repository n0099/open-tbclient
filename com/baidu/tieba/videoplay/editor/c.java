package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText cuY;

    public c(Context context) {
        super(context, (String) null, 28);
        this.ctO = false;
        this.ctN = 3;
        this.csV = new VideoPlayInputContainer(context);
        this.cuY = ((VideoPlayInputContainer) this.csV).getInputView();
        this.ctP = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.cuY;
    }
}
