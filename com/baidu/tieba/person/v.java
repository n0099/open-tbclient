package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
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
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.cpq = rVar;
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
        int i2;
        int i3;
        int i4;
        String str;
        ac acVar;
        ac acVar2;
        ac acVar3;
        ad adVar3;
        this.cpq.cpf = false;
        if (httpResponsedMessage.getError() == 0) {
            adVar = this.cpq.coP;
            ArrayList<ForumData> aiq = adVar.aiv().aiq();
            adVar2 = this.cpq.coP;
            int aik = adVar2.aiv().aik();
            i = this.cpq.cbA;
            if (i < aik) {
                adVar3 = this.cpq.coP;
                adVar3.aiv().ja(aik - 1);
            }
            if (aiq != null) {
                i2 = this.cpq.cbA;
                if (i2 >= 0) {
                    i3 = this.cpq.cbA;
                    if (i3 < aiq.size()) {
                        i4 = this.cpq.cbA;
                        aiq.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cpq.cpb;
                        m411getInst.delLikeForum(str);
                        acVar = this.cpq.cpa;
                        if (acVar != null) {
                            this.cpq.eV(true);
                            acVar2 = this.cpq.cpa;
                            acVar2.S(aiq);
                            acVar3 = this.cpq.cpa;
                            acVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cpq.showToast(i.h.success);
            forumData = this.cpq.cpe;
            if (forumData != null) {
                forumData2 = this.cpq.cpe;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    r rVar = this.cpq;
                    forumData3 = this.cpq.cpe;
                    rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.cpq.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cpq.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
    }
}
