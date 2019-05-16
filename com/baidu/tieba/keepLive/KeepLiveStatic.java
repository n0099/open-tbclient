package com.baidu.tieba.keepLive;

import com.baidu.adp.base.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.keepLive.startActivity.ScreenManager;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
/* loaded from: classes3.dex */
public class KeepLiveStatic {
    public static final CustomMessageListener mKeepLiveServiceListener = new CustomMessageListener(2921300) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst()) && !RomTypeUtil.isEmui()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        a.eM().eN();
                    } else {
                        KeepLiveUtil.startForKeeplive(TbadkCoreApplication.getInst().getApplicationContext());
                    }
                }
            }
        }
    };
    public static final CustomMessageListener mKeepLiveActivityListener = new CustomMessageListener(2921301) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    public static final CustomMessageListener mKeepLiveActivityFromFlagListener = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private static final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!RomTypeUtil.isEmui() && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                ScreenManager.isBackGround = false;
            }
        }
    };
    private static final CustomMessageListener mReleaseActivityListener = new CustomMessageListener(2921302) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!RomTypeUtil.isEmui() && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ScreenManager.isBackGround = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(mKeepLiveServiceListener);
    }
}
