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
public class n33 {
    public static /* synthetic */ Interceptable $ic;
    public static n33 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public WeakReference<m33> b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<h63> a;
        public WeakReference<p52> b;
        public String c;
        public MediaModel d;

        public b(n33 n33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(n33 n33Var, a aVar) {
            this(n33Var);
        }
    }

    public n33() {
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

    public static n33 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (n33.class) {
                    if (c == null) {
                        c = new n33();
                    }
                }
            }
            return c;
        }
        return (n33) invokeV.objValue;
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
            m33 m33Var = this.b.get();
            if (m33Var != null) {
                m33Var.H1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            h63 M = h63.M();
            p52 J = ur2.V().J();
            if (M != null && J != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.a = new WeakReference<>(M);
                this.a.b = new WeakReference<>(J);
                b bVar2 = this.a;
                bVar2.c = str;
                bVar2.d = mediaModel;
                return;
            }
            this.a = null;
        }
    }

    public void e(h63 h63Var, ReplyEditorParams replyEditorParams, j33 j33Var) {
        p52 J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, h63Var, replyEditorParams, j33Var) == null) && (J = ur2.V().J()) != null && h63Var != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("params", replyEditorParams);
            b bVar = this.a;
            if (bVar != null && h63Var == bVar.a.get() && J == this.a.b.get()) {
                bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
                bundle.putString("content", this.a.c);
                bundle.putParcelable("image", this.a.d);
            }
            m33 m33Var = new m33();
            m33Var.m1(bundle);
            m33Var.V1(j33Var);
            m33Var.x1(J.D(), "ReplyEditor");
            this.b = new WeakReference<>(m33Var);
        }
    }
}
