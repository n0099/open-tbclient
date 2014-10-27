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
    final /* synthetic */ o bBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i) {
        super(i);
        this.bBB = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
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
        this.bBB.bBx = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                zVar = this.bBB.bBn;
                ArrayList<ForumData> ZK = zVar.ZQ().ZK();
                zVar2 = this.bBB.bBn;
                int ZI = zVar2.ZQ().ZI();
                i = this.bBB.bAU;
                if (i < ZI) {
                    zVar3 = this.bBB.bBn;
                    zVar3.ZQ().gV(ZI - 1);
                }
                if (ZK != null) {
                    i2 = this.bBB.bAU;
                    if (i2 >= 0) {
                        i3 = this.bBB.bAU;
                        if (i3 < ZK.size()) {
                            i4 = this.bBB.bAU;
                            ZK.remove(i4);
                            com.baidu.tieba.aj wk = com.baidu.tieba.aj.wk();
                            str = this.bBB.bBu;
                            wk.dX(str);
                            xVar = this.bBB.bBt;
                            if (xVar != null) {
                                this.bBB.et(true);
                                xVar2 = this.bBB.bBt;
                                xVar2.E(ZK);
                                xVar3 = this.bBB.bBt;
                                xVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.bBB.showToast(com.baidu.tieba.y.success);
                forumData = this.bBB.bBw;
                if (forumData != null) {
                    forumData2 = this.bBB.bBw;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        o oVar = this.bBB;
                        forumData3 = this.bBB.bBw;
                        oVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                        return;
                    }
                    return;
                }
                return;
            }
            this.bBB.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
