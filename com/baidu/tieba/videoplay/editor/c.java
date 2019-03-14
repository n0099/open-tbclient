package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText ckv;

    public c(Context context) {
        super(context, (String) null, 28);
        this.cjm = false;
        this.cjl = 3;
        this.ciu = new VideoPlayInputContainer(context);
        this.ckv = ((VideoPlayInputContainer) this.ciu).getInputView();
        this.cjn = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.ckv;
    }
}
