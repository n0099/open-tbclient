package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class jj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public List<b> c;
    public List<b> d;
    public int[] e;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public final /* synthetic */ jj3 g;

        public b(jj3 jj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = jj3Var;
        }

        public /* synthetic */ b(jj3 jj3Var, a aVar) {
            this(jj3Var);
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", vh3.P(this.b));
                    jSONObject.put("y", vh3.P(this.c));
                    jSONObject.put("clientX", vh3.P(this.d - this.g.e[0]));
                    jSONObject.put("clientY", vh3.P(this.e - this.g.e[1]));
                    jSONObject.put("identifier", this.a);
                    jSONObject.put(TTDownloadField.TT_FORCE, this.f);
                } catch (JSONException e) {
                    if (jj3.f) {
                        e.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947885174, "Lcom/baidu/tieba/jj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947885174, "Lcom/baidu/tieba/jj3;");
                return;
            }
        }
        f = ok1.a;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public jj3(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "error";
        this.b = 0L;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new int[2];
        h(motionEvent, "");
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) && !TextUtils.equals(this.a, "touchend") && !TextUtils.equals(this.a, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.c.add(d(motionEvent, i));
                    }
                }
            } catch (Exception e) {
                if (f) {
                    e.printStackTrace();
                }
            }
        }
    }

    public jj3(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = "error";
        this.b = 0L;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new int[2];
        h(motionEvent, str);
    }

    public b d(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, i)) == null) {
            int pointerId = motionEvent.getPointerId(i);
            b bVar = new b(this, null);
            bVar.a = pointerId;
            bVar.b = motionEvent.getX(i);
            bVar.c = motionEvent.getY(i);
            bVar.d = (motionEvent.getRawX() + bVar.b) - motionEvent.getX();
            bVar.e = (motionEvent.getRawY() + bVar.c) - motionEvent.getY();
            bVar.f = motionEvent.getPressure(i);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.c.isEmpty()) {
                    for (b bVar : this.c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.d.isEmpty()) {
                    for (b bVar2 : this.d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (motionEvent.getActionMasked() == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    this.d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    this.d.add(d(motionEvent, i));
                }
            } catch (Exception e) {
                if (f) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.e = iArr;
            if (f) {
                Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked != 6) {
                                    this.a = "error";
                                } else {
                                    this.a = "touchpointerup";
                                    f(motionEvent);
                                }
                            } else {
                                this.a = "touchpointerdown";
                                f(motionEvent);
                            }
                        } else {
                            this.a = "touchcancel";
                            f(motionEvent);
                        }
                    } else {
                        this.a = "touchmove";
                        f(motionEvent);
                    }
                } else {
                    this.a = "touchend";
                    f(motionEvent);
                }
            } else {
                this.a = "touchstart";
                f(motionEvent);
            }
            this.b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.a, "touchpointerdown")) {
                this.a = "touchstart";
            }
            if (TextUtils.equals(this.a, "touchpointerup")) {
                this.a = "touchend";
            }
        }
    }
}
