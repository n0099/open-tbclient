package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> gUv;
    private List<Integer> gUw;
    private List<a> gUz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.sex_taglist)) {
                this.gUz = new ArrayList();
                n(this.gUz, dataRes.sex_taglist);
            }
            if (!v.aa(dataRes.taglist)) {
                this.gUv = new ArrayList();
                this.gUw = new ArrayList();
                n(this.gUv, dataRes.taglist);
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
                    if (this.gUw != null && aVar.isFollow) {
                        this.gUw.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> bGE() {
        return this.gUz;
    }

    public List<a> bGF() {
        return this.gUv;
    }

    public List<Integer> bGG() {
        return this.gUw;
    }
}
