package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DatabaseService f2502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(DatabaseService databaseService) {
        this.f2502a = databaseService;
    }

    @Override // com.baidu.tieba.util.w
    public void a() {
        try {
            TiebaApplication.g().K();
        } catch (Exception e) {
        }
    }
}
