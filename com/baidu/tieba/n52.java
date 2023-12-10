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
import com.baidu.tieba.g52;
import com.baidu.tieba.hr2;
import com.baidu.tieba.o53;
import com.baidu.tieba.r43;
import com.baidu.tieba.rz2;
import com.baidu.tieba.s43;
import com.baidu.tieba.t52;
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
/* loaded from: classes7.dex */
public class n52 extends q52 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView G0;
    public BdBaseImageView H0;
    public TextView I0;
    public hl3 J0;
    public long[] K0;
    public String L0;
    public String M0;
    public String N0;
    public Button O0;
    public RecyclerView P0;
    public SwanAppWebPopWindow Q0;

    @Override // com.baidu.tieba.q52
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        /* loaded from: classes7.dex */
        public class a extends rz2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.baidu.tieba.n52$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0402a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0402a(a aVar, String str) {
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
                        o53.a aVar = new o53.a(this.b.a.a.c0);
                        aVar.U(R.string.obfuscated_res_0x7f0f0185);
                        aVar.x(this.a);
                        aVar.n(new sl3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f0151, null);
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

            @Override // com.baidu.tieba.rz2.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.c0.runOnUiThread(new RunnableC0402a(this, str));
                }
            }
        }

        public n(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            rz2.e().g(new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class a implements tq3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ n52 c;

        /* renamed from: com.baidu.tieba.n52$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnClickListenerC0401a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0401a(a aVar) {
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
                    SwanAppActivity w = j63.K().w();
                    if (w != null && Build.VERSION.SDK_INT >= 21) {
                        w.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(n52 n52Var, xe3 xe3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, xe3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n52Var;
            this.a = xe3Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tq3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                o53.a aVar = new o53.a(this.c.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f153f);
                aVar.v(R.string.obfuscated_res_0x7f0f153e);
                aVar.n(new sl3());
                aVar.O(R.string.obfuscated_res_0x7f0f0151, new DialogInterface$OnClickListenerC0401a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tq3 c;
        public final /* synthetic */ n52 d;

        /* loaded from: classes7.dex */
        public class a implements g52.b {
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

            @Override // com.baidu.tieba.g52.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.c.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.d.c0;
                    if (activity != null && !activity.isDestroyed()) {
                        g52.b(this.a.d.c0, R.string.obfuscated_res_0x7f0f153f, str);
                    }
                }
            }
        }

        public b(n52 n52Var, xe3 xe3Var, String str, tq3 tq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, xe3Var, str, tq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n52Var;
            this.a = xe3Var;
            this.b = str;
            this.c = tq3Var;
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
                    k63 c0 = k63.c0();
                    if (c0 == null) {
                        return;
                    }
                    g52.a(c0, this.d.c0, new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements s43.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ n52 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r43 a;
            public final /* synthetic */ e b;

            public a(e eVar, r43 r43Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, r43Var};
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
                this.a = r43Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.P0.setVisibility(0);
                    this.b.a.n(this.a);
                }
            }
        }

        public e(n52 n52Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n52Var;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.baidu.tieba.s43.b
        public void a(r43 r43Var) {
            List<r43.a> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, r43Var) == null) && r43Var != null && (list = r43Var.a) != null && list.size() > 0) {
                ek3.e0(new a(this, r43Var));
                SwanAppRelatedSwanListAdapter.l("aboutrelated", null, "show");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements g52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        /* loaded from: classes7.dex */
        public class a implements dl3<Boolean> {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        h32.d(this.a.a.z());
                    } else {
                        sp2.h().a(this.a.a.c0, null);
                    }
                }
            }
        }

        public f(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
        }

        @Override // com.baidu.tieba.g52.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    g52.c(this.a.c0, str);
                } else if (h32.a()) {
                    h32.d(this.a.z());
                } else {
                    sp2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ n52 b;

        /* loaded from: classes7.dex */
        public class a implements dl3<Boolean> {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        h32.c(this.a.b.z(), true);
                    } else {
                        sp2.h().a(this.a.b.c0, null);
                    }
                }
            }
        }

        public j(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.c0 == null) {
                return;
            }
            if (n52.R0) {
                if (ka2.f()) {
                    h32.d(this.b.z());
                    return;
                }
                if (this.a == null) {
                    this.a = xr2.V().o(this.b.c0);
                }
                int i = 0;
                if (this.b.e2()) {
                    if (h32.a()) {
                        h32.c(this.b.z(), false);
                        return;
                    } else {
                        sp2.h().f(new a(this));
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
                h32.d(this.b.z());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr2 a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ n52 c;

        /* loaded from: classes7.dex */
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

        public l(n52 n52Var, hr2 hr2Var, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, hr2Var, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n52Var;
            this.a = hr2Var;
            this.b = k63Var;
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
            sb.append(ed2.V().s0());
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
            sb.append(ny1.c(this.b.b));
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
            o53.a aVar = new o53.a(this.c.c0);
            aVar.V(this.c.c0.getResources().getString(R.string.obfuscated_res_0x7f0f0202));
            aVar.x(sb.toString());
            aVar.n(new sl3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0151, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        /* loaded from: classes7.dex */
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

        public m(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            String e = of3.c().e(1);
            String string = this.a.c0.getResources().getString(R.string.obfuscated_res_0x7f0f0124);
            o53.a aVar = new o53.a(this.a.c0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new sl3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0151, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public l42 a;
        public final /* synthetic */ n52 b;

        /* loaded from: classes7.dex */
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
                    l42.g(1);
                    this.a.a = new l42(rp2.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    l42.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    l42.g(0);
                }
            }
        }

        public o(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n52Var;
        }

        public final void b() {
            l42 l42Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l42Var = this.a) != null) {
                l42Var.i();
                this.a = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                o53.a aVar = new o53.a(this.b.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f0187);
                aVar.v(R.string.obfuscated_res_0x7f0f0173);
                aVar.n(new sl3());
                aVar.m(true);
                if (l42.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f0174, new a(this));
                }
                if (l42.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f0172, new b(this));
                }
                if (l42.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f156a, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ View b;
        public final /* synthetic */ n52 c;

        public c(n52 n52Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n52Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zg3.d().g();
                this.a.onLongClick(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ long b;
        public final /* synthetic */ n52 c;

        public d(n52 n52Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n52Var;
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

    /* loaded from: classes7.dex */
    public class g implements ei2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        public g(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
        }

        @Override // com.baidu.tieba.ei2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                c63 f = c63.f(this.a.z(), R.string.obfuscated_res_0x7f0f014a);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ei2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63 f = c63.f(this.a.z(), R.string.obfuscated_res_0x7f0f15d5);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ei2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c63 f = c63.f(this.a.z(), R.string.obfuscated_res_0x7f0f014b);
                f.l(2);
                f.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements di2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ n52 b;

        public h(n52 n52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n52Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.di2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63 f = c63.f(this.b.z(), R.string.obfuscated_res_0x7f0f15d5);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.di2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                c63 f = c63.f(this.b.z(), R.string.obfuscated_res_0x7f0f0193);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.di2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                id2.t();
                if (aw2.k(this.b.n())) {
                    aw2.p("aboutconcern", this.a);
                    return;
                }
                Context z = this.b.z();
                c63 g = c63.g(z, rp2.l0().f(z));
                g.l(2);
                g.q(2);
                g.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        public i(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ n52 b;

        public k(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = xr2.V().L(this.b.c0);
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

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        public p(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
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

    /* loaded from: classes7.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n52 a;

        public q(n52 n52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n52Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947953374, "Lcom/baidu/tieba/n52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947953374, "Lcom/baidu/tieba/n52;");
                return;
            }
        }
        R0 = vm1.a;
    }

    public n52() {
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

    public static n52 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new n52();
        }
        return (n52) invokeV.objValue;
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || k63.c0() == null) {
            return;
        }
        g52.a(k63.c0(), this.c0, new f(this));
    }

    public final void n3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && h0() && (swanAppWebPopWindow = this.Q0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            n3();
        }
    }

    @Override // com.baidu.tieba.q52
    public void p2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || !e2()) {
            return;
        }
        t3();
        this.g0.r(rp2.M().a());
    }

    @Override // com.baidu.tieba.q52
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
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            fg2 l2 = fg2.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            q3("click", "aboutmove");
        }
    }

    public final void s3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            bk3.M(this.H0, this.I0, String.valueOf(i2));
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
            if (j63.K().k() == 0 && pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.brandsInfo)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.x0(bundle);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0098, viewGroup, false);
            a2(inflate);
            u3(inflate);
            if (Z1()) {
                inflate = c2(inflate);
            }
            return I1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void A3() {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (c0 = k63.c0()) == null) {
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
            t52 W = xr2.V().W();
            if (W == null) {
                c63.f(z(), R.string.obfuscated_res_0x7f0f01dd).G();
                return;
            }
            t52.b i2 = W.i("navigateTo");
            i2.n(t52.g, t52.i);
            i2.k("running_info", null).a();
        }
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (id2.n(j63.K().getAppId())) {
                this.O0.setText(R.string.obfuscated_res_0x7f0f1583);
                this.O0.setTextColor(AppCompatResources.getColorStateList(z(), R.color.obfuscated_res_0x7f060aba));
                this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f08145b);
                return;
            }
            this.O0.setText(R.string.obfuscated_res_0x7f0f154f);
            this.O0.setTextColor(-1);
            this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081459);
        }
    }

    @Override // com.baidu.tieba.q52
    public void T2() {
        t52 W;
        s52 s52Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (W = xr2.V().W()) == null || (s52Var = (s52) W.n(s52.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, s52Var.A3());
        xr2.V().v(new lg2("sharebtn", hashMap));
        q3("click", "aboutshare");
    }

    public final void j3() {
        SwanAppActivity activity;
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (activity = xr2.V().getActivity()) == null || (c0 = k63.c0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.z()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + c0.P());
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.u0(R.string.obfuscated_res_0x7f0f14f9);
        swanAppWebPopWindow2.q0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
        swanAppWebPopWindow2.r0();
        swanAppWebPopWindow2.p0();
        swanAppWebPopWindow2.w0();
    }

    public final void k3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (activity = xr2.V().getActivity()) == null || k63.c0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.z()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.N0);
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.v0(X(R.string.obfuscated_res_0x7f0f1527));
        swanAppWebPopWindow2.s0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07082d));
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
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904cb);
                        linearLayout.setOnClickListener(this);
                        linearLayout.setVisibility(0);
                        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904c9)).setText(this.M0);
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
            String g2 = dj3.g(this.c0);
            c63.g(AppRuntime.getAppContext(), g2).F();
            k32.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
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
            s43.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            hl3 hl3Var = this.J0;
            if (hl3Var != null) {
                hl3Var.c();
            }
            O2(1);
            rc4 rc4Var = this.g0;
            if (rc4Var != null && rc4Var.i()) {
                this.g0.A(rp2.M().a());
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
            rc4 rc4Var = new rc4(n2, this.f0, 13, rp2.K(), new tl3());
            this.g0 = rc4Var;
            rc4Var.p(ek3.P());
            new aw2(this.g0, this).z();
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            String P = j63.K().q().P();
            if (TextUtils.isEmpty(P)) {
                return;
            }
            if (id2.n(P)) {
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
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (c0 = k63.c0()) == null) {
            return;
        }
        hr2.a X = c0.X();
        String K = X.K();
        String G = X.G();
        if (!TextUtils.isEmpty(K) && !TextUtils.isEmpty(G)) {
            String h2 = ek3.h(K, G);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new h73());
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
        String str = j63.K().q().X().g0().webUrl;
        if (TextUtils.isEmpty(str)) {
            fk3.b(this.c0).c("");
            c63.f(this.c0, R.string.obfuscated_res_0x7f0f15f2).G();
            return;
        }
        String i3 = i3(str, kw2.b(ek3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f15f3;
        if (i3.length() > 4000) {
            i2 = R.string.obfuscated_res_0x7f0f15f4;
        } else {
            str = i3;
        }
        fk3.b(this.c0).c(str);
        c63.f(this.c0, i2).G();
    }

    public final void o3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (j23.H()) {
                if (R0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                c63.f(z(), R.string.obfuscated_res_0x7f0f0165).G();
                return;
            }
            String e2 = ek3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            aw2.p("aboutconcern", e2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0901d2) {
                A3();
            } else if (id == R.id.obfuscated_res_0x7f091ae3) {
                l3();
            } else if (id == R.id.obfuscated_res_0x7f0904cb) {
                SchemeRouter.invoke(z(), this.L0);
                q3("click", "brand");
            } else if (id == R.id.obfuscated_res_0x7f090185) {
                k3();
            } else if (id == R.id.obfuscated_res_0x7f09229b) {
                T2();
            } else if (id == R.id.obfuscated_res_0x7f090140) {
                y3();
            }
        }
    }

    public final void r3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            String b2 = o52.b();
            xe3 a2 = o52.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090532);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f153c);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f153d);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    public final void q3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            nd3 nd3Var = new nd3();
            if (!TextUtils.isEmpty(str)) {
                nd3Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                nd3Var.e = str2;
            }
            E1(nd3Var);
        }
    }

    public final void u3(View view2) {
        k63 c0;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, view2) == null) && (c0 = k63.c0()) != null && c0.X() != null) {
            hr2.a X = c0.X();
            this.G0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901d2);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901e1);
            textView.setText(X.L());
            if (X.H() == 0) {
                nl3.a(textView, new i(this));
            }
            xz2.h().l().f(textView);
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c9);
            textView2.setText(X.f1());
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09229b);
            button.setOnClickListener(this);
            Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090140);
            this.O0 = button2;
            button2.setOnClickListener(this);
            G3();
            if (rp2.y0().d()) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            if (!rp2.t().b()) {
                this.O0.setVisibility(8);
            }
            t52 W = xr2.V().W();
            if (W == null) {
                return;
            }
            if (W.n(sp2.c().a()) != null) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            il4.b().a(textView2);
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f092276)).setText(X.t1());
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ef)).setText(X.u1());
            String G = rp2.o().G();
            this.N0 = G;
            if (!TextUtils.isEmpty(G)) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090185);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.P0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091f96);
            PMSAppInfo g0 = X.g0();
            if (w3(g0)) {
                B3(view2, g0.brandsInfo);
            }
            this.I0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901d6);
            this.H0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901d5);
            this.G0.setImageBitmap(ek3.i(X, "SwanAppAboutFragment", false));
            this.G0.setOnClickListener(this);
            SwanAppBearInfo l1 = X.l1();
            if (l1 != null && l1.isValid()) {
                this.J0 = new hl3(this.c0, view2, l1, R.id.obfuscated_res_0x7f0903fa);
            }
            s3(X.w1());
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f091ae3)).setVisibility(8);
            if (R0 || xr2.V().O()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09018d)).inflate();
                if (e2() && (inflate instanceof Button)) {
                    Button button3 = (Button) inflate;
                    if (X.n0()) {
                        i2 = R.string.obfuscated_res_0x7f0f014f;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f01db;
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
                        button4.setText(R.string.obfuscated_res_0x7f0f0124);
                        button4.setOnClickListener(new m(this));
                    }
                }
                if (rz2.e().f()) {
                    View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09018f)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button5 = (Button) inflate3;
                        button5.setText(R.string.obfuscated_res_0x7f0f0185);
                        button5.setOnClickListener(new n(this));
                    }
                }
                View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090191)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f0187);
                }
                inflate4.setOnClickListener(new o(this));
                if (!e2()) {
                    r3(view2);
                }
            }
            if (v3(g0)) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902f1);
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
