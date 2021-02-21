package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bt;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes8.dex */
public class q {
    public int haF;
    public int jWr;
    public List<User> mCd;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mCd = dataRes.recom_user_list;
            this.jWr = dataRes.has_more.intValue();
            this.haF = dataRes.current_page.intValue();
        }
    }

    public bt dyO() {
        bt btVar = new bt();
        btVar.ePz = false;
        btVar.bp(this.mCd);
        return btVar;
    }
}
