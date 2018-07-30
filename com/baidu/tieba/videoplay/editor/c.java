package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes2.dex */
public class c extends k {
    private EditText aOf;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aMW = false;
        this.aMV = 3;
        this.aMf = new VideoPlayInputContainer(context);
        this.aOf = ((VideoPlayInputContainer) this.aMf).getInputView();
        this.aMX = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aOf;
    }
}
