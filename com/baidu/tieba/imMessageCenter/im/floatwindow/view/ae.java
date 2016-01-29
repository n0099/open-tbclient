package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView ckL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.ckL = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void agT() {
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
        list = this.ckL.mUserDataList;
        if (list != null) {
            i = this.ckL.currentIndex;
            list2 = this.ckL.mUserDataList;
            if (i < list2.size()) {
                i2 = this.ckL.currentIndex;
                if (i2 >= 0) {
                    list3 = this.ckL.mUserDataList;
                    i3 = this.ckL.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.ckL.ckI;
                    ajVar = this.ckL.ckJ;
                    list4 = this.ckL.mUserDataList;
                    i4 = this.ckL.currentIndex;
                    lVar.jI(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
