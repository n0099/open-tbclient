package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> hWd;
    private List<Integer> hWe;
    private List<a> hWh;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.hWh = new ArrayList();
                q(this.hWh, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.hWd = new ArrayList();
                this.hWe = new ArrayList();
                q(this.hWd, dataRes.taglist);
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
                    if (this.hWe != null && aVar.isFollow) {
                        this.hWe.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cbr() {
        return this.hWh;
    }

    public List<a> cbs() {
        return this.hWd;
    }

    public List<Integer> cbt() {
        return this.hWe;
    }
}
