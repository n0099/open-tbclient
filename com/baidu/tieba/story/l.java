package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static volatile l ggc;
    private final Map<Long, UserStoryData> gga = new HashMap();
    private MetaData ggb;

    private l() {
    }

    public static l bqh() {
        if (ggc == null) {
            synchronized (l.class) {
                if (ggc == null) {
                    ggc = new l();
                }
            }
        }
        return ggc;
    }

    public void a(long j, UserStoryData userStoryData) {
        this.gga.put(Long.valueOf(j), userStoryData);
    }

    public void e(MetaData metaData) {
        this.ggb = metaData;
    }

    public MetaData bqi() {
        return this.ggb;
    }

    public UserStoryData cI(long j) {
        return this.gga.get(Long.valueOf(j));
    }

    public void clear() {
        this.gga.clear();
        this.ggb = null;
    }

    public boolean a(d dVar, List<MetaData> list, int i, long j, long j2, f fVar) {
        if (v.v(list) || dVar == null) {
            return false;
        }
        int i2 = (i < 0 || i > v.u(list) + (-1)) ? 0 : i;
        ArrayList<MetaData> arrayList = new ArrayList<>();
        MetaData metaData = (MetaData) v.c(list, i2);
        MetaData metaData2 = (MetaData) v.c(list, i2 + 1);
        MetaData metaData3 = (MetaData) v.c(list, i2 - 1);
        if (metaData != null) {
            arrayList.add(metaData);
        }
        if (metaData2 != null) {
            arrayList.add(metaData2);
        }
        if (metaData3 != null) {
            arrayList.add(metaData3);
        }
        dVar.a(arrayList, i2, j, j2, fVar);
        return true;
    }

    public int bqj() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), 0);
    }

    public void bqk() {
        tu(0);
    }

    public void tu(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), i);
    }
}
