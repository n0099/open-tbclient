package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.p.a.a.a.c.h;
import c.p.a.a.a.c.t;
import c.p.a.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.d;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f67422a;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67422a = new WeakReference<>(context);
    }

    @Override // c.p.a.a.a.c.h
    public void a(@NonNull Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, activity, i2, strArr, iArr) == null) {
        }
    }

    @Override // c.p.a.a.a.c.h
    public void a(@NonNull Activity activity, @NonNull String[] strArr, t tVar) {
        boolean z;
        TTCustomController f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, strArr, tVar) == null) {
            if (strArr != null && strArr.length > 0) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i2])) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (f2 = com.bytedance.sdk.openadsdk.core.h.d().f()) != null && tVar != null && !f2.isCanUseWriteExternal()) {
                    tVar.a("android.permission.WRITE_EXTERNAL_STORAGE");
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 23 && h.r.a(activity) < 23) {
                if (tVar != null) {
                    tVar.a();
                }
            } else if (strArr == null || strArr.length <= 0) {
                if (tVar != null) {
                    tVar.a();
                }
            } else {
                long hashCode = hashCode();
                for (String str : strArr) {
                    hashCode += str.hashCode();
                }
                com.bytedance.sdk.openadsdk.q.d.a(String.valueOf(hashCode), strArr, new d.a(this, tVar, strArr) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ t f67423a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String[] f67424b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f67425c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tVar, strArr};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67425c = this;
                        this.f67423a = tVar;
                        this.f67424b = strArr;
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.d.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            t tVar2 = this.f67423a;
                            if (tVar2 != null) {
                                tVar2.a();
                            }
                            com.bytedance.sdk.openadsdk.j.a.a().a(true, this.f67424b);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.d.a
                    public void a(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                            t tVar2 = this.f67423a;
                            if (tVar2 != null) {
                                tVar2.a(str2);
                            }
                            com.bytedance.sdk.openadsdk.j.a.a().a(false, new String[]{str2});
                        }
                    }
                });
            }
        }
    }

    @Override // c.p.a.a.a.c.h
    public boolean a(@Nullable Context context, @NonNull String str) {
        InterceptResult invokeLL;
        TTCustomController f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (!"android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) || (f2 = com.bytedance.sdk.openadsdk.core.h.d().f()) == null || f2.isCanUseWriteExternal()) {
                if (context == null) {
                    context = o.a();
                }
                return com.bytedance.sdk.openadsdk.core.g.d.a().a(context, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
