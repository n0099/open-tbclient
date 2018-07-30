package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eMk;
    private List<Integer> eMl;
    private List<a> eMo;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!w.z(dataRes.sex_taglist)) {
                this.eMo = new ArrayList();
                o(this.eMo, dataRes.sex_taglist);
            }
            if (!w.z(dataRes.taglist)) {
                this.eMk = new ArrayList();
                this.eMl = new ArrayList();
                o(this.eMk, dataRes.taglist);
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
                    if (this.eMl != null && aVar.isFollow) {
                        this.eMl.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aQn() {
        return this.eMo;
    }

    public List<a> aQo() {
        return this.eMk;
    }

    public List<Integer> aQp() {
        return this.eMl;
    }
}
