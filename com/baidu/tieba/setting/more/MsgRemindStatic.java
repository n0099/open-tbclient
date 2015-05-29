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
    private static boolean cga = false;
    private static boolean cgb = false;
    private static final com.baidu.adp.framework.listener.e cgc = new an(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private static final CustomMessageListener cgd = new ao(2005016);
    private static final CustomMessageListener cge = new ap(2001318);
    private static MaskInfo maskInfo;

    static {
        MessageManager.getInstance().registerListener(cgd);
        MessageManager.getInstance().registerListener(cgc);
        MessageManager.getInstance().registerListener(cge);
        com.baidu.tieba.tbadkCore.a.a.c(104101, ResponseUpdateMaskMessage.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void aja() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (cga && maskInfo != null && !cgb) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.sl().getBoolean(new StringBuilder("had_sync_setting_switch").append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("had_sync_setting_switch" + currentAccount, true);
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi()) {
                        q(14, false);
                    } else {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl()) {
                            q(2, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm()) {
                            q(3, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
                            q(4, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                            q(5, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn()) {
                            q(1, false);
                        }
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                            q(23, false);
                        }
                        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                            q(6, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().ax(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().ax(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aw(z2);
                            boolean z3 = (intValue & 512) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().az(z3);
                            boolean z4 = (intValue & 1) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aG(z4);
                            boolean z5 = (intValue & 2) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aH(z5);
                            boolean z6 = (intValue & 4) == 0;
                            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aI(z6);
                            TbadkCoreApplication.m411getInst().setPromotedMessage((intValue & 32) == 0);
                            if ((intValue & 256) == 0) {
                            }
                            if (z4 || z5 || z6 || z2 || z || z3) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.wg().cL(300);
                                r(0, true);
                            } else {
                                com.baidu.tbadk.coreExtra.messageCenter.c.wg().cL(0);
                                r(0, false);
                            }
                        }
                        com.baidu.adp.lib.g.l.ht().c(new aq());
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    com.baidu.adp.lib.g.l.ht().c(new aq());
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.h.UP().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.c.UN().a(currentAccount, str2, false, (com.baidu.tieba.im.g<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.j.UQ().a(currentAccount, str3, false, null);
                    }
                }
                cgb = true;
            }
        }
    }

    private static final void q(int i, boolean z) {
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

    public static final void r(int i, boolean z) {
        WindowSwitchResponse windowSwitchResponse = new WindowSwitchResponse();
        windowSwitchResponse.setIsOpen(z);
        windowSwitchResponse.setSwitchType(i);
        MessageManager.getInstance().dispatchResponsedMessage(windowSwitchResponse);
    }
}
