package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.bSc = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ag agVar;
        boolean z;
        ag agVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.bSc.bGT = ((Integer) view.getTag()).intValue();
        i = this.bSc.bGT;
        if (i >= 0) {
            i2 = this.bSc.bGT;
            agVar = this.bSc.bRN;
            if (i2 < agVar.getCount()) {
                z = this.bSc.bRS;
                if (!z) {
                    v vVar = this.bSc;
                    agVar2 = this.bSc.bRN;
                    i3 = this.bSc.bGT;
                    vVar.bRR = (ForumData) agVar2.getItem(i3);
                    forumData = this.bSc.bRR;
                    if (forumData != null) {
                        forumData2 = this.bSc.bRR;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bSc.bRR;
                            if (forumData3.getName() != null) {
                                v vVar2 = this.bSc;
                                forumData4 = this.bSc.bRR;
                                vVar2.bRO = forumData4.getName();
                                this.bSc.bRS = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bSc.bRR;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bSc.bRO;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bSc.bRR;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.bSc.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
