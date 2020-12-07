package com.baidu.tieba.pb.data;

import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class r {
    public String forum_top_list;
    public final List<PostData> lCq = new ArrayList();
    public final List<Long> lCr = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }
}
