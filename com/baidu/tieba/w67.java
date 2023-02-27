package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class w67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ FrsTabInfo d;
        public final /* synthetic */ FrsViewData e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(FrsFragment frsFragment, FrsTabInfo frsTabInfo, FrsViewData frsViewData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsTabInfo, frsViewData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
            this.d = frsTabInfo;
            this.e = frsViewData;
            this.f = i;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                FrsFragment frsFragment = this.c;
                if (frsFragment != null && frsFragment.u1() != null) {
                    frsAllThreadFragment.E1(this.c.u1().Z());
                    this.c.Q4(h97.e(this.d, this.e.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                FrsFragment frsFragment2 = this.c;
                if (frsFragment2 != null) {
                    bundle.putString("forum_id", frsFragment2.l());
                }
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.f);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                eh5 eh5Var = new eh5();
                eh5Var.a = frsAllThreadFragment;
                eh5Var.e = 1;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, h97.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.e());
                bundle.putString("from", this.e.w3());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.l());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                eh5 eh5Var = new eh5();
                eh5Var.a = frsGoodFragment;
                eh5Var.e = this.f;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public c(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, h97.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.e());
                bundle.putString("from", this.e.w3());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.l());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                eh5 eh5Var = new eh5();
                eh5Var.a = frsNewAreaFragment;
                eh5Var.e = this.f;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public d(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.c.e());
                bundle.putString("from", this.c.w3());
                bundle.putString("forum_id", this.c.l());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                eh5 eh5Var = new eh5();
                eh5Var.a = frsADFragment;
                eh5Var.e = 90;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public e(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, h97.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.e());
                bundle.putString("from", this.e.w3());
                bundle.putString("forum_id", this.e.l());
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.f);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.d.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.d.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean("need_log", z);
                bundle.putBoolean("is_brand_forum", this.d.isBrandForum);
                bundle.putSerializable("view_data", this.d);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                eh5 eh5Var = new eh5();
                eh5Var.a = frsCommonTabFragment;
                eh5Var.e = this.f;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public f(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsTabWebFragment frsTabWebFragment = new FrsTabWebFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, h97.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.e());
                bundle.putString("from", this.e.w3());
                bundle.putString("forum_id", this.e.l());
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.f);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putString("tab_url", this.c.tab_url);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.d.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.d.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean("need_log", z);
                bundle.putBoolean("is_brand_forum", this.d.isBrandForum);
                bundle.putSerializable("view_data", this.d);
                bundle.putBoolean("isAdded", false);
                frsTabWebFragment.setArguments(bundle);
                eh5 eh5Var = new eh5();
                eh5Var.a = frsTabWebFragment;
                eh5Var.e = this.f;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends dh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabInfo e;
        public final /* synthetic */ FrsViewData f;
        public final /* synthetic */ String g;

        @Override // com.baidu.tieba.dh5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dh5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public g(FrsFragment frsFragment, int i, FrsTabInfo frsTabInfo, FrsViewData frsViewData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i), frsTabInfo, frsViewData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
            this.d = i;
            this.e = frsTabInfo;
            this.f = frsViewData;
            this.g = str;
        }

        @Override // com.baidu.tieba.dh5
        public eh5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.c.e());
                bundle.putString("from", this.c.w3());
                bundle.putString("forum_id", this.c.l());
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.d);
                bundle.putInt("tab_type", this.e.tab_type.intValue());
                bundle.putString("tab_name", this.e.tab_name);
                bundle.putString("tab_code", this.e.tab_code);
                boolean z = true;
                if (this.f.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean("need_log", z);
                bundle.putString("theme_color", this.g);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.c.y3());
                frsItemTabFragment.setArguments(bundle);
                frsItemTabFragment.H1(this.c.getUniqueId());
                eh5 eh5Var = new eh5();
                eh5Var.a = frsItemTabFragment;
                eh5Var.e = this.d;
                eh5Var.i = eh5.k;
                return eh5Var;
            }
            return (eh5) invokeV.objValue;
        }
    }

    public static dh5 a(@NonNull FrsTabInfo frsTabInfo, @NonNull FrsFragment frsFragment, @NonNull FrsViewData frsViewData, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, frsTabInfo, frsFragment, frsViewData, str)) == null) {
            int intValue = frsTabInfo.tab_id.intValue();
            if (intValue == 1) {
                return new a(frsFragment, frsTabInfo, frsViewData, intValue);
            }
            if (intValue == 301) {
                return new b(frsTabInfo, frsViewData, frsFragment, intValue);
            }
            if (intValue == 503) {
                return new c(frsTabInfo, frsViewData, frsFragment, intValue);
            }
            if (intValue == 90) {
                return new d(frsFragment);
            }
            if (frsTabInfo.tab_type.intValue() != 91 && intValue != 89 && intValue != 504 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 100) {
                if (frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() == 102) {
                    return new f(frsTabInfo, frsViewData, frsFragment, intValue);
                }
                if (intValue == 506) {
                    return new g(frsFragment, intValue, frsTabInfo, frsViewData, str);
                }
                return null;
            }
            return new e(frsTabInfo, frsViewData, frsFragment, intValue);
        }
        return (dh5) invokeLLLL.objValue;
    }
}
