package com.bytedance.pangle.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class PluginContentProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Uri pluginUri;

    @Override // android.content.ContentProvider
    public abstract int delete(Uri uri, String str, String[] strArr);

    @Override // android.content.ContentProvider
    public abstract String getType(Uri uri);

    @Override // android.content.ContentProvider
    public abstract Uri insert(Uri uri, ContentValues contentValues);

    @Override // android.content.ContentProvider
    public abstract Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    @Override // android.content.ContentProvider
    public abstract int update(Uri uri, ContentValues contentValues, String str, String[] strArr);

    public PluginContentProvider() {
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
}
