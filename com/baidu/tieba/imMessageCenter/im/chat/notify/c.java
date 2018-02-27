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
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hx() || com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HE()) {
            msgChat = newsNotifyMessage.getMsgChat();
            msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
        } else {
            msgStrangerChat = 0;
            msgChat = 0;
        }
        return ((com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HF() ? newsNotifyMessage.getMsgAgree() : 0) + ((msgChat + (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hw() ? newsNotifyMessage.getMsgReplyme() : 0)) + (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hu() ? newsNotifyMessage.getMsgAtme() : 0))) - msgStrangerChat;
    }
}
