package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pc2 extends ic2<JSONObject, h32> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements jc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gc2 gc2Var = new gc2();
                gc2Var.g(this.a);
                gc2Var.f(SceneType.SCENE_SKELETON_DEV_TIMEOUT);
            }
        }

        public static jc2 b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                a aVar = new a();
                aVar.a = str;
                return aVar;
            }
            return (jc2) invokeL.objValue;
        }
    }

    public pc2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mc2
    @NonNull
    /* renamed from: c */
    public h32 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new h32(202);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return new h32(202, "data is required");
            }
            String optString = optJSONObject.optString("path");
            if (TextUtils.isEmpty(optString)) {
                return new h32(202, "path is required");
            }
            wb2 b = wb2.b();
            if (!b.d()) {
                b.g(a.b(optString));
            }
            return new h32(0);
        }
        return (h32) invokeL.objValue;
    }
}
