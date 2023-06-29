package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.od3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class ju1 implements ow1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ow1
    public boolean a(Activity activity, String str, od3.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, bVar)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ow1
    public boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public ju1() {
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

    @Override // com.baidu.tieba.ow1
    public boolean c(Activity activity, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, uri, str)) == null) {
            if (activity != null && uri != null && uri.getPath() != null && !TextUtils.isEmpty(str)) {
                if (jo3.i()) {
                    uri = zp3.a(activity, new File(uri.getPath()));
                }
                d(activity, uri, str);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void d(Activity activity, Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, uri, str) == null) {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.addFlags(1);
            intent.setDataAndType(uri, str);
            lo3.f(activity, intent);
        }
    }
}
