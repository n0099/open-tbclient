package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText evO;

    public c(Context context) {
        super(context, (String) null, 28);
        this.euA = false;
        this.euz = 3;
        this.etH = new VideoPlayInputContainer(context);
        this.evO = ((VideoPlayInputContainer) this.etH).getInputView();
        this.euB = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.evO;
    }
}
