package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class x {
    private static x fQm = null;
    private HashMap<String, a> fQn = new HashMap<>();

    private x() {
    }

    public static x bjC() {
        if (fQm == null) {
            synchronized (x.class) {
                if (fQm == null) {
                    fQm = new x();
                }
            }
        }
        return fQm;
    }

    public void av(String str, int i) {
        a aVar = this.fQn.get(str);
        if (aVar == null) {
            this.fQn.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.fQn.size() > 20) {
            ArrayList arrayList = new ArrayList(this.fQn.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, a>>() { // from class: com.baidu.tieba.play.x.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: b */
                public int compare(Map.Entry<String, a> entry, Map.Entry<String, a> entry2) {
                    return (int) (entry.getValue().lastUpdateTime - entry2.getValue().lastUpdateTime);
                }
            });
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 10) {
                    this.fQn.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fQn.remove(str);
        }
    }

    public int rs(String str) {
        a aVar = this.fQn.get(str);
        if (aVar != null) {
            return aVar.position;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public long lastUpdateTime;
        public int position;

        public a(int i, long j) {
            this.position = i;
            this.lastUpdateTime = j;
        }
    }
}
