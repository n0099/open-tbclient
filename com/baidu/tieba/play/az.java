package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class az {
    private static az eTq = null;
    private HashMap<String, a> eTr = new HashMap<>();

    private az() {
    }

    public static az aWM() {
        if (eTq == null) {
            synchronized (az.class) {
                if (eTq == null) {
                    eTq = new az();
                }
            }
        }
        return eTq;
    }

    public void ar(String str, int i) {
        a aVar = this.eTr.get(str);
        if (aVar == null) {
            this.eTr.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.eTr.size() > 20) {
            ArrayList arrayList = new ArrayList(this.eTr.entrySet());
            Collections.sort(arrayList, new ba(this));
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 10) {
                    this.eTr.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eTr.remove(str);
        }
    }

    public int oT(String str) {
        a aVar = this.eTr.get(str);
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
