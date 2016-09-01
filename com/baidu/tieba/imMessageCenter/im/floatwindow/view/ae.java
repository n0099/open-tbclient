package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView dqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.dqj = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void ayj() {
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
        list = this.dqj.mUserDataList;
        if (list != null) {
            i = this.dqj.currentIndex;
            list2 = this.dqj.mUserDataList;
            if (i < list2.size()) {
                i2 = this.dqj.currentIndex;
                if (i2 >= 0) {
                    list3 = this.dqj.mUserDataList;
                    i3 = this.dqj.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.dqj.dqg;
                    ajVar = this.dqj.dqh;
                    list4 = this.dqj.mUserDataList;
                    i4 = this.dqj.currentIndex;
                    lVar.md(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
