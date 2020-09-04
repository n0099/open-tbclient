package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes17.dex */
public class b {
    private List<a> jLf;
    private List<Integer> jLg;
    private List<a> jLj;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.jLj = new ArrayList();
                w(this.jLj, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.jLf = new ArrayList();
                this.jLg = new ArrayList();
                w(this.jLf, dataRes.taglist);
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
                    if (this.jLg != null && aVar.isFollow) {
                        this.jLg.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cLk() {
        return this.jLj;
    }

    public List<a> cLl() {
        return this.jLf;
    }

    public List<Integer> cLm() {
        return this.jLg;
    }
}
