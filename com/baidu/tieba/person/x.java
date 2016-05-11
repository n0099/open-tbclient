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
public class x extends HttpMessageListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(s sVar, int i) {
        super(i);
        this.dvP = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        af afVar;
        af afVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        int i2;
        int i3;
        int i4;
        String str;
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        af afVar3;
        this.dvP.dvE = false;
        if (httpResponsedMessage.getError() == 0) {
            afVar = this.dvP.dvo;
            ArrayList<ForumData> aBA = afVar.aBF().aBA();
            afVar2 = this.dvP.dvo;
            int aBu = afVar2.aBF().aBu();
            i = this.dvP.dar;
            if (i < aBu) {
                afVar3 = this.dvP.dvo;
                afVar3.aBF().ml(aBu - 1);
            }
            if (aBA != null) {
                i2 = this.dvP.dar;
                if (i2 >= 0) {
                    i3 = this.dvP.dar;
                    if (i3 < aBA.size()) {
                        i4 = this.dvP.dar;
                        aBA.remove(i4);
                        TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                        str = this.dvP.dvA;
                        m11getInst.delLikeForum(str);
                        aeVar = this.dvP.dvz;
                        if (aeVar != null) {
                            this.dvP.hk(true);
                            aeVar2 = this.dvP.dvz;
                            aeVar2.ab(aBA);
                            aeVar3 = this.dvP.dvz;
                            aeVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.dvP.showToast(t.j.success);
            forumData = this.dvP.dvD;
            if (forumData != null) {
                forumData2 = this.dvP.dvD;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    s sVar = this.dvP;
                    forumData3 = this.dvP.dvD;
                    sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    forumData4 = this.dvP.dvD;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(forumData4.getId(), 0L))));
                    return;
                }
                return;
            }
            return;
        }
        this.dvP.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dvP.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
    }
}
