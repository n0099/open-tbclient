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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.c05;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes9.dex */
public class x38 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ c05 b;
        public final /* synthetic */ x38 c;

        public a(x38 x38Var, TbPageContext tbPageContext, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x38Var, tbPageContext, c05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x38Var;
            this.a = tbPageContext;
            this.b = c05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.S()});
                p38.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(x38 x38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(x38 x38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x38Var};
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

    public x38() {
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    @Override // com.baidu.tieba.j15
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull Context context, @NonNull x05 x05Var) {
        ForumData forumData;
        UserData userData;
        PrivateForumPopInfoData privateForumPopInfoData;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, x05Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                eva frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(frsResponseData);
                py4 py4Var = null;
                if (context instanceof f25) {
                    f25 f25Var = (f25) context;
                    if (f25Var.i1() != null) {
                        e25 i1 = f25Var.i1();
                        py4Var = i1.n1();
                        userData = i1.W1();
                        privateForumPopInfoData = i1.r1();
                        forumData = i1.a1();
                        if (py4Var == null) {
                            py4Var = frsViewData.getPrivateForumTotalInfo();
                        }
                        if (userData == null) {
                            userData = frsViewData.getUserData();
                        }
                        if (privateForumPopInfoData == null) {
                            privateForumPopInfoData = frsViewData.getPrivateForumPopInfo();
                        }
                        if (forumData == null) {
                            forumData = frsViewData.getForum();
                        }
                        if (forumData != null) {
                            this.c = forumData.getName();
                            this.b = forumData.getId();
                        }
                        if (StringUtils.isNull(this.c) && !StringUtils.isNull(this.b)) {
                            if ((py4Var == null || py4Var.a() == null || userData.getIs_manager() != 1) && privateForumPopInfoData == null) {
                                YunDialogManager.unMarkShowingDialogName("frsExam");
                                return;
                            }
                            PrivateForumPopInfoData privateForumPopInfoData2 = new PrivateForumPopInfoData();
                            privateForumPopInfoData2.T(py4Var.c());
                            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(tbPageContextSupport.getPageContext().getPageActivity());
                            PrivateForumInfo a2 = py4Var.a();
                            if (a2 != null && a2.private_forum_status.intValue() == 1 && (rd.isEmpty(privateForumPopInfoData2.R()) || privateForumPopInfoData2.Q() != JavaTypesHelper.toInt(this.b, 0))) {
                                privateForumPopInfoData2.W("create_success");
                                privateForumPopInfoData2.X(String.format(v38.a, this.b, this.c));
                                privateForumPopInfoData2.V(JavaTypesHelper.toInt(this.b, -1));
                                privateForumPopInfoData2.setTitle(context.getString(R.string.obfuscated_res_0x7f0f174f));
                                privateForumPopInfoData2.U(context.getString(R.string.obfuscated_res_0x7f0f1750));
                                z = frsPrivateCommonDialogView.c(privateForumPopInfoData2, false);
                            } else if (privateForumPopInfoData2.Q() == JavaTypesHelper.toInt(this.b, 0)) {
                                z = frsPrivateCommonDialogView.c(privateForumPopInfoData2, false);
                            } else {
                                z = false;
                            }
                            if (!z) {
                                if (privateForumPopInfoData != null && privateForumPopInfoData.Q() == JavaTypesHelper.toInt(this.b, 0)) {
                                    this.a = true;
                                    frsPrivateCommonDialogView.c(privateForumPopInfoData, true);
                                }
                            } else {
                                privateForumPopInfoData = privateForumPopInfoData2;
                            }
                            TbPageContext pageContext = tbPageContextSupport.getPageContext();
                            c05 c05Var = new c05(pageContext.getPageActivity());
                            c05Var.setContentViewSize(10);
                            c05Var.setContentView(frsPrivateCommonDialogView);
                            c05Var.setCanceledOnTouchOutside(false);
                            frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, c05Var));
                            c05Var.setCloseButton(new b(this));
                            c05Var.setOnDismissListener(new c(this));
                            c05Var.create(pageContext).show();
                            FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                            p38.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                            return;
                        }
                        YunDialogManager.unMarkShowingDialogName("frsExam");
                        return;
                    }
                }
                forumData = null;
                userData = null;
                privateForumPopInfoData = null;
                if (py4Var == null) {
                }
                if (userData == null) {
                }
                if (privateForumPopInfoData == null) {
                }
                if (forumData == null) {
                }
                if (forumData != null) {
                }
                if (StringUtils.isNull(this.c)) {
                }
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("frsExam");
        }
    }
}
