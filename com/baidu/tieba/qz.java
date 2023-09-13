package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.tieba.a10;
import com.baidu.tieba.oz;
import com.baidu.tieba.s00;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qz extends oz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s00.a f;
    public b g;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(s00.a aVar, s00 s00Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aVar, s00Var)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (aVar != null && !aVar.f().equals(s00Var.a())) {
                        aVar.f().setExecutable(true, false);
                        aVar = aVar.i();
                    }
                    return true;
                }
                while (aVar != null) {
                    if (!b(aVar.f())) {
                        return false;
                    }
                    aVar = aVar.i();
                }
                return b(s00Var.a());
            }
            return invokeLL.booleanValue;
        }

        public static boolean b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        int i = Os.stat(file.getAbsolutePath()).st_mode;
                        if ((i & 1) == 0) {
                            Os.chmod(file.getAbsolutePath(), i | 1);
                        }
                        return true;
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v00 a;
        public long b;
        public a10.a c;
        public boolean d;
        public boolean e;
        public final /* synthetic */ qz f;

        public b(qz qzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qzVar;
            this.a = new v00();
            this.e = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.longValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b == j) {
                return;
            }
            this.b = j;
            this.d = true;
        }

        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.a.a(j, j2)) {
                this.d = true;
            }
        }

        public void d(a10.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar.equals(this.c)) {
                return;
            }
            this.c = aVar;
            this.d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, packageInfo)) == null) {
                String c = this.f.f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
                this.e = false;
                return f(c);
            }
            return invokeL.booleanValue;
        }

        public final boolean f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.b = jSONObject.getLong("pub_lst_ts");
                        this.c = a10.c(jSONObject.getString("pub_info"));
                        jSONObject.getInt("d_form_ver");
                        this.d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public a10.a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (a10.a) invokeV.objValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f(this.f.f.c("pub.dat", true)) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.e) {
                    if (this.d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_info", this.c.z());
                            jSONObject.put("pub_lst_ts", this.b);
                            jSONObject.put("d_form_ver", 1);
                            this.f.f.e("pub.dat", jSONObject.toString(), true);
                            this.d = false;
                            return true;
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                throw new IllegalStateException();
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? qz.i(this.f.f.g("pub.dat"), true) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends oz.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;
        public long e;
        public long f;
        public long g;
        public a10.a h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qz qzVar, String str) {
            super(qzVar.f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qzVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((s00.a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.oz.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.d = jSONObject.getString("pkg");
                this.f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.e = jSONObject.getLong("last_fe_ts");
                this.h = a10.c(jSONObject.getString("info"));
                this.g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // com.baidu.tieba.oz.c
        public void d(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.d);
                jSONObject.put("last_fe_ts", this.e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f);
                jSONObject.put("info", this.h.z());
                jSONObject.put("tar_pkg_lst_up_ts", this.g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public void f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                h(bVar.g());
                j(bVar.a());
            }
        }

        public boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.e != j) {
                    this.e = j;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h(a10.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                if (aVar.equals(this.h)) {
                    return false;
                }
                this.h = aVar;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.d)) {
                    return false;
                }
                this.d = str;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f != j) {
                    this.f = j;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public String k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public boolean l(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                if (this.g != j) {
                    this.g = j;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public a10.a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (a10.a) invokeV.objValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : invokeV.longValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qz() {
        super("isc", 8000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new b(this);
    }

    public static boolean i(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, file, z)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Os.chmod(file.getAbsolutePath(), z ? RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR : 432);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            try {
                if (z) {
                    return file.setReadable(true, false);
                }
                return file.setReadable(false, false) && file.setReadable(true, true);
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.oz
    public oz.f a(oz.e eVar, a10.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            Context context = this.a.a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.g.h();
                try {
                    return h(eVar, aVar);
                } finally {
                    this.g.i();
                    j();
                    this.g.i();
                    this.g.j();
                }
            }
            return oz.f.a(-100);
        }
        return (oz.f) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.oz
    public oz.h b(String str, oz.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        a10.a g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            c cVar = null;
            boolean z = false;
            try {
                packageInfo = this.a.a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return oz.h.a(-2);
            }
            if (gVar.a) {
                cVar = new c(this, str);
                cVar.c();
                if (str.equals(cVar.k())) {
                    a10.a m = cVar.m();
                    boolean z2 = packageInfo.lastUpdateTime == cVar.n();
                    if (m != null && m.r() && !TextUtils.isEmpty(m.s())) {
                        z = true;
                    }
                    if (z2 && z) {
                        g = cVar.m();
                        return oz.h.b(g);
                    }
                }
            }
            b bVar = new b(this);
            if (bVar.e(packageInfo)) {
                if (gVar.a && cVar != null) {
                    cVar.f(bVar);
                    cVar.g(System.currentTimeMillis());
                    cVar.l(packageInfo.lastUpdateTime);
                    cVar.i(str);
                    cVar.e();
                }
                g = bVar.g();
                return oz.h.b(g);
            }
            return oz.h.a(-2);
        }
        return (oz.h) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.oz
    public void e(oz.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f = this.b.b("isc");
        }
    }

    public final oz.f h(oz.e eVar, a10.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, aVar)) == null) {
            this.g.h();
            this.f.d();
            if (aVar.equals(this.g.g())) {
                return oz.f.b();
            }
            this.g.d(aVar);
            this.g.b(System.currentTimeMillis());
            return oz.f.b();
        }
        return (oz.f) invokeLL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.c(a.a(this.f, this.a.b) ? 1 : 2, 3L);
        }
    }
}
