package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class b {
    private List<a> hdu;
    private List<Integer> hdv;
    private List<a> hdy;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.sex_taglist)) {
                this.hdy = new ArrayList();
                n(this.hdy, dataRes.sex_taglist);
            }
            if (!v.aa(dataRes.taglist)) {
                this.hdu = new ArrayList();
                this.hdv = new ArrayList();
                n(this.hdu, dataRes.taglist);
            }
        }
    }

    private void n(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.hdv != null && aVar.isFollow) {
                        this.hdv.add(Integer.valueOf(aVar.bGk));
                    }
                }
            }
        }
    }

    public List<a> bKn() {
        return this.hdy;
    }

    public List<a> bKo() {
        return this.hdu;
    }

    public List<Integer> bKp() {
        return this.hdv;
    }
}
