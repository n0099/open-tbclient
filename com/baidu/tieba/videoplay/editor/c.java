package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText duw;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dtl = false;
        this.dtk = 3;
        this.dss = new VideoPlayInputContainer(context);
        this.duw = ((VideoPlayInputContainer) this.dss).getInputView();
        this.dtm = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.duw;
    }
}
