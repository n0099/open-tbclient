package com.baidu.tieba.pb.data;

import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class p {
    public String forum_top_list;
    public final List<PostData> kao = new ArrayList();
    public final List<Long> kap = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }
}
