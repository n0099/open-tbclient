package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s sVar, int i) {
        super(i);
        this.cXR = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        int i2;
        int i3;
        int i4;
        String str;
        ad adVar;
        ad adVar2;
        ad adVar3;
        ae aeVar3;
        this.cXR.cXG = false;
        if (httpResponsedMessage.getError() == 0) {
            aeVar = this.cXR.cXq;
            ArrayList<ForumData> atx = aeVar.atD().atx();
            aeVar2 = this.cXR.cXq;
            int atr = aeVar2.atD().atr();
            i = this.cXR.cEJ;
            if (i < atr) {
                aeVar3 = this.cXR.cXq;
                aeVar3.atD().ll(atr - 1);
            }
            if (atx != null) {
                i2 = this.cXR.cEJ;
                if (i2 >= 0) {
                    i3 = this.cXR.cEJ;
                    if (i3 < atx.size()) {
                        i4 = this.cXR.cEJ;
                        atx.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cXR.cXC;
                        m411getInst.delLikeForum(str);
                        adVar = this.cXR.cXB;
                        if (adVar != null) {
                            this.cXR.fR(true);
                            adVar2 = this.cXR.cXB;
                            adVar2.Y(atx);
                            adVar3 = this.cXR.cXB;
                            adVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cXR.showToast(t.j.success);
            forumData = this.cXR.cXF;
            if (forumData != null) {
                forumData2 = this.cXR.cXF;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    s sVar = this.cXR;
                    forumData3 = this.cXR.cXF;
                    sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.cXR.cXF;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.cXR.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cXR.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
    }
}
