package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
public class s {
    public static boolean mb(int i) {
        switch (i) {
            case 0:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zO() && !com.baidu.tbadk.coreExtra.messageCenter.c.zG().zV()) {
                    return false;
                }
                return true;
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zN()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zL()) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    public static int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (mb(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((mb(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (mb(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }
}
