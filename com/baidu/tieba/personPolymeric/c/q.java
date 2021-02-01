package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bt;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes8.dex */
public class q {
    public int har;
    public int jWd;
    public List<User> mBO;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mBO = dataRes.recom_user_list;
            this.jWd = dataRes.has_more.intValue();
            this.har = dataRes.current_page.intValue();
        }
    }

    public bt dyH() {
        bt btVar = new bt();
        btVar.ePz = false;
        btVar.bp(this.mBO);
        return btVar;
    }
}
