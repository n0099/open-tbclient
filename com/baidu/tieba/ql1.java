package com.baidu.tieba;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class ql1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentProvider a;
    public final int b;
    public final int c;

    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public boolean d(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, bundle)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public abstract int delete(int i, Uri uri, String str, String[] strArr);

    public abstract void f(UriMatcher uriMatcher, String str);

    public abstract String getType(int i, Uri uri);

    public void i(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
        }
    }

    public abstract Uri insert(int i, Uri uri, ContentValues contentValues);

    public abstract boolean j();

    public abstract Cursor query(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public abstract int update(int i, Uri uri, ContentValues contentValues, String str, String[] strArr);

    public ql1(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i;
        this.c = i2;
    }

    public ContentProviderResult[] a(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            int size = arrayList.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = arrayList.get(i).apply(this.a, contentProviderResultArr, i);
            }
            return contentProviderResultArr;
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    public void b(ContentProvider contentProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentProvider) == null) && this.a == null) {
            this.a = contentProvider;
        }
    }

    public int c(int i, Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, uri, contentValuesArr)) == null) {
            int length = contentValuesArr.length;
            for (ContentValues contentValues : contentValuesArr) {
                insert(i, uri, contentValues);
            }
            return length;
        }
        return invokeILL.intValue;
    }

    public AssetFileDescriptor k(int i, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048591, this, i, uri, str)) == null) {
            m(i, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeILL.objValue;
    }

    public ParcelFileDescriptor m(int i, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048593, this, i, uri, str)) == null) {
            throw new FileNotFoundException("No files supported by provider at " + uri);
        }
        return (ParcelFileDescriptor) invokeILL.objValue;
    }

    public void e(Uri uri, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, uri, i) != null) || Binder.getCallingUid() == Process.myUid()) {
            return;
        }
        throw new SecurityException();
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public AssetFileDescriptor l(int i, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), uri, str, cancellationSignal})) == null) {
            k(i, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeCommon.objValue;
    }

    public Cursor query(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            return query(i, uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeCommon.objValue;
    }
}
