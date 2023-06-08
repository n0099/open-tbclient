package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.c55;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes7.dex */
public class po7 extends j65 {
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
        public final /* synthetic */ c55 b;
        public final /* synthetic */ po7 c;

        public a(po7 po7Var, TbPageContext tbPageContext, c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po7Var, tbPageContext, c55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = po7Var;
            this.a = tbPageContext;
            this.b = c55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.Y()});
                lo7.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(po7 po7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(po7 po7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po7Var};
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
                z55.s("frsExam");
            }
        }
    }

    public po7() {
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

    @Override // com.baidu.tieba.j65
    public void a(@NonNull Context context, @NonNull b65 b65Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, b65Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                z55.s("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                yw9 frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(frsResponseData);
                if (frsViewData.getForum() != null) {
                    this.c = frsViewData.getForum().getName();
                    this.b = frsViewData.getForum().getId();
                }
                if (!StringUtils.isNull(this.c) && !StringUtils.isNull(this.b)) {
                    if ((frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().a() == null || frsViewData.getUserData().getIs_manager() != 1) && frsViewData.getPrivateForumPopInfo() == null) {
                        z55.s("frsExam");
                        return;
                    }
                    PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                    privateForumPopInfoData.Z(frsViewData.getPrivateForumTotalInfo().c());
                    FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(tbPageContextSupport.getPageContext().getPageActivity());
                    PrivateForumInfo a2 = frsViewData.getPrivateForumTotalInfo().a();
                    if (a2 != null && a2.private_forum_status.intValue() == 1 && (ui.isEmpty(privateForumPopInfoData.X()) || privateForumPopInfoData.W() != tg.e(this.b, 0))) {
                        privateForumPopInfoData.c0("create_success");
                        privateForumPopInfoData.d0(String.format(dn7.t, this.b, this.c));
                        privateForumPopInfoData.b0(tg.e(this.b, -1));
                        privateForumPopInfoData.setTitle(context.getString(R.string.obfuscated_res_0x7f0f16af));
                        privateForumPopInfoData.a0(context.getString(R.string.obfuscated_res_0x7f0f16b0));
                        z = frsPrivateCommonDialogView.c(privateForumPopInfoData, false);
                    } else if (privateForumPopInfoData.W() == tg.e(this.b, 0)) {
                        z = frsPrivateCommonDialogView.c(privateForumPopInfoData, false);
                    } else {
                        z = false;
                    }
                    if (!z && (privateForumPopInfoData = frsViewData.getPrivateForumPopInfo()) != null && privateForumPopInfoData.W() == tg.e(this.b, 0)) {
                        this.a = true;
                        frsPrivateCommonDialogView.c(privateForumPopInfoData, true);
                    }
                    TbPageContext pageContext = tbPageContextSupport.getPageContext();
                    c55 c55Var = new c55(pageContext.getPageActivity());
                    c55Var.setContentViewSize(10);
                    c55Var.setContentView(frsPrivateCommonDialogView);
                    c55Var.setCanceledOnTouchOutside(false);
                    frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, c55Var));
                    c55Var.setCloseButton(new b(this));
                    c55Var.setOnDismissListener(new c(this));
                    c55Var.create(pageContext).show();
                    FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                    lo7.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                    return;
                }
                z55.s("frsExam");
                return;
            }
            z55.s("frsExam");
        }
    }
}
