package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> gDa;
    private List<Integer> gDb;
    private List<a> gDe;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.T(dataRes.sex_taglist)) {
                this.gDe = new ArrayList();
                n(this.gDe, dataRes.sex_taglist);
            }
            if (!v.T(dataRes.taglist)) {
                this.gDa = new ArrayList();
                this.gDb = new ArrayList();
                n(this.gDa, dataRes.taglist);
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
                    if (this.gDb != null && aVar.isFollow) {
                        this.gDb.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> byR() {
        return this.gDe;
    }

    public List<a> byS() {
        return this.gDa;
    }

    public List<Integer> byT() {
        return this.gDb;
    }
}
