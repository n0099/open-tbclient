package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static volatile l gfa;
    private final Map<Long, UserStoryData> geY = new HashMap();
    private MetaData geZ;

    private l() {
    }

    public static l bpW() {
        if (gfa == null) {
            synchronized (l.class) {
                if (gfa == null) {
                    gfa = new l();
                }
            }
        }
        return gfa;
    }

    public void a(long j, UserStoryData userStoryData) {
        this.geY.put(Long.valueOf(j), userStoryData);
    }

    public void e(MetaData metaData) {
        this.geZ = metaData;
    }

    public MetaData bpX() {
        return this.geZ;
    }

    public UserStoryData cG(long j) {
        return this.geY.get(Long.valueOf(j));
    }

    public void clear() {
        this.geY.clear();
        this.geZ = null;
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

    public int bpY() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), 0);
    }

    public void bpZ() {
        tr(0);
    }

    public void tr(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), i);
    }
}
