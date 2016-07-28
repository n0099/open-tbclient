package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class f extends t<Boolean> {
    private final /* synthetic */ PersonalChatMessage cYX;
    final /* synthetic */ e dfG;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dfG = eVar;
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
