package com.baidu.tieba.write.write;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class z extends HttpMessageListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(WriteActivity writeActivity, int i) {
        super(i);
        this.feb = writeActivity;
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
                str3 = this.feb.cSm;
                if (!TextUtils.isEmpty(str3)) {
                    this.feb.cSm = str4;
                    TbadkCoreApplication.m11getInst().setDefaultBubble(str4);
                    this.feb.kB(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                str = this.feb.cSm;
                if (!str4.equals(str)) {
                    this.feb.cSm = str4;
                    TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                    str2 = this.feb.cSm;
                    m11getInst.setDefaultBubble(str2);
                    this.feb.kB(true);
                }
            }
        }
    }
}
