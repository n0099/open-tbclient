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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes8.dex */
public class wr7 extends PriorityOrganizer.Task {
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

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ wr7 b;

        public a(wr7 wr7Var, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var, p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr7Var;
            this.a = p55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.b.m.getPageContext(), new String[]{privateForumPopInfoData.Z()});
                ht7.f(privateForumPopInfoData, booleanValue, this.b.r, this.b.s, true);
                this.a.dismiss();
                this.b.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr7 a;

        public b(wr7 wr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr7Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.a.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(wr7 wr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var};
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
                m65.u("frsExam");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280269, "Lcom/baidu/tieba/wr7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280269, "Lcom/baidu/tieba/wr7;");
                return;
            }
        }
        t = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
    }

    public wr7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
            if (frsFragment != null && !frsFragment.K3() && TbSingleton.getInstance().getFrsResponseData() != null) {
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
            if (m65.k()) {
                return false;
            }
            nba frsResponseData = TbSingleton.getInstance().getFrsResponseData();
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
            privateForumPopInfoData.a0(frsViewData.getPrivateForumTotalInfo().c());
            this.o = new FrsPrivateCommonDialogView(this.n);
            PrivateForumInfo a2 = frsViewData.getPrivateForumTotalInfo().a();
            if (a2 != null && a2.private_forum_status.intValue() == 1 && (xi.isEmpty(this.p.Y()) || this.p.X() != wg.e(this.r, 0))) {
                this.p.d0("create_success");
                this.p.e0(String.format(t, this.r, this.s));
                this.p.c0(wg.e(this.r, -1));
                this.p.setTitle(this.m.getString(R.string.obfuscated_res_0x7f0f16e6));
                this.p.b0(this.m.getString(R.string.obfuscated_res_0x7f0f16e7));
                z = this.o.c(this.p, false);
            } else if (this.p.X() == wg.e(this.r, 0)) {
                z = this.o.c(this.p, false);
            } else {
                z = false;
            }
            if (!z) {
                PrivateForumPopInfoData privateForumPopInfo = frsViewData.getPrivateForumPopInfo();
                this.p = privateForumPopInfo;
                if (privateForumPopInfo != null && privateForumPopInfo.X() == wg.e(this.r, 0)) {
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
            p55 p55Var = new p55(this.n);
            p55Var.setContentViewSize(10);
            p55Var.setContentView(this.o);
            p55Var.setCanceledOnTouchOutside(false);
            this.o.setConfirmButton(new a(this, p55Var));
            p55Var.setCloseButton(new b(this));
            p55Var.setOnDismissListener(new c(this));
            p55Var.create(this.m.getPageContext()).show();
            FrsPrivateCommonDialogView.setDialogShown(this.p, this.q);
            ht7.f(this.p, this.q, this.r, this.s, false);
            this.m.U4(true);
            m65.n("frsExam");
        }
    }
}
