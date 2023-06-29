package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class jg {
    public static /* synthetic */ Interceptable $ic;
    public static String d;
    public static String e;
    public static String f;
    public static boolean g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public transient /* synthetic */ FieldHolder $fh;
    public zf a;
    public wf b;
    public long c;

    public jg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i();
    }

    public void c() {
        wf wfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (wfVar = this.b) != null) {
            wfVar.b();
        }
    }

    public zf e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (zf) invokeV.objValue;
    }

    public wf f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (wf) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            System.setProperty("http.keepAlive", "false");
            this.c = BdStatisticsManager.getInstance().getClientLogId();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            wf wfVar = this.b;
            if (wfVar != null) {
                return wfVar.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        wf wfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (wfVar = this.b) != null) {
            wfVar.p();
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            d = str;
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            h = str;
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            i = str;
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            j = str;
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            k = str;
        }
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            g = z;
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f = str;
        }
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            e = str;
        }
    }

    public final void a(zf zfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zfVar) == null) {
            b(zfVar, false);
        }
    }

    public final void b(zf zfVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zfVar, z) != null) || zfVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(d)) {
            zfVar.b().a("Cookie", d);
        } else {
            zfVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f)) {
            zfVar.b().a("client_user_token", f);
        }
        if (!TextUtils.isEmpty(e)) {
            zfVar.b().a("User-Agent", e);
        }
        if (z) {
            zfVar.b().a("Accept-Encoding", "gzip");
        } else {
            zfVar.b().a("Accept-Encoding", "");
        }
        if (g) {
            zfVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            zfVar.b().a(HTTP.CONN_DIRECTIVE, "close");
        }
        zfVar.b().a("client_logid", String.valueOf(this.c));
        if (!TextUtils.isEmpty(h)) {
            zfVar.b().a("cuid", h);
        }
        if (!TextUtils.isEmpty(i)) {
            zfVar.b().a("cuid_galaxy2", i);
        }
        if (!TextUtils.isEmpty(j)) {
            zfVar.b().a("c3_aid", j);
        }
        if (!TextUtils.isEmpty(k)) {
            zfVar.b().a(TiebaStatic.Params.CUID_GID, k);
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, dg dgVar, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, dgVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            zf zfVar = new zf();
            this.a = zfVar;
            a(zfVar);
            this.a.b().s(str);
            this.a.b().o(z4);
            wf wfVar = new wf(this.a);
            this.b = wfVar;
            return wfVar.c(str2, dgVar, i2, i3, i4, i5, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public bg g(String str, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i2, i3, i4)) == null) {
            return h(str, false, i2, i3, i4);
        }
        return (bg) invokeLIII.objValue;
    }

    public bg h(String str, boolean z, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            zf zfVar = new zf();
            this.a = zfVar;
            b(zfVar, z);
            this.a.b().s(str);
            wf wfVar = new wf(this.a);
            this.b = wfVar;
            wfVar.d(i2, i3, i4);
            return this.a.c();
        }
        return (bg) invokeCommon.objValue;
    }

    public bg k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            zf zfVar = new zf();
            this.a = zfVar;
            b(zfVar, z);
            this.a.b().s(str);
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.a.b().d(basicNameValuePair);
                }
            }
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.b().a(next.getName(), next.getValue());
                }
            }
            wf wfVar = new wf(this.a);
            this.b = wfVar;
            wfVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (bg) invokeCommon.objValue;
    }

    public bg l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), arrayList, hashMap, Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            zf zfVar = new zf();
            this.a = zfVar;
            b(zfVar, z);
            this.a.b().s(str);
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.b().a(next.getName(), next.getValue());
                }
            }
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    BasicNameValuePair next2 = it2.next();
                    this.a.b().b(next2.getName(), next2.getValue());
                }
            }
            if (hashMap != null) {
                for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                    this.a.b().c(entry.getKey(), entry.getValue());
                }
            }
            wf wfVar = new wf(this.a);
            this.b = wfVar;
            wfVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (bg) invokeCommon.objValue;
    }
}
