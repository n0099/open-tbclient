package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DatabaseService f2614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(DatabaseService databaseService) {
        this.f2614a = databaseService;
    }

    @Override // com.baidu.tieba.util.u
    public void a() {
        try {
            TiebaApplication.h().J();
        } catch (Exception e) {
        }
    }
}
