package com.baidu.tieba.write.write;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ai extends HttpMessageListener {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(WriteActivity writeActivity, int i) {
        super(i);
        this.cCQ = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        String str2;
        String str3;
        if (httpResponsedMessage.getError() == 0) {
            String str4 = (String) MessageManager.getInstance().runTask(2001291, String.class, httpResponsedMessage).getData();
            if (TextUtils.isEmpty(str4)) {
                str3 = this.cCQ.bCQ;
                if (!TextUtils.isEmpty(str3)) {
                    this.cCQ.bCQ = str4;
                    TbadkCoreApplication.m411getInst().setDefaultBubble(str4);
                    this.cCQ.fF(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                str = this.cCQ.bCQ;
                if (!str4.equals(str)) {
                    this.cCQ.bCQ = str4;
                    TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                    str2 = this.cCQ.bCQ;
                    m411getInst.setDefaultBubble(str2);
                    this.cCQ.fF(true);
                }
            }
        }
    }
}
