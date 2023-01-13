package com.baidu.tieba;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes5.dex */
public class o4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c7<ModelMaterial> a;

    public o4() {
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
        this.a = new c7<>();
    }

    public ModelMaterial a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c7.b<ModelMaterial> it = this.a.iterator();
            while (it.hasNext()) {
                ModelMaterial next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            ModelMaterial modelMaterial = new ModelMaterial();
            modelMaterial.a = str;
            modelMaterial.c = new m3(m3.e);
            this.a.a(modelMaterial);
            return modelMaterial;
        }
        return (ModelMaterial) invokeL.objValue;
    }

    public void b(l3 l3Var) {
        String str;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l3Var) == null) {
            m3 m3Var = m3.e;
            if (l3Var != null && l3Var.c()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(l3Var.m()), 4096);
                String str2 = "default";
                String str3 = null;
                float f2 = 1.0f;
                float f3 = 0.0f;
                m3 m3Var2 = m3Var;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.length() > 0 && readLine.charAt(0) == '\t') {
                            readLine = readLine.substring(1).trim();
                        }
                        String[] split = readLine.split("\\s+");
                        if (split[0].length() != 0 && split[0].charAt(0) != '#') {
                            String lowerCase = split[0].toLowerCase();
                            if (lowerCase.equals("newmtl")) {
                                ModelMaterial modelMaterial = new ModelMaterial();
                                modelMaterial.a = str2;
                                modelMaterial.c = new m3(m3Var);
                                modelMaterial.d = new m3(m3Var2);
                                modelMaterial.h = f2;
                                modelMaterial.g = f3;
                                if (str3 != null) {
                                    e5 e5Var = new e5();
                                    e5Var.d = 2;
                                    e5Var.a = new String(str3);
                                    if (modelMaterial.i == null) {
                                        modelMaterial.i = new c7<>(1);
                                    }
                                    modelMaterial.i.a(e5Var);
                                }
                                this.a.a(modelMaterial);
                                if (split.length <= 1) {
                                    str = "default";
                                } else {
                                    str = split[1].replace(IStringUtil.EXTENSION_SEPARATOR, '_');
                                }
                                str2 = str;
                                m3Var = m3.e;
                                m3Var2 = m3.e;
                                f2 = 1.0f;
                                f3 = 0.0f;
                            } else {
                                if (!lowerCase.equals("kd") && !lowerCase.equals(FunAdSdk.PLATFORM_KS)) {
                                    if (!lowerCase.equals("tr") && !lowerCase.equals("d")) {
                                        if (lowerCase.equals(NotificationStyle.NOTIFICATION_STYLE)) {
                                            f3 = Float.parseFloat(split[1]);
                                        } else if (lowerCase.equals("map_kd")) {
                                            str3 = l3Var.i().a(split[1]).j();
                                        }
                                    }
                                    f2 = Float.parseFloat(split[1]);
                                }
                                float parseFloat = Float.parseFloat(split[1]);
                                float parseFloat2 = Float.parseFloat(split[2]);
                                float parseFloat3 = Float.parseFloat(split[3]);
                                if (split.length > 4) {
                                    f = Float.parseFloat(split[4]);
                                } else {
                                    f = 1.0f;
                                }
                                if (split[0].toLowerCase().equals("kd")) {
                                    m3Var = new m3();
                                    m3Var.d(parseFloat, parseFloat2, parseFloat3, f);
                                } else {
                                    m3Var2 = new m3();
                                    m3Var2.d(parseFloat, parseFloat2, parseFloat3, f);
                                }
                            }
                        }
                    } catch (IOException unused) {
                        return;
                    }
                }
                bufferedReader.close();
                ModelMaterial modelMaterial2 = new ModelMaterial();
                modelMaterial2.a = str2;
                modelMaterial2.c = new m3(m3Var);
                modelMaterial2.d = new m3(m3Var2);
                modelMaterial2.h = f2;
                modelMaterial2.g = f3;
                if (str3 != null) {
                    e5 e5Var2 = new e5();
                    e5Var2.d = 2;
                    e5Var2.a = new String(str3);
                    if (modelMaterial2.i == null) {
                        modelMaterial2.i = new c7<>(1);
                    }
                    modelMaterial2.i.a(e5Var2);
                }
                this.a.a(modelMaterial2);
            }
        }
    }
}
