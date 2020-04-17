package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText dYK;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dXz = false;
        this.dXy = 3;
        this.dWH = new VideoPlayInputContainer(context);
        this.dYK = ((VideoPlayInputContainer) this.dWH).getInputView();
        this.dXA = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dYK;
    }
}
