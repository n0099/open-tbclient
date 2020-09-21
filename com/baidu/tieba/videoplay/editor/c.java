package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes23.dex */
public class c extends m {
    private EditText ePB;

    public c(Context context) {
        super(context, (String) null, 28);
        this.eNN = false;
        this.eNM = 3;
        this.eMS = new VideoPlayInputContainer(context);
        this.ePB = ((VideoPlayInputContainer) this.eMS).getInputView();
        this.eNO = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.ePB;
    }
}
