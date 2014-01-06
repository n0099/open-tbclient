package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
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
        if (TiebaApplication.g().s()) {
            baseFragmentActivity = this.a.g;
            StatService.onEvent(baseFragmentActivity, "person_info_pull", "infopull", 1);
        }
        this.a.a();
    }
}
