package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> iVL;
    private List<Integer> iVM;
    private List<a> iVP;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.iVP = new ArrayList();
                r(this.iVP, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.iVL = new ArrayList();
                this.iVM = new ArrayList();
                r(this.iVL, dataRes.taglist);
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
                    if (this.iVM != null && aVar.isFollow) {
                        this.iVM.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> csC() {
        return this.iVP;
    }

    public List<a> csD() {
        return this.iVL;
    }

    public List<Integer> csE() {
        return this.iVM;
    }
}
