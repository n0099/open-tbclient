package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DatabaseService f1767a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(DatabaseService databaseService) {
        this.f1767a = databaseService;
    }

    @Override // com.baidu.tieba.util.m
    public void a() {
        try {
            TiebaApplication.f().N();
        } catch (Exception e) {
        }
    }
}
