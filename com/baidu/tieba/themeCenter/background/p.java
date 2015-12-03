package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.o;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i, int i2) {
        super(i, i2);
        this.dET = oVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        List list;
        int i;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        DressItemData dressItemData;
        List list7;
        DressItemData dressItemData2;
        o.a aVar;
        o.a aVar2;
        com.baidu.tieba.themeCenter.dressCenter.k kVar;
        List<DressItemData> list8;
        int i2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundListHttpResponseMessage) || (responsedMessage instanceof BackgroundListSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    o oVar = this.dET;
                    i2 = oVar.MZ;
                    oVar.MZ = i2 - 1;
                } else {
                    if (responsedMessage instanceof BackgroundListHttpResponseMessage) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        this.dET.mRecommand = backgroundListHttpResponseMessage.getRecommand();
                        this.dET.mBackgroundList = backgroundListHttpResponseMessage.getBackgroundList();
                        this.dET.hasMore = backgroundListHttpResponseMessage.hasMore();
                        this.dET.dgo = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.dET.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                        this.dET.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                        this.dET.hasMore = backgroundListSocketResponseMessage.hasMore();
                        this.dET.dgo = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    list = this.dET.dEN;
                    if (list == null) {
                        this.dET.dEN = new ArrayList();
                        list7 = this.dET.dEN;
                        dressItemData2 = this.dET.dEO;
                        list7.add(dressItemData2);
                    }
                    i = this.dET.MZ;
                    if (i == 1) {
                        list5 = this.dET.dEN;
                        list5.clear();
                        list6 = this.dET.dEN;
                        dressItemData = this.dET.dEO;
                        list6.add(dressItemData);
                    }
                    list2 = this.dET.mBackgroundList;
                    if (list2 != null) {
                        list3 = this.dET.dEN;
                        list4 = this.dET.mBackgroundList;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dET.dEP;
                if (aVar == null) {
                    return;
                }
                this.dET.aFt();
                aVar2 = this.dET.dEP;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dET.mRecommand;
                list8 = this.dET.dEN;
                aVar2.a(error, errorString, kVar, list8);
            }
        }
    }
}
