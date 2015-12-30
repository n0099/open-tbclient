package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.e;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e dNs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.dNs = eVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        List list;
        int i;
        List list2;
        List list3;
        List list4;
        List list5;
        boolean z;
        List list6;
        e.a aVar;
        e.a aVar2;
        k kVar;
        List<DressItemData> list7;
        int i2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BubbleListHttpResponseMessage) || (responsedMessage instanceof BubbleListSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    e eVar = this.dNs;
                    i2 = eVar.Np;
                    eVar.Np = i2 - 1;
                } else {
                    if (responsedMessage instanceof BubbleListHttpResponseMessage) {
                        BubbleListHttpResponseMessage bubbleListHttpResponseMessage = (BubbleListHttpResponseMessage) responsedMessage;
                        this.dNs.mRecommand = bubbleListHttpResponseMessage.getRecommand();
                        this.dNs.dNp = bubbleListHttpResponseMessage.getBubbleList();
                        this.dNs.hasMore = bubbleListHttpResponseMessage.hasMore();
                        this.dNs.isDefault = bubbleListHttpResponseMessage.isDefault();
                    } else if (responsedMessage instanceof BubbleListSocketResponseMessage) {
                        BubbleListSocketResponseMessage bubbleListSocketResponseMessage = (BubbleListSocketResponseMessage) responsedMessage;
                        this.dNs.mRecommand = bubbleListSocketResponseMessage.getRecommand();
                        this.dNs.dNp = bubbleListSocketResponseMessage.getBubbleList();
                        this.dNs.hasMore = bubbleListSocketResponseMessage.hasMore();
                        this.dNs.isDefault = bubbleListSocketResponseMessage.isDefault();
                    }
                    list = this.dNs.dNq;
                    if (list == null) {
                        this.dNs.dNq = new ArrayList();
                    }
                    i = this.dNs.Np;
                    if (i == 1) {
                        list5 = this.dNs.dNq;
                        list5.clear();
                        DressItemData dressItemData = new DressItemData();
                        dressItemData.setPropsId(0);
                        z = this.dNs.isDefault;
                        dressItemData.setInUse(z);
                        list6 = this.dNs.dNq;
                        list6.add(dressItemData);
                    }
                    list2 = this.dNs.dNp;
                    if (list2 != null) {
                        list3 = this.dNs.dNq;
                        list4 = this.dNs.dNp;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dNs.dNr;
                if (aVar != null) {
                    aVar2 = this.dNs.dNr;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dNs.mRecommand;
                    list7 = this.dNs.dNq;
                    aVar2.a(error, errorString, kVar, list7);
                }
            }
        }
    }
}
