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
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s sVar, int i) {
        super(i);
        this.dst = sVar;
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
        this.dst.dsi = false;
        if (httpResponsedMessage.getError() == 0) {
            aeVar = this.dst.drS;
            ArrayList<ForumData> aBd = aeVar.aBj().aBd();
            aeVar2 = this.dst.drS;
            int aAX = aeVar2.aBj().aAX();
            i = this.dst.cYb;
            if (i < aAX) {
                aeVar3 = this.dst.drS;
                aeVar3.aBj().mu(aAX - 1);
            }
            if (aBd != null) {
                i2 = this.dst.cYb;
                if (i2 >= 0) {
                    i3 = this.dst.cYb;
                    if (i3 < aBd.size()) {
                        i4 = this.dst.cYb;
                        aBd.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.dst.dse;
                        m411getInst.delLikeForum(str);
                        adVar = this.dst.dsd;
                        if (adVar != null) {
                            this.dst.gE(true);
                            adVar2 = this.dst.dsd;
                            adVar2.Z(aBd);
                            adVar3 = this.dst.dsd;
                            adVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.dst.showToast(t.j.success);
            forumData = this.dst.dsh;
            if (forumData != null) {
                forumData2 = this.dst.dsh;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    s sVar = this.dst;
                    forumData3 = this.dst.dsh;
                    sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.dst.dsh;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.dst.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dst.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
    }
}
