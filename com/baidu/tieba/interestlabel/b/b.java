package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> fcD;
    private List<Integer> fcE;
    private List<a> fcH;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.I(dataRes.sex_taglist)) {
                this.fcH = new ArrayList();
                o(this.fcH, dataRes.sex_taglist);
            }
            if (!v.I(dataRes.taglist)) {
                this.fcD = new ArrayList();
                this.fcE = new ArrayList();
                o(this.fcD, dataRes.taglist);
            }
        }
    }

    private void o(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.fcE != null && aVar.isFollow) {
                        this.fcE.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aVj() {
        return this.fcH;
    }

    public List<a> aVk() {
        return this.fcD;
    }

    public List<Integer> aVl() {
        return this.fcE;
    }
}
