package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.nu4;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class os8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;

        public a(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;

        public b(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TbPageContext c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public c(nu4 nu4Var, int i, TbPageContext tbPageContext, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var, Integer.valueOf(i), tbPageContext, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
            this.b = i;
            this.c = tbPageContext;
            this.d = i2;
            this.e = str;
            this.f = str2;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
                int i2 = this.b;
                String str = null;
                if (i2 == 1) {
                    i = 10;
                    TiebaStatic.log("c10271");
                    str = "4011001001";
                } else if (i2 == 2) {
                    i = 13;
                    TiebaStatic.log("c10282");
                    str = "4012001001";
                } else if (i2 == 3) {
                    i = 11;
                    TiebaStatic.log("c10276");
                    str = "4011001002";
                } else if (i2 == 4) {
                    i = 14;
                    TiebaStatic.log("c10285");
                    str = "4012001002";
                } else if (i2 != 5) {
                    i = i2 != 7 ? 0 : 22;
                } else {
                    i = 18;
                    TiebaStatic.log("c10767");
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.c.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                memberPayActivityConfig.setFromScence(this.d);
                memberPayActivityConfig.setReferPageClickZone(this.e, this.f);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;

        public d(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TbPageContext c;

        public e(nu4 nu4Var, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
            this.b = str;
            this.c = tbPageContext;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
                if (this.b == null) {
                    return;
                }
                TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
                yo4.n(this.c.getPageActivity(), this.b);
            }
        }
    }

    public static boolean a(DressItemData dressItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dressItemData)) == null) {
            int freeUserLevel = dressItemData.getFreeUserLevel();
            if (dressItemData.isDefault() || freeUserLevel == 0) {
                return true;
            }
            return freeUserLevel == 100 ? dressItemData.getActivityFinish() != 0 : freeUserLevel == 101 ? TbadkCoreApplication.getCurrentMemberType() == 3 : TbadkCoreApplication.getCurrentMemberType() >= 2 && TbadkCoreApplication.getCurrentVipLevel() >= freeUserLevel;
        }
        return invokeL.booleanValue;
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65537, null, tbPageContext, i, str) == null) || tbPageContext == null) {
            return;
        }
        nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
        nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f1428);
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(nu4Var));
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1427, new e(nu4Var, str, tbPageContext));
        nu4Var.create(tbPageContext);
        nu4Var.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) || tbPageContext == null) {
            return;
        }
        nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
        nu4Var.setButtonTextColor(R.color.CAM_X0305);
        nu4Var.setTitle(str);
        a aVar = new a(nu4Var);
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, aVar);
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f09b7, aVar);
        nu4Var.create(tbPageContext);
        nu4Var.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3}) == null) || tbPageContext == null) {
            return;
        }
        nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
        nu4Var.setButtonTextColor(R.color.CAM_X0305);
        nu4Var.setMessage(str);
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(nu4Var));
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new c(nu4Var, i, tbPageContext, i2, str2, str3));
        nu4Var.create(tbPageContext);
        nu4Var.show();
    }
}
