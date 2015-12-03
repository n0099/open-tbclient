package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dGx = dVar;
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
                    list = this.dGx.dGq;
                    if (list == null) {
                        this.dGx.dGq = new ArrayList();
                        list8 = this.dGx.dGq;
                        bVar3 = this.dGx.dGr;
                        list8.add(bVar3);
                        list9 = this.dGx.dGq;
                        bVar4 = this.dGx.dGs;
                        list9.add(bVar4);
                    }
                    i = this.dGx.MZ;
                    if (i == 1) {
                        list5 = this.dGx.dGq;
                        list5.clear();
                        list6 = this.dGx.dGq;
                        bVar = this.dGx.dGr;
                        list6.add(bVar);
                        list7 = this.dGx.dGq;
                        bVar2 = this.dGx.dGs;
                        list7.add(bVar2);
                    }
                    if (responsedMessage instanceof AllThemeListSocketResponsedMessage) {
                        AllThemeListSocketResponsedMessage allThemeListSocketResponsedMessage = (AllThemeListSocketResponsedMessage) responsedMessage;
                        if (allThemeListSocketResponsedMessage.getThemeList() != null) {
                            list4 = this.dGx.dGq;
                            list4.addAll(allThemeListSocketResponsedMessage.getThemeList());
                        }
                        this.dGx.mRecommand = allThemeListSocketResponsedMessage.getRecommand();
                        this.dGx.hasMore = allThemeListSocketResponsedMessage.hasMore();
                    } else if (responsedMessage instanceof AllThemeListHttpResponsedMessage) {
                        AllThemeListHttpResponsedMessage allThemeListHttpResponsedMessage = (AllThemeListHttpResponsedMessage) responsedMessage;
                        if (allThemeListHttpResponsedMessage.getThemeList() != null) {
                            list2 = this.dGx.dGq;
                            list2.addAll(allThemeListHttpResponsedMessage.getThemeList());
                        }
                        this.dGx.mRecommand = allThemeListHttpResponsedMessage.getRecommand();
                        this.dGx.hasMore = allThemeListHttpResponsedMessage.hasMore();
                    }
                    aVar = this.dGx.dGt;
                    if (aVar == null) {
                        return;
                    }
                    this.dGx.aFy();
                    aVar2 = this.dGx.dGt;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    kVar = this.dGx.mRecommand;
                    list3 = this.dGx.mThemeList;
                    aVar2.a(error, errorString, kVar, list3);
                    return;
                }
                d dVar = this.dGx;
                i2 = dVar.MZ;
                dVar.MZ = i2 - 1;
                aVar3 = this.dGx.dGt;
                if (aVar3 == null) {
                    return;
                }
                this.dGx.aFy();
                aVar4 = this.dGx.dGt;
                int error2 = responsedMessage.getError();
                String errorString2 = responsedMessage.getErrorString();
                kVar2 = this.dGx.mRecommand;
                list10 = this.dGx.mThemeList;
                aVar4.a(error2, errorString2, kVar2, list10);
            }
        }
    }
}
