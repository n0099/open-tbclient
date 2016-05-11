package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId dZZ = BdUniqueId.gen();
    public List<j> eaa = null;
    public List<j> eab = null;

    public static k f(DataRes.Builder builder) {
        if (builder == null || builder.age_sex == null) {
            return null;
        }
        if ((builder.age_sex.sex_tag == null || builder.age_sex.sex_tag.size() == 0) && (builder.age_sex.age_tag == null || builder.age_sex.age_tag.size() == 0)) {
            return null;
        }
        k kVar = new k();
        kVar.eaa = new ArrayList();
        kVar.eab = new ArrayList();
        if (builder.age_sex.sex_tag != null && builder.age_sex.sex_tag.size() == 2) {
            j a = j.a(builder.age_sex.sex_tag.get(0));
            j a2 = j.a(builder.age_sex.sex_tag.get(1));
            if (a != null && a2 != null) {
                kVar.eaa.add(a);
                kVar.eaa.add(a2);
            }
        }
        if (builder.age_sex.age_tag != null && builder.age_sex.age_tag.size() > 0) {
            for (int i = 0; i < builder.age_sex.age_tag.size() && i < 5; i++) {
                j a3 = j.a(builder.age_sex.age_tag.get(i));
                if (a3 != null) {
                    kVar.eab.add(a3);
                }
            }
        }
        return kVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dZZ;
    }
}
