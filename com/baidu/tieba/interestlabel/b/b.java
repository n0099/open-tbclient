package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> jmY;
    private List<Integer> jmZ;
    private List<a> jnc;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!w.isEmpty(dataRes.sex_taglist)) {
                this.jnc = new ArrayList();
                s(this.jnc, dataRes.sex_taglist);
            }
            if (!w.isEmpty(dataRes.taglist)) {
                this.jmY = new ArrayList();
                this.jmZ = new ArrayList();
                s(this.jmY, dataRes.taglist);
            }
        }
    }

    private void s(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.jmZ != null && aVar.isFollow) {
                        this.jmZ.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cwt() {
        return this.jnc;
    }

    public List<a> cwu() {
        return this.jmY;
    }

    public List<Integer> cwv() {
        return this.jmZ;
    }
}
