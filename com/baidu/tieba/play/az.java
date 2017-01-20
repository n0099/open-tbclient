package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class az {
    private static az eTv = null;
    private HashMap<String, a> eTw = new HashMap<>();

    private az() {
    }

    public static az aYy() {
        if (eTv == null) {
            synchronized (az.class) {
                if (eTv == null) {
                    eTv = new az();
                }
            }
        }
        return eTv;
    }

    public void aw(String str, int i) {
        a aVar = this.eTw.get(str);
        if (aVar == null) {
            this.eTw.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.eTw.size() > 20) {
            ArrayList arrayList = new ArrayList(this.eTw.entrySet());
            Collections.sort(arrayList, new ba(this));
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 10) {
                    this.eTw.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eTw.remove(str);
        }
    }

    public int pE(String str) {
        a aVar = this.eTw.get(str);
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
