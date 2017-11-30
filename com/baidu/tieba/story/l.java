package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static volatile l goU;
    private final Map<Long, UserStoryData> goS = new HashMap();
    private MetaData goT;

    private l() {
    }

    public static l brP() {
        if (goU == null) {
            synchronized (l.class) {
                if (goU == null) {
                    goU = new l();
                }
            }
        }
        return goU;
    }

    public void a(long j, UserStoryData userStoryData) {
        this.goS.put(Long.valueOf(j), userStoryData);
    }

    public void d(MetaData metaData) {
        this.goT = metaData;
    }

    public MetaData brQ() {
        return this.goT;
    }

    public UserStoryData cP(long j) {
        return this.goS.get(Long.valueOf(j));
    }

    public void clear() {
        this.goS.clear();
        this.goT = null;
    }

    public boolean a(d dVar, List<MetaData> list, int i, long j, long j2, f fVar) {
        if (v.w(list) || dVar == null) {
            return false;
        }
        int i2 = (i < 0 || i > v.v(list) + (-1)) ? 0 : i;
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

    public int brR() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), 0);
    }

    public void brS() {
        tK(0);
    }

    public void tK(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), i);
    }
}
