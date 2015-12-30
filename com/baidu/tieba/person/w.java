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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s sVar, int i) {
        super(i);
        this.cOw = sVar;
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
        this.cOw.cOm = false;
        if (httpResponsedMessage.getError() == 0) {
            aeVar = this.cOw.cNW;
            ArrayList<ForumData> aoG = aeVar.aoL().aoG();
            aeVar2 = this.cOw.cNW;
            int aoA = aeVar2.aoL().aoA();
            i = this.cOw.cyc;
            if (i < aoA) {
                aeVar3 = this.cOw.cNW;
                aeVar3.aoL().kF(aoA - 1);
            }
            if (aoG != null) {
                i2 = this.cOw.cyc;
                if (i2 >= 0) {
                    i3 = this.cOw.cyc;
                    if (i3 < aoG.size()) {
                        i4 = this.cOw.cyc;
                        aoG.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cOw.cOi;
                        m411getInst.delLikeForum(str);
                        adVar = this.cOw.cOh;
                        if (adVar != null) {
                            this.cOw.fC(true);
                            adVar2 = this.cOw.cOh;
                            adVar2.X(aoG);
                            adVar3 = this.cOw.cOh;
                            adVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cOw.showToast(n.j.success);
            forumData = this.cOw.cOl;
            if (forumData != null) {
                forumData2 = this.cOw.cOl;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    s sVar = this.cOw;
                    forumData3 = this.cOw.cOl;
                    sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.cOw.cOl;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.cOw.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cOw.getResources().getString(n.j.neterror) : httpResponsedMessage.getErrorString());
    }
}
