package com.baidu.tieba.pb.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ d cGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cGN = dVar;
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
            aVar = this.cGN.cGL;
            if (aVar != null) {
                aVar2 = this.cGN.cGL;
                aVar2.bK(null);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if (statusCode != 200 || error != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            aVar3 = this.cGN.cGL;
            if (aVar3 != null) {
                aVar4 = this.cGN.cGL;
                aVar4.bK(null);
                return;
            }
            return;
        }
        PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
        if (praiseListResponsedMessage.getError() != 0) {
            aVar5 = this.cGN.cGL;
            if (aVar5 != null) {
                aVar6 = this.cGN.cGL;
                aVar6.bK(praiseListResponsedMessage.getErrMsg());
                return;
            }
            return;
        }
        List<a> list4 = praiseListResponsedMessage.getmZanItemDataList();
        if (list4 != null) {
            for (a aVar9 : list4) {
                list3 = this.cGN.cGK;
                list3.add(aVar9);
            }
        }
        d dVar = this.cGN;
        list = this.cGN.cGK;
        dVar.cGJ = list.size();
        this.cGN.cGI = praiseListResponsedMessage.getTotalNum();
        d dVar2 = this.cGN;
        i = dVar2.cGH;
        dVar2.cGH = i + 1;
        int i8 = BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES;
        i2 = this.cGN.cGH;
        if (i2 > 5) {
            i8 = 1003;
        }
        i3 = this.cGN.cGJ;
        i4 = this.cGN.cGI;
        if (i3 >= i4) {
            i8 = BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE;
        }
        aVar7 = this.cGN.cGL;
        if (aVar7 != null) {
            aVar8 = this.cGN.cGL;
            i5 = this.cGN.cGI;
            list2 = this.cGN.cGK;
            i6 = this.cGN.cGI;
            i7 = this.cGN.cGJ;
            aVar8.a(i5, list2, i8, i6 - i7);
        }
    }
}
