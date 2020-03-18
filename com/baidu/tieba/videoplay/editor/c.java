package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class c extends l {
    private EditText dzd;

    public c(Context context) {
        super(context, (String) null, 28);
        this.dxS = false;
        this.dxR = 3;
        this.dxa = new VideoPlayInputContainer(context);
        this.dzd = ((VideoPlayInputContainer) this.dxa).getInputView();
        this.dxT = new int[]{4, 24, 3, 9, 6};
    }

    public EditText getInputView() {
        return this.dzd;
    }
}
