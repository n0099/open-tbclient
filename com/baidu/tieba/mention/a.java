package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class a implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtMeActivity f1289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtMeActivity atMeActivity) {
        this.f1289a = atMeActivity;
    }

    @Override // com.baidu.tieba.mention.n
    public void a(String str) {
        DatabaseService.m(str);
    }

    @Override // com.baidu.tieba.mention.n
    public String a() {
        return DatabaseService.l();
    }

    @Override // com.baidu.tieba.mention.n
    public void b() {
        DatabaseService.k();
    }
}
