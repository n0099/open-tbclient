package com.baidu.tieba.recommend;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.view.ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FindInterestFragment findInterestFragment) {
        this.f1638a = findInterestFragment;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(bl blVar) {
        com.baidu.tieba.model.o oVar;
        aq aqVar;
        oVar = this.f1638a.f1627a;
        oVar.a(blVar.a(), blVar.b(), 1);
        com.baidu.adp.lib.cache.q bm = TiebaApplication.f().bm();
        if (bm != null) {
            bm.a("home_tag", String.valueOf(blVar.a()) + "," + blVar.b(), 100000000L);
        }
        this.f1638a.e = blVar;
        aqVar = this.f1638a.b;
        aqVar.b();
    }
}
