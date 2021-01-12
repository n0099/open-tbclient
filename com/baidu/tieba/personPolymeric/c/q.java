package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.br;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes7.dex */
public class q {
    public int gXH;
    public int jOB;
    public List<User> msO;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.msO = dataRes.recom_user_list;
            this.jOB = dataRes.has_more.intValue();
            this.gXH = dataRes.current_page.intValue();
        }
    }

    public br dwy() {
        br brVar = new br();
        brVar.eNn = false;
        brVar.bu(this.msO);
        return brVar;
    }
}
