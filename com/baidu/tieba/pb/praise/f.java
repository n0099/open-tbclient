package com.baidu.tieba.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        List list;
        int i;
        int i2;
        int i3;
        int i4;
        g gVar7;
        g gVar8;
        int i5;
        List<a> list2;
        int i6;
        int i7;
        List list3;
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
            gVar = this.a.i;
            if (gVar != null) {
                gVar2 = this.a.i;
                gVar2.a(null);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if (statusCode != 200 || error != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            gVar3 = this.a.i;
            if (gVar3 != null) {
                gVar4 = this.a.i;
                gVar4.a(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
        if (praiseListResponsedMessage.getError() != 0) {
            gVar5 = this.a.i;
            if (gVar5 != null) {
                gVar6 = this.a.i;
                gVar6.a(praiseListResponsedMessage.getErrMsg());
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
        e eVar = this.a;
        list = this.a.h;
        eVar.g = list.size();
        this.a.f = praiseListResponsedMessage.getTotalNum();
        e eVar2 = this.a;
        i = eVar2.e;
        eVar2.e = i + 1;
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
        gVar7 = this.a.i;
        if (gVar7 != null) {
            gVar8 = this.a.i;
            i5 = this.a.f;
            list2 = this.a.h;
            i6 = this.a.f;
            i7 = this.a.g;
            gVar8.a(i5, list2, i8, i6 - i7);
        }
    }
}
