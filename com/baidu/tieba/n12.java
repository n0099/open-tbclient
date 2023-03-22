package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Typeface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class n12 extends z02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public float b;
    public boolean c;
    public boolean d;

    public n12() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "sans-serif";
        this.b = kl3.g(10.0f);
        this.c = false;
        this.d = false;
    }

    @Override // com.baidu.tieba.z02
    public void a(a12 a12Var, Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, a12Var, canvas) == null) {
            if (this.c && this.d) {
                i = 3;
            } else if (this.c) {
                i = 1;
            } else if (this.d) {
                i = 2;
            } else {
                i = 0;
            }
            a12Var.e.setTypeface(Typeface.create(this.a, i));
            a12Var.e.setTextSize(this.b);
        }
    }

    @Override // com.baidu.tieba.z02
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains("italic")) {
                            this.d = true;
                        } else if (str.contains("oblique")) {
                            this.d = true;
                        } else if (str.contains("bold")) {
                            this.c = true;
                        } else if (!str.contains("normal")) {
                            if (Character.isDigit(str.charAt(0))) {
                                int length = str.length();
                                int i = 0;
                                while (true) {
                                    if (i >= str.length()) {
                                        break;
                                    } else if (!Character.isDigit(str.charAt(i))) {
                                        length = i;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                this.b = kl3.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.a = str;
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
}
