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
public class l3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final ViewGroup c;

    public l3a(Context context, ViewGroup viewGroup) {
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

    public m3a b(x2a x2aVar, m3a m3aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x2aVar, m3aVar)) == null) {
            if (x2aVar == null) {
                return m3aVar;
            }
            String str = x2aVar.a;
            if (str == null) {
                return m3aVar;
            }
            if (m3aVar != null && a(str, m3aVar.a)) {
                return m3aVar;
            }
            ViewGroup viewGroup = this.c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(x2aVar.a)) {
                if (this.a == 2) {
                    return new k3a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d09de, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new i3a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0963, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if (!"apk_download".equals(x2aVar.a)) {
                return null;
            } else {
                if (this.a == 2) {
                    return new j3a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d09dd, this.c, true), "apk_download");
                }
                return new h3a(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0962, this.c, true), "apk_download");
            }
        }
        return (m3a) invokeLL.objValue;
    }
}
