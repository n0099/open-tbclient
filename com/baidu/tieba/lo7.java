package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.hz4;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes7.dex */
public class lo7 extends o05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ hz4 b;
        public final /* synthetic */ lo7 c;

        public a(lo7 lo7Var, TbPageContext tbPageContext, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo7Var, tbPageContext, hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lo7Var;
            this.a = tbPageContext;
            this.b = hz4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.R()});
                fo7.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(lo7 lo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo7Var};
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
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(lo7 lo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo7Var};
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
                YunDialogManager.unMarkShowingDialogName("frsExam");
            }
        }
    }

    public lo7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    @Override // com.baidu.tieba.o05
    public void a(@NonNull Context context, @NonNull c05 c05Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, c05Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                fda frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(frsResponseData);
                if (frsViewData.getForum() != null) {
                    this.c = frsViewData.getForum().getName();
                    this.b = frsViewData.getForum().getId();
                }
                if (!StringUtils.isNull(this.c) && !StringUtils.isNull(this.b)) {
                    if ((frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().a() == null || frsViewData.getUserData().getIs_manager() != 1) && frsViewData.getPrivateForumPopInfo() == null) {
                        YunDialogManager.unMarkShowingDialogName("frsExam");
                        return;
                    }
                    PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                    privateForumPopInfoData.S(frsViewData.getPrivateForumTotalInfo().c());
                    FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(tbPageContextSupport.getPageContext().getPageActivity());
                    PrivateForumInfo a2 = frsViewData.getPrivateForumTotalInfo().a();
                    if (a2 != null && a2.private_forum_status.intValue() == 1 && (ad.isEmpty(privateForumPopInfoData.Q()) || privateForumPopInfoData.P() != JavaTypesHelper.toInt(this.b, 0))) {
                        privateForumPopInfoData.V("create_success");
                        privateForumPopInfoData.W(String.format(ko7.a, this.b, this.c));
                        privateForumPopInfoData.U(JavaTypesHelper.toInt(this.b, -1));
                        privateForumPopInfoData.setTitle(context.getString(R.string.obfuscated_res_0x7f0f1727));
                        privateForumPopInfoData.T(context.getString(R.string.obfuscated_res_0x7f0f1728));
                        z = frsPrivateCommonDialogView.c(privateForumPopInfoData, false);
                    } else if (privateForumPopInfoData.P() == JavaTypesHelper.toInt(this.b, 0)) {
                        z = frsPrivateCommonDialogView.c(privateForumPopInfoData, false);
                    } else {
                        z = false;
                    }
                    if (!z && (privateForumPopInfoData = frsViewData.getPrivateForumPopInfo()) != null && privateForumPopInfoData.P() == JavaTypesHelper.toInt(this.b, 0)) {
                        this.a = true;
                        frsPrivateCommonDialogView.c(privateForumPopInfoData, true);
                    }
                    TbPageContext pageContext = tbPageContextSupport.getPageContext();
                    hz4 hz4Var = new hz4(pageContext.getPageActivity());
                    hz4Var.setContentViewSize(10);
                    hz4Var.setContentView(frsPrivateCommonDialogView);
                    hz4Var.setCanceledOnTouchOutside(false);
                    frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, hz4Var));
                    hz4Var.setCloseButton(new b(this));
                    hz4Var.setOnDismissListener(new c(this));
                    hz4Var.create(pageContext).show();
                    FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                    fo7.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                    return;
                }
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("frsExam");
        }
    }
}
