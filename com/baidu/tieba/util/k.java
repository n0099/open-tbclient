package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j {
    final /* synthetic */ DatabaseService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(DatabaseService databaseService) {
        this.a = databaseService;
    }

    @Override // com.baidu.tieba.util.j
    public void a() {
        try {
            TiebaApplication.f().M();
        } catch (Exception e) {
        }
    }
}
