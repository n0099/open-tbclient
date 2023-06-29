package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchHttpResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ArrayList<String> j;
    public int k;
    public final HttpMessageListener l;
    public CustomMessageListener m;

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yp9 yp9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp9Var, Integer.valueOf(i)};
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
            this.a = yp9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof PostSearchHttpResponseMessage) || !(httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    return;
                }
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                boolean z = false;
                if (httpMessage.getExtra() instanceof Integer) {
                    i = ((Integer) httpMessage.getExtra()).intValue();
                } else {
                    i = 0;
                }
                this.a.p(i);
                if (this.a.i(i) > 1) {
                    z = true;
                }
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    this.a.a.A1(i, postSearchHttpResponseMessage.getSearchData(), z);
                    this.a.f(i);
                    this.a.r();
                    this.a.s();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e0f);
                }
                this.a.a.showToast(errorString);
                this.a.a.A1(i, null, z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yp9 yp9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp9Var, Integer.valueOf(i)};
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
            this.a = yp9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                yp9 yp9Var = this.a;
                yp9Var.j = (ArrayList) data;
                yp9Var.a.z1();
            }
        }
    }

    public yp9(PostSearchActivity postSearchActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = 1;
        this.f = 1;
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = 0;
        this.l = new a(this, CmdConfigHttp.CMD_POST_SEARCH);
        b bVar = new b(this, 2009001);
        this.m = bVar;
        this.a = postSearchActivity;
        postSearchActivity.registerListener(bVar);
        this.a.registerListener(this.l);
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f++;
                        return;
                    }
                    return;
                }
                this.e++;
                return;
            }
            this.d++;
        }
    }

    public final int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return this.f;
                }
                return this.e;
            }
            return this.d;
        }
        return invokeI.intValue;
    }

    public final void k(List<String> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || list == null || list.size() - 5 <= 0) {
            return;
        }
        int size2 = list.size();
        for (int i = 0; i < size; i++) {
            list.remove((size2 - i) - 1);
        }
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.i) {
                return false;
            }
            this.b = str;
            this.k = 3;
            this.a.sendMessage(h(3));
            this.i = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.h) {
                return false;
            }
            this.b = str;
            this.k = 2;
            this.a.sendMessage(h(2));
            this.h = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.g) {
                return false;
            }
            this.b = str;
            this.k = 1;
            this.a.sendMessage(h(1));
            this.g = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.i = false;
                        return;
                    }
                    return;
                }
                this.h = false;
                return;
            }
            this.g = false;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList<String> arrayList = this.j;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.a.sendMessage(new CustomMessage(2009004));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.sendMessage(new CustomMessage(2009001));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d = 1;
            this.e = 1;
            this.f = 1;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            this.j.remove(this.b);
            this.j.add(0, this.b);
            k(this.j);
        }
    }

    public final HttpMessage h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
            httpMessage.addParam(DownloadStatisticConstants.UBC_VALUE_WORD, this.b);
            httpMessage.addParam("rn", 30);
            httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.a.d);
            httpMessage.setExtra(Integer.valueOf(this.k));
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        httpMessage.addParam("sm", 2);
                        httpMessage.addParam("only_thread", 1);
                        httpMessage.addParam("pn", this.f);
                    }
                } else {
                    httpMessage.addParam("sm", 2);
                    httpMessage.addParam("only_thread", 0);
                    httpMessage.addParam("pn", this.e);
                }
            } else {
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.d);
            }
            return httpMessage;
        }
        return (HttpMessage) invokeI.objValue;
    }

    public boolean l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            if (!str.equals(this.b)) {
                q();
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return m(str);
                }
                return n(str);
            }
            return o(str);
        }
        return invokeLI.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !StringUtils.isNull(this.b) && !this.b.equals(this.c)) {
            this.a.sendMessage(new CustomMessage(2009003, this.b));
            this.c = this.b;
        }
    }
}
