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
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern f = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    protected Context a;
    protected PbEditorToolView b;
    protected EditorToolComponetContainer c;
    protected com.baidu.tieba.editortool.aa d;
    protected boolean e;
    private boolean g;

    public PbEditor(Context context) {
        super(context);
        this.e = true;
        this.a = context;
        s();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        this.a = context;
        s();
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    public final void a() {
        this.b.d();
    }

    public final void b() {
        this.b.e();
    }

    public final boolean c() {
        Editable text = this.b.getEditText().getText();
        if ((text == null || text.length() <= 0) && !this.c.h()) {
            return this.c.i();
        }
        return true;
    }

    public EditText getEditText() {
        return this.b.getEditText();
    }

    public final void a(ArrayList<String> arrayList) {
        this.b.a(arrayList);
    }

    public String getContent() {
        return this.b.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.b.getEditText().setText(str);
    }

    public final void d() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
    }

    public final void e() {
        this.c.b();
        this.b.j();
    }

    public final void f() {
        this.c.b();
        this.b.j();
    }

    public final void g() {
        if (this.c.a() && !this.g) {
            this.g = true;
            Context context = this.a;
            com.baidu.tieba.editortool.ad.a(this, new ci(this));
            return;
        }
        e();
    }

    public final boolean h() {
        return this.c.a();
    }

    private void s() {
        LayoutInflater.from(this.a).inflate(R.layout.pb_editor_view, (ViewGroup) this, true);
        this.b = (PbEditorToolView) findViewById(R.id.pb_editor_tool_button);
        this.c = (EditorToolComponetContainer) findViewById(R.id.pb_editor_tool_group);
    }

    public final boolean i() {
        return this.c.m();
    }

    public final void a(View view) {
        this.c.a(view);
    }

    public final void j() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
        this.b.getEditText().setSelection(this.b.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        this.b.getEditText().requestFocus();
        this.c.b(this.b.getEditText());
        d(i);
    }

    private void d(int i) {
        if (i == 5) {
            this.c.f();
        } else if (i == 23 || i == 22) {
            this.c.g();
        } else if (i == 2) {
            this.c.e();
        } else if (i == 38) {
            this.c.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i) {
        if (this.c.a()) {
            d(i);
            return;
        }
        this.e = false;
        if (this.c.m()) {
            this.c.b(this.b.getEditText());
        }
        new Handler().postDelayed(new cj(this, i), 200L);
    }

    public void setOnActionListener(com.baidu.tieba.editortool.aa aaVar) {
        if (aaVar != null) {
            this.d = aaVar;
            this.b.setOnActionListener(new cl(this, aaVar));
            this.c.setOnActionListener(new cm(this, aaVar));
        }
    }

    public final void c(int i) {
        this.b.a(i);
        this.c.a(i);
        if (this.a instanceof com.baidu.tieba.f) {
            ((com.baidu.tieba.f) this.a).getLayoutMode().a(i == 1);
            ((com.baidu.tieba.f) this.a).getLayoutMode().a(this.b);
            ((com.baidu.tieba.f) this.a).getLayoutMode().a(this.c);
        } else if (this.a instanceof com.baidu.tieba.k) {
            ((com.baidu.tieba.k) this.a).a().a(i == 1);
            ((com.baidu.tieba.k) this.a).a().a(this.b);
            ((com.baidu.tieba.k) this.a).a().a(this.c);
        }
    }

    public final void k() {
        this.b.a();
        this.c.j();
    }

    public final void l() {
        if (this.d != null) {
            this.d.a(33, null);
        }
        setVisibility(0);
    }

    public final void m() {
        if (this.d != null) {
            this.d.a(34, null);
        }
        this.b.j();
        this.c.b();
        this.c.b(getEditText());
        setVisibility(8);
    }

    public final boolean n() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.b.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public final void o() {
        this.b.c();
    }

    public final void p() {
        this.b.b();
    }

    public final void q() {
        this.c.k();
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.c.getAudioData();
    }

    public final void a(Bitmap bitmap) {
        this.c.setImage(bitmap);
    }

    public final void a(boolean z) {
        this.c.a(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
