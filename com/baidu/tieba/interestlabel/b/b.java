package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eMf;
    private List<Integer> eMg;
    private List<a> eMj;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!w.z(dataRes.sex_taglist)) {
                this.eMj = new ArrayList();
                o(this.eMj, dataRes.sex_taglist);
            }
            if (!w.z(dataRes.taglist)) {
                this.eMf = new ArrayList();
                this.eMg = new ArrayList();
                o(this.eMf, dataRes.taglist);
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
                    if (this.eMg != null && aVar.isFollow) {
                        this.eMg.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aQk() {
        return this.eMj;
    }

    public List<a> aQl() {
        return this.eMf;
    }

    public List<Integer> aQm() {
        return this.eMg;
    }
}
