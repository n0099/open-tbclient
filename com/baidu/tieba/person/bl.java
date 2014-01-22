package com.baidu.tieba.person;

import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.adp.widget.ScrollView.n {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        BaseFragmentActivity baseFragmentActivity;
        baseFragmentActivity = this.a.g;
        com.baidu.tieba.util.by.a(baseFragmentActivity, "person_info_pull", "infopull", 1, new Object[0]);
        this.a.a();
    }
}
