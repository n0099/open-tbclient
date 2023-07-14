package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.a65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class kc5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ic5 a;
    public WeakReference<jc5> b;
    public TbPageContext c;
    public sf5 d;
    public BdUniqueId e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public y55 j;
    public boolean k;
    public g05 l;
    public f m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kc5 kc5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(this.a.a.getUserId()) && this.a.a.getUserId().equals(str)) {
                    this.a.k = true;
                }
                bh.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kc5 kc5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.b data = updateAttentionMessage.getData();
            ic5 ic5Var = this.a.a;
            if (ic5Var != null && !StringUtils.isNull(ic5Var.getUserId()) && data != null && this.a.a.getUserId().equals(data.c)) {
                if (updateAttentionMessage.getOrginalMessage() != null && this.a.e != null && updateAttentionMessage.getOrginalMessage().getTag().equals(this.a.e)) {
                    z = true;
                } else {
                    z = false;
                }
                BlockPopInfoData blockPopInfoData = data.i;
                if (blockPopInfoData != null) {
                    String str2 = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                        }
                    } else if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                    }
                    this.a.c.showToast(str2);
                } else if (!data.a) {
                    this.a.k = false;
                    if (updateAttentionMessage.getData() != null) {
                        str = updateAttentionMessage.getData().b;
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), str);
                    b.g(BdToast.ToastIcon.FAILURE);
                    b.d(3000);
                    b.q();
                    jc5 jc5Var = (jc5) this.a.b.get();
                    if (jc5Var == null) {
                        return;
                    }
                    if (z) {
                        jc5Var.b(this.a.a.getIsLike(), this.a.a.getLikeStatus(), z);
                    } else {
                        jc5Var.d(this.a.a.getIsLike(), this.a.a.getLikeStatus());
                    }
                } else {
                    int fansNum = this.a.a.getFansNum();
                    boolean isLike = this.a.a.getIsLike();
                    if (data.d && !isLike) {
                        fansNum++;
                    } else if (!data.d && isLike) {
                        fansNum--;
                        if (!this.a.h) {
                            this.a.c.showToast(R.string.un_attention_success);
                        }
                    }
                    this.a.a.setLikeStatus(data.j);
                    this.a.a.setIsLike(data.d);
                    this.a.a.setIsFromNetWork(false);
                    this.a.a.setFansNum(fansNum);
                    this.a.k = false;
                    jc5 jc5Var2 = (jc5) this.a.b.get();
                    if (jc5Var2 != null) {
                        jc5Var2.c(fansNum);
                        if (z) {
                            if (this.a.m != null) {
                                this.a.m.a(data.d);
                            }
                            jc5Var2.b(data.d, data.j, true);
                            return;
                        }
                        jc5Var2.d(data.d, data.j);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a65.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc5 a;

        public c(kc5 kc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc5Var;
        }

        @Override // com.baidu.tieba.a65.e
        public void onClick() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jc5 jc5Var = (jc5) this.a.b.get();
                if (jc5Var instanceof View) {
                    this.a.k = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    ic5 ic5Var = this.a.a;
                    if (ic5Var != null) {
                        str = ic5Var.getUserId();
                    } else {
                        str = "0";
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, str));
                    this.a.onClick((View) jc5Var);
                }
                bh.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a65.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc5 a;

        public d(kc5 kc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc5Var;
        }

        @Override // com.baidu.tieba.a65.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.j == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(kc5 kc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
            }
        }
    }

    public kc5(TbPageContext tbPageContext, jc5 jc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jc5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new WeakReference<>(null);
        this.f = "0";
        this.n = new a(this, 2921560);
        this.o = new b(this, 2001115);
        this.c = tbPageContext;
        this.d = new sf5(tbPageContext);
        this.e = this.c.getUniqueId();
        tbPageContext.registerListener(this.o);
        tbPageContext.registerListener(this.n);
        p(jc5Var);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.h = z;
            this.d.f(z);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public void l(ic5 ic5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ic5Var) == null) {
            this.a = ic5Var;
            jc5 jc5Var = this.b.get();
            if (jc5Var != null && this.a != null) {
                jc5Var.d(ic5Var.getIsLike(), ic5Var.getLikeStatus());
                jc5Var.c(ic5Var.getFansNum());
            }
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g = str;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void p(jc5 jc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, jc5Var) == null) && jc5Var != null) {
            this.b = new WeakReference<>(jc5Var);
            jc5Var.e(this);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public ic5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ic5) invokeV.objValue;
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.e = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
        this.o.setTag(this.e);
        this.n.setTag(this.e);
        MessageManager.getInstance().registerListener(this.o);
        MessageManager.getInstance().registerListener(this.n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ic5 ic5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            g05 g05Var = this.l;
            if (g05Var != null && g05Var.a(view2)) {
                return;
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.c.showToast(R.string.obfuscated_res_0x7f0f0e1f);
                return;
            }
            jc5 jc5Var = this.b.get();
            if (jc5Var != null) {
                jc5Var.a(view2);
            }
            if (!ViewHelper.checkUpIsLogin(this.c.getPageActivity()) || (ic5Var = this.a) == null) {
                return;
            }
            boolean z = !ic5Var.getIsLike();
            if (!z && this.i && !this.k) {
                q();
            } else if (this.e == null) {
                this.d.j(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.c.getUniqueId(), null, "0", this.g);
            } else {
                this.d.j(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.e, null, "0", this.g);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.j == null) {
                a65 a65Var = new a65(TbadkCoreApplication.getInst().getCurrentActivity());
                a65Var.t(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
                ArrayList arrayList = new ArrayList();
                w55 w55Var = new w55(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), a65Var);
                w55Var.m(new c(this));
                arrayList.add(w55Var);
                a65Var.o(new d(this));
                a65Var.l(arrayList);
                y55 y55Var = new y55(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), a65Var);
                this.j = y55Var;
                y55Var.k(0.7f);
            }
            this.j.setOnCancelListener(new e(this));
            bh.i(this.j, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }
}
