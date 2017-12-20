package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static volatile l grB;
    private MetaData grA;
    private final Map<Long, UserStoryData> grz = new HashMap();

    private l() {
    }

    public static l bsu() {
        if (grB == null) {
            synchronized (l.class) {
                if (grB == null) {
                    grB = new l();
                }
            }
        }
        return grB;
    }

    public void a(long j, UserStoryData userStoryData) {
        this.grz.put(Long.valueOf(j), userStoryData);
    }

    public void d(MetaData metaData) {
        this.grA = metaData;
    }

    public MetaData bsv() {
        return this.grA;
    }

    public UserStoryData cQ(long j) {
        return this.grz.get(Long.valueOf(j));
    }

    public void clear() {
        this.grz.clear();
        this.grA = null;
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

    public int bsw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), 0);
    }

    public void bsx() {
        tV(0);
    }

    public void tV(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("official_story_segment_last_index"), i);
    }
}
