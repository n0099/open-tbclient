package com.baidu.tieba;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.s45;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;

        public a(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;

        public b(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TbPageContext c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public c(s45 s45Var, int i, TbPageContext tbPageContext, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var, Integer.valueOf(i), tbPageContext, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
            this.b = i;
            this.c = tbPageContext;
            this.d = str;
            this.e = str2;
            this.f = i2;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.dismiss();
                int i = this.b;
                int i2 = 2010;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5) {
                                    TiebaStatic.log("c10767");
                                }
                                i2 = 0;
                            } else {
                                TiebaStatic.log("c10285");
                            }
                        } else {
                            TiebaStatic.log("c10276");
                        }
                    } else {
                        TiebaStatic.log("c10282");
                    }
                    PayPanelUtils.launchPayPanel(this.c, i2, this.d, this.e, String.valueOf(this.f));
                }
                TiebaStatic.log("c10271");
                i2 = IMConstants.IM_MSG_TYPE_SHIELD;
                PayPanelUtils.launchPayPanel(this.c, i2, this.d, this.e, String.valueOf(this.f));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;

        public d(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TbPageContext c;

        public e(s45 s45Var, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
            this.b = str;
            this.c = tbPageContext;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.dismiss();
                if (this.b == null) {
                    return;
                }
                TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
                BrowserHelper.startInternalWebActivity(this.c.getPageActivity(), this.b);
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

    public static void b(TbPageContext<?> tbPageContext, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65537, null, tbPageContext, i, str) != null) || tbPageContext == null) {
            return;
        }
        s45 s45Var = new s45(tbPageContext.getPageActivity());
        s45Var.setMessageId(R.string.obfuscated_res_0x7f0f1690);
        s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new d(s45Var));
        s45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f168f, new e(s45Var, str, tbPageContext));
        s45Var.create(tbPageContext);
        s45Var.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2)}) != null) || tbPageContext == null) {
            return;
        }
        s45 s45Var = new s45(tbPageContext.getPageActivity());
        s45Var.setButtonTextColor(R.color.CAM_X0305);
        s45Var.setTitle(str);
        a aVar = new a(s45Var);
        s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, aVar);
        s45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b46, aVar);
        s45Var.create(tbPageContext);
        s45Var.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3}) != null) || tbPageContext == null) {
            return;
        }
        s45 s45Var = new s45(tbPageContext.getPageActivity());
        s45Var.setButtonTextColor(R.color.CAM_X0305);
        s45Var.setMessage(str);
        s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new b(s45Var));
        s45Var.setPositiveButton(R.string.open_now, new c(s45Var, i, tbPageContext, str2, str3, i2));
        s45Var.create(tbPageContext);
        s45Var.show();
    }
}
