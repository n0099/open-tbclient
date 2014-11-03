package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends HttpMessageListener {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i) {
        super(i);
        this.bBP = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        z zVar;
        z zVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        int i2;
        int i3;
        int i4;
        String str;
        x xVar;
        x xVar2;
        x xVar3;
        z zVar3;
        this.bBP.bBL = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                zVar = this.bBP.bBB;
                ArrayList<ForumData> ZM = zVar.ZS().ZM();
                zVar2 = this.bBP.bBB;
                int ZK = zVar2.ZS().ZK();
                i = this.bBP.bBi;
                if (i < ZK) {
                    zVar3 = this.bBP.bBB;
                    zVar3.ZS().gV(ZK - 1);
                }
                if (ZM != null) {
                    i2 = this.bBP.bBi;
                    if (i2 >= 0) {
                        i3 = this.bBP.bBi;
                        if (i3 < ZM.size()) {
                            i4 = this.bBP.bBi;
                            ZM.remove(i4);
                            com.baidu.tieba.aj wm = com.baidu.tieba.aj.wm();
                            str = this.bBP.bBI;
                            wm.dX(str);
                            xVar = this.bBP.bBH;
                            if (xVar != null) {
                                this.bBP.et(true);
                                xVar2 = this.bBP.bBH;
                                xVar2.F(ZM);
                                xVar3 = this.bBP.bBH;
                                xVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.bBP.showToast(com.baidu.tieba.y.success);
                forumData = this.bBP.bBK;
                if (forumData != null) {
                    forumData2 = this.bBP.bBK;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        o oVar = this.bBP;
                        forumData3 = this.bBP.bBK;
                        oVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                        return;
                    }
                    return;
                }
                return;
            }
            this.bBP.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
