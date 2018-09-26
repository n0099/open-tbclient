package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes2.dex */
public class c extends k {
    private EditText aRu;

    public c(Context context) {
        super(context, (String) null, 28);
        this.aQl = false;
        this.aQk = 3;
        this.aPu = new VideoPlayInputContainer(context);
        this.aRu = ((VideoPlayInputContainer) this.aPu).getInputView();
        this.aQm = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.aRu;
    }
}
