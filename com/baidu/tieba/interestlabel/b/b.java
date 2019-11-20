package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> haG;
    private List<Integer> haH;
    private List<a> haK;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.haK = new ArrayList();
                n(this.haK, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.haG = new ArrayList();
                this.haH = new ArrayList();
                n(this.haG, dataRes.taglist);
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
                    if (this.haH != null && aVar.isFollow) {
                        this.haH.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> bGV() {
        return this.haK;
    }

    public List<a> bGW() {
        return this.haG;
    }

    public List<Integer> bGX() {
        return this.haH;
    }
}
