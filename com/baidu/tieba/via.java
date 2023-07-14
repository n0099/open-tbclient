package com.baidu.tieba;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.p55;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class via {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;

        public a(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;

        public b(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TbPageContext c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public c(p55 p55Var, int i, TbPageContext tbPageContext, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var, Integer.valueOf(i), tbPageContext, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
            this.b = i;
            this.c = tbPageContext;
            this.d = str;
            this.e = str2;
            this.f = i2;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
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
                    rd9.e(this.c, i2, this.d, this.e, String.valueOf(this.f));
                }
                TiebaStatic.log("c10271");
                i2 = IMConstants.IM_MSG_TYPE_SHIELD;
                rd9.e(this.c, i2, this.d, this.e, String.valueOf(this.f));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;

        public d(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TbPageContext c;

        public e(p55 p55Var, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
            this.b = str;
            this.c = tbPageContext;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.dismiss();
                if (this.b == null) {
                    return;
                }
                TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
                nx4.q(this.c.getPageActivity(), this.b);
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
        p55 p55Var = new p55(tbPageContext.getPageActivity());
        p55Var.setMessageId(R.string.obfuscated_res_0x7f0f167e);
        p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new d(p55Var));
        p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f167d, new e(p55Var, str, tbPageContext));
        p55Var.create(tbPageContext);
        p55Var.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2)}) != null) || tbPageContext == null) {
            return;
        }
        p55 p55Var = new p55(tbPageContext.getPageActivity());
        p55Var.setButtonTextColor(R.color.CAM_X0305);
        p55Var.setTitle(str);
        a aVar = new a(p55Var);
        p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, aVar);
        p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b3d, aVar);
        p55Var.create(tbPageContext);
        p55Var.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3}) != null) || tbPageContext == null) {
            return;
        }
        p55 p55Var = new p55(tbPageContext.getPageActivity());
        p55Var.setButtonTextColor(R.color.CAM_X0305);
        p55Var.setMessage(str);
        p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(p55Var));
        p55Var.setPositiveButton(R.string.open_now, new c(p55Var, i, tbPageContext, str2, str3, i2));
        p55Var.create(tbPageContext);
        p55Var.show();
    }
}
