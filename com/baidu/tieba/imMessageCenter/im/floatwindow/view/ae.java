package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.cvr = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void akn() {
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
        list = this.cvr.mUserDataList;
        if (list != null) {
            i = this.cvr.currentIndex;
            list2 = this.cvr.mUserDataList;
            if (i < list2.size()) {
                i2 = this.cvr.currentIndex;
                if (i2 >= 0) {
                    list3 = this.cvr.mUserDataList;
                    i3 = this.cvr.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.cvr.cvo;
                    ajVar = this.cvr.cvp;
                    list4 = this.cvr.mUserDataList;
                    i4 = this.cvr.currentIndex;
                    lVar.ko(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
