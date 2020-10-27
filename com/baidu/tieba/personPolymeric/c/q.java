package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bo;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes24.dex */
public class q {
    public int gBW;
    public int jlH;
    public List<User> lXG;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lXG = dataRes.recom_user_list;
            this.jlH = dataRes.has_more.intValue();
            this.gBW = dataRes.current_page.intValue();
        }
    }

    public bo dtf() {
        bo boVar = new bo();
        boVar.ewX = false;
        boVar.bd(this.lXG);
        return boVar;
    }
}
