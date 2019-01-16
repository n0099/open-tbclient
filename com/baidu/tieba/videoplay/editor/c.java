package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText baW;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aZM = false;
        this.aZL = 3;
        this.aYV = new VideoPlayInputContainer(context);
        this.baW = ((VideoPlayInputContainer) this.aYV).getInputView();
        this.aZN = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.baW;
    }
}
