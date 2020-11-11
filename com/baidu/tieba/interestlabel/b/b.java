package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes23.dex */
public class b {
    private List<a> kAZ;
    private List<Integer> kBa;
    private List<a> kBd;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kBd = new ArrayList();
                B(this.kBd, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kAZ = new ArrayList();
                this.kBa = new ArrayList();
                B(this.kAZ, dataRes.taglist);
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
                    if (this.kBa != null && aVar.isFollow) {
                        this.kBa.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cYg() {
        return this.kBd;
    }

    public List<a> cYh() {
        return this.kAZ;
    }

    public List<Integer> cYi() {
        return this.kBa;
    }
}
