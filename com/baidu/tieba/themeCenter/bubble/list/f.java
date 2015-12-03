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
    final /* synthetic */ e dFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.dFQ = eVar;
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
                    e eVar = this.dFQ;
                    i2 = eVar.MZ;
                    eVar.MZ = i2 - 1;
                } else {
                    if (responsedMessage instanceof BubbleListHttpResponseMessage) {
                        BubbleListHttpResponseMessage bubbleListHttpResponseMessage = (BubbleListHttpResponseMessage) responsedMessage;
                        this.dFQ.mRecommand = bubbleListHttpResponseMessage.getRecommand();
                        this.dFQ.dFN = bubbleListHttpResponseMessage.getBubbleList();
                        this.dFQ.hasMore = bubbleListHttpResponseMessage.hasMore();
                        this.dFQ.isDefault = bubbleListHttpResponseMessage.isDefault();
                    } else if (responsedMessage instanceof BubbleListSocketResponseMessage) {
                        BubbleListSocketResponseMessage bubbleListSocketResponseMessage = (BubbleListSocketResponseMessage) responsedMessage;
                        this.dFQ.mRecommand = bubbleListSocketResponseMessage.getRecommand();
                        this.dFQ.dFN = bubbleListSocketResponseMessage.getBubbleList();
                        this.dFQ.hasMore = bubbleListSocketResponseMessage.hasMore();
                        this.dFQ.isDefault = bubbleListSocketResponseMessage.isDefault();
                    }
                    list = this.dFQ.dFO;
                    if (list == null) {
                        this.dFQ.dFO = new ArrayList();
                    }
                    i = this.dFQ.MZ;
                    if (i == 1) {
                        list5 = this.dFQ.dFO;
                        list5.clear();
                        DressItemData dressItemData = new DressItemData();
                        dressItemData.setPropsId(0);
                        z = this.dFQ.isDefault;
                        dressItemData.setInUse(z);
                        list6 = this.dFQ.dFO;
                        list6.add(dressItemData);
                    }
                    list2 = this.dFQ.dFN;
                    if (list2 != null) {
                        list3 = this.dFQ.dFO;
                        list4 = this.dFQ.dFN;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dFQ.dFP;
                if (aVar != null) {
                    aVar2 = this.dFQ.dFP;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dFQ.mRecommand;
                    list7 = this.dFQ.dFO;
                    aVar2.a(error, errorString, kVar, list7);
                }
            }
        }
    }
}
