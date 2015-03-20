package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
import protobuf.MaskInfo;
/* loaded from: classes.dex */
public class MsgRemindStatic {
    private static boolean cbj = false;
    private static boolean cbk = false;
    private static final com.baidu.adp.framework.listener.e cbl = new an(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private static final CustomMessageListener cbm = new ao(2005016);
    private static final CustomMessageListener cbn = new ap(2001318);
    private static MaskInfo maskInfo;

    static {
        MessageManager.getInstance().registerListener(cbm);
        MessageManager.getInstance().registerListener(cbl);
        MessageManager.getInstance().registerListener(cbn);
        com.baidu.tieba.tbadkCore.a.a.c(104101, ResponseUpdateMaskMessage.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void agU() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (cbj && maskInfo != null && !cbk) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.rB().getBoolean(new StringBuilder("had_sync_setting_switch").append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("had_sync_setting_switch" + currentAccount, true);
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vs()) {
                        r(14, false);
                    } else {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv()) {
                            r(2, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vw()) {
                            r(3, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF()) {
                            r(4, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
                            r(5, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx()) {
                            r(1, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
                            r(23, false);
                        }
                        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                            r(6, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().aq(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().aq(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().ap(z2);
                            boolean z3 = (intValue & 512) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().as(z3);
                            boolean z4 = (intValue & 1) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().az(z4);
                            boolean z5 = (intValue & 2) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().aA(z5);
                            boolean z6 = (intValue & 4) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.vq().aB(z6);
                            TbadkCoreApplication.m411getInst().setPromotedMessage((intValue & 32) == 0);
                            if ((intValue & 256) == 0) {
                            }
                            if (z4 || z5 || z6 || z2 || z || z3) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.vq().cE(300);
                                s(0, true);
                            } else {
                                com.baidu.tbadk.coreExtra.messageCenter.c.vq().cE(0);
                                s(0, false);
                            }
                        }
                        com.baidu.adp.lib.g.l.hJ().c(new aq());
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    com.baidu.adp.lib.g.l.hJ().c(new aq());
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.h.Tp().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.c.Tn().a(currentAccount, str2, false, (com.baidu.tieba.im.g<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.j.Tq().a(currentAccount, str3, false, null);
                    }
                }
                cbk = true;
            }
        }
    }

    private static final void r(int i, boolean z) {
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

    public static final void s(int i, boolean z) {
        WindowSwitchResponse windowSwitchResponse = new WindowSwitchResponse();
        windowSwitchResponse.setIsOpen(z);
        windowSwitchResponse.setSwitchType(i);
        MessageManager.getInstance().dispatchResponsedMessage(windowSwitchResponse);
    }
}
