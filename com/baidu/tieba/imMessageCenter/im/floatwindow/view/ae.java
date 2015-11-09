package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView bNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.bNh = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void Zv() {
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
        list = this.bNh.mUserDataList;
        if (list != null) {
            i = this.bNh.currentIndex;
            list2 = this.bNh.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bNh.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bNh.mUserDataList;
                    i3 = this.bNh.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.bNh.bNe;
                    ajVar = this.bNh.bNf;
                    list4 = this.bNh.mUserDataList;
                    i4 = this.bNh.currentIndex;
                    lVar.hX(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
