package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> gUB;
    private List<a> gUx;
    private List<Integer> gUy;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.sex_taglist)) {
                this.gUB = new ArrayList();
                n(this.gUB, dataRes.sex_taglist);
            }
            if (!v.aa(dataRes.taglist)) {
                this.gUx = new ArrayList();
                this.gUy = new ArrayList();
                n(this.gUx, dataRes.taglist);
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
                    if (this.gUy != null && aVar.isFollow) {
                        this.gUy.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> bGF() {
        return this.gUB;
    }

    public List<a> bGG() {
        return this.gUx;
    }

    public List<Integer> bGH() {
        return this.gUy;
    }
}
