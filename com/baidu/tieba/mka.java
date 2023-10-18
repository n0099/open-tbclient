package com.baidu.tieba;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.hz4;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;

        public a(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;

        public b(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TbPageContext c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public c(hz4 hz4Var, int i, TbPageContext tbPageContext, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz4Var, Integer.valueOf(i), tbPageContext, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz4Var;
            this.b = i;
            this.c = tbPageContext;
            this.d = str;
            this.e = str2;
            this.f = i2;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
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

    /* loaded from: classes7.dex */
    public class d implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;

        public d(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TbPageContext c;

        public e(hz4 hz4Var, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz4Var, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz4Var;
            this.b = str;
            this.c = tbPageContext;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
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
        hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
        hz4Var.setMessageId(R.string.obfuscated_res_0x7f0f16be);
        hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new d(hz4Var));
        hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f16bd, new e(hz4Var, str, tbPageContext));
        hz4Var.create(tbPageContext);
        hz4Var.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2)}) != null) || tbPageContext == null) {
            return;
        }
        hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
        hz4Var.setButtonTextColor(R.color.CAM_X0305);
        hz4Var.setTitle(str);
        a aVar = new a(hz4Var);
        hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, aVar);
        hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b68, aVar);
        hz4Var.create(tbPageContext);
        hz4Var.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3}) != null) || tbPageContext == null) {
            return;
        }
        hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
        hz4Var.setButtonTextColor(R.color.CAM_X0305);
        hz4Var.setMessage(str);
        hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new b(hz4Var));
        hz4Var.setPositiveButton(R.string.open_now, new c(hz4Var, i, tbPageContext, str2, str3, i2));
        hz4Var.create(tbPageContext);
        hz4Var.show();
    }
}
