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
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.cjC = rVar;
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
        this.cjC.cjr = false;
        if (httpResponsedMessage.getError() == 0) {
            adVar = this.cjC.cjb;
            ArrayList<ForumData> agr = adVar.agw().agr();
            adVar2 = this.cjC.cjb;
            int agl = adVar2.agw().agl();
            i = this.cjC.bXD;
            if (i < agl) {
                adVar3 = this.cjC.cjb;
                adVar3.agw().iQ(agl - 1);
            }
            if (agr != null) {
                i2 = this.cjC.bXD;
                if (i2 >= 0) {
                    i3 = this.cjC.bXD;
                    if (i3 < agr.size()) {
                        i4 = this.cjC.bXD;
                        agr.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.cjC.cjn;
                        m411getInst.delLikeForum(str);
                        acVar = this.cjC.cjm;
                        if (acVar != null) {
                            this.cjC.eP(true);
                            acVar2 = this.cjC.cjm;
                            acVar2.R(agr);
                            acVar3 = this.cjC.cjm;
                            acVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.cjC.showToast(i.h.success);
            forumData = this.cjC.cjq;
            if (forumData != null) {
                forumData2 = this.cjC.cjq;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    r rVar = this.cjC;
                    forumData3 = this.cjC.cjq;
                    rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.cjC.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cjC.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
    }
}
