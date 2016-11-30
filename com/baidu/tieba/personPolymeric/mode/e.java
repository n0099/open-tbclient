package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ax;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ c eRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.eRn = cVar;
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
            bdUniqueId = this.eRn.unique_id;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar2 = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                DataRes dataRes = aVar2.ges;
                if (aVar2.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                    if (dataRes.is_mute.equals("0")) {
                        this.eRn.ePL = 0;
                        this.eRn.ePM = dataRes.mute_confirm;
                        str2 = this.eRn.ePM;
                        if (ax.isEmpty(str2)) {
                            this.eRn.ePM = "确定禁言？";
                        }
                    } else if (dataRes.is_mute.equals("1")) {
                        this.eRn.ePL = 1;
                    }
                    aVar = this.eRn.eRl;
                    i = this.eRn.ePL;
                    str = this.eRn.ePM;
                    aVar.a(0, i, str, aVar2.error, aVar2.errorString);
                }
            }
        }
    }
}
