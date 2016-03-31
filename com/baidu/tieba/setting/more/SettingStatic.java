package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
import com.baidu.tieba.setting.AboutActivityConfig;
import com.baidu.tieba.setting.AccountSafeSettingActivityConfig;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import protobuf.MaskInfo;
/* loaded from: classes.dex */
public class SettingStatic {
    private static MaskInfo maskInfo;
    private static boolean eeq = false;
    private static boolean eer = false;
    private static final com.baidu.adp.framework.listener.e cmn = new ao(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private static final CustomMessageListener aME = new ap(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private static final CustomMessageListener ees = new aq(CmdConfigCustom.CMD_SETTING_READ_FINISH);

    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AccountSafeSettingActivityConfig.class, AccountSafeActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(SapiWebViewActivityConfig.class, SapiWebViewActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MORE, new ar());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(303016, ResponsedPrivacySocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, com.baidu.tieba.tbadkCore.a.a.au(TbConfig.GET_PRIVATE_INFO, 303016));
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(aME);
        MessageManager.getInstance().registerListener(cmn);
        MessageManager.getInstance().registerListener(ees);
        com.baidu.tieba.tbadkCore.a.a.c(104101, ResponseUpdateMaskMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.c(104106, ResponseUpdateForumMask.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void aPg() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (eeq && maskInfo != null && !eer) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.vk().getBoolean(new StringBuilder("had_sync_setting_switch").append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("had_sync_setting_switch" + currentAccount, true);
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zO()) {
                        u(14, false);
                    } else {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zR()) {
                            u(2, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zS()) {
                            u(3, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ab()) {
                            u(4, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU()) {
                            u(5, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zT()) {
                            u(1, false);
                        }
                        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                            u(6, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aI(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aI(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aH(z2);
                            boolean z3 = (intValue & 1) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aR(z3);
                            boolean z4 = (intValue & 2) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aS(z4);
                            boolean z5 = (intValue & 4) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aT(z5);
                            TbadkCoreApplication.m411getInst().setPromotedMessage((intValue & 32) == 0);
                            if ((intValue & 256) == 0) {
                            }
                            if (z3 || z4 || z5 || z2 || z) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.zM().dK(300);
                                v(0, true);
                            } else {
                                com.baidu.tbadk.coreExtra.messageCenter.c.zM().dK(0);
                                v(0, false);
                            }
                        }
                        com.baidu.adp.lib.h.k.hy().c(new as());
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    com.baidu.adp.lib.h.k.hy().c(new as());
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.h.aim().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.c.aik().a(currentAccount, str2, false, (com.baidu.tbadk.util.g<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.j.ain().a(currentAccount, str3, false, null);
                    }
                }
                eer = true;
            }
        }
    }

    private static final void u(int i, boolean z) {
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

    public static final void v(int i, boolean z) {
        WindowSwitchResponse windowSwitchResponse = new WindowSwitchResponse();
        windowSwitchResponse.setIsOpen(z);
        windowSwitchResponse.setSwitchType(i);
        MessageManager.getInstance().dispatchResponsedMessage(windowSwitchResponse);
    }
}
