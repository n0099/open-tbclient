package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static volatile l fYX;
    private final Map<Long, UserStoryData> fYV = new HashMap();
    private MetaData fYW;

    private l() {
    }

    public static l bof() {
        if (fYX == null) {
            synchronized (l.class) {
                if (fYX == null) {
                    fYX = new l();
                }
            }
        }
        return fYX;
    }

    public void a(long j, UserStoryData userStoryData) {
        this.fYV.put(Long.valueOf(j), userStoryData);
    }

    public void c(MetaData metaData) {
        this.fYW = metaData;
    }

    public MetaData bog() {
        return this.fYW;
    }

    public UserStoryData cG(long j) {
        return this.fYV.get(Long.valueOf(j));
    }

    public void clear() {
        this.fYV.clear();
        this.fYW = null;
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

    public int boh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), 0);
    }

    public void boi() {
        sW(0);
    }

    public void sW(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), i);
    }
}
