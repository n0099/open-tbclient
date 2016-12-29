package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        er erVar;
        Object obj;
        er erVar2;
        boolean z = false;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.eah.dZB;
            if (tag == bdUniqueId) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                erVar = this.eah.dZk;
                erVar.aHa();
                obj = this.eah.mExtra;
                SparseArray<Object> sparseArray = (SparseArray) obj;
                DataRes dataRes = aVar.ftm;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.av.isEmpty(str)) {
                        sparseArray.put(r.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(r.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(r.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(r.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(r.g.tag_from)).intValue();
                if (intValue == 0) {
                    this.eah.a(z, sparseArray);
                } else if (intValue == 1) {
                    erVar2 = this.eah.dZk;
                    erVar2.a(sparseArray, z);
                }
            }
        }
    }
}
