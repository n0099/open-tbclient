package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bt;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes7.dex */
public class q {
    public int hco;
    public int jYt;
    public List<User> mEj;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mEj = dataRes.recom_user_list;
            this.jYt = dataRes.has_more.intValue();
            this.hco = dataRes.current_page.intValue();
        }
    }

    public bt dyX() {
        bt btVar = new bt();
        btVar.eRa = false;
        btVar.bp(this.mEj);
        return btVar;
    }
}
