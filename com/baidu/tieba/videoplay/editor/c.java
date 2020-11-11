package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes24.dex */
public class c extends m {
    private EditText fpZ;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fok = false;
        this.foj = 3;
        this.fnp = new VideoPlayInputContainer(context);
        this.fpZ = ((VideoPlayInputContainer) this.fnp).getInputView();
        this.fol = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fpZ;
    }
}
