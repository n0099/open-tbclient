package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.data.bp;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes23.dex */
public class q {
    public int gHr;
    public int jsm;
    public List<User> mdX;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mdX = dataRes.recom_user_list;
            this.jsm = dataRes.has_more.intValue();
            this.gHr = dataRes.current_page.intValue();
        }
    }

    public bp dvh() {
        bp bpVar = new bp();
        bpVar.eBg = false;
        bpVar.bk(this.mdX);
        return bpVar;
    }
}
