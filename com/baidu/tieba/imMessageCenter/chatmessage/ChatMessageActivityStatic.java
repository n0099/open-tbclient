package com.baidu.tieba.imMessageCenter.chatmessage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class ChatMessageActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(ChatMessageActivityConfig.class, ChatMessageActivity.class);
        Jf();
    }

    private static void Jf() {
        ba.vt().a(new b());
    }
}
