package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
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
import com.baidu.tbadk.util.l;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeResMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeResMsg;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivity;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.privacy.PrivacyPermissionActivity;
import com.baidu.tieba.setting.usermutelist.UserMuteListActivity;
import com.xiaomi.mipush.sdk.Constants;
import protobuf.MaskInfo;
/* loaded from: classes11.dex */
public class SettingStatic {
    private static MaskInfo maskInfo;
    private static boolean jTw = false;
    private static boolean jTx = false;
    private static final com.baidu.adp.framework.listener.c hDO = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.setting.more.SettingStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MaskInfo maskInfo2;
            if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && (socketResponsedMessage instanceof ResponseOnlineMessage) && (maskInfo2 = ((ResponseOnlineMessage) socketResponsedMessage).getMaskInfo()) != null) {
                MaskInfo unused = SettingStatic.maskInfo = maskInfo2;
                SettingStatic.cFt();
            }
        }
    };
    private static final CustomMessageListener dUf = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.setting.more.SettingStatic.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean unused = SettingStatic.jTx = false;
            MaskInfo unused2 = SettingStatic.maskInfo = null;
            boolean unused3 = SettingStatic.jTw = false;
        }
    };
    private static final CustomMessageListener jTy = new CustomMessageListener(CmdConfigCustom.CMD_SETTING_READ_FINISH) { // from class: com.baidu.tieba.setting.more.SettingStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean unused = SettingStatic.jTw = true;
            SettingStatic.cFt();
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AdSettingActivityConfig.class, AdSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgReceiveActivityConfig.class, MsgReceiveActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PrivacyPermissionActivityConfig.class, PrivacyPermissionActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(OfficialAccountPushActivityConfig.class, OfficialAccountPushActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MORE, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.setting.more.SettingStatic.6
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
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_GET_PRIVATE_INFO, ResponsedPrivacySocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002501, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.GET_PRIVATE_INFO, CmdConfigSocket.CMD_GET_PRIVATE_INFO));
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(dUf);
        MessageManager.getInstance().registerListener(hDO);
        MessageManager.getInstance().registerListener(jTy);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_UPDATE_MASK, ResponseUpdateMaskMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_UPDATE_FORUM_MAST_STAT, ResponseUpdateForumMask.class, false);
        cFu();
        cFv();
        cFw();
        cFx();
        cFy();
        SwitchManager.getInstance().registerSwitch(com.baidu.tieba.setting.im.more.b.class);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new CustomMessageTask.CustomRunnable<UserMuteListActivityConfig>() { // from class: com.baidu.tieba.setting.more.SettingStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<UserMuteListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(UserMuteListActivity.class);
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void cFt() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (jTw && maskInfo != null && !jTx) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(new StringBuilder().append(SharedPrefConfig.HAD_SYNC_SETTING_SWITCH).append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.HAD_SYNC_SETTING_SWITCH + currentAccount, true);
                    if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIS()) {
                        R(14, false);
                    } else {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIV()) {
                            R(2, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIW()) {
                            R(3, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJg()) {
                            R(4, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIY()) {
                            R(5, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIX()) {
                            R(1, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJh()) {
                            R(20, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fS(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fS(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fR(z2);
                            boolean z3 = (intValue & 1) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ga(z3);
                            boolean z4 = (intValue & 2) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gb(z4);
                            boolean z5 = (intValue & 4) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gc(z5);
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gd((intValue & 2048) == 0);
                            boolean z6 = (intValue & 4096) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fT(z6);
                            if (z3 || z4 || z5 || z2 || z || z6) {
                                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ly(300);
                            } else {
                                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ly(0);
                            }
                        }
                        com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.setting.more.SettingStatic.4
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIR();
                            }
                        });
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.setting.more.SettingStatic.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIR();
                        }
                    });
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.d.bWy().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.b.bWw().a(currentAccount, str2, false, (l<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.e.bWz().a(currentAccount, str3, false, null);
                    }
                }
                jTx = true;
            }
        }
    }

    private static final void R(int i, boolean z) {
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

    private static void cFu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003318, TbConfig.SERVER_ADDRESS + TbConfig.FRIEND_AND_STRANGER_MSG_SWITCH);
        tbHttpMessageTask.setResponsedClass(FriendAndStrangerSwitchResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cFv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003319, TbConfig.SERVER_ADDRESS + TbConfig.GET_FRIEND_AND_STRANGER_MSG_SWITCH);
        tbHttpMessageTask.setResponsedClass(GetFriendAndStrangerSwitchResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cFw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_IMAGE_WATERMARK_TYPE, TbConfig.SERVER_ADDRESS + TbConfig.SET_IMAGE_WATERMARK_TYPE);
        tbHttpMessageTask.setResponsedClass(SetImageWatermarkTypeResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cFx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE, TbConfig.SERVER_ADDRESS + TbConfig.GET_IMAGE_WATERMARK_TYPE);
        tbHttpMessageTask.setResponsedClass(GetImageWatermarkTypeResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cFy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_LOG_OUT, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.setting.more.SettingStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    Context data = customMessage.getData();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
                    TbadkCoreApplication.getInst().deleteAccountAllInfo(currentAccount);
                    com.baidu.tbadk.coreExtra.a.a.aGD().sapiLogout();
                    com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logout_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, data);
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(data, true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
