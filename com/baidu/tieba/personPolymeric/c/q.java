package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bq;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes24.dex */
public class q {
    public int gQA;
    public int jFO;
    public List<User> msf;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.msf = dataRes.recom_user_list;
            this.jFO = dataRes.has_more.intValue();
            this.gQA = dataRes.current_page.intValue();
        }
    }

    public bq dAA() {
        bq bqVar = new bq();
        bqVar.eIg = false;
        bqVar.bn(this.msf);
        return bqVar;
    }
}
