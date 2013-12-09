package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SubPbEditor extends PbEditor {
    public SubPbEditor(Context context) {
        super(context);
    }

    public SubPbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tieba.pb.PbEditor
    protected void j() {
        LayoutInflater.from(this.f2141a).inflate(R.layout.sub_pb_editor_view, (ViewGroup) this, true);
        this.b = (SubPbEditorToolView) findViewById(R.id.pb_editor_tool_button);
        this.c = (EditorToolComponetContainer) findViewById(R.id.pb_editor_tool_group);
    }

    @Override // com.baidu.tieba.pb.PbEditor, com.baidu.tieba.view.ap
    public void a(int i) {
        this.c.a(i);
        if (i == 1 && p() && !i() && this.e) {
            o();
        }
    }
}
