package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.iv4;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y98 implements cb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public TbPageContext c;
    public oy4 d;
    public qy4 e;
    public BdUniqueId f;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y98 a;

        public a(y98 y98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y98Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(this.a.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(y98 y98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y98 a;

        public c(y98 y98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y98Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    iv4Var.dismiss();
                    this.a.c.showToast(R.string.obfuscated_res_0x7f0f072f);
                    return;
                }
                TiebaStatic.log("c10038");
                iv4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.c.getPageActivity(), 2, true, 5);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                if (!StringUtils.isNULL("4010001002")) {
                    memberPayActivityConfig.setSceneId("4010001002");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(y98 y98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ y98 b;

        public e(y98 y98Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y98Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y98Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.b.g();
                MessageManager.getInstance().sendMessage(this.a);
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(y98 y98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    public y98(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = "";
        this.c = tbPageContext;
        qy4 qy4Var = new qy4();
        this.e = qy4Var;
        qy4Var.a = 1000L;
        this.f = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        BdUniqueId bdUniqueId2 = this.f;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId2;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId3 = this.f;
        userMuteCheckCustomMessage.mId = bdUniqueId3;
        userMuteCheckCustomMessage.setTag(bdUniqueId3);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    @Override // com.baidu.tieba.cb8
    public void a(int i, int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            oy4 oy4Var = this.d;
            if (oy4Var != null) {
                oy4Var.h(false);
            }
            this.a = i2;
            this.b = str;
            if (i3 == 0) {
                if (i == 1) {
                    this.e.d(this.c.getString(R.string.obfuscated_res_0x7f0f0b69));
                } else if (i == 2) {
                    this.e.d(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f14f6));
                }
            } else if (i3 == 220017) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.c.getString(R.string.obfuscated_res_0x7f0f0b65);
                }
                i(str2);
            } else if (i3 == 1990043) {
                h();
            } else {
                if (wi.isEmpty(str2)) {
                    if (i == 1) {
                        str2 = this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0b66);
                    } else if (i == 2) {
                        str2 = this.c.getResources().getString(R.string.obfuscated_res_0x7f0f14f5);
                    }
                }
                this.e.c(str2);
            }
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.d == null) {
                oy4 oy4Var = new oy4(this.c);
                this.d = oy4Var;
                oy4Var.e(new a(this));
            }
            this.d.h(true);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            iv4 iv4Var = new iv4(this.c.getPageActivity());
            iv4Var.setMessage(this.c.getString(R.string.obfuscated_res_0x7f0f0b67));
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3b, new c(this));
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(this));
            iv4Var.create(this.c).show();
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                str = "";
            }
            iv4 iv4Var = new iv4(this.c.getPageActivity());
            iv4Var.setMessage(str);
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d2, new b(this));
            iv4Var.create(this.c).show();
        }
    }

    public void j(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2}) == null) {
            if (z) {
                g();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            iv4 iv4Var = new iv4(this.c.getPageActivity());
            if (!wi.isEmpty(str)) {
                iv4Var.setMessage(str);
            } else {
                iv4Var.setMessage(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0324, str2));
            }
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043f, new e(this, userMuteAddAndDelCustomMessage));
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new f(this));
            iv4Var.create(this.c).show();
        }
    }
}
