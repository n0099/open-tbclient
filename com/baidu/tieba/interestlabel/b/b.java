package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes22.dex */
public class b {
    private List<a> jTH;
    private List<Integer> jTI;
    private List<a> jTL;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.jTL = new ArrayList();
                x(this.jTL, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.jTH = new ArrayList();
                this.jTI = new ArrayList();
                x(this.jTH, dataRes.taglist);
            }
        }
    }

    private void x(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.jTI != null && aVar.isFollow) {
                        this.jTI.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cOQ() {
        return this.jTL;
    }

    public List<a> cOR() {
        return this.jTH;
    }

    public List<Integer> cOS() {
        return this.jTI;
    }
}
