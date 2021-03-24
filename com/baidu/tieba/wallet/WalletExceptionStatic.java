package com.baidu.tieba.wallet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes5.dex */
public class WalletExceptionStatic {
    public static final String FATAL_ERROR_WALLET = "com.baidu.tieba.wallet";

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tieba.wallet.WalletExceptionStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData) || !((ExceptionData) customResponsedMessage.getData()).info.contains(WalletExceptionStatic.FATAL_ERROR_WALLET)) {
                    return;
                }
                TbadkCoreApplication.getInst().incWalletSdkCrashCount();
            }
        });
    }
}
