package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static volatile l fZy;
    private final Map<Long, UserStoryData> fZx = new HashMap();

    private l() {
    }

    public static l boN() {
        if (fZy == null) {
            synchronized (l.class) {
                if (fZy == null) {
                    fZy = new l();
                }
            }
        }
        return fZy;
    }

    public void a(long j, UserStoryData userStoryData) {
        this.fZx.put(Long.valueOf(j), userStoryData);
    }

    public UserStoryData cL(long j) {
        return this.fZx.get(Long.valueOf(j));
    }

    public void clear() {
        this.fZx.clear();
    }

    public boolean a(d dVar, List<MetaData> list, int i, long j, long j2, f fVar) {
        if (u.v(list) || dVar == null) {
            return false;
        }
        int i2 = (i < 0 || i > u.u(list) + (-1)) ? 0 : i;
        ArrayList<MetaData> arrayList = new ArrayList<>();
        MetaData metaData = (MetaData) u.c(list, i2);
        MetaData metaData2 = (MetaData) u.c(list, i2 + 1);
        MetaData metaData3 = (MetaData) u.c(list, i2 - 1);
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

    public int boO() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), 0);
    }

    public void boP() {
        sS(0);
    }

    public void sS(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), i);
    }
}
