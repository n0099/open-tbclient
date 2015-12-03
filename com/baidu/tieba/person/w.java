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
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s sVar, int i) {
        super(i);
        this.cKg = sVar;
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
        this.cKg.cJW = false;
        if (httpResponsedMessage.getError() == 0) {
            aeVar = this.cKg.cJG;
            ArrayList<ForumData> anv = aeVar.anA().anv();
            aeVar2 = this.cKg.cJG;
            int anp = aeVar2.anA().anp();
            i = this.cKg.cua;
            if (i < anp) {
                aeVar3 = this.cKg.cJG;
                aeVar3.anA().ki(anp - 1);
            }
            if (anv != null) {
                i2 = this.cKg.cua;
                if (i2 >= 0) {
                    i3 = this.cKg.cua;
                    if (i3 < anv.size()) {
                        i4 = this.cKg.cua;
                        anv.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cKg.cJS;
                        m411getInst.delLikeForum(str);
                        adVar = this.cKg.cJR;
                        if (adVar != null) {
                            this.cKg.fD(true);
                            adVar2 = this.cKg.cJR;
                            adVar2.Y(anv);
                            adVar3 = this.cKg.cJR;
                            adVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cKg.showToast(n.i.success);
            forumData = this.cKg.cJV;
            if (forumData != null) {
                forumData2 = this.cKg.cJV;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    s sVar = this.cKg;
                    forumData3 = this.cKg.cJV;
                    sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.cKg.cJV;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.cKg.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cKg.getResources().getString(n.i.neterror) : httpResponsedMessage.getErrorString());
    }
}
