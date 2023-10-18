package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t03;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface c {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public static class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (na3.h(sa3Var)) {
                    qa4.c(this.a);
                } else {
                    this.a.onFail();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements t03.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.t03.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) {
                if (i != 0) {
                    this.a.onFail();
                    return;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        this.a.onFail();
                        return;
                    }
                }
                this.a.onSuccess();
            }
        }
    }

    public static void b(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, cVar) == null) {
            if (!(context instanceof Activity)) {
                cVar.onFail();
                return;
            }
            p53 M = p53.M();
            if (M != null) {
                M.f0().g((Activity) context, "mapp_location", new a(cVar));
            }
        }
    }

    public static void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            p53 c0 = p53.c0();
            if (jj3.M() && c0 != null) {
                cVar.onSuccess();
            } else {
                c0.w().z(0, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, new b(cVar));
            }
        }
    }
}
