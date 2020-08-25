package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bo;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes18.dex */
public class q {
    public int gcm;
    public int iCU;
    public List<User> lmQ;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lmQ = dataRes.recom_user_list;
            this.iCU = dataRes.has_more.intValue();
            this.gcm = dataRes.current_page.intValue();
        }
    }

    public bo diG() {
        bo boVar = new bo();
        boVar.eah = false;
        boVar.aM(this.lmQ);
        return boVar;
    }
}
