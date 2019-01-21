package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> fnh;
    private List<Integer> fni;
    private List<a> fnl;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.I(dataRes.sex_taglist)) {
                this.fnl = new ArrayList();
                o(this.fnl, dataRes.sex_taglist);
            }
            if (!v.I(dataRes.taglist)) {
                this.fnh = new ArrayList();
                this.fni = new ArrayList();
                o(this.fnh, dataRes.taglist);
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
                    if (this.fni != null && aVar.isFollow) {
                        this.fni.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aYo() {
        return this.fnl;
    }

    public List<a> aYp() {
        return this.fnh;
    }

    public List<Integer> aYq() {
        return this.fni;
    }
}
