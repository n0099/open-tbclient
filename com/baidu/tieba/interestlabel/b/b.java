package com.baidu.tieba.interestlabel.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes7.dex */
public class b {
    private List<a> kPI;
    private List<Integer> kPJ;
    private List<a> kPM;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.sex_taglist)) {
                this.kPM = new ArrayList();
                D(this.kPM, dataRes.sex_taglist);
            }
            if (!x.isEmpty(dataRes.taglist)) {
                this.kPI = new ArrayList();
                this.kPJ = new ArrayList();
                D(this.kPI, dataRes.taglist);
            }
        }
    }

    private void D(List<a> list, List<ResponseTagInfo> list2) {
        if (list != null && list2 != null) {
            for (ResponseTagInfo responseTagInfo : list2) {
                if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                    a aVar = new a();
                    aVar.a(responseTagInfo);
                    list.add(aVar);
                    if (this.kPJ != null && aVar.isFollow) {
                        this.kPJ.add(Integer.valueOf(aVar.labelId));
                    }
                }
            }
        }
    }

    public List<a> cYH() {
        return this.kPM;
    }

    public List<a> cYI() {
        return this.kPI;
    }

    public List<Integer> cYJ() {
        return this.kPJ;
    }
}
