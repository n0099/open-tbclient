package com.baidu.tieba.pb.pb.praise;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ d dof;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.dof = dVar;
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
            aVar = this.dof.dod;
            if (aVar != null) {
                aVar2 = this.dof.dod;
                aVar2.bL(null);
            }
        } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
            aVar3 = this.dof.dod;
            if (aVar3 != null) {
                aVar4 = this.dof.dod;
                aVar4.bL(null);
            }
        } else {
            PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
            if (praiseListResponsedMessage.getError() != 0) {
                aVar5 = this.dof.dod;
                if (aVar5 != null) {
                    aVar6 = this.dof.dod;
                    aVar6.bL(praiseListResponsedMessage.getErrMsg());
                    return;
                }
                return;
            }
            List<a> list4 = praiseListResponsedMessage.getmZanItemDataList();
            if (list4 != null) {
                for (a aVar9 : list4) {
                    list3 = this.dof.dob;
                    list3.add(aVar9);
                }
            }
            d dVar = this.dof;
            list = this.dof.dob;
            dVar.doa = list.size();
            this.dof.dnZ = praiseListResponsedMessage.getTotalNum();
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
            aVar7 = this.dof.dod;
            if (aVar7 != null) {
                aVar8 = this.dof.dod;
                i5 = this.dof.dnZ;
                list2 = this.dof.dob;
                i6 = this.dof.dnZ;
                i7 = this.dof.doa;
                aVar8.a(i5, list2, i8, i6 - i7);
            }
        }
    }
}
