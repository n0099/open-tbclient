package com.baidu.tieba.pb;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cm implements com.baidu.tieba.editortool.aa {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ com.baidu.tieba.editortool.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PbEditor pbEditor, com.baidu.tieba.editortool.aa aaVar) {
        this.a = pbEditor;
        this.b = aaVar;
    }

    @Override // com.baidu.tieba.editortool.aa
    public final void a(int i, Object obj) {
        Pattern pattern;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.x)) {
                com.baidu.tieba.editortool.x xVar = (com.baidu.tieba.editortool.x) obj;
                if (xVar.a() != null) {
                    if (com.baidu.tieba.util.bs.h(this.a.b.getEditText().getText().toString()) >= 10 && (this.a.a instanceof com.baidu.tieba.f)) {
                        ((com.baidu.tieba.f) this.a.a).showToast(this.a.a.getResources().getString(R.string.too_many_face));
                        return;
                    } else {
                        this.a.b.getEditText().getText().insert(this.a.b.getEditText().getSelectionStart(), xVar.a());
                    }
                }
                if (this.a.c()) {
                    this.a.b.d();
                } else {
                    this.a.b.e();
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
            this.a.b.f();
            if (this.a.c()) {
                this.a.b.d();
            } else {
                this.a.b.e();
            }
        } else if (i == 15) {
            this.a.b.g();
            if (this.a.c()) {
                this.a.b.d();
            } else {
                this.a.b.e();
            }
        } else if (i == 2) {
            this.a.b(i);
            this.a.b.j();
        } else if (i == 23) {
            this.a.b.j();
            if (this.a.c.h()) {
                this.a.b(i);
            } else {
                this.b.a(i, obj);
            }
        } else {
            if (i == 22) {
                this.a.b.j();
            } else if (i == 13) {
                if (this.a.c.h()) {
                    this.a.b.h();
                } else {
                    this.a.b.i();
                }
                if (this.a.c()) {
                    this.a.b.d();
                } else {
                    this.a.b.e();
                }
                this.b.a(i, obj);
                return;
            } else if (i == 0) {
                if (this.a.b.getEditText().getText()) {
                    BdUtilHelper.a(this.a.getContext(), (int) R.string.over_limit_tip);
                    return;
                } else {
                    this.b.a(i, obj);
                    return;
                }
            }
            this.b.a(i, obj);
        }
    }
}
