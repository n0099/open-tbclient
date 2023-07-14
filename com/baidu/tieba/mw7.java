package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes7.dex */
public class mw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public b b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mw7 a;

        /* loaded from: classes7.dex */
        public class a implements p55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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
                    }
                }
            }

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, p55Var) != null) || p55Var == null) {
                    return;
                }
                p55Var.dismiss();
            }
        }

        /* renamed from: com.baidu.tieba.mw7$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0405b implements p55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PopInfo a;
            public final /* synthetic */ b b;

            public C0405b(b bVar, PopInfo popInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, popInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = popInfo;
            }

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    UrlManager.getInstance().dealOneLink(this.b.a.a.getPageContext(), new String[]{this.a.ahead_url});
                    if (p55Var == null) {
                        return;
                    }
                    p55Var.dismiss();
                }
            }
        }

        public b(mw7 mw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mw7Var;
        }

        public /* synthetic */ b(mw7 mw7Var, a aVar) {
            this(mw7Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                o55.e();
                ye<String> f = o55.f("tb.enter_frs_dialog_list");
                String encode = URLEncoder.encode(this.a.a.c1().getForum().getName());
                if (f.get(encode) == null) {
                    f.g(encode, "1");
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) != null) || !bool.booleanValue() || !this.a.c() || !this.a.a.isAdded()) {
                return;
            }
            PopInfo popInfo = this.a.a.c1().enterFrsDialogInfo;
            p55 p55Var = new p55(this.a.a.getActivity());
            p55Var.setTitle(popInfo.title);
            p55Var.setMessage(popInfo.v_title);
            p55Var.isShowTitleAndMessage();
            p55Var.setNegativeButton(popInfo.ok_info, new a(this));
            p55Var.setPositiveButton(popInfo.ahead_info, new C0405b(this, popInfo));
            p55Var.create(this.a.a.getPageContext()).show();
        }
    }

    public mw7(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frsFragment;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PopInfo popInfo = this.a.c1().enterFrsDialogInfo;
            if (popInfo != null && !StringUtils.isNull(popInfo.ahead_info) && !StringUtils.isNull(popInfo.ahead_url) && !StringUtils.isNull(popInfo.ok_info) && !StringUtils.isNull(popInfo.title) && !StringUtils.isNull(popInfo.v_title) && this.a.c1().enterFrsDialogInfo.if_pop.intValue() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !TbadkCoreApplication.isLogin() || (frsFragment = this.a) == null || frsFragment.c1() == null || this.a.c1().getForum() == null || StringUtils.isNull(this.a.c1().getForum().getName()) || this.a.c1().enterFrsDialogInfo == null || !c() || this.b != null) {
            return;
        }
        b bVar = new b(this, null);
        this.b = bVar;
        bVar.execute(new Void[0]);
    }
}
