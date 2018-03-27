package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eXA;
    private List<a> eXw;
    private List<Integer> eXx;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.E(dataRes.sex_taglist)) {
                this.eXA = new ArrayList();
                n(this.eXA, dataRes.sex_taglist);
            }
            if (!v.E(dataRes.taglist)) {
                this.eXw = new ArrayList();
                this.eXx = new ArrayList();
                n(this.eXw, dataRes.taglist);
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
                    if (this.eXx != null && aVar.isFollow) {
                        this.eXx.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aOK() {
        return this.eXA;
    }

    public List<a> aOL() {
        return this.eXw;
    }

    public List<Integer> aOM() {
        return this.eXx;
    }
}
