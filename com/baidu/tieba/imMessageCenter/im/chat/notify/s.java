package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes2.dex */
public class s {
    public static boolean mz(int i) {
        switch (i) {
            case 0:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zl() && !com.baidu.tbadk.coreExtra.messageCenter.c.zd().zs()) {
                    return false;
                }
                return true;
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zk()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zi()) {
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
        if (mz(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((mz(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (mz(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }
}
