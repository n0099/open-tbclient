package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.h;
import java.util.LinkedList;
/* loaded from: classes.dex */
class f extends l<Boolean> {
    private final /* synthetic */ PersonalChatMessage bHl;
    final /* synthetic */ e bNS;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bNS = eVar;
        this.bHl = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.TU().a(h.o(this.bHl), this.val$list, false));
    }
}
