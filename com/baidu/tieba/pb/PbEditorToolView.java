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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected Context a;
    protected PbEditorToolButtonContainer b;
    protected EditText c;
    protected Button d;

    public PbEditorToolView(Context context) {
        super(context);
        this.a = context;
        k();
    }

    public PbEditorToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        k();
    }

    public Button getPostButton() {
        return this.d;
    }

    public EditText getEditText() {
        return this.c;
    }

    private void k() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_tool_view, (ViewGroup) this, true);
        this.b = (PbEditorToolButtonContainer) findViewById(R.id.tool_button_container);
        this.c = (EditText) findViewById(R.id.reply_content);
        this.d = (Button) findViewById(R.id.pb_reply_post);
        this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
    }

    public final void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.c.getText().insert(this.c.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void setOnActionListener(com.baidu.tieba.editortool.aa aaVar) {
        this.b.setOnActionListener(new co(this, aaVar));
        this.c.setOnTouchListener(new cp(this, aaVar));
        this.c.addTextChangedListener(new cq(this, aaVar));
        this.d.setOnClickListener(new cr(this, aaVar));
    }

    public final void a() {
        this.b.e();
        this.c.setText("");
        e();
    }

    public final void b() {
        this.b.a(true);
    }

    public final void c() {
        this.b.a(false);
    }

    public final void d() {
        this.d.setEnabled(true);
        if (TiebaApplication.g().ae() == 1) {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_enable_text_1));
        } else {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_enable_text));
        }
    }

    public final void e() {
        this.d.setEnabled(false);
        if (TiebaApplication.g().ae() == 1) {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_disable_text_1));
        } else {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_disable_text));
        }
    }

    public final void f() {
        this.b.d();
    }

    public final void g() {
        this.b.e();
    }

    public final void h() {
        this.b.f();
    }

    public final void i() {
        this.b.g();
    }

    public final void j() {
        this.b.c();
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.b.setMoreFocusable(z);
    }

    public final void a(int i) {
        this.c.setHintTextColor(this.a.getResources().getColor(i == 1 ? R.color.pb_editor_edittext_hint_text_1 : R.color.pb_editor_edittext_hint_text));
    }
}
