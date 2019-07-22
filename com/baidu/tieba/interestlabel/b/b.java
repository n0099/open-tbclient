package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> haI;
    private List<Integer> haJ;
    private List<a> haM;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.sex_taglist)) {
                this.haM = new ArrayList();
                n(this.haM, dataRes.sex_taglist);
            }
            if (!v.aa(dataRes.taglist)) {
                this.haI = new ArrayList();
                this.haJ = new ArrayList();
                n(this.haI, dataRes.taglist);
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
                    if (this.haJ != null && aVar.isFollow) {
                        this.haJ.add(Integer.valueOf(aVar.bFL));
                    }
                }
            }
        }
    }

    public List<a> bJm() {
        return this.haM;
    }

    public List<a> bJn() {
        return this.haI;
    }

    public List<Integer> bJo() {
        return this.haJ;
    }
}
