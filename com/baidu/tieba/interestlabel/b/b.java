package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class b {
    private List<a> eTA;
    private List<Integer> eTB;
    private List<a> eTE;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.z(dataRes.sex_taglist)) {
                this.eTE = new ArrayList();
                o(this.eTE, dataRes.sex_taglist);
            }
            if (!v.z(dataRes.taglist)) {
                this.eTA = new ArrayList();
                this.eTB = new ArrayList();
                o(this.eTA, dataRes.taglist);
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
                    if (this.eTB != null && aVar.isFollow) {
                        this.eTB.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> aSy() {
        return this.eTE;
    }

    public List<a> aSz() {
        return this.eTA;
    }

    public List<Integer> aSA() {
        return this.eTB;
    }
}
