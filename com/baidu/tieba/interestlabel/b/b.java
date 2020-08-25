package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes17.dex */
public class b {
    private List<a> jKZ;
    private List<Integer> jLa;
    private List<a> jLd;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.jLd = new ArrayList();
                w(this.jLd, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.jKZ = new ArrayList();
                this.jLa = new ArrayList();
                w(this.jKZ, dataRes.taglist);
            }
        }
    }

    private void w(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.jLa != null && aVar.isFollow) {
                        this.jLa.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cLj() {
        return this.jLd;
    }

    public List<a> cLk() {
        return this.jKZ;
    }

    public List<Integer> cLl() {
        return this.jLa;
    }
}
