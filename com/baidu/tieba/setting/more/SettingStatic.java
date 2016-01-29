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
    private static boolean dLQ = false;
    private static boolean dLR = false;
    private static final com.baidu.adp.framework.listener.e cbI = new am(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private static final CustomMessageListener aJI = new an(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private static final CustomMessageListener dLS = new ao(CmdConfigCustom.CMD_SETTING_READ_FINISH);

    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AccountSafeSettingActivityConfig.class, AccountSafeActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(SapiWebViewActivityConfig.class, SapiWebViewActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MORE, new ap());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(303016, ResponsedPrivacySocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, com.baidu.tieba.tbadkCore.a.a.am(TbConfig.GET_PRIVATE_INFO, 303016));
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(aJI);
        MessageManager.getInstance().registerListener(cbI);
        MessageManager.getInstance().registerListener(dLS);
        com.baidu.tieba.tbadkCore.a.a.c(104101, ResponseUpdateMaskMessage.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void aIr() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (dLQ && maskInfo != null && !dLR) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.uO().getBoolean(new StringBuilder("had_sync_setting_switch").append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("had_sync_setting_switch" + currentAccount, true);
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zm()) {
                        u(14, false);
                    } else {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zp()) {
                            u(2, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zq()) {
                            u(3, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zz()) {
                            u(4, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs()) {
                            u(5, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zr()) {
                            u(1, false);
                        }
                        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                            u(6, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aD(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aD(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aC(z2);
                            boolean z3 = (intValue & 1) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aM(z3);
                            boolean z4 = (intValue & 2) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aN(z4);
                            boolean z5 = (intValue & 4) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aO(z5);
                            TbadkCoreApplication.m411getInst().setPromotedMessage((intValue & 32) == 0);
                            if ((intValue & 256) == 0) {
                            }
                            if (z3 || z4 || z5 || z2 || z) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.zk().dH(300);
                                v(0, true);
                            } else {
                                com.baidu.tbadk.coreExtra.messageCenter.c.zk().dH(0);
                                v(0, false);
                            }
                        }
                        com.baidu.adp.lib.h.k.hs().c(new aq());
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    com.baidu.adp.lib.h.k.hs().c(new aq());
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.h.aeT().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.c.aeR().a(currentAccount, str2, false, (com.baidu.tbadk.util.d<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.j.aeU().a(currentAccount, str3, false, null);
                    }
                }
                dLR = true;
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
