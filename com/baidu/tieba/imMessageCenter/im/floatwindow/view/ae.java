package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView bMB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.bMB = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void Ze() {
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
        list = this.bMB.mUserDataList;
        if (list != null) {
            i = this.bMB.currentIndex;
            list2 = this.bMB.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bMB.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bMB.mUserDataList;
                    i3 = this.bMB.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.bMB.bMy;
                    ajVar = this.bMB.bMz;
                    list4 = this.bMB.mUserDataList;
                    i4 = this.bMB.currentIndex;
                    lVar.hK(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
