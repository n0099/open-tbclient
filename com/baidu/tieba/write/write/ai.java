package com.baidu.tieba.write.write;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ai extends HttpMessageListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(WriteActivity writeActivity, int i) {
        super(i);
        this.cCP = writeActivity;
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
                str3 = this.cCP.bCP;
                if (!TextUtils.isEmpty(str3)) {
                    this.cCP.bCP = str4;
                    TbadkCoreApplication.m411getInst().setDefaultBubble(str4);
                    this.cCP.fF(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                str = this.cCP.bCP;
                if (!str4.equals(str)) {
                    this.cCP.bCP = str4;
                    TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                    str2 = this.cCP.bCP;
                    m411getInst.setDefaultBubble(str2);
                    this.cCP.fF(true);
                }
            }
        }
    }
}
