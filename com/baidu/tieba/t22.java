package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class t22 extends q22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public String l;
    public float m;
    public boolean n;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t22(String str) {
        super(str);
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "sans-serif";
        this.m = kl3.g(10.0f);
        this.n = false;
        this.o = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.k = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.o = true;
                    } else if (str2.contains("oblique")) {
                        this.o = true;
                    } else if (str2.contains("bold")) {
                        this.n = true;
                    } else if (!str2.contains("normal")) {
                        if (Character.isDigit(str2.charAt(0))) {
                            int length = str2.length();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= str2.length()) {
                                    break;
                                } else if (!Character.isDigit(str2.charAt(i3))) {
                                    length = i3;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            this.m = kl3.g(Float.parseFloat(str2.substring(0, length)));
                        } else {
                            this.l = str2;
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (do1.a) {
                e.printStackTrace();
            }
        }
    }
}
