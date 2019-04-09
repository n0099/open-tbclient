package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> gDb;
    private List<Integer> gDc;
    private List<a> gDf;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.T(dataRes.sex_taglist)) {
                this.gDf = new ArrayList();
                n(this.gDf, dataRes.sex_taglist);
            }
            if (!v.T(dataRes.taglist)) {
                this.gDb = new ArrayList();
                this.gDc = new ArrayList();
                n(this.gDb, dataRes.taglist);
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
                    if (this.gDc != null && aVar.isFollow) {
                        this.gDc.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> byR() {
        return this.gDf;
    }

    public List<a> byS() {
        return this.gDb;
    }

    public List<Integer> byT() {
        return this.gDc;
    }
}
