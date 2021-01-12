package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes7.dex */
public class c extends m {
    private EditText fBK;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fzU = false;
        this.fzT = 3;
        this.fyZ = new VideoPlayInputContainer(context);
        this.fBK = ((VideoPlayInputContainer) this.fyZ).getInputView();
        this.fzV = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fBK;
    }
}
