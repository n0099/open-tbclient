package com.baidu.tieba.pb.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ d cTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cTk = dVar;
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
            aVar = this.cTk.cTi;
            if (aVar != null) {
                aVar2 = this.cTk.cTi;
                aVar2.bN(null);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if (statusCode != 200 || error != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            aVar3 = this.cTk.cTi;
            if (aVar3 != null) {
                aVar4 = this.cTk.cTi;
                aVar4.bN(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
        if (praiseListResponsedMessage.getError() != 0) {
            aVar5 = this.cTk.cTi;
            if (aVar5 != null) {
                aVar6 = this.cTk.cTi;
                aVar6.bN(praiseListResponsedMessage.getErrMsg());
                return;
            }
            return;
        }
        List<a> list4 = praiseListResponsedMessage.getmZanItemDataList();
        if (list4 != null) {
            for (a aVar9 : list4) {
                list3 = this.cTk.cTh;
                list3.add(aVar9);
            }
        }
        d dVar = this.cTk;
        list = this.cTk.cTh;
        dVar.cTg = list.size();
        this.cTk.cTf = praiseListResponsedMessage.getTotalNum();
        d dVar2 = this.cTk;
        i = dVar2.cTe;
        dVar2.cTe = i + 1;
        int i8 = BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES;
        i2 = this.cTk.cTe;
        if (i2 > 5) {
            i8 = 1003;
        }
        i3 = this.cTk.cTg;
        i4 = this.cTk.cTf;
        if (i3 >= i4) {
            i8 = BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE;
        }
        aVar7 = this.cTk.cTi;
        if (aVar7 != null) {
            aVar8 = this.cTk.cTi;
            i5 = this.cTk.cTf;
            list2 = this.cTk.cTh;
            i6 = this.cTk.cTf;
            i7 = this.cTk.cTg;
            aVar8.a(i5, list2, i8, i6 - i7);
        }
    }
}
