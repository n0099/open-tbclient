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
/* loaded from: classes5.dex */
public class sg {
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
    public ig a;
    public fg b;
    public long c;

    public sg() {
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
        fg fgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fgVar = this.b) != null) {
            fgVar.b();
        }
    }

    public ig e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (ig) invokeV.objValue;
    }

    public fg f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (fg) invokeV.objValue;
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
            fg fgVar = this.b;
            if (fgVar != null) {
                return fgVar.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        fg fgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (fgVar = this.b) != null) {
            fgVar.p();
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

    public final void a(ig igVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, igVar) == null) {
            b(igVar, false);
        }
    }

    public final void b(ig igVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, igVar, z) != null) || igVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(d)) {
            igVar.b().a("Cookie", d);
        } else {
            igVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f)) {
            igVar.b().a("client_user_token", f);
        }
        if (!TextUtils.isEmpty(e)) {
            igVar.b().a("User-Agent", e);
        }
        if (z) {
            igVar.b().a("Accept-Encoding", "gzip");
        } else {
            igVar.b().a("Accept-Encoding", "");
        }
        if (g) {
            igVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            igVar.b().a(HTTP.CONN_DIRECTIVE, "close");
        }
        igVar.b().a("client_logid", String.valueOf(this.c));
        if (!TextUtils.isEmpty(h)) {
            igVar.b().a("cuid", h);
        }
        if (!TextUtils.isEmpty(i)) {
            igVar.b().a("cuid_galaxy2", i);
        }
        if (!TextUtils.isEmpty(j)) {
            igVar.b().a("c3_aid", j);
        }
        if (!TextUtils.isEmpty(k)) {
            igVar.b().a(TiebaStatic.Params.CUID_GID, k);
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList linkedList, mg mgVar, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, mgVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            ig igVar = new ig();
            this.a = igVar;
            a(igVar);
            this.a.b().s(str);
            this.a.b().o(z4);
            fg fgVar = new fg(this.a);
            this.b = fgVar;
            return fgVar.c(str2, mgVar, i2, i3, i4, i5, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public kg g(String str, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i2, i3, i4)) == null) {
            return h(str, false, i2, i3, i4);
        }
        return (kg) invokeLIII.objValue;
    }

    public kg h(String str, boolean z, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ig igVar = new ig();
            this.a = igVar;
            b(igVar, z);
            this.a.b().s(str);
            fg fgVar = new fg(this.a);
            this.b = fgVar;
            fgVar.d(i2, i3, i4);
            return this.a.c();
        }
        return (kg) invokeCommon.objValue;
    }

    public kg k(String str, List list, boolean z, int i2, int i3, LinkedList linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            ig igVar = new ig();
            this.a = igVar;
            b(igVar, z);
            this.a.b().s(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.a.b().d((BasicNameValuePair) it.next());
                }
            }
            if (linkedList != null) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it2.next();
                    this.a.b().a(basicNameValuePair.getName(), basicNameValuePair.getValue());
                }
            }
            fg fgVar = new fg(this.a);
            this.b = fgVar;
            fgVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (kg) invokeCommon.objValue;
    }

    public kg l(String str, boolean z, ArrayList arrayList, HashMap hashMap, int i2, int i3, LinkedList linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), arrayList, hashMap, Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            ig igVar = new ig();
            this.a = igVar;
            b(igVar, z);
            this.a.b().s(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                    this.a.b().a(basicNameValuePair.getName(), basicNameValuePair.getValue());
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    BasicNameValuePair basicNameValuePair2 = (BasicNameValuePair) it2.next();
                    this.a.b().b(basicNameValuePair2.getName(), basicNameValuePair2.getValue());
                }
            }
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    this.a.b().c((String) entry.getKey(), (byte[]) entry.getValue());
                }
            }
            fg fgVar = new fg(this.a);
            this.b = fgVar;
            fgVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (kg) invokeCommon.objValue;
    }
}
