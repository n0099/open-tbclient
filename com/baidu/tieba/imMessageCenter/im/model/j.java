package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class j extends t<Boolean> {
    private final /* synthetic */ PersonalChatMessage cYX;
    final /* synthetic */ i dfJ;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dfJ = iVar;
        this.cYX = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(l.anF().a(com.baidu.tieba.im.util.h.p(this.cYX), this.val$list, false));
    }
}
