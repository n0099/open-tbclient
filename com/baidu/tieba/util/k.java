package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DatabaseService f1461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(DatabaseService databaseService) {
        this.f1461a = databaseService;
    }

    @Override // com.baidu.tieba.util.j
    public void a() {
        try {
            TiebaApplication.f().M();
        } catch (Exception e) {
        }
    }
}
