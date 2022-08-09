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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final g a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(10032742, "Lcom/bytedance/pangle/plugin/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(10032742, "Lcom/bytedance/pangle/plugin/c;");
                return;
            }
        }
        a = g.a();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final synchronized boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
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
                    if (plugin.isLoaded()) {
                        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
                        return true;
                    }
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(62:27|(1:186)|31|(1:185)|35|(1:37)|38|(1:184)|42|(43:49|50|(2:52|53)(1:182)|54|(1:56)|57|(1:181)|61|(1:180)|65|(1:67)|68|(1:70)|71|(1:179)|75|(1:178)|79|(3:81|(5:83|(3:88|89|90)|91|92|90)|93)|94|(3:96|(5:98|(3:103|104|105)|106|107|105)|108)|109|(1:177)|113|(3:115|(5:117|(3:122|123|124)|125|126|124)|127)|128|(1:176)|132|(3:134|(5:136|(3:141|142|143)|144|145|143)|146)|147|(1:175)|151|(1:155)|156|(1:174)|160|(1:162)|163|(1:173)|167|168|169|170)|183|50|(0)(0)|54|(0)|57|(1:59)|181|61|(1:63)|180|65|(0)|68|(0)|71|(1:73)|179|75|(1:77)|178|79|(0)|94|(0)|109|(1:111)|177|113|(0)|128|(1:130)|176|132|(0)|147|(1:149)|175|151|(2:153|155)|156|(1:158)|174|160|(0)|163|(1:165)|173|167|168|169|170) */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02d9 A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x032e A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0383 A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0414 A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145 A[Catch: all -> 0x045b, TRY_LEAVE, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018c A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019f A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0230 A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023e A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a1 A[Catch: all -> 0x045b, TryCatch #3 {all -> 0x045b, blocks: (B:7:0x000e, B:9:0x0022, B:12:0x0041, B:14:0x0047, B:17:0x0066, B:22:0x0085, B:24:0x009a, B:27:0x00b9, B:32:0x00d4, B:37:0x00fe, B:39:0x010f, B:40:0x0112, B:45:0x012d, B:47:0x0134, B:49:0x013a, B:56:0x0145, B:62:0x019b, B:64:0x019f, B:65:0x01a9, B:70:0x01c6, B:75:0x01f1, B:77:0x0230, B:78:0x0234, B:80:0x023e, B:81:0x0242, B:86:0x025f, B:91:0x0291, B:93:0x02a1, B:95:0x02a5, B:97:0x02af, B:100:0x02ba, B:102:0x02cb, B:101:0x02c7, B:103:0x02d5, B:105:0x02d9, B:107:0x02dd, B:109:0x02e7, B:112:0x02f2, B:114:0x0303, B:113:0x02ff, B:115:0x030d, B:120:0x032a, B:122:0x032e, B:124:0x0332, B:126:0x033c, B:129:0x0347, B:131:0x0358, B:130:0x0354, B:132:0x0362, B:137:0x037f, B:139:0x0383, B:141:0x0387, B:143:0x0391, B:146:0x039c, B:148:0x03ad, B:147:0x03a9, B:149:0x03b7, B:154:0x03d4, B:156:0x03d8, B:158:0x03e0, B:159:0x03ed, B:164:0x040a, B:166:0x0414, B:167:0x042d, B:171:0x043d, B:163:0x03fd, B:153:0x03c7, B:136:0x0372, B:119:0x031d, B:90:0x0284, B:85:0x0252, B:74:0x01e4, B:69:0x01b9, B:61:0x018c, B:44:0x0120, B:36:0x00f1, B:31:0x00c7, B:21:0x0078, B:57:0x0156), top: B:191:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(String str, Plugin plugin, StringBuilder sb) {
        InterceptResult invokeLLL;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, plugin, sb)) == null) {
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
                                e.a.execute(new Runnable(plugin) { // from class: com.bytedance.pangle.plugin.c.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ Plugin a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {plugin};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = plugin;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            try {
                                                this.a.mClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(this.a.mClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                                            } catch (Throwable unused) {
                                            }
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
                            Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks(plugin) { // from class: com.bytedance.pangle.plugin.c.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Plugin a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {plugin};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = plugin;
                                }

                                @Override // android.content.ComponentCallbacks
                                public final void onConfigurationChanged(Configuration configuration) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, configuration) == null) {
                                        this.a.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
                                    }
                                }

                                @Override // android.content.ComponentCallbacks
                                public final void onLowMemory() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    }
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
                        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks(plugin) { // from class: com.bytedance.pangle.plugin.c.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Plugin a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = objArr;
                                    Object[] objArr = {plugin};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = plugin;
                            }

                            @Override // android.content.ComponentCallbacks
                            public final void onConfigurationChanged(Configuration configuration) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, configuration) == null) {
                                    this.a.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
                                }
                            }

                            @Override // android.content.ComponentCallbacks
                            public final void onLowMemory() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                }
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
        return invokeLLL.booleanValue;
    }

    public static void a(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Long.valueOf(j), str3}) == null) {
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
    }
}
