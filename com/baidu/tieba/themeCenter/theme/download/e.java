package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dgP = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        d.a aVar;
        d.a aVar2;
        boolean z;
        List<com.baidu.tieba.themeCenter.theme.top.a> list;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof SkinUpdateHttpResponsedMessage) || (responsedMessage instanceof SkinUpdateSocketResponsedMessage)) {
                if (responsedMessage instanceof SkinUpdateSocketResponsedMessage) {
                    this.dgP.mUpdateList = ((SkinUpdateSocketResponsedMessage) responsedMessage).getUpdateList();
                } else if (responsedMessage instanceof SkinUpdateHttpResponsedMessage) {
                    this.dgP.mUpdateList = ((SkinUpdateHttpResponsedMessage) responsedMessage).getUpdateList();
                }
                arrayList = this.dgP.dgM;
                if (arrayList != null) {
                    arrayList2 = this.dgP.dgM;
                    if (arrayList2.size() <= 2) {
                        return;
                    }
                    this.dgP.azs();
                    aVar = this.dgP.dgN;
                    if (aVar != null) {
                        aVar2 = this.dgP.dgN;
                        z = this.dgP.dgO;
                        list = this.dgP.mThemeList;
                        aVar2.a(z, list);
                    }
                }
            }
        }
    }
}
