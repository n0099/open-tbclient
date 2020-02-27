package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> hUp;
    private List<Integer> hUq;
    private List<a> hUt;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.hUt = new ArrayList();
                r(this.hUt, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.hUp = new ArrayList();
                this.hUq = new ArrayList();
                r(this.hUp, dataRes.taglist);
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
                    if (this.hUq != null && aVar.isFollow) {
                        this.hUq.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> caV() {
        return this.hUt;
    }

    public List<a> caW() {
        return this.hUp;
    }

    public List<Integer> caX() {
        return this.hUq;
    }
}
