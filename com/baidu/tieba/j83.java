package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class j83 {
    public static /* synthetic */ Interceptable $ic;
    public static j83 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public WeakReference<i83> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<db3> a;
        public WeakReference<la2> b;
        public String c;
        public MediaModel d;

        public b(j83 j83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(j83 j83Var, a aVar) {
            this(j83Var);
        }
    }

    public j83() {
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

    public static j83 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (j83.class) {
                    if (c == null) {
                        c = new j83();
                    }
                }
            }
            return c;
        }
        return (j83) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i83 i83Var = this.b.get();
            if (i83Var != null) {
                i83Var.D1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            db3 M = db3.M();
            la2 H = qw2.T().H();
            if (M != null && H != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.a = new WeakReference<>(M);
                this.a.b = new WeakReference<>(H);
                b bVar2 = this.a;
                bVar2.c = str;
                bVar2.d = mediaModel;
                return;
            }
            this.a = null;
        }
    }

    public void e(db3 db3Var, ReplyEditorParams replyEditorParams, f83 f83Var) {
        la2 H;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, db3Var, replyEditorParams, f83Var) == null) && (H = qw2.T().H()) != null && db3Var != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("params", replyEditorParams);
            b bVar = this.a;
            if (bVar != null && db3Var == bVar.a.get() && H == this.a.b.get()) {
                bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
                bundle.putString("content", this.a.c);
                bundle.putParcelable("image", this.a.d);
            }
            i83 i83Var = new i83();
            i83Var.j1(bundle);
            i83Var.R1(f83Var);
            i83Var.u1(H.A(), "ReplyEditor");
            this.b = new WeakReference<>(i83Var);
        }
    }
}
