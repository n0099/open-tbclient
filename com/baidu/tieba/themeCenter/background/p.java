package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.o;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dfI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i, int i2) {
        super(i, i2);
        this.dfI = oVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        List list;
        int i;
        List list2;
        List list3;
        List list4;
        List list5;
        o.a aVar;
        o.a aVar2;
        com.baidu.tieba.themeCenter.dressCenter.k kVar;
        List<DressItemData> list6;
        int i2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundListHttpResponseMessage) || (responsedMessage instanceof BackgroundListSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    o oVar = this.dfI;
                    i2 = oVar.MH;
                    oVar.MH = i2 - 1;
                } else {
                    if (responsedMessage instanceof BackgroundListHttpResponseMessage) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        this.dfI.mRecommand = backgroundListHttpResponseMessage.getRecommand();
                        this.dfI.mBackgroundList = backgroundListHttpResponseMessage.getBackgroundList();
                        this.dfI.hasMore = backgroundListHttpResponseMessage.hasMore();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.dfI.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                        this.dfI.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                        this.dfI.hasMore = backgroundListSocketResponseMessage.hasMore();
                    }
                    list = this.dfI.dfE;
                    if (list == null) {
                        this.dfI.dfE = new ArrayList();
                    }
                    i = this.dfI.MH;
                    if (i == 1) {
                        list5 = this.dfI.dfE;
                        list5.clear();
                    }
                    list2 = this.dfI.mBackgroundList;
                    if (list2 != null) {
                        list3 = this.dfI.dfE;
                        list4 = this.dfI.mBackgroundList;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dfI.dfF;
                if (aVar != null) {
                    aVar2 = this.dfI.dfF;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dfI.mRecommand;
                    list6 = this.dfI.dfE;
                    aVar2.a(error, errorString, kVar, list6);
                }
            }
        }
    }
}
