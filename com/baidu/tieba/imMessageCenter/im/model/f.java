package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.h;
import java.util.LinkedList;
/* loaded from: classes.dex */
class f extends m<Boolean> {
    private final /* synthetic */ PersonalChatMessage bWM;
    final /* synthetic */ e cdq;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.cdq = eVar;
        this.bWM = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(l.Xr().a(h.o(this.bWM), this.val$list, false));
    }
}
