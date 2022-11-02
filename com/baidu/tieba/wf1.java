package com.baidu.tieba;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wf1 extends vf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vf1
    public int delete(int i, Uri uri, String str, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), uri, str, strArr})) == null) {
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.vf1
    public String getType(int i, Uri uri) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, uri)) == null) {
            return null;
        }
        return (String) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.vf1
    public Uri insert(int i, Uri uri, ContentValues contentValues) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.vf1
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vf1
    public int update(int i, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), uri, contentValues, str, strArr})) == null) {
            return 0;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf1() {
        super(0, 100);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.vf1
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) {
            if ("_get_service_handler".equals(str)) {
                return of1.a();
            }
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.vf1
    public boolean d(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, bundle)) == null) {
            return "_get_service_handler".equals(str);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vf1
    public void e(Uri uri, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, uri, i) != null) || i == 3) {
            return;
        }
        super.e(uri, i);
    }

    @Override // com.baidu.tieba.vf1
    public void f(UriMatcher uriMatcher, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, uriMatcher, str) == null) {
            uriMatcher.addURI(str, "ipc_manager/method/get_service_handler", 1);
        }
    }

    @Override // com.baidu.tieba.vf1
    public Cursor query(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), uri, strArr, str, strArr2, str2})) == null) {
            if (i == 1) {
                return new pf1(of1.a());
            }
            return null;
        }
        return (Cursor) invokeCommon.objValue;
    }
}
