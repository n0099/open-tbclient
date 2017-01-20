package com.baidu.tieba.write.write;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class u extends HttpMessageListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(WriteActivity writeActivity, int i) {
        super(i);
        this.fMl = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        String str2;
        String str3;
        if (httpResponsedMessage.getError() == 0) {
            String str4 = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
            if (TextUtils.isEmpty(str4)) {
                str3 = this.fMl.dIu;
                if (!TextUtils.isEmpty(str3)) {
                    this.fMl.dIu = str4;
                    TbadkCoreApplication.m9getInst().setDefaultBubble(str4);
                    this.fMl.lO(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                str = this.fMl.dIu;
                if (!str4.equals(str)) {
                    this.fMl.dIu = str4;
                    TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                    str2 = this.fMl.dIu;
                    m9getInst.setDefaultBubble(str2);
                    this.fMl.lO(true);
                }
            }
        }
    }
}
