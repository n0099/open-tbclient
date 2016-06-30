package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView dbE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.dbE = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void asJ() {
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
        list = this.dbE.mUserDataList;
        if (list != null) {
            i = this.dbE.currentIndex;
            list2 = this.dbE.mUserDataList;
            if (i < list2.size()) {
                i2 = this.dbE.currentIndex;
                if (i2 >= 0) {
                    list3 = this.dbE.mUserDataList;
                    i3 = this.dbE.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.dbE.dbB;
                    ajVar = this.dbE.dbC;
                    list4 = this.dbE.mUserDataList;
                    i4 = this.dbE.currentIndex;
                    lVar.lu(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
