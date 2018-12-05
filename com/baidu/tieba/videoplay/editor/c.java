package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText bai;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aYZ = false;
        this.aYY = 3;
        this.aYi = new VideoPlayInputContainer(context);
        this.bai = ((VideoPlayInputContainer) this.aYi).getInputView();
        this.aZa = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.bai;
    }
}
