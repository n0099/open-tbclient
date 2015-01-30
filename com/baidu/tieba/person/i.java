package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends HttpMessageListener {
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, int i) {
        super(i);
        this.bHc = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        s sVar;
        s sVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        int i2;
        int i3;
        int i4;
        String str;
        q qVar;
        q qVar2;
        q qVar3;
        s sVar3;
        this.bHc.bGX = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                sVar = this.bHc.bGG;
                ArrayList<ForumData> aaJ = sVar.aaO().aaJ();
                sVar2 = this.bHc.bGG;
                int aaD = sVar2.aaO().aaD();
                i = this.bHc.byp;
                if (i < aaD) {
                    sVar3 = this.bHc.bGG;
                    sVar3.aaO().hj(aaD - 1);
                }
                if (aaJ != null) {
                    i2 = this.bHc.byp;
                    if (i2 >= 0) {
                        i3 = this.bHc.byp;
                        if (i3 < aaJ.size()) {
                            i4 = this.bHc.byp;
                            aaJ.remove(i4);
                            TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                            str = this.bHc.bGS;
                            m255getInst.delLikeForum(str);
                            qVar = this.bHc.bGR;
                            if (qVar != null) {
                                this.bHc.eh(true);
                                qVar2 = this.bHc.bGR;
                                qVar2.K(aaJ);
                                qVar3 = this.bHc.bGR;
                                qVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.bHc.showToast(com.baidu.tieba.z.success);
                forumData = this.bHc.bGW;
                if (forumData != null) {
                    forumData2 = this.bHc.bGW;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        g gVar = this.bHc;
                        forumData3 = this.bHc.bGW;
                        gVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                        return;
                    }
                    return;
                }
                return;
            }
            this.bHc.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
