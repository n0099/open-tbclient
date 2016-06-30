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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends HttpMessageListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(t tVar, int i) {
        super(i);
        this.eeh = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ag agVar;
        ag agVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        int i2;
        int i3;
        int i4;
        String str;
        af afVar;
        af afVar2;
        af afVar3;
        ag agVar3;
        this.eeh.edW = false;
        if (httpResponsedMessage.getError() == 0) {
            agVar = this.eeh.edG;
            ArrayList<ForumData> aKv = agVar.aKA().aKv();
            agVar2 = this.eeh.edG;
            int aKp = agVar2.aKA().aKp();
            i = this.eeh.dGZ;
            if (i < aKp) {
                agVar3 = this.eeh.edG;
                agVar3.aKA().nL(aKp - 1);
            }
            if (aKv != null) {
                i2 = this.eeh.dGZ;
                if (i2 >= 0) {
                    i3 = this.eeh.dGZ;
                    if (i3 < aKv.size()) {
                        i4 = this.eeh.dGZ;
                        aKv.remove(i4);
                        TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                        str = this.eeh.edS;
                        m9getInst.delLikeForum(str);
                        afVar = this.eeh.edR;
                        if (afVar != null) {
                            this.eeh.m15if(true);
                            afVar2 = this.eeh.edR;
                            afVar2.am(aKv);
                            afVar3 = this.eeh.edR;
                            afVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.eeh.showToast(u.j.success);
            forumData = this.eeh.edV;
            if (forumData != null) {
                forumData2 = this.eeh.edV;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    t tVar = this.eeh;
                    forumData3 = this.eeh.edV;
                    tVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.eeh.edV;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.eeh.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.eeh.getResources().getString(u.j.neterror) : httpResponsedMessage.getErrorString());
    }
}
