package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2128a;
    final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cp cpVar, com.baidu.tieba.editortool.h hVar) {
        this.b = cpVar;
        this.f2128a = hVar;
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
                if (!pbEditor2.k() && TiebaApplication.g().s()) {
                    newPbActivity = this.b.g;
                    StatService.onEvent(newPbActivity, "pb_reply", "pbclick", 1);
                }
            }
        }
        this.f2128a.a(i, obj);
    }
}
