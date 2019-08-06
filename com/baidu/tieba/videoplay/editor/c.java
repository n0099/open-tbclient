package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText cub;

    public c(Context context) {
        super(context, (String) null, 28);
        this.csS = false;
        this.csR = 3;
        this.csa = new VideoPlayInputContainer(context);
        this.cub = ((VideoPlayInputContainer) this.csa).getInputView();
        this.csT = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.cub;
    }
}
