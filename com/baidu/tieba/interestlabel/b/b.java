package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> iFU;
    private List<Integer> iFV;
    private List<a> iFY;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.iFY = new ArrayList();
                q(this.iFY, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.iFU = new ArrayList();
                this.iFV = new ArrayList();
                q(this.iFU, dataRes.taglist);
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
                    if (this.iFV != null && aVar.isFollow) {
                        this.iFV.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> clS() {
        return this.iFY;
    }

    public List<a> clT() {
        return this.iFU;
    }

    public List<Integer> clU() {
        return this.iFV;
    }
}
