package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes6.dex */
public class c extends k {
    private EditText csG;

    public c(Context context) {
        super(context, (String) null, 28);
        this.crx = false;
        this.crw = 3;
        this.cqE = new VideoPlayInputContainer(context);
        this.csG = ((VideoPlayInputContainer) this.cqE).getInputView();
        this.cry = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.csG;
    }
}
