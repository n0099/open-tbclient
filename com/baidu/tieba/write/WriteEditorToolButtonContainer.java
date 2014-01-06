package com.baidu.tieba.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WriteEditorToolButtonContainer extends com.baidu.tieba.editortool.v {
    public WriteEditorToolButtonContainer(Context context) {
        super(context);
    }

    public WriteEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tieba.editortool.v
    protected void e() {
        LayoutInflater.from(this.a).inflate(R.layout.write_editor_tool_button_container, (ViewGroup) this, true);
    }
}
