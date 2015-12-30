package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dNY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dNY = dVar;
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
                    list = this.dNY.dNR;
                    if (list == null) {
                        this.dNY.dNR = new ArrayList();
                        list8 = this.dNY.dNR;
                        bVar3 = this.dNY.dNS;
                        list8.add(bVar3);
                        list9 = this.dNY.dNR;
                        bVar4 = this.dNY.dNT;
                        list9.add(bVar4);
                    }
                    i = this.dNY.Np;
                    if (i == 1) {
                        list5 = this.dNY.dNR;
                        list5.clear();
                        list6 = this.dNY.dNR;
                        bVar = this.dNY.dNS;
                        list6.add(bVar);
                        list7 = this.dNY.dNR;
                        bVar2 = this.dNY.dNT;
                        list7.add(bVar2);
                    }
                    if (responsedMessage instanceof AllThemeListSocketResponsedMessage) {
                        AllThemeListSocketResponsedMessage allThemeListSocketResponsedMessage = (AllThemeListSocketResponsedMessage) responsedMessage;
                        if (allThemeListSocketResponsedMessage.getThemeList() != null) {
                            list4 = this.dNY.dNR;
                            list4.addAll(allThemeListSocketResponsedMessage.getThemeList());
                        }
                        this.dNY.mRecommand = allThemeListSocketResponsedMessage.getRecommand();
                        this.dNY.hasMore = allThemeListSocketResponsedMessage.hasMore();
                    } else if (responsedMessage instanceof AllThemeListHttpResponsedMessage) {
                        AllThemeListHttpResponsedMessage allThemeListHttpResponsedMessage = (AllThemeListHttpResponsedMessage) responsedMessage;
                        if (allThemeListHttpResponsedMessage.getThemeList() != null) {
                            list2 = this.dNY.dNR;
                            list2.addAll(allThemeListHttpResponsedMessage.getThemeList());
                        }
                        this.dNY.mRecommand = allThemeListHttpResponsedMessage.getRecommand();
                        this.dNY.hasMore = allThemeListHttpResponsedMessage.hasMore();
                    }
                    aVar = this.dNY.dNU;
                    if (aVar == null) {
                        return;
                    }
                    this.dNY.aHN();
                    aVar2 = this.dNY.dNU;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dNY.mRecommand;
                    list3 = this.dNY.mThemeList;
                    aVar2.a(error, errorString, kVar, list3);
                    return;
                }
                d dVar = this.dNY;
                i2 = dVar.Np;
                dVar.Np = i2 - 1;
                aVar3 = this.dNY.dNU;
                if (aVar3 == null) {
                    return;
                }
                this.dNY.aHN();
                aVar4 = this.dNY.dNU;
                int error2 = responsedMessage.getError();
                String errorString2 = responsedMessage.getErrorString();
                kVar2 = this.dNY.mRecommand;
                list10 = this.dNY.mThemeList;
                aVar4.a(error2, errorString2, kVar2, list10);
            }
        }
    }
}
