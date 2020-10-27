package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes24.dex */
public class c extends m {
    private EditText fkh;

    public c(Context context) {
        super(context, (String) null, 28);
        this.fis = false;
        this.fir = 3;
        this.fhv = new VideoPlayInputContainer(context);
        this.fkh = ((VideoPlayInputContainer) this.fhv).getInputView();
        this.fit = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fkh;
    }
}
