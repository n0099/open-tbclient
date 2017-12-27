package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class z {
    private static z gEL = null;
    private HashMap<String, a> gEM = new HashMap<>();

    private z() {
    }

    public static z bro() {
        if (gEL == null) {
            synchronized (z.class) {
                if (gEL == null) {
                    gEL = new z();
                }
            }
        }
        return gEL;
    }

    public void ay(String str, int i) {
        a aVar = this.gEM.get(str);
        if (aVar == null) {
            this.gEM.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.gEM.size() > 20) {
            ArrayList arrayList = new ArrayList(this.gEM.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, a>>() { // from class: com.baidu.tieba.play.z.1
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
                    this.gEM.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gEM.remove(str);
        }
    }

    public int rD(String str) {
        a aVar = this.gEM.get(str);
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
