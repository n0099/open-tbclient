package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> fbi;
    private List<Integer> fbj;
    private List<a> fbm;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.J(dataRes.sex_taglist)) {
                this.fbm = new ArrayList();
                o(this.fbm, dataRes.sex_taglist);
            }
            if (!v.J(dataRes.taglist)) {
                this.fbi = new ArrayList();
                this.fbj = new ArrayList();
                o(this.fbi, dataRes.taglist);
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
                    if (this.fbj != null && aVar.isFollow) {
                        this.fbj.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aVM() {
        return this.fbm;
    }

    public List<a> aVN() {
        return this.fbi;
    }

    public List<Integer> aVO() {
        return this.fbj;
    }
}
