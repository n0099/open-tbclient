package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText emY;

    public c(Context context) {
        super(context, (String) null, 28);
        this.elN = false;
        this.elM = 3;
        this.ekV = new VideoPlayInputContainer(context);
        this.emY = ((VideoPlayInputContainer) this.ekV).getInputView();
        this.elO = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.emY;
    }
}
