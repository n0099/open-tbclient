package com.baidu.tieba.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.au;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.a = eVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void a(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        long j2;
        int i;
        ArrayList arrayList;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        au auVar;
        com.baidu.tieba.b.a aVar3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        String str = null;
        bdUniqueId = this.a.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.a.k = false;
            int i2 = -1;
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                int downSize = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                j = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.a.a(subPbHttpResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
                i2 = downSize;
                z = true;
            } else {
                j = 0;
                z = false;
            }
            if (responsedMessage instanceof SubPbSocketResponseMessage) {
                int downSize2 = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                j2 = responsedMessage.getCostTime();
                SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                if (subPbSocketResponseMessage.isTreatDelPage()) {
                    if (!subPbSocketResponseMessage.hasError()) {
                        this.a.a(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
                i = downSize2;
            } else {
                j2 = 0;
                i = i2;
            }
            arrayList = this.a.j;
            if (arrayList != null) {
                arrayList2 = this.a.j;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.a.j;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.a.j;
                            this.a.f.b((au) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.a.j;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.a.l;
            if (aVar == null) {
                this.a.l = new com.baidu.tieba.b.a("pbfloorStat");
            }
            aVar2 = this.a.l;
            if (aVar2 != null) {
                boolean z2 = error == 0;
                aVar3 = this.a.l;
                aVar3.a(z, z2, error, errorString, i, j, j2);
                this.a.l = new com.baidu.tieba.b.a("pbfloorStat");
            }
            if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                if (this.a.g != null) {
                    this.a.g.a(false, error, errorString, null);
                }
            } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    auVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else {
                    auVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                }
                if (auVar.a().errorno.intValue() != 0) {
                    if (this.a.g != null) {
                        this.a.g.a(false, auVar.a.errorno.intValue(), auVar.a.errmsg, null);
                        return;
                    }
                    return;
                }
                if (auVar.n() != null && auVar.n().q() != null) {
                    str = auVar.n().q().getUserId();
                }
                for (int i3 = 0; i3 < auVar.d().size(); i3++) {
                    auVar.d().get(i3).a(this.a.e, str.equals(auVar.d().get(i3).g().getUserId()));
                }
                if (auVar.b() != null) {
                    this.a.c = auVar.b().d();
                }
                if (auVar.n() != null) {
                    this.a.b = auVar.n().h();
                }
                if (this.a.a == 1) {
                    this.a.f = auVar;
                } else if (this.a.a == 2) {
                    this.a.f.b(auVar, true);
                } else if (this.a.a == 3) {
                    this.a.f.a(auVar, false);
                } else {
                    this.a.f.b(auVar, false);
                }
                if (this.a.g != null) {
                    this.a.g.a(true, error, errorString, this.a.f);
                }
            }
        }
    }
}
