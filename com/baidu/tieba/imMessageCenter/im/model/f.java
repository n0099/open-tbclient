package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.h;
import java.util.LinkedList;
/* loaded from: classes2.dex */
class f extends v<Boolean> {
    private final /* synthetic */ PersonalChatMessage dba;
    final /* synthetic */ e dfM;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dfM = eVar;
        this.dba = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(m.anD().a(h.p(this.dba), this.val$list, false));
    }
}
