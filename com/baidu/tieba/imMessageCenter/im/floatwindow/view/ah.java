package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ar {
    final /* synthetic */ FloatingPersonalChatView bsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.bsm = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.ar
    public void Vv() {
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
        list = this.bsm.mUserDataList;
        if (list != null) {
            i = this.bsm.currentIndex;
            list2 = this.bsm.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bsm.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bsm.mUserDataList;
                    i3 = this.bsm.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.bsm.bsj;
                    apVar = this.bsm.bsk;
                    list4 = this.bsm.mUserDataList;
                    i4 = this.bsm.currentIndex;
                    nVar.gz(apVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
