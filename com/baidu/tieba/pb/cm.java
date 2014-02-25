package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements com.baidu.tieba.editortool.z {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PbEditor pbEditor, com.baidu.tieba.editortool.z zVar) {
        this.a = pbEditor;
        this.b = zVar;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        Pattern pattern;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.w)) {
                com.baidu.tieba.editortool.w wVar = (com.baidu.tieba.editortool.w) obj;
                if (wVar.a() != null) {
                    if (com.baidu.tieba.util.bs.g(this.a.b.getEditText().getText().toString()) >= 10 && (this.a.a instanceof com.baidu.tieba.f)) {
                        ((com.baidu.tieba.f) this.a.a).showToast(this.a.a.getResources().getString(R.string.too_many_face));
                        return;
                    } else {
                        this.a.b.getEditText().getText().insert(this.a.b.getEditText().getSelectionStart(), wVar.a());
                    }
                }
                if (this.a.c()) {
                    this.a.b.e();
                } else {
                    this.a.b.f();
                }
            }
        } else if (i == 21) {
            if (this.a.b.getEditText().getSelectionStart() > 0) {
                String substring = this.a.b.getEditText().getText().toString().substring(0, this.a.b.getEditText().getSelectionStart());
                pattern = PbEditor.f;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.a.b.getEditText().getText().delete(this.a.b.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.a.b.getEditText().getSelectionStart());
                    return;
                }
                this.a.b.getEditText().getText().delete(this.a.b.getEditText().getSelectionStart() - 1, this.a.b.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.a.b.g();
            if (this.a.c()) {
                this.a.b.e();
            } else {
                this.a.b.f();
            }
        } else if (i == 15) {
            this.a.b.h();
            if (this.a.c()) {
                this.a.b.e();
            } else {
                this.a.b.f();
            }
        } else if (i == 2) {
            this.a.b(i);
            this.a.b.k();
        } else if (i == 23) {
            this.a.b.k();
            if (this.a.c.q()) {
                this.a.b(i);
            } else {
                this.b.a(i, obj);
            }
        } else if (i == 22) {
            this.a.b.k();
            this.b.a(i, obj);
        } else if (i == 13) {
            if (this.a.c.q()) {
                this.a.b.i();
            } else {
                this.a.b.j();
            }
            if (this.a.c()) {
                this.a.b.e();
            } else {
                this.a.b.f();
            }
            this.b.a(i, obj);
        } else {
            this.b.a(i, obj);
        }
    }
}
