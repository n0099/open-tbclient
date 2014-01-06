package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements com.baidu.tieba.editortool.t {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ cs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cs csVar, com.baidu.tieba.editortool.t tVar) {
        this.b = csVar;
        this.a = tVar;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        NewPbActivity newPbActivity;
        if (i == 33) {
            pbEditor = this.b.aq;
            if (!pbEditor.h()) {
                pbEditor2 = this.b.aq;
                if (!pbEditor2.j() && TiebaApplication.g().s()) {
                    newPbActivity = this.b.g;
                    StatService.onEvent(newPbActivity, "pb_reply", "pbclick", 1);
                }
            }
        }
        this.a.a(i, obj);
    }
}
