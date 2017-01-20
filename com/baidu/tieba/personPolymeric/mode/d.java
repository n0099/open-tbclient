package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ PersonPolymericModel eEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonPolymericModel personPolymericModel, int i) {
        super(i);
        this.eEG = personPolymericModel;
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
            bdUniqueId = this.eEG.unique_id;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar2 = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                DataRes dataRes = aVar2.fCi;
                if (aVar2.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                    if (dataRes.is_mute.equals("0")) {
                        this.eEG.eDd = 0;
                        this.eEG.eDe = dataRes.mute_confirm;
                        str2 = this.eEG.eDe;
                        if (at.isEmpty(str2)) {
                            this.eEG.eDe = "确定禁言？";
                        }
                    } else if (dataRes.is_mute.equals("1")) {
                        this.eEG.eDd = 1;
                    }
                    aVar = this.eEG.eEE;
                    i = this.eEG.eDd;
                    str = this.eEG.eDe;
                    aVar.a(0, i, str, aVar2.error, aVar2.errorString);
                }
            }
        }
    }
}
