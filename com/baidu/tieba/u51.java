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
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.BdBaseImageView;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tieba.n71;
import com.baidu.tieba.p71;
import com.baidu.tieba.q71;
import com.baidu.tieba.r71;
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
/* loaded from: classes8.dex */
public class u51 {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> h;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public a61 b;
    public boolean c;
    public Map<String, k51> d;
    public Map<String, p> e;
    public Map<String, p> f;
    public Map<String, p> g;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public a(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public b(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public c(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public d(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public e(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public f(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;

        public g(u51 u51Var, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l51 a;
        public final /* synthetic */ EditText b;

        public h(u51 u51Var, l51 l51Var, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, l51Var, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
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

    /* loaded from: classes8.dex */
    public class i implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public i(u51 u51Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, sslErrorHandler};
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

    /* loaded from: classes8.dex */
    public class j implements n71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public j(u51 u51Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, sslErrorHandler};
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

        @Override // com.baidu.tieba.n71.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements n71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m51 a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ u51 d;

        public k(u51 u51Var, m51 m51Var, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, m51Var, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = u51Var;
            this.a = m51Var;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.baidu.tieba.n71.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.s(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements n71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public l(u51 u51Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, sslErrorHandler};
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

        @Override // com.baidu.tieba.n71.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.proceed();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements n71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;
        public final /* synthetic */ SslError b;
        public final /* synthetic */ u51 c;

        public m(u51 u51Var, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u51Var;
            this.b = sslError;
            this.a = null;
        }

        @Override // com.baidu.tieba.n71.c
        public void onItemClick(View view2) {
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
                    this.c.i(this.b.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m51 a;

        public n(u51 u51Var, m51 m51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, m51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m51Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @RequiresApi(api = 26)
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements n71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m51 a;

        public o(u51 u51Var, m51 m51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, m51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m51Var;
        }

        @Override // com.baidu.tieba.n71.c
        @RequiresApi(api = 26)
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public l51 c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public p(String str, l51 l51Var) {
            this(str, null, l51Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (l51) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public p(String str, String str2, l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, l51Var};
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
            this.c = l51Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161880, "Lcom/baidu/tieba/u51;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161880, "Lcom/baidu/tieba/u51;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        h = hashSet;
        hashSet.add(".baidu.com");
        h.add(".nuomi.com");
        h.add(".nuomi.bdimg.com");
        h.add(".hao123.com");
        h.add(".qunaer.com");
        h.add(".wejianzhan.com");
    }

    public u51(Context context) {
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
        this.c = false;
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            d(linearLayout, i2, R.drawable.nad_ic_dialog_browser_security_good);
        }
    }

    public final void e(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            d(linearLayout, i2, R.drawable.nad_ic_dialog_browser_security_bad);
        }
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.nad_ssl_content_header, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.nad_safe_dialog_message));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public boolean p(String str, String str2, @NonNull l51 l51Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, str2, l51Var)) == null) {
            if (this.c) {
                this.e.put(str, new p(str2, l51Var));
                return true;
            } else if (!f()) {
                l51Var.cancel();
                return false;
            } else {
                p71.a aVar = new p71.a(this.a);
                aVar.o(R.string.nad_dialog_webcall_common_title);
                aVar.h(str2);
                aVar.m(R.string.nad_dialog_positive_button_text, new b(this, l51Var));
                aVar.l(new a(this, l51Var));
                aVar.q();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public boolean q(String str, String str2, @NonNull l51 l51Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, l51Var)) == null) {
            if (this.c) {
                this.f.put(str, new p(str2, l51Var));
                return true;
            } else if (!f()) {
                l51Var.cancel();
                return false;
            } else {
                p71.a aVar = new p71.a(this.a);
                aVar.o(R.string.nad_dialog_webcall_common_title);
                aVar.h(str2);
                aVar.m(R.string.nad_dialog_positive_button_text, new e(this, l51Var));
                aVar.j(R.string.nad_dialog_nagtive_button_text, new d(this, l51Var));
                aVar.l(new c(this, l51Var));
                aVar.q();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void s(@NonNull m51 m51Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, m51Var, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            r71.a j2 = j(certificate, sslError);
            j2.s(new n71.a(this.a.getText(R.string.nad_ssl_got_it), R.color.nad_safe_dialog_btn_black, new o(this, m51Var)));
            j2.l(new n(this, m51Var));
            j2.q();
        }
    }

    public final boolean f() {
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

    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.d.clear();
                this.e.clear();
                this.g.clear();
                this.f.clear();
            }
        }
    }

    public final boolean g(String str) {
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
            for (String str2 : h) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (clipboardManager != null) {
                clipboardManager.setText(str);
            }
            e01.a().a(this.a, R.string.nad_ssl_copy_error);
        }
    }

    public final String l(Date date) {
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

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
        }
    }

    public final r71.a j(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, sslCertificate, sslError)) == null) {
            View m2 = m(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) m2.findViewById(R.id.obfuscated_res_0x7f091cce);
            m2.findViewById(R.id.ssl_divider).setBackgroundColor(this.a.getResources().getColor(R.color.nad_dialog_gray));
            if (sslError == null) {
                c(linearLayout, R.string.nad_ssl_certificate_is_valid);
            } else {
                if (sslError.hasError(3)) {
                    e(linearLayout, R.string.nad_ssl_untrusted);
                }
                if (sslError.hasError(2)) {
                    e(linearLayout, R.string.nad_ssl_mismatch);
                }
                if (sslError.hasError(1)) {
                    e(linearLayout, R.string.nad_ssl_expired);
                }
                if (sslError.hasError(0)) {
                    e(linearLayout, R.string.nad_ssl_not_yet_valid);
                }
                if (sslError.hasError(4)) {
                    e(linearLayout, R.string.nad_ssl_date_invalid);
                }
                if (sslError.hasError(5)) {
                    e(linearLayout, R.string.nad_ssl_invalid);
                }
                if (linearLayout.getChildCount() == 0) {
                    e(linearLayout, R.string.nad_ssl_unknown);
                }
            }
            r71.a aVar = new r71.a(this.a);
            aVar.v(R.string.nad_ssl_certificate);
            aVar.u(m2);
            return aVar;
        }
        return (r71.a) invokeLL.objValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                n(false);
                for (Map.Entry<String, k51> entry : this.d.entrySet()) {
                    if (entry.getValue() != null) {
                        o(entry.getKey(), entry.getValue());
                    }
                }
                this.d.clear();
                for (Map.Entry<String, p> entry2 : this.e.entrySet()) {
                    p value = entry2.getValue();
                    if (value != null) {
                        p(entry2.getKey(), value.a, value.c);
                    }
                }
                this.e.clear();
                for (Map.Entry<String, p> entry3 : this.g.entrySet()) {
                    p value2 = entry3.getValue();
                    if (value2 != null) {
                        r(entry3.getKey(), value2.a, value2.b, value2.c);
                    }
                }
                this.g.clear();
                for (Map.Entry<String, p> entry4 : this.f.entrySet()) {
                    p value3 = entry4.getValue();
                    if (value3 != null) {
                        q(entry4.getKey(), value3.a, value3.c);
                    }
                }
                this.f.clear();
            }
        }
    }

    public final View m(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, sslCertificate)) == null) {
            View inflate = View.inflate(this.a, R.layout.nad_ssl_certificate, null);
            int color = this.a.getResources().getColor(R.color.nad_safe_dialog_message);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090412);
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
                ((TextView) inflate.findViewById(R.id.to_common)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092600)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.issued_on)).setText(l(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.expires_on)).setText(l(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void o(String str, @NonNull k51 k51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, k51Var) == null) {
            if (this.c) {
                this.d.put(str, k51Var);
            }
            if (!f()) {
                return;
            }
            if (g(str)) {
                if (k51Var != null) {
                    k51Var.a(str, true, true);
                    return;
                }
                return;
            }
            a61 a61Var = new a61(this.a, str, k51Var);
            this.b = a61Var;
            a61Var.e();
        }
    }

    public boolean r(String str, String str2, String str3, @NonNull l51 l51Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, str, str2, str3, l51Var)) == null) {
            if (this.c) {
                this.g.put(str, new p(str2, str3, l51Var));
                return true;
            } else if (!f()) {
                l51Var.cancel();
                return false;
            } else {
                View inflate = View.inflate(this.a, R.layout.nad_js_prompt, null);
                EditText editText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f09289c);
                editText.setText(str3);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091767)).setText(str2);
                p71.a aVar = new p71.a(this.a);
                aVar.o(R.string.nad_dialog_webcall_common_title);
                aVar.p(inflate);
                aVar.m(R.string.nad_dialog_positive_button_text, new h(this, l51Var, editText));
                aVar.j(R.string.nad_dialog_nagtive_button_text, new g(this, l51Var));
                aVar.l(new f(this, l51Var));
                aVar.q();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void t(@NonNull m51 m51Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, m51Var, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            q71.c cVar = new q71.c(this.a);
            cVar.x(R.string.nad_security_warning);
            cVar.w(R.string.nad_ssl_warnings_header, new m(this, sslError));
            cVar.s(new n71.a(this.a.getText(R.string.nad_ssl_continue), R.color.nad_ssl_dialog_go_on_text_color, new l(this, sslErrorHandler)));
            cVar.s(new n71.a(this.a.getText(R.string.nad_view_certificate), R.color.nad_safe_dialog_btn_black, new k(this, m51Var, sslErrorHandler, sslError)));
            cVar.s(new n71.a(this.a.getText(R.string.nad_ssl_go_back), R.color.nad_safe_dialog_btn_black, new j(this, sslErrorHandler)));
            cVar.l(new i(this, sslErrorHandler));
            cVar.q();
        }
    }
}
