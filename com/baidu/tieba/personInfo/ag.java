package com.baidu.tieba.personInfo;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.this$0.eoX;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                DataRes dataRes = aVar.fAd;
                if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                    if (dataRes.is_mute.equals("0")) {
                        this.this$0.eoQ = 0;
                        this.this$0.eoR = dataRes.mute_confirm;
                        str = this.this$0.eoR;
                        if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
                            this.this$0.eoR = "确定禁言？";
                        }
                    } else if (dataRes.is_mute.equals("1")) {
                        this.this$0.eoQ = 1;
                    }
                }
            }
        }
    }
}
