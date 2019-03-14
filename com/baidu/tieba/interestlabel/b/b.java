package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> gDm;
    private List<Integer> gDn;
    private List<a> gDq;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.T(dataRes.sex_taglist)) {
                this.gDq = new ArrayList();
                n(this.gDq, dataRes.sex_taglist);
            }
            if (!v.T(dataRes.taglist)) {
                this.gDm = new ArrayList();
                this.gDn = new ArrayList();
                n(this.gDm, dataRes.taglist);
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
                    if (this.gDn != null && aVar.isFollow) {
                        this.gDn.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> byU() {
        return this.gDq;
    }

    public List<a> byV() {
        return this.gDm;
    }

    public List<Integer> byW() {
        return this.gDn;
    }
}
