package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.o;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i, int i2) {
        super(i, i2);
        this.dho = oVar;
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
                    o oVar = this.dho;
                    i2 = oVar.MI;
                    oVar.MI = i2 - 1;
                } else {
                    if (responsedMessage instanceof BackgroundListHttpResponseMessage) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        this.dho.mRecommand = backgroundListHttpResponseMessage.getRecommand();
                        this.dho.mBackgroundList = backgroundListHttpResponseMessage.getBackgroundList();
                        this.dho.hasMore = backgroundListHttpResponseMessage.hasMore();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.dho.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                        this.dho.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                        this.dho.hasMore = backgroundListSocketResponseMessage.hasMore();
                    }
                    list = this.dho.dhk;
                    if (list == null) {
                        this.dho.dhk = new ArrayList();
                    }
                    i = this.dho.MI;
                    if (i == 1) {
                        list5 = this.dho.dhk;
                        list5.clear();
                    }
                    list2 = this.dho.mBackgroundList;
                    if (list2 != null) {
                        list3 = this.dho.dhk;
                        list4 = this.dho.mBackgroundList;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dho.dhl;
                if (aVar != null) {
                    aVar2 = this.dho.dhl;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dho.mRecommand;
                    list6 = this.dho.dhk;
                    aVar2.a(error, errorString, kVar, list6);
                }
            }
        }
    }
}
