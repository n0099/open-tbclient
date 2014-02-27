package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements aa {
    final /* synthetic */ DatabaseService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(DatabaseService databaseService) {
        this.a = databaseService;
    }

    @Override // com.baidu.tieba.util.aa
    public final void a() {
        try {
            TiebaApplication.g().C();
        } catch (Exception e) {
        }
    }
}
