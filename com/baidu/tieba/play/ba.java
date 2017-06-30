package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ba {
    private static ba fmt = null;
    private HashMap<String, a> fmu = new HashMap<>();

    private ba() {
    }

    public static ba bco() {
        if (fmt == null) {
            synchronized (ba.class) {
                if (fmt == null) {
                    fmt = new ba();
                }
            }
        }
        return fmt;
    }

    public void ar(String str, int i) {
        a aVar = this.fmu.get(str);
        if (aVar == null) {
            this.fmu.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.fmu.size() > 20) {
            ArrayList arrayList = new ArrayList(this.fmu.entrySet());
            Collections.sort(arrayList, new bb(this));
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 10) {
                    this.fmu.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fmu.remove(str);
        }
    }

    public int qe(String str) {
        a aVar = this.fmu.get(str);
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
