package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements y {
    final /* synthetic */ DatabaseService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(DatabaseService databaseService) {
        this.a = databaseService;
    }

    @Override // com.baidu.tieba.util.y
    public void a() {
        try {
            TiebaApplication.h().I();
        } catch (Exception e) {
        }
    }
}
