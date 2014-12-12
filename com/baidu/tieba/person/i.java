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
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, int i) {
        super(i);
        this.bFr = gVar;
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
        this.bFr.bFm = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                sVar = this.bFr.bEV;
                ArrayList<ForumData> aae = sVar.aaj().aae();
                sVar2 = this.bFr.bEV;
                int ZY = sVar2.aaj().ZY();
                i = this.bFr.bwG;
                if (i < ZY) {
                    sVar3 = this.bFr.bEV;
                    sVar3.aaj().ha(ZY - 1);
                }
                if (aae != null) {
                    i2 = this.bFr.bwG;
                    if (i2 >= 0) {
                        i3 = this.bFr.bwG;
                        if (i3 < aae.size()) {
                            i4 = this.bFr.bwG;
                            aae.remove(i4);
                            TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                            str = this.bFr.bFh;
                            m255getInst.delLikeForum(str);
                            qVar = this.bFr.bFg;
                            if (qVar != null) {
                                this.bFr.eb(true);
                                qVar2 = this.bFr.bFg;
                                qVar2.J(aae);
                                qVar3 = this.bFr.bFg;
                                qVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.bFr.showToast(com.baidu.tieba.z.success);
                forumData = this.bFr.bFl;
                if (forumData != null) {
                    forumData2 = this.bFr.bFl;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        g gVar = this.bFr;
                        forumData3 = this.bFr.bFl;
                        gVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                        return;
                    }
                    return;
                }
                return;
            }
            this.bFr.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
