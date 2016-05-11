package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class i implements v {
    public static final BdUniqueId dZU = BdUniqueId.gen();
    public List<j> dZV = new ArrayList();
    public String dZW;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dZU;
    }

    public static i e(DataRes.Builder builder) {
        j a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        i iVar = new i();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = j.a(tagStruct)) != null) {
                iVar.dZV.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < iVar.dZV.size()) {
                j jVar = iVar.dZV.get(i2);
                if (jVar != null && !StringUtils.isNull(jVar.dZX)) {
                    sb.append(jVar.dZX);
                    if (i2 != iVar.dZV.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                iVar.dZW = sb.toString();
                return iVar;
            }
        }
    }
}
