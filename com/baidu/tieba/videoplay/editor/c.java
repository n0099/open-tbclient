package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText aWL;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aVC = false;
        this.aVB = 3;
        this.aUL = new VideoPlayInputContainer(context);
        this.aWL = ((VideoPlayInputContainer) this.aUL).getInputView();
        this.aVD = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aWL;
    }
}
