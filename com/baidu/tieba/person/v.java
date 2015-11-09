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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends HttpMessageListener {
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.cqM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ad adVar;
        ad adVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        int i2;
        int i3;
        int i4;
        String str;
        ac acVar;
        ac acVar2;
        ac acVar3;
        ad adVar3;
        this.cqM.cqB = false;
        if (httpResponsedMessage.getError() == 0) {
            adVar = this.cqM.cql;
            ArrayList<ForumData> aiS = adVar.aiX().aiS();
            adVar2 = this.cqM.cql;
            int aiM = adVar2.aiX().aiM();
            i = this.cqM.ccb;
            if (i < aiM) {
                adVar3 = this.cqM.cql;
                adVar3.aiX().jo(aiM - 1);
            }
            if (aiS != null) {
                i2 = this.cqM.ccb;
                if (i2 >= 0) {
                    i3 = this.cqM.ccb;
                    if (i3 < aiS.size()) {
                        i4 = this.cqM.ccb;
                        aiS.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cqM.cqx;
                        m411getInst.delLikeForum(str);
                        acVar = this.cqM.cqw;
                        if (acVar != null) {
                            this.cqM.eY(true);
                            acVar2 = this.cqM.cqw;
                            acVar2.S(aiS);
                            acVar3 = this.cqM.cqw;
                            acVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cqM.showToast(i.h.success);
            forumData = this.cqM.cqA;
            if (forumData != null) {
                forumData2 = this.cqM.cqA;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    r rVar = this.cqM;
                    forumData3 = this.cqM.cqA;
                    rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.cqM.cqA;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.cqM.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cqM.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
    }
}
