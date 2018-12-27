package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText bal;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aZc = false;
        this.aZb = 3;
        this.aYl = new VideoPlayInputContainer(context);
        this.bal = ((VideoPlayInputContainer) this.aYl).getInputView();
        this.aZd = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.bal;
    }
}
