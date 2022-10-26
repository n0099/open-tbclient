package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.e33;
import com.baidu.tieba.m23;
import com.baidu.tieba.n23;
import com.baidu.tieba.q23;
import com.baidu.tieba.s23;
import com.baidu.tieba.t23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oq3 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public static r23 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "utils" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ JSONObject g;
        public final /* synthetic */ String h;

        /* loaded from: classes5.dex */
        public class a implements e33.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.e33.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.a;
                    dVar.e.handleSchemeDispatchCallback(dVar.h, "");
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements e33.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.e33.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.a;
                    dVar.e.handleSchemeDispatchCallback(dVar.h, "");
                }
            }
        }

        public d(oq3 oq3Var, String str, Context context, String str2, int i, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, str, context, str2, Integer.valueOf(i), callbackHandler, unitedSchemeEntity, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = context;
            this.c = str2;
            this.d = i;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = jSONObject;
            this.h = str3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.a;
                switch (str.hashCode()) {
                    case 49:
                        if (str.equals("1")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    Uri uri = null;
                    if (c != 1) {
                        if (c != 2) {
                            this.f.result = UnitedSchemeUtility.wrapCallbackParams(202);
                            return;
                        }
                        String optString = this.g.optString("icon");
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                uri = Uri.parse(optString);
                            } catch (Exception unused) {
                            }
                        }
                        if (TextUtils.equals(this.g.optString("bottomIconStyle"), "2")) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                        String optString2 = this.g.optString("title");
                        String optString3 = this.g.optString("buttonText");
                        String optString4 = this.g.optString("style");
                        if ("2".equals(this.g.optString("bottomShowAnimationType"))) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                        if (TextUtils.isEmpty(this.h)) {
                            this.f.result = UnitedSchemeUtility.wrapCallbackParams(202);
                            return;
                        } else if (!TextUtils.equals(optString4, "2") && !TextUtils.equals(optString4, "3")) {
                            e33 e = e33.e(this.b);
                            e.o(uri);
                            e.h(i);
                            e.t(optString2);
                            e.r(this.c);
                            e.k(optString3);
                            e.j(1);
                            e.i(i2);
                            e.l(this.d);
                            e.u(new b(this));
                            e.D();
                            UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(0));
                            return;
                        } else {
                            e33 e2 = e33.e(this.b);
                            e2.o(uri);
                            e2.h(i);
                            e2.t(optString2);
                            e2.r(this.c);
                            e2.k(optString3);
                            e2.j(2);
                            e2.i(i2);
                            e2.l(this.d);
                            e2.u(new a(this));
                            e2.D();
                            UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(0));
                            return;
                        }
                    }
                    e33 g = e33.g(this.b, this.c);
                    g.n(null);
                    g.l(this.d);
                    g.B();
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(0));
                    return;
                }
                e33 g2 = e33.g(this.b, this.c);
                g2.l(this.d);
                g2.G();
                UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        public a(oq3 oq3Var, List list, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, list, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = context;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (String) this.a.get(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = View.inflate(this.b, R.layout.obfuscated_res_0x7f0d00ce, null);
                }
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920ff);
                textView.setTextColor(this.c);
                textView.setText(getItem(i));
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ q23 c;

        public b(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, q23 q23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity, q23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = q23Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tapIndex", i);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    this.c.dismiss();
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e33.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public e(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                r23 unused = oq3.a = null;
                UnitedSchemeUtility.callCallback(this.a, this.b, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;

        public f(oq3 oq3Var, boolean z, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, Boolean.valueOf(z), callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                r23 unused = oq3.a = null;
                try {
                    JSONArray f = ((n23) dialogInterface).f();
                    JSONObject jSONObject = new JSONObject();
                    if (f != null && f.length() > 0) {
                        if (this.a) {
                            jSONObject.put("value", f.optInt(0));
                        } else {
                            jSONObject.put("value", f);
                        }
                    }
                    UnitedSchemeUtility.callCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements BdMultiPicker.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;

        public g(oq3 oq3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
        public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                String optString = UnitedSchemeUtility.optParamsAsJo(this.a).optString("cb");
                if (!TextUtils.isEmpty(optString)) {
                    this.b.handleSchemeDispatchCallback(optString, jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public h(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                UnitedSchemeUtility.callCallback(this.a, this.b, 0);
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public i(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                s23 s23Var = (s23) dialogInterface;
                String format = String.format("%02d:%02d", Integer.valueOf(s23Var.f()), Integer.valueOf(s23Var.g()));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", format);
                    JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    if (wj1.a) {
                        Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                    }
                    UnitedSchemeUtility.callCallback(this.a, this.b, wrapCallbackParams);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public j(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                UnitedSchemeUtility.callCallback(this.a, this.b, 0);
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public k(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof m23) {
                    String h = ((m23) dialogInterface).h();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", h);
                        JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        if (wj1.a) {
                            Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                        }
                        UnitedSchemeUtility.callCallback(this.a, this.b, wrapCallbackParams);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public l(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "cancel");
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public m(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "cancel");
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public n(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "confirm");
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public o(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public p(oq3 oq3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }
    }

    public oq3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final int E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return (int) Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String d(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, configuration)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                return configuration.locale.toString();
            }
            if (i2 < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context instanceof SwanAppActivity) {
                i2 = ((SwanAppActivity) context).R();
            } else {
                i2 = 0;
            }
            if (i2 == 1) {
                return rc3.i(um2.i().m(), i2);
            }
            return rc3.i(ga2.U().d0(), i2);
        }
        return (String) invokeL.objValue;
    }

    public final boolean A(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("fields");
            if (TextUtils.isEmpty(optString)) {
                optString = BdPlayerProgressView.DEFAULT_TIME_TEXT;
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "23:59";
            }
            Date D = D(optString);
            Date D2 = D(optString2);
            Date D3 = D(optString3);
            if (D3 == null) {
                D3 = D(new SimpleDateFormat("HH:mm").format(new Date()));
            }
            if (D != null && D2 != null && !D2.before(D) && D3 != null && !D3.before(D) && !D3.after(D2)) {
                s23.a aVar = new s23.a(context);
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.n(optString4);
                }
                aVar.p(D);
                aVar.m(D2);
                aVar.o(D3);
                aVar.l(optBoolean);
                aVar.h(R.string.obfuscated_res_0x7f0f011a, new i(this, callbackHandler, unitedSchemeEntity));
                aVar.d(R.string.obfuscated_res_0x7f0f0112, new h(this, callbackHandler, unitedSchemeEntity));
                aVar.k();
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Date d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, unitedSchemeEntity, callbackHandler, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("fields");
            if (TextUtils.isEmpty(optString)) {
                optString = "1900-01-01";
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "2099-12-31";
            }
            Date c2 = ag3.c(optString, "yyyy-MM-dd");
            Date c3 = ag3.c(optString2, "yyyy-MM-dd");
            if (c2 != null && c3 != null && !c3.before(c2)) {
                Date date = new Date();
                if (!TextUtils.isEmpty(optString3) && (d2 = ag3.d(optString3, new String[]{"yyyy-MM-dd", "yyyy-MM", "yyyy"})) != null) {
                    date = d2;
                }
                if (date.before(c2)) {
                    date = c2;
                } else if (date.after(c3)) {
                    date = c3;
                }
                m23.a aVar = new m23.a(context);
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.n(optString4);
                }
                aVar.p(c2);
                aVar.m(c3);
                aVar.o(date);
                aVar.l(optBoolean);
                aVar.h(R.string.obfuscated_res_0x7f0f011a, new k(this, callbackHandler, unitedSchemeEntity));
                aVar.d(R.string.obfuscated_res_0x7f0f0112, new j(this, callbackHandler, unitedSchemeEntity));
                aVar.k();
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{context, unitedSchemeEntity, callbackHandler, Boolean.valueOf(z)})) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (a != null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                String string = context.getString(R.string.obfuscated_res_0x7f0f01ab);
                if (!TextUtils.isEmpty(param)) {
                    JSONObject jSONObject = new JSONObject(param);
                    JSONArray optJSONArray = jSONObject.optJSONArray("array");
                    jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                    jSONObject.optString("title", string);
                    jSONArray = optJSONArray;
                }
                n23.a aVar = new n23.a(context);
                aVar.l(jSONArray);
                aVar.m(jSONArray2);
                aVar.o(z);
                aVar.n(new g(this, unitedSchemeEntity, callbackHandler));
                aVar.h(R.string.obfuscated_res_0x7f0f011a, new f(this, z, callbackHandler, unitedSchemeEntity));
                aVar.d(R.string.obfuscated_res_0x7f0f0112, new e(this, callbackHandler, unitedSchemeEntity));
                a = aVar.k();
                return false;
            } catch (JSONException e2) {
                if (wj1.a) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final boolean B(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            gh3.e0(new c(this));
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject f2 = f(context);
            if (f2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(f2, 0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject f2 = f(context);
            if (f2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(f2, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            return q(context, unitedSchemeEntity, callbackHandler, false);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean C(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(param);
                    int i2 = jSONObject.getInt(CriusAttrConstants.COLUMN);
                    JSONArray optJSONArray = jSONObject.optJSONArray("array");
                    int i3 = jSONObject.getInt(ProgressInfo.JSON_KEY_CURRENT);
                    if (optJSONArray != null) {
                        ((n23) a).k(i2, optJSONArray, i3);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    return true;
                } catch (JSONException e2) {
                    if (wj1.a) {
                        e2.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            HashMap params = unitedSchemeEntity.getParams();
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            JSONArray optJSONArray = optParamsAsJo.optJSONArray("array");
            int optInt = optParamsAsJo.optInt(ProgressInfo.JSON_KEY_CURRENT);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(optJSONArray);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(optInt);
                try {
                    optParamsAsJo.put("array", jSONArray);
                    optParamsAsJo.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                    params.put("params", optParamsAsJo.toString());
                    return q(context, unitedSchemeEntity, callbackHandler, true);
                } catch (JSONException unused) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(param);
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    z(optJSONArray);
                    int c2 = c(jSONObject, optJSONArray);
                    if (c2 >= 0 && c2 < optJSONArray.length()) {
                        String[] strArr = new String[optJSONArray.length()];
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            strArr[i2] = optJSONArray.getString(i2);
                        }
                        tm2.C().d(context, strArr, c2);
                        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } catch (JSONException e2) {
                if (wj1.a) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r4 == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        r10.result = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(202);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        return g(r9, r10, r11, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(param);
                String optString = jSONObject.optString("mode");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 3076014) {
                    if (hashCode == 3560141 && optString.equals("time")) {
                        c2 = 0;
                    }
                } else if (optString.equals("date")) {
                    c2 = 1;
                }
                return A(context, unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean w(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("title");
            boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
            if (!(context instanceof t23.a)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
                return false;
            }
            t23 d2 = ((t23.a) context).d();
            View d3 = d2.d();
            if (d3 instanceof LoadingView) {
                loadingView = (LoadingView) d3;
            } else {
                loadingView = new LoadingView(context);
                d2.n(loadingView);
            }
            if (!TextUtils.isEmpty(optString)) {
                loadingView.setMsg(optString);
            }
            d2.k(optBoolean);
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final Date D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Date date = null;
            try {
                if (TextUtils.isEmpty(str)) {
                    return new Date();
                }
                if (!str.contains(":")) {
                    return null;
                }
                String[] split = str.split(":");
                if (split.length != 2) {
                    return null;
                }
                Date date2 = new Date();
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    if (parseInt >= 0 && parseInt < 24) {
                        date2.setHours(parseInt);
                    }
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt2 >= 0 && parseInt2 < 60) {
                        date2.setMinutes(parseInt2);
                    }
                    return date2;
                } catch (NumberFormatException e2) {
                    e = e2;
                    date = date2;
                    e.printStackTrace();
                    return date;
                }
            } catch (NumberFormatException e3) {
                e = e3;
            }
        } else {
            return (Date) invokeL.objValue;
        }
    }

    public final int b(Context context, int i2) {
        InterceptResult invokeLI;
        int s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, context, i2)) == null) {
            Resources resources = context.getResources();
            int dimensionPixelSize = ((((i2 + 1) * resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f5)) + resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f3)) + i2) - 1;
            if (dh3.J() && dimensionPixelSize > (s = dh3.s(context) - dh3.t())) {
                return s;
            }
            return dimensionPixelSize;
        }
        return invokeLI.intValue;
    }

    public final int c(JSONObject jSONObject, JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (TextUtils.equals(optString, jSONArray.getString(i2))) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public final JSONObject f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            windowManager.getDefaultDisplay().getSize(new Point());
            windowManager.getDefaultDisplay().getRectSize(new Rect());
            Configuration configuration = context.getResources().getConfiguration();
            Pair x = zo2.U().x();
            Pair r = zo2.U().r();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("pixelRatio", displayMetrics.density);
                jSONObject.put("devicePixelRatio", displayMetrics.density);
                jSONObject.put("screenWidth", dh3.O(((Integer) x.first).intValue()));
                jSONObject.put("screenHeight", dh3.O(((Integer) x.second).intValue()));
                jSONObject.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
                jSONObject.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
                jSONObject.put("language", d(configuration));
                jSONObject.put("version", gh3.D());
                jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
                jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", tm2.o().r());
                jSONObject.put("SDKVersion", e(context));
                jSONObject.put("swanNativeVersion", xj1.a());
                jSONObject.put("host", tm2.n().a());
                jSONObject.put("statusBarHeight", dh3.O(dh3.t()));
                jSONObject.put("navigationBarHeight", dh3.O(dh3.j()));
                vu1.B(jSONObject);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", hh3.b(context).a().toString());
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("imei", gh3.r());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (!(context instanceof t23.a)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
                return false;
            }
            t23 d2 = ((t23.a) context).d();
            if (d2.d() instanceof LoadingView) {
                d2.g();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            hh3.b(context).c(optParamsAsJo.optString("data"));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        if (r1.equals("getCommonSysInfoSync") != false) goto L19;
     */
    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            char c2 = 0;
            String path = unitedSchemeEntity.getPath(false);
            if (TextUtils.isEmpty(path)) {
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            } else {
                switch (path.hashCode()) {
                    case -1920105040:
                        if (path.equals("showModal")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1913642710:
                        if (path.equals("showToast")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1641549650:
                        if (path.equals("getSystemInfoSync")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1496218978:
                        if (path.equals("updateMultiPicker")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1383206285:
                        if (path.equals("previewImage")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -886619478:
                        if (path.equals("getClipboardData")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -550543988:
                        if (path.equals("showActionSheet")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -533453131:
                        break;
                    case 216239514:
                        if (path.equals("hideLoading")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 252099448:
                        if (path.equals("openPicker")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 344806259:
                        if (path.equals("getSystemInfo")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 422312381:
                        if (path.equals("dismissToast")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 724809599:
                        if (path.equals("showLoading")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1321118366:
                        if (path.equals("makePhoneCall")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1576904990:
                        if (path.equals("setClipboardData")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1630368510:
                        if (path.equals("showDatePickerView")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1714085202:
                        if (path.equals("getNetworkType")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2103167613:
                        if (path.equals("openMultiPicker")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        return j(context, unitedSchemeEntity, callbackHandler);
                    case 1:
                        return w(context, unitedSchemeEntity, callbackHandler);
                    case 2:
                        return n(context, unitedSchemeEntity, callbackHandler);
                    case 3:
                        return s(context, unitedSchemeEntity, callbackHandler);
                    case 4:
                        return t(context, unitedSchemeEntity, callbackHandler);
                    case 5:
                        return i(context, unitedSchemeEntity, callbackHandler);
                    case 6:
                        return k(context, unitedSchemeEntity, callbackHandler);
                    case 7:
                        return l(context, unitedSchemeEntity, callbackHandler);
                    case '\b':
                        return m(context, unitedSchemeEntity, callbackHandler);
                    case '\t':
                        return o(context, unitedSchemeEntity, callbackHandler);
                    case '\n':
                        return v(context, unitedSchemeEntity, callbackHandler);
                    case 11:
                        return x(context, unitedSchemeEntity, callbackHandler);
                    case '\f':
                        return u(context, unitedSchemeEntity, callbackHandler);
                    case '\r':
                        return h(context, unitedSchemeEntity, callbackHandler);
                    case 14:
                        return y(context, unitedSchemeEntity, callbackHandler);
                    case 15:
                        return r(context, unitedSchemeEntity, callbackHandler);
                    case 16:
                        return p(context, unitedSchemeEntity, callbackHandler);
                    case 17:
                        return C(context, unitedSchemeEntity, callbackHandler);
                    default:
                        return B(context, unitedSchemeEntity, callbackHandler);
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            String e2 = SwanAppNetworkUtils.e();
            if (TextUtils.isEmpty(e2)) {
                e2 = "unknown";
            } else if ("no".equals(e2)) {
                e2 = "none";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("networkType", e2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            int i2 = 0;
            if (unitedSchemeEntity == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.DIAL");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null) {
                String optString = optParamsAsJo.optString("phoneNumber");
                if (!TextUtils.isEmpty(optString)) {
                    intent.setData(Uri.parse("tel:" + optString));
                }
            }
            if (!vf3.g(context, intent)) {
                i2 = 1001;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, i2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        int i2;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String string = jSONArray.getString(i3);
                    if (TextUtils.isEmpty(string)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    arrayList.add(string);
                }
                optString = optParamsAsJo.optString("itemColor");
            } catch (IllegalArgumentException | JSONException unused) {
            }
            if (!TextUtils.isEmpty(optString)) {
                if (optString.length() == 4 && optString.charAt(0) == '#') {
                    optString = SwanAppConfigData.d(optString);
                }
                i2 = Color.parseColor(optString);
                if (!arrayList.isEmpty()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (i2 == -1) {
                    i2 = context.getResources().getColor(R.color.obfuscated_res_0x7f060395);
                }
                q23.a aVar = new q23.a(context);
                aVar.f(true);
                aVar.i(true);
                aVar.k(true);
                aVar.m(true);
                aVar.n(new ui3());
                aVar.s(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f3));
                aVar.p(R.drawable.obfuscated_res_0x7f080125);
                aVar.B(R.string.obfuscated_res_0x7f0f0112, new p(this, callbackHandler, unitedSchemeEntity));
                aVar.K(new o(this, callbackHandler, unitedSchemeEntity));
                View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d00cd, null);
                ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f091318);
                listView.setAdapter((ListAdapter) new a(this, arrayList, context, i2));
                aVar.W(inflate);
                aVar.j();
                aVar.q(b(context, arrayList.size()));
                q23 c2 = aVar.c();
                Window window = c2.getWindow();
                if (window != null) {
                    window.setGravity(80);
                    window.setLayout(dh3.s(context), -2);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f10039c);
                }
                c2.a(false);
                c2.setCanceledOnTouchOutside(true);
                listView.setOnItemClickListener(new b(this, callbackHandler, unitedSchemeEntity, c2));
                c2.show();
                return true;
            }
            i2 = -1;
            if (!arrayList.isEmpty()) {
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public final boolean x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                optParamsAsJo = new JSONObject();
            }
            String optString = optParamsAsJo.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = context.getString(R.string.obfuscated_res_0x7f0f011a);
            }
            q23.a aVar = new q23.a(context);
            aVar.V(optParamsAsJo.optString("title"));
            aVar.x(optParamsAsJo.optString("content"));
            aVar.n(new ui3());
            if (optParamsAsJo.optBoolean("showCancel", true)) {
                aVar.E(optParamsAsJo.optString("cancelColor"), R.color.obfuscated_res_0x7f0603dc);
                String optString2 = optParamsAsJo.optString("cancelText");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = context.getString(R.string.obfuscated_res_0x7f0f0112);
                }
                aVar.C(optString2, new l(this, callbackHandler, unitedSchemeEntity));
                aVar.K(new m(this, callbackHandler, unitedSchemeEntity));
            }
            aVar.R(optParamsAsJo.optString("confirmColor"), R.color.obfuscated_res_0x7f0603dd);
            aVar.P(optString, new n(this, callbackHandler, unitedSchemeEntity));
            aVar.X();
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean y(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            HashMap params = unitedSchemeEntity.getParams();
            if (params != null && params.size() != 0 && params.containsKey("params") && !TextUtils.isEmpty((CharSequence) params.get("params"))) {
                try {
                    JSONObject jSONObject = new JSONObject((String) params.get("params"));
                    String string = jSONObject.getString("type");
                    String string2 = jSONObject.getString("message");
                    String optString = jSONObject.optString("time");
                    String optString2 = jSONObject.optString("clickCallback");
                    if (TextUtils.isEmpty(string2)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = "1";
                    }
                    String str = string;
                    try {
                        int E = E(optString);
                        if (E <= 0) {
                            i2 = 2;
                        } else {
                            i2 = E;
                        }
                        gh3.e0(new d(this, str, context, string2, i2, callbackHandler, unitedSchemeEntity, jSONObject, optString2));
                        return true;
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public final JSONArray z(JSONArray jSONArray) {
        InterceptResult invokeL;
        m33 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() > 0 && (M = m33.M()) != null && !TextUtils.isEmpty(M.b) && !TextUtils.isEmpty(M.k0())) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        String string = jSONArray.getString(i2);
                        PathType s = ua3.s(string);
                        if (s == PathType.BD_FILE) {
                            string = ua3.M(string, M.b);
                        } else if (s == PathType.RELATIVE) {
                            string = ua3.L(string, M, M.k0());
                        }
                        if (!TextUtils.isEmpty(string)) {
                            jSONArray.put(i2, string);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
