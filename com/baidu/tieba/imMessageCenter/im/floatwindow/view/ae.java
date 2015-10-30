package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView bMM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.bMM = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void Za() {
        List list;
        int i;
        List list2;
        int i2;
        List list3;
        int i3;
        l lVar;
        aj ajVar;
        List list4;
        int i4;
        list = this.bMM.mUserDataList;
        if (list != null) {
            i = this.bMM.currentIndex;
            list2 = this.bMM.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bMM.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bMM.mUserDataList;
                    i3 = this.bMM.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.bMM.bMJ;
                    ajVar = this.bMM.bMK;
                    list4 = this.bMM.mUserDataList;
                    i4 = this.bMM.currentIndex;
                    lVar.hK(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
