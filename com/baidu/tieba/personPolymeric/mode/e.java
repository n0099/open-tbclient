package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ba;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ c eIL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.eIL = cVar;
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
            bdUniqueId = this.eIL.unique_id;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar2 = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                DataRes dataRes = aVar2.fUV;
                if (aVar2.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                    if (dataRes.is_mute.equals("0")) {
                        this.eIL.eHi = 0;
                        this.eIL.eHj = dataRes.mute_confirm;
                        str2 = this.eIL.eHj;
                        if (ba.isEmpty(str2)) {
                            this.eIL.eHj = "确定禁言？";
                        }
                    } else if (dataRes.is_mute.equals("1")) {
                        this.eIL.eHi = 1;
                    }
                    aVar = this.eIL.eIJ;
                    i = this.eIL.eHi;
                    str = this.eIL.eHj;
                    aVar.a(0, i, str, aVar2.error, aVar2.errorString);
                }
            }
        }
    }
}
