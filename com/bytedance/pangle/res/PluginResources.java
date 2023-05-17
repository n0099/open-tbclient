package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.i;
import java.util.HashSet;
import java.util.List;
@Keep
/* loaded from: classes8.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        String a = f.a(Zeus.getAppApplication());
        String b = f.b(Zeus.getAppApplication());
        List<String> b2 = i.b();
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(i.a(assets));
        List<String> a2 = i.a(assets2);
        for (String str : b2) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (String str2 : a2) {
            if (!isOtherPlugin(str2, a, b) && !hashSet.contains(str2) && !b2.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        return assets;
    }

    public static boolean isOtherPlugin(String str, String str2, String str3) {
        if (str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            if (TextUtils.isEmpty(str3) || !str.contains(str3)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
