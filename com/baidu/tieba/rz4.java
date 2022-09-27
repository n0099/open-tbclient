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
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class rz4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pz4 a;
    public WeakReference<qz4> b;
    public TbPageContext c;
    public n25 d;
    public BdUniqueId e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public wu4 j;
    public boolean k;
    public op4 l;
    public f m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rz4 rz4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz4Var, Integer.valueOf(i)};
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
            this.a = rz4Var;
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
                ih.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rz4 rz4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz4Var, Integer.valueOf(i)};
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
            this.a = rz4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                pz4 pz4Var = this.a.a;
                if (pz4Var == null || StringUtils.isNull(pz4Var.getUserId()) || data == null || !this.a.a.getUserId().equals(data.c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || this.a.e == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(this.a.e)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.l;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0288);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0292);
                    }
                    this.a.c.showToast(str);
                } else if (!data.a) {
                    this.a.k = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d22);
                    }
                    BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), str2);
                    b.f(BdToast.ToastIcon.FAILURE);
                    b.c(3000);
                    b.i();
                    qz4 qz4Var = (qz4) this.a.b.get();
                    if (qz4Var == null) {
                        return;
                    }
                    if (z) {
                        qz4Var.c(this.a.a.getIsLike(), this.a.a.getLikeStatus(), z);
                    } else {
                        qz4Var.e(this.a.a.getIsLike(), this.a.a.getLikeStatus());
                    }
                } else {
                    int fansNum = this.a.a.getFansNum();
                    boolean isLike = this.a.a.getIsLike();
                    if (data.d && !isLike) {
                        fansNum++;
                    } else if (!data.d && isLike) {
                        if (!this.a.i || this.a.k) {
                            fansNum--;
                            if (!this.a.h) {
                                this.a.c.showToast(R.string.obfuscated_res_0x7f0f14bb);
                            }
                        } else {
                            this.a.k = false;
                            this.a.s();
                            return;
                        }
                    }
                    this.a.a.setLikeStatus(data.m);
                    this.a.a.setIsLike(data.d);
                    this.a.a.setIsFromNetWork(false);
                    this.a.a.setFansNum(fansNum);
                    this.a.k = false;
                    qz4 qz4Var2 = (qz4) this.a.b.get();
                    if (qz4Var2 != null) {
                        qz4Var2.d(fansNum);
                        if (z) {
                            if (this.a.m != null) {
                                this.a.m.a(data.d);
                            }
                            qz4Var2.c(data.d, data.m, true);
                            return;
                        }
                        qz4Var2.e(data.d, data.m);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz4 a;

        public c(rz4 rz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz4Var;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qz4 qz4Var = (qz4) this.a.b.get();
                if (qz4Var instanceof View) {
                    this.a.k = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    pz4 pz4Var = this.a.a;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, pz4Var != null ? pz4Var.getUserId() : "0"));
                    this.a.onClick((View) qz4Var);
                }
                ih.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements yu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz4 a;

        public d(rz4 rz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz4Var;
        }

        @Override // com.baidu.tieba.yu4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(rz4 rz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz4Var};
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

    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z);
    }

    public rz4(TbPageContext tbPageContext, qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, qz4Var};
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
        this.d = new n25(tbPageContext);
        this.e = this.c.getUniqueId();
        tbPageContext.registerListener(this.o);
        tbPageContext.registerListener(this.n);
        r(qz4Var);
    }

    public pz4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (pz4) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.h = z;
            this.d.i(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
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

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public void n(pz4 pz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pz4Var) == null) {
            this.a = pz4Var;
            qz4 qz4Var = this.b.get();
            if (qz4Var == null || this.a == null) {
                return;
            }
            qz4Var.e(pz4Var.getIsLike(), pz4Var.getLikeStatus());
            qz4Var.d(pz4Var.getFansNum());
        }
    }

    public void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.m = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        pz4 pz4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            op4 op4Var = this.l;
            if (op4Var == null || !op4Var.a(view2)) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.c.showToast(R.string.obfuscated_res_0x7f0f0c59);
                    return;
                }
                qz4 qz4Var = this.b.get();
                if (qz4Var != null) {
                    qz4Var.a(view2);
                }
                if (!ViewHelper.checkUpIsLogin(this.c.getPageActivity()) || (pz4Var = this.a) == null) {
                    return;
                }
                boolean z = !pz4Var.getIsLike();
                if (this.e == null) {
                    this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.c.getUniqueId(), null, "0", this.g);
                } else {
                    this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.e, null, "0", this.g);
                }
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.i = z;
        }
    }

    public void r(qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, qz4Var) == null) || qz4Var == null) {
            return;
        }
        this.b = new WeakReference<>(qz4Var);
        qz4Var.b(this);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.j == null) {
                yu4 yu4Var = new yu4(TbadkCoreApplication.getInst().getCurrentActivity());
                yu4Var.q(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0440));
                ArrayList arrayList = new ArrayList();
                uu4 uu4Var = new uu4(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0436), yu4Var);
                uu4Var.m(new c(this));
                arrayList.add(uu4Var);
                yu4Var.m(new d(this));
                yu4Var.j(arrayList);
                wu4 wu4Var = new wu4(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), yu4Var);
                this.j = wu4Var;
                wu4Var.j(0.7f);
            }
            this.j.setOnCancelListener(new e(this));
            ih.i(this.j, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
    }
}
