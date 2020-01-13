package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes8.dex */
public class b {
    private List<a> hSr;
    private List<Integer> hSs;
    private List<a> hSv;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.hSv = new ArrayList();
                r(this.hSv, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.hSr = new ArrayList();
                this.hSs = new ArrayList();
                r(this.hSr, dataRes.taglist);
            }
        }
    }

    private void r(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.hSs != null && aVar.isFollow) {
                        this.hSs.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> bZu() {
        return this.hSv;
    }

    public List<a> bZv() {
        return this.hSr;
    }

    public List<Integer> bZw() {
        return this.hSs;
    }
}
