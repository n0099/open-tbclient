package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes2.dex */
public class c extends k {
    private EditText aEO;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aDE = false;
        this.aDD = 3;
        this.aCN = new VideoPlayInputContainer(context);
        this.aEO = ((VideoPlayInputContainer) this.aCN).getInputView();
        this.aDF = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aEO;
    }
}
