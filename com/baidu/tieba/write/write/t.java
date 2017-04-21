package com.baidu.tieba.write.write;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class t extends HttpMessageListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(WriteActivity writeActivity, int i) {
        super(i);
        this.fUM = writeActivity;
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
                str3 = this.fUM.dJR;
                if (!TextUtils.isEmpty(str3)) {
                    this.fUM.dJR = str4;
                    TbadkCoreApplication.m9getInst().setDefaultBubble(str4);
                    this.fUM.ma(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                str = this.fUM.dJR;
                if (!str4.equals(str)) {
                    this.fUM.dJR = str4;
                    TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                    str2 = this.fUM.dJR;
                    m9getInst.setDefaultBubble(str2);
                    this.fUM.ma(true);
                }
            }
        }
    }
}
