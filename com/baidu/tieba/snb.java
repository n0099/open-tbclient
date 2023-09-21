package com.baidu.tieba;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes8.dex */
public class snb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str, int i) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException, XmlPullParserException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            AssetManager assetManager = (AssetManager) Class.forName("android.content.res.AssetManager").newInstance();
            XmlResourceParser xmlResourceParser = null;
            try {
                XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser(((Integer) assetManager.getClass().getMethod(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(assetManager, str)).intValue(), "AndroidManifest.xml");
                if (openXmlResourceParser == null) {
                    if (openXmlResourceParser != null) {
                        openXmlResourceParser.close();
                    }
                    return -1;
                }
                while (openXmlResourceParser.next() != 1) {
                    if (openXmlResourceParser.getEventType() == 2 && openXmlResourceParser.getName().equals("uses-sdk")) {
                        for (int i2 = 0; i2 < openXmlResourceParser.getAttributeCount(); i2++) {
                            if (openXmlResourceParser.getAttributeNameResource(i2) == i) {
                                int attributeIntValue = openXmlResourceParser.getAttributeIntValue(i2, -1);
                                if (openXmlResourceParser != null) {
                                    openXmlResourceParser.close();
                                }
                                return attributeIntValue;
                            }
                        }
                        continue;
                    }
                }
                if (openXmlResourceParser != null) {
                    openXmlResourceParser.close();
                }
                return -1;
            } catch (Throwable th) {
                if (0 != 0) {
                    xmlResourceParser.close();
                }
                throw th;
            }
        }
        return invokeLI.intValue;
    }

    public static List<mnb> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 9; i++) {
                arrayList.add(new mnb());
            }
            ((mnb) arrayList.get(0)).c("SDK版本号");
            ((mnb) arrayList.get(1)).c("测试应用");
            ((mnb) arrayList.get(1)).g(context.getPackageName());
            ((mnb) arrayList.get(2)).c("AppID");
            ((mnb) arrayList.get(3)).c("设备id");
            ((mnb) arrayList.get(4)).c(HttpConstants.OS_VERSION);
            ((mnb) arrayList.get(4)).g(Build.VERSION.RELEASE);
            ((mnb) arrayList.get(5)).c(HttpConstants.HTTP_MANUFACTURER);
            ((mnb) arrayList.get(5)).g(Build.MANUFACTURER);
            ((mnb) arrayList.get(6)).c("imei");
            ((mnb) arrayList.get(7)).c("oaid");
            ((mnb) arrayList.get(8)).c("environment");
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    ((mnb) arrayList.get(8)).g("minSdkVersion:" + context.getApplicationInfo().minSdkVersion + "targetSdkVersion:" + context.getApplicationInfo().targetSdkVersion);
                } else {
                    ((mnb) arrayList.get(8)).g("minSdkVersion:" + a(context.getApplicationContext().getPackageResourcePath(), 16843276) + "targetSdkVersion:" + a(context.getApplicationContext().getPackageResourcePath(), 16843376));
                }
            } catch (Exception unused) {
            }
            Cursor cursor = null;
            try {
                try {
                    Cursor b = tnb.b(context, "setting_base_info", new String[]{"_id", "value"}, null, null, null, null, null);
                    if (b == null) {
                        if (b != null) {
                            b.close();
                        }
                        return arrayList;
                    }
                    while (b.moveToNext()) {
                        try {
                            int i2 = b.getInt(b.getColumnIndex("_id"));
                            String string = b.getString(b.getColumnIndex("value"));
                            if (i2 >= 0 && i2 < 9) {
                                ((mnb) arrayList.get(i2)).g(rnb.g(string));
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    if (b != null) {
                        b.close();
                    }
                    return arrayList;
                } catch (Exception unused3) {
                    return arrayList;
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        return (List) invokeL.objValue;
    }
}
