package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes23.dex */
public class b {
    private List<a> kiH;
    private List<Integer> kiI;
    private List<a> kiL;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kiL = new ArrayList();
                x(this.kiL, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kiH = new ArrayList();
                this.kiI = new ArrayList();
                x(this.kiH, dataRes.taglist);
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
                    if (this.kiI != null && aVar.isFollow) {
                        this.kiI.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cSy() {
        return this.kiL;
    }

    public List<a> cSz() {
        return this.kiH;
    }

    public List<Integer> cSA() {
        return this.kiI;
    }
}
