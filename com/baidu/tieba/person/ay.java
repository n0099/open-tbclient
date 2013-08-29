package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonInfoActivity personInfoActivity) {
        this.f1620a = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1620a, "person_info_pull", "infopull", 1);
        }
        this.f1620a.c();
    }
}
