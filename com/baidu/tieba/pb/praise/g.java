package com.baidu.tieba.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.a = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
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
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1006000) {
            hVar = this.a.i;
            if (hVar != null) {
                hVar2 = this.a.i;
                hVar2.a(null);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if (statusCode != 200 || error != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            hVar3 = this.a.i;
            if (hVar3 != null) {
                hVar4 = this.a.i;
                hVar4.a(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
        if (praiseListResponsedMessage.getError() != 0) {
            hVar5 = this.a.i;
            if (hVar5 != null) {
                hVar6 = this.a.i;
                hVar6.a(praiseListResponsedMessage.getErrMsg());
                return;
            }
            return;
        }
        List<a> list4 = praiseListResponsedMessage.getmZanItemDataList();
        if (list4 != null) {
            for (a aVar : list4) {
                list3 = this.a.h;
                list3.add(aVar);
            }
        }
        f fVar = this.a;
        list = this.a.h;
        fVar.g = list.size();
        this.a.f = praiseListResponsedMessage.getTotalNum();
        f fVar2 = this.a;
        i = fVar2.e;
        fVar2.e = i + 1;
        int i8 = 1001;
        i2 = this.a.e;
        if (i2 > 5) {
            i8 = 1003;
        }
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
        }
    }
}
