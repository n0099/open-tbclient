package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes2.dex */
public class c {
    public static boolean ny(int i) {
        switch (i) {
            case 0:
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zh() && !com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zo()) {
                    return false;
                }
                return true;
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zg()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.yZ().ze()) {
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
        if (ny(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((ny(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (ny(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }
}
