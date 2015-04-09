package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.bPV = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        af afVar;
        boolean z;
        af afVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.bPV.bDX = ((Integer) view.getTag()).intValue();
        i = this.bPV.bDX;
        if (i >= 0) {
            i2 = this.bPV.bDX;
            afVar = this.bPV.bPJ;
            if (i2 < afVar.getCount()) {
                z = this.bPV.bPP;
                if (!z) {
                    v vVar = this.bPV;
                    afVar2 = this.bPV.bPJ;
                    i3 = this.bPV.bDX;
                    vVar.bPO = (ForumData) afVar2.getItem(i3);
                    forumData = this.bPV.bPO;
                    if (forumData != null) {
                        forumData2 = this.bPV.bPO;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bPV.bPO;
                            if (forumData3.getName() != null) {
                                v vVar2 = this.bPV;
                                forumData4 = this.bPV.bPO;
                                vVar2.bPK = forumData4.getName();
                                this.bPV.bPP = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bPV.bPO;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bPV.bPK;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bPV.bPO;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.bPV.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
