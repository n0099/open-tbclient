package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected Context a;
    protected PbEditorToolButtonContainer b;
    protected PbEditorToolButtonContainer c;
    protected EditText d;
    protected Button e;

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
        return this.e;
    }

    public EditText getEditText() {
        return this.d;
    }

    protected void a() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_tool_view, (ViewGroup) this, true);
        this.b = (PbEditorToolButtonContainer) findViewById(R.id.tool_button_container);
        this.b.b(false);
        this.c = (PbEditorToolButtonContainer) findViewById(R.id.extern_tool_button_container);
        this.c.setAtFocusable(false);
        this.d = (EditText) findViewById(R.id.reply_content);
        this.e = (Button) findViewById(R.id.pb_reply_post);
        this.d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
    }

    public void a(String str) {
        this.d.getText().insert(this.d.getSelectionStart(), "@" + str + " ");
    }

    public void setOnActionListener(com.baidu.tieba.editortool.h hVar) {
        cn cnVar = new cn(this, hVar);
        this.b.setOnActionListener(cnVar);
        this.d.setOnTouchListener(new co(this, hVar));
        this.d.addTextChangedListener(new cp(this, hVar));
        this.e.setOnClickListener(new cq(this, hVar));
        this.c.setOnActionListener(cnVar);
    }

    public void b() {
        this.b.k();
        this.c.k();
        this.b.i();
        this.c.i();
        this.d.setText("");
        this.e.setEnabled(false);
        this.b.l();
        this.c.l();
    }

    public void c() {
        this.b.d(true);
        this.b.a(false);
        this.c.d(true);
    }

    public void d() {
        this.b.d(false);
        this.b.a(true);
        this.c.d(false);
    }

    public void e() {
        this.b.c(false);
        this.c.c(false);
    }

    public void f() {
        this.e.setEnabled(true);
    }

    public void g() {
        this.e.setEnabled(false);
    }

    public void h() {
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    public void i() {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
    }

    public void j() {
        this.b.j();
        this.c.j();
    }

    public void k() {
        this.b.k();
        this.c.k();
    }

    public void l() {
        this.b.c();
        this.c.c();
    }

    public void setImageFocusable(boolean z) {
        this.b.setImageFocusable(z);
        this.c.setImageFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
        this.c.setAudioFocusable(z);
    }

    public void a(int i) {
        this.d.setHintTextColor(this.a.getResources().getColor(i == 1 ? R.color.pb_editor_edittext_hint_text_1 : R.color.pb_editor_edittext_hint_text));
    }

    public boolean m() {
        return this.c.m();
    }

    public void n() {
        this.c.l();
        this.b.l();
    }

    public void a(Bitmap bitmap) {
        this.c.a(bitmap);
        this.b.a(bitmap);
    }

    public Bitmap getImage() {
        return this.c.getImage();
    }
}
