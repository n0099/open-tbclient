package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class w {
    private static w fGB = null;
    private HashMap<String, a> fGC = new HashMap<>();

    private w() {
    }

    public static w bhK() {
        if (fGB == null) {
            synchronized (w.class) {
                if (fGB == null) {
                    fGB = new w();
                }
            }
        }
        return fGB;
    }

    public void au(String str, int i) {
        a aVar = this.fGC.get(str);
        if (aVar == null) {
            this.fGC.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.fGC.size() > 20) {
            ArrayList arrayList = new ArrayList(this.fGC.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, a>>() { // from class: com.baidu.tieba.play.w.1
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
                    this.fGC.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fGC.remove(str);
        }
    }

    public int qT(String str) {
        a aVar = this.fGC.get(str);
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
