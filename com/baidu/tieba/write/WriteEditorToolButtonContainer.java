package com.baidu.tieba.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class WriteEditorToolButtonContainer extends com.baidu.tieba.editortool.aq {
    public WriteEditorToolButtonContainer(Context context) {
        super(context);
    }

    public WriteEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tieba.editortool.aq
    protected void e() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.write_editor_tool_button_container, (ViewGroup) this, true);
    }
}
