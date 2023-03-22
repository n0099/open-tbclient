package com.baidu.tieba;

import android.content.Intent;
import android.net.http.SslError;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListNetMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.SearchSug.DataRes;
/* loaded from: classes5.dex */
public class j68 implements z68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public i68 b;
    public View c;
    public boolean d;
    public HotSearchInfoData e;
    public boolean f;
    public String g;
    public Stack<String> h;
    public h68 i;
    public CustomMessageListener j;
    public final CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.a.finish();
                }
            }
        }

        public h(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.b.g() && this.a.b.g().getText() != null) {
                    j68 j68Var = this.a;
                    j68Var.g = j68Var.b.g().getText().toString();
                    if (StringUtils.isNull(this.a.g)) {
                        this.a.x();
                    }
                } else if (view2 == this.a.b.d()) {
                    hi.z(this.a.a.getPageContext().getPageActivity(), this.a.b.g());
                    jg.a().postDelayed(new a(this), 1000L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        public a(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                b35.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
                if (!TbadkCoreApplication.isLogin() && str != null && vp5.e(str) && vp5.a()) {
                    LoginDialogData loginDialogData = new LoginDialogData(this.a.a, LoginDialogData.SEARCH_RESULT_PAGE);
                    loginDialogData.setUrl(str);
                    DialogLoginHelper.checkUpIsLogin(loginDialogData);
                    return true;
                } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.a.getPageContext(), new String[]{str}) != 3) {
                    return true;
                } else {
                    if (str != null && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str}, true);
                        return true;
                    }
                    Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.a.a.getApplicationContext(), str);
                    if (parseIntentFromUrl == null) {
                        return false;
                    }
                    try {
                        ArrayList<String> arrayList = (ArrayList) this.a.a.getCurrentPageSourceKeyList();
                        String currentPageKey = this.a.a.getCurrentPageKey();
                        if (arrayList != null && !StringUtils.isNull(currentPageKey) && !arrayList.contains(currentPageKey)) {
                            arrayList.add(currentPageKey);
                        }
                        if (!ListUtils.isEmpty(arrayList)) {
                            parseIntentFromUrl.putStringArrayListExtra("obj_source", arrayList);
                        }
                        this.a.a.startActivity(parseIntentFromUrl);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends wp5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(j68 j68Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.wp5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ad9.o(this.a);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j68 j68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.b.K(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j68 j68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.a((String) customResponsedMessage.getData(), true, 3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        public e(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    hi.z(this.a.a.getPageContext().getPageActivity(), view2);
                    return;
                }
                if (this.a.b != null && this.a.b.g() != null) {
                    j68 j68Var = this.a;
                    j68Var.g = j68Var.b.g().getText().toString();
                }
                if (StringUtils.isNull(this.a.g)) {
                    this.a.r();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        public f(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i != 3) {
                    return false;
                }
                if (StringUtils.isNull(this.a.g)) {
                    hi.z(this.a.a.getPageContext().getPageActivity(), textView);
                    this.a.v();
                } else {
                    j68 j68Var = this.a;
                    j68Var.a(j68Var.g, false, 1);
                    TiebaStatic.log(new StatisticItem("c12842").param("obj_name", this.a.g).param("obj_source", "1").param("obj_type", "1"));
                }
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j68 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public g(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j68Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || editable == null) {
                return;
            }
            if (this.a.f) {
                this.a.g = editable.toString();
                this.a.y();
            }
            this.a.b.u(!StringUtils.isNull(editable.toString()));
        }
    }

    /* loaded from: classes5.dex */
    public class i implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                b35.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements BaseWebView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
        public void a(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                b35.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(j68 j68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) && sslError != null) {
                b35.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
            }
        }
    }

    public j68(BaseActivity baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = true;
        this.h = new Stack<>();
        this.j = new c(this, 2921444);
        this.k = new d(this, 2921595);
        this.a = baseActivity;
        this.d = z;
        s();
    }

    @Override // com.baidu.tieba.z68
    public void d(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hotSearchInfoData) == null) {
            this.e = hotSearchInfoData;
            w();
        }
    }

    @Override // com.baidu.tieba.z68
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.b.q(this.a.getPageContext(), i2);
        }
    }

    @Override // com.baidu.tieba.z68
    public void f(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, dataRes, str) == null) && !TextUtils.isEmpty(str) && str.equals(this.g)) {
            this.b.I(dataRes, this.g);
        }
    }

    @Override // com.baidu.tieba.z68
    public void a(String str, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
            } else if (StringUtils.isNull(str)) {
            } else {
                t(str);
                Matcher matcher = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2).matcher(str);
                if (matcher != null && matcher.find() && !TextUtils.isEmpty(matcher.group(2))) {
                    str = matcher.group(2);
                }
                if (z) {
                    this.f = false;
                    this.b.G(str);
                    this.f = true;
                }
                hi.z(this.a.getPageContext().getPageActivity(), this.b.g());
                this.b.C();
                String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
                try {
                    str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.b.p(str2);
                this.h.push(str);
                aq5.b(new b(this, str), null);
                this.i.j(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
            }
        }
    }

    @Override // com.baidu.tieba.z68
    public void b() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.h.size() > 1) {
                this.h.pop();
                String peek = this.h.peek();
                if (!TextUtils.isEmpty(peek) && (i68Var = this.b) != null) {
                    boolean z = this.f;
                    this.f = false;
                    i68Var.G(peek);
                    this.f = z;
                    this.b.C();
                    return;
                }
                return;
            }
            this.h.clear();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e eVar = new e(this);
            f fVar = new f(this);
            g gVar = new g(this);
            h hVar = new h(this);
            this.b.E(eVar);
            this.b.D(fVar);
            this.b.H(gVar);
            this.b.y(hVar);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (StringUtils.isNull(this.g)) {
                x();
                return;
            }
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.g.trim();
            searchListNetMessage.isForum = Integer.valueOf(this.d ? 1 : 0);
            this.a.sendMessage(searchListNetMessage);
        }
    }

    @Override // com.baidu.tieba.z68
    public WebView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.f();
        }
        return (WebView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z68
    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b.g();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z68
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i68 i68Var = this.b;
            if (i68Var != null) {
                i68Var.r();
            }
            h68 h68Var = this.i;
            if (h68Var != null) {
                h68Var.s();
            }
        }
    }

    @Override // com.baidu.tieba.z68
    public void onPause() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (i68Var = this.b) != null) {
            i68Var.s();
        }
    }

    @Override // com.baidu.tieba.z68
    public void onResume() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (i68Var = this.b) != null) {
            i68Var.t();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i iVar = new i(this);
            j jVar = new j(this);
            k kVar = new k(this);
            this.b.A(new a(this), iVar, jVar, kVar);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.b.n()) {
            return;
        }
        u();
    }

    public final void w() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (i68Var = this.b) == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.e;
        if (hotSearchInfoData == null) {
            i68Var.F(this.a.getResources().getString(R.string.search_bar));
        } else {
            i68Var.F(hotSearchInfoData.S());
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.i.r();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (!StringUtils.isNull(this.g)) {
                u();
            } else {
                x();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d069f, (ViewGroup) null);
                this.c = inflate;
                this.a.setContentView(inflate);
            } catch (Exception e2) {
                e2.printStackTrace();
                Map<String, String> a2 = y68.a();
                if (a2 != null) {
                    int size = a2.size();
                    int i2 = 0;
                    for (String str : a2.keySet()) {
                        y68.b(str);
                        try {
                            View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d069f, (ViewGroup) null);
                            this.c = inflate2;
                            this.a.setContentView(inflate2);
                            break;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            i2++;
                        }
                    }
                    if (i2 == size) {
                        this.a.finish();
                        return;
                    }
                } else {
                    this.a.finish();
                    return;
                }
            }
            View view2 = this.c;
            if (view2 == null) {
                this.a.finish();
                return;
            }
            i68 i68Var = new i68(view2, this.a.getPageContext().getPageActivity());
            this.b = i68Var;
            this.i = new h68(this.a, this, i68Var);
            q();
            p();
            w();
            y();
            oq5.g(this.b.f(), this.a.getUniqueId());
            oq5.g(this.b.e(), this.a.getUniqueId());
            this.a.registerListener(this.j);
            this.k.setTag(this.a.getUniqueId());
            this.k.setSelfListener(true);
            this.a.registerListener(this.k);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HotSearchInfoData hotSearchInfoData = this.e;
            if (hotSearchInfoData == null) {
                BaseActivity baseActivity = this.a;
                baseActivity.showToast(baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f1715));
                return;
            }
            int i2 = 1;
            if (hotSearchInfoData.getType() != 0 && this.e.getType() != 2) {
                if (this.e.getType() == 1 && !yo5.b(this.a.getPageContext())) {
                    if (this.e.R() != 1 && NewWebHotTopicPageSwitch.isOn()) {
                        mp5.e(this.a.getPageContext(), String.valueOf(this.e.getId()), this.e.getName());
                    } else {
                        new HotTopicActivityConfig(this.a).createNormalConfig(String.valueOf(this.e.getId()), this.e.getName(), String.valueOf(this.e.R()), null).start();
                    }
                }
            } else {
                a(this.e.getName(), true, 1);
            }
            StatisticItem param = new StatisticItem("c10355").param("obj_name", this.e.getName());
            if (this.e.getType() == 0) {
                i2 = 2;
            }
            TiebaStatic.log(param.param("obj_type", i2));
        }
    }

    public final void t(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if ("tiebalog:true".equals(str)) {
                m35.m().w("key_tieba_exception_log_enable", true);
                BdLog.enableExceptionLog = true;
            } else if ("tiebalog:false".equals(str)) {
                m35.m().w("key_tieba_exception_log_enable", false);
                BdLog.enableExceptionLog = false;
            }
        }
    }
}
