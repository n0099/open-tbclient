package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.p;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.h;
import java.util.LinkedList;
/* loaded from: classes.dex */
class f extends p<Boolean> {
    private final /* synthetic */ PersonalChatMessage cpP;
    final /* synthetic */ e cwu;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.cwu = eVar;
        this.cpP = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(l.aeE().a(h.o(this.cpP), this.val$list, false));
    }
}
