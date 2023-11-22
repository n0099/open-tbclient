package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.c52;
import com.baidu.tieba.dr2;
import com.baidu.tieba.k53;
import com.baidu.tieba.n43;
import com.baidu.tieba.nz2;
import com.baidu.tieba.o43;
import com.baidu.tieba.p52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j52 extends m52 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView G0;
    public BdBaseImageView H0;
    public TextView I0;
    public dl3 J0;
    public long[] K0;
    public String L0;
    public String M0;
    public String N0;
    public Button O0;
    public RecyclerView P0;
    public SwanAppWebPopWindow Q0;

    @Override // com.baidu.tieba.m52
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m52
    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        /* loaded from: classes6.dex */
        public class a extends nz2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.baidu.tieba.j52$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0355a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0355a(a aVar, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        k53.a aVar = new k53.a(this.b.a.a.c0);
                        aVar.U(R.string.obfuscated_res_0x7f0f017d);
                        aVar.x(this.a);
                        aVar.n(new ol3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f0149, null);
                        aVar.X();
                    }
                }
            }

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.baidu.tieba.nz2.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.c0.runOnUiThread(new RunnableC0355a(this, str));
                }
            }
        }

        public n(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            nz2.e().g(new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class a implements pq3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j52 c;

        /* renamed from: com.baidu.tieba.j52$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class DialogInterface$OnClickListenerC0354a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0354a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    SwanAppActivity w = f63.K().w();
                    if (w != null && Build.VERSION.SDK_INT >= 21) {
                        w.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(j52 j52Var, te3 te3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, te3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j52Var;
            this.a = te3Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pq3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                k53.a aVar = new k53.a(this.c.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f152e);
                aVar.v(R.string.obfuscated_res_0x7f0f152d);
                aVar.n(new ol3());
                aVar.O(R.string.obfuscated_res_0x7f0f0149, new DialogInterface$OnClickListenerC0354a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pq3 c;
        public final /* synthetic */ j52 d;

        /* loaded from: classes6.dex */
        public class a implements c52.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.c52.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.c.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.d.c0;
                    if (activity != null && !activity.isDestroyed()) {
                        c52.b(this.a.d.c0, R.string.obfuscated_res_0x7f0f152e, str);
                    }
                }
            }
        }

        public b(j52 j52Var, te3 te3Var, String str, pq3 pq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, te3Var, str, pq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = j52Var;
            this.a = te3Var;
            this.b = str;
            this.c = pq3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = this.a.getInt(this.b, -1);
                if (i == 1) {
                    this.c.run(Boolean.FALSE);
                } else if (i == 0) {
                    this.c.run(Boolean.TRUE);
                } else {
                    g63 c0 = g63.c0();
                    if (c0 == null) {
                        return;
                    }
                    c52.a(c0, this.d.c0, new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements o43.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ j52 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n43 a;
            public final /* synthetic */ e b;

            public a(e eVar, n43 n43Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, n43Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = n43Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.P0.setVisibility(0);
                    this.b.a.m(this.a);
                }
            }
        }

        public e(j52 j52Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j52Var;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.baidu.tieba.o43.b
        public void a(n43 n43Var) {
            List<n43.a> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, n43Var) == null) && n43Var != null && (list = n43Var.a) != null && list.size() > 0) {
                ak3.e0(new a(this, n43Var));
                SwanAppRelatedSwanListAdapter.l("aboutrelated", null, "show");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        /* loaded from: classes6.dex */
        public class a implements zk3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zk3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        d32.d(this.a.a.z());
                    } else {
                        op2.h().a(this.a.a.c0, null);
                    }
                }
            }
        }

        public f(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // com.baidu.tieba.c52.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    c52.c(this.a.c0, str);
                } else if (d32.a()) {
                    d32.d(this.a.z());
                } else {
                    op2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ j52 b;

        /* loaded from: classes6.dex */
        public class a implements zk3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zk3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        d32.c(this.a.b.z(), true);
                    } else {
                        op2.h().a(this.a.b.c0, null);
                    }
                }
            }
        }

        public j(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.c0 == null) {
                return;
            }
            if (j52.R0) {
                if (ga2.f()) {
                    d32.d(this.b.z());
                    return;
                }
                if (this.a == null) {
                    this.a = tr2.V().o(this.b.c0);
                }
                int i = 0;
                if (this.b.e2()) {
                    if (d32.a()) {
                        d32.c(this.b.z(), false);
                        return;
                    } else {
                        op2.h().f(new a(this));
                        return;
                    }
                }
                if (this.a.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                FullScreenFloatView fullScreenFloatView = this.a;
                if (z) {
                    i = 8;
                }
                fullScreenFloatView.setVisibility(i);
            } else if (this.b.e2()) {
                this.b.F3();
            } else {
                d32.d(this.b.z());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr2 a;
        public final /* synthetic */ g63 b;
        public final /* synthetic */ j52 c;

        /* loaded from: classes6.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public l(j52 j52Var, dr2 dr2Var, g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, dr2Var, g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j52Var;
            this.a = dr2Var;
            this.b = g63Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String x1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.c.c0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(ad2.V().s0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            String str = "";
            if (TextUtils.isEmpty(this.a.x1())) {
                x1 = "";
            } else {
                x1 = this.a.x1();
            }
            sb.append(x1);
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(jy1.c(this.b.b));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.a.j1());
            sb.append("小程序包大小: ");
            if (!TextUtils.isEmpty(formatFileSize)) {
                str = formatFileSize;
            }
            sb.append(str);
            sb.append("(");
            sb.append(this.a.j1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            k53.a aVar = new k53.a(this.c.c0);
            aVar.V(this.c.c0.getResources().getString(R.string.obfuscated_res_0x7f0f01fa));
            aVar.x(sb.toString());
            aVar.n(new ol3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0149, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        /* loaded from: classes6.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public m(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            String e = kf3.c().e(1);
            String string = this.a.c0.getResources().getString(R.string.obfuscated_res_0x7f0f011c);
            k53.a aVar = new k53.a(this.a.c0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new ol3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0149, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public h42 a;
        public final /* synthetic */ j52 b;

        /* loaded from: classes6.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    h42.g(1);
                    this.a.a = new h42(np2.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    h42.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    h42.g(0);
                }
            }
        }

        public o(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j52Var;
        }

        public final void b() {
            h42 h42Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (h42Var = this.a) != null) {
                h42Var.i();
                this.a = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                k53.a aVar = new k53.a(this.b.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f017f);
                aVar.v(R.string.obfuscated_res_0x7f0f016b);
                aVar.n(new ol3());
                aVar.m(true);
                if (h42.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f016c, new a(this));
                }
                if (h42.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f016a, new b(this));
                }
                if (h42.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f1559, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ View b;
        public final /* synthetic */ j52 c;

        public c(j52 j52Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j52Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vg3.d().g();
                this.a.onLongClick(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ long b;
        public final /* synthetic */ j52 c;

        public d(j52 j52Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j52Var;
            this.a = runnable;
            this.b = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        view2.removeCallbacks(this.a);
                        return false;
                    }
                    return false;
                }
                view2.postDelayed(this.a, this.b);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ai2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        public g(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // com.baidu.tieba.ai2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                y53 f = y53.f(this.a.z(), R.string.obfuscated_res_0x7f0f0142);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ai2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y53 f = y53.f(this.a.z(), R.string.obfuscated_res_0x7f0f15c4);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ai2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y53 f = y53.f(this.a.z(), R.string.obfuscated_res_0x7f0f0143);
                f.l(2);
                f.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements zh2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j52 b;

        public h(j52 j52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j52Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.zh2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y53 f = y53.f(this.b.z(), R.string.obfuscated_res_0x7f0f15c4);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.zh2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                y53 f = y53.f(this.b.z(), R.string.obfuscated_res_0x7f0f018b);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.zh2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ed2.t();
                if (wv2.k(this.b.n())) {
                    wv2.p("aboutconcern", this.a);
                    return;
                }
                Context z = this.b.z();
                y53 g = y53.g(z, np2.l0().f(z));
                g.l(2);
                g.q(2);
                g.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        public i(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ j52 b;

        public k(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = tr2.V().L(this.b.c0);
                }
                int i = 0;
                if (this.a.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                SwanAppPropertyWindow swanAppPropertyWindow = this.a;
                if (z) {
                    i = 8;
                }
                swanAppPropertyWindow.setVisibility(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        public p(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j3();
            this.a.q3("click", "baozhang");
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j52 a;

        public q(j52 j52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j52Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.m3();
            return true;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947834210, "Lcom/baidu/tieba/j52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947834210, "Lcom/baidu/tieba/j52;");
                return;
            }
        }
        R0 = rm1.a;
    }

    public j52() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.K0 = new long[5];
    }

    public static j52 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new j52();
        }
        return (j52) invokeV.objValue;
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || g63.c0() == null) {
            return;
        }
        c52.a(g63.c0(), this.c0, new f(this));
    }

    public final void n3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && h0() && (swanAppWebPopWindow = this.Q0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    @Override // com.baidu.tieba.m52, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            n3();
        }
    }

    @Override // com.baidu.tieba.m52
    public void q2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || !e2()) {
            return;
        }
        t3();
        this.g0.r(np2.M().a());
    }

    @Override // com.baidu.tieba.m52
    public void a2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            b2(view2);
            if (!e2()) {
                Q2(false);
            }
            H2(true);
            A2(-1);
            J2(-16777216);
            C2(null);
            E2(true);
        }
    }

    public final void p3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            bg2 l2 = bg2.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            q3("click", "aboutmove");
        }
    }

    public final void s3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            xj3.M(this.H0, this.I0, String.valueOf(i2));
        }
    }

    public final boolean v3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                i2 = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
            } else {
                i2 = pMSAppInfo.payProtected;
            }
            if (i2 == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean w3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, pMSAppInfo)) == null) {
            if (f63.K().k() == 0 && pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.brandsInfo)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.y0(bundle);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0097, viewGroup, false);
            a2(inflate);
            u3(inflate);
            if (Z1()) {
                inflate = c2(inflate);
            }
            return J1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void A3() {
        g63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c0 = g63.c0()) == null) {
            return;
        }
        long[] jArr = this.K0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.K0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.K0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.K0 = new long[5];
            if (c0.x0()) {
                C3();
            } else {
                E3();
            }
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (R0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            p52 W = tr2.V().W();
            if (W == null) {
                y53.f(z(), R.string.obfuscated_res_0x7f0f01d5).G();
                return;
            }
            p52.b i2 = W.i("navigateTo");
            i2.n(p52.g, p52.i);
            i2.k("running_info", null).a();
        }
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (ed2.n(f63.K().getAppId())) {
                this.O0.setText(R.string.obfuscated_res_0x7f0f1572);
                this.O0.setTextColor(AppCompatResources.getColorStateList(z(), R.color.obfuscated_res_0x7f060ab3));
                this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081435);
                return;
            }
            this.O0.setText(R.string.obfuscated_res_0x7f0f153e);
            this.O0.setTextColor(-1);
            this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081433);
        }
    }

    @Override // com.baidu.tieba.m52
    public void T2() {
        p52 W;
        o52 o52Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (W = tr2.V().W()) == null || (o52Var = (o52) W.n(o52.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, o52Var.A3());
        tr2.V().v(new hg2("sharebtn", hashMap));
        q3("click", "aboutshare");
    }

    public final void j3() {
        SwanAppActivity activity;
        g63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (activity = tr2.V().getActivity()) == null || (c0 = g63.c0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.z()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + c0.P());
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.u0(R.string.obfuscated_res_0x7f0f14e8);
        swanAppWebPopWindow2.q0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
        swanAppWebPopWindow2.r0();
        swanAppWebPopWindow2.p0();
        swanAppWebPopWindow2.w0();
    }

    public final void k3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (activity = tr2.V().getActivity()) == null || g63.c0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.z()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.N0);
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.v0(X(R.string.obfuscated_res_0x7f0f1516));
        swanAppWebPopWindow2.s0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070816));
        swanAppWebPopWindow2.q0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
        swanAppWebPopWindow2.p0();
        swanAppWebPopWindow2.w0();
        q3("click", "servicenote");
    }

    public final void B3(View view2, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, str) == null) {
            if (R0) {
                Log.i("SwanAppAboutFragment", str + "");
            }
            if (!TextUtils.isEmpty(str) && view2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.L0 = jSONObject.optString("scheme");
                    this.M0 = jSONObject.optString("description");
                    if (!TextUtils.isEmpty(this.L0) && !TextUtils.isEmpty(this.M0) && (length = this.M0.length()) >= 20) {
                        if (length > 100) {
                            this.M0 = this.M0.substring(0, 100);
                        }
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904b1);
                        linearLayout.setOnClickListener(this);
                        linearLayout.setVisibility(0);
                        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904af)).setText(this.M0);
                        SwanAppRelatedSwanListAdapter.l("brand", null, "show");
                        D3();
                    }
                } catch (JSONException e2) {
                    if (R0) {
                        Log.i("SwanAppAboutFragment", e2.getMessage());
                    }
                }
            }
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String g2 = zi3.g(this.c0);
            y53.g(AppRuntime.getAppContext(), g2).F();
            g32.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(z());
            linearLayoutManager.setOrientation(1);
            this.P0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(z());
            this.P0.setAdapter(swanAppRelatedSwanListAdapter);
            o43.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    @Override // com.baidu.tieba.m52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            dl3 dl3Var = this.J0;
            if (dl3Var != null) {
                dl3Var.c();
            }
            O2(1);
            nc4 nc4Var = this.g0;
            if (nc4Var != null && nc4Var.i()) {
                this.g0.A(np2.M().a());
            }
            if (this.O0 != null) {
                G3();
            }
        }
    }

    public void t3() {
        FragmentActivity n2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (n2 = n()) != null && this.g0 == null) {
            nc4 nc4Var = new nc4(n2, this.f0, 13, np2.K(), new pl3());
            this.g0 = nc4Var;
            nc4Var.p(ak3.P());
            new wv2(this.g0, this).z();
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            String P = f63.K().q().P();
            if (TextUtils.isEmpty(P)) {
                return;
            }
            if (ed2.n(P)) {
                p3(P);
            } else {
                o3(P);
            }
            G3();
        }
    }

    @NonNull
    public final String i3(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str2.startsWith(File.separator)) {
                str2 = str2.substring(1);
            }
            return str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void l3() {
        g63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (c0 = g63.c0()) == null) {
            return;
        }
        dr2.a X = c0.X();
        String K = X.K();
        String G = X.G();
        if (!TextUtils.isEmpty(K) && !TextUtils.isEmpty(G)) {
            String h2 = ak3.h(K, G);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new d73());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.c0, unitedSchemeEntity);
            if (R0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (R0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.c0 == null) {
            return;
        }
        String str = f63.K().q().X().g0().webUrl;
        if (TextUtils.isEmpty(str)) {
            bk3.b(this.c0).c("");
            y53.f(this.c0, R.string.obfuscated_res_0x7f0f15e1).G();
            return;
        }
        String i3 = i3(str, gw2.b(ak3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f15e2;
        if (i3.length() > 4000) {
            i2 = R.string.obfuscated_res_0x7f0f15e3;
        } else {
            str = i3;
        }
        bk3.b(this.c0).c(str);
        y53.f(this.c0, i2).G();
    }

    public final void o3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (f23.H()) {
                if (R0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                y53.f(z(), R.string.obfuscated_res_0x7f0f015d).G();
                return;
            }
            String e2 = ak3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            wv2.p("aboutconcern", e2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0901bf) {
                A3();
            } else if (id == R.id.obfuscated_res_0x7f091a6c) {
                l3();
            } else if (id == R.id.obfuscated_res_0x7f0904b1) {
                SchemeRouter.invoke(z(), this.L0);
                q3("click", "brand");
            } else if (id == R.id.obfuscated_res_0x7f090185) {
                k3();
            } else if (id == R.id.obfuscated_res_0x7f09221f) {
                T2();
            } else if (id == R.id.obfuscated_res_0x7f090140) {
                y3();
            }
        }
    }

    public final void r3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            String b2 = k52.b();
            te3 a2 = k52.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090517);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f152b);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f152c);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    public final void q3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            jd3 jd3Var = new jd3();
            if (!TextUtils.isEmpty(str)) {
                jd3Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                jd3Var.e = str2;
            }
            F1(jd3Var);
        }
    }

    public final void u3(View view2) {
        g63 c0;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, view2) == null) && (c0 = g63.c0()) != null && c0.X() != null) {
            dr2.a X = c0.X();
            this.G0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901bf);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ce);
            textView.setText(X.L());
            if (X.H() == 0) {
                jl3.a(textView, new i(this));
            }
            tz2.h().l().f(textView);
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b6);
            textView2.setText(X.f1());
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09221f);
            button.setOnClickListener(this);
            Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090140);
            this.O0 = button2;
            button2.setOnClickListener(this);
            G3();
            if (np2.y0().d()) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            if (!np2.t().b()) {
                this.O0.setVisibility(8);
            }
            p52 W = tr2.V().W();
            if (W == null) {
                return;
            }
            if (W.n(op2.c().a()) != null) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            el4.b().a(textView2);
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921fa)).setText(X.t1());
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f09236b)).setText(X.u1());
            String G = np2.o().G();
            this.N0 = G;
            if (!TextUtils.isEmpty(G)) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090185);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.P0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091f1d);
            PMSAppInfo g0 = X.g0();
            if (w3(g0)) {
                B3(view2, g0.brandsInfo);
            }
            this.I0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c3);
            this.H0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901c2);
            this.G0.setImageBitmap(ak3.i(X, "SwanAppAboutFragment", false));
            this.G0.setOnClickListener(this);
            SwanAppBearInfo l1 = X.l1();
            if (l1 != null && l1.isValid()) {
                this.J0 = new dl3(this.c0, view2, l1, R.id.obfuscated_res_0x7f0903e6);
            }
            s3(X.w1());
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f091a6c)).setVisibility(8);
            if (R0 || tr2.V().O()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09018d)).inflate();
                if (e2() && (inflate instanceof Button)) {
                    Button button3 = (Button) inflate;
                    if (X.n0()) {
                        i2 = R.string.obfuscated_res_0x7f0f0147;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f01d3;
                    }
                    button3.setText(i2);
                }
                inflate.setOnClickListener(new j(this));
                if (!e2()) {
                    ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09018e)).inflate().setOnClickListener(new k(this));
                }
                if (e2()) {
                    ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090190)).inflate().setOnClickListener(new l(this, X, c0));
                }
                if (e2()) {
                    View inflate2 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090192)).inflate();
                    if (inflate2 instanceof Button) {
                        Button button4 = (Button) inflate2;
                        button4.setText(R.string.obfuscated_res_0x7f0f011c);
                        button4.setOnClickListener(new m(this));
                    }
                }
                if (nz2.e().f()) {
                    View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09018f)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button5 = (Button) inflate3;
                        button5.setText(R.string.obfuscated_res_0x7f0f017d);
                        button5.setOnClickListener(new n(this));
                    }
                }
                View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090191)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f017f);
                }
                inflate4.setOnClickListener(new o(this));
                if (!e2()) {
                    r3(view2);
                }
            }
            if (v3(g0)) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902dd);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new p(this));
            }
            if (!e2()) {
                z3(this.G0, 2000L, new q(this));
            }
        }
    }

    public final void z3(View view2, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{view2, Long.valueOf(j2), onLongClickListener}) == null) && view2 != null && onLongClickListener != null && j2 > 0) {
            view2.setOnTouchListener(new d(this, new c(this, onLongClickListener, view2), j2));
        }
    }
}
