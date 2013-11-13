package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.f2231a = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        BaseFragmentActivity baseFragmentActivity;
        if (TiebaApplication.g().s()) {
            baseFragmentActivity = this.f2231a.g;
            StatService.onEvent(baseFragmentActivity, "person_info_pull", "infopull", 1);
        }
        this.f2231a.a();
    }
}
