package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> iGa;
    private List<Integer> iGb;
    private List<a> iGe;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.iGe = new ArrayList();
                q(this.iGe, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.iGa = new ArrayList();
                this.iGb = new ArrayList();
                q(this.iGa, dataRes.taglist);
            }
        }
    }

    private void q(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.iGb != null && aVar.isFollow) {
                        this.iGb.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> clR() {
        return this.iGe;
    }

    public List<a> clS() {
        return this.iGa;
    }

    public List<Integer> clT() {
        return this.iGb;
    }
}
