package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes8.dex */
public class c extends m {
    private EditText fDZ;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fCj = false;
        this.fCi = 3;
        this.fBo = new VideoPlayInputContainer(context);
        this.fDZ = ((VideoPlayInputContainer) this.fBo).getInputView();
        this.fCk = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fDZ;
    }
}
