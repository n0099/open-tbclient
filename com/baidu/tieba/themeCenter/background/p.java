package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.o;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i, int i2) {
        super(i, i2);
        this.dMw = oVar;
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
                    o oVar = this.dMw;
                    i2 = oVar.Np;
                    oVar.Np = i2 - 1;
                } else {
                    if (responsedMessage instanceof BackgroundListHttpResponseMessage) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        this.dMw.mRecommand = backgroundListHttpResponseMessage.getRecommand();
                        this.dMw.mBackgroundList = backgroundListHttpResponseMessage.getBackgroundList();
                        this.dMw.hasMore = backgroundListHttpResponseMessage.hasMore();
                        this.dMw.dlU = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.dMw.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                        this.dMw.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                        this.dMw.hasMore = backgroundListSocketResponseMessage.hasMore();
                        this.dMw.dlU = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    list = this.dMw.dMq;
                    if (list == null) {
                        this.dMw.dMq = new ArrayList();
                        list7 = this.dMw.dMq;
                        dressItemData2 = this.dMw.dMr;
                        list7.add(dressItemData2);
                    }
                    i = this.dMw.Np;
                    if (i == 1) {
                        list5 = this.dMw.dMq;
                        list5.clear();
                        list6 = this.dMw.dMq;
                        dressItemData = this.dMw.dMr;
                        list6.add(dressItemData);
                    }
                    list2 = this.dMw.mBackgroundList;
                    if (list2 != null) {
                        list3 = this.dMw.dMq;
                        list4 = this.dMw.mBackgroundList;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dMw.dMs;
                if (aVar == null) {
                    return;
                }
                this.dMw.aHI();
                aVar2 = this.dMw.dMs;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dMw.mRecommand;
                list8 = this.dMw.dMq;
                aVar2.a(error, errorString, kVar, list8);
            }
        }
    }
}
