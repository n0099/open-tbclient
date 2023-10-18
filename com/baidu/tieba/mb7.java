package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.forumSquare.model.ForumSquareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class mb7 implements pb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final Context b;
    public ForumSquareModel c;
    public nb7 d;
    public ob7 e;
    public String f;
    public CustomMessageListener g;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mb7 mb7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb7Var, Integer.valueOf(i)};
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
            this.a = mb7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                mb7 mb7Var = this.a;
                if (mb7Var.d == null || mb7Var.c == null) {
                    return;
                }
                this.a.f = "推荐";
                this.a.c.clearData();
                this.a.m();
            }
        }
    }

    public mb7(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = "推荐";
        this.g = new a(this, 2921589);
        this.a = tbPageContext;
        this.b = context;
        this.c = new ForumSquareModel(context, this);
        this.d = new nb7(context, this.a);
        this.a.registerListener(this.g);
    }

    @Override // com.baidu.tieba.pb7
    public void onError(String str, ErrorData errorData) {
        nb7 nb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, errorData) == null) && (nb7Var = this.d) != null && this.c != null) {
            nb7Var.K();
            tb7 c0 = this.c.c0(str);
            if (c0 != null && (!c0.d || !ListUtils.isEmpty(c0.a()))) {
                this.d.t(c0.a());
                c(str, c0.a());
                return;
            }
            this.d.g();
            this.d.v();
        }
    }

    public void j(String str) {
        ForumSquareModel forumSquareModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (forumSquareModel = this.c) != null && this.d != null && forumSquareModel.b0(str)) {
            this.d.C(str);
            i(str);
        }
    }

    @Override // com.baidu.tieba.pb7
    public void onNoData(ErrorData errorData) {
        nb7 nb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, errorData) == null) && (nb7Var = this.d) != null) {
            nb7Var.J();
        }
    }

    public final void c(String str, List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && this.d != null && this.c != null) {
            if (ListUtils.isEmpty(list)) {
                this.d.g();
            } else if (ListUtils.getCount(list) < 10) {
                this.d.o();
            } else {
                this.d.F(this.c.d0(str));
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.b();
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            nb7 nb7Var = this.d;
            if (nb7Var != null) {
                nb7Var.G();
            }
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel != null) {
                forumSquareModel.f0(f());
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ob7 ob7Var = new ob7(this.b, this, this.d);
            this.e = ob7Var;
            ob7Var.e();
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.G();
            this.c.f0(this.f);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String f = f();
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel != null && this.d != null) {
                boolean e0 = forumSquareModel.e0();
                boolean F = this.d.F(this.c.d0(f));
                if (!e0 && F) {
                    this.c.f0(f);
                }
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            l(this.f);
            this.f = str;
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel != null && this.d != null) {
                tb7 c0 = forumSquareModel.c0(str);
                if (c0 != null && (!c0.d || !ListUtils.isEmpty(c0.a()))) {
                    this.d.K();
                    c(str, c0.a());
                    this.d.t(c0.a());
                    this.d.r(c0.f, c0.g);
                    return;
                }
                this.d.E();
                c(str, null);
                this.c.f0(str);
                this.d.r(0, 0);
            }
        }
    }

    public void k(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) && intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f = uri.getQueryParameter("tab_name");
            }
            boolean z = false;
            int intExtra = intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0);
            nb7 nb7Var = this.d;
            if (intExtra == 0) {
                z = true;
            }
            nb7Var.D(z);
        }
    }

    public void l(String str) {
        tb7 c0;
        Pair<Integer, Integer> d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || this.d == null || this.c == null || TextUtils.isEmpty(str) || (c0 = this.c.c0(str)) == null || (d = this.d.d()) == null) {
            return;
        }
        c0.f = ((Integer) d.first).intValue();
        c0.g = ((Integer) d.second).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    @Override // com.baidu.tieba.pb7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSucc(String str, List<String> list, List<yh> list2) {
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048590, this, str, list, list2) == null) && this.c != null && this.d != null) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || str.equals(this.f)) {
                String f = this.d.f();
                if (!TextUtils.isEmpty(str)) {
                }
                isEmpty = TextUtils.isEmpty(this.f);
                this.f = str;
                if (isEmpty) {
                    this.d.G();
                    this.c.f0(this.f);
                }
                this.d.K();
                this.d.s(str, list, z);
                this.d.u(list2, this.c.i0(list2, 300));
                c(str, list2);
            }
            z = true;
            isEmpty = TextUtils.isEmpty(this.f);
            this.f = str;
            if (isEmpty) {
            }
            this.d.K();
            this.d.s(str, list, z);
            this.d.u(list2, this.c.i0(list2, 300));
            c(str, list2);
        }
    }
}
