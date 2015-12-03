package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView ccl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.ccl = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void acB() {
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
        list = this.ccl.mUserDataList;
        if (list != null) {
            i = this.ccl.currentIndex;
            list2 = this.ccl.mUserDataList;
            if (i < list2.size()) {
                i2 = this.ccl.currentIndex;
                if (i2 >= 0) {
                    list3 = this.ccl.mUserDataList;
                    i3 = this.ccl.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.ccl.cci;
                    ajVar = this.ccl.ccj;
                    list4 = this.ccl.mUserDataList;
                    i4 = this.ccl.currentIndex;
                    lVar.iL(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
