package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.erC = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ao aoVar;
        Object obj;
        boolean z;
        ao aoVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.erC.erx;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                aoVar = this.erC.ern;
                aoVar.aIO();
                obj = this.erC.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.fCi;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(r.h.tag_user_mute_visible, true);
                    sparseArray.put(r.h.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(r.h.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(r.h.tag_from) instanceof Integer ? ((Integer) sparseArray.get(r.h.tag_from)).intValue() : 0;
                if (intValue != 0) {
                    if (intValue == 1) {
                        aoVar2 = this.erC.ern;
                        aoVar2.a(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.erC.a(z, sparseArray);
            }
        }
    }
}
