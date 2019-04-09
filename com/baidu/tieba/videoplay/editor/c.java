package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText cky;

    public c(Context context) {
        super(context, (String) null, 28);
        this.cjp = false;
        this.cjo = 3;
        this.cix = new VideoPlayInputContainer(context);
        this.cky = ((VideoPlayInputContainer) this.cix).getInputView();
        this.cjq = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.cky;
    }
}
