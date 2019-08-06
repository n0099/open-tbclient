package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> hbA;
    private List<Integer> hbB;
    private List<a> hbE;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.sex_taglist)) {
                this.hbE = new ArrayList();
                n(this.hbE, dataRes.sex_taglist);
            }
            if (!v.aa(dataRes.taglist)) {
                this.hbA = new ArrayList();
                this.hbB = new ArrayList();
                n(this.hbA, dataRes.taglist);
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
                    if (this.hbB != null && aVar.isFollow) {
                        this.hbB.add(Integer.valueOf(aVar.bFM));
                    }
                }
            }
        }
    }

    public List<a> bJA() {
        return this.hbE;
    }

    public List<a> bJB() {
        return this.hbA;
    }

    public List<Integer> bJC() {
        return this.hbB;
    }
}
