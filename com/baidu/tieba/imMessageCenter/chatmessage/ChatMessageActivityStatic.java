package com.baidu.tieba.imMessageCenter.chatmessage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class ChatMessageActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(ChatMessageActivityConfig.class, ChatMessageActivity.class);
        Kk();
    }

    private static void Kk() {
        bb.wn().a(new b());
    }
}
