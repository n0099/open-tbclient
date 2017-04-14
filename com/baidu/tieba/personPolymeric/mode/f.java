package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ PersonPolymericModel eGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PersonPolymericModel personPolymericModel, int i) {
        super(i);
        this.eGd = personPolymericModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        a aVar;
        int i;
        String str;
        if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.eGd.unique_id;
            if (tag == bdUniqueId) {
                this.eGd.eEB = 0;
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                aVar = this.eGd.eGb;
                i = this.eGd.eEB;
                str = this.eGd.eEC;
                aVar.a(2, i, str, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
            }
        }
    }
}
