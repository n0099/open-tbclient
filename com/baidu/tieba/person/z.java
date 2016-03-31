package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.dst = sVar;
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
        this.dst.cYb = ((Integer) view.getTag()).intValue();
        i = this.dst.cYb;
        if (i >= 0) {
            i2 = this.dst.cYb;
            adVar = this.dst.dsd;
            if (i2 < adVar.getCount()) {
                z = this.dst.dsi;
                if (!z) {
                    s sVar = this.dst;
                    adVar2 = this.dst.dsd;
                    i3 = this.dst.cYb;
                    sVar.dsh = (ForumData) adVar2.getItem(i3);
                    forumData = this.dst.dsh;
                    if (forumData != null) {
                        forumData2 = this.dst.dsh;
                        if (forumData2.getId() != null) {
                            forumData3 = this.dst.dsh;
                            if (forumData3.getName() != null) {
                                s sVar2 = this.dst;
                                forumData4 = this.dst.dsh;
                                sVar2.dse = forumData4.getName();
                                this.dst.dsi = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.dst.dsh;
                                httpMessage.addParam("fid", forumData5.getId());
                                str = this.dst.dse;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.dst.dsh;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.dst.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
