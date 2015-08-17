package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView bIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.bIP = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void Yu() {
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
        list = this.bIP.mUserDataList;
        if (list != null) {
            i = this.bIP.currentIndex;
            list2 = this.bIP.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bIP.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bIP.mUserDataList;
                    i3 = this.bIP.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.bIP.bIM;
                    ajVar = this.bIP.bIN;
                    list4 = this.bIP.mUserDataList;
                    i4 = this.bIP.currentIndex;
                    lVar.hu(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
