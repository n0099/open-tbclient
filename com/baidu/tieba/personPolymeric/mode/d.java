package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ PersonPolymericModel eIt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonPolymericModel personPolymericModel, int i) {
        super(i);
        this.eIt = personPolymericModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        a aVar;
        int i;
        String str;
        String str2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.eIt.unique_id;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar2 = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                DataRes dataRes = aVar2.fKP;
                if (aVar2.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                    if (dataRes.is_mute.equals("0")) {
                        this.eIt.eGR = 0;
                        this.eIt.eGS = dataRes.mute_confirm;
                        str2 = this.eIt.eGS;
                        if (au.isEmpty(str2)) {
                            this.eIt.eGS = "确定禁言？";
                        }
                    } else if (dataRes.is_mute.equals("1")) {
                        this.eIt.eGR = 1;
                    }
                    aVar = this.eIt.eIr;
                    i = this.eIt.eGR;
                    str = this.eIt.eGS;
                    aVar.a(0, i, str, aVar2.error, aVar2.errorString);
                }
            }
        }
    }
}
