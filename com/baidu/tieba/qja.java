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
public class qja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final ViewGroup c;

    public qja(Context context, ViewGroup viewGroup) {
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

    public rja b(cja cjaVar, rja rjaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cjaVar, rjaVar)) == null) {
            if (cjaVar == null) {
                return rjaVar;
            }
            String str = cjaVar.a;
            if (str == null) {
                return rjaVar;
            }
            if (rjaVar != null && a(str, rjaVar.a)) {
                return rjaVar;
            }
            ViewGroup viewGroup = this.c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(cjaVar.a)) {
                if (this.a == 2) {
                    return new pja(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0a0c, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new nja(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d099a, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if (!"apk_download".equals(cjaVar.a)) {
                return null;
            } else {
                if (this.a == 2) {
                    return new oja(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0a0b, this.c, true), "apk_download");
                }
                return new mja(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0999, this.c, true), "apk_download");
            }
        }
        return (rja) invokeLL.objValue;
    }
}
