package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class kv1 extends ku1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public int g;
    public ViewTreeObserver.OnGlobalLayoutListener h;

    @Override // com.baidu.tieba.ku1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Keyboard" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SoftKeyboardApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv1 a;

        public a(kv1 kv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv1Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.f.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.a.g == height) {
                    return;
                }
                if (this.a.g - height > 180) {
                    HashMap hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("height", xj3.O(this.a.g - height));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    hashMap.put("data", jSONObject.toString());
                    tr2.V().v(new hg2("keyboardHeightChange", hashMap));
                    this.a.g = height;
                } else if (height - this.a.g > 180) {
                    HashMap hashMap2 = new HashMap();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("height", 0);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    hashMap2.put("data", jSONObject2.toString());
                    tr2.V().v(new hg2("keyboardHeightChange", hashMap2));
                    this.a.g = height;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppActivity activity = tr2.V().getActivity();
            if (activity == null) {
                g32.c("SoftKeyboardApi", "activity is null");
                return;
            }
            this.f = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f.getWindowVisibleDisplayFrame(rect);
            this.g = rect.height();
            if (this.h == null) {
                this.h = new a(this);
                this.f.getViewTreeObserver().addOnGlobalLayoutListener(this.h);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.h != null) {
                this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this.h);
            }
            this.h = null;
            this.g = 0;
        }
    }

    public hy1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r("#startKeyboardHeightChange", false);
            if (g63.c0() == null) {
                return new hy1(1001, "swan app is null");
            }
            B();
            return hy1.f();
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r("#stopKeyboardHeightChange", false);
            if (g63.c0() == null) {
                return new hy1(1001, "swan app is null");
            }
            C();
            return hy1.f();
        }
        return (hy1) invokeV.objValue;
    }
}
