package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView deC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.deC = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void atv() {
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
        list = this.deC.mUserDataList;
        if (list != null) {
            i = this.deC.currentIndex;
            list2 = this.deC.mUserDataList;
            if (i < list2.size()) {
                i2 = this.deC.currentIndex;
                if (i2 >= 0) {
                    list3 = this.deC.mUserDataList;
                    i3 = this.deC.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.deC.dez;
                    ajVar = this.deC.deA;
                    list4 = this.deC.mUserDataList;
                    i4 = this.deC.currentIndex;
                    lVar.lA(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
