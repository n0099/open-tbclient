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
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.cpf = rVar;
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
        this.cpf.coU = false;
        if (httpResponsedMessage.getError() == 0) {
            adVar = this.cpf.coE;
            ArrayList<ForumData> aiq = adVar.aiv().aiq();
            adVar2 = this.cpf.coE;
            int aik = adVar2.aiv().aik();
            i = this.cpf.cbp;
            if (i < aik) {
                adVar3 = this.cpf.coE;
                adVar3.aiv().ja(aik - 1);
            }
            if (aiq != null) {
                i2 = this.cpf.cbp;
                if (i2 >= 0) {
                    i3 = this.cpf.cbp;
                    if (i3 < aiq.size()) {
                        i4 = this.cpf.cbp;
                        aiq.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cpf.coQ;
                        m411getInst.delLikeForum(str);
                        acVar = this.cpf.coP;
                        if (acVar != null) {
                            this.cpf.eV(true);
                            acVar2 = this.cpf.coP;
                            acVar2.S(aiq);
                            acVar3 = this.cpf.coP;
                            acVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cpf.showToast(i.h.success);
            forumData = this.cpf.coT;
            if (forumData != null) {
                forumData2 = this.cpf.coT;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    r rVar = this.cpf;
                    forumData3 = this.cpf.coT;
                    rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.cpf.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cpf.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
    }
}
