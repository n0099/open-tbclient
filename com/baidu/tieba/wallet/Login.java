package com.baidu.tieba.wallet;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletListener;
import d.a.m0.l.a;
/* loaded from: classes5.dex */
public class Login extends LightAppListenerImpl implements IWalletListener {
    public CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.wallet.Login.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || Login.this.mLoginBackListener == null) {
                return;
            }
            Login.this.mLoginBackListener.onSuccess(0, TbadkCoreApplication.getCurrentBduss());
            Login.this.mLoginBackListener = null;
        }
    };
    public Context mContext;
    public ILoginBackListener mLoginBackListener;

    public Login(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        this.mLoginBackListener = iLoginBackListener;
        TbadkCoreApplication.getInst().handler.post(new Runnable() { // from class: com.baidu.tieba.wallet.Login.2
            @Override // java.lang.Runnable
            public void run() {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(Login.this.mContext, true)));
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        if (UrlSchemaHelper.SCHEMA_TYPE_GOTO_CONSUMPTION_RECORDS.equals(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(this.mContext)));
        } else if (UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY.equals(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.mContext, 0)));
        } else if ("tdoudiscount:".equals(str)) {
            CurrencyJumpHelper.schemaGotoBuyBean(this.mContext);
        } else {
            a.s(this.mContext, true, str);
        }
        return true;
    }
}
