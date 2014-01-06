package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.editortool.EditorToolButton;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends com.baidu.tieba.editortool.a {
    protected Context a;
    protected EditorToolButton b;
    protected EditorToolButton c;
    protected TextView d;

    public PbEditorToolButtonContainer(Context context) {
        super(context);
        this.a = context;
        e();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        e();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        e();
    }

    protected void d() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_tool_button_container, (ViewGroup) this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b.getTip() != null) {
            TextView tip = this.b.getTip();
            int right = this.b.getRight() - com.baidu.adp.lib.h.g.a(this.a, 14.0f);
            int top = this.b.getTop() - com.baidu.adp.lib.h.g.a(this.a, 2.0f);
            this.b.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
    }

    protected void e() {
        d();
        this.c = (EditorToolButton) findViewById(R.id.tool_more);
        this.b = (EditorToolButton) findViewById(R.id.tool_audio);
    }

    public void setOnActionListener(com.baidu.tieba.editortool.t tVar) {
        if (tVar != null) {
            View.OnClickListener a = a(tVar);
            this.c.setOnClickListener(a);
            this.b.setOnClickListener(a);
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

    public void f() {
        if (this.d == null) {
            this.d = a(this.b, false);
        }
        this.b.e();
    }

    public void g() {
        this.b.f();
    }

    public void a(boolean z) {
        if (z) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tieba.editortool.t tVar) {
        if (editorToolButton == this.c) {
            tVar.a(35, null);
        } else if (editorToolButton == this.b) {
            tVar.a(4, null);
        }
        if (editorToolButton.g() && !editorToolButton.isFocused()) {
            c();
            editorToolButton.h();
            if (editorToolButton == this.c) {
                tVar.a(36, null);
            } else if (editorToolButton == this.b) {
                tVar.a(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tieba.editortool.t tVar) {
        return new cn(this, tVar);
    }
}
