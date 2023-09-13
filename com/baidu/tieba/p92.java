package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public p92() {
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

    public ContentValues g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 5);
            contentValues.put("data1", this.y);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.z);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 10);
            contentValues.put("data1", this.q);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 2);
            contentValues.put("data1", this.f);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.a);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", this.e);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.s);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 4);
            contentValues.put("data1", this.o);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 3);
            contentValues.put("data1", this.p);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return !TextUtils.isEmpty(this.d);
        }
        return invokeV.booleanValue;
    }

    public static p92 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            p92 p92Var = new p92();
            if (jSONObject != null) {
                jSONObject.optString("photoFilePath");
                p92Var.a = jSONObject.optString("nickName");
                p92Var.b = jSONObject.optString("lastName");
                p92Var.c = jSONObject.optString("middleName");
                p92Var.d = jSONObject.optString("firstName");
                p92Var.e = jSONObject.optString("remark");
                p92Var.f = jSONObject.optString("mobilePhoneNumber");
                p92Var.g = jSONObject.optString("weChatNumber");
                p92Var.h = jSONObject.optString("addressCountry");
                p92Var.i = jSONObject.optString("addressState");
                p92Var.j = jSONObject.optString("addressCity");
                p92Var.k = jSONObject.optString("addressStreet");
                p92Var.l = jSONObject.optString("addressPostalCode");
                p92Var.m = jSONObject.optString("organization");
                p92Var.n = jSONObject.optString("title");
                p92Var.o = jSONObject.optString("workFaxNumber");
                p92Var.p = jSONObject.optString("workPhoneNumber");
                p92Var.q = jSONObject.optString("hostNumber");
                p92Var.r = jSONObject.optString("email");
                p92Var.s = jSONObject.optString("url");
                p92Var.t = jSONObject.optString("workAddressCountry");
                p92Var.u = jSONObject.optString("workAddressState");
                p92Var.v = jSONObject.optString("workAddressCity");
                p92Var.w = jSONObject.optString("workAddressStreet");
                p92Var.x = jSONObject.optString("workAddressPostalCode");
                p92Var.y = jSONObject.optString("homeFaxNumber");
                p92Var.z = jSONObject.optString("homePhoneNumber");
                p92Var.A = jSONObject.optString("homeAddressCountry");
                p92Var.B = jSONObject.optString("homeAddressState");
                p92Var.C = jSONObject.optString("homeAddressCity");
                p92Var.D = jSONObject.optString("homeAddressStreet");
                p92Var.E = jSONObject.optString("homeAddressPostalCode");
            }
            return p92Var;
        }
        return (p92) invokeL.objValue;
    }

    public ContentValues b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 3);
            contentValues.put("data1", c());
            contentValues.put("data9", this.l);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.b)) {
                sb.append(this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                sb.append(this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(this.d);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", f());
            contentValues.put("data9", this.E);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/organization");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.m);
            contentValues.put("data4", this.n);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/im");
            contentValues.put("data5", (Integer) (-1));
            contentValues.put("data6", AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0142));
            contentValues.put("data1", this.g);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 2);
            contentValues.put("data1", q());
            contentValues.put("data9", this.x);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.h)) {
                sb.append(this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
                sb.append(this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append(this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append(this.k);
            }
            if (!TextUtils.isEmpty(this.l)) {
                sb.append(" ");
                sb.append(this.l);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.A)) {
                sb.append(this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                sb.append(this.B);
            }
            if (!TextUtils.isEmpty(this.C)) {
                sb.append(this.C);
            }
            if (!TextUtils.isEmpty(this.D)) {
                sb.append(this.D);
            }
            if (!TextUtils.isEmpty(this.E)) {
                sb.append(" ");
                sb.append(this.E);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.t)) {
                sb.append(this.t);
            }
            if (!TextUtils.isEmpty(this.u)) {
                sb.append(this.u);
            }
            if (!TextUtils.isEmpty(this.v)) {
                sb.append(this.v);
            }
            if (!TextUtils.isEmpty(this.w)) {
                sb.append(this.w);
            }
            if (!TextUtils.isEmpty(this.x)) {
                sb.append(" ");
                sb.append(this.x);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
