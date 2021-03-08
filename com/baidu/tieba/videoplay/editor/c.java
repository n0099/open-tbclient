package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes7.dex */
public class c extends m {
    private EditText fFy;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fDI = false;
        this.fDH = 3;
        this.fCN = new VideoPlayInputContainer(context);
        this.fFy = ((VideoPlayInputContainer) this.fCN).getInputView();
        this.fDJ = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fFy;
    }
}
