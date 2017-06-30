package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        gg ggVar;
        Object obj;
        gg ggVar2;
        boolean z = false;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.ewh.evm;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                ggVar = this.ewh.euU;
                ggVar.Qy();
                obj = this.ewh.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.fZc;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.aw.isEmpty(str)) {
                        sparseArray.put(w.h.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(w.h.tag_user_mute_msg, str);
                    }
                    sparseArray.put(w.h.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(w.h.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(w.h.tag_from)).intValue();
                if (intValue == 0) {
                    this.ewh.a(z, sparseArray);
                } else if (intValue == 1) {
                    ggVar2 = this.ewh.euU;
                    ggVar2.a(sparseArray, z);
                }
            }
        }
    }
}
