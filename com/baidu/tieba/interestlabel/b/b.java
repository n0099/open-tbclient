package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes7.dex */
public class b {
    private List<a> hOO;
    private List<Integer> hOP;
    private List<a> hOS;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.hOS = new ArrayList();
                r(this.hOS, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.hOO = new ArrayList();
                this.hOP = new ArrayList();
                r(this.hOO, dataRes.taglist);
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
                    if (this.hOP != null && aVar.isFollow) {
                        this.hOP.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> bYl() {
        return this.hOS;
    }

    public List<a> bYm() {
        return this.hOO;
    }

    public List<Integer> bYn() {
        return this.hOP;
    }
}
