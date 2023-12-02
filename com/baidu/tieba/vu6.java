package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes8.dex */
public final class vu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948253330, "Lcom/baidu/tieba/vu6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948253330, "Lcom/baidu/tieba/vu6;");
        }
    }

    public vu6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(ItemData itemData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, itemData)) == null) {
            if (itemData != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("item_id", Long.valueOf(itemData.itemId));
                    jSONObject.putOpt("item_name", itemData.mTitle);
                    jSONObject.putOpt("icon_size", Double.valueOf(itemData.mIconSize));
                    jSONObject.putOpt("icon_url", itemData.mIconUrl);
                    if (!ListUtils.isEmpty(itemData.mTags)) {
                        jSONObject.putOpt("tags", new JSONArray((Collection) itemData.mTags));
                    }
                    jSONObject.putOpt("score", Double.valueOf(itemData.mScore));
                    jSONObject.putOpt("star", Integer.valueOf(itemData.mStar));
                    jSONObject.putOpt("button_name", itemData.buttonName);
                    jSONObject.putOpt("button_link", itemData.buttonLink);
                    jSONObject.putOpt("button_link_type", itemData.buttonLinkType);
                    jSONObject.putOpt("apk_name", itemData.pkgName);
                    jSONObject.putOpt("forum_name", itemData.forumName);
                    jSONObject.putOpt("item_appid", itemData.appId);
                    jSONObject.putOpt("file_download_type", Integer.valueOf(itemData.mTbFileDownloaderType));
                    jSONObject.putOpt("notification_show_count", Integer.valueOf(itemData.notificationShowCount));
                    jSONObject.putOpt(NetDiskFileMsg.NetDiskFile.JSON_KEY_FILE_TYPE, itemData.fileType);
                    ApkDetail apkDetail = itemData.apkDetail;
                    if (apkDetail != null) {
                        Intrinsics.checkNotNullExpressionValue(apkDetail, "apkDetail");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("developer", apkDetail.developer);
                        jSONObject2.putOpt("publisher", apkDetail.publisher);
                        jSONObject2.putOpt("version", apkDetail.version);
                        jSONObject2.putOpt("version_code", apkDetail.version_code);
                        jSONObject2.putOpt("update_time", apkDetail.update_time);
                        jSONObject2.putOpt("size", apkDetail.size);
                        jSONObject2.putOpt("need_network", apkDetail.need_network);
                        jSONObject2.putOpt("need_inner_buy", apkDetail.need_inner_buy);
                        jSONObject2.putOpt("authority_url", apkDetail.authority_url);
                        jSONObject2.putOpt("privacy_url", apkDetail.privacy_url);
                        jSONObject2.putOpt("pkg_source", apkDetail.pkg_source);
                        jSONObject2.putOpt("app_effect", apkDetail.app_effect);
                        jSONObject.putOpt("apk_detail", jSONObject2);
                    }
                } catch (JSONException unused) {
                    DefaultLog.getInstance().i("DownloadMultiInfoDbMana", "convertToDbDetailInfoData 解析json异常");
                    if (BdLog.isDebugMode()) {
                        Log.e("DownloadMultiInfoDbMana", "convertToDbDetailInfoData 解析json异常");
                    }
                }
                str = jSONObject.toString();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final int b(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            jsa jsaVar = new jsa();
            jsaVar.j(data.getUrl());
            return oz0Var.e(jsaVar, (nz0[]) Arrays.copyOf(new nz0[]{lsa.o}, 1));
        }
        return invokeL.intValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            jsa jsaVar = new jsa();
            jsaVar.m(i);
            return oz0Var.e(jsaVar, (nz0[]) Arrays.copyOf(new nz0[]{lsa.l}, 1));
        }
        return invokeI.intValue;
    }

    public final int m(jsa downloadMultiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadMultiInfo)) == null) {
            Intrinsics.checkNotNullParameter(downloadMultiInfo, "downloadMultiInfo");
            return new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f()).f(downloadMultiInfo, (nz0[]) Arrays.copyOf(new nz0[]{lsa.l}, 1));
        }
        return invokeL.intValue;
    }

    public final int c(wz0 model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, model)) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f()).e(model, new nz0[0]);
        }
        return invokeL.intValue;
    }

    public final xz0 e(xz0 xz0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, xz0Var, str, str2)) == null) {
            if (!StringsKt__StringsJVMKt.isBlank(str)) {
                nz0 nz0Var = lsa.q;
                xz0Var.a("m", nz0Var, " = '" + str + '\'');
            } else if (!StringsKt__StringsJVMKt.isBlank(str2)) {
                nz0 nz0Var2 = lsa.p;
                xz0Var.a("m", nz0Var2, " = '" + str2 + '\'');
            }
            return xz0Var;
        }
        return (xz0) invokeLLL.objValue;
    }

    public final long f(DownloadData data) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            oz0 oz0Var = new oz0(f);
            f.beginTransaction();
            jsa jsaVar = new jsa();
            jsaVar.p(System.currentTimeMillis());
            jsaVar.j(data.getUrl());
            jsaVar.q(data.getId());
            jsaVar.i(a(data.getItemData()));
            jsaVar.o(data.getSource());
            ItemData itemData = data.getItemData();
            String str2 = null;
            if (itemData != null) {
                str = itemData.packageName;
            } else {
                str = null;
            }
            boolean z2 = false;
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                ItemData itemData2 = data.getItemData();
                if (itemData2 != null) {
                    str2 = itemData2.packageName;
                }
                jsaVar.n(str2);
            } else {
                ItemData itemData3 = data.getItemData();
                if (itemData3 != null) {
                    str2 = itemData3.pkgName;
                }
                jsaVar.n(str2);
            }
            String str3 = data.mDbExtraData;
            if (!((str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) ? true : true)) {
                jsaVar.k(data.mDbExtraData);
            }
            try {
                long c = oz0Var.c(jsaVar);
                f.setTransactionSuccessful();
                return c;
            } finally {
                f.endTransaction();
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final List<jsa> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            b01 f = b01.f();
            nz0[] d = new jsa().b().d();
            f.a("m", (nz0[]) Arrays.copyOf(d, d.length));
            f.d("m", jsa.class);
            Cursor d2 = oz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            ArrayList arrayList = new ArrayList();
            while (d2.moveToNext()) {
                try {
                    jsa jsaVar = new jsa();
                    uz0.b(jsaVar, d2);
                    arrayList.add(jsaVar);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(d2, null);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final List<jsa> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            b01 f = b01.f();
            nz0[] d = new jsa().b().d();
            f.a("m", (nz0[]) Arrays.copyOf(d, d.length));
            f.d("m", jsa.class);
            f.h(lsa.n, "is not null");
            Cursor d2 = oz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            ArrayList arrayList = new ArrayList();
            while (d2.moveToNext()) {
                try {
                    jsa jsaVar = new jsa();
                    uz0.b(jsaVar, d2);
                    arrayList.add(jsaVar);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(d2, null);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final jsa h(nz0 field, String value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, field, value)) == null) {
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(value, "value");
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            b01 f = b01.f();
            nz0[] d = new jsa().b().d();
            f.a("m", (nz0[]) Arrays.copyOf(d, d.length));
            f.c("m", new jsa());
            f.h(field, " = '" + value + '\'');
            Cursor d2 = oz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            try {
                if (d2.moveToNext()) {
                    jsa jsaVar = new jsa();
                    uz0.b(jsaVar, d2);
                    CloseableKt.closeFinally(d2, null);
                    return jsaVar;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(d2, null);
                return null;
            } finally {
            }
        } else {
            return (jsa) invokeLL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final jsa k(String title, String pkgName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, title, pkgName)) == null) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(pkgName, "pkgName");
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            b01 f = b01.f();
            nz0[] d = new jsa().b().d();
            f.a("m", (nz0[]) Arrays.copyOf(d, d.length));
            f.c("m", new jsa());
            xz0 condition = f.h(lsa.n, "is not null");
            Intrinsics.checkNotNullExpressionValue(condition, "condition");
            e(condition, title, pkgName);
            Cursor d2 = oz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            jsa jsaVar = new jsa();
            try {
                if (d2.moveToFirst()) {
                    uz0.b(jsaVar, d2);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(d2, null);
                return jsaVar;
            } finally {
            }
        } else {
            return (jsa) invokeLL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final jsa i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            b01 f = b01.f();
            nz0[] d = new jsa().b().d();
            f.a("m", (nz0[]) Arrays.copyOf(d, d.length));
            f.d("m", jsa.class);
            nz0 nz0Var = lsa.l;
            f.h(nz0Var, " = " + i);
            Cursor d2 = oz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            try {
                if (d2.moveToNext()) {
                    jsa jsaVar = new jsa();
                    uz0.b(jsaVar, d2);
                    CloseableKt.closeFinally(d2, null);
                    return jsaVar;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(d2, null);
                return null;
            } finally {
            }
        } else {
            return (jsa) invokeI.objValue;
        }
    }

    public final int n(DownloadData data) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            oz0 oz0Var = new oz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            jsa jsaVar = new jsa();
            jsaVar.l(System.currentTimeMillis());
            jsaVar.j(data.getUrl());
            ItemData itemData = data.getItemData();
            if (itemData != null) {
                String str = itemData.packageName;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    jsaVar.n(itemData.packageName);
                }
            }
            return oz0Var.f(jsaVar, (nz0[]) Arrays.copyOf(new nz0[]{lsa.o}, 1));
        }
        return invokeL.intValue;
    }

    public final long l(DownloadData data) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            oz0 oz0Var = new oz0(f);
            f.beginTransaction();
            jsa jsaVar = new jsa();
            jsaVar.q(data.getId());
            try {
                if (!oz0Var.b(jsaVar, (nz0[]) Arrays.copyOf(new nz0[]{lsa.q}, 1))) {
                    j = f(data);
                } else {
                    j = -1;
                }
                oz0Var.setTransactionSuccessful();
                return j;
            } finally {
                oz0Var.endTransaction();
            }
        }
        return invokeL.longValue;
    }
}
