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
public class x extends HttpMessageListener {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar, int i) {
        super(i);
        this.bPV = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        int i2;
        int i3;
        int i4;
        String str;
        af afVar;
        af afVar2;
        af afVar3;
        ah ahVar3;
        this.bPV.bPP = false;
        if (httpResponsedMessage.getError() == 0) {
            ahVar = this.bPV.bPy;
            ArrayList<ForumData> adj = ahVar.ado().adj();
            ahVar2 = this.bPV.bPy;
            int add = ahVar2.ado().add();
            i = this.bPV.bDX;
            if (i < add) {
                ahVar3 = this.bPV.bPy;
                ahVar3.ado().hx(add - 1);
            }
            if (adj != null) {
                i2 = this.bPV.bDX;
                if (i2 >= 0) {
                    i3 = this.bPV.bDX;
                    if (i3 < adj.size()) {
                        i4 = this.bPV.bDX;
                        adj.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.bPV.bPK;
                        m411getInst.delLikeForum(str);
                        afVar = this.bPV.bPJ;
                        if (afVar != null) {
                            this.bPV.ec(true);
                            afVar2 = this.bPV.bPJ;
                            afVar2.Q(adj);
                            afVar3 = this.bPV.bPJ;
                            afVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.bPV.showToast(com.baidu.tieba.y.success);
            forumData = this.bPV.bPO;
            if (forumData != null) {
                forumData2 = this.bPV.bPO;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    v vVar = this.bPV;
                    forumData3 = this.bPV.bPO;
                    vVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.bPV.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bPV.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
    }
}
