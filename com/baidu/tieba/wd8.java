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
/* loaded from: classes6.dex */
public class wd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final ViewGroup c;

    public wd8(Context context, ViewGroup viewGroup) {
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

    public xd8 b(hd8 hd8Var, xd8 xd8Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hd8Var, xd8Var)) == null) {
            if (hd8Var == null || (str = hd8Var.a) == null) {
                return xd8Var;
            }
            if (xd8Var == null || !a(str, xd8Var.a)) {
                ViewGroup viewGroup = this.c;
                if (viewGroup == null) {
                    return null;
                }
                viewGroup.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(hd8Var.a)) {
                    if (this.a == 2) {
                        return new vd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08b1, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new td8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0840, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(hd8Var.a)) {
                    if (this.a == 2) {
                        return new ud8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08b0, this.c, true), "apk_download");
                    }
                    return new sd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d083f, this.c, true), "apk_download");
                } else {
                    return null;
                }
            }
            return xd8Var;
        }
        return (xd8) invokeLL.objValue;
    }
}
