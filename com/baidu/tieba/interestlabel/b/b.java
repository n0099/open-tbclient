package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes22.dex */
public class b {
    private List<a> kBo;
    private List<Integer> kBp;
    private List<a> kBs;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kBs = new ArrayList();
                B(this.kBs, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kBo = new ArrayList();
                this.kBp = new ArrayList();
                B(this.kBo, dataRes.taglist);
            }
        }
    }

    private void B(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kBp != null && aVar.isFollow) {
                        this.kBp.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cXC() {
        return this.kBs;
    }

    public List<a> cXD() {
        return this.kBo;
    }

    public List<Integer> cXE() {
        return this.kBp;
    }
}
