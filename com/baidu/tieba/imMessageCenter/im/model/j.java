package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class j extends s<Boolean> {
    private final /* synthetic */ PersonalChatMessage cWc;
    final /* synthetic */ i dcM;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dcM = iVar;
        this.cWc = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(l.amU().a(com.baidu.tieba.im.util.h.p(this.cWc), this.val$list, false));
    }
}
