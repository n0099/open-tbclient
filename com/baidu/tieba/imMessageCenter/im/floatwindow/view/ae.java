package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView drG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.drG = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void ayH() {
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
        list = this.drG.mUserDataList;
        if (list != null) {
            i = this.drG.currentIndex;
            list2 = this.drG.mUserDataList;
            if (i < list2.size()) {
                i2 = this.drG.currentIndex;
                if (i2 >= 0) {
                    list3 = this.drG.mUserDataList;
                    i3 = this.drG.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.drG.drD;
                    ajVar = this.drG.drE;
                    list4 = this.drG.mUserDataList;
                    i4 = this.drG.currentIndex;
                    lVar.ml(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
