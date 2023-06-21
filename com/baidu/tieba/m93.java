package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.z93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static m93 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public HashMap<String, n93> b;
    public List<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947927458, "Lcom/baidu/tieba/m93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947927458, "Lcom/baidu/tieba/m93;");
                return;
            }
        }
        d = js1.a;
    }

    public m93() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new ArrayList();
    }

    public static m93 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (m93.class) {
                    if (e == null) {
                        e = new m93();
                    }
                }
            }
            return e;
        }
        return (m93) invokeV.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> list = this.c;
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        n93 n93Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HashMap<String, n93> hashMap = this.b;
            if (hashMap != null && (n93Var = hashMap.get(str)) != null) {
                return n93Var.a();
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (d) {
                Log.d("EmojiInfoManager", "get emoji info from " + str);
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String E = ds4.E(new File(str + File.separator + "emoji.json"));
                if (TextUtils.isEmpty(E)) {
                    if (d) {
                        Log.d("EmojiInfoManager", "读取emoji配置文件失败");
                        return;
                    }
                    return;
                }
                try {
                    JSONArray optJSONArray = new JSONObject(E).optJSONArray("packages");
                    if (optJSONArray == null) {
                        return;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return;
                    }
                    String optString = optJSONObject.optString("package_icon");
                    if (!TextUtils.isEmpty(optString)) {
                        this.a = BitmapFactory.decodeFile(str + File.separator + optString);
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("emoticons");
                    this.c.clear();
                    this.b.clear();
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray2.get(i);
                            String optString2 = jSONObject.optString("id");
                            String optString3 = jSONObject.optString("text");
                            String optString4 = jSONObject.optString("icon");
                            Bitmap decodeFile = BitmapFactory.decodeFile(str + File.separator + optString4);
                            if (!TextUtils.isEmpty(optString3) && decodeFile != null) {
                                this.c.add(optString3);
                                this.b.put(optString3, new n93(optString2, optString3, decodeFile));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (d) {
                Log.d("EmojiInfoManager", "文件路径错误");
            }
        }
    }

    public SpannableString g(Context context, CharSequence charSequence, TextView textView) {
        InterceptResult invokeLLL;
        Object aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, charSequence, textView)) == null) {
            if (d) {
                Log.d("EmojiInfoManager", "parseEmotion in UI thread, use cache");
            }
            SpannableString spannableString = new SpannableString(charSequence);
            Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                Bitmap a = c().a(group);
                if (a == null) {
                    break;
                }
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, textSize, textSize, true);
                if (createScaledBitmap != null) {
                    if (textView instanceof EditText) {
                        aVar = new z93.b(context.getApplicationContext(), createScaledBitmap);
                    } else {
                        aVar = new z93.a(context.getApplicationContext(), createScaledBitmap);
                    }
                    spannableString.setSpan(aVar, start, group.length() + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
