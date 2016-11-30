package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView dxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.dxn = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void aAE() {
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
        list = this.dxn.mUserDataList;
        if (list != null) {
            i = this.dxn.currentIndex;
            list2 = this.dxn.mUserDataList;
            if (i < list2.size()) {
                i2 = this.dxn.currentIndex;
                if (i2 >= 0) {
                    list3 = this.dxn.mUserDataList;
                    i3 = this.dxn.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.dxn.dxk;
                    ajVar = this.dxn.dxl;
                    list4 = this.dxn.mUserDataList;
                    i4 = this.dxn.currentIndex;
                    lVar.mt(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
