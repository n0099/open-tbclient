package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dNB = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        List<b> list;
        k kVar;
        List<j> list2;
        d.a aVar3;
        d.a aVar4;
        List<b> list3;
        k kVar2;
        List<j> list4;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof DressupCenterHttpResponseMessage) || (responsedMessage instanceof DressupCenterSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    aVar3 = this.dNB.dNA;
                    if (aVar3 != null) {
                        aVar4 = this.dNB.dNA;
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        list3 = this.dNB.mThemeCarouselList;
                        kVar2 = this.dNB.mRecommand;
                        list4 = this.dNB.mThemeList;
                        aVar4.a(error, errorString, list3, kVar2, list4);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof DressupCenterHttpResponseMessage) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    this.dNB.mThemeList = dressupCenterHttpResponseMessage.getThemeList();
                    this.dNB.mRecommand = dressupCenterHttpResponseMessage.getRecommand();
                    this.dNB.mThemeCarouselList = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    this.dNB.mThemeList = dressupCenterSocketResponseMessage.getThemeList();
                    this.dNB.mRecommand = dressupCenterSocketResponseMessage.getRecommand();
                    this.dNB.mThemeCarouselList = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                aVar = this.dNB.dNA;
                if (aVar != null) {
                    aVar2 = this.dNB.dNA;
                    int error2 = responsedMessage.getError();
                    String errorString2 = responsedMessage.getErrorString();
                    list = this.dNB.mThemeCarouselList;
                    kVar = this.dNB.mRecommand;
                    list2 = this.dNB.mThemeList;
                    aVar2.a(error2, errorString2, list, kVar, list2);
                }
            }
        }
    }
}
