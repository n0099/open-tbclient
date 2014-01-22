package com.baidu.tieba.pb;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected Context a;
    protected PbEditorToolButtonContainer b;
    protected EditText c;
    protected Button d;

    public PbEditorToolView(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public PbEditorToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        a();
    }

    public Button getPostButton() {
        return this.d;
    }

    public EditText getEditText() {
        return this.c;
    }

    protected void a() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_tool_view, (ViewGroup) this, true);
        this.b = (PbEditorToolButtonContainer) findViewById(R.id.tool_button_container);
        this.c = (EditText) findViewById(R.id.reply_content);
        this.d = (Button) findViewById(R.id.pb_reply_post);
        this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
    }

    public void a(String str) {
        this.c.getText().insert(this.c.getSelectionStart(), "@" + str + " ");
    }

    public void setOnActionListener(com.baidu.tieba.editortool.t tVar) {
        this.b.setOnActionListener(new cn(this, tVar));
        this.c.setOnTouchListener(new co(this, tVar));
        this.c.addTextChangedListener(new cp(this, tVar));
        this.d.setOnClickListener(new cq(this, tVar));
    }

    public void b() {
        this.b.g();
        this.c.setText("");
        f();
    }

    public void c() {
        this.b.a(true);
    }

    public void d() {
        this.b.a(false);
    }

    public void e() {
        this.d.setEnabled(true);
        if (TiebaApplication.h().al() == 1) {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_enable_text_1));
        } else {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_enable_text));
        }
    }

    public void f() {
        this.d.setEnabled(false);
        if (TiebaApplication.h().al() == 1) {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_disable_text_1));
        } else {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_disable_text));
        }
    }

    public void g() {
        this.b.f();
    }

    public void h() {
        this.b.g();
    }

    public void i() {
        this.b.c();
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.b.setMoreFocusable(z);
    }

    public void a(int i) {
        this.c.setHintTextColor(this.a.getResources().getColor(i == 1 ? R.color.pb_editor_edittext_hint_text_1 : R.color.pb_editor_edittext_hint_text));
    }
}
