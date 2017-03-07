package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.euQ = newSubPbActivity;
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
            bdUniqueId = this.euQ.euL;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                aoVar = this.euQ.euB;
                aoVar.aIn();
                obj = this.euQ.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.fGL;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(w.h.tag_user_mute_visible, true);
                    sparseArray.put(w.h.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(w.h.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(w.h.tag_from) instanceof Integer ? ((Integer) sparseArray.get(w.h.tag_from)).intValue() : 0;
                if (intValue != 0) {
                    if (intValue == 1) {
                        aoVar2 = this.euQ.euB;
                        aoVar2.a(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.euQ.a(z, sparseArray);
            }
        }
    }
}
