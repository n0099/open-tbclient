package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bo;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes24.dex */
public class q {
    public int gHK;
    public int jrF;
    public List<User> mdF;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mdF = dataRes.recom_user_list;
            this.jrF = dataRes.has_more.intValue();
            this.gHK = dataRes.current_page.intValue();
        }
    }

    public bo dvH() {
        bo boVar = new bo();
        boVar.eCP = false;
        boVar.bk(this.mdF);
        return boVar;
    }
}
