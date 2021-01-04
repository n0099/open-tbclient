package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.br;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes8.dex */
public class q {
    public int hcn;
    public int jTg;
    public List<User> mxt;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mxt = dataRes.recom_user_list;
            this.jTg = dataRes.has_more.intValue();
            this.hcn = dataRes.current_page.intValue();
        }
    }

    public br dAp() {
        br brVar = new br();
        brVar.eRY = false;
        brVar.bu(this.mxt);
        return brVar;
    }
}
