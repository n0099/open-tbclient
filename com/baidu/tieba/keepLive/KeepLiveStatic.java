package com.baidu.tieba.keepLive;

import com.baidu.adp.base.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.keepLive.startActivity.ScreenManager;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
/* loaded from: classes2.dex */
public class KeepLiveStatic {
    public static final CustomMessageListener mKeepLiveServiceListener = new CustomMessageListener(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst()) && !RomTypeUtil.isEmui()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        a.ca().cb();
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
            if (!RomTypeUtil.isEmui()) {
                KeepLiveUtil.startKeepLiveForBackGroungActivity();
            }
        }
    };
    public static final CustomMessageListener mKeepLiveActivityFromFlagListener = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!RomTypeUtil.isEmui()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    KeepLiveUtil.startOrStopActivityForKeepLive(((Boolean) data).booleanValue());
                }
            }
        }
    };
    private static final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!RomTypeUtil.isEmui() && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                ScreenManager.isBackGround = false;
            }
        }
    };
    private static final CustomMessageListener mReleaseActivityListener = new CustomMessageListener(CmdConfigCustom.CMD_KEEPLIVE_RELEASE_ACTIVITY) { // from class: com.baidu.tieba.keepLive.KeepLiveStatic.5
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
        MessageManager.getInstance().registerListener(mKeepLiveActivityListener);
        MessageManager.getInstance().registerListener(mKeepLiveActivityFromFlagListener);
    }
}
