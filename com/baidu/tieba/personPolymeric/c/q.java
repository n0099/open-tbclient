package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bo;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes18.dex */
public class q {
    public int gcq;
    public int iDa;
    public List<User> lnb;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lnb = dataRes.recom_user_list;
            this.iDa = dataRes.has_more.intValue();
            this.gcq = dataRes.current_page.intValue();
        }
    }

    public bo diJ() {
        bo boVar = new bo();
        boVar.eal = false;
        boVar.aM(this.lnb);
        return boVar;
    }
}
