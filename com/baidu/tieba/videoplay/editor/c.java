package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes18.dex */
public class c extends m {
    private EditText eMK;

    public c(Context context) {
        super(context, (String) null, 28);
        this.eLw = false;
        this.eLv = 3;
        this.eKB = new VideoPlayInputContainer(context);
        this.eMK = ((VideoPlayInputContainer) this.eKB).getInputView();
        this.eLx = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.eMK;
    }
}
