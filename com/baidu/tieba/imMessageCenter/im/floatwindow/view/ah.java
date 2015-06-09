package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ar {
    final /* synthetic */ FloatingPersonalChatView buZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.buZ = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.ar
    public void WO() {
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
        list = this.buZ.mUserDataList;
        if (list != null) {
            i = this.buZ.currentIndex;
            list2 = this.buZ.mUserDataList;
            if (i < list2.size()) {
                i2 = this.buZ.currentIndex;
                if (i2 >= 0) {
                    list3 = this.buZ.mUserDataList;
                    i3 = this.buZ.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.buZ.buW;
                    apVar = this.buZ.buX;
                    list4 = this.buZ.mUserDataList;
                    i4 = this.buZ.currentIndex;
                    nVar.gQ(apVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
