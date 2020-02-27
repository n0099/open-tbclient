package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText dyC;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dxr = false;
        this.dxq = 3;
        this.dwz = new VideoPlayInputContainer(context);
        this.dyC = ((VideoPlayInputContainer) this.dwz).getInputView();
        this.dxs = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dyC;
    }
}
