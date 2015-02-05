package com.baidu.tieba.tiebasdk;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.ao;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TiebaSDK implements Serializable {
    private static HashMap<String, Field[]> cdS = new HashMap<>();
    private static final long serialVersionUID = -3424378401905406520L;

    public static void init(Application application) {
        ao.AJ().init(application);
    }

    public static void openBar(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new FrsActivityConfig(context).createNormalCfg(str, null)));
    }

    public static String getBarData(String str) {
        BasicNameValuePair basicNameValuePair;
        ad adVar;
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(TbConfig.SERVER_ADDRESS);
        stringBuffer.append(TbConfig.FRS_ADDRESS);
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", str));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(1)));
        if (ao.AJ().lZ()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        arrayList.add(new BasicNameValuePair("st_type", FrsActivityConfig.FRS_FROM_LIKE));
        try {
            adVar = new ad(stringBuffer.toString());
            adVar.r(arrayList);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return !adVar.oS().qa().lT() ? "" : adVar.or();
    }

    public static void setFrom(String str) {
        TbadkApplication.getInst().setFrom(str);
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
            Field[] fieldArr = cdS.get(packageName);
            if (fieldArr == null) {
                fieldArr = Class.forName(String.valueOf(packageName) + ".R$styleable").getFields();
                cdS.put(packageName, fieldArr);
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
            Field[] fieldArr = cdS.get(packageName);
            if (fieldArr == null) {
                fieldArr = Class.forName(String.valueOf(packageName) + ".R$styleable").getFields();
                cdS.put(packageName, fieldArr);
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
