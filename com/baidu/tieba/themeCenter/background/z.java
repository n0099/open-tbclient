package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ y dhG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, int i, int i2) {
        super(i, i2);
        this.dhG = yVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        y.a aVar;
        DressItemData dressItemData;
        y.a aVar2;
        DressItemData dressItemData2;
        DressItemData dressItemData3;
        int i;
        DressItemData dressItemData4;
        int i2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundGetHttpResponseMessage) || (responsedMessage instanceof BackgroundGetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof BackgroundGetHttpResponseMessage) {
                        this.dhG.mBgItem = ((BackgroundGetHttpResponseMessage) responsedMessage).getBgItem();
                    } else if (responsedMessage instanceof BackgroundGetSocketResponseMessage) {
                        this.dhG.mBgItem = ((BackgroundGetSocketResponseMessage) responsedMessage).getBgItem();
                    }
                }
                aVar = this.dhG.dhF;
                if (aVar != null) {
                    dressItemData = this.dhG.mBgItem;
                    if (dressItemData != null) {
                        dressItemData3 = this.dhG.mBgItem;
                        i = this.dhG.dgZ;
                        dressItemData3.setPropsId(i);
                        dressItemData4 = this.dhG.mBgItem;
                        i2 = this.dhG.dhs;
                        dressItemData4.setInUse(i2 == 1);
                    }
                    aVar2 = this.dhG.dhF;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    dressItemData2 = this.dhG.mBgItem;
                    aVar2.a(error, errorString, dressItemData2);
                }
            }
        }
    }
}
