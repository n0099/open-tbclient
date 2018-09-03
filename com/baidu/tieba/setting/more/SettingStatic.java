package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchResMsg;
import protobuf.MaskInfo;
/* loaded from: classes3.dex */
public class SettingStatic {
    private static MaskInfo maskInfo;
    private static boolean gBl = false;
    private static boolean gBm = false;
    private static final com.baidu.adp.framework.listener.c eyf = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.setting.more.SettingStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MaskInfo maskInfo2;
            if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && (socketResponsedMessage instanceof ResponseOnlineMessage) && (maskInfo2 = ((ResponseOnlineMessage) socketResponsedMessage).getMaskInfo()) != null) {
                MaskInfo unused = SettingStatic.maskInfo = maskInfo2;
                SettingStatic.bre();
            }
        }
    };
    private static final CustomMessageListener bmU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.setting.more.SettingStatic.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean unused = SettingStatic.gBm = false;
            MaskInfo unused2 = SettingStatic.maskInfo = null;
            boolean unused3 = SettingStatic.gBl = false;
        }
    };
    private static final CustomMessageListener gBn = new CustomMessageListener(2001311) { // from class: com.baidu.tieba.setting.more.SettingStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean unused = SettingStatic.gBl = true;
            SettingStatic.bre();
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgReceiveActivityConfig.class, MsgReceiveActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.setting.more.SettingStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(MoreActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(303016, ResponsedPrivacySocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, com.baidu.tieba.tbadkCore.a.a.aK(TbConfig.GET_PRIVATE_INFO, 303016));
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(bmU);
        MessageManager.getInstance().registerListener(eyf);
        MessageManager.getInstance().registerListener(gBn);
        com.baidu.tieba.tbadkCore.a.a.c(104101, ResponseUpdateMaskMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.c(104106, ResponseUpdateForumMask.class, false);
        brf();
        brg();
        brh();
        com.baidu.adp.lib.b.d.hv().f(com.baidu.tieba.setting.im.more.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void bre() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (gBl && maskInfo != null && !gBm) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(new StringBuilder().append("had_sync_setting_switch").append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("had_sync_setting_switch" + currentAccount, true);
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DU()) {
                        C(14, false);
                    } else {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX()) {
                            C(2, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DY()) {
                            C(3, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh()) {
                            C(4, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea()) {
                            C(5, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DZ()) {
                            C(1, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei()) {
                            C(20, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().be(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().be(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bd(z2);
                            boolean z3 = (intValue & 1) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bm(z3);
                            boolean z4 = (intValue & 2) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bn(z4);
                            boolean z5 = (intValue & 4) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bo(z5);
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bp((intValue & 2048) == 0);
                            boolean z6 = (intValue & 4096) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bf(z6);
                            if (z3 || z4 || z5 || z2 || z || z6) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.DS().ea(300);
                            } else {
                                com.baidu.tbadk.coreExtra.messageCenter.c.DS().ea(0);
                            }
                        }
                        h.io().d(new Runnable() { // from class: com.baidu.tieba.setting.more.SettingStatic.4
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tbadk.coreExtra.messageCenter.c.DS().DT();
                            }
                        });
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    h.io().d(new Runnable() { // from class: com.baidu.tieba.setting.more.SettingStatic.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DS().DT();
                        }
                    });
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.d.aNs().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.b.aNq().a(currentAccount, str2, false, (com.baidu.tbadk.util.g<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.e.aNt().a(currentAccount, str3, false, null);
                    }
                }
                gBm = true;
            }
        }
    }

    private static final void C(int i, boolean z) {
        if (i == 4) {
            RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
            requestUpdateMaskMessage.setSettingMask(z);
            MessageManager.getInstance().sendMessage(requestUpdateMaskMessage);
            return;
        }
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(i);
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    private static void brf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH, TbConfig.SERVER_ADDRESS + TbConfig.FRIEND_AND_STRANGER_MSG_SWITCH);
        tbHttpMessageTask.setResponsedClass(FriendAndStrangerSwitchResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void brg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH, TbConfig.SERVER_ADDRESS + TbConfig.GET_FRIEND_AND_STRANGER_MSG_SWITCH);
        tbHttpMessageTask.setResponsedClass(GetFriendAndStrangerSwitchResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void brh() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921330, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.setting.more.SettingStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    final Context data = customMessage.getData();
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.SettingStatic.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
                            TbadkCoreApplication.getInst().deleteAccountAllInfo(currentAccount);
                            TbadkCoreApplication.setCurrentAccount(null, data);
                            com.baidu.tbadk.coreExtra.a.a.Bu().Bv();
                            TbadkCoreApplication.getInst().onUserChanged();
                        }
                    }, 600L);
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(data, true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
