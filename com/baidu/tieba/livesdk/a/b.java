package com.baidu.tieba.livesdk.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.c.a.a.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes3.dex */
public class b implements com.baidu.c.a.a.a {
    private c jeQ;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.livesdk.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.jeQ != null) {
                b.this.jeQ.onLoginStatusChanged(false, false);
            }
        }
    };

    public b() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.c.a.a.a
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.c.a.a.a
    public void login() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
    }

    @Override // com.baidu.c.a.a.a
    public com.baidu.c.a.a.b JL() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.c.a.a.b bVar = new com.baidu.c.a.a.b();
            bVar.setUid(currentAccountInfo.getID());
            bVar.setBduss(currentAccountInfo.getBDUSS());
            bVar.setDisplayname(currentAccountInfo.getAccountNameShow());
            bVar.fX(TbConfig.getBigPhotoAdress() + currentAccountInfo.getPortrait());
            return bVar;
        }
        return null;
    }

    @Override // com.baidu.c.a.a.a
    public void a(c cVar) {
        this.jeQ = cVar;
    }
}
