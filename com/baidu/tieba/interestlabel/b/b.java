package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> ese;
    private List<Integer> esf;
    private List<a> esi;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.w(dataRes.sex_taglist)) {
                this.esi = new ArrayList();
                n(this.esi, dataRes.sex_taglist);
            }
            if (!v.w(dataRes.taglist)) {
                this.ese = new ArrayList();
                this.esf = new ArrayList();
                n(this.ese, dataRes.taglist);
            }
        }
    }

    private void n(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.esf != null && aVar.isFollow) {
                        this.esf.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aJM() {
        return this.esi;
    }

    public List<a> aJN() {
        return this.ese;
    }

    public List<Integer> aJO() {
        return this.esf;
    }
}
