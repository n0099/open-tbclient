package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes18.dex */
public class c extends l {
    private EditText eCh;

    public c(Context context) {
        super(context, (String) null, 28);
        this.eAT = false;
        this.eAS = 3;
        this.ezZ = new VideoPlayInputContainer(context);
        this.eCh = ((VideoPlayInputContainer) this.ezZ).getInputView();
        this.eAU = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.eCh;
    }
}
