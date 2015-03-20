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
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar, int i) {
        super(i);
        this.bPF = vVar;
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
        this.bPF.bPz = false;
        if (httpResponsedMessage.getError() == 0) {
            ahVar = this.bPF.bPi;
            ArrayList<ForumData> acU = ahVar.acZ().acU();
            ahVar2 = this.bPF.bPi;
            int acO = ahVar2.acZ().acO();
            i = this.bPF.bDK;
            if (i < acO) {
                ahVar3 = this.bPF.bPi;
                ahVar3.acZ().hu(acO - 1);
            }
            if (acU != null) {
                i2 = this.bPF.bDK;
                if (i2 >= 0) {
                    i3 = this.bPF.bDK;
                    if (i3 < acU.size()) {
                        i4 = this.bPF.bDK;
                        acU.remove(i4);
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        str = this.bPF.bPu;
                        m411getInst.delLikeForum(str);
                        afVar = this.bPF.bPt;
                        if (afVar != null) {
                            this.bPF.ee(true);
                            afVar2 = this.bPF.bPt;
                            afVar2.O(acU);
                            afVar3 = this.bPF.bPt;
                            afVar3.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.bPF.showToast(com.baidu.tieba.y.success);
            forumData = this.bPF.bPy;
            if (forumData != null) {
                forumData2 = this.bPF.bPy;
                if (!TextUtils.isEmpty(forumData2.getId())) {
                    v vVar = this.bPF;
                    forumData3 = this.bPF.bPy;
                    vVar.sendMessage(new CustomMessage(2003004, forumData3.getId()));
                    return;
                }
                return;
            }
            return;
        }
        this.bPF.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bPF.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
    }
}
