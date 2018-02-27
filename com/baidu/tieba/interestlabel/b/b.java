package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eXi;
    private List<Integer> eXj;
    private List<a> eXm;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.E(dataRes.sex_taglist)) {
                this.eXm = new ArrayList();
                n(this.eXm, dataRes.sex_taglist);
            }
            if (!v.E(dataRes.taglist)) {
                this.eXi = new ArrayList();
                this.eXj = new ArrayList();
                n(this.eXi, dataRes.taglist);
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
                    if (this.eXj != null && aVar.isFollow) {
                        this.eXj.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aOJ() {
        return this.eXm;
    }

    public List<a> aOK() {
        return this.eXi;
    }

    public List<Integer> aOL() {
        return this.eXj;
    }
}
