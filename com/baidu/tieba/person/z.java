package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends HttpMessageListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(v vVar, int i) {
        super(i);
        this.bSb = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ai aiVar;
        ai aiVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        int i2;
        int i3;
        int i4;
        String str;
        ag agVar;
        ag agVar2;
        ag agVar3;
        ai aiVar3;
        this.bSb.bRR = false;
        if (httpResponsedMessage.getError() == 0) {
            aiVar = this.bSb.bRB;
            ArrayList<ForumData> aej = aiVar.aeo().aej();
            aiVar2 = this.bSb.bRB;
            int aed = aiVar2.aeo().aed();
            i = this.bSb.bGS;
            if (i < aed) {
                aiVar3 = this.bSb.bRB;
                aiVar3.aeo().hK(aed - 1);
            }
            if (aej != null) {
                i2 = this.bSb.bGS;
                if (i2 >= 0) {
                    i3 = this.bSb.bGS;
                    if (i3 < aej.size()) {
                        i4 = this.bSb.bGS;
                        aej.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.bSb.bRN;
                        m411getInst.delLikeForum(str);
                        agVar = this.bSb.bRM;
                        if (agVar != null) {
                            this.bSb.eo(true);
                            agVar2 = this.bSb.bRM;
                            agVar2.L(aej);
                            agVar3 = this.bSb.bRM;
                            agVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.bSb.showToast(com.baidu.tieba.t.success);
            forumData = this.bSb.bRQ;
            if (forumData != null) {
                forumData2 = this.bSb.bRQ;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    v vVar = this.bSb;
                    forumData3 = this.bSb.bRQ;
                    vVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.bSb.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bSb.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
    }
}
