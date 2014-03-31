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
            hVar = this.a.g;
            if (hVar != null) {
                hVar2 = this.a.g;
                hVar2.a(null);
                return;
            }
            return;
        }
        int d = httpResponsedMessage2.d();
        int e = httpResponsedMessage2.e();
        if (d != 200 || e != 0 || !(httpResponsedMessage2 instanceof PraiseListResponsedMessage)) {
            hVar3 = this.a.g;
            if (hVar3 != null) {
                hVar4 = this.a.g;
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
                    list3 = this.a.f;
                    list3.add(aVar);
                }
            }
            f fVar = this.a;
            list = this.a.f;
            fVar.e = list.size();
            this.a.d = praiseListResponsedMessage.j();
            f fVar2 = this.a;
            i = fVar2.c;
            fVar2.c = i + 1;
            i2 = this.a.c;
            int i8 = i2 > 5 ? 1003 : 1001;
            i3 = this.a.e;
            i4 = this.a.d;
            if (i3 >= i4) {
                i8 = 1002;
            }
            hVar7 = this.a.g;
            if (hVar7 != null) {
                hVar8 = this.a.g;
                i5 = this.a.d;
                list2 = this.a.f;
                i6 = this.a.d;
                i7 = this.a.e;
                hVar8.a(i5, list2, i8, i6 - i7);
                return;
            }
            return;
        }
        hVar5 = this.a.g;
        if (hVar5 != null) {
            hVar6 = this.a.g;
            hVar6.a(praiseListResponsedMessage.i());
        }
    }
}
