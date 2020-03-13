package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText dyQ;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dxF = false;
        this.dxE = 3;
        this.dwN = new VideoPlayInputContainer(context);
        this.dyQ = ((VideoPlayInputContainer) this.dwN).getInputView();
        this.dxG = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dyQ;
    }
}
