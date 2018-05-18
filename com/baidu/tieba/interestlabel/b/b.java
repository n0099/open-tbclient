package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> etk;
    private List<Integer> etl;
    private List<a> eto;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.w(dataRes.sex_taglist)) {
                this.eto = new ArrayList();
                n(this.eto, dataRes.sex_taglist);
            }
            if (!v.w(dataRes.taglist)) {
                this.etk = new ArrayList();
                this.etl = new ArrayList();
                n(this.etk, dataRes.taglist);
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
                    if (this.etl != null && aVar.isFollow) {
                        this.etl.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aJL() {
        return this.eto;
    }

    public List<a> aJM() {
        return this.etk;
    }

    public List<Integer> aJN() {
        return this.etl;
    }
}
