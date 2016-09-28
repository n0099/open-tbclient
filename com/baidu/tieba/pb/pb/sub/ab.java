package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.exF = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ag agVar;
        Object obj;
        boolean z;
        ag agVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.exF.exD;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                agVar = this.exF.exu;
                agVar.aLg();
                obj = this.exF.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.fWY;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(r.g.tag_user_mute_visible, true);
                    sparseArray.put(r.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(r.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(r.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(r.g.tag_from)).intValue() : 0;
                if (intValue != 0) {
                    if (intValue == 1) {
                        agVar2 = this.exF.exu;
                        agVar2.a(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.exF.a(z, sparseArray);
            }
        }
    }
}
