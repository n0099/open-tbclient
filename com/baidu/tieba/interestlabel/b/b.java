package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes8.dex */
public class b {
    private List<a> kXY;
    private List<Integer> kXZ;
    private List<a> kYc;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.kYc = new ArrayList();
                C(this.kYc, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.kXY = new ArrayList();
                this.kXZ = new ArrayList();
                C(this.kXY, dataRes.taglist);
            }
        }
    }

    private void C(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kXZ != null && aVar.isFollow) {
                        this.kXZ.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> daM() {
        return this.kYc;
    }

    public List<a> daN() {
        return this.kXY;
    }

    public List<Integer> daO() {
        return this.kXZ;
    }
}
