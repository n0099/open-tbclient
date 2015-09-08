package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView bJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.bJw = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void Yw() {
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
        list = this.bJw.mUserDataList;
        if (list != null) {
            i = this.bJw.currentIndex;
            list2 = this.bJw.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bJw.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bJw.mUserDataList;
                    i3 = this.bJw.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.bJw.bJt;
                    ajVar = this.bJw.bJu;
                    list4 = this.bJw.mUserDataList;
                    i4 = this.bJw.currentIndex;
                    lVar.hE(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
