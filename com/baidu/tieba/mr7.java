package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.hz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes7.dex */
public class mr7 {
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
        public final /* synthetic */ mr7 a;

        /* loaded from: classes7.dex */
        public class a implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, hz4Var) != null) || hz4Var == null) {
                    return;
                }
                hz4Var.dismiss();
            }
        }

        /* renamed from: com.baidu.tieba.mr7$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0388b implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PopInfo a;
            public final /* synthetic */ b b;

            public C0388b(b bVar, PopInfo popInfo) {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    UrlManager.getInstance().dealOneLink(this.b.a.a.getPageContext(), new String[]{this.a.ahead_url});
                    if (hz4Var == null) {
                        return;
                    }
                    hz4Var.dismiss();
                }
            }
        }

        public b(mr7 mr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mr7Var;
        }

        public /* synthetic */ b(mr7 mr7Var, a aVar) {
            this(mr7Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                gz4.k();
                m9<String> l = gz4.l("tb.enter_frs_dialog_list");
                String encode = URLEncoder.encode(this.a.a.s1().getForum().getName());
                if (l.get(encode) == null) {
                    l.g(encode, "1");
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
            PopInfo popInfo = this.a.a.s1().enterFrsDialogInfo;
            hz4 hz4Var = new hz4(this.a.a.getActivity());
            hz4Var.setTitle(popInfo.title);
            hz4Var.setMessage(popInfo.v_title);
            hz4Var.isShowTitleAndMessage();
            hz4Var.setNegativeButton(popInfo.ok_info, new a(this));
            hz4Var.setPositiveButton(popInfo.ahead_info, new C0388b(this, popInfo));
            hz4Var.create(this.a.a.getPageContext()).show();
        }
    }

    public mr7(FrsFragment frsFragment) {
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
            PopInfo popInfo = this.a.s1().enterFrsDialogInfo;
            if (popInfo != null && !StringUtils.isNull(popInfo.ahead_info) && !StringUtils.isNull(popInfo.ahead_url) && !StringUtils.isNull(popInfo.ok_info) && !StringUtils.isNull(popInfo.title) && !StringUtils.isNull(popInfo.v_title) && this.a.s1().enterFrsDialogInfo.if_pop.intValue() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !TbadkCoreApplication.isLogin() || (frsFragment = this.a) == null || frsFragment.s1() == null || this.a.s1().getForum() == null || StringUtils.isNull(this.a.s1().getForum().getName()) || this.a.s1().enterFrsDialogInfo == null || !c() || this.b != null) {
            return;
        }
        b bVar = new b(this, null);
        this.b = bVar;
        bVar.execute(new Void[0]);
    }
}
