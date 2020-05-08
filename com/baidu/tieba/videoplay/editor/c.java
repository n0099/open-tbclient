package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText dYP;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dXE = false;
        this.dXD = 3;
        this.dWM = new VideoPlayInputContainer(context);
        this.dYP = ((VideoPlayInputContainer) this.dWM).getInputView();
        this.dXF = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dYP;
    }
}
