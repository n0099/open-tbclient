package com.baidu.yuyinala.privatemessage.implugin.ui.theme;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ThemeManager {
    private static ThemeMode oUX = ThemeMode.DAY;
    private static List<a> oUY = new LinkedList();
    private static HashMap<String, HashMap<String, Integer>> oUZ = new HashMap<>();

    /* loaded from: classes4.dex */
    public enum ThemeMode {
        DAY,
        NIGHT
    }

    /* loaded from: classes4.dex */
    public interface a {
    }

    public static int U(Context context, int i) {
        try {
            if (enO() != ThemeMode.DAY && context != null) {
                String resourceEntryName = context.getResources().getResourceEntryName(i);
                String resourceTypeName = context.getResources().getResourceTypeName(i);
                HashMap<String, Integer> hashMap = oUZ.get(resourceTypeName);
                HashMap<String, Integer> hashMap2 = hashMap == null ? new HashMap<>() : hashMap;
                Integer num = hashMap2.get(resourceEntryName + "_night");
                if (num != null && num.intValue() != 0) {
                    return num.intValue();
                }
                try {
                    int identifier = context.getResources().getIdentifier(resourceEntryName + "_night", resourceTypeName, "com.baidu.sumeru.implugin");
                    hashMap2.put(resourceEntryName + "_night", Integer.valueOf(identifier));
                    oUZ.put(resourceTypeName, hashMap2);
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
        if (!oUY.contains(aVar)) {
            oUY.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (oUY.contains(aVar)) {
            oUY.remove(aVar);
        }
    }

    public static ThemeMode enO() {
        return oUX;
    }
}
