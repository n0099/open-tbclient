package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eIq;
    private List<Integer> eIr;
    private List<a> eIu;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!w.A(dataRes.sex_taglist)) {
                this.eIu = new ArrayList();
                o(this.eIu, dataRes.sex_taglist);
            }
            if (!w.A(dataRes.taglist)) {
                this.eIq = new ArrayList();
                this.eIr = new ArrayList();
                o(this.eIq, dataRes.taglist);
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
                    if (this.eIr != null && aVar.isFollow) {
                        this.eIr.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aPn() {
        return this.eIu;
    }

    public List<a> aPo() {
        return this.eIq;
    }

    public List<Integer> aPp() {
        return this.eIr;
    }
}
