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
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(v vVar, int i) {
        super(i);
        this.bSc = vVar;
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
        this.bSc.bRS = false;
        if (httpResponsedMessage.getError() == 0) {
            aiVar = this.bSc.bRC;
            ArrayList<ForumData> aek = aiVar.aep().aek();
            aiVar2 = this.bSc.bRC;
            int aee = aiVar2.aep().aee();
            i = this.bSc.bGT;
            if (i < aee) {
                aiVar3 = this.bSc.bRC;
                aiVar3.aep().hK(aee - 1);
            }
            if (aek != null) {
                i2 = this.bSc.bGT;
                if (i2 >= 0) {
                    i3 = this.bSc.bGT;
                    if (i3 < aek.size()) {
                        i4 = this.bSc.bGT;
                        aek.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.bSc.bRO;
                        m411getInst.delLikeForum(str);
                        agVar = this.bSc.bRN;
                        if (agVar != null) {
                            this.bSc.eo(true);
                            agVar2 = this.bSc.bRN;
                            agVar2.L(aek);
                            agVar3 = this.bSc.bRN;
                            agVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.bSc.showToast(com.baidu.tieba.t.success);
            forumData = this.bSc.bRR;
            if (forumData != null) {
                forumData2 = this.bSc.bRR;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    v vVar = this.bSc;
                    forumData3 = this.bSc.bRR;
                    vVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.bSc.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bSc.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
    }
}
