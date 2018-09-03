package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes2.dex */
public class c extends k {
    private EditText aOc;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aMT = false;
        this.aMS = 3;
        this.aMc = new VideoPlayInputContainer(context);
        this.aOc = ((VideoPlayInputContainer) this.aMc).getInputView();
        this.aMU = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aOc;
    }
}
