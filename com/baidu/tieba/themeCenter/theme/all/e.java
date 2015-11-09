package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d din;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.din = dVar;
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
                    list = this.din.dih;
                    if (list == null) {
                        this.din.dih = new ArrayList();
                        list8 = this.din.dih;
                        bVar3 = this.din.dii;
                        list8.add(bVar3);
                        list9 = this.din.dih;
                        bVar4 = this.din.dij;
                        list9.add(bVar4);
                    }
                    i = this.din.MI;
                    if (i == 1) {
                        list5 = this.din.dih;
                        list5.clear();
                        list6 = this.din.dih;
                        bVar = this.din.dii;
                        list6.add(bVar);
                        list7 = this.din.dih;
                        bVar2 = this.din.dij;
                        list7.add(bVar2);
                    }
                    if (responsedMessage instanceof AllThemeListSocketResponsedMessage) {
                        AllThemeListSocketResponsedMessage allThemeListSocketResponsedMessage = (AllThemeListSocketResponsedMessage) responsedMessage;
                        if (allThemeListSocketResponsedMessage.getThemeList() != null) {
                            list4 = this.din.dih;
                            list4.addAll(allThemeListSocketResponsedMessage.getThemeList());
                        }
                        this.din.mRecommand = allThemeListSocketResponsedMessage.getRecommand();
                        this.din.hasMore = allThemeListSocketResponsedMessage.hasMore();
                    } else if (responsedMessage instanceof AllThemeListHttpResponsedMessage) {
                        AllThemeListHttpResponsedMessage allThemeListHttpResponsedMessage = (AllThemeListHttpResponsedMessage) responsedMessage;
                        if (allThemeListHttpResponsedMessage.getThemeList() != null) {
                            list2 = this.din.dih;
                            list2.addAll(allThemeListHttpResponsedMessage.getThemeList());
                        }
                        this.din.mRecommand = allThemeListHttpResponsedMessage.getRecommand();
                        this.din.hasMore = allThemeListHttpResponsedMessage.hasMore();
                    }
                    aVar = this.din.dik;
                    if (aVar == null) {
                        return;
                    }
                    this.din.aAo();
                    aVar2 = this.din.dik;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.din.mRecommand;
                    list3 = this.din.mThemeList;
                    aVar2.a(error, errorString, kVar, list3);
                    return;
                }
                d dVar = this.din;
                i2 = dVar.MI;
                dVar.MI = i2 - 1;
                aVar3 = this.din.dik;
                if (aVar3 == null) {
                    return;
                }
                this.din.aAo();
                aVar4 = this.din.dik;
                int error2 = responsedMessage.getError();
                String errorString2 = responsedMessage.getErrorString();
                kVar2 = this.din.mRecommand;
                list10 = this.din.mThemeList;
                aVar4.a(error2, errorString2, kVar2, list10);
            }
        }
    }
}
