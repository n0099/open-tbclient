package com.baidu.tieba;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes7.dex */
public class qk4 {
    public static /* synthetic */ Interceptable $ic;
    public static final bp4 b;
    public static final String c;
    public static final Uri d;
    public static final Uri e;
    public static final Uri f;
    public static final Uri g;
    public static final Uri h;
    public static final Uri i;
    public static final Uri j;
    public static UriMatcher k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948094703, "Lcom/baidu/tieba/qk4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948094703, "Lcom/baidu/tieba/qk4;");
                return;
            }
        }
        b = bp4.c();
        c = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
        d = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/framework");
        e = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/swan_app");
        f = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/pkg_main");
        g = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/pkg_sub");
        h = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/" + ETAG.KEY_EXTENSION);
        i = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/swan_plugin");
        j = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + c + "/so_lib");
        UriMatcher uriMatcher = new UriMatcher(-1);
        k = uriMatcher;
        uriMatcher.addURI(c, "framework", 2);
        k.addURI(c, "pkg_main", 0);
        k.addURI(c, "pkg_sub", 1);
        k.addURI(c, ETAG.KEY_EXTENSION, 3);
        k.addURI(c, "swan_app", 4);
        k.addURI(c, "swan_plugin", 5);
        k.addURI(c, "so_lib", 7);
    }

    public qk4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public SQLiteOpenHelper a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return pk4.a();
        }
        return (SQLiteOpenHelper) invokeV.objValue;
    }

    public final String b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            int match = k.match(uri);
            if (match != 0) {
                if (match != 1) {
                    if (match != 2) {
                        if (match != 3) {
                            if (match != 4) {
                                if (match != 5) {
                                    if (match != 7) {
                                        return null;
                                    }
                                    return "so_lib";
                                }
                                return "swan_plugin";
                            }
                            return "swan_app";
                        }
                        return ETAG.KEY_EXTENSION;
                    }
                    return "framework";
                }
                return "pkg_sub";
            }
            return "pkg_main";
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public Cursor c(@NonNull Uri uri, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, str)) == null) {
            if (!TextUtils.isEmpty(b(uri))) {
                try {
                    return a().getReadableDatabase().rawQuery(str, null);
                } catch (SQLException e2) {
                    b.g("PMSDBProvider", "#rawQuery error", e2);
                }
            }
            return null;
        }
        return (Cursor) invokeLL.objValue;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uri, str, strArr)) == null) {
            String b2 = b(uri);
            if (!TextUtils.isEmpty(b2)) {
                bp4 bp4Var = b;
                bp4Var.i("PMSDBProvider", "#delete tableName=" + b2 + " selection=" + str);
                try {
                    int delete = a().getWritableDatabase().delete(b2, str, strArr);
                    if (delete > 0) {
                        this.a.getContentResolver().notifyChange(uri, null);
                    }
                    return delete;
                } catch (SQLException e2) {
                    b.g("PMSDBProvider", "#delete error", e2);
                    return 0;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uri, contentValues)) == null) {
            String b2 = b(uri);
            if (!TextUtils.isEmpty(b2) && contentValues != null) {
                bp4 bp4Var = b;
                bp4Var.i("PMSDBProvider", "#insert values=" + contentValues);
                try {
                    long insertWithOnConflict = a().getWritableDatabase().insertWithOnConflict(b2, null, contentValues, 5);
                    if (insertWithOnConflict > 0) {
                        Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                        this.a.getContentResolver().notifyChange(withAppendedId, null);
                        return withAppendedId;
                    }
                    return uri;
                } catch (SQLException e2) {
                    b.g("PMSDBProvider", "#insert error", e2);
                }
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) {
            if (uri.getQueryParameter("rawQuery") != null) {
                return c(uri, str);
            }
            String b2 = b(uri);
            if (!TextUtils.isEmpty(b2)) {
                try {
                    return a().getReadableDatabase().query(b2, strArr, str, strArr2, null, null, str2, null);
                } catch (SQLException e2) {
                    b.g("PMSDBProvider", "#query error", e2);
                    return null;
                }
            }
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            String b2 = b(uri);
            if (!TextUtils.isEmpty(b2)) {
                bp4 bp4Var = b;
                bp4Var.i("PMSDBProvider", "#update tableName=" + b2 + " selection=" + str);
                try {
                    int update = a().getWritableDatabase().update(b2, contentValues, str, strArr);
                    if (update > 0) {
                        this.a.getContentResolver().notifyChange(uri, null);
                    }
                    return update;
                } catch (SQLException e2) {
                    b.g("PMSDBProvider", "#update error", e2);
                    return 0;
                }
            }
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
