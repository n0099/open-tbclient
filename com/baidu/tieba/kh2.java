package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.jh2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class kh2 implements dj4<JSONArray> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public final lh2 a;
    public final String b;
    public vg4 c;
    public vg4 d;
    public mj3 e;
    public boolean f;
    public boolean g;
    public final Collection<mm3<kh2>> h;
    public final Collection<mm3<kh2>> i;
    public jh2.b j;

    /* loaded from: classes5.dex */
    public class a implements Function1<mj3, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh2 a;

        public a(kh2 kh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh2Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.kh2.c(com.baidu.tieba.kh2, com.baidu.tieba.mj3):com.baidu.tieba.kh2
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public kotlin.Unit invoke(com.baidu.tieba.mj3 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.kh2.a.$ic
                if (r0 != 0) goto L38
            L4:
                boolean r0 = com.baidu.tieba.kh2.b()
                if (r0 == 0) goto L2b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "install: "
                r0.append(r1)
                com.baidu.tieba.kh2 r1 = r4.a
                java.lang.String r1 = r1.k()
                r0.append(r1)
                java.lang.String r1 = " onCallback"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "SoUpdating"
                android.util.Log.i(r1, r0)
            L2b:
                com.baidu.tieba.kh2 r0 = r4.a
                com.baidu.tieba.kh2.c(r0, r5)
                com.baidu.tieba.kh2 r5 = r4.a
                r0 = 0
                com.baidu.tieba.kh2.d(r5, r0)
                r5 = 0
                return r5
            L38:
                r2 = r0
                r3 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                java.lang.Object r1 = r0.objValue
                kotlin.Unit r1 = (kotlin.Unit) r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.kh2.a.invoke(com.baidu.tieba.mj3):kotlin.Unit");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947913012, "Lcom/baidu/tieba/kh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947913012, "Lcom/baidu/tieba/kh2;");
                return;
            }
        }
        k = do1.a;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.h.clear();
                this.i.clear();
            }
        }
    }

    public vg4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (vg4) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public vg4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c == null && !TextUtils.isEmpty(this.b)) {
                this.c = qf4.i().t(this.b);
            }
            return this.c;
        }
        return (vg4) invokeV.objValue;
    }

    public jh2.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (jh2.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (n() && (this.e == null || ih2.d.k(k()))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            vg4 vg4Var = this.d;
            if (vg4Var != null && vg4Var != this.c) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!n() && this.f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public kh2(@NonNull lh2 lh2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lh2Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = new HashSet();
        this.i = new HashSet();
        this.j = null;
        this.a = lh2Var;
        this.b = str;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ com.baidu.tieba.kh2 c(com.baidu.tieba.kh2 r0, com.baidu.tieba.mj3 r1) {
        /*
            r0.i(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.kh2.c(com.baidu.tieba.kh2, com.baidu.tieba.mj3):com.baidu.tieba.kh2");
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.kh2.a.a(com.baidu.tieba.mj3):kotlin.Unit] */
    public static /* synthetic */ boolean d(kh2 kh2Var, boolean z) {
        kh2Var.f = z;
        return z;
    }

    public kh2 w(lh2 lh2Var, vg4 vg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, lh2Var, vg4Var)) == null) {
            if (r(lh2Var)) {
                this.d = vg4Var;
            }
            return this;
        }
        return (kh2) invokeLL.objValue;
    }

    public synchronized kh2 g(mm3<kh2> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mm3Var)) == null) {
            synchronized (this) {
                this.h.remove(mm3Var);
            }
            return this;
        }
        return (kh2) invokeL.objValue;
    }

    public synchronized kh2 h(mm3<kh2> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mm3Var)) == null) {
            synchronized (this) {
                this.i.remove(mm3Var);
            }
            return this;
        }
        return (kh2) invokeL.objValue;
    }

    public boolean r(lh2 lh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, lh2Var)) == null) {
            if (lh2Var != null && lh2Var == this.a) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized kh2 u(mm3<kh2> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, mm3Var)) == null) {
            synchronized (this) {
                this.h.add(mm3Var);
            }
            return this;
        }
        return (kh2) invokeL.objValue;
    }

    public synchronized kh2 v(mm3<kh2> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, mm3Var)) == null) {
            synchronized (this) {
                this.i.add(mm3Var);
            }
            return this;
        }
        return (kh2) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dj4
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        boolean z;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            vg4 l = l();
            if (k) {
                Log.i("SoUpdating", "decorateParams libName=" + this.b + " localSo=" + l);
            }
            try {
                for (AbiType abiType : AbiType.currentAbi().getCompatible()) {
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop abi=" + abiType);
                    }
                    if (abiType != null) {
                        rk4 d = rk4.d(this.b, abiType);
                        if (k) {
                            Log.i("SoUpdating", "decorateParams loop bundleId=" + d);
                        }
                        if (d != null) {
                            JSONObject jSONObject = new JSONObject();
                            if (l != null && abiType == l.q) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (l != null && z) {
                                j = l.i;
                            } else {
                                j = 0;
                            }
                            String str2 = "0";
                            if (l == null || !z) {
                                str = "0";
                            } else {
                                str = l.j;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d.b);
                            jSONObject.put("version_code", j);
                            jSONObject.put("version_name", str2);
                            if (k) {
                                Log.i("SoUpdating", "decorate abi=" + abiType + " jo=" + jSONObject);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e) {
                if (k) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized kh2 i(mj3 mj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mj3Var)) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "finish: " + k() + " finished=" + this.g + " error=" + mj3Var);
                }
                if (this.g) {
                    return this;
                }
                this.g = true;
                this.e = mj3Var;
                if (mj3Var == null) {
                    ih2.d.v(k(), System.currentTimeMillis());
                }
                ih2.d.f(k());
                t();
                e();
                return this;
            }
        }
        return (kh2) invokeL.objValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "install: " + k() + " finished=" + this.g + " installing=" + this.f);
                }
                if (!this.g && !this.f) {
                    this.f = true;
                    if (k) {
                        Log.i("SoUpdating", "install: " + k());
                    }
                    ih2.d.x(k(), new a(this));
                }
            }
        }
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.h.size());
                }
                this.g = true;
                for (mm3<kh2> mm3Var : this.h) {
                    if (mm3Var != null) {
                        mm3Var.a(this);
                    }
                }
            }
        }
    }

    public synchronized void x(jh2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.g && bVar != null && 0 != bVar.b) {
                    this.j = bVar;
                    for (mm3<kh2> mm3Var : this.i) {
                        if (mm3Var != null) {
                            mm3Var.a(this);
                        }
                    }
                }
            }
        }
    }
}
