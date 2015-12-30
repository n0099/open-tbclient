package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aj.a {
    final /* synthetic */ FloatingPersonalChatView cgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.cgl = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj.a
    public void adK() {
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
        list = this.cgl.mUserDataList;
        if (list != null) {
            i = this.cgl.currentIndex;
            list2 = this.cgl.mUserDataList;
            if (i < list2.size()) {
                i2 = this.cgl.currentIndex;
                if (i2 >= 0) {
                    list3 = this.cgl.mUserDataList;
                    i3 = this.cgl.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    lVar = this.cgl.cgi;
                    ajVar = this.cgl.cgj;
                    list4 = this.cgl.mUserDataList;
                    i4 = this.cgl.currentIndex;
                    lVar.jk(ajVar.c((UserData) list4.get(i4)));
                }
            }
        }
    }
}
