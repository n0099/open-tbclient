package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> fmm;
    private List<Integer> fmn;
    private List<a> fmq;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.I(dataRes.sex_taglist)) {
                this.fmq = new ArrayList();
                o(this.fmq, dataRes.sex_taglist);
            }
            if (!v.I(dataRes.taglist)) {
                this.fmm = new ArrayList();
                this.fmn = new ArrayList();
                o(this.fmm, dataRes.taglist);
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
                    if (this.fmn != null && aVar.isFollow) {
                        this.fmn.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aXO() {
        return this.fmq;
    }

    public List<a> aXP() {
        return this.fmm;
    }

    public List<Integer> aXQ() {
        return this.fmn;
    }
}
