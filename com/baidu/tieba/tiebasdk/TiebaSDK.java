package com.baidu.tieba.tiebasdk;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.c;
import com.baidu.adp.framework.message.a;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.l;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.p;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TiebaSDK implements Serializable {
    private static HashMap<String, Field[]> a = new HashMap<>();
    private static final long serialVersionUID = -3424378401905406520L;

    public static void init(Application application) {
        p.c().a(application);
    }

    public static void openBar(Context context, String str) {
        c.a().a(new a(2003001, new l(context).a(str, null)));
    }

    public static String getBarData(String str) {
        BasicNameValuePair basicNameValuePair;
        ak akVar;
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(n.a);
        stringBuffer.append("c/f/frs/page");
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", str));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(1)));
        if (p.c().s()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        arrayList.add(new BasicNameValuePair("st_type", "tb_forumlist"));
        try {
            akVar = new ak(stringBuffer.toString());
            akVar.a(arrayList);
        } catch (Exception e) {
            f.b("TiebaSDK.getBarData error = " + e.getMessage());
        }
        return !akVar.a().b().b() ? "" : akVar.i();
    }

    public static void setFrom(String str) {
        TbadkApplication.j();
        TbadkApplication.h(str);
    }

    public static int getResIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "资源文件读取不到！");
        }
        return identifier;
    }

    public static int getDimenIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "dimen", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "dimen资源文件读取不到！");
        }
        return identifier;
    }

    public static int getDrawableIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "drawable资源文件读取不到！");
        }
        return identifier;
    }

    public static int getStringIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "string资源文件读取不到！");
        }
        return identifier;
    }

    public static int getLayoutIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "layout", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "layout资源文件读取不到！");
        }
        return identifier;
    }

    public static int getColorIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "color", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "color资源文件读取不到！");
        }
        return identifier;
    }

    public static int getAnimIdByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "anim", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "anim资源文件读取不到！");
        }
        return identifier;
    }

    public static int getResIdByName(Context context, String str, String str2) {
        int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "资源文件读取不到！");
        }
        return identifier;
    }

    public static int getStyleIDByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "style", context.getPackageName());
        if (identifier == 0) {
            Log.e("TiebaSDK", "style资源文件读取不到！");
        }
        return identifier;
    }

    public static int[] getStyleableIDByName(Context context, String str) {
        try {
            String packageName = context.getPackageName();
            Field[] fieldArr = a.get(packageName);
            if (fieldArr == null) {
                fieldArr = Class.forName(String.valueOf(packageName) + ".R$styleable").getFields();
                a.put(packageName, fieldArr);
            }
            Field[] fieldArr2 = fieldArr;
            for (Field field : fieldArr2) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static int getAttrIDByName(Context context, String str) {
        try {
            String packageName = context.getPackageName();
            Field[] fieldArr = a.get(packageName);
            if (fieldArr == null) {
                fieldArr = Class.forName(String.valueOf(packageName) + ".R$styleable").getFields();
                a.put(packageName, fieldArr);
            }
            Field[] fieldArr2 = fieldArr;
            for (Field field : fieldArr2) {
                if (field.getName().equals(str)) {
                    return field.getInt(null);
                }
            }
        } catch (Throwable th) {
        }
        return -1;
    }
}
