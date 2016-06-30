package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.dWP = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        af afVar;
        Object obj;
        boolean z;
        af afVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.dWP.dWN;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                afVar = this.dWP.dWE;
                afVar.aHL();
                obj = this.dWP.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.fAd;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(u.g.tag_user_mute_visible, true);
                    sparseArray.put(u.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(u.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(u.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(u.g.tag_from)).intValue() : 0;
                if (intValue != 0) {
                    if (intValue == 1) {
                        afVar2 = this.dWP.dWE;
                        afVar2.a(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.dWP.a(z, sparseArray);
            }
        }
    }
}
