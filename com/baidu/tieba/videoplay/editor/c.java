package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText baX;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aZN = false;
        this.aZM = 3;
        this.aYW = new VideoPlayInputContainer(context);
        this.baX = ((VideoPlayInputContainer) this.aYW).getInputView();
        this.aZO = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.baX;
    }
}
