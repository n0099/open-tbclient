package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout implements com.baidu.tieba.view.ao {
    private static final Pattern f = Pattern.compile("#\\([^#\\)\\(]+\\)$");

    /* renamed from: a  reason: collision with root package name */
    protected Context f2050a;
    protected PbEditorToolView b;
    protected EditorToolComponetContainer c;
    protected com.baidu.tieba.editortool.h d;
    protected boolean e;

    public PbEditor(Context context) {
        super(context);
        this.e = true;
        this.f2050a = context;
        j();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        this.f2050a = context;
        j();
    }

    public void a() {
        this.b.f();
    }

    public void b() {
        this.b.g();
    }

    public boolean c() {
        Editable text = this.b.getEditText().getText();
        if ((text == null || text.length() <= 0) && !this.c.m()) {
            return this.c.n();
        }
        return true;
    }

    public EditText getEditText() {
        return this.b.getEditText();
    }

    public void a(String str) {
        this.b.a(str);
    }

    public String getContent() {
        return this.b.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.b.getEditText().setText(str);
    }

    public void d() {
        this.b.i();
    }

    public void e() {
        this.b.h();
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
    }

    public void f() {
        this.c.i();
        this.b.l();
        this.b.i();
    }

    public void g() {
        this.c.i();
        this.b.l();
    }

    public void h() {
        if (this.c.h()) {
            com.baidu.tieba.editortool.l.a(this, this.f2050a, new cb(this));
        } else {
            f();
        }
    }

    public boolean i() {
        return this.c.h();
    }

    protected void j() {
        LayoutInflater.from(this.f2050a).inflate(R.layout.pb_editor_view, (ViewGroup) this, true);
        this.b = (PbEditorToolView) findViewById(R.id.pb_editor_tool_button);
        this.c = (EditorToolComponetContainer) findViewById(R.id.pb_editor_tool_group);
    }

    public boolean k() {
        return this.c.r();
    }

    public void a(View view) {
        this.c.a(view);
    }

    public void b(View view) {
        this.c.b(view);
    }

    public void l() {
        com.baidu.tieba.editortool.l.a(this, this.f2050a, new cc(this));
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        this.c.a(i);
        if (i == 1 && !i()) {
            new Handler().postDelayed(new cd(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.baidu.tieba.editortool.o oVar) {
        this.b.getEditText().requestFocus();
        this.c.b(this.b.getEditText());
        b(i);
        if (oVar != null) {
            com.baidu.tieba.editortool.l.b(this, this.f2050a, oVar);
        } else {
            com.baidu.tieba.editortool.l.a(this, this.f2050a);
        }
    }

    protected void b(int i) {
        if (i == 5) {
            this.c.k();
        } else if (i == 8) {
            this.c.l();
        } else if (i == 2) {
            this.c.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        if (this.c.h()) {
            com.baidu.tieba.editortool.l.a(this, this.f2050a, new ce(this, i));
            return;
        }
        this.c.b(this.b.getEditText());
        this.e = false;
        new Handler().postDelayed(new cf(this, i), 200L);
    }

    public void setOnActionListener(com.baidu.tieba.editortool.h hVar) {
        if (hVar != null) {
            this.d = hVar;
            this.b.setOnActionListener(new ch(this, hVar));
            this.c.setOnActionListener(new ci(this, hVar));
        }
    }

    public void d(int i) {
        this.b.a(i);
    }

    public void m() {
        this.b.b();
        this.c.o();
    }

    public void n() {
        if (this.d != null) {
            this.d.a(33, null);
        }
        setVisibility(0);
    }

    public void o() {
        if (this.d != null) {
            this.d.a(34, null);
        }
        this.b.l();
        this.c.i();
        b(getEditText());
        setVisibility(8);
    }

    public boolean p() {
        return getVisibility() == 0;
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public void q() {
        this.b.d();
    }

    public void r() {
        this.b.c();
    }

    public void s() {
        this.c.p();
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.c.getAudioData();
    }

    public void setImageFocusable(boolean z) {
        this.b.setImageFocusable(z);
    }

    public boolean t() {
        return this.b.m();
    }

    public void u() {
        this.b.n();
    }

    public void a(Bitmap bitmap) {
        this.b.a(bitmap);
    }

    public Bitmap getImage() {
        return this.b.getImage();
    }

    public void v() {
        this.b.e();
    }
}
