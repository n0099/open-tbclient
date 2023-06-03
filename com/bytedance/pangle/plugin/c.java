package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.c.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c {
    public static final g a = g.a();

    public static void a(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.c.a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.c.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.c.a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.c.b(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.c.a(str3));
            jSONObject2.putOpt("timestamp", com.bytedance.pangle.log.c.a(Long.valueOf(System.currentTimeMillis())));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(62:25|(1:184)|29|(1:183)|33|(1:35)|36|(1:182)|40|(43:47|48|(2:50|51)(1:180)|52|(1:54)|55|(1:179)|59|(1:178)|63|(1:65)|66|(1:68)|69|(1:177)|73|(1:176)|77|(3:79|(5:81|(3:86|87|88)|89|90|88)|91)|92|(3:94|(5:96|(3:101|102|103)|104|105|103)|106)|107|(1:175)|111|(3:113|(5:115|(3:120|121|122)|123|124|122)|125)|126|(1:174)|130|(3:132|(5:134|(3:139|140|141)|142|143|141)|144)|145|(1:173)|149|(1:153)|154|(1:172)|158|(1:160)|161|(1:171)|165|166|167|168)|181|48|(0)(0)|52|(0)|55|(1:57)|179|59|(1:61)|178|63|(0)|66|(0)|69|(1:71)|177|73|(1:75)|176|77|(0)|92|(0)|107|(1:109)|175|111|(0)|126|(1:128)|174|130|(0)|145|(1:147)|173|149|(2:151|153)|154|(1:156)|172|158|(0)|161|(1:163)|171|165|166|167|168) */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d5 A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x032a A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x037f A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0410 A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0141 A[Catch: all -> 0x0457, TRY_LEAVE, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0188 A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019b A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022c A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023a A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029d A[Catch: all -> 0x0457, TryCatch #3 {all -> 0x0457, blocks: (B:5:0x000a, B:7:0x001e, B:10:0x003d, B:12:0x0043, B:15:0x0062, B:20:0x0081, B:22:0x0096, B:25:0x00b5, B:30:0x00d0, B:35:0x00fa, B:37:0x010b, B:38:0x010e, B:43:0x0129, B:45:0x0130, B:47:0x0136, B:54:0x0141, B:60:0x0197, B:62:0x019b, B:63:0x01a5, B:68:0x01c2, B:73:0x01ed, B:75:0x022c, B:76:0x0230, B:78:0x023a, B:79:0x023e, B:84:0x025b, B:89:0x028d, B:91:0x029d, B:93:0x02a1, B:95:0x02ab, B:98:0x02b6, B:100:0x02c7, B:99:0x02c3, B:101:0x02d1, B:103:0x02d5, B:105:0x02d9, B:107:0x02e3, B:110:0x02ee, B:112:0x02ff, B:111:0x02fb, B:113:0x0309, B:118:0x0326, B:120:0x032a, B:122:0x032e, B:124:0x0338, B:127:0x0343, B:129:0x0354, B:128:0x0350, B:130:0x035e, B:135:0x037b, B:137:0x037f, B:139:0x0383, B:141:0x038d, B:144:0x0398, B:146:0x03a9, B:145:0x03a5, B:147:0x03b3, B:152:0x03d0, B:154:0x03d4, B:156:0x03dc, B:157:0x03e9, B:162:0x0406, B:164:0x0410, B:165:0x0429, B:169:0x0439, B:161:0x03f9, B:151:0x03c3, B:134:0x036e, B:117:0x0319, B:88:0x0280, B:83:0x024e, B:72:0x01e0, B:67:0x01b5, B:59:0x0188, B:42:0x011c, B:34:0x00ed, B:29:0x00c3, B:19:0x0074, B:55:0x0152), top: B:185:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(String str, final Plugin plugin, StringBuilder sb) {
        boolean z;
        long a2;
        PackageInfo packageArchiveInfo;
        long a3;
        long a4;
        long a5;
        ActivityInfo[] activityInfoArr;
        ServiceInfo[] serviceInfoArr;
        long a6;
        ActivityInfo[] activityInfoArr2;
        long a7;
        ProviderInfo[] providerInfoArr;
        long a8;
        long a9;
        long a10;
        synchronized (c.class) {
            try {
                com.bytedance.pangle.log.b a11 = com.bytedance.pangle.log.b.a(ZeusLogger.TAG_LOAD, "PluginLoader", "load:".concat(String.valueOf(str)));
                if (plugin == null) {
                    sb.append("loadPluginInternal, plugin == null;");
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!", str);
                    return false;
                } else if (!plugin.isInstalled()) {
                    sb.append("loadPluginInternal, !plugin.isInstalled();");
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!", str);
                    return false;
                } else {
                    long a12 = a11.a("isInstalled");
                    if (a12 > 20 || a12 < 0) {
                        sb.append("isInstall cost:");
                        sb.append(a12);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                    String b = com.bytedance.pangle.c.c.b(plugin.mPkgName, plugin.getVersion());
                    if (!new File(b).exists()) {
                        sb.append("loadPluginInternal, sourceApk not exist;");
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!", str);
                        return false;
                    }
                    long a13 = a11.a("getSourceFile");
                    if (a13 > 20 || a13 < 0) {
                        sb.append("getSourceFile cost:");
                        sb.append(a13);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                    File file = new File(com.bytedance.pangle.c.c.d(plugin.mPkgName, plugin.getVersion()));
                    long a14 = a11.a("getNativeLibraryDir");
                    if (a14 > 20 || a14 < 0) {
                        sb.append("getNativeLibraryDir cost:");
                        sb.append(a14);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                    File file2 = new File(file.getParentFile(), "dalvik-cache");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    long a15 = a11.a("dalvikCacheDir");
                    if (a15 > 20 || a15 < 0) {
                        sb.append("dalvikCacheDirTime cost:");
                        sb.append(a15);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                    if (Build.VERSION.SDK_INT < 31 && (Build.VERSION.SDK_INT != 30 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
                        z = false;
                        if (!z) {
                            PluginClassLoader pluginClassLoader = new PluginClassLoader("", file2.getPath(), file.getAbsolutePath(), null);
                            plugin.mClassLoader = pluginClassLoader;
                            MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(pluginClassLoader, b);
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(b)));
                        } else {
                            plugin.mClassLoader = new PluginClassLoader(b, file2.getPath(), file.getAbsolutePath(), null);
                        }
                        if (plugin.mOpenLoadClassOpt) {
                            e.a.execute(new Runnable() { // from class: com.bytedance.pangle.plugin.c.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        Plugin.this.mClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(Plugin.this.mClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        }
                        a2 = a11.a("classloader");
                        if (a2 <= 20 || a2 < 0) {
                            sb.append("classloader cost:");
                            sb.append(a2);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(b, 15);
                        a3 = a11.a("getPackageInfo");
                        if (a3 <= 20 || a3 < 0) {
                            sb.append("getPackageInfo cost:");
                            sb.append(a3);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
                        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
                        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
                        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
                        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
                        plugin.mHostApplicationInfoHookSomeField.sourceDir = b;
                        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
                            packageArchiveInfo.applicationInfo.sourceDir = b;
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
                            packageArchiveInfo.applicationInfo.publicSourceDir = b;
                        }
                        a4 = a11.a("setApplication");
                        if (a4 <= 20 || a4 < 0) {
                            sb.append("setApplication cost:");
                            sb.append(a4);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
                        a5 = a11.a("makeResources");
                        if (a5 <= 20 || a5 < 0) {
                            sb.append("makeResources cost:");
                            sb.append(a5);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.c.2
                            @Override // android.content.ComponentCallbacks
                            public final void onLowMemory() {
                            }

                            @Override // android.content.ComponentCallbacks
                            public final void onConfigurationChanged(Configuration configuration) {
                                Plugin.this.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
                            }
                        });
                        activityInfoArr = packageArchiveInfo.activities;
                        if (activityInfoArr != null) {
                            for (ActivityInfo activityInfo : activityInfoArr) {
                                if (!TextUtils.isEmpty(activityInfo.processName) && activityInfo.processName.contains(":")) {
                                    activityInfo.processName = activityInfo.processName.split(":")[1];
                                    plugin.pluginActivities.put(activityInfo.name, activityInfo);
                                }
                                activityInfo.processName = "main";
                                plugin.pluginActivities.put(activityInfo.name, activityInfo);
                            }
                        }
                        serviceInfoArr = packageArchiveInfo.services;
                        if (serviceInfoArr != null) {
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(":")) {
                                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                                    plugin.pluginServices.put(serviceInfo.name, serviceInfo);
                                }
                                serviceInfo.processName = "main";
                                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
                            }
                        }
                        a6 = a11.a("resolveActivityServices");
                        if (a6 <= 20 || a6 < 0) {
                            sb.append("resolveActivityServices cost:");
                            sb.append(a6);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        activityInfoArr2 = packageArchiveInfo.receivers;
                        if (activityInfoArr2 != null) {
                            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(":")) {
                                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                                    plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
                                }
                                activityInfo2.processName = "main";
                                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
                            }
                        }
                        a7 = a11.a("resolveReceiver");
                        if (a7 <= 20 || a7 < 0) {
                            sb.append("resolveReceiver cost:");
                            sb.append(a7);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        providerInfoArr = packageArchiveInfo.providers;
                        if (providerInfoArr != null) {
                            for (ProviderInfo providerInfo : providerInfoArr) {
                                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                    providerInfo.processName = providerInfo.processName.split(":")[1];
                                    plugin.pluginProvider.put(providerInfo.name, providerInfo);
                                }
                                providerInfo.processName = "main";
                                plugin.pluginProvider.put(providerInfo.name, providerInfo);
                            }
                        }
                        a8 = a11.a("resolveProvider");
                        if (a8 <= 20 || a8 < 0) {
                            sb.append("resolveProvider cost:");
                            sb.append(a8);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        if (plugin.pluginProvider != null && plugin.pluginProvider.size() > 0) {
                            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
                        }
                        a9 = a11.a("installProvider");
                        if (a9 <= 20 || a9 < 0) {
                            sb.append("installProvider cost:");
                            sb.append(a9);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        if (!TextUtils.isEmpty(packageArchiveInfo.applicationInfo.className)) {
                            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageArchiveInfo.applicationInfo.className).newInstance();
                            plugin.mApplication = zeusApplication;
                            zeusApplication.attach(plugin, Zeus.getAppApplication());
                        }
                        a10 = a11.a("makeApplication");
                        if (a10 <= 20 || a10 < 0) {
                            sb.append("makeApplication cost:");
                            sb.append(a10);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        MethodUtils.invokeStaticMethod(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "config", new Object[0]);
                        return true;
                    }
                    z = true;
                    if (!z) {
                    }
                    if (plugin.mOpenLoadClassOpt) {
                    }
                    a2 = a11.a("classloader");
                    if (a2 <= 20) {
                    }
                    sb.append("classloader cost:");
                    sb.append(a2);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(b, 15);
                    a3 = a11.a("getPackageInfo");
                    if (a3 <= 20) {
                    }
                    sb.append("getPackageInfo cost:");
                    sb.append(a3);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
                    ApplicationInfo applicationInfo2 = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
                    plugin.mHostApplicationInfoHookSomeField = applicationInfo2;
                    applicationInfo2.nativeLibraryDir = file.getAbsolutePath();
                    plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
                    plugin.mHostApplicationInfoHookSomeField.sourceDir = b;
                    if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
                    }
                    if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
                    }
                    a4 = a11.a("setApplication");
                    if (a4 <= 20) {
                    }
                    sb.append("setApplication cost:");
                    sb.append(a4);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
                    a5 = a11.a("makeResources");
                    if (a5 <= 20) {
                    }
                    sb.append("makeResources cost:");
                    sb.append(a5);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.c.2
                        @Override // android.content.ComponentCallbacks
                        public final void onLowMemory() {
                        }

                        @Override // android.content.ComponentCallbacks
                        public final void onConfigurationChanged(Configuration configuration) {
                            Plugin.this.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
                        }
                    });
                    activityInfoArr = packageArchiveInfo.activities;
                    if (activityInfoArr != null) {
                    }
                    serviceInfoArr = packageArchiveInfo.services;
                    if (serviceInfoArr != null) {
                    }
                    a6 = a11.a("resolveActivityServices");
                    if (a6 <= 20) {
                    }
                    sb.append("resolveActivityServices cost:");
                    sb.append(a6);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    activityInfoArr2 = packageArchiveInfo.receivers;
                    if (activityInfoArr2 != null) {
                    }
                    a7 = a11.a("resolveReceiver");
                    if (a7 <= 20) {
                    }
                    sb.append("resolveReceiver cost:");
                    sb.append(a7);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    providerInfoArr = packageArchiveInfo.providers;
                    if (providerInfoArr != null) {
                    }
                    a8 = a11.a("resolveProvider");
                    if (a8 <= 20) {
                    }
                    sb.append("resolveProvider cost:");
                    sb.append(a8);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    if (plugin.pluginProvider != null) {
                        ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
                    }
                    a9 = a11.a("installProvider");
                    if (a9 <= 20) {
                    }
                    sb.append("installProvider cost:");
                    sb.append(a9);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    if (!TextUtils.isEmpty(packageArchiveInfo.applicationInfo.className)) {
                    }
                    a10 = a11.a("makeApplication");
                    if (a10 <= 20) {
                    }
                    sb.append("makeApplication cost:");
                    sb.append(a10);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    MethodUtils.invokeStaticMethod(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "config", new Object[0]);
                    return true;
                }
            } catch (Throwable th) {
                sb.append("loadPluginInternal ");
                sb.append(th.getMessage());
                sb.append(ParamableElem.DIVIDE_PARAM);
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", str, th);
                return false;
            }
        }
    }

    public final synchronized boolean a(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        } else if (!plugin.isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
            return false;
        } else if (plugin.isLoaded()) {
            return true;
        } else {
            a.a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.bytedance.pangle.log.b a2 = com.bytedance.pangle.log.b.a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.b.b.g, b.a.x, plugin.mPkgName, plugin.getVersion(), -1L, null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean a3 = a(str, plugin, sb);
            a2.b("loadPluginInternal:".concat(String.valueOf(a3)));
            if (a3) {
                plugin.setLifeCycle(3);
                a(com.bytedance.pangle.b.b.h, b.a.y, plugin.mPkgName, plugin.getVersion(), a2.a(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                a.a(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                sb.append("plugin:");
                sb.append(plugin.mPkgName);
                sb.append(" versionCode:");
                sb.append(plugin.getVersion());
                sb.append("load failed;");
                a(com.bytedance.pangle.b.b.h, b.a.z, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                a.a(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }
}
