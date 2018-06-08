package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eEA;
    private List<Integer> eEB;
    private List<a> eEE;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!w.z(dataRes.sex_taglist)) {
                this.eEE = new ArrayList();
                o(this.eEE, dataRes.sex_taglist);
            }
            if (!w.z(dataRes.taglist)) {
                this.eEA = new ArrayList();
                this.eEB = new ArrayList();
                o(this.eEA, dataRes.taglist);
            }
        }
    }

    private void o(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.eEB != null && aVar.isFollow) {
                        this.eEB.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aOH() {
        return this.eEE;
    }

    public List<a> aOI() {
        return this.eEA;
    }

    public List<Integer> aOJ() {
        return this.eEB;
    }
}
