package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes7.dex */
public class b {
    private List<a> laa;
    private List<Integer> lab;
    private List<a> lae;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.sex_taglist)) {
                this.lae = new ArrayList();
                B(this.lae, dataRes.sex_taglist);
            }
            if (!y.isEmpty(dataRes.taglist)) {
                this.laa = new ArrayList();
                this.lab = new ArrayList();
                B(this.laa, dataRes.taglist);
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
                    if (this.lab != null && aVar.isFollow) {
                        this.lab.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> daV() {
        return this.lae;
    }

    public List<a> daW() {
        return this.laa;
    }

    public List<Integer> daX() {
        return this.lab;
    }
}
