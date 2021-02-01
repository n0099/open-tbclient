package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes8.dex */
public class b {
    private List<a> kXK;
    private List<Integer> kXL;
    private List<a> kXO;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kXO = new ArrayList();
                C(this.kXO, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kXK = new ArrayList();
                this.kXL = new ArrayList();
                C(this.kXK, dataRes.taglist);
            }
        }
    }

    private void C(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kXL != null && aVar.isFollow) {
                        this.kXL.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> daF() {
        return this.kXO;
    }

    public List<a> daG() {
        return this.kXK;
    }

    public List<Integer> daH() {
        return this.kXL;
    }
}
