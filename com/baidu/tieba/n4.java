package com.baidu.tieba;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
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
public class n4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b7<ModelMaterial> a;

    public n4() {
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
        this.a = new b7<>();
    }

    public ModelMaterial a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            b7.b<ModelMaterial> it = this.a.iterator();
            while (it.hasNext()) {
                ModelMaterial next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            ModelMaterial modelMaterial = new ModelMaterial();
            modelMaterial.a = str;
            modelMaterial.c = new l3(l3.e);
            this.a.a(modelMaterial);
            return modelMaterial;
        }
        return (ModelMaterial) invokeL.objValue;
    }

    public void b(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k3Var) == null) {
            l3 l3Var = l3.e;
            if (k3Var == null || !k3Var.c()) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(k3Var.m()), 4096);
            String str = "default";
            String str2 = null;
            float f = 1.0f;
            float f2 = 0.0f;
            l3 l3Var2 = l3Var;
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
                            modelMaterial.a = str;
                            modelMaterial.c = new l3(l3Var);
                            modelMaterial.d = new l3(l3Var2);
                            modelMaterial.h = f;
                            modelMaterial.g = f2;
                            if (str2 != null) {
                                d5 d5Var = new d5();
                                d5Var.d = 2;
                                d5Var.a = new String(str2);
                                if (modelMaterial.i == null) {
                                    modelMaterial.i = new b7<>(1);
                                }
                                modelMaterial.i.a(d5Var);
                            }
                            this.a.a(modelMaterial);
                            str = split.length > 1 ? split[1].replace(IStringUtil.EXTENSION_SEPARATOR, '_') : "default";
                            l3Var = l3.e;
                            l3Var2 = l3.e;
                            f = 1.0f;
                            f2 = 0.0f;
                        } else {
                            if (!lowerCase.equals("kd") && !lowerCase.equals(FunAdSdk.PLATFORM_KS)) {
                                if (!lowerCase.equals("tr") && !lowerCase.equals("d")) {
                                    if (lowerCase.equals(NotificationStyle.NOTIFICATION_STYLE)) {
                                        f2 = Float.parseFloat(split[1]);
                                    } else if (lowerCase.equals("map_kd")) {
                                        str2 = k3Var.i().a(split[1]).j();
                                    }
                                }
                                f = Float.parseFloat(split[1]);
                            }
                            float parseFloat = Float.parseFloat(split[1]);
                            float parseFloat2 = Float.parseFloat(split[2]);
                            float parseFloat3 = Float.parseFloat(split[3]);
                            float parseFloat4 = split.length > 4 ? Float.parseFloat(split[4]) : 1.0f;
                            if (split[0].toLowerCase().equals("kd")) {
                                l3Var = new l3();
                                l3Var.d(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                            } else {
                                l3Var2 = new l3();
                                l3Var2.d(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                            }
                        }
                    }
                } catch (IOException unused) {
                    return;
                }
            }
            bufferedReader.close();
            ModelMaterial modelMaterial2 = new ModelMaterial();
            modelMaterial2.a = str;
            modelMaterial2.c = new l3(l3Var);
            modelMaterial2.d = new l3(l3Var2);
            modelMaterial2.h = f;
            modelMaterial2.g = f2;
            if (str2 != null) {
                d5 d5Var2 = new d5();
                d5Var2.d = 2;
                d5Var2.a = new String(str2);
                if (modelMaterial2.i == null) {
                    modelMaterial2.i = new b7<>(1);
                }
                modelMaterial2.i.a(d5Var2);
            }
            this.a.a(modelMaterial2);
        }
    }
}
