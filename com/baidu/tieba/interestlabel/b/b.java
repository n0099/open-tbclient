package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> gUs;
    private List<Integer> gUt;
    private List<a> gUw;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.sex_taglist)) {
                this.gUw = new ArrayList();
                n(this.gUw, dataRes.sex_taglist);
            }
            if (!v.aa(dataRes.taglist)) {
                this.gUs = new ArrayList();
                this.gUt = new ArrayList();
                n(this.gUs, dataRes.taglist);
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
                    if (this.gUt != null && aVar.isFollow) {
                        this.gUt.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> bGB() {
        return this.gUw;
    }

    public List<a> bGC() {
        return this.gUs;
    }

    public List<Integer> bGD() {
        return this.gUt;
    }
}
