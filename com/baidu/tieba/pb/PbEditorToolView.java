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

    public void a(ArrayList<String> arrayList) {
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

    public void setOnActionListener(com.baidu.tieba.editortool.z zVar) {
        this.b.setOnActionListener(new co(this, zVar));
        this.c.setOnTouchListener(new cp(this, zVar));
        this.c.addTextChangedListener(new cq(this, zVar));
        this.d.setOnClickListener(new cr(this, zVar));
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
        if (TiebaApplication.g().al() == 1) {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_enable_text_1));
        } else {
            this.d.setTextColor(this.a.getResources().getColor(R.color.editor_tool_post_enable_text));
        }
    }

    public void f() {
        this.d.setEnabled(false);
        if (TiebaApplication.g().al() == 1) {
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
        this.b.h();
    }

    public void j() {
        this.b.i();
    }

    public void k() {
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
