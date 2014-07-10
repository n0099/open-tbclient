package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.a = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ad adVar;
        boolean z;
        ad adVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.a.d = ((Integer) view.getTag()).intValue();
        i = this.a.d;
        if (i >= 0) {
            i2 = this.a.d;
            adVar = this.a.c;
            if (i2 < adVar.getCount()) {
                z = this.a.l;
                if (!z) {
                    u uVar = this.a;
                    adVar2 = this.a.c;
                    i3 = this.a.d;
                    uVar.k = (ForumData) adVar2.getItem(i3);
                    forumData = this.a.k;
                    if (forumData != null) {
                        forumData2 = this.a.k;
                        if (forumData2.getId() != null) {
                            forumData3 = this.a.k;
                            if (forumData3.getName() != null) {
                                u uVar2 = this.a;
                                forumData4 = this.a.k;
                                uVar2.e = forumData4.getName();
                                this.a.l = true;
                                HttpMessage httpMessage = new HttpMessage(1002002);
                                forumData5 = this.a.k;
                                httpMessage.addParam("fid", forumData5.getId());
                                str = this.a.e;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.a.k;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkApplication.m252getInst().getTbs());
                                this.a.a(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
