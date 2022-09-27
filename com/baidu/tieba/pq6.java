package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.nu4;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes5.dex */
public class pq6 extends PriorityOrganizer.Task {
    public static /* synthetic */ Interceptable $ic;
    public static final String t;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment m;
    public FrsActivity n;
    public FrsPrivateCommonDialogView o;
    public PrivateForumPopInfoData p;
    public boolean q;
    public String r;
    public String s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ pq6 b;

        public a(pq6 pq6Var, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq6Var, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pq6Var;
            this.a = nu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.obfuscated_res_0x7f090f89)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.obfuscated_res_0x7f091a90);
                UrlManager.getInstance().dealOneLink(this.b.m.getPageContext(), new String[]{privateForumPopInfoData.D()});
                as6.f(privateForumPopInfoData, booleanValue, this.b.r, this.b.s, true);
                this.a.dismiss();
                this.b.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq6 a;

        public b(pq6 pq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq6Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.a.u();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070740, "Lcom/baidu/tieba/pq6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070740, "Lcom/baidu/tieba/pq6;");
                return;
            }
        }
        t = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
    }

    public pq6(FrsActivity frsActivity, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity, frsFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = false;
        this.n = frsActivity;
        this.m = frsFragment;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nu4 nu4Var = new nu4(this.n);
            nu4Var.setContentViewSize(10);
            nu4Var.setContentView(this.o);
            nu4Var.setCanceledOnTouchOutside(false);
            this.o.setConfirmButton(new a(this, nu4Var));
            nu4Var.setCloseButton(new b(this));
            nu4Var.create(this.m.getPageContext()).show();
            as6.f(this.p, this.q, this.r, this.s, false);
            this.m.z4(true);
        }
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsFragment frsFragment = this.m;
            return (frsFragment == null || frsFragment.u3() || TbSingleton.getInstance().getFrsResponseData() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean x() {
        InterceptResult invokeV;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            zl8 frsResponseData = TbSingleton.getInstance().getFrsResponseData();
            FrsViewData frsViewData = new FrsViewData();
            frsViewData.receiveData(frsResponseData);
            if (frsViewData.getForum() != null) {
                this.s = frsViewData.getForum().getName();
                this.r = frsViewData.getForum().getId();
            }
            if (StringUtils.isNull(this.s) || StringUtils.isNull(this.r)) {
                return false;
            }
            if ((frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().a() == null || frsViewData.getUserData().getIs_manager() != 1) && frsViewData.getPrivateForumPopInfo() == null) {
                return false;
            }
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            this.p = privateForumPopInfoData;
            privateForumPopInfoData.E(frsViewData.getPrivateForumTotalInfo().c());
            this.o = new FrsPrivateCommonDialogView(this.n);
            PrivateForumInfo a2 = frsViewData.getPrivateForumTotalInfo().a();
            if (a2 != null && a2.private_forum_status.intValue() == 1 && (dj.isEmpty(this.p.C()) || this.p.B() != dh.e(this.r, 0))) {
                this.p.H("create_success");
                this.p.I(String.format(t, this.r, this.s));
                this.p.G(dh.e(this.r, -1));
                this.p.setTitle(this.m.getString(R.string.obfuscated_res_0x7f0f147f));
                this.p.F(this.m.getString(R.string.obfuscated_res_0x7f0f1480));
                b2 = this.o.b(this.p, false);
            } else {
                b2 = this.p.B() == dh.e(this.r, 0) ? this.o.b(this.p, false) : false;
            }
            if (b2) {
                return b2;
            }
            PrivateForumPopInfoData privateForumPopInfo = frsViewData.getPrivateForumPopInfo();
            this.p = privateForumPopInfo;
            if (privateForumPopInfo == null || privateForumPopInfo.B() != dh.e(this.r, 0)) {
                return b2;
            }
            this.q = true;
            return this.o.b(this.p, true);
        }
        return invokeV.booleanValue;
    }
}
