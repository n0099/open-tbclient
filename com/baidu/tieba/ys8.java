package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pu4;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ys8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;

        public a(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;

        public b(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TbPageContext c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public c(pu4 pu4Var, int i, TbPageContext tbPageContext, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu4Var, Integer.valueOf(i), tbPageContext, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
            this.b = i;
            this.c = tbPageContext;
            this.d = i2;
            this.e = str;
            this.f = str2;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
                int i2 = this.b;
                String str = null;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    if (i2 != 7) {
                                        i = 0;
                                    } else {
                                        i = 22;
                                    }
                                } else {
                                    i = 18;
                                    TiebaStatic.log("c10767");
                                }
                            } else {
                                i = 14;
                                TiebaStatic.log("c10285");
                                str = "4012001002";
                            }
                        } else {
                            i = 11;
                            TiebaStatic.log("c10276");
                            str = "4011001002";
                        }
                    } else {
                        i = 13;
                        TiebaStatic.log("c10282");
                        str = "4012001001";
                    }
                } else {
                    i = 10;
                    TiebaStatic.log("c10271");
                    str = "4011001001";
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

    /* loaded from: classes6.dex */
    public final class d implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;

        public d(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TbPageContext c;

        public e(pu4 pu4Var, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu4Var, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
            this.b = str;
            this.c = tbPageContext;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
                if (this.b == null) {
                    return;
                }
                TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
                zo4.n(this.c.getPageActivity(), this.b);
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
            if (freeUserLevel == 100) {
                if (dressItemData.getActivityFinish() != 0) {
                    return true;
                }
                return false;
            } else if (freeUserLevel == 101) {
                if (TbadkCoreApplication.getCurrentMemberType() == 3) {
                    return true;
                }
                return false;
            } else if (TbadkCoreApplication.getCurrentMemberType() >= 2 && TbadkCoreApplication.getCurrentVipLevel() >= freeUserLevel) {
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void b(TbPageContext tbPageContext, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65537, null, tbPageContext, i, str) != null) || tbPageContext == null) {
            return;
        }
        pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
        pu4Var.setMessageId(R.string.obfuscated_res_0x7f0f1441);
        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(pu4Var));
        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1440, new e(pu4Var, str, tbPageContext));
        pu4Var.create(tbPageContext);
        pu4Var.show();
    }

    public static void c(TbPageContext tbPageContext, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2)}) != null) || tbPageContext == null) {
            return;
        }
        pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
        pu4Var.setButtonTextColor(R.color.CAM_X0305);
        pu4Var.setTitle(str);
        a aVar = new a(pu4Var);
        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, aVar);
        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f09c4, aVar);
        pu4Var.create(tbPageContext);
        pu4Var.show();
    }

    public static void d(TbPageContext tbPageContext, int i, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3}) != null) || tbPageContext == null) {
            return;
        }
        pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
        pu4Var.setButtonTextColor(R.color.CAM_X0305);
        pu4Var.setMessage(str);
        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(pu4Var));
        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new c(pu4Var, i, tbPageContext, i2, str2, str3));
        pu4Var.create(tbPageContext);
        pu4Var.show();
    }
}
