package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes23.dex */
public class b {
    private List<a> kve;
    private List<Integer> kvf;
    private List<a> kvi;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kvi = new ArrayList();
                A(this.kvi, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kve = new ArrayList();
                this.kvf = new ArrayList();
                A(this.kve, dataRes.taglist);
            }
        }
    }

    private void A(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kvf != null && aVar.isFollow) {
                        this.kvf.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cVF() {
        return this.kvi;
    }

    public List<a> cVG() {
        return this.kve;
    }

    public List<Integer> cVH() {
        return this.kvf;
    }
}
