package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.evy = newSubPbActivity;
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
            bdUniqueId = this.evy.evw;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                agVar = this.evy.evn;
                agVar.aKF();
                obj = this.evy.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.fUV;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(t.g.tag_user_mute_visible, true);
                    sparseArray.put(t.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(t.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(t.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(t.g.tag_from)).intValue() : 0;
                if (intValue != 0) {
                    if (intValue == 1) {
                        agVar2 = this.evy.evn;
                        agVar2.a(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.evy.a(z, sparseArray);
            }
        }
    }
}
