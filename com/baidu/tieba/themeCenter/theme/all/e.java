package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dgH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dgH = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        List list;
        int i;
        List list2;
        d.a aVar;
        d.a aVar2;
        k kVar;
        List<com.baidu.tieba.themeCenter.theme.top.a> list3;
        List list4;
        List list5;
        List list6;
        com.baidu.tieba.themeCenter.b bVar;
        List list7;
        com.baidu.tieba.themeCenter.b bVar2;
        List list8;
        com.baidu.tieba.themeCenter.b bVar3;
        List list9;
        com.baidu.tieba.themeCenter.b bVar4;
        int i2;
        d.a aVar3;
        d.a aVar4;
        k kVar2;
        List<com.baidu.tieba.themeCenter.theme.top.a> list10;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof AllThemeListSocketResponsedMessage) || (responsedMessage instanceof AllThemeListHttpResponsedMessage)) {
                if (responsedMessage.getError() == 0) {
                    list = this.dgH.dgB;
                    if (list == null) {
                        this.dgH.dgB = new ArrayList();
                        list8 = this.dgH.dgB;
                        bVar3 = this.dgH.dgC;
                        list8.add(bVar3);
                        list9 = this.dgH.dgB;
                        bVar4 = this.dgH.dgD;
                        list9.add(bVar4);
                    }
                    i = this.dgH.MH;
                    if (i == 1) {
                        list5 = this.dgH.dgB;
                        list5.clear();
                        list6 = this.dgH.dgB;
                        bVar = this.dgH.dgC;
                        list6.add(bVar);
                        list7 = this.dgH.dgB;
                        bVar2 = this.dgH.dgD;
                        list7.add(bVar2);
                    }
                    if (responsedMessage instanceof AllThemeListSocketResponsedMessage) {
                        AllThemeListSocketResponsedMessage allThemeListSocketResponsedMessage = (AllThemeListSocketResponsedMessage) responsedMessage;
                        if (allThemeListSocketResponsedMessage.getThemeList() != null) {
                            list4 = this.dgH.dgB;
                            list4.addAll(allThemeListSocketResponsedMessage.getThemeList());
                        }
                        this.dgH.mRecommand = allThemeListSocketResponsedMessage.getRecommand();
                        this.dgH.hasMore = allThemeListSocketResponsedMessage.hasMore();
                    } else if (responsedMessage instanceof AllThemeListHttpResponsedMessage) {
                        AllThemeListHttpResponsedMessage allThemeListHttpResponsedMessage = (AllThemeListHttpResponsedMessage) responsedMessage;
                        if (allThemeListHttpResponsedMessage.getThemeList() != null) {
                            list2 = this.dgH.dgB;
                            list2.addAll(allThemeListHttpResponsedMessage.getThemeList());
                        }
                        this.dgH.mRecommand = allThemeListHttpResponsedMessage.getRecommand();
                        this.dgH.hasMore = allThemeListHttpResponsedMessage.hasMore();
                    }
                    aVar = this.dgH.dgE;
                    if (aVar == null) {
                        return;
                    }
                    this.dgH.azC();
                    aVar2 = this.dgH.dgE;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dgH.mRecommand;
                    list3 = this.dgH.mThemeList;
                    aVar2.a(error, errorString, kVar, list3);
                    return;
                }
                d dVar = this.dgH;
                i2 = dVar.MH;
                dVar.MH = i2 - 1;
                aVar3 = this.dgH.dgE;
                if (aVar3 == null) {
                    return;
                }
                this.dgH.azC();
                aVar4 = this.dgH.dgE;
                int error2 = responsedMessage.getError();
                String errorString2 = responsedMessage.getErrorString();
                kVar2 = this.dgH.mRecommand;
                list10 = this.dgH.mThemeList;
                aVar4.a(error2, errorString2, kVar2, list10);
            }
        }
    }
}
