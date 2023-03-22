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
/* loaded from: classes7.dex */
public class z43 {
    public static /* synthetic */ Interceptable $ic;
    public static z43 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public WeakReference<y43> b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<t73> a;
        public WeakReference<b72> b;
        public String c;
        public MediaModel d;

        public b(z43 z43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(z43 z43Var, a aVar) {
            this(z43Var);
        }
    }

    public z43() {
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

    public static z43 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (z43.class) {
                    if (c == null) {
                        c = new z43();
                    }
                }
            }
            return c;
        }
        return (z43) invokeV.objValue;
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
            y43 y43Var = this.b.get();
            if (y43Var != null) {
                y43Var.F1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            t73 M = t73.M();
            b72 H = gt2.U().H();
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

    public void e(t73 t73Var, ReplyEditorParams replyEditorParams, v43 v43Var) {
        b72 H;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, t73Var, replyEditorParams, v43Var) == null) && (H = gt2.U().H()) != null && t73Var != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("params", replyEditorParams);
            b bVar = this.a;
            if (bVar != null && t73Var == bVar.a.get() && H == this.a.b.get()) {
                bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
                bundle.putString("content", this.a.c);
                bundle.putParcelable("image", this.a.d);
            }
            y43 y43Var = new y43();
            y43Var.l1(bundle);
            y43Var.S1(v43Var);
            y43Var.v1(H.B(), "ReplyEditor");
            this.b = new WeakReference<>(y43Var);
        }
    }
}
