package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
public class s {
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean lu(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS() || com.baidu.tbadk.coreExtra.messageCenter.c.xK().xZ();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xR()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xP()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xP()) {
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
        if (lu(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((lu(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (lu(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }
}
