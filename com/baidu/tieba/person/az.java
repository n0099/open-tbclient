package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.adp.widget.ScrollView.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.f2189a = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.o
    public void a() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2189a, "person_info_pull", "infopull", 1);
        }
        this.f2189a.b();
    }
}
