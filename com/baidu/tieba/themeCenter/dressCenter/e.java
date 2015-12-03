package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dFZ = dVar;
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
                    aVar3 = this.dFZ.dFY;
                    if (aVar3 != null) {
                        aVar4 = this.dFZ.dFY;
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        list3 = this.dFZ.mThemeCarouselList;
                        kVar2 = this.dFZ.mRecommand;
                        list4 = this.dFZ.mThemeList;
                        aVar4.a(error, errorString, list3, kVar2, list4);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof DressupCenterHttpResponseMessage) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    this.dFZ.mThemeList = dressupCenterHttpResponseMessage.getThemeList();
                    this.dFZ.mRecommand = dressupCenterHttpResponseMessage.getRecommand();
                    this.dFZ.mThemeCarouselList = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    this.dFZ.mThemeList = dressupCenterSocketResponseMessage.getThemeList();
                    this.dFZ.mRecommand = dressupCenterSocketResponseMessage.getRecommand();
                    this.dFZ.mThemeCarouselList = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                aVar = this.dFZ.dFY;
                if (aVar != null) {
                    aVar2 = this.dFZ.dFY;
                    int error2 = responsedMessage.getError();
                    String errorString2 = responsedMessage.getErrorString();
                    list = this.dFZ.mThemeCarouselList;
                    kVar = this.dFZ.mRecommand;
                    list2 = this.dFZ.mThemeList;
                    aVar2.a(error2, errorString2, list, kVar, list2);
                }
            }
        }
    }
}
