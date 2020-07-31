package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes17.dex */
public class b {
    private List<a> jvC;
    private List<Integer> jvD;
    private List<a> jvG;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.sex_taglist)) {
                this.jvG = new ArrayList();
                t(this.jvG, dataRes.sex_taglist);
            }
            if (!x.isEmpty(dataRes.taglist)) {
                this.jvC = new ArrayList();
                this.jvD = new ArrayList();
                t(this.jvC, dataRes.taglist);
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
                    if (this.jvD != null && aVar.isFollow) {
                        this.jvD.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cAr() {
        return this.jvG;
    }

    public List<a> cAs() {
        return this.jvC;
    }

    public List<Integer> cAt() {
        return this.jvD;
    }
}
