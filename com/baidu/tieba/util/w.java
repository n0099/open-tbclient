package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements v {
    final /* synthetic */ DatabaseService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(DatabaseService databaseService) {
        this.a = databaseService;
    }

    @Override // com.baidu.tieba.util.v
    public void a() {
        try {
            TiebaApplication.h().J();
        } catch (Exception e) {
        }
    }
}
