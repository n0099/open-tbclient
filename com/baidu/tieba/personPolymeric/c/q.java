package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bo;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes24.dex */
public class q {
    public int grS;
    public int iZn;
    public List<User> lLk;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lLk = dataRes.recom_user_list;
            this.iZn = dataRes.has_more.intValue();
            this.grS = dataRes.current_page.intValue();
        }
    }

    public bo dpY() {
        bo boVar = new bo();
        boVar.eoA = false;
        boVar.aT(this.lLk);
        return boVar;
    }
}
