package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.pu4;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BlockPopInfo;
/* loaded from: classes4.dex */
public class ku8 {
    public static /* synthetic */ Interceptable $ic;
    public static BlockPopInfo d;
    public static BlockPopInfo e;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public pu4 b;
    public CustomMessageListener c;

    /* loaded from: classes4.dex */
    public class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ku8 ku8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ku8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfo a;
        public final /* synthetic */ ku8 b;

        public b(ku8 ku8Var, BlockPopInfo blockPopInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ku8Var, blockPopInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ku8Var;
            this.a = blockPopInfo;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.b.e(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ku8 ku8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ku8Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            ku8.h(null);
            ku8.g(null);
        }
    }

    public ku8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c cVar = new c(this, 2005016);
        this.c = cVar;
        this.a = tbPageContext;
        tbPageContext.registerListener(cVar);
    }

    public static void g(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, blockPopInfo) == null) {
            e = blockPopInfo;
        }
    }

    public static void h(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, blockPopInfo) == null) {
            d = blockPopInfo;
        }
    }

    public final void e(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, blockPopInfo) != null) || blockPopInfo == null) {
            return;
        }
        AntiHelper.p(this.a.getPageActivity(), blockPopInfo.ahead_url);
    }

    public final boolean b(BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, blockPopInfo)) == null) {
            if (blockPopInfo != null && (num = blockPopInfo.appeal_status) != null && num.intValue() == 1) {
                BdToast b2 = BdToast.b(this.a.getPageActivity(), blockPopInfo.appeal_msg);
                b2.f(BdToast.ToastIcon.FAILURE);
                b2.c(3000);
                b2.i();
                return true;
            } else if (blockPopInfo != null && blockPopInfo.can_post.intValue() == 0) {
                if ((blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2) && blockPopInfo.appeal_status.intValue() != 1) {
                    if (blockPopInfo.ahead_type.intValue() == 1) {
                        String str = blockPopInfo.block_info;
                        String str2 = blockPopInfo.ok_info;
                        if (!ej.isEmpty(str) && !ej.isEmpty(str2)) {
                            i(blockPopInfo);
                        } else {
                            BdToast b3 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0848));
                            b3.f(BdToast.ToastIcon.FAILURE);
                            b3.c(3000);
                            b3.i();
                        }
                    } else if (blockPopInfo.ahead_type.intValue() == 2) {
                        e(blockPopInfo);
                    }
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return b(e);
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b(d);
        }
        return invokeV.booleanValue;
    }

    public void f() {
        pu4 pu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a != null && (pu4Var = this.b) != null && pu4Var.isShowing()) {
            this.b.autoChangeSkinType(this.a);
        }
    }

    public final void i(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, blockPopInfo) != null) || blockPopInfo == null) {
            return;
        }
        pu4 pu4Var = new pu4(this.a.getPageActivity());
        this.b = pu4Var;
        pu4Var.setMessage(blockPopInfo.block_info);
        this.b.setNegativeButton(blockPopInfo.ok_info, new a(this));
        this.b.setPositiveButton(blockPopInfo.ahead_info, new b(this, blockPopInfo));
        this.b.create(this.a).show();
    }
}
