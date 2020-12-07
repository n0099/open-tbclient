package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes23.dex */
public class b {
    private List<a> kOG;
    private List<Integer> kOH;
    private List<a> kOK;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kOK = new ArrayList();
                A(this.kOK, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kOG = new ArrayList();
                this.kOH = new ArrayList();
                A(this.kOG, dataRes.taglist);
            }
        }
    }

    private void A(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kOH != null && aVar.isFollow) {
                        this.kOH.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> dcN() {
        return this.kOK;
    }

    public List<a> dcO() {
        return this.kOG;
    }

    public List<Integer> dcP() {
        return this.kOH;
    }
}
