package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u12 {
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

    public u12() {
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
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

    public static u12 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            u12 u12Var = new u12();
            if (jSONObject != null) {
                jSONObject.optString("photoFilePath");
                u12Var.a = jSONObject.optString("nickName");
                u12Var.b = jSONObject.optString("lastName");
                u12Var.c = jSONObject.optString("middleName");
                u12Var.d = jSONObject.optString("firstName");
                u12Var.e = jSONObject.optString("remark");
                u12Var.f = jSONObject.optString("mobilePhoneNumber");
                u12Var.g = jSONObject.optString("weChatNumber");
                u12Var.h = jSONObject.optString("addressCountry");
                u12Var.i = jSONObject.optString("addressState");
                u12Var.j = jSONObject.optString("addressCity");
                u12Var.k = jSONObject.optString("addressStreet");
                u12Var.l = jSONObject.optString("addressPostalCode");
                u12Var.m = jSONObject.optString("organization");
                u12Var.n = jSONObject.optString("title");
                u12Var.o = jSONObject.optString("workFaxNumber");
                u12Var.p = jSONObject.optString("workPhoneNumber");
                u12Var.q = jSONObject.optString("hostNumber");
                u12Var.r = jSONObject.optString("email");
                u12Var.s = jSONObject.optString("url");
                u12Var.t = jSONObject.optString("workAddressCountry");
                u12Var.u = jSONObject.optString("workAddressState");
                u12Var.v = jSONObject.optString("workAddressCity");
                u12Var.w = jSONObject.optString("workAddressStreet");
                u12Var.x = jSONObject.optString("workAddressPostalCode");
                u12Var.y = jSONObject.optString("homeFaxNumber");
                u12Var.z = jSONObject.optString("homePhoneNumber");
                u12Var.A = jSONObject.optString("homeAddressCountry");
                u12Var.B = jSONObject.optString("homeAddressState");
                u12Var.C = jSONObject.optString("homeAddressCity");
                u12Var.D = jSONObject.optString("homeAddressStreet");
                u12Var.E = jSONObject.optString("homeAddressPostalCode");
            }
            return u12Var;
        }
        return (u12) invokeL.objValue;
    }

    public ContentValues b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
            contentValues.put("data5", (Integer) (-1));
            contentValues.put("data6", AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0115));
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
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
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
