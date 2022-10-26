package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.BdBaseImageView;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tieba.d61;
import com.baidu.tieba.i71;
import com.baidu.tieba.k71;
import com.baidu.tieba.l71;
import com.baidu.tieba.m71;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class o51 {
    public static /* synthetic */ Interceptable $ic;
    public static Set i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public d61 b;
    public c61 c;
    public boolean d;
    public Map e;
    public Map f;
    public Map g;
    public Map h;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public a(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public b(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public c(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public d(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public e(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public f(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;

        public g(o51 o51Var, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y51 a;
        public final /* synthetic */ EditText b;

        public h(o51 o51Var, y51 y51Var, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, y51Var, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y51Var;
            this.b = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.a(this.b.getText().toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements d61.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w51 a;
        public final /* synthetic */ o51 b;

        public i(o51 o51Var, w51 w51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, w51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o51Var;
            this.a = w51Var;
        }

        @Override // com.baidu.tieba.d61.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                this.a.setHttpAuthUsernamePassword(str, str2, str3, str4);
                this.a.a(str3, str4);
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements d61.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w51 a;
        public final /* synthetic */ o51 b;

        public j(o51 o51Var, w51 w51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, w51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o51Var;
            this.a = w51Var;
        }

        @Override // com.baidu.tieba.d61.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.cancel();
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public k(o51 o51Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements i71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public l(o51 o51Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // com.baidu.tieba.i71.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements i71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z51 a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ o51 d;

        public m(o51 o51Var, z51 z51Var, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, z51Var, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o51Var;
            this.a = z51Var;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.baidu.tieba.i71.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.u(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements i71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public n(o51 o51Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // com.baidu.tieba.i71.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.proceed();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements i71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;
        public final /* synthetic */ SslError b;
        public final /* synthetic */ o51 c;

        public o(o51 o51Var, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o51Var;
            this.b = sslError;
            this.a = null;
        }

        @Override // com.baidu.tieba.i71.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = new long[5];
                }
                long[] jArr = this.a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.a = null;
                    this.c.j(this.b.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z51 a;

        public p(o51 o51Var, z51 z51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, z51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements i71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z51 a;

        public q(o51 o51Var, z51 z51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var, z51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z51Var;
        }

        @Override // com.baidu.tieba.i71.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public y51 c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public r(String str, y51 y51Var) {
            this(str, null, y51Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, y51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (y51) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public r(String str, String str2, y51 y51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, y51Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = y51Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983134, "Lcom/baidu/tieba/o51;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983134, "Lcom/baidu/tieba/o51;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        i = hashSet;
        hashSet.add(".baidu.com");
        i.add(".nuomi.com");
        i.add(".nuomi.bdimg.com");
        i.add(".hao123.com");
        i.add(".qunaer.com");
        i.add(".wejianzhan.com");
    }

    public o51(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.a = context;
    }

    public final void d(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.obfuscated_res_0x7f080de3);
        }
    }

    public final void f(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.obfuscated_res_0x7f080de2);
        }
    }

    public final void e(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0616, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f65);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06086c));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091f64)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public boolean r(String str, String str2, y51 y51Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, y51Var)) == null) {
            if (this.d) {
                this.f.put(str, new r(str2, y51Var));
                return true;
            } else if (!g()) {
                y51Var.cancel();
                return false;
            } else {
                k71.a aVar = new k71.a(this.a);
                aVar.q(R.string.obfuscated_res_0x7f0f0bb9);
                aVar.j(str2);
                aVar.o(R.string.obfuscated_res_0x7f0f0bad, new b(this, y51Var));
                aVar.n(new a(this, y51Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public boolean s(String str, String str2, y51 y51Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, str2, y51Var)) == null) {
            if (this.d) {
                this.g.put(str, new r(str2, y51Var));
                return true;
            } else if (!g()) {
                y51Var.cancel();
                return false;
            } else {
                k71.a aVar = new k71.a(this.a);
                aVar.q(R.string.obfuscated_res_0x7f0f0bb9);
                aVar.j(str2);
                aVar.o(R.string.obfuscated_res_0x7f0f0bad, new e(this, y51Var));
                aVar.l(R.string.obfuscated_res_0x7f0f0bab, new d(this, y51Var));
                aVar.n(new c(this, y51Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void u(z51 z51Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, z51Var, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            m71.a k2 = k(certificate, sslError);
            k2.v(new i71.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c1e), R.color.obfuscated_res_0x7f06086a, new q(this, z51Var)));
            k2.n(new p(this, z51Var));
            k2.t();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.a;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.e.clear();
                this.f.clear();
                this.h.clear();
                this.g.clear();
            }
        }
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return false;
            }
            String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            for (String str2 : i) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (clipboardManager != null) {
                clipboardManager.setText(str);
            }
            b21.a().a(this.a, R.string.obfuscated_res_0x7f0f0c1a);
        }
    }

    public final String m(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, date)) == null) {
            if (date == null) {
                return "";
            }
            return DateFormat.getDateFormat(this.a).format(date);
        }
        return (String) invokeL.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d = z;
        }
    }

    public final m71.a k(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, sslCertificate, sslError)) == null) {
            View n2 = n(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) n2.findViewById(R.id.obfuscated_res_0x7f0919e5);
            n2.findViewById(R.id.obfuscated_res_0x7f091f63).setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060833));
            if (sslError == null) {
                d(linearLayout, R.string.obfuscated_res_0x7f0f0c18);
            } else {
                if (sslError.hasError(3)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c23);
                }
                if (sslError.hasError(2)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c20);
                }
                if (sslError.hasError(1)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c1c);
                }
                if (sslError.hasError(0)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c21);
                }
                if (sslError.hasError(4)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c1b);
                }
                if (sslError.hasError(5)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c1f);
                }
                if (linearLayout.getChildCount() == 0) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c22);
                }
            }
            m71.a aVar = new m71.a(this.a);
            aVar.y(R.string.obfuscated_res_0x7f0f0c17);
            aVar.x(n2);
            return aVar;
        }
        return (m71.a) invokeLL.objValue;
    }

    public synchronized void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                o(false);
                for (Map.Entry entry : this.e.entrySet()) {
                    if (entry.getValue() != null) {
                        p((String) entry.getKey(), (x51) entry.getValue());
                    }
                }
                this.e.clear();
                for (Map.Entry entry2 : this.f.entrySet()) {
                    r rVar = (r) entry2.getValue();
                    if (rVar != null) {
                        r((String) entry2.getKey(), rVar.a, rVar.c);
                    }
                }
                this.f.clear();
                for (Map.Entry entry3 : this.h.entrySet()) {
                    r rVar2 = (r) entry3.getValue();
                    if (rVar2 != null) {
                        t((String) entry3.getKey(), rVar2.a, rVar2.b, rVar2.c);
                    }
                }
                this.h.clear();
                for (Map.Entry entry4 : this.g.entrySet()) {
                    r rVar3 = (r) entry4.getValue();
                    if (rVar3 != null) {
                        s((String) entry4.getKey(), rVar3.a, rVar3.c);
                    }
                }
                this.g.clear();
            }
        }
    }

    public final View n(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, sslCertificate)) == null) {
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d0615, null);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f06086c);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0903bc);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextColor(color);
                    textView.setTextSize(14.0f);
                }
            }
            SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092256)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092259)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09225b)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09048f)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090491)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090493)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f7e)).setText(m(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09096f)).setText(m(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void p(String str, x51 x51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, x51Var) == null) {
            if (this.d) {
                this.e.put(str, x51Var);
            }
            if (!g()) {
                return;
            }
            if (h(str)) {
                if (x51Var != null) {
                    x51Var.a(str, true, true);
                    return;
                }
                return;
            }
            c61 c61Var = new c61(this.a, str, x51Var);
            this.c = c61Var;
            c61Var.e();
        }
    }

    public void q(w51 w51Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, w51Var, str, str2) == null) {
            d61 d61Var = new d61(this.a, str, str2);
            this.b = d61Var;
            d61Var.h(new i(this, w51Var));
            this.b.g(new j(this, w51Var));
            this.b.i();
        }
    }

    public boolean t(String str, String str2, String str3, y51 y51Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, str, str2, str3, y51Var)) == null) {
            if (this.d) {
                this.h.put(str, new r(str2, str3, y51Var));
                return true;
            } else if (!g()) {
                y51Var.cancel();
                return false;
            } else {
                View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d05f6, null);
                EditText editText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f0924d3);
                editText.setText(str3);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091507)).setText(str2);
                k71.a aVar = new k71.a(this.a);
                aVar.q(R.string.obfuscated_res_0x7f0f0bb9);
                aVar.s(inflate);
                aVar.o(R.string.obfuscated_res_0x7f0f0bad, new h(this, y51Var, editText));
                aVar.l(R.string.obfuscated_res_0x7f0f0bab, new g(this, y51Var));
                aVar.n(new f(this, y51Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void v(z51 z51Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, z51Var, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            l71.c cVar = new l71.c(this.a);
            cVar.A(R.string.obfuscated_res_0x7f0f0c13);
            cVar.z(R.string.obfuscated_res_0x7f0f0c24, new o(this, sslError));
            cVar.v(new i71.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c19), R.color.obfuscated_res_0x7f06086d, new n(this, sslErrorHandler)));
            cVar.v(new i71.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c47), R.color.obfuscated_res_0x7f06086a, new m(this, z51Var, sslErrorHandler, sslError)));
            cVar.v(new i71.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c1d), R.color.obfuscated_res_0x7f06086a, new l(this, sslErrorHandler)));
            cVar.n(new k(this, sslErrorHandler));
            cVar.t();
        }
    }
}
