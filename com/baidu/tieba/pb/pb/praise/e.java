package com.baidu.tieba.pb.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ d cmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cmo = dVar;
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
            aVar = this.cmo.cmm;
            if (aVar != null) {
                aVar2 = this.cmo.cmm;
                aVar2.bH(null);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if (statusCode != 200 || error != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            aVar3 = this.cmo.cmm;
            if (aVar3 != null) {
                aVar4 = this.cmo.cmm;
                aVar4.bH(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
        if (praiseListResponsedMessage.getError() != 0) {
            aVar5 = this.cmo.cmm;
            if (aVar5 != null) {
                aVar6 = this.cmo.cmm;
                aVar6.bH(praiseListResponsedMessage.getErrMsg());
                return;
            }
            return;
        }
        List<a> list4 = praiseListResponsedMessage.getmZanItemDataList();
        if (list4 != null) {
            for (a aVar9 : list4) {
                list3 = this.cmo.cml;
                list3.add(aVar9);
            }
        }
        d dVar = this.cmo;
        list = this.cmo.cml;
        dVar.cmk = list.size();
        this.cmo.cmj = praiseListResponsedMessage.getTotalNum();
        d dVar2 = this.cmo;
        i = dVar2.cmi;
        dVar2.cmi = i + 1;
        int i8 = BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES;
        i2 = this.cmo.cmi;
        if (i2 > 5) {
            i8 = 1003;
        }
        i3 = this.cmo.cmk;
        i4 = this.cmo.cmj;
        if (i3 >= i4) {
            i8 = BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE;
        }
        aVar7 = this.cmo.cmm;
        if (aVar7 != null) {
            aVar8 = this.cmo.cmm;
            i5 = this.cmo.cmj;
            list2 = this.cmo.cml;
            i6 = this.cmo.cmj;
            i7 = this.cmo.cmk;
            aVar8.a(i5, list2, i8, i6 - i7);
        }
    }
}
