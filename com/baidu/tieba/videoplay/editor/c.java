package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText csH;

    public c(Context context) {
        super(context, (String) null, 28);
        this.cry = false;
        this.crx = 3;
        this.cqF = new VideoPlayInputContainer(context);
        this.csH = ((VideoPlayInputContainer) this.cqF).getInputView();
        this.crz = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.csH;
    }
}
