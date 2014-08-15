package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ac acVar;
        boolean z;
        ac acVar2;
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
            acVar = this.a.c;
            if (i2 < acVar.getCount()) {
                z = this.a.l;
                if (!z) {
                    t tVar = this.a;
                    acVar2 = this.a.c;
                    i3 = this.a.d;
                    tVar.k = (ForumData) acVar2.getItem(i3);
                    forumData = this.a.k;
                    if (forumData != null) {
                        forumData2 = this.a.k;
                        if (forumData2.getId() != null) {
                            forumData3 = this.a.k;
                            if (forumData3.getName() != null) {
                                t tVar2 = this.a;
                                forumData4 = this.a.k;
                                tVar2.e = forumData4.getName();
                                this.a.l = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
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
