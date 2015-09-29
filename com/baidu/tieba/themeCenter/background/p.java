package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.o;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i, int i2) {
        super(i, i2);
        this.dfi = oVar;
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
                    o oVar = this.dfi;
                    i2 = oVar.MG;
                    oVar.MG = i2 - 1;
                } else {
                    if (responsedMessage instanceof BackgroundListHttpResponseMessage) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        this.dfi.mRecommand = backgroundListHttpResponseMessage.getRecommand();
                        this.dfi.mBackgroundList = backgroundListHttpResponseMessage.getBackgroundList();
                        this.dfi.hasMore = backgroundListHttpResponseMessage.hasMore();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.dfi.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                        this.dfi.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                        this.dfi.hasMore = backgroundListSocketResponseMessage.hasMore();
                    }
                    list = this.dfi.dfe;
                    if (list == null) {
                        this.dfi.dfe = new ArrayList();
                    }
                    i = this.dfi.MG;
                    if (i == 1) {
                        list5 = this.dfi.dfe;
                        list5.clear();
                    }
                    list2 = this.dfi.mBackgroundList;
                    if (list2 != null) {
                        list3 = this.dfi.dfe;
                        list4 = this.dfi.mBackgroundList;
                        list3.addAll(list4);
                    }
                }
                aVar = this.dfi.dff;
                if (aVar != null) {
                    aVar2 = this.dfi.dff;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dfi.mRecommand;
                    list6 = this.dfi.dfe;
                    aVar2.a(error, errorString, kVar, list6);
                }
            }
        }
    }
}
