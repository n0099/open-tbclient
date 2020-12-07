package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bq;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes24.dex */
public class q {
    public int gQy;
    public int jFM;
    public List<User> msd;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.msd = dataRes.recom_user_list;
            this.jFM = dataRes.has_more.intValue();
            this.gQy = dataRes.current_page.intValue();
        }
    }

    public bq dAz() {
        bq bqVar = new bq();
        bqVar.eIg = false;
        bqVar.bn(this.msd);
        return bqVar;
    }
}
