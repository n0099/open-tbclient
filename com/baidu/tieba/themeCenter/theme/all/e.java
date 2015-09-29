package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dgh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dgh = dVar;
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
                    list = this.dgh.dgb;
                    if (list == null) {
                        this.dgh.dgb = new ArrayList();
                        list8 = this.dgh.dgb;
                        bVar3 = this.dgh.dgc;
                        list8.add(bVar3);
                        list9 = this.dgh.dgb;
                        bVar4 = this.dgh.dgd;
                        list9.add(bVar4);
                    }
                    i = this.dgh.MG;
                    if (i == 1) {
                        list5 = this.dgh.dgb;
                        list5.clear();
                        list6 = this.dgh.dgb;
                        bVar = this.dgh.dgc;
                        list6.add(bVar);
                        list7 = this.dgh.dgb;
                        bVar2 = this.dgh.dgd;
                        list7.add(bVar2);
                    }
                    if (responsedMessage instanceof AllThemeListSocketResponsedMessage) {
                        AllThemeListSocketResponsedMessage allThemeListSocketResponsedMessage = (AllThemeListSocketResponsedMessage) responsedMessage;
                        if (allThemeListSocketResponsedMessage.getThemeList() != null) {
                            list4 = this.dgh.dgb;
                            list4.addAll(allThemeListSocketResponsedMessage.getThemeList());
                        }
                        this.dgh.mRecommand = allThemeListSocketResponsedMessage.getRecommand();
                        this.dgh.hasMore = allThemeListSocketResponsedMessage.hasMore();
                    } else if (responsedMessage instanceof AllThemeListHttpResponsedMessage) {
                        AllThemeListHttpResponsedMessage allThemeListHttpResponsedMessage = (AllThemeListHttpResponsedMessage) responsedMessage;
                        if (allThemeListHttpResponsedMessage.getThemeList() != null) {
                            list2 = this.dgh.dgb;
                            list2.addAll(allThemeListHttpResponsedMessage.getThemeList());
                        }
                        this.dgh.mRecommand = allThemeListHttpResponsedMessage.getRecommand();
                        this.dgh.hasMore = allThemeListHttpResponsedMessage.hasMore();
                    }
                    aVar = this.dgh.dge;
                    if (aVar == null) {
                        return;
                    }
                    this.dgh.azs();
                    aVar2 = this.dgh.dge;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dgh.mRecommand;
                    list3 = this.dgh.mThemeList;
                    aVar2.a(error, errorString, kVar, list3);
                    return;
                }
                d dVar = this.dgh;
                i2 = dVar.MG;
                dVar.MG = i2 - 1;
                aVar3 = this.dgh.dge;
                if (aVar3 == null) {
                    return;
                }
                this.dgh.azs();
                aVar4 = this.dgh.dge;
                int error2 = responsedMessage.getError();
                String errorString2 = responsedMessage.getErrorString();
                kVar2 = this.dgh.mRecommand;
                list10 = this.dgh.mThemeList;
                aVar4.a(error2, errorString2, kVar2, list10);
            }
        }
    }
}
