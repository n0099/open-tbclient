package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes2.dex */
public class c {
    public static boolean qM(int i) {
        switch (i) {
            case 0:
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GR() && !com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GY()) {
                    return false;
                }
                return true;
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GQ()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GO()) {
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
        if (qM(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((qM(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (qM(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }
}
