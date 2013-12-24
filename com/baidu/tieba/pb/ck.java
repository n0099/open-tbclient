package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements com.baidu.tieba.editortool.h {
    final /* synthetic */ com.baidu.tieba.editortool.h a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(PbEditor pbEditor, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditor;
        this.a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        Pattern pattern;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.g)) {
                com.baidu.tieba.editortool.g gVar = (com.baidu.tieba.editortool.g) obj;
                if (gVar.a() != null) {
                    if (com.baidu.tieba.util.bc.g(this.b.b.getEditText().getText().toString()) >= 10 && (this.b.a instanceof com.baidu.tieba.j)) {
                        ((com.baidu.tieba.j) this.b.a).showToast(this.b.a.getResources().getString(R.string.too_many_face));
                        return;
                    } else {
                        this.b.b.getEditText().getText().insert(this.b.b.getEditText().getSelectionStart(), gVar.a());
                    }
                }
                if (this.b.c()) {
                    this.b.b.f();
                } else {
                    this.b.b.g();
                }
            }
        } else if (i == 21) {
            if (this.b.b.getEditText().getSelectionStart() > 0) {
                String substring = this.b.b.getEditText().getText().toString().substring(0, this.b.b.getEditText().getSelectionStart());
                pattern = PbEditor.f;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.b.b.getEditText().getText().delete(this.b.b.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.b.b.getEditText().getSelectionStart());
                    return;
                }
                this.b.b.getEditText().getText().delete(this.b.b.getEditText().getSelectionStart() - 1, this.b.b.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.b.b.j();
            if (this.b.c()) {
                this.b.b.f();
            } else {
                this.b.b.g();
            }
        } else if (i == 15) {
            this.b.b.k();
            if (this.b.c()) {
                this.b.b.f();
            } else {
                this.b.b.g();
            }
        } else {
            this.a.a(i, obj);
        }
    }
}
