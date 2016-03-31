package com.baidu.tieba.pb.pb.praise;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tieba.pb.pb.praise.d;
import com.baidu.tieba.pb.pb.praise.grffitiList.ResponseHttpGraffitiMessage;
import com.baidu.tieba.pb.pb.praise.grffitiList.ResponseSocketGraffitiMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dof;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i, int i2) {
        super(i, i2);
        this.dof = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        List list;
        int i;
        int i2;
        int i3;
        int i4;
        d.a aVar3;
        d.a aVar4;
        int i5;
        List<a> list2;
        int i6;
        int i7;
        List list3;
        if (responsedMessage == null || ((!(responsedMessage instanceof ResponseHttpGraffitiMessage) && !(responsedMessage instanceof ResponseSocketGraffitiMessage)) || responsedMessage.hasError())) {
            aVar = this.dof.dod;
            if (aVar != null) {
                aVar2 = this.dof.dod;
                aVar2.bL(responsedMessage.getErrorString());
                return;
            }
            return;
        }
        List<a> list4 = null;
        if ((responsedMessage instanceof ResponseHttpGraffitiMessage) && ((ResponseHttpGraffitiMessage) responsedMessage).getItemDataList() != null) {
            list4 = ((ResponseHttpGraffitiMessage) responsedMessage).getItemDataList();
            this.dof.dnZ = ((ResponseHttpGraffitiMessage) responsedMessage).getmTotalNum();
        }
        if ((responsedMessage instanceof ResponseSocketGraffitiMessage) && ((ResponseSocketGraffitiMessage) responsedMessage).getItemDataList() != null) {
            list4 = ((ResponseSocketGraffitiMessage) responsedMessage).getItemDataList();
            this.dof.dnZ = ((ResponseSocketGraffitiMessage) responsedMessage).getmTotalNum();
        }
        if (list4 != null) {
            for (a aVar5 : list4) {
                list3 = this.dof.dob;
                list3.add(aVar5);
            }
        }
        d dVar = this.dof;
        list = this.dof.dob;
        dVar.doa = list.size();
        d dVar2 = this.dof;
        i = dVar2.dnY;
        dVar2.dnY = i + 1;
        int i8 = BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES;
        i2 = this.dof.dnY;
        if (i2 > 5) {
            i8 = 1003;
        }
        i3 = this.dof.doa;
        i4 = this.dof.dnZ;
        if (i3 >= i4) {
            i8 = BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE;
        }
        aVar3 = this.dof.dod;
        if (aVar3 != null) {
            aVar4 = this.dof.dod;
            i5 = this.dof.dnZ;
            list2 = this.dof.dob;
            i6 = this.dof.dnZ;
            i7 = this.dof.doa;
            aVar4.a(i5, list2, i8, i6 - i7);
        }
    }
}
