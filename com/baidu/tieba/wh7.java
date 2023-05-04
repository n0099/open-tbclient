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
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes6.dex */
public class wh7 extends b25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ u05 b;
        public final /* synthetic */ wh7 c;

        public a(wh7 wh7Var, TbPageContext tbPageContext, u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh7Var, tbPageContext, u05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wh7Var;
            this.a = tbPageContext;
            this.b = u05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.Z()});
                sh7.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wh7 wh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(wh7 wh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh7Var};
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
                r15.s("frsExam");
            }
        }
    }

    public wh7() {
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

    @Override // com.baidu.tieba.b25
    public void a(@NonNull Context context, @NonNull t15 t15Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, t15Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                r15.s("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                eo9 frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(frsResponseData);
                if (frsViewData.getForum() != null) {
                    this.c = frsViewData.getForum().getName();
                    this.b = frsViewData.getForum().getId();
                }
                if (!StringUtils.isNull(this.c) && !StringUtils.isNull(this.b)) {
                    if ((frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().a() == null || frsViewData.getUserData().getIs_manager() != 1) && frsViewData.getPrivateForumPopInfo() == null) {
                        r15.s("frsExam");
                        return;
                    }
                    PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                    privateForumPopInfoData.a0(frsViewData.getPrivateForumTotalInfo().c());
                    FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(tbPageContextSupport.getPageContext().getPageActivity());
                    PrivateForumInfo a2 = frsViewData.getPrivateForumTotalInfo().a();
                    if (a2 != null && a2.private_forum_status.intValue() == 1 && (hi.isEmpty(privateForumPopInfoData.Y()) || privateForumPopInfoData.X() != gg.e(this.b, 0))) {
                        privateForumPopInfoData.d0("create_success");
                        privateForumPopInfoData.e0(String.format(kg7.t, this.b, this.c));
                        privateForumPopInfoData.c0(gg.e(this.b, -1));
                        privateForumPopInfoData.setTitle(context.getString(R.string.obfuscated_res_0x7f0f1570));
                        privateForumPopInfoData.b0(context.getString(R.string.obfuscated_res_0x7f0f1571));
                        z = frsPrivateCommonDialogView.c(privateForumPopInfoData, false);
                    } else if (privateForumPopInfoData.X() == gg.e(this.b, 0)) {
                        z = frsPrivateCommonDialogView.c(privateForumPopInfoData, false);
                    } else {
                        z = false;
                    }
                    if (!z && (privateForumPopInfoData = frsViewData.getPrivateForumPopInfo()) != null && privateForumPopInfoData.X() == gg.e(this.b, 0)) {
                        this.a = true;
                        frsPrivateCommonDialogView.c(privateForumPopInfoData, true);
                    }
                    TbPageContext pageContext = tbPageContextSupport.getPageContext();
                    u05 u05Var = new u05(pageContext.getPageActivity());
                    u05Var.setContentViewSize(10);
                    u05Var.setContentView(frsPrivateCommonDialogView);
                    u05Var.setCanceledOnTouchOutside(false);
                    frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, u05Var));
                    u05Var.setCloseButton(new b(this));
                    u05Var.setOnDismissListener(new c(this));
                    u05Var.create(pageContext).show();
                    FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                    sh7.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                    return;
                }
                r15.s("frsExam");
                return;
            }
            r15.s("frsExam");
        }
    }
}
