package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.bPF = vVar;
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
        this.bPF.bDK = ((Integer) view.getTag()).intValue();
        i = this.bPF.bDK;
        if (i >= 0) {
            i2 = this.bPF.bDK;
            afVar = this.bPF.bPt;
            if (i2 < afVar.getCount()) {
                z = this.bPF.bPz;
                if (!z) {
                    v vVar = this.bPF;
                    afVar2 = this.bPF.bPt;
                    i3 = this.bPF.bDK;
                    vVar.bPy = (ForumData) afVar2.getItem(i3);
                    forumData = this.bPF.bPy;
                    if (forumData != null) {
                        forumData2 = this.bPF.bPy;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bPF.bPy;
                            if (forumData3.getName() != null) {
                                v vVar2 = this.bPF;
                                forumData4 = this.bPF.bPy;
                                vVar2.bPu = forumData4.getName();
                                this.bPF.bPz = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bPF.bPy;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bPF.bPu;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bPF.bPy;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.bPF.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
