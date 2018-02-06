package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eXu;
    private List<Integer> eXv;
    private List<a> eXy;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.E(dataRes.sex_taglist)) {
                this.eXy = new ArrayList();
                n(this.eXy, dataRes.sex_taglist);
            }
            if (!v.E(dataRes.taglist)) {
                this.eXu = new ArrayList();
                this.eXv = new ArrayList();
                n(this.eXu, dataRes.taglist);
            }
        }
    }

    private void n(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.eXv != null && aVar.isFollow) {
                        this.eXv.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aOK() {
        return this.eXy;
    }

    public List<a> aOL() {
        return this.eXu;
    }

    public List<Integer> aOM() {
        return this.eXv;
    }
}
