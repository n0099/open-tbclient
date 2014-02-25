package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements aa {
    final /* synthetic */ DatabaseService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(DatabaseService databaseService) {
        this.a = databaseService;
    }

    @Override // com.baidu.tieba.util.aa
    public void a() {
        try {
            TiebaApplication.g().I();
        } catch (Exception e) {
        }
    }
}
