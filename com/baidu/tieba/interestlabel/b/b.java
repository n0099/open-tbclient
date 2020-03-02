package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> hUr;
    private List<Integer> hUs;
    private List<a> hUv;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.hUv = new ArrayList();
                r(this.hUv, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.hUr = new ArrayList();
                this.hUs = new ArrayList();
                r(this.hUr, dataRes.taglist);
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
                    if (this.hUs != null && aVar.isFollow) {
                        this.hUs.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> caX() {
        return this.hUv;
    }

    public List<a> caY() {
        return this.hUr;
    }

    public List<Integer> caZ() {
        return this.hUs;
    }
}
