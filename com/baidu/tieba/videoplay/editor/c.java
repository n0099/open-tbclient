package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText dyD;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dxs = false;
        this.dxr = 3;
        this.dwA = new VideoPlayInputContainer(context);
        this.dyD = ((VideoPlayInputContainer) this.dwA).getInputView();
        this.dxt = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dyD;
    }
}
