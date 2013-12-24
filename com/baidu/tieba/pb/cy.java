package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tieba.editortool.h {
    final /* synthetic */ com.baidu.tieba.editortool.h a;
    final /* synthetic */ cr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cr crVar, com.baidu.tieba.editortool.h hVar) {
        this.b = crVar;
        this.a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        NewPbActivity newPbActivity;
        if (i == 33) {
            pbEditor = this.b.an;
            if (!pbEditor.i()) {
                pbEditor2 = this.b.an;
                if (!pbEditor2.k() && TiebaApplication.h().t()) {
                    newPbActivity = this.b.g;
                    StatService.onEvent(newPbActivity, "pb_reply", "pbclick", 1);
                }
            }
        }
        this.a.a(i, obj);
    }
}
