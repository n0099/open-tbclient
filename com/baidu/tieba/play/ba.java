package com.baidu.tieba.play;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ba {
    private static ba fcd = null;
    private HashMap<String, a> fce = new HashMap<>();

    private ba() {
    }

    public static ba aYd() {
        if (fcd == null) {
            synchronized (ba.class) {
                if (fcd == null) {
                    fcd = new ba();
                }
            }
        }
        return fcd;
    }

    public void aq(String str, int i) {
        a aVar = this.fce.get(str);
        if (aVar == null) {
            this.fce.put(str, new a(i, System.currentTimeMillis()));
        } else {
            aVar.lastUpdateTime = System.currentTimeMillis();
            aVar.position = i;
        }
        if (this.fce.size() > 20) {
            ArrayList arrayList = new ArrayList(this.fce.entrySet());
            Collections.sort(arrayList, new bb(this));
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 10) {
                    this.fce.remove(((Map.Entry) arrayList.get(i3)).getKey());
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fce.remove(str);
        }
    }

    public int ph(String str) {
        a aVar = this.fce.get(str);
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
