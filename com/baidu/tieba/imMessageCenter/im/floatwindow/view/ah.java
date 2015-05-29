package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ar {
    final /* synthetic */ FloatingPersonalChatView buY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.buY = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.ar
    public void WN() {
        List list;
        int i;
        List list2;
        int i2;
        List list3;
        int i3;
        n nVar;
        ap apVar;
        List list4;
        int i4;
        list = this.buY.mUserDataList;
        if (list != null) {
            i = this.buY.currentIndex;
            list2 = this.buY.mUserDataList;
            if (i < list2.size()) {
                i2 = this.buY.currentIndex;
                if (i2 >= 0) {
                    list3 = this.buY.mUserDataList;
                    i3 = this.buY.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.buY.buV;
                    apVar = this.buY.buW;
                    list4 = this.buY.mUserDataList;
                    i4 = this.buY.currentIndex;
                    nVar.gQ(apVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
