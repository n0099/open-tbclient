package com.baidu.tieba.pb.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ d cnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cnC = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        d.a aVar;
        d.a aVar2;
        d.a aVar3;
        d.a aVar4;
        d.a aVar5;
        d.a aVar6;
        List list;
        int i;
        int i2;
        int i3;
        int i4;
        d.a aVar7;
        d.a aVar8;
        int i5;
        List<a> list2;
        int i6;
        int i7;
        List list3;
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
            aVar = this.cnC.cnA;
            if (aVar != null) {
                aVar2 = this.cnC.cnA;
                aVar2.bF(null);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if (statusCode != 200 || error != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            aVar3 = this.cnC.cnA;
            if (aVar3 != null) {
                aVar4 = this.cnC.cnA;
                aVar4.bF(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
        if (praiseListResponsedMessage.getError() != 0) {
            aVar5 = this.cnC.cnA;
            if (aVar5 != null) {
                aVar6 = this.cnC.cnA;
                aVar6.bF(praiseListResponsedMessage.getErrMsg());
                return;
            }
            return;
        }
        List<a> list4 = praiseListResponsedMessage.getmZanItemDataList();
        if (list4 != null) {
            for (a aVar9 : list4) {
                list3 = this.cnC.cnz;
                list3.add(aVar9);
            }
        }
        d dVar = this.cnC;
        list = this.cnC.cnz;
        dVar.cny = list.size();
        this.cnC.cnx = praiseListResponsedMessage.getTotalNum();
        d dVar2 = this.cnC;
        i = dVar2.cnw;
        dVar2.cnw = i + 1;
        int i8 = BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES;
        i2 = this.cnC.cnw;
        if (i2 > 5) {
            i8 = 1003;
        }
        i3 = this.cnC.cny;
        i4 = this.cnC.cnx;
        if (i3 >= i4) {
            i8 = BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE;
        }
        aVar7 = this.cnC.cnA;
        if (aVar7 != null) {
            aVar8 = this.cnC.cnA;
            i5 = this.cnC.cnx;
            list2 = this.cnC.cnz;
            i6 = this.cnC.cnx;
            i7 = this.cnC.cny;
            aVar8.a(i5, list2, i8, i6 - i7);
        }
    }
}
