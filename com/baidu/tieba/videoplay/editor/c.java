package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes18.dex */
public class c extends m {
    private EditText eMG;

    public c(Context context) {
        super(context, (String) null, 28);
        this.eLs = false;
        this.eLr = 3;
        this.eKx = new VideoPlayInputContainer(context);
        this.eMG = ((VideoPlayInputContainer) this.eKx).getInputView();
        this.eLt = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.eMG;
    }
}
