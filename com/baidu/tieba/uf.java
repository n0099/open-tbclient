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
public class uf {
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
    public kf a;
    public hf b;
    public long c;

    public uf() {
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
        hf hfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hfVar = this.b) != null) {
            hfVar.b();
        }
    }

    public kf e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (kf) invokeV.objValue;
    }

    public hf f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (hf) invokeV.objValue;
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
            hf hfVar = this.b;
            if (hfVar != null) {
                return hfVar.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        hf hfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (hfVar = this.b) != null) {
            hfVar.p();
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

    public final void a(kf kfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kfVar) == null) {
            b(kfVar, false);
        }
    }

    public final void b(kf kfVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kfVar, z) != null) || kfVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(d)) {
            kfVar.b().a("Cookie", d);
        } else {
            kfVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f)) {
            kfVar.b().a("client_user_token", f);
        }
        if (!TextUtils.isEmpty(e)) {
            kfVar.b().a("User-Agent", e);
        }
        if (z) {
            kfVar.b().a("Accept-Encoding", "gzip");
        } else {
            kfVar.b().a("Accept-Encoding", "");
        }
        if (g) {
            kfVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            kfVar.b().a(HTTP.CONN_DIRECTIVE, "close");
        }
        kfVar.b().a("client_logid", String.valueOf(this.c));
        if (!TextUtils.isEmpty(h)) {
            kfVar.b().a("cuid", h);
        }
        if (!TextUtils.isEmpty(i)) {
            kfVar.b().a("cuid_galaxy2", i);
        }
        if (!TextUtils.isEmpty(j)) {
            kfVar.b().a("c3_aid", j);
        }
        if (!TextUtils.isEmpty(k)) {
            kfVar.b().a(TiebaStatic.Params.CUID_GID, k);
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, of ofVar, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, ofVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            kf kfVar = new kf();
            this.a = kfVar;
            a(kfVar);
            this.a.b().s(str);
            this.a.b().o(z4);
            hf hfVar = new hf(this.a);
            this.b = hfVar;
            return hfVar.c(str2, ofVar, i2, i3, i4, i5, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public mf g(String str, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i2, i3, i4)) == null) {
            return h(str, false, i2, i3, i4);
        }
        return (mf) invokeLIII.objValue;
    }

    public mf h(String str, boolean z, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            kf kfVar = new kf();
            this.a = kfVar;
            b(kfVar, z);
            this.a.b().s(str);
            hf hfVar = new hf(this.a);
            this.b = hfVar;
            hfVar.d(i2, i3, i4);
            return this.a.c();
        }
        return (mf) invokeCommon.objValue;
    }

    public mf k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            kf kfVar = new kf();
            this.a = kfVar;
            b(kfVar, z);
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
            hf hfVar = new hf(this.a);
            this.b = hfVar;
            hfVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (mf) invokeCommon.objValue;
    }

    public mf l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), arrayList, hashMap, Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            kf kfVar = new kf();
            this.a = kfVar;
            b(kfVar, z);
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
            hf hfVar = new hf(this.a);
            this.b = hfVar;
            hfVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (mf) invokeCommon.objValue;
    }
}
