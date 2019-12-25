package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes8.dex */
public class c extends l {
    private EditText dul;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dta = false;
        this.dsZ = 3;
        this.dsh = new VideoPlayInputContainer(context);
        this.dul = ((VideoPlayInputContainer) this.dsh).getInputView();
        this.dtb = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dul;
    }
}
