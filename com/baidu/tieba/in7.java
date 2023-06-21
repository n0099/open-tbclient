package com.baidu.tieba;

import android.content.DialogInterface;
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
import com.baidu.tieba.d55;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes6.dex */
public class in7 extends PriorityOrganizer.Task {
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d55 a;
        public final /* synthetic */ in7 b;

        public a(in7 in7Var, d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in7Var, d55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = in7Var;
            this.a = d55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.b.m.getPageContext(), new String[]{privateForumPopInfoData.Y()});
                to7.f(privateForumPopInfoData, booleanValue, this.b.r, this.b.s, true);
                this.a.dismiss();
                this.b.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ in7 a;

        public b(in7 in7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = in7Var;
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                d55Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.a.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(in7 in7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                a65.s("frsExam");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947859351, "Lcom/baidu/tieba/in7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947859351, "Lcom/baidu/tieba/in7;");
                return;
            }
        }
        t = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
    }

    public in7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsFragment frsFragment = this.m;
            if (frsFragment != null && !frsFragment.I3() && TbSingleton.getInstance().getFrsResponseData() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean w() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a65.j()) {
                return false;
            }
            qy9 frsResponseData = TbSingleton.getInstance().getFrsResponseData();
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
            privateForumPopInfoData.Z(frsViewData.getPrivateForumTotalInfo().c());
            this.o = new FrsPrivateCommonDialogView(this.n);
            PrivateForumInfo a2 = frsViewData.getPrivateForumTotalInfo().a();
            if (a2 != null && a2.private_forum_status.intValue() == 1 && (vi.isEmpty(this.p.X()) || this.p.W() != ug.e(this.r, 0))) {
                this.p.c0("create_success");
                this.p.d0(String.format(t, this.r, this.s));
                this.p.b0(ug.e(this.r, -1));
                this.p.setTitle(this.m.getString(R.string.obfuscated_res_0x7f0f16b3));
                this.p.a0(this.m.getString(R.string.obfuscated_res_0x7f0f16b4));
                z = this.o.c(this.p, false);
            } else if (this.p.W() == ug.e(this.r, 0)) {
                z = this.o.c(this.p, false);
            } else {
                z = false;
            }
            if (!z) {
                PrivateForumPopInfoData privateForumPopInfo = frsViewData.getPrivateForumPopInfo();
                this.p = privateForumPopInfo;
                if (privateForumPopInfo != null && privateForumPopInfo.W() == ug.e(this.r, 0)) {
                    this.q = true;
                    return this.o.c(this.p, true);
                }
                return z;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d55 d55Var = new d55(this.n);
            d55Var.setContentViewSize(10);
            d55Var.setContentView(this.o);
            d55Var.setCanceledOnTouchOutside(false);
            this.o.setConfirmButton(new a(this, d55Var));
            d55Var.setCloseButton(new b(this));
            d55Var.setOnDismissListener(new c(this));
            d55Var.create(this.m.getPageContext()).show();
            FrsPrivateCommonDialogView.setDialogShown(this.p, this.q);
            to7.f(this.p, this.q, this.r, this.s, false);
            this.m.P4(true);
            a65.m("frsExam");
        }
    }
}
