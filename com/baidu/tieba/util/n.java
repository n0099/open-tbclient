package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DatabaseService f1804a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(DatabaseService databaseService) {
        this.f1804a = databaseService;
    }

    @Override // com.baidu.tieba.util.m
    public void a() {
        try {
            TiebaApplication.g().N();
        } catch (Exception e) {
        }
    }
}
