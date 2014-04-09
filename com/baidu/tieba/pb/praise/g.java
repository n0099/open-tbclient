package com.baidu.tieba.pb.praise;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.framework.c.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(1005000);
        this.a = fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        h hVar6;
        List list;
        int i;
        int i2;
        int i3;
        int i4;
        h hVar7;
        h hVar8;
        int i5;
        List<a> list2;
        int i6;
        int i7;
        List list3;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1005000) {
            hVar = this.a.i;
            if (hVar != null) {
                hVar2 = this.a.i;
                hVar2.a(null);
                return;
            }
            return;
        }
        int d = httpResponsedMessage2.d();
        int e = httpResponsedMessage2.e();
        if (d != 200 || e != 0 || !(httpResponsedMessage2 instanceof PraiseListResponsedMessage)) {
            hVar3 = this.a.i;
            if (hVar3 != null) {
                hVar4 = this.a.i;
                hVar4.a(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage2;
        if (praiseListResponsedMessage.e() == 0) {
            List<a> k = praiseListResponsedMessage.k();
            if (k != null) {
                for (a aVar : k) {
                    list3 = this.a.h;
                    list3.add(aVar);
                }
            }
            f fVar = this.a;
            list = this.a.h;
            fVar.g = list.size();
            this.a.f = praiseListResponsedMessage.j();
            f fVar2 = this.a;
            i = fVar2.e;
            fVar2.e = i + 1;
            i2 = this.a.e;
            int i8 = i2 > 5 ? 1003 : 1001;
            i3 = this.a.g;
            i4 = this.a.f;
            if (i3 >= i4) {
                i8 = 1002;
            }
            hVar7 = this.a.i;
            if (hVar7 != null) {
                hVar8 = this.a.i;
                i5 = this.a.f;
                list2 = this.a.h;
                i6 = this.a.f;
                i7 = this.a.g;
                hVar8.a(i5, list2, i8, i6 - i7);
                return;
            }
            return;
        }
        hVar5 = this.a.i;
        if (hVar5 != null) {
            hVar6 = this.a.i;
            hVar6.a(praiseListResponsedMessage.i());
        }
    }
}
