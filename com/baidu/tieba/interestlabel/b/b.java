package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> fjv;
    private List<Integer> fjw;
    private List<a> fjz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.I(dataRes.sex_taglist)) {
                this.fjz = new ArrayList();
                o(this.fjz, dataRes.sex_taglist);
            }
            if (!v.I(dataRes.taglist)) {
                this.fjv = new ArrayList();
                this.fjw = new ArrayList();
                o(this.fjv, dataRes.taglist);
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
                    if (this.fjw != null && aVar.isFollow) {
                        this.fjw.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aXb() {
        return this.fjz;
    }

    public List<a> aXc() {
        return this.fjv;
    }

    public List<Integer> aXd() {
        return this.fjw;
    }
}
