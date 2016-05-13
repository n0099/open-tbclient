package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.cwo = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void akv() {
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
        list = this.cwo.mUserDataList;
        if (list != null) {
            i = this.cwo.currentIndex;
            list2 = this.cwo.mUserDataList;
            if (i < list2.size()) {
                i2 = this.cwo.currentIndex;
                if (i2 >= 0) {
                    list3 = this.cwo.mUserDataList;
                    i3 = this.cwo.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.cwo.cwl;
                    ajVar = this.cwo.cwm;
                    list4 = this.cwo.mUserDataList;
                    i4 = this.cwo.currentIndex;
                    lVar.jS(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
