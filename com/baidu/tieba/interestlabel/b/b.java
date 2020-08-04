package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes17.dex */
public class b {
    private List<a> jvE;
    private List<Integer> jvF;
    private List<a> jvI;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.sex_taglist)) {
                this.jvI = new ArrayList();
                t(this.jvI, dataRes.sex_taglist);
            }
            if (!x.isEmpty(dataRes.taglist)) {
                this.jvE = new ArrayList();
                this.jvF = new ArrayList();
                t(this.jvE, dataRes.taglist);
            }
        }
    }

    private void t(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.jvF != null && aVar.isFollow) {
                        this.jvF.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cAr() {
        return this.jvI;
    }

    public List<a> cAs() {
        return this.jvE;
    }

    public List<Integer> cAt() {
        return this.jvF;
    }
}
