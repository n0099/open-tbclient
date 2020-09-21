package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bo;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes23.dex */
public class q {
    public int gfD;
    public int iKv;
    public List<User> lvY;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lvY = dataRes.recom_user_list;
            this.iKv = dataRes.has_more.intValue();
            this.gfD = dataRes.current_page.intValue();
        }
    }

    public bo dmo() {
        bo boVar = new bo();
        boVar.ecv = false;
        boVar.aQ(this.lvY);
        return boVar;
    }
}
