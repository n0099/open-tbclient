package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes23.dex */
public class b {
    private List<a> kOI;
    private List<Integer> kOJ;
    private List<a> kOM;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kOM = new ArrayList();
                A(this.kOM, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kOI = new ArrayList();
                this.kOJ = new ArrayList();
                A(this.kOI, dataRes.taglist);
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
                    if (this.kOJ != null && aVar.isFollow) {
                        this.kOJ.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> dcO() {
        return this.kOM;
    }

    public List<a> dcP() {
        return this.kOI;
    }

    public List<Integer> dcQ() {
        return this.kOJ;
    }
}
