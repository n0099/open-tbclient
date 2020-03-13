package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes10.dex */
public class b {
    private List<a> hUD;
    private List<Integer> hUE;
    private List<a> hUH;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.sex_taglist)) {
                this.hUH = new ArrayList();
                r(this.hUH, dataRes.sex_taglist);
            }
            if (!v.isEmpty(dataRes.taglist)) {
                this.hUD = new ArrayList();
                this.hUE = new ArrayList();
                r(this.hUD, dataRes.taglist);
            }
        }
    }

    private void r(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.hUE != null && aVar.isFollow) {
                        this.hUE.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> caY() {
        return this.hUH;
    }

    public List<a> caZ() {
        return this.hUD;
    }

    public List<Integer> cba() {
        return this.hUE;
    }
}
