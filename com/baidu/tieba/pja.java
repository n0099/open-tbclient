package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.m45;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pja {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public UEGCancelModel a;
    public UEGCancelModel.b b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948065346, "Lcom/baidu/tieba/pja;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948065346, "Lcom/baidu/tieba/pja;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements UEGCancelModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pja a;

        public a(pja pjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pjaVar;
        }

        @Override // com.baidu.tieba.ueg.UEGCancelModel.b
        public void a(BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, blockPopInfoData) != null) || blockPopInfoData == null || pja.d) {
                return;
            }
            this.a.d(blockPopInfoData);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ pja b;

        public b(pja pjaVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pjaVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pjaVar;
            this.a = blockPopInfoData;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", this.b.c).param("obj_type", this.a.win_type));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ pja b;

        public c(pja pjaVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pjaVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pjaVar;
            this.a = blockPopInfoData;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.b.e(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", this.b.c).param("obj_type", this.a.win_type));
            }
        }
    }

    public pja() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_COLD_BOOT;
        this.a = new UEGCancelModel();
        if (this.b == null) {
            this.b = new a(this);
        }
        this.a.P(this.b);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c = i;
            this.a.O();
        }
    }

    public final void e(BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, blockPopInfoData) != null) || blockPopInfoData == null || (currentActivity = BdActivityStack.getInst().currentActivity()) == null) {
            return;
        }
        AntiHelper.p(currentActivity, blockPopInfoData.ahead_url);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            d = z;
        }
    }

    public final void d(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, blockPopInfoData) != null) || blockPopInfoData == null || BdActivityStack.getInst().currentActivity() == null) {
            return;
        }
        String str = blockPopInfoData.block_id_code;
        int i = blockPopInfoData.win_type;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str2 = blockPopInfoData.ahead_url;
        String str3 = blockPopInfoData.ok_info;
        String str4 = blockPopInfoData.ahead_info;
        String str5 = blockPopInfoData.block_info;
        if ((i == 1 || i == 2 || i == 3 || i == 4) && !bi.isEmpty(currentAccount) && !bi.isEmpty(str)) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            boolean z = false;
            boolean z2 = sharedPrefHelper.getBoolean(str + i + currentAccount, false);
            if ((!bi.isEmpty(str2) || i == 4) && !bi.isEmpty(str3) && ((!bi.isEmpty(str4) || i == 4) && !bi.isEmpty(str5))) {
                z = true;
            }
            if (!z2 && z) {
                SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                sharedPrefHelper2.putBoolean(str + i + currentAccount, true);
                h(blockPopInfoData);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", this.c).param("obj_type", i));
            }
        }
    }

    public void f() {
        UEGCancelModel uEGCancelModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (uEGCancelModel = this.a) != null) {
            uEGCancelModel.onDestroy();
        }
    }

    public final void h(BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, blockPopInfoData) != null) || blockPopInfoData == null || (currentActivity = BdActivityStack.getInst().currentActivity()) == null) {
            return;
        }
        m45 m45Var = new m45(currentActivity);
        m45Var.setMessage(blockPopInfoData.block_info);
        m45Var.setNegativeButton(blockPopInfoData.ok_info, new b(this, blockPopInfoData));
        m45Var.setPositiveButton(blockPopInfoData.ahead_info, new c(this, blockPopInfoData));
        m45Var.create(((BdPageContextSupport) currentActivity).getPageContext());
        m45Var.show();
    }
}
