package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu extends CustomMessageListener {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(ct ctVar, int i) {
        super(i);
        this.a = ctVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.model.av avVar;
        bd bdVar;
        com.baidu.tieba.model.av avVar2;
        if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            String content = responseNewFriendUpdateUiMsg.getContent();
            if (!TextUtils.isEmpty(content)) {
                long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                long longValue = Long.valueOf(TbadkApplication.getCurrentAccount()).longValue();
                cb cbVar = new cb();
                cbVar.a = longValue;
                cbVar.b = friendId;
                cbVar.c = content;
                avVar = this.a.e;
                avVar.a().h().add(cbVar);
                bdVar = this.a.l;
                avVar2 = this.a.e;
                bdVar.a(avVar2);
            }
        }
    }
}
