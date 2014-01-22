package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern f = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    protected Context a;
    protected PbEditorToolView b;
    protected EditorToolComponetContainer c;
    protected com.baidu.tieba.editortool.t d;
    protected boolean e;
    private boolean g;

    public PbEditor(Context context) {
        super(context);
        this.e = true;
        this.a = context;
        i();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        this.a = context;
        i();
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    public void a() {
        this.b.e();
    }

    public void b() {
        this.b.f();
    }

    public boolean c() {
        Editable text = this.b.getEditText().getText();
        if ((text == null || text.length() <= 0) && !this.c.p()) {
            return this.c.q();
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
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
    }

    public void e() {
        this.c.k();
        this.b.i();
    }

    public void f() {
        this.c.k();
        this.b.i();
    }

    public void g() {
        if (this.c.j() && !this.g) {
            this.g = true;
            com.baidu.tieba.editortool.x.a(this, this.a, new cf(this));
            return;
        }
        e();
    }

    public boolean h() {
        return this.c.j();
    }

    protected void i() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_view, (ViewGroup) this, true);
        this.b = (PbEditorToolView) findViewById(R.id.pb_editor_tool_button);
        this.c = (EditorToolComponetContainer) findViewById(R.id.pb_editor_tool_group);
    }

    public boolean j() {
        return this.c.u();
    }

    public void a(View view) {
        this.c.a(view);
    }

    public void b(View view) {
        this.c.b(view);
    }

    public void k() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
        this.b.getEditText().setSelection(this.b.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.baidu.tieba.editortool.z zVar) {
        this.b.getEditText().requestFocus();
        this.c.b(this.b.getEditText());
        a(i);
    }

    protected void a(int i) {
        if (i == 5) {
            this.c.n();
        } else if (i == 8) {
            this.c.o();
        } else if (i == 2) {
            this.c.m();
        } else if (i == 36) {
            this.c.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (this.c.j()) {
            a(i);
            return;
        }
        this.e = false;
        if (this.c.u()) {
            this.c.b(this.b.getEditText());
        }
        new Handler().postDelayed(new cg(this, i), 200L);
    }

    public void setOnActionListener(com.baidu.tieba.editortool.t tVar) {
        if (tVar != null) {
            this.d = tVar;
            this.b.setOnActionListener(new ci(this, tVar));
            this.c.setOnActionListener(new cj(this, tVar));
        }
    }

    public void c(int i) {
        this.b.a(i);
        this.c.a(i);
        if (this.a instanceof com.baidu.tieba.j) {
            ((com.baidu.tieba.j) this.a).getLayoutMode().a(i == 1);
            ((com.baidu.tieba.j) this.a).getLayoutMode().a((View) this.b);
            ((com.baidu.tieba.j) this.a).getLayoutMode().a((View) this.c);
        } else if (this.a instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.a).a().a(i == 1);
            ((BaseFragmentActivity) this.a).a().a((View) this.b);
            ((BaseFragmentActivity) this.a).a().a((View) this.c);
        }
    }

    public void l() {
        this.b.b();
        this.c.r();
    }

    public void m() {
        if (this.d != null) {
            this.d.a(33, null);
        }
        setVisibility(0);
    }

    public void n() {
        if (this.d != null) {
            this.d.a(34, null);
        }
        this.b.i();
        this.c.k();
        b(getEditText());
        setVisibility(8);
    }

    public boolean o() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.b.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public void p() {
        this.b.d();
    }

    public void q() {
        this.b.c();
    }

    public void r() {
        this.c.s();
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.c.getAudioData();
    }

    public boolean s() {
        return this.c.v();
    }

    public void a(Bitmap bitmap) {
        this.c.setImage(bitmap);
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
