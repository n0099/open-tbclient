package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ar {
    final /* synthetic */ FloatingPersonalChatView brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.brW = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.ar
    public void Vi() {
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
        list = this.brW.mUserDataList;
        if (list != null) {
            i = this.brW.currentIndex;
            list2 = this.brW.mUserDataList;
            if (i < list2.size()) {
                i2 = this.brW.currentIndex;
                if (i2 >= 0) {
                    list3 = this.brW.mUserDataList;
                    i3 = this.brW.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.brW.brT;
                    apVar = this.brW.brU;
                    list4 = this.brW.mUserDataList;
                    i4 = this.brW.currentIndex;
                    nVar.gx(apVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
