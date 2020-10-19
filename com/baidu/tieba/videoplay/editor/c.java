package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes24.dex */
public class c extends m {
    private EditText fbI;

    public c(Context context) {
        super(context, (String) null, 28);
        this.eZU = false;
        this.eZT = 3;
        this.eYZ = new VideoPlayInputContainer(context);
        this.fbI = ((VideoPlayInputContainer) this.eYZ).getInputView();
        this.eZV = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.fbI;
    }
}
