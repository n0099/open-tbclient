package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes2.dex */
public class c {
    public static int a(NewsNotifyMessage newsNotifyMessage) {
        int msgChat;
        int msgStrangerChat;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy() || com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF()) {
            msgChat = newsNotifyMessage.getMsgChat();
            msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
        } else {
            msgStrangerChat = 0;
            msgChat = 0;
        }
        return ((com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG() ? newsNotifyMessage.getMsgAgree() : 0) + ((msgChat + (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hx() ? newsNotifyMessage.getMsgReplyme() : 0)) + (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv() ? newsNotifyMessage.getMsgAtme() : 0))) - msgStrangerChat;
    }
}
