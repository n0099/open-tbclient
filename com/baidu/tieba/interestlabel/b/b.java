package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> iUY;
    private List<Integer> iUZ;
    private List<a> iVc;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.iVc = new ArrayList();
                r(this.iVc, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.iUY = new ArrayList();
                this.iUZ = new ArrayList();
                r(this.iUY, dataRes.taglist);
            }
        }
    }

    private void r(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.iUZ != null && aVar.isFollow) {
                        this.iUZ.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cst() {
        return this.iVc;
    }

    public List<a> csu() {
        return this.iUY;
    }

    public List<Integer> csv() {
        return this.iUZ;
    }
}
