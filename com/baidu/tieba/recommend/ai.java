package com.baidu.tieba.recommend;

import android.app.Activity;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.data.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FindInterestFragment findInterestFragment) {
        this.f1637a = findInterestFragment;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        bl blVar;
        com.baidu.tieba.model.o oVar;
        bl blVar2;
        bl blVar3;
        Activity activity;
        aq aqVar;
        com.baidu.tieba.model.o oVar2;
        blVar = this.f1637a.e;
        if (blVar == null) {
            oVar2 = this.f1637a.f1625a;
            oVar2.a("get_all_interest", "", 2);
        } else {
            oVar = this.f1637a.f1625a;
            blVar2 = this.f1637a.e;
            String a2 = blVar2.a();
            blVar3 = this.f1637a.e;
            oVar.a(a2, blVar3.b(), 2);
        }
        activity = this.f1637a.d;
        StatService.onEvent(activity, "findinterest_pull", "pulldate");
        aqVar = this.f1637a.b;
        aqVar.g();
    }
}
