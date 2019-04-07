package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText ckx;

    public c(Context context) {
        super(context, (String) null, 28);
        this.cjo = false;
        this.cjn = 3;
        this.ciw = new VideoPlayInputContainer(context);
        this.ckx = ((VideoPlayInputContainer) this.ciw).getInputView();
        this.cjp = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.ckx;
    }
}
