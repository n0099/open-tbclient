package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends v<Boolean> {
    final /* synthetic */ ChatVoiceView dcX;
    private final /* synthetic */ OfficialChatMessage dcZ;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dcX = chatVoiceView;
        this.dcZ = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(l.anC().a(com.baidu.tieba.im.util.h.p(this.dcZ), this.val$list, false));
    }
}
