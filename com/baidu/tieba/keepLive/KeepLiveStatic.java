package com.baidu.tieba.keepLive;

import com.baidu.adp.base.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.keepLive.startActivity.ScreenManager;
/* loaded from: classes3.dex */
public class KeepLiveStatic {
    public static final CustomMessageListener mKeepLiveServiceListener = new CustomMessageListener(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst()) && !ak.Uq()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        a.em().currentActivity();
                    } else {
                        KeepLiveUtil.startForKeeplive(TbadkCoreApplication.getInst().getApplicationContext());
                    }
                }
            }
        }
    };
    public static final CustomMessageListener mKeepLiveActivityListener = new CustomMessageListener(CmdConfigCustom.CMD_KEEPLIVE_START_ACTIVITY) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    public static final CustomMessageListener mKeepLiveActivityFromFlagListener = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private static final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!ak.Uq() && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                ScreenManager.isBackGround = false;
            }
        }
    };
    private static final CustomMessageListener mReleaseActivityListener = new CustomMessageListener(CmdConfigCustom.CMD_KEEPLIVE_RELEASE_ACTIVITY) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!ak.Uq() && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ScreenManager.isBackGround = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(mKeepLiveServiceListener);
    }
}
