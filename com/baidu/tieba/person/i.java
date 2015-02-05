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
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, int i) {
        super(i);
        this.bHb = gVar;
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
        this.bHb.bGW = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                sVar = this.bHb.bGF;
                ArrayList<ForumData> aaE = sVar.aaJ().aaE();
                sVar2 = this.bHb.bGF;
                int aay = sVar2.aaJ().aay();
                i = this.bHb.byo;
                if (i < aay) {
                    sVar3 = this.bHb.bGF;
                    sVar3.aaJ().hj(aay - 1);
                }
                if (aaE != null) {
                    i2 = this.bHb.byo;
                    if (i2 >= 0) {
                        i3 = this.bHb.byo;
                        if (i3 < aaE.size()) {
                            i4 = this.bHb.byo;
                            aaE.remove(i4);
                            TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                            str = this.bHb.bGR;
                            m255getInst.delLikeForum(str);
                            qVar = this.bHb.bGQ;
                            if (qVar != null) {
                                this.bHb.eh(true);
                                qVar2 = this.bHb.bGQ;
                                qVar2.K(aaE);
                                qVar3 = this.bHb.bGQ;
                                qVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.bHb.showToast(com.baidu.tieba.z.success);
                forumData = this.bHb.bGV;
                if (forumData != null) {
                    forumData2 = this.bHb.bGV;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        g gVar = this.bHb;
                        forumData3 = this.bHb.bGV;
                        gVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                        return;
                    }
                    return;
                }
                return;
            }
            this.bHb.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
