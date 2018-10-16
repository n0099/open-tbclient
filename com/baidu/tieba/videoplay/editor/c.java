package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText aVV;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aUM = false;
        this.aUL = 3;
        this.aTV = new VideoPlayInputContainer(context);
        this.aVV = ((VideoPlayInputContainer) this.aTV).getInputView();
        this.aUN = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aVV;
    }
}
