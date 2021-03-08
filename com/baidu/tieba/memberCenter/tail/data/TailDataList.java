package com.baidu.tieba.memberCenter.tail.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class TailDataList implements Serializable {
    private static final long serialVersionUID = 5535689487690791648L;
    private List<TailData> mTails;

    public TailDataList(List<TailData> list) {
        if (list != null) {
            this.mTails = list;
        } else {
            this.mTails = new ArrayList();
        }
    }

    public List<TailData> getTails() {
        return this.mTails;
    }
}
