package com.baidu.tieba.pb.data;

import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class r {
    public String forum_top_list;
    public final List<PostData> kGS = new ArrayList();
    public final List<Long> kGT = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }
}
