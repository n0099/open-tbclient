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
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.ciI = rVar;
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
        this.ciI.cix = false;
        if (httpResponsedMessage.getError() == 0) {
            adVar = this.ciI.cih;
            ArrayList<ForumData> agb = adVar.agg().agb();
            adVar2 = this.ciI.cih;
            int afV = adVar2.agg().afV();
            i = this.ciI.bWM;
            if (i < afV) {
                adVar3 = this.ciI.cih;
                adVar3.agg().iE(afV - 1);
            }
            if (agb != null) {
                i2 = this.ciI.bWM;
                if (i2 >= 0) {
                    i3 = this.ciI.bWM;
                    if (i3 < agb.size()) {
                        i4 = this.ciI.bWM;
                        agb.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.ciI.cit;
                        m411getInst.delLikeForum(str);
                        acVar = this.ciI.cis;
                        if (acVar != null) {
                            this.ciI.eG(true);
                            acVar2 = this.ciI.cis;
                            acVar2.R(agb);
                            acVar3 = this.ciI.cis;
                            acVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.ciI.showToast(i.C0057i.success);
            forumData = this.ciI.ciw;
            if (forumData != null) {
                forumData2 = this.ciI.ciw;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    r rVar = this.ciI;
                    forumData3 = this.ciI.ciw;
                    rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.ciI.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.ciI.getResources().getString(i.C0057i.neterror) : httpResponsedMessage.getErrorString());
    }
}
