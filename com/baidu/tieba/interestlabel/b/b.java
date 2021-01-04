package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes8.dex */
public class b {
    private List<a> kUn;
    private List<Integer> kUo;
    private List<a> kUr;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.sex_taglist)) {
                this.kUr = new ArrayList();
                D(this.kUr, dataRes.sex_taglist);
            }
            if (!x.isEmpty(dataRes.taglist)) {
                this.kUn = new ArrayList();
                this.kUo = new ArrayList();
                D(this.kUn, dataRes.taglist);
            }
        }
    }

    private void D(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kUo != null && aVar.isFollow) {
                        this.kUo.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> dcy() {
        return this.kUr;
    }

    public List<a> dcz() {
        return this.kUn;
    }

    public List<Integer> dcA() {
        return this.kUo;
    }
}
