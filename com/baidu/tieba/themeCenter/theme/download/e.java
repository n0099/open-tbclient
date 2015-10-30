package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dhp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dhp = dVar;
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
                    this.dhp.mUpdateList = ((SkinUpdateSocketResponsedMessage) responsedMessage).getUpdateList();
                } else if (responsedMessage instanceof SkinUpdateHttpResponsedMessage) {
                    this.dhp.mUpdateList = ((SkinUpdateHttpResponsedMessage) responsedMessage).getUpdateList();
                }
                arrayList = this.dhp.dhm;
                if (arrayList != null) {
                    arrayList2 = this.dhp.dhm;
                    if (arrayList2.size() <= 2) {
                        return;
                    }
                    this.dhp.azy();
                    aVar = this.dhp.dhn;
                    if (aVar != null) {
                        aVar2 = this.dhp.dhn;
                        z = this.dhp.dho;
                        list = this.dhp.mThemeList;
                        aVar2.a(z, list);
                    }
                }
            }
        }
    }
}
