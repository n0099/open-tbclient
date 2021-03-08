package com.baidu.yuyinala.privatemessage.implugin.ui.theme;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class ThemeManager {
    private static ThemeMode pjv = ThemeMode.DAY;
    private static List<a> pjw = new LinkedList();
    private static HashMap<String, HashMap<String, Integer>> pjx = new HashMap<>();

    /* loaded from: classes10.dex */
    public enum ThemeMode {
        DAY,
        NIGHT
    }

    /* loaded from: classes10.dex */
    public interface a {
    }

    public static int U(Context context, int i) {
        try {
            if (emG() != ThemeMode.DAY && context != null) {
                String resourceEntryName = context.getResources().getResourceEntryName(i);
                String resourceTypeName = context.getResources().getResourceTypeName(i);
                HashMap<String, Integer> hashMap = pjx.get(resourceTypeName);
                HashMap<String, Integer> hashMap2 = hashMap == null ? new HashMap<>() : hashMap;
                Integer num = hashMap2.get(resourceEntryName + "_night");
                if (num != null && num.intValue() != 0) {
                    return num.intValue();
                }
                try {
                    int identifier = context.getResources().getIdentifier(resourceEntryName + "_night", resourceTypeName, "com.baidu.sumeru.implugin");
                    hashMap2.put(resourceEntryName + "_night", Integer.valueOf(identifier));
                    pjx.put(resourceTypeName, hashMap2);
                    return identifier;
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            return i;
        } catch (Exception e2) {
            c.e("ThemeManager", e2.getMessage());
            return i;
        }
    }

    public static void a(a aVar) {
        if (!pjw.contains(aVar)) {
            pjw.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (pjw.contains(aVar)) {
            pjw.remove(aVar);
        }
    }

    public static ThemeMode emG() {
        return pjv;
    }
}
