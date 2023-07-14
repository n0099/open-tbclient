package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final ViewGroup c;

    public o0a(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = context;
        this.c = viewGroup;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if ("apk_download".equals(str)) {
                return "apk_download".equals(str2);
            }
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
                return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public p0a b(zz9 zz9Var, p0a p0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz9Var, p0aVar)) == null) {
            if (zz9Var == null) {
                return p0aVar;
            }
            String str = zz9Var.a;
            if (str == null) {
                return p0aVar;
            }
            if (p0aVar != null && a(str, p0aVar.a)) {
                return p0aVar;
            }
            ViewGroup viewGroup = this.c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(zz9Var.a)) {
                if (this.a == 2) {
                    return new n0a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d09cc, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new l0a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0951, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if (!"apk_download".equals(zz9Var.a)) {
                return null;
            } else {
                if (this.a == 2) {
                    return new m0a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d09cb, this.c, true), "apk_download");
                }
                return new k0a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0950, this.c, true), "apk_download");
            }
        }
        return (p0a) invokeLL.objValue;
    }
}
