package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
import protobuf.MaskInfo;
/* loaded from: classes.dex */
public class MsgRemindStatic {
    private static boolean bwA = false;
    private static boolean bwB = false;
    private static final com.baidu.adp.framework.listener.e bwC = new as(1001);
    private static final CustomMessageListener bwD = new at(2005016);
    private static final CustomMessageListener bwE = new au(2001315);
    private static MaskInfo maskInfo;

    static {
        MessageManager.getInstance().registerListener(bwD);
        MessageManager.getInstance().registerListener(bwC);
        MessageManager.getInstance().registerListener(bwE);
        com.baidu.tieba.tbadkCore.a.a.c(104101, ResponseUpdateMaskMessage.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VJ() {
        boolean z;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        if (bwA && maskInfo != null && !bwB) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                if ((maskInfo.remindMask == null || maskInfo.shieldStatus == null || maskInfo.remindMask.intValue() != 0 || maskInfo.shieldStatus.intValue() != 0 || com.baidu.tbadk.core.sharedPref.b.oc().getBoolean(new StringBuilder("had_sync_setting_switch").append(currentAccount).toString(), false)) ? false : true) {
                    com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("had_sync_setting_switch" + currentAccount, true);
                    if (!TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
                        s(14, false);
                    } else {
                        if (!TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
                            s(2, false);
                        }
                        if (!TbadkCoreApplication.m255getInst().isMsgNewFansOn()) {
                            s(3, false);
                        }
                        if (!TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                            s(4, false);
                        }
                        if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                            s(5, false);
                        }
                        if (!TbadkCoreApplication.m255getInst().isMsgReplymeOn()) {
                            s(1, false);
                        }
                        if (!TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                            s(23, false);
                        }
                        if (!TbadkCoreApplication.m255getInst().isPromotedMessageOn()) {
                            s(6, false);
                        }
                    }
                } else {
                    if (maskInfo.remindMask != null) {
                        if (maskInfo.remindMask.intValue() == 0) {
                            TbadkCoreApplication.m255getInst().setGroupMsgOn(true);
                            z = true;
                        } else if (maskInfo.remindMask.intValue() == 1) {
                            TbadkCoreApplication.m255getInst().setGroupMsgOn(false);
                            z = false;
                        }
                        num = maskInfo.shieldStatus;
                        if (num != null) {
                            int intValue = num.intValue();
                            boolean z2 = (intValue & 16) == 0;
                            TbadkCoreApplication.m255getInst().setMsgChatOn(z2);
                            boolean z3 = (intValue & 512) == 0;
                            TbadkCoreApplication.m255getInst().setStrangerChatOn(z3);
                            boolean z4 = (intValue & 1) == 0;
                            TbadkCoreApplication.m255getInst().setMsgReplymeOn(z4);
                            boolean z5 = (intValue & 2) == 0;
                            TbadkCoreApplication.m255getInst().setMsgAtmeOn(z5);
                            boolean z6 = (intValue & 4) == 0;
                            TbadkCoreApplication.m255getInst().setMsgNewFansOn(z6);
                            TbadkCoreApplication.m255getInst().setPromotedMessage((intValue & 32) == 0);
                            if ((intValue & 256) == 0) {
                            }
                            if (z4 || z5 || z6 || z2 || z || z3 || TbadkCoreApplication.m255getInst().isMsgZanOn()) {
                                TbadkCoreApplication.m255getInst().setMsgFrequency(300);
                                t(0, true);
                            } else {
                                TbadkCoreApplication.m255getInst().setMsgFrequency(0);
                                t(0, false);
                            }
                        }
                        com.baidu.adp.lib.g.l.ek().c(new av());
                    }
                    z = true;
                    num = maskInfo.shieldStatus;
                    if (num != null) {
                    }
                    com.baidu.adp.lib.g.l.ek().c(new av());
                }
                if (!TextUtils.isEmpty(maskInfo.maskFids) && (split3 = maskInfo.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        com.baidu.tieba.im.settingcache.h.To().a(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskGids) && (split2 = maskInfo.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        com.baidu.tieba.im.settingcache.c.Tm().a(currentAccount, str2, false, (com.baidu.tieba.im.g<Void>) null);
                    }
                }
                if (!TextUtils.isEmpty(maskInfo.maskUids) && (split = maskInfo.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        com.baidu.tieba.im.settingcache.j.Tp().a(currentAccount, str3, false, null);
                    }
                }
                bwB = true;
            }
        }
    }

    private static final void s(int i, boolean z) {
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

    public static final void t(int i, boolean z) {
        WindowSwitchResponse windowSwitchResponse = new WindowSwitchResponse();
        windowSwitchResponse.setIsOpen(z);
        windowSwitchResponse.setSwitchType(i);
        MessageManager.getInstance().dispatchResponsedMessage(windowSwitchResponse);
    }
}
