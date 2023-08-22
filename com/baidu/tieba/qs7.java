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
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes7.dex */
public class qs7 extends x55 {
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
        public final /* synthetic */ s45 b;
        public final /* synthetic */ qs7 c;

        public a(qs7 qs7Var, TbPageContext tbPageContext, s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs7Var, tbPageContext, s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qs7Var;
            this.a = tbPageContext;
            this.b = s45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.R()});
                ls7.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(qs7 qs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(qs7 qs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs7Var};
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

    public qs7() {
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

    @Override // com.baidu.tieba.x55
    public void a(@NonNull Context context, @NonNull p55 p55Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, p55Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                qea frsResponseData = TbSingleton.getInstance().getFrsResponseData();
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
                    if (a2 != null && a2.private_forum_status.intValue() == 1 && (di.isEmpty(privateForumPopInfoData.Q()) || privateForumPopInfoData.P() != JavaTypesHelper.toInt(this.b, 0))) {
                        privateForumPopInfoData.V("create_success");
                        privateForumPopInfoData.W(String.format(ar7.h, this.b, this.c));
                        privateForumPopInfoData.U(JavaTypesHelper.toInt(this.b, -1));
                        privateForumPopInfoData.setTitle(context.getString(R.string.obfuscated_res_0x7f0f16f8));
                        privateForumPopInfoData.T(context.getString(R.string.obfuscated_res_0x7f0f16f9));
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
                    s45 s45Var = new s45(pageContext.getPageActivity());
                    s45Var.setContentViewSize(10);
                    s45Var.setContentView(frsPrivateCommonDialogView);
                    s45Var.setCanceledOnTouchOutside(false);
                    frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, s45Var));
                    s45Var.setCloseButton(new b(this));
                    s45Var.setOnDismissListener(new c(this));
                    s45Var.create(pageContext).show();
                    FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                    ls7.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                    return;
                }
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("frsExam");
        }
    }
}
