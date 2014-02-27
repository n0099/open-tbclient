package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.editortool.EditorToolButton;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends com.baidu.tieba.editortool.a {
    protected Context a;
    protected EditorToolButton b;
    protected EditorToolButton c;
    protected TextView d;
    protected TextView e;

    public PbEditorToolButtonContainer(Context context) {
        super(context);
        this.a = context;
        h();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        h();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        h();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b.getTip() != null) {
            TextView tip = this.b.getTip();
            int right = this.b.getRight() - BdUtilHelper.a(this.a, 18.0f);
            int top = this.b.getTop() - BdUtilHelper.a(this.a, 2.0f);
            this.b.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.c.getTip() != null) {
            TextView tip2 = this.c.getTip();
            int right2 = this.c.getRight() - BdUtilHelper.a(this.a, 18.0f);
            int top2 = this.c.getTop() - BdUtilHelper.a(this.a, 2.0f);
            this.c.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    private void h() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_tool_button_container, (ViewGroup) this, true);
        this.c = (EditorToolButton) findViewById(R.id.tool_more);
        this.b = (EditorToolButton) findViewById(R.id.tool_audio);
    }

    public void setOnActionListener(com.baidu.tieba.editortool.aa aaVar) {
        if (aaVar != null) {
            cn cnVar = new cn(this, aaVar);
            this.c.setOnClickListener(cnVar);
            this.b.setOnClickListener(cnVar);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.c.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.b.setHardDisabled(z);
    }

    public final void d() {
        if (this.d == null) {
            this.d = a(this.b, false);
        }
        this.b.e();
    }

    public final void e() {
        this.b.f();
    }

    public final void f() {
        if (this.e == null) {
            this.e = a(this.c, false);
        }
        this.c.e();
    }

    public final void g() {
        this.c.f();
    }

    public final void a(boolean z) {
        if (z) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(EditorToolButton editorToolButton, com.baidu.tieba.editortool.aa aaVar) {
        if (editorToolButton == this.c) {
            aaVar.a(37, null);
        } else if (editorToolButton == this.b) {
            aaVar.a(4, null);
        }
        if (editorToolButton.g() && !editorToolButton.isFocused()) {
            c();
            editorToolButton.h();
            if (editorToolButton == this.c) {
                aaVar.a(38, null);
            } else if (editorToolButton == this.b) {
                aaVar.a(5, null);
            }
        }
    }
}
