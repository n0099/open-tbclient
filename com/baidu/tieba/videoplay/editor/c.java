package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText ctU;

    public c(Context context) {
        super(context, (String) null, 28);
        this.csL = false;
        this.csK = 3;
        this.crT = new VideoPlayInputContainer(context);
        this.ctU = ((VideoPlayInputContainer) this.crT).getInputView();
        this.csM = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.ctU;
    }
}
